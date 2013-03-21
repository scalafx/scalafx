/*
 * Copyright (c) 2012, ScalaFX Project
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

import javafx.scene.{ control => jfxsc }
import scalafx.delegate.SFXDelegate
import scalafx.Includes._
import javafx.{ event => jfxe }
import javafx.{ geometry => jfxg }
import scalafx.collections.ObservableBuffer
import scalafx.scene.Node

object ContextMenu {
  implicit def sfxContextMenu2jfx(cm: ContextMenu) = cm.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/ContextMenu.html]].
 */
class ContextMenu(override val delegate: jfxsc.ContextMenu = new jfxsc.ContextMenu)
  extends PopupControl(delegate)
  with SFXDelegate[jfxsc.ContextMenu] {

  /**
   * Create a new ContextMenu initialized with the given items
   */
  def this(items: MenuItem*) = this(new jfxsc.ContextMenu(items.map(_.delegate): _*))

  /**
   * Callback function to be informed when an item contained within this ContextMenu has been activated.
   */
  def onAction = delegate.onActionProperty
  def onAction_=(v: jfxe.EventHandler[jfxe.ActionEvent]) {
    onAction() = v
  }

  /**
   * The menu items on the context menu.
   */
  def items: ObservableBuffer[jfxsc.MenuItem] = delegate.getItems

  /**
   * Shows the `ContextMenu` relative to the given anchor node, on the side specified by the hpos and vpos parameters,
   * and offset by the given dx and dy values for the x-axis and y-axis, respectively.
   */
  def show(anchor: Node, side: jfxg.Side, screenX: Double, screenY: Double) {
    delegate.show(anchor, side, screenX, screenY)
  }

}