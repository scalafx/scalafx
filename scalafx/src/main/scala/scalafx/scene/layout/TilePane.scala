/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import javafx.scene.{layout => jfxsl}
import javafx.{geometry => jfxg, scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, IntegerProperty, ObjectProperty, ReadOnlyDoubleProperty}
import scalafx.delegate.{AlignmentDelegate, SFXDelegate}
import scalafx.geometry.{Insets, Orientation, Pos}
import scalafx.scene.Node

import scala.language.implicitConversions

object TilePane {
  implicit def sfxTilePane2jfx(v: TilePane): jfxsl.TilePane = if (v != null) v.delegate else null

  /**
   * Removes all hbox constraints from the child node.
   */
  def clearConstraints(child: jfxs.Node): Unit = {
    jfxsl.TilePane.clearConstraints(child)
  }

  /**
   * Returns the child's alignment constraint if set.
   */
  def getAlignment(child: Node): Pos = jfxsl.TilePane.getAlignment(child)

  /**
   * Sets the alignment for the child when contained by a stackpane.
   */
  def setAlignment(child: Node, value: Pos): Unit = {
    jfxsl.TilePane.setAlignment(child, value)
  }

  /**
   * Returns the child's margin constraint if set.
   */
  def getMargin(child: Node): Insets = jfxsl.TilePane.getMargin(child)

  /**
   * Sets the margin for the child when contained by an hbox.
   */
  def setMargin(child: Node, value: Insets): Unit = {
    jfxsl.TilePane.setMargin(child, value)
  }

}

class TilePane(override val delegate: jfxsl.TilePane = new jfxsl.TilePane)
    extends Pane(delegate)
    with AlignmentDelegate[jfxsl.TilePane]
    with SFXDelegate[jfxsl.TilePane] {

  /**
   * The amount of horizontal space between each tile in a row.
   */
  def hgap: DoubleProperty = delegate.hgapProperty

  def hgap_=(v: Double): Unit = {
    hgap() = v
  }

  /**
   * The orientation of this tilepane.
   */
  def orientation: ObjectProperty[jfxg.Orientation] = delegate.orientationProperty

  def orientation_=(v: Orientation): Unit = {
    orientation() = v
  }

  /**
   * The preferred number of columns for a horizontal tilepane.
   */
  def prefColumns: IntegerProperty = delegate.prefColumnsProperty

  def prefColumns_=(v: Int): Unit = {
    prefColumns() = v
  }

  /**
   * The preferred number of rows for a vertical tilepane.
   */
  def prefRows: IntegerProperty = delegate.prefRowsProperty

  def prefRows_=(v: Int): Unit = {
    prefRows() = v
  }

  /**
   * The preferred height of each tile.
   */
  def prefTileHeight: DoubleProperty = delegate.prefTileHeightProperty

  def prefTileHeight_=(v: Double): Unit = {
    prefTileHeight() = v
  }

  /**
   * The preferred width of each tile.
   */
  def prefTileWidth: DoubleProperty = delegate.prefTileWidthProperty

  def prefTileWidth_=(v: Double): Unit = {
    prefTileWidth() = v
  }

  /**
   * The default alignment of each child within its tile.
   */
  def tileAlignment: ObjectProperty[jfxg.Pos] = delegate.tileAlignmentProperty

  def tileAlignment_=(v: Pos): Unit = {
    tileAlignment() = v
  }

  /**
   * The actual height of each tile.
   */
  def tileHeight: ReadOnlyDoubleProperty = delegate.tileHeightProperty

  /**
   * The actual width of each tile.
   */
  def tileWidth: ReadOnlyDoubleProperty = delegate.tileWidthProperty

  /**
   * The amount of vertical space between each tile in a column.
   */
  def vgap: DoubleProperty = delegate.vgapProperty

  def vgap_=(v: Double): Unit = {
    vgap() = v
  }

  /**
   * Returns the orientation of a node's resizing bias for layout purposes.
   */
  def getContentBias: Orientation = delegate.getContentBias

  /**
   * Requests a layout pass to be performed before the next scene is rendered.
   */
  def requestLayout(): Unit = {
    delegate.requestLayout()
  }

}
