/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

/**
 * Companion Object for [[scalafx.collections.ObservableFloatArray]].
 */
object ObservableFloatArray extends ObservableArrayCompanionBase[Float, ObservableFloatArray,
  jfxc.ObservableFloatArray] {

  /**
   * @inheritdoc
   */
  override def apply(v: Float*) = new ObservableFloatArray(jfxc.FXCollections.observableFloatArray(v:_*))
}

// TODO: Enter link when JavaFX 8 API Docs are available on-line.
/**
 * Wrapper class to JavaFX's `ObservableFloatArray`.
 *
 * @param delegate Wrapped JavaFX $OFA providing implementation.

 * @define OFA `ObservableFloatArray`
 * @define ARY `Array`
 */
class ObservableFloatArray(delegate: jfxc.ObservableFloatArray = jfxc.FXCollections.observableFloatArray())
  extends ObservableArray[Float, ObservableFloatArray, jfxc.ObservableFloatArray](delegate) {

  /**
   * Create $OFA with specified capacity.
   *
   * Elements will be zeroed out.
   *
   * @param n Size of new $OFA.  This value cannot be negative.
   * @throws NegativeArraySizeException if `n` is negative.
   */
  def this(n: Int) = this(jfxc.FXCollections.observableFloatArray(new Array[Float](n):_*))

  // ObservableFloatArray interface functions, allow class to act like it
  // implements the JavaFX ObservableFloatArray interface, without actually
  // being interchangeable with one.
  /**
   * @inheritdoc
   */
  override def copyTo(srcIdx: Int, dest: Array[Float], destIdx: Int, length:Int) {
    delegate.copyTo(srcIdx, dest, destIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def copyTo(srcIdx: Int, dest: ObservableFloatArray, destIdx: Int, length: Int) {
    delegate.copyTo(srcIdx, dest.delegate, destIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def get(idx: Int): Float = delegate.get(idx)

  /**
   * @inheritdoc
   */
  override def addAll(elems: Float*) {
    delegate.addAll(elems:_*)
  }

  /**
   * @inheritdoc
   */
  override def addAll(src: ObservableFloatArray) {
    delegate.addAll(src.delegate)
  }

  /**
   * @inheritdoc
   */
  override def addAll(src: Array[Float], srcIdx: Int, length: Int) {
    delegate.addAll(src, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def addAll(src: ObservableFloatArray, srcIdx: Int, length: Int) {
    delegate.addAll(src.delegate, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def setAll(elems: Float*) {
    delegate.setAll(elems:_*)
  }

  /**
   * @inheritdoc
   */
  override def setAll(src: ObservableFloatArray) {
    delegate.setAll(src.delegate)
  }

  /**
   * @inheritdoc
   */
  override def setAll(src: Array[Float], srcIdx: Int, length: Int) {
    delegate.setAll(src, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def setAll(src: ObservableFloatArray, srcIdx: Int, length: Int) {
    delegate.setAll(src.delegate, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def set(idx: Int, elem: Float) {
    delegate.set(idx, elem)
  }

  /**
   * @inheritdoc
   */
  override def set(destIdx: Int, src: Array[Float], srcIdx: Int, length: Int) {
    delegate.set(destIdx, src, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def set(destIdx: Int, src: ObservableFloatArray, srcIdx: Int, length: Int) {
    delegate.set(destIdx, src.delegate, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def toArray(dest: Array[Float]): Array[Float] = delegate.toArray(dest)

  /**
   * @inheritdoc
   */
  override def toArray(srcIdx: Int, dest: Array[Float], length: Int): Array[Float] = delegate.toArray(srcIdx, dest, length)
}