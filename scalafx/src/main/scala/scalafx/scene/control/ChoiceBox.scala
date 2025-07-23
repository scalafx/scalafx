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
import javafx.{collections as jfxc, event as jfxe, util as jfxu}
import scalafx.Includes.*
import scalafx.beans.property.{ObjectProperty, ReadOnlyBooleanProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.event.EventType
import scalafx.util.StringConverter

import scala.language.implicitConversions

object ChoiceBox {
  implicit def sfxChoiceBox2jfx[J <: Any](cb: ChoiceBox[J]): jfxsc.ChoiceBox[J] = if (cb != null) cb.delegate else null

  /** Called when the ChoiceBox popup has been hidden. */
  val OnHidden: EventType[jfxe.Event] = jfxsc.ChoiceBox.ON_HIDDEN

  /** Called when the ChoiceBox popup '''will''' be hidden. */
  val OnHiding: EventType[jfxe.Event] = jfxsc.ChoiceBox.ON_HIDING

  /** Called prior to the ChoiceBox showing its popup after the user has clicked or otherwise interacted with the ChoiceBox. */
  val OnShowing: EventType[jfxe.Event] = jfxsc.ChoiceBox.ON_SHOWING

  /** Called after the ChoiceBox has shown its popup. */
  val OnShown: EventType[jfxe.Event] = jfxsc.ChoiceBox.ON_SHOWN
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ChoiceBox.html]].
 */
class ChoiceBox[J <: Any](override val delegate: jfxsc.ChoiceBox[J] = new jfxsc.ChoiceBox[J])
    extends Control(delegate)
    with SFXDelegate[jfxsc.ChoiceBox[J]] {

  /**
   * Create a new ChoiceBox with the given set of items.
   */
  def this(items: ObservableBuffer[J]) = this(new jfxsc.ChoiceBox[J](items))

  /**
   * Allows a way to specify how to represent objects in the items list.
   */
  def converter: ObjectProperty[jfxu.StringConverter[J]] = delegate.converterProperty

  def converter_=(v: StringConverter[J]): Unit = {
    converter() = v
  }

  /**
   * The items to display in the choice box.
   */
  def items: ObjectProperty[jfxc.ObservableList[J]] = delegate.itemsProperty

  def items_=(v: ObservableBuffer[J]): Unit = {
    items() = v
  }

  /**
   * The selection model for the ChoiceBox.
   */
  def selectionModel: ObjectProperty[jfxsc.SingleSelectionModel[J]] = delegate.selectionModelProperty

  def selectionModel_=(v: SingleSelectionModel[J]): Unit = {
    selectionModel() = v
  }

  /**
   * Indicates whether the drop down is displaying the list of choices to the
   * user. Although showing be a ReadOnlyBooleanProperty, a setter method is
   * implemented using `show()` and `hide()` method from ChoiceBox JavaFX.
   */
  def showing: ReadOnlyBooleanProperty = delegate.showingProperty

  def showing_=(show: Boolean): Unit = {
    if (show) delegate.show()
    else delegate.hide()
  }

  /**
   * The value of this ChoiceBox is defined as the selected item in the
   * ChoiceBox selection model.
   */
  def value: ObjectProperty[J] = delegate.valueProperty

  def value_=(v: J): Unit = {
    value() = v
  }

  /**
   * The ChoiceBox action, which is invoked whenever the ChoiceBox value property is changed.
   */
  def onAction: ObjectProperty[jfxe.EventHandler[jfxe.ActionEvent]] = delegate.onActionProperty

  def onAction_=(aeh: jfxe.EventHandler[jfxe.ActionEvent]): Unit = {
    onAction() = aeh
  }

  /**
   * Called just prior to the ChoiceBox popup being shown.
   */
  def onShowing: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onShowingProperty

  def onShowing_=(aeh: jfxe.EventHandler[jfxe.Event]): Unit = {
    onShowing() = aeh
  }

  /**
   * Called just after the ChoiceBox popup is shown.
   */
  def onShown: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onShownProperty

  def onShown_=(aeh: jfxe.EventHandler[jfxe.Event]): Unit = {
    onShown() = aeh
  }

  /**
   * Called just prior to the ChoiceBox popup being hidden.
   */
  def onHiding: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onHidingProperty

  def onHiding_=(aeh: jfxe.EventHandler[jfxe.Event]): Unit = {
    onHiding() = aeh
  }

  /**
   * Called just after the ChoiceBox popup has been hidden.
   */
  def onHidden: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onHiddenProperty

  def onHidden_=(aeh: jfxe.EventHandler[jfxe.Event]): Unit = {
    onHidden() = aeh
  }

}
