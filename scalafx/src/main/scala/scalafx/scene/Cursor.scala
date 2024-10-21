/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import javafx.{scene => jfxs}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Cursor {
  implicit def sfxCursor2jfx(c: Cursor): jfxs.Cursor = if (c != null) c.delegate else null

  /**
   * Returns a cursor for the specified identifier.
   */
  def apply(identifier: String): Cursor = new Cursor(jfxs.Cursor.cursor(identifier)) {}

  /**
   * A cursor with a hand that is closed, often used when "grabbing", for example, when panning.
   */
  val ClosedHand: Cursor = new Cursor(jfxs.Cursor.CLOSED_HAND) {}
  @deprecated("Use ClosedHand; CLOSED_HAND will be removed in a future release", "8.0.60-R10")
  val CLOSED_HAND: Cursor = ClosedHand

  /**
   * The crosshair cursor type.
   */
  val Crosshair: Cursor = new Cursor(jfxs.Cursor.CROSSHAIR) {}
  @deprecated("Use Crosshair; CROSSHAIR will be removed in a future release", "8.0.60-R10")
  val CROSSHAIR: Cursor = Crosshair

  /**
   * The default cursor type (gets set if no cursor is defined) {}.
   */
  val Default: Cursor = new Cursor(jfxs.Cursor.DEFAULT) {}
  @deprecated("Use Default; DEFAULT will be removed in a future release", "8.0.60-R10")
  val DEFAULT: Cursor = Default

  /**
   * The disappear cursor type.
   */
  val Disappear: Cursor = new Cursor(jfxs.Cursor.DISAPPEAR) {}
  @deprecated("Use Disappear; DISAPPEAR will be removed in a future release", "8.0.60-R10")
  val DISAPPEAR: Cursor = Disappear

  /**
   * The east-resize cursor type.
   */
  val EResize: Cursor = new Cursor(jfxs.Cursor.E_RESIZE) {}
  @deprecated("Use EResize; E_RESIZE will be removed in a future release", "8.0.60-R10")
  val E_RESIZE: Cursor = EResize

  /**
   * The horizontal cursor type.
   */
  val HResize: Cursor = new Cursor(jfxs.Cursor.HAND) {}
  @deprecated("Use HResize; H_RESIZE will be removed in a future release", "8.0.60-R10")
  val H_RESIZE: Cursor = HResize

  /**
   * The hand cursor type, resembling a pointing hand, often used to indicate that something
   * can be clicked, such as a hyperlink.
   */
  val Hand: Cursor = new Cursor(jfxs.Cursor.HAND) {}
  @deprecated("Use Hand; HAND will be removed in a future release", "8.0.60-R10")
  val HAND: Cursor = Hand

  /**
   * The move cursor type.
   */
  val Move: Cursor = new Cursor(jfxs.Cursor.MOVE) {}
  @deprecated("Use Move; MOVE will be removed in a future release", "8.0.60-R10")
  val MOVE: Cursor = Move

  /**
   * The north-resize cursor type.
   */
  val NResize: Cursor = new Cursor(jfxs.Cursor.N_RESIZE) {}
  @deprecated("Use NResize; N_RESIZE will be removed in a future release", "8.0.60-R10")
  val N_RESIZE: Cursor = NResize

  /**
   * The north-east-resize cursor type.
   */
  val NEResize: Cursor = new Cursor(jfxs.Cursor.NE_RESIZE) {}
  @deprecated("Use NEResize; NE_RESIZE will be removed in a future release", "8.0.60-R10")
  val NE_RESIZE: Cursor = NEResize

  /**
   * The none cursor type.
   */
  val None: Cursor = new Cursor(jfxs.Cursor.NONE) {}
  @deprecated("Use None; NONE will be removed in a future release", "8.0.60-R10")
  val NONE: Cursor = None

  /**
   * The north-west-resize cursor type.
   */
  val NWResize: Cursor = new Cursor(jfxs.Cursor.NW_RESIZE) {}
  @deprecated("Use NWResize; NW_RESIZE will be removed in a future release", "8.0.60-R10")
  val NW_RESIZE: Cursor = NWResize

  /**
   * A cursor with a hand which is open
   */
  val OpenHand: Cursor = new Cursor(jfxs.Cursor.OPEN_HAND) {}
  @deprecated("Use OpenHand; OPEN_HAND will be removed in a future release", "8.0.60-R10")
  val OPEN_HAND: Cursor = OpenHand

  /**
   * The south-resize cursor type.
   */
  val SResize: Cursor = new Cursor(jfxs.Cursor.S_RESIZE) {}
  @deprecated("Use SResize; S_RESIZE will be removed in a future release", "8.0.60-R10")
  val S_RESIZE: Cursor = SResize

  /**
   * The south-east-resize cursor type.
   */
  val SEResize: Cursor = new Cursor(jfxs.Cursor.SE_RESIZE) {}
  @deprecated("Use SEResize; SE_RESIZE will be removed in a future release", "8.0.60-R10")
  val SE_RESIZE: Cursor = SEResize

  /**
   * The south-west-resize cursor type.
   */
  val SWResize: Cursor = new Cursor(jfxs.Cursor.SW_RESIZE) {}
  @deprecated("Use SWResize; SW_RESIZE will be removed in a future release", "8.0.60-R10")
  val SW_RESIZE: Cursor = SWResize

  /**
   * The text cursor type.
   */
  val Text: Cursor = new Cursor(jfxs.Cursor.TEXT) {}
  @deprecated("Use Text; TEXT will be removed in a future release", "8.0.60-R10")
  val TEXT: Cursor = Text

  /**
   * The vertical cursor type.
   */
  val VResize: Cursor = new Cursor(jfxs.Cursor.V_RESIZE) {}
  @deprecated("Use VResize; V_RESIZE will be removed in a future release", "8.0.60-R10")
  val V_RESIZE: Cursor = VResize

  /**
   * The west-resize cursor type.
   */
  val WResize: Cursor = new Cursor(jfxs.Cursor.W_RESIZE) {}
  @deprecated("Use WResize; W_RESIZE will be removed in a future release", "8.0.60-R10")
  val W_RESIZE: Cursor = WResize

  /**
   * The wait cursor type.
   */
  val Wait: Cursor = new Cursor(jfxs.Cursor.WAIT) {}
  @deprecated("Use Wait; WAIT will be removed in a future release", "8.0.60-R10")
  val WAIT: Cursor = Wait

}

abstract class Cursor(override val delegate: jfxs.Cursor) extends SFXDelegate[jfxs.Cursor]
