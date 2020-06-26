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
import javafx.{util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, ObjectProperty, ReadOnlyObjectProperty, StringProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.util.Duration

import scala.language.implicitConversions


object Spinner {

  implicit def sfxSpinner2jfx[T](v: Spinner[T]): jfxsc.Spinner[T] = if (v != null) v.delegate else null


  /** The arrows are placed on the right of the Spinner, pointing horizontally (i.e. left and right). */
  val StyleClassArrowsOnRightHorizontal: String = jfxsc.Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL

  /** The arrows are placed on the left of the Spinner, pointing vertically (i.e. up and down). */
  val StyleClassArrowsOnLeftVertical: String = jfxsc.Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL

  /** The arrows are placed on the left of the Spinner, pointing horizontally (i.e. left and right). */
  val StyleClassArrowsOnLeftHorizontal: String = jfxsc.Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL

  /** The arrows are placed above and beneath the spinner, stretching to take the entire width. */
  val StyleClassSplitArrowsVertical: String = jfxsc.Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL

  /** The decrement arrow is placed on the left of the Spinner, and the increment on the right. */
  val StyleClassSplitArrowsHorizontal: String = jfxsc.Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL

}

/**
  * A single line text field that lets the user select a number or an object
  * value from an ordered sequence.
  *
  * Wraps a $JFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Spinner.html]].
  *
  * @constructor Constructs a default Spinner instance, with the default 'spinner' style class and a non-editable editor.
  * @param delegate A JavaFX Spinner to be wrapped. Its default value is a new JavaFX Spinner.
  * @tparam T The type of all values that can be iterated through in the Spinner. Common types include Integer and String.
  *
  */
class Spinner[T](override val delegate: jfxsc.Spinner[T] = new jfxsc.Spinner[T])
  extends Control(delegate)
    with SFXDelegate[jfxsc.Spinner[T]] {

  /**
    * Creates a Spinner instance with the value factory set to be an instance
    * of `IntegerSpinnerValueFactory`. Note that
    * if this constructor is called, the only valid generic type for the
    * Spinner instance is Integer, i.e. Spinner[Integer].
    *
    * @param min          The minimum allowed integer value for the Spinner.
    * @param max          The maximum allowed integer value for the Spinner.
    * @param initialValue The value of the Spinner when first instantiated, must
    *                     be within the bounds of the min and max arguments, or
    *                     else the min value will be used.
    */
  def this(min: Int, max: Int, initialValue: Int) = {
    this(new jfxsc.Spinner[T](min, max, initialValue))
  }

  /**
    * Creates a Spinner instance with the value factory set to be an instance
    * of `IntegerSpinnerValueFactory`. Note that
    * if this constructor is called, the only valid generic type for the
    * Spinner instance is Integer, i.e. Spinner[Integer].
    *
    * @param min            The minimum allowed integer value for the Spinner.
    * @param max            The maximum allowed integer value for the Spinner.
    * @param initialValue   The value of the Spinner when first instantiated, must
    *                       be within the bounds of the min and max arguments, or
    *                       else the min value will be used.
    * @param amountToStepBy The amount to increment or decrement by, per step.
    */
  def this(min: Int, max: Int, initialValue: Int, amountToStepBy: Int) = {
    this(new jfxsc.Spinner[T](min, max, initialValue, amountToStepBy))
  }

  /**
    * Creates a Spinner instance with the value factory set to be an instance
    * of `DoubleSpinnerValueFactory`. Note that
    * if this constructor is called, the only valid generic type for the
    * Spinner instance is Double, i.e. Spinner[Double].
    *
    * @param min          The minimum allowed double value for the Spinner.
    * @param max          The maximum allowed double value for the Spinner.
    * @param initialValue The value of the Spinner when first instantiated, must
    *                     be within the bounds of the min and max arguments, or
    *                     else the min value will be used.
    */
  def this(min: Double, max: Double, initialValue: Double) = {
    this(new jfxsc.Spinner[T](min, max, initialValue))
  }

  /**
    * Creates a Spinner instance with the value factory set to be an instance
    * of `DoubleSpinnerValueFactory`. Note that
    * if this constructor is called, the only valid generic type for the
    * Spinner instance is Double, i.e. Spinner[Double].
    *
    * @param min            The minimum allowed double value for the Spinner.
    * @param max            The maximum allowed double value for the Spinner.
    * @param initialValue   The value of the Spinner when first instantiated, must
    *                       be within the bounds of the min and max arguments, or
    *                       else the min value will be used.
    * @param amountToStepBy The amount to increment or decrement by, per step.
    */
  def this(min: Double, max: Double, initialValue: Double, amountToStepBy: Double) = {
    this(new jfxsc.Spinner[T](min, max, initialValue, amountToStepBy))
  }

  /**
    * Creates a Spinner instance with the value factory set to be an instance
    * of `ListSpinnerValueFactory`. The
    * Spinner `value` property will be set to the first
    * element of the list, if an element exists, or null otherwise.
    *
    * @param items A list of items that will be stepped through in the Spinner.
    */
  def this(items: ObservableBuffer[T]) = {
    this(new jfxsc.Spinner[T](items))
  }

  /**
    * Creates a Spinner instance with the given value factory set.
    *
    * @param valueFactory The value factory to use.
    */
  def this(valueFactory: SpinnerValueFactory[T]) = {
    this(new jfxsc.Spinner[T](valueFactory.delegate))
  }

  /**
    * The value property on Spinner is a read-only property, as it is bound to
    * the SpinnerValueFactory [[scalafx.scene.control.Spinner#valueFactory() valueFactory property]].
    * Should the value factory change, this value property
    * will be unbound from the old value factory and bound to the new one.
    *
    * <p>If developers wish to modify the value property, they may do so with
    * code in the following form:
    *
    * {{{
    * val newValue = ...;
    * spinner.valueFactory().value = newValue
    * }}}
    */
  def value: ReadOnlyObjectProperty[T] = delegate.valueProperty()

  /**
    * The value factory is the model behind the JavaFX Spinner control - without
    * a value factory installed a Spinner is unusable. It is the role of the
    * value factory to handle almost all aspects of the Spinner.
    *
    */
  def valueFactory: ObjectProperty[jfxsc.SpinnerValueFactory[T]] = delegate.valueFactoryProperty()

  def valueFactory_=(value: SpinnerValueFactory[T]): Unit = {
    valueFactory() = value
  }

  /**
    * The editable property is used to specify whether user input is able to
    * be typed into the Spinner `editor`. If editable
    * is true, user input will be received once the user types and presses
    * the Enter key. At this point the input is passed to the
    * SpinnerValueFactory `converter` StringConverter#fromString(String) method.
    * The returned value from this call (of type T) is then sent to the
    * `SpinnerValueFactory#setValue(Object)` method. If the value
    * is valid, it will remain as the value. If it is invalid, the value factory
    * will need to react accordingly and back out this change.
    */
  def editable: BooleanProperty = delegate.editableProperty()
  def editable_=(value: Boolean): Unit = {
    editable() = value
  }

  /**
    * The prompt text to display in the `Spinner`, or
    * `null` if no prompt text is displayed.
    *
    * @return the prompt text property
    * @since 9
    */
  def promptText: StringProperty = delegate.promptTextProperty()
  def promptText_=(value: String): Unit = {
    promptText() = value
  }

  /**
    * The duration that the mouse has to be pressed on an arrow button before the next value steps.
    * Successive step duration is set using [[scalafx.scene.control.Spinner#repeatDelay() repeat delay]].
    *
    * @return the initial delay property
    * @since 11
    */
  def initialDelay: ObjectProperty[jfxu.Duration] = delegate.initialDelayProperty()
  def initialDelay_=(value: Duration): Unit = {
    initialDelay() = value
  }

  /**
    * The duration that the mouse has to be pressed for each successive step after the first value steps.
    * Initial step duration is set using [[scalafx.scene.control.Spinner#initialDelay() initial delay]].
    *
    * @return the repeat delay property
    * @since 11
    */
  def repeatDelay: ObjectProperty[jfxu.Duration] = delegate.repeatDelayProperty()
  def repeatDelay_=(value: Duration): Unit = {
    repeatDelay() = value
  }


  def editor: ReadOnlyObjectProperty[jfxsc.TextField] = delegate.editorProperty()


}
