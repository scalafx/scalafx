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
package scalafx.scene.transform

import javafx.scene.transform as jfxst
import scalafx.Includes.*
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.{PositionDelegate, SFXDelegate}

import scala.language.implicitConversions

object Scale {
  implicit def sfxScale2jfx(v: Scale): jfxst.Scale = if (v != null) v.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/scene/transform/Scale.html]]
 */
class Scale(override val delegate: jfxst.Scale = new jfxst.Scale)
    extends Transform(delegate)
    with PositionDelegate[jfxst.Scale]
    with SFXDelegate[jfxst.Scale] {

  /**
   * Creates a two-dimensional Scale.
   */
  def this(x: Double, y: Double) = this(new jfxst.Scale(x, y))

  /**
   * Creates a three-dimensional Scale.
   */
  def this(x: Double, y: Double, z: Double) = this(new jfxst.Scale(x, y, z))

  /**
   * Creates a two-dimensional Scale with pivot.
   */
  def this(x: Double, y: Double, pivotX: Double, pivotY: Double) = this(new jfxst.Scale(x, y, pivotX, pivotY))

  /**
   * Creates a three-dimensional Scale with pivot.
   */
  def this(x: Double, y: Double, z: Double, pivotX: Double, pivotY: Double, pivotZ: Double) =
    this(new jfxst.Scale(x, y, z, pivotX, pivotY, pivotZ))

  /**
   * Defines the X coordinate about which point the scale occurs.
   */
  def pivotX: DoubleProperty = delegate.pivotXProperty()

  def pivotX_=(v: Double): Unit = {
    pivotX() = v
  }

  /**
   * Defines the Y coordinate about which point the scale occurs.
   */
  def pivotY: DoubleProperty = delegate.pivotYProperty()

  def pivotY_=(v: Double): Unit = {
    pivotY() = v
  }

  /**
   * Defines the Z coordinate about which point the scale occurs.
   */
  def pivotZ: DoubleProperty = delegate.pivotZProperty()

  def pivotZ_=(v: Double): Unit = {
    pivotZ() = v
  }

  /**
   * Defines the factor by which coordinates are scaled along the Z axis direction.
   */
  def z: DoubleProperty = delegate.zProperty()

  def z_=(v: Double): Unit = {
    z() = v
  }

}
