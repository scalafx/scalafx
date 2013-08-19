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

/**
 * Companion Object for [[scalafx.collections.ObservableIntegerArray]].
 */
object ObservableIntegerArray extends ObservableArrayCompanionBase[Int, ObservableIntegerArray,
  jfxc.ObservableIntegerArray] {

  /**
   * @inheritdocs
   */
  override def apply(a: Int*) = new ObservableIntegerArray(jfxc.FXCollections.observableIntegerArray(a:_*))

  /**
    * Returns an array containing equally spaced values in some integer interval.
    *
    * @param start Start value of the array.
    * @param end End value of the array, exclusive (that is, first value '''not''' included in array).  If `start`
    * exceeds `end` (>= `end` if `step` is positive or <= `end` if `step` is negative), then an empty array will
    * result.
    * @param step Increment value of the array.  This value can be negative, but not zero.  If omitted, this value
    * defaults to 1.
    * @return Observable array with values: `start, start + step, start + 2 * step, ...`, up to, but not including,
    * `end`.
    * @throws IllegalArgumentException if `step` is 0.
    */
  def range(start: Int, end: Int, step: Int = 1) = apply(Array.range(start, end, step))
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
  def this(n: Int) = this(jfxc.FXCollections.observableIntegerArray(new Array[Int](n):_*))


  // ObservableIntegerArray interface functions, allow class to act like it implements the JavaFX
  // ObservableIntegerArray interface, without actually being interchangeable with one.
  /**
   * @inheritdocs
   */
  override def copyTo(srcIdx: Int, dest: Array[Int], destIdx: Int, length: Int) {
    delegate.copyTo(srcIdx, dest, destIdx, length)
  }

  /**
   * @inheritdocs
   */
  override def copyTo(srcIdx: Int, dest: ObservableIntegerArray, destIdx: Int, length: Int) {
    delegate.copyTo(srcIdx, dest.delegate, destIdx, length)
  }

  /**
   * @inheritdocs
   */
  override def get(idx: Int) = delegate.get(idx)

  /**
   * @inheritdocs.
   */
  override def addAll(elems: Int*) = {
    delegate.addAll(elems:_*)
  }

  /**
   * @inheritdocs.
   */
  override def addAll(src: ObservableIntegerArray) {
    delegate.addAll(src.delegate)
  }

  /**
   * @inheritdocs.
   */
  override def addAll(src: Array[Int], srcIdx: Int, length: Int) {
    delegate.addAll(src, srcIdx, length)
  }

  /**
   * @inheritdocs.
   */
  override def addAll(src: ObservableIntegerArray, srcIdx: Int, length: Int) {
    delegate.addAll(src.delegate, srcIdx, length)
  }

  /**
   * @inheritdocs.
   */
  override def setAll(elements: Int*) {
    delegate.setAll(elements:_*)
  }

  /**
   * @inheritdocs.
   */
  override def setAll(src: ObservableIntegerArray) {
    delegate.setAll(src.delegate)
  }

  /**
   * @inheritdocs.
   */
  override def setAll(src: Array[Int], srcIdx: Int, length: Int) {
    delegate.setAll(src, srcIdx, length)
  }

  /**
   * @inheritdocs.
   */
  override def setAll(src: ObservableIntegerArray, srcIdx: Int, length: Int) {
    delegate.setAll(src.delegate, srcIdx, length)
  }

  /**
   * @inheritdocs
   */
  override def set(idx: Int, elem: Int) {
    delegate.set(idx, elem)
  }

  /**
   * @inheritdocs
   */
  override def set(destIdx: Int, src: Array[Int], srcIdx: Int, length: Int) {
    delegate.set(destIdx, src, srcIdx, length)
  }

  /**
   * @inheritdocs
   */
  override def set(destIdx: Int, src: ObservableIntegerArray, srcIdx: Int, length: Int) {
    delegate.set(destIdx, src.delegate, srcIdx, length)
  }

  /**
   * @inheritdocs
   */
  override def toArray(dest: Array[Int]) = delegate.toArray(dest)

  /**
   * @inheritdocs
   */
  override def toArray(srcIdx: Int, dest: Array[Int], length: Int) =
    delegate.toArray(srcIdx, dest, length)

  // ArrayLike[V, T] abstract member function implementations.
  /**
   * Create new builder for this collection.
   *
   * @return New empty $OIA.
   */
  protected[this] override def newBuilder = ObservableIntegerArray.empty
}