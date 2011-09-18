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

package scalafx

import scalafx.application.Application
import scalafx.beans.binding.Bindings._
import scalafx.scene.shape.Rectangle
import scalafx.scene.Scene
import scalafx.stage.Stage
import javafx.beans.Observable
import javafx.beans.value.ObservableValue
import javafx.scene.paint.{Paint, Color}

object JavaFXChangeListener extends Application {
  def rect = new Rectangle {
    x = 25
    y = 40
    width = 100
    height = 100
    fill <== when(hover) then Color.GREEN otherwise Color.RED
    fill onChange print("changed")
    fill onChange {
      (prop, oldVal, newVal) =>
        println(" " + prop + " from " + oldVal + " to " + newVal)
    }
    fill onInvalidate print("invalidated")
    fill onInvalidate {
      prop =>
        println(" " + prop)
    }
    fill.addListener(
      (obs: Observable) => println("addListener worked on invalidate")
    )
    fill.addListener(
      (obs: ObservableValue[_ <: Paint], oldV: Paint, newV: Paint) => println("addListener worked on changed")
    )
    fill.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println("change listener worked on super type")
    )
  }

  stage = new Stage {
    title = "Hello Stage"
    width = 600
    height = 450
    scene = new Scene {
      fill = Color.LIGHTGREEN
      content = List(rect)
    }
    visible = true
  }
}
