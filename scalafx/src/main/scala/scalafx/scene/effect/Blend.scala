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
package scalafx.scene.effect

import scalafx.Includes._
import javafx.scene.{ effect => jfxse}
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate

object Blend {
  implicit def sfxBlend2jfx(b: Blend) = b.delegate
}

class Blend(override val delegate: jfxse.Blend = new jfxse.Blend) extends Effect(delegate) with SFXDelegate[jfxse.Blend] {

  /**
   * Creates a new instance of Blend with the specified mode.
   */
  def this(mode: BlendMode) = this(new jfxse.Blend(mode))

  /**
   * Creates a new instance of Blend with the specified mode and bottom and top inputs.
   */
  def this(mode: BlendMode, bottomInput: Effect, topInput: Effect) = this(new jfxse.Blend(mode, bottomInput, topInput))

  /**
   * The bottom input for this Blend operation.
   */
  def bottomInput: ObjectProperty[jfxse.Effect] = delegate.bottomInputProperty
  def bottomInput_=(v: Effect) {
    bottomInput() = v
  }

  /**
   * The BlendMode used to blend the two inputs together.
   */
  def mode: ObjectProperty[jfxse.BlendMode] = delegate.modeProperty
  def mode_=(v: BlendMode) {
    mode() = v
  }

  /**
   * The opacity value, which is modulated with the top input prior to blending.
   */
  def opacity: DoubleProperty = delegate.opacityProperty
  def opacity_=(v: Double) {
    opacity() = v
  }

  /**
   * The top input for this Blend operation.
   */
  def topInput: ObjectProperty[jfxse.Effect] = delegate.topInputProperty
  def topInput_=(v: Effect) {
    topInput() = v
  }

}
