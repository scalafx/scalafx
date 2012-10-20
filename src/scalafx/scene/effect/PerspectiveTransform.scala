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

import javafx.scene.{ effect => jfxse }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.scene.paint.Color
import scalafx.util.SFXDelegate

object PerspectiveTransform {
  implicit def sfxPerspectiveTransform2jfx(pt: PerspectiveTransform) = pt.delegate
}

class PerspectiveTransform(override val delegate: jfxse.PerspectiveTransform = new jfxse.PerspectiveTransform)
  extends Effect(delegate)
  with InputDelegate[jfxse.PerspectiveTransform]
  with SFXDelegate[jfxse.PerspectiveTransform] {

  /**
   * Creates a new instance of PerspectiveTransform with the specified ulx, uly, urx, ury, lrx, lry, llx, and lly.
   */
  def this(ulx: Double, uly: Double, urx: Double, ury: Double, lrx: Double, lry: Double, llx: Double, lly: Double) = this(new jfxse.PerspectiveTransform(ulx, uly, urx, ury, lrx, lry, llx, lly))

  /**
   * The x coordinate of the output location onto which the lower left corner of the source is mapped.
   */
  def llx: DoubleProperty = delegate.llxProperty
  def llx_=(v: Double) {
    llx() = v
  }

  /**
   * The y coordinate of the output location onto which the lower left corner of the source is mapped.
   */
  def lly: DoubleProperty = delegate.llyProperty
  def lly_=(v: Double) {
    lly() = v
  }

  /**
   * The x coordinate of the output location onto which the lower right corner of the source is mapped.
   */
  def lrx: DoubleProperty = delegate.lrxProperty
  def lrx_=(v: Double) {
    lrx() = v
  }

  /**
   * The y coordinate of the output location onto which the lower right corner of the source is mapped.
   */
  def lry: DoubleProperty = delegate.lryProperty
  def lry_=(v: Double) {
    lry() = v
  }

  /**
   * The x coordinate of the output location onto which the upper left corner of the source is mapped.
   */
  def ulx: DoubleProperty = delegate.ulxProperty
  def ulx_=(v: Double) {
    ulx() = v
  }

  /**
   * The y coordinate of the output location onto which the upper left corner of the source is mapped.
   */
  def uly: DoubleProperty = delegate.ulyProperty
  def uly_=(v: Double) {
    uly() = v
  }

  /**
   * The x coordinate of the output location onto which the upper right corner of the source is mapped.
   */
  def urx: DoubleProperty = delegate.urxProperty
  def urx_=(v: Double) {
    urx() = v
  }

  /**
   * The y coordinate of the output location onto which the upper right corner of the source is mapped.
   */
  def ury: DoubleProperty = delegate.uryProperty
  def ury_=(v: Double) {
    ury() = v
  }

}
