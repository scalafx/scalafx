package scalafx.colorselector

import scalafx.geometry.Insets

package object colorselector {

  val Min = 0.0

  val Max = 255.0

  val insets = Insets(5, 5, 5, 5)

  def doubleToInt(d: Double) = (colorselector.Max * d).toInt

}