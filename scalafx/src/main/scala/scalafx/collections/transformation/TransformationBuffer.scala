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

package scalafx.collections.transformation

import javafx.collections.{transformation => jfxct}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.collections.{ObservableBuffer, ObservableBufferBase}
import scalafx.delegate.SFXDelegate

object TransformationBuffer {

  /**
   * Converts a ScalaFX TransformationBuffer to its JavaFX counterpart TransformationList.
   *
   * @param v ScalaFX TransformationBuffer
   * @return JavaFX TransformationList
   */
  implicit def sfxTransformationBuffer2jfx[E, F](v: TransformationBuffer[E, F]): jfxct.TransformationList[E, F] =
    if (v != null) v.delegate else null
}

/**
 * A base class for all buffers that wraps other buffers in a way that changes the buffer's elements, order,
 * size or generally it's structure. If the source list is observable, a listener is automatically added to it and
 * the events are delegated.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * @tparam E - the type parameter of this buffer.
 * @tparam F - the upper bound of the type of the source buffer.
 *
 * @define TC TransformationList
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx.collections.transformation/TransformationList.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
abstract class TransformationBuffer[E, F](override val delegate: jfxct.TransformationList[E, F])
    extends ObservableBufferBase[E](delegate)
    with SFXDelegate[jfxct.TransformationList[E, F]] {

  /**
   * The source list specified in the constructor of this transformation list.
   */
  def source: ObservableBuffer[_ <: F] = delegate.getSource

  /**
   * Maps the index of this buffer's element to an index in the direct source buffer.
   * @param index  the index in this buffer
   * @return  the index of the element's origin in the source buffer.
   */
  def getSourceIndex(index: Int): Int = delegate.getSourceIndex(index)

  /**
   * Maps the index of this list's element to an index of the provided list.
   */
  def getSourceIndexFor(buffer: ObservableBuffer[E], index: Int): Int =
    delegate.getSourceIndexFor(buffer.delegate, index)

  /**
   * Checks whether the provided list is in the chain under this TransformationList.
   */
  def isInTransformationChain(buffer: ObservableBuffer[_]): Boolean = delegate.isInTransformationChain(buffer.delegate)
}
