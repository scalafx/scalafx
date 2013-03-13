/*
 * Copyright (c) 2012-2013, ScalaFX Project
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

import javafx.{ scene => jfxs }
import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene._
import javafx.beans.property.BooleanProperty
import scalafx.beans.property.ObjectProperty

object TitledPane {
  implicit def sfxTitledPane2jfx(v: TitledPane) = v.delegate
}

class TitledPane(override val delegate: jfxsc.TitledPane = new jfxsc.TitledPane)
  extends Labeled(delegate)
  with SFXDelegate[jfxsc.TitledPane] {

  def animated: BooleanProperty = delegate.animatedProperty
  def animated_=(v: Boolean) {
    animated() = v
  }

  def collapsible: BooleanProperty = delegate.collapsibleProperty
  def collapsible_=(v: Boolean) {
    collapsible() = v
  }

  def content: ObjectProperty[jfxs.Node] = delegate.contentProperty
  def content_=(v: Node) {
    content() = v
  }

  def expanded: BooleanProperty = delegate.expandedProperty
  def expanded_=(v: Boolean) {
    expanded() = v
  }
}
