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

import javafx.beans.binding.{NumberExpression => JFXNumberExpression}
import javafx.beans.value.ObservableNumberValue
import scalafx.beans.binding.NumberExpression.VariablePrecisionNumber

object NumberExpression {
  implicit def sfxNumberExpression2jfx(ne: NumberExpression) = ne.delegate
  implicit def jfxNumberExpression2sfx(ne: JFXNumberExpression) = new NumberExpression(ne)
  case class VariablePrecisionNumber(number:Double, var precision:Double = 0) {
    def +-(p:Double):VariablePrecisionNumber = {
      precision = p
      this
    }
  }
}

class NumberExpression(val delegate: JFXNumberExpression) {
  def +(v: Int) = new NumberBinding(delegate.add(v))
  def +(v: Long) = new NumberBinding(delegate.add(v))
  def +(v: Float) = new NumberBinding(delegate.add(v))
  def +(v: Double) = new NumberBinding(delegate.add(v))
  def +(v: ObservableNumberValue) = new NumberBinding(delegate.add(v))
  def +(v: NumberExpression) = new NumberBinding(delegate.add(v.delegate))

  def -(v: Int) = new NumberBinding(delegate.subtract(v))
  def -(v: Long) = new NumberBinding(delegate.subtract(v))
  def -(v: Float) = new NumberBinding(delegate.subtract(v))
  def -(v: Double) = new NumberBinding(delegate.subtract(v))
  def -(v: ObservableNumberValue) = new NumberBinding(delegate.subtract(v))
  def -(v: NumberExpression) = new NumberBinding(delegate.subtract(v.delegate))

  def *(v: Int) = new NumberBinding(delegate.multiply(v))
  def *(v: Long) = new NumberBinding(delegate.multiply(v))
  def *(v: Float) = new NumberBinding(delegate.multiply(v))
  def *(v: Double) = new NumberBinding(delegate.multiply(v))
  def *(v: ObservableNumberValue) = new NumberBinding(delegate.multiply(v))
  def *(v: NumberExpression) = new NumberBinding(delegate.multiply(v.delegate))

  def /(v: Int) = new NumberBinding(delegate.divide(v))
  def /(v: Long) = new NumberBinding(delegate.divide(v))
  def /(v: Float) = new NumberBinding(delegate.divide(v))
  def /(v: Double) = new NumberBinding(delegate.divide(v))
  def /(v: ObservableNumberValue) = new NumberBinding(delegate.divide(v))
  def /(v: NumberExpression) = new NumberBinding(delegate.divide(v.delegate))

  def ==(v: Int) = new BooleanBinding(delegate.isEqualTo(v))
  def ==(v: Long) = new BooleanBinding(delegate.isEqualTo(v))
  def ==(v: Float) = new BooleanBinding(delegate.isEqualTo(v, 0))
  def ==(v: Double) = new BooleanBinding(delegate.isEqualTo(v, 0))
  def ==(v: VariablePrecisionNumber) = new BooleanBinding(delegate.isEqualTo(v.number, v.precision))
  def ==(v: ObservableNumberValue) = new BooleanBinding(delegate.isEqualTo(v))
  def ==(v: NumberExpression) = new BooleanBinding(delegate.isEqualTo(v.delegate))

  def !=(v: Int) = new BooleanBinding(delegate.isNotEqualTo(v))
  def !=(v: Long) = new BooleanBinding(delegate.isNotEqualTo(v))
  def !=(v: Float) = new BooleanBinding(delegate.isNotEqualTo(v, 0))
  def !=(v: Double) = new BooleanBinding(delegate.isNotEqualTo(v, 0))
  def !=(v: VariablePrecisionNumber) = new BooleanBinding(delegate.isNotEqualTo(v.number, v.precision))
  def !=(v: ObservableNumberValue) = new BooleanBinding(delegate.isNotEqualTo(v))
  def !=(v: NumberExpression) = new BooleanBinding(delegate.isNotEqualTo(v.delegate))

  def <(v: Int) = new BooleanBinding(delegate.lessThan(v))
  def <(v: Long) = new BooleanBinding(delegate.lessThan(v))
  def <(v: Float) = new BooleanBinding(delegate.lessThan(v))
  def <(v: Double) = new BooleanBinding(delegate.lessThan(v))
  def <(v: ObservableNumberValue) = new BooleanBinding(delegate.lessThan(v))
  def <(v: NumberExpression) = new BooleanBinding(delegate.lessThan(v.delegate))

  def >(v: Int) = new BooleanBinding(delegate.greaterThan(v))
  def >(v: Long) = new BooleanBinding(delegate.greaterThan(v))
  def >(v: Float) = new BooleanBinding(delegate.greaterThan(v))
  def >(v: Double) = new BooleanBinding(delegate.greaterThan(v))
  def >(v: ObservableNumberValue) = new BooleanBinding(delegate.greaterThan(v))
  def >(v: NumberExpression) = new BooleanBinding(delegate.greaterThan(v.delegate))

  def <=(v: Int) = new BooleanBinding(delegate.lessThanOrEqualTo(v))
  def <=(v: Long) = new BooleanBinding(delegate.lessThanOrEqualTo(v))
  def <=(v: Float) = new BooleanBinding(delegate.lessThanOrEqualTo(v))
  def <=(v: Double) = new BooleanBinding(delegate.lessThanOrEqualTo(v))
  def <=(v: ObservableNumberValue) = new BooleanBinding(delegate.lessThanOrEqualTo(v))
  def <=(v: NumberExpression) = new BooleanBinding(delegate.lessThanOrEqualTo(v.delegate))

  def >=(v: Int) = new BooleanBinding(delegate.greaterThanOrEqualTo(v))
  def >=(v: Long) = new BooleanBinding(delegate.greaterThanOrEqualTo(v))
  def >=(v: Float) = new BooleanBinding(delegate.greaterThanOrEqualTo(v))
  def >=(v: Double) = new BooleanBinding(delegate.greaterThanOrEqualTo(v))
  def >=(v: ObservableNumberValue) = new BooleanBinding(delegate.greaterThanOrEqualTo(v))
  def >=(v: NumberExpression) = new BooleanBinding(delegate.greaterThanOrEqualTo(v.delegate))

  def unary_- = new NumberBinding(delegate.negate())

  def toInt = delegate.intValue
  def toLong = delegate.longValue
  def toFloat = delegate.floatValue
  def toDouble = delegate.doubleValue
}