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
package scalafx.collections

import javafx.{collections => jfxc}

/**
 * Companion Object for [[scalafx.collections.ObservableIntegerArray]].
 */
object ObservableIntegerArray
    extends ObservableArrayCompanionBase[Int, ObservableIntegerArray, jfxc.ObservableIntegerArray] {

  /**
   * @inheritdoc
   */
  override def apply(v: Int*) = new ObservableIntegerArray(jfxc.FXCollections.observableIntegerArray(v: _*))

  /**
   * Returns an array containing equally spaced values in some integer interval.
   *
   * @param start Start value of the array.
   * @param end   End value of the array, exclusive (that is, first value '''not''' included in array).  If `start`
   *              exceeds `end` (>= `end` if `step` is positive or <= `end` if `step` is negative), then an empty array will
   *              result.
   * @param step  Increment value of the array.  This value can be negative, but not zero.  If omitted, this value
   *              defaults to 1.
   * @return Observable array with values: `start, start + step, start + 2 * step, ...`, up to, but not including,
   *         `end`.
   * @throws IllegalArgumentException if `step` is 0.
   */
  def range(start: Int, end: Int, step: Int = 1): ObservableIntegerArray = apply(Array.range(start, end, step))
}

// TODO: Enter link when JavaFX 8 API Docs are available on-line.
/**
 * Wrapper class to JavaFX's `ObservableIntegerArray`.
 *
 * @param delegate Wrapped JavaFX $OIA providing implementation.
 *
 * @define OIA `ObservableIntegerArray`
 * @define ARY `Array`
 */
class ObservableIntegerArray(delegate: jfxc.ObservableIntegerArray = jfxc.FXCollections.observableIntegerArray())
    extends ObservableArray[Int, ObservableIntegerArray, jfxc.ObservableIntegerArray](delegate) {

  /**
   * Create $OIA with specified capacity.
   *
   * Elements will be zeroed out.
   *
   * @param n Size of new $OIA.  This value cannot be negative.
   * @throws NegativeArraySizeException if `n` is negative.
   */
  def this(n: Int) = this(jfxc.FXCollections.observableIntegerArray(new Array[Int](n): _*))

  // ObservableIntegerArray interface functions, allow class to act like it implements the JavaFX
  // ObservableIntegerArray interface, without actually being interchangeable with one.
  /**
   * @inheritdoc
   */
  override def copyTo(srcIdx: Int, dest: Array[Int], destIdx: Int, length: Int): Unit = {
    delegate.copyTo(srcIdx, dest, destIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def copyTo(srcIdx: Int, dest: ObservableIntegerArray, destIdx: Int, length: Int): Unit = {
    delegate.copyTo(srcIdx, dest.delegate, destIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def get(idx: Int): Int = delegate.get(idx)

  /**
   * @inheritdoc.
   */
  override def addAll(elems: Int*): Unit = {
    delegate.addAll(elems: _*)
  }

  /**
   * @inheritdoc.
   */
  override def addAll(src: ObservableIntegerArray): Unit = {
    delegate.addAll(src.delegate)
  }

  /**
   * @inheritdoc.
   */
  override def addAll(src: Array[Int], srcIdx: Int, length: Int): Unit = {
    delegate.addAll(src, srcIdx, length)
  }

  /**
   * @inheritdoc.
   */
  override def addAll(src: ObservableIntegerArray, srcIdx: Int, length: Int): Unit = {
    delegate.addAll(src.delegate, srcIdx, length)
  }

  /**
   * @inheritdoc.
   */
  override def setAll(elements: Int*): Unit = {
    delegate.setAll(elements: _*)
  }

  /**
   * @inheritdoc.
   */
  override def setAll(src: ObservableIntegerArray): Unit = {
    delegate.setAll(src.delegate)
  }

  /**
   * @inheritdoc.
   */
  override def setAll(src: Array[Int], srcIdx: Int, length: Int): Unit = {
    delegate.setAll(src, srcIdx, length)
  }

  /**
   * @inheritdoc.
   */
  override def setAll(src: ObservableIntegerArray, srcIdx: Int, length: Int): Unit = {
    delegate.setAll(src.delegate, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def set(idx: Int, elem: Int): Unit = {
    delegate.set(idx, elem)
  }

  /**
   * @inheritdoc
   */
  override def set(destIdx: Int, src: Array[Int], srcIdx: Int, length: Int): Unit = {
    delegate.set(destIdx, src, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def set(destIdx: Int, src: ObservableIntegerArray, srcIdx: Int, length: Int): Unit = {
    delegate.set(destIdx, src.delegate, srcIdx, length)
  }

  /**
   * @inheritdoc
   */
  override def toArray(dest: Array[Int]): Array[Int] = delegate.toArray(dest)

  /**
   * @inheritdoc
   */
  override def toArray(srcIdx: Int, dest: Array[Int], length: Int): Array[Int] =
    delegate.toArray(srcIdx, dest, length)

  // ArrayLike[V, T] abstract member function implementations.
  /**
   * Create new builder for this collection.
   *
   * @return New empty $OIA.
   */
  protected[this] override def newBuilder: ObservableIntegerArray = ObservableIntegerArray.empty()
}
