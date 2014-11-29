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
package scalafx.colorselector

import scalafx.scene.paint.Color
import scalafx.scene.paint.Color._

object WebColor {

  val colors = List(
    WebColor("ALICEBLUE", AliceBlue),
    WebColor("ANTIQUEWHITE", AntiqueWhite),
    WebColor("AQUA", Aqua),
    WebColor("AQUAMARINE", Aquamarine),
    WebColor("AZURE", Azure),
    WebColor("BEIGE", Beige),
    WebColor("BISQUE", Bisque),
    WebColor("BLACK", Black),
    WebColor("BLANCHEDALMOND", BlanchedAlmond),
    WebColor("BLUE", Blue),
    WebColor("BLUEVIOLET", BlueViolet),
    WebColor("BROWN", Brown),
    WebColor("BURLYWOOD", Burlywood),
    WebColor("CADETBLUE", CadetBlue),
    WebColor("CHARTREUSE", Chartreuse),
    WebColor("CHOCOLATE", Chocolate),
    WebColor("CORAL", Coral),
    WebColor("CORNFLOWERBLUE", CornflowerBlue),
    WebColor("CORNSILK", Cornsilk),
    WebColor("CRIMSON", Crimson),
    WebColor("CYAN", Cyan),
    WebColor("DARKBLUE", DarkBlue),
    WebColor("DARKCYAN", DarkCyan),
    WebColor("DARKGOLDENROD", DarkGoldenrod),
    WebColor("DARKGRAY", DarkGray),
    WebColor("DARKGREEN", DarkGreen),
    WebColor("DARKGREY", DarkGrey),
    WebColor("DARKKHAKI", DarkKhaki),
    WebColor("DARKMAGENTA", DarkMagenta),
    WebColor("DARKOLIVEGREEN", DarkOliveGreen),
    WebColor("DARKORANGE", DarkOrange),
    WebColor("DARKORCHID", DarkOrchid),
    WebColor("DARKRED", DarkRed),
    WebColor("DARKSALMON", DarkSalmon),
    WebColor("DARKSEAGREEN", DarkSeaGreen),
    WebColor("DARKSLATEBLUE", DarkSlateBlue),
    WebColor("DARKSLATEGRAY", DarkSlateGray),
    WebColor("DARKSLATEGREY", DarkSlateGrey),
    WebColor("DARKTURQUOISE", DarkTurquoise),
    WebColor("DARKVIOLET", DarkViolet),
    WebColor("DEEPPINK", DeepPink),
    WebColor("DEEPSKYBLUE", DeepSkyBlue),
    WebColor("DIMGRAY", DimGray),
    WebColor("DIMGREY", DimGrey),
    WebColor("DODGERBLUE", DodgerBlue),
    WebColor("FIREBRICK", FireBrick),
    WebColor("FLORALWHITE", FloralWhite),
    WebColor("FORESTGREEN", ForestGreen),
    WebColor("FUCHSIA", Fuchsia),
    WebColor("GAINSBORO", Gainsboro),
    WebColor("GHOSTWHITE", GhostWhite),
    WebColor("GOLD", Gold),
    WebColor("GOLDENROD", Goldenrod),
    WebColor("GRAY", Gray),
    WebColor("GREEN", Green),
    WebColor("GREENYELLOW", GreenYellow),
    WebColor("GREY", Grey),
    WebColor("HONEYDEW", Honeydew),
    WebColor("HOTPINK", HotPink),
    WebColor("INDIANRED", IndianRed),
    WebColor("INDIGO", Indigo),
    WebColor("IVORY", Ivory),
    WebColor("KHAKI", Khaki),
    WebColor("LAVENDER", Lavender),
    WebColor("LAVENDERBLUSH", LavenderBlush),
    WebColor("LAWNGREEN", LawnGreen),
    WebColor("LEMONCHIFFON", LemonChiffon),
    WebColor("LIGHTBLUE", LightBlue),
    WebColor("LIGHTCORAL", LightCoral),
    WebColor("LIGHTCYAN", LightCyan),
    WebColor("LIGHTGOLDENRODYELLOW", LightGoldrenrodYellow),
    WebColor("LIGHTGRAY", LightGray),
    WebColor("LIGHTGREEN", LightGreen),
    WebColor("LIGHTGREY", LightGrey),
    WebColor("LIGHTPINK", LightPink),
    WebColor("LIGHTSALMON", LightSalmon),
    WebColor("LIGHTSEAGREEN", LightSeaGreen),
    WebColor("LIGHTSKYBLUE", LightSkyBlue),
    WebColor("LIGHTSLATEGRAY", LightSlateGray),
    WebColor("LIGHTSLATEGREY", LightSlateGrey),
    WebColor("LIGHTSTEELBLUE", LightSteelBlue),
    WebColor("LIGHTYELLOW", LightYellow),
    WebColor("LIME", Lime),
    WebColor("LIMEGREEN", LimeGreen),
    WebColor("LINEN", Linen),
    WebColor("MAGENTA", Magenta),
    WebColor("MAROON", Maroon),
    WebColor("MEDIUMAQUAMARINE", MediumAquamarine),
    WebColor("MEDIUMBLUE", MediumBlue),
    WebColor("MEDIUMORCHID", MediumOrchid),
    WebColor("MEDIUMPURPLE", MediumPurple),
    WebColor("MEDIUMSEAGREEN", MediumSeaGreen),
    WebColor("MEDIUMSLATEBLUE", MediumSlateBlue),
    WebColor("MEDIUMSPRINGGREEN", MediumSpringGreen),
    WebColor("MEDIUMTURQUOISE", MediumTurquoise),
    WebColor("MEDIUMVIOLETRED", MediumVioletRed),
    WebColor("MIDNIGHTBLUE", MidnightBlue),
    WebColor("MINTCREAM", MintCream),
    WebColor("MISTYROSE", MistyRose),
    WebColor("MOCCASIN", Moccasin),
    WebColor("NAVAJOWHITE", NavajoWhite),
    WebColor("NAVY", Navy),
    WebColor("OLDLACE", OldLace),
    WebColor("OLIVE", Olive),
    WebColor("OLIVEDRAB", OliveDrab),
    WebColor("ORANGE", Orange),
    WebColor("ORANGERED", OrangeRed),
    WebColor("ORCHID", Orchid),
    WebColor("PALEGOLDENROD", PaleGoldrenrod),
    WebColor("PALEGREEN", PaleGreen),
    WebColor("PALETURQUOISE", PaleTurquoise),
    WebColor("PALEVIOLETRED", PaleVioletRed),
    WebColor("PAPAYAWHIP", PapayaWhip),
    WebColor("PEACHPUFF", PeachPuff),
    WebColor("PERU", Peru),
    WebColor("PINK", Pink),
    WebColor("PLUM", Plum),
    WebColor("POWDERBLUE", PowderBlue),
    WebColor("PURPLE", Purple),
    WebColor("RED", Red),
    WebColor("ROSYBROWN", RosyBrown),
    WebColor("ROYALBLUE", RoyalBlue),
    WebColor("SADDLEBROWN", SaddleBrown),
    WebColor("SALMON", Salmon),
    WebColor("SANDYBROWN", SandyBrown),
    WebColor("SEAGREEN", SeaGreen),
    WebColor("SEASHELL", SeaShell),
    WebColor("SIENNA", Sienna),
    WebColor("SILVER", Silver),
    WebColor("SKYBLUE", SkyBlue),
    WebColor("SLATEBLUE", SlateBlue),
    WebColor("SLATEGRAY", SlateGray),
    WebColor("SLATEGREY", SlateGrey),
    WebColor("SNOW", Snow),
    WebColor("SPRINGGREEN", SpringGreen),
    WebColor("STEELBLUE", SteelBlue),
    WebColor("TAN", Tan),
    WebColor("TEAL", Teal),
    WebColor("THISTLE", Thistle),
    WebColor("TOMATO", Tomato),
    WebColor("TRANSPARENT", Transparent),
    WebColor("TURQUOISE", Turquoise),
    WebColor("VIOLET", Violet),
    WebColor("WHEAT", Wheat),
    WebColor("WHITE", White),
    WebColor("WHITESMOKE", WhiteSmoke),
    WebColor("YELLOW", Yellow),
    WebColor("YELLOWGREEN", YellowGreen)

  )
}

/**
 * Represents pre-defined colors defined in [[scalafx.scene.paint.Color]] Object.
 *
 * @constructor Creates a new WebColor
 * @param name Color Name
 * @param color Color
 */
sealed case class WebColor(name: String, color: Color) {

  /**
   * Verifies if a determined color is equivalent to color represented by this WebColor.
   */
  def sameColor(c: Color) =
    ((c.red == color.red) && (c.green == color.green) && (c.blue == color.blue))
}