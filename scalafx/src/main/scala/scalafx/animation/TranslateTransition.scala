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

import javafx.{ animation => jfxa, scene => jfxs, util => jfxu }
import scalafx.util.Duration
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty

object TranslateTransition extends AnimationStatics {
  implicit def sfxTranslateTransition2jfx(v: TranslateTransition) = v.delegate
}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/TranslateTransition.html TranslateTransition]].
 */
class TranslateTransition(override val delegate: jfxa.TranslateTransition = new jfxa.TranslateTransition())
  extends Transition(delegate)
  with SFXDelegate[jfxa.TranslateTransition] {

  /**
   * The constructor of TranslateTransition
   *
   * @param duration The duration of the TranslateTransition
   */
  def this(duration: Duration) = this(new jfxa.TranslateTransition(duration))

  /**
   * The constructor of RotateTransition
   *
   * @param duration The duration of the TranslateTransition
   * @param node The node which will be translated
   */
  def this(duration: Duration, node: Node) =
    this(new jfxa.TranslateTransition(duration, node))

  /**
   * The duration of this TranslateTransition.
   */
  def duration: ObjectProperty[jfxu.Duration] = delegate.durationProperty
  def duration_=(d: Duration) {
    duration() = d
  }

  /**
   * The target node of this TranslateTransition.
   */
  def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty
  def node_=(n: Node) {
    node() = n
  }

  /**
   * Specifies the incremented stop X coordinate value, from the start, of
   * this TranslateTransition.
   */
  def byX: DoubleProperty = delegate.byXProperty
  def byX_=(x: Double) {
    byX() = x
  }

  /**
   * Specifies the incremented stop Y coordinate value, from the start, of
   * this TranslateTransition.
   */
  def byY: DoubleProperty = delegate.byYProperty
  def byY_=(y: Double) {
    byY() = y
  }

  /**
   * Specifies the incremented stop Z coordinate value, from the start, of
   * this TranslateTransition.
   */
  def byZ: DoubleProperty = delegate.byZProperty
  def byZ_=(z: Double) {
    byZ() = z
  }

  /**
   * Specifies the start X coordinate value of this TranslateTransition.
   */
  def fromX: DoubleProperty = delegate.fromXProperty
  def fromX_=(x: Double) {
    fromX() = x
  }

  /**
   * Specifies the start Y coordinate value of this TranslateTransition.
   */
  def fromY: DoubleProperty = delegate.fromYProperty
  def fromY_=(y: Double) {
    fromY() = y
  }

  /**
   * Specifies the start Z coordinate value of this TranslateTransition.
   */
  def fromZ: DoubleProperty = delegate.fromZProperty
  def fromZ_=(z: Double) {
    fromZ() = z
  }

  /**
   * Specifies the stop X coordinate value of this TranslateTransition.
   */
  def toX: DoubleProperty = delegate.toXProperty
  def toX_=(x: Double) {
    toX() = x
  }

  /**
   * Specifies the stop Y coordinate value of this TranslateTransition.
   */
  def toY: DoubleProperty = delegate.toYProperty
  def toY_=(y: Double) {
    toY() = y
  }

  /**
   * Specifies the stop Z coordinate value of this TranslateTransition.
   */
  def toZ: DoubleProperty = delegate.toZProperty
  def toZ_=(z: Double) {
    toZ() = z
  }
}