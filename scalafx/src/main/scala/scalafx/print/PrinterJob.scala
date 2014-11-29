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
import scalafx.beans.property.{ObjectProperty, ReadOnlyObjectProperty}
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.scene.Node
import scalafx.stage.Window

/**
 * Companion Object for [[scalafx.print.PrinterJob]].
 */
object PrinterJob {

  /**
   * Converts a ScalaFX PrinterJob to its JavaFX counterpart.
   *
   * @param pj ScalaFX PrinterJob
   * @return JavaFX PrinterJob
   */
  implicit def sfxPrinterJob2jfx(pj: PrinterJob): jfxp.PrinterJob = if (pj != null) pj.delegate else null

  // JobStatus - begin

  /**
   * Companion Object for [[scalafx.print.PrinterJob.JobStatus]].
   */
  object JobStatus extends SFXEnumDelegateCompanion[jfxp.PrinterJob.JobStatus, PrinterJob.JobStatus] {

    /**
     * The job has been cancelled by the application.
     */
    val Canceled = new JobStatus(jfxp.PrinterJob.JobStatus.CANCELED)

    /**
     * The job initiated printing and later called endJob() which reported success.
     */
    val Done = new JobStatus(jfxp.PrinterJob.JobStatus.DONE)

    /**
     * The job encountered an error.
     */
    val Error = new JobStatus(jfxp.PrinterJob.JobStatus.ERROR)

    /**
     * The new job status.
     */
    val NotStarted = new JobStatus(jfxp.PrinterJob.JobStatus.NOT_STARTED)

    /**
     * The job has requested to print at least one page, and has not terminated printing.
     */
    val Printing = new JobStatus(jfxp.PrinterJob.JobStatus.PRINTING)

    protected override def unsortedValues: Array[PrinterJob.JobStatus] =
      Array(Canceled, Done, Error, NotStarted, Printing)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/PrinterJob.JobStatus.html JavaFX JobStatus]].
   */
  sealed case class JobStatus(override val delegate: jfxp.PrinterJob.JobStatus)
    extends SFXEnumDelegate[jfxp.PrinterJob.JobStatus]

  // JobStatus - end

  /**
   * Factory method to create a job.
   */
  def createPrinterJob: PrinterJob = jfxp.PrinterJob.createPrinterJob

  /**
   * Factory method to create a job for a specified printer.
   *
   * @param printer to use for the job. If the printer is currently unavailable (e.g. offline)
   *                then this may return 'null'.
   * @return a new PrinterJob, or 'null'.
   */
  def createPrinterJob(printer: Printer): PrinterJob = jfxp.PrinterJob.createPrinterJob(printer)

  /**
   * Added just to satisfy Spec tests.
   */
  @deprecated(message = "Use createPrinterJob(Printer): PrinterJob instead", since = "8.0")
  def createPrinterJob(printer: jfxp.Printer): jfxp.PrinterJob = jfxp.PrinterJob.createPrinterJob(printer)

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/PrinterJob.html JavaFX PrinterJob]].
 *
 * @constructor Creates a new ScalaFX PrinterJob from its JavaFX counterpart.
 * @param delegate JavaFX PrinterJob. Since there is no public constructor for it, there is not a default value.
 *
 * @since 8.0
 */
final class PrinterJob(override val delegate: jfxp.PrinterJob)
  extends SFXDelegate[jfxp.PrinterJob] {

  /**
   * The JobSettings encapsulates all the API supported job configuration options such as
   * number of copies, collation option, duplex option, etc.
   */
  def jobSettings: JobSettings = delegate.getJobSettings

  /**
   * A read only object property representing the current JobStatus
   */
  def jobStatus: ReadOnlyObjectProperty[jfxp.PrinterJob.JobStatus] = delegate.jobStatusProperty

  /**
   * Property representing the Printer for this job.
   */
  def printer: ObjectProperty[jfxp.Printer] = delegate.printerProperty
  def printer_=(v: Printer) {
    printer() = v
  }

  /**
   * Cancel the underlying print job at the earliest opportunity.
   */
  def cancelJob: Unit = delegate.cancelJob

  /**
   * If the job can be successfully spooled to the printer queue this will return true.
   */
  def endJob: Boolean = delegate.endJob

  /**
   * Print the specified node.
   *
   * @param node The node to print.
   * @return whether rendering was successful.
   */
  def printPage(node: Node): Boolean = delegate.printPage(node)

  /**
   * Print the specified node using the specified page layout.
   *
   * @param pageLayout  Layout for this page.
   * @param node The node to print.
   * @return whether rendering was successful.
   */
  def printPage(pageLayout: PageLayout, node: Node): Boolean = delegate.printPage(pageLayout, node)

  /**
   * Displays a Page Setup dialog.
   *
   * @param to block input, or 'null'.
   * @return false if the user opts to cancel the dialog, or the job is not in the new state.
   *         That is if it has already started, has failed, or has been cancelled, or ended.
   */
  def showPageSetupDialog(owner: Window): Boolean = delegate.showPageSetupDialog(owner)

  /**
   * Displays a Print Dialog.
   *
   * @param to which to block input, or 'null'.
   * @return false if the user opts to cancel printing, or the job is not in the new state.
   *         That is if it has already started, has failed, or has been cancelled, or ended.
   */
  def showPrintDialog(owner: Window): Boolean = delegate.showPrintDialog(owner)

}