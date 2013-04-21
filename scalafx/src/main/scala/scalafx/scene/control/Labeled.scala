/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.{ geometry => jfxg }
import javafx.{ scene => jfxs }
import javafx.scene.{ control => jfxsc, paint => jfxsp, text => jfxst }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.beans.property.StringProperty
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.paint.Paint
import scalafx.scene.text.Font.sfxFont2jfx
import scalafx.scene.text.Font
import scalafx.scene.text.TextAlignment
import scalafx.scene.Node
import scalafx.delegate.SFXDelegate
import scalafx.delegate.AlignmentDelegate

object Labeled {
  implicit def sfxLabeled2jfx(v: Labeled) = v.delegate
}

abstract class Labeled(override val delegate: jfxsc.Labeled)
  extends Control(delegate)
  with AlignmentDelegate[jfxsc.Labeled]
  with SFXDelegate[jfxsc.Labeled] {

  /**
   * Specifies the positioning of the graphic relative to the text.
   */
  def contentDisplay: ObjectProperty[jfxsc.ContentDisplay] = delegate.contentDisplayProperty
  def contentDisplay_=(v: ContentDisplay) {
    contentDisplay() = v
  }

  /**
   * The default font to use for text in the Labeled.
   */
  def font: ObjectProperty[jfxst.Font] = delegate.fontProperty
  def font_=(v: Font) {
    font() = v
  }

  /**
   * An optional icon for the Labeled.
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty
  def graphic_=(v: Node) {
    graphic() = v
  }

  /**
   * The amount of space between the graphic and text.
   */
  def graphicTextGap: DoubleProperty = delegate.graphicTextGapProperty
  def graphicTextGap_=(v: Double) {
    graphicTextGap() = v
  }

  /**
   * The padding around the Label's text and graphic content.
   */
  def labelPadding: ReadOnlyObjectProperty[jfxg.Insets] = delegate.labelPaddingProperty

  /**
   * MnemonicParsing property to enable/disable text parsing.
   */
  def mnemonicParsing: BooleanProperty = delegate.mnemonicParsingProperty
  def mnemonicParsing_=(v: Boolean) {
    mnemonicParsing() = v
  }

  /**
   * The text to display in the label.
   */
  def text: StringProperty = delegate.textProperty
  def text_=(v: String) {
    text() = v
  }

  /**
   * Specifies the behavior for lines of text 'when text is multiline' Unlike `Labeled.contentDisplay` which affects
   * the graphic and text, this setting only affects multiple lines of text relative to the text bounds.
   */
  def textAlignment: ObjectProperty[jfxst.TextAlignment] = delegate.textAlignmentProperty
  def textAlignment_=(v: TextAlignment) {
    textAlignment() = v
  }

  /**
   * The [[scalafx.scene.paint.Paint]] used to fill the text.
   */
  def textFill: ObjectProperty[jfxsp.Paint] = delegate.textFillProperty
  def textFill_=(v: Paint) {
    textFill() = v
  }

  /**
   * Specifies the behavior to use if the text of the `Labeled` exceeds the available space for rendering the text.
   */
  def textOverrun: ObjectProperty[jfxsc.OverrunStyle] = delegate.textOverrunProperty
  def textOverrun_=(v: OverrunStyle) {
    textOverrun() = v
  }

  /**
   * Whether all text should be underlined.
   */
  def underline: BooleanProperty = delegate.underlineProperty
  def underline_=(v: Boolean) {
    underline() = v
  }

  /**
   * If a run of text exceeds the width of the `Labeled`, then this variable indicates whether the text should wrap onto
   * another line.
   */
  def wrapText: BooleanProperty = delegate.wrapTextProperty
  def wrapText_=(v: Boolean) {
    wrapText() = v
  }

  /**
   * Specifies the string to display for the ellipsis when text is truncated.
   * For example it might be "..."
   *
   * @since 2.2
   */
  def ellipsisString: StringProperty = delegate.ellipsisStringProperty()
  def ellipsisString_=(v: String) {
    ellipsisString() = v
  }

}
