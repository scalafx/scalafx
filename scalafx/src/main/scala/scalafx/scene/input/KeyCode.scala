/*
 * Copyright (c) 2011-2018, ScalaFX Project
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

  case object Enter extends KeyCode(jfxsi.KeyCode.ENTER)
  @deprecated ("Use Enter; ENTER will be removed in a future release", "8.0.60-R10")
  val ENTER = Enter

  case object BackSpace extends KeyCode(jfxsi.KeyCode.BACK_SPACE)
  @deprecated ("Use BackSpace; BACK_SPACE will be removed in a future release", "8.0.60-R10")
  val BACK_SPACE = BackSpace

  case object Tab extends KeyCode(jfxsi.KeyCode.TAB)
  @deprecated ("Use Tab; TAB will be removed in a future release", "8.0.60-R10")
  val TAB = Tab

  case object Cancel extends KeyCode(jfxsi.KeyCode.CANCEL)
  @deprecated ("Use Cancel; CANCEL will be removed in a future release", "8.0.60-R10")
  val CANCEL = Cancel

  case object Clear extends KeyCode(jfxsi.KeyCode.CLEAR)
  @deprecated ("Use Clear; CLEAR will be removed in a future release", "8.0.60-R10")
  val CLEAR = Clear

  case object Shift extends KeyCode(jfxsi.KeyCode.SHIFT)
  @deprecated ("Use Shift; SHIFT will be removed in a future release", "8.0.60-R10")
  val SHIFT = Shift

  case object Control extends KeyCode(jfxsi.KeyCode.CONTROL)
  @deprecated ("Use Control; CONTROL will be removed in a future release", "8.0.60-R10")
  val CONTROL = Control

  case object Alt extends KeyCode(jfxsi.KeyCode.ALT)
  @deprecated ("Use Alt; ALT will be removed in a future release", "8.0.60-R10")
  val ALT = Alt

  case object Pause extends KeyCode(jfxsi.KeyCode.PAUSE)
  @deprecated ("Use Pause; PAUSE will be removed in a future release", "8.0.60-R10")
  val PAUSE = Pause

  case object Caps extends KeyCode(jfxsi.KeyCode.CAPS)
  @deprecated ("Use Caps; CAPS will be removed in a future release", "8.0.60-R10")
  val CAPS = Caps

  case object Escape extends KeyCode(jfxsi.KeyCode.ESCAPE)
  @deprecated ("Use Escape; ESCAPE will be removed in a future release", "8.0.60-R10")
  val ESCAPE = Escape

  case object Space extends KeyCode(jfxsi.KeyCode.SPACE)
  @deprecated ("Use Space; SPACE will be removed in a future release", "8.0.60-R10")
  val SPACE = Space

  case object PageUp extends KeyCode(jfxsi.KeyCode.PAGE_UP)
  @deprecated ("Use PageUp; PAGE_UP will be removed in a future release", "8.0.60-R10")
  val PAGE_UP = PageUp

  case object PageDown extends KeyCode(jfxsi.KeyCode.PAGE_DOWN)
  @deprecated ("Use PageDown; PAGE_DOWN will be removed in a future release", "8.0.60-R10")
  val PAGE_DOWN = PageDown

  case object End extends KeyCode(jfxsi.KeyCode.END)
  @deprecated ("Use End; END will be removed in a future release", "8.0.60-R10")
  val END = End

  case object Home extends KeyCode(jfxsi.KeyCode.HOME)
  @deprecated ("Use Home; HOME will be removed in a future release", "8.0.60-R10")
  val HOME = Home

  case object Left extends KeyCode(jfxsi.KeyCode.LEFT)
  @deprecated ("Use Left; LEFT will be removed in a future release", "8.0.60-R10")
  val LEFT = Left

  case object Up extends KeyCode(jfxsi.KeyCode.UP)
  @deprecated ("Use Up; UP will be removed in a future release", "8.0.60-R10")
  val UP = Up

  case object Right extends KeyCode(jfxsi.KeyCode.RIGHT)
  @deprecated ("Use Right; RIGHT will be removed in a future release", "8.0.60-R10")
  val RIGHT = Right

  case object Down extends KeyCode(jfxsi.KeyCode.DOWN)
  @deprecated ("Use Down; DOWN will be removed in a future release", "8.0.60-R10")
  val DOWN = Down

  case object Comma extends KeyCode(jfxsi.KeyCode.COMMA)
  @deprecated ("Use Comma; COMMA will be removed in a future release", "8.0.60-R10")
  val COMMA = Comma

  case object Minus extends KeyCode(jfxsi.KeyCode.MINUS)
  @deprecated ("Use Minus; MINUS will be removed in a future release", "8.0.60-R10")
  val MINUS = Minus

  case object Period extends KeyCode(jfxsi.KeyCode.PERIOD)
  @deprecated ("Use Period; PERIOD will be removed in a future release", "8.0.60-R10")
  val PERIOD = Period

  case object Slash extends KeyCode(jfxsi.KeyCode.SLASH)
  @deprecated ("Use Slash; SLASH will be removed in a future release", "8.0.60-R10")
  val SLASH = Slash

  case object Digit0 extends KeyCode(jfxsi.KeyCode.DIGIT0)
  @deprecated ("Use Digit0; DIGIT0 will be removed in a future release", "8.0.60-R10")
  val DIGIT0 = Digit0

  case object Digit1 extends KeyCode(jfxsi.KeyCode.DIGIT1)
  @deprecated ("Use Digit1; DIGIT1 will be removed in a future release", "8.0.60-R10")
  val DIGIT1 = Digit1

  case object Digit2 extends KeyCode(jfxsi.KeyCode.DIGIT2)
  @deprecated ("Use Digit2; DIGIT2 will be removed in a future release", "8.0.60-R10")
  val DIGIT2 = Digit2

  case object Digit3 extends KeyCode(jfxsi.KeyCode.DIGIT3)
  @deprecated ("Use Digit3; DIGIT3 will be removed in a future release", "8.0.60-R10")
  val DIGIT3 = Digit3

  case object Digit4 extends KeyCode(jfxsi.KeyCode.DIGIT4)
  @deprecated ("Use Digit4; DIGIT4 will be removed in a future release", "8.0.60-R10")
  val DIGIT4 = Digit4

  case object Digit5 extends KeyCode(jfxsi.KeyCode.DIGIT5)
  @deprecated ("Use Digit5; DIGIT5 will be removed in a future release", "8.0.60-R10")
  val DIGIT5 = Digit5

  case object Digit6 extends KeyCode(jfxsi.KeyCode.DIGIT6)
  @deprecated ("Use Digit6; DIGIT6 will be removed in a future release", "8.0.60-R10")
  val DIGIT6 = Digit6

  case object Digit7 extends KeyCode(jfxsi.KeyCode.DIGIT7)
  @deprecated ("Use Digit7; DIGIT7 will be removed in a future release", "8.0.60-R10")
  val DIGIT7 = Digit7

  case object Digit8 extends KeyCode(jfxsi.KeyCode.DIGIT8)
  @deprecated ("Use Digit8; DIGIT8 will be removed in a future release", "8.0.60-R10")
  val DIGIT8 = Digit8

  case object Digit9 extends KeyCode(jfxsi.KeyCode.DIGIT9)
  @deprecated ("Use Digit9; DIGIT9 will be removed in a future release", "8.0.60-R10")
  val DIGIT9 = Digit9

  case object Semicolon extends KeyCode(jfxsi.KeyCode.SEMICOLON)
  @deprecated ("Use Semicolon; SEMICOLON will be removed in a future release", "8.0.60-R10")
  val SEMICOLON = Semicolon

  case object Equals extends KeyCode(jfxsi.KeyCode.EQUALS)
  @deprecated ("Use Equals; EQUALS will be removed in a future release", "8.0.60-R10")
  val EQUALS = Equals

  case object A extends KeyCode(jfxsi.KeyCode.A)

  case object B extends KeyCode(jfxsi.KeyCode.B)

  case object C extends KeyCode(jfxsi.KeyCode.C)

  case object D extends KeyCode(jfxsi.KeyCode.D)

  case object E extends KeyCode(jfxsi.KeyCode.E)

  case object F extends KeyCode(jfxsi.KeyCode.F)

  case object G extends KeyCode(jfxsi.KeyCode.G)

  case object H extends KeyCode(jfxsi.KeyCode.H)

  case object I extends KeyCode(jfxsi.KeyCode.I)

  case object J extends KeyCode(jfxsi.KeyCode.J)

  case object K extends KeyCode(jfxsi.KeyCode.K)

  case object L extends KeyCode(jfxsi.KeyCode.L)

  case object M extends KeyCode(jfxsi.KeyCode.M)

  case object N extends KeyCode(jfxsi.KeyCode.N)

  case object O extends KeyCode(jfxsi.KeyCode.O)

  case object P extends KeyCode(jfxsi.KeyCode.P)

  case object Q extends KeyCode(jfxsi.KeyCode.Q)

  case object R extends KeyCode(jfxsi.KeyCode.R)

  case object S extends KeyCode(jfxsi.KeyCode.S)

  case object T extends KeyCode(jfxsi.KeyCode.T)

  case object U extends KeyCode(jfxsi.KeyCode.U)

  case object V extends KeyCode(jfxsi.KeyCode.V)

  case object W extends KeyCode(jfxsi.KeyCode.W)

  case object X extends KeyCode(jfxsi.KeyCode.X)

  case object Y extends KeyCode(jfxsi.KeyCode.Y)

  case object Z extends KeyCode(jfxsi.KeyCode.Z)

  case object OpenBracket extends KeyCode(jfxsi.KeyCode.OPEN_BRACKET)
  @deprecated ("Use OpenBracket; OPEN_BRACKET will be removed in a future release", "8.0.60-R10")
  val OPEN_BRACKET = OpenBracket

  case object BackSlash extends KeyCode(jfxsi.KeyCode.BACK_SLASH)
  @deprecated ("Use BackSlash; BACK_SLASH will be removed in a future release", "8.0.60-R10")
  val BACK_SLASH = BackSlash

  case object CloseBracket extends KeyCode(jfxsi.KeyCode.CLOSE_BRACKET)
  @deprecated ("Use CloseBracket; CLOSE_BRACKET will be removed in a future release", "8.0.60-R10")
  val CLOSE_BRACKET = CloseBracket

  case object Numpad0 extends KeyCode(jfxsi.KeyCode.NUMPAD0)
  @deprecated ("Use Numpad0; NUMPAD0 will be removed in a future release", "8.0.60-R10")
  val NUMPAD0 = Numpad0

  case object Numpad1 extends KeyCode(jfxsi.KeyCode.NUMPAD1)
  @deprecated ("Use Numpad1; NUMPAD1 will be removed in a future release", "8.0.60-R10")
  val NUMPAD1 = Numpad1

  case object Numpad2 extends KeyCode(jfxsi.KeyCode.NUMPAD2)
  @deprecated ("Use Numpad2; NUMPAD2 will be removed in a future release", "8.0.60-R10")
  val NUMPAD2 = Numpad2

  case object Numpad3 extends KeyCode(jfxsi.KeyCode.NUMPAD3)
  @deprecated ("Use Numpad3; NUMPAD3 will be removed in a future release", "8.0.60-R10")
  val NUMPAD3 = Numpad3

  case object Numpad4 extends KeyCode(jfxsi.KeyCode.NUMPAD4)
  @deprecated ("Use Numpad4; NUMPAD4 will be removed in a future release", "8.0.60-R10")
  val NUMPAD4 = Numpad4

  case object Numpad5 extends KeyCode(jfxsi.KeyCode.NUMPAD5)
  @deprecated ("Use Numpad5; NUMPAD5 will be removed in a future release", "8.0.60-R10")
  val NUMPAD5 = Numpad5

  case object Numpad6 extends KeyCode(jfxsi.KeyCode.NUMPAD6)
  @deprecated ("Use Numpad6; NUMPAD6 will be removed in a future release", "8.0.60-R10")
  val NUMPAD6 = Numpad6

  case object Numpad7 extends KeyCode(jfxsi.KeyCode.NUMPAD7)
  @deprecated ("Use Numpad7; NUMPAD7 will be removed in a future release", "8.0.60-R10")
  val NUMPAD7 = Numpad7

  case object Numpad8 extends KeyCode(jfxsi.KeyCode.NUMPAD8)
  @deprecated ("Use Numpad8; NUMPAD8 will be removed in a future release", "8.0.60-R10")
  val NUMPAD8 = Numpad8

  case object Numpad9 extends KeyCode(jfxsi.KeyCode.NUMPAD9)
  @deprecated ("Use Numpad9; NUMPAD9 will be removed in a future release", "8.0.60-R10")
  val NUMPAD9 = Numpad9

  case object Multiply extends KeyCode(jfxsi.KeyCode.MULTIPLY)
  @deprecated ("Use Multiply; MULTIPLY will be removed in a future release", "8.0.60-R10")
  val MULTIPLY = Multiply

  case object Add extends KeyCode(jfxsi.KeyCode.ADD)
  @deprecated ("Use Add; ADD will be removed in a future release", "8.0.60-R10")
  val ADD = Add

  case object Separator extends KeyCode(jfxsi.KeyCode.SEPARATOR)
  @deprecated ("Use Separator; SEPARATOR will be removed in a future release", "8.0.60-R10")
  val SEPARATOR = Separator

  case object Subtract extends KeyCode(jfxsi.KeyCode.SUBTRACT)
  @deprecated ("Use Subtract; SUBTRACT will be removed in a future release", "8.0.60-R10")
  val SUBTRACT = Subtract

  case object Decimal extends KeyCode(jfxsi.KeyCode.DECIMAL)
  @deprecated ("Use Decimal; DECIMAL will be removed in a future release", "8.0.60-R10")
  val DECIMAL = Decimal

  case object Divide extends KeyCode(jfxsi.KeyCode.DIVIDE)
  @deprecated ("Use Divide; DIVIDE will be removed in a future release", "8.0.60-R10")
  val DIVIDE = Divide

  case object Delete extends KeyCode(jfxsi.KeyCode.DELETE)
  @deprecated ("Use Delete; DELETE will be removed in a future release", "8.0.60-R10")
  val DELETE = Delete

  case object NumLock extends KeyCode(jfxsi.KeyCode.NUM_LOCK)
  @deprecated ("Use NumLock; NUM_LOCK will be removed in a future release", "8.0.60-R10")
  val NUM_LOCK = NumLock

  case object ScrollLock extends KeyCode(jfxsi.KeyCode.SCROLL_LOCK)
  @deprecated ("Use ScrollLock; SCROLL_LOCK will be removed in a future release", "8.0.60-R10")
  val SCROLL_LOCK = ScrollLock

  case object F1 extends KeyCode(jfxsi.KeyCode.F1)

  case object F2 extends KeyCode(jfxsi.KeyCode.F2)

  case object F3 extends KeyCode(jfxsi.KeyCode.F3)

  case object F4 extends KeyCode(jfxsi.KeyCode.F4)

  case object F5 extends KeyCode(jfxsi.KeyCode.F5)

  case object F6 extends KeyCode(jfxsi.KeyCode.F6)

  case object F7 extends KeyCode(jfxsi.KeyCode.F7)

  case object F8 extends KeyCode(jfxsi.KeyCode.F8)

  case object F9 extends KeyCode(jfxsi.KeyCode.F9)

  case object F10 extends KeyCode(jfxsi.KeyCode.F10)

  case object F11 extends KeyCode(jfxsi.KeyCode.F11)

  case object F12 extends KeyCode(jfxsi.KeyCode.F12)

  case object F13 extends KeyCode(jfxsi.KeyCode.F13)

  case object F14 extends KeyCode(jfxsi.KeyCode.F14)

  case object F15 extends KeyCode(jfxsi.KeyCode.F15)

  case object F16 extends KeyCode(jfxsi.KeyCode.F16)

  case object F17 extends KeyCode(jfxsi.KeyCode.F17)

  case object F18 extends KeyCode(jfxsi.KeyCode.F18)

  case object F19 extends KeyCode(jfxsi.KeyCode.F19)

  case object F20 extends KeyCode(jfxsi.KeyCode.F20)

  case object F21 extends KeyCode(jfxsi.KeyCode.F21)

  case object F22 extends KeyCode(jfxsi.KeyCode.F22)

  case object F23 extends KeyCode(jfxsi.KeyCode.F23)

  case object F24 extends KeyCode(jfxsi.KeyCode.F24)

  case object Printscreen extends KeyCode(jfxsi.KeyCode.PRINTSCREEN)
  @deprecated ("Use Printscreen; PRINTSCREEN will be removed in a future release", "8.0.60-R10")
  val PRINTSCREEN = Printscreen

  case object Insert extends KeyCode(jfxsi.KeyCode.INSERT)
  @deprecated ("Use Insert; INSERT will be removed in a future release", "8.0.60-R10")
  val INSERT = Insert

  case object Help extends KeyCode(jfxsi.KeyCode.HELP)
  @deprecated ("Use Help; HELP will be removed in a future release", "8.0.60-R10")
  val HELP = Help

  case object Meta extends KeyCode(jfxsi.KeyCode.META)
  @deprecated ("Use Meta; META will be removed in a future release", "8.0.60-R10")
  val META = Meta

  case object BackQuote extends KeyCode(jfxsi.KeyCode.BACK_QUOTE)
  @deprecated ("Use BackQuote; BACK_QUOTE will be removed in a future release", "8.0.60-R10")
  val BACK_QUOTE = BackQuote

  case object Quote extends KeyCode(jfxsi.KeyCode.QUOTE)
  @deprecated ("Use Quote; QUOTE will be removed in a future release", "8.0.60-R10")
  val QUOTE = Quote

  case object KPUp extends KeyCode(jfxsi.KeyCode.KP_UP)
  @deprecated ("Use KPUp; KP_UP will be removed in a future release", "8.0.60-R10")
  val KP_UP = KPUp

  case object KPDown extends KeyCode(jfxsi.KeyCode.KP_DOWN)
  @deprecated ("Use KPDown; KP_DOWN will be removed in a future release", "8.0.60-R10")
  val KP_DOWN = KPDown

  case object KPLeft extends KeyCode(jfxsi.KeyCode.KP_LEFT)
  @deprecated ("Use KPLeft; KP_LEFT will be removed in a future release", "8.0.60-R10")
  val KP_LEFT = KPLeft

  case object KPRight extends KeyCode(jfxsi.KeyCode.KP_RIGHT)
  @deprecated ("Use KPRight; KP_RIGHT will be removed in a future release", "8.0.60-R10")
  val KP_RIGHT = KPRight

  case object DeadGrave extends KeyCode(jfxsi.KeyCode.DEAD_GRAVE)
  @deprecated ("Use DeadGrave; DEAD_GRAVE will be removed in a future release", "8.0.60-R10")
  val DEAD_GRAVE = DeadGrave

  case object DeadAcute extends KeyCode(jfxsi.KeyCode.DEAD_ACUTE)
  @deprecated ("Use DeadAcute; DEAD_ACUTE will be removed in a future release", "8.0.60-R10")
  val DEAD_ACUTE = DeadAcute

  case object DeadCircumflex extends KeyCode(jfxsi.KeyCode.DEAD_CIRCUMFLEX)
  @deprecated ("Use DeadCircumflex; DEAD_CIRCUMFLEX will be removed in a future release", "8.0.60-R10")
  val DEAD_CIRCUMFLEX = DeadCircumflex

  case object DeadTilde extends KeyCode(jfxsi.KeyCode.DEAD_TILDE)
  @deprecated ("Use DeadTilde; DEAD_TILDE will be removed in a future release", "8.0.60-R10")
  val DEAD_TILDE = DeadTilde

  case object DeadMacron extends KeyCode(jfxsi.KeyCode.DEAD_MACRON)
  @deprecated ("Use DeadMacron; DEAD_MACRON will be removed in a future release", "8.0.60-R10")
  val DEAD_MACRON = DeadMacron

  case object DeadBreve extends KeyCode(jfxsi.KeyCode.DEAD_BREVE)
  @deprecated ("Use DeadBreve; DEAD_BREVE will be removed in a future release", "8.0.60-R10")
  val DEAD_BREVE = DeadBreve

  case object DeadAbovedot extends KeyCode(jfxsi.KeyCode.DEAD_ABOVEDOT)
  @deprecated ("Use DeadAbovedot; DEAD_ABOVEDOT will be removed in a future release", "8.0.60-R10")
  val DEAD_ABOVEDOT = DeadAbovedot

  case object DeadDiaeresis extends KeyCode(jfxsi.KeyCode.DEAD_DIAERESIS)
  @deprecated ("Use DeadDiaeresis; DEAD_DIAERESIS will be removed in a future release", "8.0.60-R10")
  val DEAD_DIAERESIS = DeadDiaeresis

  case object DeadAbovering extends KeyCode(jfxsi.KeyCode.DEAD_ABOVERING)
  @deprecated ("Use DeadAbovering; DEAD_ABOVERING will be removed in a future release", "8.0.60-R10")
  val DEAD_ABOVERING = DeadAbovering

  case object DeadDoubleacute extends KeyCode(jfxsi.KeyCode.DEAD_DOUBLEACUTE)
  @deprecated ("Use DeadDoubleacute; DEAD_DOUBLEACUTE will be removed in a future release", "8.0.60-R10")
  val DEAD_DOUBLEACUTE = DeadDoubleacute

  case object DeadCaron extends KeyCode(jfxsi.KeyCode.DEAD_CARON)
  @deprecated ("Use DeadCaron; DEAD_CARON will be removed in a future release", "8.0.60-R10")
  val DEAD_CARON = DeadCaron

  case object DeadCedilla extends KeyCode(jfxsi.KeyCode.DEAD_CEDILLA)
  @deprecated ("Use DeadCedilla; DEAD_CEDILLA will be removed in a future release", "8.0.60-R10")
  val DEAD_CEDILLA = DeadCedilla

  case object DeadOgonek extends KeyCode(jfxsi.KeyCode.DEAD_OGONEK)
  @deprecated ("Use DeadOgonek; DEAD_OGONEK will be removed in a future release", "8.0.60-R10")
  val DEAD_OGONEK = DeadOgonek

  case object DeadIota extends KeyCode(jfxsi.KeyCode.DEAD_IOTA)
  @deprecated ("Use DeadIota; DEAD_IOTA will be removed in a future release", "8.0.60-R10")
  val DEAD_IOTA = DeadIota

  case object DeadVoicedSound extends KeyCode(jfxsi.KeyCode.DEAD_VOICED_SOUND)
  @deprecated ("Use DeadVoicedSound; DEAD_VOICED_SOUND will be removed in a future release", "8.0.60-R10")
  val DEAD_VOICED_SOUND = DeadVoicedSound

  case object DeadSemivoicedSound extends KeyCode(jfxsi.KeyCode.DEAD_SEMIVOICED_SOUND)
  @deprecated ("Use DeadSemivoicedSound; DEAD_SEMIVOICED_SOUND will be removed in a future release", "8.0.60-R10")
  val DEAD_SEMIVOICED_SOUND = DeadSemivoicedSound

  case object Ampersand extends KeyCode(jfxsi.KeyCode.AMPERSAND)
  @deprecated ("Use Ampersand; AMPERSAND will be removed in a future release", "8.0.60-R10")
  val AMPERSAND = Ampersand

  case object Asterisk extends KeyCode(jfxsi.KeyCode.ASTERISK)
  @deprecated ("Use Asterisk; ASTERISK will be removed in a future release", "8.0.60-R10")
  val ASTERISK = Asterisk

  case object Quotedbl extends KeyCode(jfxsi.KeyCode.QUOTEDBL)
  @deprecated ("Use Quotedbl; QUOTEDBL will be removed in a future release", "8.0.60-R10")
  val QUOTEDBL = Quotedbl

  case object Less extends KeyCode(jfxsi.KeyCode.LESS)
  @deprecated ("Use Less; LESS will be removed in a future release", "8.0.60-R10")
  val LESS = Less

  case object Greater extends KeyCode(jfxsi.KeyCode.GREATER)
  @deprecated ("Use Greater; GREATER will be removed in a future release", "8.0.60-R10")
  val GREATER = Greater

  case object Braceleft extends KeyCode(jfxsi.KeyCode.BRACELEFT)
  @deprecated ("Use Braceleft; BRACELEFT will be removed in a future release", "8.0.60-R10")
  val BRACELEFT = Braceleft

  case object Braceright extends KeyCode(jfxsi.KeyCode.BRACERIGHT)
  @deprecated ("Use Braceright; BRACERIGHT will be removed in a future release", "8.0.60-R10")
  val BRACERIGHT = Braceright

  case object At extends KeyCode(jfxsi.KeyCode.AT)
  @deprecated ("Use At; AT will be removed in a future release", "8.0.60-R10")
  val AT = At

  case object Colon extends KeyCode(jfxsi.KeyCode.COLON)
  @deprecated ("Use Colon; COLON will be removed in a future release", "8.0.60-R10")
  val COLON = Colon

  case object Circumflex extends KeyCode(jfxsi.KeyCode.CIRCUMFLEX)
  @deprecated ("Use Circumflex; CIRCUMFLEX will be removed in a future release", "8.0.60-R10")
  val CIRCUMFLEX = Circumflex

  case object Dollar extends KeyCode(jfxsi.KeyCode.DOLLAR)
  @deprecated ("Use Dollar; DOLLAR will be removed in a future release", "8.0.60-R10")
  val DOLLAR = Dollar

  case object EuroSign extends KeyCode(jfxsi.KeyCode.EURO_SIGN)
  @deprecated ("Use EuroSign; EURO_SIGN will be removed in a future release", "8.0.60-R10")
  val EURO_SIGN = EuroSign

  case object ExclamationMark extends KeyCode(jfxsi.KeyCode.EXCLAMATION_MARK)
  @deprecated ("Use ExclamationMark; EXCLAMATION_MARK will be removed in a future release", "8.0.60-R10")
  val EXCLAMATION_MARK = ExclamationMark

  case object InvertedExclamationMark extends KeyCode(jfxsi.KeyCode.INVERTED_EXCLAMATION_MARK)
  @deprecated ("Use InvertedExclamationMark; INVERTED_EXCLAMATION_MARK will be removed in a future release", "8.0.60-R10")
  val INVERTED_EXCLAMATION_MARK = InvertedExclamationMark

  case object LeftParenthesis extends KeyCode(jfxsi.KeyCode.LEFT_PARENTHESIS)
  @deprecated ("Use LeftParenthesis; LEFT_PARENTHESIS will be removed in a future release", "8.0.60-R10")
  val LEFT_PARENTHESIS = LeftParenthesis

  case object NumberSign extends KeyCode(jfxsi.KeyCode.NUMBER_SIGN)
  @deprecated ("Use NumberSign; NUMBER_SIGN will be removed in a future release", "8.0.60-R10")
  val NUMBER_SIGN = NumberSign

  case object Plus extends KeyCode(jfxsi.KeyCode.PLUS)
  @deprecated ("Use Plus; PLUS will be removed in a future release", "8.0.60-R10")
  val PLUS = Plus

  case object RightParenthesis extends KeyCode(jfxsi.KeyCode.RIGHT_PARENTHESIS)
  @deprecated ("Use RightParenthesis; RIGHT_PARENTHESIS will be removed in a future release", "8.0.60-R10")
  val RIGHT_PARENTHESIS = RightParenthesis

  case object Underscore extends KeyCode(jfxsi.KeyCode.UNDERSCORE)
  @deprecated ("Use Underscore; UNDERSCORE will be removed in a future release", "8.0.60-R10")
  val UNDERSCORE = Underscore

  case object Windows extends KeyCode(jfxsi.KeyCode.WINDOWS)
  @deprecated ("Use Windows; WINDOWS will be removed in a future release", "8.0.60-R10")
  val WINDOWS = Windows

  case object ContextMenu extends KeyCode(jfxsi.KeyCode.CONTEXT_MENU)
  @deprecated ("Use ContextMenu; CONTEXT_MENU will be removed in a future release", "8.0.60-R10")
  val CONTEXT_MENU = ContextMenu

  case object Final extends KeyCode(jfxsi.KeyCode.FINAL)
  @deprecated ("Use Final; FINAL will be removed in a future release", "8.0.60-R10")
  val FINAL = Final

  case object Convert extends KeyCode(jfxsi.KeyCode.CONVERT)
  @deprecated ("Use Convert; CONVERT will be removed in a future release", "8.0.60-R10")
  val CONVERT = Convert

  case object Nonconvert extends KeyCode(jfxsi.KeyCode.NONCONVERT)
  @deprecated ("Use Nonconvert; NONCONVERT will be removed in a future release", "8.0.60-R10")
  val NONCONVERT = Nonconvert

  case object Accept extends KeyCode(jfxsi.KeyCode.ACCEPT)
  @deprecated ("Use Accept; ACCEPT will be removed in a future release", "8.0.60-R10")
  val ACCEPT = Accept

  case object Modechange extends KeyCode(jfxsi.KeyCode.MODECHANGE)
  @deprecated ("Use Modechange; MODECHANGE will be removed in a future release", "8.0.60-R10")
  val MODECHANGE = Modechange

  case object Kana extends KeyCode(jfxsi.KeyCode.KANA)
  @deprecated ("Use Kana; KANA will be removed in a future release", "8.0.60-R10")
  val KANA = Kana

  case object Kanji extends KeyCode(jfxsi.KeyCode.KANJI)
  @deprecated ("Use Kanji; KANJI will be removed in a future release", "8.0.60-R10")
  val KANJI = Kanji

  case object Alphanumeric extends KeyCode(jfxsi.KeyCode.ALPHANUMERIC)
  @deprecated ("Use Alphanumeric; ALPHANUMERIC will be removed in a future release", "8.0.60-R10")
  val ALPHANUMERIC = Alphanumeric

  case object Katakana extends KeyCode(jfxsi.KeyCode.KATAKANA)
  @deprecated ("Use Katakana; KATAKANA will be removed in a future release", "8.0.60-R10")
  val KATAKANA = Katakana

  case object Hiragana extends KeyCode(jfxsi.KeyCode.HIRAGANA)
  @deprecated ("Use Hiragana; HIRAGANA will be removed in a future release", "8.0.60-R10")
  val HIRAGANA = Hiragana

  case object FullWidth extends KeyCode(jfxsi.KeyCode.FULL_WIDTH)
  @deprecated ("Use FullWidth; FULL_WIDTH will be removed in a future release", "8.0.60-R10")
  val FULL_WIDTH = FullWidth

  case object HalfWidth extends KeyCode(jfxsi.KeyCode.HALF_WIDTH)
  @deprecated ("Use HalfWidth; HALF_WIDTH will be removed in a future release", "8.0.60-R10")
  val HALF_WIDTH = HalfWidth

  case object RomanCharacters extends KeyCode(jfxsi.KeyCode.ROMAN_CHARACTERS)
  @deprecated ("Use RomanCharacters; ROMAN_CHARACTERS will be removed in a future release", "8.0.60-R10")
  val ROMAN_CHARACTERS = RomanCharacters

  case object AllCandidates extends KeyCode(jfxsi.KeyCode.ALL_CANDIDATES)
  @deprecated ("Use AllCandidates; ALL_CANDIDATES will be removed in a future release", "8.0.60-R10")
  val ALL_CANDIDATES = AllCandidates

  case object PreviousCandidate extends KeyCode(jfxsi.KeyCode.PREVIOUS_CANDIDATE)
  @deprecated ("Use PreviousCandidate; PREVIOUS_CANDIDATE will be removed in a future release", "8.0.60-R10")
  val PREVIOUS_CANDIDATE = PreviousCandidate

  case object CodeInput extends KeyCode(jfxsi.KeyCode.CODE_INPUT)
  @deprecated ("Use CodeInput; CODE_INPUT will be removed in a future release", "8.0.60-R10")
  val CODE_INPUT = CodeInput

  case object JapaneseKatakana extends KeyCode(jfxsi.KeyCode.JAPANESE_KATAKANA)
  @deprecated ("Use JapaneseKatakana; JAPANESE_KATAKANA will be removed in a future release", "8.0.60-R10")
  val JAPANESE_KATAKANA = JapaneseKatakana

  case object JapaneseHiragana extends KeyCode(jfxsi.KeyCode.JAPANESE_HIRAGANA)
  @deprecated ("Use JapaneseHiragana; JAPANESE_HIRAGANA will be removed in a future release", "8.0.60-R10")
  val JAPANESE_HIRAGANA = JapaneseHiragana

  case object JapaneseRoman extends KeyCode(jfxsi.KeyCode.JAPANESE_ROMAN)
  @deprecated ("Use JapaneseRoman; JAPANESE_ROMAN will be removed in a future release", "8.0.60-R10")
  val JAPANESE_ROMAN = JapaneseRoman

  case object KanaLock extends KeyCode(jfxsi.KeyCode.KANA_LOCK)
  @deprecated ("Use KanaLock; KANA_LOCK will be removed in a future release", "8.0.60-R10")
  val KANA_LOCK = KanaLock

  case object InputMethodOnOff extends KeyCode(jfxsi.KeyCode.INPUT_METHOD_ON_OFF)
  @deprecated ("Use InputMethodOnOff; INPUT_METHOD_ON_OFF will be removed in a future release", "8.0.60-R10")
  val INPUT_METHOD_ON_OFF = InputMethodOnOff

  case object Cut extends KeyCode(jfxsi.KeyCode.CUT)
  @deprecated ("Use Cut; CUT will be removed in a future release", "8.0.60-R10")
  val CUT = Cut

  case object Copy extends KeyCode(jfxsi.KeyCode.COPY)
  @deprecated ("Use Copy; COPY will be removed in a future release", "8.0.60-R10")
  val COPY = Copy

  case object Paste extends KeyCode(jfxsi.KeyCode.PASTE)
  @deprecated ("Use Paste; PASTE will be removed in a future release", "8.0.60-R10")
  val PASTE = Paste

  case object Undo extends KeyCode(jfxsi.KeyCode.UNDO)
  @deprecated ("Use Undo; UNDO will be removed in a future release", "8.0.60-R10")
  val UNDO = Undo

  case object Again extends KeyCode(jfxsi.KeyCode.AGAIN)
  @deprecated ("Use Again; AGAIN will be removed in a future release", "8.0.60-R10")
  val AGAIN = Again

  case object Find extends KeyCode(jfxsi.KeyCode.FIND)
  @deprecated ("Use Find; FIND will be removed in a future release", "8.0.60-R10")
  val FIND = Find

  case object Props extends KeyCode(jfxsi.KeyCode.PROPS)
  @deprecated ("Use Props; PROPS will be removed in a future release", "8.0.60-R10")
  val PROPS = Props

  case object Stop extends KeyCode(jfxsi.KeyCode.STOP)
  @deprecated ("Use Stop; STOP will be removed in a future release", "8.0.60-R10")
  val STOP = Stop

  case object Compose extends KeyCode(jfxsi.KeyCode.COMPOSE)
  @deprecated ("Use Compose; COMPOSE will be removed in a future release", "8.0.60-R10")
  val COMPOSE = Compose

  case object AltGraph extends KeyCode(jfxsi.KeyCode.ALT_GRAPH)
  @deprecated ("Use AltGraph; ALT_GRAPH will be removed in a future release", "8.0.60-R10")
  val ALT_GRAPH = AltGraph

  case object Begin extends KeyCode(jfxsi.KeyCode.BEGIN)
  @deprecated ("Use Begin; BEGIN will be removed in a future release", "8.0.60-R10")
  val BEGIN = Begin

  case object Undefined extends KeyCode(jfxsi.KeyCode.UNDEFINED)
  @deprecated ("Use Undefined; UNDEFINED will be removed in a future release", "8.0.60-R10")
  val UNDEFINED = Undefined

  case object Softkey0 extends KeyCode(jfxsi.KeyCode.SOFTKEY_0)
  @deprecated ("Use Softkey0; SOFTKEY_0 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_0 = Softkey0

  case object Softkey1 extends KeyCode(jfxsi.KeyCode.SOFTKEY_1)
  @deprecated ("Use Softkey1; SOFTKEY_1 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_1 = Softkey1

  case object Softkey2 extends KeyCode(jfxsi.KeyCode.SOFTKEY_2)
  @deprecated ("Use Softkey2; SOFTKEY_2 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_2 = Softkey2

  case object Softkey3 extends KeyCode(jfxsi.KeyCode.SOFTKEY_3)
  @deprecated ("Use Softkey3; SOFTKEY_3 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_3 = Softkey3

  case object Softkey4 extends KeyCode(jfxsi.KeyCode.SOFTKEY_4)
  @deprecated ("Use Softkey4; SOFTKEY_4 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_4 = Softkey4

  case object Softkey5 extends KeyCode(jfxsi.KeyCode.SOFTKEY_5)
  @deprecated ("Use Softkey5; SOFTKEY_5 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_5 = Softkey5

  case object Softkey6 extends KeyCode(jfxsi.KeyCode.SOFTKEY_6)
  @deprecated ("Use Softkey6; SOFTKEY_6 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_6 = Softkey6

  case object Softkey7 extends KeyCode(jfxsi.KeyCode.SOFTKEY_7)
  @deprecated ("Use Softkey7; SOFTKEY_7 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_7 = Softkey7

  case object Softkey8 extends KeyCode(jfxsi.KeyCode.SOFTKEY_8)
  @deprecated ("Use Softkey8; SOFTKEY_8 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_8 = Softkey8

  case object Softkey9 extends KeyCode(jfxsi.KeyCode.SOFTKEY_9)
  @deprecated ("Use Softkey9; SOFTKEY_9 will be removed in a future release", "8.0.60-R10")
  val SOFTKEY_9 = Softkey9

  case object GameA extends KeyCode(jfxsi.KeyCode.GAME_A)
  @deprecated ("Use GameA; GAME_A will be removed in a future release", "8.0.60-R10")
  val GAME_A = GameA

  case object GameB extends KeyCode(jfxsi.KeyCode.GAME_B)
  @deprecated ("Use GameB; GAME_B will be removed in a future release", "8.0.60-R10")
  val GAME_B = GameB

  case object GameC extends KeyCode(jfxsi.KeyCode.GAME_C)
  @deprecated ("Use GameC; GAME_C will be removed in a future release", "8.0.60-R10")
  val GAME_C = GameC

  case object GameD extends KeyCode(jfxsi.KeyCode.GAME_D)
  @deprecated ("Use GameD; GAME_D will be removed in a future release", "8.0.60-R10")
  val GAME_D = GameD

  case object Star extends KeyCode(jfxsi.KeyCode.STAR)
  @deprecated ("Use Star; STAR will be removed in a future release", "8.0.60-R10")
  val STAR = Star

  case object Pound extends KeyCode(jfxsi.KeyCode.POUND)
  @deprecated ("Use Pound; POUND will be removed in a future release", "8.0.60-R10")
  val POUND = Pound

  case object Power extends KeyCode(jfxsi.KeyCode.POWER)
  @deprecated ("Use Power; POWER will be removed in a future release", "8.0.60-R10")
  val POWER = Power

  case object Info extends KeyCode(jfxsi.KeyCode.INFO)
  @deprecated ("Use Info; INFO will be removed in a future release", "8.0.60-R10")
  val INFO = Info

  case object ColoredKey0 extends KeyCode(jfxsi.KeyCode.COLORED_KEY_0)
  @deprecated ("Use ColoredKey0; COLORED_KEY_0 will be removed in a future release", "8.0.60-R10")
  val COLORED_KEY_0 = ColoredKey0

  case object ColoredKey1 extends KeyCode(jfxsi.KeyCode.COLORED_KEY_1)
  @deprecated ("Use ColoredKey1; COLORED_KEY_1 will be removed in a future release", "8.0.60-R10")
  val COLORED_KEY_1 = ColoredKey1

  case object ColoredKey2 extends KeyCode(jfxsi.KeyCode.COLORED_KEY_2)
  @deprecated ("Use ColoredKey2; COLORED_KEY_2 will be removed in a future release", "8.0.60-R10")
  val COLORED_KEY_2 = ColoredKey2

  case object ColoredKey3 extends KeyCode(jfxsi.KeyCode.COLORED_KEY_3)
  @deprecated ("Use ColoredKey3; COLORED_KEY_3 will be removed in a future release", "8.0.60-R10")
  val COLORED_KEY_3 = ColoredKey3

  case object EjectToggle extends KeyCode(jfxsi.KeyCode.EJECT_TOGGLE)
  @deprecated ("Use EjectToggle; EJECT_TOGGLE will be removed in a future release", "8.0.60-R10")
  val EJECT_TOGGLE = EjectToggle

  case object Play extends KeyCode(jfxsi.KeyCode.PLAY)
  @deprecated ("Use Play; PLAY will be removed in a future release", "8.0.60-R10")
  val PLAY = Play

  case object Record extends KeyCode(jfxsi.KeyCode.RECORD)
  @deprecated ("Use Record; RECORD will be removed in a future release", "8.0.60-R10")
  val RECORD = Record

  case object FastFwd extends KeyCode(jfxsi.KeyCode.FAST_FWD)
  @deprecated ("Use FastFwd; FAST_FWD will be removed in a future release", "8.0.60-R10")
  val FAST_FWD = FastFwd

  case object Rewind extends KeyCode(jfxsi.KeyCode.REWIND)
  @deprecated ("Use Rewind; REWIND will be removed in a future release", "8.0.60-R10")
  val REWIND = Rewind

  case object TrackPrev extends KeyCode(jfxsi.KeyCode.TRACK_PREV)
  @deprecated ("Use TrackPrev; TRACK_PREV will be removed in a future release", "8.0.60-R10")
  val TRACK_PREV = TrackPrev

  case object TrackNext extends KeyCode(jfxsi.KeyCode.TRACK_NEXT)
  @deprecated ("Use TrackNext; TRACK_NEXT will be removed in a future release", "8.0.60-R10")
  val TRACK_NEXT = TrackNext

  case object ChannelUp extends KeyCode(jfxsi.KeyCode.CHANNEL_UP)
  @deprecated ("Use ChannelUp; CHANNEL_UP will be removed in a future release", "8.0.60-R10")
  val CHANNEL_UP = ChannelUp

  case object ChannelDown extends KeyCode(jfxsi.KeyCode.CHANNEL_DOWN)
  @deprecated ("Use ChannelDown; CHANNEL_DOWN will be removed in a future release", "8.0.60-R10")
  val CHANNEL_DOWN = ChannelDown

  case object VolumeUp extends KeyCode(jfxsi.KeyCode.VOLUME_UP)
  @deprecated ("Use VolumeUp; VOLUME_UP will be removed in a future release", "8.0.60-R10")
  val VOLUME_UP = VolumeUp

  case object VolumeDown extends KeyCode(jfxsi.KeyCode.VOLUME_DOWN)
  @deprecated ("Use VolumeDown; VOLUME_DOWN will be removed in a future release", "8.0.60-R10")
  val VOLUME_DOWN = VolumeDown

  case object Mute extends KeyCode(jfxsi.KeyCode.MUTE)
  @deprecated ("Use Mute; MUTE will be removed in a future release", "8.0.60-R10")
  val MUTE = Mute

  case object Command extends KeyCode(jfxsi.KeyCode.COMMAND)
  @deprecated ("Use Command; COMMAND will be removed in a future release", "8.0.60-R10")
  val COMMAND = Command

  case object Shortcut extends KeyCode(jfxsi.KeyCode.SHORTCUT)
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


sealed abstract class KeyCode(override val delegate: jfxsi.KeyCode)
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
