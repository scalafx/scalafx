/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
package scalafx.collections

import javafx.collections as jfxc
import scalafx.beans.Observable
import scalafx.delegate.SFXDelegate
import scalafx.event.subscriptions.Subscription

import java.util as ju
import scala.collection.{IterableFactory, mutable}
import scala.language.implicitConversions

/**
 * Companion Object for `[[scalafx.collections.ObservableSet]]`.
 *
 * @define OS `ObservableSet`
 */
object ObservableSet extends IterableFactory[ObservableSet] {

  /**
   * Extracts a JavaFX's $OS from a ScalaFX's $OS.
   *
   * @param os ScalaFX's $OS.
   * @return JavaFX's $OS inside parameter.
   */
  implicit def sfxObservableSet2sfxObservableSet[T](os: ObservableSet[T]): jfxc.ObservableSet[T] =
    if (os != null) os.delegate else null

  override def from[T](source: IterableOnce[T]): ObservableSet[T] = (newBuilder[T] ++= source).result()

  override def empty[T]: ObservableSet[T] = new ObservableHashSet[T]()

  override def newBuilder[T]: mutable.Builder[T, ObservableSet[T]] = new mutable.GrowableBuilder(empty[T])

  // CHANGING INDICATORS - BEGIN

  /**
   * Indicates a change in a $OS. It is a simpler version of JavaFX's
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/SetChangeListener.Change.html `SetChangeListener.Change`]],
   * where each subclass indicates a specific change operation.
   */
  trait Change[T]

  /**
   * Indicates a addition in a $OS.
   *
   * @param added Added element.
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/SetChangeListener.Change.html#getElementAdded() `SetChangeListener.Change.getElementAdded()`]]
   */
  case class Add[T](added: T) extends Change[T]

  /**
   * Indicates a removal in an $OS.
   *
   * @param removed Removed element.
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/SetChangeListener.Change.html#getElementRemoved() `SetChangeListener.Change.getElementRemoved()`]]
   */
  case class Remove[T](removed: T) extends Change[T]

  // CHANGING INDICATORS - END

  // CREATION METHODS - BEGIN

  //  /**
  //   * Creates a empty $OS
  //   *
  //   * @return a Empty [[scalafx.collections.ObservableHashSet]]
  //   */
  //  override def empty[T]: ObservableSet[T] = new ObservableHashSet[T]

  // CREATION METHODS - END

}

/**
 * Wrapper class to JavaFX's [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableSet.html $OS]] .
 *
 * @tparam T Type of this $SET
 * @define OS  `ObservableSet`
 * @define SET `Set`
 */
trait ObservableSet[T]
    extends mutable.AbstractSet[T]
    //    with SetOps[T, ObservableSet, ObservableSet[T]]
    //    with StrictOptimizedIterableOps[T, ObservableSet, ObservableSet[T]]
    //    with IterableFactoryDefaults[T, ObservableSet]
    with Observable
    with SFXDelegate[jfxc.ObservableSet[T]] {

  override val iterableFactory: IterableFactory[ObservableSet] = ObservableSet

  /**
   * The result when this set is used as a builder
   */
  override def result(): ObservableSet[T] = this

  /**
   * Generates a empty $OS.
   *
   * @return A empty [[scalafx.collections.ObservableHashSet]]
   */
  override def empty: ObservableSet[T] = new ObservableHashSet[T]

  /**
   * Adds a single element to the set.
   *
   * @param elem the element to be added.
   * @return The $SET itself
   */
  def addOne(elem: T): ObservableSet.this.type = {
    delegate.add(elem)
    this
  }

  /**
   * Removes a single element from this mutable set.
   *
   * @param elem the element to be removed.
   * @return The $SET itself
   */
  def subtractOne(elem: T): ObservableSet.this.type = {
    delegate.remove(elem)
    this
  }

  /**
   * Removes all elements from the $SET. After this operation has completed, the $SET will be empty.
   */
  override def clear(): Unit = {
    delegate.clear()
  }

  /**
   * Creates a new iterator over elements of this set
   */
  def iterator: Iterator[T] = new Iterator[T] {
    val it: ju.Iterator[T] = delegate.iterator

    def hasNext: Boolean = it.hasNext

    def next(): T = it.next()
  }

  /**
   * @return This $SET's size.
   */
  override def size: Int = delegate.size

  /**
   * Tests if some element is contained in this $SET.
   *
   * @param elem the element to test for membership.
   * @return `true` if `elem` is contained in this $SET, `false` otherwise.
   */
  def contains(elem: T): Boolean = delegate.contains(elem)

  import scalafx.collections.ObservableSet.*

  /**
   * Add a listener function to $SET's changes. This function '''will handle''' this map's modifications data.
   *
   * @param op Function that will handle this $OS's modifications data to be activated when some change was made.
   */
  def onChange[J >: T](op: (ObservableSet[T], Change[J]) => Unit): Subscription = {
    val listener = new jfxc.SetChangeListener[T] {
      def onChanged(change: jfxc.SetChangeListener.Change[_ <: T]): Unit = {
        val changeEvent: Change[J] = (change.wasAdded, change.wasRemoved) match {
          case (true, false) => ObservableSet.Add(change.getElementAdded)
          case (false, true) => ObservableSet.Remove(change.getElementRemoved)
          case _ => throw new IllegalStateException("Irregular Change. Added: " +
              change.getElementAdded + ", Removed: " + change.getElementRemoved)
        }

        op(ObservableSet.this, changeEvent)
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel(): Unit = {
        delegate.removeListener(listener)
      }
    }
  }

  /**
   * Add a listener function to $SET's changes. This function '''will not handle''' this $SET's modifications data.
   *
   * @param op No-argument function to be activated when some change in this $OS was made.
   */
  def onChange(op: => Unit): Subscription = {
    val listener = new jfxc.SetChangeListener[T] {
      def onChanged(change: jfxc.SetChangeListener.Change[_ <: T]): Unit = {
        op
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel(): Unit = {
        delegate.removeListener(listener)
      }
    }
  }

}

/**
 * [[scalafx.collections.ObservableSet]] implementation backed for a
 * [[http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html `HashSet`]] from Java Collection.
 *
 * @param delegate JavaFX
 *                 [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableSet.html ObservableSet]]
 *                 instance to be wrapped by this class. By default it is a
 *                 [[http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html HashSet]] wrapped by
 *                 [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/FXCollections.html#observableSet(java.util.Set) observableSet]]
 *                 method from
 *                 [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/FXCollections.html FXCollections]].
 */
class ObservableHashSet[T](override val delegate: jfxc.ObservableSet[T] =
  jfxc.FXCollections.observableSet(new ju.HashSet[T]))
    extends ObservableSet[T] {}
