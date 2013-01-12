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
import javafx.scene.{ image => jfxsi }
import scalafx.delegate.SFXDelegate
import scalafx.scene.image.Image
import scalafx.delegate.PositionDelegate

object ImageInput {
  implicit def sfxImageInput2jfx(ii: ImageInput) = ii.delegate
}

class ImageInput(override val delegate: jfxse.ImageInput = new jfxse.ImageInput)
  extends Effect(delegate)
  with PositionDelegate[jfxse.ImageInput]
  with SFXDelegate[jfxse.ImageInput] {

  /**
   * Creates a new instance of ImageInput with the specified source.
   */
  def this(source: Image) = this(new jfxse.ImageInput(source))

  /**
   * Creates a new instance of ImageInput with the specified source, x and y.
   */
  def this(source: Image, x: Double, y: Double) = this(new jfxse.ImageInput(source, x, y))

  /**
   * The source Image.
   */
  def source = delegate.sourceProperty
  def source_=(v: Image) {
    source() = v
  }

}