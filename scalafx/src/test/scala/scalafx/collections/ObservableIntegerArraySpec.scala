/*
 * Copyright (c) 2011-2020, ScalaFX Project
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
import scalafx.Includes._
import scalafx.collections.ObservableArray.Change
import scalafx.testutil.SimpleSFXDelegateSpec

import scala.collection.mutable.Buffer

/**
 * ObservableIntegerArray Spec tests.
 */
class ObservableIntegerArraySpec
  extends SimpleSFXDelegateSpec[jfxc.ObservableIntegerArray, ObservableIntegerArray](
    classOf[jfxc.ObservableIntegerArray], classOf[ObservableIntegerArray]
  ) {

  /**
   * Test trait for instance testing.
   */

  trait InstanceTests {
    val array0: Array[Int] = Array.empty
    val array1 = Array(4, 5, 6, 7)
    val array2 = Array(8, 9, 10, 11, 12)
    val instance0 = ObservableIntegerArray(array0)
    val instance1 = ObservableIntegerArray(array1)
    val instance2 = ObservableIntegerArray(array2)
    val change = Buffer.empty[(ObservableIntegerArray, Change)]
    var changes = 0
    def onChangeFull(a: ObservableIntegerArray, c: Change): Unit = {
      change += ((a, c))
    }

    def onChangeBrief(): Unit = {
      changes += 1
    }
    instance0.onChange(onChangeFull(_, _))
    instance0.onChange(onChangeBrief())
    instance1.onChange(onChangeFull(_, _))
    instance1.onChange(onChangeBrief())
    instance2.onChange(onChangeFull(_, _))
    instance2.onChange(onChangeBrief())

    def verifyChange(n: Int, array: ObservableIntegerArray, sizeChanged: Boolean, start: Int, end: Int): Unit = {
      val (a, c) = change(n)
      assert(a eq array)
      assert(c.sizeChanged === sizeChanged)
      assert(c.start === start)
      assert(c.end === end)
    }
  }

  /**
   * @inheritdoc
   *
   * Overridden to create empty JFX ObservableIntegerArray (inherited method fails).
   */
  override protected def getJavaClassInstance = jfxc.FXCollections.observableIntegerArray()

  /**
   * Test that a function to access/change an array element with an invalid index yields an out of bounds exception.
   */
  def testOutOfBoundsExceptionThrown(f: => Unit): Unit = {
    intercept[ArrayIndexOutOfBoundsException] {
      f
    }
  }

  /**
   * Test that a function results in an NegativeArraySizeException being thrown.
   */
  def testNegativeArraySizeExceptionThrown(f: => Unit): Unit = {
    intercept[NegativeArraySizeException] {
      f
    }
  }

  /**
   * Test that a function results in an IllegalArgumentException being thrown.
   */
  def testIllegalArgumentExceptionThrown(f: => Unit): Unit = {
    intercept[IllegalArgumentException] {
      f
    }
  }

  /**
   * Common tests for an empty array.
   */
  def testEmpty(oa: ObservableIntegerArray): Unit = {
    assert(oa.length === 0)
    assert(oa.size === 0)
    assert(oa.isEmpty === true)
    testOutOfBoundsExceptionThrown(oa(-1))
    testOutOfBoundsExceptionThrown(oa(0))
    testOutOfBoundsExceptionThrown(oa(1))
  }

  /**
   * Common tests for a non-empty array with known contents.
   */
  def testNonEmpty(oa: ObservableIntegerArray, expected: Array[Int]): Unit = {
    assert(oa.length === expected.length)
    assert(oa.size === expected.length)
    assert(oa.isEmpty === false)
    testOutOfBoundsExceptionThrown(oa(-1))
    for (i <- 0 until expected.length) {
      assert(oa(i) === expected(i))
    }
    testOutOfBoundsExceptionThrown(oa(expected.length))
  }

  /**
   * Test that arrays are equal.
   */
  def testEqual(oa: ObservableIntegerArray, expected: ObservableIntegerArray): Unit = {
    assert(oa.length === expected.length)
    assert(oa.size === expected.length)
    assert(oa.isEmpty === false)
    for (i <- 0 until expected.length) {
      assert((oa(i) - expected(i)).abs < 1.0e-6f)
    }
  }


  /**
   * Class tests.
   */
  it should "allow construct an empty array by default" in {
    testEmpty(new ObservableIntegerArray())
  }
  it should "allow construction of empty array" in {
    testEmpty(new ObservableIntegerArray(0))
  }
  it should "not allow construction of array of negative dimension" in {
    testNegativeArraySizeExceptionThrown(new ObservableIntegerArray(-1))
  }
  it should "allow construction of dimensioned array with zeroed elements" in {
    testNonEmpty(new ObservableIntegerArray(1), new Array(1))
    testNonEmpty(new ObservableIntegerArray(10), new Array(10))
  }
  it should "allow its elements to be retrieved correctly" in {
    new InstanceTests {
      testEmpty(instance0)
      testNonEmpty(instance1, array1)
      testNonEmpty(instance2, array2)
      assert(change.size === 0)
      assert(changes === 0)
    }
  }
  it should "report its size correctly" in {
    new InstanceTests {
      assert(instance0.size === array0.size)
      assert(instance1.size === array1.size)
      assert(instance2.size === array2.size)
      assert(change.size === 0)
      assert(changes === 0)
    }
  }
  it should "allow the array to be resized and report changes" in {
    new InstanceTests {
      testNegativeArraySizeExceptionThrown(instance0.resize(-1))
      testEmpty(instance0)
      instance0.resize(3) // Notification 0
      testNonEmpty(instance0, Array(0, 0, 0))
      instance0.resize(3) // No notification - nothing was changed.
      instance1.resize(0) // Notification 1
      testEmpty(instance1)
      instance2.resize(1) // Notification 2
      testNonEmpty(instance2, Array(array2(0)))
      instance2.resize(4) // Notification 3
      testNonEmpty(instance2, Array(array2(0), 0, 0, 0))
      assert(change.size === 4)
      verifyChange(0, instance0, true, 0, 3) // Elements 0 through 2 added.
      verifyChange(1, instance1, true, 0, 0) // All elements cleared.
      verifyChange(2, instance2, true, 1, 1) // Elements 1 through 4 removed.
      verifyChange(3, instance2, true, 1, 4) // Elements 1 through 3 added.
      assert(changes === 4)
    }
  }
  it should "allow its capacity to be trimmed to its size" in {
    // It appears there's no way to determine the capacity of an observable array, so we cannot verify that this works.
    // However, we can check that nothing bad happens.
    new InstanceTests {
      instance0.trimToSize()
      assert(instance0.size === array0.size)
      instance1.trimToSize()
      assert(instance1.size === array1.size)
      instance2.trimToSize()
      assert(instance2.size === array2.size)
      assert(change.size === 0)
      assert(changes === 0)
    }
  }
  it should "allow its contents to be cleared" in {
    new InstanceTests {
      instance0.clear() // No notification - nothing was changed
      testEmpty(instance0)
      instance1.clear() // Notification 0
      testEmpty(instance1)
      // Repeat - make sure nothing unexpected happens.
      instance1.clear() // No notification - nothing was changed
      testEmpty(instance1)
      instance2.clear() // Notification 1
      testEmpty(instance2)
      assert(change.size === 2)
      verifyChange(0, instance1, true, 0, 0)
      verifyChange(1, instance2, true, 0, 0)
      assert(changes === 2)
    }
  }
  it should "allow its capacity to be ensured" in {
    // It appears there's no way to determine the capacity of an observable
    // array, so we cannot verify that this works.  However, we can check that
    // nothing bad happens.
    new InstanceTests {
      instance0.ensureCapacity(10)
      testEmpty(instance0)
      instance0.ensureCapacity(0)
      testEmpty(instance0)
      instance1.ensureCapacity(1)
      testNonEmpty(instance1, array1)
      // Repeat - make sure nothing unexpected happens.
      instance1.ensureCapacity(10)
      testNonEmpty(instance1, array1)
      // Test unusual values
      instance2.ensureCapacity(-1)
      testNonEmpty(instance2, array2)
      instance2.ensureCapacity(0)
      testNonEmpty(instance2, array2)
      assert(change.size === 0)
      assert(changes === 0)
    }
  }
  it should "allow individual elements to be modified and report changes" in {
    new InstanceTests {
      testOutOfBoundsExceptionThrown(instance0(-1) = 0)
      testOutOfBoundsExceptionThrown(instance0(0) = 0)
      testOutOfBoundsExceptionThrown(instance1(-1) = 0)
      instance1(0) = 0 // Notification 0
      instance1(2) = 1 // Notification 1
      instance1(3) = 2 // Notification 2
      testOutOfBoundsExceptionThrown(instance1(4) = 2)
      testNonEmpty(instance1, Array(0, array1(1), 1, 2))
      assert(change.size === 3)
      verifyChange(0, instance1, false, 0, 1)
      verifyChange(1, instance1, false, 2, 3)
      verifyChange(2, instance1, false, 3, 4)
    }
  }

  /**
   * Companion tests.
   */
  it should "return an empty observable array from companion's empty()" in {
    testEmpty(ObservableIntegerArray.empty())
  }
  it should "not allow a negative dimension array from companion's ofDim(size)" in {
    testNegativeArraySizeExceptionThrown(new ObservableIntegerArray(-1))
  }
  it should "return a dimension array of zeroed elements from companion's ofDim(size)" in {
    testNonEmpty(ObservableIntegerArray.ofDim(1), new Array(1))
    testNonEmpty(ObservableIntegerArray.ofDim(10), new Array(10))
  }
  it should "return valid array from companion's apply(values*)" in {
    testEmpty(ObservableIntegerArray())
    testNonEmpty(ObservableIntegerArray(1), Array(1))
    testNonEmpty(ObservableIntegerArray(0, 1, 2, 3, 4), Array(0, 1, 2, 3, 4))
  }
  it should "return valid array from companion's apply(Array)" in {
    testEmpty(ObservableIntegerArray(Array[Int]()))
    val arrays = List(Array(1), Array(0, 1, 2, 3, 4))
    arrays.foreach(array => testNonEmpty(ObservableIntegerArray(array), array))
  }
  it should "return valid initialized array from companion's fill(n)(f)" in {
    def fillArray(n: Int): ObservableIntegerArray = {
      var lastVal = 0
      def initVal: Int = {
        lastVal += 1
        lastVal
      }
      val oa = ObservableIntegerArray.fill(n)(initVal)
      testOutOfBoundsExceptionThrown(oa(-1))
      testOutOfBoundsExceptionThrown(oa(n))
      oa
    }
    testEmpty(fillArray(-1))
    testEmpty(fillArray(0))
    testNonEmpty(fillArray(1), Array(1))
    testNonEmpty(fillArray(5), Array(1, 2, 3, 4, 5))
  }
  it should "return valid initialized array from companion's tabulate(n)(f)" in {
    def tabulateArray(n: Int): ObservableIntegerArray = {
      val oa = ObservableIntegerArray.tabulate(n)(_ + 1)
      testOutOfBoundsExceptionThrown(oa(-1))
      testOutOfBoundsExceptionThrown(oa(n))
      oa
    }
    testEmpty(tabulateArray(-1))
    testEmpty(tabulateArray(0))
    testNonEmpty(tabulateArray(1), Array(1))
    testNonEmpty(tabulateArray(5), Array(1, 2, 3, 4, 5))
  }
  it should "return valid initialized array from companion's iterate(start, length)(f)" in {
    testEmpty(ObservableIntegerArray.iterate(0, -1)(_ + 1))
    testEmpty(ObservableIntegerArray.iterate(0, 0)(_ + 1))
    testNonEmpty(ObservableIntegerArray.iterate(0, 1)(_ + 1), Array(0))
    testNonEmpty(ObservableIntegerArray.iterate(0, 5)(_ + 1), Array(0, 1, 2, 3, 4))
  }
  it should "return valid initialized array from companion's range(start, end)" in {
    testIllegalArgumentExceptionThrown(ObservableIntegerArray.range(1, 2, 0))
    testEmpty(ObservableIntegerArray.range(1, 0))
    testEmpty(ObservableIntegerArray.range(1, 0, 1))
    testEmpty(ObservableIntegerArray.range(1, 1))
    testEmpty(ObservableIntegerArray.range(1, 1, 1))
    testNonEmpty(ObservableIntegerArray.range(1, 2, 2), Array(1))
    testEmpty(ObservableIntegerArray.range(1, 2, -1))
    testEmpty(ObservableIntegerArray.range(1, 1, -1))
    testNonEmpty(ObservableIntegerArray.range(1, 0, -2), Array(1))
    val a123 = Array(1, 2, 3)
    testNonEmpty(ObservableIntegerArray.range(1, 4), a123)
    testNonEmpty(ObservableIntegerArray.range(1, 4, 1), a123)
    testNonEmpty(ObservableIntegerArray.range(3, 0, -1), Array(3, 2, 1))
    val a135 = Array(1, 3, 5)
    testNonEmpty(ObservableIntegerArray.range(1, 6, 2), a135)
    testNonEmpty(ObservableIntegerArray.range(1, 7, 2), a135)
    val a531 = Array(5, 3, 1)
    testNonEmpty(ObservableIntegerArray.range(5, 0, -2), a531)
    testNonEmpty(ObservableIntegerArray.range(5, -1, -2), a531)
  }


  it should "support element access through (i) operator" in {
    val a = ObservableIntegerArray(1, 2, 3, 4, 5)
    val v = a(2)
    assert(v === 3)
  }

  it should "support element assignment through (i) operator" in {
    val a = ObservableIntegerArray(1, 2, 3, 4, 5)
    a(2) = 13
    val v = a(2)
    assert(v === 13)
    testEqual(a, ObservableIntegerArray(1, 2, 13, 4, 5))
  }

  it should "support operator +=" in {
    val a = ObservableIntegerArray(1, 2, 3, 4, 5)
    assert(a.length === 5)
    a += 13
    assert(a.length === 6)
    assert(a(5) === 13)
    testEqual(a, ObservableIntegerArray(1, 2, 3, 4, 5, 13))
  }

  it should "support operator ++= Array[Float](...)" in {
    val a = ObservableIntegerArray(1, 2, 3, 4, 5)
    (a.length === 5)
    a ++= Array(13, 42)
    a.length === 7
    assert(a(6) === 42)
    testEqual(a, ObservableIntegerArray(1, 2, 3, 4, 5, 13, 42))
  }

  it should "support operator ++= ObservableFloatArray(...)" in {
    val a = ObservableIntegerArray(1, 2, 3, 4, 5)
    assert(a.length === 5)
    a ++= ObservableIntegerArray(13, 42)
    assert(a.length === 7)
    assert(a(6) === 42)
    testEqual(a, ObservableIntegerArray(1, 2, 3, 4, 5, 13, 42))
  }

}