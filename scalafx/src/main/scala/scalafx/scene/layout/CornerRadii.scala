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
import scalafx.delegate.SFXDelegate

object CornerRadii {
  implicit def sfxCornerRadii2jfx(v: CornerRadii): jfxsl.CornerRadii = if (v != null) v.delegate else null

  /** An empty Background, useful to use instead of null. */
  val Empty = jfxsl.CornerRadii.EMPTY
}

/**
  * Defines the radii of each of the four corners of a BorderStroke.
  */
class CornerRadii(override val delegate: jfxsl.CornerRadii) extends SFXDelegate[jfxsl.CornerRadii] {

  /**
    * Create a new CornerRadii with a single uniform radii value for all components of all corners.
    */
  def this(radius: Double) = this(new jfxsl.CornerRadii(radius))

  /**
    * Create a new CornerRadii with the given radii for each corner.
    */
  def this(radius: Double, asPercent: Boolean) = this(new jfxsl.CornerRadii(radius, asPercent))

  /**
    * Create a new CornerRadii with uniform yet independent radii for each corner.
    */
  def this(topLeft: Double, topRight: Double, bottomRight: Double, bottomLeft: Double, asPercent: Boolean) =
    this(new jfxsl.CornerRadii(topLeft, topRight, bottomRight, bottomLeft, asPercent))

  /**
    * Creates a new `CornerRadii`, allowing for specification of each component of each corner radii
    * and whether each component should be treated as a value or percentage.
    */
  def this(
      topLeftHorizontalRadius: Double,
      topLeftVerticalRadius: Double,
      topRightVerticalRadius: Double,
      topRightHorizontalRadius: Double,
      bottomRightHorizontalRadius: Double,
      bottomRightVerticalRadius: Double,
      bottomLeftVerticalRadius: Double,
      bottomLeftHorizontalRadius: Double,
      topLeftHorizontalRadiusAsPercent: Boolean,
      topLeftVerticalRadiusAsPercent: Boolean,
      topRightVerticalRadiusAsPercent: Boolean,
      topRightHorizontalRadiusAsPercent: Boolean,
      bottomRightHorizontalRadiusAsPercent: Boolean,
      bottomRightVerticalRadiusAsPercent: Boolean,
      bottomLeftVerticalRadiusAsPercent: Boolean,
      bottomLeftHorizontalRadiusAsPercent: Boolean
  ) =
    this(
      new jfxsl.CornerRadii(
        topLeftHorizontalRadius,
        topLeftVerticalRadius,
        topRightVerticalRadius,
        topRightHorizontalRadius,
        bottomRightHorizontalRadius,
        bottomRightVerticalRadius,
        bottomLeftVerticalRadius,
        bottomLeftHorizontalRadius,
        topLeftHorizontalRadiusAsPercent,
        topLeftVerticalRadiusAsPercent,
        topRightVerticalRadiusAsPercent,
        topRightHorizontalRadiusAsPercent,
        bottomRightHorizontalRadiusAsPercent,
        bottomRightVerticalRadiusAsPercent,
        bottomLeftVerticalRadiusAsPercent,
        bottomLeftHorizontalRadiusAsPercent
      )
    )

  /**
    * The length of the horizontal radii of the bottom-left corner.
    */
  def BottomLeftHorizontalRadius: Double = delegate.getBottomLeftHorizontalRadius

  /**
    * The length of the vertical radii of the bottom-left corner.
    */
  def bottomLeftVerticalRadius: Double = delegate.getBottomLeftVerticalRadius

  /**
    * The length of the horizontal radii of the bottom-right corner.
    */
  def bottomRightHorizontalRadius: Double = delegate.getBottomRightHorizontalRadius

  /**
    * The length of the vertical radii of the bottom-right corner.
    */
  def bottomRightVerticalRadius: Double = delegate.getBottomRightVerticalRadius

  /**
    * The length of the horizontal radii of the top-left corner.
    */
  def topLeftHorizontalRadius: Double = delegate.getTopLeftHorizontalRadius

  /**
    * The length of the vertical radii of the top-left corner.
    */
  def topLeftVerticalRadius: Double = delegate.getTopLeftVerticalRadius

  /**
    * The length of the horizontal radii of the top-right corner.
    */
  def topRightHorizontalRadius: Double = delegate.getTopRightHorizontalRadius

  /**
    * The length of the vertical radii of the top-right corner.
    */
  def topRightVerticalRadius: Double = delegate.getTopRightVerticalRadius

}
