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
package scalafx.scene

import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate
import scalafx.scene.paint.Color

import scala.language.implicitConversions

object PointLight {
  implicit def sfxPointLight2jfx(pl: PointLight): jfxs.PointLight = if (pl != null) pl.delegate else null
}

/**
 * Defines a point light source object. An attenuated light source that has a fixed point in space and radiates light
 * equally in all directions away from itself.
 */
class PointLight(override val delegate: jfxs.PointLight = new jfxs.PointLight())
    extends LightBase(delegate)
    with SFXDelegate[jfxs.PointLight] {

  /** Creates a new instance of `PointLight` class using the specified color. */
  def this(color: Color) = {
    this(new jfxs.PointLight(color))
  }

  /**
   * The constant attenuation coefficient. This is the term `ca` in the attenuation formula:
   * {{{
   * attn = 1 / (ca + la * dist + qa * dist^2)
   * }}}
   * where `dist` is the distance between the light source and the pixel.
   *
   * @since
   *   16
   */
  def constantAttenuation: DoubleProperty = delegate.constantAttenuationProperty

  def constantAttenuation_=(v: Double): Unit = {
    constantAttenuation() = v
  }

  /**
   * The linear attenuation coefficient. This is the term `la` in the attenuation formula:
   * {{{
   * attn = 1 / (ca + la * dist + qa * dist^2)
   * }}}
   * where `dist` is the distance between the light source and the pixel.
   *
   * @since
   *   JavaFX 16
   */
  def linearAttenuation: DoubleProperty = delegate.linearAttenuationProperty

  def linearAttenuation_=(v: Double): Unit = {
    linearAttenuation() = v
  }

  /**
   * The quadratic attenuation coefficient. This is the term `qa` in the attenuation formula:
   * {{{
   * attn = 1 / (ca + la * dist + qa * dist^2)
   * }}}
   * where `dist` is the distance between the light source and the pixel.
   *
   * @since
   *   JavaFX 16
   */
  def quadraticAttenuation: DoubleProperty = delegate.quadraticAttenuationProperty

  def quadraticAttenuation_=(v: Double): Unit = {
    quadraticAttenuation() = v
  }

  /**
   * The maximum range of this `PointLight`. For a pixel to be affected by this light, its distance to the light source
   * must be less than or equal to the light's maximum range. Any negative value will be treated as 0.
   *
   * Lower `maxRange` values can give better performance as pixels outside the range of the light will not require
   * complex calculation. The attenuation formula can be used to calculate a realistic `maxRange` value by finding the
   * distance where the attenuation is close enough to 0.
   *
   * Nodes that are inside the light's range can still be excluded from the light's effect by removing them from its
   * [[scalafx.scene.LightBase.scopescope]] (or including them in its
   * [[scalafx.scene.LightBase.exclusionScopeexclusionScope]] ). If a node is known to always be outside of the light's
   * range, it is more performant to exclude it from its scope.
   *
   * @since
   *   Java 16
   */
  def maxRange: DoubleProperty = delegate.maxRangeProperty

  def maxRange_=(v: Double): Unit = {
    constantAttenuation() = v
  }
}
