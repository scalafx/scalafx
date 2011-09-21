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

package scalafx.scene.shape

import scalafx.beans.property.DoubleProperty

class Rectangle extends Shape {
  override val delegate = new javafx.scene.shape.Rectangle()

  private[this] lazy val _xProperty = new DoubleProperty(delegate.xProperty())
  def x = _xProperty
  def x_=(v: Double) {
    x() = v
  }

  private[this] lazy val _yProperty = new DoubleProperty(delegate.yProperty())
  def y = _yProperty
  def y_=(v: Double) {
    y() = v
  }

  private[this] lazy val _widthProperty = new DoubleProperty(delegate.widthProperty())
  def width = _widthProperty
  def width_=(v: Double) {
    width() = v
  }

  private[this] lazy val _heightProperty = new DoubleProperty(delegate.heightProperty())
  def height = _heightProperty
  def height_=(v: Double) {
    height() = v
  }

  private[this] lazy val _arcWidthProperty = new DoubleProperty(delegate.arcWidthProperty())
  def arcWidth = _arcWidthProperty
  def arcWidth_=(v: Double) {
    arcWidth() = v
  }

  private[this] lazy val _arcHeightProperty = new DoubleProperty(delegate.arcHeightProperty())
  def arcHeight = _arcHeightProperty
  def arcHeight_=(v: Double) {
    arcHeight() = v
  }
}
