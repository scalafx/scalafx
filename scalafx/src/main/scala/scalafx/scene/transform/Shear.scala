/*
 * Copyright (c) 2012-2013, ScalaFX Project
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
package scalafx.scene.transform

import javafx.scene.{ transform => jfxst }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate
import scalafx.delegate.PositionDelegate

object Shear {
  implicit def sfxShear2jfx(v: Shear) = v.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/scene/transform/Shear.html]]
 */
class Shear(override val delegate: jfxst.Shear = new jfxst.Shear)
  extends Transform(delegate)
  with PositionDelegate[jfxst.Shear] 
  with SFXDelegate[jfxst.Shear] {

  /**
   * Creates a new instance of Shear.
   */
  def this(x: Double, y: Double) = this(new jfxst.Shear(x, y))

  /**
   * Creates a new instance of Shear with pivot.
   */
  def this(x: Double, y: Double, pivotX: Double, pivotY: Double) = this(new jfxst.Shear(x, y, pivotX, pivotY))

  /**
   * Defines the X coordinate of the shear pivot point.
   */
  def pivotX: DoubleProperty = delegate.pivotXProperty()
  def pivotX_=(v: Double) {
    pivotX() = v
  }

  /**
   * Defines the Y coordinate of the shear pivot point.
   */
  def pivotY: DoubleProperty = delegate.pivotYProperty()
  def pivotY_=(v: Double) {
    pivotY() = v
  }

}