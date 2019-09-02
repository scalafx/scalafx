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

package scalafx.scene.text

import javafx.scene.{text => jfxst}
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/TextAlignment.html javafx.scene.text.TextAlignment]] */
object TextAlignment extends SFXEnumDelegateCompanion[jfxst.TextAlignment, TextAlignment] {

  case object Left extends TextAlignment(jfxst.TextAlignment.LEFT)
  @deprecated("Use Left; LEFT will be removed in a future release", "2.2.60")
  val LEFT = Left

  case object Center extends TextAlignment(jfxst.TextAlignment.CENTER)
  @deprecated("Use Center; CENTER will be removed in a future release", "2.2.60")
  val CENTER = Center

  case object Right extends TextAlignment(jfxst.TextAlignment.RIGHT)
  @deprecated("Use Right; RIGHT will be removed in a future release", "2.2.60")
  val RIGHT = Right

  case object Justify extends TextAlignment(jfxst.TextAlignment.JUSTIFY)
  @deprecated("Use Justify; JUSTIFY will be removed in a future release", "2.2.60")
  val JUSTIFY = Justify

  protected override def unsortedValues: Array[TextAlignment] = Array(Left, Center, Right, Justify)
}

sealed abstract class TextAlignment(override val delegate: jfxst.TextAlignment)
    extends SFXEnumDelegate[jfxst.TextAlignment]
