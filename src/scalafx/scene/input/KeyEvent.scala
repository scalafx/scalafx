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

package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object KeyEvent {
  implicit def sfxKeyEvent2jfx(ke: KeyEvent) = ke.delegate
  
  /**
   * Common supertype for all key event types.
   */
  val Any = jfxsi.KeyEvent.ANY

  /**
   * KEY_PRESSED and KEY_RELEASED events which do not map to a valid Unicode character use this for the keyChar value.
   */
  val CharUndefined = jfxsi.KeyEvent.CHAR_UNDEFINED

  /**
   * This event occurs when a key has been pressed.
   */
  val KeyPressed = jfxsi.KeyEvent.KEY_PRESSED

  /**
   * This event occurs when a key has been released.
   */
  val KeyReleased = jfxsi.KeyEvent.KEY_RELEASED

  /**
   * This event occurs when a key has been typed (pressed and released).
   */
  val KeyTyped = jfxsi.KeyEvent.KEY_TYPED

}

class KeyEvent(override val delegate: jfxsi.KeyEvent) extends InputEvent(delegate) with SFXDelegate[jfxsi.KeyEvent] {

  /**
   * The unicode character associated with the key typed event.
   */
  def character = delegate.getCharacter()

  /**
   * The key code associated with the key in this key pressed or key released event.
   *
   */
  def code : KeyCode = delegate.getCode

  /**
   * A String describing the key code, such as "HOME", "F1" or "A", for key pressed and key released events.
   */
  def text = delegate.getText()

  /**
   * Returns whether or not the Alt modifier is down on this event.
   */
  def altDown = delegate.isAltDown()

  /**
   * Returns whether or not the Control modifier is down on this event.
   */
  def controlDown = delegate.isControlDown()

  /**
   * Returns whether or not the Meta modifier is down on this event.
   */
  def metaDown = delegate.isMetaDown()

  /**
   * Returns whether or not the Shift modifier is down on this event.
   */
  def shifitDown = delegate.isShiftDown()

  /**
   * Returns whether or not the host platform common shortcut modifier is down on this event.
   */
  def shortcutDown = delegate.isShortcutDown()

}