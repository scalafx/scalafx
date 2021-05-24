/*
 * Copyright (c) 2011-2021, ScalaFX Project
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
import javafx.{scene => jfxs}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node

/**
 * Object companion for [[CustomMenuItem]].
 */
object CustomMenuItem {
  implicit def sfxCustomMenuItem2jfx(c: CustomMenuItem): jfxsc.CustomMenuItem = if (c != null) c.delegate else null
}

/**
 * A MenuItem that allows for arbitrary nodes to be embedded within it, by assigning a Node to the content property.
 *
 * Wraps a $JFX $URL0 $FC]].
 *
 * @constructor
 *   Creates a new $FC from a $JFX one.
 * @param delegate
 *   A $JFX $FC to be wrapped. Its default value is a new $JFX $FC.
 *
 * @define
 *   FC CustomMenuItem
 * @define
 *   URL0
 *   [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/CustomMenuItem.html@defineJFX JavaFX @define ORIGINALDOC Original Documentation]].
 */
class CustomMenuItem(override val delegate: jfxsc.CustomMenuItem = new jfxsc.CustomMenuItem)
    extends MenuItem(delegate)
    with SFXDelegate[jfxsc.CustomMenuItem] {

  /**
   * Constructs a CustomMenuItem and initializes its content with the node specified.
   *
   * @param node
   *   to be embedded inside this CustomMenuItem
   */
  def this(node: Node) = this(new jfxsc.CustomMenuItem(node))

  /**
   * Bridge constructor for [[jfxsc.CustomMenuItem(Node,boolean)]]
   * @param node
   *   to be embedded inside this CustomMenuItem
   * @param hidOnClick
   *   if false the menu will not hide when the user interacts with the node.
   */
  def this(node: Node, hidOnClick: Boolean) = this(new jfxsc.CustomMenuItem(node, hidOnClick))

  /**
   * The node to display within this CustomMenuItem.
   */
  def content: ObjectProperty[jfxs.Node] = delegate.contentProperty()
  def content_=(value: Node): Unit = {
    ObjectProperty.fillProperty(content, value)
  }

  /**
   * If true, this menu item, and all visible menus, will be hidden when this menu item is clicked on.
   */
  def hideOnClick: BooleanProperty = delegate.hideOnClickProperty()
  def hideOnClick_=(value: Boolean): Unit = {
    hideOnClick() = value
  }
}
