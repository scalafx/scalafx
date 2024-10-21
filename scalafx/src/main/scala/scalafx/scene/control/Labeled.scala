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

import javafx.scene.{control as jfxsc, paint as jfxsp, text as jfxst}
import javafx.{geometry as jfxg, scene as jfxs}
import scalafx.Includes.*
import scalafx.beans.property.*
import scalafx.delegate.{AlignmentDelegate, SFXDelegate}
import scalafx.scene.Node
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.paint.Paint
import scalafx.scene.text.Font.sfxFont2jfx
import scalafx.scene.text.{Font, TextAlignment}

import scala.language.implicitConversions

object Labeled {
  implicit def sfxLabeled2jfx(v: Labeled): jfxsc.Labeled = if (v != null) v.delegate else null
}

abstract class Labeled(override val delegate: jfxsc.Labeled)
    extends Control(delegate)
    with AlignmentDelegate[jfxsc.Labeled]
    with SFXDelegate[jfxsc.Labeled] {

  /**
   * Specifies the positioning of the graphic relative to the text.
   */
  def contentDisplay: ObjectProperty[jfxsc.ContentDisplay] = delegate.contentDisplayProperty

  def contentDisplay_=(v: ContentDisplay): Unit = {
    contentDisplay() = v
  }

  /**
   * The default font to use for text in the Labeled.
   */
  def font: ObjectProperty[jfxst.Font] = delegate.fontProperty

  def font_=(v: Font): Unit = {
    font() = v
  }

  /**
   * An optional icon for the Labeled.
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty

  def graphic_=(v: Node): Unit = {
    graphic() = v
  }

  /**
   * The amount of space between the graphic and text.
   */
  def graphicTextGap: DoubleProperty = delegate.graphicTextGapProperty

  def graphicTextGap_=(v: Double): Unit = {
    graphicTextGap() = v
  }

  /**
   * The padding around the Label's text and graphic content.
   */
  def labelPadding: ReadOnlyObjectProperty[jfxg.Insets] = delegate.labelPaddingProperty

  /**
   * Specifies the space in pixel between lines.
   */
  def lineSpacing: DoubleProperty = delegate.lineSpacingProperty

  def lineSpacing_=(v: Double): Unit = {
    lineSpacing() = v
  }

  /**
   * MnemonicParsing property to enable/disable text parsing.
   */
  def mnemonicParsing: BooleanProperty = delegate.mnemonicParsingProperty

  def mnemonicParsing_=(v: Boolean): Unit = {
    mnemonicParsing() = v
  }

  /**
   * The text to display in the label.
   */
  def text: StringProperty = delegate.textProperty

  def text_=(v: String): Unit = {
    text() = v
  }

  /**
   * Specifies the behavior for lines of text 'when text is multiline' Unlike `Labeled.contentDisplay` which affects
   * the graphic and text, this setting only affects multiple lines of text relative to the text bounds.
   */
  def textAlignment: ObjectProperty[jfxst.TextAlignment] = delegate.textAlignmentProperty

  def textAlignment_=(v: TextAlignment): Unit = {
    textAlignment() = v
  }

  /**
   * The [[scalafx.scene.paint.Paint]] used to fill the text.
   */
  def textFill: ObjectProperty[jfxsp.Paint] = delegate.textFillProperty

  def textFill_=(v: Paint): Unit = {
    textFill() = v
  }

  /**
   * Specifies the behavior to use if the text of the `Labeled` exceeds the available space for rendering the text.
   */
  def textOverrun: ObjectProperty[jfxsc.OverrunStyle] = delegate.textOverrunProperty

  def textOverrun_=(v: OverrunStyle): Unit = {
    textOverrun() = v
  }

  /**
   * Indicates whether the text has been truncated
   * because it cannot fit into the available width.
   *
   * When truncated, the [[ellipsisString ellipsisString]]
   * gets inserted in the place dictated by the
   * [[textOverrun textOverrun]] property.
   *
   * @since 23
   */
  def textTruncated: ReadOnlyBooleanProperty = delegate.textTruncatedProperty

  /**
   * Whether all text should be underlined.
   */
  def underline: BooleanProperty = delegate.underlineProperty

  def underline_=(v: Boolean): Unit = {
    underline() = v
  }

  /**
   * If a run of text exceeds the width of the `Labeled`, then this variable indicates whether the text should wrap onto
   * another line.
   */
  def wrapText: BooleanProperty = delegate.wrapTextProperty

  def wrapText_=(v: Boolean): Unit = {
    wrapText() = v
  }

  /**
   * Specifies the string to display for the ellipsis when text is truncated.
   * For example it might be "..."
   *
   * @since 2.2
   */
  def ellipsisString: StringProperty = delegate.ellipsisStringProperty()

  def ellipsisString_=(v: String): Unit = {
    ellipsisString() = v
  }

}
