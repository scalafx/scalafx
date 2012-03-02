package scalafx.geometry

import javafx.{ geometry => jfxg }
import scalafx.util.SFXDelegate

object Point3D {
  implicit def sfxPoint3D2jfx(p: Point3D) = p.delegate
}

class Point3D(override val delegate: jfxg.Point3D) extends SFXDelegate[jfxg.Point3D] {

  def this(x: Double, y: Double, z: Double) = this(new jfxg.Point3D(x, y, z))

  /**
   * The x coordinate.
   */
  def x = delegate.getX

  /**
   * The y coordinate.
   */
  def y = delegate.getX

  /**
   * The z coordinate.
   */
  def z = delegate.getX

  /**
   * Computes the distance between this point and point (x1, y1, z1).
   */
  def distance(x1: Double, y1: Double, z1: Double) = delegate.distance(x1, y1, z1)

  /**
   * Computes the distance between this point and point p.
   */
  def distance(p: Point3D) = delegate.distance(p)

}