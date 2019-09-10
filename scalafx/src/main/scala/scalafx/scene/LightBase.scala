/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

import javafx.scene.{paint => jfxsp}
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, ObjectProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.scene.paint.Color

import scala.language.implicitConversions

object LightBase {
  implicit def sfxLightBase2jfx(lb: LightBase): jfxs.LightBase = if (lb != null) lb.delegate else null
}


/** The LightBase class provides definitions of common properties for objects that represent a form of Light source. */
abstract class LightBase(override val delegate: jfxs.LightBase)
  extends Node(delegate)
  with SFXDelegate[jfxs.LightBase] {

  /** Specifies the color of light source. */
  def color: ObjectProperty[jfxsp.Color] = delegate.colorProperty

  def color_=(v: Color): Unit = {
    ObjectProperty.fillProperty[jfxsp.Color](this.color, v)
  }

  /** Defines the light on or off. */
  def lightOn: BooleanProperty = delegate.lightOnProperty

  def lightOn_=(v: Boolean): Unit = {
    lightOn() = v
  }

  /** Gets the list of nodes that specifies the hierarchical scope of this Light. */
  def scope: ObservableBuffer[jfxs.Node] = delegate.getScope
}