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
package scalafx.embed.swing

import java.awt.image.BufferedImage

import javafx.embed.{swing => jfxes}
import scalafx.Includes._
import scalafx.scene.image.Image
import scalafx.scene.image.WritableImage

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/embed/swing/SwingFXUtils.html JavaFX SwingFXUtils]].
 *
 * @since 8.0
 */
object SwingFXUtils {

  /**
   * Snapshots the specified ScalaFX [[scalafx.scene.image.Image Image]] object and stores a copy
   * of its pixels into a BufferedImage object, creating a new object if needed.
   *
   * @param img the JavaFX Image to be converted
   * @param bimg an optional BufferedImage object that may be used to store the returned pixel data
   * @return a BufferedImage containing a snapshot of the JavaFX Image, or `null` if the Image is not readable.
   */
  def fromFXImage(img: Image, bimg: BufferedImage): BufferedImage =
    jfxes.SwingFXUtils.fromFXImage(img, bimg)

  /**
   * Snapshots the specified BufferedImage and stores a copy of its pixels into a ScalaFX
   * [[scalafx.scene.image.Image Image]] object, creating a new object if needed.
   *
   * @param bimg the BufferedImage object to be converted
   * @param wimg an optional WritableImage object that can be used to store the returned pixel data
   * @return an Image object representing a snapshot of the current pixels in the BufferedImage.
   */
  def toFXImage(bimg: BufferedImage, wimg: WritableImage): WritableImage =
    jfxes.SwingFXUtils.toFXImage(bimg, wimg)

  def installFwEventQueue = jfxes.SwingFXUtils.installFwEventQueue

  def removeFwEventQueue = jfxes.SwingFXUtils.removeFwEventQueue

}