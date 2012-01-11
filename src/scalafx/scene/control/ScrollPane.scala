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

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import jfxsc.ScrollPane.ScrollBarPolicy
import javafx.geometry.Bounds

import scalafx.Includes._
import scalafx.util.SFXDelegate
import javafx.{scene => jfxs}

object ScrollPane {
  implicit def sfxScrollPane2jfx(v: ScrollPane) = v.delegate
}

class ScrollPane(override val delegate:jfxsc.ScrollPane = new jfxsc.ScrollPane) extends SFXDelegate[jfxsc.ScrollPane] {

  def content = delegate.contentProperty
  def content_= (v: jfxs.Node) {
    content() = v
  }

  def fitToHeight = delegate.fitToHeightProperty
  def fitToHeight_= (v: Boolean) {
    fitToHeight() = v
  }

  def fitToWidth = delegate.fitToWidthProperty
  def fitToWidth_= (v: Boolean) {
    fitToWidth() = v
  }

  def hbarPolicy = delegate.hbarPolicyProperty
  def hbarPolicy_= (v: ScrollBarPolicy) {
    hbarPolicy() = v
  }

  def hmax = delegate.hmaxProperty
  def hmax_= (v: Double) {
    hmax() = v
  }

  def hmin = delegate.hminProperty
  def hmin_= (v: Double) {
    hmin() = v
  }

  def hvalue = delegate.hvalueProperty
  def hvalue_= (v: Double) {
    hvalue() = v
  }

  def pannable = delegate.pannableProperty
  def pannable_= (v: Boolean) {
    pannable() = v
  }

  def prefViewportHeight = delegate.prefViewportHeightProperty
  def prefViewportHeight_= (v: Double) {
    prefViewportHeight() = v
  }

  def prefViewportWidth = delegate.prefViewportWidthProperty
  def prefViewportWidth_= (v: Double) {
    prefViewportWidth() = v
  }

  def vbarPolicy = delegate.vbarPolicyProperty
  def vbarPolicy_= (v: ScrollBarPolicy) {
    vbarPolicy() = v
  }

  def viewportBounds = delegate.viewportBoundsProperty
  def viewportBounds_= (v: Bounds) {
    viewportBounds() = v
  }

  def vmax = delegate.vmaxProperty
  def vmax_= (v: Double) {
    vmax() = v
  }

  def vmin = delegate.vminProperty
  def vmin_= (v: Double) {
    vmin() = v
  }

  def vvalue = delegate.vvalueProperty
  def vvalue_= (v: Double) {
    vvalue() = v
  }
}
