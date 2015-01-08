/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

package scalafx.geometry

import javafx.{geometry => jfxg}

import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/VPos.html javafx.geometry.VPos]] */
object VPos
  extends SFXEnumDelegateCompanion[jfxg.VPos, VPos] {

  /** Indicates baseline vertical position. */
  val Baseline = new VPos(jfxg.VPos.BASELINE)
  @deprecated("Use Baseline; BASELINE will be removed in a future release", "2.2.60")
  val BASELINE = Baseline

  /** Indicates bottom vertical position. */
  val Bottom = new VPos(jfxg.VPos.BOTTOM)
  @deprecated("Use Bottom; BOTTOM will be removed in a future release", "2.2.60")
  val BOTTOM = Bottom

  /** Indicates centered vertical position. */
  val Center = new VPos(jfxg.VPos.CENTER)
  @deprecated("Use Center; CENTER will be removed in a future release", "2.2.60")
  val CENTER = Center

  /** Indicates top vertical position. */
  val Top = new VPos(jfxg.VPos.TOP)
  @deprecated("Use Top; TOP will be removed in a future release", "2.2.60")
  val TOP = Top

  protected override def unsortedValues: Array[VPos] = Array(Top, Center, Baseline, Bottom)
}


sealed case class VPos(override val delegate: jfxg.VPos)
  extends SFXEnumDelegate[jfxg.VPos]