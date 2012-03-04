/**
 * 
 */
package scalafx.scene.control;

import javafx.collections.ObservableList;
import javafx.scene.control.MultipleSelectionModel;

/**
 * Simple {@link MultipleSelectionModel} implemetation to be used in MultipleSelectionModelSpec
 *
 */
class SimpleMultipleSelectionModel<T> extends MultipleSelectionModel<T> {

	/* (non-Javadoc)
	 * @see javafx.scene.control.MultipleSelectionModel#getSelectedIndices()
	 */
	@Override
	public ObservableList<Integer> getSelectedIndices() {
		return null;
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.MultipleSelectionModel#getSelectedItems()
	 */
	@Override
	public ObservableList<T> getSelectedItems() {
		return null;
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.MultipleSelectionModel#selectAll()
	 */
	@Override
	public void selectAll() {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.MultipleSelectionModel#selectFirst()
	 */
	@Override
	public void selectFirst() {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.MultipleSelectionModel#selectIndices(int, int[])
	 */
	@Override
	public void selectIndices(int index, int... indices) {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.MultipleSelectionModel#selectLast()
	 */
	@Override
	public void selectLast() {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#clearAndSelect(int)
	 */
	@Override
	public void clearAndSelect(int index) {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#clearSelection()
	 */
	@Override
	public void clearSelection() {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#clearSelection(int)
	 */
	@Override
	public void clearSelection(int index) {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#isSelected(int)
	 */
	@Override
	public boolean isSelected(int index) {
		return false;
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#select(int)
	 */
	@Override
	public void select(int index) {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#select(java.lang.Object)
	 */
	@Override
	public void select(T obj) {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#selectNext()
	 */
	@Override
	public void selectNext() {
	}

	/* (non-Javadoc)
	 * @see javafx.scene.control.SelectionModel#selectPrevious()
	 */
	@Override
	public void selectPrevious() {
	}

}
