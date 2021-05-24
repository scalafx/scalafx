/*
 * Copyright (c) 2011-2021, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.colorselector

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.collections.ObservableBuffer
import scalafx.collections.ObservableBuffer.{Add, Change, Remove}
import scalafx.colorselector
import scalafx.event.ActionEvent
import scalafx.geometry.{HPos, Pos, VPos}
import scalafx.scene.Scene
import scalafx.scene.control.{CheckBox, ComboBox, Label, TextField}
import scalafx.scene.effect.Reflection
import scalafx.scene.input.{MouseButton, MouseEvent}
import scalafx.scene.layout._
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.TextAlignment
import scalafx.util.StringConverter

import scala.collection.Seq

object ColorSelector extends JFXApp3 {
  override def start(): Unit = {
    val controlRed = new SliderControl("R") { value = 255 }
    val controlGreen = new SliderControl("G") { value = 255 }
    val controlBlue = new SliderControl("B") { value = 255 }
    val controlAlpha = new SliderControl("A") { value = 255 }
    lazy val allControls = List(controlRed, controlGreen, controlBlue, controlAlpha)
    val currentColor = ObjectProperty(this, "Color", Color.White)
    val synchronizedValue = new DoubleProperty()
    val synchronizedControls = new ObservableBuffer[SliderControl]
    def synchronizeValues(buffer: ObservableBuffer[SliderControl], changes: Seq[Change[SliderControl]]): Unit = {
      changes.head match {
        case Add(pos, added) =>
          val media = buffer.map(_.value.value).sum / buffer.size
          added.last.value <==> synchronizedValue
          buffer.foreach(_.value = media)
        case Remove(pos, removed) =>
          removed.last.value unbind synchronizedValue
        case otherChange =>
          throw new UnsupportedOperationException("Only add and remove defined for the ColorSelector SliderControl sync")
      }
    }
    synchronizedControls.onChange((buffer, changes) => synchronizeValues(buffer, changes))
    def webColorSelected(): Unit = {
      if (cmbWebColor.value.value != null) {
        val color = cmbWebColor.value.value.color
        controlRed.value() = doubleToInt(color.red)
        controlGreen.value() = doubleToInt(color.green)
        controlBlue.value() = doubleToInt(color.blue)
      }
    }
    lazy val cmbWebColor = new ComboBox[WebColor](WebColor.colors) {
      promptText = "Web Color"
      converter = StringConverter.toStringConverter { (wc: WebColor) => wc.name }
      onAction = _ => webColorSelected()
      cellFactory = (cell, webColor) => {
        cell.graphic = new Rectangle {
          fill = webColor.color
          stroke = Color.DarkGray
          width = 16
          height = 16
          arcWidth = 5
          arcHeight = 5
        }
        cell.text = webColor.name
      }
    }
    def controlSelected(control: SliderControl): Unit = {
      if (control.selectedControl.value) {
        synchronizedControls.add(control)
      } else {
        synchronizedControls.remove(control)
      }
    }
    def changeColor(): Unit = {
      val newAlphaValue = if (controlAlpha.disabled.value) 1.0d else controlAlpha.value.toDouble / colorselector.Max
      currentColor() = Color.rgb(controlRed.value.toInt, controlGreen.value.toInt, controlBlue.value.toInt, newAlphaValue)
    }

    def randomizeColors(): Unit = {
      if (synchronizedControls.nonEmpty) {
        synchronizedValue() = math.random * colorselector.Max
      }
      if (synchronizedControls.size < 4) {
        allControls.filterNot(_.selectedControl.value).filterNot(_.disabled.value).foreach(_.value() = math.random * colorselector.Max)
      }
    }
    val txfColorValue = new TextField {
      promptText = "Color Value"
      editable = false
      alignment = Pos.CenterLeft
      hgrow = Priority.Never
      style = "-fx-font-family: Consolas;"
    }
    val chbDisableAlpha = new CheckBox { selected <==> controlAlpha.disable }
    def formatColor(): Unit = {
      txfColorValue.text() = cmbColorFormat.value.value.format(currentColor(), !chbDisableAlpha.selected.value)
    }
    lazy val cmbColorFormat = new ComboBox[Formatter](Formatter.formatters) {
      promptText = "Color Format"
      converter = StringConverter.toStringConverter { (f: Formatter) => f.description }
      value = RgbFormatter
      onAction = (event: ActionEvent) => formatColor()
    }
    def verifyWebColor(): Unit = {
      cmbWebColor.value() = WebColor.colors.find(_.sameColor(currentColor())).orNull
    }
    def colorChanged(): Unit = {
      formatColor()
      verifyWebColor()
    }
    currentColor.onChange(colorChanged())
    def getForegroundColor(d: Double) = if (d > Max / 2) Color.Black else Color.White
    val rectangleRegion = new Region {
      effect = new Reflection { fraction = 0.45d }
      onMouseClicked = (event: MouseEvent) => {
        if (event.getClickCount == 2 && event.button == MouseButton.Primary) {
          randomizeColors()
        }
      }
    }
    currentColor.onChange(rectangleRegion.setStyle("-fx-background-color: " + RgbFormatter.format(currentColor(), !chbDisableAlpha.selected.value)))
    controlRed.value.onChange {
      changeColor()
      controlRed.changeColor(Color.rgb(controlRed.value.value.toInt, 0, 0), getForegroundColor(controlRed.value.value))
    }
    controlRed.selectedControl.onChange(controlSelected(controlRed))
    controlRed.changeColor(Color.rgb(controlRed.value.value.toInt, 0, 0), getForegroundColor(controlRed.value.value))
    controlGreen.value.onChange {
      changeColor()
      controlGreen.changeColor(Color.rgb(0, controlGreen.value.value.toInt, 0), getForegroundColor(controlGreen.value.value))
    }
    controlGreen.selectedControl.onChange(controlSelected(controlGreen))
    controlGreen.changeColor(Color.rgb(0, controlGreen.value.value.toInt, 0), getForegroundColor(controlGreen.value.value))
    controlBlue.value.onChange {
      changeColor()
      controlBlue.changeColor(Color.rgb(0, 0, controlBlue.value.value.toInt), Color.White)
    }
    controlBlue.selectedControl.onChange(controlSelected(controlBlue))
    controlBlue.changeColor(Color.rgb(0, 0, controlBlue.value.value.toInt), Color.White)
    controlAlpha.value.onChange(changeColor())
    controlAlpha.selectedControl.onChange(controlSelected(controlAlpha))
    controlAlpha.disable.onChange {
      if (controlAlpha.selectedControl.value) {
        if (controlAlpha.disable.value) synchronizedControls.remove(controlAlpha) else synchronizedControls.add(controlAlpha)
      }
      changeColor()
      formatColor()
    }


    val rectangleRowsConstraint = new RowConstraints {
      vgrow = Priority.Always
      prefHeight = Region.USE_COMPUTED_SIZE
    }
    val otherRowsConstraint = new RowConstraints {
      vgrow = Priority.Never
      valignment = VPos.Top
    }
    val column0Constraint = new ColumnConstraints {
      fillWidth = true
      halignment = HPos.Center
      hgrow = Priority.Always
      minWidth = 300
    }
    val column1Constraint = new ColumnConstraints {
      halignment = HPos.Right
      hgrow = Priority.Never
      minWidth = 80
      maxWidth = 100
    }
    val column2Constraint = new ColumnConstraints {
      halignment = HPos.Left
      hgrow = Priority.Sometimes
      minWidth = 200
    }
    val pnlMain = new GridPane {
      hgap = 5.0d
      vgap = 5.0d
      rowConstraints = List(rectangleRowsConstraint, otherRowsConstraint, otherRowsConstraint, otherRowsConstraint, otherRowsConstraint)
      columnConstraints = List(column0Constraint, column1Constraint)
      padding = colorselector.insets
      add(rectangleRegion, 0, 0, 3, 1)
      add(controlRed, 0, 1)
      add(new Label {
        alignmentInParent = Pos.TopRight
        labelFor = cmbWebColor
        text = "Web Color"
        textAlignment = TextAlignment.Right
        wrapText = true
      }, 1, 1)
      add(cmbWebColor, 2, 1)
      add(controlGreen, 0, 2)
      add(new Label {
        alignmentInParent = Pos.TopRight
        labelFor = txfColorValue
        text = "Color Value"
        textAlignment = TextAlignment.Right
        wrapText = true
      }, 1, 2)
      add(txfColorValue, 2, 2)
      add(controlBlue, 0, 3)
      add(new Label {
        alignmentInParent = Pos.TopRight
        labelFor = cmbColorFormat
        text = "Color Format"
        textAlignment = TextAlignment.Right
        wrapText = true
      }, 1, 3)
      add(cmbColorFormat, 2, 3)
      add(controlAlpha, 0, 4)
      add(new Label {
        alignmentInParent = Pos.TopRight
        labelFor = chbDisableAlpha
        text = "Disable Alpha"
        textAlignment = TextAlignment.Right
        wrapText = true
      }, 1, 4)
      add(chbDisableAlpha, 2, 4)
    }
    val pnlMain0 = new AnchorPane {
      children = List(pnlMain)
      prefHeight = 500
      prefWidth = 800
    }
    AnchorPane.setAnchors(pnlMain, 0, 0, 0, 0)
    val mainScene = new Scene { content = List(pnlMain0) }
    pnlMain0.prefWidth <== mainScene.width
    pnlMain0.prefHeight <== mainScene.height
    stage = new PrimaryStage {
      title = "Color Selector"
      width = 600
      height = 400
      scene = mainScene
    }
    changeColor()
    chbDisableAlpha.selected = true
    formatColor()
    webColorSelected()
  }
}
