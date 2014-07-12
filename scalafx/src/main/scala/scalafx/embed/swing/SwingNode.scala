/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
package scalafx.embed.swing

import scala.language.implicitConversions

import javafx.embed.{ swing => jfxes }
import javax.swing.JComponent
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node

/**
 * Companion Object for [[scalafx.embed.swing.SwingNode]].
 */
object SwingNode {

  /**
   * Converts a ScalaFX SwingNode to its JavaFX counterpart.
   *
   * @param node ScalaFX SwingNode
   * @return JavaFX SwingNode
   */
  implicit def sfxPanel2jfx(node: SwingNode): jfxes.SwingNode = node.delegate

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/embed/swing/SwingNode.html JavaFX
 * SwingNode]]. This class is not implementing the `impl_*` methods from the original class.
 *
 * @constructor Creates a new ScalaFX SwingNode from its JavaFX counterpart.
 * @param delegate JavaFX SwingNode. Its defaul value is a new SwingNode
 *
 * @since 8.0
 */
class SwingNode(override val delegate: jfxes.SwingNode = new jfxes.SwingNode)
  extends Node(delegate)
  with SFXDelegate[jfxes.SwingNode] {

  /**
   *  the JComponent instance attached to this SwingNode.
   */
  def content: JComponent = delegate.getContent
  def content_=(c: JComponent) {
    delegate.setContent(c)
  }

}