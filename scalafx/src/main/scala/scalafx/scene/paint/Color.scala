/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
package scalafx.scene.paint

import javafx.scene.{paint => jfxsp}

import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate
import scalafx.scene.paint.PaintIncludes._

object Color {
  implicit def sfxColor2jfx(c: Color): jfxsp.Color = if (c != null) c.delegate else null

  def apply(red: Double, green: Double, blue: Double, opacity: Double) = new Color(new jfxsp.Color(red, green, blue, opacity))

  /**
   * Creates an RGB color specified with hexadecimal notation or color name.
   */
  def web(color: String) = new Color(jfxsp.Color.web(color))

  /**
   * Creates an RGB color specified with hexadecimal notation or color name.
   */
  def web(color: String, opacity: Double) = new Color(jfxsp.Color.web(color, opacity))

  /**
   * Creates an opaque sRGB color with the specified RGB values in the range 0-255.
   */
  def rgb(red: Int, green: Int, blue: Int) = new Color(jfxsp.Color.rgb(red, green, blue))

  /**
   * Creates an sRGB color with the specified RGB values in the range 0-255, and a given opacity in the range 0.0-1.0.
   */
  def rgb(red: Int, green: Int, blue: Int, opacity: Double) = new Color(jfxsp.Color.rgb(red, green, blue, opacity))

  /**
   * Creates an opaque Color based on the specified values in the HSB color model.
   */
  def hsb(hue: Double, saturation: Double, brightness: Double) = new Color(jfxsp.Color.hsb(hue, saturation, brightness))

  /**
   * Creates a Color based on the specified values in the HSB color model, and a given opacity.
   */
  def hsb(hue: Double, saturation: Double, brightness: Double, opacity: Double) = new Color(jfxsp.Color.hsb(hue, saturation, brightness, opacity))

  /**
   * Creates an opaque sRGB color with the specified red, green and blue values in the range 0.0-1.0.
   */
  def color(red: Double, green: Double, blue: Double) = new Color(jfxsp.Color.color(red, green, blue))

  /**
   * Creates an sRGB color with the specified red, green and blue values in the range 0.0-1.0, and a given opacity.
   */
  def color(red: Double, green: Double, blue: Double, opacity: Double) = new Color(jfxsp.Color.color(red, green, blue, opacity))

  /**
   * Creates an opaque grey color.
   */
  def gray(gray: Double) = new Color(jfxsp.Color.gray(gray))

  /**
   * Creates a grey color.
   */
  def gray(gray: Double, opacity: Double) = new Color(jfxsp.Color.gray(gray, opacity))

  /**
   * This is a shortcut for rgb(gray, gray, gray).
   */
  def grayRgb(gray: Int) = new Color(jfxsp.Color.gray(gray))

  /**
   * This is a shortcut for rgb(gray, gray, gray, opacity).
   */
  def grayRgb(gray: Int, opacity: Double) = new Color(jfxsp.Color.gray(gray, opacity))

  /**
   * Creates a color value from a string representation.  The format of the string representation is the same as in web(String).
   */
  def valueOf(value: String) = new Color(jfxsp.Color.valueOf(value))

  val AliceBlue = new Color(jfxsp.Color.ALICEBLUE)
  @deprecated("Use AliceBlue; ALICEBLUE will be removed in a future release", "1.0.0-R9")
  val ALICEBLUE = AliceBlue
  val AntiqueWhite = new Color(jfxsp.Color.ANTIQUEWHITE)
  @deprecated("Use AntiqueWhite; ANTIQUEWHITE will be removed in a future release.", "1.0.0-R9")
  val ANTIQUEWHITE = AntiqueWhite
  val Aqua = new Color(jfxsp.Color.AQUA)
  @deprecated("Use Aqua; AQUA will be removed in a future release.", "1.0.0-R9")
  val AQUA = Aqua
  val Aquamarine = new Color(jfxsp.Color.AQUAMARINE)
  @deprecated("Use Aquamarine; AQUAMARINE will be removed in a future release.", "1.0.0-R9")
  val AQUAMARINE = Aquamarine
  val Azure = new Color(jfxsp.Color.AZURE)
  @deprecated("Use Azure; AZURE will be removed in a future release.", "1.0.0-R9")
  val AZURE = Azure
  val Beige = new Color(jfxsp.Color.BEIGE)
  @deprecated("Use Beige; BEIGE will be removed in a future release.", "1.0.0-R9")
  val BEIGE = Beige
  val Bisque = new Color(jfxsp.Color.BISQUE)
  @deprecated("Use Bisque; BISQUE will be removed in a future release.", "1.0.0-R9")
  val BISQUE = Bisque
  val Black = new Color(jfxsp.Color.BLACK)
  @deprecated("Use Black; BLACK will be removed in a future release.", "1.0.0-R9")
  val BLACK = Black
  val BlanchedAlmond = new Color(jfxsp.Color.BLANCHEDALMOND)
  @deprecated("Use BlanchedAlmond; BLANCHEDALMOND will be removed in a future release.", "1.0.0-R9")
  val BLANCHEDALMOND = BlanchedAlmond
  val Blue = new Color(jfxsp.Color.BLUE)
  @deprecated("Use Blue; BLUE will be removed in a future release.", "1.0.0-R9")
  val BLUE = Blue
  val BlueViolet = new Color(jfxsp.Color.BLUEVIOLET)
  @deprecated("Use BlueViolet; BLUEVIOLET will be removed in a future release.", "1.0.0-R9")
  val BLUEVIOLET = BlueViolet
  val Brown = new Color(jfxsp.Color.BROWN)
  @deprecated("Use Brown; BROWN will be removed in a future release.", "1.0.0-R9")
  val BROWN = Brown
  val Burlywood = new Color(jfxsp.Color.BURLYWOOD)
  @deprecated("Use Burlywood; BURLYWOOD will be removed in a future release.", "1.0.0-R9")
  val BURLYWOOD = Burlywood
  val CadetBlue = new Color(jfxsp.Color.CADETBLUE)
  @deprecated("Use CadetBlue; CADETBLUE will be removed in a future release.", "1.0.0-R9")
  val CADETBLUE = CadetBlue
  val Chartreuse = new Color(jfxsp.Color.CHARTREUSE)
  @deprecated("Use Chartreuse; CHARTREUSE will be removed in a future release.", "1.0.0-R9")
  val CHARTREUSE = Chartreuse
  val Chocolate = new Color(jfxsp.Color.CHOCOLATE)
  @deprecated("Use Chocolate; CHOCOLATE will be removed in a future release.", "1.0.0-R9")
  val CHOCOLATE = Chocolate
  val Coral = new Color(jfxsp.Color.CORAL)
  @deprecated("Use Coral; CORAL will be removed in a future release.", "1.0.0-R9")
  val CORAL = Coral
  val CornflowerBlue = new Color(jfxsp.Color.CORNFLOWERBLUE)
  @deprecated("Use CornflowerBlue; CORNFLOWERBLUE will be removed in a future release.", "1.0.0-R9")
  val CORNFLOWERBLUE = CornflowerBlue
  val Cornsilk = new Color(jfxsp.Color.CORNSILK)
  @deprecated("Use Cornsilk; CORNSILK will be removed in a future release.", "1.0.0-R9")
  val CORNSILK = Cornsilk
  val Crimson = new Color(jfxsp.Color.CRIMSON)
  @deprecated("Use Crimson; CRIMSON will be removed in a future release.", "1.0.0-R9")
  val CRIMSON = Crimson
  val Cyan = new Color(jfxsp.Color.CYAN)
  @deprecated("Use Cyan; CYAN will be removed in a future release.", "1.0.0-R9")
  val CYAN = Cyan
  val DarkBlue = new Color(jfxsp.Color.DARKBLUE)
  @deprecated("Use DarkBlue; DARKBLUE will be removed in a future release.", "1.0.0-R9")
  val DARKBLUE = DarkBlue
  val DarkCyan = new Color(jfxsp.Color.DARKCYAN)
  @deprecated("Use DarkCyan; DARKCYAN will be removed in a future release.", "1.0.0-R9")
  val DARKCYAN = DarkCyan
  val DarkGoldenrod = new Color(jfxsp.Color.DARKGOLDENROD)
  @deprecated("Use DarkGoldenrod; DARKGOLDENROD will be removed in a future release.", "1.0.0-R9")
  val DARKGOLDENROD = DarkGoldenrod
  val DarkGray = new Color(jfxsp.Color.DARKGRAY)
  @deprecated("Use DarkGray; DARKGRAY will be removed in a future release.", "1.0.0-R9")
  val DARKGRAY = DarkGray
  val DarkGreen = new Color(jfxsp.Color.DARKGREEN)
  @deprecated("Use DarkGreen; DARKGREEN will be removed in a future release.", "1.0.0-R9")
  val DARKGREEN = DarkGreen
  val DarkGrey = new Color(jfxsp.Color.DARKGREY)
  @deprecated("Use DarkGrey; DARKGREY will be removed in a future release.", "1.0.0-R9")
  val DARKGREY = DarkGrey
  val DarkKhaki = new Color(jfxsp.Color.DARKKHAKI)
  @deprecated("Use DarkKhaki; DARKKHAKI will be removed in a future release.", "1.0.0-R9")
  val DARKKHAKI = DarkKhaki
  val DarkMagenta = new Color(jfxsp.Color.DARKMAGENTA)
  @deprecated("Use DarkMagenta; DARKMAGENTA will be removed in a future release.", "1.0.0-R9")
  val DARKMAGENTA = DarkMagenta
  val DarkOliveGreen = new Color(jfxsp.Color.DARKOLIVEGREEN)
  @deprecated("Use DarkOliveGreen; DARKOLIVEGREEN will be removed in a future release.", "1.0.0-R9")
  val DARKOLIVEGREEN = DarkOliveGreen
  val DarkOrange = new Color(jfxsp.Color.DARKORANGE)
  @deprecated("Use DarkOrange; DARKORANGE will be removed in a future release.", "1.0.0-R9")
  val DARKORANGE = DarkOrange
  val DarkOrchid = new Color(jfxsp.Color.DARKORCHID)
  @deprecated("Use DarkOrchid; DARKORCHID will be removed in a future release.", "1.0.0-R9")
  val DARKORCHID = DarkOrchid
  val DarkRed = new Color(jfxsp.Color.DARKRED)
  @deprecated("Use DarkRed; DARKRED will be removed in a future release.", "1.0.0-R9")
  val DARKRED = DarkRed
  val DarkSalmon = new Color(jfxsp.Color.DARKSALMON)
  @deprecated("Use DarkSalmon; DARKSALMON will be removed in a future release.", "1.0.0-R9")
  val DARKSALMON = DarkSalmon
  val DarkSeaGreen = new Color(jfxsp.Color.DARKSEAGREEN)
  @deprecated("Use DarkSeaGreen; DARKSEAGREEN will be removed in a future release.", "1.0.0-R9")
  val DARKSEAGREEN = DarkSeaGreen
  val DarkSlateBlue = new Color(jfxsp.Color.DARKSLATEBLUE)
  @deprecated("Use DarkSlateBlue; DARKSLATEBLUE will be removed in a future release.", "1.0.0-R9")
  val DARKSLATEBLUE = DarkSlateBlue
  val DarkSlateGray = new Color(jfxsp.Color.DARKSLATEGRAY)
  @deprecated("Use DarkSlateGray; DARKSLATEGRAY will be removed in a future release.", "1.0.0-R9")
  val DARKSLATEGRAY = DarkSlateGray
  val DarkSlateGrey = new Color(jfxsp.Color.DARKSLATEGREY)
  @deprecated("Use DarkSlateGrey; DARKSLATEGREY will be removed in a future release.", "1.0.0-R9")
  val DARKSLATEGREY = DarkSlateGrey
  val DarkTurquoise = new Color(jfxsp.Color.DARKTURQUOISE)
  @deprecated("Use DarkTurquoise; DARKTURQUOISE will be removed in a future release.", "1.0.0-R9")
  val DARKTURQUOISE = DarkTurquoise
  val DarkViolet = new Color(jfxsp.Color.DARKVIOLET)
  @deprecated("Use DarkViolet; DARKVIOLET will be removed in a future release.", "1.0.0-R9")
  val DARKVIOLET = DarkViolet
  val DeepPink = new Color(jfxsp.Color.DEEPPINK)
  @deprecated("Use DeepPink; DEEPPINK will be removed in a future release.", "1.0.0-R9")
  val DEEPPINK = DeepPink
  val DeepSkyBlue = new Color(jfxsp.Color.DEEPSKYBLUE)
  @deprecated("Use DeepSkyBlue; DEEPSKYBLUE will be removed in a future release.", "1.0.0-R9")
  val DEEPSKYBLUE = DeepSkyBlue
  val DimGray = new Color(jfxsp.Color.DIMGRAY)
  @deprecated("Use DimGray; DIMGRAY will be removed in a future release.", "1.0.0-R9")
  val DIMGRAY = DimGray
  val DimGrey = new Color(jfxsp.Color.DIMGREY)
  @deprecated("Use DimGrey; DIMGREY will be removed in a future release.", "1.0.0-R9")
  val DIMGREY = DimGrey
  val DodgerBlue = new Color(jfxsp.Color.DODGERBLUE)
  @deprecated("Use DodgerBlue; DODGERBLUE will be removed in a future release.", "1.0.0-R9")
  val DODGERBLUE = DodgerBlue
  val FireBrick = new Color(jfxsp.Color.FIREBRICK)
  @deprecated("Use FireBrick; FIREBRICK will be removed in a future release.", "1.0.0-R9")
  val FIREBRICK = FireBrick
  val FloralWhite = new Color(jfxsp.Color.FLORALWHITE)
  @deprecated("Use FloralWhite; FLORALWHITE will be removed in a future release.", "1.0.0-R9")
  val FLORALWHITE = FloralWhite
  val ForestGreen = new Color(jfxsp.Color.FORESTGREEN)
  @deprecated("Use ForestGreen; FORESTGREEN will be removed in a future release.", "1.0.0-R9")
  val FORESTGREEN = ForestGreen
  val Fuchsia = new Color(jfxsp.Color.FUCHSIA)
  @deprecated("Use Fuchsia; FUCHSIA will be removed in a future release.", "1.0.0-R9")
  val FUCHSIA = Fuchsia
  val Gainsboro = new Color(jfxsp.Color.GAINSBORO)
  @deprecated("Use Gainsboro; GAINSBORO will be removed in a future release.", "1.0.0-R9")
  val GAINSBORO = Gainsboro
  val GhostWhite = new Color(jfxsp.Color.GHOSTWHITE)
  @deprecated("Use GhostWhite; GHOSTWHITE will be removed in a future release.", "1.0.0-R9")
  val GHOSTWHITE = GhostWhite
  val Gold = new Color(jfxsp.Color.GOLD)
  @deprecated("Use Gold; GOLD will be removed in a future release.", "1.0.0-R9")
  val GOLD = Gold
  val Goldenrod = new Color(jfxsp.Color.GOLDENROD)
  @deprecated("Use Goldenrod; GOLDENROD will be removed in a future release.", "1.0.0-R9")
  val GOLDENROD = Goldenrod
  val Gray = new Color(jfxsp.Color.GRAY)
  @deprecated("Use Gray; GRAY will be removed in a future release.", "1.0.0-R9")
  val GRAY = Gray
  val Green = new Color(jfxsp.Color.GREEN)
  @deprecated("Use Green; GREEN will be removed in a future release.", "1.0.0-R9")
  val GREEN = Green
  val GreenYellow = new Color(jfxsp.Color.GREENYELLOW)
  @deprecated("Use GreenYellow; GREENYELLOW will be removed in a future release.", "1.0.0-R9")
  val GREENYELLOW = GreenYellow
  val Grey = new Color(jfxsp.Color.GREY)
  @deprecated("Use Grey; GREY will be removed in a future release.", "1.0.0-R9")
  val GREY = Grey
  val Honeydew = new Color(jfxsp.Color.HONEYDEW)
  @deprecated("Use Honeydew; HONEYDEW will be removed in a future release.", "1.0.0-R9")
  val HONEYDEW = Honeydew
  val HotPink = new Color(jfxsp.Color.HOTPINK)
  @deprecated("Use HotPink; HOTPINK will be removed in a future release.", "1.0.0-R9")
  val HOTPINK = HotPink
  val IndianRed = new Color(jfxsp.Color.INDIANRED)
  @deprecated("Use IndianRed; INDIANRED will be removed in a future release.", "1.0.0-R9")
  val INDIANRED = IndianRed
  val Indigo = new Color(jfxsp.Color.INDIGO)
  @deprecated("Use Indigo; INDIGO will be removed in a future release.", "1.0.0-R9")
  val INDIGO = Indigo
  val Ivory = new Color(jfxsp.Color.IVORY)
  @deprecated("Use Ivory; IVORY will be removed in a future release.", "1.0.0-R9")
  val IVORY = Ivory
  val Khaki = new Color(jfxsp.Color.KHAKI)
  @deprecated("Use Khaki; KHAKI will be removed in a future release.", "1.0.0-R9")
  val KHAKI = Khaki
  val Lavender = new Color(jfxsp.Color.LAVENDER)
  @deprecated("Use Lavender; LAVENDER will be removed in a future release.", "1.0.0-R9")
  val LAVENDER = Lavender
  val LavenderBlush = new Color(jfxsp.Color.LAVENDERBLUSH)
  @deprecated("Use LavenderBlush; LAVENDERBLUSH will be removed in a future release.", "1.0.0-R9")
  val LAVENDERBLUSH = LavenderBlush
  val LawnGreen = new Color(jfxsp.Color.LAWNGREEN)
  @deprecated("Use LawnGreen; LAWNGREEN will be removed in a future release.", "1.0.0-R9")
  val LAWNGREEN = LawnGreen
  val LemonChiffon = new Color(jfxsp.Color.LEMONCHIFFON)
  @deprecated("Use LemonChiffon; LEMONCHIFFON will be removed in a future release.", "1.0.0-R9")
  val LEMONCHIFFON = LemonChiffon
  val LightBlue = new Color(jfxsp.Color.LIGHTBLUE)
  @deprecated("Use LightBlue; LIGHTBLUE will be removed in a future release.", "1.0.0-R9")
  val LIGHTBLUE = LightBlue
  val LightCoral = new Color(jfxsp.Color.LIGHTCORAL)
  @deprecated("Use LightCoral; LIGHTCORAL will be removed in a future release.", "1.0.0-R9")
  val LIGHTCORAL = LightCoral
  val LightCyan = new Color(jfxsp.Color.LIGHTCYAN)
  @deprecated("Use LightCyan; LIGHTCYAN will be removed in a future release.", "1.0.0-R9")
  val LIGHTCYAN = LightCyan
  val LightGoldrenrodYellow = new Color(jfxsp.Color.LIGHTGOLDENRODYELLOW)
  @deprecated("Use LightGoldrenrodYellow; LIGHTGOLDENRODYELLOW will be removed in a future release.", "1.0.0-R9")
  val LIGHTGOLDENRODYELLOW = LightGoldrenrodYellow
  val LightGray = new Color(jfxsp.Color.LIGHTGRAY)
  @deprecated("Use LightGray; LIGHTGRAY will be removed in a future release.", "1.0.0-R9")
  val LIGHTGRAY = LightGray
  val LightGreen = new Color(jfxsp.Color.LIGHTGREEN)
  @deprecated("Use LightGreen; LIGHTGREEN will be removed in a future release.", "1.0.0-R9")
  val LIGHTGREEN = LightGreen
  val LightGrey = new Color(jfxsp.Color.LIGHTGREY)
  @deprecated("Use LightGrey; LIGHTGREY will be removed in a future release.", "1.0.0-R9")
  val LIGHTGREY = LightGrey
  val LightPink = new Color(jfxsp.Color.LIGHTPINK)
  @deprecated("Use LightPink; LIGHTPINK will be removed in a future release.", "1.0.0-R9")
  val LIGHTPINK = LightPink
  val LightSalmon = new Color(jfxsp.Color.LIGHTSALMON)
  @deprecated("Use LightSalmon; LIGHTSALMON will be removed in a future release.", "1.0.0-R9")
  val LIGHTSALMON = LightSalmon
  val LightSeaGreen = new Color(jfxsp.Color.LIGHTSEAGREEN)
  @deprecated("Use LightSeaGreen; LIGHTSEAGREEN will be removed in a future release.", "1.0.0-R9")
  val LIGHTSEAGREEN = LightSeaGreen
  val LightSkyBlue = new Color(jfxsp.Color.LIGHTSKYBLUE)
  @deprecated("Use LightSkyBlue; LIGHTSKYBLUE will be removed in a future release.", "1.0.0-R9")
  val LIGHTSKYBLUE = LightSkyBlue
  val LightSlateGray = new Color(jfxsp.Color.LIGHTSLATEGRAY)
  @deprecated("Use LightSlateGray; LIGHTSLATEGRAY will be removed in a future release.", "1.0.0-R9")
  val LIGHTSLATEGRAY = LightSlateGray
  val LightSlateGrey = new Color(jfxsp.Color.LIGHTSLATEGREY)
  @deprecated("Use LightSlateGrey; LIGHTSLATEGREY will be removed in a future release.", "1.0.0-R9")
  val LIGHTSLATEGREY = LightSlateGrey
  val LightSteelBlue = new Color(jfxsp.Color.LIGHTSTEELBLUE)
  @deprecated("Use LightSteelBlue; LIGHTSTEELBLUE will be removed in a future release.", "1.0.0-R9")
  val LIGHTSTEELBLUE = LightSteelBlue
  val LightYellow = new Color(jfxsp.Color.LIGHTYELLOW)
  @deprecated("Use LightYellow; LIGHTYELLOW will be removed in a future release.", "1.0.0-R9")
  val LIGHTYELLOW = LightYellow
  val Lime = new Color(jfxsp.Color.LIME)
  @deprecated("Use Lime; LIME will be removed in a future release.", "1.0.0-R9")
  val LIME = Lime
  val LimeGreen = new Color(jfxsp.Color.LIMEGREEN)
  @deprecated("Use LimeGreen; LIMEGREEN will be removed in a future release.", "1.0.0-R9")
  val LIMEGREEN = LimeGreen
  val Linen = new Color(jfxsp.Color.LINEN)
  @deprecated("Use Linen; LINEN will be removed in a future release.", "1.0.0-R9")
  val LINEN = Linen
  val Magenta = new Color(jfxsp.Color.MAGENTA)
  @deprecated("Use Magenta; MAGENTA will be removed in a future release.", "1.0.0-R9")
  val MAGENTA = Magenta
  val Maroon = new Color(jfxsp.Color.MAROON)
  @deprecated("Use Maroon; MAROON will be removed in a future release.", "1.0.0-R9")
  val MAROON = Maroon
  val MediumAquamarine = new Color(jfxsp.Color.MEDIUMAQUAMARINE)
  @deprecated("Use MediumAquamarine; MEDIUMAQUAMARINE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMAQUAMARINE = MediumAquamarine
  val MediumBlue = new Color(jfxsp.Color.MEDIUMBLUE)
  @deprecated("Use MediumBlue; MEDIUMBLUE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMBLUE = MediumBlue
  val MediumOrchid = new Color(jfxsp.Color.MEDIUMORCHID)
  @deprecated("Use MediumOrchid; MEDIUMORCHID will be removed in a future release.", "1.0.0-R9")
  val MEDIUMORCHID = MediumOrchid
  val MediumPurple = new Color(jfxsp.Color.MEDIUMPURPLE)
  @deprecated("Use MediumPurple; MEDIUMPURPLE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMPURPLE = MediumPurple
  val MediumSeaGreen = new Color(jfxsp.Color.MEDIUMSEAGREEN)
  @deprecated("Use MediumSeaGreen; MEDIUMSEAGREEN will be removed in a future release.", "1.0.0-R9")
  val MEDIUMSEAGREEN = MediumSeaGreen
  val MediumSlateBlue = new Color(jfxsp.Color.MEDIUMSLATEBLUE)
  @deprecated("Use MediumSlateBlue; MEDIUMSLATEBLUE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMSLATEBLUE = MediumSlateBlue
  val MediumSpringGreen = new Color(jfxsp.Color.MEDIUMSPRINGGREEN)
  @deprecated("Use MediumSpringGreen; MEDIUMSPRINGGREEN will be removed in a future release.", "1.0.0-R9")
  val MEDIUMSPRINGGREEN = MediumSpringGreen
  val MediumTurquoise = new Color(jfxsp.Color.MEDIUMTURQUOISE)
  @deprecated("Use MediumTurquoise; MEDIUMTURQUOISE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMTURQUOISE = MediumTurquoise
  val MediumVioletRed = new Color(jfxsp.Color.MEDIUMVIOLETRED)
  @deprecated("Use MediumVioletRed; MEDIUMVIOLETRED will be removed in a future release.", "1.0.0-R9")
  val MEDIUMVIOLETRED = MediumVioletRed
  val MidnightBlue = new Color(jfxsp.Color.MIDNIGHTBLUE)
  @deprecated("Use MidnightBlue; MIDNIGHTBLUE will be removed in a future release.", "1.0.0-R9")
  val MIDNIGHTBLUE = MidnightBlue
  val MintCream = new Color(jfxsp.Color.MINTCREAM)
  @deprecated("Use MintCream; MINTCREAM will be removed in a future release.", "1.0.0-R9")
  val MINTCREAM = MintCream
  val MistyRose = new Color(jfxsp.Color.MISTYROSE)
  @deprecated("Use MistyRose; MISTYROSE will be removed in a future release.", "1.0.0-R9")
  val MISTYROSE = MistyRose
  val Moccasin = new Color(jfxsp.Color.MOCCASIN)
  @deprecated("Use Moccasin; MOCCASIN will be removed in a future release.", "1.0.0-R9")
  val MOCCASIN = Moccasin
  val NavajoWhite = new Color(jfxsp.Color.NAVAJOWHITE)
  @deprecated("Use NavajoWhite; NAVAJOWHITE will be removed in a future release.", "1.0.0-R9")
  val NAVAJOWHITE = NavajoWhite
  val Navy = new Color(jfxsp.Color.NAVY)
  @deprecated("Use Navy; NAVY will be removed in a future release.", "1.0.0-R9")
  val NAVY = Navy
  val OldLace = new Color(jfxsp.Color.OLDLACE)
  @deprecated("Use OldLace; OLDLACE will be removed in a future release.", "1.0.0-R9")
  val OLDLACE = OldLace
  val Olive = new Color(jfxsp.Color.OLIVE)
  @deprecated("Use Olive; OLIVE will be removed in a future release.", "1.0.0-R9")
  val OLIVE = Olive
  val OliveDrab = new Color(jfxsp.Color.OLIVEDRAB)
  @deprecated("Use OliveDrab; OLIVEDRAB will be removed in a future release.", "1.0.0-R9")
  val OLIVEDRAB = OliveDrab
  val Orange = new Color(jfxsp.Color.ORANGE)
  @deprecated("Use Orange; ORANGE will be removed in a future release.", "1.0.0-R9")
  val ORANGE = Orange
  val OrangeRed = new Color(jfxsp.Color.ORANGERED)
  @deprecated("Use OrangeRed; ORANGERED will be removed in a future release.", "1.0.0-R9")
  val ORANGERED = OrangeRed
  val Orchid = new Color(jfxsp.Color.ORCHID)
  @deprecated("Use Orchid; ORCHID will be removed in a future release.", "1.0.0-R9")
  val ORCHID = Orchid
  val PaleGoldrenrod = new Color(jfxsp.Color.PALEGOLDENROD)
  @deprecated("Use PaleGoldrenrod; PALEGOLDENROD will be removed in a future release.", "1.0.0-R9")
  val PALEGOLDENROD = PaleGoldrenrod
  val PaleGreen = new Color(jfxsp.Color.PALEGREEN)
  @deprecated("Use PaleGreen; PALEGREEN will be removed in a future release.", "1.0.0-R9")
  val PALEGREEN = PaleGreen
  val PaleTurquoise = new Color(jfxsp.Color.PALETURQUOISE)
  @deprecated("Use PaleTurquoise; PALETURQUOISE will be removed in a future release.", "1.0.0-R9")
  val PALETURQUOISE = PaleTurquoise
  val PaleVioletRed = new Color(jfxsp.Color.PALEVIOLETRED)
  @deprecated("Use PaleVioletRed; PALEVIOLETRED will be removed in a future release.", "1.0.0-R9")
  val PALEVIOLETRED = PaleVioletRed
  val PapayaWhip = new Color(jfxsp.Color.PAPAYAWHIP)
  @deprecated("Use PapayaWhip; PAPAYAWHIP will be removed in a future release.", "1.0.0-R9")
  val PAPAYAWHIP = PapayaWhip
  val PeachPuff = new Color(jfxsp.Color.PEACHPUFF)
  @deprecated("Use PeachPuff; PEACHPUFF will be removed in a future release.", "1.0.0-R9")
  val PEACHPUFF = PeachPuff
  val Peru = new Color(jfxsp.Color.PERU)
  @deprecated("Use Peru; PERU will be removed in a future release.", "1.0.0-R9")
  val PERU = Peru
  val Pink = new Color(jfxsp.Color.PINK)
  @deprecated("Use Pink; PINK will be removed in a future release.", "1.0.0-R9")
  val PINK = Pink
  val Plum = new Color(jfxsp.Color.PLUM)
  @deprecated("Use Plum; PLUM will be removed in a future release.", "1.0.0-R9")
  val PLUM = Plum
  val PowderBlue = new Color(jfxsp.Color.POWDERBLUE)
  @deprecated("Use PowderBlue; POWDERBLUE will be removed in a future release.", "1.0.0-R9")
  val POWDERBLUE = PowderBlue
  val Purple = new Color(jfxsp.Color.PURPLE)
  @deprecated("Use Purple; PURPLE will be removed in a future release.", "1.0.0-R9")
  val PURPLE = Purple
  val Red = new Color(jfxsp.Color.RED)
  @deprecated("Use Red; RED will be removed in a future release.", "1.0.0-R9")
  val RED = Red
  val RosyBrown = new Color(jfxsp.Color.ROSYBROWN)
  @deprecated("Use RosyBrown; ROSYBROWN will be removed in a future release.", "1.0.0-R9")
  val ROSYBROWN = RosyBrown
  val RoyalBlue = new Color(jfxsp.Color.ROYALBLUE)
  @deprecated("Use RoyalBlue; ROYALBLUE will be removed in a future release.", "1.0.0-R9")
  val ROYALBLUE = RoyalBlue
  val SaddleBrown = new Color(jfxsp.Color.SADDLEBROWN)
  @deprecated("Use SaddleBrown; SADDLEBROWN will be removed in a future release.", "1.0.0-R9")
  val SADDLEBROWN = SaddleBrown
  val Salmon = new Color(jfxsp.Color.SALMON)
  @deprecated("Use Salmon; SALMON will be removed in a future release.", "1.0.0-R9")
  val SALMON = Salmon
  val SandyBrown = new Color(jfxsp.Color.SANDYBROWN)
  @deprecated("Use SandyBrown; SANDYBROWN will be removed in a future release.", "1.0.0-R9")
  val SANDYBROWN = SandyBrown
  val SeaGreen = new Color(jfxsp.Color.SEAGREEN)
  @deprecated("Use SeaGreen; SEAGREEN will be removed in a future release.", "1.0.0-R9")
  val SEAGREEN = SeaGreen
  val SeaShell = new Color(jfxsp.Color.SEASHELL)
  @deprecated("Use SeaShell; SEASHELL will be removed in a future release.", "1.0.0-R9")
  val SEASHELL = SeaShell
  val Sienna = new Color(jfxsp.Color.SIENNA)
  @deprecated("Use Sienna; SIENNA will be removed in a future release.", "1.0.0-R9")
  val SIENNA = Sienna
  val Silver = new Color(jfxsp.Color.SILVER)
  @deprecated("Use Silver; SILVER will be removed in a future release.", "1.0.0-R9")
  val SILVER = Silver
  val SkyBlue = new Color(jfxsp.Color.SKYBLUE)
  @deprecated("Use SkyBlue; SKYBLUE will be removed in a future release.", "1.0.0-R9")
  val SKYBLUE = SkyBlue
  val SlateBlue = new Color(jfxsp.Color.SLATEBLUE)
  @deprecated("Use SlateBlue; SLATEBLUE will be removed in a future release.", "1.0.0-R9")
  val SLATEBLUE = SlateBlue
  val SlateGray = new Color(jfxsp.Color.SLATEGRAY)
  @deprecated("Use SlateGray; SLATEGRAY will be removed in a future release.", "1.0.0-R9")
  val SLATEGRAY = SlateGray
  val SlateGrey = new Color(jfxsp.Color.SLATEGREY)
  @deprecated("Use SlateGrey; SLATEGREY will be removed in a future release.", "1.0.0-R9")
  val SLATEGREY = SlateGrey
  val Snow = new Color(jfxsp.Color.SNOW)
  @deprecated("Use Snow; SNOW will be removed in a future release.", "1.0.0-R9")
  val SNOW = Snow
  val SpringGreen = new Color(jfxsp.Color.SPRINGGREEN)
  @deprecated("Use SpringGreen; SPRINGGREEN will be removed in a future release.", "1.0.0-R9")
  val SPRINGGREEN = SpringGreen
  val SteelBlue = new Color(jfxsp.Color.STEELBLUE)
  @deprecated("Use SteelBlue; STEELBLUE will be removed in a future release.", "1.0.0-R9")
  val STEELBLUE = SteelBlue
  val Tan = new Color(jfxsp.Color.TAN)
  @deprecated("Use Tan; TAN will be removed in a future release.", "1.0.0-R9")
  val TAN = Tan
  val Teal = new Color(jfxsp.Color.TEAL)
  @deprecated("Use Teal; TEAL will be removed in a future release.", "1.0.0-R9")
  val TEAL = Teal
  val Thistle = new Color(jfxsp.Color.THISTLE)
  @deprecated("Use Thistle; THISTLE will be removed in a future release.", "1.0.0-R9")
  val THISTLE = Thistle
  val Tomato = new Color(jfxsp.Color.TOMATO)
  @deprecated("Use Tomato; TOMATO will be removed in a future release.", "1.0.0-R9")
  val TOMATO = Tomato
  val Transparent = new Color(jfxsp.Color.TRANSPARENT)
  @deprecated("Use Transparent; TRANSPARENT will be removed in a future release.", "1.0.0-R9")
  val TRANSPARENT = Transparent
  val Turquoise = new Color(jfxsp.Color.TURQUOISE)
  @deprecated("Use Turquoise; TURQUOISE will be removed in a future release.", "1.0.0-R9")
  val TURQUOISE = Turquoise
  val Violet = new Color(jfxsp.Color.VIOLET)
  @deprecated("Use Violet; VIOLET will be removed in a future release.", "1.0.0-R9")
  val VIOLET = Violet
  val Wheat = new Color(jfxsp.Color.WHEAT)
  @deprecated("Use Wheat; WHEAT will be removed in a future release.", "1.0.0-R9")
  val WHEAT = Wheat
  val White = new Color(jfxsp.Color.WHITE)
  @deprecated("Use White; WHITE will be removed in a future release.", "1.0.0-R9")
  val WHITE = White
  val WhiteSmoke = new Color(jfxsp.Color.WHITESMOKE)
  @deprecated("Use WhiteSmoke; WHITESMOKE will be removed in a future release.", "1.0.0-R9")
  val WHITESMOKE = WhiteSmoke
  val Yellow = new Color(jfxsp.Color.YELLOW)
  @deprecated("Use Yellow; YELLOW will be removed in a future release.", "1.0.0-R9")
  val YELLOW = Yellow
  val YellowGreen = new Color(jfxsp.Color.YELLOWGREEN)
  @deprecated("Use YellowGreen; YELLOWGREEN will be removed in a future release.", "1.0.0-R9")
  val YELLOWGREEN = YellowGreen
}

class Color(override val delegate: jfxsp.Color) extends Paint(delegate) with SFXDelegate[jfxsp.Color] {

  /**
   * The red component of the Color, in the range 0.0-1.0.
   */
  def red = delegate.getRed

  /**
   * The green component of the Color, in the range 0.0-1.0.
   */
  def green = delegate.getGreen

  /**
   * The blue component of the Color, in the range 0.0-1.0.
   */
  def blue = delegate.getBlue

  /**
   * The opacity of the Color, in the range 0.0-1.0.
   */
  def opacity = delegate.getOpacity

  /**
   * Gets the hue component of this Color.
   */
  def hue = delegate.getHue

  /**
   * Gets the saturation component of this Color.
   */
  def saturation = delegate.getSaturation

  /**
   * Gets the brightness component of this Color.
   */
  def brightness = delegate.getBrightness

  /*
   * Does someone uses this method?
   */
  def opacity(o: Double) = jfxsp.Color.color(red, green, blue, o)

  /**
   * Creates a new Color that is a brighter version of this Color.
   */
  def brighter: Color = delegate.brighter


  /**
   * Creates a new Color that is a darker version of this Color.
   */
  def darker: Color = delegate.darker

  /**
   * Creates a new Color based on this Color with hue, saturation, brightness and opacity values altered.
   */
  def deriveColor(hueShift: Double, saturationFactor: Double, brightnessFactor: Double, opacityFactor: Double): Color = delegate.deriveColor(hueShift, saturationFactor, brightnessFactor, opacityFactor)

  /**
   * Creates a new Color that is a less saturated version of this Color.
   */
  def desaturate: Color = delegate.desaturate

  /**
   * Creates a new Color that is grayscale equivalent of this Color.
   */
  def grayscale: Color = delegate.grayscale

  /**
   * The function calculates an interpolated value along the fraction t between 0.0 and 1.0.
   */
  def interpolate(endValue: Color, t: Double): Color = delegate.interpolate(endValue, t)

  /**
   * Creates a new Color that is inversion of this Color.
   */
  def invert: Color = delegate.invert

  /**
   * Creates a new Color that is a more saturated version of this Color.
   */
  def saturate: Color = delegate.saturate

}