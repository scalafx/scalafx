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
package scalafx.scene

import javafx.scene as jfxs
import scalafx.Includes.*
import scalafx.beans.property.{BooleanProperty, DoubleProperty}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object PerspectiveCamera {
  implicit def sfxPerspectiveCamera2jfx(c: PerspectiveCamera): jfxs.PerspectiveCamera =
    if (c != null) c.delegate else null
}

class PerspectiveCamera(override val delegate: jfxs.PerspectiveCamera = new jfxs.PerspectiveCamera)
    extends Camera(delegate) with SFXDelegate[jfxs.PerspectiveCamera] {

  /** Constructs a PerspectiveCamera with the specified fixedEyeAtCameraZero flag. */
  def this(fixedEyeAtCameraZero: Boolean) = this(new jfxs.PerspectiveCamera(fixedEyeAtCameraZero))

  /**
   * Specifies the vertical angle of the camera's projection.
   */
  def fieldOfView: DoubleProperty = delegate.fieldOfViewProperty

  def fieldOfView_=(v: Double): Unit = {
    fieldOfView() = v
  }

  /**
   * Defines whether the `fieldOfView` property is to apply to the vertical dimension of the projection plane.
   */
  def verticalFieldOfView: BooleanProperty = delegate.verticalFieldOfViewProperty

  def verticalFieldOfView_=(v: Boolean): Unit = {
    verticalFieldOfView() = v
  }

  def isFixedEyeAtCameraZero: Boolean = delegate.isFixedEyeAtCameraZero
}
