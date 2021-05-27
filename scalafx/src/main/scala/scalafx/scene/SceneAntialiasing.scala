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
package scalafx.scene

import javafx.{scene => jfxs}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Specifies the level of antialiasing desired when rendering 3D primitives.
 *
 * @note In order for scene antialiasing to have an affect, the underlying system must support:
 *       ConditionalFeature.SCENE3D and anti-aliasing.
 */
object SceneAntialiasing {

  /**
   * Convert a ScalaFX scene antialiasing value to a JavaFX scene-antialiasing value.
   */
  implicit def sfxSceneAntialiasing2jfx(v: SceneAntialiasing): jfxs.SceneAntialiasing =
    if (v != null) v.delegate else null.asInstanceOf[jfxs.SceneAntialiasing]

  /**
    * Converts a JavaFX `SceneAntialiasing` to its respective `SceneAntialiasing`.
    *
    * @param e JavaFX `SceneAntialiasing`
    * @return `ScalaFX` equivalent to argument.
    */
  def apply(e: jfxs.SceneAntialiasing): SceneAntialiasing =
    if (e != null) values.find(_.delegate == e).get
    else null.asInstanceOf[SceneAntialiasing]

  /**
   * Disables antialiasing.
   */
  case object Disabled extends SceneAntialiasing(jfxs.SceneAntialiasing.DISABLED)

  /**
   * Enables antialising, optimized for a balance of quality and performance.
   */
  case object Balanced extends SceneAntialiasing(jfxs.SceneAntialiasing.BALANCED)

  /**
   * Defined SceneAntialiasing values
   */
  val values: Seq[SceneAntialiasing] = Seq(Disabled, Balanced)
}

sealed abstract class SceneAntialiasing(override val delegate: jfxs.SceneAntialiasing)
  extends SFXDelegate[jfxs.SceneAntialiasing]