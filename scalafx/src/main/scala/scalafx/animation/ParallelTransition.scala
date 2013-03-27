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
package scalafx.animation

import collection.JavaConversions._
import javafx.{ animation => jfxa, scene => jfxs }
import javafx.{ collections => jfxc }
import scalafx._
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.scene.Node
import scalafx.delegate.SFXDelegate

object ParallelTransition extends AnimationStatics {
  implicit def sfxParallelTransition2jfx(v: ParallelTransition) = v.delegate
}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/ParallelTransition.html ParallelTransition]].
 */
class ParallelTransition(override val delegate: jfxa.ParallelTransition = new jfxa.ParallelTransition)
  extends Transition(delegate)
  with SFXDelegate[jfxa.ParallelTransition] {

  /**
   * The constructor of ParallelTransition.
   *
   * @param children  The child Animations of this ParallelTransition
   */
  def this(children: Seq[Animation]) =
    this(new jfxa.ParallelTransition(children.map(_.delegate): _*))

  /**
   * The constructor of ParallelTransition.
   *
   * @param node The target Node to be used in child Transitions that have no
   * Node specified themselves
   */
  def this(node: Node) = this(new jfxa.ParallelTransition(node))

  /**
   * The constructor of ParallelTransition.
   *
   * @param node The target Node to be used in child Transitions that have no
   * Node specified themselves
   * @param children  The child Animations of this ParallelTransition
   */
  def this(node: Node, children: Seq[Animation]) =
    this(new jfxa.ParallelTransition(node, children.map(_.delegate): _*))

  /**
   * This Node is used in all child Transitions, that do not define a target
   *  Node themselves.
   */
  def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty
  def node_=(n: Node) {
    node() = n
  }

  /**
   * A list of Animations that will be played sequentially.
   */
  def children: jfxc.ObservableList[jfxa.Animation] = delegate.getChildren
  def children_=(c: Iterable[Animation]) {
    fillSFXCollection(this.children, c)
  }

}