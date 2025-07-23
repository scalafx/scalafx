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

package scalafx.beans.property

import javafx.beans.property as jfxbp
import javafx.collections as jfxc
import scalafx.beans.binding.BufferExpression
import scalafx.collections.CollectionIncludes.observableList2ObservableBuffer
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object ReadOnlyBufferProperty {

  /**
   * Converts a ScalaFX ReadOnlyBufferProperty to its JavaFX counterpart ReadOnlyListProperty.
   *
   * @param v ScalaFX ReadOnlyBufferProperty
   * @return JavaFX ReadOnlyListProperty
   */
  implicit def sfxReadOnlyBufferProperty2jfx[E <: Any](v: ReadOnlyBufferProperty[E]): jfxbp.ReadOnlyListProperty[E] =
    if (v != null) v.delegate else null
}

/**
 * Wraps a $JFX $URL0 ReadOnlyListProperty]].
 *
 * @define TC          ReadOnlyBufferProperty
 * @define URL0        [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyListProperty.html
 * @define JFX         JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class ReadOnlyBufferProperty[E <: Any](override val delegate: jfxbp.ReadOnlyListProperty[E])
    extends BufferExpression[E](delegate)
    with ReadOnlyProperty[ObservableBuffer[E], jfxc.ObservableList[E]]
    with SFXDelegate[jfxbp.ReadOnlyListProperty[E]] {

  override def value: ObservableBuffer[E] = delegate.get()

  /**
   * Creates a content binding between the ObservableBuffer, that is wrapped in this ReadOnlyBufferProperty,
   * and another ObservableBuffer.
   *
   * A content binding ensures that the content of the wrapped ObservableBuffers is the same as that of the other buffer.
   * If the content of the other buffer changes, the wrapped buffer will be updated automatically.
   * Once the wrapped buffer is bound to another buffer, you must not change it directly.
   *
   * @param buffer the ObservableBuffer this property should be bound to
   */
  def bindContent(buffer: ObservableBuffer[E]): Unit = delegate.bindContent(buffer.delegate)

  /**
   * Creates a bidirectional content binding of the ObservableBuffer, that is wrapped in this ReadOnlyBufferProperty,
   * and another ObservableBuffer.
   *
   * A bidirectional content binding ensures that the content of two ObservableBuffers is the same.
   * If the content of one of the buffers changes, the other one will be updated automatically.
   *
   * @param buffer the ObservableBuffer this property should be bound to
   */
  def bindContentBidirectional(buffer: ObservableBuffer[E]): Unit = delegate.bindContentBidirectional(buffer.delegate)

  /**
   * Deletes a content binding between the ObservableBuffer, that is wrapped in this ReadOnlyBufferProperty, and another Object.
   *
   * This is a helper method that calls the JavaFX counterpart with a delegate rather than the original object.
   *
   * @param sfx the SFXDelegate object to which the binding should be removed
   */
  def unbindContent[T <: Object](sfx: SFXDelegate[T]): Unit = delegate.unbindContent(sfx.delegate)

  /**
   * Deletes a bidirectional content binding between the ObservableBuffer, that is wrapped in this ReadOnlyBufferProperty, and another Object.
   *
   * This is a helper method that calls the JavaFX counterpart with a delegate rather than the original object.
   *
   * @param sfx the SFXDelegate object to which the binding should be removed
   */
  def unbindContentBidirectional[T <: Object](sfx: SFXDelegate[T]): Unit =
    delegate.unbindContentBidirectional(sfx.delegate)
}
