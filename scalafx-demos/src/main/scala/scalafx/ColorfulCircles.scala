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

package scalafx

import scala.collection.immutable.VectorBuilder
import scala.language.postfixOps
import scala.math.random
import scalafx.Includes._
import scalafx.animation.Timeline
import scalafx.animation.Timeline.Indefinite
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.effect.BlendMode.Overlay
import scalafx.scene.effect.BoxBlur
import scalafx.scene.paint.Color.{Black, White}
import scalafx.scene.paint.CycleMethod.NoCycle
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.shape.StrokeType.Outside
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.{Group, Scene}


/**
 * ColorfulCircles
 */
object ColorfulCircles extends JFXApp {
  val circlesToAnimate = new VectorBuilder[Circle]()
  val initWidth = 800
  val initHeight = 600
  stage = new PrimaryStage {
    width = initWidth
    height = initHeight
    val rectA = new Rectangle {
      width = initWidth
      height = initHeight
      fill = Black
    }
    val rectB = new Rectangle {
      width = initWidth
      height = initHeight
      fill = new LinearGradient(0, 1, 1, 0, true, NoCycle,
      Stops(0xf8bd55, 0xc0fe56, 0x5dfbc1, 0x64c2f8, 0xbe4af7, 0xed5fc2, 0xef504c, 0xf2660f))
      blendMode = Overlay
    }
    scene = new Scene {
      fill = Black
      content = Seq(
        new Group {
          children = Seq(
            rectA,
            new Group {
              val circles = for (i <- 0 until 15) yield new Circle {
                radius = 200
                fill = White opacity 0.05
                stroke = White opacity 0.2
                strokeWidth = 4
                strokeType = Outside
              }
              children = circles
              circlesToAnimate ++= circles
              effect = new BoxBlur(30, 30, 3)
            },
            new Group {
              val circles = for (i <- 0 until 20) yield new Circle {
                radius = 70
                fill = White opacity 0.05
                stroke = White opacity 0.1
                strokeWidth = 2
                strokeType = Outside
              }
              children = circles
              circlesToAnimate ++= circles
              effect = new BoxBlur(2, 2, 2)
            },
            new Group {
              val circles = for (i <- 0 until 10) yield new Circle {
                radius = 150
                fill = White opacity 0.05
                stroke = White opacity 0.16
                strokeWidth = 4
                strokeType = Outside
              }
              children = circles
              circlesToAnimate ++= circles
              effect = new BoxBlur(10, 10, 3)
            })
        },
        rectB
      )
    }
    // Have the two rectangles react to changes in scene height & width
    rectA.width <== scene.width
    rectA.height <== scene.height
    rectB.width <== scene.width
    rectB.height <== scene.height
  }
  new Timeline {
    cycleCount = Indefinite
    autoReverse = true
    keyFrames = (for (circle <- circlesToAnimate.result()) yield Seq(
      at(0 s) {
        Set(circle.centerX -> random * initWidth,
          circle.centerY -> random * initHeight)
      },
      at(40 s) {
        Set(circle.centerX -> random * initWidth,
          circle.centerY -> random * initHeight)
      }
    )).flatten
  }.play()
}
