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

package scalafx.scene.layout

import javafx.scene.layout as jfxsl
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

import scala.language.implicitConversions

/**
 * Enum indicating the repetition rules for border images.
 * Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderRepeat.html javafx.scene.layout.BorderRepeat]].
 */
object BorderRepeat extends SFXEnumDelegateCompanion[jfxsl.BorderRepeat, BorderRepeat] {

  /**
   * The image is tiled (repeated) to fill the area.
   */
  case object Repeat extends BorderRepeat(jfxsl.BorderRepeat.REPEAT)

  /**
   * The image is tiled (repeated) to fill the area.
   */
  case object Round extends BorderRepeat(jfxsl.BorderRepeat.ROUND)

  /**
   * The image is tiled (repeated) to fill the area.
   */
  case object Space extends BorderRepeat(jfxsl.BorderRepeat.SPACE)

  /**
   * The image is stretched to fill the area.
   */
  case object Stretch extends BorderRepeat(jfxsl.BorderRepeat.STRETCH)

  protected override def unsortedValues: Array[BorderRepeat] = Array(Repeat, Round, Space, Stretch)
}

sealed abstract class BorderRepeat(override val delegate: jfxsl.BorderRepeat)
    extends SFXEnumDelegate[jfxsl.BorderRepeat]
