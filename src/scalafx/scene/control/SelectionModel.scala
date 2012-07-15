package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import scalafx.Includes.jfxReadOnlyIntegerProperty2sfx
import scalafx.beans.property.ReadOnlyIntegerProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.util.SFXDelegate

object SelectionModel {
  def sfxSelectionModel2jfx[T](v: SelectionModel[T]) = v.delegate
}

abstract class SelectionModel[T](override val delegate: jfxsc.SelectionModel[T])
  extends SFXDelegate[jfxsc.SelectionModel[T]] {

  /**
   * Refers to the selected index property, which is used to indicate the
   * currently selected index value in the selection model.
   */
  def selectedIndex: ReadOnlyIntegerProperty = delegate.selectedIndexProperty

  /**
   * Refers to the selected item property, which is used to indicate the
   * currently selected item in the selection model.
   */
  def selectedItem: ReadOnlyObjectProperty[T] = 
    new ReadOnlyObjectProperty[T](delegate.selectedItemProperty)

  /**
   * A method that clears any selection prior to setting the selection to the
   * given index.
   */
  def clearAndSelect(index: Int): Unit = delegate.clearAndSelect(index)

  /**
   * Clears the selection model of all selected indices.
   */
  def clearSelection: Unit = delegate.clearSelection

  /**
   * This method will clear the selection of the item in the given index.
   */
  def clearSelection(index: Int): Unit = delegate.clearSelection(index)

  /**
   * This method is available to test whether there are any selected
   * indices/items.
   */
  def isEmpty: Boolean = delegate.isEmpty

  /**
   * Convenience method to inform if the given index is currently selected in this SelectionModel.
   */
  def isSelected(index: Int): Boolean = delegate.isSelected(index)

  /**
   * This will select the given index in the selection model, assuming the
   * index is within the valid range (i.e.
   */
  def select(index: Int): Unit = delegate.select(index)

  /**
   * This method will attempt to select the index that contains the given object.
   */
  def select(obj: T): Unit = delegate.select(obj)

  /**
   * This method will attempt to select the first index in the control.
   */
  def selectFirst: Unit = delegate.selectFirst

  /**
   * This method will attempt to select the last index in the control.
   */
  def selectLast: Unit = delegate.selectLast

  /**
   * This method will attempt to select the index directly after the current
   * focused index.
   */
  def selectNext: Unit = delegate.selectNext

  /**
   * This method will attempt to select the index directly before the current focused index.
   */
  def selectPrevious: Unit = delegate.selectPrevious

}
