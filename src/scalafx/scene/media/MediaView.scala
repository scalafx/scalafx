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
package scalafx.scene.media

import javafx.scene.{ media => jfxsm }
import javafx.{ event => jfxe }
import scalafx.Includes._
import scalafx.util.Duration
import scalafx.util.SFXDelegate
import scalafx.scene.Node
import scalafx.geometry.Rectangle2D

object MediaView {
  implicit def sfxMediaView2jfx(mv: MediaView) = mv.delegate
}

class MediaView(override val delegate: jfxsm.MediaView = new jfxsm.MediaView) extends Node(delegate) with SFXDelegate[jfxsm.MediaView] {

  /**
   * Creates a MediaView instance associated with the specified MediaPlayer.
   */
  def this(mediaPlayer: MediaPlayer) = this(new jfxsm.MediaView(mediaPlayer))

  /**
   * Determines the height of the bounding box within which the source media is resized as
   * necessary to fit.
   */
  def fitHeight = delegate.fitHeightProperty
  def fitHeight_=(v: Double) {
    fitHeight() = v
  }

  /**
   * Determines the width of the bounding box within which the source media is resized as
   * necessary to fit.
   */
  def fitWidth = delegate.fitWidthProperty
  def fitWidth_=(v: Double) {
    fitWidth() = v
  }

  /**
   * The mediaPlayer whose output will be handled by this view.
   */
  def mediaPlayer = delegate.mediaPlayerProperty
  def mediaPlayer_=(v: MediaPlayer) {
    mediaPlayer() = v
  }

  /**
   * Event handler to be invoked whenever an error occurs on this MediaView.
   */
  def onError = delegate.onErrorProperty
  def onError_=(v: jfxe.EventHandler[jfxsm.MediaErrorEvent]) {
    onError() = v
  }

  /**
   * Whether to preserve the aspect ratio (width / height) of the media when scaling it to fit the
   * node.
   */
  def preserveRatio = delegate.preserveRatioProperty
  def preserveRatio_=(v: Boolean) {
    preserveRatio() = v
  }

  /**
   * If set to true a better quality filtering algorithm will be used when scaling this video to
   * fit within the bounding box provided by fitWidth and fitHeight or when transforming.
   */
  def smooth = delegate.smoothProperty
  def smooth_=(v: Boolean) {
    smooth() = v
  }

  /**
   * Specifies a rectangular viewport into the media frame.
   */
  def viewport = delegate.viewportProperty
  def viewport_=(v: Rectangle2D) {
    viewport() = v
  }

  /**
   * Defines the current x coordinate of the MediaView origin.
   */
  def x = delegate.xProperty
  def x_=(v: Double) {
    x() = v
  }

  /**
   * Defines the current y coordinate of the MediaView origin.
   */
  def y = delegate.yProperty
  def y_=(v: Double) {
    y() = v
  }

}