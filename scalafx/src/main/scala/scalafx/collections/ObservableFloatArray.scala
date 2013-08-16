/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.{collections => jfxc}
import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.collections.ObservableFloatArray!]].
 */
object ObservableFloatArray extends ObservableArrayCompanionBase [Float,
  ObservableFloatArray, jfxc.ObservableFloatArray] {

  /**
   * @inheritdocs
   */
  override def apply (va: Float*) =
    new ObservableFloatArray (jfxc.FXCollections.observableFloatArray (va:_*))
}

/**
 * @define OFA `ObservableFloatArray`
 * @define ARY `Array`
 * @define JFXC http://docs.oracle.com/javafx/8/api/javafx/collections
 *
 * Wrapper class to JavaFX's [[$JFXC/ObservableFloatArray.html
 * ObservableFloatArray]].
 *
 * @param delegate Wrapped JavaFX $OFA providing implementation.
 */
class ObservableFloatArray (delegate: jfxc.ObservableFloatArray =
  jfxc.FXCollections.observableFloatArray ())
  extends ObservableArray [Float, ObservableFloatArray,
    jfxc.ObservableFloatArray] (delegate) {

  /**
   * Create $OFA with specified capacity.
   *
   * Elements will be zeroed out.
   *
   * @param n Size of new $OFA.  This value cannot be negative.
   * @throws NegativeArraySizeException if `n` is negative.
   */
  def this (n: Int) = this (jfxc.FXCollections.observableFloatArray
    (new Array [Float] (n):_*))

  // ObservableFloatArray interface functions, allow class to act like it
  // implements the JavaFX ObservableFloatArray interface, without actually
  // being interchangeable with one.
  /**
   * @inheritdocs
   */
  override def copyTo (srcIdx: Int, dest: Array [Float], destIdx: Int, length:
    Int) = delegate.copyTo (srcIdx, dest, destIdx, length)

  /**
   * @inheritdocs
   */
  override def copyTo (srcIdx: Int, dest: ObservableFloatArray, destIdx: Int,
    length: Int) =
      delegate.copyTo (srcIdx, dest.delegate, destIdx, length)

  /**
   * @inheritdocs
   */
  override def get (idx: Int) = delegate.get (idx)

  /**
   * @inheritdocs.
   */
  override def addAll (elements: Float*) = delegate.addAll (elements:_*)

  /**
   * @inheritdocs.
   */
  override def addAll (src: ObservableFloatArray) =
    delegate.addAll (src.delegate)

  /**
   * @inheritdocs.
   */
  override def addAll (src: Array [Float], srcIdx: Int, length: Int) =
    delegate.addAll (src, srcIdx, length)

  /**
   * @inheritdocs.
   */
  override def addAll (src: ObservableFloatArray, srcIdx: Int, length: Int) =
    delegate.addAll (src.delegate, srcIdx, length)

  /**
   * @inheritdocs.
   */
  override def setAll (elements: Float*) = delegate.setAll (elements:_*)

  /**
   * @inheritdocs.
   */
  override def setAll (src: ObservableFloatArray) =
    delegate.setAll (src.delegate)

  /**
   * @inheritdocs.
   */
  override def setAll (src: Array [Float], srcIdx: Int, length: Int) =
    delegate.setAll (src, srcIdx, length)

  /**
   * @inheritdocs.
   */
  override def setAll (src: ObservableFloatArray, srcIdx: Int, length: Int) =
    delegate.setAll (src.delegate, srcIdx, length)

  /**
   * @inheritdocs
   */
  override def set (idx: Int, elem: Float) = delegate.set (idx, elem)

  /**
   * @inheritdocs
   */
  override def set (destIdx: Int, src: Array [Float], srcIdx: Int, length:
    Int) = delegate.set (destIdx, src, srcIdx, length)

  /**
   * @inheritdocs
   */
  override def set (destIdx: Int, src: ObservableFloatArray, srcIdx: Int,
    length: Int) = delegate.set (destIdx, src.delegate, srcIdx, length)

  /**
   * @inheritdocs
   */
  override def toArray (dest: Array [Float]) = delegate.toArray (dest)

  /**
   * @inheritdocs
   */
  override def toArray (srcIdx: Int, dest: Array [Float], length: Int) =
    delegate.toArray (srcIdx, dest, length)

  // ArrayLike [V, T] abstract member function implementations.
  /**
   * Create new builder for this collection.
   *
   * @return New empty $OFA.
   */
  protected [this] override def newBuilder = ObservableFloatArray.empty

  // Builder [V, T] abstract member function implementations.
  /**
   * Produces collection from builder.
   *
   * @return This $OFA.
   */
  override def result () = this

  /**
   * Add new element to this $OFA.
   *
   * @param elem Element to be added to end of this array.
   * @return This $OFA.
   */
  override def += (elem: Float) = {
    delegate.addAll (elem)
    this
  }
}