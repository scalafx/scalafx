/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

package scalafx.scene.input

import javafx.scene.{input => jfxsi}

import scalafx.Includes._
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/KeyCode.html javafx.scene.input.KeyCode]] */
object KeyCode extends SFXEnumDelegateCompanion[jfxsi.KeyCode, KeyCode] {

  val Enter = new KeyCode(jfxsi.KeyCode.ENTER)
  @deprecated ("Use Enter; ENTER will be removed in a future release", "8.0.60-R10")
  val ENTER = Enter

  val BackSpace = new KeyCode(jfxsi.KeyCode.BACK_SPACE)
  @deprecated ("Use BackSpace; BACK_SPACE will be removed in a future release", "8.0.60-R10")
  val BACK_SPACE = BackSpace

  val Tab = new KeyCode(jfxsi.KeyCode.TAB)
  @deprecated ("Use Tab; TAB will be removed in a future release", "8.0.60-R10")
  val TAB = Tab

  val Cancel = new KeyCode(jfxsi.KeyCode.CANCEL)
  @deprecated ("Use Cancel; CANCEL will be removed in a future release", "8.0.60-R10")
  val CANCEL = Cancel

  val Clear = new KeyCode(jfxsi.KeyCode.CLEAR)
  @deprecated ("Use Clear; CLEAR will be removed in a future release", "8.0.60-R10")
  val CLEAR = Clear

  val Shift = new KeyCode(jfxsi.KeyCode.SHIFT)
  @deprecated ("Use Shift; SHIFT will be removed in a future release", "8.0.60-R10")
  val SHIFT = Shift

  val Control = new KeyCode(jfxsi.KeyCode.CONTROL)
  @deprecated ("Use Control; CONTROL will be removed in a future release", "8.0.60-R10")
  val CONTROL = Control

  val Alt = new KeyCode(jfxsi.KeyCode.ALT)
  @deprecated ("Use Alt; ALT will be removed in a future release", "8.0.60-R10")
  val ALT = Alt

  val Pause = new KeyCode(jfxsi.KeyCode.PAUSE)
  @deprecated ("Use Pause; PAUSE will be removed in a future release", "8.0.60-R10")
  val PAUSE = Pause

  val Caps = new KeyCode(jfxsi.KeyCode.CAPS)
  @deprecated ("Use Caps; CAPS will be removed in a future release", "8.0.60-R10")
  val CAPS = Caps

  val Escape = new KeyCode(jfxsi.KeyCode.ESCAPE)
  @deprecated ("Use Escape; ESCAPE will be removed in a future release", "8.0.60-R10")
  val ESCAPE = Escape

  val Space = new KeyCode(jfxsi.KeyCode.SPACE)
  @deprecated ("Use Space; SPACE will be removed in a future release", "8.0.60-R10")
  val SPACE = Space

  val PageUp = new KeyCode(jfxsi.KeyCode.PAGE_UP)
  @deprecated ("Use PageUp; PAGE_UP will be removed in a future release", "8.0.60-R10")
  val PAGE_UP = PageUp

  val PageDown = new KeyCode(jfxsi.KeyCode.PAGE_DOWN)
  @deprecated ("Use PageDown; PAGE_DOWN will be removed in a future release", "8.0.60-R10")
  val PAGE_DOWN = PageDown

  val End = new KeyCode(jfxsi.KeyCode.END)
  @deprecated ("Use End; END will be removed in a future release", "8.0.60-R10")
  val END = End

  val Home = new KeyCode(jfxsi.KeyCode.HOME)
  @deprecated ("Use Home; HOME will be removed in a future release", "8.0.60-R10")
  val HOME = Home

  val Left = new KeyCode(jfxsi.KeyCode.LEFT)
  @deprecated ("Use Left; LEFT will be removed in a future release", "8.0.60-R10")
  val LEFT = Left

  val Up = new KeyCode(jfxsi.KeyCode.UP)
  @deprecated ("Use Up; UP will be removed in a future release", "8.0.60-R10")
  val UP = Up

  val Right = new KeyCode(jfxsi.KeyCode.RIGHT)
  @deprecated ("Use Right; RIGHT will be removed in a future release", "8.0.60-R10")
  val RIGHT = Right

  val Down = new KeyCode(jfxsi.KeyCode.DOWN)
  @deprecated ("Use Down; DOWN will be removed in a future release", "8.0.60-R10")
  val DOWN = Down

  val Comma = new KeyCode(jfxsi.KeyCode.COMMA)
  @deprecated ("Use Comma; COMMA will be removed in a future release", "8.0.60-R10")
  val COMMA = Comma

  val Minus = new KeyCode(jfxsi.KeyCode.MINUS)
  @deprecated ("Use Minus; MINUS will be removed in a future release", "8.0.60-R10")
  val MINUS = Minus

  val Period = new KeyCode(jfxsi.KeyCode.PERIOD)
  @deprecated ("Use Period; PERIOD will be removed in a future release", "8.0.60-R10")
  val PERIOD = Period

  val Slash = new KeyCode(jfxsi.KeyCode.SLASH)
  @deprecated ("Use Slash; SLASH will be removed in a future release", "8.0.60-R10")
  val SLASH = Slash

  val Digit0 = new KeyCode(jfxsi.KeyCode.DIGIT0)
  @deprecated ("Use Digit0; DIGIT0 will be removed in a future release", "8.0.60-R10")
  val DIGIT0 = Digit0

  val Digit1 = new KeyCode(jfxsi.KeyCode.DIGIT1)
  @deprecated ("Use Digit1; DIGIT1 will be removed in a future release", "8.0.60-R10")
  val DIGIT1 = Digit1

  val Digit2 = new KeyCode(jfxsi.KeyCode.DIGIT2)
  @deprecated ("Use Digit2; DIGIT2 will be removed in a future release", "8.0.60-R10")
  val DIGIT2 = Digit2

  val Digit3 = new KeyCode(jfxsi.KeyCode.DIGIT3)
  @deprecated ("Use Digit3; DIGIT3 will be removed in a future release", "8.0.60-R10")
  val DIGIT3 = Digit3

  val Digit4 = new KeyCode(jfxsi.KeyCode.DIGIT4)
  @deprecated ("Use Digit4; DIGIT4 will be removed in a future release", "8.0.60-R10")
  val DIGIT4 = Digit4

  val Digit5 = new KeyCode(jfxsi.KeyCode.DIGIT5)
  @deprecated ("Use Digit5; DIGIT5 will be removed in a future release", "8.0.60-R10")
  val DIGIT5 = Digit5

  val Digit6 = new KeyCode(jfxsi.KeyCode.DIGIT6)
  @deprecated ("Use Digit6; DIGIT6 will be removed in a future release", "8.0.60-R10")
  val DIGIT6 = Digit6

  val Digit7 = new KeyCode(jfxsi.KeyCode.DIGIT7)
  @deprecated ("Use Digit7; DIGIT7 will be removed in a future release", "8.0.60-R10")
  val DIGIT7 = Digit7

  val Digit8 = new KeyCode(jfxsi.KeyCode.DIGIT8)
  @deprecated ("Use Digit8; DIGIT8 will be removed in a future release", "8.0.60-R10")
  val DIGIT8 = Digit8

  val Digit9 = new KeyCode(jfxsi.KeyCode.DIGIT9)
  @deprecated ("Use Digit9; DIGIT9 will be removed in a future release", "8.0.60-R10")
  val DIGIT9 = Digit9

  val Semicolon = new KeyCode(jfxsi.KeyCode.SEMICOLON)
  @deprecated ("Use Semicolon; SEMICOLON will be removed in a future release", "8.0.60-R10")
  val SEMICOLON = Semicolon

  val Equals = new KeyCode(jfxsi.KeyCode.EQUALS)
  @deprecated ("Use Equals; EQUALS will be removed in a future release", "8.0.60-R10")
  val EQUALS = Equals

  val A = new KeyCode(jfxsi.KeyCode.A)
  val B = new KeyCode(jfxsi.KeyCode.B)
  val C = new KeyCode(jfxsi.KeyCode.C)
  val D = new KeyCode(jfxsi.KeyCode.D)
  val E = new KeyCode(jfxsi.KeyCode.E)
  val F = new KeyCode(jfxsi.KeyCode.F)
  val G = new KeyCode(jfxsi.KeyCode.G)
  val H = new KeyCode(jfxsi.KeyCode.H)
  val I = new KeyCode(jfxsi.KeyCode.I)
  val J = new KeyCode(jfxsi.KeyCode.J)
  val K = new KeyCode(jfxsi.KeyCode.K)
  val L = new KeyCode(jfxsi.KeyCode.L)
  val M = new KeyCode(jfxsi.KeyCode.M)
  val N = new KeyCode(jfxsi.KeyCode.N)
  val O = new KeyCode(jfxsi.KeyCode.O)
  val P = new KeyCode(jfxsi.KeyCode.P)
  val Q = new KeyCode(jfxsi.KeyCode.Q)
  val R = new KeyCode(jfxsi.KeyCode.R)
  val S = new KeyCode(jfxsi.KeyCode.S)
  val T = new KeyCode(jfxsi.KeyCode.T)
  val U = new KeyCode(jfxsi.KeyCode.U)
  val V = new KeyCode(jfxsi.KeyCode.V)
  val W = new KeyCode(jfxsi.KeyCode.W)
  val X = new KeyCode(jfxsi.KeyCode.X)
  val Y = new KeyCode(jfxsi.KeyCode.Y)
  val Z = new KeyCode(jfxsi.KeyCode.Z)
  val OpenBracket = new KeyCode(jfxsi.KeyCode.OPEN_BRACKET)
  @deprecated ("Use OpenBracket; OPEN_BRACKET will be removed in a future release", "8.0.60-R10")
  val OPEN_BRACKET = OpenBracket

  val BackSlash = new KeyCode(jfxsi.KeyCode.BACK_SLASH)
  @deprecated ("Use BackSlash; BACK_SLASH will be removed in a future release", "8.0.60-R10")
  val BACK_SLASH = BackSlash

  val CloseBracket = new KeyCode(jfxsi.KeyCode.CLOSE_BRACKET)
  @deprecated ("Use CloseBracket; CLOSE_BRACKET will be removed in a future release", "8.0.60-R10")
  val CLOSE_BRACKET = CloseBracket

  val Numpad0 = new KeyCode(jfxsi.KeyCode.NUMPAD0)
  @deprecated ("Use Numpad0; NUMPAD0 will be removed in a future release", "8.0.60-R10")
  val NUMPAD0 = Numpad0

  val Numpad1 = new KeyCode(jfxsi.KeyCode.NUMPAD1)
  @deprecated ("Use Numpad1; NUMPAD1 will be removed in a future release", "8.0.60-R10")
  val NUMPAD1 = Numpad1

  val Numpad2 = new KeyCode(jfxsi.KeyCode.NUMPAD2)
  @deprecated ("Use Numpad2; NUMPAD2 will be removed in a future release", "8.0.60-R10")
  val NUMPAD2 = Numpad2

  val Numpad3 = new KeyCode(jfxsi.KeyCode.NUMPAD3)
  @deprecated ("Use Numpad3; NUMPAD3 will be removed in a future release", "8.0.60-R10")
  val NUMPAD3 = Numpad3

  val Numpad4 = new KeyCode(jfxsi.KeyCode.NUMPAD4)
  @deprecated ("Use Numpad4; NUMPAD4 will be removed in a future release", "8.0.60-R10")
  val NUMPAD4 = Numpad4

  val Numpad5 = new KeyCode(jfxsi.KeyCode.NUMPAD5)
  @deprecated ("Use Numpad5; NUMPAD5 will be removed in a future release", "8.0.60-R10")
  val NUMPAD5 = Numpad5

  val Numpad6 = new KeyCode(jfxsi.KeyCode.NUMPAD6)
  @deprecated ("Use Numpad6; NUMPAD6 will be removed in a future release", "8.0.60-R10")
  val NUMPAD6 = Numpad6

  val Numpad7 = new KeyCode(jfxsi.KeyCode.NUMPAD7)
  @deprecated ("Use Numpad7; NUMPAD7 will be removed in a future release", "8.0.60-R10")
  val NUMPAD7 = Numpad7

  val Numpad8 = new KeyCode(jfxsi.KeyCode.NUMPAD8)
  @deprecated ("Use Numpad8; NUMPAD8 will be removed in a future release", "8.0.60-R10")
  val NUMPAD8 = Numpad8

  val Numpad9 = new KeyCode(jfxsi.KeyCode.NUMPAD9)
  @deprecated ("Use Numpad9; NUMPAD9 will be removed in a future release", "8.0.60-R10")
  val NUMPAD9 = Numpad9

  val Multiply = new KeyCode(jfxsi.KeyCode.MULTIPLY)
  @deprecated ("Use Multiply; MULTIPLY will be removed in a future release", "8.0.60-R10")
  val MULTIPLY = Multiply

  val Add = new KeyCode(jfxsi.KeyCode.ADD)
  @deprecated ("Use Add; ADD will be removed in a future release", "8.0.60-R10")
  val ADD = Add

  val Separator = new KeyCode(jfxsi.KeyCode.SEPARATOR)
  @deprecated ("Use Separator; SEPARATOR will be removed in a future release", "8.0.60-R10")
  val SEPARATOR = Separator

  val Subtract = new KeyCode(jfxsi.KeyCode.SUBTRACT)
  @deprecated ("Use Subtract; SUBTRACT will be removed in a future release", "8.0.60-R10")
  val SUBTRACT = Subtract

  val Decimal = new KeyCode(jfxsi.KeyCode.DECIMAL)
  @deprecated ("Use Decimal; DECIMAL will be removed in a future release", "8.0.60-R10")
  val DECIMAL = Decimal

  val Divide = new KeyCode(jfxsi.KeyCode.DIVIDE)
  @deprecated ("Use Divide; DIVIDE will be removed in a future release", "8.0.60-R10")
  val DIVIDE = Divide

  val Delete = new KeyCode(jfxsi.KeyCode.DELETE)
  @deprecated ("Use Delete; DELETE will be removed in a future release", "8.0.60-R10")
  val DELETE = Delete

  val NumLock = new KeyCode(jfxsi.KeyCode.NUM_LOCK)
  @deprecated ("Use NumLock; NUM_LOCK will be removed in a future release", "8.0.60-R10")
  val NUM_LOCK = NumLock

  val ScrollLock = new KeyCode(jfxsi.KeyCode.SCROLL_LOCK)
  @deprecated ("Use ScrollLock; SCROLL_LOCK will be removed in a future release", "8.0.60-R10")
  val SCROLL_LOCK = ScrollLock

  val F1 = new KeyCode(jfxsi.KeyCode.F1)
  val F2 = new KeyCode(jfxsi.KeyCode.F2)
  val F3 = new KeyCode(jfxsi.KeyCode.F3)
  val F4 = new KeyCode(jfxsi.KeyCode.F4)
  val F5 = new KeyCode(jfxsi.KeyCode.F5)
  val F6 = new KeyCode(jfxsi.KeyCode.F6)
  val F7 = new KeyCode(jfxsi.KeyCode.F7)
  val F8 = new KeyCode(jfxsi.KeyCode.F8)
  val F9 = new KeyCode(jfxsi.KeyCode.F9)
  val F10 = new KeyCode(jfxsi.KeyCode.F10)
  val F11 = new KeyCode(jfxsi.KeyCode.F11)
  val F12 = new KeyCode(jfxsi.KeyCode.F12)
  val F13 = new KeyCode(jfxsi.KeyCode.F13)
  val F14 = new KeyCode(jfxsi.KeyCode.F14)
  val F15 = new KeyCode(jfxsi.KeyCode.F15)
  val F16 = new KeyCode(jfxsi.KeyCode.F16)
  val F17 = new KeyCode(jfxsi.KeyCode.F17)
  val F18 = new KeyCode(jfxsi.KeyCode.F18)
  val F19 = new KeyCode(jfxsi.KeyCode.F19)
  val F20 = new KeyCode(jfxsi.KeyCode.F20)
  val F21 = new KeyCode(jfxsi.KeyCode.F21)
  val F22 = new KeyCode(jfxsi.KeyCode.F22)
  val F23 = new KeyCode(jfxsi.KeyCode.F23)
  val F24 = new KeyCode(jfxsi.KeyCode.F24)
  val Printscreen = new KeyCode(jfxsi.KeyCode.PRINTSCREEN)
  @deprecated ("Use Printscreen; PRINTSCREEN will be removed in a future release", "8.0.60-R10")
  val PRINTSCREEN = Printscreen

  val Insert = new KeyCode(jfxsi.KeyCode.INSERT)
  @deprecated ("Use Insert; INSERT will be removed in a future release", "8.0.60-R10")
  val INSERT = Insert

  val Help = new KeyCode(jfxsi.KeyCode.HELP)
  @deprecated ("Use Help; HELP will be removed in a future release", "8.0.60-R10")
  val HELP = Help

  val Meta = new KeyCode(jfxsi.KeyCode.META)
  @deprecated ("Use Meta; META will be removed in a future release", "8.0.60-R10")
  val META = Meta

  val BackQuote = new KeyCode(jfxsi.KeyCode.BACK_QUOTE)
  @deprecated ("Use BackQuote; BACK_QUOTE will be removed in a future release", "8.0.60-R10")
  val BACK_QUOTE = BackQuote

  val Quote = new KeyCode(jfxsi.KeyCode.QUOTE)
  @deprecated ("Use Quote; QUOTE will be removed in a future release", "8.0.60-R10")
  val QUOTE = Quote

  val KPUp = new KeyCode(jfxsi.KeyCode.KP_UP)
  @deprecated ("Use KPUp; KP_UP will be removed in a future release", "8.0.60-R10")
  val KP_UP = KPUp

  val KPDown = new KeyCode(jfxsi.KeyCode.KP_DOWN)
  @deprecated ("Use KPDown; KP_DOWN will be removed in a future release", "8.0.60-R10")
  val KP_DOWN = KPDown

  val KPLeft = new KeyCode(jfxsi.KeyCode.KP_LEFT)
  @deprecated ("Use KPLeft; KP_LEFT will be removed in a future release", "8.0.60-R10")
  val KP_LEFT = KPLeft

  val KPRight = new KeyCode(jfxsi.KeyCode.KP_RIGHT)
  @deprecated ("Use KPRight; KP_RIGHT will be removed in a future release", "8.0.60-R10")
  val KP_RIGHT = KPRight

  val DeadGrave = new KeyCode(jfxsi.KeyCode.DEAD_GRAVE)
  @deprecated ("Use DeadGrave; DEAD_GRAVE will be removed in a future release", "8.0.60-R10")
  val DEAD_GRAVE = DeadGrave

  val DeadAcute = new KeyCode(jfxsi.KeyCode.DEAD_ACUTE)
  @deprecated ("Use DeadAcute; DEAD_ACUTE will be removed in a future release", "8.0.60-R10")
  val DEAD_ACUTE = DeadAcute

  val DeadCircumflex = new KeyCode(jfxsi.KeyCode.DEAD_CIRCUMFLEX)
  @deprecated ("Use DeadCircumflex; DEAD_CIRCUMFLEX will be removed in a future release", "8.0.60-R10")
  val DEAD_CIRCUMFLEX = DeadCircumflex

  val DeadTilde = new KeyCode(jfxsi.KeyCode.DEAD_TILDE)
  @deprecated ("Use DeadTilde; DEAD_TILDE will be removed in a future release", "8.0.60-R10")
  val DEAD_TILDE = DeadTilde

  val DeadMacron = new KeyCode(jfxsi.KeyCode.DEAD_MACRON)
  @deprecated ("Use DeadMacron; DEAD_MACRON will be removed in a future release", "8.0.60-R10")
  val DEAD_MACRON = DeadMacron

  val DeadBreve = new KeyCode(jfxsi.KeyCode.DEAD_BREVE)
  @deprecated ("Use DeadBreve; DEAD_BREVE will be removed in a future release", "8.0.60-R10")
  val DEAD_BREVE = DeadBreve

  val DeadAbovedot = new KeyCode(jfxsi.KeyCode.DEAD_ABOVEDOT)
  @deprecated ("Use DeadAbovedot; DEAD_ABOVEDOT will be removed in a future release", "8.0.60-R10")
  val DEAD_ABOVEDOT = DeadAbovedot

  val DeadDiaeresis = new KeyCode(jfxsi.KeyCode.DEAD_DIAERESIS)
  @deprecated ("Use DeadDiaeresis; DEAD_DIAERESIS will be removed in a future release", "8.0.60-R10")
  val DEAD_DIAERESIS = DeadDiaeresis

  val DeadAbovering = new KeyCode(jfxsi.KeyCode.DEAD_ABOVERING)
  @deprecated ("Use DeadAbovering; DEAD_ABOVERING will be removed in a future release", "8.0.60-R10")
  val DEAD_ABOVERING = DeadAbovering

  val DeadDoubleacute = new KeyCode(jfxsi.KeyCode.DEAD_DOUBLEACUTE)
  @deprecated ("Use DeadDoubleacute; DEAD_DOUBLEACUTE will be removed in a future release", "8.0.60-R10")
  val DEAD_DOUBLEACUTE = DeadDoubleacute

  val DeadCaron = new KeyCode(jfxsi.KeyCode.DEAD_CARON)
  @deprecated ("Use DeadCaron; DEAD_CARON will be removed in a future release", "8.0.60-R10")
  val DEAD_CARON = DeadCaron

  val DeadCedilla = new KeyCode(jfxsi.KeyCode.DEAD_CEDILLA)
  @deprecated ("Use DeadCedilla; DEAD_CEDILLA will be removed in a future release", "8.0.60-R10")
  val DEAD_CEDILLA = DeadCedilla

  val DeadOgonek = new KeyCode(jfxsi.KeyCode.DEAD_OGONEK)
  @deprecated ("Use DeadOgonek; DEAD_OGONEK will be removed in a future release", "8.0.60-R10")
  val DEAD_OGONEK = DeadOgonek

  val DeadIota = new KeyCode(jfxsi.KeyCode.DEAD_IOTA)
  @deprecated ("Use DeadIota; DEAD_IOTA will be removed in a future release", "8.0.60-R10")
  val DEAD_IOTA = DeadIota

  val DeadVoicedSound = new KeyCode(jfxsi.KeyCode.DEAD_VOICED_SOUND)
  @deprecated ("Use DeadVoicedSound; DEAD_VOICED_SOUND will be removed in a future release", "8.0.60-R10")
  val DEAD_VOICED_SOUND = DeadVoicedSound

  val DeadSemivoicedSound = new KeyCode(jfxsi.KeyCode.DEAD_SEMIVOICED_SOUND)
  @deprecated ("Use DeadSemivoicedSound; DEAD_SEMIVOICED_SOUND will be removed in a future release", "8.0.60-R10")
  val DEAD_SEMIVOICED_SOUND = DeadSemivoicedSound

  val Ampersand = new KeyCode(jfxsi.KeyCode.AMPERSAND)
  @deprecated ("Use Ampersand; AMPERSAND will be removed in a future release", "8.0.60-R10")
  val AMPERSAND = Ampersand

  val Asterisk = new KeyCode(jfxsi.KeyCode.ASTERISK)
  @deprecated ("Use Asterisk; ASTERISK will be removed in a future release", "8.0.60-R10")
  val ASTERISK = Asterisk

  val Quotedbl = new KeyCode(jfxsi.KeyCode.QUOTEDBL)
  @deprecated ("Use Quotedbl; QUOTEDBL will be removed in a future release", "8.0.60-R10")
  val QUOTEDBL = Quotedbl

  val Less = new KeyCode(jfxsi.KeyCode.LESS)
  @deprecated ("Use Less; LESS will be removed in a future release", "8.0.60-R10")
  val LESS = Less

  val Greater = new KeyCode(jfxsi.KeyCode.GREATER)
  @deprecated ("Use Greater; GREATER will be removed in a future release", "8.0.60-R10")
  val GREATER = Greater

  val Braceleft = new KeyCode(jfxsi.KeyCode.BRACELEFT)
  @deprecated ("Use Braceleft; BRACELEFT will be removed in a future release", "8.0.60-R10")
  val BRACELEFT = Braceleft

  val Braceright = new KeyCode(jfxsi.KeyCode.BRACERIGHT)
  @deprecated ("Use Braceright; BRACERIGHT will be removed in a future release", "8.0.60-R10")
  val BRACERIGHT = Braceright

  val At = new KeyCode(jfxsi.KeyCode.AT)
  @deprecated ("Use At; AT will be removed in a future release", "8.0.60-R10")
  val AT = At

  val Colon = new KeyCode(jfxsi.KeyCode.COLON)
  @deprecated ("Use Colon; COLON will be removed in a future release", "8.0.60-R10")
  val COLON = Colon

  val Circumflex = new KeyCode(jfxsi.KeyCode.CIRCUMFLEX)
  @deprecated ("Use Circumflex; CIRCUMFLEX will be removed in a future release", "8.0.60-R10")
  val CIRCUMFLEX = Circumflex

  val Dollar = new KeyCode(jfxsi.KeyCode.DOLLAR)
  @deprecated ("Use Dollar; DOLLAR will be removed in a future release", "8.0.60-R10")
  val DOLLAR = Dollar

  val EuroSign = new KeyCode(jfxsi.KeyCode.EURO_SIGN)
  @deprecated ("Use EuroSign; EURO_SIGN will be removed in a future release", "8.0.60-R10")
  val EURO_SIGN = EuroSign

  val ExclamationMark = new KeyCode(jfxsi.KeyCode.EXCLAMATION_MARK)
  @deprecated ("Use ExclamationMark; EXCLAMATION_MARK will be removed in a future release", "8.0.60-R10")
  val EXCLAMATION_MARK = ExclamationMark

  val InvertedExclamationMark = new KeyCode(jfxsi.KeyCode.INVERTED_EXCLAMATION_MARK)
  @deprecated ("Use InvertedExclamationMark; INVERTED_EXCLAMATION_MARK will be removed in a future release", "8.0.60-R10")
  val INVERTED_EXCLAMATION_MARK = InvertedExclamationMark

  val LeftParenthesis = new KeyCode(jfxsi.KeyCode.LEFT_PARENTHESIS)
  @deprecated ("Use LeftParenthesis; LEFT_PARENTHESIS will be removed in a future release", "8.0.60-R10")
  val LEFT_PARENTHESIS = LeftParenthesis

  val NumberSign = new KeyCode(jfxsi.KeyCode.NUMBER_SIGN)
  @deprecated ("Use NumberSign; NUMBER_SIGN will be removed in a future release", "8.0.60-R10")
  val NUMBER_SIGN = NumberSign

  val Plus = new KeyCode(jfxsi.KeyCode.PLUS)
  @deprecated ("Use Plus; PLUS will be removed in a future release", "8.0.60-R10")
  val PLUS = Plus

  val RightParenthesis = new KeyCode(jfxsi.KeyCode.RIGHT_PARENTHESIS)
  @deprecated ("Use RightParenthesis; RIGHT_PARENTHESIS will be removed in a future release", "8.0.60-R10")
  val RIGHT_PARENTHESIS = RightParenthesis

  val Underscore = new KeyCode(jfxsi.KeyCode.UNDERSCORE)
  @deprecated ("Use Underscore; UNDERSCORE will be removed in a future release", "8.0.60-R10")
  val UNDERSCORE = Underscore

  val Windows = new KeyCode(jfxsi.KeyCode.WINDOWS)
  @deprecated ("Use Windows; WINDOWS will be removed in a future release", "8.0.60-R10")
  val WINDOWS = Windows

  val ContextMenu = new KeyCode(jfxsi.KeyCode.CONTEXT_MENU)
  @deprecated ("Use ContextMenu; CONTEXT_MENU will be removed in a future release", "8.0.60-R10")
  val CONTEXT_MENU = ContextMenu

  val Final = new KeyCode(jfxsi.KeyCode.FINAL)
  @deprecated ("Use Final; FINAL will be removed in a future release", "8.0.60-R10")
  val FINAL = Final

  val Convert = new KeyCode(jfxsi.KeyCode.CONVERT)
  @deprecated ("Use Convert; CONVERT will be removed in a future release", "8.0.60-R10")
  val CONVERT = Convert

  val Nonconvert = new KeyCode(jfxsi.KeyCode.NONCONVERT)
  @deprecated ("Use Nonconvert; NONCONVERT will be removed in a future release", "8.0.60-R10")
  val NONCONVERT = Nonconvert

  val Accept = new KeyCode(jfxsi.KeyCode.ACCEPT)
  @deprecated ("Use Accept; ACCEPT will be removed in a future release", "8.0.60-R10")
  val ACCEPT = Accept

  val Modechange = new KeyCode(jfxsi.KeyCode.MODECHANGE)
  @deprecated ("Use Modechange; MODECHANGE will be removed in a future release", "8.0.60-R10")
  val MODECHANGE = Modechange

  val Kana = new KeyCode(jfxsi.KeyCode.KANA)
  @deprecated ("Use Kana; KANA will be removed in a future release", "8.0.60-R10")
  val KANA = Kana

  val Kanji = new KeyCode(jfxsi.KeyCode.KANJI)
  @deprecated ("Use Kanji; KANJI will be removed in a future release", "8.0.60-R10")
  val KANJI = Kanji

  val Alphanumeric = new KeyCode(jfxsi.KeyCode.ALPHANUMERIC)
  @deprecated ("Use Alphanumeric; ALPHANUMERIC will be removed in a future release", "8.0.60-R10")
  val ALPHANUMERIC = Alphanumeric

  val Katakana = new KeyCode(jfxsi.KeyCode.KATAKANA)
  @deprecated ("Use Katakana; KATAKANA will be removed in a future release", "8.0.60-R10")
  val KATAKANA = Katakana

  val Hiragana = new KeyCode(jfxsi.KeyCode.HIRAGANA)
  @deprecated ("Use Hiragana; HIRAGANA will be removed in a future release", "8.0.60-R10")
  val HIRAGANA = Hiragana

  val FullWidth = new KeyCode(jfxsi.KeyCode.FULL_WIDTH)
  @deprecated ("Use FullWidth; FULL_WIDTH will be removed in a future release", "8.0.60-R10")
  val FULL_WIDTH = FullWidth

  val HalfWidth = new KeyCode(jfxsi.KeyCode.HALF_WIDTH)
  @deprecated ("Use HalfWidth; HALF_WIDTH will be removed in a future release", "8.0.60-R10")
  val HALF_WIDTH = HalfWidth

  val RomanCharacters = new KeyCode(jfxsi.KeyCode.ROMAN_CHARACTERS)
  @deprecated ("Use RomanCharacters; ROMAN_CHARACTERS will be removed in a future release", "8.0.60-R10")
  val ROMAN_CHARACTERS = RomanCharacters

  val AllCandidates = new KeyCode(jfxsi.KeyCode.ALL_CANDIDATES)
  @deprecated ("Use AllCandidates; ALL_CANDIDATES will be removed in a future release", "8.0.60-R10")
  val ALL_CANDIDATES = AllCandidates

  val PreviousCandidate = new KeyCode(jfxsi.KeyCode.PREVIOUS_CANDIDATE)
  @deprecated ("Use PreviousCandidate; PREVIOUS_CANDIDATE will be removed in a future release", "8.0.60-R10")
  val PREVIOUS_CANDIDATE = PreviousCandidate

  val CodeInput = new KeyCode(jfxsi.KeyCode.CODE_INPUT)
  @deprecated ("Use CodeInput; CODE_INPUT will be removed in a future release", "8.0.60-R10")
  val CODE_INPUT = CodeInput

  val JapaneseKatakana = new KeyCode(jfxsi.KeyCode.JAPANESE_KATAKANA)
  @deprecated ("Use JapaneseKatakana; JAPANESE_KATAKANA will be removed in a future release", "8.0.60-R10")
  val JAPANESE_KATAKANA = JapaneseKatakana

  val JapaneseHiragana = new KeyCode(jfxsi.KeyCode.JAPANESE_HIRAGANA)
  @deprecated ("Use JapaneseHiragana; JAPANESE_HIRAGANA will be removed in a future release", "8.0.60-R10")
  val JAPANESE_HIRAGANA = JapaneseHiragana

  val JapaneseRoman = new KeyCode(jfxsi.KeyCode.JAPANESE_ROMAN)
  @deprecated ("Use JapaneseRoman; JAPANESE_ROMAN will be removed in a future release", "8.0.60-R10")
  val JAPANESE_ROMAN = JapaneseRoman

  val KanaLock = new KeyCode(jfxsi.KeyCode.KANA_LOCK)
  @deprecated ("Use KanaLock; KANA_LOCK will be removed in a future release", "8.0.60-R10")
  val KANA_LOCK = KanaLock

  val InputMethodOnOff = new KeyCode(jfxsi.KeyCode.INPUT_METHOD_ON_OFF)
  @deprecated ("Use InputMethodOnOff; INPUT_METHOD_ON_OFF will be removed in a future release", "8.0.60-R10")
  val INPUT_METHOD_ON_OFF = InputMethodOnOff

  val Cut = new KeyCode(jfxsi.KeyCode.CUT)
  @deprecated ("Use Cut; CUT will be removed in a future release", "8.0.60-R10")
  val CUT = Cut

  val Copy = new KeyCode(jfxsi.KeyCode.COPY)
  @deprecated ("Use Copy; COPY will be removed in a future release", "8.0.60-R10")
  val COPY = Copy

  val Paste = new KeyCode(jfxsi.KeyCode.PASTE)
  @deprecated ("Use Paste; PASTE will be removed in a future release", "8.0.60-R10")
  val PASTE = Paste

  val Undo = new KeyCode(jfxsi.KeyCode.UNDO)
  @deprecated ("Use Undo; UNDO will be removed in a future release", "8.0.60-R10")
  val UNDO = Undo

  val Again = new KeyCode(jfxsi.KeyCode.AGAIN)
  @deprecated ("Use Again; AGAIN will be removed in a future release", "8.0.60-R10")
  val AGAIN = Again

  val Find = new KeyCode(jfxsi.KeyCode.FIND)
  @deprecated ("Use Find; FIND will be removed in a future release", "8.0.60-R10")
  val FIND = Find

  val Props = new KeyCode(jfxsi.KeyCode.PROPS)
  @deprecated ("Use Props; PROPS will be removed in a future release", "8.0.60-R10")
  val PROPS = Props

  val Stop = new KeyCode(jfxsi.KeyCode.STOP)
  @deprecated ("Use Stop; STOP will be removed in a future release", "8.0.60-R10")
  val STOP = Stop

  val Compose = new KeyCode(jfxsi.KeyCode.COMPOSE)
  @deprecated ("Use Compose; COMPOSE will be removed in a future release", "8.0.60-R10")
  val COMPOSE = Compose

  val AltGraph = new KeyCode(jfxsi.KeyCode.ALT_GRAPH)
  @deprecated ("Use AltGraph; ALT_GRAPH will be removed in a future release", "8.0.60-R10")
  val ALT_GRAPH = AltGraph

  val Begin = new KeyCode(jfxsi.KeyCode.BEGIN)
  @deprecated ("Use Begin; BEGIN will be removed in a future release", "8.0.60-R10")
  val BEGIN = Begin

  val Undefined = new KeyCode(jfxsi.KeyCode.UNDEFINED)
  @deprecated ("Use Undefined; UNDEFINED will be removed in a future release", "8.0.60-R10")
  val UNDEFINED = Undefined

  val Softkey0 = new KeyCode(jfxsi.KeyCode.SOFTKEY_0)
  @deprecated ("Use Softkey0; SOFTKEY_0 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_0 = Softkey0

  val Softkey1 = new KeyCode(jfxsi.KeyCode.SOFTKEY_1)
  @deprecated ("Use Softkey1; SOFTKEY_1 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_1 = Softkey1

  val Softkey2 = new KeyCode(jfxsi.KeyCode.SOFTKEY_2)
  @deprecated ("Use Softkey2; SOFTKEY_2 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_2 = Softkey2

  val Softkey3 = new KeyCode(jfxsi.KeyCode.SOFTKEY_3)
  @deprecated ("Use Softkey3; SOFTKEY_3 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_3 = Softkey3

  val Softkey4 = new KeyCode(jfxsi.KeyCode.SOFTKEY_4)
  @deprecated ("Use Softkey4; SOFTKEY_4 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_4 = Softkey4

  val Softkey5 = new KeyCode(jfxsi.KeyCode.SOFTKEY_5)
  @deprecated ("Use Softkey5; SOFTKEY_5 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_5 = Softkey5

  val Softkey6 = new KeyCode(jfxsi.KeyCode.SOFTKEY_6)
  @deprecated ("Use Softkey6; SOFTKEY_6 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_6 = Softkey6

  val Softkey7 = new KeyCode(jfxsi.KeyCode.SOFTKEY_7)
  @deprecated ("Use Softkey7; SOFTKEY_7 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_7 = Softkey7

  val Softkey8 = new KeyCode(jfxsi.KeyCode.SOFTKEY_8)
  @deprecated ("Use Softkey8; SOFTKEY_8 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_8 = Softkey8

  val Softkey9 = new KeyCode(jfxsi.KeyCode.SOFTKEY_9)
  @deprecated ("Use Softkey9; SOFTKEY_9 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_9 = Softkey9

  val GameA = new KeyCode(jfxsi.KeyCode.GAME_A)
  @deprecated ("Use GameA; GAME_A will be removed in a future release", "8.0.60-R10")
  val GAME_A = GameA

  val GameB = new KeyCode(jfxsi.KeyCode.GAME_B)
  @deprecated ("Use GameB; GAME_B will be removed in a future release", "8.0.60-R10")
  val GAME_B = GameB

  val GameC = new KeyCode(jfxsi.KeyCode.GAME_C)
  @deprecated ("Use GameC; GAME_C will be removed in a future release", "8.0.60-R10")
  val GAME_C = GameC

  val GameD = new KeyCode(jfxsi.KeyCode.GAME_D)
  @deprecated ("Use GameD; GAME_D will be removed in a future release", "8.0.60-R10")
  val GAME_D = GameD

  val Star = new KeyCode(jfxsi.KeyCode.STAR)
  @deprecated ("Use Star; STAR will be removed in a future release", "8.0.60-R10")
  val STAR = Star

  val Pound = new KeyCode(jfxsi.KeyCode.POUND)
  @deprecated ("Use Pound; POUND will be removed in a future release", "8.0.60-R10")
  val POUND = Pound

  val Power = new KeyCode(jfxsi.KeyCode.POWER)
  @deprecated ("Use Power; POWER will be removed in a future release", "8.0.60-R10")
  val POWER = Power

  val Info = new KeyCode(jfxsi.KeyCode.INFO)
  @deprecated ("Use Info; INFO will be removed in a future release", "8.0.60-R10")
  val INFO = Info

  val ColoredKey0 = new KeyCode(jfxsi.KeyCode.COLORED_KEY_0)
  @deprecated ("Use ColoredKey0; COLORED_KEY_0 will be removed in a future release", "8.0.60-R10")
  val COLORED_KEY_0 = ColoredKey0

  val ColoredKey1 = new KeyCode(jfxsi.KeyCode.COLORED_KEY_1)
  @deprecated ("Use ColoredKey1; COLORED_KEY_1 will be removed in a future release", "8.0.60-R10")
  val COLORED_KEY_1 = ColoredKey1

  val ColoredKey2 = new KeyCode(jfxsi.KeyCode.COLORED_KEY_2)
  @deprecated ("Use ColoredKey2; COLORED_KEY_2 will be removed in a future release", "8.0.60-R10")
  val COLORED_KEY_2 = ColoredKey2

  val ColoredKey3 = new KeyCode(jfxsi.KeyCode.COLORED_KEY_3)
  @deprecated ("Use ColoredKey3; COLORED_KEY_3 will be removed in a future release", "8.0.60-R10")
  val COLORED_KEY_3 = ColoredKey3

  val EjectToggle = new KeyCode(jfxsi.KeyCode.EJECT_TOGGLE)
  @deprecated ("Use EjectToggle; EJECT_TOGGLE will be removed in a future release", "8.0.60-R10")
  val EJECT_TOGGLE = EjectToggle

  val Play = new KeyCode(jfxsi.KeyCode.PLAY)
  @deprecated ("Use Play; PLAY will be removed in a future release", "8.0.60-R10")
  val PLAY = Play

  val Record = new KeyCode(jfxsi.KeyCode.RECORD)
  @deprecated ("Use Record; RECORD will be removed in a future release", "8.0.60-R10")
  val RECORD = Record

  val FastFwd = new KeyCode(jfxsi.KeyCode.FAST_FWD)
  @deprecated ("Use FastFwd; FAST_FWD will be removed in a future release", "8.0.60-R10")
  val FAST_FWD = FastFwd

  val Rewind = new KeyCode(jfxsi.KeyCode.REWIND)
  @deprecated ("Use Rewind; REWIND will be removed in a future release", "8.0.60-R10")
  val REWIND = Rewind

  val TrackPrev = new KeyCode(jfxsi.KeyCode.TRACK_PREV)
  @deprecated ("Use TrackPrev; TRACK_PREV will be removed in a future release", "8.0.60-R10")
  val TRACK_PREV = TrackPrev

  val TrackNext = new KeyCode(jfxsi.KeyCode.TRACK_NEXT)
  @deprecated ("Use TrackNext; TRACK_NEXT will be removed in a future release", "8.0.60-R10")
  val TRACK_NEXT = TrackNext

  val ChannelUp = new KeyCode(jfxsi.KeyCode.CHANNEL_UP)
  @deprecated ("Use ChannelUp; CHANNEL_UP will be removed in a future release", "8.0.60-R10")
  val CHANNEL_UP = ChannelUp

  val ChannelDown = new KeyCode(jfxsi.KeyCode.CHANNEL_DOWN)
  @deprecated ("Use ChannelDown; CHANNEL_DOWN will be removed in a future release", "8.0.60-R10")
  val CHANNEL_DOWN = ChannelDown

  val VolumeUp = new KeyCode(jfxsi.KeyCode.VOLUME_UP)
  @deprecated ("Use VolumeUp; VOLUME_UP will be removed in a future release", "8.0.60-R10")
  val VOLUME_UP = VolumeUp

  val VolumeDown = new KeyCode(jfxsi.KeyCode.VOLUME_DOWN)
  @deprecated ("Use VolumeDown; VOLUME_DOWN will be removed in a future release", "8.0.60-R10")
  val VOLUME_DOWN = VolumeDown

  val Mute = new KeyCode(jfxsi.KeyCode.MUTE)
  @deprecated ("Use Mute; MUTE will be removed in a future release", "8.0.60-R10")
  val MUTE = Mute

  val Command = new KeyCode(jfxsi.KeyCode.COMMAND)
  @deprecated ("Use Command; COMMAND will be removed in a future release", "8.0.60-R10")
  val COMMAND = Command

  val Shortcut = new KeyCode(jfxsi.KeyCode.SHORTCUT)
  @deprecated ("Use Shortcut; SHORTCUT will be removed in a future release", "8.0.60-R10")
  val SHORTCUT = Shortcut

  protected override def unsortedValues: Array[KeyCode] = Array(
    Enter, BackSpace, Tab, Cancel, Clear, Shift, Control, Alt, Pause, Caps, Escape, Space, PageUp, PageDown, End,
    Home, Left, Up, Right, Down, Comma, Minus, Period, Slash,
    Digit0, Digit1, Digit2, Digit3, Digit4, Digit5, Digit6, Digit7, Digit8, Digit9, Semicolon, Equals,
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
    OpenBracket, BackSlash, CloseBracket,
    Numpad0, Numpad1, Numpad2, Numpad3, Numpad4, Numpad5, Numpad6, Numpad7, Numpad8, Numpad9,
    Multiply, Add, Separator, Subtract, Decimal, Divide, Delete, NumLock, ScrollLock,
    F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19, F20, F21, F22, F23, F24,
    Printscreen, Insert, Help, Meta, BackQuote, Quote,
    KPUp, KPDown, KPLeft, KPRight,
    DeadGrave, DeadAcute, DeadCircumflex, DeadTilde, DeadMacron, DeadBreve, DeadAbovedot, DeadDiaeresis,
    DeadAbovering, DeadDoubleacute, DeadCaron, DeadCedilla, DeadOgonek, DeadIota, DeadVoicedSound,
    DeadSemivoicedSound, Ampersand, Asterisk, Quotedbl, Less, Greater, Braceleft, Braceright, At, Colon, Circumflex,
    Dollar, EuroSign, ExclamationMark, InvertedExclamationMark, LeftParenthesis, NumberSign, Plus,
    RightParenthesis, Underscore, Windows, ContextMenu, Final, Convert, Nonconvert, Accept, Modechange, Kana, Kanji,
    Alphanumeric, Katakana, Hiragana, FullWidth, HalfWidth, RomanCharacters, AllCandidates, PreviousCandidate,
    CodeInput, JapaneseKatakana, JapaneseHiragana, JapaneseRoman, KanaLock, InputMethodOnOff,
    Cut, Copy, Paste, Undo, Again, Find, Props, Stop, Compose, AltGraph, Begin, Undefined,
    Softkey0, Softkey1, Softkey2, Softkey3, Softkey4, Softkey5, Softkey6, Softkey7, Softkey8, Softkey9,
    GameA, GameB, GameC, GameD, Star, Pound, Power, Info,
    ColoredKey0, ColoredKey1, ColoredKey2, ColoredKey3,
    EjectToggle, Play, Record, FastFwd, Rewind, TrackPrev, TrackNext, ChannelUp, ChannelDown,
    VolumeUp, VolumeDown, Mute, Command, Shortcut
  )

  /** Parses textual representation of a key. */
  def keyCode(name: String): KeyCode = jfxsi.KeyCode.getKeyCode(name)
}


sealed case class KeyCode(override val delegate: jfxsi.KeyCode)
  extends SFXEnumDelegate[jfxsi.KeyCode] {

  /** Gets name of this key code. */
  def name: String = delegate.getName

  /** Left, right, up, down keys (including the keypad arrows) */
  def isArrowKey: Boolean = delegate.isArrowKey

  /** All Digit keys (including the keypad digits) */
  def isDigitKey: Boolean = delegate.isDigitKey

  /** Function keys like F1, F2, etc... */
  def isFunctionKey: Boolean = delegate.isFunctionKey

  /** All keys on the keypad */
  def isKeypadKey: Boolean = delegate.isKeypadKey

  /** All keys with letters */
  def isLetterKey: Boolean = delegate.isLetterKey

  /** All multimedia keys (channel up/down, volume control, etc...) */
  def isMediaKey: Boolean = delegate.isMediaKey

  /** Keys that could act as a modifier */
  def isModifierKey: Boolean = delegate.isModifierKey

  /** Navigation keys are arrow keys and Page Down, Page Up, Home, End (including keypad keys) */
  def isNavigationKey: Boolean = delegate.isNavigationKey

  /** Space, tab and enter */
  def isWhitespaceKey: Boolean = delegate.isWhitespaceKey
}
