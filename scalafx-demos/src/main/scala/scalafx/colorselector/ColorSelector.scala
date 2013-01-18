package scalafx.colorselector

import colorselector.Max
import colorselector.doubleToInt
import javafx.beans.property.SimpleDoubleProperty
import javafx.event.EventHandler
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Priority
import javafx.scene.text.TextAlignment
import scala.collection.Seq
import scalafx.Includes.jfxBooleanProperty2sfx
import scalafx.Includes.jfxDoubleProperty2sfx
import scalafx.Includes.jfxObjectProperty2sfx
import scalafx.application.JFXApp
import scalafx.beans.property.BooleanProperty.sfxBooleanProperty2jfx
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.DoubleProperty.sfxDoubleProperty2jfx
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ObjectProperty.sfxObjectProperty2jfx
import scalafx.collections.ObservableBuffer
import scalafx.collections.ObservableBuffer.Add
import scalafx.collections.ObservableBuffer.Change
import scalafx.collections.ObservableBuffer.Remove
import scalafx.collections.ObservableBuffer.canBuildFrom
import scalafx.collections.ObservableBuffer.observableBuffer2ObservableList
import scalafx.event.EventHandler.function2jfxEventHandler
import scalafx.geometry.{HPos, Pos, VPos}
import scalafx.scene.Scene
import scalafx.scene.control.CheckBox
import scalafx.scene.control.CheckBox.sfxCheckBox2jfx
import scalafx.scene.control.ComboBox
import scalafx.scene.control.Control
import scalafx.scene.control.Control.sfxControl2jfx
import scalafx.scene.control.Label
import scalafx.scene.control.TextField
import scalafx.scene.control.TextField.sfxTextField2jfx
import scalafx.scene.effect.Reflection
import scalafx.scene.layout._
import scalafx.scene.paint.Color
import scalafx.stage.Stage
import scalafx.util.StringConverter


object ColorSelector extends JFXApp {

  // VAL'S DEFINITION - BEGIN

  lazy val allControls = List(controlRed, controlGreen, controlBlue, controlAlpha)

  val currentColor = new ObjectProperty[Color](Color.WHITE, "Color")
  currentColor.onChange(colorChanged)

  val synchronizedValue = new DoubleProperty(new SimpleDoubleProperty)

  val synchronizedControls = new ObservableBuffer[SliderControl]
  synchronizedControls.onChange((buffer, changes) => synchronizeValues(buffer, changes))

  // METHODS - BEGIN

  private def controlSelected(control: SliderControl) {
    if (control.selectedControl.get) {
      synchronizedControls.add(control)
    } else {
      synchronizedControls.remove(control)
    }
  }

  private def changeColor {
    val newAlphaValue = if (controlAlpha.disabled.get()) 1.0 else (controlAlpha.value.toDouble / colorselector.Max)

    this.currentColor() = Color.rgb(controlRed.value.toInt, controlGreen.value.toInt,
      controlBlue.value.toInt, newAlphaValue)
  }

  private def synchronizeValues(buffer: ObservableBuffer[SliderControl], changes: Seq[Change]) {
    changes(0) match {
      case Add(pos, added) => {
        val media = buffer.map(_.value.get).sum / buffer.size
        added.last.asInstanceOf[SliderControl].value <==> synchronizedValue
        buffer.foreach(_.value = media)
      }
      case Remove(pos, removed) => {
        removed.last.asInstanceOf[SliderControl].value unbind synchronizedValue
      }
    }
  }

  private def randomizeColors {
    if (synchronizedControls.size > 0) {
      this.synchronizedValue() = math.random * colorselector.Max
    }
    if (synchronizedControls.size < 4) {
      this.allControls
        .filterNot(_.selectedControl.get)
        .filterNot(_.disabled.get)
        .foreach(_.value() = math.random * colorselector.Max)
    }
  }

  private def colorChanged {
    formatColor
    verifyWebColor
  }

  private def formatColor {
    this.txfColorValue.text() = this.cmbColorFormat.value.get.format(this.currentColor.get, !this.chbDisableAlpha.selected.get)
  }

  private def getForegroundColor(d: Double) = if (d > Max / 2) Color.BLACK else Color.WHITE

  private def verifyWebColor {
    cmbWebColor.value() = WebColor.colors.find(_.sameColor(currentColor.get)).orNull
  }

  private def webColorSelected {
    if (this.cmbWebColor.value.get != null) {
      val color = this.cmbWebColor.value.get.color
      controlRed.value() = doubleToInt(color.red)
      controlGreen.value() = doubleToInt(color.green)
      controlBlue.value() = doubleToInt(color.blue)
    }
  }

  // METHODS - END

  val rectangleRegion = new Region {
    effect = new Reflection {
      fraction = 0.45
    }
    onMouseClicked = new EventHandler[MouseEvent] {
      def handle(event: MouseEvent) {
        if ((event.getClickCount == 2) && (event.getButton() == MouseButton.PRIMARY)) {
          randomizeColors
        }
      }
    }
  }

  currentColor.onChange(rectangleRegion.setStyle("-fx-background-color: " + RgbFormatter.format(currentColor(), !this.chbDisableAlpha.selected.get)))

  val controlRed = new SliderControl("R") {
    value = 255
  }
  controlRed.value.onChange({
    changeColor
    controlRed.changeColor(Color.rgb(controlRed.value.get.toInt, 0, 0), getForegroundColor(controlRed.value.get))
  })
  controlRed.selectedControl.onChange(controlSelected(controlRed))
  controlRed.changeColor(Color.rgb(controlRed.value.get.toInt, 0, 0), getForegroundColor(controlRed.value.get))

  val controlGreen = new SliderControl("G") {
    value = 255
  }
  controlGreen.value.onChange({
    changeColor
    controlGreen.changeColor(Color.rgb(0, controlGreen.value.get.toInt, 0), getForegroundColor(controlGreen.value.get))
  })
  controlGreen.selectedControl.onChange(controlSelected(controlGreen))
  controlGreen.changeColor(Color.rgb(0, controlGreen.value.get.toInt, 0), getForegroundColor(controlGreen.value.get))

  val controlBlue = new SliderControl("B") {
    value = 255
  }
  controlBlue.value.onChange({
    changeColor
    controlBlue.changeColor(Color.rgb(0, 0, controlBlue.value.get.toInt), Color.WHITE)
  })
  controlBlue.selectedControl.onChange(controlSelected(controlBlue))
  controlBlue.changeColor(Color.rgb(0, 0, controlBlue.value.get.toInt), Color.WHITE)

  val controlAlpha = new SliderControl("A") {
    value = 255
  }
  controlAlpha.value.onChange(changeColor)
  controlAlpha.selectedControl.onChange(controlSelected(controlAlpha))
  controlAlpha.disable.onChange({
    if (controlAlpha.selectedControl.get) {
      if (controlAlpha.disable.get) synchronizedControls.remove(controlAlpha)
      else synchronizedControls.add(controlAlpha)
    }
    changeColor
    formatColor
  })

  val cmbWebColor = new ComboBox[WebColor](WebColor.colors) {
    promptText = "Web Color"
    converter = StringConverter.toStringConverter((wc: WebColor) => wc.name)
    onAction = webColorSelected
  }

  val txfColorValue = new TextField {
    promptText = "Color Value"
    editable = false
    alignment = Pos.CENTER_LEFT
    hgrow = Priority.NEVER
    style = "-fx-font-family: Consolas;"
  }

  val cmbColorFormat = new ComboBox[Formatter](Formatter.formatters) {
    promptText = "Color Format"
    converter = StringConverter.toStringConverter((f: Formatter) => f.description)
    value = RgbFormatter
    onAction = formatColor
  }

  val chbDisableAlpha = new CheckBox {
    selected <==> controlAlpha.disable
  }

  val rectangleRowsConstraint = new RowConstraints {
    vgrow = Priority.ALWAYS
    prefHeight = Control.USE_COMPUTED_SIZE
  }
  val otherRowsConstraint = new RowConstraints {
    vgrow = Priority.NEVER
    valignment = VPos.TOP
  }
  val column0Constraint = new ColumnConstraints {
    fillWidth = true
    halignment = HPos.CENTER
    hgrow = Priority.ALWAYS
    minWidth = 300
  }
  val column1Constraint = new ColumnConstraints {
    halignment = HPos.RIGHT
    hgrow = Priority.NEVER
    minWidth = 80
    maxWidth = 100
  }
  val column2Constraint = new ColumnConstraints {
    halignment = HPos.LEFT
    hgrow = Priority.SOMETIMES
    minWidth = 200
  }
  val pnlMain = new GridPane {
    hgap = 5.0
    vgap = 5.0
    rowConstraints = List(rectangleRowsConstraint, otherRowsConstraint, otherRowsConstraint,
      otherRowsConstraint, otherRowsConstraint)
    columnConstraints = List(column0Constraint, column1Constraint)
    padding = colorselector.insets

    add(rectangleRegion, 0, 0, 3, 1)

    add(controlRed, 0, 1)
    add(new Label {
      alignment = Pos.TOP_RIGHT
      labelFor = cmbWebColor
      text = "Web Color"
      textAlignment = TextAlignment.RIGHT
      wrapText = true
    }, 1, 1)
    add(cmbWebColor, 2, 1)

    add(controlGreen, 0, 2)
    add(new Label {
      alignment = Pos.TOP_RIGHT
      labelFor = txfColorValue
      text = "Color Value"
      textAlignment = TextAlignment.RIGHT
      wrapText = true
    }, 1, 2)
    add(txfColorValue, 2, 2)

    add(controlBlue, 0, 3)
    add(new Label {
      alignment = Pos.TOP_RIGHT
      labelFor = cmbColorFormat
      text = "Color Format"
      textAlignment = TextAlignment.RIGHT
      wrapText = true
    }, 1, 3)
    add(cmbColorFormat, 2, 3)

    add(controlAlpha, 0, 4)
    add(new Label {
      alignment = Pos.TOP_RIGHT
      labelFor = chbDisableAlpha
      text = "Disable Alpha"
      textAlignment = TextAlignment.RIGHT
      wrapText = true
    }, 1, 4)
    add(chbDisableAlpha, 2, 4)
  }

  val pnlMain0 = new AnchorPane {
    content = List(pnlMain)
    prefHeight = 500
    prefWidth = 800
  }
  AnchorPane.setAnchors(pnlMain, 0, 0, 0, 0)

  val mainScene = new Scene {
    content = List(pnlMain0)
  }
  pnlMain0.prefWidth <== (mainScene.width)
  pnlMain0.prefHeight <== (mainScene.height)

  stage = new Stage {
    title = "Color Selector"
    width = 600
    height = 400
    scene = mainScene
  }

  // Initialization
  changeColor
  chbDisableAlpha.selected = true
  formatColor
  webColorSelected

}