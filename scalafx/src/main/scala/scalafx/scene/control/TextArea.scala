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

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, IntegerProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object TextArea {
  implicit def sfxTextArea2jfx(v: TextArea): jfxsc.TextArea = if (v != null) v.delegate else null
}

class TextArea(override val delegate: jfxsc.TextArea = new jfxsc.TextArea())
    extends TextInputControl(delegate)
    with SFXDelegate[jfxsc.TextArea] {

  /**
   * Creates a TextArea with initial text content.
   *
   * @param text - A string for text content.
   */
  def this(text: String) = this(new jfxsc.TextArea(text))

  def prefColumnCount: IntegerProperty = delegate.prefColumnCountProperty()

  def prefColumnCount_=(v: Int): Unit = {
    prefColumnCount() = v
  }

  def prefRowCount: IntegerProperty = delegate.prefRowCountProperty()

  def prefRowCount_=(v: Int): Unit = {
    prefRowCount() = v
  }

  def scrollLeft: DoubleProperty = delegate.scrollLeftProperty()

  def scrollLeft_=(v: Double): Unit = {
    scrollLeft() = v
  }

  def scrollTop: DoubleProperty = delegate.scrollTopProperty()

  def scrollTop_=(v: Double): Unit = {
    scrollTop() = v
  }

  def wrapText: BooleanProperty = delegate.wrapTextProperty()

  def wrapText_=(v: Boolean): Unit = {
    wrapText() = v
  }

  def paragraphs: ObservableBuffer[CharSequence] = delegate.getParagraphs

}
