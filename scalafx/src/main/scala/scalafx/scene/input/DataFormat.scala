/*
 * Copyright (c) 2011-2018, ScalaFX Project
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

import javafx.scene.{input => jfxsi}
import scalafx.delegate.SFXDelegate
import scalafx.scene.input.InputIncludes.jfxDataFormat2sfx

import scala.collection.JavaConverters._
import scala.collection._
import scala.language.implicitConversions

object DataFormat {

  implicit def sfxDataFormat2jfx(ie: DataFormat): jfxsi.DataFormat = if (ie != null) ie.delegate else null

  /**
    * Looks for the DataFormat which has been previously created with the given mime type as one of its ids.
    */
  def lookupMimeType(mimeType: String): DataFormat = jfxsi.DataFormat.lookupMimeType(mimeType)

  /**
    * Represents a List of Files.
    */
  val Files: DataFormat = jfxsi.DataFormat.FILES

  /**
    * Represents an HTML formatted string.
    */
  val Html: DataFormat = jfxsi.DataFormat.HTML

  /**
    * A special platform specific image type, such as is commonly used on the clipboard and interoperates widely with other applications.
    */
  val Image: DataFormat = jfxsi.DataFormat.IMAGE

  /**
    * Represents a plain text string.
    */
  val PlainText: DataFormat = jfxsi.DataFormat.PLAIN_TEXT

  /**
    * Represents an RTF formatted string
    */
  val Rtf: DataFormat = jfxsi.DataFormat.RTF

  /**
    * Represents a URL, encoded as a String
    */
  val Url: DataFormat = jfxsi.DataFormat.URL

}

/**
  * Data format identifier used as means of identifying the data stored on a clipboard/dragboard.
  *
  * Wraps a $JFX [[ $URL0 $FC]].
  *
  * @constructor Creates a new $FC from a $JFX one.
  * @param delegate A $JFX $FC to be wrapped. Its default value is a new $JFX $FC.
  * @define FC   DataFormat
  * @define URL0 http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/DataFormat.html
  * @define JFX  JavaFX
  */
class DataFormat(override val delegate: jfxsi.DataFormat = new jfxsi.DataFormat) extends SFXDelegate[jfxsi.DataFormat] {

  /**
    * Create a new DataFormat, specifying the set of ids that are associated with this data format.
    *
    * @param ids - The set of ids used to represent this DataFormat on the clipboard.
    */
  def this(ids: String*) = this(new jfxsi.DataFormat(ids: _*))

  /**
    * Gets the unmodifiable set of identifiers for this DataFormat.
    */
  def identifiers: Set[String] = delegate.getIdentifiers.asScala

}