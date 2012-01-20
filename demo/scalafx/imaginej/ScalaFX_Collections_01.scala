package scalafx.imaginej

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

//             ________                                __                   ________   __    __
//           /   _____/\                             /  /\                /   _____/\/__/\ /  /\
//          /  /\_____\/  ________     _______      /  / /   ________    /  /\_____\/\  \ /  / /
//         /  /_/___    /   _____/\  /_____   /\   /  / /  /_____   /\  /  /_/__      \  /  / /
//        /______  /\  /  /\_____\/  \____/  / /  /  / /   \____/  / / /   ____/\      \/  / /
//        \_____/ / / /  / /       /  ___   / /  /  / /  /  ___   / / /  /\____\/      /  / /\
//       ______/ / / /  /_/___    /  /__/  / /  /  / /  /  /__/  / / /  / /           /  / /\ \
//     /________/ / /________/\  /________/ /  /__/ /  /________/ / /__/ /           /__/ /  \ \
//     \________\/  \________\/  \________\/   \__\/   \________\/  \__\/            \__\/ \__\/
//
//                                  ScalaFX Programming Library Examples
//

import scalafx.collections.ObservableBuffer
import ObservableBuffer.{Reorder, Remove, Add}

/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 * based upon: Example 4 Using an ObservableList & Example 7 Querying a ListChangeListener.Change Object
 *
 * http://docs.oracle.com/javafx/2.0/collections/jfxpub-collections.htm
 *
 */

object ScalaFX_Collections_01 {
  private def changes01(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changess01 " + observableStringBuffer)
    observableStringBuffer += "a"
    observableStringBuffer += "b"
    println("observable string buffer after  changes01 " + observableStringBuffer)
  }

  private def changes02(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes02 " + observableStringBuffer)
    observableStringBuffer ++= List("c", "d")
    println("observable string buffer after  changes02 " + observableStringBuffer)
  }

  private def changes03(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes03 " + observableStringBuffer)
    List("x", "y", "z") ++=: observableStringBuffer
    println("observable string buffer after  changes03 " + observableStringBuffer)
  }

  private def changes04(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes04 " + observableStringBuffer)
    observableStringBuffer.remove(1, 4)
    println("observable string buffer after  changes04 " + observableStringBuffer)
  }

  private def changes05(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes05 " + observableStringBuffer)
    observableStringBuffer.setAll("X", "C", "D")
    println("observable string buffer after  changes05 " + observableStringBuffer)
  }

  private def changes06(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes06 " + observableStringBuffer)
    observableStringBuffer.sort()
    println("observable string buffer after  changes06 " + observableStringBuffer)
  }

  def main(args: Array[String]) {
    val observableStringBuffer = ObservableBuffer[String]()
    observableStringBuffer onInvalidate {
      println("observable string buffer invalidated")
    }
    observableStringBuffer onChange {
      (_, changes) =>
        for (change <- changes) change match {
          case Add(position, elements) =>
            println("added " + elements + " at position " + position)
          case Remove(position, elements) =>
            println("removed " + elements + " at position " + position)
          case Reorder(start, end, _) =>
            println("reordered from " + start + " to " + end)
          case _ =>
            println("unclassified change")
        }
    }
    println("======================================================================")
    changes01(observableStringBuffer)
    println("======================================================================")
    changes02(observableStringBuffer)
    println("======================================================================")
    changes03(observableStringBuffer)
    println("======================================================================")
    changes04(observableStringBuffer)
    println("======================================================================")
    changes05(observableStringBuffer)
    println("======================================================================")
    changes06(observableStringBuffer)
    println("======================================================================")
  }
}
