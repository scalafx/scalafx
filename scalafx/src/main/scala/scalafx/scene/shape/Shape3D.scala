/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import javafx.scene.{paint => jfxsp, shape => jfxss}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.paint.Material

import scala.language.implicitConversions

object Shape3D {
  implicit def sfxShape3D2jfx(v: Shape3D): jfxss.Shape3D = if (v != null) v.delegate else null
}

/** Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/shape/Shape3D.html]]. */
abstract class Shape3D(override val delegate: jfxss.Shape3D)
    extends Node(delegate)
    with SFXDelegate[jfxss.Shape3D] {

  /** Defines the cullFace this Shape3D. */
  def cullFace: ObjectProperty[jfxss.CullFace] = delegate.cullFaceProperty

  def cullFace_=(v: CullFace): Unit = {
    ObjectProperty.fillProperty[jfxss.CullFace](this.cullFace, v)
  }

  /** Defines the drawMode this Shape3D. */
  def drawMode: ObjectProperty[jfxss.DrawMode] = delegate.drawModeProperty

  def drawMode_=(v: DrawMode): Unit = {
    ObjectProperty.fillProperty[jfxss.DrawMode](this.drawMode, v)
  }

  /** Defines the material this Shape3D. */
  def material: ObjectProperty[jfxsp.Material] = delegate.materialProperty

  def material_=(v: Material): Unit = {
    ObjectProperty.fillProperty[jfxsp.Material](this.material, v)
  }
}
