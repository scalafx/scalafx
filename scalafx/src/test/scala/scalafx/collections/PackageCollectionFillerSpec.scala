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

  private case class Analyzer[T](originalList: jfxc.ObservableList[T]) {
    val originalElements = originalList.toList
    val copy = originalList.toList
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
        addedElements = change.getAddedSubList
        removedElements = change.getRemoved
        secondChange = change.next
      }
    })

  }

  def emptyEvaluation(analyzer: Analyzer[_], list: jfxc.ObservableList[_]) {
    list should be('empty)
    analyzer.wasAdded should be(false)
    analyzer.addedElements.size should be(0)
  }

  def filledEvaluation(analyzer: Analyzer[_], list: jfxc.ObservableList[_], fillingIterable: Iterable[_], extraEval: (Analyzer[_], Iterable[_]) => Unit) {
    list.toList should be(fillingIterable)
    analyzer.wasAdded should be(true)
    extraEval(analyzer, fillingIterable)
  }

  def finalEvaluation(analyzer: Analyzer[_]) {
    analyzer.wasRemoved should be(true)
    analyzer.removedElements.toIterable should be(analyzer.copy)
    analyzer.secondChange should be(false)
  }

  private def executeAndTestChanges[T](originalList: jfxc.ObservableList[T], newContent: Iterable[T]) {
    val analyzer = Analyzer(originalList)

    fillCollection(originalList, newContent)

    if (newContent == null || newContent.isEmpty) {
      this.emptyEvaluation(analyzer, originalList)
    } else {
      this.filledEvaluation(analyzer, originalList, newContent, (an, li) => an.addedElements.toList should be(li.toList))
    }
    this.finalEvaluation(analyzer)
  }

  private def executeAndTestChangesFX[T <: Object](originalList: jfxc.ObservableList[T], newContent: Iterable[SFXDelegate[T]]) {
    val analyzer = Analyzer(originalList)

    fillSFXCollection(originalList, newContent)

    if (newContent == null || newContent.isEmpty) {
      this.emptyEvaluation(analyzer, originalList)
    } else {
      this.filledEvaluation(analyzer, originalList, newContent.map(_.delegate), (an, li) => ())
      analyzer.addedElements.toList should be(newContent.map(_.delegate).toList)
    }
    this.finalEvaluation(analyzer)
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
    val originalList = getOriginalStringObservableList
    val analyzer = Analyzer(originalList)

    fillCollectionWithOne(originalList, null)

    this.emptyEvaluation(analyzer, originalList)
    this.finalEvaluation(analyzer)
  }

  "fillCollectionWithOne" should "replace original content if receives a not null element" in {
    val originalList = getOriginalStringObservableList
    val analyzer = Analyzer(originalList)

    val newValue = "1"
    fillCollectionWithOne(originalList, newValue)

    this.filledEvaluation(analyzer, originalList, List(newValue), (an, li) => an.addedElements.size should be(1))
    this.finalEvaluation(analyzer)
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
    val originalList = getOriginalNodeObservableList
    val analyzer = Analyzer(originalList)

    fillSFXCollectionWithOne(originalList, null)

    this.emptyEvaluation(analyzer, originalList)
    this.finalEvaluation(analyzer)
  }

  it should "replace original content if receives a not null element" in {
    val originalList = getOriginalNodeObservableList
    val analyzer = Analyzer(originalList)

    val newValue = new Slider
    fillSFXCollectionWithOne(originalList, newValue)

    this.filledEvaluation(analyzer, originalList, List(newValue.delegate), (an, li) => an.addedElements.size should be(1))
    this.finalEvaluation(analyzer)
  }

}