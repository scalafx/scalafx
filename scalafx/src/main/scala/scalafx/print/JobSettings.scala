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

import javafx.{ print => jfxp }
import scalafx.Includes.jfxIntegerProperty2sfx
import scalafx.Includes.jfxObjectProperty2sfx
import scalafx.Includes.jfxStringProperty2sfx
import scalafx.beans.property.IntegerProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.StringProperty
import scalafx.delegate.SFXDelegate
import scalafx.print.Collation.sfxEnum2jfx
import scalafx.print.PageLayout.sfxPageLayout2jfx
import scalafx.print.PaperSource.sfxPaperSource2jfx
import scalafx.print.PrintColor.sfxEnum2jfx
import scalafx.print.PrintQuality.sfxEnum2jfx
import scalafx.print.PrintResolution.sfxPrintResolution2jfx
import scalafx.print.PrintSides.sfxEnum2jfx

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
  implicit def sfxJobSettings2jfx(js: JobSettings): jfxp.JobSettings = js.delegate

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
  def collation_=(v: Collation) {
    collation() = v
  }

  /**
   * IntegerProperty representing the number of copies of the job to print.
   */
  def copies: IntegerProperty = delegate.copiesProperty
  def copies_=(v: Int) {
    copies() = v
  }

  /**
   * StringProperty representing the name of a job.
   */
  def jobName: StringProperty = delegate.jobNameProperty
  def jobName_=(v: String) {
    jobName() = v
  }

  /**
   * Property representing an instance of PageLayout.
   */
  def pageLayout: ObjectProperty[jfxp.PageLayout] = delegate.pageLayoutProperty
  def pageLayout_=(v: PageLayout) {
    pageLayout() = v
  }

  /**
   * An ObjectProperty whose value represents the job pages to print as an array of PageRange.
   */
  def pageRanges: ObjectProperty[_] = delegate.pageRangesProperty
  def pageRanges_=(v: PageRange*) {
    delegate.setPageRanges(v.map(_.delegate): _*)
  }

  /**
   * Property representing an instance of PaperSource.
   */
  def paperSource: ObjectProperty[jfxp.PaperSource] = delegate.paperSourceProperty
  def paperSource_=(v: PaperSource) {
    paperSource() = v
  }

  /**
   * Property representing an instance of PrintColor.
   */
  def printColor: ObjectProperty[jfxp.PrintColor] = delegate.printColorProperty
  def printColor_=(v: PrintColor) {
    printColor() = v
  }

  /**
   * Property representing an instance of PrintQuality.
   */
  def printQuality: ObjectProperty[jfxp.PrintQuality] = delegate.printQualityProperty
  def printQuality_=(v: PrintQuality) {
    printQuality() = v
  }

  /**
   * Property representing an instance of PrintResolution.
   */
  def printResolution: ObjectProperty[jfxp.PrintResolution] = delegate.printResolutionProperty
  def printResolution_=(v: PrintResolution) {
    printResolution() = v
  }

  /**
   * Property representing an instance of PrintSides.
   */
  def printSides: ObjectProperty[jfxp.PrintSides] = delegate.printSidesProperty
  def printSides_=(v: PrintSides) {
    printSides() = v
  }

}