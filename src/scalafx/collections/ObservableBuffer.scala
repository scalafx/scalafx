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

import collection.generic.{GenericCompanion, GenericTraversableTemplate, SeqFactory, CanBuildFrom}
import collection.JavaConversions._
import com.sun.javafx.{collections => csjc}
import javafx.{collections => jfxc}
import scalafx.beans.Observable
import javafx.collections.ListChangeListener
import collection.mutable.{ArrayBuffer, Builder, Buffer, BufferLike}
import collection.TraversableOnce
import scalafx.collections.ObservableBuffer.{Reorder, Remove, Add, Change}
import java.util.{Comparator, ArrayList}

object ObservableBuffer extends SeqFactory[ObservableBuffer] {
  implicit def observableBuffer2ObservableList[T](ob: ObservableBuffer[T]) = ob.delegate
  implicit def canBuildFrom[T]: CanBuildFrom[Coll, T, ObservableBuffer[T]] = new GenericCanBuildFrom[T] {
    override def apply() = newBuilder[T]
  }
  def newBuilder[T]: Builder[T, ObservableBuffer[T]] = new ObservableBuffer

  trait Change
  case class Add[T](position: Int, added: Traversable[T]) extends Change
  case class Remove[T](position: Int, removed: Traversable[T]) extends Change
  case class Reorder(start: Int, end: Int, permutation: (Int => Int)) extends Change
}

class ObservableBuffer[T](override val delegate: jfxc.ObservableList[T] with csjc.SortableList[T] = new csjc.ObservableListWrapper[T](new ArrayList[T]())) 
  extends Buffer[T] 
with BufferLike[T, ObservableBuffer[T]] 
with GenericTraversableTemplate[T, ObservableBuffer] 
with Observable 
with Builder[T, ObservableBuffer[T]] {
  
  override def companion: GenericCompanion[ObservableBuffer] = ObservableBuffer
  def length = delegate.size
  override def isEmpty = delegate.isEmpty
  override def iterator: Iterator[T] = delegate.iterator
  def apply(i: Int) = delegate.get(i)
  def update(i: Int, elem: T) {
    delegate.set(i, elem)
  }
  def +=:(elem: T) = {
    delegate.subList(0, 0) add elem
    this
  }
  def +=(elem: T): this.type = {
    delegate add elem
    this
  }
  override def +=(elem1: T, elem2: T, elems: T*) = {
    val buf = Buffer(elem1, elem2)
    for (e <- elems) buf.append(e)
    delegate.addAll(buf)
    this
  }
  def insertAll(i: Int, elems: Traversable[T]) {
    delegate.addAll(i, elems.toIterable)
  }
  def remove(i: Int) = delegate.remove(i)
  def clear() {
    delegate.clear()
  }
  def result() = this
  override def ++=(xs: TraversableOnce[T]) = {
    delegate.addAll(xs.toIterable)
    this
  }
  override def remove(n: Int, count: Int) {
    delegate.subList(n, n + count).clear()
  }
  def sort() {
    delegate.sort()
  }
  def sort(lt: (T, T) => Boolean) {
    delegate.sort(new Comparator[T]() {
      def compare(p1: T, p2: T) = if (lt(p1, p2)) -1 else if (lt(p2, p1)) 1 else 0
    })
  }

  def onChange[T1 >: T](op: (ObservableBuffer[T], Seq[Change]) => Unit) {
    delegate.addListener(new ListChangeListener[T1] {
      def onChanged(c: ListChangeListener.Change[_ <: T1]) {
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
    )
  }

  def onChange[T1 >: T](op: => Unit) {
    delegate.addListener(new ListChangeListener[T1] {
      def onChanged(c: ListChangeListener.Change[_ <: T1]) {
        op
      }
    })
  }
}