/*
 * Copyright (c) 2011-2013, ScalaFX Project
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
import scalafx.delegate.SFXDelegate

object Bindings extends Bindings

/**
 * Contains Methods for Bindings.
 * 
 * @define JFX JavaFX
 */
trait Bindings {
  
  /**
   * Returns the highest value among a collection of $JFX 
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableNumberValue.html `ObservableNumberValue`]]s.
   * 
   * @param v1 First Value
   * @param values Collection of values
   * @return The highest Value
   */
  def min(v1: jfxbv.ObservableNumberValue, values: jfxbv.ObservableNumberValue*) = (v1 /: values)(jfxbb.Bindings.min)
  
  /**
   * Returns the Lowest value among a collection of $JFX 
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableNumberValue.html `ObservableNumberValue`]]s.
   * 
   * @param v1 First Value
   * @param values Collection of values
   * @return The Lowest Value
   */
  def max(v1: jfxbv.ObservableNumberValue, values: jfxbv.ObservableNumberValue*) = (v1 /: values)(jfxbb.Bindings.max)

  /**
   * Returns the sum of a collection of $JFX
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableNumberValue.html `ObservableNumberValue`]]s.
   * 
   * @param v1 First Value
   * @param values Collection of values
   * @return The Value sum.
   */
  def add(v1: jfxbv.ObservableNumberValue, values: jfxbv.ObservableNumberValue*) = (v1 /: values)(jfxbb.Bindings.add)

  /**
   * 
   * @param condition Function that returns a $JFX 
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/value/ObservableBooleanValue.html `ObservableBooleanValue`]]
   * @return A ConditionBuilder wrapping `condition`. 
   */
  def when(condition: => jfxbv.ObservableBooleanValue) = new ConditionBuilder(new jfxbb.When(condition))

  protected class ConditionBuilder(whenBuilder: jfxbb.When) {
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`(thenExpression: jfxbv.ObservableNumberValue) = choose(thenExpression)
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`(thenExpression: Int) = choose(thenExpression)
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`(thenExpression: Long) = choose(thenExpression)
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`(thenExpression: Float) = choose(thenExpression)
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`(thenExpression: Double) = choose(thenExpression)

    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`[T](thenExpression: jfxbv.ObservableBooleanValue) = choose(thenExpression)
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`[T](thenExpression: Boolean) = choose(thenExpression)

    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`[T](thenExpression: jfxbv.ObservableStringValue) = choose(thenExpression)
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`[T](thenExpression: String) = choose(thenExpression)

    // explicit conversion needed due to T(Any) typed method
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`[T](thenExpression: ObservableValue[T, T]) = choose(thenExpression)
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`[T](thenExpression: jfxbv.ObservableObjectValue[T]) = choose(thenExpression)
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`[T](thenExpression: T) = choose(thenExpression)
    /** Create `ObjectConditionBuilder` with type of the delegate rather than wrapping SFX.
      *
      * This is addressing problems pointed in Issue 16 - inability to bind an expression to JFX property
      * when `thenValue` is a SFX wrapper. */
    @deprecated(message = "`then` is a reserved word in Scala 2.10+, use `choose` instead. `then` will be removed in ScalaFX 1.0.0-m3", since = "1.0.0-m1")
     def `then`[J <: Object](thenExpression: SFXDelegate[J]) = choose(thenExpression)

    def choose(chooseExpression: NumberBinding) = new NumberConditionBuilder(whenBuilder.`then`(chooseExpression.delegate))
    def choose(chooseExpression: jfxbv.ObservableNumberValue) = new NumberConditionBuilder(whenBuilder.`then`(chooseExpression))
    def choose(chooseExpression: Int) = new NumberConditionBuilder(whenBuilder.`then`(chooseExpression))
    def choose(chooseExpression: Long) = new NumberConditionBuilder(whenBuilder.`then`(chooseExpression))
    def choose(chooseExpression: Float) = new NumberConditionBuilder(whenBuilder.`then`(chooseExpression))
    def choose(chooseExpression: Double) = new NumberConditionBuilder(whenBuilder.`then`(chooseExpression))

    def choose[T](chooseExpression: jfxbv.ObservableBooleanValue) = new BooleanConditionBuilder(whenBuilder.`then`(chooseExpression))
    def choose[T](chooseExpression: Boolean) = new BooleanConditionBuilder(whenBuilder.`then`(chooseExpression))

    def choose[T](chooseExpression: jfxbv.ObservableStringValue) = new StringConditionBuilder(whenBuilder.`then`(chooseExpression))
    def choose[T](chooseExpression: String) = new StringConditionBuilder(whenBuilder.`then`(chooseExpression))

    // explicit conversion needed due to T(Any) typed method
    def choose[T](chooseExpression: ObservableValue[T, T]) = new ObjectConditionBuilder[T](whenBuilder.`then`(ObservableValue.sfxObservableValue2jfxObjectValue[T](chooseExpression)))
    def choose[T](chooseExpression: jfxbv.ObservableObjectValue[T]) = new ObjectConditionBuilder[T](whenBuilder.`then`(chooseExpression))
    def choose[T](chooseExpression: T) = new ObjectConditionBuilder[T](whenBuilder.`then`(chooseExpression))
    /** Create `ObjectConditionBuilder` with type of the delegate rather than wrapping SFX.
      *
      * This is addressing problems pointed in Issue 16 - inability to bind an expression to JFX property
      * when `thenValue` is a SFX wrapper. */
    def choose[J <: Object](chooseExpression: SFXDelegate[J]) = new ObjectConditionBuilder[J](whenBuilder.`then`(chooseExpression.delegate))

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