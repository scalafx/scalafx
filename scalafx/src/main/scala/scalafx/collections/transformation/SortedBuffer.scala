/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

package scalafx.collections.transformation

import java.{util => ju}
import javafx.collections.{transformation => jfxct}

import scala.language.implicitConversions
import scala.math.Ordering
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

object SortedBuffer {

  /**
    * Converts a ScalaFX SortedBuffer to its JavaFX counterpart SortedList.
    *
    * @param v ScalaFX SortedBuffer
    * @return JavaFX SortedList
    */
  implicit def sfxSortedList2jfx[E](v: SortedBuffer[E]): jfxct.SortedList[E] =
    if (v != null) v.delegate else null
}

/**
  * Wraps a $JFX $URL0 $TC]].
  *
  * @define TC SortedList
  * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx.collections.transformation/SortedList.html
  * @define JFX JavaFX
  * @define ORIGINALDOC Original Documentation]].
  */
class SortedBuffer[E](override val delegate: jfxct.SortedList[E])
    extends TransformationBuffer[E, E](delegate)
    with SFXDelegate[jfxct.SortedList[E]] {

  /**
    * Constructs a new unordered SortedList wrapper around the source list.
    *
    * @param source the source list.
    */
  def this(source: ObservableBuffer[E]) = this(delegate = new jfxct.SortedList[E](source.delegate))

  /**
    * Constructs a new unordered SortedList wrapper around the source list.
    *
    * @param source the source list.
    */
  def this(source: ObservableBuffer[E], ordering: Ordering[_ >: E]) =
    this(delegate = new jfxct.SortedList[E](source.delegate, ordering))

  def this(source: ObservableBuffer[E], lessThan: (_ >: E, _ >: E) => Boolean) =
    this(delegate = new jfxct.SortedList[E](source.delegate, Ordering.fromLessThan(lessThan)))

  /**
    * The comparator that denotes the order of this SortedList.
    */
  def comparator: ObjectProperty[ju.Comparator[_ >: E]] = delegate.comparatorProperty
  def comparator_=(v: Ordering[_ >: E]) {
    ObjectProperty.fillProperty(delegate.comparatorProperty, v)
  }

  /**
    * Creates and align new comparator value using provided comparison function `lessThan`.
    *
    * @param lessThan Comparison function that returns `true` if first element was lesser than second or `false` otherwise.
    */
  def comparator_[T >: E](lessThan: (T, T) => Boolean) {
    val c = new ju.Comparator[T] {
      def compare(p1: T, p2: T) = if (lessThan(p1, p2)) -1 else if (lessThan(p2, p1)) 1 else 0
    }
    ObjectProperty.fillProperty(delegate.comparatorProperty(), Ordering.fromLessThan(lessThan))
  }

}
