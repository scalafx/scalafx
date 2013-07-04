/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import java.{ util => ju }
import scala.collection.JavaConversions._
import scala.collection.generic.GenericSetTemplate
import scala.collection.generic.MutableSetFactory
import scala.collection.mutable.Builder
import scala.collection.mutable.Set
import scala.collection.mutable.SetLike
import javafx.{ collections => jfxc }
import scalafx.beans.Observable
import scalafx.delegate.SFXDelegate
import scala.collection.generic.GenericCompanion

/**
 * Companion Object for `[[scalafx.collections.ObservableSet]]`.
 *
 * @define OS `ObservableSet`
 */
object ObservableSet extends MutableSetFactory[ObservableSet] {

  /**
   * Extracts a JavaFX's $OS from a ScalaFX's $OS.
   *
   * @param os ScalaFX's $OS.
   * @return JavaFX's $OS inside parameter.
   */
  implicit def sfxObservableSet2sfxObservableSet[T](os: ObservableSet[T]) = os.delegate

  // CHANGING INDICATORS - BEGIN

  /**
   * Indicates a change in a $OS. It is a simpler version of JavaFX's
   * [[http://docs.oracle.com/javafx/2/api/javafx/collections/SetChangeListener.Change.html `SetChangeListener.Change`]],
   * where each subclass indicates a specific change operation.
   */
  trait Change[T]

  /**
   * Indicates a addition in a $OS.
   *
   * @param added Added element.
   * @see [[http://docs.oracle.com/javafx/2/api/javafx/collections/SetChangeListener.Change.html#getElementAdded() `SetChangeListener.Change.getElementAdded()`]]
   */
  case class Add[T](added: T) extends Change[T]

  /**
   * Indicates a removal in an $OS.
   *
   * @param removed Removed element.
   * @see [[http://docs.oracle.com/javafx/2/api/javafx/collections/SetChangeListener.Change.html#getElementRemoved() `SetChangeListener.Change.getElementRemoved()`]]
   */
  case class Remove[T](removed: T) extends Change[T]

  // CHANGING INDICATORS - END

  // CREATION METHODS - BEGIN

  /**
   * Creates a empty $OS
   *
   * @return a Empty [[scalafx.collections.ObservableHashSet]]
   */
  override def empty[T]: ObservableSet[T] = new ObservableHashSet[T]

  /**
   * Creates a new $OS from a sequence.
   *
   * @param elems Sequence source of Set
   * @return new [[scalafx.collections.ObservableHashSet]] generated from elems
   */
  def apply[T](elems: Seq[T]): ObservableSet[T] =
    new ObservableHashSet[T](jfxc.FXCollections.observableSet(elems: _*))

  /**
   * Creates a new $OS from a mutable [[scala.collection.mutable.Set]].
   *
   * @param set Mutable Set to be wrapped.
   * @return new [[scalafx.collections.ObservableHashSet]] wrapping ''set''
   */
  def apply[T](set: Set[T]): ObservableSet[T] =
    new ObservableSet[T] {
      override val delegate = jfxc.FXCollections.observableSet(mutableSetAsJavaSet(set))
    }

  // CREATION METHODS - END

}

/**
 * Wrapper class to JavaFX's [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableSet.html $OS]] .
 *
 * @tparam T Type of this $SET
 *
 * @define OS `ObservableSet`
 * @define SET `Set`
 */
trait ObservableSet[T]
  extends Set[T]
  with SetLike[T, ObservableSet[T]]
  with GenericSetTemplate[T, ObservableSet]
  with Builder[T, ObservableSet[T]]
  with Observable
  with SFXDelegate[jfxc.ObservableSet[T]] {

  /**
   * The factory companion object that builds instances of class $OS.
   */
  override def companion: GenericCompanion[ObservableSet] = ObservableSet

  /**
   * The result when this set is used as a builder
   */
  override def result() = this

  /**
   * Generates a empty $OS.
   *
   * @return A empty [[scalafx.collections.ObservableHashSet]]
   */
  override def empty = new ObservableHashSet[T]

  /**
   * Adds a single element to the set.
   *
   * @param elem the element to be added.
   * @return The $SET itself
   */
  def +=(elem: T) = {
    delegate.add(elem)
    this
  }

  /**
   * Removes a single element from this mutable set.
   *
   * @param elem the element to be removed.
   * @return The $SET itself
   */
  def -=(elem: T) = {
    delegate.remove(elem)
    this
  }

  /**
   * Removes all elements from the $SET. After this operation has completed, the $SET will be empty.
   */
  override def clear() {
    delegate.clear()
  }

  /**
   * Creates a new iterator over elements of this set
   */
  def iterator = new Iterator[T] {
    val it = delegate.iterator
    def hasNext = it.hasNext
    def next() = it.next()
  }

  /**
   * @return This $SET's size.
   */
  override def size = delegate.size

  /**
   * Tests if some element is contained in this $SET.
   *
   * @param elem the element to test for membership.
   * @return `true` if `elem` is contained in this $SET, `false` otherwise.
   */
  def contains(elem: T) = delegate.contains(elem)

  import ObservableSet._

  /**
   * Add a listener function to $SET's changes. This function '''will handle''' this map's modifications data.
   *
   * @param op Function that will handle this $OS's modifications data to be activated when some change was made.
   */
  def onChange[J >: T](op: (ObservableSet[T], Change[J]) => Unit) {
    delegate.addListener(new jfxc.SetChangeListener[T] {
      def onChanged(change: jfxc.SetChangeListener.Change[_ <: T]) {
        val changeEvent: Change[J] = (change.wasAdded, change.wasRemoved) match {
          case (true, false) => ObservableSet.Add(change.getElementAdded)
          case (false, true) => ObservableSet.Remove(change.getElementRemoved)
          case _ => throw new IllegalStateException("Irregular Change. Added: " +
            change.getElementAdded + ", Removed: " + change.getElementRemoved)
        }

        op(ObservableSet.this, changeEvent)
      }
    })
  }

  /**
   * Add a listener function to $SET's changes. This function '''will not handle''' this $SET's modifications data.
   *
   * @param op No-argument function to be activated when some change in this $OS was made.
   */
  def onChange(op: => Unit) {
    delegate.addListener(new jfxc.SetChangeListener[T] {
      def onChanged(change: jfxc.SetChangeListener.Change[_ <: T]) {
        op
      }
    })
  }

}

/**
 * [[scalafx.collections.ObservableSet]] implementation backed for a
 * [[http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html `HashSet`]] from Java Collection.
 *
 * @param delegate JavaFX
 *                 [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableSet.html ObservableSet]]
 *                 instance to be wrapped by this class. By default it is a
 *                 [[http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html HashSet]] wrapped by
 *                 [[http://docs.oracle.com/javafx/2/api/javafx/collections/FXCollections.html#observableSet(java.util.Set) observableSet]]
 *                 method from
 *                 [[http://docs.oracle.com/javafx/2/api/javafx/collections/FXCollections.html FXCollections]].
 */
class ObservableHashSet[T](override val delegate: jfxc.ObservableSet[T] = jfxc.FXCollections.observableSet(new ju.HashSet[T]))
  extends ObservableSet[T]
