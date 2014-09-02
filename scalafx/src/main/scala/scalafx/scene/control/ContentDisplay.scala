/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
import scalafx.delegate.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

/** Wrapper for [[scalafx.scene.control.ContentDisplay]] */
object ContentDisplay extends SFXEnumDelegateCompanion[jfxsc.ContentDisplay, ContentDisplay] {

  val Bottom = new ContentDisplay(jfxsc.ContentDisplay.BOTTOM)
  @deprecated ("Use Bottom; BOTTOM will be removed in a future release", "2.2.60")
  val BOTTOM = Bottom
  val Center = new ContentDisplay(jfxsc.ContentDisplay.CENTER)
  @deprecated ("Use Center; CENTER will be removed in a future release", "2.2.60")
  val CENTER = Center
  val GraphicOnly = new ContentDisplay(jfxsc.ContentDisplay.GRAPHIC_ONLY)
  @deprecated ("Use GraphicOnly; GRAPHIC_ONLY will be removed in a future release", "2.2.60")
  val GRAPHIC_ONLY = GraphicOnly
  val Left = new ContentDisplay(jfxsc.ContentDisplay.LEFT)
  @deprecated ("Use Left; LEFT will be removed in a future release", "2.2.60")
  val LEFT = Left
  val Right = new ContentDisplay(jfxsc.ContentDisplay.RIGHT)
  @deprecated ("Use Right; RIGHT will be removed in a future release", "2.2.60")
  val RIGHT = Right
  val TextOnly = new ContentDisplay(jfxsc.ContentDisplay.TEXT_ONLY)
  @deprecated ("Use TextOnly; TEXT_ONLY will be removed in a future release", "2.2.60")
  val TEXT_ONLY = TextOnly
  val Top = new ContentDisplay(jfxsc.ContentDisplay.TOP)
  @deprecated ("Use Top; TOP will be removed in a future release", "2.2.60")
  val TOP = Top

  protected override def unsortedValues: Array[ContentDisplay] = Array(
    Top, Right, Bottom, Left, Center, GraphicOnly, TextOnly
  )
}


sealed case class ContentDisplay(override val delegate: jfxsc.ContentDisplay) extends SFXEnumDelegate[jfxsc.ContentDisplay]
