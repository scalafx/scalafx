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
package scalafx.animation

import javafx.{animation => jfxa, scene => jfxs, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.util.Duration

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.animation.FadeTransition]].
 *
 * @define
 *   FT `FadeTransition`
 */
object FadeTransition extends AnimationStatics {

  /**
   * Converts a ScalaFX $FT to a JavaFX
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/FadeTransition.html$FT]], extracting its delegate.
   *
   * @param v
   *   ScalaFX $FT
   * @return
   *   Delegated JavaFX $FT extracted from `v`.
   */
  implicit def sfxFadeTransition2jfx(v: FadeTransition): jfxa.FadeTransition = if (v != null) v.delegate else null

}

/**
 * Wraps a [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/FadeTransition.html$FT]].
 *
 * @constructor
 *   Creates a new ScalaFX $FT from a JavaFX $FT.
 * @param delegate
 *   JavaFX $FT to be delegated.
 *
 * @define
 *   FT `FadeTransition`
 * @define
 *   DV Default value:
 */
class FadeTransition(override val delegate: jfxa.FadeTransition = new jfxa.FadeTransition)
    extends Transition(delegate)
    with SFXDelegate[jfxa.FadeTransition] {

  // CONSTRUCTORS

  /**
   * The constructor of $FT.
   *
   * @param duration
   *   The duration of the $FT.
   */
  def this(duration: Duration) = this(new jfxa.FadeTransition(duration))

  /**
   * The constructor of $FT.
   *
   * @param duration
   *   The duration of the $FT.
   * @param node
   *   The node which opacity will be animated
   */
  def this(duration: Duration, node: Node) = this(new jfxa.FadeTransition(duration, node))

  // PROPERTIES

  /**
   * Specifies the incremented stop opacity value, from the start, of this $FT.
   */
  def byValue: DoubleProperty = delegate.byValueProperty

  def byValue_=(by: Double): Unit = {
    byValue() = by
  }

  /**
   * The duration of this $FT. $DV 400ms
   */
  def duration: ObjectProperty[jfxu.Duration] = delegate.durationProperty

  def duration_=(d: Duration): Unit = {
    duration() = d
  }

  /**
   * Specifies the start opacity value for this $FT. $DV Double.NaN
   */
  def fromValue: DoubleProperty = delegate.fromValueProperty

  def fromValue_=(from: Double): Unit = {
    fromValue() = from
  }

  /**
   * The target node of this `Transition`.
   */
  def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty

  def node_=(n: Node): Unit = {
    node() = n
  }

  /**
   * Specifies the stop opacity value for this $FT. $DV Double.NaN
   */
  def toValue: DoubleProperty = delegate.toValueProperty

  def toValue_=(to: Double): Unit = {
    toValue() = to
  }

  // METHODS

}
