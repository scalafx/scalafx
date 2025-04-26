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
package scalafx.scene.control

import javafx.scene.{control as jfxsc, paint as jfxsp}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color.sfxColor2jfx

import scala.language.implicitConversions

object ColorPicker {
  implicit def sfxColorPicker2jfx(cp: ColorPicker): jfxsc.ColorPicker = if (cp != null) cp.delegate else null

  val StyleClassButton: String = jfxsc.ColorPicker.STYLE_CLASS_BUTTON
  @deprecated("Use StyleClassButton; STYLE_CLASS_BUTTON will be removed in a future release", "8.0.60-R10")
  val STYLE_CLASS_BUTTON: String = StyleClassButton

  val StyleClassSplitButton: String = jfxsc.ColorPicker.STYLE_CLASS_SPLIT_BUTTON
  @deprecated("Use StyleClassSplitButton; STYLE_CLASS_SPLIT_BUTTON will be removed in a future release", "8.0.60-R10")
  val STYLE_CLASS_SPLIT_BUTTON: String = StyleClassSplitButton
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Pagination.html]]
 */
class ColorPicker(override val delegate: jfxsc.ColorPicker = new jfxsc.ColorPicker)
    extends ComboBoxBase[jfxsp.Color](delegate)
    with SFXDelegate[jfxsc.ColorPicker] {

  def this(color: Color) = this(new jfxsc.ColorPicker(color))

  def customColors = new ObservableBuffer(delegate.getCustomColors)

}
