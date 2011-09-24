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

import javafx.beans.{binding => jfxbb, value => jfxbv}
import scalafx.beans.value.ObservableValue

object Bindings extends Bindings

trait Bindings {
  def min(v1: jfxbv.ObservableNumberValue, values: jfxbv.ObservableNumberValue*) = (v1 /: values)(jfxbb.Bindings.min)
  def max(v1: jfxbv.ObservableNumberValue, values: jfxbv.ObservableNumberValue*) = (v1 /: values)(jfxbb.Bindings.max)

  def when(condition: => jfxbv.ObservableBooleanValue) = new ConditionBuilder(new jfxbb.When(condition))

  protected class ConditionBuilder(whenBuilder: jfxbb.When) {
    def then(thenExpression: jfxbv.ObservableNumberValue) = new NumberConditionBuilder(whenBuilder.then(thenExpression))
    def then(thenExpression: Int) = new NumberConditionBuilder(whenBuilder.then(thenExpression))
    def then(thenExpression: Long) = new NumberConditionBuilder(whenBuilder.then(thenExpression))
    def then(thenExpression: Float) = new NumberConditionBuilder(whenBuilder.then(thenExpression))
    def then(thenExpression: Double) = new NumberConditionBuilder(whenBuilder.then(thenExpression))

    def then[T](thenExpression: jfxbv.ObservableBooleanValue) = new BooleanConditionBuilder(whenBuilder.then(thenExpression))
    def then[T](thenExpression: Boolean) = new BooleanConditionBuilder(whenBuilder.then(thenExpression))

    def then[T](thenExpression: jfxbv.ObservableStringValue) = new StringConditionBuilder(whenBuilder.then(thenExpression))
    def then[T](thenExpression: String) = new StringConditionBuilder(whenBuilder.then(thenExpression))

    // explicit conversion needed due to T(Any) typed method
    def then[T](thenExpression: ObservableValue[T, T]) = new ObjectConditionBuilder[T](whenBuilder.then(ObservableValue.sfxObservableValue2jfxObjectValue[T](thenExpression)))
    def then[T](thenExpression: jfxbv.ObservableObjectValue[T]) = new ObjectConditionBuilder[T](whenBuilder.then(thenExpression))
    def then[T](thenExpression: T) = new ObjectConditionBuilder[T](whenBuilder.then(thenExpression))
  }

  protected class NumberConditionBuilder(whenBuilder: jfxbb.When#NumberConditionBuilder) {
    def otherwise(otherwiseExpression: jfxbv.ObservableNumberValue) = whenBuilder.otherwise(otherwiseExpression)
    def otherwise(otherwiseExpression: Int) = whenBuilder.otherwise(otherwiseExpression)
    def otherwise(otherwiseExpression: Long) = whenBuilder.otherwise(otherwiseExpression)
    def otherwise(otherwiseExpression: Float) = whenBuilder.otherwise(otherwiseExpression)
    def otherwise(otherwiseExpression: Double) = whenBuilder.otherwise(otherwiseExpression)
  }

  protected class BooleanConditionBuilder(whenBuilder: jfxbb.When#BooleanConditionBuilder) {
    def otherwise(otherwiseExpression: jfxbv.ObservableBooleanValue) = whenBuilder.otherwise(otherwiseExpression)
    def otherwise(otherwiseExpression: Boolean) = whenBuilder.otherwise(otherwiseExpression)
  }

  protected class StringConditionBuilder(whenBuilder: jfxbb.When#StringConditionBuilder) {
    def otherwise(otherwiseExpression: jfxbv.ObservableStringValue) = whenBuilder.otherwise(otherwiseExpression)
    def otherwise(otherwiseExpression: String) = whenBuilder.otherwise(otherwiseExpression)
  }

  protected class ObjectConditionBuilder[T](whenBuilder: jfxbb.When#ObjectConditionBuilder[T]) {
    // explicit conversion needed due to T(Any) typed method
    def otherwise(otherwiseExpression: ObservableValue[T, T]) = whenBuilder.otherwise(ObservableValue.sfxObservableValue2jfxObjectValue[T](otherwiseExpression))
    def otherwise(otherwiseExpression: jfxbv.ObservableObjectValue[T]) = whenBuilder.otherwise(otherwiseExpression)
    def otherwise(otherwiseExpression: T) = whenBuilder.otherwise(otherwiseExpression)
  }

}