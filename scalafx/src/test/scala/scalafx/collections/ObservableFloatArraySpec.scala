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

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FunSpec

import javafx.{collections => jfxc}
import scala.collection.mutable.Buffer
import scalafx.testutil.SimpleSFXDelegateSpec
import scalafx.Includes._
import scalafx.collections.ObservableArray.Change

/**
 * ObservableFloatArray Spec tests.
 */
@RunWith(classOf[JUnitRunner])
class ObservableFloatArraySpec
  extends SimpleSFXDelegateSpec[jfxc.ObservableFloatArray, ObservableFloatArray](classOf[jfxc.ObservableFloatArray],
    classOf[ObservableFloatArray]) {

  /**
   * Test trait for instance testing.
   */
  
  trait InstanceTests {
    val array0: Array[Float] = Array.empty
    val array1 = Array(4.0f, 5.0f, 6.0f, 7.0f)
    val array2 = Array(8.0f, 9.0f, 10.0f, 11.0f, 12.0f)
    val instance0 = ObservableFloatArray(array0)
    val instance1 = ObservableFloatArray(array1)
    val instance2 = ObservableFloatArray(array2)
    val change = Buffer.empty[(ObservableFloatArray, Change)]
    var changes = 0
    def onChangeFull(a: ObservableFloatArray, c: Change) {
      change += ((a, c))
    }
    def onChangeBrief() {
      changes += 1
    }
    instance0.onChange(onChangeFull(_, _))
    instance0.onChange(onChangeBrief)
    instance1.onChange(onChangeFull(_, _))
    instance1.onChange(onChangeBrief)
    instance2.onChange(onChangeFull(_, _))
    instance2.onChange(onChangeBrief)
    def verifyChange(n: Int, array: ObservableFloatArray, sizeChanged:
      Boolean, start: Int, end: Int) {
      val (a, c) = change(n)
      assert(a eq array)
      assert(c.sizeChanged === sizeChanged)
      assert(c.start === start)
      assert(c.end === end)
    }
  }

  /**
   * @inheritdocs
   * 
   * Overridden to create empty SFX ObservableFloatArray (inherited method
   * fails).
   */
  override protected def getScalaClassInstance = new ObservableFloatArray()

  /**
   * @inheritdocs
   * 
   * Overridden to create empty JFX ObservableFloatArray (inherited method fails).
   */
  override protected def getJavaClassInstance = jfxc.FXCollections.observableFloatArray()

  /**
   * Test that a function to access/change an array element with an invalid index yields an out of bounds exception.
   */
  def testOutOfBoundsExceptionThrown(f: => Unit) {
    intercept[ArrayIndexOutOfBoundsException] {
      f
    }
  }

  /**
   * Test that a function results in an NegativeArraySizeException being thrown.
   */
  def testNegativeArraySizeExceptionThrown(f: => Unit) {
    intercept[NegativeArraySizeException] {
      f
    }
  }

  /**
   * Test that a function results in an IllegalArgumentException being thrown.
   */
  def testIllegalArgumentExceptionThrown(f: => Unit) {
    intercept[IllegalArgumentException] {
      f
    }
  }
  /**
   * Common tests for an empty array.
   */
  def testEmpty(oa: ObservableFloatArray) {
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
  def testNonEmpty(oa: ObservableFloatArray, expected: Array[Float]) {
    assert(oa.length === expected.length)
    assert(oa.size === expected.length)
    assert(oa.isEmpty === false)
    testOutOfBoundsExceptionThrown(oa(-1))
    for (i <- 0 until expected.length) {
      assert((oa(i) - expected(i)).abs < 1.0e-6f)
    }
    testOutOfBoundsExceptionThrown(oa(expected.length))
  }

  /**
   * Class tests.
   */
  it should "allow construct an empty array by default" in {
    testEmpty(new ObservableFloatArray())
  }
  it should "allow construction of empty array" in {
    testEmpty(new ObservableFloatArray(0))
  }
  it should "not allow construction of array of negative dimension" in {
    testNegativeArraySizeExceptionThrown(new ObservableFloatArray(-1))
  }
  it should "allow construction of dimensioned array with zeroed elements" in {
    testNonEmpty(new ObservableFloatArray(1), new Array(1))
    testNonEmpty(new ObservableFloatArray(10), new Array(10))
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
      testNonEmpty(instance0, Array(0.0f, 0.0f, 0.0f))
      instance0.resize(3) // No notification - nothing was changed.
      instance1.resize(0) // Notification 1
      testEmpty(instance1)
      instance2.resize(1) // Notification 2
      testNonEmpty(instance2, Array(array2(0)))
      instance2.resize(4) // Notification 3
      testNonEmpty(instance2, Array(array2(0), 0.0f, 0.0f, 0.0f))
      assert(change.size === 4)
      verifyChange(0, instance0, true, 0, 3)  // Elements 0 through 2 added.
      verifyChange(1, instance1, true, 0, 0)  // All elements cleared.
      verifyChange(2, instance2, true, 1, 1)  // Elements 1 through 4 removed.
      verifyChange(3, instance2, true, 1, 4)  // Elements 1 through 3 added.
      assert(changes === 4)
    }
  }
  it should "allow its capacity to be trimmed to its size" in {
    // It appears there's no way to determine the capacity of an observable
    // array, so we cannot verify that this works.  However, we can check that
    // nothing bad happens.
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
      instance0.clear()    // No notification - nothing was changed
      testEmpty(instance0)
      instance1.clear()    // Notification 0
      testEmpty(instance1)
      // Repeat - make sure nothing unexpected happens.
      instance1.clear()    // No notification - nothing was changed
      testEmpty(instance1)
      instance2.clear()    // Notification 1
      testEmpty(instance2)
      assert(change.size === 2)
      verifyChange(0, instance1, true, 0, 0)
      verifyChange(1, instance2, true, 0, 0)
      assert(changes === 2)
    }
  }
  it should "allow its capacity to be ensured" in {
    // It appears there's no way to determine the capacity of an observable array, so we cannot verify that this works.
    // However, we can check that nothing bad happens.
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

  /**
   * Companion tests.
   */
  it should "return an empty observable array from companion's empty()" in {
    testEmpty(ObservableFloatArray.empty())
  }
  it should "not allow a negative dimension array from companion's ofDim(size)" in {
    testNegativeArraySizeExceptionThrown(new ObservableFloatArray(-1))
  }
  it should "return a dimension array of zeroed elements from companion's ofDim(size)" in {
    testNonEmpty(ObservableFloatArray.ofDim(1), new Array(1))
    testNonEmpty(ObservableFloatArray.ofDim(10), new Array(10))
  }
  it should "return valid array from companion's apply(values*)" in {
    testEmpty(ObservableFloatArray())
    testNonEmpty(ObservableFloatArray(1.0f), Array(1.0f))
    testNonEmpty(ObservableFloatArray(0.0f, 1.0f, 2.0f, 3.0f, 4.0f), Array(0.0f, 1.0f, 2.0f, 3.0f, 4.0f))
  }
  it should "return valid array from companion's apply(Array)" in {
    testEmpty(ObservableFloatArray(Array[Float]()))
    val arrays = List(Array(1.0f), Array(0.0f, 1.0f, 2.0f, 3.0f, 4.0f))
    arrays.foreach (array => testNonEmpty(ObservableFloatArray(array), array))
  }
  it should "return valid initialized array from companion's fill(n)(f)" in {
    def fillArray(n: Int): ObservableFloatArray = {
      var lastVal = 0.0f
      def initVal: Float = {
        lastVal += 1.0f
        lastVal
      }
      val oa = ObservableFloatArray.fill(n)(initVal)
      testOutOfBoundsExceptionThrown(oa(-1))
      testOutOfBoundsExceptionThrown(oa(n))
      oa
    }
    testEmpty(fillArray(-1))
    testEmpty(fillArray(0))
    testNonEmpty(fillArray(1), Array(1.0f))
    testNonEmpty(fillArray(5), Array(1.0f, 2.0f, 3.0f, 4.0f, 5.0f))
  }
  it should "return valid initialized array from companion's tabulate(n)(f)" in {
    def tabulateArray(n: Int): ObservableFloatArray = {
      val oa = ObservableFloatArray.tabulate(n)(_ + 1.0f)
      testOutOfBoundsExceptionThrown(oa(-1))
      testOutOfBoundsExceptionThrown(oa(n))
      oa
    }
    testEmpty(tabulateArray(-1))
    testEmpty(tabulateArray(0))
    testNonEmpty(tabulateArray(1), Array(1.0f))
    testNonEmpty(tabulateArray(5), Array(1.0f, 2.0f, 3.0f, 4.0f, 5.0f))
  }
  it should "return valid initialized array from companion's iterate(start, length)(f)" in {
    testEmpty(ObservableFloatArray.iterate(0.0f, -1)(_ + 1.0f))
    testEmpty(ObservableFloatArray.iterate(0.0f, 0)(_ + 1.0f))
    testNonEmpty(ObservableFloatArray.iterate(0.0f, 1)(_ + 1.0f), Array(0.0f))
    testNonEmpty(ObservableFloatArray.iterate(0.0f, 5)(_ + 1.0f), Array(0.0f, 1.0f, 2.0f, 3.0f, 4.0f))
  }
}