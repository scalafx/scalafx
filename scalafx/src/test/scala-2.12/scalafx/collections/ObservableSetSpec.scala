/*
 * Copyright (c) 2011-2021, ScalaFX Project
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
import org.scalatest.matchers.should.Matchers._
import scalafx.Includes._
import scalafx.collections.ObservableSet._
import scalafx.testutil.SimpleSFXDelegateSpec

import java.{util => ju}
import scala.collection.mutable._

/**
 * ObservableSet[T] Spec tests.
 *
 *
 */
class ObservableSetSpec[T]
  extends SimpleSFXDelegateSpec[jfxc.ObservableSet[T], ObservableSet[T]](classOf[jfxc.ObservableSet[T]], classOf[ObservableSet[T]]) {

  /**
   * Verifies if a generated Set is the same instance than a original Set. If it should not be,
   * generated map must be a ObservableSet.
   *
   * @param generatedSet    Generated Set, that should be a ObservableSet.
   * @param originalSet     Set Original ObservableSet.
   * @param shouldBeTheSame If both maps should be same instance.
   */
  private def compareInstances(generatedSet: Set[Int],
                               originalSet: ObservableSet[Int], shouldBeTheSame: Boolean): Unit = {
    if (shouldBeTheSame) {
      generatedSet should be theSameInstanceAs (originalSet)
    } else {
      generatedSet should not be theSameInstanceAs(originalSet)
      generatedSet.getClass.getInterfaces.contains(classOf[ObservableSet[Int]]) should be(true)
    }
  }

  override def getScalaClassInstance = ObservableSet.empty[T]

  override def getJavaClassInstance = jfxc.FXCollections.observableSet[T](new ju.HashSet[T])

  it should "generate new instances using Companion's apply" in {

    def assertGeneratedSet(set: ObservableSet[Int]): Unit = {
      set should have size (2)
      set should contain(1)
      set should contain(2)
    }

    assertGeneratedSet(ObservableSet(1, 2))
    assertGeneratedSet(ObservableSet.from(List(1, 2)))
    assertGeneratedSet(ObservableSet.from(Set(1, 2)))

    val scalaHashSet = new HashSet[Int]
    scalaHashSet += 1 += 2
    assertGeneratedSet(ObservableSet.from(scalaHashSet))
  }

  it should "notify on invalidation" in {
    // Preparation
    val set = ObservableSet(1, 2)
    var invalidateCount = 0
    set onInvalidate {
      invalidateCount += 1
    }

    // Execution
    set += 1 // 1 is in set yet. How set is not modified, invalidate is not activated
    set -= 1
    set -= 2
    set -= 3 // 3 is not in set yet. How set is not modified, invalidate is not activated
    set += 3

    // Verification
    invalidateCount should equal(3)
  }

  it should "notify on changes" in {
    // Preparation
    val set = ObservableSet(1, 2)
    var changeCount = 0
    set onChange {
      changeCount += 1
    }

    // Execution
    set += 1 // Set not changed. onChange not activated
    set += 3
    set -= 2

    // Verification
    changeCount should equal(2)
  }

  it should "return changed set" in {
    // Preparation
    val set = ObservableSet(1, 2)
    set onChange {
      (sourceSet, change) => sourceSet should be(set)
    }

    // Execution
    set += 3
  }

  it should "notify each addition individually" in {
    // Preparation
    val set = ObservableSet.empty[Int]
    val addedValues = Buffer.empty[Int]
    set onChange {
      (sourceSet, change) =>
        change match {
          case Add(value) => addedValues += value
          case _          => fail("Unexpected change: " + change)
        }
    }

    // Execution
    // Operations that change this set
    compareInstances(set += 0, set, true)
    compareInstances(set +=(1, 2), set, true)
    compareInstances(set ++= List(3), set, true)
    compareInstances(set ++= List(4, 5), set, true)
    (set add 6) should be(true)
    set(7) = true
    // Operations that not change this set
    compareInstances(set + 100, set, false)
    compareInstances(set +(101, 102), set, false)
    compareInstances(set ++ List(103), set, false)
    compareInstances(set ++ List(104, 105), set, false)
    (set add 1) should be(false)
    set(2) = true

    // Verification 
    addedValues should equal((0 to 7).toBuffer)
  }

  it should "notify each remotion individually" in {
    // Preparation 
    val set = ObservableSet.from((0 to 15))
    val removedValues = Buffer.empty[Int]
    set onChange {
      (sourceSet, change) =>
        change match {
          case Remove(value) => removedValues += value
          case _             => fail("Unexpected change: " + change)
        }
    }

    // Execution
    // Operations that change this set
    compareInstances(set -= 0, set, true)
    compareInstances(set -=(1, 2), set, true)
    compareInstances(set --= List(3), set, true)
    compareInstances(set --= List(4, 5), set, true)
    (set remove 6) should be(true)
    set(7) = false
    // Operations that not change this set
    compareInstances(set - 100, set, false)
    compareInstances(set -(101, 102), set, false)
    compareInstances(set -- List(103), set, false)
    compareInstances(set -- List(104, 105), set, false)
    (set remove 1) should be(false)
    set(2) = false

    // First Verification
    removedValues.toList.sortWith(_ < _) should equal((0 to 7).toList)

    removedValues.clear()
    // Retain even values
    set retain (_ % 2 == 0)
    removedValues.toList.sortWith(_ < _) should equal((8 to 15).filter(_ % 2 != 0).toList)

    removedValues.clear()
    // Clear Set
    set.clear()
    set should be('empty)
    removedValues.toList.sortWith(_ < _) should equal((8 to 15).filter(_ % 2 == 0).toList)
  }

  it should "keep his behavior with other types of sets beyond HashSet" in {
    // Preparation
    val set = ObservableSet.from(new LinkedHashSet[Int])
    val addedValues = Buffer.empty[Int]
    val removedValues = Buffer.empty[Int]
    set onChange {
      (sourceSet, change) =>
        change match {
          case Add(value)    => addedValues += value
          case Remove(value) => removedValues += value
        }
    }

    // Execution
    compareInstances(set +=(1, 10, 3, 8, 5), set, true)
    compareInstances(set -=(10, 9, 3), set, true)
    compareInstances(set += 11, set, true)
    compareInstances(set +=(-1, 15), set, true)

    // Verification
    set.toList should equal(List(1, 8, 5, 11, -1, 15))
    addedValues should equal(Buffer(1, 10, 3, 8, 5, 11, -1, 15))
    removedValues should equal(Buffer(10, 3))
  }

}