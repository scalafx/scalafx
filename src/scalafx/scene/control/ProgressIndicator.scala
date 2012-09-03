package scalafx.scene.control

import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ReadOnlyBooleanProperty
import scalafx.util.SFXDelegate

object ProgressIndicator {
  implicit def sfxProgressIndicator2jfx(v: ProgressIndicator) = v.delegate

  val INDETERMINATE_PROGRESS = jfxsc.ProgressIndicator.INDETERMINATE_PROGRESS
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/ProgressIndicator.html]]
 */
class ProgressIndicator(override val delegate: jfxsc.ProgressIndicator = new jfxsc.ProgressIndicator)
  extends Control(delegate)
  with SFXDelegate[jfxsc.ProgressIndicator] {

  /**
   * A flag indicating whether it is possible to determine the progress of the ProgressIndicator.
   */
  def indeterminate: ReadOnlyBooleanProperty = delegate.indeterminateProperty

  /**
   * The actual progress of the ProgressIndicator.
   */
  def progress: DoubleProperty = delegate.progressProperty
  def progress_=(v: Double) {
    progress() = v
  }

}