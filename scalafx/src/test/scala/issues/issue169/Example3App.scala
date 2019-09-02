/*
 * Copyright (c) 2011-2016, ScalaFX Project
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

package issues.issue169

import javafx.{beans => jfxb, collections => jfxc, util => jfxu}

import scalafx.Includes._
import scalafx.collections.ObservableBuffer

/**
  * Example of `Update` notification. Based on example for Issue #169:
  * [[https://github.com/scalafx/scalafx/issues/169#issuecomment-67577800]]
  *
  */
object Example3App extends App {

  val items: ObservableBuffer[jfxc.ObservableList[String]] = new ObservableBuffer(
    jfxc.FXCollections.observableArrayList[jfxc.ObservableList[String]](
      new jfxu.Callback[jfxc.ObservableList[String], Array[jfxb.Observable]] {
        def call(elem: jfxc.ObservableList[String]) = Array[jfxb.Observable](elem)
      }
    )
  )

  items.onChange((_, changes) => {
    println(s"onChange(_, $changes")
    for (change <- changes)
      change match {
        case ObservableBuffer.Add(_, _)        => println(s"  case Add: $change")
        case ObservableBuffer.Remove(_, _)     => println(s"  case Remove: $change")
        case ObservableBuffer.Reorder(_, _, _) => println(s"  case Reorder: $change")
        case ObservableBuffer.Update(_, _)     => println(s"  case Update: $change")
      }
  })

  // Should produce `Add` notification
  println("items += ObservableBuffer(\"test\")")
  items += ObservableBuffer("test")
  println("Items: " + items)
  println()

  // Should produce `Update` notification
  println("items(0) += \"update\"")
  items(0) += "update"
  println("Items: " + items)
}
