/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.scene.input as jfxsi
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/MouseButton.html javafx.scene.input.MouseButton]] */
object MouseButton extends SFXEnumDelegateCompanion[jfxsi.MouseButton, MouseButton] {

  case object None extends MouseButton(jfxsi.MouseButton.NONE)

  @deprecated("Use None; NONE will be removed in a future release", "8.0.60-R10")
  val NONE: MouseButton = None

  case object Primary extends MouseButton(jfxsi.MouseButton.PRIMARY)

  @deprecated("Use Primary; PRIMARY will be removed in a future release", "8.0.60-R10")
  val PRIMARY: MouseButton = Primary

  case object Middle extends MouseButton(jfxsi.MouseButton.MIDDLE)

  @deprecated("Use Middle; MIDDLE will be removed in a future release", "8.0.60-R10")
  val MIDDLE: MouseButton = Middle

  case object Secondary extends MouseButton(jfxsi.MouseButton.SECONDARY)

  @deprecated("Use Secondary; SECONDARY will be removed in a future release", "8.0.60-R10")
  val SECONDARY: MouseButton = Secondary

  case object Back extends MouseButton(jfxsi.MouseButton.BACK)

  case object Forward extends MouseButton(jfxsi.MouseButton.FORWARD)

  protected override def unsortedValues: Array[MouseButton] = Array(None, Primary, Middle, Secondary, Back, Forward)
}

sealed abstract class MouseButton(override val delegate: jfxsi.MouseButton)
    extends SFXEnumDelegate[jfxsi.MouseButton]
