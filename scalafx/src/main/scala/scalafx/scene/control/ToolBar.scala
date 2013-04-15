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
package scalafx.scene.control

import javafx.{ collections => jfxc }
import scalafx.collections._
import scalafx.Includes._
import javafx.{ scene => jfxs }
import javafx.scene.{ control => jfxsc }
import scalafx.delegate.SFXDelegate
import javafx.{ event => jfxe }
import javafx.{ geometry => jfxg }
import scalafx.scene.Node
import collection.JavaConversions._
import scalafx.beans.property.ObjectProperty
import scalafx.geometry.Orientation

object ToolBar {
  implicit def sfxToolBarTojfx(v: ToolBar) = v.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/ToolBar.html]].
 */
class ToolBar(override val delegate: jfxsc.ToolBar = new jfxsc.ToolBar)
  extends Control(delegate)
  with SFXDelegate[jfxsc.ToolBar] {

  /**
   * The items contained in the ToolBar.
   */
  def items: jfxc.ObservableList[jfxs.Node] = delegate.getItems
  /**
   * Sets the items, replacing the prior items. If you want append to current items, use `add` or similar.
   *
   * @param c list of items to replace prior items.
   */
  def items_=(c: Iterable[Node]) {
    fillSFXCollection(this.items, c)
  }
  /**
   * Sets a node, replacing the prior content. If you want append to current content, use `add` or similar.
   *
   * @param n Node to replace prior content.
   */
  def items_=(n: Node) {
    fillSFXCollectionWithOne(this.items, n)
  }
  /**
   * The items contained in the ToolBar.
   */
  def content = items
  /**
   * Sets the items, replacing the prior items. If you want append to current items, use `add` or similar.
   *
   * @param c list of items to replace prior items.
   */
  def content_=(c: Iterable[Node]) {
    items = c
  }
  /**
   * Sets a node, replacing the prior content. If you want append to current content, use `add` or similar.
   *
   * @param n Node to replace prior content.
   */
  def content_=(n: Node) {
    items = n
  }

  /**
   * The orientation of the ToolBar - this can either be horizontal or vertical.
   */
  def orientation: ObjectProperty[jfxg.Orientation] = delegate.orientationProperty
  def orientation_=(v: Orientation) {
    orientation() = v
  }
}