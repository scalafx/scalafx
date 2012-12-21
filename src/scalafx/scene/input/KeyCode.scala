/*
 * Copyright (c) 2012, ScalaFX Project
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
import scalafx.util.{SFXEnumDelegateCompanion, SFXEnumDelegate}


/** Wrapper for [[javafx.scene.input.KeyCode]] */
object KeyCode extends SFXEnumDelegateCompanion[jfxsi.KeyCode, KeyCode] {

  val ENTER = new KeyCode(jfxsi.KeyCode.ENTER)
  val BACK_SPACE = new KeyCode(jfxsi.KeyCode.BACK_SPACE)
  val TAB = new KeyCode(jfxsi.KeyCode.TAB)
  val CANCEL = new KeyCode(jfxsi.KeyCode.CANCEL)
  val CLEAR = new KeyCode(jfxsi.KeyCode.CLEAR)
  val SHIFT = new KeyCode(jfxsi.KeyCode.SHIFT)
  val CONTROL = new KeyCode(jfxsi.KeyCode.CONTROL)
  val ALT = new KeyCode(jfxsi.KeyCode.ALT)
  val PAUSE = new KeyCode(jfxsi.KeyCode.PAUSE)
  val CAPS = new KeyCode(jfxsi.KeyCode.CAPS)
  val ESCAPE = new KeyCode(jfxsi.KeyCode.ESCAPE)
  val SPACE = new KeyCode(jfxsi.KeyCode.SPACE)
  val PAGE_UP = new KeyCode(jfxsi.KeyCode.PAGE_UP)
  val PAGE_DOWN = new KeyCode(jfxsi.KeyCode.PAGE_DOWN)
  val END = new KeyCode(jfxsi.KeyCode.END)
  val HOME = new KeyCode(jfxsi.KeyCode.HOME)
  val LEFT = new KeyCode(jfxsi.KeyCode.LEFT)
  val UP = new KeyCode(jfxsi.KeyCode.UP)
  val RIGHT = new KeyCode(jfxsi.KeyCode.RIGHT)
  val DOWN = new KeyCode(jfxsi.KeyCode.DOWN)
  val COMMA = new KeyCode(jfxsi.KeyCode.COMMA)
  val MINUS = new KeyCode(jfxsi.KeyCode.MINUS)
  val PERIOD = new KeyCode(jfxsi.KeyCode.PERIOD)
  val SLASH = new KeyCode(jfxsi.KeyCode.SLASH)
  val DIGIT0 = new KeyCode(jfxsi.KeyCode.DIGIT0)
  val DIGIT1 = new KeyCode(jfxsi.KeyCode.DIGIT1)
  val DIGIT2 = new KeyCode(jfxsi.KeyCode.DIGIT2)
  val DIGIT3 = new KeyCode(jfxsi.KeyCode.DIGIT3)
  val DIGIT4 = new KeyCode(jfxsi.KeyCode.DIGIT4)
  val DIGIT5 = new KeyCode(jfxsi.KeyCode.DIGIT5)
  val DIGIT6 = new KeyCode(jfxsi.KeyCode.DIGIT6)
  val DIGIT7 = new KeyCode(jfxsi.KeyCode.DIGIT7)
  val DIGIT8 = new KeyCode(jfxsi.KeyCode.DIGIT8)
  val DIGIT9 = new KeyCode(jfxsi.KeyCode.DIGIT9)
  val SEMICOLON = new KeyCode(jfxsi.KeyCode.SEMICOLON)
  val EQUALS = new KeyCode(jfxsi.KeyCode.EQUALS)
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
  val OPEN_BRACKET = new KeyCode(jfxsi.KeyCode.OPEN_BRACKET)
  val BACK_SLASH = new KeyCode(jfxsi.KeyCode.BACK_SLASH)
  val CLOSE_BRACKET = new KeyCode(jfxsi.KeyCode.CLOSE_BRACKET)
  val NUMPAD0 = new KeyCode(jfxsi.KeyCode.NUMPAD0)
  val NUMPAD1 = new KeyCode(jfxsi.KeyCode.NUMPAD1)
  val NUMPAD2 = new KeyCode(jfxsi.KeyCode.NUMPAD2)
  val NUMPAD3 = new KeyCode(jfxsi.KeyCode.NUMPAD3)
  val NUMPAD4 = new KeyCode(jfxsi.KeyCode.NUMPAD4)
  val NUMPAD5 = new KeyCode(jfxsi.KeyCode.NUMPAD5)
  val NUMPAD6 = new KeyCode(jfxsi.KeyCode.NUMPAD6)
  val NUMPAD7 = new KeyCode(jfxsi.KeyCode.NUMPAD7)
  val NUMPAD8 = new KeyCode(jfxsi.KeyCode.NUMPAD8)
  val NUMPAD9 = new KeyCode(jfxsi.KeyCode.NUMPAD9)
  val MULTIPLY = new KeyCode(jfxsi.KeyCode.MULTIPLY)
  val ADD = new KeyCode(jfxsi.KeyCode.ADD)
  val SEPARATOR = new KeyCode(jfxsi.KeyCode.SEPARATOR)
  val SUBTRACT = new KeyCode(jfxsi.KeyCode.SUBTRACT)
  val DECIMAL = new KeyCode(jfxsi.KeyCode.DECIMAL)
  val DIVIDE = new KeyCode(jfxsi.KeyCode.DIVIDE)
  val DELETE = new KeyCode(jfxsi.KeyCode.DELETE)
  val NUM_LOCK = new KeyCode(jfxsi.KeyCode.NUM_LOCK)
  val SCROLL_LOCK = new KeyCode(jfxsi.KeyCode.SCROLL_LOCK)
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
  val PRINTSCREEN = new KeyCode(jfxsi.KeyCode.PRINTSCREEN)
  val INSERT = new KeyCode(jfxsi.KeyCode.INSERT)
  val HELP = new KeyCode(jfxsi.KeyCode.HELP)
  val META = new KeyCode(jfxsi.KeyCode.META)
  val BACK_QUOTE = new KeyCode(jfxsi.KeyCode.BACK_QUOTE)
  val QUOTE = new KeyCode(jfxsi.KeyCode.QUOTE)
  val KP_UP = new KeyCode(jfxsi.KeyCode.KP_UP)
  val KP_DOWN = new KeyCode(jfxsi.KeyCode.KP_DOWN)
  val KP_LEFT = new KeyCode(jfxsi.KeyCode.KP_LEFT)
  val KP_RIGHT = new KeyCode(jfxsi.KeyCode.KP_RIGHT)
  val DEAD_GRAVE = new KeyCode(jfxsi.KeyCode.DEAD_GRAVE)
  val DEAD_ACUTE = new KeyCode(jfxsi.KeyCode.DEAD_ACUTE)
  val DEAD_CIRCUMFLEX = new KeyCode(jfxsi.KeyCode.DEAD_CIRCUMFLEX)
  val DEAD_TILDE = new KeyCode(jfxsi.KeyCode.DEAD_TILDE)
  val DEAD_MACRON = new KeyCode(jfxsi.KeyCode.DEAD_MACRON)
  val DEAD_BREVE = new KeyCode(jfxsi.KeyCode.DEAD_BREVE)
  val DEAD_ABOVEDOT = new KeyCode(jfxsi.KeyCode.DEAD_ABOVEDOT)
  val DEAD_DIAERESIS = new KeyCode(jfxsi.KeyCode.DEAD_DIAERESIS)
  val DEAD_ABOVERING = new KeyCode(jfxsi.KeyCode.DEAD_ABOVERING)
  val DEAD_DOUBLEACUTE = new KeyCode(jfxsi.KeyCode.DEAD_DOUBLEACUTE)
  val DEAD_CARON = new KeyCode(jfxsi.KeyCode.DEAD_CARON)
  val DEAD_CEDILLA = new KeyCode(jfxsi.KeyCode.DEAD_CEDILLA)
  val DEAD_OGONEK = new KeyCode(jfxsi.KeyCode.DEAD_OGONEK)
  val DEAD_IOTA = new KeyCode(jfxsi.KeyCode.DEAD_IOTA)
  val DEAD_VOICED_SOUND = new KeyCode(jfxsi.KeyCode.DEAD_VOICED_SOUND)
  val DEAD_SEMIVOICED_SOUND = new KeyCode(jfxsi.KeyCode.DEAD_SEMIVOICED_SOUND)
  val AMPERSAND = new KeyCode(jfxsi.KeyCode.AMPERSAND)
  val ASTERISK = new KeyCode(jfxsi.KeyCode.ASTERISK)
  val QUOTEDBL = new KeyCode(jfxsi.KeyCode.QUOTEDBL)
  val LESS = new KeyCode(jfxsi.KeyCode.LESS)
  val GREATER = new KeyCode(jfxsi.KeyCode.GREATER)
  val BRACELEFT = new KeyCode(jfxsi.KeyCode.BRACELEFT)
  val BRACERIGHT = new KeyCode(jfxsi.KeyCode.BRACERIGHT)
  val AT = new KeyCode(jfxsi.KeyCode.AT)
  val COLON = new KeyCode(jfxsi.KeyCode.COLON)
  val CIRCUMFLEX = new KeyCode(jfxsi.KeyCode.CIRCUMFLEX)
  val DOLLAR = new KeyCode(jfxsi.KeyCode.DOLLAR)
  val EURO_SIGN = new KeyCode(jfxsi.KeyCode.EURO_SIGN)
  val EXCLAMATION_MARK = new KeyCode(jfxsi.KeyCode.EXCLAMATION_MARK)
  val INVERTED_EXCLAMATION_MARK = new KeyCode(jfxsi.KeyCode.INVERTED_EXCLAMATION_MARK)
  val LEFT_PARENTHESIS = new KeyCode(jfxsi.KeyCode.LEFT_PARENTHESIS)
  val NUMBER_SIGN = new KeyCode(jfxsi.KeyCode.NUMBER_SIGN)
  val PLUS = new KeyCode(jfxsi.KeyCode.PLUS)
  val RIGHT_PARENTHESIS = new KeyCode(jfxsi.KeyCode.RIGHT_PARENTHESIS)
  val UNDERSCORE = new KeyCode(jfxsi.KeyCode.UNDERSCORE)
  val WINDOWS = new KeyCode(jfxsi.KeyCode.WINDOWS)
  val CONTEXT_MENU = new KeyCode(jfxsi.KeyCode.CONTEXT_MENU)
  val FINAL = new KeyCode(jfxsi.KeyCode.FINAL)
  val CONVERT = new KeyCode(jfxsi.KeyCode.CONVERT)
  val NONCONVERT = new KeyCode(jfxsi.KeyCode.NONCONVERT)
  val ACCEPT = new KeyCode(jfxsi.KeyCode.ACCEPT)
  val MODECHANGE = new KeyCode(jfxsi.KeyCode.MODECHANGE)
  val KANA = new KeyCode(jfxsi.KeyCode.KANA)
  val KANJI = new KeyCode(jfxsi.KeyCode.KANJI)
  val ALPHANUMERIC = new KeyCode(jfxsi.KeyCode.ALPHANUMERIC)
  val KATAKANA = new KeyCode(jfxsi.KeyCode.KATAKANA)
  val HIRAGANA = new KeyCode(jfxsi.KeyCode.HIRAGANA)
  val FULL_WIDTH = new KeyCode(jfxsi.KeyCode.FULL_WIDTH)
  val HALF_WIDTH = new KeyCode(jfxsi.KeyCode.HALF_WIDTH)
  val ROMAN_CHARACTERS = new KeyCode(jfxsi.KeyCode.ROMAN_CHARACTERS)
  val ALL_CANDIDATES = new KeyCode(jfxsi.KeyCode.ALL_CANDIDATES)
  val PREVIOUS_CANDIDATE = new KeyCode(jfxsi.KeyCode.PREVIOUS_CANDIDATE)
  val CODE_INPUT = new KeyCode(jfxsi.KeyCode.CODE_INPUT)
  val JAPANESE_KATAKANA = new KeyCode(jfxsi.KeyCode.JAPANESE_KATAKANA)
  val JAPANESE_HIRAGANA = new KeyCode(jfxsi.KeyCode.JAPANESE_HIRAGANA)
  val JAPANESE_ROMAN = new KeyCode(jfxsi.KeyCode.JAPANESE_ROMAN)
  val KANA_LOCK = new KeyCode(jfxsi.KeyCode.KANA_LOCK)
  val INPUT_METHOD_ON_OFF = new KeyCode(jfxsi.KeyCode.INPUT_METHOD_ON_OFF)
  val CUT = new KeyCode(jfxsi.KeyCode.CUT)
  val COPY = new KeyCode(jfxsi.KeyCode.COPY)
  val PASTE = new KeyCode(jfxsi.KeyCode.PASTE)
  val UNDO = new KeyCode(jfxsi.KeyCode.UNDO)
  val AGAIN = new KeyCode(jfxsi.KeyCode.AGAIN)
  val FIND = new KeyCode(jfxsi.KeyCode.FIND)
  val PROPS = new KeyCode(jfxsi.KeyCode.PROPS)
  val STOP = new KeyCode(jfxsi.KeyCode.STOP)
  val COMPOSE = new KeyCode(jfxsi.KeyCode.COMPOSE)
  val ALT_GRAPH = new KeyCode(jfxsi.KeyCode.ALT_GRAPH)
  val BEGIN = new KeyCode(jfxsi.KeyCode.BEGIN)
  val UNDEFINED = new KeyCode(jfxsi.KeyCode.UNDEFINED)
  val SOFTKEY_0 = new KeyCode(jfxsi.KeyCode.SOFTKEY_0)
  val SOFTKEY_1 = new KeyCode(jfxsi.KeyCode.SOFTKEY_1)
  val SOFTKEY_2 = new KeyCode(jfxsi.KeyCode.SOFTKEY_2)
  val SOFTKEY_3 = new KeyCode(jfxsi.KeyCode.SOFTKEY_3)
  val SOFTKEY_4 = new KeyCode(jfxsi.KeyCode.SOFTKEY_4)
  val SOFTKEY_5 = new KeyCode(jfxsi.KeyCode.SOFTKEY_5)
  val SOFTKEY_6 = new KeyCode(jfxsi.KeyCode.SOFTKEY_6)
  val SOFTKEY_7 = new KeyCode(jfxsi.KeyCode.SOFTKEY_7)
  val SOFTKEY_8 = new KeyCode(jfxsi.KeyCode.SOFTKEY_8)
  val SOFTKEY_9 = new KeyCode(jfxsi.KeyCode.SOFTKEY_9)
  val GAME_A = new KeyCode(jfxsi.KeyCode.GAME_A)
  val GAME_B = new KeyCode(jfxsi.KeyCode.GAME_B)
  val GAME_C = new KeyCode(jfxsi.KeyCode.GAME_C)
  val GAME_D = new KeyCode(jfxsi.KeyCode.GAME_D)
  val STAR = new KeyCode(jfxsi.KeyCode.STAR)
  val POUND = new KeyCode(jfxsi.KeyCode.POUND)
  val POWER = new KeyCode(jfxsi.KeyCode.POWER)
  val INFO = new KeyCode(jfxsi.KeyCode.INFO)
  val COLORED_KEY_0 = new KeyCode(jfxsi.KeyCode.COLORED_KEY_0)
  val COLORED_KEY_1 = new KeyCode(jfxsi.KeyCode.COLORED_KEY_1)
  val COLORED_KEY_2 = new KeyCode(jfxsi.KeyCode.COLORED_KEY_2)
  val COLORED_KEY_3 = new KeyCode(jfxsi.KeyCode.COLORED_KEY_3)
  val EJECT_TOGGLE = new KeyCode(jfxsi.KeyCode.EJECT_TOGGLE)
  val PLAY = new KeyCode(jfxsi.KeyCode.PLAY)
  val RECORD = new KeyCode(jfxsi.KeyCode.RECORD)
  val FAST_FWD = new KeyCode(jfxsi.KeyCode.FAST_FWD)
  val REWIND = new KeyCode(jfxsi.KeyCode.REWIND)
  val TRACK_PREV = new KeyCode(jfxsi.KeyCode.TRACK_PREV)
  val TRACK_NEXT = new KeyCode(jfxsi.KeyCode.TRACK_NEXT)
  val CHANNEL_UP = new KeyCode(jfxsi.KeyCode.CHANNEL_UP)
  val CHANNEL_DOWN = new KeyCode(jfxsi.KeyCode.CHANNEL_DOWN)
  val VOLUME_UP = new KeyCode(jfxsi.KeyCode.VOLUME_UP)
  val VOLUME_DOWN = new KeyCode(jfxsi.KeyCode.VOLUME_DOWN)
  val MUTE = new KeyCode(jfxsi.KeyCode.MUTE)
  val COMMAND = new KeyCode(jfxsi.KeyCode.COMMAND)
  val SHORTCUT = new KeyCode(jfxsi.KeyCode.SHORTCUT)

  protected def unsortedValues: Array[KeyCode] = Array(
    ENTER, BACK_SPACE, TAB, CANCEL, CLEAR, SHIFT, CONTROL, ALT, PAUSE, CAPS, ESCAPE, SPACE, PAGE_UP, PAGE_DOWN, END,
    HOME, LEFT, UP, RIGHT, DOWN, COMMA, MINUS, PERIOD, SLASH,
    DIGIT0, DIGIT1, DIGIT2, DIGIT3, DIGIT4, DIGIT5, DIGIT6, DIGIT7, DIGIT8, DIGIT9, SEMICOLON, EQUALS,
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
    OPEN_BRACKET, BACK_SLASH, CLOSE_BRACKET,
    NUMPAD0, NUMPAD1, NUMPAD2, NUMPAD3, NUMPAD4, NUMPAD5, NUMPAD6, NUMPAD7, NUMPAD8, NUMPAD9,
    MULTIPLY, ADD, SEPARATOR, SUBTRACT, DECIMAL, DIVIDE, DELETE, NUM_LOCK, SCROLL_LOCK,
    F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19, F20, F21, F22, F23, F24,
    PRINTSCREEN, INSERT, HELP, META, BACK_QUOTE, QUOTE,
    KP_UP, KP_DOWN, KP_LEFT, KP_RIGHT,
    DEAD_GRAVE, DEAD_ACUTE, DEAD_CIRCUMFLEX, DEAD_TILDE, DEAD_MACRON, DEAD_BREVE, DEAD_ABOVEDOT, DEAD_DIAERESIS,
    DEAD_ABOVERING, DEAD_DOUBLEACUTE, DEAD_CARON, DEAD_CEDILLA, DEAD_OGONEK, DEAD_IOTA, DEAD_VOICED_SOUND,
    DEAD_SEMIVOICED_SOUND, AMPERSAND, ASTERISK, QUOTEDBL, LESS, GREATER, BRACELEFT, BRACERIGHT, AT, COLON, CIRCUMFLEX,
    DOLLAR, EURO_SIGN, EXCLAMATION_MARK, INVERTED_EXCLAMATION_MARK, LEFT_PARENTHESIS, NUMBER_SIGN, PLUS,
    RIGHT_PARENTHESIS, UNDERSCORE, WINDOWS, CONTEXT_MENU, FINAL, CONVERT, NONCONVERT, ACCEPT, MODECHANGE, KANA, KANJI,
    ALPHANUMERIC, KATAKANA, HIRAGANA, FULL_WIDTH, HALF_WIDTH, ROMAN_CHARACTERS, ALL_CANDIDATES, PREVIOUS_CANDIDATE,
    CODE_INPUT, JAPANESE_KATAKANA, JAPANESE_HIRAGANA, JAPANESE_ROMAN, KANA_LOCK, INPUT_METHOD_ON_OFF,
    CUT, COPY, PASTE, UNDO, AGAIN, FIND, PROPS, STOP, COMPOSE, ALT_GRAPH, BEGIN, UNDEFINED,
    SOFTKEY_0, SOFTKEY_1, SOFTKEY_2, SOFTKEY_3, SOFTKEY_4, SOFTKEY_5, SOFTKEY_6, SOFTKEY_7, SOFTKEY_8, SOFTKEY_9,
    GAME_A, GAME_B, GAME_C, GAME_D, STAR, POUND, POWER, INFO,
    COLORED_KEY_0, COLORED_KEY_1, COLORED_KEY_2, COLORED_KEY_3,
    EJECT_TOGGLE, PLAY, RECORD, FAST_FWD, REWIND, TRACK_PREV, TRACK_NEXT, CHANNEL_UP, CHANNEL_DOWN,
    VOLUME_UP, VOLUME_DOWN, MUTE, COMMAND, SHORTCUT
  )

  /** Parses textual representation of a key. */
  def keyCode(name: String): KeyCode = jfxsi.KeyCode.getKeyCode(name)
}


sealed case class KeyCode(override val delegate: jfxsi.KeyCode)
  extends SFXEnumDelegate[jfxsi.KeyCode] {
  /** Gets name of this key code. */
  def name: String = delegate.getName

  /** Left, right, up, down keys (including the keypad arrows) */
  //  def isArrowKey: Boolean = delegate.isArrowKey

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