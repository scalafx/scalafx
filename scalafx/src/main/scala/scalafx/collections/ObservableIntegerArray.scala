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
 * Companion Object for [[scalafx.collections.ObservableIntegerArray!]].
 *
 * @define OIA `ObservableIntegerArray`
 * @define ARY `Array`
 * @define JFXC http://docs.oracle.com/javafx/8/api/javafx/collections
 */
object ObservableIntegerArray {

  /**
   * Extract a JavaFX's [[$JFXC/ObservableIntegerArray.html
   * ObservableIntegerArray]] from a
   * ScalaFX $OIA.
   *
   * @param oia ScalaFX $OIA.
   * @return JavaFX $OIA inside parameter.
   */
  implicit def sfxObservableIntegerArray2jfxObservableIntegerArray (oia:
    ObservableIntegerArray) = oia.delegate

  /**
   * Return an empty $OIA
   *
   * @return New empty $OIA
   */
  def empty = ofDim (0)

  /**
   * Create new $OIA from an existing Array [Int].
   *
   * @param ai Array [Int] to be converted..
   * @return New $OIA storing `ai`.
   */
  def apply (ai: Array [Int]) =
    new ObservableIntegerArray (jfxc.FXCollections.observableIntegerArray
      (ai:_*))

  /**
   * Create new $OIA from a list of Int vararg.
   *
   * @param iva Integer varargs.
   * @return New $OIA storing `iva`
   */
  def apply (iva: Int*) =
    new ObservableIntegerArray (jfxc.FXCollections.observableIntegerArray
      (iva:_*))

  /**
   * Create an array with given dimension.
   *
   * @param n Size of the new array.
   * @return An observable array with the specified dimension and zeroed
   * elements.
   */
  def ofDim (n: Int) = new ObservableIntegerArray (n)

   /**
    * Returns an observable array containing the results of some element
    * computation.
    *
    * Note that `elem` is computed `n` times in total; it is not calculated
    * once and reused.
    *
    * @param n Int Size of the new array.
    * @param elem Computation to be calculated for each element.
    * @return Observable array of size `n`, with each element containing the
    * result of computation `elem`.
    */
  def fill (n: Int)(elem: => Int) = apply (Array.fill (n)(elem))

   /**
    * Returns an array containing the results of some element computation that
    * takes the element index as an argument.
    *
    * @param n Int Size of the new array.
    * @param f Function to be used to initialize element whose index is passed
    * as an argument.
    * @return Observable array of size `n`, with each element initialized by
    * `f`.
    */
  def tabulate (n: Int)(f: Int => Int) = apply (Array.tabulate (n)(f (_)))
}

/**
 * @define OIA `ObservableIntegerArray`
 * @define ARY `Array`
 * @define JFXC http://docs.oracle.com/javafx/8/api/javafx/collections
 *
 * Wrapper class to JavaFX's [[$JFXC/ObservableIntegerArray.html
 * ObservableIntegerArray]].
 *
 * @param delegate Wrapped JavaFX $OIA providing implementation.
 */
class ObservableIntegerArray private [collections] (delegate:
    jfxc.ObservableIntegerArray = ObservableIntegerArray.empty)
  extends ObservableArray [Int, ObservableIntegerArray,
    jfxc.ObservableIntegerArray] (delegate) {

  /**
   * Create $OIA with specified capacity.
   *
   * Elements will be zeroed out.
   *
   * @param size Size of new $OIA
   */
  def this (size: Int) = this (jfxc.FXCollections.observableIntegerArray
    (new Array [Int] (size):_*))


  // ObservableIntegerArray interface functions, allow class to act like it
  // implements the JavaFX ObservableIntegerArray interface, without actually
  // being interchangeable with one.
  /**
   * @inheritdocs
   */
  override def copyTo (srcIdx: Int, dest: Array [Int], destIdx: Int, length:
    Int) = delegate.copyTo (srcIdx, dest, destIdx, length)

  /**
   * @inheritdocs
   */
  override def copyTo (srcIdx: Int, dest: ObservableIntegerArray, destIdx: Int,
    length: Int) =
      delegate.copyTo (srcIdx, dest.delegate, destIdx, length)

  /**
   * @inheritdocs
   */
  override def get (idx: Int) = delegate.get (idx)

  /**
   * @inheritdocs.
   */
  override def addAll (elements: Int*) = delegate.addAll (elements:_*)

  /**
   * @inheritdocs.
   */
  override def addAll (src: ObservableIntegerArray) =
    delegate.addAll (src.delegate)

  /**
   * @inheritdocs.
   */
  override def addAll (src: Array [Int], srcIdx: Int, length: Int) =
    delegate.addAll (src, srcIdx, length)

  /**
   * @inheritdocs.
   */
  override def addAll (src: ObservableIntegerArray, srcIdx: Int, length: Int) =
    delegate.addAll (src.delegate, srcIdx, length)

  /**
   * @inheritdocs.
   */
  override def setAll (elements: Int*) = delegate.setAll (elements:_*)

  /**
   * @inheritdocs.
   */
  override def setAll (src: ObservableIntegerArray) =
    delegate.setAll (src.delegate)

  /**
   * @inheritdocs.
   */
  override def setAll (src: Array [Int], srcIdx: Int, length: Int) =
    delegate.setAll (src, srcIdx, length)

  /**
   * @inheritdocs.
   */
  override def setAll (src: ObservableIntegerArray, srcIdx: Int, length: Int) =
    delegate.setAll (src.delegate, srcIdx, length)

  /**
   * @inheritdocs
   */
  override def set (idx: Int, elem: Int) = delegate.set (idx, elem)

  /**
   * @inheritdocs
   */
  override def set (destIdx: Int, src: Array [Int], srcIdx: Int, length: Int) =
    delegate.set (destIdx, src, srcIdx, length)

  /**
   * @inheritdocs
   */
  override def set (destIdx: Int, src: ObservableIntegerArray, srcIdx: Int,
    length: Int) = delegate.set (destIdx, src.delegate, srcIdx, length)

  /**
   * @inheritdocs
   */
  override def toArray (dest: Array [Int]) = delegate.toArray (dest)

  /**
   * @inheritdocs
   */
  override def toArray (srcIdx: Int, dest: Array [Int], length: Int) =
    delegate.toArray (srcIdx, dest, length)

  // ArrayLike [V, T] abstract member function implementations.
  /**
   * Create new builder for this collection.
   *
   * @return New empty $OIA.
   */
  protected [this] override def newBuilder = ObservableIntegerArray.empty

  // Builder [V, T] abstract member function implementations.
  /**
   * Produces collection from builder.
   *
   * @return This $OIA.
   */
  override def result () = this

  /**
   * Add new element to this $OIA.
   *
   * @param elem Element to be added to end of this array.
   * @return This $OIA.
   */
  override def += (elem: Int) = {
    delegate.addAll (elem)
    this
  }
}