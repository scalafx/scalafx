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
import scalafx.geometry.Insets
import scalafx.scene.paint.Paint

object BorderStroke {
  implicit def sfxBorderStroke2jfx(v: BorderStroke): jfxsl.BorderStroke = if (v != null) v.delegate else null

  /**
   * The default Insets to be used with a BorderStroke that does not otherwise define any.
   */
  val DefaultWidths: BorderWidths = jfxsl.BorderStroke.DEFAULT_WIDTHS

  /**
   * The default insets when "medium" is specified
   */
  val Medium: BorderWidths = jfxsl.BorderStroke.MEDIUM

  /**
   * The default insets when "thick" is specified
   */
  val Thick: BorderWidths = jfxsl.BorderStroke.THICK

  /**
   * The default insets when "thin" is specified.
   */
  val Thin: BorderWidths = jfxsl.BorderStroke.THIN
}

/**
 *
 * Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderStroke.html javafx.scene.layout.BorderStroke]].
 */
class BorderStroke(override val delegate: jfxsl.BorderStroke)
  extends SFXDelegate[jfxsl.BorderStroke] {

  /**
   * Creates a new BorderStroke.
   */
  def this(stroke: Paint, style: BorderStrokeStyle, radii: CornerRadii, widths: BorderWidths) =
    this(new jfxsl.BorderStroke(stroke, style, radii, widths))

  /**
   * Create a new BorderStroke, specifying all construction parameters.
   */
  def this(topStroke: Paint, rightStroke: Paint, bottomStroke: Paint, leftStroke: Paint,
           topStyle: BorderStrokeStyle, rightStyle: BorderStrokeStyle,
           bottomStyle: BorderStrokeStyle, leftStyle: BorderStrokeStyle,
           radii: CornerRadii, widths: BorderWidths, insets: Insets) =
    this(new jfxsl.BorderStroke(topStroke, rightStroke, bottomStroke, leftStroke, topStyle,
      rightStyle, bottomStyle, leftStyle, radii, widths, insets))

  /**
   * Defines the fill of bottom side of this border.
   */
  def bottomStroke: Paint = delegate.getBottomStroke

  /**
   * Defines the style of bottom side of this border.
   */
  def bottomStyle: BorderStrokeStyle = delegate.getBottomStyle

  /**
   * Defines the insets of each side of the BorderStroke.
   */
  def insets: Insets = delegate.getInsets

  /**
   * Defines the fill of left side of this border.
   */
  def leftStroke: Paint = delegate.getLeftStroke

  /**
   * Defines the style of left side of this border.
   */
  def leftStyle: BorderStrokeStyle = delegate.getLeftStyle

  /**
   * Defines the radii for each corner of this BorderStroke.
   */
  def radii: CornerRadii = delegate.getRadii

  /**
   * Defines the fill of right side of this border.
   */
  def rightStroke: Paint = delegate.getRightStroke

  /**
   * Defines the style of right side of this border.
   */
  def rightStyle: BorderStrokeStyle = delegate.getRightStyle

  /**
   * Defines the fill of top side of this border.
   */
  def topStroke: Paint = delegate.getTopStroke

  /**
   * Defines the style of top side of this border.
   */
  def topStyle: BorderStrokeStyle = delegate.getTopStyle

  /**
   * Defines the thickness of each side of the BorderStroke.
   */
  def widths: BorderWidths = delegate.getWidths

}