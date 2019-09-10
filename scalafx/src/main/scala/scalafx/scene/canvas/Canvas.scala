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
package scalafx.scene.canvas

import javafx.scene.{canvas => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node

import scala.language.implicitConversions

object Canvas {
  implicit def sfxCanvas2jfx(c: Canvas): jfxsc.Canvas = if (c != null) c.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/Canvas.html JavaFX Canvas]]
 */
class Canvas(override val delegate: jfxsc.Canvas = new jfxsc.Canvas)
  extends Node(delegate)
  with SFXDelegate[jfxsc.Canvas] {

  /**
   * Creates a new instance of Canvas with the given size.
   */
  def this(width: Double, height: Double) = this(new jfxsc.Canvas(width, height))

  /**
   * Defines the height of the canvas.
   */
  def height: DoubleProperty = delegate.heightProperty

  def height_=(v: Double): Unit = {
    height() = v
  }

  /**
   * Defines the width of the canvas.
   */
  def width: DoubleProperty = delegate.widthProperty

  def width_=(v: Double): Unit = {
    width() = v
  }

  /**
   * returns the `GraphicsContext` associated with this `Canvas`.
   */
  def graphicsContext2D: GraphicsContext = delegate.getGraphicsContext2D

}