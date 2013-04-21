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

/**
 *
 */
package scalafx.controls.controls

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property._
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.util.converter.DoubleStringConverter

/**
 * @author rafael
 *
 */
class SliderLabelControl(property: DoubleProperty) extends FlowPane {

  def this(intProp: IntegerProperty) = this(new DoubleProperty(intProp.getValue, intProp.name) {
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

  stage = new PrimaryStage {
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