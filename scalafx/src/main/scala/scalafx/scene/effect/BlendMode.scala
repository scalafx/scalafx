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
package scalafx.scene.effect

import javafx.scene.{effect => jfxse}
import scalafx.delegate.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

/** Wrapper for [[scalafx.scene.effect.BlendMode]] */
object BlendMode extends SFXEnumDelegateCompanion[jfxse.BlendMode, BlendMode] {

  val Add = new BlendMode(jfxse.BlendMode.ADD)
  @deprecated ("Use Add; ADD will be removed in a future release", "2.2.60")
  val ADD = Add
  val Blue = new BlendMode(jfxse.BlendMode.BLUE)
  @deprecated ("Use Blue; BLUE will be removed in a future release", "2.2.60")
  val BLUE = Blue
  val ColorBurn = new BlendMode(jfxse.BlendMode.COLOR_BURN)
  @deprecated ("Use ColorBurn; COLOR_BURN will be removed in a future release", "2.2.60")
  val COLOR_BURN = ColorBurn
  val ColorDodge = new BlendMode(jfxse.BlendMode.COLOR_DODGE)
  @deprecated ("Use ColorDodge; COLOR_DODGE will be removed in a future release", "2.2.60")
  val COLOR_DODGE = ColorDodge
  val Darken = new BlendMode(jfxse.BlendMode.DARKEN)
  @deprecated ("Use Darken; DARKEN will be removed in a future release", "2.2.60")
  val DARKEN = Darken
  val Difference = new BlendMode(jfxse.BlendMode.DIFFERENCE)
  @deprecated ("Use Difference; DIFFERENCE will be removed in a future release", "2.2.60")
  val DIFFERENCE = Difference
  val Exclusion = new BlendMode(jfxse.BlendMode.EXCLUSION)
  @deprecated ("Use Exclusion; EXCLUSION will be removed in a future release", "2.2.60")
  val EXCLUSION = Exclusion
  val Green = new BlendMode(jfxse.BlendMode.GREEN)
  @deprecated ("Use Green; GREEN will be removed in a future release", "2.2.60")
  val GREEN = Green
  val HardLight = new BlendMode(jfxse.BlendMode.HARD_LIGHT)
  @deprecated ("Use HardLight; HARD_LIGHT will be removed in a future release", "2.2.60")
  val HARD_LIGHT = HardLight
  val Lighten = new BlendMode(jfxse.BlendMode.LIGHTEN)
  @deprecated ("Use Lighten; LIGHTEN will be removed in a future release", "2.2.60")
  val LIGHTEN = Lighten
  val Multiply = new BlendMode(jfxse.BlendMode.MULTIPLY)
  @deprecated ("Use Multiply; MULTIPLY will be removed in a future release", "2.2.60")
  val MULTIPLY = Multiply
  val Overlay = new BlendMode(jfxse.BlendMode.OVERLAY)
  @deprecated ("Use Overlay; OVERLAY will be removed in a future release", "2.2.60")
  val OVERLAY = Overlay
  val Red = new BlendMode(jfxse.BlendMode.RED)
  @deprecated ("Use Red; RED will be removed in a future release", "2.2.60")
  val RED = Red
  val Screen = new BlendMode(jfxse.BlendMode.SCREEN)
  @deprecated ("Use Screen; SCREEN will be removed in a future release", "2.2.60")
  val SCREEN = Screen
  val SoftLight = new BlendMode(jfxse.BlendMode.SOFT_LIGHT)
  @deprecated ("Use SoftLight; SOFT_LIGHT will be removed in a future release", "2.2.60")
  val SOFT_LIGHT = SoftLight
  val SrcAtop = new BlendMode(jfxse.BlendMode.SRC_ATOP)
  @deprecated ("Use SrcAtop; SRC_ATOP will be removed in a future release", "2.2.60")
  val SRC_ATOP = SrcAtop
  val SrcOver = new BlendMode(jfxse.BlendMode.SRC_OVER)
  @deprecated ("Use SrcOver; SRC_OVER will be removed in a future release", "2.2.60")
  val SRC_OVER = SrcOver

  protected override def unsortedValues: Array[BlendMode] = Array(
    SrcOver, SrcAtop, Add, Multiply, Screen, Overlay, Darken, Lighten, ColorDodge, ColorBurn,
    HardLight, SoftLight, Difference, Exclusion, Red, Green, Blue
  )
}


sealed case class BlendMode(override val delegate: jfxse.BlendMode) extends SFXEnumDelegate[jfxse.BlendMode]