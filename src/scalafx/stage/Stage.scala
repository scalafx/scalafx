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

import scalafx.scene.Scene
import scalafx.application.Application
import scalafx.util.SFXDelegate
import scalafx.beans.property._

class Stage extends SFXDelegate[javafx.stage.Stage] {
  override val delegate = Application.STAGE

  private[this] lazy val _fullScreenProperty = new ReadOnlyBooleanProperty(delegate.fullScreenProperty())
  def fullScreen = _fullScreenProperty

  private[this] lazy val _titleProperty = new StringProperty(delegate.titleProperty())
  def title = _titleProperty
  def title_=(v: String) {
    title() = v
  }

  private[this] lazy val _iconifiedProperty = new ReadOnlyBooleanProperty(delegate.iconifiedProperty())
  def iconified = _iconifiedProperty

  private[this] lazy val _resizableProperty = new BooleanProperty(delegate.resizableProperty())
  def resizable = _resizableProperty
  def resizable_=(v: Boolean) {
    resizable() = v
  }

  private[this] var _scene: Scene = null
  def scene: Scene = _scene
  def scene_=(s: Scene) {
    _scene = s
    delegate.setScene(s.delegate)
  }

  // The following methods are strictly speaking not properties...  but it is convenient to treat them as such.  :)

  def width: Double = delegate.getWidth
  def width_=(w: Double) {
    delegate.setWidth(w)
  }

  def height: Double = delegate.getHeight
  def height_=(h: Double) {
    delegate.setHeight(h)
  }

  private[this] var _visible: Boolean = false
  def visible: Boolean = _visible
  def visible_=(v: Boolean) {
    _visible = v
    if (v) {
      delegate.show()
    } else {
      delegate.hide()
    }
  }
}
