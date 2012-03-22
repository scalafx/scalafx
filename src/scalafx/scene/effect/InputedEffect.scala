package scalafx.scene.effect

import scalafx.Includes._
import javafx.scene.{ effect => jfxse }
import javafx.beans.{ property => jfxbp }
import scalafx.util.SFXDelegate

/**
 * Trait that unify all Effect subclasses whose Java counterpart have input Property. See type Inputed.
 */
trait InputedEffect {

  type Inputed = {
    def getInput: jfxse.Effect
    def inputProperty: jfxbp.ObjectProperty[jfxse.Effect]
    def setInput(value: jfxse.Effect)
  }

  protected def inputed: jfxse.Effect with Inputed

  /**
   * The input for this Effect.
   */
  def input = inputed.inputProperty
  def input_=(v: Effect) {
    input() = v
  }

}