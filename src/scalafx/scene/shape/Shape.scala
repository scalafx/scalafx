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

package scalafx.scene.shape

import javafx.scene.paint.Paint
import javafx.scene.shape.StrokeLineCap
import javafx.scene.shape.StrokeLineJoin
import javafx.scene.shape.StrokeType

import scalafx.scene.Node
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty

abstract class Shape extends Node {
  override val node: javafx.scene.shape.Shape
  
  private[this] lazy val _fillProperty = new ObjectProperty[Paint](node.fillProperty())
  def fill = _fillProperty
  def fill_=(v: Paint) {
    fill() = v
  }
  
  private[this] lazy val _smoothProperty = new BooleanProperty(node.smoothProperty())
  def smooth = _smoothProperty
  def smooth_=(v: Boolean) {
    smooth() = v
  }  

  private[this] lazy val _strokeDashOffsetProperty = new DoubleProperty(node.strokeDashOffsetProperty())
  def strokeDashOffset = _strokeDashOffsetProperty
  def strokeDashOffset_=(v: Double) {
    strokeDashOffset() = v
  }  
  
  private[this] lazy val _strokeLineCapProperty = new ObjectProperty[StrokeLineCap](node.strokeLineCapProperty())
  def strokeLineCap = _strokeLineCapProperty
  def strokeLineCap_=(v: StrokeLineCap) {
    strokeLineCap() = v
  }  
  
  private[this] lazy val _strokeLineJoinProperty = new ObjectProperty[StrokeLineJoin](node.strokeLineJoinProperty())
  def strokeLineJoin = _strokeLineJoinProperty
  def strokeLineJoin_=(v: StrokeLineJoin) {
    strokeLineJoin() = v
  }  

  private[this] lazy val _strokeMiterLimitProperty = new DoubleProperty(node.strokeMiterLimitProperty())
  def strokeMiterLimit = _strokeMiterLimitProperty
  def strokeMiterLimit_=(v: Double) {
    strokeMiterLimit() = v
  }
  
  private[this] lazy val _strokeProperty = new ObjectProperty[Paint](node.strokeProperty())
  def stroke = _strokeProperty
  def stroke_=(v: Paint) {
    stroke() = v
  }  
  
  private[this] lazy val _strokeTypeProperty = new ObjectProperty[StrokeType](node.strokeTypeProperty())
  def strokeType = _strokeTypeProperty
  def strokeType_=(v: StrokeType) {
    strokeType() = v
  }  

  private[this] lazy val _strokeWidthProperty = new DoubleProperty(node.strokeWidthProperty())
  def strokeWidth = _strokeWidthProperty
  def strokeWidth_=(v: Double) {
    strokeWidth() = v
  }  
  
}
