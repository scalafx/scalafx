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

import javafx.scene.{control => jfxsc, input => jfxsi}
import javafx.{event => jfxe}
import scalafx.Includes._
import scalafx.beans.property.ReadOnlyBooleanProperty
import scalafx.delegate.{FireDelegate, SFXDelegate}
import scalafx.scene.input.MouseEvent

import scala.language.implicitConversions

object ButtonBase {
  implicit def sfxButtonBase2jfx(v: ButtonBase): jfxsc.ButtonBase = if (v != null) v.delegate else null
}

abstract class ButtonBase(override val delegate: jfxsc.ButtonBase)
  extends Labeled(delegate)
  with FireDelegate[jfxsc.ButtonBase]
  with SFXDelegate[jfxsc.ButtonBase] {

  /**
   * Indicates that the button has been "armed" such that a mouse release will cause the button's action to be invoked.
   */
  def armed: ReadOnlyBooleanProperty = delegate.armedProperty

  /**
   * The button's action, which is invoked whenever the button is fired.
   */
  def onAction = delegate.onActionProperty

  def onAction_=(implicit aeh: jfxe.EventHandler[jfxe.ActionEvent]): Unit = {
    onAction() = aeh
  }

  /**
   * Arms the button.
   */
  def arm(): Unit = {
    delegate.arm()
  }

  /**
   * Disarms the button.
   */
  def disarm(): Unit = {
    delegate.disarm()
  }

  // for now only a few examples

  def addOnMouseEnteredHandler(handler: (MouseEvent) => Unit): Unit = {
    delegate.addEventHandler(jfxsi.MouseEvent.MOUSE_ENTERED,
      new jfxe.EventHandler[jfxsi.MouseEvent]() {
        @Override
        def handle(me: jfxsi.MouseEvent): Unit = {
          handler(new MouseEvent(me))
        }
      })
  }

  def addOnMouseExitedHandler(handler: (MouseEvent) => Unit): Unit = {
    delegate.addEventHandler(jfxsi.MouseEvent.MOUSE_EXITED,
      new jfxe.EventHandler[jfxsi.MouseEvent]() {
        @Override
        def handle(me: jfxsi.MouseEvent): Unit = {
          handler(new MouseEvent(me))
        }
      })
  }

}
