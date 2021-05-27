/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

import scala.language.implicitConversions

object ShapeIncludes extends ShapeIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/package-summary.html `javafx.scene.shape`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define ARC Arc
 * @define ACT ArcTo
 * @define ATY ArcType
 * @define CLC Circle
 * @define CLP ClosePath
 * @define CCR CubicCurve
 * @define CCT CubicCurveTo
 * @define CUF CullFace
 * @define DRM DrawMode
 * @define ELI Ellipse
 * @define FLR FillRule
 * @define HLT HLineTo
 * @define LIN Line
 * @define LNT LineTo
 * @define MVT MoveTo
 * @define PTH Path
 * @define PTE PathElement
 * @define PLG Polygon
 * @define PLL Polyline
 * @define QDC QuadCurve
 * @define QCT QuadCurveTo
 * @define REC Rectangle
 * @define SHA Shape
 * @define SHA3D Shape3D
 * @define SLC StrokeLineCap
 * @define SLJ StrokeLineJoin
 * @define STT StrokeType
 * @define SVP SVGPath
 * @define VLT VLineTo
 */
trait ShapeIncludes {

  /**
   * $START$ARC.html $ARC$END
   *
   * @param r $JFX $ARC
   * @return $SFX $ARC
   */
  implicit def jfxArc2sfx(r: jfxss.Arc): Arc = if (r != null) new Arc(r) else null

  /**
   * $START$ACT.html $ACT$END
   *
   * @param a $JFX $ACT
   * @return $SFX $ACT
   */
  implicit def jfxArcTo2sfx(a: jfxss.ArcTo): ArcTo = if (a != null) new ArcTo(a) else null

  /**
   * $START$ATY.html $ATY$END
   *
   * @param e $JFX $ATY
   * @return $SFX $ATY
   */
  implicit def jfxArcType2sfx(e: jfxss.ArcType): ArcType = ArcType.jfxEnum2sfx(e)

  /**
   * ${START}Box.html Box$END
   *
   * @param b $JFX Box
   * @return $SFX Box
   */
  implicit def jfxBox2sfx(b: jfxss.Box): Box = if (b != null) new Box(b) {} else null

  /**
   * $START$CLC.html $CLC$END
   *
   * @param r $JFX $CLC
   * @return $SFX $CLC
   */
  implicit def jfxCircle2sfx(r: jfxss.Circle): Circle = if (r != null) new Circle(r) else null

  /**
   * $START$CLP.html $CLP$END
   *
   * @param c $JFX $CLP
   * @return $SFX $CLP
   */
  implicit def jfxClosePath2sfx(c: jfxss.ClosePath): ClosePath = if (c != null) new ClosePath(c) else null

  /**
   * $START$CCR.html $CCR$END
   *
   * @param c $JFX $CCR
   * @return $SFX $CCR
   */
  implicit def jfxCubicCurve2sfx(c: jfxss.CubicCurve): CubicCurve = if (c != null) new CubicCurve(c) else null

  /**
   * $START$CCT.html $CCT$END
   *
   * @param c $JFX $CCT
   * @return $SFX $CCT
   */
  implicit def jfxCubicCurveTo2sfx(c: jfxss.CubicCurveTo): CubicCurveTo = if (c != null) new CubicCurveTo(c) else null

  /**
   * $START$CUF.html $CUF$END
   *
   * @param cf $JFX $CUF
   * @return $SFX $CUF
   */
  implicit def jfxCullFace2sfx(cf: jfxss.CullFace): CullFace = CullFace.jfxEnum2sfx(cf)

  implicit def jfxCylinder2sfx(c: jfxss.Cylinder): Cylinder = if (c != null) new Cylinder(c) else null

  /**
   * $START$DRM.html $DRM$END
   *
   * @param e $JFX $DRM
   * @return $SFX $DRM
   */
  implicit def jfxDrawMode2sfx(e: jfxss.DrawMode): DrawMode = DrawMode.jfxEnum2sfx(e)

  /**
   * $START$ELI.html $ELI$END
   *
   * @param r $JFX $ELI
   * @return $SFX $ELI
   */
  implicit def jfxEllipse2sfx(r: jfxss.Ellipse): Ellipse = if (r != null) new Ellipse(r) else null

  /**
   * $START$FLR.html $FLR$END
   *
   * @param e $JFX $FLR
   * @return $SFX $FLR
   */
  implicit def jfxFillRule2sfx(e: jfxss.FillRule): FillRule = FillRule.jfxEnum2sfx(e)

  /**
   * $START$HLT.html $HLT$END
   *
   * @param h $JFX $HLT
   * @return $SFX $HLT
   */
  implicit def jfxHLineTo2sfx(h: jfxss.HLineTo): HLineTo = if (h != null) new HLineTo(h) else null

  /**
   * $START$LIN.html $LIN$END
   *
   * @param r $JFX $LIN
   * @return $SFX $LIN
   */
  implicit def jfxLine2sfx(r: jfxss.Line): Line = if (r != null) new Line(r) else null

  /**
   * $START$LNT.html $LNT$END
   *
   * @param l $JFX $LNT
   * @return $SFX $LNT
   */
  implicit def jfxLineTo2sfx(l: jfxss.LineTo): LineTo = if (l != null) new LineTo(l) else null

  implicit def jfxMeshView2sfx(mv: jfxss.MeshView): MeshView = if (mv != null) new MeshView(mv) else null

  /**
   * $START$MVT.html $MVT$END
   *
   * @param l $JFX $MVT
   * @return $SFX $MVT
   */
  implicit def jfxMoveTo2sfx(l: jfxss.MoveTo): MoveTo = if (l != null) new MoveTo(l) else null

  /**
   * $START$PTH.html $PTH$END
   *
   * @param r $JFX $PTH
   * @return $SFX $PTH
   */
  implicit def jfxPath2sfx(r: jfxss.Path): Path = if (r != null) new Path(r) else null

  /**
   * $START$PTE.html $PTE$END
   *
   * @param e $JFX $PTE
   * @return $SFX $PTE
   */
  implicit def jfxPathElement2sfx(e: jfxss.PathElement): PathElement = if (e != null) new PathElement(e) {} else null

  /**
   * $START$PLG.html $PLG$END
   *
   * @param p $JFX $PLG
   * @return $SFX $PLG
   */
  implicit def jfxPolygon2sfx(p: jfxss.Polygon): Polygon = if (p != null) new Polygon(p) else null

  /**
   * $START$PLL.html $PLL$END
   *
   * @param p $JFX $PLL
   * @return $SFX $PLL
   */
  implicit def jfxPolyline2sfx(p: jfxss.Polyline): Polyline = if (p != null) new Polyline(p) else null

  /**
   * $START$QDC.html $QDC$END
   *
   * @param q $JFX $QDC
   * @return $SFX $QDC
   */
  implicit def jfxQuadCurve2sfx(q: jfxss.QuadCurve): QuadCurve = if (q != null) new QuadCurve(q) else null

  /**
   * $START$QCT.html $QCT$END
   *
   * @param q $JFX $QCT
   * @return $SFX $QCT
   */
  implicit def jfxQuadCurveTo2sfx(q: jfxss.QuadCurveTo): QuadCurveTo = if (q != null) new QuadCurveTo(q) else null

  /**
   * $START$REC.html $REC$END
   *
   * @param r $JFX $REC
   * @return $SFX $REC
   */
  implicit def jfxRectangle2sfx(r: jfxss.Rectangle): Rectangle = if (r != null) new Rectangle(r) else null

  /**
   * $START$SHA.html $SHA$END
   *
   * @param s $JFX $SHA
   * @return $SFX $SHA
   */
  implicit def jfxShape2sfx(s: jfxss.Shape): Shape = if (s != null) new Shape(s) {} else null

  /**
   * $START$SHA3D.html $SHA3D$END
   *
   * @param s $JFX $SHA3D
   * @return $SFX $SHA3D
   */
  implicit def jfxShape3D2sfx(s: jfxss.Shape3D): Shape3D = if (s != null) new Shape3D(s) {} else null

  implicit def jfxSphere2sfx(s: jfxss.Sphere): Sphere = if (s != null) new Sphere(s) else null

  /**
   * $START$SLC.html $SLC$END
   *
   * @param e $JFX $SLC
   * @return $SFX $SLC
   */
  implicit def jfxStrokeLineCap2sfx(e: jfxss.StrokeLineCap): StrokeLineCap = StrokeLineCap.jfxEnum2sfx(e)

  /**
   * $START$SLJ.html $SLJ$END
   *
   * @param e $JFX $SLJ
   * @return $SFX $SLJ
   */
  implicit def jfxStrokeLineJoin2sfx(e: jfxss.StrokeLineJoin): StrokeLineJoin = StrokeLineJoin.jfxEnum2sfx(e)

  /**
   * $START$STT.html $STT$END
   *
   * @param e $JFX $STT
   * @return $SFX $STT
   */
  implicit def jfxStrokeType2sfx(e: jfxss.StrokeType): StrokeType = StrokeType.jfxEnum2sfx(e)

  /**
   * $START$SVP.html $SVP$END
   *
   * @param s $JFX $SVP
   * @return $SFX $SVP
   */
  implicit def jfxSVGPath2sfx(s: jfxss.SVGPath): SVGPath = if (s != null) new SVGPath(s) else null

  implicit def jfxTriangleMesh2sfx(tm: jfxss.TriangleMesh): TriangleMesh = if (tm != null) new TriangleMesh(tm) else null

  implicit def jfxVertexFormat2sfx(v: jfxss.VertexFormat): VertexFormat = if (v != null) new VertexFormat(v) else null

  /**
   * $START$VLT.html $VLT$END
   *
   * @param v $JFX $VLT
   * @return $SFX $VLT
   */
  implicit def jfxVLineTo2sfx(v: jfxss.VLineTo): VLineTo = if (v != null) new VLineTo(v) else null

}
