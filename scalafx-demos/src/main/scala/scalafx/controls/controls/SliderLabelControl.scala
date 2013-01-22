/**
 *
 */
package scalafx.controls.controls

import javafx.scene.layout.Priority
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.beans.property._
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.stage.Stage
import scalafx.util.converter.DoubleStringConverter

/**
 * @author rafael
 *
 */
class SliderLabelControl(property: DoubleProperty) extends FlowPane {

  def this(intProp: IntegerProperty) = this(new DoubleProperty(intProp.getValue(), intProp.name) {
    override def value = intProp.value.toDouble
    override def value_=(v: Double) {
      intProp.value = v.toInt
    }
  })

  val originalPattern = "%02.1f"

  val slider = new Slider {
    value <==> property
    hgrow = Priority.ALWAYS
    labelFormatter = new DoubleStringConverter()
  }

  val lblValue = new Label {
    text <== slider.value.asString(originalPattern)
    hgrow = Priority.SOMETIMES
  }

  def blockIncrement_=(v: Double) {
    slider.blockIncrement = v
  }

  def pattern_=(v: String) {
    slider.labelFormatter = new DoubleStringConverter
    lblValue.text <== slider.value.asString(v)
  }

  def majorTickUnit_=(v: Double) {
    slider.majorTickUnit = v
  }

  def max = slider.max
  def max_=(v: Double) {
    slider.max = v
  }

  def min = slider.min
  def min_=(v: Double) {
    slider.min = v
  }

  def minorTickCount_=(v: Int) {
    slider.minorTickCount = v
  }

  def showTickLabels_=(v: Boolean) {
    slider.showTickLabels = v
  }

  def showTickMarks_=(v: Boolean) {
    slider.showTickMarks = v
  }

  def snapToTicks_=(v: Boolean) {
    slider.snapToTicks = v
  }

  super.content = List(slider, lblValue)
  super.hgap = 5.0
}

object SliderLabelControlDemo extends JFXApp {

  val x: java.lang.Double = 5.0
  val value = new IntegerProperty(1.asInstanceOf[java.lang.Object], "value")
    //new DoubleProperty(x, "Value")

  val lblValue = new Label {
    text <== value.asString("%2d")
  }

  val sldValue = new SliderLabelControl(value)

  stage = new Stage(JFXApp.STAGE) {
    height = 100
    width = 200
    title = "Slider Label Control Demo"
    scene = new Scene {
      content =
        new FlowPane {
          content = List(lblValue, sldValue)
        }
    }
  }

}