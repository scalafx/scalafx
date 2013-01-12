/*
 * Copyright (c) 2011, ScalaFX Project
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

import scala.collection.GenTraversableOnce
import scala.collection.JavaConversions._
import scala.collection.TraversableOnce
import scala.collection.generic.CanBuildFrom
import scala.collection.generic.GenericCompanion
import scala.collection.generic.GenericTraversableTemplate
import scala.collection.generic.SeqFactory
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Buffer
import scala.collection.mutable.BufferLike
import scala.collection.mutable.Builder

import java.{ util => ju }
import javafx.{ collections => jfxc }
import scalafx.beans.Observable
import scalafx.event.subscriptions.Subscription
import scalafx.delegate.SFXDelegate

/**
 * Companion Object for [[ObservableBuffer]].
 */
object ObservableBuffer extends SeqFactory[ObservableBuffer] {

  implicit def observableBuffer2ObservableList[T](ob: ObservableBuffer[T]) = ob.delegate

  /**
   * The standard `CanBuildFrom` instance for `ObservableBuffer` objects.
   */
  implicit def canBuildFrom[T]: CanBuildFrom[Coll, T, ObservableBuffer[T]] = new GenericCanBuildFrom[T] {
    override def apply() = newBuilder[T]
  }

  /**
   * The default builder for `ObservableBuffer` objects.
   */
  def newBuilder[T]: Builder[T, ObservableBuffer[T]] = new ObservableBuffer

  // CHANGING INDICATORS - BEGIN

  /**
   * Trait that indicates a Change in a ObsevableBuffer
   */
  trait Change

  /**
   * Indicates a Addition in a ObsevableBuffer
   *
   * @param position Position from where new elements were added
   * @param added elements added
   */
  case class Add[T](position: Int, added: Traversable[T]) extends Change

  /**
   * Indicates a Removing in a ObsevableBuffer
   *
   * @param position Position from where elements were removed
   * @param added elements removed
   */
  case class Remove[T](position: Int, removed: Traversable[T]) extends Change

  /**
   * Indicates a Removing in a ObsevableBuffer
   *
   * @param position Position from where elements were removed
   * @param added elements removed
   */
  case class Reorder(start: Int, end: Int, permutation: (Int => Int)) extends Change

  // CHANGING INDICATORS - END

  // CREATION METHODS - BEGIN

  /**
   * Creates a new Observable Buffer from a sequence of elements.
   *
   * @param itens Sequence of elements
   * @returns new Observable Buffer from items
   */
  def apply[T](items: Seq[T]): ObservableBuffer[T] =
    new ObservableBuffer[T](jfxc.FXCollections.observableArrayList[T](items))

  // CREATION METHODS - END

  // HELPER METHODS (ORIGINATED FROM FXCOLLECTIONS) - BEGIN

  /**
   * Shuffles all elements in the observable list. Fires only '''one''' change notification on
   * the list.
   *
   * @param buffer Buffer to be shuffled
   */
  def shuffle[T](buffer: ObservableBuffer[T]) {
    jfxc.FXCollections.shuffle(buffer)
  }

  /**
   * Shuffles all elements in the observable list. Fires only '''one''' change notification on
   * the list.
   *
   * @param buffer Buffer to be shuffled
   * @param rnd the random generator used for shuffling
   */
  def shuffle[T](buffer: ObservableBuffer[T], rnd: ju.Random) {
    jfxc.FXCollections.shuffle(buffer, rnd)
  }

  /**
   * Concatenates more observable buffers into one.
   *
   * @param buffers Buffers to concatenate
   */
  def concat[T](buffers: ObservableBuffer[T]*): ObservableBuffer[T] = {
    val lists: java.util.List[jfxc.ObservableList[T]] = new java.util.ArrayList[jfxc.ObservableList[T]]
    buffers.foreach(buf => lists.add(buf.delegate))

    ObservableBuffer[T](jfxc.FXCollections.concat(lists: _*))
  }

  /**
   * Revert the order in the list Fires only '''one''' change notification on the list.
   *
   * ''Implementation note'': This method uses `reverse` method from
   * [[javafx.collections.FXCollections]]. It is not called `reverse` to not confuse with
   * method with same name from [[scala.collection.mutable.Buffer]]
   *
   * @param buffer to be reverted.
   */
  def revertBuffer[T](buffer: ObservableBuffer[T]) = jfxc.FXCollections.reverse(buffer.delegate)

  /**
   * Fills the provided list with obj. Fires only one change notification on the list.
   *
   * @param buffer buffer to Fill
   * @param obj the object to fill the list with
   */
  def fillAll[T](buffer: ObservableBuffer[T], obj: T) = jfxc.FXCollections.fill(buffer, obj)

  /**
   * Rotates the buffer by distance. Fires only one change notification on the buffer.
   * 
   * @param buffer the list to be rotated
   * @param distance the distance of rotation
   */
  def rotate[T](buffer: ObservableBuffer[T], distance: Int) = jfxc.FXCollections.rotate(buffer, distance)
  
  // HELPER METHODS - END

}

/**
 * Wrapper class to [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableList.html ObservableList]]'s
 * JavaFX.
 *
 * @tparam T Type of this Buffer
 *
 * @define OB ObservableBuffer
 * @define ownOB The ObservableBuffer itself.
 * @define buf Buffer
 * @define WhyOverride Overrided method to make it behave like wrapped ObservableList.
 * @define noCL The new $OB won't have Change and Invalidation Listeners from original $buf.
 *
 */
class ObservableBuffer[T](override val delegate: jfxc.ObservableList[T] = jfxc.FXCollections.observableArrayList[T])
  extends Buffer[T]
  with BufferLike[T, ObservableBuffer[T]]
  with GenericTraversableTemplate[T, ObservableBuffer]
  with Builder[T, ObservableBuffer[T]]
  with Observable
  with SFXDelegate[jfxc.ObservableList[T]] {

  /**
   * The factory companion object that builds instances of class $OB.
   */
  override def companion: GenericCompanion[ObservableBuffer] = ObservableBuffer

  /**
   * Produces a $OB from the added elements.
   */
  def result = this

  /**
   * Creates a new $OB containing both the elements of this $buf and the
   * provided traversable object. $WhyOverride $noCL
   *
   * @param xs The traversable object.
   * @return A new $OB consisting of all the elements of this $buf and `xs`. $noCL
   */
  override def ++(xs: GenTraversableOnce[T]) = {
    val ob = new ObservableBuffer[T]
    ob.appendAll(this)
    ob.appendAll(xs.toList)
    ob
  }

  /**
   * Appends a single element to this $OB. $WhyOverride
   *
   * @param elem the element to add.
   * @return $ownOB
   */
  def +=(elem: T) = {
    delegate.add(elem)
    this
  }

  /**
   * Appends two or more elements to this $OB. $WhyOverride
   *
   * @param elem1 First element to add
   * @param elem2 Second element to add
   * @param elems Other elements to add
   * @return $ownOB
   */
  override def +=(elem1: T, elem2: T, elems: T*) =
    this ++= (Buffer(elem1, elem2) ++= elems).toTraversable

  /**
   * Adds all elements produced by a TraversableOnce to this $OB. $WhyOverride
   *
   * @param the traversable object.
   * @return $ownOB
   */
  override def ++=(xs: TraversableOnce[T]) = {
    delegate.addAll(xs.toIterable)
    this
  }

  /**
   * Prepends a single element to this buffer. $WhyOverride
   *
   * @param elem Element to prepend
   * @return $ownOB
   */
  def +=:(elem: T) = {
    delegate.insert(0, elem)
    this
  }

  /**
   * Creates a new $OB with all the elements of this collection except `elem`. $noCL
   *
   * @param elem Element to remove
   * @return A new $OB consisting of all the elements of this $buf except `elem`. $noCL
   */
  override def -(elem: T) = {
    val ob = new ObservableBuffer[T]
    this.filterNot(_ != elem).foreach(ob += _)
    ob
  }

  /**
   * Creates a new collection with all the elements of this collection except the two
   * or more specified elements. $noCL
   *
   * @param elem1 First element to remove
   * @param elem2 Second element to remove
   * @param elems Other elements to remove
   * @return a new $OB consisting of all the elements of this $buf except `elem1`, `elem2` and
   *         those in `elems`. $noCL
   */
  override def -(elem1: T, elem2: T, elems: T*) = {
    val xs = Buffer(elem1, elem2) ++= elems
    val ob = new ObservableBuffer[T]
    this.filterNot(xs.contains(_)).foreach(ob += _)
    ob
  }

  /**
   * Creates a new $OB with all the elements of this $buf except those provided by
   * the specified traversable object. $noCL
   *
   * @param xs The traversable object.
   * @return A new $OB with all the elements of this $buf except those in `xs`. $noCL
   */
  override def --(xs: GenTraversableOnce[T]) = {
    val ob = new ObservableBuffer[T]
    val list = xs.toList
    this.filterNot(list.contains(_)).foreach(ob += _)
    ob
  }

  /**
   * Removes two or more elements from this $OB.
   *
   * @param elem1 First element to remove
   * @param elem2 Second element to remove
   * @param elems Other elements to remove
   * @return $ownOB
   */
  override def -=(elem1: T, elem2: T, elems: T*) = {
    delegate.removeAll(Buffer(elem1, elem2) ++= elems)
    this
  }

  /**
   * Removes all elements produced by an iterator from this buffer.
   *
   * @param the traversable object with elements to remove.
   * @return $ownOB
   */
  override def --=(xs: TraversableOnce[T]) = {
    delegate.removeAll(xs.toIterable)
    this
  }

  /**
   * Selects an element by its index in the buffer.
   *
   * @param n index
   * @return Element at position `n`
   */
  def apply(n: Int) = delegate.get(n)

  /**
   * Clears the $OB's contents. After this operation, the $buf is empty.
   */
  def clear = delegate.clear

  /**
   * Inserts new elements at a given index into this $buf.
   *
   * @param n the index where new elements are inserted.
   * @param iter  the traversable collection containing the elements to insert.
   */
  def insertAll(n: Int, elems: Traversable[T]) {
    delegate.addAll(n, elems.toIterable)
  }

  /**
   * Creates a new [[scala.Iterator]].
   */
  def iterator = new Iterator[T] {
    val it = delegate.iterator

    def hasNext = it.hasNext

    def next = it.next
  }

  /**
   *
   */
  def length = delegate.size

  /**
   * Removes the element at a given index from this $OB.
   *
   * @param n index the index of the element to be removed
   * @param Removed element
   */
  def remove(n: Int) = delegate.remove(n)

  /**
   * Removes a number of elements from a given index position. $WhyOverride
   * Note: This method conflicts with method with same name in
   * [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableList.html#remove(int, int) ObservableList]].
   * There the arguments indicate a range of index of elements to be removed. Here the arguments indicate the first
   * index of range and the quantity of elements to be removed. If you want a functionality equivalent to JavaFX
   * ObservableList, use `removeRange`.
   *
   * @param n  the index which refers to the first element to remove.
   * @param count  the number of elements to remove.
   */
  override def remove(n: Int, count: Int) {
    delegate.subList(n, n + count).clear()
  }

  /**
   * Remove a range of elements. Use this method if you want a functionality such as
   * [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableList.html#remove(int, int) the method with
   * same name in ObservableList]].
   *
   * @param from the start of the range to remove (inclusive)
   * @param to  the end of the range to remove (exclusive)
   */
  def removeRange(from: Int, to: Int) {
    delegate.remove(from, to)
  }

  /**
   * Replaces element at given index with a new value.
   *
   * @param n the index of the element to replace.
   * @param newelem new value to be positioned at position n.
   */
  def update(n: Int, newelem: T) {
    delegate.set(n, newelem)
  }

  /**
   * Retains only the elements in this list that are contained in the specified collection.
   * In other words, removes from this list all the elements that are not contained in the
   * specified collection.
   *
   * @param elems the traversable collection containing elements to be retained in this list
   */
  def retainAll(elems: T*) {
    delegate.retainAll(elems)
  }

  /**
   * Retains only the elements in this list that are contained in the specified collection.
   * In other words, removes from this list all the elements that are not contained in the
   * specified collection.
   *
   * @param elems the traversable collection containing elements to be retained in this list
   */
  def retainAll(elems: Iterable[T]) {
    delegate.retainAll(elems)
  }

  /**
   * Replace all oldVal elements in the list with newVal element. Fires only '''one''' change
   * notification on the list.
   */
  def replaceAll(oldVal: T, newVal: T) = jfxc.FXCollections.replaceAll(this.delegate, oldVal, newVal)

  /**
   * Sorts this $OB if its type's ''natural ordering''. This type must be a
   * [[java.util.Comparable]] subclass. Otherwise it will throws a [[scala.IllegalStateException]].
   */
  def sort()(implicit m: ClassManifest[T]) {
    if (m.erasure.getInterfaces.contains(classOf[Comparable[_]])) {
      jfxc.FXCollections.sort(delegate, new ju.Comparator[T] {
        def compare(p1: T, p2: T) = p1.asInstanceOf[Comparable[T]].compareTo(p2)
      })
    } else {
      throw new IllegalStateException("Type of this Observable List does not implements " +
        "java.util.Comparable. Please uses a Comparator function.")
    }
  }

  /**
   * Sorts this $OB using a Comparator function
   *
   * @param lt Comparator function that returns `true` if first element was lesser than second
   *           or `false` otherwise.
   */
  def sort(lt: (T, T) => Boolean) {
    jfxc.FXCollections.sort(delegate, new ju.Comparator[T] {
      def compare(p1: T, p2: T) = if (lt(p1, p2)) -1 else if (lt(p2, p1)) 1 else 0
    })
  }

  import ObservableBuffer._

  /**
   * Add a listener function to list's changes. This functin will handle this buffer's
   * modifications data.
   *
   * @param Function that will handle this $OB's modifications data to be activated when
   *                 some change was made.
   * @return A subscription object
   */
  def onChange[T1 >: T](op: (ObservableBuffer[T], Seq[Change]) => Unit): Subscription = {
    val listener = new jfxc.ListChangeListener[T1] {
      def onChanged(c: jfxc.ListChangeListener.Change[_ <: T1]) {
        var changes = ArrayBuffer.empty[Change]
        while (c.next()) {
          if (c.wasRemoved()) {
            changes += Remove(c.getFrom, c.getRemoved)
          }
          if (c.wasAdded()) {
            changes += Add(c.getFrom, c.getAddedSubList)
          }
          if (c.wasPermutated()) {
            changes += Reorder(c.getFrom, c.getTo, {
              x => c.getPermutation(x)
            })
          }
        }
        op(ObservableBuffer.this, changes)
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel() {
        delegate.removeListener(listener)
      }
    }
  }

  /**
   * Add a listener function to list's changes. This functin will not handle this buffer's
   * modifications data.
   *
   * @param op No-argument function to be activated when some change in this $OB was made.
   * @return A subscription object
   */
  def onChange[T1 >: T](op: => Unit): Subscription = {
    val listener = new jfxc.ListChangeListener[T1] {
      def onChanged(c: jfxc.ListChangeListener.Change[_ <: T1]) {
        op
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel() {
        delegate.removeListener(listener)
      }
    }
  }
}
