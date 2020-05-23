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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[scalafx.scene.control.ContentDisplay]] */
object ContentDisplay extends SFXEnumDelegateCompanion[jfxsc.ContentDisplay, ContentDisplay] {

  case object Bottom extends ContentDisplay(jfxsc.ContentDisplay.BOTTOM)
  @deprecated("Use Bottom; BOTTOM will be removed in a future release", "2.2.60")
  val BOTTOM: ContentDisplay = Bottom

  case object Center extends ContentDisplay(jfxsc.ContentDisplay.CENTER)

  @deprecated("Use Center; CENTER will be removed in a future release", "2.2.60")
  val CENTER: ContentDisplay = Center

  case object GraphicOnly extends ContentDisplay(jfxsc.ContentDisplay.GRAPHIC_ONLY)

  @deprecated("Use GraphicOnly; GRAPHIC_ONLY will be removed in a future release", "2.2.60")
  val GRAPHIC_ONLY: ContentDisplay = GraphicOnly

  case object Left extends ContentDisplay(jfxsc.ContentDisplay.LEFT)

  @deprecated("Use Left; LEFT will be removed in a future release", "2.2.60")
  val LEFT: ContentDisplay = Left

  case object Right extends ContentDisplay(jfxsc.ContentDisplay.RIGHT)

  @deprecated("Use Right; RIGHT will be removed in a future release", "2.2.60")
  val RIGHT: ContentDisplay = Right

  case object TextOnly extends ContentDisplay(jfxsc.ContentDisplay.TEXT_ONLY)

  @deprecated("Use TextOnly; TEXT_ONLY will be removed in a future release", "2.2.60")
  val TEXT_ONLY: ContentDisplay = TextOnly

  case object Top extends ContentDisplay(jfxsc.ContentDisplay.TOP)

  @deprecated("Use Top; TOP will be removed in a future release", "2.2.60")
  val TOP: ContentDisplay = Top

  protected override def unsortedValues: Array[ContentDisplay] = Array(
    Top, Right, Bottom, Left, Center, GraphicOnly, TextOnly
  )
}


sealed abstract class ContentDisplay(override val delegate: jfxsc.ContentDisplay) extends SFXEnumDelegate[jfxsc.ContentDisplay]
