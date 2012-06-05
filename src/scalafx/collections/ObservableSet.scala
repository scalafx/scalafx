/*
 * Copyright (c) 2012, ScalaFX Project
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

import scala.collection.JavaConversions._
import scala.collection.generic.MutableSetFactory
import scala.collection.mutable.Builder
import scala.collection.mutable.Set
import scala.collection.mutable.SetLike

import javafx.{ collections => jfxc }
import java.{ util => ju }
import scalafx.beans.Observable
import scalafx.util.SFXDelegate

/**
 * Companion Object for [[ObservableSet]]. 
 */
object ObservableSet extends MutableSetFactory[ObservableSet] {
  implicit def sfxObservableSet2sfxObservableSet[T](os: ObservableSet[T]) = os.delegate

  /**
   * Indicates a change in a ObservableSet
   */
  trait Change[T]

  /**
   * Indicates a addition in a ObservableSet
   *
   * @param added Added element.
   */
  case class Add[T](added: T) extends Change[T]

  /**
   * Indicates a remotion in a ObservableSet
   *
   * @param removed Removed element.
   */
  case class Remove[T](removed: T) extends Change[T]

  /**
   * Creates a empty ObservableSet
   *
   * @return a Empty [[ObservableHashSet]]
   */
  override def empty[T]: ObservableSet[T] = new ObservableHashSet[T]

  /**
   * Creates a new ObservableSet from a [[scala.Seq Sequence]].
   *
   * @param elems Sequence source of Set
   * @param new [[ObservableHashSet]] generated from elems
   */
  def apply[T](elems: Seq[T]): ObservableSet[T] =
    new ObservableHashSet[T](jfxc.FXCollections.observableSet(elems: _*))

  /**
   * Creates a new ObservableSet from a [[scala.collection.mutable.Set Mutable Set]].
   *
   * @param set Mutable Set to be wrapped. 
   */
  def apply[T](set: Set[T]): ObservableSet[T] =
    new ObservableHashSet[T](jfxc.FXCollections.observableSet(mutableSetAsJavaSet(set)))

}

/**
 * Wrapper class to [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableSet.html ObservableSet]]'s
 * from JavaFX.
 *
 * @tparam T Type of this Set
 *
 */
trait ObservableSet[T]
  extends Set[T]
  with SetLike[T, ObservableSet[T]]
  with Builder[T, ObservableSet[T]]
  with Observable
  with SFXDelegate[jfxc.ObservableSet[T]] {

  import ObservableSet._

  /**
   * The result when this set is used as a builder
   */
  override def result = this

  /**
   * Generates a empty ObservableSet
   * 
   * @return A empty [[ObservableHashSet]]
   */
  override def empty = new ObservableHashSet[T]

  /**
   * Adds a single element to the set.
   * 
   * @param elem the element to be added.
   * @return The set itself
   */
  def +=(elem: T) = {
    delegate.add(elem)
    this
  }

  /**
   * Removes a single element from this mutable set.
   * 
   * @param elem the element to be removed.
   * @return The set itself
   */
  def -=(elem: T) = {
    delegate.remove(elem)
    this
  }

  /**
   * Tests if some element is contained in this set.
   * 
   * @param elem the element to test for membership.
   * @return `true` if `elem` is contained in this set, `false` otherwise.
   */
  def contains(elem: T) = delegate.contains(elem)

  /**
   * @return `Iterator` of this ObservableSet
   */
  def iterator = new Iterator[T] {
    val it = delegate.iterator
    def hasNext = it.hasNext
    def next = it.next
  }

  /**
   * @return This set's size. 
   */
  override def size = delegate.size

  /**
   * Removes all elements from the set. After this operation has completed, the set will be empty.
   */
  override def clear = delegate.clear

  /**
   * Add a listener function to set's changes. This function will handle this
   * [[ObservableSet.Change set's modification data]].
   *
   * @param Function that will handle this set's modification data to be activated when
   * some change was made.
   */
  def onChange(op: (ObservableSet[T], Change[T]) => Unit) {
    delegate.addListener(new jfxc.SetChangeListener[T] {
      def onChanged(change: jfxc.SetChangeListener.Change[_ <: T]) {
        val changeEvent = (change.wasAdded, change.wasRemoved) match {
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
   * Add a listener function to set's changes. This function will not handle this set's
   * modification data.
   *
   * @param op No-argument function to be activated when some change in this set was made.
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
 * [[ObservableSet]] implementation backed for a
 * [[http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html HashSet]] from Java Collection.
 *
 * @param delegate JavaFX
 * [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableSet.html ObservableSet]]
 * instance to be wrapped by this class. By default it is a
 * [[http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html HashSet]] wrapped by
 * [[http://docs.oracle.com/javafx/2/api/javafx/collections/FXCollections.html#observableSet(java.util.Set) observableSet]]
 * method from
 * [[http://docs.oracle.com/javafx/2/api/javafx/collections/FXCollections.html FXCollections]].
 */
class ObservableHashSet[T](override val delegate: jfxc.ObservableSet[T] = jfxc.FXCollections.observableSet(new ju.HashSet[T]))
  extends ObservableSet[T] 
