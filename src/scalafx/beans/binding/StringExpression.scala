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

  implicit def jfxStringExpression2sfx(se: StringExpression) = new StringExpression(se)
}

class StringExpression(val delegate: JFXStringExpression) {
  // todo - this should really be a BooleanBinding (probably the same issue all over the place)
  def ==(v: String) = new BooleanExpression(delegate.isEqualTo(v))

  def ==(v: ObservableStringValue) = new BooleanExpression(delegate.isEqualTo(v))

  def ==(v: StringExpression) = new BooleanExpression(delegate.isEqualTo(v.delegate))

  def !=(v: String) = new BooleanExpression(delegate.isNotEqualTo(v))

  def !=(v: ObservableStringValue) = new BooleanExpression(delegate.isNotEqualTo(v))

  def !=(v: StringExpression) = new BooleanExpression(delegate.isNotEqualTo(v.delegate))

  def ==~(v: String) = new BooleanExpression(delegate.isEqualToIgnoreCase(v))

  def ==~(v: ObservableStringValue) = new BooleanExpression(delegate.isEqualToIgnoreCase(v))

  def ==~(v: StringExpression) = new BooleanExpression(delegate.isEqualToIgnoreCase(v.delegate))

  def !=~(v: String) = new BooleanExpression(delegate.isNotEqualToIgnoreCase(v))

  def !=~(v: ObservableStringValue) = new BooleanExpression(delegate.isNotEqualToIgnoreCase(v))

  def !=~(v: StringExpression) = new BooleanExpression(delegate.isNotEqualToIgnoreCase(v.delegate))

  def +(v: ObservableStringValue) = new StringExpression(delegate.concat(v))

  def +[T, J](v: ObservableValue[T, J]) = new StringExpression(delegate.concat(v.delegate))

  def +(v: AnyRef) = new StringExpression(delegate.concat(v))
}