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
package scalafx.scene.effect

import javafx.scene.{effect => jfxse}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate

object DisplacementMap {
  implicit def sfxDisplacementMap2jfx(dm: DisplacementMap) = dm.delegate
}

class DisplacementMap(override val delegate: jfxse.DisplacementMap = new jfxse.DisplacementMap)
  extends Effect(delegate)
  with InputDelegate[jfxse.DisplacementMap]
  with SFXDelegate[jfxse.DisplacementMap] {

  /**
   * Creates a new instance of DisplacementMap with the specified mapData.
   */
  def this(mapData: FloatMap) = this(new jfxse.DisplacementMap(mapData))

  /**
   * Creates a new instance of DisplacementMap with the specified mapData, offsetX, offsetY, scaleX, and scaleY.
   */
  def this(mapData: FloatMap, offsetX: Double, offsetY: Double, scaleX: Double, scaleY: Double) = this(new jfxse.DisplacementMap(mapData, offsetX, offsetY, scaleX, scaleY))

  /**
   * The map data for this Effect.
   */
  def mapData: ObjectProperty[jfxse.FloatMap] = delegate.mapDataProperty
  def mapData_=(v: FloatMap) {
    mapData() = v
  }

  /**
   * The offset by which all x coordinate offset values in the FloatMap are displaced after they are scaled.
   */
  def offsetX: DoubleProperty = delegate.offsetXProperty
  def offsetX_=(v: Double) {
    offsetX() = v
  }

  /**
   * The offset by which all y coordinate offset values in the FloatMap are displaced after they are scaled.
   */
  def offsetY: DoubleProperty = delegate.offsetYProperty
  def offsetY_=(v: Double) {
    offsetX() = v
  }

  /**
   * The scale factor by which all x coordinate offset values in the FloatMap are multiplied.
   */
  def scaleX: DoubleProperty = delegate.scaleXProperty
  def scaleX_=(v: Double) {
    scaleX() = v
  }

  /**
   * The scale factor by which all y coordinate offset values in the FloatMap are multiplied.
   */
  def scaleY: DoubleProperty = delegate.scaleYProperty
  def scaleY_=(v: Double) {
    scaleY() = v
  }

  /**
   * Defines whether values taken from outside the edges of the map "wrap around" or not.
   */
  def wrap: BooleanProperty = delegate.wrapProperty
  def wrap_=(v: Boolean) {
    wrap() = v
  }

}