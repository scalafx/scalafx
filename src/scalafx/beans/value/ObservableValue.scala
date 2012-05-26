/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.beans.value

import javafx.beans.{ value => jfxbv }
import scalafx.beans.Observable
import scalafx.util.SFXDelegate

object ObservableValue {
  implicit def sfxObservableValue2jfx[T, J](ov: ObservableValue[T, J]) = ov.delegate
  // Conversions to JavaFX Marker classes (no need for these in scala, due to specialized classes)
  implicit def sfxObservableValue2jfxIntegerValue(ov: ObservableValue[Int, Number]) = ov.delegate.asInstanceOf[jfxbv.ObservableIntegerValue]
  implicit def sfxObservableValue2jfxLongValue(ov: ObservableValue[Long, Number]) = ov.delegate.asInstanceOf[jfxbv.ObservableLongValue]
  implicit def sfxObservableValue2jfxFloatValue(ov: ObservableValue[Float, Number]) = ov.delegate.asInstanceOf[jfxbv.ObservableFloatValue]
  implicit def sfxObservableValue2jfxDoubleValue(ov: ObservableValue[Double, Number]) = ov.delegate.asInstanceOf[jfxbv.ObservableDoubleValue]
  implicit def sfxObservableValue2jfxBooleanValue(ov: ObservableValue[Boolean, java.lang.Boolean]) = ov.delegate.asInstanceOf[jfxbv.ObservableBooleanValue]
  implicit def sfxObservableValue2jfxStringValue(ov: ObservableValue[String, String]) = ov.delegate.asInstanceOf[jfxbv.ObservableStringValue]
  implicit def sfxObservableValue2jfxObjectValue[T](ov: ObservableValue[T, T]) = ov.delegate.asInstanceOf[jfxbv.ObservableObjectValue[T]]
  implicit def sfxObservableValue2jfxNumberValue(ov: ObservableValue[Number, Number]) = ov.delegate.asInstanceOf[jfxbv.ObservableNumberValue]
}

/**
 * An ObservableValue is an entity that wraps a value and allows to observe the value for changes.
 *
 * @tparam T Indicates Scala type that will be returned for this Observable.
 * @tparam J Indicates Java type to be wrapped by T. Eventually T and J could be the same.
 */
trait ObservableValue[@specialized(Int, Long, Float, Double, Boolean) T, J]
  extends Observable
  with SFXDelegate[jfxbv.ObservableValue[J]] {

  /**
   * Returns the current value of this ObservableValue
   */
  def value: T

  /**
   * Returns the current value of this ObservableValue
   */
  def apply() = value

  /**
   * Adds a function as a [[http://docs.oracle.com/javafx/2/api/javafx/beans/value/ChangeListener.html ChangeListener]].
   * This function has all arguments from
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/value/ChangeListener.html#changed(javafx.beans.value.ObservableValue, T, T) changed]]
   * method from ChangeListener.
   *
   * @param op Function that receives a [[ObservableValue]], the old value and the new value.
   * It will be called when value changes.
   */
  def onChange[J1 >: J](op: (ObservableValue[T, J], J1, J1) => Unit) {
    delegate.addListener(new jfxbv.ChangeListener[J1] {
      def changed(observable: jfxbv.ObservableValue[_ <: J1], oldValue: J1, newValue: J1) {
        op(ObservableValue.this, oldValue, newValue)
      }
    })
  }

  /**
   * Adds a function as a [[http://docs.oracle.com/javafx/2/api/javafx/beans/value/ChangeListener.html ChangeListener]].
   * This function has no arguments because it will not handle values changed.
   *
   * @param op A Function with no arguments. It will be called when value changes.
   */
  def onChange[J1 >: J](op: => Unit) {
    delegate.addListener(new jfxbv.ChangeListener[J1] {
      def changed(observable: jfxbv.ObservableValue[_ <: J1], oldValue: J1, newValue: J1) {
        op
      }
    })
  }
}
