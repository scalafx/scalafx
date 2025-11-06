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
package scalafx.scene.text

import javafx.scene.{paint as jfxsp, shape as jfxss, text as jfxst}
import javafx.{geometry as jfxg, scene as jfxs}
import scalafx.Includes.*
import scalafx.beans.property.*
import scalafx.delegate.{PositionDelegate, SFXDelegate}
import scalafx.geometry.VPos
import scalafx.scene.paint.Paint
import scalafx.scene.shape.Shape
import scalafx.scene.text.Font.sfxFont2jfx

import scala.language.implicitConversions

object Text {
  implicit def sfxText2jfx(v: Text): jfxs.text.Text = if (v != null) v.delegate else null

}

class Text(override val delegate: jfxst.Text = new jfxst.Text)
    extends Shape(delegate)
    with PositionDelegate[jfxst.Text]
    with SFXDelegate[jfxst.Text] {

  /**
   * Creates an instance of Text containing the given string.
   */
  def this(t: String) = this(new jfxst.Text(t))

  /**
   * Creates an instance of Text on the given coordinates containing the given string.
   */
  def this(x: Double, y: Double, t: String) = this(new jfxst.Text(x, y, t))

  /**
   * The 'alphabetic' (or roman) baseline offset from the Text node's layoutBounds.minY location.
   */
  // NOTE IMPLEMENTATION: Added "Property" suffix to not conflict with Node.baselineOffset() method.
  def baselineOffsetProperty: ReadOnlyDoubleProperty = delegate.baselineOffsetProperty

  /**
   * Determines how the bounds of the text node are calculated.
   */
  def boundsType: ObjectProperty[jfxst.TextBoundsType] = delegate.boundsTypeProperty

  def boundsType_=(v: TextBoundsType): Unit = {
    boundsType() = v
  }

  /**
   * Defines the font of text.
   */
  def font: ObjectProperty[jfxst.Font] = delegate.fontProperty

  def font_=(v: Font): Unit = {
    font() = v
  }

  /**
   * Specifies a requested font smoothing type : gray or LCD.
   */
  def fontSmoothingType: ObjectProperty[jfxst.FontSmoothingType] = delegate.fontSmoothingTypeProperty

  def fontSmoothingType_=(v: FontSmoothingType): Unit = {
    fontSmoothingType() = v
  }

  /**
   * Defines the vertical space in pixel between lines.
   */
  def lineSpacing: DoubleProperty = delegate.lineSpacingProperty

  def lineSpacing_=(v: Double): Unit = {
    lineSpacing() = v
  }

  /**
   * Defines if each line of text should have a line through it.
   */
  def strikethrough: BooleanProperty = delegate.strikethroughProperty

  def strikethrough_=(v: Boolean): Unit = {
    strikethrough() = v
  }

  /**
   * The size of a tab stop in spaces. Values less than 1 are treated as 1.
   */
  def tabSize: IntegerProperty = delegate.tabSizeProperty()

  def tabSize_=(v: Int): Unit = {
    tabSize() = v
  }

  /**
   * Defines text string that is to be displayed.
   */
  def text: StringProperty = delegate.textProperty

  def text_=(v: String): Unit = {
    text() = v
  }

  /**
   * Defines horizontal text alignment in the bounding box.
   */
  def textAlignment: ObjectProperty[jfxst.TextAlignment] = delegate.textAlignmentProperty

  def textAlignment_=(v: TextAlignment): Unit = {
    textAlignment() = v
  }

  /**
   * Defines the origin of text coordinate system in local coordinates.
   */
  def textOrigin: ObjectProperty[jfxg.VPos] = delegate.textOriginProperty

  def textOrigin_=(v: VPos): Unit = {
    textOrigin() = v
  }

  /**
   * Defines if each line of text should have a line below it.
   */
  def underline: BooleanProperty = delegate.underlineProperty

  def underline_=(v: Boolean): Unit = {
    underline() = v
  }

  /**
   * Defines a width constraint for the text in user space coordinates, e.g. pixels, not glyph or
   * character count.
   */
  def wrappingWidth: DoubleProperty = delegate.wrappingWidthProperty

  def wrappingWidth_=(v: Double): Unit = {
    wrappingWidth() = v
  }

  /**
   * Caret bias in the content. `true` means a bias towards the leading character edge.
   * (true=leading/false=trailing)
   */
  def caretBias: BooleanProperty = delegate.caretBiasProperty

  def caretBias_=(v: Boolean): Unit = {
    caretBias() = v
  }

  /**
   * The fill color of selected text.
   */
  def selectionFill: ObjectProperty[jfxsp.Paint] = delegate.selectionFillProperty

  def selectionFill_=(v: Paint): Unit = {
    selectionFill() = v
  }

  /**
   * Caret index in the content. Set to `-1` to unset caret.
   */
  def caretPosition: IntegerProperty = delegate.caretPositionProperty

  def caretPosition_=(v: Int): Unit = {
    caretPosition() = v
  }

  /**
   * Shape of caret in local coordinates.
   */
  def caretShape: ReadOnlyObjectProperty[Array[jfxss.PathElement]] = delegate.caretShapeProperty

  /**
   * Shape of selection in local coordinates.
   */
  def selectionShape: ReadOnlyObjectProperty[Array[jfxss.PathElement]] = delegate.selectionShapeProperty

  /**
   * Selection start index in the content.
   * Set to `-1` to unset selection.
   */
  def selectionStart: IntegerProperty = delegate.selectionStartProperty

  def selectionStart_=(v: Int): Unit = {
    selectionStart() = v
  }

  /**
   * Selection end index in the content.
   * Set to `-1` to unset selection.
   */
  def selectionEnd: IntegerProperty = delegate.selectionEndProperty

  def selectionEnd_=(v: Int): Unit = {
    selectionEnd() = v
  }

  /**
   * Returns a copy of the text layout geometry for this node.
   */
  def layoutInfo: LayoutInfo = delegate.getLayoutInfo()
}
