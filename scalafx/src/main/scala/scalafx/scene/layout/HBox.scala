/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

import javafx.scene.{layout => jfxsl}
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty}
import scalafx.delegate.{AlignmentDelegate, SFXDelegate}
import scalafx.geometry.Insets
import scalafx.geometry.Insets._
import scalafx.scene.Node
import scalafx.scene.Node._

import scala.language.implicitConversions

object HBox {
  implicit def sfxHBox2jfx(v: HBox): jfxsl.HBox = if (v != null) v.delegate else null

  /**
   * Removes all hbox constraints from the child node.
   */
  def clearConstraints(child: jfxs.Node): Unit = {
    jfxsl.HBox.clearConstraints(child)
  }

  /**
   * Returns the child's hgrow constraint if set.
   */
  def getHgrow(child: Node) = jfxsl.HBox.getHgrow(child)

  /**
   * Sets the horizontal grow priority for the child when contained by an hbox.
   */
  def setHgrow(child: Node, value: Priority): Unit = {
    jfxsl.HBox.setHgrow(child, value)
  }

  /**
   * Returns the child's margin constraint if set.
   */
  def getMargin(child: Node) = jfxsl.HBox.getMargin(child)

  /**
   * Sets the margin for the child when contained by an hbox.
   */
  def setMargin(child: Node, value: Insets): Unit = {
    jfxsl.HBox.setMargin(child, value)
  }

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html]]
 */
class HBox(override val delegate: jfxsl.HBox = new jfxsl.HBox)
  extends Pane(delegate)
  with AlignmentDelegate[jfxsl.HBox]
  with SFXDelegate[jfxsl.HBox] {

  /**
   * Creates an HBox layout with the specified spacing between children.
   */
  def this(spacing: Double) = this(new jfxsl.HBox(spacing))

  /**
   * Creates an HBox layout with spacing = 0.
   * @param children The initial set of children for this pane.
   */
  def this(children: Node*) = this(new jfxsl.HBox(children.map(_.delegate): _*))

  /**
   * Creates an HBox layout with the specified spacing between children.
   * @param spacing  The amount of horizontal space between each child.
   * @param children  The initial set of children for this pane.
   */
  def this(spacing: Double, children: Node*) = this(new jfxsl.HBox(spacing, children.map(_.delegate): _*))

  /**
   * The amount of horizontal space between each child in the hbox.
   */
  def spacing: DoubleProperty = delegate.spacingProperty

  def spacing_=(v: Double): Unit = {
    spacing() = v
  }

  /**
   * Whether or not resizable children will be resized to fill the full height of the hbox or be
   * kept to their preferred height and aligned according to the alignment vpos value.
   */
  def fillHeight: BooleanProperty = delegate.fillHeightProperty

  def fillHeight_=(v: Boolean): Unit = {
    fillHeight() = v
  }

}