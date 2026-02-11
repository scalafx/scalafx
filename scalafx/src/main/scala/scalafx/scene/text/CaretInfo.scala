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

import javafx.scene.text as jfxst
import scalafx.delegate.SFXDelegate
import scalafx.geometry.GeometryIncludes.jfxRectangle2D2sfx
import scalafx.geometry.Rectangle2D

import scala.language.implicitConversions

object CaretInfo {
  implicit def sfxCaretInfo2jfx(ci: CaretInfo): jfxst.CaretInfo = if (ci != null) ci.delegate else null
}

/**
 * Provides the information associated with the caret.
 *
 * Wraps JavaFX [[https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/text/CaretInfo.html CaretInfo]]
 *
 * @since 25
 */
class CaretInfo(override val delegate: jfxst.CaretInfo) extends SFXDelegate[jfxst.CaretInfo] {

  /**
   * Returns the geometry of the segment at the specified index.
   *
   * @param index the line index
   * @return the bounds of the caret segment
   * @throws IndexOutOfBoundsException if the index is out of range
   *                                   `code (index < 0 || index >= getSegmentCount())`
   */
  def segmentAt(index: Int): Rectangle2D = delegate.getSegmentAt(index)

  /**
   * Returns the number of segments representing the caret.
   *
   * @return the number of segments representing the caret
   */
  def segmentCount: Int = delegate.getSegmentCount
}
