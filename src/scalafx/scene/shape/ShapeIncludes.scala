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

package scalafx.scene.shape

import javafx.scene.{shape => jfxss}

object ShapeIncludes extends ShapeIncludes

trait ShapeIncludes {
  implicit def jfxArc2sfx(r: jfxss.Arc) = new Arc(r)
  implicit def jfxArcTo2sfx(a: jfxss.ArcTo) = new ArcTo(a)
  implicit def jfxCircle2sfx(r: jfxss.Circle) = new Circle(r)
  implicit def jfxClosePath2sfx(c: jfxss.ClosePath) = new ClosePath(c)
  implicit def jfxCubicCurve2sfx(c: jfxss.CubicCurve) = new CubicCurve(c)
  implicit def jfxEllipse2sfx(r: jfxss.Ellipse) = new Ellipse(r)
  implicit def jfxHLineTo2sfx(h: jfxss.HLineTo) = new HLineTo(h)
  implicit def jfxLine2sfx(r: jfxss.Line) = new Line(r)
  implicit def jfxLineTo2sfx(l: jfxss.LineTo) = new LineTo(l)
  implicit def jfxMoveTo2sfx(l: jfxss.MoveTo) = new MoveTo(l)
  implicit def jfxPath2sfx(r: jfxss.Path) = new Path(r)
  implicit def jfxPathElement2sfx(e: jfxss.PathElement) = new PathElement(e) {}
  implicit def jfxPolygon2sfx(p: jfxss.Polygon) = new Polygon(p)
  implicit def jfxPolyline2sfx(p: jfxss.Polyline) = new Polyline(p)
  implicit def jfxQuadCurve2sfx(q: jfxss.QuadCurve) = new QuadCurve(q)
  implicit def jfxQuadCurveTo2sfx(q: jfxss.QuadCurveTo) = new QuadCurveTo(q)
  implicit def jfxRectangle2sfx(r: jfxss.Rectangle) = new Rectangle(r)
  implicit def jfxShape2sfx(s: jfxss.Shape) = new Shape(s) {}
  implicit def jfxSVGPath2sfx(s: jfxss.SVGPath) = new SVGPath(s)
  implicit def jfxVLineTo2sfx(v: jfxss.VLineTo) = new VLineTo(v)
}
