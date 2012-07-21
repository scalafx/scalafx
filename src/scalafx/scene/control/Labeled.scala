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

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.scene.{paint => jfxsp}
import javafx.scene.{text => jfxst}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.StringProperty
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.text.Font.sfxFont2jfx
import scalafx.scene.text.Font
import scalafx.scene.Node
import scalafx.util.SFXDelegate

object Labeled {
  implicit def sfxLabeled2jfx(v: Labeled) = v.delegate
}

abstract class Labeled(override val delegate: jfxsc.Labeled)
  extends Control(delegate)
  with SFXDelegate[jfxsc.Labeled] {

  def contentDisplay = delegate.contentDisplayProperty
  def contentDisplay_=(v: jfxsc.ContentDisplay) {
    contentDisplay() = v
  }

  def font = delegate.fontProperty
  def font_=(v: Font) {
    font() = v
  }

  def graphic = delegate.graphicProperty
  def graphic_=(v: Node) {
    graphic() = v
  }

  def graphicTextGap: DoubleProperty = delegate.graphicTextGapProperty
  def graphicTextGap_=(v: Double) {
    graphicTextGap() = v
  }

  def labelPadding = delegate.labelPaddingProperty

  def mnemonicParsing: BooleanProperty = delegate.mnemonicParsingProperty
  def mnemonicParsing_=(v: Boolean) {
    mnemonicParsing() = v
  }

  def text: StringProperty = delegate.textProperty
  def text_=(v: String) {
    text() = v
  }

  def textAlignment = delegate.textAlignmentProperty
  def textAlignment_=(v: jfxst.TextAlignment) {
    textAlignment() = v
  }

  def textFill = delegate.textFillProperty
  def textFill_=(v: jfxsp.Paint) {
    textFill() = v
  }

  def textOverrun = delegate.textOverrunProperty
  def textOverrun_=(v: jfxsc.OverrunStyle) {
    textOverrun() = v
  }

  def underline: BooleanProperty = delegate.underlineProperty
  def underline_=(v: Boolean) {
    underline() = v
  }

  def wrapText: BooleanProperty = delegate.wrapTextProperty
  def wrapText_=(v: Boolean) {
    wrapText() = v
  }
}
