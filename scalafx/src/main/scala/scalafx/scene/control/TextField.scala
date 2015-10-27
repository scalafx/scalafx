/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.IntegerProperty
import scalafx.delegate.{AlignmentDelegate, SFXDelegate}
import scalafx.event.ActionEvent

object TextField {
  implicit def sfxTextField2jfx(v: TextField): jfxsc.TextField = if (v != null) v.delegate else null
}

class TextField(override val delegate: jfxsc.TextField = new jfxsc.TextField)
  extends TextInputControl(delegate)
  with AlignmentDelegate[jfxsc.TextField]
  with SFXDelegate[jfxsc.TextField] {

  /**
   * The action handler associated with this text field, or null if no action handler is assigned.
   */
  def onAction = delegate.onActionProperty
  def onAction_=(v: jfxe.EventHandler[jfxe.ActionEvent]) {
    onAction() = v
  }
  def onAction_=(handler: ActionEvent => Unit) {
    onAction() = new jfxe.EventHandler[jfxe.ActionEvent] {
      override def handle(event: jfxe.ActionEvent): Unit = handler(event)
    }
  }

  /**
   * The preferred number of text columns.
   */
  def prefColumnCount: IntegerProperty = delegate.prefColumnCountProperty
  def prefColumnCount_=(v: Int) {
    prefColumnCount() = v
  }

}