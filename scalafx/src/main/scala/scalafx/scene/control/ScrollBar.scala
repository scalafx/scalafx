/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
import javafx.{geometry => jfxg}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.geometry.Orientation

import scala.language.implicitConversions

object ScrollBar {
  implicit def sfxScrollBar2jfx(sc: ScrollBar): jfxsc.ScrollBar = if (sc != null) sc.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollBar.html]]
 */
class ScrollBar(override val delegate: jfxsc.ScrollBar = new jfxsc.ScrollBar)
    extends Control(delegate)
    with SFXDelegate[jfxsc.ScrollBar] {

  /**
   * The amount by which to adjust the scrollbar if the track of the bar is clicked.
   */
  def blockIncrement: DoubleProperty = delegate.blockIncrementProperty

  def blockIncrement_=(v: Double): Unit = {
    blockIncrement() = v
  }

  /**
   * The maximum value represented by this ScrollBar.
   */
  def max: DoubleProperty = delegate.maxProperty

  def max_=(v: Double): Unit = {
    max() = v
  }

  /**
   * The minimum value represented by this ScrollBar.
   */
  def min: DoubleProperty = delegate.minProperty

  def min_=(v: Double): Unit = {
    min() = v
  }

  /**
   * The orientation of the ScrollBar can either be HORIZONTAL or VERTICAL.
   */
  def orientation: ObjectProperty[jfxg.Orientation] = delegate.orientationProperty

  def orientation_=(v: Orientation): Unit = {
    orientation() = v
  }

  /**
   * The amount by which to adjust the ScrollBar when the increment or decrement methods are called.
   */
  def unitIncrement: DoubleProperty = delegate.unitIncrementProperty

  def unitIncrement_=(v: Double): Unit = {
    unitIncrement() = v
  }

  /**
   * The current value represented by this ScrollBar.
   */
  def value: DoubleProperty = delegate.valueProperty

  def value_=(v: Double): Unit = {
    value() = v
  }

  /**
   * Visible amount of the scrollbar's range, typically represented by the size of the scroll bar's thumb.
   */
  def visibleAmount: DoubleProperty = delegate.visibleAmountProperty

  def visibleAmount_=(v: Double): Unit = {
    visibleAmount() = v
  }

  /**
   * Adjusts the `value` property by `blockIncrement`.
   */
  def adjustValue(position: Double): Unit = {
    delegate.adjustValue(position)
  }

  /**
   * Decrements the value of the ScrollBar by the `unitIncrement`.
   */
  def decrement(): Unit = {
    delegate.decrement()
  }

  /**
   * Increments the value of the ScrollBar by the `unitIncrement`.
   */
  def increment(): Unit = {
    delegate.increment()
  }

}
