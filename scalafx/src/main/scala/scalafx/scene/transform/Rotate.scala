/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.{ geometry => jfxg }
import javafx.scene.{ transform => jfxst }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.geometry.Point3D._
import scalafx.geometry.Point3D
import scalafx.delegate.SFXDelegate

object Rotate {
  implicit def sfxRotate2jfx(v: Rotate) = v.delegate

  /**
   * Specifies the X-axis as the axis of rotation.
   */
  val XAxis = new Point3D(jfxst.Rotate.X_AXIS)

  /**
   * Specifies the Y-axis as the axis of rotation.
   */
  val YAxis = new Point3D(jfxst.Rotate.Y_AXIS)

  /**
   * Specifies the Z-axis as the axis of rotation.
   */
  val ZAxis = new Point3D(jfxst.Rotate.Z_AXIS)
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/scene/transform/Rotate.html]]
 */
class Rotate(override val delegate: jfxst.Rotate = new jfxst.Rotate) extends Transform(delegate) with SFXDelegate[jfxst.Rotate] {

  /**
   * Creates a two-dimensional Rotate transform.
   */
  def this(angle: Double) = this(new jfxst.Rotate(angle))

  /**
   * Creates a two-dimensional Rotate transform with pivot.
   */
  def this(angle: Double, pivotX: Double, pivotY: Double) = this(new jfxst.Rotate(angle, pivotX, pivotY))

  /**
   * Creates a simple Rotate transform with three-dimensional pivot.
   */
  def this(angle: Double, pivotX: Double, pivotY: Double, pivotZ: Double) =
    this(new jfxst.Rotate(angle, pivotX, pivotY, pivotZ))

  /**
   * Creates a three-dimensional Rotate transform with pivot.
   */
  def this(angle: Double, pivotX: Double, pivotY: Double, pivotZ: Double, axis: Point3D) =
    this(new jfxst.Rotate(angle, pivotX, pivotY, pivotZ, axis))

  /**
   * Creates a three-dimensional Rotate transform.
   */
  def this(angle: Double, axis: Point3D) = this(new jfxst.Rotate(angle, axis))

  /**
   * Defines the angle of rotation measured in degrees.
   */
  def angle: DoubleProperty = delegate.angleProperty()
  def angle_=(v: Double) {
    angle() = v
  }

  /**
   * Defines the axis of rotation at the pivot point.
   */
  def axis: ObjectProperty[jfxg.Point3D] = delegate.axisProperty()
  def axis_=(v: Point3D) {
    axis() = v
  }

  /**
   * Defines the X coordinate of the rotation pivot point.
   */
  def pivotX: DoubleProperty = delegate.pivotXProperty()
  def pivotX_=(v: Double) {
    pivotX() = v
  }

  /**
   * Defines the Y coordinate of the rotation pivot point.
   */
  def pivotY: DoubleProperty = delegate.pivotYProperty()
  def pivotY_=(v: Double) {
    pivotY() = v
  }

  /**
   * Defines the Z coordinate of the rotation pivot point.
   */
  def pivotZ: DoubleProperty = delegate.pivotZProperty()
  def pivotZ_=(v: Double) {
    pivotZ() = v
  }

}
