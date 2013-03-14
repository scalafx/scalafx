/*
* Copyright (c) 2012-2013, ScalaFX Project
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
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.IntegerProperty
import scalafx.delegate.SFXDelegate

object AudioClip {
  implicit def sfxAudioClip2jfx(ac: AudioClip) = ac.delegate

  /**
   * When cycleCount is set to this value, the AudioClip will loop continuously until stopped.
   */
  val INDEFINITE = jfxsm.AudioClip.INDEFINITE

}

final class AudioClip(override val delegate: jfxsm.AudioClip) extends SFXDelegate[jfxsm.AudioClip] {

  /**
   * Create an AudioClip loaded from the supplied source URL
   */
  def this(source: String) = this(new jfxsm.AudioClip(source))

  /**
   * The relative left and right volume levels of the clip.
   */
  def balance: DoubleProperty = delegate.balanceProperty
  def balance_=(v: Double) {
    balance() = v
  }

  /**
   * The number of times the clip will be played when play() is called.
   */
  def cycleCount: IntegerProperty = delegate.cycleCountProperty
  def cycleCount_=(v: Int) {
    cycleCount() = v
  }

  /**
   * The relative "center" of the clip.
   */
  def pan: DoubleProperty = delegate.panProperty
  def pan_=(v: Double) {
    pan() = v
  }

  /**
   * The relative priority of the clip with respect to other clips.
   */
  def priority: IntegerProperty = delegate.priorityProperty
  def priority_=(v: Int) {
    priority() = v
  }

  /**
   * The relative rate at which the clip is played.
   */
  def rate: DoubleProperty = delegate.rateProperty
  def rate_=(v: Double) {
    rate() = v
  }

  /**
   * Get the source URL used to create this AudioClip.
   */
  def source = delegate.getSource

  /**
   * The relative volume level at which the clip is played.
   */
  def volume: DoubleProperty = delegate.volumeProperty
  def volume_=(v: Double) {
    volume() = v
  }

}