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
import javafx.scene.{ layout => jfxsl }
import scalafx.Includes._
import scalafx.geometry.Insets._
import scalafx.geometry.Insets
import scalafx.scene.Node._
import scalafx.scene.Node
import scalafx.delegate.SFXDelegate

object AnchorPane {
  implicit def sfxAnchorPane2jfx(ap: AnchorPane) = ap.delegate

  /**
   * Removes all anchorpane constraints from the child node.
   */
  def clearConstraints(child: javafx.scene.Node) {
    jfxsl.AnchorPane.clearConstraints(child)
  }

  /**
   * Returns the child's bottom anchor constraint if set.
   */
  def getBottomAnchor(child: Node) = jfxsl.AnchorPane.getBottomAnchor(child)

  /**
   * Returns the child's left anchor constraint if set.
   */
  def getLeftAnchor(child: Node) = jfxsl.AnchorPane.getLeftAnchor(child)

  /**
   * Returns the child's right anchor constraint if set.
   */
  def getRightAnchor(child: Node) = jfxsl.AnchorPane.getRightAnchor(child)

  /**
   * Returns the child's top anchor constraint if set.
   */
  def getTopAnchor(child: Node) = jfxsl.AnchorPane.getTopAnchor(child)

  /**
   * Sets the bottom anchor for the child when contained by an anchorpane.
   */
  def setBottomAnchor(child: Node, value: Double) {
    jfxsl.AnchorPane.setBottomAnchor(child, value)
  }

  /**
   * Sets the left anchor for the child when contained by an anchorpane.
   */
  def setLeftAnchor(child: Node, value: Double) {
    jfxsl.AnchorPane.setLeftAnchor(child, value)
  }

  /**
   * Sets the bottom anchor for the child when contained by an anchorpane.
   */
  def setRightAnchor(child: Node, value: Double) {
    jfxsl.AnchorPane.setRightAnchor(child, value)
  }

  /**
   * Sets the top anchor for the child when contained by an anchorpane.
   */
  def setTopAnchor(child: Node, value: Double) {
    jfxsl.AnchorPane.setTopAnchor(child, value)
  }

  /**
   * Sets the anchors for the child when contained by an anchorpane.
   *
   * @param child Node to be set
   * @param top Top Anchor
   * @param right Right Anchor
   * @param bottom Bottom Anchor
   * @param left Left Anchor
   */
  def setAnchors(child: Node, top: Double, right: Double, bottom: Double, left: Double) {
    setTopAnchor(child, top)
    setRightAnchor(child, right)
    setBottomAnchor(child, bottom)
    setLeftAnchor(child, left)
  }

}

class AnchorPane(override val delegate: jfxsl.AnchorPane = new jfxsl.AnchorPane) extends Pane(delegate) with SFXDelegate[jfxsl.AnchorPane] {

}