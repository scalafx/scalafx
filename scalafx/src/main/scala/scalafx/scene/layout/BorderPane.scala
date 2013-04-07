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
import javafx.{ scene => jfxs }
import javafx.scene.{ layout => jfxsl }
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.geometry.Insets._
import scalafx.geometry.Insets
import scalafx.scene.Node._
import scalafx.scene.Node
import scalafx.delegate.SFXDelegate

object BorderPane {
  implicit def sfxBorderPane2jfx(v: BorderPane) = v.delegate

  /**
   * Removes all borderpane constraints from the child node.
   */
  def clearConstraints(child: javafx.scene.Node) = jfxsl.BorderPane.clearConstraints(child)

  /**
   * Returns the child's alignment constraint if set.
   */
  def getAlignment(child: Node) = jfxsl.BorderPane.getAlignment(child)

  /**
   * Returns the child's margin constraint if set.
   */
  def getMargin(child: Node): Insets = jfxsl.BorderPane.getMargin(child)

  /**
   * Sets the alignment for the child when contained by a borderpane.
   */
  def setAlignment(child: Node, value: jfxg.Pos) = jfxsl.BorderPane.setAlignment(child, value)

  /**
   * Sets the margin for the child when contained by a borderpane.
   */
  def setMargin(child: Node, value: Insets) = jfxsl.BorderPane.setMargin(child, value)
}

class BorderPane(override val delegate: jfxsl.BorderPane = new jfxsl.BorderPane()) extends Pane(delegate) with SFXDelegate[jfxsl.BorderPane] {

  /**
   * The node placed on the bottom edge of this border pane.
   */
  def bottom: ObjectProperty[jfxs.Node] = delegate.bottomProperty()
  def bottom_=(v: Node) {
    ObjectProperty.fillProperty[jfxs.Node](this.bottom, v)
  }

  /**
   * The node placed in the center of this border pane.
   */
  def center: ObjectProperty[jfxs.Node] = delegate.centerProperty()
  def center_=(v: Node) {
    ObjectProperty.fillProperty[jfxs.Node](this.center, v)
  }

  /**
   * The node placed on the left edge of this border pane.
   */
  def left: ObjectProperty[jfxs.Node] = delegate.leftProperty()
  def left_=(v: Node) {
    ObjectProperty.fillProperty[jfxs.Node](this.left, v)
  }

  /**
   * The node placed on the right edge of this border pane.
   */
  def right: ObjectProperty[jfxs.Node] = delegate.rightProperty()
  def right_=(v: Node) {
    ObjectProperty.fillProperty[jfxs.Node](this.right, v)
  }

  /**
   * The node placed on the top edge of this border pane.
   */
  def top: ObjectProperty[jfxs.Node] = delegate.topProperty()
  def top_=(v: Node) {
    ObjectProperty.fillProperty[jfxs.Node](this.top, v)
  }

  /**
   * Returns the orientation of a node's resizing bias for layout purposes.
   */
  def contentBias = delegate.getContentBias
}
