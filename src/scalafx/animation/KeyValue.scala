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

package scalafx.animation

import javafx.{animation => jfxa}
import javafx.beans.{value => jfxbv}
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.beans.property.Property

object KeyValue {
  implicit def sfxKeyValue2jfx(v: KeyValue[_, _]) = v.delegate

  // need to separately capture the Number/primitive combinations since JavaFX does not go down to primitives in its generics
  def apply(target: jfxbv.WritableIntegerValue, endValue: Int) = new KeyValue[Int, Number](new jfxa.KeyValue(target, int2Integer(endValue)))
  def apply(target: jfxbv.WritableLongValue, endValue: Long) = new KeyValue[Long, Number](new jfxa.KeyValue(target, long2Long(endValue)))
  def apply(target: jfxbv.WritableFloatValue, endValue: Float) = new KeyValue[Float, Number](new jfxa.KeyValue(target, float2Float(endValue)))
  def apply(target: jfxbv.WritableDoubleValue, endValue: Double) = new KeyValue[Double, Number](new jfxa.KeyValue(target, double2Double(endValue)))
  def apply(target: jfxbv.WritableBooleanValue, endValue: Boolean) = new KeyValue[Boolean, java.lang.Boolean](new jfxa.KeyValue(target, boolean2Boolean(endValue)))
  def apply(target: Property[Int, Number], endValue: Int) = new KeyValue[Int, Number](new jfxa.KeyValue(Property.sfxProperty2jfx(target), int2Integer(endValue)))
  def apply(target: Property[Long, Number], endValue: Long) = new KeyValue[Long, Number](new jfxa.KeyValue(target, long2Long(endValue)))
  def apply(target: Property[Float, Number], endValue: Float) = new KeyValue[Float, Number](new jfxa.KeyValue(target, float2Float(endValue)))
  def apply(target: Property[Double, Number], endValue: Double) = new KeyValue[Double, Number](new jfxa.KeyValue(target, double2Double(endValue)))
  def apply(target: Property[Boolean, java.lang.Boolean], endValue: Boolean) = new KeyValue[Boolean, java.lang.Boolean](new jfxa.KeyValue(target, boolean2Boolean(endValue)))
  def apply[T <: AnyRef](target: jfxbv.WritableValue[T], endValue: T) = new KeyValue[T, T](new jfxa.KeyValue(target, endValue))
}

class KeyValue[T, J](override val delegate: jfxa.KeyValue) extends SFXDelegate[jfxa.KeyValue] {
  // need to fix the types on these returns since JavaFX KeyValue is not genericized
  def endValue: J = delegate.getEndValue.asInstanceOf[J]
  def target: jfxbv.WritableValue[T] = delegate.getTarget.asInstanceOf[jfxbv.WritableValue[T]]
}