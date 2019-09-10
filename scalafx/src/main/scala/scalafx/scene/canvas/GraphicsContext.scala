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

import javafx.geometry.VPos
import javafx.scene.effect.BlendMode
import javafx.scene.shape.FillRule
import javafx.scene.text.TextAlignment
import javafx.scene.{canvas => jfxsc}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.effect.Effect
import scalafx.scene.image.Image
import scalafx.scene.paint.Paint
import scalafx.scene.shape.{ArcType, StrokeLineCap, StrokeLineJoin}
import scalafx.scene.text.Font
import scalafx.scene.transform.Affine

import scala.collection.mutable.ArrayBuffer
import scala.language.implicitConversions

object GraphicsContext {
  implicit def sfxGraphicsContext2jfx(gc: GraphicsContext): jfxsc.GraphicsContext = if (gc != null) gc.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html JavaFX GraphicsContext]]
 */
class GraphicsContext(override val delegate: jfxsc.GraphicsContext)
  extends SFXDelegate[jfxsc.GraphicsContext] {

  private def executeWithPoints(action: (Array[Double], Array[Double], Int) => Unit, points: Seq[(Double, Double)]): Unit = {
    val xPoints = new ArrayBuffer[Double](points.size)
    val yPoints = new ArrayBuffer[Double](points.size)

    points.foreach(p => {
      xPoints += p._1
      yPoints += p._2
    })

    action(xPoints.toArray, yPoints.toArray, points.size)
  }

  /**
   * Appends an SVG Path string to the current path.
   */
  def appendSVGPath(svgpath: String): Unit = {
    delegate.appendSVGPath(svgpath)
  }

  /**
   * Applies the given effect to the entire canvas.
   */
  def applyEffect(e: Effect): Unit = {
    delegate.applyEffect(e)
  }

  /**
   * Adds path elements to the current path to make an arc that uses Euclidean degrees.
   */
  def arc(centerX: Double, centerY: Double, radiusX: Double, radiusY: Double, startAngle: Double, length: Double): Unit = {
    delegate.arc(centerX, centerY, radiusX, radiusY, startAngle, length)
  }

  /**
   * Adds segments to the current path to make an arc.
   */
  def arcTo(x1: Double, y1: Double, x2: Double, y2: Double, radius: Double): Unit = {
    delegate.arcTo(x1, y1, x2, y2, radius)
  }

  /**
   * Starts a Path
   */
  def beginPath(): Unit = {
    delegate.beginPath()
  }

  /**
   * Adds segments to the current path to make a cubic bezier curve.
   */
  def bezierCurveTo(xc1: Double, yc1: Double, xc2: Double, yc2: Double, x1: Double, y1: Double): Unit = {
    delegate.bezierCurveTo(xc1, yc1, xc2, yc2, x1, y1)
  }

  /**
   * Gets the Canvas that the GraphicsContext is issuing draw commands to.
   */
  def canvas = delegate.getCanvas

  /**
   * Clears a portion of the canvas with a transparent color value.
   */
  def clearRect(x: Double, y: Double, w: Double, h: Double): Unit = {
    delegate.clearRect(x, y, w, h)
  }

  /**
   * Clips using the current path
   */
  def clip(): Unit = {
    delegate.clip()
  }

  /**
   * Closes the path.
   */
  def closePath(): Unit = {
    delegate.closePath()
  }

  /**
   * Draws an image at the given x, y position using the width and height of the given image.
   */
  def drawImage(img: Image, x: Double, y: Double): Unit = {
    delegate.drawImage(img, x, y)
  }

  /**
   * Draws an image into the given destination rectangle of the canvas.
   */
  def drawImage(img: Image, x: Double, y: Double, w: Double, h: Double): Unit = {
    delegate.drawImage(img, x, y, w, h)
  }

  /**
   * Draws the current source rectangle of the given image to the given destination rectangle of the Canvas.
   */
  def drawImage(img: Image, sx: Double, sy: Double, sw: Double, sh: Double, dx: Double, dy: Double, dw: Double, dh: Double): Unit = {
    delegate.drawImage(img, sx, sy, sw, sh, dx, dy, dw, dh)
  }

  /*
   * IMPLEMENTATION NOTE ABOUT EFFECT: Although there is a "getter" and a setter for Effect, the getEffect in JavaFX 
   * class has a parameter (in this case the Effect to be used) I decided not to use the Scala pattern for getters and 
   * setters.
   */

  /**
   * Gets a copy of the effect to be applied after the next draw call.
   */
  def getEffect(e: Effect): Effect = delegate.getEffect(e)

  /**
   * Sets the effect to be applied after the next draw call, or null to disable effects.
   */
  def setEffect(e: Effect): Unit = {
    delegate.setEffect(e)
  }

  /*
   * IMPLEMENTATION NOTE ABOUT FILL: In original JavaFX class there is a getter and setter for fill. However, there 
   * is a method called fill(). Then, in order to use Scala pattern for getter and setter, the fill() method in JavaFX 
   * class was renamed to fillPath.
   */

  /**
   * the current fill attribute.
   */
  def fill: Paint = delegate.getFill

  def fill_=(p: Paint): Unit = {
    delegate.setFill(p)
  }

  /**
   * Fills the path with the current fill paint.
   * This method is correspondent to fill() method in JavaFx class.
   */
  def fillPath(): Unit = {
    delegate.fill()
  }

  /**
   * Fills an arc using the current fill paint.
   */
  def fillArc(x: Double, y: Double, w: Double, h: Double, startAngle: Double, arcExtent: Double, closure: ArcType): Unit = {
    delegate.fillArc(x, y, w, h, startAngle, arcExtent, closure)
  }

  /**
   * Fills an oval using the current fill paint.
   */
  def fillOval(x: Double, y: Double, w: Double, h: Double): Unit = {
    delegate.fillOval(x, y, w, h)
  }

  /**
   * Fills a polygon with the given points using the currently set fill paint.
   */
  def fillPolygon(xPoints: Array[Double], yPoints: Array[Double], nPoints: Int): Unit = {
    delegate.fillPolygon(xPoints, yPoints, nPoints)
  }

  /**
   * Fills a polygon with the given points using the currently set fill paint.
   */
  def fillPolygon(points: Seq[(Double, Double)]): Unit = {
    executeWithPoints(fillPolygon, points)
  }

  /**
   * Fills a rectangle using the current fill paint.
   */
  def fillRect(x: Double, y: Double, w: Double, h: Double): Unit = {
    delegate.fillRect(x, y, w, h)
  }

  /**
   * Fills a rounded rectangle using the current fill paint.
   */
  def fillRoundRect(x: Double, y: Double, w: Double, h: Double, arcWidth: Double, arcHeight: Double): Unit = {
    delegate.fillRoundRect(x, y, w, h, arcWidth, arcHeight)
  }

  /**
   * Fills the given string of text at position x, y (0,0 at top left) with the current fill paint attribute.
   */
  def fillText(text: String, x: Double, y: Double): Unit = {
    delegate.fillText(text, x, y)
  }

  /**
   * Fills text and includes a maximum width of the string.
   */
  def fillText(text: String, x: Double, y: Double, maxWidth: Double): Unit = {
    delegate.fillText(text, x, y, maxWidth)
  }

  /**
   * the filling rule constant for determining the interior of the path.
   */
  def fillRule = delegate.getFillRule

  def fillRule_=(fillRule: FillRule): Unit = {
    delegate.setFillRule(fillRule)
  }

  /**
   * the current Font.
   */
  def font: Font = delegate.getFont

  def font_=(f: Font): Unit = {
    delegate.setFont(f)
  }

  /**
   * the current global alpha.
   */
  def globalAlpha = delegate.getGlobalAlpha

  def globalAlpha_=(alpha: Double): Unit = {
    delegate.setGlobalAlpha(alpha)
  }

  /**
   * the global blend mode.
   */
  def globalBlendMode = delegate.getGlobalBlendMode

  def globalBlendMode_=(op: BlendMode): Unit = {
    delegate.setGlobalBlendMode(op)
  }

  /**
   * the current stroke line cap.
   */
  def lineCap: StrokeLineCap = StrokeLineCap(delegate.getLineCap)

  def lineCap_=(cap: StrokeLineCap): Unit = {
    delegate.setLineCap(cap)
  }

  /**
   * the current stroke line join.
   */
  def lineJoin: StrokeLineJoin = StrokeLineJoin(delegate.getLineJoin)

  def lineJoin_=(join: StrokeLineJoin): Unit = {
    delegate.setLineJoin(join)
  }

  /**
   * the current line width.
   */
  def lineWidth = delegate.getLineWidth

  def lineWidth_=(lw: Double): Unit = {
    delegate.setLineWidth(lw)
  }

  /**
   * Adds segments to the current path to make a line at the given x,y coordinate.
   */
  def lineTo(x1: Double, y1: Double): Unit = {
    delegate.lineTo(x1, y1)
  }

  /**
   * the current miter limit.
   */
  def miterLimit = delegate.getMiterLimit

  def miterLimit_=(ml: Double): Unit = {
    delegate.setMiterLimit(ml)
  }

  /**
   * Issues a move command for the current path to the given x,y coordinate.
   */
  def moveTo(x0: Double, y0: Double): Unit = {
    delegate.moveTo(x0, y0)
  }

  /**
   * Returns a PixelWriter object that can be used to modify the pixels of the Canvas associated with this
   * GraphicsContext.
   */
  def pixelWriter = delegate.getPixelWriter

  /**
   * Returns true if the the given x,y point is inside the path.
   */
  def pointInPath(x: Double, y: Double) = delegate.isPointInPath(x, y)

  /**
   * Adds segments to the current path to make a quadratic curve.
   */
  def quadraticCurveTo(xc: Double, yc: Double, x1: Double, y1: Double): Unit = {
    delegate.quadraticCurveTo(xc, yc, x1, y1)
  }

  /**
   * Adds path elements to the current path to make a rectangle.
   */
  def rect(x: Double, y: Double, w: Double, h: Double): Unit = {
    delegate.rect(x, y, w, h)
  }

  /**
   * Pops the state off of the stack, setting the following attributes to their value at the time when that state was
   * pushed onto the stack.
   */
  def restore(): Unit = {
    delegate.restore()
  }

  /**
   * Rotates the current transform in degrees.
   */
  def rotate(degrees: Double): Unit = {
    delegate.rotate(degrees)
  }

  /**
   * Saves the following attributes onto a stack.
   */
  def save(): Unit = {
    delegate.save()
  }

  /**
   * Scales the current transform by x, y.
   */
  def scale(x: Double, y: Double): Unit = {
    delegate.scale(x, y)
  }

  /**
   * the current stroke.
   */
  def stroke: Paint = delegate.getStroke

  def stroke_=(s: Paint): Unit = {
    delegate.setStroke(s)
  }

  /**
   * Strokes the path with the current stroke paint.
   * This method is correspondent to stroke() method in JavaFx class.
   */
  def strokePath(): Unit = {
    delegate.stroke()
  }

  /**
   * Strokes an Arc using the current stroke paint.
   */
  def strokeArc(x: Double, y: Double, w: Double, h: Double, startAngle: Double, arcExtent: Double, closure: ArcType): Unit = {
    delegate.strokeArc(x, y, w, h, startAngle, arcExtent, closure)
  }

  /**
   * Strokes a line using the current stroke paint.
   */
  def strokeLine(x1: Double, y1: Double, x2: Double, y2: Double): Unit = {
    delegate.strokeLine(x1, y1, x2, y2)
  }

  /**
    * Strokes an oval using the current stroke paint.
   */
  def strokeOval(x: Double, y: Double, w: Double, h: Double): Unit = {
    delegate.strokeOval(x, y, w, h)
  }

  /**
   * Strokes a polygon with the given points using the currently set stroke paint.
   */
  def strokePolygon(xPoints: Array[Double], yPoints: Array[Double], nPoints: Int): Unit = {
    delegate.strokePolygon(xPoints, yPoints, nPoints)
  }

  /**
   * Strokes a polygon with the given points using the currently set stroke paint.
   */
  def strokePolygon(points: Seq[(Double, Double)]): Unit = {
    this.executeWithPoints(strokePolygon, points)
  }

  /**
   * Draws a polyline with the given points using the currently set stroke paint attribute.
   */
  def strokePolyline(xPoints: Array[Double], yPoints: Array[Double], nPoints: Int): Unit = {
    delegate.strokePolyline(xPoints, yPoints, nPoints)
  }

  /**
   * Draws a polyline with the given points using the currently set stroke paint attribute.
   */
  def strokePolyline(points: Seq[(Double, Double)]): Unit = {
    this.executeWithPoints(strokePolyline, points)
  }

  /**
   * Strokes a rectangle using the current stroke paint.
   */
  def strokeRect(x: Double, y: Double, w: Double, h: Double): Unit = {
    delegate.strokeRect(x, y, w, h)
  }

  /**
   * Strokes a rounded rectangle using the current stroke paint.
   */
  def strokeRoundRect(x: Double, y: Double, w: Double, h: Double, arcWidth: Double, arcHeight: Double): Unit = {
    delegate.strokeRoundRect(x, y, w, h, arcWidth, arcHeight)
  }

  /**
   * draws the given string of text at position x, y (0,0 at top left) with the current stroke paint attribute.
   */
  def strokeText(text: String, x: Double, y: Double): Unit = {
    delegate.strokeText(text, x, y)
  }

  /**
   * Draws text with stroke paint and includes a maximum width of the string.
   */
  def strokeText(text: String, x: Double, y: Double, maxWidth: Double): Unit = {
    delegate.strokeText(text, x, y, maxWidth)
  }

  /**
   * the current TextAlignment.
   */
  def textAlign = delegate.getTextAlign

  def textAlign_=(align: TextAlignment): Unit = {
    delegate.setTextAlign(align)
  }

  /**
   * the current Text Baseline.
   */
  def textBaseline = delegate.getTextBaseline

  def textBaseline_=(baseline: VPos): Unit = {
    delegate.setTextBaseline(baseline)
  }

  /*
   * IMPLEMENTATION NOTE ABOUT TRANSFORM: Although there is more than a getter and setter for Transform. Besides, one
   * of getters has parameter (in this case the Effect to be used). Furthermore, there is two transform methods in 
   * original class. So I decided not to use the Scala pattern for getters and setters. 
   */

  /**
   * Returns a copy of the current transform.
   */
  def getTransform: Affine = delegate.getTransform

  /**
   * Sets the current transform.
   */
  def setTransform(xform: Affine): Unit = {
    delegate.setTransform(xform)
  }

  /**
   * Returns a copy of the current transform.
   */
  def getTransform(xform: Affine): Affine = delegate.getTransform(xform)

  /**
   * Sets the current transform.
   */
  def setTransform(mxx: Double, myx: Double, mxy: Double, myy: Double, mxt: Double, myt: Double): Unit = {
    delegate.setTransform(mxx, myx, mxy, myy, mxt, myt)
  }

  /**
   * Concatenates the input with the current transform.
   */
  def transform(xform: Affine): Unit = {
    delegate.transform(xform)
  }

  /**
   * Concatenates the input with the current transform.
   */
  def transform(mxx: Double, myx: Double, mxy: Double, myy: Double, mxt: Double, myt: Double): Unit = {
    delegate.transform(mxx, myx, mxy, myy, mxt, myt)
  }

  /**
   * Translates the current transform by x, y.
   */
  def translate(x: Double, y: Double): Unit = {
    delegate.translate(x, y)
  }

}
