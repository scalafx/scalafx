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

package scalafx.scene

import javafx.{ scene => jfxs }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object Cursor {
  implicit def sfxCursor2jfx(c: Cursor) = c.delegate

  /**
   * Returns a cursor for the specified identifier.
   */
  def apply(identifier: String) = new Cursor(jfxs.Cursor.cursor(identifier)) {}

  /**
   * A cursor with a hand that is closed, often used when "grabbing", for example, when panning.
   */
  val CLOSED_HAND = new Cursor(jfxs.Cursor.CLOSED_HAND) {}

  /**
   * The crosshair cursor type.
   */
  val CROSSHAIR = new Cursor(jfxs.Cursor.CROSSHAIR) {}

  /**
   * The default cursor type (gets set if no cursor is defined) {}.
   */
  val DEFAULT = new Cursor(jfxs.Cursor.DEFAULT) {}

  /**
   * The disappear cursor type.
   */
  val DISAPPEAR = new Cursor(jfxs.Cursor.DISAPPEAR) {}

  /**
   * The east-resize cursor type.
   */
  val E_RESIZE = new Cursor(jfxs.Cursor.E_RESIZE) {}

  /**
   * The horizontal cursor type.
   */
  val H_RESIZE = new Cursor(jfxs.Cursor.HAND) {}

  /**
   * The hand cursor type, resembling a pointing hand, often used to indicate that something 
   * can be clicked, such as a hyperlink.
   */
  val HAND = new Cursor(jfxs.Cursor.HAND) {}

  /**
   * The move cursor type.
   */
  val MOVE = new Cursor(jfxs.Cursor.MOVE) {}

  /**
   * The north-resize cursor type.
   */
  val N_RESIZE = new Cursor(jfxs.Cursor.N_RESIZE) {}

  /**
   * The north-east-resize cursor type.
   */
  val NE_RESIZE = new Cursor(jfxs.Cursor.NE_RESIZE) {}

  /**
   * The none cursor type.
   */
  val NONE = new Cursor(jfxs.Cursor.NONE) {}

  /**
   * The north-west-resize cursor type.
   */
  val NW_RESIZE = new Cursor(jfxs.Cursor.NW_RESIZE) {}

  /**
   * A cursor with a hand which is open
   */
  val OPEN_HAND = new Cursor(jfxs.Cursor.OPEN_HAND) {}

  /**
   * The south-resize cursor type.
   */
  val S_RESIZE = new Cursor(jfxs.Cursor.S_RESIZE) {}

  /**
   * The south-east-resize cursor type.
   */
  val SE_RESIZE = new Cursor(jfxs.Cursor.SE_RESIZE) {}

  /**
   * The south-west-resize cursor type.
   */
  val SW_RESIZE = new Cursor(jfxs.Cursor.SW_RESIZE) {}

  /**
   * The text cursor type.
   */
  val TEXT = new Cursor(jfxs.Cursor.TEXT) {}

  /**
   * The vertical cursor type.
   */
  val V_RESIZE = new Cursor(jfxs.Cursor.V_RESIZE) {}

  /**
   * The west-resize cursor type.
   */
  val W_RESIZE = new Cursor(jfxs.Cursor.W_RESIZE) {}

  /**
   * The wait cursor type.
   */
  val WAIT = new Cursor(jfxs.Cursor.WAIT) {}

}

abstract class Cursor(override val delegate: jfxs.Cursor) extends SFXDelegate[jfxs.Cursor]