/*
 * Copyright (c) 2011-2020, ScalaFX Project
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
import javafx.{event => jfxe}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.collections._
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.Node._

import scala.language.implicitConversions

object Menu {
  implicit def sfxMenu2jfx(cb: Menu): jfxsc.Menu = if (cb != null) cb.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Menu.html]].
 */
class Menu(override val delegate: jfxsc.Menu = new jfxsc.Menu("default"))
    extends MenuItem(delegate)
    with jfxe.EventTarget
    with SFXDelegate[jfxsc.Menu] {

  /**
   * Constructs a Menu and sets the display text with the specified text and sets the graphic Node to the given node.
   */
  def this(label: String, node: Node) = this(new jfxsc.Menu(label, node))

  /**
   * Constructs a Menu and sets the display text with the specified text.
   */
  def this(label: String) = this(new jfxsc.Menu(label))

  /**
   * The items to show within this menu.
   */
  def items: ObservableBuffer[jfxsc.MenuItem] = delegate.getItems

  /**
   * Sets the menu items, replacing the prior content. If you want append to current content, use `add` or similar.
   *
   * @param c
   *   Menu items to replace prior content.
   */
  def items_=(c: Iterable[MenuItem]): Unit = {
    fillSFXCollection(this.items, c)
  }

  /**
   * Hides the ContextMenu if it was previously showing, and any showing submenus.
   */
  def hide(): Unit = {
    delegate.hide()
  }

  /**
   * If the Menu is not disabled and the ContextMenu is not already showing, then this will cause the ContextMenu to be
   * shown.
   */
  def show(): Unit = {
    delegate.show()
  }

  /**
   * Gets the value of the property showing.
   */
  def showing: Boolean = delegate.isShowing

  def onHidden: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onHiddenProperty

  def onHidden_=(implicit eventHandler: jfxe.EventHandler[jfxe.Event]): Unit = {
    onHidden() = eventHandler
  }

  def onHiding: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onHidingProperty

  def onHiding_=(implicit eventHandler: jfxe.EventHandler[jfxe.Event]): Unit = {
    onHiding() = eventHandler
  }

  def onShowing: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onShowingProperty

  def onShowing_=(implicit eventHandler: jfxe.EventHandler[jfxe.Event]): Unit = {
    onShowing() = eventHandler
  }

  def onShown: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onShownProperty

  def onShown_=(implicit eventHandler: jfxe.EventHandler[jfxe.Event]): Unit = {
    onShown() = eventHandler
  }

}
