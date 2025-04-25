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
package scalafx.scene.layout

import javafx.scene.layout as jfxsl
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate
import scalafx.geometry.Insets
import scalafx.util.JavaConverters.*

import scala.language.implicitConversions

object Background {
  implicit def sfxBackground2jfx(v: Background): jfxsl.Background = if (v != null) v.delegate else null

  /** An empty Background, useful to use instead of null. */
  val Empty: Background = jfxsl.Background.EMPTY
  @deprecated("Use Empty; EMPTY will be removed in a future release", "8.0.60-R10")
  val EMPTY: Background = Empty

  def classCssMetaData: Seq[javafx.css.CssMetaData[? <: javafx.css.Styleable, ?]] =
    jfxsl.Background.getClassCssMetaData.asScala.toSeq

  /**
   * A convenience factory method for creating a `Background` with a single `Paint`.
   *
   * This call is equivalent to `new Background(new BackgroundFill(fill, null, null))`.
   * @param f the fill of the background. If `null`, `Color.Transparent` will be used.
   * @return a new background of the given fill
   * @since 18.0.0
   */
  def fill(f: javafx.scene.paint.Paint): Background = jfxsl.Background.fill(f)
}

class Background(override val delegate: jfxsl.Background)
    extends SFXDelegate[jfxsl.Background] {

  /** Create a new Background by supplying an array of BackgroundFills. */
  def this(fills: Array[BackgroundFill]) = this(new jfxsl.Background(fills.map(_.delegate)*))

  /** Create a new Background by supplying two arrays, one for background fills, and one for background images. */
  def this(fills: Array[BackgroundFill], images: Array[BackgroundImage]) =
    this(new jfxsl.Background(fills.map(_.delegate), images.map(_.delegate)))

  /** Create a new Background by supplying an array of BackgroundImages. */
  def this(images: Array[BackgroundImage]) = this(new jfxsl.Background(images.map(_.delegate)*))

  /** Create a new Background supply two Lists, one for background fills and one for background images. */
  def this(fills: Seq[BackgroundFill], images: Seq[BackgroundImage]) =
    this(new jfxsl.Background(fills.map(_.delegate).asJava, images.map(_.delegate).asJava))

  /**
   * * The list of BackgroundFills which together define the filled portion of this Background.
   */
  def fills: Seq[jfxsl.BackgroundFill] = delegate.getFills.asScala.toSeq

  /**
   * The list of BackgroundImages which together define the image portion of this Background.
   */
  def images: Seq[jfxsl.BackgroundImage] = delegate.getImages.asScala.toSeq

  /**
   * The outsets of this Background.
   */
  def outsets: Insets = delegate.getOutsets
}
