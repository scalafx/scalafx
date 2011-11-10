/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.scene.layout

import javafx.{geometry => jfxg}
import javafx.scene.{layout => jfxsl}
import scalafx.Includes._
import scalafx.util.SFXDelegate

object TilePane {
  implicit def sfxTilePane2jfx(v: TilePane) = v.delegate
}

class TilePane(override val delegate:jfxsl.TilePane = new jfxsl.TilePane()) extends Pane with SFXDelegate[jfxsl.TilePane] {
  /**
   * Renamed from alignment to avoid a conflict with the pseudo-property for alignment on Node
   */
  def innerAlignment = delegate.alignmentProperty
  def innerAlignment_=(v: jfxg.Pos) {
    innerAlignment() = v
  }

  def hgap = delegate.hgapProperty
  def hgap_=(v: Double) {
    hgap() = v
  }

  def orientation = delegate.orientationProperty
  def orientation_=(v: jfxg.Orientation) {
    orientation() = v
  }

  def prefColumns = delegate.prefColumnsProperty
  def prefColumns_=(v: Int) {
    prefColumns() = v
  }

  def prefRows = delegate.prefRowsProperty
  def prefRows_=(v: Int) {
    prefRows() = v
  }

  def prefTileHeight = delegate.prefTileHeightProperty
  def prefTileHeight_=(v: Double) {
    prefTileHeight() = v
  }

  def prefTileWidth = delegate.prefTileWidthProperty
  def prefTileWidth_=(v: Double) {
    prefTileWidth() = v
  }

  def tileAlignment = delegate.tileAlignmentProperty
  def tileAlignment_=(v: jfxg.Pos) {
    tileAlignment() = v
  }

  def tileHeight = delegate.tileHeightProperty

  def tileWidth = delegate.tileWidthProperty

  def vgap = delegate.vgapProperty
  def vgap_=(v: Double) {
    vgap() = v
  }
}
