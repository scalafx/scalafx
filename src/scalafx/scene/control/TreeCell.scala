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

import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import scalafx.scene.Node
import scalafx.util.SFXDelegate

object TreeCell {
  implicit def sfxTreeCell2jfx[T](t: TreeCell[T]) = t.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TreeCell.html]]
 *
 * @tparam T The type of the value contained within the `TreeItem` property.
 */
class TreeCell[T](override val delegate: jfxsc.TreeCell[T] = new jfxsc.TreeCell[T])
  extends IndexedCell(delegate)
  with SFXDelegate[jfxsc.TreeCell[T]] {

  /**
   * The disclosure node is commonly seen represented as a triangle that rotates on screen to indicate whether or
   * not the TreeItem that it is placed beside is expanded or collapsed.
   */
  def disclosureNode = delegate.disclosureNodeProperty
  def disclosureNode_=(v: Node) {
    disclosureNode() = v
  }

  /**
   * Each TreeCell represents at most a single `TreeItem`, which is represented by this property.
   */
  def treeItem = delegate.treeItemProperty
  def treeItem_=(treeItem: TreeItem[T]) {
    delegate.updateTreeItem(treeItem)
  }

  /**
   * A TreeCell is explicitly linked to a single `TreeView` instance, which is represented by this property.
   */
  def treeView = delegate.treeViewProperty
  def treeView_=(tree: TreeView[T]) {
    delegate.updateTreeView(tree)
  }

  /**
   * Call this function to transition from an editing state into a non-editing state, without saving any user input.
   */
  def cancelEdit = delegate.cancelEdit

  /**
   * Call this function to transition from an editing state into a non-editing state, and in the process saving any user input.
   */
  def commitEdit(newValue: T) = delegate.commitEdit(newValue)

  /**
   * Call this function to transition from a non-editing state into an editing state, if the cell is editable.
   */
  def startEdit = delegate.startEdit

}