/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.{ geometry => jfxg }
import javafx.scene.{ layout => jfxsl }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate
import scalafx.delegate.AlignmentDelegate
import scalafx.geometry.Insets
import scalafx.scene.Node
import scalafx.geometry.Orientation
import scalafx.geometry.HPos
import scalafx.geometry.Pos
import scalafx.geometry.VPos

object FlowPane {
  implicit def sfxFlowPane2jfx(v: FlowPane) = v.delegate

  /**
   * Removes all flowpane constraints from the child node.
   */
  def clearConstraints(child: Node) {
    jfxsl.FlowPane.clearConstraints(child)
  }

  /**
   * Added just for satisfy tests.
   */
  @deprecated("Use clearConstraints(scalafx.scene.Node) instead", "1.0")
  def clearConstraints(child: javafx.scene.Node) {
    jfxsl.FlowPane.clearConstraints(child)
  }

  /**
   * Returns the child's margin constraint if set.
   */
  def getMargin(child: Node): Insets = jfxsl.FlowPane.getMargin(child)

  /**
   * Sets the margin for the child when contained by a flowpane.
   */
  def setMargin(child: Node, value: Insets) {
    jfxsl.FlowPane.setMargin(child, value)
  }

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/FlowPane.html]]
 */
class FlowPane(override val delegate: jfxsl.FlowPane = new jfxsl.FlowPane)
  extends Pane(delegate)
  with AlignmentDelegate[jfxsl.FlowPane]
  with SFXDelegate[jfxsl.FlowPane] {

  /**
   * Creates a horizontal FlowPane layout with the specified hgap/vgap.
   */
  def this(hgap: Double, vgap: Double) = this(new jfxsl.FlowPane(hgap, vgap))

  /**
   * Creates a FlowPane layout with the specified orientation and hgap/vgap = 0.
   */
  def this(orientation: Orientation) = this(new jfxsl.FlowPane(orientation))

  /**
   * Creates a FlowPane layout with the specified orientation and hgap/vgap.
   */
  def this(orientation: Orientation, hgap: Double, vgap: Double) = this(new jfxsl.FlowPane(orientation, hgap, vgap))

  /**
   * The horizontal alignment of nodes within each column of a vertical flowpane.
   */
  def columnHalignment: ObjectProperty[jfxg.HPos] = delegate.columnHalignmentProperty
  def columnHalignment_=(v: HPos) {
    columnHalignment() = v
  }

  /**
   * The amount of horizontal space between each node in a horizontal flowpane or the space between columns in a
   * vertical flowpane.
   */
  def hgap: DoubleProperty = delegate.hgapProperty
  def hgap_=(v: Double) {
    hgap() = v
  }

  /**
   * The orientation of this flowpane.
   */
  def orientation: ObjectProperty[jfxg.Orientation] = delegate.orientationProperty
  def orientation_=(v: Orientation) {
    orientation() = v
  }

  /**
   * The preferred width where content should wrap in a horizontal flowpane or the preferred height where content
   * should wrap in a vertical flowpane.
   */
  def prefWrapLength: DoubleProperty = delegate.prefWrapLengthProperty
  def prefWrapLength_=(v: Double) {
    prefWrapLength() = v
  }

  /**
   * The vertical alignment of nodes within each row of a horizontal flowpane.
   */
  def rowValignment: ObjectProperty[jfxg.VPos] = delegate.rowValignmentProperty
  def rowValignment_=(v: VPos) {
    rowValignment() = v
  }

  /**
   * The amount of vertical space between each node in a vertical flowpane or the space between rows in a horizontal
   * flowpane.
   */
  def vgap: DoubleProperty = delegate.vgapProperty
  def vgap_=(v: Double) {
    vgap() = v
  }

}
