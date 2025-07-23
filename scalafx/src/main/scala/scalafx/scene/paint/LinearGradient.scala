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
package scalafx.scene.paint

import javafx.scene.paint as jfxsp
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate
import scalafx.util.JavaConverters.*

import java.util
import scala.language.implicitConversions

object LinearGradient {
  implicit def sfxLinearGradient2jfx(lg: LinearGradient): jfxsp.LinearGradient = if (lg != null) lg.delegate else null

  /**
   * Creates a new instance of LinearGradient.
   *
   * @param startX  the X coordinate of the gradient axis start point
   * @param startY  the Y coordinate of the gradient axis start point
   * @param endX  the X coordinate of the gradient axis end point
   * @param endY  the Y coordinate of the gradient axis end point
   * @param proportional  whether the coordinates are proportional to the shape which this gradient fills
   * @param cycleMethod  cycle method applied to the gradient
   * @param stops  the gradient's color specification
   */
  def apply(
    startX: Double,
    startY: Double,
    endX: Double,
    endY: Double,
    proportional: Boolean,
    cycleMethod: CycleMethod,
    stops: List[Stop]
  ) =
    new LinearGradient(startX, startY, endX, endY, proportional, cycleMethod, stops.map(_.delegate))

  /**
   * Creates a new instance of LinearGradient.
   *
   * @param startX  the X coordinate of the gradient axis start point
   * @param startY  the Y coordinate of the gradient axis start point
   * @param endX  the X coordinate of the gradient axis end point
   * @param endY  the Y coordinate of the gradient axis end point
   * @param proportional  whether the coordinates are proportional to the shape which this gradient fills
   * @param cycleMethod  cycle method applied to the gradient
   * @param stops  the gradient's color specification
   */
  def apply(
    startX: Double,
    startY: Double,
    endX: Double,
    endY: Double,
    proportional: Boolean,
    cycleMethod: CycleMethod,
    stops: Stop*
  ) =
    new LinearGradient(startX, startY, endX, endY, proportional, cycleMethod, stops.map(_.delegate))

  /**
   * Creates a linear gradient value from a string representation.
   */
  def valueOf(value: String): LinearGradient = jfxsp.LinearGradient.valueOf(value)

}

/**
 */
class LinearGradient(override val delegate: jfxsp.LinearGradient)
    extends Paint(delegate)
    with SFXDelegate[jfxsp.LinearGradient] {

  /**
   * Creates a new instance of LinearGradient.
   *
   * @param startX  the X coordinate of the gradient axis start point.
   *                Default value = 0.0
   * @param startY  the Y coordinate of the gradient axis start point.
   *                Default value = 0.0
   * @param endX  the X coordinate of the gradient axis end point.
   *              Default value = 0.0
   * @param endY  the Y coordinate of the gradient axis end point.
   *              Default value = 0.0
   * @param proportional  whether the coordinates are proportional to the shape
   *                      which this gradient fills. Default value = true
   * @param cycleMethod  cycle method applied to the gradient.
   *                     Default value = [[scalafx.scene.paint.CycleMethod.NoCycle]]
   * @param stops  the gradient's color specification.
   *               Default value = [[scala.Nil]]
   */
  def this(
    startX: Double = 0,
    startY: Double = 0,
    endX: Double = 1,
    endY: Double = 1,
    proportional: Boolean = true,
    cycleMethod: CycleMethod = CycleMethod.NoCycle,
    stops: Seq[jfxsp.Stop] = Nil
  ) =
    this(new jfxsp.LinearGradient(startX, startY, endX, endY, proportional, cycleMethod, stops.asJava))

  /**
   * Defines which of the following cycle method is applied to the
   * LinearGradient: [[scalafx.scene.paint.CycleMethod.NoCycle]],
   * [[scalafx.scene.paint.CycleMethod.Reflect]] or
   * [[scalafx.scene.paint.CycleMethod.Repeat]].
   */
  def cycleMethod: CycleMethod = delegate.getCycleMethod

  /**
   * Defines the X coordinate of the gradient axis end point.
   */
  def endX: Double = delegate.getEndX

  /**
   * Defines the Y coordinate of the gradient axis end point.
   */
  def endY: Double = delegate.getEndY

  /**
   * Defines the X coordinate of the gradient axis start point.
   */
  def startX: Double = delegate.getStartX

  /**
   * Defines the Y coordinate of the gradient axis start point.
   */
  def startY: Double = delegate.getStartY

  /**
   * A sequence of 2 or more Stop values specifying how to distribute the
   * colors along the gradient.
   */
  def stops: util.List[jfxsp.Stop] = delegate.getStops

  /**
   * Indicates whether start and end locations are proportional or absolute.
   */
  def proportional: Boolean = delegate.isProportional

}
