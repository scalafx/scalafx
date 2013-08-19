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
import scala.reflect.ClassTag

/*
 * Enable implicit conversions, to avoid feature warnings during compilation.
 */
import scala.language.implicitConversions

/**
 * @define OA `ObservableArray`
 * @define ARY `Array`
 *
 * Abstract base class for observable array subclass companion objects.
 *
 * @tparam V Value type to be stored in this array.
 * @tparam T Type of this ScalaFX $ARY.
 * @tparam D Type of the delegated JavaFX $ARY.
 *
 * @constructor Create new base $OA.
 * @param delegate Wrapped JavaFX $OA instance providing implementation.
 */

private[collections] abstract class ObservableArrayCompanionBase[V : ClassTag, T <: ObservableArray[V, T, D],
  D <: jfxc.ObservableArray[D]] {

  // TODO: Enter link when JavaFX 8 API Docs are available on-line.
  /**
   * Extract a JavaFX $OA from a ScalaFX $OA.
   *
   * @param oa ScalaFX $OA.
   * @return JavaFX $OA inside parameter.
   */
  implicit def sfxObservableArray2jfxObservableArray(oa: T): D = oa.delegate

  /**
   * Create new $OA from a vararg list.
   *
   * @param va Value varargs.
   * @return New $OA storing `ia`
   */
  def apply(v: V*): T

  /**
   * Create new $OA from an existing array.
   *
   * @param av Array to be converted..
   * @return New $OA storing `av`.
   */
  def apply(a: Array[V]): T = apply(a:_*)

  /**
   * Create an observable array with given dimension.
   *
   * @param n Size of the new array.  This value cannot be negative.
   * @return An observable array with the specified dimension and zeroed elements.
   * @throws NegativeArraySizeException if `n` is negative.
   */
  def ofDim(n: Int): T = apply(Array.ofDim(n))

  /**
   * Return an empty $OA
   *
   * @return New empty $OA
   */
  def empty(): T = ofDim(0)

  /**
   * Returns an observable array containing the results of some element computation.
   *
   * Note that `elem` is computed `n` times in total; it is not simply calculated once and reused.
   *
   * @param n Size of the new array.  If this value is less than 1, an empty array is returned (matching the behavior
   * of Scala's Array[T].fill function).
   * @param elem Computation to be calculated for each element.
   * @return Observable array of size `n`, with each element containing the result of computation `elem`.
   */
  def fill(n: Int)(elem: => V): T = apply(Array.fill(n)(elem))

  /**
   * Returns an array containing the results of some element computation that takes the element index as an argument.
   *
   * @param n Size of the new array.  If this value is less than 1, an empty array is returned (matching the behavior
   * of Scala's Array[T].tabulate function).
   * @param f Function to be used to initialize element whose index is passed as an argument.
   * @return Observable array of size `n`, with each element initialized by `f`.
   */
  def tabulate(n: Int)(f: Int => V): T = apply(Array.tabulate(n)(f))

  /**
   * Return an array returning repeated applications of a function to a start value.
   * 
   * @param start Start value of the array.
   * @param n Size of the new array.  If this value is less than 1, an empty array is returned (matching the behavior
   * of Scala's Array[T].iterate function).
   * @param f Function to be repeatedly applied to previous element's value.
   * @return Array containing elements `start, f(start), f(f(start)), ...`.
   */
  def iterate(start: V, n: Int)(f: V => V): T = apply(Array.iterate(start, n)(f))
}