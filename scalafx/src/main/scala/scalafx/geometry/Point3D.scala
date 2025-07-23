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
package scalafx.geometry

import javafx.geometry as jfxg
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Point3D {
  implicit def sfxPoint3D2jfx(p: Point3D): jfxg.Point3D = if (p != null) p.delegate else null

  /**
   * Point or vector with all three coordinates set to zero.
   */
  val Zero = new Point3D(jfxg.Point3D.ZERO)
}

class Point3D(override val delegate: jfxg.Point3D) extends SFXDelegate[jfxg.Point3D] {

  def this(x: Double, y: Double, z: Double) = this(new jfxg.Point3D(x, y, z))

  /**
   * The x coordinate.
   */
  def x: Double = delegate.getX

  /**
   * The y coordinate.
   */
  def y: Double = delegate.getY

  /**
   * The z coordinate.
   */
  def z: Double = delegate.getZ

  /**
   * Computes the distance between this point and point (x1, y1, z1).
   */
  def distance(x1: Double, y1: Double, z1: Double): Double = delegate.distance(x1, y1, z1)

  /**
   * Computes the distance between this point and point p.
   */
  def distance(p: Point3D): Double = delegate.distance(p)

}
