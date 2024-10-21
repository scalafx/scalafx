/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

package scalafx.scene.layout

import javafx.scene.{layout => jfxsl}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.shape.{StrokeLineCap, StrokeLineJoin, StrokeType}

import scala.collection.JavaConverters._
import scala.language.implicitConversions

object BorderStrokeStyle {
  implicit def sfxBorderStrokeStyle2jfx(v: BorderStrokeStyle): jfxsl.BorderStrokeStyle =
    if (v != null) v.delegate else null

  /**
   * A predefined dashed pattern to be used for stroking
   */
  val Dashed: BorderStrokeStyle = jfxsl.BorderStrokeStyle.DASHED

  /**
   * A predefined dotted pattern to be used for stroking
   */
  val Dotted: BorderStrokeStyle = jfxsl.BorderStrokeStyle.DOTTED

  /**
   * Indicates that no stroke should be drawn.
   */
  val None: BorderStrokeStyle = jfxsl.BorderStrokeStyle.NONE

  /**
   * A predefined solid line to be used for stroking
   */
  val Solid: BorderStrokeStyle = jfxsl.BorderStrokeStyle.SOLID
}

/**
 * Defines the style of the stroke to use on one side of a BorderStroke.
 *
 * Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderStrokeStyle.html javafx.scene.layout.BorderStrokeStyle]].
 */
class BorderStrokeStyle(override val delegate: jfxsl.BorderStrokeStyle)
    extends SFXDelegate[jfxsl.BorderStrokeStyle] {

  /**
   * Creates a new BorderStrokeStyle.
   */
  def this(
    strokeType: StrokeType,
    lineJoin: StrokeLineJoin,
    lineCap: StrokeLineCap,
    miterLimit: Double,
    dashOffset: Double,
    dashArray: Seq[java.lang.Double]
  ) =
    this(new jfxsl.BorderStrokeStyle(strokeType, lineJoin, lineCap, miterLimit, dashOffset, dashArray.asJava))

  /**
   * Defines the array representing the lengths of the dash segments.
   */
  def dashArray: Seq[java.lang.Double] = delegate.getDashArray.asScala.toSeq

  /**
   * Defines a distance specified in user coordinates that represents an offset into the dashing pattern.
   */
  def dashOffset: Double = delegate.getDashOffset

  /**
   * The end cap style of this Shape as one of the following values that define possible end cap
   * styles: StrokeLineCap.BUTT, StrokeLineCap.ROUND, and StrokeLineCap.SQUARE.
   */
  def lineCap: StrokeLineCap = delegate.getLineCap

  /**
   * Defines the decoration applied where path segments meet.
   */
  def lineJoin: StrokeLineJoin = delegate.getLineJoin

  /**
   * Defines the limit for the StrokeLineJoin.MITER line join style.
   */
  def miterLimit: Double = delegate.getMiterLimit

  /**
   * Defines the direction (inside, outside, or both) that the strokeWidth
   * is applied to the boundary of the shape.
   */
  def strokeType: StrokeType = delegate.getType
}
