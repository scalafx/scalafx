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

package scalafx.scene.input

import java.io.File

import javafx.scene.{input => jfxsi}
import scalafx.delegate.SFXDelegate
import scalafx.scene.image.Image
import scalafx.scene.image.Image.sfxImage2jfx
import scalafx.scene.image.ImageIncludes.jfxImage2sfx

import scalafx.util.JavaConverters._
import scala.collection.{Map, Seq}
import scala.language.implicitConversions

object ClipboardContent {
  implicit def sfxClipboardContent2jfx(c: ClipboardContent): jfxsi.ClipboardContent = if (c != null) c.delegate else null

  def apply[T <: AnyRef](arg: Map[DataFormat, T]): ClipboardContent = {
    val c = new jfxsi.ClipboardContent()
    arg.foreach { case (k, v) => c.put(k.delegate, v) }
    new ClipboardContent(c)
  }

  def apply[T <: AnyRef](elems: (DataFormat, T)*): ClipboardContent = {
    val c = new jfxsi.ClipboardContent()
    elems.foreach { case (k, v) => c.put(k.delegate, v) }
    new ClipboardContent(c)
  }
}

/**
  * Data container for Clipboard data. It can hold multiple data in several data formats.
  *
  * Example use:
  * {{{
  *   val content = new ClipboardContent()
  *   content.putString("Some text")
  *   content.putHtml("<b>Some</b> text")
  * }}}
  *
  * Alternative use:
  * {{{
  *    val content = ClipboardContent(
  *      DataFormat.PlainText -> "Some text",
  *      DataFormat.Html -> "<b>Some</b> text"
  *    )
  * }}}
  *
  * Caution when putting files into the clipboard. The recommended way is to use `putFiles` method:
  * {{{
  *   content.putFiles(Seq(new File("one"), new File("two"))) *
  * }}}
  *
  * When using with `DataFormat.Files` you have to use Java `List` as a container, which is less convenient:
  * {{{
  *   import scalafx.util.JavaConverters._
  *
  *   val content = ClipboardContent(
  *     DataFormat.Files -> Seq(new File("one"), new File("two")).asJava,
  *   )
  * }}}
  *
  * Wraps a [[ $JFX $URL0 $FC]].
  *
  * @constructor Creates a new $FC from a $JFX one.
  * @param delegate A $JFX $FC to be wrapped. Its default value is a new $JFX $FC.
  * @define FC   ClipboardContent
  * @define URL0 http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/ClipboardContent.html
  * @define JFX  JavaFX
  */
class ClipboardContent(override val delegate: jfxsi.ClipboardContent = new jfxsi.ClipboardContent)
  extends JMapWrapperLike[jfxsi.DataFormat, AnyRef, ClipboardContent]
    with SFXDelegate[jfxsi.ClipboardContent] {

  override def underlying: java.util.Map[jfxsi.DataFormat, AnyRef] = delegate

  /**
    * Gets the List of Files from the clipboard which had previously been registered.
    */
  def files: Seq[File] = delegate.getFiles.asScala

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
    * Gets whether an List of Files (DataFormat.FILES) has been registered on this Clipboard.
    */
  def hasFiles: Boolean = delegate.hasFiles

  /**
    * Gets whether an HTML text String (DataFormat.HTML) has been registered on this Clipboard.
    */
  def hasHtml: Boolean = delegate.hasHtml

  /**
    * Gets whether an Image (DataFormat.IMAGE) has been registered on this Clipboard.
    */
  def hasImage: Boolean = delegate.hasImage

  /**
    * Gets whether an RTF String (DataFormat.RTF) has been registered on this Clipboard.
    */
  def hasRtf: Boolean = delegate.hasRtf

  /**
    * Gets whether a plain text String (DataFormat.PLAIN_TEXT) has been registered on this Clipboard.
    */
  def hasString: Boolean = delegate.hasString

  /**
    * Gets whether a url String (DataFormat.URL) has been registered on this Clipboard.
    */
  def hasUrl: Boolean = delegate.hasUrl

  /**
    * Puts an List of Files onto the Clipboard.
    */
  def putFiles(files: Seq[File]): Boolean = delegate.putFiles(files.asJava)

  /**
    * Puts an List of Files onto the Clipboard, based on the file path.
    */
  def putFilesByPath(filePaths: Seq[String]): Boolean = delegate.putFilesByPath(filePaths.asJava)

  /**
    * Puts an HTML text String onto the Clipboard.
    */
  def putHtml(html: String): Boolean = delegate.putHtml(html)

  /**
    * Puts an Image onto the Clipboard.
    */
  def putImage(i: Image): Boolean = delegate.putImage(i)

  /**
    * Puts an RTF text String onto the Clipboard.
    */
  def putRtf(rtf: String): Boolean = delegate.putRtf(rtf)

  /**
    * Puts a plain text String onto the Clipboard.
    */
  def putString(string: String): Boolean = delegate.putString(string)

  /**
    * Puts a URL String onto the Clipboard.
    */
  def putUrl(url: String): Boolean = delegate.putUrl(url)
}