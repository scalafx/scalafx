/*
 * Copyright (c) 2011-2020, ScalaFX Project
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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{geometry => jfxg, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, IntegerProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.geometry.Orientation
import scalafx.util.StringConverter

import scala.language.implicitConversions

object Slider {
  implicit def sfxSlider2jfx(v: Slider): jfxsc.Slider = if (v != null) v.delegate else null
}

class Slider(override val delegate: jfxsc.Slider = new jfxsc.Slider)
    extends Control(delegate)
    with SFXDelegate[jfxsc.Slider] {

  /** Constructs a Slider control with the specified slider min, max and current value values. */
  def this(min: Double, max: Double, value: Double) = {
    this(new jfxsc.Slider(min, max, value))
  }

  /**
   * The amount by which to adjust the slider if the track of the slider is clicked.
   */
  def blockIncrement: DoubleProperty = delegate.blockIncrementProperty

  def blockIncrement_=(v: Double): Unit = {
    blockIncrement() = v
  }

  /**
   * A function for formatting the label for a major tick.
   */
  def labelFormatter: ObjectProperty[jfxu.StringConverter[java.lang.Double]] = delegate.labelFormatterProperty

  def labelFormatter_=(v: StringConverter[Double]): Unit = {
    labelFormatter() = new jfxu.StringConverter[java.lang.Double] {
      def fromString(s: String): java.lang.Double = v.fromString(s)

      def toString(d: java.lang.Double): String = v.toString(d)
    }
  }

  /**
   * The unit distance between major tick marks.
   */
  def majorTickUnit: DoubleProperty = delegate.majorTickUnitProperty

  def majorTickUnit_=(v: Double): Unit = {
    majorTickUnit() = v
  }

  /**
   * The maximum value represented by this Slider.
   */
  def max: DoubleProperty = delegate.maxProperty

  def max_=(v: Double): Unit = {
    max() = v
  }

  /**
   * The number of minor ticks to place between any two major ticks.
   */
  def minorTickCount: IntegerProperty = delegate.minorTickCountProperty

  def minorTickCount_=(v: Int): Unit = {
    minorTickCount() = v
  }

  /**
   * The minimum value represented by this Slider.
   */
  def min: DoubleProperty = delegate.minProperty

  def min_=(v: Double): Unit = {
    min() = v
  }

  /**
   * The orientation of the Slider can either be horizontal or vertical.
   */
  def orientation: ObjectProperty[jfxg.Orientation] = delegate.orientationProperty

  def orientation_=(v: Orientation): Unit = {
    orientation() = v
  }

  /**
   * Indicates that the labels for tick marks should be shown.
   */
  def showTickLabels: BooleanProperty = delegate.showTickLabelsProperty

  def showTickLabels_=(v: Boolean): Unit = {
    showTickLabels() = v
  }

  /**
   * Specifies whether the Skin implementation should show tick marks.
   */
  def showTickMarks: BooleanProperty = delegate.showTickMarksProperty

  def showTickMarks_=(v: Boolean): Unit = {
    showTickMarks() = v
  }

  /**
   * Indicates whether the value of the Slider should always be aligned with the tick marks.
   */
  def snapToTicks: BooleanProperty = delegate.snapToTicksProperty

  def snapToTicks_=(v: Boolean): Unit = {
    snapToTicks() = v
  }

  /**
   * When true, indicates the current value of this Slider is changing.
   */
  def valueChanging: BooleanProperty = delegate.valueChangingProperty

  def valueChanging_=(v: Boolean): Unit = {
    valueChanging() = v
  }

  /**
   * The current value represented by this Slider.
   */
  def value: DoubleProperty = delegate.valueProperty

  def value_=(v: Double): Unit = {
    value() = v
  }

}
