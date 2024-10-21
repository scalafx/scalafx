/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
package scalafx.scene.media

import javafx.scene.{media => jfxsm}
import javafx.{util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.{ObjectProperty, ReadOnlyIntegerProperty, ReadOnlyObjectProperty}
import scalafx.collections.CollectionIncludes.jfxObservableMap2sfxObservableMap
import scalafx.collections.{ObservableBuffer, ObservableMap}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Media {
  implicit def sfxMedia2jfx(m: Media): jfxsm.Media = if (m != null) m.delegate else null
}

class Media(override val delegate: jfxsm.Media) extends SFXDelegate[jfxsm.Media] {

  /**
   * Constructs a Media instance.
   */
  def this(source: String) = this(new jfxsm.Media(source))

  /**
   * The duration in seconds of the source media.
   */
  def duration: ReadOnlyObjectProperty[jfxu.Duration] = delegate.durationProperty

  /**
   * A property set to a MediaException value when an error occurs.
   */
  def error: ReadOnlyObjectProperty[jfxsm.MediaException] = delegate.errorProperty

  /**
   * The height in pixels of the source media.
   */
  def height: ReadOnlyIntegerProperty = delegate.heightProperty

  /** Retrieve the markers defined on this Media instance. */
  def markers: ObservableMap[String, jfxu.Duration] = delegate.getMarkers

  /** Retrieve the metadata contained in this media source. */
  def metadata: ObservableMap[String, AnyRef] = delegate.getMetadata

  /**
   * Event handler called when an error occurs.
   */
  def onError: ObjectProperty[Runnable] = delegate.onErrorProperty

  def onError_=(v: Runnable): Unit = {
    onError() = v
  }

  def onError_=(op: => Unit): Unit = {
    onError() = new Runnable {
      def run(): Unit = {
        op
      }
    }
  }

  /**
   * Retrieve the source URI of the media.
   */
  def source: String = delegate.getSource

  /**
   * Retrieve the tracks contained in this media source.
   */
  def tracks: ObservableBuffer[jfxsm.Track] = delegate.getTracks

  /**
   * The width in pixels of the source media.
   */
  def width: ReadOnlyIntegerProperty = delegate.widthProperty

}
