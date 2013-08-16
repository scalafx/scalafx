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
import scala.collection.mutable.ArrayLike
import scala.collection.mutable.Builder
import scala.reflect.ClassTag
import scalafx.beans.Observable
import scalafx.delegate.SFXDelegate

/**
 * @define OA `ObservableArray`
 * @define ARY `Array`
 *
 * Abstract base class for observable array subclass companions.
 *
 * @tparam V Value type to be stored in this array.
 * @tparam T Type of this $ARY.
 *
 * @constructor Create new base $OA.
 * @param delegate Wrapped JavaFX $OA instance providing implementation.
 */

private [collections] abstract class ObservableArrayCompanionBase [V :
  ClassTag, T <: ObservableArray [V, T, D], D <: jfxc.ObservableArray [D]] {

  /*
   * Enable implicit conversions, to avoid feature warnings during compilation.
   */
  import scala.language.implicitConversions

  /**
   * Extract a JavaFX's [[$JFXC/ObservableIntegerArray.html
   * ObservableIntegerArray]] from a
   * ScalaFX $OIA.
   *
   * @param oia ScalaFX $OIA.
   * @return JavaFX $OIA inside parameter.
   */
  implicit def sfxObservableArray2jfxObservableArray (oa: T): D = oa.delegate

  /**
   * Create new $OA from a vararg list.
   *
   * @param va Value varargs.
   * @return New $OA storing `ia`
   */
  def apply (va: V*): T

  /**
   * Create new $OA from an existing array.
   *
   * @param av Array to be converted..
   * @return New $OA storing `av`.
   */
  def apply (av: Array [V]): T = apply (av:_*)

  /**
   * Create an observable array with given dimension.
   *
   * @param n Size of the new array.  This value cannot be negative.
   * @return An observable array with the specified dimension and zeroed
   * elements.
   * @throws NegativeArraySizeException if `n` is negative.
   */
  def ofDim (n: Int): T = apply (Array.ofDim (n))

  /**
   * Return an empty $OA
   *
   * @return New empty $OA
   */
  def empty (): T = ofDim (0)

  /**
   * Returns an observable array containing the results of some element
   * computation.
   *
   * Note that `elem` is http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1139computed `n` times in total; it is not calculated
   * once and reused.
   *
   * @param n Int Size of the new array.  If this value is less than 1, an
   * empty array is returned (matching the behavior of Scala's Array [T].fill
   * function).
   * @param elem Computation to be calculated for each element.
   * @return Observable array of size `n`, with each element containing the
   * result of computation `elem`.
   */
  def fill (n: Int)(elem: => V): T = apply (Array.fill (n)(elem))

  /**
   * Returns an array containing the results of some element computation that
   * takes the element index as an argument.
   *
   * @param n Int Size of the new array.  If this value is less than 1, an
   * empty array is returned (matching the behavior of Scala's Array
   * [T].tabulate function).
   * @param f Function to be used to initialize element whose index is passed
   * as an argument.
   * @return Observable array of size `n`, with each element initialized by
   * `f`.
   */
  def tabulate (n: Int)(f: Int => V): T = apply (Array.tabulate (n)(f))

  /**
   * Return an array returning repeated applications of a function to a start
   * value.
   * 
   * @param start Start value of the array.
   * @param n Int Size of the new array.  If this value is less than 1, an
   * empty array is returned (matching the behavior of Scala's Array
   * [T].iterate function).
   * @param f Function to be repeatedly applied to previous element's value.
   * @returns Array containing elements `start, f(start), f(f(start)), ...`.
   */
  def iterate (start: V, n: Int)(f: V => V): T = apply (Array.iterate (start,
    n)(f))
}

/**
 * Companion Object for `[[scalafx.collections.ObservableArray!]]`.
 * 
 * @define OA `ObservableArray`
 * @define JFXC http://docs.oracle.com/javafx/82/api/javafx/collections
 */

object ObservableArray {

  /**
   * Indicates a change in an $OA. It is a simpler version of JavaFX's
   * [[$JFXC/ArrayChangeListener.html `ArrayChangeListener [T]`]].
   * 
   * @constructor Create new instance describing the change detected.
   * 
   * @param sizeChanged `true` if the size of the $OA was changed; `false`
   * otherwise.
   * @param start Index of first element in the array affected by the change.
   * @param end Index of first element in the array unaffected by the change.
   * This value is exclusive of the change and indicates the first unchanged
   * element after start, or the end of the array.
   */
  case class Change (sizeChanged: Boolean, start: Int, end: Int)
}

/**
 * @define OA `ObservableArray`
 * @define ARY `Array`
 *
 * Abstract $OA base class.
 *
 * @tparam V Value type to be stored in this array.
 * @tparam T Type of this $ARY.
 * @tparam D Type of delegated $ARY.
 *
 * @constructor Create new base $OA.
 * @param delegate Wrapped JavaFX $OA instance providing implementation.
 */

abstract class ObservableArray [V : ClassTag, T <: ObservableArray [V, T, D],
  D <: jfxc.ObservableArray [D]] (override val delegate: D)
  extends ArrayLike [V, T]
  with Builder [V, T]
  with Observable
  with SFXDelegate [D] {

  // ObservableArray [D] interface functions, allow class to act like it
  // implements the JavaFX ObservableArray interface, without actually being
  // interchangeable with one.
  /**
   * Shrinks capacity to current length of data in this array.
   */
  def trimToSize () = delegate.trimToSize ()

  /**
   * Grow array capacity if currently smaller than given `capacity`; do nothing
   * otherwise.
   *
   * @param capacity Required capacity.
   */
  def ensureCapacity (capacity: Int) =
    delegate.ensureCapacity (capacity)

  // Observable<X>Array interface functions.  Note: These functions are present
  // in ObservableFloatArray and ObservableIntegerArray, but they are not in
  // ObservableArray [T].
  /**
   * Copy specified portion of this observable array to `dest` regular array.
   *
   * @param srcIdx Start position in this array.
   * @param dest Array into which the portion of this array is to be copied.
   * @param destIdx Start position in the `dest` array.
   * @param length Number of data elements to be copied.
   * @throws java.lang.ArrayIndexOutOfBoundsException if copying would cause
   * access out of either array bounds.
   * @throws java.lang.ArrayStoreException if element in this array could not
   * be stored in `dest` array due to a type mismatch.
   * @throws java.lang.NullPointerException if `dest` is `null`.
   */
  def copyTo (srcIdx: Int, dest: Array [V], destIdx: Int, length: Int): Unit

  /**
   * Copy specified portion of this observable array to `dest` observable
   * array.
   *
   * @param srcIdx Start position in this array.
   * @param dest Array into which the portion of this array is to be copied.
   * @param destIdx Start position in the `dest` array.
   * @param length Number of data elements to be copied.
   * @throws java.lang.ArrayIndexOutOfBoundsException if copying would cause
   * access out of either array bounds.
   * @throws java.lang.ArrayStoreException if element in this array could not
   * be stored in `dest` array due to a type mismatch.
   * @throws java.lang.NullPointerException if `dest` is `null`.
   */
  def copyTo (srcIdx: Int, dest: T, destIdx: Int, length: Int): Unit

  /**
   * Select the element at `idx` in the array.
   *
   * @param idx Index of selected element.
   * @return Element at given `idx`.
   * @throws java.lang.ArrayIndexOutOfBoundsException if `idx` does not satisfy
   * `0 <= idx < length`.
   */
  def get (idx: Int): V

  /**
   * Append given observable array to the end of this array.
   *
   * Capacity is increased, if necessary, to match the new size of the data.
   *
   * @param array Elements to be appended.
   * @throws java.lang.ArrayStoreException if element in `src` array could not
   * be stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `src` is `null`.
   */
  def addAll (src: T): Unit

  /**
   * Append given `elements` to the end of this array.
   *
   * Capacity is increased, if necessary, to match the new size of the data.
   *
   * @param elements Elements to be appended.
   * @throws java.lang.ArrayStoreException if element in `elements` could not
   * be stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `elements` is `null`.
   */
  def addAll (elements: V*): Unit

  /**
   * Append portion of given regular array to the end of this array.
   *
   * Capacity is increased, if necessary, to match the new size of the data.
   *
   * @param src Elements to be appended.
   * @param srcIdx Start position in the `src` array.
   * @param length Number of data elements to be appended.
   * @throws java.lang.ArrayIndexOutOfBoundsException if copying would cause
   * access out of `src` array bounds.
   * @throws java.lang.ArrayStoreException if element in `src` array could not
   * be stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `src` is `null`.
   */
  def addAll (src: Array [V], srcIdx: Int, lenght: Int): Unit

  /**
   * Append portion of given regular array to the end of this array.
   *
   * Capacity is increased, if necessary, to match the new size of the data.
   *
   * @param src Elements to be appended.
   * @param srcIdx Start position in the `src` array.
   * @param length Number of data elements to be appended.
   * @throws java.lang.ArrayIndexOutOfBoundsException if copying would cause
   * access out of `src` array bounds.
   * @throws java.lang.ArrayStoreException if element in `src` array could not
   * be stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `src` is `null`.
   */
  def addAll (src: T, srcIdx: Int, lenght: Int): Unit

  /**
   * Replace the contents of this array with the given `elements`.
   *
   * Capacity is increased, if necessary, to match the new size of the data.
   *
   * @param elements New contents of this array.
   * @throws java.lang.ArrayStoreException if element in `elements` could not
   * be stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `elements` is `null`.
   */
  def setAll (elements: V*): Unit

  /**
   * Replace the contents of this array with the given observable array.
   *
   * Capacity is increased, if necessary, to match the new size of the data.
   *
   * @param src Array to replace contents this array.
   * @throws java.lang.ArrayStoreException if element in `src` could not be
   * stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `src` is `null`.
   */
  def setAll (src: T): Unit

  /**
   * Replace the contents of this array with portion of the given regular
   * array.
   *
   * Capacity is increased, if necessary, to match the new size of the data.
   *
   * @param src Array to replace contents this array.
   * @param srcIdx Start position in the `src` array.
   * @param length Number of data elements to be copied.
   * @throws java.lang.ArrayIndexOutOfBoundsException if copying would cause
   * access out of array bounds.
   * @throws java.lang.ArrayStoreException if element in `src` could not be
   * stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `src` is `null`.
   */
  def setAll (src: Array [V], srcIdx: Int, length: Int): Unit

  /**
   * Replace the contents of this array with portion of the given observable
   * array.
   *
   * Capacity is increased, if necessary, to match the new size of the data.
   *
   * @param src Array to replace contents this array.
   * @param srcIdx Start position in the `src` array.
   * @param length Number of data elements to be copied.
   * @throws java.lang.ArrayIndexOutOfBoundsException if copying would cause
   * access out of array bounds.
   * @throws java.lang.ArrayStoreException if element in `src` could not be
   * stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `src` is `null`.
   */
  def setAll (src: T, srcIdx: Int, length: Int): Unit

  /**
   * Set the element at `idx` in the array to `value`.
   *
   * @param idx Index of element to be changed.
   * @param value New value for element at `idx`.
   * @throws java.lang.ArrayIndexOutOfBoundsException if `idx` does not satisfy
   * `0 <= idx < length`.
   */
  def set (idx: Int, value: V): Unit

  /**
   * Copy a portion of given regular array into this array, replacing affected
   * contents.
   *
   * @param destIdx Start position in this array.
   * @param src Array containing data to be copied.
   * @param srcIdx Start position in `src` array.
   * @param length Number of data elements to be copied
   * @throws java.lang.ArrayIndexOutOfBoundsException if copying would cause
   * access out of array bounds.
   * @throws java.lang.ArrayStoreException if element in `src` could not be
   * stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `src` is `null`.
   */
  def set (destIdx: Int, src: Array [V], srcIdx: Int, length: Int): Unit

  /**
   * Copy a portion of given observable array into this array, replacing
   * affected contents.
   *
   * @param destIdx Start position in this array.
   * @param src Array containing data to be copied.
   * @param srcIdx Start position in `src` array.
   * @param length Number of data elements to be copied
   * @throws java.lang.ArrayIndexOutOfBoundsException if copying would cause
   * access out of array bounds.
   * @throws java.lang.ArrayStoreException if element in `src` could not be
   * stored in this array due to a type mismatch.
   * @throws java.lang.NullPointerException if `src` is `null`.
   */
  def set (destIdx: Int, src: T, srcIdx: Int, length: Int): Unit

  /**
   * Translate this observable array to a regular array.
   *
   * @return Regular array containing this array's contents.
   */
  def toArray: Array [V] = toArray (null.asInstanceOf [Array [V]])

  /**
   * Write the contents of this array into the specified array, if it is large
   * enough, or a new array if it is not.
   *
   * @param dest Array into which this array will be written, if large enough
   * to hold this array's contents.  If `null`, this argument is ignored.
   * @return The `dest` array if it is large enough to hold this array's data,
   * or a new array, containing this array's copied contents.
   * @throws java.lang.ArrayStoreException if element in `src` could not be
   * stored in this array due to a type mismatch.
   */
  def toArray (dest: Array [V]): Array [V]

  /**
   * Write a portion of this array's contents into the specified array, if it
   * is large enough, or a new array if it is not.
   *
   * @param srcIdx Start position in this array.
   * @param dest Array into which this array will be written, if large enough
   * to hold this array's contents.  If `null`, this argument is ignored.
   * @param length Number of data elements to be copied.
   * @return The `dest` array if it is large enough to hold this array's data,
   * or a new array, containing this array's copied contents.
   * @throws java.lang.ArrayStoreException if element in `src` could not be
   * stored in this array due to a type mismatch.
   */
  def toArray (srcIdx: Int, dest: Array [V], length: Int): Array [V]

  // ArrayLike [V, T] abstract member function implementations.
  /**
   * Select an element by its index in the array.
   *
   * @param idx Index of selected element.
   * @return Element at given `idx`.
   * @throws java.lang.ArrayIndexOutOfBoundsException if `idx` does not satisfy
   * `0 <= idx < length`.
   */
  def apply (idx: Int) = get (idx)

  /**
   * Set the element at `idx` in the array to `value`.
   *
   * @param idx Index of element to be changed.
   * @param value New value for element at `idx`.
   * @throws java.lang.ArrayIndexOutOfBoundsException if `idx` does not satisfy
   * `0 <= idx < length`.
   */
  def update (idx: Int, value: V) = set (idx, value)

  /**
   * Retrieve length of data in this array.
   *
   * @return Length of data in this array.
   */
  override def size = delegate.size

  /**
   * Retrieve length of data in this array.
   *
   * @return Length of data in this array.
   */
  override def length = size

  /**
   * Convert to a sequence in which all elements are implemented sequentially.
   *
   * @return Sequence with contents of this array.
   */
  override def seq = toArray.seq

  // Builder [V, T] abstract member function implementations.
  /**
   * Empty array, clearing builder contents, resizing it to zero.
   *
   * Capacity is unchanged.
   */
  override def clear () = delegate.clear ()

  /**
   * Add a listener function to $ARY's changes.
   * 
   * @note This function '''will handle''' this array's modifications data.
   * This is, it will be notified which array has been modified and which array
   * 
   * @param op Function that will handle this $OA's modifications data,
   * to be activated when some change is made.
   */

  import ObservableArray.Change
  def onChange (op: (T, Change) => Unit): Unit = {
    delegate.addListener {
      new jfxc.ArrayChangeListener [D] {
        override def onChanged (array: D, sizeChanged: Boolean, start: Int,
          end: Int) {
          op (ObservableArray.this.asInstanceOf [T], Change (sizeChanged,
            start, end))
        }
      }
    }
  }

  /**
   * Add a listener function to $ARY's changes.
   * 
   * @note This function '''will handle''' this array's modifications data.
   *
   * @param op Function that will handle this $OA's modifications data,
   * to be activated when some change is made.
   */

  import ObservableArray.Change
  def onChange (op: => Unit): Unit = {
    delegate.addListener {
      new jfxc.ArrayChangeListener [D] {
        override def onChanged (array: D, sizeChanged: Boolean, start: Int,
          end: Int) {
          op
        }
      }
    }
  }
}