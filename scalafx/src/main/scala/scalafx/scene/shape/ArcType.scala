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

package scalafx.scene.shape

import javafx.scene.{shape => jfxss}
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/ArcType.html javafx.scene.shape.ArcType]] */
object ArcType extends SFXEnumDelegateCompanion[jfxss.ArcType, ArcType] {

  case object Open extends ArcType(jfxss.ArcType.OPEN)
  @deprecated("Use Open; OPEN will be removed in a future release", "2.2.60")
  val OPEN: ArcType = Open

  case object Chord extends ArcType(jfxss.ArcType.CHORD)

  @deprecated("Use Chord; CHORD will be removed in a future release", "2.2.60")
  val CHORD: ArcType = Chord

  case object Round extends ArcType(jfxss.ArcType.ROUND)

  @deprecated("Use Round; ROUND will be removed in a future release", "2.2.60")
  val ROUND: ArcType = Round

  protected override def unsortedValues: Array[ArcType] = Array(Open, Chord, Round)
}


sealed abstract class ArcType(override val delegate: jfxss.ArcType)
  extends SFXEnumDelegate[jfxss.ArcType]
