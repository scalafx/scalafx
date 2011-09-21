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

package scalafx.scene.layout

import javafx.geometry.Insets
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.scene.Parent

class Region extends Parent {
  override val delegate = new javafx.scene.layout.Region()
  
  private[this] lazy val _heightProperty = new ReadOnlyDoubleProperty(delegate.heightProperty())
  def height = _heightProperty

  private[this] lazy val _maxHeightProperty = new DoubleProperty(delegate.maxHeightProperty())
  def maxHeight = _maxHeightProperty
  def maxHeight_=(v: Double) {
    maxHeight() = v
  }
  
  private[this] lazy val _maxWidthProperty = new DoubleProperty(delegate.maxWidthProperty())
  def maxWidth = _maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth() = v
  }
  
  private[this] lazy val _minHeightProperty = new DoubleProperty(delegate.minHeightProperty())
  def minHeight = _minHeightProperty
  def minHeight_=(v: Double) {
    minHeight() = v
  }
  
  private[this] lazy val _minWidthProperty = new DoubleProperty(delegate.minWidthProperty())
  def minWidth = _minWidthProperty
  def minWidth_=(v: Double) {
    minWidth() = v
  }

  private[this] lazy val _paddingProperty = new ObjectProperty[Insets](delegate.paddingProperty())
  def padding = _paddingProperty
  def padding_=(v: Insets) {
    padding() = v
  }
  
  private[this] lazy val _prefHeightProperty = new DoubleProperty(delegate.prefHeightProperty())
  def prefHeight = _prefHeightProperty
  def prefHeight_=(v: Double) {
    prefHeight() = v
  }
  
  private[this] lazy val _prefWidthProperty = new DoubleProperty(delegate.prefWidthProperty())
  def prefWidth = _prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth() = v
  }
  
  private[this] lazy val _snapToPixelProperty = new BooleanProperty(delegate.snapToPixelProperty())
  def snapToPixel = _snapToPixelProperty
  def snapToPixel_=(v: Boolean) {
    snapToPixel() = v
  } 

  private[this] lazy val _widthProperty = new ReadOnlyDoubleProperty(delegate.widthProperty())
  def width = _widthProperty
}
