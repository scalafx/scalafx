/*
 * Copyright (c) 2011-2020, ScalaFX Project
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
import javafx.{geometry => jfxg, scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.geometry.Orientation
import scalafx.scene.Node

import scala.language.implicitConversions

object SplitPane {
  implicit def sfxSplitPane2jfx(v: SplitPane): jfxsc.SplitPane = if (v != null) v.delegate else null

  object Divider {
    implicit def sfxSplitPaneDivider2jfx(v: SplitPane.Divider): jfxsc.SplitPane.Divider =
      if (v != null) v.delegate else null
  }

  class Divider(override val delegate: jfxsc.SplitPane.Divider = new jfxsc.SplitPane.Divider)
      extends SFXDelegate[jfxsc.SplitPane.Divider] {

    /**
     * Represents the location where the divider should ideally be positioned, between 0.0 and 1.0 (inclusive).
     */
    def position: DoubleProperty = delegate.positionProperty

    def position_=(v: Double): Unit = {
      position() = v
    }

  }

  /**
   * Return true if the node is resizable when the parent container is resized false otherwise.
   */
  def isResizableWithParent(node: Node): Boolean = jfxsc.SplitPane.isResizableWithParent(node)

  /**
   * Sets a node in the SplitPane to be resizable or not when the SplitPane is resized.
   */
  def setResizableWithParent(node: Node, value: Boolean): Unit = {
    jfxsc.SplitPane.setResizableWithParent(node, value)
  }

}

class SplitPane(override val delegate: jfxsc.SplitPane = new jfxsc.SplitPane)
    extends Control(delegate)
    with SFXDelegate[jfxsc.SplitPane] {

  /**
   * The orientation for the SplitPane.
   */
  def orientation: ObjectProperty[jfxg.Orientation] = delegate.orientationProperty

  def orientation_=(v: Orientation): Unit = {
    orientation() = v
  }

  /**
   * Returns an array of double containing the position of each divider.
   */
  def dividerPositions: Array[Double] = delegate.getDividerPositions

  def dividerPositions_=(positions: Double*): Unit = {
    delegate.setDividerPositions(positions: _*)
  }

  /**
   * Sets the position of the divider at the specified divider index.
   * @todo
   *   Change to a Scala notation
   */
  def setDividerPosition(dividerIndex: Int, position: Double): Unit = {
    delegate.setDividerPosition(dividerIndex, position)
  }

  /**
   * Returns an unmodifiable list of all the dividers in this SplitPane.
   */
  def dividers: ObservableBuffer[jfxsc.SplitPane.Divider] = delegate.getDividers

  /**
   * Returns an ObservableList which can be use to modify the contents of the SplitPane.
   */
  def items: ObservableBuffer[jfxs.Node] = delegate.getItems

}
