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

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object WritableImage {
  implicit def sfxWritableImage2jfx(wi: WritableImage): jfxsi.WritableImage = if (null == wi) null else wi.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/WritableImage.html]]
 */
class WritableImage(override val delegate: jfxsi.WritableImage)
    extends Image(delegate)
    with SFXDelegate[jfxsi.WritableImage] {

  /**
   * Construct an empty image of the specified dimensions.
   */
  def this(width: Int, height: Int) = this(new jfxsi.WritableImage(width, height))

  /**
   * Construct an image of the specified dimensions, initialized from the indicated
   * [[scalafx.scene.image.PixelReader]].
   */
  def this(reader: PixelReader, width: Int, height: Int) = this(new jfxsi.WritableImage(reader, width, height))

  /**
   * Construct an image of the specified dimensions, initialized from the indicated region of the
   * [[scalafx.scene.image.PixelReader]].
   */
  def this(reader: PixelReader, x: Int, y: Int, width: Int, height: Int) =
    this(new jfxsi.WritableImage(reader, x, y, width, height))

  /**
   * This method returns a PixelWriter that provides access to write the pixels of the image.
   */
  def pixelWriter: PixelWriter = delegate.getPixelWriter
  @deprecated("Method name is incorrect use `pixelWriter`.", "8.0.60-R10")
  def pixelWrit: PixelWriter = delegate.getPixelWriter

}
