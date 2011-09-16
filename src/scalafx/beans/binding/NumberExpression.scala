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

import javafx.beans.value.ObservableNumberValue
import scalafx.beans.binding.NumberExpression.VariablePrecisionNumber

object NumberExpression {
  implicit def sfxNumberExpression2jfx(ne: NumberExpression) = ne.wrappedNumberExpression
  implicit def jfxNumberExpression2sfx(ne: NumberExpression) = new NumberExpression(ne)
  case class VariablePrecisionNumber(number:Double, var precision:Double = 0) {
    def +-(p:Double):VariablePrecisionNumber = {
      precision = p
      this
    }
  }
}

class NumberExpression(val wrappedNumberExpression: javafx.beans.binding.NumberExpression) {
  def +(v: Int) = new NumberExpression(wrappedNumberExpression.add(v))
  def +(v: Long) = new NumberExpression(wrappedNumberExpression.add(v))
  def +(v: Float) = new NumberExpression(wrappedNumberExpression.add(v))
  def +(v: Double) = new NumberExpression(wrappedNumberExpression.add(v))
  def +(v: ObservableNumberValue) = new NumberExpression(wrappedNumberExpression.add(v))
  def +(v: NumberExpression) = new NumberExpression(wrappedNumberExpression.add(v.wrappedNumberExpression))

  def -(v: Int) = new NumberExpression(wrappedNumberExpression.subtract(v))
  def -(v: Long) = new NumberExpression(wrappedNumberExpression.subtract(v))
  def -(v: Float) = new NumberExpression(wrappedNumberExpression.subtract(v))
  def -(v: Double) = new NumberExpression(wrappedNumberExpression.subtract(v))
  def -(v: ObservableNumberValue) = new NumberExpression(wrappedNumberExpression.subtract(v))
  def -(v: NumberExpression) = new NumberExpression(wrappedNumberExpression.subtract(v.wrappedNumberExpression))

  def *(v: Int) = new NumberExpression(wrappedNumberExpression.multiply(v))
  def *(v: Long) = new NumberExpression(wrappedNumberExpression.multiply(v))
  def *(v: Float) = new NumberExpression(wrappedNumberExpression.multiply(v))
  def *(v: Double) = new NumberExpression(wrappedNumberExpression.multiply(v))
  def *(v: ObservableNumberValue) = new NumberExpression(wrappedNumberExpression.multiply(v))
  def *(v: NumberExpression) = new NumberExpression(wrappedNumberExpression.multiply(v.wrappedNumberExpression))

  def /(v: Int) = new NumberExpression(wrappedNumberExpression.divide(v))
  def /(v: Long) = new NumberExpression(wrappedNumberExpression.divide(v))
  def /(v: Float) = new NumberExpression(wrappedNumberExpression.divide(v))
  def /(v: Double) = new NumberExpression(wrappedNumberExpression.divide(v))
  def /(v: ObservableNumberValue) = new NumberExpression(wrappedNumberExpression.divide(v))
  def /(v: NumberExpression) = new NumberExpression(wrappedNumberExpression.divide(v.wrappedNumberExpression))

  def ==(v: Int) = wrappedNumberExpression.isEqualTo(v)
  def ==(v: Long) = wrappedNumberExpression.isEqualTo(v)
  def ==(v: Float) = wrappedNumberExpression.isEqualTo(v, 0)
  def ==(v: Double) = wrappedNumberExpression.isEqualTo(v, 0)
  def ==(v: VariablePrecisionNumber) = wrappedNumberExpression.isEqualTo(v.number, v.precision)
  def ==(v: ObservableNumberValue) = wrappedNumberExpression.isEqualTo(v)
  def ==(v: NumberExpression) = wrappedNumberExpression.isEqualTo(v.wrappedNumberExpression)

  def !=(v: Int) = wrappedNumberExpression.isNotEqualTo(v)
  def !=(v: Long) = wrappedNumberExpression.isNotEqualTo(v)
  def !=(v: Float) = wrappedNumberExpression.isNotEqualTo(v, 0)
  def !=(v: Double) = wrappedNumberExpression.isNotEqualTo(v, 0)
  def !=(v: VariablePrecisionNumber) = wrappedNumberExpression.isNotEqualTo(v.number, v.precision)
  def !=(v: ObservableNumberValue) = wrappedNumberExpression.isNotEqualTo(v)
  def !=(v: NumberExpression) = wrappedNumberExpression.isNotEqualTo(v.wrappedNumberExpression)

  def <(v: Int) = wrappedNumberExpression.lessThan(v)
  def <(v: Long) = wrappedNumberExpression.lessThan(v)
  def <(v: Float) = wrappedNumberExpression.lessThan(v)
  def <(v: Double) = wrappedNumberExpression.lessThan(v)
  def <(v: ObservableNumberValue) = wrappedNumberExpression.lessThan(v)
  def <(v: NumberExpression) = wrappedNumberExpression.lessThan(v.wrappedNumberExpression)

  def >(v: Int) = wrappedNumberExpression.greaterThan(v)
  def >(v: Long) = wrappedNumberExpression.greaterThan(v)
  def >(v: Float) = wrappedNumberExpression.greaterThan(v)
  def >(v: Double) = wrappedNumberExpression.greaterThan(v)
  def >(v: ObservableNumberValue) = wrappedNumberExpression.greaterThan(v)
  def >(v: NumberExpression) = wrappedNumberExpression.greaterThan(v.wrappedNumberExpression)

  def <=(v: Int) = wrappedNumberExpression.lessThanOrEqualTo(v)
  def <=(v: Long) = wrappedNumberExpression.lessThanOrEqualTo(v)
  def <=(v: Float) = wrappedNumberExpression.lessThanOrEqualTo(v)
  def <=(v: Double) = wrappedNumberExpression.lessThanOrEqualTo(v)
  def <=(v: ObservableNumberValue) = wrappedNumberExpression.lessThanOrEqualTo(v)
  def <=(v: NumberExpression) = wrappedNumberExpression.lessThanOrEqualTo(v.wrappedNumberExpression)

  def >=(v: Int) = wrappedNumberExpression.greaterThanOrEqualTo(v)
  def >=(v: Long) = wrappedNumberExpression.greaterThanOrEqualTo(v)
  def >=(v: Float) = wrappedNumberExpression.greaterThanOrEqualTo(v)
  def >=(v: Double) = wrappedNumberExpression.greaterThanOrEqualTo(v)
  def >=(v: ObservableNumberValue) = wrappedNumberExpression.greaterThanOrEqualTo(v)
  def >=(v: NumberExpression) = wrappedNumberExpression.greaterThanOrEqualTo(v.wrappedNumberExpression)

  def unary_- = wrappedNumberExpression.negate()

  def toInt = wrappedNumberExpression.intValue
  def toLong = wrappedNumberExpression.longValue
  def toFloat = wrappedNumberExpression.floatValue
  def toDouble = wrappedNumberExpression.doubleValue
}