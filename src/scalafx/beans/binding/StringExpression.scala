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

package scalafx.beans.binding

import javafx.beans.binding.{StringExpression => JFXStringExpression}
import scalafx.beans.value.ObservableValue
import javafx.beans.value.ObservableStringValue

object StringExpression {
  implicit def sfxStringExpression2jfx(se: StringExpression) = se.delegate
  implicit def jfxStringExpression2sfx(se: JFXStringExpression) = new StringExpression(se)
}

class StringExpression(val delegate: JFXStringExpression) {
  def ==(v: Null) = new BooleanBinding(delegate.isNull)
  def ==(v: String) = new BooleanBinding(delegate.isEqualTo(v))
  def ==(v: ObservableStringValue) = new BooleanBinding(delegate.isEqualTo(v))
  def ==(v: StringExpression) = new BooleanBinding(delegate.isEqualTo(v.delegate))

  def !=(v: Null) = new BooleanBinding(delegate.isNotNull)
  def !=(v: String) = new BooleanBinding(delegate.isNotEqualTo(v))
  def !=(v: ObservableStringValue) = new BooleanBinding(delegate.isNotEqualTo(v))
  def !=(v: StringExpression) = new BooleanBinding(delegate.isNotEqualTo(v.delegate))

  def ==~(v: Null) = new BooleanBinding(delegate.isNull)
  def ==~(v: String) = new BooleanBinding(delegate.isEqualToIgnoreCase(v))
  def ==~(v: ObservableStringValue) = new BooleanBinding(delegate.isEqualToIgnoreCase(v))
  def ==~(v: StringExpression) = new BooleanBinding(delegate.isEqualToIgnoreCase(v.delegate))

  def !=~(v: Null) = new BooleanBinding(delegate.isNotNull)
  def !=~(v: String) = new BooleanBinding(delegate.isNotEqualToIgnoreCase(v))
  def !=~(v: ObservableStringValue) = new BooleanBinding(delegate.isNotEqualToIgnoreCase(v))
  def !=~(v: StringExpression) = new BooleanBinding(delegate.isNotEqualToIgnoreCase(v.delegate))

  def <(v: Null) = new BooleanBinding(delegate.lessThan(v.asInstanceOf[String]))
  def <(v: String) = new BooleanBinding(delegate.lessThan(v))
  def <(v: ObservableStringValue) = new BooleanBinding(delegate.lessThan(v))
  def <(v: StringExpression) = new BooleanBinding(delegate.lessThan(v.delegate))

  def <=(v: Null) = new BooleanBinding(delegate.lessThanOrEqualTo(v.asInstanceOf[String]))
  def <=(v: String) = new BooleanBinding(delegate.lessThanOrEqualTo(v))
  def <=(v: ObservableStringValue) = new BooleanBinding(delegate.lessThanOrEqualTo(v))
  def <=(v: StringExpression) = new BooleanBinding(delegate.lessThanOrEqualTo(v.delegate))

  def >(v: Null) = new BooleanBinding(delegate.greaterThan(v.asInstanceOf[String]))
  def >(v: String) = new BooleanBinding(delegate.greaterThan(v))
  def >(v: ObservableStringValue) = new BooleanBinding(delegate.greaterThan(v))
  def >(v: StringExpression) = new BooleanBinding(delegate.greaterThan(v.delegate))

  def >=(v: Null) = new BooleanBinding(delegate.greaterThanOrEqualTo(v.asInstanceOf[String]))
  def >=(v: String) = new BooleanBinding(delegate.greaterThanOrEqualTo(v))
  def >=(v: ObservableStringValue) = new BooleanBinding(delegate.greaterThanOrEqualTo(v))
  def >=(v: StringExpression) = new BooleanBinding(delegate.greaterThanOrEqualTo(v.delegate))

  // Kind of an odd case that concat is not observable, but this is how it is coded in JavaFX
  def +(v: Null) = new StringExpression(delegate.concat(v.asInstanceOf))
  def +(v: ObservableStringValue) = new StringExpression(delegate.concat(v))
  def +[T, J](v: ObservableValue[T, J]) = new StringExpression(delegate.concat(v.delegate))
  def +(v: Any) = new StringExpression(delegate.concat(v))
}