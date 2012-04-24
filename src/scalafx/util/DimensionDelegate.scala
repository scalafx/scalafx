/**
 *
 */
package scalafx.util

import javafx.beans.{ property => jfxbp }
import scalafx.beans.property.DoubleProperty
import scalafx.Includes._

/**
 * Trait that unifies JavaFX classes that contains properties indicating height and width,
 * represented by heightProperty and widthProperty and their respectives getter and setters.
 *
 */
trait DimensionDelegate {

  type Dimensioned = {
    def getHeight: java.lang.Double
    def setHeight(h: java.lang.Double): Unit
    def heightProperty: jfxbp.DoubleProperty

    def getWidth: java.lang.Double
    def setWidth(w: java.lang.Double): Unit
    def widthProperty: jfxbp.DoubleProperty
  }

  def dimensionedDelegate: Dimensioned

  def height: DoubleProperty = dimensionedDelegate.heightProperty
  def height_=(h: Double) {
    height() = h
  }

  def width: DoubleProperty = dimensionedDelegate.widthProperty
  def width_=(w: Double) {
    width() = w
  }

}