/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

import scala.language.implicitConversions

object Button {
  implicit def sfxButton2jfx(v: Button): jfxsc.Button = if (v != null) v.delegate else null
}

class Button(override val delegate: jfxsc.Button = new jfxsc.Button) extends ButtonBase(delegate) with SFXDelegate[jfxsc.Button] {

  /**
   * Creates a button with the specified text as its label.
   */
  def this(text: String) = this(new jfxsc.Button(text))

  /**
   * Creates a button with the specified text and icon for its label.
   */
  def this(text: String, graphic: Node) = this(new jfxsc.Button(text, graphic))

  /**
   * A Cancel Button is the button that receives a keyboard VK_ESC press, if no other node in the
   * scene consumes it.
   */
  def cancelButton: BooleanProperty = delegate.cancelButtonProperty

  def cancelButton_=(b: Boolean): Unit = {
    cancelButton() = b
  }

  /**
   * A default Button is the button that receives a keyboard VK_ENTER press, if no other node in the
   * scene consumes it.
   */
  def defaultButton: BooleanProperty = delegate.defaultButtonProperty

  def defaultButton_=(b: Boolean): Unit = {
    defaultButton() = b
  }

}