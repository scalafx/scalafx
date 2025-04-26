/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.scene.input as jfxsi
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.scene.input.InputIncludes.jfxKeyCombination2sfx

import scala.language.implicitConversions

object KeyCombination {

  object ModifierValue
      extends SFXEnumDelegateCompanion[jfxsi.KeyCombination.ModifierValue, ModifierValue] {

    /**
     * Constant which indicates that the modifier key can be either up or down.
     */
    case object Any extends ModifierValue(jfxsi.KeyCombination.ModifierValue.ANY)

    @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
    val ANY: ModifierValue = Any

    /**
     * Constant which indicates that the modifier key must be down.
     */
    case object Down extends ModifierValue(jfxsi.KeyCombination.ModifierValue.DOWN)

    @deprecated("Use Down; DOWN will be removed in a future release", "8.0.60-R10")
    val DOWN: ModifierValue = Down

    /**
     * Constant which indicates that the modifier key must be up.
     */
    case object Up extends ModifierValue(jfxsi.KeyCombination.ModifierValue.UP)

    @deprecated("Use Up; UP will be removed in a future release", "8.0.60-R10")
    val UP: ModifierValue = Up

    protected override def unsortedValues: Array[ModifierValue] = Array(Any, Down, Up)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/KeyCombination.ModifierValue.html]]
   */
  sealed abstract class ModifierValue(override val delegate: jfxsi.KeyCombination.ModifierValue)
      extends SFXEnumDelegate[jfxsi.KeyCombination.ModifierValue]

  object Modifier {
    implicit def sfxModifier2jfx(m: Modifier): jfxsi.KeyCombination.Modifier = if (m != null) m.delegate else null
  }

  class Modifier(override val delegate: jfxsi.KeyCombination.Modifier)
      extends SFXDelegate[jfxsi.KeyCombination.Modifier] {

    /**
     * Gets the modifier key of this Modifier.
     */
    def key: KeyCode = KeyCode(delegate.getKey)

    /**
     * Gets the modifier value of this Modifier.
     */
    def value: ModifierValue = ModifierValue.jfxEnum2sfx(delegate.getValue)

  }

  implicit def sfxKeyCombination2jfx(kc: KeyCombination): jfxsi.KeyCombination = if (kc != null) kc.delegate else null

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
  def valueOf(value: String): KeyCombination = jfxsi.KeyCombination.valueOf(value)

  /**
   * Constructs a new KeyCombination from the specified string.
   */
  def apply(value: String): KeyCombination = new KeyCombination(jfxsi.KeyCombination.valueOf(value)) {}

}

abstract class KeyCombination protected (override val delegate: jfxsi.KeyCombination)
    extends SFXDelegate[jfxsi.KeyCombination] {

  /**
   * The state of the alt key in this key combination.
   */
  def alt: KeyCombination.ModifierValue = KeyCombination.ModifierValue.jfxEnum2sfx(delegate.getAlt)

  /**
   * The state of the control key in this key combination.
   */
  def control: KeyCombination.ModifierValue = KeyCombination.ModifierValue.jfxEnum2sfx(delegate.getControl)

  /**
   * Returns a string representation of this KeyCombination that is suitable for display in a user interface
   * (for example, beside a menu item).
   *
   * @return A string representation of this KeyCombination, suitable for display in a user interface.
   */
  def displayText: String = delegate.getDisplayText

  /**
   * The state of the meta key in this key combination.
   */
  def meta: KeyCombination.ModifierValue = KeyCombination.ModifierValue.jfxEnum2sfx(delegate.getMeta)

  /**
   * Returns a string representation of this KeyCombination.
   */
  def name: String = delegate.getName

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
  def `match`(event: KeyEvent): Boolean = delegate.`match`(event)

}
