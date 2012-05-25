/*
 * Copyright (c) 2011, ScalaFX Project
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

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers._
import scalafx.collections.ObservableBuffer.{Reorder, Remove, Add}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * ObservableBuffer Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class ObservableBufferSpec extends FlatSpec {
  "An ObservableBuffer" should "support apply" in {
    val buffer = ObservableBuffer("a", "b", "c")
    buffer should have length (3)
  }

  it should "support unapply" in {
    val buffer = ObservableBuffer("a", "b", "c")
    val ObservableBuffer(first, second, third) = buffer
    first should equal("a")
    second should equal("b")
    third should equal("c")
  }

  it should "notify on invalidation" in {
    val buffer = ObservableBuffer("a", "b", "c")
    var invalidateCount = 0
    buffer onInvalidate {
      invalidateCount += 1
    }
    buffer += "d"
    invalidateCount should equal(1)
  }

  it should "notify on changes" in {
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    buffer onChange {
      changeCount += 1
    }
    buffer += "d"
    changeCount should equal(1)
  }

  it should "return changed list" in {
    val buffer = ObservableBuffer("a", "b", "c")
    buffer onChange {
      (list, changes) => list should be(buffer.delegate)
    }
    buffer += "d"
  }

  it should "batch notify with additions" in {
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    buffer onChange {
      (list, changes) => for (change <- changes) change match {
        case Add(position, elements) => {
          changeCount += 1
          position should equal(3 * changeCount)
          elements should equal(Seq("d", "e", "f"))
        }
      }
    }
    buffer.appendAll(List("d", "e", "f"))
    buffer ++= List("d", "e", "f")
    buffer.append("d", "e", "f")
    buffer +=("d", "e", "f")
    buffer.insertAll((changeCount + 1) * 3, List("d", "e", "f"))
    buffer.insert((changeCount + 1) * 3, "d", "e", "f")
    changeCount should equal(6)
    changeCount = -1
    List("d", "e", "f") ++=: buffer
    changeCount = -1
    buffer.prependAll(List("d", "e", "f"))
  }

  it should "batch notify with removes" in {
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    buffer onChange {
      (list, changes) => for (change <- changes) change match {
        case Remove(position, elements) => {
          changeCount += 1
          position should equal(0)
          elements should equal(Seq("a", "b", "c"))
        }
        case Add(_, _) =>
      }
    }
    buffer.setAll("a", "b", "c")
    buffer.trimEnd(3)
    buffer +=("a", "b", "c")
    buffer.trimStart(3)
    buffer +=("a", "b", "c")
    buffer.remove(0, 3)
    buffer +=("a", "b", "c")
    buffer.clear
    changeCount should equal(5)
  }

  it should "notify on replace with a remove and add" in {
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    buffer onChange {
      (list, changes) => for (change <- changes) change match {
        case Add(position, elements) => {
          changeCount += 1
          position should equal(0)
          elements should equal(Seq("d", "e", "f"))
        }
        case Remove(position, elements) => {
          changeCount += 1
          position should equal(0)
          elements should equal(Seq("a", "b", "c"))
        }
      }
    }
    buffer.setAll("d", "e", "f")
    changeCount should equal(2)
  }

  it should "notify on a sort order change with a reorder from the JavaFX collection sort" in {
    val buffer = ObservableBuffer("f", "e", "d", "c", "b", "a")
    var changeCount = 0
    buffer onChange {
      (list, changes) => for (change <- changes) change match {
        case Reorder(start, end, permutation) => {
          changeCount += 1
          start should equal (0)
          end should equal (6)
          for (i <- 0 until 5) {
            permutation(i) should equal (5 - i)
          }
        }
      }
    }
    javafx.collections.FXCollections.sort(buffer)
    changeCount should equal(1)
  }

  it should "notify on a sort order change with a reorder from a member method" in {
    val buffer = ObservableBuffer("f", "e", "d", "c", "b", "a")
    var changeCount = 0
    buffer onChange {
      (list, changes) => for (change <- changes) change match {
        case Reorder(start, end, permutation) => {
          changeCount += 1
          start should equal (0)
          end should equal (6)
          for (i <- 0 until 5) {
            permutation(i) should equal (5 - i)
          }
        }
      }
    }
    buffer.sort()
    changeCount should equal(1)
  }

  it should "notify on a sort order change with a reorder from a member method with a comparison function" in {
    val buffer = ObservableBuffer("f", "e", "d", "c", "b", "a")
    var changeCount = 0
    buffer onChange {
      (list, changes) => for (change <- changes) change match {
        case Reorder(start, end, permutation) => {
          changeCount += 1
          start should equal (0)
          end should equal (6)
          for (i <- 0 until 5) {
            permutation(i) should equal (i)
          }
        }
      }
    }
    buffer.sort((a, b) => a > b)
    changeCount should equal(1)
  }
}