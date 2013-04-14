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
import javafx.util.Duration

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/Interpolator.html $INT]].
 * Really no point wrapping the JavaFX $INT class, so this just exposes the statics.
 *
 * @define INT `Interpolator`
 */
object Interpolator {

  /**
   * Built-in $INT that provides discrete time interpolation.
   */
  def DISCRETE = jfxa.Interpolator.DISCRETE

  /**
   * Built-in $INT instance that provides ease in/out behavior.
   */
  def EASE_BOTH = jfxa.Interpolator.EASE_BOTH

  /**
   * Built-in $INT instance that provides ease in behavior.
   */
  def EASE_IN = jfxa.Interpolator.EASE_IN

  /**
   * Built-in $INT instance that provides ease out behavior.
   */
  def EASE_OUT = jfxa.Interpolator.EASE_OUT

  /**
   * Built-in $INT that provides linear time interpolation.
   */
  def LINEAR = jfxa.Interpolator.LINEAR

  /**
   * Creates an $INT, which `curve()` is shaped using the spline control points defined by `(x1, y1)` and `(x2, y2)`.
   * 
   * @param x1 x coordinate of the first control point
   * @param y1 y coordinate of the first control point
   * @param x2 x coordinate of the second control point
   * @param y2 y coordinate of the second control point
   * @return A spline interpolator
   */
  def SPLINE(x1: Double, y1: Double, x2: Double, y2: Double) = jfxa.Interpolator.SPLINE(x1, y1, x2, y2)

  /**
   * Creates a tangent $INT, for which in-tangent and out-tangent are identical.
   * 
   * @param t The delta time of the tangent
   * @param v The value of the tangent
   * @return the new Tangent interpolator
   */
  def TANGENT(t: Duration, v: Double) = jfxa.Interpolator.TANGENT(t, v)

  /**
   * Create a tangent $INT.
   * 
   * @param t1 The delta time of the in-tangent
   * @param v1 The value of the in-tangent
   * @param t2 The delta time of the out-tangent
   * @param v2 The value of the out-tangent
   * @return the new tangent interpolator
   */
  def TANGENT(t1: Duration, v1: Double, t2: Duration, v2: Double) = jfxa.Interpolator.TANGENT(t1, v1, t2, v2)

}
