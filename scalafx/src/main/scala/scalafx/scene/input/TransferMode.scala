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

package scalafx.scene.input

import javafx.scene.{input => jfxsi}
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/TransferMode.html javafx.scene.input.TransferMode]] */
object TransferMode extends SFXEnumDelegateCompanion[jfxsi.TransferMode, TransferMode] {

  case object Copy extends TransferMode(jfxsi.TransferMode.COPY)
  @deprecated("Use Copy; COPY will be removed in a future release", "8.0.60-R10")
  val COPY = Copy

  case object Move extends TransferMode(jfxsi.TransferMode.MOVE)
  @deprecated("Use Move; MOVE will be removed in a future release", "8.0.60-R10")
  val MOVE = Move

  case object Link extends TransferMode(jfxsi.TransferMode.LINK)
  @deprecated("Use Link; LINK will be removed in a future release", "8.0.60-R10")
  val LINK = Link

  /** Array containing all transfer modes. */
  val Any = jfxsi.TransferMode.ANY
  @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY = Any

  /** Array containing transfer modes COPY and MOVE. */
  val CopyOrMove = jfxsi.TransferMode.COPY_OR_MOVE
  @deprecated("Use CopyOrMove; COPY_OR_MOVE will be removed in a future release", "8.0.60-R10")
  val COPY_OR_MOVE = CopyOrMove

  /** Empty array of transfer modes. */
  val None = jfxsi.TransferMode.NONE
  @deprecated("Use None; NONE will be removed in a future release", "8.0.60-R10")
  val NONE = None

  protected override def unsortedValues: Array[TransferMode] = Array(Copy, Move, Link)
}

sealed abstract class TransferMode(override val delegate: jfxsi.TransferMode)
    extends SFXEnumDelegate[jfxsi.TransferMode]
