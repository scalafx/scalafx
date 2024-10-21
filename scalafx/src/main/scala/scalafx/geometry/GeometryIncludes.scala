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

import javafx.{geometry => jfxg}

import scala.language.implicitConversions

object GeometryIncludes extends GeometryIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/package-summary.html `javafx.geometry`]]
 * Classes to their ScalaFX counterparts.
 */
trait GeometryIncludes {

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Bounds `javafx.geometry.Bounds`]]
   * instance to its ScalaFX counterpart.
   *
   * @param b JavaFX Bounds
   * @return ScalaFX Bounds
   */
  implicit def jfxBounds2sfx(b: jfxg.Bounds): Bounds = if (b != null) new Bounds(b) {}
  else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/BoundingBox `javafx.geometry.BoundingBox`]]
   * instance to its ScalaFX counterpart.
   *
   * @param b JavaFX BoundingBox
   * @return ScalaFX BoundingBox
   */
  implicit def jfxBoundingBox2sfx(b: jfxg.BoundingBox): BoundingBox = if (b != null) new BoundingBox(b) else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Dimension2D `javafx.geometry.Dimension2D`]]
   * instance to its ScalaFX counterpart.
   *
   * @param d JavaFX Dimension2D
   * @return ScalaFX Dimension2D
   */
  implicit def jfxDimension2D2sfx(d: jfxg.Dimension2D): Dimension2D = if (d != null) new Dimension2D(d) else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/HorizontalDirection `javafx.geometry.HorizontalDirection`]]
   * instance to its ScalaFX counterpart.
   *
   * @param h JavaFX HorizontalDirection
   * @return ScalaFX HorizontalDirection
   */
  implicit def jfxHorizontalDirection2sfx(h: jfxg.HorizontalDirection): HorizontalDirection =
    HorizontalDirection.jfxEnum2sfx(h)

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/HPos `javafx.geometry.HPos`]]
   * instance to its ScalaFX counterpart.
   *
   * @param h JavaFX HPos
   * @return ScalaFX HPos
   */
  implicit def jfxHPos2sfx(h: jfxg.HPos): HPos = HPos.jfxEnum2sfx(h)

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Insets `javafx.geometry.Insets`]]
   * instance to its ScalaFX counterpart.
   *
   * @param i JavaFX Insets
   * @return ScalaFX Insets
   */
  implicit def jfxInsets2sfx(i: jfxg.Insets): Insets = if (i != null) new Insets(i) else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/NodeNodeOrientation `javafx.geometry.NodeOrientation`]]
   * instance to its ScalaFX counterpart.
   *
   * @param e JavaFX NodeOrientation
   * @return ScalaFX NodeOrientation
   */
  implicit def jfxNodeOrientation2sfx(e: jfxg.NodeOrientation): NodeOrientation = NodeOrientation.jfxEnum2sfx(e)

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Orientation `javafx.geometry.Orientation`]]
   * instance to its ScalaFX counterpart.
   *
   * @param e JavaFX Orientation
   * @return ScalaFX Orientation
   */
  implicit def jfxOrientation2sfx(e: jfxg.Orientation): Orientation = Orientation.jfxEnum2sfx(e)

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Point2D `javafx.geometry.Point2D`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX Point2D
   * @return ScalaFX Point2D
   */
  implicit def jfxPoint2D2sfx(p: jfxg.Point2D): Point2D = if (p != null) new Point2D(p) else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Point3D `javafx.geometry.Point3D`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX Point3D
   * @return ScalaFX Point3D
   */
  implicit def jfxPoint3D2sfx(p: jfxg.Point3D): Point3D = if (p != null) new Point3D(p) else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Pos `javafx.geometry.Pos`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX Pos
   * @return ScalaFX Pos
   */
  implicit def jfxPos2sfx(p: jfxg.Pos): Pos = Pos.jfxEnum2sfx(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Rectangle2D `javafx.geometry.Rectangle2D`]]
   * instance to its ScalaFX counterpart.
   *
   * @param r JavaFX Rectangle2D
   * @return ScalaFX Rectangle2D
   */
  implicit def jfxRectangle2D2sfx(r: jfxg.Rectangle2D): Rectangle2D = if (r != null) new Rectangle2D(r) else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Side `javafx.geometry.Side`]]
   * instance to its ScalaFX counterpart.
   *
   * @param e JavaFX Side
   * @return ScalaFX Side
   */
  implicit def jfxSide2sfx(e: jfxg.Side): Side = Side.jfxEnum2sfx(e)

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/VerticalDirection `javafx.geometry.VerticalDirection`]]
   * instance to its ScalaFX counterpart.
   *
   * @param h JavaFX VerticalDirection
   * @return ScalaFX VerticalDirection
   */
  implicit def jfxVerticalDirection2sfx(h: jfxg.VerticalDirection): VerticalDirection = VerticalDirection.jfxEnum2sfx(h)

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/VPos `javafx.geometry.VPos`]]
   * instance to its ScalaFX counterpart.
   *
   * @param v JavaFX VPos
   * @return ScalaFX VPos
   */
  implicit def jfxVPos2sfx(v: jfxg.VPos): VPos = VPos.jfxEnum2sfx(v)
}
