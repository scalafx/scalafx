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
package scalafx.scene.control

import javafx.geometry as jfxg
import javafx.scene.control as jfxsc
import scalafx.Includes.*
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate
import scalafx.geometry.{HPos, Orientation, VPos}

import scala.language.implicitConversions

object Separator {
  implicit def sfxSeparator2jfx(v: Separator): jfxsc.Separator = if (v != null) v.delegate else null

  /**
   * Create new separator with provided orientation.
   */
  def apply(orientation: Orientation): Separator = new jfxsc.Separator(orientation)
}

class Separator(override val delegate: jfxsc.Separator = new jfxsc.Separator) extends Control(delegate)
    with SFXDelegate[jfxsc.Separator] {

  def halignment: ObjectProperty[jfxg.HPos] = delegate.halignmentProperty

  def halignment_=(v: HPos): Unit = {
    halignment() = v
  }

  def valignment: ObjectProperty[jfxg.VPos] = delegate.valignmentProperty

  def valignment_=(v: VPos): Unit = {
    valignment() = v
  }

  def orientation: ObjectProperty[jfxg.Orientation] = delegate.orientationProperty

  def orientation_=(v: Orientation): Unit = {
    orientation() = v
  }

}
