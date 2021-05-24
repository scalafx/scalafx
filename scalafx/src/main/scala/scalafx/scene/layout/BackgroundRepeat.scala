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

package scalafx.scene.layout

import javafx.scene.{layout => jfxsl}
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/**
 * Wrapper for
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BackgroundRepeat.htmljavafx.scene.layout.BackgroundRepeat]]
 */
object BackgroundRepeat extends SFXEnumDelegateCompanion[jfxsl.BackgroundRepeat, BackgroundRepeat] {

  /** The image is placed once and not repeated. */
  case object NoRepeat extends BackgroundRepeat(jfxsl.BackgroundRepeat.NO_REPEAT)

  /** The image is repeated as often as needed to cover the area. */
  case object Repeat extends BackgroundRepeat(jfxsl.BackgroundRepeat.REPEAT)

  /** The image is repeated as often as will fit within the area. */
  case object Round extends BackgroundRepeat(jfxsl.BackgroundRepeat.ROUND)

  /**
   * The image is repeated as often as will fit within the area without being clipped and then the images are spaced out
   * to fill the area.
   */
  case object Space extends BackgroundRepeat(jfxsl.BackgroundRepeat.SPACE)

  protected override def unsortedValues: Array[BackgroundRepeat] = Array(
    NoRepeat,
    Repeat,
    Round,
    Space
  )
}

/**
 * Enumeration of options for repeating images in backgrounds
 */
sealed abstract class BackgroundRepeat(override val delegate: jfxsl.BackgroundRepeat)
    extends SFXEnumDelegate[jfxsl.BackgroundRepeat]
