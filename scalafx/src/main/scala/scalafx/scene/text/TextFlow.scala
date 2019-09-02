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

package scalafx.scene.text

import javafx.scene.{text => jfxst}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.layout.Pane

object TextFlow {
  implicit def sfxTextFlow2jfx(v: TextFlow): jfxst.TextFlow = if (v != null) v.delegate else null

  def classCssMetaData = jfxst.TextFlow.getClassCssMetaData

}

/**
  * TextFlow is special layout designed to lay out rich text. It can be used to layout several
  * `Text` nodes in a single text flow. The `TextFlow` uses the text and the font of each `Text`
  * node inside of it plus it own width and text alignment to determine the location for each child.
  * A single `Text` node can span over several lines due to wrapping and the visual location
  * of `Text` node can differ from the logical location due to bidi reordering.
  *
  * Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/text/TextFlow.html]]
  */
class TextFlow(override val delegate: jfxst.TextFlow = new jfxst.TextFlow)
    extends Pane(delegate)
    with SFXDelegate[jfxst.TextFlow] {

  /**
    * Defines horizontal text alignment.
    */
  def this(children: Node*) = this(new jfxst.TextFlow(children.map(_.delegate): _*))

  /**
    * Defines the vertical space in pixel between lines.
    */
  def lineSpacing: DoubleProperty = delegate.lineSpacingProperty
  def lineSpacing_=(v: Double) {
    lineSpacing() = v
  }

  /**
    * Defines horizontal text alignment.
    */
  def textAlignment: ObjectProperty[jfxst.TextAlignment] = delegate.textAlignmentProperty
  def textAlignment_=(v: TextAlignment) {
    textAlignment() = v
  }

  /**
    * Calculates the baseline offset based on the first managed child.
    */
  override def baselineOffset: Double = delegate.getBaselineOffset

  /**
    * Requests a layout pass to be performed before the next scene is rendered.
    */
  def requestLayout() {
    delegate.requestLayout()
  }

}
