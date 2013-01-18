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
import scalafx.delegate.SFXDelegate
import scala.collection._
import scala.collection.JavaConversions._

object KeyCharacterCombination {
  implicit def sfxKeyCharacterCombination2jfx(kcc: KeyCharacterCombination) = kcc.delegate
}

class KeyCharacterCombination(override val delegate: jfxsi.KeyCharacterCombination) extends KeyCombination(delegate) with SFXDelegate[jfxsi.KeyCharacterCombination] {

  /**
   * Constructs a KeyCodeCombination for the specified main key and with the specified list of modifiers.
   */
  def this(character: String, modifiers: jfxsi.KeyCombination.Modifier*) = this(new jfxsi.KeyCharacterCombination(character, modifiers: _*))

  /**
   * Constructs a KeyCodeCombination for the specified main key and with an explicit specification of all modifier keys.
   */
  def this(character: String, shift: jfxsi.KeyCombination.ModifierValue, control: jfxsi.KeyCombination.ModifierValue, alt: jfxsi.KeyCombination.ModifierValue, meta: jfxsi.KeyCombination.ModifierValue, shortcut: jfxsi.KeyCombination.ModifierValue) =
    this(new jfxsi.KeyCharacterCombination(character, shift, control, alt, meta, shortcut))

  /**
   * Gets the key character associated with this key combination.
   */
  def character = delegate.getCharacter

}