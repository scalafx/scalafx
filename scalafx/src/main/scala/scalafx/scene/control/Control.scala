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
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate
import scalafx.scene.layout.Region

import scala.language.implicitConversions

object Control {
  implicit def sfxControl2jfx(v: Control): jfxsc.Control = if (v != null) v.delegate else null
}

abstract class Control(override val delegate: jfxsc.Control)
    extends Region(delegate)
    with Skinnable
    with SFXDelegate[jfxsc.Control] {

  /**
   * The ContextMenu to show for this control.
   */
  def contextMenu: ObjectProperty[jfxsc.ContextMenu] = delegate.contextMenuProperty

  def contextMenu_=(v: ContextMenu): Unit = {
    contextMenu() = v
  }

  /**
   * The ToolTip for this control.
   */
  def tooltip: ObjectProperty[jfxsc.Tooltip] = delegate.tooltipProperty

  def tooltip_=(v: Tooltip): Unit = {
    tooltip() = v
  }

}
