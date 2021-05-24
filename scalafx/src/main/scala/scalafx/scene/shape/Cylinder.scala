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
package scalafx.scene.shape

import javafx.scene.{shape => jfxss}
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Cylinder {
  implicit def sfxCylinder2jfx(c: Cylinder): jfxss.Cylinder = if (c != null) c.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/shape/Cylinder.html]].
 */
class Cylinder(override val delegate: jfxss.Cylinder = new jfxss.Cylinder())
    extends Shape3D(delegate)
    with SFXDelegate[jfxss.Cylinder] {

  /**
   * Creates a new instance of Cylinder of a given radius and height. Resolution defaults to 15 divisions along X and Z
   * axis.
   */
  def this(radius: Double, height: Double) = this(new jfxss.Cylinder(radius, height))

  /**
   * Creates a new instance of Cylinder of a given radius, height, and divisions. Resolution defaults to 15 divisions
   * along X and Z axis. Note that divisions should be at least 3. Any value less than that will be clamped to 3.
   */
  def this(radius: Double, height: Double, divisions: Int) = this(new jfxss.Cylinder(radius, height, divisions))

  /** Divisions attribute use to generate this cylinder. */
  def divisions: Int = delegate.getDivisions

  /** Defines the height or the Y dimension of the cylinder. */
  def height: DoubleProperty = delegate.heightProperty

  def height_=(v: Double): Unit = {
    height() = v
  }

  /** Defines the radius in the Z plane of the cylinder. */
  def radius: DoubleProperty = delegate.radiusProperty

  def radius_=(v: Double): Unit = {
    radius() = v
  }
}
