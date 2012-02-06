package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.util.SFXDelegate

object ProgressBar {
  implicit def sfxProgressBar2jfx(v: ProgressBar) = v.delegate
}

class ProgressBar(override val delegate: jfxsc.ProgressBar = new jfxsc.ProgressBar) extends ProgressIndicator(delegate) with SFXDelegate[jfxsc.ProgressBar] {

}