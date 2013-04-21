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
package scalafx.colorselector

import scalafx.scene.paint.Color
import scalafx.util.StringConverter

object Formatter {
  val formatters = List(HexFormatter, RgbFormatter, PercentFormatter, HsbFormatter)

}

abstract sealed case class Formatter(description: String) {

  import colorselector._

  protected def colorToRgbInt(c: Color): (Int, Int, Int) =
    (doubleToInt(c.red), doubleToInt(c.green), doubleToInt(c.blue))

  protected def formatWithAlpha(c: Color): String

  protected def formatWithoutAlpha(c: Color): String

  def format(c: Color, hasAlpha: Boolean): String =
    if (hasAlpha) formatWithAlpha(c) else formatWithoutAlpha(c)

}

object HexFormatter extends Formatter("Hexadecimal") {
  val HEXADECIMAL_FORMAT = "#%02x%02x%02x"

  def formatWithAlpha(c: Color): String = {
    val (r, g, b) = super.colorToRgbInt(c)
    HEXADECIMAL_FORMAT.format(r, g, b).toUpperCase
  }

  def formatWithoutAlpha(c: Color): String = formatWithAlpha(c)

}

object RgbFormatter extends Formatter("RGB") {
  val RGB_FORMAT = "rgb(%3d, %3d, %3d)"
  val RGBA_FORMAT = "rgba(%3d, %3d, %3d, %.2f)"

  def formatWithAlpha(c: Color): String = {
    val (r, g, b) = super.colorToRgbInt(c)
    RGBA_FORMAT.format(r, g, b, c.opacity)
  }

  def formatWithoutAlpha(c: Color): String = {
    val (r, g, b) = super.colorToRgbInt(c)
    RGB_FORMAT.format(r, g, b)
  }

}

object PercentFormatter extends Formatter("Percent") {
  val RGB_FORMAT = "rgb(%3d%%, %3d%%, %3d%%)"
  val RGBA_FORMAT = "rgba(%3d%%, %3d%%, %3d%%, %.2f)"

  private def doubleToInt(d: Double) = (100 * d).toInt

  def formatWithAlpha(c: Color): String =
    RGBA_FORMAT.format(doubleToInt(c.red), doubleToInt(c.green), doubleToInt(c.blue), c.opacity)

  def formatWithoutAlpha(c: Color): String =
    RGB_FORMAT.format(doubleToInt(c.red), doubleToInt(c.green), doubleToInt(c.blue))
}

object HsbFormatter extends Formatter("HSB") {
  val HSB_FORMAT = "hsb(%3.0f, %3.0f%%, %3.0f%%)"
  val HSBA_FORMAT = "hsba(%3.0f, %3.0f%%, %3.0f%%, %.2f)"

  private def colorToHsb(c: Color): (Double, Double, Double) =
    (c.hue, (c.saturation * 100), (c.brightness * 100))

  def formatWithAlpha(c: Color): String = {
    val (h, s, b) = colorToHsb(c)
    HSBA_FORMAT.format(h, s, b, c.opacity)
  }

  def formatWithoutAlpha(c: Color): String = {
    val (h, s, b) = colorToHsb(c)
    HSB_FORMAT.format(h, s, b)
  }
}