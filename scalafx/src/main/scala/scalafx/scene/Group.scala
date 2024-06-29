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

package scalafx.scene

import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.collections._
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Group {
  implicit def sfxGroup2jfx(v: Group): jfxs.Group = if (v != null) v.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/Group.html]].
 */
class Group(override val delegate: jfxs.Group = new jfxs.Group())
    extends Parent(delegate)
    with SFXDelegate[jfxs.Group] {

  /**
   * Constructs a group consisting of children.
   */
  def this(children: Node*) = this(new jfxs.Group(children.map(_.delegate): _*))

  /**
   * Gets the list of children of this `Group`.
   */
  def children: ObservableBuffer[jfxs.Node] = delegate.getChildren

  /**
   * Sets the list of children, replacing the prior content. If you want append to current content, use `add` or
   * similar.
   *
   * @param c list of children to replace prior content.
   */
  def children_=(c: Iterable[Node]): Unit = {
    fillSFXCollection(this.children, c)
  }

  /**
   * Sets a child, replacing the prior content. If you want append to current content, use `add` or similar.
   *
   * @param n Node to replace prior content.
   */
  def children_=(n: Node): Unit = {
    fillSFXCollectionWithOne(this.children, n)
  }

  /**
   * Controls whether or not this Group will automatically resize any managed resizable children
   * to their preferred sizes during the layout pass.
   */
  def autoSizeChildren: BooleanProperty = delegate.autoSizeChildrenProperty

  def autoSizeChildren_=(v: Boolean): Unit = {
    autoSizeChildren() = v
  }
}
