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

import javafx.{beans => jfxb}
import javafx.beans.{binding => jfxbb, value => jfxbv}
import scalafx.beans.binding.NumberExpression.VariablePrecisionNumber

object BindingIncludes extends BindingIncludes

trait BindingIncludes extends Bindings {
  // Implicit upcasts from JavaFX to ScalaFX types for all bindings

  implicit def jfxBooleanBinding2sfx(bb: jfxbb.BooleanBinding) = new BooleanBinding(bb)
  implicit def jfxBooleanExpression2sfx(be: jfxbb.BooleanExpression) = new BooleanExpression(be)
  implicit def jfxNumberBinding2sfx(nb: jfxbb.NumberBinding) = new NumberBinding(nb)
  implicit def jfxNumberExpression2sfx(ne: jfxbb.NumberExpression) = new NumberExpression(ne)
  implicit def jfxObjectBinding2sfx[T](ob: jfxbb.ObjectBinding[T]) = new ObjectBinding[T](ob)
  implicit def jfxObjectExpression2sfx[T](oe: jfxbb.ObjectExpression[T]) = new ObjectExpression[T](oe)
  implicit def jfxStringBinding2sfx(sb: jfxbb.StringBinding) = new StringBinding(sb)
  implicit def jfxStringExpression2sfx(se: jfxbb.StringExpression) = new StringExpression(se)

  // Conversion helper for variable precision numbers (e.g. 100+-.01)

  implicit def double2VariablePrecisionNumber(d: Double) = VariablePrecisionNumber(d)

  // Simple closure syntax for observables to reduce boilerplace on the JavaFX addListener methods

  implicit def closure2InvalidationListener(il: jfxb.Observable => Unit) = new jfxb.InvalidationListener {
    def invalidated(observable: jfxb.Observable) {
      il(observable)
    }
  }

  implicit def closure2ChangedListener[P](cl: (jfxbv.ObservableValue[_ <: P], P, P) => Unit) = new jfxbv.ChangeListener[P]() {
    def changed(observable: jfxbv.ObservableValue[_ <: P], oldValue: P, newValue: P) {
      cl(observable, oldValue, newValue)
    }
  }

  // Upconversions from primitives to bindings
  // Needed for min and max, which take a list of bindings -- all other uses have the primitives declared directly for efficiency

  implicit def integer2IntegerBinding(i: Int) = new jfxbb.IntegerBinding {
    def computeValue() = i
  }

  implicit def long2LongBinding(i: Long) = new jfxbb.LongBinding {
    def computeValue() = i
  }

  implicit def float2FloatBinding(i: Float) = new jfxbb.FloatBinding {
    def computeValue() = i
  }

  implicit def double2DoubleBinding(i: Double) = new jfxbb.DoubleBinding {
    def computeValue() = i
  }
}
