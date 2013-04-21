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
package scalafx.animation

import javafx.{ animation => jfxa }
import javafx.beans.{ value => jfxbv }
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.beans.property.Property

/**
 * Companion Object for [[scalafx.animation.KeyValue]].
 *
 * @define KV `KeyValue`
 */
object KeyValue {

  /**
   * Converts a ScalaFX $KV to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/animation/KeyValue.html $KV]],
   * extracting its delegate.
   *
   * @param v ScalaFX $KV
   * @return JavaFX $KV extracted from `v`.
   */
  implicit def sfxKeyValue2jfx(v: KeyValue[_, _]) = v.delegate

  // Need to separately capture the Number/primitive combinations since JavaFX does not go down to primitives in its generics (wow, this is ugly!)
  def apply[T >: Int <: Int, J >: Number <: Number](target: jfxbv.WritableIntegerValue, endValue: Int) = new KeyValue[T, J](new jfxa.KeyValue(target, int2Integer(endValue)))
  def apply[T >: Long <: Long, J >: Number <: Number](target: jfxbv.WritableLongValue, endValue: Long) = new KeyValue[T, J](new jfxa.KeyValue(target, long2Long(endValue)))
  def apply[T >: Float <: Float, J >: Number <: Number](target: jfxbv.WritableFloatValue, endValue: Float) = new KeyValue[T, J](new jfxa.KeyValue(target, float2Float(endValue)))
  def apply[T >: Double <: Double, J >: Number <: Number](target: jfxbv.WritableDoubleValue, endValue: Double) = new KeyValue[T, J](new jfxa.KeyValue(target, double2Double(endValue)))
  def apply[T >: Boolean <: Boolean, J >: java.lang.Boolean <: java.lang.Boolean](target: jfxbv.WritableBooleanValue, endValue: Boolean) = new KeyValue[T, J](new jfxa.KeyValue(target, boolean2Boolean(endValue)))
  def apply[T <: AnyRef](target: jfxbv.WritableObjectValue[T], endValue: T) = new KeyValue[T, T](new jfxa.KeyValue(target, endValue))
  def apply[T >: Int <: Int, J >: Number <: Number](target: Property[T, J], endValue: Int) = new KeyValue[T, J](new jfxa.KeyValue(Property.sfxProperty2jfx(target), int2Integer(endValue)))
  def apply[T >: Long <: Long, J >: Number <: Number](target: Property[T, J], endValue: Long) = new KeyValue[T, J](new jfxa.KeyValue(target, long2Long(endValue)))
  def apply[T >: Float <: Float, J >: Number <: Number](target: Property[T, J], endValue: Float) = new KeyValue[T, J](new jfxa.KeyValue(target, float2Float(endValue)))
  def apply[T >: Double <: Double, J >: Number <: Number](target: Property[T, J], endValue: Double) = new KeyValue[T, J](new jfxa.KeyValue(target, double2Double(endValue)))
  def apply[T >: Boolean <: Boolean, J >: java.lang.Boolean <: java.lang.Boolean](target: Property[T, J], endValue: Boolean) = new KeyValue[T, J](new jfxa.KeyValue(target, boolean2Boolean(endValue)))
  def apply[T <: Any, J <: AnyRef](target: Property[T, J], endValue: J) = new KeyValue[T, J](new jfxa.KeyValue(target, endValue))
  def apply[T <: Any](target: jfxbv.WritableValue[T], endValue: T) = new KeyValue[T, T](new jfxa.KeyValue(target, endValue))
  // And did you know that you can't use default arguments on multiple constructors?  Oh well, guess I just REPEAT them all! *sigh*
  def apply[T >: Int <: Int, J >: Number <: Number](target: jfxbv.WritableIntegerValue, endValue: Int, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, int2Integer(endValue), interpolator))
  def apply[T >: Long <: Long, J >: Number <: Number](target: jfxbv.WritableLongValue, endValue: Long, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, long2Long(endValue), interpolator))
  def apply[T >: Float <: Float, J >: Number <: Number](target: jfxbv.WritableFloatValue, endValue: Float, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, float2Float(endValue), interpolator))
  def apply[T >: Double <: Double, J >: Number <: Number](target: jfxbv.WritableDoubleValue, endValue: Double, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, double2Double(endValue), interpolator))
  def apply[T >: Boolean <: Boolean, J >: java.lang.Boolean <: java.lang.Boolean](target: jfxbv.WritableBooleanValue, endValue: Boolean, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, boolean2Boolean(endValue), interpolator))
  def apply[T <: AnyRef](target: jfxbv.WritableObjectValue[T], endValue: T, interpolator: jfxa.Interpolator) = new KeyValue[T, T](new jfxa.KeyValue(target, endValue, interpolator))
  def apply[T >: Int <: Int, J >: Number <: Number](target: Property[T, J], endValue: Int, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(Property.sfxProperty2jfx(target), int2Integer(endValue), interpolator))
  def apply[T >: Long <: Long, J >: Number <: Number](target: Property[T, J], endValue: Long, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, long2Long(endValue), interpolator))
  def apply[T >: Float <: Float, J >: Number <: Number](target: Property[T, J], endValue: Float, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, float2Float(endValue), interpolator))
  def apply[T >: Double <: Double, J >: Number <: Number](target: Property[T, J], endValue: Double, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, double2Double(endValue), interpolator))
  def apply[T >: Boolean <: Boolean, J >: java.lang.Boolean <: java.lang.Boolean](target: Property[T, J], endValue: Boolean, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, boolean2Boolean(endValue), interpolator))
  def apply[T <: Any, J <: AnyRef](target: Property[T, J], endValue: J, interpolator: jfxa.Interpolator) = new KeyValue[T, J](new jfxa.KeyValue(target, endValue, interpolator))
  def apply[T <: Any](target: jfxbv.WritableValue[T], endValue: T, interpolator: jfxa.Interpolator) = new KeyValue[T, T](new jfxa.KeyValue(target, endValue, interpolator))
}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/KeyValue.html $KV]].
 * Defines a key value to be interpolated for a particular interval along the animation.
 * A KeyFrame, which defines a specific point on a timeline, can hold multiple $KV s.
 * $KV is an immutable class.
 *
 * @tparam T Indicates Scala type that will be returned for this property.
 * @tparam J Indicates Java type to be wrapped by T. Eventually T and J could be the same.
 * @constructor Creates a new ScalaFX $KV from a JavaFX $KV.
 * @param delegate JavaFX $KV to be delegated.
 * 
 * @define KV `KeyValue`
 */
class KeyValue[T, J](override val delegate: jfxa.KeyValue)
  extends SFXDelegate[jfxa.KeyValue] {
  // need to fix the types on these returns since JavaFX KeyValue is not genericized

  /**
   * Returns the end value of this $KV.
   */
  def endValue: J = delegate.getEndValue.asInstanceOf[J]

  /**
   * Returns the target of this $KV.
   */
  def target: jfxbv.WritableValue[T] = delegate.getTarget.asInstanceOf[jfxbv.WritableValue[T]]

  /**
   * Interpolator to be used for calculating the key value along the particular interval.
   */
  def interpolator = delegate.getInterpolator

}

/**
 * Companion Object for [[scalafx.animation.Tweenable]].
 *
 * @define TW `Tweenable`
 * @define KV `KeyValue`
 */
object Tweenable {
  
  /**
   * Converts a ScalaFX $TW to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/animation/KeyValue.html $KV]].
   *
   * @param t ScalaFX $TW
   * @return JavaFX $KV extracted from `t.linear`.
   */
  implicit def tweenable2KeyFrame[T <: Any, J <: Any](t: Tweenable[T, J]) = t.linear
}

/**
 * Class factory for new [[scalafx.animation.KeyValue]]s.
 *
 * @tparam T Indicates Scala type that will be returned for this property.
 * @tparam J Indicates Java type to be wrapped by T. Eventually T and J could be the same.
 * @constructor Creates a new $TW
 * @param target target.
 * @param endValue end value.
 * 
 * @define TW `Tweenable`
 * @define KV `KeyValue`
 */
class Tweenable[T <: Any, J <: Any](target: jfxbv.WritableValue[J], endValue: J) {

  /**
   * Returns a new [[scalafx.animation.KeyValue]] with a determinate Interpolator.
   *
   * @param interpolator Interpolator to be used in KeyFrame.
   */
  def tween(interpolator: jfxa.Interpolator) = KeyValue[J](target, endValue, interpolator)

  /**
   * Returns a new [[scalafx.animation.KeyValue]] with [[scalafx.animation.Interpolator.LINEAR]] Interpolator.
   */
  def linear: KeyValue[J, J] = KeyValue[J](target, endValue)
}
