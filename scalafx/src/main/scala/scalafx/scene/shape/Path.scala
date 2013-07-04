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
package scalafx.scene.shape

import collection.JavaConversions._
import javafx.scene.{shape => jfxss}
import scalafx.collections._
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate

object Path {
  implicit def sfxPath2jfx(v: Path) = v.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/shape/Path.html]].
 */
class Path(override val delegate: jfxss.Path = new jfxss.Path())
  extends Shape(delegate)
  with SFXDelegate[jfxss.Path] {

  /**
   * The filling rule constant for determining the interior of the path.
   */
  def fillRule: ObjectProperty[jfxss.FillRule] = delegate.fillRuleProperty
  def fillRule_=(v: FillRule) {
    fillRule() = v
  }

  /**
   * Observable list of path elements of this path.
   */
  def elements = delegate.getElements
  /**
   * Sets the list of path elements, replacing the prior content. If you want append to current content, use `add` or
   * similar.
   *
   * @param c list of path elements to replace prior content.
   */
  def elements_=(c: Iterable[PathElement]) {
    fillSFXCollection(this.elements, c)
  }
}
