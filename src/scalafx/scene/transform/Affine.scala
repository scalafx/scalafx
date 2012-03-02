package scalafx.scene.transform

import javafx.scene.{transform => jfxst}
import scalafx.Includes._
import scalafx.util.SFXDelegate

object Affine {
  implicit def sfxAffine2jfx(v: Affine) = v.delegate
}

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