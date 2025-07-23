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
package scalafx.scene.web

import javafx.scene.web as jfxsw
import scalafx.delegate.SFXDelegate
import scalafx.print.PrinterJob
import scalafx.scene.control.Control

import scala.language.implicitConversions

/**
 * Companion object for [[scalafx.scene.web.HTMLEditor]]
 */
object HTMLEditor {

  /**
   * Converts a ScalaFX HTMLEditor to its JavaFX counterpart.
   *
   * @param he ScalaFX HTMLEditor
   * @return JavaFX HTMLEditor
   */
  implicit def sfxHTMLEditor2jfx(he: HTMLEditor): jfxsw.HTMLEditor = if (he != null) he.delegate else null

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/HTMLEditor.html JavaFX HTMLEditor]]
 *
 * @constructor Creates a new HTMLEditor from its JavaFX counterpart.
 * @param delegate JavaFX HTMLEditor. Its default value is a new instance.
 */
class HTMLEditor(override val delegate: jfxsw.HTMLEditor = new jfxsw.HTMLEditor)
    extends Control(delegate)
    with SFXDelegate[jfxsw.HTMLEditor] {

  /**
   * Returns the HTML content of the editor.
   */
  def htmlText: String = delegate.getHtmlText

  def htmlText_=(htmlText: String): Unit = {
    delegate.setHtmlText(htmlText)
  }

  /**
   * Prints the content of the editor using the given printer job.
   *
   * @param job printer job used for printing
   * @since 8.0
   */
  def print(job: PrinterJob): Unit = delegate.print(job)

}
