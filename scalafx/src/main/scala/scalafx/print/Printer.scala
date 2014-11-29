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

import javafx.{print => jfxp}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.collections.ObservableSet
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}

/**
 * Companion Object for [[scalafx.print.Printer]].
 */
object Printer {

  /**
   * Converts a ScalaFX Printer to its JavaFX counterpart.
   *
   * @param pr ScalaFX Printer
   * @return JavaFX Printer
   */
  implicit def sfxPrinter2jfx(p: Printer): jfxp.Printer = if (p != null) p.delegate else null

  // MarginType - begin

  /**
   * Companion Object for [[scalafx.print.Printer.MarginType]].
   */
  object MarginType
    extends SFXEnumDelegateCompanion[jfxp.Printer.MarginType, Printer.MarginType] {

    /**
     * This requests a default 0.75 inch margin on all sides.
     */
    val Default = new MarginType(jfxp.Printer.MarginType.DEFAULT)

    /**
     * Choose the largest of the four hardware margins, and use that for all for margins,
     * so that the margins are equal on all sides.
     */
    val Equal = new MarginType(jfxp.Printer.MarginType.EQUAL)

    /**
     * Similar to EQUAL, but it chooses the larger of the left/right hardware margins and
     * top/bottom hardware margins separately, so that the top and bottom margins are equal,
     * and the left and right margins are equal.
     */
    val EqualOpposites = new MarginType(jfxp.Printer.MarginType.EQUAL_OPPOSITES)

    /**
     * Request margins are set to be the smallest on each side that the hardware allows.
     */
    val HardwareMinimum = new MarginType(jfxp.Printer.MarginType.HARDWARE_MINIMUM)

    protected override def unsortedValues: Array[Printer.MarginType] =
      Array(Default, Equal, EqualOpposites, HardwareMinimum)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/Printer.MarginType.html JavaFX MarginType]].
   *
   * @since 8.0
   */
  sealed case class MarginType(override val delegate: jfxp.Printer.MarginType)
    extends SFXEnumDelegate[jfxp.Printer.MarginType]

  // MarginType - end

  /**
   * A read only object property representing the current default printer.
   */
  def defaultPrinterProperty: ReadOnlyObjectProperty[jfxp.Printer] =
    jfxp.Printer.defaultPrinterProperty

  /**
   * Retrieve the installed printers.
   */
  def allPrinters: ObservableSet[jfxp.Printer] = jfxp.Printer.getAllPrinters

  /**
   * Retrieve the default printer.
   */
  def defaultPrinter: Printer = jfxp.Printer.getDefaultPrinter

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/Printer.html JavaFX Printer]].
 *
 * @constructor Creates a new ScalaFX Printer from its JavaFX counterpart.
 * @param delegate JavaFX Printer. Since there is no public constructor for it, there is not a default value.
 *
 * @since 8.0
 */
final class Printer(override val delegate: jfxp.Printer)
  extends SFXDelegate[jfxp.Printer] {

  /**
   * the default page layout for this printer.
   */
  def defaultPageLayout: PageLayout = delegate.getDefaultPageLayout

  /**
   * the name used by the underlying system to identify the printer to users and/or applications.
   */
  def name: String = delegate.getName

  /**
   * Retrieves the delegate object encapsulating the printer attributes and capabilities.
   */
  def printerAttributes: PrinterAttributes = delegate.getPrinterAttributes

  /**
   * Obtain a new PageLayout for this printer using the specified parameters.
   *
   * @param paper  The paper to use
   * @param orient  The orientation to use
   * @param lMargin the left margin to use in pts.
   * @param rMargin the right margin to use in pts.
   * @param tMargin the top margin to use in pts.
   * @param bMargin the bottom margin to use in pts.
   * @return PageLayout based on the specified parameters.
   */
  def createPageLayout(paper: Paper, orient: PageOrientation, lMargin: Double, rMargin: Double, tMargin: Double, bMargin: Double): PageLayout =
    delegate.createPageLayout(paper, orient, lMargin, rMargin, tMargin, bMargin)

  /**
   * Obtain a new PageLayout instance for this printer using the specified parameters.
   *
   * @param paper - The paper to use
   * @param orient - The orientation to use
   * @param mType - the margin type to use
   * @return PageLayout based on the specified parameters.
   */
  def createPageLayout(paper: Paper, orient: PageOrientation, mType: jfxp.Printer.MarginType): PageLayout =
    delegate.createPageLayout(paper, orient, mType)

}