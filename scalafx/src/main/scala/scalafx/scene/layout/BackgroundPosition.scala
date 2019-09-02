/*
 * Copyright (c) 2011-2017, ScalaFX Project
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
import scalafx.geometry.Side

object BackgroundPosition {
  implicit def sfxBackgroundPosition2jfx(v: BackgroundPosition): jfxsl.BackgroundPosition =
    if (v != null) v.delegate else null

  /** A BackgroundPosition which will center a BackgroundImage. */
  val Center: BackgroundPosition = jfxsl.BackgroundPosition.CENTER

  /** The default BackgroundPosition for any BackgroundImage. */
  val Default: BackgroundPosition = jfxsl.BackgroundPosition.DEFAULT
}

/**
  * Represents the position of a BackgroundImage within the Region's drawing area.
  *
  * Wrapper for [[http://docs.oracle.com/javafx/8/api/javafx/scene/layout/BackgroundPosition]]
  */
class BackgroundPosition(override val delegate: jfxsl.BackgroundPosition)
    extends SFXDelegate[jfxsl.BackgroundPosition] {

  /** Creates a new BackgroundPosition. */
  def this(
      horizontalSide: Side,
      horizontalPosition: Double,
      horizontalAsPercentage: Boolean,
      verticalSide: Side,
      verticalPosition: Double,
      verticalAsPercentage: Boolean
  ) =
    this(
      new jfxsl.BackgroundPosition(
        horizontalSide,
        horizontalPosition,
        horizontalAsPercentage,
        verticalSide,
        verticalPosition,
        verticalAsPercentage
      )
    )

  /**
    * The value indicating the position of the BackgroundImage relative to the Region along the
    * side indicated by the horizontalSide property.
    */
  def horizontalPosition: Double = delegate.getHorizontalPosition

  /**
    * The side along the horizontal axis to which the BackgroundImage is anchored.
    */
  def horizontalSide: Side = delegate.getHorizontalSide

  /**
    * The value indicating the position of the BackgroundImage relative to the Region along the
    * side indicated by the verticalSide property.
    */
  def verticalPosition: Double = delegate.getVerticalPosition

  /**
    * The side along the vertical axis to which the BackgroundImage is anchored.
    */
  def verticalSide: Side = delegate.getVerticalSide
}
