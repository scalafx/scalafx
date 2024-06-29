/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/InputMethodHighlight.html javafx.scene.input.InputMethodHighlight]] */
object InputMethodHighlight extends SFXEnumDelegateCompanion[jfxsi.InputMethodHighlight, InputMethodHighlight] {

  case object UnselectedRaw extends InputMethodHighlight(jfxsi.InputMethodHighlight.UNSELECTED_RAW)
  @deprecated("Use UnselectedRaw; UNSELECTED_RAW will be removed in a future release", "8.0.60-R10")
  val UNSELECTED_RAW: InputMethodHighlight = UnselectedRaw

  case object SelectedRaw extends InputMethodHighlight(jfxsi.InputMethodHighlight.SELECTED_RAW)

  @deprecated("Use SelectedRaw; SELECTED_RAW will be removed in a future release", "8.0.60-R10")
  val SELECTED_RAW: InputMethodHighlight = SelectedRaw

  case object UnselectedConverted extends InputMethodHighlight(jfxsi.InputMethodHighlight.UNSELECTED_CONVERTED)

  @deprecated("Use UnselectedConverted; UNSELECTED_CONVERTED will be removed in a future release", "8.0.60-R10")
  val UNSELECTED_CONVERTED: InputMethodHighlight = UnselectedConverted

  case object SelectedConverted extends InputMethodHighlight(jfxsi.InputMethodHighlight.SELECTED_CONVERTED)

  @deprecated("Use SelectedConverted; SELECTED_CONVERTED will be removed in a future release", "8.0.60-R10")
  val SELECTED_CONVERTED: InputMethodHighlight = SelectedConverted

  protected override def unsortedValues: Array[InputMethodHighlight] = Array(
    UnselectedRaw,
    SelectedRaw,
    UnselectedConverted,
    SelectedConverted
  )
}

sealed abstract class InputMethodHighlight(override val delegate: jfxsi.InputMethodHighlight)
    extends SFXEnumDelegate[jfxsi.InputMethodHighlight]
