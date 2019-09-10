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
package scalafx.scene.transform

import javafx.scene.{transform => jfxst}
import javafx.{event => jfxe}
import scalafx.Includes._
import scalafx.beans.property.{ObjectProperty, ReadOnlyBooleanProperty}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions


object Transform {

  implicit def sfxTransform2jfx(v: Transform): jfxst.Transform = if (v != null) v.delegate else null

  /**
   * Returns a new Affine object from 12 number values representing the 6 specifiable entries of the 3x4 Affine transformation matrix.
   */
  def affine(mxx: Double, myx: Double, mxy: Double, myy: Double, tx: Double, ty: Double): Affine = jfxst.Transform.affine(mxx, myx, mxy, myy, tx, ty)

  /**
   * Returns a new Affine object from 12 number values representing the 6 specifiable entries of the 3x4 Affine transformation matrix.
   */
  def affine(mxx: Double, mxy: Double, mxz: Double, tx: Double, myx: Double, myy: Double, myz: Double, ty: Double, mzx: Double, mzy: Double, mzz: Double, tz: Double): Affine =
    jfxst.Transform.affine(mxx, mxy, mxz, tx, myx, myy, myz, ty, mzx, mzy, mzz, tz)

  /**
   * Returns a Rotate object that rotates coordinates around a pivot point.
   */
  def rotate(angle: Double, pivotX: Double, pivotY: Double): Rotate = jfxst.Transform.rotate(angle, pivotX, pivotY)

  /**
   * Returns a Scale object representing a scaling transformation.
   */
  def scale(x: Double, y: Double): Scale = jfxst.Transform.scale(x, y)

  /**
   * Returns a Scale object representing a scaling transformation.
   */
  def scale(x: Double, y: Double, pivotX: Double, pivotY: Double): Scale = jfxst.Transform.scale(x, y, pivotX, pivotY)

  /**
   * Returns a Shear object representing a shearing transformation.
   */
  def shear(x: Double, y: Double): Shear = jfxst.Transform.shear(x, y)

  /**
   * Returns a Shear object representing a shearing transformation.
   */
  def shear(x: Double, y: Double, pivotX: Double, pivotY: Double): Shear = jfxst.Transform.shear(x, y, pivotX, pivotY)

  /**
   * Returns a Translate object representing a translation transformation.
   */
  def translate(x: Double, y: Double): Translate = jfxst.Transform.translate(x, y)

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/scene/transform/Transform.html]]
 */
abstract class Transform(override val delegate: jfxst.Transform) extends SFXDelegate[jfxst.Transform] {

  // TODO implement missing methods from JFX2 and JFX8

  /** Determines if this is currently an identity transform. */
  def identity: ReadOnlyBooleanProperty = delegate.identityProperty

  /** The onTransformChanged event handler is called whenever the transform changes any of its parameters. */
  def onTransformChanged: ObjectProperty[jfxe.EventHandler[_ >: jfxst.TransformChangedEvent]] = delegate.onTransformChangedProperty

  def onTransformChanged_=(v: jfxe.EventHandler[_ >: jfxst.TransformChangedEvent]): Unit = {
    ObjectProperty.fillProperty[jfxe.EventHandler[_ >: jfxst.TransformChangedEvent]](this.onTransformChanged, v)
  }

  /** Determines if this is currently a 2D transform. */
  def type2D: ReadOnlyBooleanProperty = delegate.type2DProperty
}