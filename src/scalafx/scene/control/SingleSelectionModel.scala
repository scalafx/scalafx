package scalafx.scene.control

import scalafx.util.SFXDelegate
import javafx.scene.{ control => jfxsc }
import javafx.{ collections => jfxc }
import scalafx.Includes._

object SingleSelectionModel {
  implicit def sfxSingleSelectionModel2jfx[T](v: SingleSelectionModel[T]) = v.delegate

  /**
   * Creates a new [[SingleSelectionModel]] from functions that defines a data
   * model and quantity of items. This method was created to supply necessity
   * to override protected methods
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/SingleSelectionModel.html#getItemCount() getItemCount()]]
   * and
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/SingleSelectionModel.html#getModelItem(int) getModelItem(int)]]
   * from
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/SingleSelectionModel.html SingleSelectionModel]].
   *
   * @tparam T  The type of the item contained in the control that can be
   * selected.
   * @param modelItem Function that gets the data model item associated with a
   * specific index.
   * @param itemCount Function that gets the number of items available for the
   * selection model.
   */
  def apply[T](modelItem: Int => T, itemCount: => Int) = new SingleSelectionModel[T](
    new jfxsc.SingleSelectionModel[T] {
      protected def getModelItem(index: Int): T = modelItem(index)
      protected def getItemCount = itemCount
    }) {}

}

abstract class SingleSelectionModel[T](override val delegate: jfxsc.SingleSelectionModel[T])
  extends SelectionModel[T](delegate)
  with SFXDelegate[jfxsc.SingleSelectionModel[T]] 