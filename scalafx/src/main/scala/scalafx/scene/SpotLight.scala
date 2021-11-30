/*
 * Copyright (c) 2011-2021, ScalaFX Project
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

import javafx.{geometry => jfxg, scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.geometry.Point3D
import scalafx.scene.paint.Color

import scala.language.implicitConversions

object SpotLight {
  implicit def sfxSpotLight2jfx(sl: SpotLight): jfxs.SpotLight = if (sl != null) sl.delegate else null
}

/**
 * A {{{SpotLight}}} is a {{PointLight}}} that radiates light in a cone in a specific direction.
 * The direction is defined by the [[directionProperty()]] direction vector property of the light. The direction
 * can be rotated by setting a rotation transform on the {{{SpotLight}}}. For example, if the direction vector is
 * {{{(1, 1, 1)}}} and the light is not rotated, it will point in the {{{(1, 1, 1)}}} direction, and if the light is
 * rotated 90 degrees on the y axis, it will point in the {{{(1, 1, -1)}}} direction.
 * <p>
 * In addition to the factors that control the light intensity of a {{{PointLight}}}, a {{{SpotLight}}} has a
 * light-cone attenuation factor, {{{spot}}}, that is determined by 3 properties:
 * <ul>
 * <li> [[innerAngleProperty]] innerAngle: the angle of the inner cone (see image below)
 * <li> [[outerAngleProperty]] outerAngle: the angle of the outer cone (see image below)
 * <li> [[falloffProperty]] falloff: the factor that controls the light's intensity drop inside the outer cone
 * </ul>
 * The valid ranges for these properties are {{{0 <= innerAngle <= outerAngle <= 180}}} and {{{falloff >= 0}}};
 * values outside either of these ranges can produce unexpected results.
 * <p>
 * The angle of a point to the light is defined as the angle between its vector to the light's position and the
 * direction of the light. For such an angle {{{theta}}}, if
 * <ul>
 * <li>{{{theta < innerAngle}}} then {{{spot = 1}}}
 * <li>{{{theta > outerAngle}}} then {{{spot = 0}}}
 * <li>{{{innerAngle <= theta <= outerAngle}}} then
 *
 * <pre>spot = pow((cos(theta) - cos(outer)) / (cos(inner) - cos(outer)), falloff)</pre>
 *
 * which represents a drop in intensity from the inner angle to the outer angle.
 * </ul>
 * As a result, {{{0 <= spot <= 1}}}. The overall intensity of the light is {{{I = lambert * atten * spot}}}.
 * <p>
 * <img src="doc-files/spotlight.png" alt="Image of the Spotlight">
 *
 * @since 17
 * @see PhongMaterial
 */
class SpotLight(override val delegate: jfxs.SpotLight = new jfxs.SpotLight())
  extends LightBase(delegate)
  with SFXDelegate[jfxs.SpotLight] {

  /** Creates a new instance of `SpotLight` class using the specified color. */
  def this(color: Color) = this(new jfxs.SpotLight(color))

  /**
   * The direction vector of the spotlight. It can be rotated by setting a rotation transform on the
   * {{{SpotLight}}}. The vector need not be normalized.
   */
  def direction: ObjectProperty[jfxg.Point3D] = delegate.directionProperty

  def direction_(p: Point3D = new Point3D(0, 0, 1)): Unit = {
    direction() = p
  }

  /**
   * The angle of the spotlight's inner cone, in degrees. A point whose angle to the light is less than this angle is
   * not attenuated by the spotlight factor ({{{spot = 1}}}). At larger angles, the light intensity starts to drop.
   * See the class doc for more information.
   * <p>
   * The valid range is {{{0 <= innerAngle <= outerAngle}}}; values outside of this range can produce unexpected
   * results.
   */
  def innerAngle: DoubleProperty = delegate.innerAngleProperty

  def innerAngle_(v: Double): Unit = {
    innerAngle() = v
  }

  /**
   * The angle of the spotlight's outer cone, in degrees (as shown in the class doc image). A point whose angle to the
   * light is greater than this angle receives no light ({{{spot = 0}}}). A point whose angle to the light is less
   * than the outer angle but greater than the inner angle receives partial intensity governed by the falloff factor.
   * See the class doc for more information.
   * <p>
   * The valid range is {{{innerAngle <= outerAngle <= 180}}}; values outside of this range can produce unexpected
   * results.
   */
  def outerAngle: DoubleProperty = delegate.outerAngleProperty

  def outerAngle_(v: Double): Unit = {
    outerAngle() = v
  }

  /**
   * The intensity falloff factor of the spotlight's outer cone. A point whose angle to the light is
   * greater than the inner angle but less than the outer angle receives partial intensity governed by this factor.
   * The larger the falloff, the sharper the drop in intensity from the inner cone. A falloff factor of 1 gives a
   * linear drop in intensity, values greater than 1 give a convex drop, and values smaller than 1 give a concave
   * drop. See the class doc for more information.
   * <p>
   * The valid range is {{{0 <= falloff}}}; values outside of this range can produce unexpected results.
   */
  def falloff: DoubleProperty = delegate.falloffProperty

  def falloff_(v: Double): Unit = {
    falloff() = v
  }
}
