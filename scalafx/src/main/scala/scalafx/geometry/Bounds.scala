/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

object Bounds {
  implicit def sfxBounds2jfx(b: Bounds): jfxg.Bounds = if (b != null) b.delegate else null
}

abstract class Bounds protected (override val delegate: jfxg.Bounds) extends SFXDelegate[jfxg.Bounds] {

  /*
   * Creates a new instance of Bounds class.
   */
  //  protected def this(minX: Double, minY: Double, minZ: Double, width: Double, height: Double, depth: Double) = this(new jfxg.Bounds(minX, minY, minZ, width, height, depth) {})

  /**
   * Tests if the interior of this Bounds entirely contains the specified Bounds, b.
   */
  def contains(b: Bounds): Boolean = delegate.contains(b)

  /**
   * Tests if the specified (x, y) coordinates are inside the boundary of Bounds.
   */
  def contains(x: Double, y: Double): Boolean = delegate.contains(x, y)

  /**
   * Tests if the specified (x, y, z) coordinates are inside the boundary of Bounds.
   */
  def contains(x: Double, y: Double, z: Double): Boolean = delegate.contains(x, y, z)

  /**
   * Tests if the interior of this Bounds entirely contains the specified rectangular area.
   */
  def contains(x: Double, y: Double, w: Double, h: Double): Boolean = delegate.contains(x, y, w, h)

  /**
   * Tests if the interior of this Bounds entirely contains the specified rectangular area.
   */
  def contains(x: Double, y: Double, z: Double, w: Double, h: Double, d: Double): Boolean =
    delegate.contains(x, y, z, w, h, d)

  /**
   * Tests if the specified point is inside the boundary of Bounds.
   */
  def contains(p: Point2D): Boolean = delegate.contains(p)

  /**
   * Tests if the specified point is inside the boundary of Bounds.
   */
  def contains(p: Point3D): Boolean = delegate.contains(p)

  /**
   * The depth of this Bounds.
   */
  def depth: Double = delegate.getDepth

  /**
   * Indicates whether any of the dimensions(width, height or depth) of this bounds is less than zero.
   */
  def empty: Boolean = delegate.isEmpty

  /**
   * The height of this Bounds.
   */
  def height: Double = delegate.getHeight

  /**
   * Tests if the interior of this Bounds intersects the interior of a specified Bounds, b.
   */
  def intersects(b: Bounds): Boolean = delegate.intersects(b)

  /**
   * Tests if the interior of this Bounds intersects the interior of a specified rectangular area.
   */
  def intersects(x: Double, y: Double, w: Double, h: Double): Boolean = delegate.intersects(x, y, w, h)

  /**
   * Tests if the interior of this Bounds intersects the interior of a specified rectangular area.
   */
  def intersects(x: Double, y: Double, z: Double, w: Double, h: Double, d: Double): Boolean =
    delegate.intersects(x, y, z, w, h, d)

  /**
   * The x coordinate of the lower-right corner of this Bounds.
   */
  def maxX: Double = delegate.getMaxX

  /**
   * The y coordinate of the lower-right corner of this Bounds.
   */
  def maxY: Double = delegate.getMaxY

  /**
   * The maximum z coordinate of this Bounds.
   */
  def maxZ: Double = delegate.getMaxZ

  /**
   * The x coordinate of the upper-left corner of this Bounds.
   */
  def minX: Double = delegate.getMinX

  /**
   * The y coordinate of the upper-left corner of this Bounds.
   */
  def minY: Double = delegate.getMinY

  /**
   * The minimum z coordinate of this Bounds.
   */
  def minZ: Double = delegate.getMinZ

  /**
   * The width of this Bounds.
   */
  def width: Double = delegate.getWidth

  /**
   * The central x coordinate of this [[Bounds]].
   *
   * @return the central x coordinate
   *         This call is equivalent to `(getMaxX() + getMinX())/2.0`.
   * @since 11
   */
  def centerX: Double = delegate.getCenterX

  /**
   * The central y coordinate of this [[Bounds]].
   *
   * @return the central y coordinate
   *         This call is equivalent to `(getMaxY() + getMinY())/2.0`.
   * @since 11
   */
  def centerY: Double = delegate.getCenterY

  /**
   * The central z coordinate of this [[Bounds]].
   *
   * @return the central z coordinate
   *         This call is equivalent to `(getMaxZ() + getMinZ())/2.0`.
   * @since 11
   */
  def centerZ: Double = delegate.getCenterZ
}
