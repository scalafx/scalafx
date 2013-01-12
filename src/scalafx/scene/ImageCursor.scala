/*
 * Copyright (c) 2012, ScalaFX Project
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

import javafx.scene.{image => jfxsi}
import javafx.{scene => jfxs}
import scalafx.scene.image.Image._
import scalafx.scene.image.Image
import scalafx.delegate.SFXDelegate

object ImageCursor {
  implicit def sfxImageCursor2jfx(c: ImageCursor) = c.delegate

  /**
   * Creates a custom image cursor from one of the specified images.
   */
  def chooseBestCursor(images: Array[jfxsi.Image], hotspotX: Double, hotspotY: Double) =
    jfxs.ImageCursor.chooseBestCursor(images, hotspotX, hotspotX)

  /**
   * Gets the supported cursor size that is closest to the specified preferred size.
   */
  def getBestSize(preferredWidth: Double, preferredHeight: Double) =
    jfxs.ImageCursor.getBestSize(preferredWidth, preferredHeight)

  /**
   * Returns the maximum number of colors supported in a custom image cursor palette.
   */
  def getMaximumColors = jfxs.ImageCursor.getMaximumColors

}

class ImageCursor(override val delegate: jfxs.ImageCursor = new jfxs.ImageCursor)
  extends Cursor(delegate) with SFXDelegate[jfxs.ImageCursor] {

  /**
   * Constructs an ImageCursor from the specified image.
   */
  def this(image: Image) = this(new jfxs.ImageCursor(image))

  /**
   * Constructs an ImageCursor from the specified image and hotspot coordinates.
   */
  def this(image: Image, hotspotX: Double, hotspotY: Double) =
    this(new jfxs.ImageCursor(image, hotspotX, hotspotY))

  /**
   * The X coordinate of the cursor's hot spot.
   */
  def hotspotX = delegate.hotspotXProperty

  /**
   * The Y coordinate of the cursor's hot spot.
   */
  def hotspotY = delegate.hotspotYProperty

  /**
   * The image to display when the cursor is active.
   */
  def image = delegate.imageProperty

}