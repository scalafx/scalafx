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
package scalafx.scene.layout

import javafx.scene.{layout => jfxsl}
import javafx.{geometry => jfxg}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.geometry.HPos

import scala.language.implicitConversions

object ColumnConstraints {
  implicit def sfxColumnConstraints2jfx(v: ColumnConstraints): jfxsl.ColumnConstraints =
    if (v != null) v.delegate else null
}

class ColumnConstraints(override val delegate: jfxsl.ColumnConstraints = new jfxsl.ColumnConstraints)
    extends ConstraintsBase(delegate) with SFXDelegate[jfxsl.ColumnConstraints] {

  /**
   * Creates a column constraint object with a fixed width.
   */
  def this(width: Double) = this(new jfxsl.ColumnConstraints(width))

  /**
   * Creates a column constraint object with a fixed size range.
   */
  def this(minWidth: Double, prefWidth: Double, maxWidth: Double) =
    this(new jfxsl.ColumnConstraints(minWidth, prefWidth, maxWidth))

  /**
   * Creates a column constraint object with a fixed size range, horizontal grow priority, horizontal alignment, and horizontal fill behavior.
   */
  def this(
    minWidth: Double,
    prefWidth: Double,
    maxWidth: Double,
    hgrow: jfxsl.Priority,
    halignment: jfxg.HPos,
    fillWidth: Boolean
  ) =
    this(new jfxsl.ColumnConstraints(minWidth, prefWidth, maxWidth, hgrow, halignment, fillWidth))

  /**
   * The horizontal fill policy for the column.
   */
  def fillWidth: BooleanProperty = delegate.fillWidthProperty

  def fillWidth_=(v: Boolean): Unit = {
    fillWidth() = v
  }

  /**
   * The horizontal alignment for the column.
   */
  def halignment: ObjectProperty[jfxg.HPos] = delegate.halignmentProperty

  def halignment_=(v: HPos): Unit = {
    halignment() = v
  }

  /**
   * The horizontal grow priority for the column.
   */
  def hgrow: ObjectProperty[jfxsl.Priority] = delegate.hgrowProperty

  def hgrow_=(v: Priority): Unit = {
    hgrow() = v
  }

  /**
   * The maximum width for the column.
   */
  def maxWidth: DoubleProperty = delegate.maxWidthProperty

  def maxWidth_=(v: Double): Unit = {
    maxWidth() = v
  }

  /**
   * The minimum width for the column.
   */
  def minWidth: DoubleProperty = delegate.minWidthProperty

  def minWidth_=(v: Double): Unit = {
    minWidth() = v
  }

  /**
   * The width percentage of the column.
   */
  def percentWidth: DoubleProperty = delegate.percentWidthProperty

  def percentWidth_=(v: Double): Unit = {
    percentWidth() = v
  }

  /**
   * The preferred width for the column.
   */
  def prefWidth: DoubleProperty = delegate.prefWidthProperty

  def prefWidth_=(v: Double): Unit = {
    prefWidth() = v
  }
}
