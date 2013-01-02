/*
 * Copyright (c) 2011, ScalaFX Project
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

import scala.collection.JavaConversions._

import javafx.scene.{ text => jfxst }
import scalafx.util.SFXDelegate

object Font {
  implicit def sfxFont2jfx(v: Font) = v.delegate

  /**
   * Gets the default font which will be from the family "System", and typically the style
   * "Regular", and be of a size consistent with the user's desktop environment, to the extent
   * that can be determined.
   */
  def default = jfxst.Font.getDefault

  /**
   * Gets all the font families installed on the user's system, including any
   *  application fonts or SDK fonts.
   */
  def families = jfxst.Font.getFamilies.toSeq

  /**
   * Searches for an appropriate font based on the font family name and size.
   */
  def font(family: String, size: Double) =
    new Font(jfxst.Font.font(family, size))

  /**
   * Searches for an appropriate font based on the font family name and posture
   * style.
   */
  def font(family: String, posture: jfxst.FontPosture, size: Double) =
    new Font(jfxst.Font.font(family, posture, size))

  /**
   * Searches for an appropriate font based on the font family name and weight style.
   */
  def font(family: String, weight: jfxst.FontWeight, size: Double) =
    new Font(jfxst.Font.font(family, weight, size))

  /**
   * Searches for an appropriate font based on the font family name and weight and posture style.
   */
  def font(family: String, weight: jfxst.FontWeight, posture: jfxst.FontPosture, size: Double) =
    new Font(jfxst.Font.font(family, weight, posture, size))

  /**
   * Gets the names of all fonts that are installed on the users system, including any application
   * fonts and SDK fonts.
   */
  def fontNames = jfxst.Font.getFontNames.toSeq

  /**
   * Gets the names of all fonts in the specified font family that are installed on the users
   * system, including any application fonts and SDK fonts.
   */
  def fontNames(family: String) = jfxst.Font.getFontNames(family).toSeq

  /**
   * Loads a font resource from the specified input stream.
   */
  def loadFont(in: java.io.InputStream, size: Double) = jfxst.Font.loadFont(in, size)

  /**
   * Loads a font resource from the specified URL.
   */
  def loadFont(urlStr: String, size: Double) = jfxst.Font.loadFont(urlStr, size)
}

class Font(val delegate: jfxst.Font) extends SFXDelegate[jfxst.Font] {

  /**
   * Constructs a font using the default face "System".
   */
  def this(size: Double) = this(new jfxst.Font(size))

  /**
   * Constructs a font using the specified full face name and size
   */
  def this(name: String, size: Double) = this(new jfxst.Font(name, size))

  /**
   * Returns the family of this font.
   */
  def family = delegate.getFamily

  /**
   * The full font name.
   */
  def name = delegate.getName

  /**
   * The point size for this font.
   */
  def size = delegate.getSize

  /**
   * The font specified string describing the style within the font family.
   */
  def style = delegate.getStyle
}
