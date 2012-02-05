package scalafx.scene.control

import javafx.scene.{ control => jfxsc }

import scalafx.Includes._
import scalafx.util.SFXDelegate
import collection.JavaConversions._

object ProgressIndicator {
  implicit def sfxProgressIndicator2jfx(v: ProgressIndicator) = v.delegate

  val INDETERMINATE_PROGRESS = jfxsc.ProgressIndicator.INDETERMINATE_PROGRESS
}

class ProgressIndicator(override val delegate: jfxsc.ProgressIndicator = new jfxsc.ProgressIndicator) extends Control(delegate) with SFXDelegate[jfxsc.ProgressIndicator] {

  def indeterminate = delegate.indeterminateProperty

  def progress = delegate.progressProperty
  def progress_=(v: Double) {
    progress() = v
  }

}