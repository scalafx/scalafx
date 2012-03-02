/**
 *
 */
package scalafx.scene.transform

import scalafx.Includes._
import javafx.scene.{ transform => jfxst }
import scalafx.util.SFXDelegate

object Translate {
  implicit def sfxTranslate2jfx(v: Translate) = v.delegate
}

/**
 * @author RUAfonso
 *
 */
class Translate(override val delegate: jfxst.Translate = new jfxst.Translate) extends SFXDelegate[jfxst.Translate] {

  def this(x: Double, y: Double) = this(new jfxst.Translate(x, y))

  def this(x: Double, y: Double, z: Double) = this(new jfxst.Translate(x, y, z))

  /**
   * Defines the distance by which coordinates are translated in the X axis direction
   */
  def x = delegate.xProperty
  def x_=(v: Double) {
    x() = v
  }

  /**
   * Defines the distance by which coordinates are translated in the Y axis direction
   */
  def y = delegate.yProperty
  def y_=(v: Double) {
    y() = v
  }

  /**
   * Defines the distance by which coordinates are translated in the Z axis direction
   */
  def z = delegate.zProperty
  def z_=(v: Double) {
    z() = v
  }

}