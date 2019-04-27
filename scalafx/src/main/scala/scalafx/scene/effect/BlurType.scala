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

/** Wrapper for [[scalafx.scene.effect.BlurType]] */
object BlurType extends SFXEnumDelegateCompanion[jfxse.BlurType, BlurType] {

  case object Gaussian extends BlurType(jfxse.BlurType.GAUSSIAN)
  @deprecated ("Use Gaussian; GAUSSIAN will be removed in a future release", "8.0.60-R10")
  val GAUSSIAN = Gaussian

  case object OnePassBox extends BlurType(jfxse.BlurType.ONE_PASS_BOX)
  @deprecated ("Use OnePassBox; ONE_PASS_BOX will be removed in a future release", "8.0.60-R10")
  val ONE_PASS_BOX = OnePassBox

  case object ThreePassBox extends BlurType(jfxse.BlurType.THREE_PASS_BOX)
  @deprecated ("Use ThreePassBox; THREE_PASS_BOX will be removed in a future release", "8.0.60-R10")
  val THREE_PASS_BOX = ThreePassBox

  case object TwoPassBox extends BlurType(jfxse.BlurType.TWO_PASS_BOX)
  @deprecated ("Use TwoPassBox; TWO_PASS_BOX will be removed in a future release", "8.0.60-R10")
  val TWO_PASS_BOX = TwoPassBox

  protected override def unsortedValues: Array[BlurType] = Array(
    OnePassBox, TwoPassBox, ThreePassBox, Gaussian
  )
}

sealed abstract class BlurType(override val delegate: jfxse.BlurType) extends SFXEnumDelegate[jfxse.BlurType]
