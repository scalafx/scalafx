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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.util.SFXDelegate

object Toggle {
  implicit def sfxToggle2jfx(t: Toggle) = t.delegate
}

/**
 * Wrapper trait to [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/Toggle.html Toggle]]
 * interface.
 */
trait Toggle extends SFXDelegate[jfxsc.Toggle] {

  /**
   * The selected state for this Toggle. Indicates whether this Control is selected.
   */
  def selected = delegate.selectedProperty
  def selected_=(v: Boolean) {
    selected() = v
  }

  /**
   * The [[ToggleGroup]] to which this Toggle belongs.
   */
  def toggleGroup = delegate.toggleGroupProperty
  def toggleGroup_=(v: ToggleGroup) {
    toggleGroup() = v
  }

  def userData: AnyRef
  def userData_=(v: AnyRef)

  /**
   * Returns an observable map of properties on this toggle for use primarily by application
   * developers.
   */
  def properties = delegate.getProperties

}