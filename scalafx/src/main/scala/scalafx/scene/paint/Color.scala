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
package scalafx.scene.paint

import javafx.scene.{ paint => jfxsp }
import scalafx.delegate.SFXDelegate

object Color {
  implicit def sfxColor2jfx(c: Color) = c.delegate
  implicit def jfxColor2sfx(c: jfxsp.Color) = new Color(c)

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

  val ALICEBLUE = new Color(jfxsp.Color.ALICEBLUE)
  val ANTIQUEWHITE = new Color(jfxsp.Color.ANTIQUEWHITE)
  val AQUA = new Color(jfxsp.Color.AQUA)
  val AQUAMARINE = new Color(jfxsp.Color.AQUAMARINE)
  val AZURE = new Color(jfxsp.Color.AZURE)
  val BEIGE = new Color(jfxsp.Color.BEIGE)
  val BISQUE = new Color(jfxsp.Color.BISQUE)
  val BLACK = new Color(jfxsp.Color.BLACK)
  val BLANCHEDALMOND = new Color(jfxsp.Color.BLANCHEDALMOND)
  val BLUE = new Color(jfxsp.Color.BLUE)
  val BLUEVIOLET = new Color(jfxsp.Color.BLUEVIOLET)
  val BROWN = new Color(jfxsp.Color.BROWN)
  val BURLYWOOD = new Color(jfxsp.Color.BURLYWOOD)
  val CADETBLUE = new Color(jfxsp.Color.CADETBLUE)
  val CHARTREUSE = new Color(jfxsp.Color.CHARTREUSE)
  val CHOCOLATE = new Color(jfxsp.Color.CHOCOLATE)
  val CORAL = new Color(jfxsp.Color.CORAL)
  val CORNFLOWERBLUE = new Color(jfxsp.Color.CORNFLOWERBLUE)
  val CORNSILK = new Color(jfxsp.Color.CORNSILK)
  val CRIMSON = new Color(jfxsp.Color.CRIMSON)
  val CYAN = new Color(jfxsp.Color.CYAN)
  val DARKBLUE = new Color(jfxsp.Color.DARKBLUE)
  val DARKCYAN = new Color(jfxsp.Color.DARKCYAN)
  val DARKGOLDENROD = new Color(jfxsp.Color.DARKGOLDENROD)
  val DARKGRAY = new Color(jfxsp.Color.DARKGRAY)
  val DARKGREEN = new Color(jfxsp.Color.DARKGREEN)
  val DARKGREY = new Color(jfxsp.Color.DARKGREY)
  val DARKKHAKI = new Color(jfxsp.Color.DARKKHAKI)
  val DARKMAGENTA = new Color(jfxsp.Color.DARKMAGENTA)
  val DARKOLIVEGREEN = new Color(jfxsp.Color.DARKOLIVEGREEN)
  val DARKORANGE = new Color(jfxsp.Color.DARKORANGE)
  val DARKORCHID = new Color(jfxsp.Color.DARKORCHID)
  val DARKRED = new Color(jfxsp.Color.DARKRED)
  val DARKSALMON = new Color(jfxsp.Color.DARKSALMON)
  val DARKSEAGREEN = new Color(jfxsp.Color.DARKSEAGREEN)
  val DARKSLATEBLUE = new Color(jfxsp.Color.DARKSLATEBLUE)
  val DARKSLATEGRAY = new Color(jfxsp.Color.DARKSLATEGRAY)
  val DARKSLATEGREY = new Color(jfxsp.Color.DARKSLATEGREY)
  val DARKTURQUOISE = new Color(jfxsp.Color.DARKTURQUOISE)
  val DARKVIOLET = new Color(jfxsp.Color.DARKVIOLET)
  val DEEPPINK = new Color(jfxsp.Color.DEEPPINK)
  val DEEPSKYBLUE = new Color(jfxsp.Color.DEEPSKYBLUE)
  val DIMGRAY = new Color(jfxsp.Color.DIMGRAY)
  val DIMGREY = new Color(jfxsp.Color.DIMGREY)
  val DODGERBLUE = new Color(jfxsp.Color.DODGERBLUE)
  val FIREBRICK = new Color(jfxsp.Color.FIREBRICK)
  val FLORALWHITE = new Color(jfxsp.Color.FLORALWHITE)
  val FORESTGREEN = new Color(jfxsp.Color.FORESTGREEN)
  val FUCHSIA = new Color(jfxsp.Color.FUCHSIA)
  val GAINSBORO = new Color(jfxsp.Color.GAINSBORO)
  val GHOSTWHITE = new Color(jfxsp.Color.GHOSTWHITE)
  val GOLD = new Color(jfxsp.Color.GOLD)
  val GOLDENROD = new Color(jfxsp.Color.GOLDENROD)
  val GRAY = new Color(jfxsp.Color.GRAY)
  val GREEN = new Color(jfxsp.Color.GREEN)
  val GREENYELLOW = new Color(jfxsp.Color.GREENYELLOW)
  val GREY = new Color(jfxsp.Color.GREY)
  val HONEYDEW = new Color(jfxsp.Color.HONEYDEW)
  val HOTPINK = new Color(jfxsp.Color.HOTPINK)
  val INDIANRED = new Color(jfxsp.Color.INDIANRED)
  val INDIGO = new Color(jfxsp.Color.INDIGO)
  val IVORY = new Color(jfxsp.Color.IVORY)
  val KHAKI = new Color(jfxsp.Color.KHAKI)
  val LAVENDER = new Color(jfxsp.Color.LAVENDER)
  val LAVENDERBLUSH = new Color(jfxsp.Color.LAVENDERBLUSH)
  val LAWNGREEN = new Color(jfxsp.Color.LAWNGREEN)
  val LEMONCHIFFON = new Color(jfxsp.Color.LEMONCHIFFON)
  val LIGHTBLUE = new Color(jfxsp.Color.LIGHTBLUE)
  val LIGHTCORAL = new Color(jfxsp.Color.LIGHTCORAL)
  val LIGHTCYAN = new Color(jfxsp.Color.LIGHTCYAN)
  val LIGHTGOLDENRODYELLOW = new Color(jfxsp.Color.LIGHTGOLDENRODYELLOW)
  val LIGHTGRAY = new Color(jfxsp.Color.LIGHTGRAY)
  val LIGHTGREEN = new Color(jfxsp.Color.LIGHTGREEN)
  val LIGHTGREY = new Color(jfxsp.Color.LIGHTGREY)
  val LIGHTPINK = new Color(jfxsp.Color.LIGHTPINK)
  val LIGHTSALMON = new Color(jfxsp.Color.LIGHTSALMON)
  val LIGHTSEAGREEN = new Color(jfxsp.Color.LIGHTSEAGREEN)
  val LIGHTSKYBLUE = new Color(jfxsp.Color.LIGHTSKYBLUE)
  val LIGHTSLATEGRAY = new Color(jfxsp.Color.LIGHTSLATEGRAY)
  val LIGHTSLATEGREY = new Color(jfxsp.Color.LIGHTSLATEGREY)
  val LIGHTSTEELBLUE = new Color(jfxsp.Color.LIGHTSTEELBLUE)
  val LIGHTYELLOW = new Color(jfxsp.Color.LIGHTYELLOW)
  val LIME = new Color(jfxsp.Color.LIME)
  val LIMEGREEN = new Color(jfxsp.Color.LIMEGREEN)
  val LINEN = new Color(jfxsp.Color.LINEN)
  val MAGENTA = new Color(jfxsp.Color.MAGENTA)
  val MAROON = new Color(jfxsp.Color.MAROON)
  val MEDIUMAQUAMARINE = new Color(jfxsp.Color.MEDIUMAQUAMARINE)
  val MEDIUMBLUE = new Color(jfxsp.Color.MEDIUMBLUE)
  val MEDIUMORCHID = new Color(jfxsp.Color.MEDIUMORCHID)
  val MEDIUMPURPLE = new Color(jfxsp.Color.MEDIUMPURPLE)
  val MEDIUMSEAGREEN = new Color(jfxsp.Color.MEDIUMSEAGREEN)
  val MEDIUMSLATEBLUE = new Color(jfxsp.Color.MEDIUMSLATEBLUE)
  val MEDIUMSPRINGGREEN = new Color(jfxsp.Color.MEDIUMSPRINGGREEN)
  val MEDIUMTURQUOISE = new Color(jfxsp.Color.MEDIUMTURQUOISE)
  val MEDIUMVIOLETRED = new Color(jfxsp.Color.MEDIUMVIOLETRED)
  val MIDNIGHTBLUE = new Color(jfxsp.Color.MIDNIGHTBLUE)
  val MINTCREAM = new Color(jfxsp.Color.MINTCREAM)
  val MISTYROSE = new Color(jfxsp.Color.MISTYROSE)
  val MOCCASIN = new Color(jfxsp.Color.MOCCASIN)
  val NAVAJOWHITE = new Color(jfxsp.Color.NAVAJOWHITE)
  val NAVY = new Color(jfxsp.Color.NAVY)
  val OLDLACE = new Color(jfxsp.Color.OLDLACE)
  val OLIVE = new Color(jfxsp.Color.OLIVE)
  val OLIVEDRAB = new Color(jfxsp.Color.OLIVEDRAB)
  val ORANGE = new Color(jfxsp.Color.ORANGE)
  val ORANGERED = new Color(jfxsp.Color.ORANGERED)
  val ORCHID = new Color(jfxsp.Color.ORCHID)
  val PALEGOLDENROD = new Color(jfxsp.Color.PALEGOLDENROD)
  val PALEGREEN = new Color(jfxsp.Color.PALEGREEN)
  val PALETURQUOISE = new Color(jfxsp.Color.PALETURQUOISE)
  val PALEVIOLETRED = new Color(jfxsp.Color.PALEVIOLETRED)
  val PAPAYAWHIP = new Color(jfxsp.Color.PAPAYAWHIP)
  val PEACHPUFF = new Color(jfxsp.Color.PEACHPUFF)
  val PERU = new Color(jfxsp.Color.PERU)
  val PINK = new Color(jfxsp.Color.PINK)
  val PLUM = new Color(jfxsp.Color.PLUM)
  val POWDERBLUE = new Color(jfxsp.Color.POWDERBLUE)
  val PURPLE = new Color(jfxsp.Color.PURPLE)
  val RED = new Color(jfxsp.Color.RED)
  val ROSYBROWN = new Color(jfxsp.Color.ROSYBROWN)
  val ROYALBLUE = new Color(jfxsp.Color.ROYALBLUE)
  val SADDLEBROWN = new Color(jfxsp.Color.SADDLEBROWN)
  val SALMON = new Color(jfxsp.Color.SALMON)
  val SANDYBROWN = new Color(jfxsp.Color.SANDYBROWN)
  val SEAGREEN = new Color(jfxsp.Color.SEAGREEN)
  val SEASHELL = new Color(jfxsp.Color.SEASHELL)
  val SIENNA = new Color(jfxsp.Color.SIENNA)
  val SILVER = new Color(jfxsp.Color.SILVER)
  val SKYBLUE = new Color(jfxsp.Color.SKYBLUE)
  val SLATEBLUE = new Color(jfxsp.Color.SLATEBLUE)
  val SLATEGRAY = new Color(jfxsp.Color.SLATEGRAY)
  val SLATEGREY = new Color(jfxsp.Color.SLATEGREY)
  val SNOW = new Color(jfxsp.Color.SNOW)
  val SPRINGGREEN = new Color(jfxsp.Color.SPRINGGREEN)
  val STEELBLUE = new Color(jfxsp.Color.STEELBLUE)
  val TAN = new Color(jfxsp.Color.TAN)
  val TEAL = new Color(jfxsp.Color.TEAL)
  val THISTLE = new Color(jfxsp.Color.THISTLE)
  val TOMATO = new Color(jfxsp.Color.TOMATO)
  val TRANSPARENT = new Color(jfxsp.Color.TRANSPARENT)
  val TURQUOISE = new Color(jfxsp.Color.TURQUOISE)
  val VIOLET = new Color(jfxsp.Color.VIOLET)
  val WHEAT = new Color(jfxsp.Color.WHEAT)
  val WHITE = new Color(jfxsp.Color.WHITE)
  val WHITESMOKE = new Color(jfxsp.Color.WHITESMOKE)
  val YELLOW = new Color(jfxsp.Color.YELLOW)
  val YELLOWGREEN = new Color(jfxsp.Color.YELLOWGREEN)
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
  def brighter:Color = delegate.brighter
  

  /**
   * Creates a new Color that is a darker version of this Color.
   */
  def darker:Color = delegate.darker

  /**
   * Creates a new Color based on this Color with hue, saturation, brightness and opacity values altered.
   */
  def deriveColor(hueShift: Double, saturationFactor: Double, brightnessFactor: Double, opacityFactor: Double):Color = delegate.deriveColor(hueShift, saturationFactor, brightnessFactor, opacityFactor)

  /**
   * Creates a new Color that is a less saturated version of this Color.
   */
  def desaturate:Color = delegate.desaturate

  /**
   * Creates a new Color that is grayscale equivalent of this Color.
   */
  def grayscale:Color = delegate.grayscale

  /**
   * The function calculates an interpolated value along the fraction t between 0.0 and 1.0.
   */
  def interpolate(endValue: Color, t: Double):Color = delegate.interpolate(endValue, t)

  /**
   * Creates a new Color that is inversion of this Color.
   */
  def invert:Color = delegate.invert

  /**
   * Creates a new Color that is a more saturated version of this Color.
   */
  def saturate:Color = delegate.saturate

}