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

import javafx.beans.binding.{BooleanExpression => JFXBooleanExpression}
import javafx.beans.value.ObservableBooleanValue

object BooleanExpression {
  implicit def sfxBooleanExpression2jfx(be: BooleanExpression) = be.delegate

  implicit def jfxBooleanExpression2sfx(be: BooleanExpression) = new BooleanExpression(be)
}

class BooleanExpression(val delegate: JFXBooleanExpression) {
  def ==(v: ObservableBooleanValue) = new BooleanExpression(delegate.isEqualTo(v))

  def ==(v: BooleanExpression) = new BooleanExpression(delegate.isEqualTo(v.delegate))

  def !=(v: ObservableBooleanValue) = new BooleanExpression(delegate.isNotEqualTo(v))

  def !=(v: BooleanExpression) = new BooleanExpression(delegate.isNotEqualTo(v.delegate))

  def &&(v: ObservableBooleanValue) = new BooleanExpression(delegate.and(v))

  def &&(v: BooleanExpression) = new BooleanExpression(delegate.and(v.delegate))

  def ||(v: ObservableBooleanValue) = new BooleanExpression(delegate.or(v))

  def ||(v: BooleanExpression) = new BooleanExpression(delegate.or(v.delegate))

  def unary_!() = new BooleanExpression(delegate.not())
}