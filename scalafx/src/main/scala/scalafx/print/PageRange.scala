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
import scalafx.beans.property.ReadOnlyIntegerProperty
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.print.PageRange]].
 */
object PageRange {

  /**
   * Converts a ScalaFX PageRange to its JavaFX counterpart.
   *
   * @param pr ScalaFX PageRange
   * @return JavaFX PageRange
   */
  implicit def sfxPageRange2jfx(pr: PageRange): jfxp.PageRange = if (pr != null) pr.delegate else null

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/PageRange.html JavaFX PageRange]].
 *
 * @constructor Creates a new ScalaFX PageRange from its JavaFX counterpart.
 * @param delegate JavaFX PageRange. Since there is no public 'default' constructor for it, there is not a default value.
 *
 * @since 8.0
 */
final class PageRange(override val delegate: jfxp.PageRange)
    extends SFXDelegate[jfxp.PageRange] {

  /**
   * Create a new PageRange with the specified start and end page numbers.
   *
   * @param startPage the first page in the range.
   * @param endPage the last page in the range.
   */
  def this(startPage: Int, endPage: Int) = this(new jfxp.PageRange(startPage, endPage))

  /**
   * IntegerProperty representing the ending page number of the range.
   */
  def startPage: ReadOnlyIntegerProperty = delegate.startPageProperty

  /**
   * IntegerProperty representing the starting page number of the range.
   */
  def endPage: ReadOnlyIntegerProperty = delegate.endPageProperty

}
