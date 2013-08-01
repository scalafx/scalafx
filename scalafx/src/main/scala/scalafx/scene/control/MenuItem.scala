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
package scalafx.scene.control

import javafx.{ event => jfxe }
import javafx.{ scene => jfxs }
import javafx.scene.{ control => jfxsc, input => jfxsi }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.beans.property.StringProperty
import scalafx.event.EventHandlerDelegate
import scalafx.scene.Node
import scalafx.scene.input.KeyCombination
import scalafx.delegate.FireDelegate
import scalafx.delegate.SFXDelegate

object MenuItem {
  implicit def sfxMenuItem2jfx(m: MenuItem) = m.delegate
}

class MenuItem(override val delegate: jfxsc.MenuItem = new jfxsc.MenuItem)
  extends jfxe.EventTarget
  with EventHandlerDelegate
  with FireDelegate[jfxsc.MenuItem]
  with SFXDelegate[jfxsc.MenuItem] {

  /**
   * Constructs a MenuItem and sets the display text with the specified text
   */
  def this(text: String) = this(new jfxsc.MenuItem(text))

  /**
   * Constructor s MenuItem and sets the display text with the specified text and sets the graphic
   * Node to the given node.
   */
  def this(text: String, graphic: Node) = this(new jfxsc.MenuItem(text, graphic))

  /**
   *
   */
  def accelerator: ObjectProperty[jfxsi.KeyCombination] = delegate.acceleratorProperty
  def accelerator_=(v: KeyCombination) {
    accelerator() = v
  }

  /**
   *
   */
  def disable: BooleanProperty = delegate.disableProperty
  def disable_=(v: Boolean) {
    disable() = v
  }

  /**
   *
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty
  def graphic_=(v: Node) {
    graphic() = v
  }

  /**
   *
   */
  def id: StringProperty = delegate.idProperty
  def id_=(v: String) {
    id() = v
  }

  /**
   * MnemonicParsing property to enable/disable text parsing.
   */
  def mnemonicParsing: BooleanProperty = delegate.mnemonicParsingProperty
  def mnemonicParsing_=(v: Boolean) {
    mnemonicParsing() = v
  }

  /**
   *
   */
  def onAction = delegate.onActionProperty
  def onAction_=(v: jfxe.EventHandler[jfxe.ActionEvent]) {
    onAction() = v
  }

  /**
   *
   */
  def parentMenu: ReadOnlyObjectProperty[jfxsc.Menu] = delegate.parentMenuProperty

  /**
   *
   */
  def parentPopup: ReadOnlyObjectProperty[jfxsc.ContextMenu] = delegate.parentPopupProperty

  /**
   *
   */
  def style: StringProperty = delegate.styleProperty
  def style_=(v: String) {
    style() = v
  }

  /**
   *
   */
  def text: StringProperty = delegate.textProperty
  def text_=(v: String) {
    text() = v
  }

  /**
   *
   */
  def visible: BooleanProperty = delegate.visibleProperty
  def visible_=(v: Boolean) {
    visible() = v
  }


  /**
   * Construct an event dispatch chain for this target.
   */
  def buildEventDispatchChain(tail: jfxe.EventDispatchChain) = delegate.buildEventDispatchChain(tail)

  /**
   * Returns an observable map of properties on this menu item for use primarily by application
   * developers.
   */
  def properties = delegate.getProperties

  /**
   *
   */
  def styleClass = delegate.getStyleClass

  /**
   * Returns a previously set Object property, or null if no such property has been set using the
   * setUserData(java.lang.Object) method.
   */
  def userData: AnyRef = delegate.getUserData
  def userData_=(v: AnyRef) {
    delegate.setUserData(v)
  }

  /**
   * The event handler that is associated with invocation of an accelerator for a MenuItem.
   * This can happen when a key sequence for an accelerator is pressed.
   * The event handler is also invoked when onShowing event handler is called.
   * @since 2.2
   */
  def onMenuValidation = delegate.onMenuValidationProperty()
  def onMenuValidation_=(eventHandler: jfxe.EventHandler[jfxe.Event]) {
    onMenuValidation() = eventHandler
  }

  override protected def eventHandlerDelegate = delegate.asInstanceOf[EventHandled]
}