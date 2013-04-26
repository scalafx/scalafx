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

import scala.collection.mutable.Buffer
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers._
import javafx.{ collections => jfxc }
import java.{ util => ju }
import ObservableBuffer.Add
import ObservableBuffer.Remove
import ObservableBuffer.Reorder
import ObservableBuffer.observableBuffer2ObservableList
import scalafx.testutil.SimpleSFXDelegateSpec
import org.scalatest.junit.JUnitRunner
import scalafx.Includes._

/**
 * ObservableBuffer Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class ObservableBufferSpec[T]
  extends SimpleSFXDelegateSpec[jfxc.ObservableList[T], ObservableBuffer[T]](classOf[jfxc.ObservableList[T]], classOf[ObservableBuffer[T]]) {

  /**
   * Verifies if a generated Buffer is the same instance than a original Buffer. If it should not be,
   * generated map must be a ObservableBuffer.
   *
   * @param generatedBuffer Generated Buffer, that should be a ObservableBuffer.
   * @param original Buffer Original ObservableBuffer.
   * @param shouldBeTheSame If both mapos should be same instance.
   */
  private def compareInstances(generatedBuffer: Buffer[_],
    originalBuffer: ObservableBuffer[_], shouldBeTheSame: Boolean) {
    if (shouldBeTheSame) {
      generatedBuffer should be theSameInstanceAs (originalBuffer)
    } else {
      generatedBuffer should not be theSameInstanceAs(originalBuffer)
      generatedBuffer.getClass should be(classOf[ObservableBuffer[_]])
    }
  }

  private def compareAfterRemoving[T](generatedBuffer: Buffer[T],
    originalBuffer: ObservableBuffer[T], expectedResult: T*) {
    generatedBuffer.toList should equal(expectedResult.toList)
    generatedBuffer should not be theSameInstanceAs(originalBuffer)
    generatedBuffer.getClass should be(classOf[ObservableBuffer[T]])
  }

  override def getScalaClassInstance = ObservableBuffer.empty[T]

  override def getJavaClassInstance = jfxc.FXCollections.observableList[T](new ju.ArrayList[T])

  "An ObservableBuffer" should "support apply" in {
    // Execution
    val buffer = ObservableBuffer("a", "b", "c")

    // Verification
    buffer should have length (3)
  }

  it should "support unapply" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c")

    // Execution
    val ObservableBuffer(first, second, third) = buffer

    // Verification
    (first, second, third) should equal("a", "b", "c")
  }

  it should "notify on invalidation" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c")
    var invalidateCount = 0
    buffer onInvalidate {
      invalidateCount += 1
    }

    // Execution
    compareInstances(buffer += "d", buffer, true)

    // Verification
    invalidateCount should equal(1)
  }

  it should "notify on changes" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    buffer onChange {
      changeCount += 1
    }

    // Execution
    buffer += "d"

    // Verification
    changeCount should equal(1)
  }

  it should "return changed list" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c")
    buffer onChange {
      // Verification
      (list, changes) => list should be(buffer.delegate)
    }

    // Execution
    buffer += "d"
  }

  it should "notify individuals appends" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    var addedElement = ""
    var expectedPosition = -1
    buffer onChange {
      (list, changes) =>
        {
          changes.toList match {
            case (List(Add(position, elements))) => {
              changeCount += 1
              position should be(expectedPosition)
              elements should have size (1)
              elements.toSeq(0) should equal(addedElement)
            }
            case _ => fail("Unexpected changes: " + changes)
          }
        }
    }

    // Execution
    addedElement = "d"
    expectedPosition = buffer.size
    compareInstances(buffer += addedElement, buffer, true)

    addedElement = "0"
    expectedPosition = 0
    compareInstances(addedElement +=: buffer, buffer, true)

    addedElement = "e"
    expectedPosition = buffer.size
    buffer.append(addedElement)

    // Next changes will not affect buffer.
    addedElement = "f"
    compareInstances(addedElement +: buffer, buffer, false)
    compareInstances(buffer :+ addedElement, buffer, false)

    // Verification
    buffer.toList should equal(List("0", "a", "b", "c", "d", "e"))
    changeCount should be(3)
  }

  it should "batch notify with additions" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
          case Add(position, elements) => {
            changeCount += 1
            position should equal(3 * changeCount)
            elements should equal(Seq("d", "e", "f"))
          }
        }
    }

    // Execution
    // Operations that change this buffer
    compareInstances(buffer += ("d", "e", "f"), buffer, true)
    compareInstances(buffer ++= List("d", "e", "f"), buffer, true)
    buffer.append("d", "e", "f")
    buffer.appendAll(List("d", "e", "f"))
    buffer.insertAll((changeCount + 1) * 3, List("d", "e", "f"))
    buffer.insert((changeCount + 1) * 3, "d", "e", "f")
    changeCount should equal(6)
    changeCount = -1
    compareInstances(List("d", "e", "f") ++=: buffer, buffer, true)
    changeCount = -1
    buffer.prependAll(List("d", "e", "f"))
    // Operations that not change this set
    changeCount = -1
    compareInstances(buffer ++ List("d", "e", "f"), buffer, false)
    compareInstances("d" +: "e" +: "f" +: buffer, buffer, false)
    compareInstances(List("d", "e", "f") ++: buffer, buffer, false)
    changeCount should equal(-1)
  }

  it should "notify individuals remotions" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c", "d", "e", "f")
    var changeCount = 0
    var removedElement = ""
    var expectedPosition = -1
    buffer onChange {
      (list, changes) =>
        {
          changes.toList match {
            case (List(Remove(position, elements))) => {
              changeCount += 1
              position should be(expectedPosition)
              elements should have size (1)
              elements.toSeq(0) should equal(removedElement)
            }
            case _ => fail("Unexpected changes: " + changes)
          }
        }
    }

    // Execution
    removedElement = "d"
    expectedPosition = 3
    compareInstances(buffer -= removedElement, buffer, true)

    removedElement = "b"
    expectedPosition = 1
    buffer.remove(expectedPosition) should equal("b")

    // Next changes will not affect buffer.
    removedElement = "e"
    expectedPosition = -1
    compareInstances(buffer - removedElement, buffer, false)

    // Verification
    buffer.toList should equal(List("a", "c", "e", "f"))
    changeCount should be(2)
  }

  it should "batch notify with removes" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
          case Remove(position, elements) => {
            changeCount += 1
            position should equal(0)
            elements should equal(Seq("a", "b", "c"))
          }
          case Add(_, _) =>
        }
    }

    // Execution
    buffer.setAll("a", "b", "c") should be(true)
    buffer.trimEnd(3)
    buffer should be('empty)

    buffer += ("a", "b", "c")
    buffer.trimStart(3)
    buffer should be('empty)

    buffer += ("a", "b", "c")
    buffer.remove(0, 3)
    buffer should be('empty)

    buffer += ("a", "b", "c")
    buffer.clear()
    buffer should be('empty)

    buffer += ("a", "b", "c")
    compareInstances(buffer -= ("a", "b", "c"), buffer, true)
    buffer should be('empty)

    buffer += ("a", "b", "c")
    compareInstances(buffer --= List("a", "b", "c"), buffer, true)
    buffer should be('empty)

    buffer += ("a", "b", "c")
    // Next Methods will not change buffer
    compareAfterRemoving(buffer - ("a", "c"), buffer, "b")
    buffer.toList should equal(List("a", "b", "c"))
    compareAfterRemoving(buffer -- List("a", "c"), buffer, "b")
    buffer.toList should equal(List("a", "b", "c"))

    // Verification
    changeCount should equal(7)
  }

  it should "notify when it is removed a range of elements" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c", "d", "e")
    var changeCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
          case Remove(position, elements) => {
            changeCount += 1
            position should equal(1)
            elements should equal(Seq("b", "c", "d"))
          }
          case Add(_, _) =>
        }
    }

    // Execution
    buffer.removeRange(1, 4)

    // Verification
    changeCount should equal(1)
    buffer.toList should equal(List("a", "e"))
  }

  it should "notify a rotation just once" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c", "d", "e", "f")

    var changeCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
          case Add(position, elements) => {
            changeCount += 1
            position should equal(0)
            elements should equal(Seq("e", "f", "a", "b", "c", "d"))
          }
          case Remove(position, elements) => {
            changeCount += 1
            position should equal(0)
            elements should equal(Seq("a", "b", "c", "d", "e", "f"))
          }
        }
    }

    // Executuion
    ObservableBuffer.rotate(buffer, 2)

    // Verification
    changeCount should equal(2)
    buffer.toList should equal(List("e", "f", "a", "b", "c", "d"))
  }

  it should "notify on replace with a remove and add" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c")
    var changeCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
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

    // Execution
    buffer.setAll("d", "e", "f") should be(true)

    // Verification
    changeCount should equal(2)
  }

  it should "notify on a sort order change with a reorder from the JavaFX collection sort" in {
    val buffer = ObservableBuffer("f", "e", "d", "c", "b", "a")
    var changeCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
          case Reorder(start, end, permutation) => {
            changeCount += 1
            start should equal(0)
            end should equal(6)
            for (i <- 0 until 5) {
              permutation(i) should equal(5 - i)
            }
          }
        }
    }

    // Execution
    javafx.collections.FXCollections.sort(buffer)

    // Verification
    changeCount should equal(1)
  }

  it should "notify on a sort order change with a reorder from a member method" in {
    // Preparation
    val buffer = ObservableBuffer("f", "e", "d", "c", "b", "a")
    var changeCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
          case Reorder(start, end, permutation) => {
            changeCount += 1
            start should equal(0)
            end should equal(6)
            for (i <- 0 until 5) {
              permutation(i) should equal(5 - i)
            }
          }
        }
    }

    // Execution
    buffer.sort

    // Verification
    changeCount should equal(1)
  }

  it should "throws a exception when sort a buffer that is composed by non Comparable subtypes" in {
    // Preparation
    case class A(val value: Int)
    val buffer = ObservableBuffer(A(4), A(3), A(1), A(5), A(2))

    // Execution
    intercept[IllegalStateException] {
      buffer.sort
    }
  }

  it should "notify on a sort order change with a reorder from a member method with a comparison function" in {
    // Preparation
    val buffer = ObservableBuffer("f", "e", "d", "c", "b", "a")
    var changeCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
          case Reorder(start, end, permutation) => {
            changeCount += 1
            start should equal(0)
            end should equal(6)
            for (i <- 0 until 5) {
              permutation(i) should equal(i)
            }
          }
        }
    }

    // Execution
    buffer.sort((a, b) => a > b)

    // Verification
    changeCount should equal(1)
  }

  it should "shufle with a only change" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c", "d", "e")
    var removeCount = 0
    var addCount = 0
    buffer onChange {
      (list, changes) =>
        for (change <- changes) change match {
          case Add(pos, addedBuffer) => {
            addCount += 1
            pos should equal(0)
            addedBuffer.size should equal(buffer.size)
            addedBuffer.toBuffer.sameElements(buffer)
          }
          case Remove(pos, removedBuffer) => {
            removeCount += 1
            pos should equal(0)
            removedBuffer.size should equal(buffer.size)
            removedBuffer.toBuffer.sameElements(buffer)
          }
          case _@ otherChange => fail(otherChange.toString)
        }
    }

    // Execution
    ObservableBuffer.shuffle(buffer)

    // Verification
    addCount should equal(1)
    removeCount should equal(1)
  }

  it should "retain continous elements with 2 changes" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c", "d", "e")
    buffer onChange {
      (list, changes) =>
        {
          list.toList should equal(List("c", "d"))
          changes.toList should equal(List(Remove(0, Buffer("a", "b")), Remove(2, Buffer("e"))))
        }
    }

    // Execution
    buffer.retainAll("c", "d")

    // Verification
    buffer.toList should equal(List("c", "d"))
  }

  it should "retain non continous elements with 3 changes" in {
    // Preparation
    val buffer = ObservableBuffer("a", "b", "c", "d", "e")
    buffer onChange {
      (list, changes) =>
        {
          list.toList should equal(List("b", "d"))
          changes.toList should equal(List(Remove(0, Buffer("a")), Remove(1, Buffer("c")), Remove(2, Buffer("e"))))
        }
    }

    // Execution
    buffer.retainAll("b", "d")

    // Verification
    buffer.toList should equal(List("b", "d"))
  }

  it should "concat various Observable Lists in a unique" in {
    val buffer1 = ObservableBuffer(1, 2)
    val buffer2 = ObservableBuffer(5, 6, 7)
    val buffer3 = ObservableBuffer(3)

    val concatBuffer = ObservableBuffer.concat(buffer1, buffer2, buffer3)

    concatBuffer should equal(ObservableBuffer(1, 2, 5, 6, 7, 3))
  }

  it should "revert using just one changing" in {
    val buffer = ObservableBuffer(1, 2, 3, 4, 5)
    var changesDetected = 0

    buffer onChange {
      (list, changes) =>
        {
          changesDetected += 1
          list.toList should equal(List(5, 4, 3, 2, 1))
          changes.toList should equal(List(Remove(0, Buffer(1, 2, 3, 4, 5)), Add(0, Buffer(5, 4, 3, 2, 1))))
        }
    }

    ObservableBuffer.revertBuffer(buffer)

    changesDetected should be(1)
  }

  it should "replace all ocurrences of a element with just one change" in {
    val buffer = ObservableBuffer(1, 2, 3, 1, 5)
    var changesDetected = 0

    buffer onChange {
      (list, changes) =>
        {
          changesDetected += 1
          list.toList should equal(List(0, 2, 3, 0, 5))
          changes.toList should equal(List(Remove(0, Buffer(1, 2, 3, 1, 5)), Add(0, Buffer(0, 2, 3, 0, 5))))
        }
    }

    buffer.replaceAll(1, 0)

    changesDetected should be(1)
  }

  it should "fill all with just one change" in {
    val buffer = ObservableBuffer(1, 2, 3, 4, 5)
    var changesDetected = 0

    buffer onChange {
      (list, changes) =>
        {
          changesDetected += 1
          list.toList should equal(List(-1, -1, -1, -1, -1))
          changes.toList should equal(List(Remove(0, Buffer(1, 2, 3, 4, 5)), Add(0, Buffer(-1, -1, -1, -1, -1))))
        }
    }

    ObservableBuffer.fillAll(buffer, -1)

    changesDetected should be(1)
  }

  it should "keep his behavior with other types of sets beyond default implementation" in {
    // Preparation
    val buffer = ObservableBuffer(new StringBuilder)
    val addedValues = Buffer.empty[Any]
    val removedValues = Buffer.empty[Any]
    val permutations = Buffer.empty[Buffer[(Int, Int)]]
    buffer onChange {
      (list, changes) =>
        {
          for (change <- changes) change match {
            case Add(pos, addedBuffer) => {
              addedValues ++= addedBuffer.toBuffer
            }
            case Remove(pos, removedBuffer) => {
              removedValues ++= removedBuffer.toBuffer
            }
            case Reorder(start, end, permutation) => {
              val p = Buffer.empty[(Int, Int)]
              (start until end).foreach(i => p += ((i, permutation(i))))
              permutations += p
            }
          }
        }
    }

    // Execution
    buffer += 'e'
    buffer += 'a' += 't'
    buffer.insert(0, 'r')
    buffer.insertAll(1, List('j', 'd', 'z'))
    buffer -= 'd'
    buffer(4) = 'h'
    buffer.sort(_ < _)

    // Verification
    buffer.toList should equal(List('e', 'h', 'j', 'r', 't', 'z'))
    addedValues.toList should equal(List('e', 'a', 't', 'r', 'j', 'd', 'z', 'h'))
    removedValues.toList should equal(List('d', 'a'))
    permutations should have size (1)
    permutations(0).toList should equal(List((0, 3), (1, 2), (2, 5), (3, 0), (4, 1), (5, 4)))
  }

}