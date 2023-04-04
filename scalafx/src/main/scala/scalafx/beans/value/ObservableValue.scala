/*
 * Copyright (c) 2011-2023, ScalaFX Project
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

import javafx.beans.value as jfxbv
import javafx.collections as jfxc
import scalafx.beans.Observable
import scalafx.collections.{ObservableBuffer, ObservableMap, ObservableSet}
import scalafx.delegate.SFXDelegate
import scalafx.event.subscriptions.Subscription

import scala.language.implicitConversions

object ObservableValue {
  implicit def sfxObservableValue2jfx[T, J](ov: ObservableValue[T, J]): jfxbv.ObservableValue[J] =
    if (ov != null) ov.delegate else null

  // Conversions to JavaFX Marker classes (no need for these in scala, due to specialized classes)
  implicit def sfxObservableValue2jfxIntegerValue(ov: ObservableValue[Int, Number]): jfxbv.ObservableIntegerValue =
    ov.delegate.asInstanceOf[jfxbv.ObservableIntegerValue]

  implicit def sfxObservableValue2jfxLongValue(ov: ObservableValue[Long, Number]): jfxbv.ObservableLongValue =
    ov.delegate.asInstanceOf[jfxbv.ObservableLongValue]

  implicit def sfxObservableValue2jfxFloatValue(ov: ObservableValue[Float, Number]): jfxbv.ObservableFloatValue =
    ov.delegate.asInstanceOf[jfxbv.ObservableFloatValue]

  implicit def sfxObservableValue2jfxDoubleValue(ov: ObservableValue[Double, Number]): jfxbv.ObservableDoubleValue =
    ov.delegate.asInstanceOf[jfxbv.ObservableDoubleValue]

  implicit def sfxObservableValue2jfxBooleanValue(ov: ObservableValue[Boolean, java.lang.Boolean])
    : jfxbv.ObservableBooleanValue = ov.delegate.asInstanceOf[jfxbv.ObservableBooleanValue]

  implicit def sfxObservableValue2jfxStringValue(ov: ObservableValue[String, String]): jfxbv.ObservableStringValue =
    ov.delegate.asInstanceOf[jfxbv.ObservableStringValue]

  implicit def sfxObservableValue2jfxObjectValue[T](ov: ObservableValue[T, T]): jfxbv.ObservableObjectValue[T] =
    ov.delegate.asInstanceOf[jfxbv.ObservableObjectValue[T]]

  implicit def sfxObservableValue2jfxNumberValue(ov: ObservableValue[Number, Number]): jfxbv.ObservableNumberValue =
    ov.delegate.asInstanceOf[jfxbv.ObservableNumberValue]

  implicit def sfxObservableValue2jfxListValue[E](ov: ObservableValue[ObservableBuffer[E], jfxc.ObservableList[E]])
    : jfxbv.ObservableListValue[E] =
    ov.delegate.asInstanceOf[jfxbv.ObservableListValue[E]]

  implicit def sfxObservableValue2jfxSetValue[E](ov: ObservableValue[ObservableSet[E], jfxc.ObservableSet[E]])
    : jfxbv.ObservableListValue[E] =
    ov.delegate.asInstanceOf[jfxbv.ObservableListValue[E]]

  implicit def sfxObservableValue2jfxMapValue[K, V](ov: ObservableValue[ObservableMap[K, V], jfxc.ObservableMap[K, V]])
    : jfxbv.ObservableMapValue[K, V] =
    ov.delegate.asInstanceOf[jfxbv.ObservableMapValue[K, V]]
}

/**
 * An ObservableValue is an entity that wraps a value and allows to observe the value for changes.
 *
 * @tparam T Indicates Scala type that will be returned for this Observable.
 * @tparam J Indicates Java type to be wrapped by T. Eventually T and J could be the same.
 *
 * @define OV `ObservableValue`
 * @define VALUE the current value of this $OV.
 * @define CV `ChangeListener`
 * @define URLCV [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ChangeListener.html `ChangeListener`]]
 * @define SUBRET A new [[scalafx.event.subscriptions.Subscription]] to remove $OV.
 */
trait ObservableValue[@specialized(Int, Long, Float, Double, Boolean) T, J]
    extends Observable
    with SFXDelegate[jfxbv.ObservableValue[J]] {

  /**
   * Returns $OV
   *
   * @return $OV
   */
  def value: T

  /**
   * Returns $OV
   *
   * @return $OV
   */
  def apply(): T = value

  /**
   * Adds a function as a $URLCV. This function has all arguments from
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ChangeListener.html#changed(javafx.beans.value.ObservableValue, T, T) `changed`]]
   * method from $CV.
   *
   * @tparam J1 J superclass.
   * @param op Function that receives a
   *            [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ObservableValue.html $OV]],
   *            the old value and the new value. It will be called when value changes.
   * @return $SUBRET
   */
  def onChange[J1 >: J](op: (ObservableValue[T, J], J1, J1) => Unit): Subscription = {
    val listener = new jfxbv.ChangeListener[J1] {
      def changed(observable: jfxbv.ObservableValue[_ <: J1], oldValue: J1, newValue: J1): Unit = {
        op(ObservableValue.this, oldValue, newValue)
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel(): Unit = {
        delegate.removeListener(listener)
      }
    }
  }

  /**
   * Adds a function as a $URLCV. This function has no arguments because it will not handle values changed.
   *
   * @param op A Function with no arguments. It will be called when value changes.
   * @return $SUBRET
   */
  def onChange[J1 >: J](op: => Unit): Subscription = {
    val listener = new jfxbv.ChangeListener[J1] {
      def changed(observable: jfxbv.ObservableValue[_ <: J1], oldValue: J1, newValue: J1): Unit = {
        op
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel(): Unit = {
        delegate.removeListener(listener)
      }
    }
  }

  /**
   * Returns an `ObservableValue` that holds this value and is updated only
   * when `condition` holds `true`.
   * <p>
   * The returned `ObservableValue` only observes this value when
   * `condition` holds `true`. This allows this `ObservableValue`
   * and the conditional `ObservableValue` to be garbage collected if neither is
   * otherwise strongly referenced when `condition` holds `false`.
   * This is in contrast to the general behavior of bindings, where the binding is
   * only eligible for garbage collection when not observed itself.
   * <p>
   * A `condition` holding `null` is treated as holding `false`.
   * <p>
   * For example:
   * {{{
   *    val condition         = BooleanProperty(true)
   *    val longLivedProperty = StringProperty("A")
   *    val whenProperty      = longLivedProperty.when(condition)
   *
   *    // observe whenProperty, which will in turn observe longLivedProperty
   *    whenProperty.onChange((_, old, current) => println(s"whenProperty change : $old -> $current"));
   *
   *    longLivedProperty.value = "B" // "B" is printed
   *
   *    condition.value = false
   *
   *    // After condition becomes false, whenProperty stops observing longLivedProperty; condition
   *    // and whenProperty may now be eligible for GC despite being observed by the ChangeListener
   *    longLivedProperty.value = "C" // nothing is printed
   *    longLivedProperty.value = "D" // nothing is printed
   *
   *    condition.value = true // longLivedProperty is observed again, and "D" is printed
   * }}}
   *
   * @param condition a boolean `ObservableValue`, cannot be `null`
   * @return an `ObservableValue` that holds this value whenever the given
   *         condition evaluates to `true`, otherwise holds the last seen value;
   *         never returns `null`
   * @since 20
   */
  def when(condition: ObservableValue[scala.Boolean, java.lang.Boolean]): ObservableValue[J, J] =
    scalafx.Includes.jfxObservableValue2sfx(delegate.when(condition.delegate))
}
