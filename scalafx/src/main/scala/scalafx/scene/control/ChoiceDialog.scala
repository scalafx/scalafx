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
import scalafx.Includes._
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scala.collection.JavaConverters._
import scala.language.implicitConversions

object ChoiceDialog {

  /**
    * Converts a ScalaFX ChoiceDialog to its JavaFX counterpart.
    *
    * @param v ScalaFX ChoiceDialog
    * @return JavaFX ChoiceDialog
    */
  implicit def sfxChoiceDialog2jfx[T](v: ChoiceDialog[T]): jfxsc.ChoiceDialog[T] =
    if (v != null) v.delegate else null
}

/**
  * A dialog that shows a list of choices to the user, from which they can pick
  * one item at most.
  *
  * Wraps a $JFX [[ $URL0 $TC]].
  *
  * @see Dialog
  * @tparam T The type of the items to show to the user, and the type that is returned
  *           via `result` when the dialog is dismissed.
  * @constructor Creates a default, empty instance of ChoiceDialog with no set items and a
  *              null default choice. Users of this constructor will subsequently need to
  *              call `items` to specify which items to show to the user.
  * @define TC   ChoiceDialog
  * @define URL0 https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx.scene.control/ChoiceDialog.html
  * @define JFX  JavaFX
  */
class ChoiceDialog[T](override val delegate: jfxsc.ChoiceDialog[T] = new jfxsc.ChoiceDialog[T]())
    extends Dialog[T](delegate)
    with SFXDelegate[jfxsc.ChoiceDialog[T]] {

  /**
    * Creates a new ChoiceDialog instance with the first argument specifying the
    * default choice that should be shown to the user, and the second argument
    * specifying a collection of all available choices for the user. It is
    * expected that the defaultChoice be one of the elements in the choices
    * collection. If this is not true, then defaultChoice will be set to null and the
    * dialog will show with the initial choice set to the first item in the list
    * of choices.
    *
    * @param defaultChoice The item to display as the pre-selected choice in the dialog.
    *                      This item must be contained within the choices varargs array.
    * @param choices All possible choices to present to the user.
    */
  def this(defaultChoice: T, choices: Iterable[T]) =
    this(new jfxsc.ChoiceDialog[T](defaultChoice, choices.asJavaCollection))

  /**
    * Shows the dialog and waits for the user response (in other words, brings
    * up a blocking dialog, with the returned value the users input).
    *
    * {{{
    *   dialog.showAndWait()
    * }}}
    * Or when return value is required:
    * {{{
    *   val r = dialog.showAndWait()
    *   r match {
    *     case Some(v) => ...
    *     case None    => ...
    *   }
    * }}}
    *
    * @return An `Option` that contains the `result`.
    */
  def showAndWait(): Option[T] = {
    super.showAndWait((x: T) => x).asInstanceOf[Option[T]]
  }

  /**
    * Returns the property representing the currently selected item in the dialog.
    */
  def selectedItem: ReadOnlyObjectProperty[T] = delegate.selectedItemProperty

  /**
    * Sets the currently selected item in the dialog.
    * @param item The item to select in the dialog.
    */
  def selectedItem_=(item: T): Unit = {
    delegate.setSelectedItem(item)
  }

  /**
    * Returns the buffer of all items that will be displayed to users. This buffer
    * can be modified by the developer to add, remove, or reorder the items
    * to present to the user.
    */
  def items: ObservableBuffer[T] = delegate.getItems

  /**
    * Returns the default choice that was specified in the constructor.
    */
  def defaultChoice: T = delegate.getDefaultChoice

}
