/*
 * Copyright (c) 2011-2016, ScalaFX Project
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

import scalafx.beans.Observable
import scalafx.beans.binding.BindingIncludes._
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
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ObservableNumberValue.html `ObservableNumberValue`]]s.
    *
    * @param v1     First Value
    * @param values Collection of values
    * @return The highest Value
    */
  def min(v1: jfxbv.ObservableNumberValue, values: jfxbv.ObservableNumberValue*) = (v1 /: values) (jfxbb.Bindings.min)

  /**
    * Returns the Lowest value among a collection of $JFX
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ObservableNumberValue.html `ObservableNumberValue`]]s.
    *
    * @param v1     First Value
    * @param values Collection of values
    * @return The Lowest Value
    */
  def max(v1: jfxbv.ObservableNumberValue, values: jfxbv.ObservableNumberValue*) = (v1 /: values) (jfxbb.Bindings.max)

  /**
    * Returns the sum of a collection of $JFX
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ObservableNumberValue.html `ObservableNumberValue`]]s.
    *
    * @param v1     First Value
    * @param values Collection of values
    * @return The Value sum.
    */
  def add(v1: jfxbv.ObservableNumberValue, values: jfxbv.ObservableNumberValue*) = (v1 /: values) (jfxbb.Bindings.add)

  /**
    *
    * @param condition Function that returns a $JFX
    *                  [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ObservableBooleanValue.html `ObservableBooleanValue`]]
    * @return A ConditionBuilder wrapping `condition`.
    */
  def when(condition: => jfxbv.ObservableBooleanValue) = new ConditionBuilder(new jfxbb.When(condition))

  protected class ConditionBuilder(whenBuilder: jfxbb.When) {
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

  /**
    * Helper function to create a custom BooleanBinding.
    *
    * Wraps a JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/Bindings.html#createBooleanBinding-java.util.concurrent.Callable-javafx.beans.Observable...- Bindings.createBooleanBinding]].
    *
    * @param func         The function that calculates the value of this binding
    * @param dependencies The dependencies of this binding
    * @return The generated binding
    */
  def createBooleanBinding(func: () => Boolean, dependencies: Observable*): BooleanBinding = {
    import java.util.{concurrent => jfxuc}
    import javafx.beans.{binding => jfxbb}

    jfxbb.Bindings.createBooleanBinding(
      new jfxuc.Callable[java.lang.Boolean] {
        override def call() = func()
      },
      dependencies.map(_.delegate): _*)
  }

  /**
    * Helper function to create a custom DoubleBinding.
    *
    * Wraps a JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/Bindings.html#createDoubleBinding-java.util.concurrent.Callable-javafx.beans.Observable...- Bindings.createDoubleBinding]].
    *
    * @param func         The function that calculates the value of this binding
    * @param dependencies The dependencies of this binding
    * @return The generated binding
    */
  def createDoubleBinding(func: () => Double, dependencies: Observable*): jfxbb.DoubleBinding = {
    import java.util.{concurrent => jfxuc}
    import javafx.beans.{binding => jfxbb}

    jfxbb.Bindings.createDoubleBinding(
      new jfxuc.Callable[java.lang.Double] {
        override def call() = func()
      },
      dependencies.map(_.delegate): _*)
  }

  /**
    * Helper function to create a custom FloatBinding.
    *
    * Wraps a JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/Bindings.html#createFloatBinding-java.util.concurrent.Callable-javafx.beans.Observable...- Bindings.createFloatBinding]].
    *
    * @param func         The function that calculates the value of this binding
    * @param dependencies The dependencies of this binding
    * @return The generated binding
    */
  def createFloatBinding(func: () => Float, dependencies: Observable*): jfxbb.FloatBinding = {
    import java.util.{concurrent => jfxuc}
    import javafx.beans.{binding => jfxbb}

    jfxbb.Bindings.createFloatBinding(
      new jfxuc.Callable[java.lang.Float] {
        override def call() = func()
      },
      dependencies.map(_.delegate): _*)
  }

  /**
    * Helper function to create a custom IntegerBinding.
    *
    * Wraps a JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/Bindings.html#createIntegerBinding-java.util.concurrent.Callable-javafx.beans.Observable...- Bindings.createIntegerBinding]].
    *
    * @param func         The function that calculates the value of this binding
    * @param dependencies The dependencies of this binding
    * @return The generated binding
    */
  def createIntegerBinding(func: () => Int, dependencies: Observable*): jfxbb.IntegerBinding = {
    import java.util.{concurrent => jfxuc}
    import javafx.beans.{binding => jfxbb}

    jfxbb.Bindings.createIntegerBinding(
      new jfxuc.Callable[java.lang.Integer] {
        override def call() = func()
      },
      dependencies.map(_.delegate): _*)
  }


  /**
    * Helper function to create a custom LongBinding.
    *
    * Wraps a JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/Bindings.html#createLongBinding-java.util.concurrent.Callable-javafx.beans.Observable...- Bindings.createLongBinding]].
    *
    * @param func         The function that calculates the value of this binding
    * @param dependencies The dependencies of this binding
    * @return The generated binding
    */
  def createLongBinding(func: () => Long, dependencies: Observable*): jfxbb.LongBinding = {
    import java.util.{concurrent => jfxuc}
    import javafx.beans.{binding => jfxbb}

    jfxbb.Bindings.createLongBinding(
      new jfxuc.Callable[java.lang.Long] {
        override def call() = func()
      },
      dependencies.map(_.delegate): _*)
  }

  /**
    * Helper function to create a custom ObjectBinding.
    *
    * Wraps a JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/Bindings.html#createObjectBinding-java.util.concurrent.Callable-javafx.beans.Observable...- Bindings.createObjectBinding]].
    *
    * @param func         The function that calculates the value of this binding
    * @param dependencies The dependencies of this binding
    * @return The generated binding
    */
  def createObjectBinding[T](func: () => T, dependencies: Observable*): ObjectBinding[T] = {
    import java.util.{concurrent => jfxuc}
    import javafx.beans.{binding => jfxbb}

    jfxbb.Bindings.createObjectBinding(
      new jfxuc.Callable[T] {
        override def call() = func()
      },
      dependencies.map(_.delegate): _*)
  }

  /**
    * Helper function to create a custom StringBinding.
    *
    * Wraps a JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/Bindings.html#createStringBinding-java.util.concurrent.Callable-javafx.beans.Observable...- Bindings.createStringBinding]].
    *
    * @param func         The function that calculates the value of this binding
    * @param dependencies The dependencies of this binding
    * @return The generated binding
    */
  def createStringBinding(func: () => String, dependencies: Observable*): StringBinding = {
    import java.util.{concurrent => jfxuc}
    import javafx.beans.{binding => jfxbb}

    jfxbb.Bindings.createStringBinding(
      new jfxuc.Callable[String] {
        override def call() = func()
      },
      dependencies.map(_.delegate): _*)
  }
}