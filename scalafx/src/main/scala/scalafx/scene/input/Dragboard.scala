/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

package scalafx.scene.input

import javafx.scene.{input => jfxsi}
import scalafx.delegate.SFXDelegate
import scalafx.scene.image.Image
import scalafx.scene.image.ImageIncludes.jfxImage2sfx

import scala.collection.JavaConverters._
import scala.collection.Set
import scala.language.implicitConversions

/**
  * Object companion for [[scalafx.scene.input.Dragboard]].
  */
object Dragboard {
  implicit def sfxDragboard2jfx(d: Dragboard): jfxsi.Dragboard = if (d != null) d.delegate else null
}

/**
  * Wraps a $JFX [[ $URL0 $FC]].
  *
  * @constructor Creates a new $FC from a $JFX one.
  * @param delegate A $JFX $FC to be wrapped. Its default value is a new $JFX $FC.
  * @define FC   Dragboard
  * @define URL0 http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/Dragboard.html
  * @define JFX  JavaFX
  */
class Dragboard(override val delegate: jfxsi.Dragboard) extends Clipboard(delegate) with SFXDelegate[jfxsi.Dragboard] {

  /** The image used as a drag view. */
  def dragView: Image = delegate.getDragView
  def dragView_=(image: Image): Unit = {
    delegate.setDragView(image)
  }

  /**
    * Sets the visual representation of data being transfered in a drag and drop gesture.
    */
  def dragView_=(image: Image, offsetX: Double, offsetY: Double): Unit = {
    delegate.setDragView(image)
  }

  /** The x position of the cursor of the drag view image. */
  def dragViewOffsetX: Double = delegate.getDragViewOffsetX
  def dragViewOffsetX_=(offsetX: Double): Unit = {
    delegate.setDragViewOffsetX(offsetX)
  }

  /** The y position of the cursor of the drag view image. */
  def dragViewOffsetY: Double = delegate.getDragViewOffsetY
  def dragViewOffsetY_=(offsetY: Double): Unit = {
    delegate.setDragViewOffsetY(offsetY)
  }

  /** Transport modes supported by source of this drag operation. */
  def transferModes: Set[jfxsi.TransferMode] = delegate.getTransferModes.asScala

}
