/*
 * Copyright (c) 2011-2026, ScalaFX Project
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

import javafx.geometry as jfxg
import javafx.scene.text as jfxst
import scalafx.delegate.SFXDelegate
import scalafx.geometry.GeometryIncludes.jfxRectangle2D2sfx
import scalafx.geometry.Rectangle2D
import scalafx.scene.text.TextIncludes.{jfxCaretInfo2sfx, jfxTextLineInfo2sfx}
import scalafx.util.JavaConverters.*

import scala.language.implicitConversions

object LayoutInfo {
  implicit def sfxLayoutInfo2jfx(v: LayoutInfo): jfxst.LayoutInfo = if (v != null) v.delegate else null
}

/**
 * Holds a snapshot of the text layout geometry in a Text or a TextFlow node,
 * such as break up of the text into lines,
 * as well as other shapes derived from the layout (selection, underline, etc.).
 *
 * Wraps JavaFX [[https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/text/LayoutInfo.html LayoutInfo]]
 */
class LayoutInfo(override val delegate: jfxst.LayoutInfo)
    extends SFXDelegate[jfxst.LayoutInfo] {

  /**
   * Returns the logical bounds of the layout.
   * Depending on `includeLineSpacing`, the return value may include the line spacing after the
   * last line of text.
   *
   * @param includeLineSpacing determines whether the line spacing after last text line should be included
   * @return the layout bounds
   */
  def logicalBounds(includeLineSpacing: Boolean): Rectangle2D = delegate.getLogicalBounds(includeLineSpacing)

  /**
   * Returns the number of text lines in the layout.
   *
   * @return the number of text lines
   */
  def textLineCount: Int = delegate.getTextLineCount

  /**
   * Returns the immutable list of text lines in the layout.
   *
   * @param includeLineSpacing determines whether the result includes the line spacing
   * @return the immutable list of `TextLineInfo` objects
   */
  def textLines(includeLineSpacing: Boolean): Seq[jfxst.TextLineInfo] =
    delegate.getTextLines(includeLineSpacing).asScala.toSeq

  /**
   * Returns the `TextLineInfo` object which contains information about
   * the text line at index `index`.
   *
   * @param index              the line index
   * @param includeLineSpacing determines whether the result includes the line spacing
   * @return the `TextLineInfo` object
   * @throws IndexOutOfBoundsException if the index is out of range
   *                                   {@code (index < 0 || index >= getTextLineCount())}
   */
  def textLine(index: Int, includeLineSpacing: Boolean): TextLineInfo = delegate.getTextLine(index, includeLineSpacing)

  /**
   * Returns the geometry of the text selection, as an immutable list of `Rectangle2D` objects,
   * for the given start and end offsets.
   *
   * @param start              the start offset
   * @param end                the end offset
   * @param includeLineSpacing determines whether the result includes the line spacing
   * @return the immutable list of `Rectangle2D` objects
   */
  def selectionGeometry(start: Int, end: Int, includeLineSpacing: Boolean): Seq[jfxg.Rectangle2D] =
    delegate.getSelectionGeometry(start, end, includeLineSpacing).asScala.toSeq

  /**
   * Returns the geometry of the strike-through shape, as an immutable list of `Rectangle2D` objects,
   * for the given start and end offsets.
   *
   * @param start the start offset
   * @param end   the end offset
   * @return the immutable list of `Rectangle2D` objects
   */
  def strikeThroughGeometry(start: Int, end: Int): Seq[jfxg.Rectangle2D] =
    delegate.getStrikeThroughGeometry(start, end).asScala.toSeq

  /**
   * Returns the geometry of the underline shape, as an immutable list of `Rectangle2D` objects,
   * for the given start and end offsets.
   *
   * @param start the start offset
   * @param end   the end offset
   * @return the immutable list of `Rectangle2D` objects
   */
  def getUnderlineGeometry(start: Int, end: Int): Seq[jfxg.Rectangle2D] =
    delegate.getUnderlineGeometry(start, end).asScala.toSeq

  /**
   * Returns the information related to the caret at the specified character index and the character bias.
   *
   * @param charIndex the character index
   * @param leading   whether the caret is biased on the leading edge of the character
   * @return the `CaretInfo` object
   */
  def caretInfoAt(charIndex: Int, leading: Boolean): CaretInfo = delegate.caretInfoAt(charIndex, leading)

}
