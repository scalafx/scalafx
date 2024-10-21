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
package scalafx.beans.binding

import javafx.beans.{binding => jfxbb, value => jfxbv}
import scalafx.beans.binding.BindingIncludes._
import scalafx.beans.value.ObservableValue

import scala.language.implicitConversions

object ObjectExpression {
  implicit def sfxObjectExpression2jfx[J](oe: ObjectExpression[J]): jfxbb.ObjectExpression[J] =
    if (oe != null) oe.delegate else null
}

class ObjectExpression[J](val delegate: jfxbb.ObjectExpression[J]) {
  def ===(v: Null): BooleanBinding = delegate.isNull

  def ===(v: jfxbv.ObservableObjectValue[_]): BooleanBinding = delegate.isEqualTo(v)

  // explicit conversion needed due to AnyRef typed method
  def ===[T](v: ObservableValue[T, T]): BooleanBinding =
    delegate.isEqualTo(ObservableValue.sfxObservableValue2jfxObjectValue[T](v))

  def ===(v: AnyRef): BooleanBinding = delegate.isEqualTo(v)

  def =!=(v: Null): BooleanBinding = delegate.isNotNull

  def =!=(v: jfxbv.ObservableObjectValue[_]): BooleanBinding = delegate.isNotEqualTo(v)

  // explicit conversion needed due to AnyRef typed method
  def =!=[T](v: ObservableValue[T, T]): BooleanBinding =
    delegate.isNotEqualTo(ObservableValue.sfxObservableValue2jfxObjectValue[T](v))

  def =!=(v: AnyRef): BooleanBinding = delegate.isNotEqualTo(v)

  def selectDouble(s: String): jfxbb.DoubleBinding = jfxbb.Bindings.selectDouble(this.delegate, s)

  def selectBoolean(s: String): BooleanBinding = jfxbb.Bindings.selectBoolean(this.delegate, s)

  def selectFloat(s: String): jfxbb.FloatBinding = jfxbb.Bindings.selectFloat(this.delegate, s)

  def selectInteger(s: String): jfxbb.IntegerBinding = jfxbb.Bindings.selectInteger(this.delegate, s)

  def selectLong(s: String): jfxbb.LongBinding = jfxbb.Bindings.selectLong(this.delegate, s)

  def selectString(s: String): StringBinding = jfxbb.Bindings.selectString(this.delegate, s)

  def select[T](s: String): ObjectBinding[T] = jfxbb.Bindings.select[T](this.delegate, s)
}
