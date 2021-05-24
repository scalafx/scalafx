/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object BorderWidths {
  implicit def sfxBorderWidths2jfx(v: BorderWidths): jfxsl.BorderWidths = if (v != null) v.delegate else null

  /**
   * When used by a BorderStroke, the value of AUTO is interpreted as the value of BorderStroke.MEDIUM for the
   * corresponding side.
   */
  val Auto: Double = jfxsl.BorderWidths.AUTO

  /**
   * The default BorderWidths that is used by a BorderImage when null is specified.
   */
  val Default: BorderWidths = jfxsl.BorderWidths.DEFAULT

  /**
   * An empty set of widths, such that all values are 0 and are literal values.
   */
  val Empty: BorderWidths = jfxsl.BorderWidths.EMPTY

  /**
   * A set of widths representing 100% on each side.
   */
  val Full: BorderWidths = jfxsl.BorderWidths.FULL
}

/**
 * Defines widths for four components (top, right, bottom, and left).
 */
class BorderWidths(override val delegate: jfxsl.BorderWidths) extends SFXDelegate[jfxsl.BorderWidths] {

  /**
   * Creates a new BorderWidths using the given width for all four borders, and treating this width as a literal value,
   * and not a percentage.
   */
  def this(width: Double) = this(new jfxsl.BorderWidths(width))

  /**
   * Creates a new BorderWidths with the specified widths for top, right, bottom, and left.
   */
  def this(top: Double, right: Double, bottom: Double, left: Double) =
    this(new jfxsl.BorderWidths(top, right, bottom, left))

  /**
   * Creates a new BorderWidths.
   */
  def this(
      top: Double,
      right: Double,
      bottom: Double,
      left: Double,
      topAsPercentage: Boolean,
      rightAsPercentage: Boolean,
      bottomAsPercentage: Boolean,
      leftAsPercentage: Boolean
  ) =
    this(
      new jfxsl.BorderWidths(
        top,
        right,
        bottom,
        left,
        topAsPercentage,
        rightAsPercentage,
        bottomAsPercentage,
        leftAsPercentage
      )
    )

  /**
   * The non-negative value (with the exception of AUTO) indicating the border thickness on the bottom of the border.
   */
  def bottom: Double = delegate.getBottom

  /**
   * The non-negative value (with the exception of AUTO) indicating the border thickness on the left of the border.
   */
  def left: Double = delegate.getLeft

  /**
   * The non-negative value (with the exception of AUTO) indicating the border thickness on the right of the border.
   */
  def right: Double = delegate.getRight

  /**
   * A non-negative value (with the exception of AUTO) indicating the border thickness on the top of the border.
   */
  def top: Double = delegate.getTop
}
