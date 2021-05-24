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
package scalafx.scene.chart

import javafx.scene.{chart => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, ReadOnlyDoubleProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object CategoryAxis {
  implicit def sfxCategoryAxis2jfx(v: CategoryAxis): jfxsc.CategoryAxis = if (v != null) v.delegate else null

  def apply() = new CategoryAxis()

  def apply(categories: ObservableBuffer[String]) = new CategoryAxis(new jfxsc.CategoryAxis(categories))

  def apply(categories: Seq[String]) = new CategoryAxis(new jfxsc.CategoryAxis(ObservableBuffer.from(categories)))

  def apply(axisLabel: String): CategoryAxis = new CategoryAxis {
    label = axisLabel
  }
}

class CategoryAxis(override val delegate: jfxsc.CategoryAxis = new jfxsc.CategoryAxis)
    extends Axis[String](delegate)
    with SFXDelegate[jfxsc.CategoryAxis] {

  def categorySpacing: ReadOnlyDoubleProperty = delegate.categorySpacingProperty

  def endMargin: DoubleProperty = delegate.endMarginProperty

  def endMargin_=(v: Double): Unit = {
    endMargin() = v
  }

  def gapStartAndEnd: BooleanProperty = delegate.gapStartAndEndProperty

  def gapStartAndEnd_=(v: Boolean): Unit = {
    gapStartAndEnd() = v
  }

  def startMargin: DoubleProperty = delegate.startMarginProperty

  def startMargin_=(v: Double): Unit = {
    startMargin() = v
  }

  def categories: ObservableBuffer[String] = delegate.getCategories

  def categories_=(value: ObservableBuffer[String]): Unit = {
    delegate.setCategories(value)
  }

}
