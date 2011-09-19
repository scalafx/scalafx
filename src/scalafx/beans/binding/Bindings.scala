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

import scalafx.beans.binding.NumberExpression.VariablePrecisionNumber
import javafx.beans.{InvalidationListener, Observable => JFXObservable}
import javafx.beans.binding.When
import javafx.beans.value.{ObservableStringValue, ObservableObjectValue, ObservableNumberValue, ChangeListener, ObservableValue => JFXObservableValue, ObservableBooleanValue}
import scalafx.beans.value.ObservableValue

object Bindings {
  implicit def double2VariablePrecisionNumber(d: Double) = VariablePrecisionNumber(d)

  implicit def closure2InvalidationListener(il: JFXObservable => Unit) = new InvalidationListener {
    def invalidated(observable: JFXObservable) {
      il(observable)
    }
  }

  implicit def closure2ChangedListener[P](cl: (JFXObservableValue[_ <: P], P, P) => Unit) = new ChangeListener[P]() {
    def changed(observable: JFXObservableValue[_ <: P], oldValue: P, newValue: P) {
      cl(observable, oldValue, newValue)
    }
  }

  def when(condition: => ObservableBooleanValue) = new ConditionBuilder(new When(condition))

  protected class ConditionBuilder(whenBuilder: When) {
    def then[T](thenExpression: ObservableValue[T, Number]) = new NumberConditionBuilder(whenBuilder.then(thenExpression.delegate.asInstanceOf[ObservableNumberValue]))

    def then(thenExpression: ObservableNumberValue) = new NumberConditionBuilder(whenBuilder.then(thenExpression))

    def then(thenExpression: Int) = new NumberConditionBuilder(whenBuilder.then(thenExpression))

    def then(thenExpression: Long) = new NumberConditionBuilder(whenBuilder.then(thenExpression))

    def then(thenExpression: Float) = new NumberConditionBuilder(whenBuilder.then(thenExpression))

    def then(thenExpression: Double) = new NumberConditionBuilder(whenBuilder.then(thenExpression))

    def then[T](thenExpression: ObservableValue[Boolean, java.lang.Boolean]) = new BooleanConditionBuilder(whenBuilder.then(thenExpression.delegate.asInstanceOf[ObservableBooleanValue]))

    def then[T](thenExpression: ObservableBooleanValue) = new BooleanConditionBuilder(whenBuilder.then(thenExpression))

    def then[T](thenExpression: Boolean) = new BooleanConditionBuilder(whenBuilder.then(thenExpression))

    def then[T](thenExpression: ObservableStringValue) = new StringConditionBuilder(whenBuilder.then(thenExpression))

    def then[T](thenExpression: String) = new StringConditionBuilder(whenBuilder.then(thenExpression))

    def then[T](thenExpression: ObservableValue[T, T]) = new ObjectConditionBuilder[T](whenBuilder.then(thenExpression.delegate.asInstanceOf[ObservableObjectValue[T]]))

    def then[T](thenExpression: ObservableObjectValue[T]) = new ObjectConditionBuilder[T](whenBuilder.then(thenExpression))

    def then[T](thenExpression: T) = new ObjectConditionBuilder[T](whenBuilder.then(thenExpression))
  }

  protected class NumberConditionBuilder(whenBuilder: When#NumberConditionBuilder) {
    def otherwise[T](otherwiseExpression: ObservableValue[T, Number]) = whenBuilder.otherwise(otherwiseExpression.delegate.asInstanceOf[ObservableNumberValue])

    def otherwise(otherwiseExpression: ObservableNumberValue) = whenBuilder.otherwise(otherwiseExpression)

    def otherwise(otherwiseExpression: Int) = whenBuilder.otherwise(otherwiseExpression)

    def otherwise(otherwiseExpression: Long) = whenBuilder.otherwise(otherwiseExpression)

    def otherwise(otherwiseExpression: Float) = whenBuilder.otherwise(otherwiseExpression)

    def otherwise(otherwiseExpression: Double) = whenBuilder.otherwise(otherwiseExpression)
  }

  protected class BooleanConditionBuilder(whenBuilder: When#BooleanConditionBuilder) {
    def otherwise(otherwiseExpression: ObservableValue[Boolean, java.lang.Boolean]) = whenBuilder.otherwise(otherwiseExpression.delegate.asInstanceOf[ObservableBooleanValue])

    def otherwise(otherwiseExpression: ObservableBooleanValue) = whenBuilder.otherwise(otherwiseExpression)

    def otherwise(otherwiseExpression: Boolean) = whenBuilder.otherwise(otherwiseExpression)
  }

  protected class StringConditionBuilder(whenBuilder: When#StringConditionBuilder) {
    def otherwise(otherwiseExpression: ObservableStringValue) = whenBuilder.otherwise(otherwiseExpression)

    def otherwise(otherwiseExpression: String) = whenBuilder.otherwise(otherwiseExpression)
  }

  protected class ObjectConditionBuilder[T](whenBuilder: When#ObjectConditionBuilder[T]) {
    def otherwise(otherwiseExpression: ObservableValue[T, T]) = whenBuilder.otherwise(otherwiseExpression.delegate.asInstanceOf[ObservableObjectValue[T]])

    def otherwise(otherwiseExpression: ObservableObjectValue[T]) = whenBuilder.otherwise(otherwiseExpression)

    def otherwise(otherwiseExpression: T) = whenBuilder.otherwise(otherwiseExpression)
  }
}
