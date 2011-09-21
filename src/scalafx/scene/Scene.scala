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

package scalafx.scene

import javafx.scene.paint.Paint
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.util.SFXDelegate

class Scene extends SFXDelegate {
  // todo - get rid of this magic...
  val root = new javafx.scene.Group()

  override val delegate = new javafx.scene.Scene(root)

  var _content: List[_ <: Node] = Nil

  def content: List[_ <: Node] = _content

  def content_=(c: List[_ <: Node]) {
    _content = c
    root.getChildren.setAll(java.util.Arrays.asList(c.map(n => n.delegate).toArray: _*))
  }

  private[this] lazy val _fillProperty = new ObjectProperty[Paint](delegate.fillProperty())
  def fill = _fillProperty
  def fill_=(v: Paint) {
    fill() = v
  }

  private[this] lazy val _heightProperty = new ReadOnlyDoubleProperty(delegate.heightProperty())
  def height = _heightProperty

  private[this] lazy val _widthProperty = new ReadOnlyDoubleProperty(delegate.widthProperty())
  def width = _widthProperty
}