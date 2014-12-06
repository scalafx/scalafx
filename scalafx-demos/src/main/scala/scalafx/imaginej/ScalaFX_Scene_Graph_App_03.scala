/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
package scalafx.imaginej

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

import scala.language.postfixOps
import scalafx.Includes._
import scalafx.animation._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle


/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 * based upon: Example 3 Animating the Scene
 *
 * http://docs.oracle.com/javafx/2.0/scenegraph/jfxpub-scenegraph.htm
 *
 */

object ScalaFX_Scene_Graph_App_03 extends JFXApp {
  val rectangle = new Rectangle {
    x = 0
    y = 0
    width = 250
    height = 250
    fill = Color.Blue
  }
  stage = new PrimaryStage {
    title = "ScalaFX Scene Graph App 03"
    scene = new Scene(500, 500) {
      fill = Color.Black
      content = List(
        rectangle
      )
    }
    val parallelTransition = new ParallelTransition {
      node = rectangle
      cycleCount = Timeline.Indefinite
      autoReverse = true
      interpolator = Interpolator.EASE_BOTH
      children = Seq(
        new TranslateTransition {
          duration = (2 s)
          toX = 390
          toY = 390
        },
        new FillTransition {
          duration = (2 s)
          toValue = Color.Red
        },
        new RotateTransition {
          duration = (2 s)
          toAngle = 360
        },
        new SequentialTransition {
          children = Seq(
            new ScaleTransition {
              duration = (1 s)
              toX = 0.1
              toY = 0.1
            },
            new ScaleTransition {
              duration = (1 s)
              toX = 1
              toY = 1
            }
          )
        }
      )
    }
    parallelTransition.play()
  }
}
