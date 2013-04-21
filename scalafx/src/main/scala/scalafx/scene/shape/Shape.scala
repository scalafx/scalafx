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
import javafx.scene.{ paint => jfxsp }
import javafx.scene.{ shape => jfxss }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.scene.Node
import scalafx.scene.paint.Paint
import scalafx.delegate.SFXDelegate
import scalafx.collections.ObservableBuffer

object Shape {
  implicit def sfxShape2jfx(v: Shape) = v.delegate

  /**
   * Returns a new Shape which is created as an intersection of the specified input shapes.
   */
  def intersect(shape1: jfxss.Shape, shape2: jfxss.Shape) = jfxss.Shape.intersect(shape1, shape2)

  /**
   * Returns a new Shape which is created by subtracting the specified second shape from the first shape.
   */
  def subtract(shape1: jfxss.Shape, shape2: jfxss.Shape) = jfxss.Shape.subtract(shape1, shape2)

  /**
   * Returns a new Shape which is created as a union of the specified input shapes.
   */
  def union(shape1: jfxss.Shape, shape2: jfxss.Shape) = jfxss.Shape.union(shape1, shape2)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/shape/Shape.html]].
 */
abstract class Shape(override val delegate: jfxss.Shape)
  extends Node(delegate)
  with SFXDelegate[jfxss.Shape] {

  /**
   * Defines parameters to fill the interior of an Shape using the settings of the Paint context.
   */
  def fill: ObjectProperty[jfxsp.Paint] = delegate.fillProperty
  /**
   * Sets parameters to fill the interior of an Shape using the settings of the Paint context.
   * 
   * @param v Filling Parameters.
   */
  def fill_=(v: Paint) {
    ObjectProperty.fillProperty[jfxsp.Paint](this.fill, v)
  }

  /**
   * Defines whether anti-aliasing hints are used or not for this Shape.
   */
  def smooth: BooleanProperty = delegate.smoothProperty
  def smooth_=(v: Boolean) {
    smooth() = v
  }

  /**
   * Defines a distance specified in user coordinates that represents an offset into the dashing pattern.
   */
  def strokeDashOffset: DoubleProperty = delegate.strokeDashOffsetProperty
  def strokeDashOffset_=(v: Double) {
    strokeDashOffset() = v
  }

  /**
   * The end cap style of this Shape as one of the following values that define possible end cap styles: 
   * `StrokeLineCap.BUTT`, `StrokeLineCap.ROUND`, and `StrokeLineCap.SQUARE`.
   */
  def strokeLineCap: ObjectProperty[jfxss.StrokeLineCap] = delegate.strokeLineCapProperty
  def strokeLineCap_=(v: StrokeLineCap) {
    strokeLineCap() = v
  }

  /**
   * Defines the decoration applied where path segments meet.
   */
  def strokeLineJoin: ObjectProperty[jfxss.StrokeLineJoin] = delegate.strokeLineJoinProperty
  def strokeLineJoin_=(v: StrokeLineJoin) {
    strokeLineJoin() = v
  }

  /**
   * Defines the limit for the `StrokeLineJoin.MITER` line join style.
   */
  def strokeMiterLimit: DoubleProperty = delegate.strokeMiterLimitProperty
  def strokeMiterLimit_=(v: Double) {
    strokeMiterLimit() = v
  }

  /**
   * Defines parameters of a stroke that is drawn around the outline of a Shape using the settings of the specified 
   * Paint.
   */
  def stroke: ObjectProperty[jfxsp.Paint] = delegate.strokeProperty
  def stroke_=(v: Paint) {
    stroke() = v.delegate
  }

  /**
   * Defines the direction (inside, centered, or outside) that the strokeWidth is applied to the boundary of the shape.
   */
  def strokeType: ObjectProperty[jfxss.StrokeType] = delegate.strokeTypeProperty
  def strokeType_=(v: StrokeType) {
    strokeType() = v
  }

  /**
   * Defines a square pen line width.
   */
  def strokeWidth: DoubleProperty = delegate.strokeWidthProperty
  def strokeWidth_=(v: Double) {
    strokeWidth() = v
  }

  /**
   * Defines the array representing the lengths of the dash segments.
   */
  def strokeDashArray: ObservableBuffer[java.lang.Double] = delegate.getStrokeDashArray
  /**
   * Sets the list of lengths of the dash segments, replacing the prior content. If you want append to current 
   * content, use `+==` or similar.
   *
   * @param c List of lengths of the dash segments to replace prior content.
   */
  def strokeDashArray_=(c: Iterable[java.lang.Double]) {
    if (null == c) {
      strokeDashArray.clear()
    } else {
      strokeDashArray.setAll(c)
    }
  }
}
