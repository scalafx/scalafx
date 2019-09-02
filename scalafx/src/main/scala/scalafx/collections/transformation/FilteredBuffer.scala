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
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

object FilteredBuffer {

  /**
    * Converts a ScalaFX FilteredBuffer to its JavaFX counterpart FilteredList.
    *
    * @param v ScalaFX FilteredBuffer
    * @return JavaFX FilteredList
    */
  implicit def sfxFilteredList2jfx[E](v: FilteredBuffer[E]): jfxct.FilteredList[E] =
    if (v != null) v.delegate else null
}

/**
  * Wraps a $JFX $URL0 $TC]].
  *
  * @define TC FilteredList
  * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx.collections.transformation/FilteredList.html
  * @define JFX JavaFX
  * @define ORIGINALDOC Original Documentation]].
  */
class FilteredBuffer[E](override val delegate: jfxct.FilteredList[E])
    extends TransformationBuffer[E, E](delegate)
    with SFXDelegate[jfxct.FilteredList[E]] {

  /**
    * Constructs a new FilteredBuffer wrapper around the source buffer.
    * This list has an "always true" predicate, containing all the elements of the source list.
    *
    * @param source the source buffer.
    */
  def this(source: ObservableBuffer[E]) = this(delegate = new jfxct.FilteredList[E](source.delegate))

  /**
    * Constructs a new FilteredBuffer wrapper around the source buffer.
    *
    * @param source the source buffer.
    * @param predicate the predicate to match the elements. Cannot be null.
    */
  def this(source: ObservableBuffer[E], predicate: (_ >: E) => Boolean) =
    this(delegate = new jfxct.FilteredList[E](source.delegate, new ju.function.Predicate[E] {
      override def test(t: E): Boolean = predicate(t)
    }))

  /**
    *
    * The predicate that will match the elements that will be in this FilteredBuffer.
    */
  def predicate: ObjectProperty[ju.function.Predicate[_ >: E]] = delegate.predicateProperty
  def predicate_=(v: ju.function.Predicate[_ >: E]): Unit = {
    ObjectProperty.fillProperty(delegate.predicateProperty, v)
  }
  def predicate_=(predicate: (E) => Boolean) {
    ObjectProperty.fillProperty(delegate.predicateProperty, new ju.function.Predicate[E] {
      override def test(t: E): Boolean = predicate(t)
    })
  }
}
