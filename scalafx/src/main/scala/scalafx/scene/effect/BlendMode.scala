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

import javafx.scene.{effect => jfxse}
import scalafx.delegate.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

/** Wrapper for [[scalafx.scene.effect.BlendMode]] */
object BlendMode extends SFXEnumDelegateCompanion[jfxse.BlendMode, BlendMode] {

  val ADD = new BlendMode(jfxse.BlendMode.ADD)
  val BLUE = new BlendMode(jfxse.BlendMode.BLUE)
  val COLOR_BURN = new BlendMode(jfxse.BlendMode.COLOR_BURN)
  val COLOR_DODGE = new BlendMode(jfxse.BlendMode.COLOR_DODGE)
  val DARKEN = new BlendMode(jfxse.BlendMode.DARKEN)
  val DIFFERENCE = new BlendMode(jfxse.BlendMode.DIFFERENCE)
  val EXCLUSION = new BlendMode(jfxse.BlendMode.EXCLUSION)
  val GREEN = new BlendMode(jfxse.BlendMode.GREEN)
  val HARD_LIGHT = new BlendMode(jfxse.BlendMode.HARD_LIGHT)
  val LIGHTEN = new BlendMode(jfxse.BlendMode.LIGHTEN)
  val MULTIPLY = new BlendMode(jfxse.BlendMode.MULTIPLY)
  val OVERLAY = new BlendMode(jfxse.BlendMode.OVERLAY)
  val RED = new BlendMode(jfxse.BlendMode.RED)
  val SCREEN = new BlendMode(jfxse.BlendMode.SCREEN)
  val SOFT_LIGHT = new BlendMode(jfxse.BlendMode.SOFT_LIGHT)
  val SRC_ATOP = new BlendMode(jfxse.BlendMode.SRC_ATOP)
  val SRC_OVER = new BlendMode(jfxse.BlendMode.SRC_OVER)

  protected override def unsortedValues: Array[BlendMode] = Array(
    SRC_OVER, SRC_ATOP, ADD, MULTIPLY, SCREEN, OVERLAY, DARKEN, LIGHTEN, COLOR_DODGE, COLOR_BURN,
    HARD_LIGHT, SOFT_LIGHT, DIFFERENCE, EXCLUSION, RED, GREEN, BLUE
  )
}


sealed case class BlendMode(override val delegate: jfxse.BlendMode) extends SFXEnumDelegate[jfxse.BlendMode]