/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.animation

import javafx.{animation => jfxa}
import javafx.{event => jfxe}
import scalafx.Includes._
import scalafx.util.{Duration, SFXDelegate}

trait AnimationStatics {
  def INDEFINITE = jfxa.Animation.INDEFINITE
}

object Animation extends AnimationStatics {
  implicit def sfxAnimation2jfx(v: Animation) = v.delegate
}

abstract class Animation extends SFXDelegate[jfxa.Animation] {
  def autoReverse = delegate.autoReverseProperty
  def autoReverse_=(ar: Boolean) {
    autoReverse() = ar
  }

  def currentRate = delegate.currentRateProperty

  def currentTime = delegate.currentTimeProperty

  def cycleCount = delegate.cycleCountProperty
  def cycleCount_=(r: Int) {
    cycleCount() = r
  }

  def cycleDuration = delegate.cycleDurationProperty

  def delay = delegate.delayProperty
  def delay_=(d: Duration) {
    delay() = d
  }

  def onFinished = delegate.onFinishedProperty
  def onFinished_=(handler: jfxe.EventHandler[jfxe.ActionEvent]) {
    onFinished() = handler
  }

  def rate = delegate.rateProperty
  def rate_=(r: Double) {
    rate() = r
  }

  def status = delegate.statusProperty

  def totalDuration = delegate.totalDurationProperty

  def targetFramerate = delegate.getTargetFramerate
}
