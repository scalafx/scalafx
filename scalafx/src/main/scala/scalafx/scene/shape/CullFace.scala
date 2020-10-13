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

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/CullFace.html javafx.scene.shape.CullFace]] */
object CullFace extends SFXEnumDelegateCompanion[jfxss.CullFace, CullFace] {

  /**
   * Perform back-face culling.
   *
   * All back-faces, identified by clockwise vertex winding, will be culled.
   */
  case object Back extends CullFace(jfxss.CullFace.BACK)

  /**
   * Perform back-face culling.
   *
   * All back-faces, identified by clockwise vertex winding, will be culled.
   */
  @deprecated("Use Back instead; BACK will be removed in a future release.", "8.0.0-M4")
  val BACK: CullFace = Back

  /**
   * Perform front-face culling.
   *
   * All front-faces, identified by counterclockwise vertex winding, will be culled.
   */
  case object Front extends CullFace(jfxss.CullFace.FRONT)

  /**
   * Perform front-face culling.
   *
   * All front-faces, identified by counterclockwise vertex winding, will be culled.
   */
  @deprecated("Use Front instead; FRONT will be removed in a future release.", "8.0.0-M4")
  val FRONT: CullFace = Front

  /**
   * Perform no face culling.
   */
  case object None extends CullFace(jfxss.CullFace.NONE)

  /**
   * Perform no face culling.
   */
  @deprecated("Use None instead; NONE will be removed in a future release.", "8.0.0-M4")
  val NONE: CullFace = None

  protected override def unsortedValues: Array[CullFace] = Array(Back, Front, None)
}

sealed abstract class CullFace(override val delegate: jfxss.CullFace)
  extends SFXEnumDelegate[jfxss.CullFace]


