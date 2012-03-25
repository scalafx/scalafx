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
import scalafx.util.SFXDelegate

object Rectangle2D {
  implicit def sfxRectangle2D2jfx(r: Rectangle2D) = r.delegate

  /**
   * An empty Rectangle2D instance (with all coordinates equal to zero).
   */
  val Empty = jfxg.Rectangle2D.EMPTY

}

class Rectangle2D(override val delegate: jfxg.Rectangle2D) extends SFXDelegate[jfxg.Rectangle2D] {

  def this(minX: Double, minY: Double, width: Double, height: Double) = this(new jfxg.Rectangle2D(minX, minY, width, height))

  /**
   * Tests if the specified (x, y) coordinates are inside the boundary of Rectangle2D.
   */
  def contains(x: Double, y: Double) = delegate.contains(x, y)

  /**
   * Tests if the interior of this Rectangle2D entirely contains the specified rectangular area.
   */
  def contains(x: Double, y: Double, w: Double, h: Double) = delegate.contains(x, y, w, h)

  /**
   * Tests if the specified point is inside the boundary of Rectangle2D.
   */
  def contains(p: Point2D) = delegate.contains(p)

  /**
   * Tests if the interior of this Rectangle2D entirely contains the specified Rectangle2D, r.
   */
  def contains(r: Rectangle2D) = delegate.contains(r)

  /**
   * The height of this Rectangle2D.
   */
  def height = delegate.getHeight

  /**
   * Tests if the interior of this Rectangle2D intersects the interior of a specified rectangular area.
   */
  def intersects(x: Double, y: Double, w: Double, h: Double) = delegate.intersects(x, y, w, h)

  /**
   * Tests if the interior of this Rectangle2D intersects the interior of a specified Rectangle2D, r.
   */
  def intersects(r: Rectangle2D) = delegate.intersects(r)

  /**
   * The x coordinate of the lower-right corner of this Rectangle2D.
   */
  def maxX = delegate.getMaxX

  /**
   * The y coordinate of the lower-right corner of this Rectangle2D.
   */
  def maxY = delegate.getMaxY

  /**
   * The x coordinate of the upper-left corner of this Rectangle2D.
   */
  def minX = delegate.getMinX

  /**
   * The y coordinate of the upper-left corner of this Rectangle2D.
   */
  def minY = delegate.getMinY

  /**
   * The width of this Rectangle2D.
   */
  def width = delegate.getWidth

}