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
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

/**
 * Companion Object for [[scalafx.print.PageLayout]].
 */
object PageLayout {

  /**
   * Converts a ScalaFX PageLayout to its JavaFX counterpart.
   *
   * @param pl ScalaFX PageLayout
   * @return JavaFX PageLayout
   */
  implicit def sfxPageLayout2jfx(pl: PageLayout): jfxp.PageLayout = pl.delegate

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/PageLayout.html JavaFX PageLayout]].
 *
 * @constructor Creates a new ScalaFX PageLayout from its JavaFX counterpart.
 * @param delegate JavaFX PageLayout. Since there is no public constructor for it, there is not a default value.
 *
 * @since 8.0
 */
final class PageLayout(override val delegate: jfxp.PageLayout)
  extends SFXDelegate[jfxp.PageLayout] {

  /**
   * The bottom margin of the page layout in points.
   */
  def bottomMargin: Double = delegate.getBottomMargin

  /**
   * The left margin of the page layout in points.
   */
  def leftMargin: Double = delegate.getLeftMargin

  /**
   * The Page orientation
   */
  def pageOrientation: PageOrientation = delegate.getPageOrientation

  /**
   * The paper used.
   */
  def paper: Paper = delegate.getPaper

  /**
   * The height dimension of the printable area of the page, in 1/72 of an inch,
   * taking into account the orientation.
   */
  def printableHeight: Double = delegate.getPrintableHeight

  /**
   *  The width dimension of the printable area of the page, in 1/72 of an inch points,
   *  taking into account the orientation.
   */
  def printableWidth: Double = delegate.getPrintableWidth

  /**
   * The right margin of the page layout in points.
   */
  def rightMargin: Double = delegate.getRightMargin

  /**
   * The top margin of the page layout in points.
   */
  def topMargin: Double = delegate.getTopMargin

}