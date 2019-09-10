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

package scalafx.scene.paint

import javafx.scene.{image => jfxsi, paint => jfxsp}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.image.Image

import scala.language.implicitConversions

object PhongMaterial {
  implicit def sfxPhongMaterial2jfx(c: PhongMaterial): jfxsp.PhongMaterial = if (c != null) c.delegate else null
}

/** The PhongMaterial class provides definitions of properties that represent a form of Phong shaded material. */
class PhongMaterial(override val delegate: jfxsp.PhongMaterial = new jfxsp.PhongMaterial())
  extends Material(delegate)
  with SFXDelegate[jfxsp.PhongMaterial] {

  def this(diffuseColor: Color) = this(new jfxsp.PhongMaterial(diffuseColor))

  def this(diffuseColor: Color, diffuseMap: Image, specularMap: Image, bumpMap: Image, selfIlluminationMap: Image) =
    this(new jfxsp.PhongMaterial(diffuseColor, diffuseMap, specularMap, bumpMap, selfIlluminationMap))

  /** The bump map of this `PhongMaterial`. */
  def bumpMap: ObjectProperty[jfxsi.Image] = delegate.bumpMapProperty

  def bumpMap_=(v: jfxsi.Image): Unit = {
    bumpMap() = v
  }

  /** Specifies the diffuse color of this Material. */
  def diffuseColor: ObjectProperty[jfxsp.Color] = delegate.diffuseColorProperty

  def diffuseColor_=(v: jfxsp.Color): Unit = {
    diffuseColor() = v
  }

  /** The diffuse map of this `PhongMaterial`. */
  def diffuseMap: ObjectProperty[jfxsi.Image] = delegate.diffuseMapProperty

  def diffuseMap_=(v: jfxsi.Image): Unit = {
    diffuseMap() = v
  }

  /** The self illumination map of this `PhongMaterial`. */
  def selfIlluminationMap: ObjectProperty[jfxsi.Image] = delegate.selfIlluminationMapProperty

  def selfIlluminationMap_=(v: jfxsi.Image): Unit = {
    selfIlluminationMap() = v
  }

  /** Specifies the specular color of this Material. */
  def specularColor: ObjectProperty[jfxsp.Color] = delegate.specularColorProperty

  def specularColor_=(v: jfxsp.Color): Unit = {
    specularColor() = v
  }

  /** The specular map of this `PhongMaterial`. */
  def specularMap: ObjectProperty[jfxsi.Image] = delegate.specularMapProperty

  def specularMap_=(v: jfxsi.Image): Unit = {
    specularMap() = v
  }

  /** Defines the specular power of this Material. */
  def specularPower: DoubleProperty = delegate.specularPowerProperty

  def specularPower_=(v: Double): Unit = {
    specularPower() = v
  }

}
