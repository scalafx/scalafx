/*
 * Copyright (c) 2011-2020, ScalaFX Project
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
import scalafx.delegate.SFXDelegate
import scalafx.scene.paint.PaintIncludes._

import scala.language.implicitConversions

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

  val AliceBlue: Color = new Color(jfxsp.Color.ALICEBLUE)
  @deprecated("Use AliceBlue; ALICEBLUE will be removed in a future release", "1.0.0-R9")
  val ALICEBLUE: Color = AliceBlue
  val AntiqueWhite: Color = new Color(jfxsp.Color.ANTIQUEWHITE)
  @deprecated("Use AntiqueWhite; ANTIQUEWHITE will be removed in a future release.", "1.0.0-R9")
  val ANTIQUEWHITE: Color = AntiqueWhite
  val Aqua: Color = new Color(jfxsp.Color.AQUA)
  @deprecated("Use Aqua; AQUA will be removed in a future release.", "1.0.0-R9")
  val AQUA: Color = Aqua
  val Aquamarine: Color = new Color(jfxsp.Color.AQUAMARINE)
  @deprecated("Use Aquamarine; AQUAMARINE will be removed in a future release.", "1.0.0-R9")
  val AQUAMARINE: Color = Aquamarine
  val Azure: Color = new Color(jfxsp.Color.AZURE)
  @deprecated("Use Azure; AZURE will be removed in a future release.", "1.0.0-R9")
  val AZURE: Color = Azure
  val Beige: Color = new Color(jfxsp.Color.BEIGE)
  @deprecated("Use Beige; BEIGE will be removed in a future release.", "1.0.0-R9")
  val BEIGE: Color = Beige
  val Bisque: Color = new Color(jfxsp.Color.BISQUE)
  @deprecated("Use Bisque; BISQUE will be removed in a future release.", "1.0.0-R9")
  val BISQUE: Color = Bisque
  val Black: Color = new Color(jfxsp.Color.BLACK)
  @deprecated("Use Black; BLACK will be removed in a future release.", "1.0.0-R9")
  val BLACK: Color = Black
  val BlanchedAlmond: Color = new Color(jfxsp.Color.BLANCHEDALMOND)
  @deprecated("Use BlanchedAlmond; BLANCHEDALMOND will be removed in a future release.", "1.0.0-R9")
  val BLANCHEDALMOND: Color = BlanchedAlmond
  val Blue: Color = new Color(jfxsp.Color.BLUE)
  @deprecated("Use Blue; BLUE will be removed in a future release.", "1.0.0-R9")
  val BLUE: Color = Blue
  val BlueViolet: Color = new Color(jfxsp.Color.BLUEVIOLET)
  @deprecated("Use BlueViolet; BLUEVIOLET will be removed in a future release.", "1.0.0-R9")
  val BLUEVIOLET: Color = BlueViolet
  val Brown: Color = new Color(jfxsp.Color.BROWN)
  @deprecated("Use Brown; BROWN will be removed in a future release.", "1.0.0-R9")
  val BROWN: Color = Brown
  val Burlywood: Color = new Color(jfxsp.Color.BURLYWOOD)
  @deprecated("Use Burlywood; BURLYWOOD will be removed in a future release.", "1.0.0-R9")
  val BURLYWOOD: Color = Burlywood
  val CadetBlue: Color = new Color(jfxsp.Color.CADETBLUE)
  @deprecated("Use CadetBlue; CADETBLUE will be removed in a future release.", "1.0.0-R9")
  val CADETBLUE: Color = CadetBlue
  val Chartreuse: Color = new Color(jfxsp.Color.CHARTREUSE)
  @deprecated("Use Chartreuse; CHARTREUSE will be removed in a future release.", "1.0.0-R9")
  val CHARTREUSE: Color = Chartreuse
  val Chocolate: Color = new Color(jfxsp.Color.CHOCOLATE)
  @deprecated("Use Chocolate; CHOCOLATE will be removed in a future release.", "1.0.0-R9")
  val CHOCOLATE: Color = Chocolate
  val Coral: Color = new Color(jfxsp.Color.CORAL)
  @deprecated("Use Coral; CORAL will be removed in a future release.", "1.0.0-R9")
  val CORAL: Color = Coral
  val CornflowerBlue = new Color(jfxsp.Color.CORNFLOWERBLUE)
  @deprecated("Use CornflowerBlue; CORNFLOWERBLUE will be removed in a future release.", "1.0.0-R9")
  val CORNFLOWERBLUE: Color = CornflowerBlue
  val Cornsilk: Color = new Color(jfxsp.Color.CORNSILK)
  @deprecated("Use Cornsilk; CORNSILK will be removed in a future release.", "1.0.0-R9")
  val CORNSILK: Color = Cornsilk
  val Crimson: Color = new Color(jfxsp.Color.CRIMSON)
  @deprecated("Use Crimson; CRIMSON will be removed in a future release.", "1.0.0-R9")
  val CRIMSON: Color = Crimson
  val Cyan: Color = new Color(jfxsp.Color.CYAN)
  @deprecated("Use Cyan; CYAN will be removed in a future release.", "1.0.0-R9")
  val CYAN: Color = Cyan
  val DarkBlue: Color = new Color(jfxsp.Color.DARKBLUE)
  @deprecated("Use DarkBlue; DARKBLUE will be removed in a future release.", "1.0.0-R9")
  val DARKBLUE: Color = DarkBlue
  val DarkCyan: Color = new Color(jfxsp.Color.DARKCYAN)
  @deprecated("Use DarkCyan; DARKCYAN will be removed in a future release.", "1.0.0-R9")
  val DARKCYAN: Color = DarkCyan
  val DarkGoldenrod: Color = new Color(jfxsp.Color.DARKGOLDENROD)
  @deprecated("Use DarkGoldenrod; DARKGOLDENROD will be removed in a future release.", "1.0.0-R9")
  val DARKGOLDENROD: Color = DarkGoldenrod
  val DarkGray: Color = new Color(jfxsp.Color.DARKGRAY)
  @deprecated("Use DarkGray; DARKGRAY will be removed in a future release.", "1.0.0-R9")
  val DARKGRAY: Color = DarkGray
  val DarkGreen: Color = new Color(jfxsp.Color.DARKGREEN)
  @deprecated("Use DarkGreen; DARKGREEN will be removed in a future release.", "1.0.0-R9")
  val DARKGREEN: Color = DarkGreen
  val DarkGrey: Color = new Color(jfxsp.Color.DARKGREY)
  @deprecated("Use DarkGrey; DARKGREY will be removed in a future release.", "1.0.0-R9")
  val DARKGREY: Color = DarkGrey
  val DarkKhaki: Color = new Color(jfxsp.Color.DARKKHAKI)
  @deprecated("Use DarkKhaki; DARKKHAKI will be removed in a future release.", "1.0.0-R9")
  val DARKKHAKI: Color = DarkKhaki
  val DarkMagenta: Color = new Color(jfxsp.Color.DARKMAGENTA)
  @deprecated("Use DarkMagenta; DARKMAGENTA will be removed in a future release.", "1.0.0-R9")
  val DARKMAGENTA: Color = DarkMagenta
  val DarkOliveGreen: Color = new Color(jfxsp.Color.DARKOLIVEGREEN)
  @deprecated("Use DarkOliveGreen; DARKOLIVEGREEN will be removed in a future release.", "1.0.0-R9")
  val DARKOLIVEGREEN: Color = DarkOliveGreen
  val DarkOrange: Color = new Color(jfxsp.Color.DARKORANGE)
  @deprecated("Use DarkOrange; DARKORANGE will be removed in a future release.", "1.0.0-R9")
  val DARKORANGE: Color = DarkOrange
  val DarkOrchid: Color = new Color(jfxsp.Color.DARKORCHID)
  @deprecated("Use DarkOrchid; DARKORCHID will be removed in a future release.", "1.0.0-R9")
  val DARKORCHID: Color = DarkOrchid
  val DarkRed: Color = new Color(jfxsp.Color.DARKRED)
  @deprecated("Use DarkRed; DARKRED will be removed in a future release.", "1.0.0-R9")
  val DARKRED: Color = DarkRed
  val DarkSalmon: Color = new Color(jfxsp.Color.DARKSALMON)
  @deprecated("Use DarkSalmon; DARKSALMON will be removed in a future release.", "1.0.0-R9")
  val DARKSALMON: Color = DarkSalmon
  val DarkSeaGreen: Color = new Color(jfxsp.Color.DARKSEAGREEN)
  @deprecated("Use DarkSeaGreen; DARKSEAGREEN will be removed in a future release.", "1.0.0-R9")
  val DARKSEAGREEN: Color = DarkSeaGreen
  val DarkSlateBlue: Color = new Color(jfxsp.Color.DARKSLATEBLUE)
  @deprecated("Use DarkSlateBlue; DARKSLATEBLUE will be removed in a future release.", "1.0.0-R9")
  val DARKSLATEBLUE: Color = DarkSlateBlue
  val DarkSlateGray: Color = new Color(jfxsp.Color.DARKSLATEGRAY)
  @deprecated("Use DarkSlateGray; DARKSLATEGRAY will be removed in a future release.", "1.0.0-R9")
  val DARKSLATEGRAY: Color = DarkSlateGray
  val DarkSlateGrey: Color = new Color(jfxsp.Color.DARKSLATEGREY)
  @deprecated("Use DarkSlateGrey; DARKSLATEGREY will be removed in a future release.", "1.0.0-R9")
  val DARKSLATEGREY: Color = DarkSlateGrey
  val DarkTurquoise: Color = new Color(jfxsp.Color.DARKTURQUOISE)
  @deprecated("Use DarkTurquoise; DARKTURQUOISE will be removed in a future release.", "1.0.0-R9")
  val DARKTURQUOISE: Color = DarkTurquoise
  val DarkViolet: Color = new Color(jfxsp.Color.DARKVIOLET)
  @deprecated("Use DarkViolet; DARKVIOLET will be removed in a future release.", "1.0.0-R9")
  val DARKVIOLET: Color = DarkViolet
  val DeepPink: Color = new Color(jfxsp.Color.DEEPPINK)
  @deprecated("Use DeepPink; DEEPPINK will be removed in a future release.", "1.0.0-R9")
  val DEEPPINK: Color = DeepPink
  val DeepSkyBlue: Color = new Color(jfxsp.Color.DEEPSKYBLUE)
  @deprecated("Use DeepSkyBlue; DEEPSKYBLUE will be removed in a future release.", "1.0.0-R9")
  val DEEPSKYBLUE: Color = DeepSkyBlue
  val DimGray: Color = new Color(jfxsp.Color.DIMGRAY)
  @deprecated("Use DimGray; DIMGRAY will be removed in a future release.", "1.0.0-R9")
  val DIMGRAY: Color = DimGray
  val DimGrey: Color = new Color(jfxsp.Color.DIMGREY)
  @deprecated("Use DimGrey; DIMGREY will be removed in a future release.", "1.0.0-R9")
  val DIMGREY: Color = DimGrey
  val DodgerBlue: Color = new Color(jfxsp.Color.DODGERBLUE)
  @deprecated("Use DodgerBlue; DODGERBLUE will be removed in a future release.", "1.0.0-R9")
  val DODGERBLUE: Color = DodgerBlue
  val FireBrick: Color = new Color(jfxsp.Color.FIREBRICK)
  @deprecated("Use FireBrick; FIREBRICK will be removed in a future release.", "1.0.0-R9")
  val FIREBRICK: Color = FireBrick
  val FloralWhite: Color = new Color(jfxsp.Color.FLORALWHITE)
  @deprecated("Use FloralWhite; FLORALWHITE will be removed in a future release.", "1.0.0-R9")
  val FLORALWHITE: Color = FloralWhite
  val ForestGreen: Color = new Color(jfxsp.Color.FORESTGREEN)
  @deprecated("Use ForestGreen; FORESTGREEN will be removed in a future release.", "1.0.0-R9")
  val FORESTGREEN: Color = ForestGreen
  val Fuchsia: Color = new Color(jfxsp.Color.FUCHSIA)
  @deprecated("Use Fuchsia; FUCHSIA will be removed in a future release.", "1.0.0-R9")
  val FUCHSIA: Color = Fuchsia
  val Gainsboro: Color = new Color(jfxsp.Color.GAINSBORO)
  @deprecated("Use Gainsboro; GAINSBORO will be removed in a future release.", "1.0.0-R9")
  val GAINSBORO: Color = Gainsboro
  val GhostWhite: Color = new Color(jfxsp.Color.GHOSTWHITE)
  @deprecated("Use GhostWhite; GHOSTWHITE will be removed in a future release.", "1.0.0-R9")
  val GHOSTWHITE: Color = GhostWhite
  val Gold: Color = new Color(jfxsp.Color.GOLD)
  @deprecated("Use Gold; GOLD will be removed in a future release.", "1.0.0-R9")
  val GOLD: Color = Gold
  val Goldenrod: Color = new Color(jfxsp.Color.GOLDENROD)
  @deprecated("Use Goldenrod; GOLDENROD will be removed in a future release.", "1.0.0-R9")
  val GOLDENROD: Color = Goldenrod
  val Gray: Color = new Color(jfxsp.Color.GRAY)
  @deprecated("Use Gray; GRAY will be removed in a future release.", "1.0.0-R9")
  val GRAY: Color = Gray
  val Green: Color = new Color(jfxsp.Color.GREEN)
  @deprecated("Use Green; GREEN will be removed in a future release.", "1.0.0-R9")
  val GREEN: Color = Green
  val GreenYellow: Color = new Color(jfxsp.Color.GREENYELLOW)
  @deprecated("Use GreenYellow; GREENYELLOW will be removed in a future release.", "1.0.0-R9")
  val GREENYELLOW: Color = GreenYellow
  val Grey: Color = new Color(jfxsp.Color.GREY)
  @deprecated("Use Grey; GREY will be removed in a future release.", "1.0.0-R9")
  val GREY: Color = Grey
  val Honeydew: Color = new Color(jfxsp.Color.HONEYDEW)
  @deprecated("Use Honeydew; HONEYDEW will be removed in a future release.", "1.0.0-R9")
  val HONEYDEW: Color = Honeydew
  val HotPink: Color = new Color(jfxsp.Color.HOTPINK)
  @deprecated("Use HotPink; HOTPINK will be removed in a future release.", "1.0.0-R9")
  val HOTPINK: Color = HotPink
  val IndianRed: Color = new Color(jfxsp.Color.INDIANRED)
  @deprecated("Use IndianRed; INDIANRED will be removed in a future release.", "1.0.0-R9")
  val INDIANRED: Color = IndianRed
  val Indigo: Color = new Color(jfxsp.Color.INDIGO)
  @deprecated("Use Indigo; INDIGO will be removed in a future release.", "1.0.0-R9")
  val INDIGO: Color = Indigo
  val Ivory: Color = new Color(jfxsp.Color.IVORY)
  @deprecated("Use Ivory; IVORY will be removed in a future release.", "1.0.0-R9")
  val IVORY: Color = Ivory
  val Khaki: Color = new Color(jfxsp.Color.KHAKI)
  @deprecated("Use Khaki; KHAKI will be removed in a future release.", "1.0.0-R9")
  val KHAKI: Color = Khaki
  val Lavender: Color = new Color(jfxsp.Color.LAVENDER)
  @deprecated("Use Lavender; LAVENDER will be removed in a future release.", "1.0.0-R9")
  val LAVENDER: Color = Lavender
  val LavenderBlush: Color = new Color(jfxsp.Color.LAVENDERBLUSH)
  @deprecated("Use LavenderBlush; LAVENDERBLUSH will be removed in a future release.", "1.0.0-R9")
  val LAVENDERBLUSH: Color = LavenderBlush
  val LawnGreen: Color = new Color(jfxsp.Color.LAWNGREEN)
  @deprecated("Use LawnGreen; LAWNGREEN will be removed in a future release.", "1.0.0-R9")
  val LAWNGREEN: Color = LawnGreen
  val LemonChiffon: Color = new Color(jfxsp.Color.LEMONCHIFFON)
  @deprecated("Use LemonChiffon; LEMONCHIFFON will be removed in a future release.", "1.0.0-R9")
  val LEMONCHIFFON: Color = LemonChiffon
  val LightBlue: Color = new Color(jfxsp.Color.LIGHTBLUE)
  @deprecated("Use LightBlue; LIGHTBLUE will be removed in a future release.", "1.0.0-R9")
  val LIGHTBLUE: Color = LightBlue
  val LightCoral: Color = new Color(jfxsp.Color.LIGHTCORAL)
  @deprecated("Use LightCoral; LIGHTCORAL will be removed in a future release.", "1.0.0-R9")
  val LIGHTCORAL: Color = LightCoral
  val LightCyan: Color = new Color(jfxsp.Color.LIGHTCYAN)
  @deprecated("Use LightCyan; LIGHTCYAN will be removed in a future release.", "1.0.0-R9")
  val LIGHTCYAN: Color = LightCyan
  val LightGoldrenrodYellow: Color = new Color(jfxsp.Color.LIGHTGOLDENRODYELLOW)
  @deprecated("Use LightGoldrenrodYellow; LIGHTGOLDENRODYELLOW will be removed in a future release.", "1.0.0-R9")
  val LIGHTGOLDENRODYELLOW: Color = LightGoldrenrodYellow
  val LightGray: Color = new Color(jfxsp.Color.LIGHTGRAY)
  @deprecated("Use LightGray; LIGHTGRAY will be removed in a future release.", "1.0.0-R9")
  val LIGHTGRAY: Color = LightGray
  val LightGreen: Color = new Color(jfxsp.Color.LIGHTGREEN)
  @deprecated("Use LightGreen; LIGHTGREEN will be removed in a future release.", "1.0.0-R9")
  val LIGHTGREEN: Color = LightGreen
  val LightGrey: Color = new Color(jfxsp.Color.LIGHTGREY)
  @deprecated("Use LightGrey; LIGHTGREY will be removed in a future release.", "1.0.0-R9")
  val LIGHTGREY: Color = LightGrey
  val LightPink: Color = new Color(jfxsp.Color.LIGHTPINK)
  @deprecated("Use LightPink; LIGHTPINK will be removed in a future release.", "1.0.0-R9")
  val LIGHTPINK: Color = LightPink
  val LightSalmon: Color = new Color(jfxsp.Color.LIGHTSALMON)
  @deprecated("Use LightSalmon; LIGHTSALMON will be removed in a future release.", "1.0.0-R9")
  val LIGHTSALMON: Color = LightSalmon
  val LightSeaGreen: Color = new Color(jfxsp.Color.LIGHTSEAGREEN)
  @deprecated("Use LightSeaGreen; LIGHTSEAGREEN will be removed in a future release.", "1.0.0-R9")
  val LIGHTSEAGREEN: Color = LightSeaGreen
  val LightSkyBlue: Color = new Color(jfxsp.Color.LIGHTSKYBLUE)
  @deprecated("Use LightSkyBlue; LIGHTSKYBLUE will be removed in a future release.", "1.0.0-R9")
  val LIGHTSKYBLUE: Color = LightSkyBlue
  val LightSlateGray: Color = new Color(jfxsp.Color.LIGHTSLATEGRAY)
  @deprecated("Use LightSlateGray; LIGHTSLATEGRAY will be removed in a future release.", "1.0.0-R9")
  val LIGHTSLATEGRAY: Color = LightSlateGray
  val LightSlateGrey: Color = new Color(jfxsp.Color.LIGHTSLATEGREY)
  @deprecated("Use LightSlateGrey; LIGHTSLATEGREY will be removed in a future release.", "1.0.0-R9")
  val LIGHTSLATEGREY: Color = LightSlateGrey
  val LightSteelBlue: Color = new Color(jfxsp.Color.LIGHTSTEELBLUE)
  @deprecated("Use LightSteelBlue; LIGHTSTEELBLUE will be removed in a future release.", "1.0.0-R9")
  val LIGHTSTEELBLUE: Color = LightSteelBlue
  val LightYellow: Color = new Color(jfxsp.Color.LIGHTYELLOW)
  @deprecated("Use LightYellow; LIGHTYELLOW will be removed in a future release.", "1.0.0-R9")
  val LIGHTYELLOW: Color = LightYellow
  val Lime: Color = new Color(jfxsp.Color.LIME)
  @deprecated("Use Lime; LIME will be removed in a future release.", "1.0.0-R9")
  val LIME: Color = Lime
  val LimeGreen: Color = new Color(jfxsp.Color.LIMEGREEN)
  @deprecated("Use LimeGreen; LIMEGREEN will be removed in a future release.", "1.0.0-R9")
  val LIMEGREEN: Color = LimeGreen
  val Linen: Color = new Color(jfxsp.Color.LINEN)
  @deprecated("Use Linen; LINEN will be removed in a future release.", "1.0.0-R9")
  val LINEN: Color = Linen
  val Magenta: Color = new Color(jfxsp.Color.MAGENTA)
  @deprecated("Use Magenta; MAGENTA will be removed in a future release.", "1.0.0-R9")
  val MAGENTA: Color = Magenta
  val Maroon: Color = new Color(jfxsp.Color.MAROON)
  @deprecated("Use Maroon; MAROON will be removed in a future release.", "1.0.0-R9")
  val MAROON: Color = Maroon
  val MediumAquamarine: Color = new Color(jfxsp.Color.MEDIUMAQUAMARINE)
  @deprecated("Use MediumAquamarine; MEDIUMAQUAMARINE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMAQUAMARINE: Color = MediumAquamarine
  val MediumBlue: Color = new Color(jfxsp.Color.MEDIUMBLUE)
  @deprecated("Use MediumBlue; MEDIUMBLUE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMBLUE: Color = MediumBlue
  val MediumOrchid: Color = new Color(jfxsp.Color.MEDIUMORCHID)
  @deprecated("Use MediumOrchid; MEDIUMORCHID will be removed in a future release.", "1.0.0-R9")
  val MEDIUMORCHID: Color = MediumOrchid
  val MediumPurple: Color = new Color(jfxsp.Color.MEDIUMPURPLE)
  @deprecated("Use MediumPurple; MEDIUMPURPLE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMPURPLE: Color = MediumPurple
  val MediumSeaGreen: Color = new Color(jfxsp.Color.MEDIUMSEAGREEN)
  @deprecated("Use MediumSeaGreen; MEDIUMSEAGREEN will be removed in a future release.", "1.0.0-R9")
  val MEDIUMSEAGREEN: Color = MediumSeaGreen
  val MediumSlateBlue: Color = new Color(jfxsp.Color.MEDIUMSLATEBLUE)
  @deprecated("Use MediumSlateBlue; MEDIUMSLATEBLUE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMSLATEBLUE: Color = MediumSlateBlue
  val MediumSpringGreen: Color = new Color(jfxsp.Color.MEDIUMSPRINGGREEN)
  @deprecated("Use MediumSpringGreen; MEDIUMSPRINGGREEN will be removed in a future release.", "1.0.0-R9")
  val MEDIUMSPRINGGREEN: Color = MediumSpringGreen
  val MediumTurquoise: Color = new Color(jfxsp.Color.MEDIUMTURQUOISE)
  @deprecated("Use MediumTurquoise; MEDIUMTURQUOISE will be removed in a future release.", "1.0.0-R9")
  val MEDIUMTURQUOISE: Color = MediumTurquoise
  val MediumVioletRed: Color = new Color(jfxsp.Color.MEDIUMVIOLETRED)
  @deprecated("Use MediumVioletRed; MEDIUMVIOLETRED will be removed in a future release.", "1.0.0-R9")
  val MEDIUMVIOLETRED: Color = MediumVioletRed
  val MidnightBlue: Color = new Color(jfxsp.Color.MIDNIGHTBLUE)
  @deprecated("Use MidnightBlue; MIDNIGHTBLUE will be removed in a future release.", "1.0.0-R9")
  val MIDNIGHTBLUE: Color = MidnightBlue
  val MintCream: Color = new Color(jfxsp.Color.MINTCREAM)
  @deprecated("Use MintCream; MINTCREAM will be removed in a future release.", "1.0.0-R9")
  val MINTCREAM: Color = MintCream
  val MistyRose: Color = new Color(jfxsp.Color.MISTYROSE)
  @deprecated("Use MistyRose; MISTYROSE will be removed in a future release.", "1.0.0-R9")
  val MISTYROSE: Color = MistyRose
  val Moccasin: Color = new Color(jfxsp.Color.MOCCASIN)
  @deprecated("Use Moccasin; MOCCASIN will be removed in a future release.", "1.0.0-R9")
  val MOCCASIN: Color = Moccasin
  val NavajoWhite: Color = new Color(jfxsp.Color.NAVAJOWHITE)
  @deprecated("Use NavajoWhite; NAVAJOWHITE will be removed in a future release.", "1.0.0-R9")
  val NAVAJOWHITE: Color = NavajoWhite
  val Navy: Color = new Color(jfxsp.Color.NAVY)
  @deprecated("Use Navy; NAVY will be removed in a future release.", "1.0.0-R9")
  val NAVY: Color = Navy
  val OldLace: Color = new Color(jfxsp.Color.OLDLACE)
  @deprecated("Use OldLace; OLDLACE will be removed in a future release.", "1.0.0-R9")
  val OLDLACE: Color = OldLace
  val Olive: Color = new Color(jfxsp.Color.OLIVE)
  @deprecated("Use Olive; OLIVE will be removed in a future release.", "1.0.0-R9")
  val OLIVE: Color = Olive
  val OliveDrab: Color = new Color(jfxsp.Color.OLIVEDRAB)
  @deprecated("Use OliveDrab; OLIVEDRAB will be removed in a future release.", "1.0.0-R9")
  val OLIVEDRAB: Color = OliveDrab
  val Orange: Color = new Color(jfxsp.Color.ORANGE)
  @deprecated("Use Orange; ORANGE will be removed in a future release.", "1.0.0-R9")
  val ORANGE: Color = Orange
  val OrangeRed: Color = new Color(jfxsp.Color.ORANGERED)
  @deprecated("Use OrangeRed; ORANGERED will be removed in a future release.", "1.0.0-R9")
  val ORANGERED: Color = OrangeRed
  val Orchid: Color = new Color(jfxsp.Color.ORCHID)
  @deprecated("Use Orchid; ORCHID will be removed in a future release.", "1.0.0-R9")
  val ORCHID: Color = Orchid
  val PaleGoldrenrod: Color = new Color(jfxsp.Color.PALEGOLDENROD)
  @deprecated("Use PaleGoldrenrod; PALEGOLDENROD will be removed in a future release.", "1.0.0-R9")
  val PALEGOLDENROD: Color = PaleGoldrenrod
  val PaleGreen: Color = new Color(jfxsp.Color.PALEGREEN)
  @deprecated("Use PaleGreen; PALEGREEN will be removed in a future release.", "1.0.0-R9")
  val PALEGREEN: Color = PaleGreen
  val PaleTurquoise: Color = new Color(jfxsp.Color.PALETURQUOISE)
  @deprecated("Use PaleTurquoise; PALETURQUOISE will be removed in a future release.", "1.0.0-R9")
  val PALETURQUOISE: Color = PaleTurquoise
  val PaleVioletRed: Color = new Color(jfxsp.Color.PALEVIOLETRED)
  @deprecated("Use PaleVioletRed; PALEVIOLETRED will be removed in a future release.", "1.0.0-R9")
  val PALEVIOLETRED: Color = PaleVioletRed
  val PapayaWhip: Color = new Color(jfxsp.Color.PAPAYAWHIP)
  @deprecated("Use PapayaWhip; PAPAYAWHIP will be removed in a future release.", "1.0.0-R9")
  val PAPAYAWHIP: Color = PapayaWhip
  val PeachPuff: Color = new Color(jfxsp.Color.PEACHPUFF)
  @deprecated("Use PeachPuff; PEACHPUFF will be removed in a future release.", "1.0.0-R9")
  val PEACHPUFF: Color = PeachPuff
  val Peru: Color = new Color(jfxsp.Color.PERU)
  @deprecated("Use Peru; PERU will be removed in a future release.", "1.0.0-R9")
  val PERU: Color = Peru
  val Pink: Color = new Color(jfxsp.Color.PINK)
  @deprecated("Use Pink; PINK will be removed in a future release.", "1.0.0-R9")
  val PINK: Color = Pink
  val Plum: Color = new Color(jfxsp.Color.PLUM)
  @deprecated("Use Plum; PLUM will be removed in a future release.", "1.0.0-R9")
  val PLUM: Color = Plum
  val PowderBlue: Color = new Color(jfxsp.Color.POWDERBLUE)
  @deprecated("Use PowderBlue; POWDERBLUE will be removed in a future release.", "1.0.0-R9")
  val POWDERBLUE: Color = PowderBlue
  val Purple: Color = new Color(jfxsp.Color.PURPLE)
  @deprecated("Use Purple; PURPLE will be removed in a future release.", "1.0.0-R9")
  val PURPLE: Color = Purple
  val Red: Color = new Color(jfxsp.Color.RED)
  @deprecated("Use Red; RED will be removed in a future release.", "1.0.0-R9")
  val RED: Color = Red
  val RosyBrown: Color = new Color(jfxsp.Color.ROSYBROWN)
  @deprecated("Use RosyBrown; ROSYBROWN will be removed in a future release.", "1.0.0-R9")
  val ROSYBROWN: Color = RosyBrown
  val RoyalBlue: Color = new Color(jfxsp.Color.ROYALBLUE)
  @deprecated("Use RoyalBlue; ROYALBLUE will be removed in a future release.", "1.0.0-R9")
  val ROYALBLUE: Color = RoyalBlue
  val SaddleBrown: Color = new Color(jfxsp.Color.SADDLEBROWN)
  @deprecated("Use SaddleBrown; SADDLEBROWN will be removed in a future release.", "1.0.0-R9")
  val SADDLEBROWN: Color = SaddleBrown
  val Salmon: Color = new Color(jfxsp.Color.SALMON)
  @deprecated("Use Salmon; SALMON will be removed in a future release.", "1.0.0-R9")
  val SALMON: Color = Salmon
  val SandyBrown: Color = new Color(jfxsp.Color.SANDYBROWN)
  @deprecated("Use SandyBrown; SANDYBROWN will be removed in a future release.", "1.0.0-R9")
  val SANDYBROWN: Color = SandyBrown
  val SeaGreen: Color = new Color(jfxsp.Color.SEAGREEN)
  @deprecated("Use SeaGreen; SEAGREEN will be removed in a future release.", "1.0.0-R9")
  val SEAGREEN: Color = SeaGreen
  val SeaShell: Color = new Color(jfxsp.Color.SEASHELL)
  @deprecated("Use SeaShell; SEASHELL will be removed in a future release.", "1.0.0-R9")
  val SEASHELL: Color = SeaShell
  val Sienna: Color = new Color(jfxsp.Color.SIENNA)
  @deprecated("Use Sienna; SIENNA will be removed in a future release.", "1.0.0-R9")
  val SIENNA: Color = Sienna
  val Silver: Color = new Color(jfxsp.Color.SILVER)
  @deprecated("Use Silver; SILVER will be removed in a future release.", "1.0.0-R9")
  val SILVER: Color = Silver
  val SkyBlue: Color = new Color(jfxsp.Color.SKYBLUE)
  @deprecated("Use SkyBlue; SKYBLUE will be removed in a future release.", "1.0.0-R9")
  val SKYBLUE: Color = SkyBlue
  val SlateBlue: Color = new Color(jfxsp.Color.SLATEBLUE)
  @deprecated("Use SlateBlue; SLATEBLUE will be removed in a future release.", "1.0.0-R9")
  val SLATEBLUE: Color = SlateBlue
  val SlateGray: Color = new Color(jfxsp.Color.SLATEGRAY)
  @deprecated("Use SlateGray; SLATEGRAY will be removed in a future release.", "1.0.0-R9")
  val SLATEGRAY: Color = SlateGray
  val SlateGrey: Color = new Color(jfxsp.Color.SLATEGREY)
  @deprecated("Use SlateGrey; SLATEGREY will be removed in a future release.", "1.0.0-R9")
  val SLATEGREY: Color = SlateGrey
  val Snow: Color = new Color(jfxsp.Color.SNOW)
  @deprecated("Use Snow; SNOW will be removed in a future release.", "1.0.0-R9")
  val SNOW: Color = Snow
  val SpringGreen: Color = new Color(jfxsp.Color.SPRINGGREEN)
  @deprecated("Use SpringGreen; SPRINGGREEN will be removed in a future release.", "1.0.0-R9")
  val SPRINGGREEN: Color = SpringGreen
  val SteelBlue: Color = new Color(jfxsp.Color.STEELBLUE)
  @deprecated("Use SteelBlue; STEELBLUE will be removed in a future release.", "1.0.0-R9")
  val STEELBLUE: Color = SteelBlue
  val Tan: Color = new Color(jfxsp.Color.TAN)
  @deprecated("Use Tan; TAN will be removed in a future release.", "1.0.0-R9")
  val TAN: Color = Tan
  val Teal: Color = new Color(jfxsp.Color.TEAL)
  @deprecated("Use Teal; TEAL will be removed in a future release.", "1.0.0-R9")
  val TEAL: Color = Teal
  val Thistle: Color = new Color(jfxsp.Color.THISTLE)
  @deprecated("Use Thistle; THISTLE will be removed in a future release.", "1.0.0-R9")
  val THISTLE: Color = Thistle
  val Tomato: Color = new Color(jfxsp.Color.TOMATO)
  @deprecated("Use Tomato; TOMATO will be removed in a future release.", "1.0.0-R9")
  val TOMATO: Color = Tomato
  val Transparent: Color = new Color(jfxsp.Color.TRANSPARENT)
  @deprecated("Use Transparent; TRANSPARENT will be removed in a future release.", "1.0.0-R9")
  val TRANSPARENT: Color = Transparent
  val Turquoise: Color = new Color(jfxsp.Color.TURQUOISE)
  @deprecated("Use Turquoise; TURQUOISE will be removed in a future release.", "1.0.0-R9")
  val TURQUOISE: Color = Turquoise
  val Violet: Color = new Color(jfxsp.Color.VIOLET)
  @deprecated("Use Violet; VIOLET will be removed in a future release.", "1.0.0-R9")
  val VIOLET: Color = Violet
  val Wheat: Color = new Color(jfxsp.Color.WHEAT)
  @deprecated("Use Wheat; WHEAT will be removed in a future release.", "1.0.0-R9")
  val WHEAT: Color = Wheat
  val White: Color = new Color(jfxsp.Color.WHITE)
  @deprecated("Use White; WHITE will be removed in a future release.", "1.0.0-R9")
  val WHITE: Color = White
  val WhiteSmoke: Color = new Color(jfxsp.Color.WHITESMOKE)
  @deprecated("Use WhiteSmoke; WHITESMOKE will be removed in a future release.", "1.0.0-R9")
  val WHITESMOKE: Color = WhiteSmoke
  val Yellow: Color = new Color(jfxsp.Color.YELLOW)
  @deprecated("Use Yellow; YELLOW will be removed in a future release.", "1.0.0-R9")
  val YELLOW: Color = Yellow
  val YellowGreen: Color = new Color(jfxsp.Color.YELLOWGREEN)
  @deprecated("Use YellowGreen; YELLOWGREEN will be removed in a future release.", "1.0.0-R9")
  val YELLOWGREEN: Color = YellowGreen
}

class Color(override val delegate: jfxsp.Color) extends Paint(delegate) with SFXDelegate[jfxsp.Color] {

  /**
   * The red component of the Color, in the range 0.0-1.0.
   */
  def red: Double = delegate.getRed

  /**
   * The green component of the Color, in the range 0.0-1.0.
   */
  def green: Double = delegate.getGreen

  /**
   * The blue component of the Color, in the range 0.0-1.0.
   */
  def blue: Double = delegate.getBlue

  /**
   * The opacity of the Color, in the range 0.0-1.0.
   */
  def opacity: Double = delegate.getOpacity

  /**
   * Gets the hue component of this Color.
   */
  def hue: Double = delegate.getHue

  /**
   * Gets the saturation component of this Color.
   */
  def saturation: Double = delegate.getSaturation

  /**
   * Gets the brightness component of this Color.
   */
  def brightness: Double = delegate.getBrightness

  /*
   * Does someone uses this method?
   */
  def opacity(o: Double): jfxsp.Color = jfxsp.Color.color(red, green, blue, o)

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
  def deriveColor(hueShift: Double, saturationFactor: Double, brightnessFactor: Double, opacityFactor: Double): Color =
    delegate.deriveColor(hueShift, saturationFactor, brightnessFactor, opacityFactor)

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