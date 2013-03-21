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
package scalafx.scene.image

import java.io.InputStream

import javafx.scene.{ image => jfxsi }
import scalafx.Includes._
import scalafx.beans.property.ReadOnlyBooleanProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.delegate.SFXDelegate

object Image {
  implicit def sfxImage2jfx(i: Image) = i.delegate
}

class Image(override val delegate: jfxsi.Image) extends SFXDelegate[jfxsi.Image] {

  /**
   * Construct an Image which pixels are loaded from the specified input stream.
   */
  def this(inputStream: InputStream) = this(new jfxsi.Image(inputStream))

  /**
   * Construct a new Image with the specified parameters.
   */
  def this(inputStream: InputStream, requestedWidth: Double, requestedHeight: Double, preserveRatio: Boolean, smooth: Boolean) =
    this(new jfxsi.Image(inputStream, requestedWidth, requestedWidth, preserveRatio, smooth))

  /**
   * Construct an Image which pixels are loaded from the specified url.
   */
  def this(url: String) = this(new jfxsi.Image(url))

  /**
   * Construct a new Image with the specified parameters.
   */
  def this(url: String, backgroundLoading: Boolean) = this(new jfxsi.Image(url, backgroundLoading))

  /**
   * Construct a new Image with the specified parameters.
   */
  def this(url: String, requestedWidth: Double, requestedHeight: Double, preserveRatio: Boolean, smooth: Boolean) =
    this(new jfxsi.Image(url, requestedWidth, requestedWidth, preserveRatio, smooth))

  /**
   * Construct a new Image with the specified parameters.
   */
  def this(url: String, requestedWidth: Double, requestedHeight: Double, preserveRatio: Boolean, smooth: Boolean, backgroundLoading: Boolean) =
    this(new jfxsi.Image(url, requestedWidth, requestedWidth, preserveRatio, smooth, backgroundLoading))

  /**
   *
   */
  def this(that: AnyRef, imagePath: String) = this(new jfxsi.Image(that.getClass.getResourceAsStream(imagePath)))

  /**
   * Indicates whether an error was detected while loading an image.
   */
  def error: ReadOnlyBooleanProperty = delegate.errorProperty

  /**
   * The image height or 0 if the image loading fails.
   */
  def height: ReadOnlyDoubleProperty = delegate.heightProperty

  /**
   * The approximate percentage of image's loading that has been completed.
   */
  def progress: ReadOnlyDoubleProperty = delegate.progressProperty

  /**
   * The image width or 0 if the image loading fails.
   */
  def width: ReadOnlyDoubleProperty = delegate.widthProperty

  /**
   * Cancels the background loading of this image.
   */
  def cancel() {
    delegate.cancel()
  }

  /**
   * Indicates whether the image is being loaded in the background.
   */
  def backgroundLoading = delegate.isBackgroundLoading

  /**
   * Indicates whether to preserve the aspect ratio of the original image when
   * scaling to fit the image within the bounding box provided by `width` and
   * `height`.
   */
  def preserveRatio = delegate.isPreserveRatio

  /**
   * This method returns a Option of [[scalafx.scene.image.PixelReader]] that provides access to read
   * the pixels of the image, if the image is readable.
   */
  def pixelReader: Option[PixelReader] = Option(delegate.getPixelReader)

  /**
   * Indicates whether to use a better quality filtering algorithm or a faster
   * one when scaling this image to fit within the bounding box provided by
   * `width` and `height`.
   */
  def smooth = delegate.isSmooth

}