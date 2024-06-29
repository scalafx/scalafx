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
package scalafx.scene.image

import javafx.scene.{image => jfxsi}
import javafx.{geometry => jfxg}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, ObjectProperty}
import scalafx.delegate.{PositionDelegate, SFXDelegate}
import scalafx.geometry.Rectangle2D
import scalafx.scene.Node

import scala.language.implicitConversions

object ImageView {
  implicit def sfxImageView2jfx(iv: ImageView): jfxsi.ImageView = if (iv != null) iv.delegate else null
}

class ImageView(override val delegate: jfxsi.ImageView = new jfxsi.ImageView())
    extends Node(delegate)
    with PositionDelegate[jfxsi.ImageView]
    with SFXDelegate[jfxsi.ImageView] {

  /** Allocates a new ImageView object using the given image. */
  def this(image: Image) = {
    this(new jfxsi.ImageView(image))
  }

  /** Allocates a new ImageView object with image loaded from the specified URL. */
  def this(url: String) = {
    this(new jfxsi.ImageView(url))
  }

  def fitHeight: DoubleProperty = delegate.fitHeightProperty

  def fitHeight_=(v: Double): Unit = {
    fitHeight() = v
  }

  def fitWidth: DoubleProperty = delegate.fitWidthProperty

  def fitWidth_=(v: Double): Unit = {
    fitWidth() = v
  }

  def image: ObjectProperty[jfxsi.Image] = delegate.imageProperty

  def image_=(v: Image): Unit = {
    image() = v
  }

  def preserveRatio: BooleanProperty = delegate.preserveRatioProperty

  def preserveRatio_=(v: Boolean): Unit = {
    preserveRatio() = v
  }

  def smooth: BooleanProperty = delegate.smoothProperty

  def smooth_=(v: Boolean): Unit = {
    smooth() = v
  }

  def viewport: ObjectProperty[jfxg.Rectangle2D] = delegate.viewportProperty

  def viewport_=(v: Rectangle2D): Unit = {
    viewport() = v
  }

}
