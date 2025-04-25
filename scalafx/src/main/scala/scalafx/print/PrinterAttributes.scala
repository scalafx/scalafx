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
package scalafx.print

import javafx.print as jfxp
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate
import scalafx.util.JavaConverters.*

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.print.PrinterAttributes]].
 */
object PrinterAttributes {

  /**
   * Converts a ScalaFX PrinterAttributes to its JavaFX counterpart.
   *
   * @param pa ScalaFX PrinterAttributes
   * @return JavaFX PrinterAttributes
   */
  implicit def sfxPrinterAttributes2jfx(pa: PrinterAttributes): jfxp.PrinterAttributes =
    if (pa != null) pa.delegate else null

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/PrinterAttributes.html JavaFX PrinterAttributes]].
 *
 * @constructor Creates a new ScalaFX PrinterAttributes from its JavaFX counterpart.
 * @param delegate JavaFX PrinterAttributes. Since there is no public constructor for it, there is not a default value.
 *
 * @since 8.0
 */
final class PrinterAttributes(override val delegate: jfxp.PrinterAttributes)
    extends SFXDelegate[jfxp.PrinterAttributes] {

  /**
   * The default collation setting.
   */
  def defaultCollation: Collation = delegate.getDefaultCollation

  /**
   * The default number of copies to print.
   */
  def defaultCopies: Int = delegate.getDefaultCopies

  /**
   * The default orientation for paper on this printer.
   */
  def defaultPageOrientation: PageOrientation = delegate.getDefaultPageOrientation

  /**
   * The default paper size used on this printer.
   */
  def defaultPaper: Paper = delegate.getDefaultPaper

  /**
   * The default paper input source/tray/
   */
  def defaultPaperSource: PaperSource = delegate.getDefaultPaperSource

  /**
   * The default color setting : greyscale or color
   */
  def defaultPrintColor: PrintColor = delegate.getDefaultPrintColor

  /**
   * The default quality setting
   */
  def defaultPrintQuality: PrintQuality = delegate.getDefaultPrintQuality

  /**
   * The default print resolution for paper on this printer.
   */
  def defaultPrintResolution: PrintResolution = delegate.getDefaultPrintResolution

  /**
   * The default value for duplex settings.
   */
  def defaultPrintSides: PrintSides = delegate.getDefaultPrintSides

  /**
   * The maximum supported number of copies.
   */
  def maxCopies: Int = delegate.getMaxCopies

  /**
   * An unmodifiable set of the supported collation settings for this printer.
   */
  def supportedCollations: Set[Collation] =
    delegate.getSupportedCollations.asScala.map(Collation(_)).toSet

  /**
   * An unmodifiable set of the supported orientations for this printer.
   */
  def supportedPageOrientations: Set[PageOrientation] =
    delegate.getSupportedPageOrientations.asScala.map(PageOrientation(_)).toSet

  /**
   * An unmodifiable set of the supported paper sizes for this printer.
   */
  def supportedPapers: Set[Paper] =
    delegate.getSupportedPapers.asScala.map(new Paper(_)).toSet

  /**
   * An unmodifiable set of the supported paper sources (ie input bins or trays) for this printer.
   */
  def supportedPaperSources: Set[PaperSource] =
    delegate.getSupportedPaperSources.asScala.map(new PaperSource(_)).toSet

  /**
   * An unmodifiable set of the supported color settings for this printer.
   */
  def supportedPrintColors: Set[PrintColor] =
    delegate.getSupportedPrintColors.asScala.map(PrintColor(_)).toSet

  /**
   * An unmodifiable set of the supported quality settings for this printer.
   */
  def supportedPrintQuality: Set[PrintQuality] =
    delegate.getSupportedPrintQuality.asScala.map(PrintQuality(_)).toSet

  /**
   * An unmodifiable set of the supported print resolutions for this printer.
   */
  def supportedPrintResolutions: Set[PrintResolution] =
    delegate.getSupportedPrintResolutions.asScala.map(new PrintResolution(_)).toSet

  /**
   * An unmodifiable set of the supported duplex settings for this printer.
   */
  def supportedPrintSides: Set[PrintSides] =
    delegate.getSupportedPrintSides.asScala.map(PrintSides(_)).toSet

  /**
   * Reports if page ranges are supported.
   */
  def supportsPageRanges: Boolean = delegate.supportsPageRanges

}
