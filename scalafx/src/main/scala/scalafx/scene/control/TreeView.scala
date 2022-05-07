/*
 * Copyright (c) 2011-2022, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.scene.control

import javafx.scene.control as jfxsc
import javafx.{event as jfxe, util as jfxu}
import scalafx.Includes.*
import scalafx.beans.property.*
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventType}

import scala.language.implicitConversions

object TreeView {
  implicit def sfxTreeView2jfx[T](v: TreeView[T]): jfxsc.TreeView[T] = if (v != null) v.delegate else null

  object EditEvent {
    implicit def sfxTreeViewEditEvent2jfx[T](v: EditEvent[T]): jfxsc.TreeView.EditEvent[T] =
      if (v != null) v.delegate else null
  }

  class EditEvent[T](override val delegate: jfxsc.TreeView.EditEvent[T])
      extends Event(delegate)
      with SFXDelegate[jfxsc.TreeView.EditEvent[T]] {

    /**
     * Creates a new EditEvent instance to represent an edit event.
     */
    def this(
      source: TreeView[T],
      eventType: jfxe.EventType[? <: jfxsc.TreeView.EditEvent[T]],
      treeItem: TreeItem[T],
      oldValue: T,
      newValue: T
    ) =
      this(new jfxsc.TreeView.EditEvent[T](source, eventType, treeItem, oldValue, newValue))

    /**
     * Returns the new value input into the TreeItem by the end user.
     */
    def newValue: T = delegate.getNewValue

    /**
     * Returns the old value that existed in the TreeItem prior to the current edit event.
     */
    def oldValue: T = delegate.getOldValue

    /**
     * Returns the TreeView upon which the edit took place.
     */
    override def source: TreeView[T] = delegate.getSource

    /**
     * Returns the `TreeItem` upon which the edit took place.
     */
    def treeItem: TreeItem[T] = delegate.getTreeItem

  }

  /**
   * An EventType that indicates some edit event has occurred.
   */
  def editAnyEvent: EventType[jfxsc.TreeView.EditEvent[Nothing]] = new EventType(jfxsc.TreeView.editAnyEvent)

  /**
   * An EventType used to indicate that an edit event has just been canceled
   * within the TreeView upon which the event was fired.
   */
  def editCancelEvent: EventType[jfxsc.TreeView.EditEvent[Nothing]] = new EventType(jfxsc.TreeView.editCancelEvent)

  /**
   * An EventType that is used to indicate that an edit in a TreeView has been
   * committed.
   */
  def editCommitEvent: EventType[jfxsc.TreeView.EditEvent[Nothing]] = new EventType(jfxsc.TreeView.editCommitEvent)

  /**
   * An EventType used to indicate that an edit event has started within the
   * TreeView upon which the event was fired.
   */
  def editStartEvent: EventType[jfxsc.TreeView.EditEvent[Nothing]] = new EventType(jfxsc.TreeView.editStartEvent)

  /**
   * Returns the number of levels of 'indentation' of the given TreeItem,
   * based on how many times getParent() can be recursively called.
   */
  @deprecated(
    "This method does not correctly calculate the distance from the given TreeItem to the root of the TreeView. " +
      "As of JavaFX 8.0_20, the proper way to do this is via getTreeItemLevel(TreeItem)",
    since = "8.0_20"
  )
  def nodeLevel(node: TreeItem[?]): Int = jfxsc.TreeView.getNodeLevel(node)

  /**
   * Creates a new TreeView overriding layoutChildren method from JavaFX's
   * TreeView.
   */
  def apply[T](layoutChildrenOp: () => Unit) = new TreeView[T](new jfxsc.TreeView[T] {
    override def layoutChildren(): Unit = {
      layoutChildrenOp()
    }
  })

}

/**
 * The `TreeView` control provides a view on to a tree root (of type `TreeItem`).
 * By using a `TreeView`, it is possible to drill down into the children of a `TreeItem`,
 * recursively until a `TreeItem` has no children (that is, it is a leaf node in the tree).
 * To facilitate this, unlike controls like `ListView`, in `TreeView` it is necessary to only specify the root node.
 *
 * For more information on building up a tree using this approach, refer to the `TreeItem` class documentation.
 * Briefly, to create a `TreeView`, you should do something along the lines of the following:
 *
 * {{{
 *   val rootItem = new TreeItem("Root Node") {
 *     expanded = true
 *     children ++= Seq(
 *       new TreeItem("Item 1"),
 *       new TreeItem("Item 2"),
 *       new TreeItem("Item 3")
 *     )
 *   }
 *
 *   val treeView = new TreeView[String] {
 *     root = rootItem
 *   }
 * }}}
 *
 * @param delegate underlying JavaFX class
 * @tparam T The type of the item contained within the `TreeItem` value property for all tree items in this `TreeView`.
 */
class TreeView[T](override val delegate: jfxsc.TreeView[T] = new jfxsc.TreeView[T])
    extends Control(delegate)
    with SFXDelegate[jfxsc.TreeView[T]] {

  /**
   * Creates a TreeView with the provided root node.
   */
  def this(rootItem: TreeItem[T]) = this(new jfxsc.TreeView[T](rootItem))

  /**
   * Represents the cell factory that will be used for creating TreeCells, which are used to represent items in the TreeView.
   */
  def cellFactory: ObjectProperty[jfxu.Callback[jfxsc.TreeView[T], jfxsc.TreeCell[T]]] = delegate.cellFactoryProperty
  def cellFactory_=(v: jfxu.Callback[jfxsc.TreeView[T], jfxsc.TreeCell[T]]): Unit = {
    cellFactory.value = v
  }
  def cellFactory_=(v: TreeView[T] => TreeCell[T]): Unit = {
    cellFactory() = new jfxu.Callback[jfxsc.TreeView[T], jfxsc.TreeCell[T]] {
      def call(tv: jfxsc.TreeView[T]): jfxsc.TreeCell[T] = {
        v(tv)
      }
    }
  }

  /**
   * This is a helper method for easy creation of custom cell factories.
   * The custom cell is automatically created, and it handles rendering of empty cells.
   * The user is only responsible for providing an operation `op` that renders non-empty cells.
   *
   * The operation `op` provides as input the already created custom `cell` and `value` of that cell.
   * The `value` is provided by the `cellValueFactory`. The `value` is guaranteed to be non `null`.
   * The `null` values are automatically rendered as empty cells by the provided `cell` object.
   *
   * Here is an example where value's type is a case class `Person` that contains two text fields: `firstName` and `lastName`.
   * {{{
   *   case class Person(firstName:String, lastName:String)
   *   ...
   *
   *   cellFactory = (cell, value) => {
   *     cell.text = value.firstName + " " + value.lastName
   *   }
   * }}}
   *
   * Another example where 'value' is of type 'Color' and the cell factory creates a circle representing that color:
   * {{{
   *   cellFactory = (cell, value) => {
   *     cell.graphic = new Circle {
   *        fill = value
   *        radius = 8
   *     }
   *   }
   * }}}
   *
   * @param op a method that will create content for a given `cell`.
   *           It gets as an input automatically created custom `cell` and a non-null `value` of that cell.
   *           `op` is called in the cell's `updateItem` method.
   */
  def cellFactory_=(op: (TreeCell[T], T) => Unit): Unit = {
    val callback =
      Option(op)
        .map { op =>
          new jfxu.Callback[jfxsc.TreeView[T], jfxsc.TreeCell[T]] {
            def call(tv: jfxsc.TreeView[T]): jfxsc.TreeCell[T] = {
              new jfxsc.TreeCell[T] {
                val sfxThis = new TreeCell(this)
                override def updateItem(item: T, empty: Boolean): Unit = {
                  super.updateItem(item, empty)
                  if (empty || item == null) {
                    setText(null)
                    setGraphic(null)
                  } else {
                    op(sfxThis, item)
                  }
                }
              }
            }
          }
        }
        .orNull

    delegate.cellFactoryProperty.setValue(callback)
  }

  /**
   * Specifies whether this TreeView is editable - only if the TreeView and
   * the TreeCells within it are both editable will a TreeCell be able to go
   * into their editing state.
   */
  def editable: BooleanProperty = delegate.editableProperty

  def editable_=(v: Boolean): Unit = {
    editable() = v
  }

  /**
   * A property used to represent the TreeItem currently being edited in the
   * TreeView, if editing is taking place, or -1 if no item is being edited.
   */
  def editingItem: ReadOnlyObjectProperty[jfxsc.TreeItem[T]] = delegate.editingItemProperty

  /** Represents the number of tree nodes presently able to be visible in the TreeView. */
  def expandedItemCount: ReadOnlyIntegerProperty = delegate.expandedItemCountProperty

  /** Specifies whether this control has cells that are a fixed height (of the specified value). */
  def fixedCellSize: DoubleProperty = delegate.fixedCellSizeProperty

  def fixedCellSize_=(v: Double): Unit = {
    fixedCellSize() = v
  }

  /**
   * The FocusModel provides the API through which it is possible to control
   * focus on zero or one rows of the TreeView.
   */
  def focusModel: ObjectProperty[jfxsc.FocusModel[jfxsc.TreeItem[T]]] = delegate.focusModelProperty

  def focusModel_=(v: FocusModel[jfxsc.TreeItem[T]]): Unit = {
    focusModel() = v
  }

  /**
   * This event handler will be fired when the user cancels editing a cell.
   */
  def onEditCancel: ObjectProperty[jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]] = delegate.onEditCancelProperty

  def onEditCancel_=(v: jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]): Unit = {
    onEditCancel() = v
  }

  /**
   * This event handler will be fired when the user commits editing a cell.
   */
  def onEditCommit: ObjectProperty[jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]] = delegate.onEditCommitProperty

  def onEditCommit_=(v: jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]): Unit = {
    onEditCommit() = v
  }

  /**
   * This event handler will be fired when the user starts editing a cell.
   */
  def onEditStart: ObjectProperty[jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]] = delegate.onEditStartProperty

  def onEditStart_=(v: jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]): Unit = {
    onEditStart() = v
  }

  /**
   * Called when there's a request to scroll an index into view using `scrollTo(Int)`
   */
  def onScrollTo: ObjectProperty[jfxe.EventHandler[jfxsc.ScrollToEvent[Integer]]] = delegate.onScrollToProperty

  def onScrollTo_=(v: jfxe.EventHandler[jfxsc.ScrollToEvent[Integer]]): Unit = {
    ObjectProperty.fillProperty[jfxe.EventHandler[jfxsc.ScrollToEvent[Integer]]](onScrollTo, v)
  }

  /**
   * Property representing the root node of the TreeView.
   */
  def root: ObjectProperty[jfxsc.TreeItem[T]] = delegate.rootProperty

  def root_=(v: TreeItem[T]): Unit = {
    root() = v
  }

  /**
   * Scrolls the TreeView such that the item in the given index is visible to the end user.
   */
  def scrollTo(index: Int): Unit = {
    delegate.scrollTo(index)
  }

  /**
   */
  def selectionModel: ObjectProperty[jfxsc.MultipleSelectionModel[jfxsc.TreeItem[T]]] = delegate.selectionModelProperty

  def selectionModel_=(v: MultipleSelectionModel[jfxsc.TreeItem[T]]): Unit = {
    selectionModel() = v
  }

  /**
   * Property that represents whether or not the TreeView root node is visible.
   */
  def showRoot: BooleanProperty = delegate.showRootProperty

  def showRoot_=(v: Boolean): Unit = {
    showRoot() = v
  }

  /**
   * Returns the number of levels of 'indentation' of the given TreeItem, based on how many times getParent()
   * can be recursively called.
   * If the given TreeItem is the root node of this TreeView, or if the TreeItem does not have any parent set,
   * the returned value will be zero. For each time getParent() is recursively called,
   * the returned value is incremented by one.
   *
   * @param node  The `TreeItem` for which the level is needed.
   * @return An integer representing the number of parents above the given node, or -1 if the given `TreeItem` is `null`.
   */
  def treeItemLevel(node: TreeItem[?]): Int = delegate.getTreeItemLevel(node)

  /**
   * Instructs the TreeView to begin editing the given TreeItem, if the
   * TreeView is `editable`.
   */
  def edit(item: TreeItem[T]): Unit = {
    delegate.edit(item)
  }

  /**
   * Returns the index position of the given TreeItem, taking into account the
   * current state of each TreeItem (i.e. whether or not it is expanded).
   */
  def row(item: TreeItem[T]): Int = delegate.getRow(item)

}
