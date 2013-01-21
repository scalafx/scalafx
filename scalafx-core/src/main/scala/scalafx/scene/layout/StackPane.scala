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

import javafx.{ scene => jfxs }
import javafx.scene.{ layout => jfxsl }
import scalafx.delegate.AlignmentDelegate
import scalafx.delegate.SFXDelegate
import scalafx.geometry.Insets
import scalafx.geometry.Insets.sfxInsets2jfx
import scalafx.geometry.Pos
import scalafx.scene.Node
import scalafx.scene.Node.sfxNode2jfx

object StackPane {
  implicit def sfxStackPane2jfx(v: StackPane) = v.delegate

  /**
   * Removes all hbox constraints from the child node.
   */
  def clearConstraints(child: jfxs.Node) = jfxsl.StackPane.clearConstraints(child)

  /**
   * Returns the child's alignment constraint if set.
   */
  def getAlignment(child: Node) = jfxsl.StackPane.getAlignment(child)

  /**
   * Sets the alignment for the child when contained by a stackpane.
   */
  def setAlignment(child: Node, value: Pos) = jfxsl.StackPane.setAlignment(child, value)

  /**
   * Returns the child's margin constraint if set.
   */
  def getMargin(child: Node) = jfxsl.StackPane.getMargin(child)

  /**
   * Sets the margin for the child when contained by an hbox.
   */
  def setMargin(child: Node, value: Insets) = jfxsl.StackPane.setMargin(child, value)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/StackPane.html]]
 */
class StackPane(override val delegate: jfxsl.StackPane = new jfxsl.StackPane)
  extends Pane(delegate)
  with AlignmentDelegate[jfxsl.StackPane]
  with SFXDelegate[jfxsl.StackPane] {

  /**
   * Returns the orientation of a node's resizing bias for layout purposes.
   */
  def contentBias = delegate.getContentBias

}
