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

import javafx.collections as jfxc
import org.scalatest.matchers.should.Matchers.*
import scalafx.Includes.*
import scalafx.collections.ObservableMap.*
import scalafx.testutil.SimpleSFXDelegateSpec
import scalafx.util.JavaConverters.*

import scala.collection.mutable

/**
 * ObservableMap[K, V] Spec tests.
 */
class ObservableMapSpec[K, V]
    extends SimpleSFXDelegateSpec[jfxc.ObservableMap[K, V], ObservableMap[K, V]](
      classOf[jfxc.ObservableMap[K, V]],
      classOf[ObservableMap[K, V]]
    ) {

  /**
   * Verifies if a generated Map is the same instance than a original Map. If it should not be,
   * generated map must be a ObservableMap.
   *
   * @param generatedMap    Generated Map, that should be a ObservableMap.
   * @param originalMap     Map Original ObservableMap.
   * @param shouldBeTheSame If both maps should be same instance.
   */
  private def compareInstances(
    generatedMap: mutable.Map[Int, String],
    originalMap: ObservableMap[Int, String],
    shouldBeTheSame: Boolean
  ): Unit = {
    if (shouldBeTheSame) {
      generatedMap should be theSameInstanceAs originalMap
    } else {
      generatedMap should not be theSameInstanceAs(originalMap)
      generatedMap.getClass.getInterfaces.contains(classOf[ObservableMap[Int, String]]) should be(true)
    }
  }

  override def getScalaClassInstance: ObservableMap[K, V] = ObservableMap.empty[K, V]

  override def getJavaClassInstance: jfxc.ObservableMap[K, V] = jfxc.FXCollections.observableHashMap[K, V]

  it should "generate new instances using Companion's apply" in {
    def assertGeneratedMap(map: mutable.Map[Int, String]): Unit = {
      map.toSet should equal(Map((1, "one"), (2, "two")).toSet)
    }

    assertGeneratedMap(ObservableMap.from(List((1, "one"), (2, "two"))))
    assertGeneratedMap(ObservableMap((1, "one"), (2, "two")))

    val map1 = new java.util.HashMap[Int, String]
    map1.put(1, "one")
    map1.put(2, "two")
    assertGeneratedMap(ObservableMap.from(map1.asScala))

    val map2 = mutable.Map.empty[Int, String]
    map2 ++= Seq((1, "one"), (2, "two"))
    assertGeneratedMap(ObservableMap.from(map2))
  }

  it should "notify on invalidation" in {
    // Preparation
    val map             = ObservableMap.from(List((1, "one"), (2, "two")))
    var invalidateCount = 0
    map onInvalidate {
      invalidateCount += 1
    }

    // Execution
    map(3) = "three"
    map(1) = "uno"

    // Verification
    invalidateCount should equal(2)
  }

  it should "notify on changes" in {
    // Preparation
    val map         = ObservableMap((1, "one"), (2, "two"))
    var changeCount = 0
    map onChange {
      changeCount += 1
    }

    // Execution
    map(3) = "three"
    map(1) = "uno"

    // Verification
    changeCount should equal(2)
  }

  it should "return changed map" in {
    // Preparation
    val map = ObservableMap((1, "one"), (2, "two"))
    map onChange {
      (sourceMap, *) => sourceMap should be(map)
    }

    // Execution
    map(3) = "three"
  }

  it should "notify each addition individually" in {
    // Preparation
    val map          = ObservableMap.empty[Int, String]
    val addedEntries = mutable.Buffer.empty[(Int, String)]
    map onChange {
      (*, change) =>
        change match {
          case Add(key1, valueAdded) => {
            addedEntries += ((key1, valueAdded))
          }
          case _ => fail(s"Unexpected change: $change")
        }
    }

    // Execution
    map(0) = 0.toString
    compareInstances(map += (1 -> 1.toString), map, true)
    compareInstances(map += (2 -> 2.toString) += (3 -> 3.toString), map, true)
    compareInstances(map += ((4, 4.toString)), map, true)
    compareInstances((map += ((5, 5.toString), (6, 6.toString))), map, true)
    compareInstances((map += (7 -> 7.toString, 8 -> 8.toString)), map, true)
    compareInstances((map ++= List((9, 9.toString))), map, true)
    compareInstances((map ++= List((10, 10.toString), (11, 11.toString))), map, true)
    (map put (12, 12.toString)) should be(None)
    (map getOrElseUpdate (13, 13.toString)) should equal(13.toString)
    // Next operations must not affect original map, so they must not call onchange function
    compareInstances((map + (100 -> 100.toString)), map, false)
    compareInstances((map + (101 -> 101.toString) + (102 -> 102.toString)), map, false)
    compareInstances((map + ((103, 103.toString))), map, false)
    compareInstances((map + ((104, 104.toString), (105, 105.toString))), map, false)
    compareInstances((map + (106 -> 106.toString, 107 -> 107.toString)), map, false)
    compareInstances((map ++ List((108, 108.toString))), map, false)
    compareInstances((map ++ List((109, 109.toString), (110, 110.toString))), map, false)
    compareInstances((map.updated(111, 111.toString)), map, false)

    // Verification
    addedEntries.toList should equal((0 to 13).map(i => (i, i.toString)).toList)
  }

  it should "notify each removing individually" in {
    // Preparation
    val map            = ObservableMap.from((0 to 20).map(i => (i, i.toString)))
    val removedEntries = mutable.Buffer.empty[(Int, String)]
    map onChange {
      (*, change) =>
        change match {
          case Remove(key1, valueRemoved) =>
            removedEntries += ((key1, valueRemoved))
          case _ => fail(s"Unexpected change: $change")
        }
    }

    // Execution
    compareInstances(map -= 0, map, true)
    compareInstances(map -= 1 -= 2, map, true)
    compareInstances(map -= 3, map, true)
    compareInstances(map -= (4, 5), map, true)
    compareInstances(map --= List(6), map, true)
    compareInstances(map --= List(7, 8), map, true)
    (map remove 9) should equal(Option(9.toString))
    // Trying remove not registered key. Should not activate onchange
    map -= -1
    (map remove 1) should be(None)
    // Next operations must not affect original map, so they must not call onchange function
    compareInstances(map - 10, map, false)
    compareInstances(map - 11 - 12, map, false)
    compareInstances(map - 13, map, false)
    compareInstances(map - (14, 15), map, false)
    compareInstances(map -- List(16), map, false)
    compareInstances(map -- List(17, 18), map, false)

    // First Verification
    map should equal(ObservableMap.from((10 to 20).map(i => (i, i.toString))))
    removedEntries.toList should equal((0 to 9).map(i => (i, i.toString)).toList)

    removedEntries.clear()
    // Retain even keys
    // NOTE Due to Scala 2.10 bug SI-7269 cannot use some of Map methods to filter elements.
    //      The `for` loop implements operation equivalent to `map.retain`
    //      without throwing ConcurrentModificationException.
    //    compareInstances(map.retain((i, str) => i % 2 == 0), map, true)
    for (k <- map.keys.toArray if k % 2 != 0) { map.remove(k) }
    map should equal(ObservableMap.from((10 to 20).filter(_ % 2 == 0).map(i => (i, i.toString))))
    removedEntries.toList.sortWith(_._1 < _._1) should equal(
      (10 to 20).filter(_ % 2 != 0).map(i => (i, i.toString)).toList
    )

    removedEntries.clear()
    // Clear Map
    map.clear()
    removedEntries.toList.sortWith(_._1 < _._1) should equal(
      (10 to 20).filter(_ % 2 == 0).map(i => (i, i.toString)).toList
    )
    map should be(Symbol("empty"))
  }

  it should "notify any replacement individually" in {
    // Preparation
    val map             = ObservableMap.from((0 to 20).map(i => (i, i.toString)))
    val replacedEntries = mutable.Buffer.empty[(Int, String, String)]
    map onChange {
      (*, change) =>
        change match {
          case Replace(key1, valueAdded, valueRemoved) =>
            replacedEntries += ((key1, valueAdded, valueRemoved))
          case _ => fail(s"Unexpected change: $change")
        }
    }
    val expectedEntries = mutable.Buffer.empty[(Int, String, String)]

    // Execution. compareInstances method is not called because operations below was tested yet.
    // Operations that change this map
    map(0) = "zero"
    expectedEntries += ((0, "zero", 0.toString))
    map += (1 -> "one")
    expectedEntries += ((1, "one", 1.toString))
    map += (2 -> "two") += (3 -> "three")
    expectedEntries += ((2, "two", 2.toString), (3, "three", 3.toString))
    map += ((4, "four"))
    expectedEntries += ((4, "four", 4.toString))
    map += ((5, "five"), (6, "six"))
    expectedEntries += ((5, "five", 5.toString), (6, "six", 6.toString))
    map += (7 -> "seven", 8 -> "eight")
    expectedEntries += ((7, "seven", 7.toString), (8, "eight", 8.toString))
    map ++= List((9, "nine"))
    expectedEntries += ((9, "nine", 9.toString))
    map ++= List((10, "ten"), (11, "eleven"))
    expectedEntries += ((10, "ten", 10.toString), (11, "eleven", 11.toString))
    map put (12, 12.toString) // repeating a value. It will not be change the map
    map put (12, "twelve")
    expectedEntries += ((12, "twelve", 12.toString))
    map getOrElseUpdate (13, "thirteen") // Map will not be updated
    // Operations that not change this set
    map + (14 -> "fourteen")
    map + (15 -> "fifteen") + (16 -> "sixteen")
    map + ((17, "seventeen"))
    map + ((18, "eighteen"), (19, "nineteen"))
    map + (20 -> "twenty", 21 -> "twenty-one")
    map ++ List((22, "twenty-two"))
    map ++ List((23, "twenty-three"), (24, "twenty-four"))
    map.updated(25, "twenty-five")

    // Verification
    replacedEntries should equal(expectedEntries)
  }

  it should "keep his behavior with other types of sets beyond HashMap" in {
    // Preparation
    val map           = ObservableMap.from(new mutable.LinkedHashMap[Int, String])
    val addedValues   = mutable.Buffer.empty[(Int, String)]
    val removedValues = mutable.Buffer.empty[(Int, String)]
    map onChange {
      (*, change) =>
        change match {
          case Add(key1, value1)    => addedValues += ((key1, value1))
          case Remove(key1, value1) => removedValues += ((key1, value1))
          case Replace(key1, added, removed) => {
            addedValues += ((key1, added))
            removedValues += ((key1, removed))
          }
        }
    }

    // Execution
    compareInstances((map ++= Seq((3, 3.toString), (1, 1.toString), (5, 5.toString))), map, true)
    compareInstances(map --= Seq(1, 4), map, true)
    map(3) = "three"

    // Verification
    map.toList should equal(List((3, "three"), (5, 5.toString)))
    addedValues should equal(mutable.Buffer((3, 3.toString), (1, 1.toString), (5, 5.toString), (3, "three")))
    removedValues should equal(mutable.Buffer((1, 1.toString), (3, 3.toString)))
  }

}
