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

package issues.issue102

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{Label, Button}
import scalafx.scene.layout.{VBox, StackPane}


/** Illustrated [https://code.google.com/p/scalafx/issues/detail?id=102 Issue 102]
  *
  * When event handler is created from a code block (rather than a function),
  * only it's last instruction is used when event handler is invoked.
  * Everything else is invoked only once when event handler is created.
  *
  * When we run this application, with bug 102 in effect, and click three tomes on the
  * button, we will have following printout
  * {{{
  *   Creating primary stage ...
  *   Button 1 - Message 1
  *   Creating primary stage - done
  *   Button 1 - Message 2
  *   Button 1 - Message 2
  *   Button 1 - Message 2
  * }}}
  * Notice that first `println` in the handler is executed during construction,
  * before it is shown on the screen. Clicking on Button 1 produces only the second message.
  * If the event handler was working correctly we should have:
  * {{{
  *   Creating primary stage ...
  *   Creating primary stage - done
  *   Button 1 - Message 1
  *   Button 1 - Message 2
  *   Button 1 - Message 1
  *   Button 1 - Message 2
  *   Button 1 - Message 1
  *   Button 1 - Message 2
  * }}}
  *
  * In certain situations we can have a
  */
object IncompleteClickHandler extends JFXApp {
  println("Creating primary stage ...")
  stage = new JFXApp.PrimaryStage {
    title = "Illustration of Issue 102"
    scene = new Scene {
      content = new StackPane {
        padding = Insets(20)
        content = new VBox {
          spacing = 10
          content = Seq(
            new Label("If Issue 102 is not fixed, some buttons below may not respond correctly."),
            new Button {
              text = "Button 1: Buggy event handler: should print two messages, but prints one."
              // Disable as old buggy handler no longer compiles
              disable = true
              //              onAction = {
              //                println("Button 1 - Message 1")
              //                println("Button 1 - Message 2")
              //              }
            },
            new Button {
              text = "Button 2: Buggy event handler: should print two messages, but prints none."
              // Disable as old buggy handler no longer compiles
              disable = true
              //              onAction = (ae: java.awt.event.ActionEvent) => {
              //                println("Button 2 - Message 1")
              //                println("Button 2 - Message 2")
              //              }
            },
            new Button {
              text = "Button 3: Former buggy event handler: should print two messages, used to print none."
              onAction = () => {
                println("Button 3 - Message 1")
                println("Button 3 - Message 2")
              }
            },
            new Button {
              text = "Button 4: Buggy event handler: should print two messages, but prints none."
              // Disable as old buggy handler no longer compiles
              disable = true
              //              onAction = (ae: javafx.event.ActionEvent) => {
              //                println("Button 4 - Message 1")
              //                println("Button 4 - Message 2")
              //              }
            },
            new Button {
              text = "Button 5: Fine event handler: prints two messages."
              onAction = (ae: scalafx.event.ActionEvent) => {
                println("Button 5 - Message 1")
                println("Button 5 - Message 2")
              }
            },
            new Button {
              text = "Button 6: New fine approach using `handle {}`"
              onAction = handle {
                println("Button 6 - Message 1")
                println("Button 6 - Message 2")
              }
            }
          )
        }
      }
    }
  }
  println("Creating primary stage - done")
}
