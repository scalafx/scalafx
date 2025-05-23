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

import javafx.{animation as jfxa, scene as jfxs, util as jfxu}
import scalafx.Includes.*
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.util.Duration

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.animation.TranslateTransition]].
 *
 * @define TT `TranslateTransition`
 */
object TranslateTransition extends AnimationStatics {

  /**
   * Converts a ScalaFX $TT to a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/TranslateTransition.html $TT]],
   * extracting its delegate.
   *
   * @param v ScalaFX $TT
   * @return JavaFX $TT extracted from `v`.
   */
  implicit def sfxTranslateTransition2jfx(v: TranslateTransition): jfxa.TranslateTransition =
    if (v != null) v.delegate else null

}

/**
 * Wraps a [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/TranslateTransition.html TranslateTransition]].
 *
 * @constructor Creates a new ScalaFX $TT from a JavaFX $TT.
 * @param delegate JavaFX $TT to be delegated.
 *
 * @define TT `TranslateTransition`
 * @define CONST The constructor of $TT
 * @define DUR The duration of the $TT
 * @define DV Default value:
 */
class TranslateTransition(override val delegate: jfxa.TranslateTransition = new jfxa.TranslateTransition())
    extends Transition(delegate)
    with SFXDelegate[jfxa.TranslateTransition] {

  // CONSTRUCTORS

  /**
   * $CONST
   *
   * @param duration $DUR
   */
  def this(duration: Duration) = this(new jfxa.TranslateTransition(duration))

  /**
   * $CONST
   *
   * @param duration $DUR
   * @param node The node which will be translated
   */
  def this(duration: Duration, node: Node) =
    this(new jfxa.TranslateTransition(duration, node))

  // PROPERTIES

  /**
   * $DUR. $DV 400ms
   */
  def duration: ObjectProperty[jfxu.Duration] = delegate.durationProperty

  def duration_=(d: Duration): Unit = {
    duration() = d
  }

  /**
   * The target node of this $TT.
   */
  def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty

  def node_=(n: Node): Unit = {
    node() = n
  }

  /**
   * Specifies the incremented stop X coordinate value, from the start, of this $TT.
   */
  def byX: DoubleProperty = delegate.byXProperty

  def byX_=(x: Double): Unit = {
    byX() = x
  }

  /**
   * Specifies the incremented stop Y coordinate value, from the start, of this $TT.
   */
  def byY: DoubleProperty = delegate.byYProperty

  def byY_=(y: Double): Unit = {
    byY() = y
  }

  /**
   * Specifies the incremented stop Z coordinate value, from the start, of this $TT.
   */
  def byZ: DoubleProperty = delegate.byZProperty

  def byZ_=(z: Double): Unit = {
    byZ() = z
  }

  /**
   * Specifies the start X coordinate value of this $TT. $DV `Double.NaN`
   */
  def fromX: DoubleProperty = delegate.fromXProperty

  def fromX_=(x: Double): Unit = {
    fromX() = x
  }

  /**
   * Specifies the start Y coordinate value of this $TT. $DV `Double.NaN`
   */
  def fromY: DoubleProperty = delegate.fromYProperty

  def fromY_=(y: Double): Unit = {
    fromY() = y
  }

  /**
   * Specifies the start Z coordinate value of this $TT. $DV `Double.NaN`
   */
  def fromZ: DoubleProperty = delegate.fromZProperty

  def fromZ_=(z: Double): Unit = {
    fromZ() = z
  }

  /**
   * Specifies the stop X coordinate value of this $TT. $DV `Double.NaN`
   */
  def toX: DoubleProperty = delegate.toXProperty

  def toX_=(x: Double): Unit = {
    toX() = x
  }

  /**
   * Specifies the stop Y coordinate value of this $TT. $DV `Double.NaN`
   */
  def toY: DoubleProperty = delegate.toYProperty

  def toY_=(y: Double): Unit = {
    toY() = y
  }

  /**
   * Specifies the stop Z coordinate value of this $TT. $DV `Double.NaN`
   */
  def toZ: DoubleProperty = delegate.toZProperty

  def toZ_=(z: Double): Unit = {
    toZ() = z
  }

}
