/*
* Copyright (c) 2012, ScalaFX Project
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

package scalafx.scene.effect

import scalafx.Includes._
import javafx.scene.{ effect => jfxse }
import scalafx.util.SFXDelegate

object FloatMap {
  implicit def sfxFloatMap2jfx(fm: FloatMap) = fm.delegate
}

class FloatMap(override val delegate: jfxse.FloatMap = new jfxse.FloatMap) extends SFXDelegate[jfxse.FloatMap] {

  def this(width: Int, height: Int) = this(new jfxse.FloatMap(width, height))

  /**
   * The height of the map, in pixels.
   */
  def height = delegate.heightProperty
  def height_=(v: Int) {
    height() = v
  }

  /**
   * The width of the map, in pixels.
   */
  def width = delegate.widthProperty
  def width_=(v: Int) {
    width() = v
  }

  /**
   * Sets the sample for a specific band at the given (x,y) location.
   */
  def setSample(x: Int, y: Int, band: Int, s: Float) = delegate.setSample(x, y, band, s)

  /**
   * Sets the sample for the first band at the given (x,y) location.
   */
  def setSamples(x: Int, y: Int, s0: Float) = delegate.setSamples(x, y, s0)

  /**
   * Sets the sample for the first two bands at the given (x,y) location.
   */
  def setSamples(x: Int, y: Int, s0: Float, s1: Float) = delegate.setSamples(x, y, s0, s1)

  /**
   * Sets the sample for the first three bands at the given (x,y) location.
   */
  def setSamples(x: Int, y: Int, s0: Float, s1: Float, s2: Float) = delegate.setSamples(x, y, s0, s1, s2)

  /**
   * Sets the sample for each of the four bands at the given (x,y) location.
   */
  def setSamples(x: Int, y: Int, s0: Float, s1: Float, s2: Float, s3: Float) = delegate.setSamples(x, y, s0, s1, s2, s3)

}