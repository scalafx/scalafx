/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.scene.{ control => jfxsc }
import javafx.{ collections => jfxc }
import scalafx.collections._
import scalafx.Includes._
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.delegate.SFXDelegate
import collection.JavaConversions._

object ToggleGroup {
  implicit def sfxToggleGroup2jfx(v: ToggleGroup) = v.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/ToggleGroup.html]].
 */
class ToggleGroup(override val delegate: jfxsc.ToggleGroup = new jfxsc.ToggleGroup)
  extends SFXDelegate[jfxsc.ToggleGroup] {

  /**
   * The selected toggle.
   */
  def selectedToggle: ReadOnlyObjectProperty[jfxsc.Toggle] = delegate.selectedToggleProperty

  /**
   * The list of toggles within the ToggleGroup.
   */
  def toggles: jfxc.ObservableList[jfxsc.Toggle] = delegate.getToggles
  /**
   * Sets the list of toggles, replacing the prior toggles. If you want append to current toggles, use `add` or
   * similar.
   *
   * @param c list of toggles to replace prior toggles.
   */
  def toggles_=(c: Iterable[Toggle]) {
    fillSFXCollection(this.toggles, c)
  }

}