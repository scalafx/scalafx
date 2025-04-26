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

package scalafx.scene.control

import javafx.scene.control as jfxsc
import javafx.util as jfxu
import scalafx.Includes.*
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

import java.util.function.UnaryOperator
import scala.language.implicitConversions

object TextFormatter {

  /**
   * Converts a ScalaFX TextFormatter to its JavaFX counterpart.
   *
   * @param v ScalaFX TextFormatter
   * @return JavaFX TextFormatter
   */
  implicit def sfxTextFormatter2jfx[V](v: TextFormatter[V]): jfxsc.TextFormatter[V] =
    if (v != null) v.delegate else null

  /**
   * This string converter converts the text to the same String value. This might be useful for cases where you
   * want to manipulate with the text through the value or you need to provide a default text value.
   */
  val IdentityStringConverter: StringConverter[String] = jfxsc.TextFormatter.IDENTITY_STRING_CONVERTER

  object Change {
    implicit def sfxTextFormatterChange2jfx[V](v: Change): jfxsc.TextFormatter.Change =
      if (v != null) v.delegate else null
  }

  /**
   * Contains the state representing a change in the content or selection for a
   * `TextInputControl`.
   *
   * Wraps a JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx/scene/control/TextFormatter.Change.html]]
   */
  class Change(override val delegate: jfxsc.TextFormatter.Change)
      extends SFXDelegate[jfxsc.TextFormatter.Change] {

    /**
     * Gets the control associated with this change.
     * @return The control associated with this change. This will never be null.
     */
    def control: Control = delegate.getControl

    /**
     * Gets the start index into the `TextInputControl.text`
     * for the modification. This will always be a value &gt; 0 and
     * &lt;= `TextInputControl.length`.
     *
     * @return The start index
     */
    def rangeStart: Int = delegate.getRangeStart

    /**
     * Gets the end index into the `TextInputControl.text`
     * for the modification. This will always be a value &gt; `angeStart` and
     * &lt;= `TextInputControl.length`.
     *
     * @return The end index
     */
    def rangeEnd: Int = delegate.getRangeEnd

    /**
     * Gets the new caret position. This value will always be &gt; 0 and
     * &lt;= `controlNewText.Length`
     *
     * @return The new caret position
     */
    def caretPosition: Int = delegate.getCaretPosition

    /**
     * Sets the caret position. The caret position value must be &gt; 0 and
     * &lt;= `controlNewText.Length`. Note that there
     * is an order dependence here, in that the position should be
     * specified after the new text has been specified.
     *
     * @param newCaretPosition The new caret position
     */
    def caretPosition_=(newCaretPosition: Int): Unit = { delegate.setCaretPosition(newCaretPosition) }

    /**
     * Gets the new anchor. This value will always be &gt; 0 and
     * &lt;= `controlNewText.Length`
     *
     * @return The new anchor position
     */
    def anchor: Int = delegate.getAnchor

    /**
     * Sets the anchor. The anchor value must be &gt; 0 and
     * &lt;= `controlNewText.Length`. Note that there
     * is an order dependence here, in that the position should be
     * specified after the new text has been specified.
     *
     * @param newAnchor The new anchor position
     */
    def anchor_=(newAnchor: Int): Unit = { delegate.setAnchor(newAnchor) }

    /**
     * Gets the current caret position of the control.
     * @return The previous caret position
     */
    def controlCaretPosition: Int = delegate.getControlCaretPosition

    /**
     * Gets the current anchor position of the control.
     * @return The previous anchor
     */
    def controlAnchor: Int = delegate.getControlAnchor

    /**
     * Gets the selection of this change. Note that the selection range refers to `controlNewText`, not
     * the current control text.
     * @return The selected range of this change.
     */
    def selection: IndexRange = delegate.getSelection

    /**
     * Gets the text used in this change. For example, this may be new
     * text being added, or text which is replacing all the control's text
     * within the range of start and end. Typically it is an empty string
     * only for cases where the range is being deleted.
     *
     * @return The text involved in this change. This will never be null.
     */
    def text: String = delegate.getText

    /**
     * Sets the text to use in this change. This is used to replace the
     * range from start to end, if such a range exists, or to insert text
     * at the position represented by start == end.
     *
     * @param value The text. This cannot be null.
     */
    def text_=(value: String): Unit = { delegate.setText(value) }

    /**
     * This is the full text that control has before the change. To get the text
     * after this change, use `controlNewText`.
     * @return the previous text of control
     */
    def controlText: String = delegate.getControlText

    /**
     * Gets the complete new text which will be used on the control after
     * this change. Note that some controls (such as TextField) may do further
     * filtering after the change is made (such as stripping out newlines)
     * such that you cannot assume that the newText will be exactly the same
     * as what is finally set as the content on the control, however it is
     * correct to assume that this is the case for the purpose of computing
     * the new caret position and new anchor position (as those values supplied
     * will be modified as necessary after the control has stripped any
     * additional characters that the control might strip).
     *
     * @return The controls proposed new text at the time of this call, according
     *         to the state set for start, end, and text properties on this Change object.
     */
    def controlNewText: String = delegate.getControlNewText
  }

  private def toUnaryOperator(op: (TextFormatter.Change) => TextFormatter.Change)
    : UnaryOperator[jfxsc.TextFormatter.Change] =
    new UnaryOperator[jfxsc.TextFormatter.Change] {
      override def apply(a: jfxsc.TextFormatter.Change): jfxsc.TextFormatter.Change = op(new TextFormatter.Change(a))
    }
}

/**
 * A Formatter describes a format of a `TextInputControl` text.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * @define TC TextFormatter
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx/scene/control/TextFormatter.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class TextFormatter[V](override val delegate: jfxsc.TextFormatter[V])
    extends SFXDelegate[jfxsc.TextFormatter[V]] {

  /**
   * Creates a new Formatter with the provided filter.
   * @param filter The filter to use in this formatter or null
   */
  def this(filter: UnaryOperator[jfxsc.TextFormatter.Change]) =
    this(delegate = new jfxsc.TextFormatter(filter))

  /**
   * Creates a new Formatter with the provided filter.
   * @param filter The filter that can modify the change.
   */
  def this(filter: (TextFormatter.Change) => TextFormatter.Change) =
    this(delegate = new jfxsc.TextFormatter(TextFormatter.toUnaryOperator(filter)))

  /**
   * Creates a new Formatter with the provided filter, value converter and default value.
   * @param valueConverter The value converter to use in this formatter or null.
   * @param defaultValue the default value.
   * @param filter The filter to use in this formatter or null
   */
  def this(
    valueConverter: jfxu.StringConverter[V],
    defaultValue: V,
    filter: UnaryOperator[jfxsc.TextFormatter.Change]
  ) =
    this(new jfxsc.TextFormatter(valueConverter, defaultValue, filter))

  /**
   * Creates a new Formatter with the provided filter, value converter and default value.
   * @param valueConverter The value converter to use in this formatter or null.
   * @param defaultValue the default value.
   * @param filter The filter that can modify the change.
   */
  def this(
    valueConverter: jfxu.StringConverter[V],
    defaultValue: V,
    filter: (TextFormatter.Change) => TextFormatter.Change
  ) =
    this(new jfxsc.TextFormatter(valueConverter, defaultValue, TextFormatter.toUnaryOperator(filter)))

  /**
   * Creates a new Formatter with the provided value converter and default value.
   * @param valueConverter The value converter to use in this formatter. This must not be null.
   * @param defaultValue the default value
   */
  def this(valueConverter: jfxu.StringConverter[V], defaultValue: V) =
    this(new jfxsc.TextFormatter(valueConverter, defaultValue))

  /**
   * Creates a new Formatter with the provided value converter. The default value will be null.
   * @param valueConverter The value converter to use in this formatter. This must not be null.
   */
  def this(valueConverter: StringConverter[V]) =
    this(new jfxsc.TextFormatter(valueConverter))

  /**
   * The converter between the values and text.
   */
  def valueConverter: StringConverter[V] = delegate.getValueConverter

  /**
   * Filter allows user to intercept and modify any change done to the text content.
   */
  def filter: UnaryOperator[jfxsc.TextFormatter.Change] = delegate.getFilter

  /**
   * The current value for this formatter. When the formatter is set on a `TextInputControl` and has a
   * `valueConverter`, the value is set by the control, when the text is committed.
   */
  def value: ObjectProperty[V] = delegate.valueProperty
  def value_=(v: V): Unit      = { delegate.valueProperty.setValue(v) }
}
