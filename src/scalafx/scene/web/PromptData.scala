package scalafx.scene.web

import javafx.scene.{ web => jfxsw }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object PromptData {
  implicit def sfxPromptData2jfx(pd: PromptData) = pd.delegate
}

class PromptData(override val delegate: jfxsw.PromptData) extends SFXDelegate[jfxsw.PromptData] {

  /**
   * .
   * Creates a new instance.
   */
  def this(message: String, defaultValue: String) = this(new jfxsw.PromptData(message, defaultValue))

  /**
   * Returns default value carried by this data object.
   */
  def defaultValue = delegate.getDefaultValue

  /**
   * Returns message carried by this data object.
   */
  def message = delegate.getMessage

}