/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

package scalafx.collections.transformation

import java.{util => ju}

import javafx.collections.{transformation => jfxct}
import javafx.{collections => jfxc}
import org.scalatest.matchers.should.Matchers._
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.testutil.SimpleSFXDelegateSpec

import scala.language.implicitConversions

/**
 * Test for [[scalafx.collections.transformation.SortedBuffer]].
 */
class SortedBufferSpec[E]
    extends SimpleSFXDelegateSpec[jfxct.SortedList[E], SortedBuffer[E]](
      classOf[jfxct.SortedList[E]],
      classOf[SortedBuffer[E]]
    ) {

  override def getScalaClassInstance = new SortedBuffer(ObservableBuffer.empty[E])

  override def getJavaClassInstance = new jfxct.SortedList(jfxc.FXCollections.observableList[E](new ju.ArrayList[E]))

  it should "assing comparator correctly" in {

    val sb = new SortedBuffer(ObservableBuffer(3, 4, 1))

    sb.toList should equal(List(3, 4, 1))

    sb.comparator = Ordering.Int
    sb.toList should equal(List(1, 3, 4))

    sb.comparator = Ordering.Int.reverse
    sb.toList should equal(List(4, 3, 1))
  }

}
