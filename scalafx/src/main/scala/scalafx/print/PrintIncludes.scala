/*
* Copyright (c) 2011-2014, ScalaFX Project
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
package scalafx.print

import scala.language.implicitConversions

import javafx.{print => jfxp}

/**
 * Companion Object for [[scalafx.print.PrintIncludes]].
 */
object PrintIncludes
  extends PrintIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/package-summary.html `javafx.print`]]
 * Classes/Enums to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/print/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define COLL Collation
 * @define JS JobSettings
 * @define PL PageLayout
 * @define PO PageOrientation
 * @define PR PageRange
 * @define PP Paper
 * @define PSO PaperSource
 * @define PC PrintColor
 * @define PRT Printer
 * @define MT Printer.MarginType
 * @define PA PrinterAttributes
 * @define PJ PrinterJob
 * @define JS PrinterJob.JobStatus
 * @define PQ PrintQuality
 * @define PR PrintResolution
 * @define PS PrintSides
 */
trait PrintIncludes {

  /**
   * $START$COLL$.html $COLL$END
   *
   * @param c $JFX $COLL
   * @return $SFX $COLL
   */
  implicit def jfxCollation2sfx(c: jfxp.Collation): Collation = Collation.jfxEnum2sfx(c)

  /**
   * $START$JS$.html $JS$END
   *
   * @param js $JFX $JS
   * @return $SFX $JS
   */
  implicit def jfxJobSettings2sfx(js: jfxp.JobSettings): JobSettings = if (js != null) new JobSettings(js) else null

  /**
   * $START$PL$.html $PL$END
   *
   * @param pl $JFX $PL
   * @return $SFX $PL
   */
  implicit def jfxPageLayout2sfx(pl: jfxp.PageLayout): PageLayout = if (pl != null) new PageLayout(pl) else null

  /**
   * $START$PO.html $PO$END
   *
   * @param po $JFX $PO
   * @return $SFX $PO
   */
  implicit def jfxPageOrientation2sfx(po: jfxp.PageOrientation): PageOrientation = PageOrientation.jfxEnum2sfx(po)

  /**
   * $START$PR.html $PR$END
   *
   * @param pr $JFX $PR
   * @return $SFX $PR
   */
  implicit def jfxPageRange2sfx(pr: jfxp.PageRange): PageRange = if (pr != null) new PageRange(pr) else null

  /**
   * $START$PP.html $PP$END
   *
   * @param pp $JFX $PP
   * @return $SFX $PP
   */
  implicit def jfxPaper2sfx(pp: jfxp.Paper): Paper = if (pp != null) new Paper(pp) else null

  /**
   * $START$PS.html $PS$END
   *
   * @param ps $JFX $PS
   * @return $SFX $PP
   */
  implicit def jfxPaperSource2sfx(ps: jfxp.PaperSource): PaperSource = if (ps != null) new PaperSource(ps) else null

  /**
   * $START$PC.html $PC$END
   *
   * @param pc $JFX $PC
   * @return $SFX $PC
   */
  implicit def jfxPrintColor2sfx(pc: jfxp.PrintColor): PrintColor = PrintColor.jfxEnum2sfx(pc)

  /**
   * $START$PA.html $PA$END
   *
   * @param pa $JFX $PA
   * @return $SFX $PA
   */
  implicit def jfxPrinterAttributes2sfx(pa: jfxp.PrinterAttributes): PrinterAttributes =
    if (pa != null) new PrinterAttributes(pa) else null

  /**
   * $START$PRT.html $PRT$END
   *
   * @param p $JFX $PRT
   * @return $SFX $PRT
   */
  implicit def jfxPrinter2sfx(p: jfxp.Printer): Printer = if (p != null) new Printer(p) else null

  /**
   * $START$MT.html $MT$END
   *
   * @param mt $JFX $MT
   * @return $SFX $MT
   */
  implicit def jfxPrinterMarginType2sfx(mt: jfxp.Printer.MarginType): Printer.MarginType = Printer.MarginType.jfxEnum2sfx(mt)

  /**
   * $START$PJ.html $PJ$END
   *
   * @param pj $JFX $PJ
   * @return $SFX $PJ
   */
  implicit def jfxPrintJob2sfx(pj: jfxp.PrinterJob): PrinterJob = if (pj != null) new PrinterJob(pj) else null

  /**
   * $START$JS.html $JS$END
   *
   * @param js $JFX $JS
   * @return $SFX $JS
   */
  implicit def jfxPrintJobJobStatus2sfx(js: jfxp.PrinterJob.JobStatus): PrinterJob.JobStatus = PrinterJob.JobStatus.jfxEnum2sfx(js)

  /**
   * $START$PQ.html $PQ$END
   *
   * @param pq $JFX $PQ
   * @return $SFX $PQ
   */
  implicit def jfxPrintQuality2sfx(pq: jfxp.PrintQuality): PrintQuality = PrintQuality.jfxEnum2sfx(pq)

  /**
   * $START$PR.html $PR$END
   *
   * @param pr $JFX $PR
   * @return $SFX $PR
   */
  implicit def jfxPrintResolution2sfx(pr: jfxp.PrintResolution): PrintResolution =
    if (pr != null) new PrintResolution(pr) else null

  /**
   * $START$PS.html $PS$END
   *
   * @param ps $JFX $PS
   * @return $SFX $PS
   */
  implicit def jfxPrintSides2sfx(ps: jfxp.PrintSides): PrintSides = PrintSides.jfxEnum2sfx(ps)

}