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

import javafx.{ geometry => jfxg }
import javafx.{ scene => jfxs }
import javafx.scene.{ layout => jfxsl }
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.delegate.AlignmentDelegate
import scalafx.geometry.Insets
import scalafx.scene.Node
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.BooleanProperty

object VBox {
  implicit def sfxVBox2jfx(v: VBox) = v.delegate

  /**
   * Removes all vbox constraints from the child node.
   */
  def clearConstraints(child: jfxs.Node) {
    jfxsl.VBox.clearConstraints(child)
  }

  /**
   * Returns the child's margin constraint if set.
   */
  def getMargin(child: Node) = jfxsl.VBox.getMargin(child)

  /**
   * Sets the margin for the child when contained by a vbox.
   */
  def setMargin(child: Node, value: Insets) {
    jfxsl.VBox.setMargin(child, value)
  }

  /**
   * Returns the child's vgrow constraint if set.
   */
  def getVgrow(child: Node) = jfxsl.VBox.getVgrow(child)

  /**
   * Sets the vertical grow priority for the child when contained by a vbox.
   */
  def setVgrow(child: Node, value: Priority) {
    jfxsl.VBox.setVgrow(child, value)
  }

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/VBox.html]]
 */
class VBox(override val delegate: jfxsl.VBox = new jfxsl.VBox)
  extends Pane(delegate)
  with AlignmentDelegate[jfxsl.VBox]
  with SFXDelegate[jfxsl.VBox] {

  /**
   * Creates a VBox layout with the specified spacing between children.
   */
  def this(spacing: Double) = this(new jfxsl.VBox(spacing))

  /**
   * The amount of vertical space between each child in the vbox.
   */
  def spacing: DoubleProperty = delegate.spacingProperty
  def spacing_=(v: Double) {
    spacing() = v
  }

  /**
   * Whether or not resizable children will be resized to fill the full width of the vbox or be
   * kept to their preferred width and aligned according to the alignment hpos value.
   */
  def fillWidth: BooleanProperty = delegate.fillWidthProperty
  def fillWidth_=(v: Boolean) {
    fillWidth() = v
  }

  /**
   * Returns the orientation of a node's resizing bias for layout purposes.
   */
  def getContentBias = delegate.getContentBias

  /**
   * Requests a layout pass to be performed before the next scene is rendered.
   */
  def requestLayout() {
    delegate.requestLayout()
  }

}
