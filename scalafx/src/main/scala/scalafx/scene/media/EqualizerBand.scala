/*
 * Copyright (c) 2011-2013, ScalaFX Project
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
import scalafx.delegate.SFXDelegate

object EqualizerBand {
  implicit def sfxEqualizerBand2jfx(eb: EqualizerBand) = eb.delegate

  /**
   * Maximum possible gain value.
   */
  val MAX_GAIN = jfxsm.EqualizerBand.MAX_GAIN

  /**
   * Minimum possible gain value.
   */
  val MIN_GAIN = jfxsm.EqualizerBand.MIN_GAIN
}

class EqualizerBand(override val delegate: jfxsm.EqualizerBand = new jfxsm.EqualizerBand)
  extends SFXDelegate[jfxsm.EqualizerBand] {

  /**
   * Custom EqualizerBand constructor.
   */
  def this(centerFrequency: Double, bandwidth: Double, gain: Double) =
    this(new jfxsm.EqualizerBand(centerFrequency, bandwidth, gain))

  /**
   * Bandwidth of the band in Hertz.
   */
  def bandwidth: DoubleProperty = delegate.bandwidthProperty
  def bandwidth_=(v: Double) {
    bandwidth() = v
  }

  /**
   * Center frequency of the band in Hertz.
   */
  def centerFrequency: DoubleProperty = delegate.centerFrequencyProperty
  def centerFrequency_=(v: Double) {
    centerFrequency() = v
  }

  /**
   * The gain to be applied to the frequencies of this band.
   */
  def gain: DoubleProperty = delegate.gainProperty
  def gain_=(v: Double) {
    gain() = v
  }

}