/*
 * Copyright (c) 2011-2021, ScalaFX Project
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

import javafx.scene.{control => jfxsc, input => jfxsi}
import javafx.{event => jfxe, scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, ObjectProperty, ReadOnlyObjectProperty, StringProperty}
import scalafx.collections.ObservableMap
import scalafx.css.Styleable
import scalafx.delegate.{FireDelegate, SFXDelegate}
import scalafx.event.EventHandlerDelegate1
import scalafx.scene.Node
import scalafx.scene.input.KeyCombination

import scala.language.implicitConversions

object MenuItem {
  implicit def sfxMenuItem2jfx(m: MenuItem): jfxsc.MenuItem = if (m != null) m.delegate else null
}

class MenuItem(override val delegate: jfxsc.MenuItem = new jfxsc.MenuItem)
    extends jfxe.EventTarget
    with Styleable
    with EventHandlerDelegate1
    with FireDelegate[jfxsc.MenuItem]
    with SFXDelegate[jfxsc.MenuItem] {

  /**
   * Constructs a MenuItem and sets the display text with the specified text
   */
  def this(text: String) = this(new jfxsc.MenuItem(text))

  /**
   * Constructor s MenuItem and sets the display text with the specified text and sets the graphic Node to the given
   * node.
   */
  def this(text: String, graphic: Node) = this(new jfxsc.MenuItem(text, graphic))

  /**
   */
  def accelerator: ObjectProperty[jfxsi.KeyCombination] = delegate.acceleratorProperty

  def accelerator_=(v: KeyCombination): Unit = {
    accelerator() = v
  }

  /**
   */
  def disable: BooleanProperty = delegate.disableProperty

  def disable_=(v: Boolean): Unit = {
    disable() = v
  }

  /**
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty

  def graphic_=(v: Node): Unit = {
    graphic() = v
  }

  /**
   */
  def id: StringProperty = delegate.idProperty

  def id_=(v: String): Unit = {
    id() = v
  }

  /**
   * MnemonicParsing property to enable/disable text parsing.
   */
  def mnemonicParsing: BooleanProperty = delegate.mnemonicParsingProperty

  def mnemonicParsing_=(v: Boolean): Unit = {
    mnemonicParsing() = v
  }

  /**
   */
  def onAction: ObjectProperty[jfxe.EventHandler[jfxe.ActionEvent]] = delegate.onActionProperty

  def onAction_=(v: jfxe.EventHandler[jfxe.ActionEvent]): Unit = {
    onAction() = v
  }

  /**
   */
  def parentMenu: ReadOnlyObjectProperty[jfxsc.Menu] = delegate.parentMenuProperty

  /**
   */
  def parentPopup: ReadOnlyObjectProperty[jfxsc.ContextMenu] = delegate.parentPopupProperty

  /**
   */
  def style: StringProperty = delegate.styleProperty

  def style_=(v: String): Unit = {
    style() = v
  }

  /**
   */
  def text: StringProperty = delegate.textProperty

  def text_=(v: String): Unit = {
    text() = v
  }

  /**
   */
  def visible: BooleanProperty = delegate.visibleProperty

  def visible_=(v: Boolean): Unit = {
    visible() = v
  }

  /**
   * Returns an observable map of properties on this menu item for use primarily by application developers.
   */
  def properties: ObservableMap[AnyRef, AnyRef] = delegate.getProperties

  /**
   * Returns a previously set Object property, or null if no such property has been set using the
   * setUserData(java.lang.Object) method.
   */
  def userData: AnyRef = delegate.getUserData

  def userData_=(v: AnyRef): Unit = {
    delegate.setUserData(v)
  }

  /**
   * The event handler that is associated with invocation of an accelerator for a MenuItem. This can happen when a key
   * sequence for an accelerator is pressed. The event handler is also invoked when onShowing event handler is called.
   *
   * @since
   *   2.2
   */
  def onMenuValidation: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onMenuValidationProperty()

  def onMenuValidation_=(eventHandler: jfxe.EventHandler[jfxe.Event]): Unit = {
    onMenuValidation() = eventHandler
  }

  override protected def eventHandlerDelegate: EventHandled = delegate.asInstanceOf[EventHandled]
}
