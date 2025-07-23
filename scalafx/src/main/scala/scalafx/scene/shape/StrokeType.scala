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

package scalafx.scene.shape

import javafx.scene.shape as jfxss
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/StrokeType.html javafx.scene.shape.StrokeType]] */
object StrokeType extends SFXEnumDelegateCompanion[jfxss.StrokeType, StrokeType] {

  case object Inside extends StrokeType(jfxss.StrokeType.INSIDE)
  @deprecated("Use Inside; INSIDE will be removed in a future release", "2.2.60")
  val INSIDE: StrokeType = Inside

  case object Outside extends StrokeType(jfxss.StrokeType.OUTSIDE)

  @deprecated("Use Outside; OUTSIDE will be removed in a future release", "2.2.60")
  val OUTSIDE: StrokeType = Outside

  case object Centered extends StrokeType(jfxss.StrokeType.CENTERED)

  @deprecated("Use Centered; CENTERED will be removed in a future release", "2.2.60")
  val CENTERED: StrokeType = Centered

  protected override def unsortedValues: Array[StrokeType] = Array(Inside, Outside, Centered)
}

sealed abstract class StrokeType(override val delegate: jfxss.StrokeType)
    extends SFXEnumDelegate[jfxss.StrokeType]
