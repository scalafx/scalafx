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

class Stage() {
  var wrappedStage: javafx.stage.Stage = Application.STAGE

  def title: String = wrappedStage.getTitle

  def title_=(t: String) {
    wrappedStage.setTitle(t)
  }

  def width: Double = wrappedStage.getWidth

  def width_=(w: Double) {
    wrappedStage.setWidth(w)
  }

  def height: Double = wrappedStage.getHeight

  def height_=(h: Double) {
    wrappedStage.setHeight(h)
  }

  private var _scene: Scene = null

  def scene: Scene = _scene

  def scene_=(s: Scene) {
    _scene = s
    wrappedStage.setScene(s.scene)
  }

  private var _visible: Boolean = false

  def visible: Boolean = _visible

  def visible_=(v: Boolean) {
    if (v) {
      _visible = v
      wrappedStage.show()
    } else {
      throw new IllegalStateException("Cannot hide scene by setting visible back to false (limitation in JavaFX APIs)");
    }
  }
}
