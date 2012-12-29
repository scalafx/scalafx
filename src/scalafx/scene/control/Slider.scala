package scalafx.scene.control

import javafx.geometry.Orientation
import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.util.StringConverter
import javafx.{util => jfxu}

object Slider {
  implicit def sfxSlider2jfx(v: Slider) = v.delegate
}

class Slider(override val delegate: jfxsc.Slider = new jfxsc.Slider) extends Control(delegate) with SFXDelegate[jfxsc.Slider] {

  /** Constructs a Slider control with the specified slider min, max and current value values. */
  def this(min:Double, max:Double, value:Double) {
    this(new jfxsc.Slider(min, max, value))
  }

  /**
   * The amount by which to adjust the slider if the track of the slider is clicked.
   */
  def blockIncrement = delegate.blockIncrementProperty
  def blockIncrement_=(v: Double) {
    blockIncrement() = v
  }

  /**
   * A function for formatting the label for a major tick.
   */
  def labelFormatter = delegate.labelFormatterProperty
  def labelFormatter_=(v: StringConverter[Double]) {
    labelFormatter() = new jfxu.StringConverter[java.lang.Double] {
      def fromString(s: String) = v.fromString(s)
      def toString(d: java.lang.Double) = v.toString(d)
    }
  }

  /**
   * The unit distance between major tick marks.
   */
  def majorTickUnit = delegate.majorTickUnitProperty
  def majorTickUnit_=(v: Double) {
    majorTickUnit() = v
  }

  /**
   * The maximum value represented by this Slider.
   */
  def max = delegate.maxProperty
  def max_=(v: Double) {
    max() = v
  }

  /**
   * The number of minor ticks to place between any two major ticks.
   */
  def minorTickCount = delegate.minorTickCountProperty
  def minorTickCount_=(v: Int) {
    minorTickCount() = v
  }

  /**
   * The minimum value represented by this Slider.
   */
  def min = delegate.minProperty
  def min_=(v: Double) {
    min() = v
  }

  /**
   * The orientation of the Slider can either be horizontal or vertical.
   */
  def orientation = delegate.orientationProperty
  def orientation_=(v: Orientation) {
    orientation() = v
  }

  /**
   * Indicates that the labels for tick marks should be shown.
   */
  def showTickLabels = delegate.showTickLabelsProperty
  def showTickLabels_=(v: Boolean) {
    showTickLabels() = v
  }

  /**
   * Specifies whether the Skin implementation should show tick marks.
   */
  def showTickMarks = delegate.showTickMarksProperty
  def showTickMarks_=(v: Boolean) {
    showTickMarks() = v
  }

  /**
   * Indicates whether the value of the Slider should always be aligned with the tick marks.
   */
  def snapToTicks = delegate.snapToTicksProperty
  def snapToTicks_=(v: Boolean) {
    snapToTicks() = v
  }

  /**
   * When true, indicates the current value of this Slider is changing.
   */
  def valueChanging = delegate.valueChangingProperty
  def valueChanging_=(v: Boolean) {
    valueChanging() = v
  }

  /**
   * The current value represented by this Slider.
   */
  def value = delegate.valueProperty
  def value_=(v: Double) {
    value() = v
  }

}