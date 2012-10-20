package scalafx.scene.transform

import javafx.scene.{ transform => jfxst }
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.util.PositionDelegate

object Scale {
  implicit def sfxScale2jfx(v: Scale) = v.delegate
}

class Scale(override val delegate: jfxst.Scale = new jfxst.Scale)
  extends Transform(delegate)
  with PositionDelegate[jfxst.Scale] 
  with SFXDelegate[jfxst.Scale] {

  def this(x: Double, y: Double) = this(new jfxst.Scale(x, y))

  def this(x: Double, y: Double, z: Double) = this(new jfxst.Scale(x, y, z))

  def this(x: Double, y: Double, pivotX: Double, pivotY: Double) = this(new jfxst.Scale(x, y, pivotX, pivotY))

  def this(x: Double, y: Double, z: Double, pivotX: Double, pivotY: Double, pivotZ: Double) = this(new jfxst.Scale(x, y, z, pivotX, pivotY, pivotZ))

  /**
   * Defines the X coordinate about which point the scale occurs.
   */
  def pivotX = delegate.pivotXProperty()
  def pivotX_=(v: Double) {
    pivotX() = v
  }

  /**
   * Defines the Y coordinate about which point the scale occurs.
   */
  def pivotY = delegate.pivotYProperty()
  def pivotY_=(v: Double) {
    pivotY() = v
  }

  /**
   * Defines the Z coordinate about which point the scale occurs.
   */
  def pivotZ = delegate.pivotZProperty()
  def pivotZ_=(v: Double) {
    pivotZ() = v
  }

  /**
   * Defines the factor by which coordinates are scaled along the Z axis direction.
   */
  def z = delegate.zProperty()
  def z_=(v: Double) {
    z() = v
  }

}