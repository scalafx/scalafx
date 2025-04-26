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

package issues.issue169

import javafx.collections as jfxc
import scalafx.collections.ObservableBuffer

/**
 * * Based on example case from reporter `scalasolist` [[https://github.com/scalafx/scalafx/issues/169#issuecomment-67262542]]:
 *
 * It show how scalafx listener lose information.
 *
 * The key is that original javafx listener is equivalent to Seq[Set[Change]] not to Seq[Change].
 * When two changes take place inside single step that means that changes are correlated.
 * Added and Removed when correlated become Replaced. Replaced shows that item in fact was modified.
 * It is very important for cost-significant computation performed when list is actually reducing or expanding.
 */
object Example2App extends App {
  val items: ObservableBuffer[String] = ObservableBuffer()

  val listener = new jfxc.ListChangeListener[String] {
    def onChanged(change: jfxc.ListChangeListener.Change[_ <: String]): Unit = {
      println(change)
      var order = 0
      while (change.next()) {
        order += 1
        println(order)
        if (change.wasPermutated) println("permutated")
        if (change.wasAdded) println("added")
        if (change.wasRemoved) println("removed")
        if (change.wasReplaced) println("replaced")
        if (change.wasUpdated) println("updated")
      }
    }
  }

  items.delegate.addListener(listener)

  println("items.append(\"test\")")
  items.append("test")
  println("items(0) = \"update\"")
  items(0) = "update"
}
