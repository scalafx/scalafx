/*
 * Copyright (c) 2011-2019, ScalaFX Project
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
package scalafx.scene.layout

import javafx.scene.layout as jfxsl
import scalafx.delegate.SFXDelegate
import scalafx.scene.layout.LayoutIncludes.jfxBorder2sfx

import scala.collection.JavaConverters.*
import scala.language.implicitConversions

object Border {
  implicit def sfxBorder2jfx(v: Border): jfxsl.Border = if (v != null) v.delegate else null

  /** An empty Border, useful to use instead of null. */
  val Empty: Border = jfxsl.Border.EMPTY
  @deprecated("Use Empty; EMPTY will be removed in a future release", "8.0.60-R10")
  val EMPTY: Border = Empty

  /**
   * A convenience factory method for creating a solid `Border` with a single `Paint`.
   *
   * This call is equivalent to `new Border(new BorderStroke(stroke, BorderStrokeStyle.Solid, null, null))`.
   * @param s the stroke of the border (for all sides). If `null`, `Color.Black` will be used.
   * @return a new border of the given stroke
   * @since 18.0.0
   */
  def stroke(s: javafx.scene.paint.Paint): Border = jfxsl.Border.stroke(s)

}

class Border(override val delegate: jfxsl.Border)
    extends SFXDelegate[jfxsl.Border] {

  /** Creates a new Border by supplying an array of BorderImages. */
  def this(images: BorderImage*) = {
    this(new jfxsl.Border(images.map(_.delegate)*))
  }

  /** Creates a new Border by supplying an array of BorderStroke. */
  def this(stroke: BorderStroke) = {
    this(new jfxsl.Border(stroke.delegate))
  }

  /** Creates a new Border by supplying an array of BorderStrokes. */
  def this(stroke: BorderStroke, strokes: BorderStroke*) = {
    this(new jfxsl.Border((Seq(stroke) ++ strokes).map(_.delegate)*))
  }

  /** Creates a new Border by supplying an array of BorderStrokes and BorderImages. */
  def this(strokes: Array[BorderStroke], images: Array[BorderImage]) = {
    this(new jfxsl.Border(strokes.map(_.delegate), images.map(_.delegate)))
  }

  /** Creates a new Border by supplying a List of BorderStrokes and BorderImages. */
  def this(strokes: Seq[BorderStroke], images: Seq[BorderImage]) = {
    this(new jfxsl.Border(strokes.map(_.delegate).asJava, images.map(_.delegate).asJava))
  }
}
