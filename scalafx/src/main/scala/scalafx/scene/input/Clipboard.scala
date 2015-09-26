/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

package scalafx.scene.input

import java.io.File
import javafx.scene.{input => jfxsi}

import scala.collection.JavaConversions._
import scala.collection._
import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate
import scalafx.scene.input.DataFormat._
import scalafx.scene.input.InputIncludes.jfxClipboard2sfx

object Clipboard {
  implicit def sfxClipboard2jfx(c: Clipboard): jfxsi.Clipboard = if (c != null) c.delegate else null

  /**
   * Gets the current system clipboard, through which data can be stored and retrieved.
   */
  def systemClipboard: Clipboard = jfxsi.Clipboard.getSystemClipboard
}

class Clipboard(override val delegate: jfxsi.Clipboard) extends SFXDelegate[jfxsi.Clipboard] {

  /**
   * Clears the clipboard of any and all content.
   */
  def clear() {
    delegate.clear()
  }

  /**
   * Returns the content stored in this clipboard
   */
  def content = {
    val cnt = new ClipboardContent()

    contentTypes foreach { dataFormat =>
      cnt.put(dataFormat, delegate.getContent(dataFormat))
    }

    cnt
  }

  /**
   * Returns the content stored in this clipboard of the given type, if any
   */
  def get(dataFormat: DataFormat) = Option(delegate.getContent(dataFormat))

  /**
   * Gets the set of DataFormat types on this Clipboard instance which have associated data registered on the clipboard.
   */
  def contentTypes: Set[DataFormat] = delegate.getContentTypes map (new DataFormat(_))

  /**
   * Gets the list of files from the clipboard which had previously been registered.
   */
  def files: Seq[File] = delegate.getFiles

  /**
   * Gets the HTML text String from the clipboard which had previously been registered.
   */
  def html = delegate.getHtml

  /**
   * Gets the Image from the clipboard which had previously been registered.
   */
  def image = delegate.getImage

  /**
   * Gets the RTF text String from the clipboard which had previously been registered.
   */
  def rtf = delegate.getRtf

  /**
   * Gets the plain text String from the clipboard which had previously been registered.
   */
  def string = delegate.getString

  /**
   * Gets the URL String from the clipboard which had previously been registered.
   */
  def url = delegate.getUrl

  /**
   * Tests whether there is any content on this clipboard of the given DataFormat type.
   */
  def hasContent(dataFormat: DataFormat) = delegate.hasContent(dataFormat)

  /**
   * Gets whether an list of files ([[DataFormat.Files]]) has been registered on this Clipboard.
   */
  def hasFiles = delegate.hasFiles

  /**
   * Gets whether an HTML text String ([[DataFormat.Html]]) has been registered on this Clipboard.
   */
  def hasHtml = delegate.hasHtml

  /**
   * Gets whether an Image ([[DataFormat.Image]]) has been registered on this Clipboard.
   */
  def hasImage = delegate.hasImage

  /**
   * Gets whether an RTF String ([[DataFormat.Rtf]]) has been registered on this Clipboard.
   */
  def hasRtf = delegate.hasRtf

  /**
   * Gets whether a plain text String ([[DataFormat.PlainText]]) has been registered on this Clipboard.
   */
  def hasString = delegate.hasString

  /**
   * Gets whether a url String ([[DataFormat.Url]]) has been registered on this Clipboard.
   */
  def hasUrl = delegate.hasUrl

  /** Puts content onto the clipboard.
    *
    * This call will always result in clearing all previous content from the clipboard,
    * and replacing it with whatever content is specified in the supplied ClipboardContent map.
    *
    * @return `true` if successful, `false` if the content fails to be added.
    * @throws java.lang.NullPointerException - if null data reference is passed for any format
    */
  def content_=(content: Map[DataFormat, AnyRef]) = {
    delegate.setContent(content.map { case (a, b) => (a.delegate, b) })
  }

  /** Puts content onto the clipboard.
    *
    * This call will always result in clearing all previous content from the clipboard,
    * and replacing it with whatever content is specified in the supplied ClipboardContent map.
    *
    * @return `true` if successful, `false` if the content fails to be added.
    * @throws java.lang.NullPointerException - if null data reference is passed for any format
    */
  def content_=(content: ClipboardContent) = delegate.setContent(content)
}
