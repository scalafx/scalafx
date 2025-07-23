/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.beans.binding as jfxbb
import javafx.beans.value.ObservableNumberValue
import scalafx.beans.binding.BindingIncludes.jfxBooleanBinding2sfx
import scalafx.beans.binding.NumberExpression.VariablePrecisionNumber

import scala.language.implicitConversions

object NumberExpression {
  implicit def sfxNumberExpression2jfx(ne: NumberExpression): jfxbb.NumberExpression =
    if (ne != null) ne.delegate else null

  case class VariablePrecisionNumber(number: Double, var precision: Double = 0) {
    def +-(p: Double): VariablePrecisionNumber = {
      precision = p
      this
    }
  }

}

class NumberExpression(val delegate: jfxbb.NumberExpression) {
  def +(v: Int)                   = new NumberBinding(delegate.add(v))
  def +(v: Long)                  = new NumberBinding(delegate.add(v))
  def +(v: Float)                 = new NumberBinding(delegate.add(v))
  def +(v: Double)                = new NumberBinding(delegate.add(v))
  def +(v: ObservableNumberValue) = new NumberBinding(delegate.add(v))

  def -(v: Int)                   = new NumberBinding(delegate.subtract(v))
  def -(v: Long)                  = new NumberBinding(delegate.subtract(v))
  def -(v: Float)                 = new NumberBinding(delegate.subtract(v))
  def -(v: Double)                = new NumberBinding(delegate.subtract(v))
  def -(v: ObservableNumberValue) = new NumberBinding(delegate.subtract(v))

  def *(v: Int)                   = new NumberBinding(delegate.multiply(v))
  def *(v: Long)                  = new NumberBinding(delegate.multiply(v))
  def *(v: Float)                 = new NumberBinding(delegate.multiply(v))
  def *(v: Double)                = new NumberBinding(delegate.multiply(v))
  def *(v: ObservableNumberValue) = new NumberBinding(delegate.multiply(v))

  def /(v: Int)                   = new NumberBinding(delegate.divide(v))
  def /(v: Long)                  = new NumberBinding(delegate.divide(v))
  def /(v: Float)                 = new NumberBinding(delegate.divide(v))
  def /(v: Double)                = new NumberBinding(delegate.divide(v))
  def /(v: ObservableNumberValue) = new NumberBinding(delegate.divide(v))

  def ===(v: Int): BooleanBinding                     = delegate.isEqualTo(v)
  def ===(v: Long): BooleanBinding                    = delegate.isEqualTo(v)
  def ===(v: Float): BooleanBinding                   = delegate.isEqualTo(v, 0)
  def ===(v: Double): BooleanBinding                  = delegate.isEqualTo(v, 0)
  def ===(v: VariablePrecisionNumber): BooleanBinding = delegate.isEqualTo(v.number, v.precision)
  def ===(v: ObservableNumberValue): BooleanBinding   = delegate.isEqualTo(v)

  def =!=(v: Int): BooleanBinding                     = delegate.isNotEqualTo(v)
  def =!=(v: Long): BooleanBinding                    = delegate.isNotEqualTo(v)
  def =!=(v: Float): BooleanBinding                   = delegate.isNotEqualTo(v, 0)
  def =!=(v: Double): BooleanBinding                  = delegate.isNotEqualTo(v, 0)
  def =!=(v: VariablePrecisionNumber): BooleanBinding = delegate.isNotEqualTo(v.number, v.precision)
  def =!=(v: ObservableNumberValue): BooleanBinding   = delegate.isNotEqualTo(v)

  def <(v: Int): BooleanBinding                   = delegate.lessThan(v)
  def <(v: Long): BooleanBinding                  = delegate.lessThan(v)
  def <(v: Float): BooleanBinding                 = delegate.lessThan(v)
  def <(v: Double): BooleanBinding                = delegate.lessThan(v)
  def <(v: ObservableNumberValue): BooleanBinding = delegate.lessThan(v)

  def >(v: Int): BooleanBinding                   = delegate.greaterThan(v)
  def >(v: Long): BooleanBinding                  = delegate.greaterThan(v)
  def >(v: Float): BooleanBinding                 = delegate.greaterThan(v)
  def >(v: Double): BooleanBinding                = delegate.greaterThan(v)
  def >(v: ObservableNumberValue): BooleanBinding = delegate.greaterThan(v)

  def <=(v: Int): BooleanBinding                   = delegate.lessThanOrEqualTo(v)
  def <=(v: Long): BooleanBinding                  = delegate.lessThanOrEqualTo(v)
  def <=(v: Float): BooleanBinding                 = delegate.lessThanOrEqualTo(v)
  def <=(v: Double): BooleanBinding                = delegate.lessThanOrEqualTo(v)
  def <=(v: ObservableNumberValue): BooleanBinding = delegate.lessThanOrEqualTo(v)

  def >=(v: Int): BooleanBinding                   = delegate.greaterThanOrEqualTo(v)
  def >=(v: Long): BooleanBinding                  = delegate.greaterThanOrEqualTo(v)
  def >=(v: Float): BooleanBinding                 = delegate.greaterThanOrEqualTo(v)
  def >=(v: Double): BooleanBinding                = delegate.greaterThanOrEqualTo(v)
  def >=(v: ObservableNumberValue): BooleanBinding = delegate.greaterThanOrEqualTo(v)

  def unary_- = new NumberBinding(delegate.negate())

  def toInt: Int       = delegate.intValue
  def toLong: Long     = delegate.longValue
  def toFloat: Float   = delegate.floatValue
  def toDouble: Double = delegate.doubleValue
}
