/*
 * Copyright (c) 2012, ScalaFX Project
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

import javafx.scene.{ paint => jfxsp }
import scala.collection.JavaConversions._
import scalafx.delegate.SFXDelegate

object RadialGradient {
  implicit def sfxRadialGradient2jfx(rg: RadialGradient) = rg.delegate

  /**
   * Creates a radial gradient value from a string representation.
   */
  def valueOf(value: String) = jfxsp.RadialGradient.valueOf(value)

  def apply(focusAngle: Double, focusDistance: Double, centerX: Double, centerY: Double, radius: Double, proportional: Boolean, cycleMethod: CycleMethod, stops: List[Stop]) { 
    val stopsList = new java.util.ArrayList[jfxsp.Stop](stops.length)
    for (stop <- stops) stopsList.add(stop)
    new RadialGradient(new jfxsp.RadialGradient(focusAngle, focusDistance, centerX, centerY, radius, proportional, cycleMethod, stopsList))
  }

/* This should work but it looks like it calls the constructor that 
 * uses List instead of the one that uses variable arguments
  def apply(focusAngle: Double, focusDistance: Double, centerX: Double, centerY: Double, radius: Double, proportional: Boolean, cycleMethod: CycleMethod, stops: Stop*) =
    new RadialGradient(new jfxsp.RadialGradient(focusAngle, focusDistance, centerX, centerY, radius, proportional, cycleMethod, stops: _*))
 */
  def apply(focusAngle: Double, focusDistance: Double, centerX: Double, centerY: Double, radius: Double, proportional: Boolean, cycleMethod: CycleMethod, stops: Stop*) { 
    val stopsList = new java.util.ArrayList[jfxsp.Stop](stops.length)
    for (stop <- stops) stopsList.add(stop)
    new RadialGradient(new jfxsp.RadialGradient(focusAngle, focusDistance, centerX, centerY, radius, proportional, cycleMethod, stopsList))
  }
}

class RadialGradient(override val delegate: jfxsp.RadialGradient) extends Paint(delegate) with SFXDelegate[jfxsp.RadialGradient] {

  def this(focusAngle: Double, focusDistance: Double, centerX: Double, centerY: Double, radius: Double, proportional: Boolean, cycleMethod: jfxsp.CycleMethod, stops: Seq[jfxsp.Stop]) =
    this(new jfxsp.RadialGradient(focusAngle, focusDistance, centerX, centerY, radius, proportional, cycleMethod, stops))

  /**
   * Defines the X coordinate of the center point of the circle defining the gradient.
   */
  def centerX = delegate.getCenterX

  /**
   * Defines the Y coordinate of the center point of the circle defining the gradient.
   */
  def centerY = delegate.getCenterY

  /**
   * Defines which of the follwing cycle method is applied to the LinearGradient: CycleMethod.NO_CYCLE, CycleMethod.REFLECT, or CycleMethod.REPEAT.
   */
  def cycleMethod = delegate.getCycleMethod

  /**
   * Defines the angle in degrees from the center of the gradient to the focus point to which the first color is mapped.
   */
  def focusAngle = delegate.getFocusAngle

  /**
   * Defines the distance from the center of the gradient to the focus point to which the first color is mapped.
   */
  def focusDistance = delegate.getFocusDistance

  /**
   * Indicates whether the center and radius values are proportional or absolute.
   */
  def proportional = delegate.isProportional

  /**
   * Specifies the radius of the circle defining the extents of the color gradient.
   */
  def radius = delegate.getRadius

  /**
   * A sequence of 2 or more Stop values specifying how to distribute the colors along the gradient.
   */
  def stops = delegate.getStops

}