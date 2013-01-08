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
package scalafx.geometry

import javafx.{ geometry => jfxg }
import scalafx.delegate.SFXDelegate

object Bounds {
  implicit def sfxBounds2jfx(b: Bounds) = b.delegate
}

abstract class Bounds protected (override val delegate: jfxg.Bounds) extends SFXDelegate[jfxg.Bounds] {

  /*
   * Creates a new instance of Bounds class.
   */
//  protected def this(minX: Double, minY: Double, minZ: Double, width: Double, height: Double, depth: Double) = this(new jfxg.Bounds(minX, minY, minZ, width, height, depth) {})

  /**
   * Tests if the interior of this Bounds entirely contains the specified Bounds, b.
   */
  def contains(b: Bounds) = delegate.contains(b)

  /**
   * Tests if the specified (x, y) coordinates are inside the boundary of Bounds.
   */
  def contains(x: Double, y: Double) = delegate.contains(x, y)

  /**
   * Tests if the specified (x, y, z) coordinates are inside the boundary of Bounds.
   */
  def contains(x: Double, y: Double, z: Double) = delegate.contains(x, y, z)

  /**
   * Tests if the interior of this Bounds entirely contains the specified rectangular area.
   */
  def contains(x: Double, y: Double, w: Double, h: Double) = delegate.contains(x, y, w, h)

  /**
   * Tests if the interior of this Bounds entirely contains the specified rectangular area.
   */
  def contains(x: Double, y: Double, z: Double, w: Double, h: Double, d: Double) = delegate.contains(x, y, z, w, h, d)

  /**
   * Tests if the specified point is inside the boundary of Bounds.
   */
  def contains(p: Point2D) = delegate.contains(p)

  /**
   * Tests if the specified point is inside the boundary of Bounds.
   */
  def contains(p: Point3D) = delegate.contains(p)

  /**
   * The depth of this Bounds.
   */
  def depth = delegate.getDepth

  /**
   * Indicates whether any of the dimensions(width, height or depth) of this bounds is less than zero.
   */
  def empty = delegate.isEmpty

  /**
   * The height of this Bounds.
   */
  def height = delegate.getHeight

  /**
   * Tests if the interior of this Bounds intersects the interior of a specified Bounds, b.
   */
  def intersects(b: Bounds) = delegate.intersects(b)

  /**
   * Tests if the interior of this Bounds intersects the interior of a specified rectangular area.
   */
  def intersects(x: Double, y: Double, w: Double, h: Double) = delegate.intersects(x, y, w, h)

  /**
   * Tests if the interior of this Bounds intersects the interior of a specified rectangular area.
   */
  def intersects(x: Double, y: Double, z: Double, w: Double, h: Double, d: Double) = delegate.intersects(x, y, z, w, h, d)

  /**
   * The x coordinate of the lower-right corner of this Bounds.
   */
  def maxX = delegate.getMaxX

  /**
   * The y coordinate of the lower-right corner of this Bounds.
   */
  def maxY = delegate.getMaxY

  /**
   * The maximum z coordinate of this Bounds.
   */
  def maxZ = delegate.getMaxZ

  /**
   * The x coordinate of the upper-left corner of this Bounds.
   */
  def minX = delegate.getMinX

  /**
   * The y coordinate of the upper-left corner of this Bounds.
   */
  def minY = delegate.getMinY

  /**
   * The minimum z coordinate of this Bounds.
   */
  def minZ = delegate.getMinZ

  /**
   * The width of this Bounds.
   */
  def width = delegate.getWidth

}
