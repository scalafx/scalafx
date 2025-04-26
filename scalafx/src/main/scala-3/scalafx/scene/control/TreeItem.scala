/*
 * Copyright (c) 2011-2023, ScalaFX Project
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
import javafx.{event as jfxe, scene as jfxs}
import scalafx.Includes.*
import scalafx.beans.property.{BooleanProperty, ObjectProperty, ReadOnlyBooleanProperty, ReadOnlyObjectProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventTarget, EventType}
import scalafx.scene.Node

import scala.jdk.CollectionConverters.*
import scala.collection.mutable
import scala.language.implicitConversions

object TreeItem {
  implicit def sfxTreeItemToJfx[T](v: TreeItem[T]): jfxsc.TreeItem[T] = if (v != null) v.delegate else null

  object TreeModificationEvent {
    implicit def sfxTreeModificationEvent2jfx[T](v: TreeModificationEvent[T]): jfxsc.TreeItem.TreeModificationEvent[T] =
      if (v != null) v.delegate else null
  }

  class TreeModificationEvent[T](override val delegate: jfxsc.TreeItem.TreeModificationEvent[T])
      extends Event(delegate)
      with SFXDelegate[jfxsc.TreeItem.TreeModificationEvent[T]] {

    /**
     * Constructs a basic TreeModificationEvent - this is useful in situations
     * where the tree item has not received a new value, has not changed
     * between expanded/collapsed states, and whose children has not changed.
     */
    def this(eventType: EventType[_ <: jfxe.Event], treeItem: TreeItem[T]) =
      this(new jfxsc.TreeItem.TreeModificationEvent[T](eventType, treeItem))

    /**
     * Constructs a TreeModificationEvent for when the TreeItem has had its
     * `TreeItem.expandedProperty()` changed.
     */
    def this(eventType: EventType[_ <: jfxe.Event], treeItem: TreeItem[T], expanded: Boolean) =
      this(new jfxsc.TreeItem.TreeModificationEvent[T](eventType, treeItem, expanded))

    /**
     * Constructs a TreeModificationEvent for when the TreeItem has had its
     * children list changed.
     */
    def this(
      eventType: jfxe.EventType[_ <: jfxe.Event],
      treeItem: jfxsc.TreeItem[T],
      added: mutable.Buffer[_ <: jfxsc.TreeItem[T]],
      removed: mutable.Buffer[_ <: jfxsc.TreeItem[T]]
    ) =
      this(new jfxsc.TreeItem.TreeModificationEvent[T](eventType, treeItem, added.asJava, removed.asJava))

    /**
     * Constructs a TreeModificationEvent for when the TreeItem has had its
     * `TreeItem.valueProperty()` changed.
     */
    def this(eventType: EventType[_ <: jfxe.Event], treeItem: TreeItem[T], newValue: T) =
      this(new jfxsc.TreeItem.TreeModificationEvent[T](eventType, treeItem, newValue))

    /**
     * Returns the children added to the TreeItem in this event, or an empty
     * list if no children were added.
     */
    def addedChildren: mutable.Buffer[_ <: jfxsc.TreeItem[T]] = delegate.getAddedChildren.asScala

    /**
     * Returns the number of children items that were added in this event, or
     * zero if no children were added.
     */
    def addedSize: Int = delegate.getAddedSize

    /**
     * If the value of the TreeItem changed, this method will return the new
     * value.
     */
    def newValue: T = delegate.getNewValue

    /**
     * Returns the children removed from the TreeItem in this event, or an
     * empty list if no children were added.
     */
    def removedChildren: mutable.Buffer[_ <: jfxsc.TreeItem[T]] = delegate.getRemovedChildren.asScala

    /**
     * Returns the number of children items that were removed in this event,
     * or zero if no children were removed.
     */
    def removedSize: Int = delegate.getRemovedSize

    /**
     * Returns the TreeItem upon which this event occurred.
     */
    override def source: TreeItem[_] = delegate.getSource

    /**
     * Returns the TreeItem that this event occurred upon.
     */
    def treeItem: TreeItem[T] = delegate.getTreeItem

    /**
     * Returns true if this event represents a TreeItem event where children
     * TreeItems were added.
     */
    def wasAdded: Boolean = delegate.wasAdded

    /**
     * Returns true if this event represents a TreeItem collapse event, and
     * false if the TreeItem was not collapsed.
     */
    def wasCollapsed: Boolean = delegate.wasCollapsed

    /**
     * Returns true if this event represents a TreeItem expansion event, and
     * false if the TreeItem was not expanded.
     */
    def wasExpanded: Boolean = delegate.wasExpanded

    /**
     * Returns true if this event represents a TreeItem event where children
     * TreeItems were removed.
     */
    def wasRemoved: Boolean = delegate.wasRemoved

  }

  /**
   * An EventType used when the TreeItem receives a modification to its
   * expanded property, such that the TreeItem is now in the collapsed state.
   */
  def branchCollapsedEvent[T]: EventType[jfxsc.TreeItem.TreeModificationEvent[Nothing]] =
    new EventType(jfxsc.TreeItem.branchCollapsedEvent)

  /**
   * An EventType used when the TreeItem receives a modification to its
   * expanded property, such that the TreeItem is now in the expanded state.
   */
  def branchExpandedEvent[T]: EventType[jfxsc.TreeItem.TreeModificationEvent[Nothing]] =
    new EventType(jfxsc.TreeItem.branchExpandedEvent)

  /**
   * An EventType used when the TreeItem receives a direct modification to its
   * children list.
   */
  def childrenModificationEvent[T]: EventType[jfxsc.TreeItem.TreeModificationEvent[Nothing]] =
    new EventType(jfxsc.TreeItem.childrenModificationEvent)

  /**
   * The general EventType used when the TreeItem receives a modification
   * that results in the number of children being visible changes.
   *
   * @since 8.0
   */
  def expandedItemCountChangeEvent[T]: EventType[jfxsc.TreeItem.TreeModificationEvent[Nothing]] =
    new EventType(jfxsc.TreeItem.expandedItemCountChangeEvent)

  /**
   * An EventType used when the TreeItem receives a modification to its
   * graphic property.
   */
  def graphicChangedEvent[T]: EventType[jfxsc.TreeItem.TreeModificationEvent[Nothing]] =
    new EventType(jfxsc.TreeItem.graphicChangedEvent)

  /**
   * The general EventType used when the TreeItem receives a modification that
   * results in the number of children being visible changes.
   */
  // NOTE JFX8: Comment method that disappeared in JavaFX 8. Did it moved somewhere?
  //  def treeItemCountChangeEvent = jfxsc.TreeItem.treeItemCountChangeEvent

  /**
   * The base EventType used to indicate that an event has occurred within a
   * TreeItem.
   */
  def treeNotificationEvent[T]: EventType[jfxsc.TreeItem.TreeModificationEvent[Nothing]] =
    new EventType(jfxsc.TreeItem.treeNotificationEvent)

  /**
   * An EventType used when the TreeItem receives a modification to its value
   * property.
   */
  def valueChangedEvent[T]: EventType[jfxsc.TreeItem.TreeModificationEvent[Nothing]] =
    new EventType(jfxsc.TreeItem.valueChangedEvent)

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeItem.html javafx.scene.control.TreeItem]] class.
 */
class TreeItem[T](override val delegate: jfxsc.TreeItem[T] = new jfxsc.TreeItem[T])
    extends EventTarget(delegate)
    with SFXDelegate[jfxsc.TreeItem[T]] {

  /**
   * Creates a TreeItem with the value property set to the provided object.
   */
  def this(value: T) = this(new jfxsc.TreeItem[T](value))

  /**
   * Creates a TreeItem with the value property set to the provided object,
   * and the graphic set to the provided Node.
   */
  def this(value: T, graphic: Node) = this(new jfxsc.TreeItem[T](value, graphic))

  /**
   * The expanded state of this TreeItem.
   */
  def expanded: BooleanProperty = delegate.expandedProperty

  def expanded_=(v: Boolean): Unit = {
    expanded() = v
  }

  /**
   * The node that is generally shown to the left of the value property.
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty

  def graphic_=(v: Node): Unit = {
    graphic() = v
  }

  /**
   * Represents the TreeItem leaf property, which is true if the TreeItem has no children.
   */
  def leaf: ReadOnlyBooleanProperty = delegate.leafProperty

  /**
   * A property that represents the parent of this TreeItem.
   */
  def parent: ReadOnlyObjectProperty[jfxsc.TreeItem[T]] = delegate.parentProperty

  /**
   * A property representing the application-specific data contained within
   * this TreeItem.
   */
  def value: ObjectProperty[T] = delegate.valueProperty

  def value_=(v: T): Unit = {
    value.set(v)
  }

  /**
   * The children of this TreeItem.
   */
  def children: ObservableBuffer[jfxsc.TreeItem[T]] = delegate.getChildren

  def children_=(items: Seq[TreeItem[T]]): Unit = {
    children.clear()
    items.foreach(children += _)
  }

  /**
   * Returns the next sibling of the TreeItem.
   */
  def nextSibling: TreeItem[T] = delegate.nextSibling

  /**
   * Returns the next sibling after the given node.
   */
  def nextSibling(afterNode: TreeItem[T]): TreeItem[T] = delegate.nextSibling(afterNode)

  /**
   * Returns the previous sibling of the TreeItem.
   */
  def previousSibling: TreeItem[T] = delegate.previousSibling

  /**
   * Returns the previous sibling previous the given node.
   */
  def previousSibling(afterNode: TreeItem[T]): TreeItem[T] = delegate.previousSibling(afterNode)
}
