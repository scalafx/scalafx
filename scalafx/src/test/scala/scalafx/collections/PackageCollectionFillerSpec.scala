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
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTER RUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.collections

import java.{ util => ju }
import javafx.{ collections => jfxc }
import javafx.{ scene => jfxs }
import jfxs.{ control => jfxsc }
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers._
import scala.collection.JavaConversions._
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.control._

/**
 * Spec tests for Collection methods in package object.
 */
@RunWith(classOf[JUnitRunner])
class PackageCollectionFillerSpec extends FlatSpec {

  private def executeAndTestChanges[T](originalList: jfxc.ObservableList[T], newContent: Iterable[T]) {
    val originalElements = originalList.toList
    var addedElements: ju.List[_ <: T] = null
    var removedElements: ju.List[_ <: T] = null
    var wasRemoved: Boolean = false
    var wasAdded = false
    var secondChange: Boolean = false
    originalList.addListener(new jfxc.ListChangeListener[T] {
      def onChanged(change: jfxc.ListChangeListener.Change[_ <: T]) {
        change.next
        wasRemoved = change.wasRemoved()
        wasAdded = change.wasAdded()
        addedElements = change.getAddedSubList()
        removedElements = change.getRemoved()
        secondChange = change.next
      }
    })

    fillCollection(originalList, newContent)

    if (newContent == null || newContent.isEmpty) {
      originalList should be('empty)
      wasAdded should be(false)
      addedElements.size should be(0)
    } else {
      originalList.toList should be(newContent.toList)
      wasAdded should be(true)
      addedElements.toList should be(newContent.toList)
    }
    wasRemoved should be(true)
    removedElements.toIterable should be(originalElements)
    secondChange should be(false)
  }

  private def executeAndTestChangesFX[T <: Object](originalList: jfxc.ObservableList[T], newContent: Iterable[SFXDelegate[T]]) {
    val originalElements = originalList.toList
    var addedElements: ju.List[_ <: T] = null
    var removedElements: ju.List[_ <: T] = null
    var wasRemoved: Boolean = false
    var wasAdded = false
    var secondChange: Boolean = false
    originalList.addListener(new jfxc.ListChangeListener[T] {
      def onChanged(change: jfxc.ListChangeListener.Change[_ <: T]) {
        change.next
        wasRemoved = change.wasRemoved()
        wasAdded = change.wasAdded()
        addedElements = change.getAddedSubList()
        removedElements = change.getRemoved()
        secondChange = change.next
      }
    })

    fillSFXCollection(originalList, newContent)

    if (newContent == null || newContent.isEmpty) {
      originalList should be('empty)
      wasAdded should be(false)
      addedElements.size should be(0)
    } else {
      originalList.toList should be(newContent.map(_.delegate).toList)
      wasAdded should be(true)
      addedElements.toList should be(newContent.map(_.delegate).toList)
    }
    wasRemoved should be(true)
    removedElements.toIterable should be(originalElements)
    secondChange should be(false)
  }

  private def getOriginalStringObservableList: jfxc.ObservableList[String] = jfxc.FXCollections.observableArrayList("A", "B", "C")

  private def getOriginalNodeObservableList: jfxc.ObservableList[jfxs.Node] = jfxc.FXCollections.observableArrayList(new jfxsc.Button("Button 1"), new jfxsc.TextField("TextField 2"), new jfxsc.Hyperlink("Hyperlink 3"))

  "fillCollection" should "clean originalCollection if receives null" in {
    executeAndTestChanges(getOriginalStringObservableList, null)
  }

  it should "clean originalCollection if receives a empty Iterable" in {
    executeAndTestChanges(getOriginalStringObservableList, Iterable.empty[String])
  }

  it should "replace new content" in {
    executeAndTestChanges(getOriginalStringObservableList, List("1", "2"))
  }

  "fillCollectionWithOne" should "clean originalCollection if receives null" in {
    var addedElements: ju.List[_] = null
    var removedElements: ju.List[_] = null
    var wasRemoved: Boolean = false
    var wasAdded = false
    var secondChange: Boolean = false
    val originalList = getOriginalStringObservableList
    originalList.addListener(new jfxc.ListChangeListener[String] {
      def onChanged(change: jfxc.ListChangeListener.Change[_ <: String]) {
        change.next
        wasRemoved = change.wasRemoved()
        wasAdded = change.wasAdded()
        addedElements = change.getAddedSubList()
        removedElements = change.getRemoved()
        secondChange = change.next
      }
    })

    fillCollectionWithOne(originalList, null)

    originalList should be('empty)
    wasAdded should be(false)
    addedElements.size should be(0)
    wasRemoved should be(true)
    removedElements should be(this.getOriginalStringObservableList)
    secondChange should be(false)
  }

  "fillCollectionWithOne" should "replace original content if receives a not null element" in {
    var addedElements: ju.List[_] = null
    var removedElements: ju.List[_] = null
    var wasRemoved: Boolean = false
    var wasAdded = false
    var secondChange: Boolean = false
    val originalList = getOriginalStringObservableList
    originalList.addListener(new jfxc.ListChangeListener[String] {
      def onChanged(change: jfxc.ListChangeListener.Change[_ <: String]) {
        change.next
        wasRemoved = change.wasRemoved()
        wasAdded = change.wasAdded()
        addedElements = change.getAddedSubList()
        removedElements = change.getRemoved()
        secondChange = change.next
      }
    })

    fillCollectionWithOne(originalList, "1")

    originalList.toList should be(List("1"))
    wasAdded should be(true)
    addedElements.size should be(1)
    wasRemoved should be(true)
    removedElements should be(this.getOriginalStringObservableList)
    secondChange should be(false)
  }

  "fillSFXCollection" should "clean originalCollection if receives null" in {
    executeAndTestChangesFX(getOriginalNodeObservableList, null)
  }

  it should "clean originalCollection if receives a empty Iterable" in {
    executeAndTestChangesFX(getOriginalNodeObservableList, Iterable.empty[Node])
  }

  it should "replace new content" in {
    executeAndTestChangesFX(getOriginalNodeObservableList, List(new ChoiceBox, new Slider))
  }

  "fillSFXCollectionWithOne" should "clean originalCollection if receives null" in {
    var addedElements: ju.List[_] = null
    var removedElements: ju.List[_] = null
    var wasRemoved: Boolean = false
    var wasAdded = false
    var secondChange: Boolean = false
    val originalList = getOriginalNodeObservableList
    val copy = originalList.toList
    originalList.addListener(new jfxc.ListChangeListener[jfxs.Node] {
      def onChanged(change: jfxc.ListChangeListener.Change[_ <: jfxs.Node]) {
        change.next
        wasRemoved = change.wasRemoved()
        wasAdded = change.wasAdded()
        addedElements = change.getAddedSubList()
        removedElements = change.getRemoved()
        secondChange = change.next
      }
    })

    fillSFXCollectionWithOne(originalList, null)

    originalList should be('empty)
    wasAdded should be(false)
    addedElements.size should be(0)
    wasRemoved should be(true)
    removedElements.toList should be(copy)
    secondChange should be(false)
  }

  it should "replace original content if receives a not null element" in {
    var addedElements: ju.List[_] = null
    var removedElements: ju.List[_] = null
    var wasRemoved: Boolean = false
    var wasAdded = false
    var secondChange: Boolean = false
    val originalList = getOriginalNodeObservableList
    val copy = originalList.toList
    originalList.addListener(new jfxc.ListChangeListener[jfxs.Node] {
      def onChanged(change: jfxc.ListChangeListener.Change[_ <: jfxs.Node]) {
        change.next
        wasRemoved = change.wasRemoved()
        wasAdded = change.wasAdded()
        addedElements = change.getAddedSubList()
        removedElements = change.getRemoved()
        secondChange = change.next
      }
    })

    val newNode = new Slider
    fillSFXCollectionWithOne(originalList, newNode)

    originalList.toList should be(List(newNode.delegate))
    wasAdded should be(true)
    addedElements.size should be(1)
    wasRemoved should be(true)
    removedElements.toList should be(copy)
    secondChange should be(false)
  }

}