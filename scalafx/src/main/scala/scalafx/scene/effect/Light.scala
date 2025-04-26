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
package scalafx.scene.effect

import javafx.scene.effect as jfxse
import scalafx.Includes.*
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.{PositionDelegate, SFXDelegate}
import scalafx.scene.paint.Color

import scala.language.implicitConversions

object Light {
  implicit def sfxLight2jfx(l: Light): jfxse.Light = if (l != null) l.delegate else null

  // Distant Definition - Begin

  object Distant {
    implicit def sfxDistant2jfx(d: Distant): jfxse.Light.Distant = if (d != null) d.delegate else null
  }

  class Distant(override val delegate: jfxse.Light.Distant = new jfxse.Light.Distant) extends Light(delegate)
      with SFXDelegate[jfxse.Light.Distant] {

    /**
     * Creates a new instance of Distant light with the specified azimuth, elevation, and color.
     */
    def this(azimuth: Double, elevation: Double, color: Color) =
      this(new jfxse.Light.Distant(azimuth, elevation, color))

    /**
     * The azimuth of the light.
     */
    def azimuth: DoubleProperty = delegate.azimuthProperty

    def azimuth_=(v: Double): Unit = {
      azimuth() = v
    }

    /**
     * The elevation of the light.
     */
    def elevation: DoubleProperty = delegate.elevationProperty

    def elevation_=(v: Double): Unit = {
      elevation() = v
    }

  }

  // Distant Definition - End

  // Point Definition - Begin

  object Point {
    implicit def sfxPoint2jfx(p: Point): jfxse.Light.Point = if (p != null) p.delegate else null

  }

  class Point(override val delegate: jfxse.Light.Point = new jfxse.Light.Point)
      extends Light(delegate)
      with PositionDelegate[jfxse.Light.Point]
      with SFXDelegate[jfxse.Light.Point] {

    def this(x: Double, y: Double, z: Double, color: Color) = this(new jfxse.Light.Point(x, y, z, color))

    /**
     * The z coordinate of the light position.
     */
    def z: DoubleProperty = delegate.zProperty

    def z_=(v: Double): Unit = {
      z() = v
    }

  }

  // Point Definition - End

  // Spot Definition - Begin

  object Spot {
    implicit def sfxSpot2jfx(s: Spot): jfxse.Light.Spot = if (s != null) s.delegate else null

  }

  class Spot(override val delegate: jfxse.Light.Spot = new jfxse.Light.Spot) extends Point(delegate)
      with SFXDelegate[jfxse.Light.Spot] {

    /**
     * Creates a new instance of Spot light with the specified x, y, z, specularExponent, and color
     */
    def this(x: Double, y: Double, z: Double, specularExponent: Double, color: Color) =
      this(new jfxse.Light.Spot(x, y, z, specularExponent, color))

    /**
     * The x coordinate of the direction vector for this light.
     */
    def pointsAtX: DoubleProperty = delegate.pointsAtXProperty

    def pointsAtX_=(v: Double): Unit = {
      pointsAtX() = v
    }

    /**
     * The y coordinate of the direction vector for this light.
     */
    def pointsAtY: DoubleProperty = delegate.pointsAtYProperty

    def pointsAtY_=(v: Double): Unit = {
      pointsAtY() = v
    }

    /**
     * The z coordinate of the direction vector for this light.
     */
    def pointsAtZ: DoubleProperty = delegate.pointsAtZProperty

    def pointsAtZ_=(v: Double): Unit = {
      pointsAtZ() = v
    }

    /**
     * The specular exponent, which controls the focus of this light source.
     */
    def specularExponent: DoubleProperty = delegate.specularExponentProperty

    def specularExponent_=(v: Double): Unit = {
      specularExponent() = v
    }

  }

  // Spot Definition - End

}

abstract class Light protected (override val delegate: jfxse.Light)
    extends ColorDelegate[jfxse.Light]
    with SFXDelegate[jfxse.Light]
