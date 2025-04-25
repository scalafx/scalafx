/*
 * Copyright (c) 2011-2025, ScalaFX Project
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
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scalafx.util.JavaConverters._
import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.animation.Timeline]].
 *
 * @define TM `Timeline`
 */
object Timeline extends AnimationStatics {

  /**
   * Converts a ScalaFX $TM to a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html $TM]],
   * extracting its delegate.
   *
   * @param v ScalaFX $TM
   * @return JavaFX $TM extracted from `v`.
   */
  implicit def sfxTimeline2jfx(v: Timeline): jfxa.Timeline = if (v != null) v.delegate else null

  /**
   * Creates a new $TM from a sequence of [[scalafx.animation.KeyFrame]]s.
   *
   * @param keyFrames sequence of [[scalafx.animation.KeyFrame]]s.
   * @return A new $TM
   */
  def apply(keyFrames: Seq[_ <: KeyFrame]): Timeline = {
    def kf: Seq[_ <: KeyFrame] = keyFrames

    new Timeline {
      super.keyFrames = kf
    }
  }
}

/**
 * Wraps a [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html Timeline]].
 *
 * @constructor Creates a new ScalaFX $TM from a JavaFX $TM.
 * @param delegate JavaFX $TM to be delegated.
 *
 * @define TM `Timeline`
 * @define CONST The constructor of $TM
 * @define KF The [[scalafx.animation.KeyFrame]]s of this $TM.
 * @define DV Default value:
 */
class Timeline(override val delegate: jfxa.Timeline = new jfxa.Timeline())
    extends Animation(delegate)
    with SFXDelegate[jfxa.Timeline] {

  // CONSTRUCTORS

  /**
   * $CONST
   *
   * @param targetFramerate The custom target frame rate for this $TM
   */
  def this(targetFramerate: Double) = this(new jfxa.Timeline(targetFramerate))

  /**
   * $CONST
   *
   * @param targetFramerate The custom target frame rate for this $TM
   * @param keyFrames $KF
   */
  def this(targetFramerate: Double, keyFrames: Seq[_ <: KeyFrame]) = {
    // HACK: for some reason this does not compile with scala 2.10.0-M7
    // this(new jfxa.Timeline(targetFramerate, keyFrames.map(_.delegate).toArray: _*))
    // solution from https://github.com/scalafx/scalafx/issues/7
    // this(new jfxa.Timeline(targetFramerate, keyFrames.map { kf: KeyFrame => kf.delegate } : _*))
    this(new jfxa.Timeline(targetFramerate, keyFrames.map((keyFrame: KeyFrame) => keyFrame.delegate).toArray: _*))
  }

  // PROPERTIES

  /**
   * $KF
   */
  def keyFrames: ObservableBuffer[jfxa.KeyFrame] = delegate.getKeyFrames

  def keyFrames_=(kfs: Seq[_ <: KeyFrame]): Unit = {
    val mapped = kfs.map((x: KeyFrame) => x.delegate)
    keyFrames.setAll(mapped.asJava)
  }

}
