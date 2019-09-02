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
package scalafx.stage

import javafx.{stage => jfxs}
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

object StageStyle extends SFXEnumDelegateCompanion[jfxs.StageStyle, StageStyle] {

  /**
    * Defines a normal Stage style with a solid white background and platform decorations.
    */
  case object Decorated extends StageStyle(jfxs.StageStyle.DECORATED)
  @deprecated("Use Decorated; DECORATED will be removed in a future release", "8.0.60-R10")
  val DECORATED = Decorated

  /**
    * Defines a Stage style with a solid white background and no decorations.
    */
  case object Undecorated extends StageStyle(jfxs.StageStyle.UNDECORATED)
  @deprecated("Use Undecorated; UNDECORATED will be removed in a future release", "8.0.60-R10")
  val UNDECORATED = Undecorated

  /**
    * Defines a Stage style with a transparent background and no decorations.
    */
  case object Transparent extends StageStyle(jfxs.StageStyle.TRANSPARENT)
  @deprecated("Use Transparent; TRANSPARENT will be removed in a future release", "8.0.60-R10")
  val TRANSPARENT = Transparent

  /**
    * Defines a Stage style with a solid white background and minimal platform decorations used for a utility window.
    */
  case object Utility extends StageStyle(jfxs.StageStyle.UTILITY)
  @deprecated("Use Utility; UTILITY will be removed in a future release", "8.0.60-R10")
  val UTILITY = Utility

  /** Defines a Stage style with platform decorations and eliminates the border between client area and decorations. */
  case object Unified extends StageStyle(jfxs.StageStyle.UNIFIED)
  @deprecated("Use Unified; UNIFIED will be removed in a future release", "8.0.60-R10")
  val UNIFIED = Unified

  protected override def unsortedValues: Array[StageStyle] =
    Array(Decorated, Undecorated, Transparent, Utility, Unified)

}

/**
  * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/stage/StageStyle.html]]
  */
sealed abstract class StageStyle(override val delegate: jfxs.StageStyle) extends SFXEnumDelegate[jfxs.StageStyle]
