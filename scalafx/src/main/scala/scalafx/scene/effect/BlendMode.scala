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
package scalafx.scene.effect

import javafx.scene.{effect => jfxse}
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

import scala.language.implicitConversions

/** Wrapper for [[scalafx.scene.effect.BlendMode]] */
object BlendMode extends SFXEnumDelegateCompanion[jfxse.BlendMode, BlendMode] {

  case object Add extends BlendMode(jfxse.BlendMode.ADD)
  @deprecated("Use Add; ADD will be removed in a future release", "2.2.60")
  val ADD = Add

  case object Blue extends BlendMode(jfxse.BlendMode.BLUE)
  @deprecated("Use Blue; BLUE will be removed in a future release", "2.2.60")
  val BLUE = Blue

  case object ColorBurn extends BlendMode(jfxse.BlendMode.COLOR_BURN)
  @deprecated("Use ColorBurn; COLOR_BURN will be removed in a future release", "2.2.60")
  val COLOR_BURN = ColorBurn

  case object ColorDodge extends BlendMode(jfxse.BlendMode.COLOR_DODGE)
  @deprecated("Use ColorDodge; COLOR_DODGE will be removed in a future release", "2.2.60")
  val COLOR_DODGE = ColorDodge

  case object Darken extends BlendMode(jfxse.BlendMode.DARKEN)
  @deprecated("Use Darken; DARKEN will be removed in a future release", "2.2.60")
  val DARKEN = Darken

  case object Difference extends BlendMode(jfxse.BlendMode.DIFFERENCE)
  @deprecated("Use Difference; DIFFERENCE will be removed in a future release", "2.2.60")
  val DIFFERENCE = Difference

  case object Exclusion extends BlendMode(jfxse.BlendMode.EXCLUSION)
  @deprecated("Use Exclusion; EXCLUSION will be removed in a future release", "2.2.60")
  val EXCLUSION = Exclusion

  case object Green extends BlendMode(jfxse.BlendMode.GREEN)
  @deprecated("Use Green; GREEN will be removed in a future release", "2.2.60")
  val GREEN = Green

  case object HardLight extends BlendMode(jfxse.BlendMode.HARD_LIGHT)
  @deprecated("Use HardLight; HARD_LIGHT will be removed in a future release", "2.2.60")
  val HARD_LIGHT = HardLight

  case object Lighten extends BlendMode(jfxse.BlendMode.LIGHTEN)
  @deprecated("Use Lighten; LIGHTEN will be removed in a future release", "2.2.60")
  val LIGHTEN = Lighten

  case object Multiply extends BlendMode(jfxse.BlendMode.MULTIPLY)
  @deprecated("Use Multiply; MULTIPLY will be removed in a future release", "2.2.60")
  val MULTIPLY = Multiply

  case object Overlay extends BlendMode(jfxse.BlendMode.OVERLAY)
  @deprecated("Use Overlay; OVERLAY will be removed in a future release", "2.2.60")
  val OVERLAY = Overlay

  case object Red extends BlendMode(jfxse.BlendMode.RED)
  @deprecated("Use Red; RED will be removed in a future release", "2.2.60")
  val RED = Red

  case object Screen extends BlendMode(jfxse.BlendMode.SCREEN)
  @deprecated("Use Screen; SCREEN will be removed in a future release", "2.2.60")
  val SCREEN = Screen

  case object SoftLight extends BlendMode(jfxse.BlendMode.SOFT_LIGHT)
  @deprecated("Use SoftLight; SOFT_LIGHT will be removed in a future release", "2.2.60")
  val SOFT_LIGHT = SoftLight

  case object SrcAtop extends BlendMode(jfxse.BlendMode.SRC_ATOP)
  @deprecated("Use SrcAtop; SRC_ATOP will be removed in a future release", "2.2.60")
  val SRC_ATOP = SrcAtop

  case object SrcOver extends BlendMode(jfxse.BlendMode.SRC_OVER)
  @deprecated("Use SrcOver; SRC_OVER will be removed in a future release", "2.2.60")
  val SRC_OVER = SrcOver

  protected override def unsortedValues: Array[BlendMode] = Array(
    SrcOver, SrcAtop, Add, Multiply, Screen, Overlay, Darken, Lighten, ColorDodge, ColorBurn,
    HardLight, SoftLight, Difference, Exclusion, Red, Green, Blue
  )
}


sealed abstract class BlendMode(override val delegate: jfxse.BlendMode) extends SFXEnumDelegate[jfxse.BlendMode]