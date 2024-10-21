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
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object StringExpression {
  implicit def sfxStringExpression2jfx(se: StringExpression): jfxbb.StringExpression =
    if (se != null) se.delegate else null
}

class StringExpression(val delegate: jfxbb.StringExpression) {
  def ===(v: Null): BooleanBinding = delegate.isNull

  def ===(v: String): BooleanBinding = delegate.isEqualTo(v)

  def ===(v: jfxbv.ObservableStringValue): BooleanBinding = delegate.isEqualTo(v)

  def =!=(v: Null): BooleanBinding = delegate.isNotNull

  def =!=(v: String): BooleanBinding = delegate.isNotEqualTo(v)

  def =!=(v: jfxbv.ObservableStringValue): BooleanBinding = delegate.isNotEqualTo(v)

  def ==~(v: Null): BooleanBinding = delegate.isNull

  def ==~(v: String): BooleanBinding = delegate.isEqualToIgnoreCase(v)

  def ==~(v: jfxbv.ObservableStringValue): BooleanBinding = delegate.isEqualToIgnoreCase(v)

  def !=~(v: Null): BooleanBinding = delegate.isNotNull

  def !=~(v: String): BooleanBinding = delegate.isNotEqualToIgnoreCase(v)

  def !=~(v: jfxbv.ObservableStringValue): BooleanBinding = delegate.isNotEqualToIgnoreCase(v)

  def <(v: Null): BooleanBinding = delegate.lessThan(v.asInstanceOf[String])

  def <(v: String): BooleanBinding = delegate.lessThan(v)

  def <(v: jfxbv.ObservableStringValue): BooleanBinding = delegate.lessThan(v)

  def <=(v: Null): BooleanBinding = delegate.lessThanOrEqualTo(v.asInstanceOf[String])

  def <=(v: String): BooleanBinding = delegate.lessThanOrEqualTo(v)

  def <=(v: jfxbv.ObservableStringValue): BooleanBinding = delegate.lessThanOrEqualTo(v)

  def >(v: Null): BooleanBinding = delegate.greaterThan(v.asInstanceOf[String])

  def >(v: String): BooleanBinding = delegate.greaterThan(v)

  def >(v: jfxbv.ObservableStringValue): BooleanBinding = delegate.greaterThan(v)

  def >=(v: Null): BooleanBinding = delegate.greaterThanOrEqualTo(v.asInstanceOf[String])

  def >=(v: String): BooleanBinding = delegate.greaterThanOrEqualTo(v)

  def >=(v: jfxbv.ObservableStringValue): BooleanBinding = delegate.greaterThanOrEqualTo(v)

  // Kind of an odd case that concat is not observable, but this is how it is coded in JavaFX
  def + : Any => StringExpression = concat

  def concat(v: Any): StringExpression = {
    val jfxV = v match {
      case d: SFXDelegate[_] => d.delegate
      case a                 => a
    }
    new StringExpression(delegate.concat(jfxV))
  }
}
