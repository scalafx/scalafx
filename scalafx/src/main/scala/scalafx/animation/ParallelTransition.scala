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
import scalafx.collections._
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.scene.Node
import scalafx.delegate.SFXDelegate

/**
 * Companion Object for [[scalafx.animation.ParallelTransition]].
 *
 * @define PT `ParallelTransition`
 */
object ParallelTransition extends AnimationStatics {

  /**
   * Converts a ScalaFX $PT to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/animation/ParallelTransition.html $PT]],
   * extracting its delegate.
   *
   * @param v ScalaFX $PT
   * @return JavaFX $PT extracted from `v`.
   */
  implicit def sfxParallelTransition2jfx(v: ParallelTransition) = v.delegate
}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/ParallelTransition.html $PT]].
 *
 * @constructor Creates a new ScalaFX $PT from a JavaFX $PT.
 * @param delegate JavaFX $PT to be delegated.
 *
 * @define PT `ParallelTransition`
 * @define CONSTR The constructor of $PT.
 * @define TRS [[scalafx.animation.Transition]]s
 * @define ND [[scalafx.scene.Node]]
 * @define NDARG The target $ND to be used in child $TRS that have no `Node` specified themselves.
 * @define ANS [[scalafx.animation.Animation]]s
 * @define ANSARG The child $ANS of this $PT.
 */
class ParallelTransition(override val delegate: jfxa.ParallelTransition = new jfxa.ParallelTransition)
  extends Transition(delegate)
  with SFXDelegate[jfxa.ParallelTransition] {

  // CONSTRUCTORS

  /**
   * $CONSTR
   *
   * @param children $ANSARG
   */
  def this(children: Seq[Animation]) =
    this(new jfxa.ParallelTransition(children.map(_.delegate): _*))

  /**
   * $CONSTR
   *
   * @param node $NDARG
   */
  def this(node: Node) = this(new jfxa.ParallelTransition(node))

  /**
   * $CONSTR
   *
   * @param node $NDARG
   * @param children $ANSARG
   */
  def this(node: Node, children: Seq[Animation]) =
    this(new jfxa.ParallelTransition(node, children.map(_.delegate): _*))

  // PROPERTIES

  /**
   * This $ND is used in all child $TRS, that do not define a target `Node` themselves.
   */
  def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty
  def node_=(n: Node) {
    node() = n
  }

  // METHODS

  /**
   * A list of $ANS that will be played sequentially.
   */
  def children: jfxc.ObservableList[jfxa.Animation] = delegate.getChildren

  /**
   * Sets the list of $ANS, replacing the prior content. If you want append to current content, use `add` or similar.
   *
   * @param c list of $ANS to replace prior content.
   */
  def children_=(c: Iterable[Animation]) {
    fillSFXCollection(this.children, c)
  }

}