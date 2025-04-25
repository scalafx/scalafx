/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.collections.ObservableList
import javafx.{collections => jfxc}
import scalafx.beans.Observable
import scalafx.delegate.SFXDelegate
import scalafx.event.subscriptions.Subscription

import java.{util => ju}
import scalafx.util.JavaConverters._
import scala.collection.generic.{CanBuildFrom, GenericCompanion, GenericTraversableTemplate, SeqFactory}
import scala.collection.mutable.ArrayBuffer
import scala.collection.{GenTraversableOnce, TraversableOnce, mutable}
import scala.language.implicitConversions
import scala.reflect.runtime.universe._

/**
 * Companion Object for [[scalafx.collections.ObservableBuffer]].
 *
 * @define OB `ObservableBuffer`
 * @define OL [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableList.html `ObservableList`]]
 * @define buf `Buffer`
 */
object ObservableBuffer extends SeqFactory[ObservableBuffer] {

  /**
   * Extracts an $OL from an $OB.
   *
   * @param ob ObservableBuffer
   */
  implicit def observableBuffer2ObservableList[T](ob: ObservableBuffer[T]): ObservableList[T] =
    if (ob != null) ob.delegate else null

  /**
   * The standard `CanBuildFrom` instance for $OB objects.
   */
  implicit def canBuildFrom[T]: CanBuildFrom[Coll, T, ObservableBuffer[T]] = new GenericCanBuildFrom[T] {
    override def apply(): mutable.Builder[T, ObservableBuffer[T]] = newBuilder[T]
  }

  /**
   * The default builder for $OB objects.
   */
  def newBuilder[T]: mutable.Builder[T, ObservableBuffer[T]] = new ObservableBuffer

  // CHANGING INDICATORS - BEGIN

  /**
   * Trait that indicates a Change in an $OB. It is a simpler version of JavaFX's
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html `ListChangeListener.Change`]],
   * where each subclass indicates a specific change operation.
   * Unlike JavaFX, all subclasses are exclusive to each other. This enables using pattern matching:
   * {{{
   * items.onChange((_, changes) => {
   *   for (change <- changes)
   *     change match {
   *       case Add(pos, added)                => ...
   *       case Remove(pos, removed)           => ...
   *       case Reorder(from, to, permutation) => ...
   *       case Update(pos, updated)           => ...
   *     }
   * })
   * }}}
   *
   * "replace" is represented as two changes `Remove` and `Add`.
   */
  sealed trait Change[T]

  /**
   * Indicates an Addition in an $OB.
   *
   * @param position Position from where new elements were added
   * @param added elements added
   *
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#wasUpdated() `ListChangeListener.Change.wasAdded()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getFrom() `ListChangeListener.Change.getFrom()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getAddedSubList() `ListChangeListener.Change.getAddedSubList()`]]
   */
  case class Add[T](position: Int, added: Traversable[T]) extends Change[T]

  /**
   * Indicates a Removal in an $OB.
   *
   * @param position Position from where elements were removed
   * @param removed elements removed
   *
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#wasUpdated() `ListChangeListener.Change.wasRemoved()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getFrom() `ListChangeListener.Change.getFrom()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getRemoved() `ListChangeListener.Change.getRemoved()`]]
   */
  case class Remove[T](position: Int, removed: Traversable[T]) extends Change[T]

  /**
   * Indicates a Reordering in an $OB.
   *
   * @param start The start of the change interval.
   * @param end The end of the change interval.
   * @param permutation Function that indicates the permutation that happened. The argument indicates the old index
   *                    that contained the element prior to this change. Its return is the new index of the same element.
   *
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#wasUpdated() `ListChangeListener.Change.wasPermutated()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getFrom() `ListChangeListener.Change.getFrom()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getTo() `ListChangeListener.Change.getTo()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getPermutation(int) `ListChangeListener.Change.getPermutation(int)`]]
   */
  case class Reorder[T](start: Int, end: Int, permutation: Int => Int) extends Change[T]

  /**
   * Indicates an Update in an $OB.
   *
   * @param from Position from where elements were updated
   * @param to Position to where elements were updated (exclusive)
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#wasUpdated() `ListChangeListener.Change.wasUpdated()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getFrom() `ListChangeListener.Change.getFrom()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ListChangeListener.Change.html#getTo() `ListChangeListener.Change.getTo()`]]
   */
  case class Update[T](from: Int, to: Int) extends Change[T]

  // CHANGING INDICATORS - END

  // CREATION METHODS - BEGIN

  /**
   * Creates a new $OB from a sequence of elements.
   *
   * @param items Sequence of elements
   * @return new $OB from items
   */
  def from[T](items: Seq[T]): ObservableBuffer[T] =
    new ObservableBuffer[T](jfxc.FXCollections.observableArrayList[T](items.asJava))

  // CREATION METHODS - END

  // HELPER METHODS (ORIGINATED FROM FXCOLLECTIONS) - BEGIN

  /**
   * Shuffles all elements in the $OB. Fires only '''one''' change notification on the $buf.
   *
   * @param buffer Buffer to be shuffled
   */
  def shuffle[T](buffer: ObservableBuffer[T]): Unit = {
    jfxc.FXCollections.shuffle(buffer)
  }

  /**
   * Shuffles all elements in the $OB. Fires only '''one''' change notification on the $buf.
   *
   * @param buffer Buffer to be shuffled
   * @param rnd    the random generator used for shuffling
   */
  def shuffle[T](buffer: ObservableBuffer[T], rnd: ju.Random): Unit = {
    jfxc.FXCollections.shuffle(buffer, rnd)
  }

  /**
   * Concatenates more $OB's into one.
   *
   * @param buffers $buf to concatenate
   */
  def concat[T](buffers: ObservableBuffer[T]*): ObservableBuffer[T] = {
    val lists: java.util.List[jfxc.ObservableList[T]] = new java.util.ArrayList[jfxc.ObservableList[T]]
    buffers.foreach(buf => lists.add(buf.delegate))

    ObservableBuffer.from[T](jfxc.FXCollections.concat(lists.asScala: _*).asScala)
  }

  /**
   * Revert the order in the $OB. Fires only '''one''' change notification on the list.
   *
   * ''Implementation note'': This method uses
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/FXCollections.html#reverse(javafx.collections.ObservableList) `reverse`]]
   * method from
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/FXCollections.html `javafx.collections.FXCollections`]].
   * It is not called `reverse` to not confuse with method with same name from [[scala.collection.mutable.Buffer]]
   *
   * @param buffer $buf to be reverted.
   */
  def revertBuffer[T](buffer: ObservableBuffer[T]): Unit = {
    jfxc.FXCollections.reverse(buffer.delegate)
  }

  /**
   * Fills the provided $buf with obj. Fires only one change notification on the $buf.
   *
   * @param buffer $buf to Fill
   * @param obj    the object to fill the $buf with
   */
  def fillAll[T](buffer: ObservableBuffer[T], obj: T): Unit = {
    jfxc.FXCollections.fill(buffer, obj)
  }

  /**
   * Rotates the $buf by distance. Fires only one change notification on the $buf.
   *
   * @param buffer   the $buf to be rotated
   * @param distance the distance of rotation
   */
  def rotate[T](buffer: ObservableBuffer[T], distance: Int): Unit = {
    jfxc.FXCollections.rotate(buffer, distance)
  }

  // HELPER METHODS - END

}

/**
 * Wrapper class to JavaFX's
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableList.html $OL]].
 *
 * @tparam T Type of this $buf
 *
 * @define OB `ObservableBuffer`
 * @define OL `ObservableList`
 * @define ownOB The $OB itself.
 * @define buf `Buffer`
 * @define WhyOverride Overridden method to make it behave like a wrapped $OL.
 * @define noCL The new $OB won't have Change and Invalidation Listeners from original $buf.
 */
class ObservableBuffer[T](override val delegate: jfxc.ObservableList[T] = jfxc.FXCollections.observableArrayList[T])
    extends mutable.Buffer[T]
    with mutable.BufferLike[T, ObservableBuffer[T]]
    with GenericTraversableTemplate[T, ObservableBuffer]
    with mutable.Builder[T, ObservableBuffer[T]]
    with Observable
    with SFXDelegate[jfxc.ObservableList[T]] {

  /**
   * The factory companion object that builds instances of class $OB.
   */
  override def companion: GenericCompanion[ObservableBuffer] = ObservableBuffer

  /**
   * Produces an $OB from the added elements.
   */
  def result(): ObservableBuffer[T] = this

  /**
   * Creates a new $OB containing both the elements of this $buf and the
   * provided traversable object. $WhyOverride $noCL
   *
   * @param xs The traversable object.
   * @return A new $OB consisting of all the elements of this $buf and `xs`. $noCL
   */
  override def ++(xs: GenTraversableOnce[T]): ObservableBuffer[T] = {
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
  def +=(elem: T): ObservableBuffer.this.type = {
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
  override def +=(elem1: T, elem2: T, elems: T*): ObservableBuffer.this.type =
    this ++= (mutable.Buffer(elem1, elem2) ++= elems)

  /**
   * Adds all elements produced by a TraversableOnce to this $OB. $WhyOverride
   *
   * @param xs traversable object.
   * @return $ownOB
   */
  override def ++=(xs: TraversableOnce[T]): ObservableBuffer.this.type = {
    delegate.addAll(xs.toIterable.asJavaCollection)
    this
  }

  /**
   * Prepends a single element to this buffer. $WhyOverride
   *
   * @param elem Element to prepend
   * @return $ownOB
   */
  def +=:(elem: T): ObservableBuffer.this.type = {
    delegate.add(0, elem)
    this
  }

  /**
   * Appends a single element to this buffer. $WhyOverride
   *
   * @param elem Element to append
   * @return $ownOB
   */
  def :+=(elem: T): ObservableBuffer.this.type = {
    delegate.add(elem)
    this
  }

  /**
   * Creates a new $OB with all the elements of this collection except `elem`. $noCL
   *
   * @param elem Element to remove
   * @return A new $OB consisting of all the elements of this $buf except `elem`. $noCL
   */
  override def -(elem: T): ObservableBuffer[T] = {
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
  override def -(elem1: T, elem2: T, elems: T*): ObservableBuffer[T] = {
    val xs = mutable.Buffer(elem1, elem2) ++= elems
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
  override def --(xs: GenTraversableOnce[T]): ObservableBuffer[T] = {
    val ob   = new ObservableBuffer[T]
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
  override def -=(elem1: T, elem2: T, elems: T*): ObservableBuffer.this.type = {
    delegate.removeAll((mutable.Buffer(elem1, elem2) ++= elems).asJava)
    this
  }

  /**
   * Removes all elements produced by an iterator from this buffer.
   *
   * @param xs the traversable object with elements to remove.
   * @return $ownOB
   */
  override def --=(xs: TraversableOnce[T]): ObservableBuffer.this.type = {
    delegate.removeAll(xs.toIterable.asJavaCollection)
    this
  }

  /**
   * Selects an element by its index in the buffer.
   *
   * @param n index
   * @return Element at position `n`
   */
  def apply(n: Int): T = delegate.get(n)

  /**
   * Clears the $OB's contents. After this operation, the $buf is empty.
   */
  def clear(): Unit = {
    delegate.clear()
  }

  /**
   * Inserts new elements at a given index into this $buf.
   *
   * @param n the index where new elements are inserted.
   * @param elems  the traversable collection containing the elements to insert.
   */
  def insertAll(n: Int, elems: Traversable[T]): Unit = {
    delegate.addAll(n, elems.toIterable.asJavaCollection)
  }

  /**
   * Creates a new [[http://www.scala-lang.org/api/current/scala/collection/Iterator.html `Iterator`]].
   */
  def iterator: Iterator[T] = new Iterator[T] {
    val it: ju.Iterator[T] = delegate.iterator

    def hasNext: Boolean = it.hasNext

    def next(): T = it.next()
  }

  /**
   * Length of this $OB.
   */
  def length: Int = delegate.size

  /**
   * Removes the element at a given index from this $OB.
   *
   * @param n index the index of the element to be removed
   * @return Removed element
   */
  def remove(n: Int): T = delegate.remove(n)

  /**
   * Removes a number of elements from a given index position. $WhyOverride
   *
   * '''Note''': This method conflicts with method with same signature in
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableList.html#remove(int,int) $OL]].
   * There the arguments indicate a range of index of elements to be removed. Here the arguments indicate the first
   * index of range and the quantity of elements to be removed. If you want a functionality equivalent to JavaFX
   * $OL, use `removeRange`.
   *
   * @param n     the index which refers to the first element to remove.
   * @param count the number of elements to remove.
   */
  override def remove(n: Int, count: Int): Unit = {
    delegate.subList(n, n + count).clear()
  }

  /**
   * Remove a range of elements. Use this method if you want a functionality such as
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableList.html#remove(int,int) the method]]
   * with same signature in $OL.
   *
   * @param from the start of the range to remove (inclusive)
   * @param to   the end of the range to remove (exclusive)
   */
  def removeRange(from: Int, to: Int): Unit = {
    delegate.remove(from, to)
  }

  /**
   * Replaces element at given index with a new value.
   *
   * @param n       the index of the element to replace.
   * @param newelem new value to be positioned at position n.
   */
  def update(n: Int, newelem: T): Unit = {
    delegate.set(n, newelem)
  }

  /**
   * Retains only the elements in this list that are contained in the specified collection.
   * In other words, removes from this list all the elements that are not contained in the
   * specified collection.
   *
   * @param elems the traversable collection containing elements to be retained in this list
   */
  def retainAll(elems: T*): Unit = {
    delegate.retainAll(elems.asJava)
  }

  /**
   * Retains only the elements in this list that are contained in the specified collection.
   * In other words, removes from this list all the elements that are not contained in the
   * specified collection.
   *
   * @param elems the traversable collection containing elements to be retained in this list
   */
  def retainAll(elems: Iterable[T]): Unit = {
    delegate.retainAll(elems.asJavaCollection)
  }

  /**
   * Replace all oldVal elements in the list with newVal element. Fires only '''one''' change
   * notification on the list.
   *
   * @param oldVal The element that is going to be replace
   * @param newVal The replacement
   * @return `true` if the list was modified
   */
  def replaceAll(oldVal: T, newVal: T): Boolean = jfxc.FXCollections.replaceAll(this.delegate, oldVal, newVal)

  /**
   * Sorts this $OB if its type implements ''natural ordering''. This type must be a
   * [[http://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html `java.util.Comparable`]] subclass.
   * Otherwise it will throws a `IllegalStateException`.
   *
   * @param typeTag information about if this type is a `Comparable` subclass or not.
   */
  def sort()(implicit typeTag: WeakTypeTag[T]): Unit = {
    if (typeTag.tpe <:< typeOf[Comparable[_]]) {
      jfxc.FXCollections.sort(
        delegate,
        new ju.Comparator[T] {
          def compare(p1: T, p2: T): Int = p1.asInstanceOf[Comparable[T]].compareTo(p2)
        }
      )
    } else {
      throw new IllegalStateException("Type of this Observable List does not implement " +
        "java.util.Comparable. Please use a Comparator function.")
    }
  }

  /**
   * Sorts this $OB using a Comparator function
   *
   * @param lt Comparator function that returns `true` if first element was lesser than second
   *           or `false` otherwise.
   */
  def sort(lt: (T, T) => Boolean): Unit = {
    jfxc.FXCollections.sort(
      delegate,
      new ju.Comparator[T] {
        def compare(p1: T, p2: T): Int = if (lt(p1, p2)) -1 else if (lt(p2, p1)) 1 else 0
      }
    )
  }

  import scalafx.collections.ObservableBuffer._

  /**
   * Add a listener function to list's changes. This function '''will handle''' this buffer's
   * modifications data.
   *
   * @param op Function that will handle this $OB's modifications data to be activated when
   *           some change was made.
   * @return A subscription object
   */
  def onChange[T1 >: T](op: (ObservableBuffer[T], Seq[Change[T1]]) => Unit): Subscription = {
    val listener = new jfxc.ListChangeListener[T1] {
      def onChanged(c: jfxc.ListChangeListener.Change[_ <: T1]): Unit = {
        var changes = ArrayBuffer.empty[Change[T1]]
        while (c.next()) {
          if (c.wasPermutated()) {
            changes += Reorder(
              c.getFrom,
              c.getTo,
              {
                x => c.getPermutation(x)
              }
            )
          } else if (c.wasUpdated()) {
            changes += Update(c.getFrom, c.getTo)
          } else {
            if (c.wasRemoved()) {
              changes += Remove(c.getFrom, c.getRemoved.asScala)
            }
            if (c.wasAdded()) {
              changes += Add(c.getFrom, c.getAddedSubList.asScala)
            }
          }
        }
        op(ObservableBuffer.this, changes)
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
   * Add a listener function to list's changes. This function '''will not handle''' this buffer's
   * modifications data.
   *
   * @param op No-argument function to be activated when some change in this $OB was made.
   * @return A `subscription` object
   */
  def onChange[T1 >: T](op: => Unit): Subscription = {
    val listener = new jfxc.ListChangeListener[T1] {
      def onChanged(c: jfxc.ListChangeListener.Change[_ <: T1]): Unit = {
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
