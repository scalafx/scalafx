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
package scalafx.animation

import javafx.{ animation => jfxa }
import scalafx.util.Duration

object AnimationIncludes extends AnimationIncludes

/**
 * Contains implicit methods to convert classes from
 * [[http://docs.oracle.com/javafx/2/api/javafx/animation/package-summary.html `javafx.animation`]] classes to their
 * respective ScalaFX versions.
 *
 * @define INTERP [[http://docs.oracle.com/javafx/2/api/javafx/animation/Interpolatable.html `Interpolatable`]]
 * @define INTERPM `interpolate` method
 * @define GENERATE Generates a ScalaFX
 * @define FROM from its JavaFX counterparty.
 */
trait AnimationIncludes {

  /**
   *
   * @param time Dutarion time
   * @param v Function which returns a [[scalafx.animation.KeyValue]] [[scala.Set]]
   * @return new KeyFrame
   */
  def at(time: Duration)(v: => Set[KeyValue[_, _ <: Object]]) = KeyFrame(time, values = v)

  /**
   * Wraps a [[scalafx.animation.KeyValue]] in a `Set`.
   *
   * @param kv `KeyValue` to be injected.
   * @return `Set` wrapping the `KeyValue`
   */
  implicit def wrapKeyValueInSet[T, J <: Object](kv: KeyValue[T, J]) = Set[KeyValue[_, _ <: Object]](kv)

  /**
   * Wraps a [[scalafx.animation.Tweenable]] in a `Set`.
   *
   * @param t `Tweenable` to be injected.
   * @return `Set` wrapping the `Tweenable`
   */
  implicit def wrapTweenableInSet[T, J <: Object](t: Tweenable[T, J]) = Set[KeyValue[_, _ <: Object]](t.linear)

  /**
   * Converts a `Set` of [[scalafx.animation.Tweenable]]s in a `Set` of [[scalafx.animation.KeyValue]]s.
   *
   * @param ts `Set` of [[scalafx.animation.Tweenable]]s
   * @return `Set` of [[scalafx.animation.KeyValue]]s.
   */
  implicit def tweenableSet2KeyValueSet(ts: Set[Tweenable[_, _ <: Object]]) = ts.map(_.linear)

  /**
   * Wraps a [[scalafx.animation.KeyFrame]] in a `Seq`.
   *
   * @param kf `KeyFrame` to be wrapped.
   * @return `Seq` wrapping the `KeyFrame`.
   */
  implicit def wrapKeyFrameInSeq[T <: KeyFrame](kf: T) = Seq[T](kf)

  /**
   * Converts a $INTERP to a [[scala.Function2]].
   *
   * @tparam T type of function
   * @param i $INTERP instance
   * @return A [[scala.Function2]] that receives a instance of T and a Double (between 0.0 and 1.0) and returns a T Instance
   * according $INTERPM
   */
  implicit def jfxInterpolatable2sfxFunction2[T](i: jfxa.Interpolatable[T]): ((T, Double) => T) =
    (endValue: T, t: Double) => i.interpolate(endValue, t)

  /**
   * Converts a [[scala.Function2]] to a $INTERP Implementation.
   *
   * @tparam T Type of Function
   * @param f Function that receives a instance of T and a Double (between 0.0 and 1.0) and returns a T Instance.
   * @return A new instance of $INTERP which $INTERPM calls `f` function.
   */
  implicit def sfxFunction2jfxInterpolatable[T](f: ((T, Double) => T)): jfxa.Interpolatable[T] = new jfxa.Interpolatable[T] {
    def interpolate(endValue: T, t: Double): T = f(endValue, t)
  }

  /**
   * $GENERATE `Animation` $FROM
   */
  implicit def jfxAnimation2sfx(v: jfxa.Animation) = new Animation(v) {}

  /**
   * $GENERATE `Animation.Status` $FROM
   */
  implicit def jfxAnimationStatus2sfx(v: jfxa.Animation.Status) = Animation.Status.jfxEnum2sfx(v)

  /**
   * $GENERATE `AnimationTimer` $FROM
   */
  implicit def jfxAnimationTimer2sfx(at: jfxa.AnimationTimer) = new AnimationTimer(at) {}

  /**
   * $GENERATE `FadeTransition` $FROM
   */
  implicit def jfxFadeTransition2sfx(v: jfxa.FadeTransition) = new FadeTransition(v)

  /**
   * $GENERATE `FillTransition` $FROM
   */
  implicit def jfxFillTransition2sfx(v: jfxa.FillTransition) = new FillTransition(v)

  /**
   * $GENERATE `KeyFrame` $FROM
   */
  implicit def jfxKeyFrame2sfx(v: jfxa.KeyFrame) = new KeyFrame(v)

  /**
   * $GENERATE `KeyValue` $FROM
   */
  implicit def jfxKeyValue2sfx(v: jfxa.KeyValue) = new KeyValue(v)

  /**
   * $GENERATE `ParallelTransition` $FROM
   */
  implicit def jfxParallelTransition2sfx(v: jfxa.ParallelTransition) = new ParallelTransition(v)

  /**
   * $GENERATE `PathTransition` $FROM
   */
  implicit def jfxPathTransition2sfx(v: jfxa.PathTransition) = new PathTransition(v)

  /**
   * $GENERATE `PathTransition.OrientationType` $FROM
   */
  implicit def jfxPathTransitionOrientationType2sfx(v: jfxa.PathTransition.OrientationType) = new PathTransition.OrientationType(v)

  /**
   * $GENERATE `PauseTransition` $FROM
   */
  implicit def jfxPauseTransition2sfx(v: jfxa.PauseTransition) = new PauseTransition(v)

  /**
   * $GENERATE `RotateTransition` $FROM
   */
  implicit def jfxRotateTransition2sfx(v: jfxa.RotateTransition) = new RotateTransition(v)

  /**
   * $GENERATE `ScaleTransition` $FROM
   */
  implicit def jfxScaleTransition2sfx(v: jfxa.ScaleTransition) = new ScaleTransition(v)

  /**
   * $GENERATE `SequentialTransition` $FROM
   */
  implicit def jfxSequentialTransition2sfx(v: jfxa.SequentialTransition) = new SequentialTransition(v)

  /**
   * $GENERATE `StrokeTransition` $FROM
   */
  implicit def jfxStrokeTransition2sfx(v: jfxa.StrokeTransition) = new StrokeTransition(v)

  /**
   * $GENERATE `Timeline` $FROM
   */
  implicit def jfxTimeline2sfx(v: jfxa.Timeline) = new Timeline(v)

  /**
   * $GENERATE `Transition` $FROM
   */
  implicit def jfxTransition2sfx(v: jfxa.Transition) = new Transition(v) {}

  /**
   * $GENERATE `TranslateTransition` $FROM
   */
  implicit def jfxTranslateTransition2sfx(v: jfxa.TranslateTransition) = new TranslateTransition(v)
}