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
package scalafx.scene.shape

import javafx.scene.shape as jfxss
import scalafx.Includes.*
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Sphere {
  implicit def sfxSphere2jfx(s: Sphere): jfxss.Sphere = if (s != null) s.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/shape/Sphere.html]].
 *
 * Creates a new instance of Sphere of radius of 1.0.
 */
class Sphere(override val delegate: jfxss.Sphere = new jfxss.Sphere())
    extends Shape3D(delegate)
    with SFXDelegate[jfxss.Sphere] {

  /** Creates a new instance of Sphere of a given radius. */
  def this(radius: Double) = this(new jfxss.Sphere(radius))

  /** Creates a new instance of Sphere of a given radius and number of divisions. */
  def this(radius: Double, divisions: Int) = this(new jfxss.Sphere(radius, divisions))

  def divisions: Int = delegate.getDivisions

  /** Defines the radius of the Sphere. */
  def radius: DoubleProperty = delegate.radiusProperty

  def radius_=(v: Double): Unit = {
    radius() = v
  }
}
