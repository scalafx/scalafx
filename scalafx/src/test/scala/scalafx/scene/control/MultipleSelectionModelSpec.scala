/*
 * Copyright (c) 2012, ScalaFX Project
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
package scalafx.scene.control

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import javafx.scene.{control => jfxsc}
import javafx.{collections => jfxc}
import scalafx.Includes._
import scalafx.testutil.AbstractSFXDelegateSpec

/**
 * MultipleSelectionModel Spec tests.
 *
 */
@RunWith(classOf[JUnitRunner])
class MultipleSelectionModelSpec[T]
  extends AbstractSFXDelegateSpec[jfxsc.MultipleSelectionModel[T], MultipleSelectionModel[T], jfxsc.MultipleSelectionModelBuilder[T, _]](classOf[jfxsc.MultipleSelectionModel[T]], classOf[MultipleSelectionModel[T]], classOf[jfxsc.MultipleSelectionModelBuilder[T, _]]) {

  class SimpleMultipleSelectionModel extends jfxsc.MultipleSelectionModel[T] {
    def getSelectedIndices: jfxc.ObservableList[java.lang.Integer] = null
    def getSelectedItems: jfxc.ObservableList[T] = null
    def selectAll() {}
    def selectFirst() {}
    def selectIndices(index: Int, indices: Int*) {}
    def selectLast() {}
    def clearAndSelect(index: Int) {}
    def clearSelection() {}
    def clearSelection(index: Int) {}
    def isEmpty: Boolean = false
    def isSelected(index: Int): Boolean = false
    def select(index: Int) {}
    def select(obj: T) {}
    def selectNext() {}
    def selectPrevious() {}
  }

  override protected def getScalaClassInstance = new MultipleSelectionModel[T](getJavaClassInstance) {}

  override protected def getJavaClassInstance = new SimpleMultipleSelectionModel

}