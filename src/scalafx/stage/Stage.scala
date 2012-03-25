/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.stage

import javafx.{stage => jfxs}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.util.SFXDelegate
import scalafx.scene.Scene

object Stage {
  implicit def sfxStage2jfx(v: Stage) = v.delegate
}

class Stage extends SFXDelegate[jfxs.Stage] {
  override val delegate = JFXApp.STAGE

  def fullScreen = delegate.fullScreenProperty

  def title = delegate.titleProperty
  def title_=(v: String) {
    title() = v
  }

  def iconified = delegate.iconifiedProperty

  def resizable = delegate.resizableProperty
  def resizable_=(v: Boolean) {
    resizable() = v
  }

  def scene = delegate.sceneProperty
  def scene_=(s: Scene) {
    delegate.setScene(s.delegate)
  }

  def width = delegate.getWidth
  def width_=(w: Double) {
    delegate.setWidth(w)
  }

  def height = delegate.getHeight
  def height_=(h: Double) {
    delegate.setHeight(h)
  }

  def minWidth = delegate.getMinWidth
  def minWidth_=(w: Double) {
    delegate.setMinWidth(w)
  }

  def minHeight = delegate.getMinHeight
  def minHeight_=(h: Double) {
    delegate.setMinHeight(h)
  }

  def maxWidth = delegate.getMaxWidth
  def maxWidth_=(w: Double) {
    delegate.setMaxWidth(w)
  }

  def maxHeight = delegate.getMaxHeight
  def maxHeight_=(h: Double) {
    delegate.setMaxHeight(h)
  }

  def showing = delegate.isShowing
  def showing_=(v: Boolean) {
    v match {
      case true => delegate.show()
      case false => delegate.hide()
    }
  }
}
