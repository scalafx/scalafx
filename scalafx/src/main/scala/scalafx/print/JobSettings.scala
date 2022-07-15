/*
 * Copyright (c) 2011-2022, ScalaFX Project
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
import scalafx.Includes.{jfxIntegerProperty2sfx, jfxObjectProperty2sfx, jfxStringProperty2sfx}
import scalafx.beans.property.{IntegerProperty, ObjectProperty, StringProperty}
import scalafx.delegate.SFXDelegate
import scalafx.print.PageLayout.sfxPageLayout2jfx
import scalafx.print.PaperSource.sfxPaperSource2jfx
import scalafx.print.PrintResolution.sfxPrintResolution2jfx
import scalafx.print.PrintSides.sfxEnum2jfx

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.print.JobSettings]].
 */
object JobSettings {

  /**
   * Converts a ScalaFX JobSettings to its JavaFX counterpart.
   *
   * @param js ScalaFX JobSettings
   * @return JavaFX JobSettings
   */
  implicit def sfxJobSettings2jfx(js: JobSettings): jfxp.JobSettings = if (js != null) js.delegate else null

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/JobSettings.html JavaFX JobSettings]].
 *
 * @constructor Creates a new ScalaFX JobSettings from its JavaFX counterpart.
 * @param delegate JavaFX JobSettings. Since there is no public constructor for it, there is not a default value.
 *
 * @since 8.0
 */
final class JobSettings(override val delegate: jfxp.JobSettings)
  extends SFXDelegate[jfxp.JobSettings] {

  /**
   * Property representing an instance of `Collation`.
   */
  def collation: ObjectProperty[jfxp.Collation] = delegate.collationProperty

  def collation_=(v: Collation): Unit = {
    collation() = v
  }

  /**
   * A `StringProperty` representing the
   * name of a filesystem file, to which the platform printer
   * driver should spool the rendered print data.
   * <p>
   * Applications can use this to programmatically request print-to-file
   * behavior where the native print system is capable of spooling the
   * output to a filesystem file, rather than the printer device.
   * <p>
   * This is often useful where the printer driver generates a format
   * such as Postscript or PDF, and the application intends to distribute
   * the result instead of printing it, or for some other reason the
   * application does not want physical media (paper) emitted by the printer.
   * <p>
   * The default value is an empty string, which is interpreted as unset,
   * equivalent to null, which means output is sent to the printer.
   * So in order to reset to print to the printer, clear the value of
   * this property by setting it to null or an empty string.
   * <p>
   * Additionally if the application displays a printer dialog which allows
   * the user to specify a file destination, including altering an application
   * specified file destination, the value of this property will reflect that
   * user-specified choice, including clearing it to reset to print to
   * the printer, if the user does so.
   * <p>
   * If the print system does not support print-to-file, then this
   * setting will be ignored.
   * <p>
   * If the specified name specifies a non-existent path, or does not specify
   * a user writable file, when printing the results are platform-dependent.
   * Possible behaviours might include replacement with a default output file location,
   * printing to the printer instead, or a platform printing error.
   * If a `SecurityManager` is installed and it denies access to the
   * specified file a `SecurityException` may be thrown.
   *
   * @return the name of a printer spool file
   * @since 17
   */
  def outputFile: StringProperty = delegate.outputFileProperty

  def outputFile_=(v: String = ""): Unit = {
    outputFile() = v
  }

  /**
   * IntegerProperty representing the number of copies of the job to print.
   */
  def copies: IntegerProperty = delegate.copiesProperty

  def copies_=(v: Int): Unit = {
    copies() = v
  }

  /**
   * StringProperty representing the name of a job.
   */
  def jobName: StringProperty = delegate.jobNameProperty

  def jobName_=(v: String): Unit = {
    jobName() = v
  }

  /**
   * Property representing an instance of PageLayout.
   */
  def pageLayout: ObjectProperty[jfxp.PageLayout] = delegate.pageLayoutProperty

  def pageLayout_=(v: PageLayout): Unit = {
    pageLayout() = v
  }

  /**
   * An ObjectProperty whose value represents the job pages to print as an array of PageRange.
   */
  def pageRanges: ObjectProperty[_] = delegate.pageRangesProperty

  def pageRanges_=(v: PageRange*): Unit = {
    delegate.setPageRanges(v.map(_.delegate): _*)
  }

  /**
   * Property representing an instance of PaperSource.
   */
  def paperSource: ObjectProperty[jfxp.PaperSource] = delegate.paperSourceProperty

  def paperSource_=(v: PaperSource): Unit = {
    paperSource() = v
  }

  /**
   * Property representing an instance of PrintColor.
   */
  def printColor: ObjectProperty[jfxp.PrintColor] = delegate.printColorProperty

  def printColor_=(v: PrintColor): Unit = {
    printColor() = v
  }

  /**
   * Property representing an instance of PrintQuality.
   */
  def printQuality: ObjectProperty[jfxp.PrintQuality] = delegate.printQualityProperty

  def printQuality_=(v: PrintQuality): Unit = {
    printQuality() = v
  }

  /**
   * Property representing an instance of PrintResolution.
   */
  def printResolution: ObjectProperty[jfxp.PrintResolution] = delegate.printResolutionProperty

  def printResolution_=(v: PrintResolution): Unit = {
    printResolution() = v
  }

  /**
   * Property representing an instance of PrintSides.
   */
  def printSides: ObjectProperty[jfxp.PrintSides] = delegate.printSidesProperty

  def printSides_=(v: PrintSides): Unit = {
    printSides() = v
  }

}