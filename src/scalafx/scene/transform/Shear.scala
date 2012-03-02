package scalafx.scene.transform

import javafx.scene.{ transform => jfxst }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object Shear {
  implicit def sfxShear2jfx(v: Shear) = v.delegate
}

class Shear(override val delegate: jfxst.Shear = new jfxst.Shear) extends Transform(delegate) with SFXDelegate[jfxst.Shear] {

  def this(x: Double, y: Double) = this(new jfxst.Shear(x, y))
  
  def this(x: Double, y: Double, pivotX: Double, pivotY: Double) = this(new jfxst.Shear(x, y, pivotX, pivotY))
  
  /**
   * Defines the X coordinate of the shear pivot point.
   */
  def pivotX = delegate.pivotXProperty()
  def pivotX_=(v: Double) {
    pivotX() = v
  }

  /**
   * Defines the Y coordinate of the shear pivot point.
   */
  def pivotY = delegate.pivotYProperty()
  def pivotY_=(v: Double) {
    pivotY() = v
  }

  /**
   * Defines the multiplier by which coordinates are shifted in the direction of the positive X axis as a factor of their Y coordinate.
   */
  def x = delegate.xProperty()
  def x_=(v: Double) {
    x() = v
  }

  /**
   * Defines the multiplier by which coordinates are shifted in the direction of the positive Y axis as a factor of their X coordinate.
   */
  def y = delegate.yProperty()
  def y_=(v: Double) {
    y() = v
  }

}