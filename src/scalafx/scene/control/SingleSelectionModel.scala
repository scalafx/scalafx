package scalafx.scene.control

import scalafx.util.SFXDelegate
import javafx.scene.{ control => jfxsc }
import javafx.{ collections => jfxc }
import scalafx.Includes._

object SingleSelectionModel {

  def sfxSingleSelectionModel2jfx[T](v: SingleSelectionModel[T]) = v.delegate

}

abstract class SingleSelectionModel[T](override val delegate: jfxsc.SingleSelectionModel[T]) extends SelectionModel[T](delegate) with SFXDelegate[jfxsc.SingleSelectionModel[T]] {

}