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
package scalafx.scene.shape

import javafx.scene.{ shape => jfxss }

object ShapeIncludes extends ShapeIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/shape/package-summary.html `javafx.scene.shape`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/shape/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define ARC Arc
 * @define ACT ArcTo
 * @define ATY ArcType
 * @define CLC Circle
 * @define CLP ClosePath
 * @define CCR CubicCurve
 * @define CCT CubicCurveTo
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
  implicit def jfxArc2sfx(r: jfxss.Arc) = new Arc(r)

  /**
   * $START$ACT.html $ACT$END
   *
   * @param a $JFX $ACT
   * @return $SFX $ACT
   */
  implicit def jfxArcTo2sfx(a: jfxss.ArcTo) = new ArcTo(a)

  /**
   * $START$ATY.html $ATY$END
   *
   * @param e $JFX $ATY
   * @return $SFX $ATY
   */
  implicit def jfxArcType2sfx(e: jfxss.ArcType) = ArcType.jfxEnum2sfx(e)

  /**
   * $START$CLC.html $CLC$END
   *
   * @param r $JFX $CLC
   * @return $SFX $CLC
   */
  implicit def jfxCircle2sfx(r: jfxss.Circle) = new Circle(r)

  /**
   * $START$CLP.html $CLP$END
   *
   * @param c $JFX $CLP
   * @return $SFX $CLP
   */
  implicit def jfxClosePath2sfx(c: jfxss.ClosePath) = new ClosePath(c)

  /**
   * $START$CCR.html $CCR$END
   *
   * @param c $JFX $CCR
   * @return $SFX $CCR
   */
  implicit def jfxCubicCurve2sfx(c: jfxss.CubicCurve) = new CubicCurve(c)

  /**
   * $START$CCT.html $CCT$END
   *
   * @param c $JFX $CCT
   * @return $SFX $CCT
   */
  implicit def jfxCubicCurveTo2sfx(c: jfxss.CubicCurveTo) = new CubicCurveTo(c)

  /**
   * $START$ELI.html $ELI$END
   *
   * @param r $JFX $ELI
   * @return $SFX $ELI
   */
  implicit def jfxEllipse2sfx(r: jfxss.Ellipse) = new Ellipse(r)

  /**
   * $START$FLR.html $FLR$END
   *
   * @param e $JFX $FLR
   * @return $SFX $FLR
   */
  implicit def jfxFillRule2sfx(e: jfxss.FillRule) = FillRule.jfxEnum2sfx(e)

  /**
   * $START$HLT.html $HLT$END
   *
   * @param h $JFX $HLT
   * @return $SFX $HLT
   */
  implicit def jfxHLineTo2sfx(h: jfxss.HLineTo) = new HLineTo(h)

  /**
   * $START$LIN.html $LIN$END
   *
   * @param r $JFX $LIN
   * @return $SFX $LIN
   */
  implicit def jfxLine2sfx(r: jfxss.Line) = new Line(r)

  /**
   * $START$LNT.html $LNT$END
   *
   * @param l $JFX $LNT
   * @return $SFX $LNT
   */
  implicit def jfxLineTo2sfx(l: jfxss.LineTo) = new LineTo(l)

  /**
   * $START$MVT.html $MVT$END
   *
   * @param l $JFX $MVT
   * @return $SFX $MVT
   */
  implicit def jfxMoveTo2sfx(l: jfxss.MoveTo) = new MoveTo(l)

  /**
   * $START$PTH.html $PTH$END
   *
   * @param r $JFX $PTH
   * @return $SFX $PTH
   */
  implicit def jfxPath2sfx(r: jfxss.Path) = new Path(r)

  /**
   * $START$PTE.html $PTE$END
   *
   * @param e $JFX $PTE
   * @return $SFX $PTE
   */
  implicit def jfxPathElement2sfx(e: jfxss.PathElement) = new PathElement(e) {}

  /**
   * $START$PLG.html $PLG$END
   *
   * @param p $JFX $PLG
   * @return $SFX $PLG
   */
  implicit def jfxPolygon2sfx(p: jfxss.Polygon) = new Polygon(p)

  /**
   * $START$PLL.html $PLL$END
   *
   * @param p $JFX $PLL
   * @return $SFX $PLL
   */
  implicit def jfxPolyline2sfx(p: jfxss.Polyline) = new Polyline(p)

  /**
   * $START$QDC.html $QDC$END
   *
   * @param q $JFX $QDC
   * @return $SFX $QDC
   */
  implicit def jfxQuadCurve2sfx(q: jfxss.QuadCurve) = new QuadCurve(q)

  /**
   * $START$QCT.html $QCT$END
   *
   * @param q $JFX $QCT
   * @return $SFX $QCT
   */
  implicit def jfxQuadCurveTo2sfx(q: jfxss.QuadCurveTo) = new QuadCurveTo(q)

  /**
   * $START$REC.html $REC$END
   *
   * @param r $JFX $REC
   * @return $SFX $REC
   */
  implicit def jfxRectangle2sfx(r: jfxss.Rectangle) = new Rectangle(r)

  /**
   * $START$SHA.html $SHA$END
   *
   * @param s $JFX $SHA
   * @return $SFX $SHA
   */
  implicit def jfxShape2sfx(s: jfxss.Shape) = new Shape(s) {}

  /**
   * $START$SLC.html $SLC$END
   *
   * @param e $JFX $SLC
   * @return $SFX $SLC
   */
  implicit def jfxStrokeLineCap2sfx(e: jfxss.StrokeLineCap) = StrokeLineCap.jfxEnum2sfx(e)

  /**
   * $START$SLJ.html $SLJ$END
   *
   * @param e $JFX $SLJ
   * @return $SFX $SLJ
   */
  implicit def jfxStrokeLineJoin2sfx(e: jfxss.StrokeLineJoin) = StrokeLineJoin.jfxEnum2sfx(e)

  /**
   * $START$STT.html $STT$END
   *
   * @param e $JFX $STT
   * @return $SFX $STT
   */
  implicit def jfxStrokeType2sfx(e: jfxss.StrokeType) = StrokeType.jfxEnum2sfx(e)

  /**
   * $START$SVP.html $SVP$END
   *
   * @param s $JFX $SVP
   * @return $SFX $SVP
   */
  implicit def jfxSVGPath2sfx(s: jfxss.SVGPath) = new SVGPath(s)

  /**
   * $START$VLT.html $VLT$END
   *
   * @param v $JFX $VLT
   * @return $SFX $VLT
   */
  implicit def jfxVLineTo2sfx(v: jfxss.VLineTo) = new VLineTo(v)

}
