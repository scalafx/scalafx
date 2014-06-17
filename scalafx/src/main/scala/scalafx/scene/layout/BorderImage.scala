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
import scalafx.geometry.Insets

object BorderImage {
  implicit def sfxBackground2jfx(v: BorderImage) = v.delegate
}

/**
 * Defines properties describing how to render an image as the background to some
 * [[scalafx.scene.layout.Region]].
 */
class BorderImage(override val delegate: jfxsl.BorderImage)
  extends SFXDelegate[jfxsl.BorderImage] {

  /**
   * Creates a new BackgroundImage.Defines properties describing how to render an image as
   * the border of some Region.
   */
    def this(image: Image,   widths:BorderWidths,  insets:Insets,  slices:BorderWidths,
             filled:Boolean, repeatX: BorderRepeat, repeatY: BorderRepeat) =
      this(new jfxsl.BorderImage(image, widths, insets, slices, filled, repeatX, repeatY))

  /**
   * The image to be used.
   */
  def image: Image = delegate.getImage

  /**
   * The insets of the BorderImage define where the border should be positioned relative
   * to the edge of the Region.
   */
  def insets :Insets 	= delegate.getInsets

  /**
   * Indicates in what manner (if at all) the background image is to be repeated along
   * the x-axis of the region.
   */
  def repeatX: BorderRepeat = delegate.getRepeatX

  /**
   * Indicates in what manner (if at all) the background image is to be repeated along
   * the y-axis of the region.
   */
  def repeatY: BorderRepeat = delegate.getRepeatY

  /**
   * Defines the slices of the image.@return
   */
  def slices : BorderWidths 	= delegate.getSlices

  /**
   * The widths of the border on each side.
   */
  def widths : BorderWidths 	= delegate.getWidths

}
