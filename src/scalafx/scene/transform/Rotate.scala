package scalafx.scene.transform

import javafx.scene.{transform => jfxst}
import scalafx.Includes._
import scalafx.geometry.Point3D._
import scalafx.geometry.Point3D
import scalafx.util.SFXDelegate

object Rotate {
  implicit def sfxRotate2jfx(v: Rotate) = v.delegate
  
  val XAxis = new Point3D(jfxst.Rotate.X_AXIS)
  
  val YAxis = new Point3D(jfxst.Rotate.Y_AXIS)
  
  val ZAxis = new Point3D(jfxst.Rotate.Z_AXIS)
}

class Rotate(override val delegate: jfxst.Rotate = new jfxst.Rotate) extends Transform(delegate) with SFXDelegate[jfxst.Rotate] {

  def this(angle: Double ) = this( new jfxst.Rotate(angle ))

  def this(angle: Double, pivotX: Double, pivotY: Double ) = this( new jfxst.Rotate(angle, pivotX, pivotY ))

  def this(angle: Double, pivotX: Double, pivotY: Double, pivotZ: Double ) =
    this( new jfxst.Rotate(angle, pivotX, pivotY, pivotZ ))

  def this(angle: Double, pivotX: Double, pivotY: Double, pivotZ: Double, axis: Point3D ) =
    this( new jfxst.Rotate(angle, pivotX, pivotY, pivotZ, axis ))

  def this(angle: Double, axis: Point3D ) = this( new jfxst.Rotate(angle, axis ))

  /**
   * Defines the angle of rotation measured in degrees.
   */
  def angle = delegate.angleProperty()
  def angle_=(v: Double) {
    angle() = v
  }

  /**
   * Defines the axis of rotation at the pivot point.
   */
  def axis = delegate.axisProperty()
  def axis_=(v: Point3D) {
    axis() = v
  }

  /**
   * Defines the X coordinate of the rotation pivot point.
   */
  def pivotX = delegate.pivotXProperty()
  def pivotX_=(v: Double) {
    pivotX() = v
  }

  /**
   * Defines the Y coordinate of the rotation pivot point.
   */
  def pivotY = delegate.pivotYProperty()
  def pivotY_=(v: Double) {
    pivotY() = v
  }

  /**
   * Defines the Z coordinate of the rotation pivot point.
   */
  def pivotZ = delegate.pivotZProperty()
  def pivotZ_=(v: Double) {
    pivotZ() = v
  }

}
