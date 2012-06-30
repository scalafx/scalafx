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

import scalafx.application.JFXApp
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.layout.BorderPane
import scalafx.scene.shape.Rectangle
import scalafx.scene.paint.Color

/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 * based upon: Example 1-1 Create a Border Pane
 *
 * http://docs.oracle.com/javafx/2.0/layout/builtin_layouts.htm
 *
 */

object ScalaFX_Layout_Panes_01 extends JFXApp {
  stage = new Stage {
    title = "ScalaFX Layout Panes 01"
    scene = new Scene {
      content = new BorderPane {
        top = new Rectangle {
          fill = Color.DARKCYAN
          width = 200
          height = 50
        }
        bottom = new Rectangle {
          fill = Color.DARKCYAN
          width = 200
          height = 50
        }
        left = new Rectangle {
          fill = Color.DARKTURQUOISE
          width = 50
          height = 100
        }
        right = new Rectangle {
          fill = Color.DARKTURQUOISE
          width = 50
          height = 100
        }
        center = new Rectangle {
          fill = Color.MEDIUMAQUAMARINE
          width = 100
          height = 100
        }
      }
    }
  }
}

