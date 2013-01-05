/*
 * Copyright (c) 2011, ScalaFX Project
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

import javafx.{geometry => jfxg}


object GeometryIncludes extends GeometryIncludes

trait GeometryIncludes {
  implicit def jfxBounds2sfx(b: jfxg.Bounds) = new Bounds(b) {}
  implicit def jfxBoundingBox2sfx(b: jfxg.BoundingBox) = new BoundingBox(b)
  implicit def jfxDimension2D2sfx(d: jfxg.Dimension2D) = new Dimension2D(d)
  implicit def jfxHorizontalDirection2sfx(h: jfxg.HorizontalDirection) = HorizontalDirection.jfxEnum2sfx(h)
  implicit def jfxHPos2sfx(h: jfxg.HPos) = HPos.jfxEnum2sfx(h)
  implicit def jfxInsets2sfx(i: jfxg.Insets) = new Insets(i)
  implicit def jfxOrientation2sfx(e: jfxg.Orientation) = Orientation.jfxEnum2sfx(e)
  implicit def jfxPoint2D2sfx(p: jfxg.Point2D) = new Point2D(p)
  implicit def jfxPoint3D2sfx(p: jfxg.Point3D) = new Point3D(p)
  implicit def jfxPos2sfx(e: jfxg.Pos) = Pos.jfxEnum2sfx(e)
  implicit def jfxRectangle2D2sfx(r: jfxg.Rectangle2D) = new Rectangle2D(r)
  implicit def jfxSide2sfx(e: jfxg.Side) = Side.jfxEnum2sfx(e)
  implicit def jfxVPos2sfx(v: jfxg.VPos) = VPos.jfxEnum2sfx(v)
}
