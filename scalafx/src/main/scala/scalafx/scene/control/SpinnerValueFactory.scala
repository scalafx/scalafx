/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

package scalafx.scene.control


import javafx.scene.{control => jfxsc}
import javafx.{collections => jfxc, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, IntegerProperty, ObjectProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

import scala.language.implicitConversions


object SpinnerValueFactory {

  implicit def sfxSpinnerValueFactory2jfx[T](v: SpinnerValueFactory[T]): jfxsc.SpinnerValueFactory[T] =
    if (v != null) v.delegate else null

  object ListSpinnerValueFactory {
    implicit def sfxListSpinnerValueFactory2jfx[T](v: ListSpinnerValueFactory[T]): jfxsc.SpinnerValueFactory.ListSpinnerValueFactory[T] =
      if (v != null) v.delegate else null
  }


  /**
   * A SpinnerValueFactory implementation designed to iterate through
   * a list of values.
   *
   *
   * @tparam T The type of the elements in the List.
   */
  class ListSpinnerValueFactory[T](override val delegate: jfxsc.SpinnerValueFactory.ListSpinnerValueFactory[T])
    extends SpinnerValueFactory(delegate)
    with SFXDelegate[jfxsc.SpinnerValueFactory.ListSpinnerValueFactory[T]] {

    /**
     * Creates a new instance of the ListSpinnerValueFactory with the given
     * list used as the list to step through.
     *
     * @param items The list of items to step through with the Spinner.
     */
    def this(items: ObservableBuffer[T]) = {
      this(new jfxsc.SpinnerValueFactory.ListSpinnerValueFactory(items.delegate))
    }

    /**
     * The underlying data model for the ListView. Note that it has a generic
     * type that must match the type of the ListView itself.
     */
    def items: ObjectProperty[jfxc.ObservableList[T]] = delegate.itemsProperty

    def items_=(v: ObservableBuffer[T]): Unit = {
      items() = v
    }
  }

  object IntegerSpinnerValueFactory {
    implicit def sfxIntegerSpinnerValueFactory2jfx(v: IntegerSpinnerValueFactory): jfxsc.SpinnerValueFactory.IntegerSpinnerValueFactory =
      if (v != null) v.delegate else null
  }

  class IntegerSpinnerValueFactory(override val delegate: jfxsc.SpinnerValueFactory.IntegerSpinnerValueFactory)
    extends SpinnerValueFactory[Integer](delegate)
    with SFXDelegate[jfxsc.SpinnerValueFactory.IntegerSpinnerValueFactory] {

    /**
     * Constructs a new IntegerSpinnerValueFactory that sets the initial value
     * to be equal to the min value, and a default `amountToStepBy` of one.
     *
     * @param min The minimum allowed integer value for the Spinner.
     * @param max The maximum allowed integer value for the Spinner.
     */
    def this(min: Int, max: Int) = {
      this(new jfxsc.SpinnerValueFactory.IntegerSpinnerValueFactory(min, max))
    }

    /**
     * Constructs a new IntegerSpinnerValueFactory with a default
     * `amountToStepBy` of one.
     *
     * @param min The minimum allowed integer value for the Spinner.
     * @param max The maximum allowed integer value for the Spinner.
     * @param initialValue The value of the Spinner when first instantiated, must
     *                     be within the bounds of the min and max arguments, or
     *                     else the min value will be used.
     */
    def this(min: Int, max: Int, initialValue: Int) = {
      this(new jfxsc.SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initialValue))
    }

    /**
     * Constructs a new IntegerSpinnerValueFactory.
     *
     * @param min The minimum allowed integer value for the Spinner.
     * @param max The maximum allowed integer value for the Spinner.
     * @param initialValue The value of the Spinner when first instantiated, must
     *                     be within the bounds of the min and max arguments, or
     *                     else the min value will be used.
     * @param amountToStepBy The amount to increment or decrement by, per step.
     */
    def this(min: Int, max: Int, initialValue: Int, amountToStepBy: Int) = {
      this(new jfxsc.SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initialValue, amountToStepBy))
    }

    /**
     * Sets the minimum allowable value for this value factory
     */
    def min: IntegerProperty = delegate.minProperty

    def min_=(value: Int): Unit = {
      min() = value
    }

    /**
     * Sets the maximum allowable value for this value factory
     */
    def max: IntegerProperty = delegate.maxProperty

    def max_=(value: Int): Unit = {
      max() = value
    }

    /**
     * Sets the amount to increment or decrement by, per step.
     */
    def amountToStepBy: IntegerProperty = delegate.amountToStepByProperty

    def amountToStepBy_=(value: Int): Unit = {
      amountToStepBy() = value
    }
  }

  object DoubleSpinnerValueFactory {
    implicit def sfxDoubleSpinnerValueFactory2jfx(v: DoubleSpinnerValueFactory): jfxsc.SpinnerValueFactory.DoubleSpinnerValueFactory =
      if (v != null) v.delegate else null
  }


  /**
   * A `SpinnerValueFactory` implementation designed to iterate through
   * double values.
   *
   */
  class DoubleSpinnerValueFactory(override val delegate: jfxsc.SpinnerValueFactory.DoubleSpinnerValueFactory)
    extends SpinnerValueFactory(delegate)
    with SFXDelegate[jfxsc.SpinnerValueFactory.DoubleSpinnerValueFactory] {

    /**
     * Constructs a new DoubleSpinnerValueFactory that sets the initial value
     * to be equal to the min value, and a default `amountToStepBy` of
     * one.
     *
     * @param min The minimum allowed double value for the Spinner.
     * @param max The maximum allowed double value for the Spinner.
     */
    def this(min: Double, max: Double) = {
      this(new jfxsc.SpinnerValueFactory.DoubleSpinnerValueFactory(min, max))
    }

    /**
     * Constructs a new DoubleSpinnerValueFactory with a default
     * `amountToStepBy` of one.
     *
     * @param min The minimum allowed double value for the Spinner.
     * @param max The maximum allowed double value for the Spinner.
     * @param initialValue The value of the Spinner when first instantiated, must
     *                     be within the bounds of the min and max arguments, or
     *                     else the min value will be used.
     */
    def this(min: Double, max: Double, initialValue: Double) = {
      this(new jfxsc.SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, initialValue))
    }

    /**
     * Constructs a new DoubleSpinnerValueFactory.
     *
     * @param min The minimum allowed double value for the Spinner.
     * @param max The maximum allowed double value for the Spinner.
     * @param initialValue The value of the Spinner when first instantiated, must
     *                     be within the bounds of the min and max arguments, or
     *                     else the min value will be used.
     * @param amountToStepBy The amount to increment or decrement by, per step.
     */
    def this(min: Double, max: Double, initialValue: Double, amountToStepBy: Double) = {
      this(new jfxsc.SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, initialValue, amountToStepBy))
    }

    /**
     * Sets the minimum allowable value for this value factory
     */
    def min: DoubleProperty = delegate.minProperty

    def min_=(value: Double): Unit = {
      min() = value
    }

    /**
     * Sets the maximum allowable value for this value factory
     */
    def max: DoubleProperty = delegate.maxProperty

    def max_=(value: Double): Unit = {
      max() = value
    }

    /**
     * Sets the amount to increment or decrement by, per step.
     */
    def amountToStepBy: DoubleProperty = delegate.amountToStepByProperty

    def amountToStepBy_=(value: Double): Unit = {
      amountToStepBy() = value
    }
  }

}

/**
 * The SpinnerValueFactory is the model behind the `Spinner` control - without a value factory installed a
 * `Spinner` is unusable.
 *
 * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SpinnerValueFactory.html]].
 *
 * @param delegate A JavaFX SpinnerValueFactory to be wrapped. Its default value is a new JavaFX SpinnerValueFactory.
 * @tparam T The type of the data this value factory deals with, which must
 *           coincide with the type of the Spinner that the value factory is set on.
 */
abstract class SpinnerValueFactory[T](override val delegate: jfxsc.SpinnerValueFactory[T])
  extends SFXDelegate[jfxsc.SpinnerValueFactory[T]] {

  /**
   * Represents the current value of the SpinnerValueFactory, or null if no
   * value has been set.
   */
  def value: ObjectProperty[T] = delegate.valueProperty()
  def value_=(newValue: T): Unit = {
    value() = newValue
  }

  /**
   * Converts the user-typed input (when the Spinner is `editable`) to an object of type T,
   * such that the input may be retrieved via the  `value`
   * property.
   */
  def converter: ObjectProperty[jfxu.StringConverter[T]] = delegate.converterProperty()
  def converter_=(newValue: StringConverter[T]): Unit = {
    converter() = newValue
  }

  /**
   * The wrapAround property is used to specify whether the value factory should
   * be circular. For example, should an integer-based value model increment
   * from the maximum value back to the minimum value (and vice versa).
   */
  def wrapAround: BooleanProperty = delegate.wrapAroundProperty()
  def wrapAround_=(value: Boolean): Unit = {
    wrapAround() = value
  }

}

