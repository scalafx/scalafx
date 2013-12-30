/*
 * Copyright (c) 2011-2013, ScalaFX Project
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
package scalafx.controls

import controls._
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.controls.controls.PropertiesNodes
import scalafx.geometry.{Orientation, Pos}
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.{Priority, BorderPane, FlowPane, VBox}
import scalafx.scene.paint.Color
import scalafx.util.converter.DoubleStringConverter

object SliderTest extends JFXApp {

  val slider = new Slider {
    alignmentInParent = Pos.CENTER
  }

  val controlsPane = new VBox {
    spacing = 5
    fillWidth = true
    alignment = Pos.CENTER
    hgrow = Priority.NEVER
    content = List(new SliderControls(slider), new ControlControls(slider))
  }

  val mainPane = new BorderPane {
    top = new FlowPane {
      content = List(slider)
    }
    center = controlsPane
    vgrow = Priority.ALWAYS
    hgrow = Priority.ALWAYS
  }

  stage = new PrimaryStage {
    title = "Slider Test"
    width = 300
    height = 380
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }

}

class SliderControls(target: Slider) extends PropertiesNodes[Slider](target, "Slider Properties") {

  override protected def resetProperties() {
    target.value = originalValue
    target.blockIncrement = originalBlockIncrement
    txfLabelFormatter.text = null
    target.majorTickUnit = originalMajorTickUnit
    target.max = originalMax
    target.min = originalMin
    target.minorTickCount = originalMinorTickCount
    target.showTickLabels = originalShowTickLabels
    target.showTickMarks = originalShowTickMarks
    target.snapToTicks = originalSnapToTicks
    target.valueChanging = originalValueChanging
    target.orientation = originalOrientation
  }

  val originalValue = target.value.get
  val txfValue = new TextField
  target.value.onChange(txfValue.text = target.value.get.toString)
  txfValue.onAction = handle { super.fillDoublePropertyFromText(target.value, txfValue, false) }

  val originalBlockIncrement = target.blockIncrement.get
  val txfBlockIncrement = new TextField {
    text = originalBlockIncrement.get.toString
  }
  target.blockIncrement.onChange(txfBlockIncrement.text = target.blockIncrement.get.toString)
  txfBlockIncrement.onAction = handle { fillDoublePropertyFromText(target.blockIncrement, txfBlockIncrement, false) }

  val txfLabelFormatter = new TextField
  txfLabelFormatter.text.onChange(
    if (txfLabelFormatter.text.get.isEmpty) {
      target.labelFormatter = null
    } else {
      target.labelFormatter = new DoubleStringConverter
    })

  val originalMajorTickUnit = target.majorTickUnit.get()
  val txfMajorTickUnit = new TextField {
    text = originalMajorTickUnit.toString
  }
  target.majorTickUnit.onChange(txfMajorTickUnit.text = target.majorTickUnit.get.toString)
  txfMajorTickUnit.onAction = handle { fillDoublePropertyFromText(target.majorTickUnit, txfMajorTickUnit, false) }

  val originalMax = target.max.get()
  val txfMax = new TextField {
    text = originalMax.toString
  }
  target.max.onChange(txfMax.text = target.max.get.toString)
  txfMax.onAction = handle { fillDoublePropertyFromText(target.max, txfMax, false) }

  val originalMinorTickCount = target.minorTickCount.get()
  val txfMinorTickCount = new TextField {
    text = originalMinorTickCount.toString
  }
  target.minorTickCount.onChange(txfMinorTickCount.text = target.minorTickCount.get.toString)
  txfMinorTickCount.onAction = handle { fillIntPropertyFromText(target.minorTickCount, txfMinorTickCount, false) }

  val originalMin = target.min.get()
  val txfMin = new TextField {
    text = originalMin.toString
  }
  target.min.onChange(txfMin.text = target.min.get.toString)
  txfMin.onAction = handle { fillDoublePropertyFromText(target.min, txfMin, false) }

  val originalShowTickLabels = target.showTickLabels.get
  val chbShowTickLabels = new CheckBox {
    selected <==> target.showTickLabels
  }

  val originalShowTickMarks = target.showTickMarks.get
  val chbShowTickMarks = new CheckBox {
    selected <==> target.showTickMarks
  }

  val originalSnapToTicks = target.snapToTicks.get()
  val chbSnapToTicks = new CheckBox {
    selected <==> target.snapToTicks
  }

  val originalValueChanging = target.valueChanging.get()
  val chbValueChanging = new CheckBox {
    selected <==> target.valueChanging
  }

  val originalOrientation = target.orientation.get()
  val tggOrientation = new ToggleGroup
  val rdbHorizontal = new RadioButton {
    text = Orientation.HORIZONTAL.toString
    toggleGroup = tggOrientation
  }
  val rdbVertical = new RadioButton {
    text = Orientation.VERTICAL.toString
    toggleGroup = tggOrientation
  }
  rdbHorizontal.selected = (target.orientation.get() == Orientation.HORIZONTAL)
  target.orientation.onChange(rdbHorizontal.selected = (target.orientation.get() == Orientation.HORIZONTAL))
  tggOrientation.selectedToggle.onChange {
    target.orientation = if (rdbHorizontal.selected.get) Orientation.HORIZONTAL else Orientation.VERTICAL
  }

  super.addNode("Value", txfValue)
  super.addNode("Block Increment", txfBlockIncrement)
  super.addNode("Pattern Formatter", txfLabelFormatter)
  super.addNode("Min", txfMin)
  super.addNode("Max", txfMax)
  super.addNode("Minor Tick Count ", txfMinorTickCount)
  super.addNode("Major Tick Unit", txfMajorTickUnit)
  super.addNode("Show Tick Labels", chbShowTickLabels)
  super.addNode("Show Tick Marks", chbShowTickMarks)
  super.addNode("Snap To Ticks", chbSnapToTicks)
  super.addNode("Value Changing", chbValueChanging)
  super.addNode("Orientation", new VBox {
    content = List(rdbHorizontal, rdbVertical)
  })

  super.addNode(btnReset)

}