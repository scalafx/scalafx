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
package scalafx.print

import javafx.print as jfxp
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.print.Paper]].
 */
object Paper {

  /**
   * Converts a ScalaFX Paper to its JavaFX counterpart.
   *
   * @param pp ScalaFX Paper
   * @return JavaFX Paper
   */
  implicit def sfxPaper2jfx(pp: Paper): jfxp.Paper = if (pp != null) pp.delegate else null

  /** Specifies the ISO A0 size, 841 mm by 1189 mm. */
  val A0 = new Paper(jfxp.Paper.A0)

  /** Specifies the ISO A1 size, 594 mm by 841 mm. */
  val A1 = new Paper(jfxp.Paper.A1)

  /** Specifies the ISO A2 size, 420 mm by 594 mm. */
  val A2 = new Paper(jfxp.Paper.A2)

  /** Specifies the ISO A3 size, 297 mm by 420 mm. */
  val A3 = new Paper(jfxp.Paper.A3)

  /** Specifies the ISO A4 size, 210 mm by 297 mm. */
  val A4 = new Paper(jfxp.Paper.A4)

  /** Specifies the ISO A5 size, 148 mm by 210 mm. */
  val A5 = new Paper(jfxp.Paper.A5)

  /** Specifies the ISO A6 size, 105 mm by 148 mm. */
  val A6 = new Paper(jfxp.Paper.A6)

  /** Specifies the engineering C size, 17 inch by 22 inch. */
  val C = new Paper(jfxp.Paper.C)

  /** Specifies the ISO Designated Long size, 110 mm by 220 mm. */
  val DesignatedLong = new Paper(jfxp.Paper.DESIGNATED_LONG)

  /** Specifies the executive size, 7.25 inches by 10.5 inches. */
  val Executive = new Paper(jfxp.Paper.EXECUTIVE)

  /** Specifies the Japanese postcard size, 100 mm by 148 mm. */
  val JapanesePostcard = new Paper(jfxp.Paper.JAPANESE_POSTCARD)

  /** Specifies the JIS B4 size, 257 mm by 364 mm. */
  val JisB4 = new Paper(jfxp.Paper.JIS_B4)

  /** Specifies the JIS B5 size, 182 mm by 257 mm. */
  val JisB5 = new Paper(jfxp.Paper.JIS_B5)

  /** Specifies the JIS B6 size, 128 mm by 182 mm. */
  val JisB6 = new Paper(jfxp.Paper.JIS_B6)

  /** Specifies the North American legal size, 8.5 inches by 14 inches. */
  val Legal = new Paper(jfxp.Paper.LEGAL)

  /** Specifies the Monarch envelope size, 3.87 inch by 7.5 inch. */
  val MonarchEnvelope = new Paper(jfxp.Paper.MONARCH_ENVELOPE)

  /** Specifies the North American 8 inch by 10 inch paper. */
  val Na8X10 = new Paper(jfxp.Paper.NA_8X10)

  /** Specifies the North American letter size, 8.5 inches by 11 inches. */
  val NaLetter = new Paper(jfxp.Paper.NA_LETTER)

  /** Specifies the North American Number 10 business envelope size, 4.125 inches by 9.5 inches. */
  val NaNumber10Envelope = new Paper(jfxp.Paper.NA_NUMBER_10_ENVELOPE)

  /** Specifies the tabloid size, 11 inches by 17 inches. */
  val Tabloid = new Paper(jfxp.Paper.TABLOID)

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/Paper.html JavaFX Paper]].
 *
 * @constructor Creates a new ScalaFX Paper from its JavaFX counterpart.
 * @param delegate JavaFX Paper. Since there is no public constructor for it, there is not a default value.
 *
 * @since 8.0
 */
final class Paper(override val delegate: jfxp.Paper)
    extends SFXDelegate[jfxp.Paper] {

  /**
   * The height of the paper in points (1/72 inch)
   */
  def height: Double = delegate.getHeight

  /**
   * The paper name.
   */
  def name: String = delegate.getName

  /**
   * The width of the paper in points (1/72 inch)
   */
  def width: Double = delegate.getWidth

}
