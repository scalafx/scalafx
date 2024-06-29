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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object CheckBox {
  implicit def sfxCheckBox2jfx(v: CheckBox): jfxsc.CheckBox = if (v != null) v.delegate else null
}

class CheckBox(override val delegate: jfxsc.CheckBox = new jfxsc.CheckBox)
    extends ButtonBase(delegate)
    with SFXDelegate[jfxsc.CheckBox] {

  /**
   * Creates a check box with the specified text as its label.
   */
  def this(text: String) = this(new jfxsc.CheckBox(text))

  /**
   * Determines whether the user toggling the CheckBox should cycle through all three states:
   * checked, unchecked, and undefined.
   */
  def allowIndeterminate: BooleanProperty = delegate.allowIndeterminateProperty

  def allowIndeterminate_=(b: Boolean): Unit = {
    allowIndeterminate() = b
  }

  /**
   * Determines whether the CheckBox is in the indeterminate state.
   */
  def indeterminate: BooleanProperty = delegate.indeterminateProperty

  def indeterminate_=(b: Boolean): Unit = {
    indeterminate() = b
  }

  /**
   * Indicates whether this CheckBox is checked.
   */
  def selected: BooleanProperty = delegate.selectedProperty

  def selected_=(b: Boolean): Unit = {
    selected() = b
  }

}
