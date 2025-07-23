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

package scalafx.stage

import javafx.stage as jfxs
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/stage/Modality.html javafx.stage.Modality]] */
object Modality
    extends SFXEnumDelegateCompanion[jfxs.Modality, Modality] {

  /**
   * Defines a top-level window that is not modal and does not block any other window.
   */
  case object None extends Modality(jfxs.Modality.NONE)
  @deprecated("Use None; NONE will be removed in a future release", "8.0.60-R10")
  val NONE: Modality = None

  /**
   * Defines a modal window that block events from being delivered to its entire owner window hierarchy.
   */
  case object WindowModal extends Modality(jfxs.Modality.WINDOW_MODAL)

  @deprecated("Use WindowModal; WINDOW_MODAL will be removed in a future release", "8.0.60-R10")
  val WINDOW_MODAL: Modality = WindowModal

  /**
   * Defines a modal window that blocks events from being delivered to any other application window.
   */
  case object ApplicationModal extends Modality(jfxs.Modality.APPLICATION_MODAL)

  @deprecated("Use ApplicationModal; APPLICATION_MODAL will be removed in a future release", "8.0.60-R10")
  val APPLICATION_MODAL: Modality = ApplicationModal

  protected override def unsortedValues: Array[Modality] = Array(None, WindowModal, ApplicationModal)
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/stage/Modality.html javafx.stage.Modality]].
 */
sealed abstract class Modality(override val delegate: jfxs.Modality)
    extends SFXEnumDelegate[jfxs.Modality]
