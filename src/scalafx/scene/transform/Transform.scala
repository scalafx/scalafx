package scalafx.scene.transform

import scalafx.Includes._
import javafx.scene.{ transform => jfxst }
import scalafx.util.SFXDelegate

object Transform {

  implicit def sfxTransform2jfx(v: Transform) = v.delegate

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

abstract class Transform(override val delegate: jfxst.Transform) extends SFXDelegate[jfxst.Transform] {

}