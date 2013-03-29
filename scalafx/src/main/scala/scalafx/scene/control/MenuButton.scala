/*
 * Copyright (c) 2012-2013, ScalaFX Project
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

import javafx.beans.{property => jfxbp}
import javafx.scene.{control => jfxsc}
import javafx.{collections => jfxc}
import javafx.{geometry => jfxg}
import scala.collection.JavaConversions.asJavaCollection
import scalafx.collections._
import scalafx.Includes._
import scalafx.geometry.Side
import scalafx.scene.Node
import scalafx.scene.Node._
import scalafx.delegate.SFXDelegate


object MenuButton {
  implicit def sfxToggleButton2jfx(mb: MenuButton) = mb.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/MenuButton.html]].
 */
class MenuButton(override val delegate: jfxsc.MenuButton = new jfxsc.MenuButton)
  extends ButtonBase(delegate)
  with SFXDelegate[jfxsc.MenuButton] {

  /** Creates a toggle button with the specified text as its label. */
  def this(text: String) = this(new jfxsc.MenuButton(text))

  /** Creates a toggle button with the specified text and icon for its label. */
  def this(text: String, graphic: Node) = this(new jfxsc.MenuButton(text, graphic))

  /** The items to show within this buttons menu. */
  def items: jfxc.ObservableList[jfxsc.MenuItem] = delegate.getItems
  /**
   * Sets the items, replacing the prior content. If you want append to current content, use `add` or
   * similar.
   *
   * @param c Items to replace prior content.
   */
  def items_=(c: Iterable[MenuItem]) {
    fillSFXCollection(this.items, c)
  }


  /** Indicates on which side the ContextMenu should open in relation to the MenuButton. */
  def popupSide: jfxbp.ObjectProperty[jfxg.Side] = delegate.popupSideProperty()

  def popupSide_=(side: Side) {
    popupSide() = side
  }

  /** Hides the ContextMenu. */
  def hide() {
    delegate.hide()
  }

  /** Gets the value of the property showing. */
  def showing: Boolean = delegate.isShowing

  /** If the Menu is not disabled and the ContextMenu is not already showing,
    * then this will cause the ContextMenu to be shown.
    */
  def show() {
    delegate.show()
  }
}
