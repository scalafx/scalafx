/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import scala.language.implicitConversions
import javafx.scene.{layout => jfxsl}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.image.Image

object BackgroundImage {
  implicit def sfxBackgroundImage2jfx(v: BackgroundImage) = if (v != null) v.delegate else null
}

/**
 * Defines properties describing how to render an image as the background to some `Region`.
 */
class BackgroundImage(override val delegate: jfxsl.BackgroundImage)
  extends SFXDelegate[jfxsl.BackgroundImage] {

  /**
   * Creates a new BackgroundImage.
   */
  def this(image: Image, repeatX: BackgroundRepeat, repeatY: BackgroundRepeat,
           position: BackgroundPosition, size: BackgroundSize) =
    this(new jfxsl.BackgroundImage(image, repeatX, repeatY, position, size))

  /**
   * The image to be used.
   */
  def image: Image = delegate.getImage

  /**
   * The position of this BackgroundImage relative to the Region.
   */
  def position: BackgroundPosition = delegate.getPosition

  /**
   * Indicates in what manner (if at all) the background image is to be repeated along the x-axis of the region.
   */
  def repeatX: BackgroundRepeat = delegate.getRepeatX

  /**
   * Indicates in what manner (if at all) the background image is to be repeated along the y-axis of the region.
   */
  def repeatY: BackgroundRepeat = delegate.getRepeatY

  /**
   * The size of this image relative to the Region.
   */
  def size: BackgroundSize = delegate.getSize
}
