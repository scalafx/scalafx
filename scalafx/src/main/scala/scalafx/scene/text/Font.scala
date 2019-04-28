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
package scalafx.scene.text

import java.io.InputStream

import javafx.scene.{text => jfxst}
import scalafx.delegate.SFXDelegate
import scalafx.scene.text.TextIncludes._

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.language.implicitConversions

object Font {
  implicit def sfxFont2jfx(v: Font): jfxst.Font = if (v != null) v.delegate else null

  /**
    * Gets the default font which will be from the family "System", and typically the style
    * "Regular", and be of a size consistent with the user's desktop environment, to the extent
    * that can be determined.
    */
  def default: Font = jfxst.Font.getDefault

  /**
    * Gets all the font families installed on the user's system, including any
    * application fonts or SDK fonts.
    */
  def families: mutable.Buffer[String] = jfxst.Font.getFamilies.asScala

  /** Searches for an appropriate font based on the default font family name and given font size. */
  def font(size: Double) = new Font(jfxst.Font.font(size))

  def apply(size: Double) = new Font(jfxst.Font.font(size))

  /** Searches for an appropriate font based on the given font family name and default font size. */
  def font(family: String) = new Font(jfxst.Font.font(family))

  def apply(family: String) = new Font(jfxst.Font.font(family))

  /**
    * Searches for an appropriate font based on the font family name and size.
    */
  def font(family: String, size: Double) =
    new Font(jfxst.Font.font(family, size))

  def apply(family: String, size: Double) =
    new Font(jfxst.Font.font(family, size))

  /**
    * Searches for an appropriate font based on the font family name and posture
    * style.
    */
  def font(family: String, posture: jfxst.FontPosture, size: Double) =
    new Font(jfxst.Font.font(family, posture, size))

  def apply(family: String, posture: jfxst.FontPosture, size: Double) =
    new Font(jfxst.Font.font(family, posture, size))

  /**
    * Searches for an appropriate font based on the font family name and weight style.
    */
  def font(family: String, weight: jfxst.FontWeight, size: Double) =
    new Font(jfxst.Font.font(family, weight, size))

  def apply(family: String, weight: jfxst.FontWeight, size: Double) =
    new Font(jfxst.Font.font(family, weight, size))

  /**
    * Searches for an appropriate font based on the font family name and weight and posture style.
    */
  def font(family: String, weight: jfxst.FontWeight, posture: jfxst.FontPosture, size: Double) =
    new Font(jfxst.Font.font(family, weight, posture, size))

  def apply(family: String, weight: jfxst.FontWeight, posture: jfxst.FontPosture, size: Double) =
    new Font(jfxst.Font.font(family, weight, posture, size))

  /**
    * Gets the names of all fonts that are installed on the users system, including any application
    * fonts and SDK fonts.
    */
  def fontNames: mutable.Buffer[String] = jfxst.Font.getFontNames.asScala

  /**
    * Gets the names of all fonts in the specified font family that are installed on the users
    * system, including any application fonts and SDK fonts.
    */
  def fontNames(family: String): mutable.Buffer[String] = jfxst.Font.getFontNames(family).asScala

  /**
    * Loads a font resource from the specified input stream.
    */
  def loadFont(in: java.io.InputStream, size: Double): Font = jfxst.Font.loadFont(in, size)

  /**
    * Loads a font resource from the specified URL.
    */
  def loadFont(urlStr: String, size: Double): Font = jfxst.Font.loadFont(urlStr, size)

  /**
    * Loads font resources from the specified URL. If the load is successful
    * such that the location is readable, and it represents a supported
    * font format then an array of <code>Font</code> will be returned.
    * <p>
    * The use case for this method is for loading all fonts
    * from a TrueType Collection (TTC).
    * <p>
    * If a security manager is present, the application
    * must have both permission to read from the specified URL location
    * and the [[javafx.util.FXPermission]] "loadFont".
    * If the application does not have permission to read from the specified
    * URL location, then null is returned.
    * If the application does not have the "loadFont" permission then this method
    * will return an array of one element which is the default
    * system font with the specified font size.
    * <p>
    * Any failure such as a malformed URL being unable to locate or read
    * from the resource, or if it doesn't represent a font, will result in
    * a <code>null</code> return. It is the application's responsibility
    * to check this before use.
    * <p>
    * On a successful (non-null) return the fonts will be registered
    * with the FX graphics system for creation by available constructors
    * and factory methods, and the application should use it in this
    * manner rather than calling this method again, which would
    * repeat the overhead of downloading and installing the fonts.
    * <p>
    * The font <code>size</code> parameter is a convenience so that in
    * typical usage the application can directly use the returned (non-null)
    * font rather than needing to create one via a constructor.
    * Invalid sizes are those <=0 and will result in a default size.
    * <p>
    * If the URL represents a local disk file, then no copying is performed
    * and the font file is required to persist for the lifetime of the
    * application. Updating the file in any manner will result
    * in unspecified and likely undesired behaviours.
    *
    * @param urlStr from which to load the fonts, specified as a String.
    * @param size   of the returned fonts.
    * @return array of Font, or null if the fonts cannot be created.
    * @since 9
    */
  def loadFonts(urlStr: String, size: Double): Seq[jfxst.Font] = jfxst.Font.loadFonts(urlStr, size).toSeq

  /**
    * Loads font resources from the specified input stream.
    * If the load is successful such that the stream can be
    * fully read, and it represents a supported font format then
    * an array of <code>Font</code> will be returned.
    * <p>
    * The use case for this method is for loading all fonts
    * from a TrueType Collection (TTC).
    * <p>
    * If a security manager is present, the application
    * must have the [[javafx.util.FXPermission]] "loadFont".
    * If the application does not have permission then this method
    * will return the default system font with the specified font size.
    * <p>
    * Any failure such as abbreviated input, or an unsupported font format
    * will result in a <code>null</code> return. It is the application's
    * responsibility to check this before use.
    * <p>
    * On a successful (non-null) return the fonts will be registered
    * with the FX graphics system for creation by available constructors
    * and factory methods, and the application should use it in this
    * manner rather than calling this method again, which would
    * repeat the overhead of re-reading and installing the fonts.
    * <p>
    * The font <code>size</code> parameter is a convenience so that in
    * typical usage the application can directly use the returned (non-null)
    * fonts rather than needing to re-create via a constructor.
    * Invalid sizes are those <=0 and will result in a default size.
    * <p>
    * This method does not close the input stream.
    *
    * @param in   stream from which to load the fonts.
    * @param size of the returned fonts.
    * @return array of Font, or null if the fonts cannot be created.
    * @since 9
    */
  def loadFonts(in: InputStream, size: Double): Seq[jfxst.Font] = jfxst.Font.loadFonts(in, size).toSeq
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
  def family: String = delegate.getFamily

  /**
    * The full font name.
    */
  def name: String = delegate.getName

  /**
    * The point size for this font.
    */
  def size: Double = delegate.getSize

  /**
    * The font specified string describing the style within the font family.
    */
  def style: String = delegate.getStyle
}
