/*
 * Copyright (c) 2012, ScalaFX Project
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
import scalafx.Includes._
import scalafx.util.SFXDelegate

object Affine {
  implicit def sfxAffine2jfx(v: Affine) = v.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/scene/transform/Affine.html]]
 */
class Affine(override val delegate: jfxst.Affine = new jfxst.Affine) extends Transform(delegate) with SFXDelegate[jfxst.Affine] {

  /**
   * Defines the X coordinate scaling element of the 3x4 matrix.
   */
  def mxx = delegate.mxxProperty()
  def mxx_=(v: Double) {
    mxx() = v
  }

  /**
   * Defines the XY coordinate element of the 3x4 matrix.
   */
  def mxy = delegate.mxyProperty()
  def mxy_=(v: Double) {
    mxy() = v
  }

  /**
   * Defines the XZ coordinate element of the 3x4 matrix.
   */
  def mxz = delegate.mxzProperty()
  def mxz_=(v: Double) {
    mxz() = v
  }

  /**
   * Defines the YX coordinate element of the 3x4 matrix.
   */
  def myx = delegate.myxProperty()
  def myx_=(v: Double) {
    myx() = v
  }

  /**
   * Defines the Y coordinate scaling element of the 3x4 matrix.
   */
  def myy = delegate.myyProperty()
  def myy_=(v: Double) {
    myy() = v
  }

  /**
   * Defines the YZ coordinate element of the 3x4 matrix.
   */
  def myz = delegate.myzProperty()
  def myz_=(v: Double) {
    myz() = v
  }

  /**
   * Defines the ZX coordinate element of the 3x4 matrix.
   */
  def mzx = delegate.mzxProperty()
  def mzx_=(v: Double) {
    mzx() = v
  }

  /**
   * Defines the ZY coordinate element of the 3x4 matrix.
   */
  def mzy = delegate.mzyProperty()
  def mzy_=(v: Double) {
    mzy() = v
  }

  /**
   * Defines the Z coordinate scaling element of the 3x4 matrix.
   */
  def mzz = delegate.mzzProperty()
  def mzz_=(v: Double) {
    mzz() = v
  }

  /**
   * Defines the X coordinate translation element of the 3x4 matrix.
   */
  def tx = delegate.txProperty()
  def tx_=(v: Double) {
    tx() = v
  }

  /**
   * Defines the Y coordinate translation element of the 3x4 matrix.
   */
  def ty = delegate.tyProperty()
  def ty_=(v: Double) {
    ty() = v
  }

  /**
   * Defines the Z coordinate translation element of the 3x4 matrix.
   */
  def tz = delegate.tzProperty()
  def tz_=(v: Double) {
    tz() = v
  }

}