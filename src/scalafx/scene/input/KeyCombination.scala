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
import javafx.{ event => jfxe }
import scalafx.event.Event
import scalafx.util.SFXDelegate
import scalafx.util.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

object KeyCombination {

  object ModifierValue
    extends SFXEnumDelegateCompanion[jfxsi.KeyCombination.ModifierValue, ModifierValue] {

    /**
     * Constant which indicates that the modifier key can be either up or down.
     */
    val ANY = new ModifierValue(jfxsi.KeyCombination.ModifierValue.ANY)

    /**
     * Constant which indicates that the modifier key must be down.
     */
    val DOWN = new ModifierValue(jfxsi.KeyCombination.ModifierValue.DOWN)

    /**
     * Constant which indicates that the modifier key must be up.
     */
    val UP = new ModifierValue(jfxsi.KeyCombination.ModifierValue.UP)

    protected override def unsortedValues: Array[ModifierValue] = Array(ANY, DOWN, UP)

  }
  
  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCombination.ModifierValue.html]]
   */
  sealed case class ModifierValue(override val delegate: jfxsi.KeyCombination.ModifierValue)
    extends SFXEnumDelegate[jfxsi.KeyCombination.ModifierValue]

  object Modifier {
    implicit def sfxModifier2jfx(m: Modifier) = m.delegate
  }

  class Modifier(override val delegate: jfxsi.KeyCombination.Modifier) extends SFXDelegate[jfxsi.KeyCombination.Modifier] {

    /**
     * Gets the modifier key of this Modifier.
     */
    def key: KeyCode = new KeyCode(delegate.getKey)

    /**
     * Gets the modifier value of this Modifier.
     */
    def value: ModifierValue = ModifierValue.jfxEnum2sfx(delegate.getValue)

  }

  implicit def sfxKeyCombination2jfx(kc: KeyCombination) = kc.delegate

  /**
   * Modifier which specifies that the alt key can be either up or down.
   */
  val AltAny: Modifier = new Modifier(jfxsi.KeyCombination.ALT_ANY)

  /**
   * Modifier which specifies that the alt key must be down.
   */
  val AltDown: Modifier = new Modifier(jfxsi.KeyCombination.ALT_DOWN)

  /**
   * Modifier which specifies that the control key can be either up or down.
   */
  val ControlAny: Modifier = new Modifier(jfxsi.KeyCombination.CONTROL_ANY)

  /**
   * Modifier which specifies that the control key must be down.
   */
  val ControlDown: Modifier = new Modifier(jfxsi.KeyCombination.CONTROL_DOWN)

  /**
   * Modifier which specifies that the meta key can be either up or down.
   */
  val MetaAny: Modifier = new Modifier(jfxsi.KeyCombination.META_ANY)

  /**
   * Modifier which specifies that the meta key must be down.
   */
  val MetaDown: Modifier = new Modifier(jfxsi.KeyCombination.META_DOWN)

  /**
   * Modifier which specifies that the shift key can be either up or down.
   */
  val ShiftAny: Modifier = new Modifier(jfxsi.KeyCombination.SHIFT_ANY)

  /**
   * Modifier which specifies that the shift key must be down.
   */
  val ShiftDown: Modifier = new Modifier(jfxsi.KeyCombination.SHIFT_DOWN)

  /**
   * Modifier which specifies that the shortcut key can be either up or down.
   */
  val ShortcutAny: Modifier = new Modifier(jfxsi.KeyCombination.SHORTCUT_ANY)

  /**
   * Modifier which specifies that the shortcut key must be down.
   */
  val ShortcutDown: Modifier = new Modifier(jfxsi.KeyCombination.SHORTCUT_DOWN)

  /**
   * Constructs a new KeyCombination from the specified string.
   */
  def keyCombination(name: String): KeyCombination = new KeyCombination(jfxsi.KeyCombination.keyCombination(name)) {}

  /**
   * Constructs a new KeyCombination from the specified string.
   */
  @deprecated("Use apply instead", "1.0")
  def valueOf(value: String) = jfxsi.KeyCombination.valueOf(value)

  /**
   * Constructs a new KeyCombination from the specified string.
   */
  def apply(value: String): KeyCombination = new KeyCombination(jfxsi.KeyCombination.valueOf(value)) {}
  
}

abstract class KeyCombination protected (override val delegate: jfxsi.KeyCombination) extends SFXDelegate[jfxsi.KeyCombination] {

  /**
   * The state of the alt key in this key combination.
   */
  def alt: KeyCombination.ModifierValue = KeyCombination.ModifierValue.jfxEnum2sfx(delegate.getAlt)

  /**
   * The state of the control key in this key combination.
   */
  def control: KeyCombination.ModifierValue = KeyCombination.ModifierValue.jfxEnum2sfx(delegate.getControl)

  /**
   * The state of the meta key in this key combination.
   */
  def meta: KeyCombination.ModifierValue = KeyCombination.ModifierValue.jfxEnum2sfx(delegate.getMeta)

  /**
   * Returns a string representation of this KeyCombination.
   */
  def name = delegate.getName

  /**
   * The state of the shift key in this key combination.
   */
  def shift: KeyCombination.ModifierValue = KeyCombination.ModifierValue.jfxEnum2sfx(delegate.getShift)

  /**
   * The state of the shortcut key in this key combination.
   */
  def shortcut: KeyCombination.ModifierValue = KeyCombination.ModifierValue.jfxEnum2sfx(delegate.getShortcut)

  /**
   * Tests whether this key combination matches the combination in the given KeyEvent.
   */
  def `match`(event: KeyEvent) = delegate.`match`(event)

}