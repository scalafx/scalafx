/*
 * Copyright (c) 2008, 2011 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx;

import java.lang.Math.random

import javafx.animation.Animation

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.effect.BlendMode
import javafx.scene.effect.BoxBlur
import javafx.scene.paint.Color
import javafx.scene.paint.CycleMethod
import javafx.scene.paint.LinearGradient
import javafx.scene.paint.Stop
import javafx.scene.shape.StrokeType

import javafx.util.Duration

import scalafx.animation.Timeline
import scala.collection.immutable.VectorBuilder
import scalafx.animation.KeyFrame
import scalafx.animation.KeyValue

import scalafx.application.Application

import scalafx.scene.Group
import scalafx.scene.Scene
import scalafx.scene.shape.Circle
import scalafx.scene.shape.Rectangle

import scalafx.stage.Stage

import collection.JavaConversions._

/**
 * ColorfulCircles
 *
 */
object ColorfulCircles extends Application {

  implicit def seqToList[T](c: scala.collection.immutable.IndexedSeq[T]):List[T] = c.toList
  
  val circlesToAnimate = new VectorBuilder[Circle]()
  
  stage = new Stage {
    width = 800
    height = 600
    scene = new Scene {
      fill = Color.BLACK
      content = List(new Group {
          blendMode = BlendMode.OVERLAY
          content = List(new Group {
              content = List(new Rectangle {
                  width = 800 //scene.width
                  height = 600 //scene.height
                  fill = Color.BLACK
                }, new Group {
                  content = for(i <- 0 until 15) yield {
                    val circle = new Circle {
                      radius = 200
                      fill = Color.web("white", 0.05)
                      stroke = Color.web("white", 0.2)
                      strokeWidth = 4
                      strokeType = StrokeType.OUTSIDE
                    }
                    circlesToAnimate += circle
                    circle
                  }
                  effect = new BoxBlur(30,30,3)
                },new Group {
                  content = for(i <- 0 until 20) yield {
                    val circle = new Circle {
                      radius = 70
                      fill = Color.web("white", 0.05)
                      stroke = Color.web("white", 0.1)
                      strokeWidth = 2
                      strokeType = StrokeType.OUTSIDE
                    }
                    circlesToAnimate += circle
                    circle
                  }
                  effect = new BoxBlur(2,2,2)
                },new Group {
                  content = for(i <- 0 until 10) yield {
                    val circle = new Circle {
                      radius = 150
                      fill = Color.web("white", 0.05)
                      stroke = Color.web("white", 0.16)
                      strokeWidth = 4
                      strokeType = StrokeType.OUTSIDE
                    }
                    circlesToAnimate += circle
                    circle
                  }
                  effect = new BoxBlur(10,10,3)
                })
            }, new Rectangle {
              width = 800 //scene.width
              height = 600 //scene.height
              fill = new LinearGradient(0f,1f,1f,0f,true, CycleMethod.NO_CYCLE,
                                        new Stop(0,Color.web("#f8bd55")),
                                        new Stop(0.14f,Color.web("#c0fe56")),
                                        new Stop(0.28f,Color.web("#5dfbc1")),
                                        new Stop(0.43f,Color.web("#64c2f8")),
                                        new Stop(0.57f,Color.web("#be4af7")),
                                        new Stop(0.71f,Color.web("#ed5fc2")),
                                        new Stop(0.85f,Color.web("#ef504c")),
                                        new Stop(1,Color.web("#f2660f")))
            })
        })
    }
    visible = true
  }
  
//  def timeline = new Timeline {
//    cycleCount = INDEFINITE
//    autoReverse = true
//    keyFrames = 
//      for(circle <- circlesToAnimate.result) yield {
//        new KeyFrame(0, values = List( // set start position at 0s
//            new KeyValue(circle.centerX, random * 800D intValue),
//            new KeyValue(circle.centerY, random * 600D intValue)
//          )
//        )
//        new KeyFrame(40000, values = List( // set end position at 40s
//            new KeyValue(circle.centerX, random * 800D intValue),
//            new KeyValue(circle.centerY, random * 600D intValue)
//          )
//        )      
//      }
//  }     
//  
//  timeline.play();      
  
}
