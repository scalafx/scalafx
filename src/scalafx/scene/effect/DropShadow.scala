package scalafx.scene.effect

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

import scalafx.Includes._
import javafx.scene.{effect => jfxse, paint => jfxsp}
import scalafx.util.SFXDelegate

object DropShadow {
  implicit def sfxDropShadow2jfx(ds: DropShadow) = ds.delegate
}

class DropShadow(override val delegate: jfxse.DropShadow = new jfxse.DropShadow()) extends Effect(delegate) with SFXDelegate[jfxse.DropShadow] {

  def color = delegate.colorProperty
  def color_= (c: jfxsp.Color) {
    color() = c
  }

  def blurType = delegate.blurTypeProperty
  def blurType_= (bt: jfxse.BlurType) {
    blurType() = bt
  }

  def height = delegate.heightProperty
  def height_= (d: Double) {
    height() = d
  }

  def input = delegate.inputProperty
  def input_= (e: jfxse.Effect) {
    input() = e
  }

  def offsetX = delegate.offsetXProperty
  def offsetX_= (d: Double) {
    offsetX() = d
  }

  def offsetY = delegate.offsetYProperty
  def offsetY_= (d: Double) {
    offsetY() = d
  }

  def radius = delegate.radiusProperty
  def radius_= (d: Double) {
    radius() = d
  }

  def spread = delegate.spreadProperty
  def spread_= (d: Double) {
    spread() = d
  }

  def width = delegate.widthProperty
  def width_= (d: Double) {
    width() = d
  }
}