/*
 * Copyright (c) 2011-2016, ScalaFX Project
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
import scalafx.scene.image.Image
import scalafx.scene.image.ImageIncludes.jfxImage2sfx
import scalafx.scene.input.DataFormat._
import scalafx.scene.input.InputIncludes.jfxClipboard2sfx

object Clipboard {
  implicit def sfxClipboard2jfx(c: Clipboard): jfxsi.Clipboard = if (c != null) c.delegate else null

  /**
   * Gets the current system clipboard, through which data can be stored and retrieved.
   */
  def systemClipboard: Clipboard = jfxsi.Clipboard.getSystemClipboard
}

/**
 * Represents an operating system clipboard, on which data may be placed during, for example, cut, copy, and paste operations.
 *
 * To access the general system clipboard, use the following code:
 *
 * {{{
 * val clipboard = Clipboard.systemClipboard
 * }}}
 *
 * There is only ever one instance of the system clipboard in the application, so it is perfectly acceptable to stash a reference to it somewhere handy if you so choose.
 *
 * The Clipboard operates on the concept of having a single conceptual item on the clipboard at any one time -- though it may be placed on the clipboard in different formats.
 *
 * Example use:
 * {{{
 *   val clipboard = Clipboard.systemClipboard
 *   val content = new ClipboardContent()
 *   content.putString("Some text")
 *   content.putHtml("<b>Some</b> text")
 *   clipboard.content = content
 * }}}
 *
 * Alternative use:
 * {{{
 *    Clipboard.systemClipboard.content = ClipboardContent(
 *      DataFormat.PlainText -> "Some text",
 *      DataFormat.Html -> "<b>Some</b> text"
 *    )
 * }}}
 *
 * Caution when putting files into the clipboard. The recommended method is:
 * {{{
 *   val content = new ClipboardContent()
 *   content.putString("Some text")
 *
 * }}}
 *
 * Wraps a $JFX $URL0 $FC]].
 *
 * @constructor Creates a new $FC from a $JFX one.
 * @param delegate A $JFX $FC to be wrapped. Its default value is a new $JFX $FC.
  * @define FC         Clipboard
 * @define URL0        [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/Clipboard.html
  * @define JFX        JavaFX
 * @define ORIGINALDOC Original Documentation]].
  **/
class Clipboard(override val delegate: jfxsi.Clipboard) extends SFXDelegate[jfxsi.Clipboard] {

  /**
   * Clears the clipboard of any and all content.
   */
  def clear(): Unit = {
    delegate.clear()
  }

  /**
   * Returns the content stored in this clipboard of the given type, or null if there is no content with this type.
   */
  def content(dataFormat: DataFormat) = delegate.getContent(dataFormat)

  /**
   * Gets the set of DataFormat types on this Clipboard instance which have associated data registered on the clipboard.
   */
  def contentTypes: Set[jfxsi.DataFormat] = delegate.getContentTypes

  /**
   * Gets the list of files from the clipboard which had previously been registered.
   */
  def files: Seq[File] = delegate.getFiles

  /**
   * Gets the HTML text String from the clipboard which had previously been registered.
   */
  def html: String = delegate.getHtml

  /**
   * Gets the Image from the clipboard which had previously been registered.
   */
  def image: Image = delegate.getImage

  /**
   * Gets the RTF text String from the clipboard which had previously been registered.
   */
  def rtf: String = delegate.getRtf

  /**
   * Gets the plain text String from the clipboard which had previously been registered.
   */
  def string: String = delegate.getString

  /**
   * Gets the URL String from the clipboard which had previously been registered.
   */
  def url: String = delegate.getUrl

  /**
   * Tests whether there is any content on this clipboard of the given DataFormat type.
   */
  def hasContent(dataFormat: DataFormat): Boolean = delegate.hasContent(dataFormat)

  /**
   * Gets whether an list of files ([[DataFormat.Files]]) has been registered on this Clipboard.
   */
  def hasFiles: Boolean = delegate.hasFiles

  /**
   * Gets whether an HTML text String ([[DataFormat.Html]]) has been registered on this Clipboard.
   */
  def hasHtml: Boolean = delegate.hasHtml

  /**
   * Gets whether an Image ([[DataFormat.Image]]) has been registered on this Clipboard.
   */
  def hasImage: Boolean = delegate.hasImage

  /**
   * Gets whether an RTF String ([[DataFormat.Rtf]]) has been registered on this Clipboard.
   */
  def hasRtf: Boolean = delegate.hasRtf

  /**
   * Gets whether a plain text String ([[DataFormat.PlainText]]) has been registered on this Clipboard.
   */
  def hasString: Boolean = delegate.hasString

  /**
   * Gets whether a url String ([[DataFormat.Url]]) has been registered on this Clipboard.
   */
  def hasUrl: Boolean = delegate.hasUrl

  /**
   * Return a ```copy``` of the clipboard content.
   */
  def content: ClipboardContent = {
    val v = contentTypes.map { df => new DataFormat(df) -> delegate.getContent(df) }
    ClipboardContent(v.toSeq: _*)
  }

  /**
   * Puts content onto the clipboard.
   *
   * This call will always result in clearing all previous content from the clipboard,
   * and replacing it with whatever content is specified in the supplied ClipboardContent map.
   *
   * @throws java.lang.NullPointerException - if null data reference is passed for any format
   */
  def content_=(content: ClipboardContent): Unit = delegate.setContent(content)
}
