/*
 * Copyright (c) 2011, ScalaFX Project
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

import javafx.{ geometry => jfxg }
import javafx.scene.{ layout => jfxsl }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.geometry.VPos
import scalafx.delegate.SFXDelegate

object RowConstraints {
  implicit def sfxRowConstraints2jfx(v: RowConstraints) = v.delegate
}

class RowConstraints(override val delegate: jfxsl.RowConstraints = new jfxsl.RowConstraints) extends ConstraintsBase(delegate) with SFXDelegate[jfxsl.RowConstraints] {

  /**
   * Creates a row constraint object with a fixed height.
   */
  def this(height: Double) = this(new jfxsl.RowConstraints(height))

  /**
   * Creates a row constraint object with a fixed size range.
   */
  def this(height: Double, prefHeight: Double, maxHeight: Double) =
    this(new jfxsl.RowConstraints(height, prefHeight, maxHeight))

  /**
   * Creates a row constraint object with a fixed size range, vertical grow priority, vertical 
   * alignment, and vertical fill behavior.
   */
  def this(height: Double, prefHeight: Double, maxHeight: Double, vgrow: jfxsl.Priority, valignment: jfxg.VPos, fillHeight: Boolean) =
    this(new jfxsl.RowConstraints(height, prefHeight, maxHeight, vgrow, valignment, fillHeight))

  /**
   * The vertical fill policy for the row.
   */
  def fillHeight: BooleanProperty = delegate.fillHeightProperty
  def fillHeight_=(v: Boolean) {
    fillHeight() = v
  }

  /**
   * The maximum height for the row.
   */
  def maxHeight: DoubleProperty = delegate.maxHeightProperty
  def maxHeight_=(v: Double) {
    maxHeight() = v
  }

  /**
   * The minimum height for the row.
   */
  def minHeight: DoubleProperty = delegate.minHeightProperty
  def minHeight_=(v: Double) {
    minHeight() = v
  }

  /**
   * The height percentage of the row.
   */
  def percentHeight: DoubleProperty = delegate.percentHeightProperty
  def percentHeight_=(v: Double) {
    percentHeight() = v
  }

  /**
   * The preferred height for the row.
   */
  def prefHeight: DoubleProperty = delegate.prefHeightProperty
  def prefHeight_=(v: Double) {
    prefHeight() = v
  }

  /**
   * The vertical alignment for the row.
   */
  def valignment: ObjectProperty[jfxg.VPos] = delegate.valignmentProperty
  def valignment_=(v: VPos) {
    valignment() = v
  }

  /**
   * The vertical grow priority for the row.
   */
  def vgrow: ObjectProperty[jfxsl.Priority] = delegate.vgrowProperty
  def vgrow_=(v: Priority) {
    vgrow() = v
  }
}
