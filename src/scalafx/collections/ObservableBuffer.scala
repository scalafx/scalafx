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

import collection.generic.{ GenericCompanion, GenericTraversableTemplate, SeqFactory, CanBuildFrom }
import collection.JavaConversions._
import com.sun.javafx.{ collections => csjc }
import javafx.{ collections => jfxc }
import scalafx.beans.Observable
import javafx.collections.ListChangeListener
import collection.mutable.{ ArrayBuffer, Builder, Buffer, BufferLike }
import collection.TraversableOnce
import scalafx.collections.ObservableBuffer.{ Reorder, Remove, Add, Change }
import java.util.{ Comparator, ArrayList }
import scala.collection.mutable.BufferProxy
import java.util.Random

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

  /**
   * Creates a new Observable Buffer from a sequence of elements.
   *
   * @param itens Sequence of elements
   * @returns new Observable Buffer from items
   */
  def apply[T](items: Seq[T]): ObservableBuffer[T] =
    new ObservableBuffer[T](jfxc.FXCollections.observableArrayList[T](items))

  /**
   * Shuffles all elements in the observable list. Fires only '''one''' change notification on
   * the list.
   */
  def shuffle[T](buffer: ObservableBuffer[T]) = jfxc.FXCollections.shuffle(buffer)

  /**
   * Shuffles all elements in the observable list. Fires only '''one''' change notification on
   * the list.
   */
  def shuffle[T](buffer: ObservableBuffer[T], rnd: Random) = jfxc.FXCollections.shuffle(buffer, rnd)

  /**
   * Concatenates more observable buffers into one.
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

}

/**
 *
 */
class ObservableBuffer[T](override val delegate: jfxc.ObservableList[T] = jfxc.FXCollections.observableArrayList[T])
  extends Buffer[T]
  with BufferProxy[T]
  with GenericTraversableTemplate[T, ObservableBuffer]
  with Observable
  with Builder[T, ObservableBuffer[T]] {

  import ObservableBuffer._

  def self = delegate

  /**
   * The factory companion object that builds instances of class ObservableBuffer.
   */
  override def companion: GenericCompanion[ObservableBuffer] = ObservableBuffer

  /**
   * Produces a collection from the added elements.
   */
  def result() = this

  /**
   * adds all elements produced by a TraversableOnce to this Observable Buffer.
   *
   * @returns the buffer itself.
   */
  override def ++=(xs: TraversableOnce[T]) = {
    delegate.addAll(xs.toIterable)
    this
  }

  /**
   * Appends two or more elements to this buffer.
   *
   * @returns the buffer itself.
   */
  override def +=(elem1: T, elem2: T, elems: T*) =
    this ++= (Buffer(elem1, elem2) ++= elems).toTraversable

  /**
   * Appends the elements contained in a traversable object to this buffer.
   *
   * @returns the buffer itself.
   */
  override def appendAll(xs: TraversableOnce[T]) = this ++= xs

  /**
   * Appends the given elements to this buffer.
   *
   * @returns the buffer itself.
   */
  override def append(xs: T*) = this ++= xs

  /**
   * Inserts new elements at a given index into this buffer.
   *
   * @param n the index where new elements are inserted.
   * @param iter  the traversable collection containing the elements to insert.
   */
  override def insertAll(n: Int, iter: Iterable[T]) {
    delegate.addAll(n, iter)
  }

  /**
   * Inserts new elements at a given index into this buffer.
   *
   * @param the index where new elements are inserted.
   * @param the traversable collection containing the elements to insert.
   */
  override def insert(n: Int, elems: T*) {
    insertAll(n, elems)
  }

  /**
   * Prepends the elements contained in a traversable object to this buffer.
   *
   * @param xs the collection containing the elements to prepend.
   */
  override def prependAll(xs: TraversableOnce[T]) {
    insertAll(0, xs.toIterable);
  }

  /**
   * Prepends elements to this buffer.
   *
   * @param xs the TraversableOnce containing the elements to prepend.
   * @returns the buffer itself.
   */
  override def ++=:(xs: TraversableOnce[T]) = {
    insertAll(0, xs.toIterable);
    this
  }

  /**
   * Removes a number of elements from a given index position.
   *
   * @param n the index which refers to the first element to remove.
   * @param count the number of elements to remove.
   */
  override def remove(n: Int, count: Int) {
    delegate.subList(n, n + count).clear()
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
   * Sorts this Buffer if its type's ''natural ordering''. This type must be a
   * [[java.util.Comparable]] subclass. Otherwise it will throws a [[scala.IllegalStateException]].
   */
  def sort()(implicit m: ClassManifest[T]) {
    if (m.erasure.getInterfaces.contains(classOf[Comparable[_]])) {
      jfxc.FXCollections.sort(delegate, new Comparator[T]() {
        def compare(p1: T, p2: T) = p1.asInstanceOf[Comparable[T]].compareTo(p2)
      })
    } else {
      throw new IllegalStateException("Type of this Observable List does not implements " +
        "java.util.Comparable. Please uses a Comparator function.")
    }
  }

  /**
   * Sorts this Buffer using a Comparator function
   *
   *  @param lt Comparator function that returns `true` if first element was lesser than second
   *  or `false` otherwise.
   */
  def sort(lt: (T, T) => Boolean) {
    jfxc.FXCollections.sort(delegate, new Comparator[T]() {
      def compare(p1: T, p2: T) = if (lt(p1, p2)) -1 else if (lt(p2, p1)) 1 else 0
    })
  }

  /**
   * Add a listener function to list's changes. This functin will handle this buffer's
   * modifications data.
   *
   * @param Function that will handle this buffer's modifications data to be activated when
   * some change was made.
   */
  def onChange[T1 >: T](op: (ObservableBuffer[T], Seq[Change]) => Unit) {
    delegate.addListener(new jfxc.ListChangeListener[T1] {
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
    })
  }

  /**
   * Add a listener function to list's changes. This functin will not handle this buffer's
   * modifications data.
   *
   * @param op No-argument function to be activated when some change in this buffer was made.
   */
  def onChange[T1 >: T](op: => Unit) {
    delegate.addListener(new jfxc.ListChangeListener[T1] {
      def onChanged(c: jfxc.ListChangeListener.Change[_ <: T1]) {
        op
      }
    })
  }
}