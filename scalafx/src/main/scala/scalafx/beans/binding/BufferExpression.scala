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

package scalafx.beans.binding

import java.util
import javafx.beans.{binding => jfxbb}

import scala.collection.mutable
import scala.language.implicitConversions
import scalafx.beans.binding.BindingIncludes.jfxBooleanBinding2sfx
import scalafx.beans.property.PropertyIncludes.{jfxReadOnlyBooleanProperty2sfx, jfxReadOnlyIntegerProperty2sfx}
import scalafx.beans.property.{ReadOnlyBooleanProperty, ReadOnlyIntegerProperty}
import scalafx.collections.ObservableBuffer

object BufferExpression {

  /**
   * Converts a ScalaFX BufferExpression to its JavaFX counterpart ListProperty.
   *
   * @param v ScalaFX BufferExpression
   * @return JavaFX ListExpression
   */
  implicit def sfxBufferExpression2jfx[E <: Any](v: BufferExpression[E]): jfxbb.ListExpression[E] =
    if (v != null) v.delegate else null
}

/**
 * Wraps a $JFX $URL0 ListExpression]].
 *
 * @define TC          BufferExpression
 * @define URL0        [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/ListExpression.html
 * @define JFX         JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class BufferExpression[E <: Any](val delegate: jfxbb.ListExpression[E]) {

  /**
   * A boolean property that is `true`, if the the buffer is empty.
   */
  def empty: ReadOnlyBooleanProperty = delegate.emptyProperty()

  /**
   * An integer property that represents the size of the buffer.
   */
  def size: ReadOnlyIntegerProperty = delegate.sizeProperty()

  def +=(element: E): Boolean = delegate.add(element)

  def ++=(elem1: E, elem2: E, elems: E*): Boolean = this.++=(Seq(elem1, elem2) ++ elems)
  def ++=(xs: Seq[E]): Boolean = {
    import scala.collection.JavaConverters._
    delegate.addAll(xs.asJavaCollection)
  }

  /**
   * Creates a new BooleanBinding that holds true if this list is equal to another ObservableBuffer.
   *
   * @param other the other ObservableList
   * @return the new BooleanBinding
   */
  def isEqualTo(other: ObservableBuffer[_]): BooleanBinding = delegate.isEqualTo(other.delegate)

  /**
   * Creates a new BooleanBinding that holds true if this list is not equal to another ObservableBuffer.
   *
   * @param other the other ObservableList
   * @return the new BooleanBinding
   */
  def isNotEqualTo(other: ObservableBuffer[_]): BooleanBinding = delegate.isNotEqualTo(other.delegate)

  def -=(element: E): Boolean = this.delegate.remove(element)

  def --=(elem1: E, elem2: E, elems: E*): Boolean = this.--=(Seq(elem1, elem2) ++ elems)
  def --=(xs: Seq[E]): Boolean = {
    import scala.collection.JavaConverters._
    delegate.removeAll(xs.asJavaCollection)
  }

  def retainAll(elem1: E, elem2: E, elems: E*): Boolean = this.retainAll(Seq(elem1, elem2) ++ elems)
  def retainAll(xs: Seq[E]): Boolean = {
    import scala.collection.JavaConverters._
    delegate.retainAll(xs.asJavaCollection)
  }

  /**
   * Clears the ObservableBuffer and add all the elements passed as var-args.
   */
  def setAll(elem1: E, elem2: E, elems: E*): Boolean = this.setAll(Seq(elem1, elem2) ++ elems)

  /**
   * Clears the ObservableBuffer and add all elements from the collection.
   */
  def setAll(xs: Seq[E]): Boolean = {
    import scala.collection.JavaConverters._
    delegate.setAll(xs.asJavaCollection)
  }

  def subBuffer(from: Int, to: Int): mutable.Buffer[E] = {
    import scala.collection.JavaConverters._
    val v: util.List[E] = delegate.subList(from, to)
    v.asScala
  }
}
