/*
* Copyright (c) 2011-2014, ScalaFX Project
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

import scala.language.implicitConversions
import javafx.scene.{shape => jfxss}
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate


object Box {
  implicit def sfxBox2jfx(v: Box) = if (v != null) v.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/shape/Box.html]].
 */
class Box(override val delegate: jfxss.Box = new jfxss.Box())
  extends Shape3D(delegate)
  with SFXDelegate[jfxss.Box] {

  def this(width: Double, height: Double, depth: Double) = this(new jfxss.Box(width, height, depth))

  /** Defines the depth or the Z dimension of the Box. */
  def depth: DoubleProperty = delegate.depthProperty
  def depth_=(v: Double) {
    depth() = v
  }

  /** Defines the height or the Y dimension of the Box. */
  def height: DoubleProperty = delegate.heightProperty
  def height_=(v: Double) {
    height() = v
  }

  /** Defines the width or the Z dimension of the Box. */
  def width: DoubleProperty = delegate.widthProperty
  def width_=(v: Double) {
    width() = v
  }
}
