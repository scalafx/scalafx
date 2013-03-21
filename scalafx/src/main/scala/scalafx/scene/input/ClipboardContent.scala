/*
* Copyright (c) 2012, ScalaFX Project
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

import scala.collection.JavaConversions._
import scala.collection.MapProxy
import scala.collection.Seq

import javafx.scene.{input => jfxsi}
import scalafx.scene.image.Image.sfxImage2jfx
import scalafx.scene.image.Image
import scalafx.delegate.SFXDelegate

object ClipboardContent {
  implicit def sfxClipboardContent2jfx(c: ClipboardContent) = c.delegate
}

class ClipboardContent(override val delegate: jfxsi.ClipboardContent = new jfxsi.ClipboardContent) extends MapProxy[DataFormat, AnyRef] with SFXDelegate[jfxsi.ClipboardContent] {

  def self = delegate.asInstanceOf[MapProxy[DataFormat, AnyRef]]

  /**
   * Gets the List of Files from the clipboard which had previously been registered.
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
   * Gets whether an List of Files (DataFormat.FILES) has been registered on this Clipboard.
   */
  def hasFiles = delegate.hasFiles

  /**
   * Gets whether an HTML text String (DataFormat.HTML) has been registered on this Clipboard.
   */
  def hasHtml = delegate.hasHtml

  /**
   * Gets whether an Image (DataFormat.IMAGE) has been registered on this Clipboard.
   */
  def hasImage = delegate.hasImage

  /**
   * Gets whether an RTF String (DataFormat.RTF) has been registered on this Clipboard.
   */
  def hasRtf = delegate.hasRtf

  /**
   * Gets whether a plain text String (DataFormat.PLAIN_TEXT) has been registered on this Clipboard.
   */
  def hasString = delegate.hasString

  /**
   * Gets whether a url String (DataFormat.URL) has been registered on this Clipboard.
   */
  def hasUrl = delegate.hasUrl

  /**
   * Puts an List of Files onto the Clipboard.
   */
  def putFiles(files: Seq[File]) = delegate.putFiles(files)

  /**
   * Puts an List of Files onto the Clipboard, based on the file path.
   */
  def putFilesByPath(filePaths: Seq[String]) = delegate.putFilesByPath(filePaths)

  /**
   * Puts an HTML text String onto the Clipboard.
   */
  def putHtml(html: String) = delegate.putHtml(html)

  /**
   * Puts an Image onto the Clipboard.
   */
  def putImage(i: Image) = delegate.putImage(i)

  /**
   * Puts an RTF text String onto the Clipboard.
   */
  def putRtf(rtf: String) = delegate.putRtf(rtf)

  /**
   * Puts a plain text String onto the Clipboard.
   */
  def putString(string: String) = delegate.putString(string)

  /**
   * Puts a URL String onto the Clipboard.
   */
  def putUrl(url: String) = delegate.putUrl(url)

}