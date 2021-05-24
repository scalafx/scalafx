/*
 * Copyright (c) 2011-2020, ScalaFX Project
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

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Side.html javafx.geometry.Side]] */
object Side extends SFXEnumDelegateCompanion[jfxg.Side, Side] {

  case object Bottom extends Side(jfxg.Side.BOTTOM)
  @deprecated("Use Bottom; BOTTOM will be removed in a future release", "8.0.60-R10")
  val BOTTOM: Side = Bottom

  case object Left extends Side(jfxg.Side.LEFT)

  @deprecated("Use Left; LEFT will be removed in a future release", "8.0.60-R10")
  val LEFT: Side = Left

  case object Right extends Side(jfxg.Side.RIGHT)

  @deprecated("Use Right; RIGHT will be removed in a future release", "8.0.60-R10")
  val RIGHT: Side = Right

  case object Top extends Side(jfxg.Side.TOP)

  @deprecated("Use Top; TOP will be removed in a future release", "8.0.60-R10")
  val TOP: Side = Top

  protected override def unsortedValues: Array[Side] = Array(Top, Bottom, Left, Right)
}

sealed abstract class Side(override val delegate: jfxg.Side) extends SFXEnumDelegate[jfxg.Side] {

  /** Indicates whether this is horizontal side of a rectangle (returns true for `TOP` and `BOTTOM`). */
  def isHorizontal: Boolean = delegate.isHorizontal

  /** Indicates whether this is vertical side of a rectangle (returns true for `LEFT` and `RIGHT`). */
  def isVertical: Boolean = delegate.isVertical
}
