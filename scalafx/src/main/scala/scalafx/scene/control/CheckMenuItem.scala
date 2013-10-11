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

import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node


object CheckMenuItem {
  implicit def sfxCheckMenuItem2jfx(m: CheckMenuItem) = m.delegate
}

/** A MenuItem that can be toggled between selected and unselected states. */
class CheckMenuItem(override val delegate: jfxsc.CheckMenuItem = new jfxsc.CheckMenuItem)
  extends jfxsc.MenuItem
  with SFXDelegate[jfxsc.CheckMenuItem] {

  /** Constructs a CheckMenuItem and sets the display text with the specified text. */
  def this(text: String) = this(new jfxsc.CheckMenuItem(text))

  /** Constructs a CheckMenuItem and sets the display text with the specified text and
    * sets the graphic Node to the given node.
    */
  def this(text: String, graphic: Node) = this(new jfxsc.CheckMenuItem(text, graphic))


  /** Represents the current state of this CheckMenuItem.
    *
    * Bind to this to be informed whenever the user interacts with the CheckMenuItem
    * (and causes the selected state to be toggled).
    */
  def selected: BooleanProperty = delegate.selectedProperty
  def selected_=(v: Boolean) {
    selected() = v
  }
}