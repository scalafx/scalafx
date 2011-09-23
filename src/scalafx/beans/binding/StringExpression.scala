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

import javafx.beans.{binding => jfxbb}
import javafx.beans.value.ObservableStringValue

object StringExpression {
  implicit def sfxStringExpression2jfx(se: StringExpression) = se.delegate
}

class StringExpression(val delegate: jfxbb.StringExpression) {
  def ===(v: Null) = delegate.isNull
  def ===(v: String) = delegate.isEqualTo(v)
  def ===(v: ObservableStringValue) = delegate.isEqualTo(v)

  def =!=(v: Null) = delegate.isNotNull
  def =!=(v: String) = delegate.isNotEqualTo(v)
  def =!=(v: ObservableStringValue) = delegate.isNotEqualTo(v)

  def ==~(v: Null) = delegate.isNull
  def ==~(v: String) = delegate.isEqualToIgnoreCase(v)
  def ==~(v: ObservableStringValue) = delegate.isEqualToIgnoreCase(v)

  def !=~(v: Null) = delegate.isNotNull
  def !=~(v: String) = delegate.isNotEqualToIgnoreCase(v)
  def !=~(v: ObservableStringValue) = delegate.isNotEqualToIgnoreCase(v)

  def <(v: Null) = delegate.lessThan(v.asInstanceOf[String])
  def <(v: String) = delegate.lessThan(v)
  def <(v: ObservableStringValue) = delegate.lessThan(v)

  def <=(v: Null) = delegate.lessThanOrEqualTo(v.asInstanceOf[String])
  def <=(v: String) = delegate.lessThanOrEqualTo(v)
  def <=(v: ObservableStringValue) = delegate.lessThanOrEqualTo(v)

  def >(v: Null) = delegate.greaterThan(v.asInstanceOf[String])
  def >(v: String) = delegate.greaterThan(v)
  def >(v: ObservableStringValue) = delegate.greaterThan(v)

  def >=(v: Null) = delegate.greaterThanOrEqualTo(v.asInstanceOf[String])
  def >=(v: String) = delegate.greaterThanOrEqualTo(v)
  def >=(v: ObservableStringValue) = delegate.greaterThanOrEqualTo(v)

  // Kind of an odd case that concat is not observable, but this is how it is coded in JavaFX
  def +(v: Null) = delegate.concat(v.asInstanceOf)
  def +(v: ObservableStringValue) = delegate.concat(v)
  def +(v: Any) = delegate.concat(v)
}