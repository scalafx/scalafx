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

package scalafx.beans.property

import javafx.beans.{property => jfxbp}
import javafx.{collections => jfxc}
import scalafx.beans.property.PropertyIncludes.jfxReadOnlyListProperty2sfx
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object ReadOnlyBufferWrapper {

  /**
   * Converts a ScalaFX ReadOnlyBufferWrapper to its JavaFX counterpart ReadOnlyListWrapper.
   *
   * @param v ScalaFX ReadOnlyBufferWrapper
   * @return JavaFX ReadOnlyListWrapper
   */
  implicit def sfxReadOnlyBufferWrapper2jfx[E <: Any](v: ReadOnlyBufferWrapper[E]): jfxbp.ReadOnlyListWrapper[E] =
    if (v != null) v.delegate else null

  /**
   * Creates a new ReadOnlyBufferWrapper instance.
   *
   * @param value the initial value of the wrapped value
   */
  def apply[E <: Any](value: ObservableBuffer[E]) = new ReadOnlyBufferWrapper(new jfxbp.ReadOnlyListWrapper(value))

  /**
   * Creates a new ReadOnlyBufferWrapper.
   *
   * @param bean the bean of this ReadOnlyBufferWrapper
   * @param name the name of this ReadOnlyBufferWrapper
   */
  def apply[E <: Any](bean: Any, name: String) =
    new ReadOnlyBufferWrapper(new jfxbp.ReadOnlyListWrapper[E](bean, name))

  /**
   * Creates a new ReadOnlyBufferWrapper.
   *
   * @param bean  the bean of this ReadOnlyBufferWrapper
   * @param name  the name of this ReadOnlyBufferWrapper
   * @param value the initial value
   */
  def apply[E <: Any](bean: Any, name: String, value: ObservableBuffer[E]) =
    new ReadOnlyBufferWrapper(new jfxbp.ReadOnlyListWrapper(bean, name, value.delegate))

  /**
   * Creates a new ReadOnlyBufferWrapper and a its value from a sequence of elements.
   *
   * @param items Sequence of elements to assign to ReadOnlyBufferWrapper value
   * @return new ReadOnlyBufferWrapper from items
   */
  def apply[E <: Any](items: Seq[E]): ReadOnlyBufferWrapper[E] = {
    import scala.collection.JavaConverters._
    new ReadOnlyBufferWrapper[E](
      new jfxbp.ReadOnlyListWrapper(jfxc.FXCollections.observableArrayList[E](items.asJava))
    )
  }

  /**
   * Creates a new ReadOnlyBufferWrapper and a its value from a sequence of elements.
   *
   * @param bean  the bean of this ReadOnlyBufferWrapper
   * @param name  the name of this ReadOnlyBufferWrapper
   * @param items Sequence of elements to assign to ReadOnlyBufferWrapper value
   * @return new ReadOnlyBufferWrapper from items
   */
  def apply[E <: Any](bean: Any, name: String, items: Seq[E]): ReadOnlyBufferWrapper[E] = {
    import scala.collection.JavaConverters._
    new ReadOnlyBufferWrapper[E](
      new jfxbp.ReadOnlyListWrapper(bean, name, jfxc.FXCollections.observableArrayList[E](items.asJava))
    )
  }
}

/**
 * Wraps `javafx.beans.property.ReadOnlyListWrapper`.
 */
class ReadOnlyBufferWrapper[E <: Any](override val delegate: jfxbp.ReadOnlyListWrapper[E] =
  new jfxbp.ReadOnlyListWrapper[E])
    extends BufferProperty[E]
    with SFXDelegate[jfxbp.ReadOnlyListWrapper[E]] {

  /**
   * Creates a new ReadOnlyBufferWrapper instance.
   *
   * @param value the initial value of the wrapped value
   */
  def this(value: ObservableBuffer[E]) =
    this(new jfxbp.ReadOnlyListWrapper[E](value))

  /**
   * Creates a new ReadOnlyBufferWrapper.
   *
   * @param bean the bean of this ReadOnlyBufferWrapper
   * @param name the name of this ReadOnlyBufferWrapper
   */
  def this(bean: Any, name: String) =
    this(new jfxbp.ReadOnlyListWrapper[E](bean, name))

  /**
   * Creates a new ReadOnlyBufferWrapper.
   *
   * @param bean  the bean of this ReadOnlyBufferWrapper
   * @param name  the name of this ReadOnlyBufferWrapper
   * @param value the initial value
   */
  def this(bean: Any, name: String, value: ObservableBuffer[E]) =
    this(new jfxbp.ReadOnlyListWrapper[E](bean, name, value))

  /**
   * Creates a new ReadOnlyBufferWrapper and a its value from a sequence of elements.
   *
   * @param items Sequence of elements to assign to ReadOnlyBufferWrapper value
   * @return new ReadOnlyBufferWrapper from items
   */
  def this(items: Seq[E]) = {
    this(
      new jfxbp.ReadOnlyListWrapper(
        jfxc.FXCollections.observableArrayList[E](
          scala.collection.JavaConverters.seqAsJavaListConverter(items).asJava
        )
      )
    )
  }

  /**
   * Creates a new ReadOnlyBufferWrapper and a its value from a sequence of elements.
   *
   * @param bean  the bean of this ReadOnlyBufferWrapper
   * @param name  the name of this ReadOnlyBufferWrapper
   * @param items Sequence of elements to assign to ReadOnlyBufferWrapper value
   * @return new ReadOnlyBufferWrapper from items
   */
  def this(bean: Any, name: String, items: Seq[E]) = {
    this(
      new jfxbp.ReadOnlyListWrapper(
        bean,
        name,
        jfxc.FXCollections.observableArrayList[E](
          scala.collection.JavaConverters.seqAsJavaListConverter(items).asJava
        )
      )
    )
  }

  /**
   * Returns the readonly property, that is synchronized with this ReadOnlyListWrapper.
   *
   * @return the readonly property
   */
  def readOnlyProperty: ReadOnlyBufferProperty[E] = delegate.getReadOnlyProperty
}
