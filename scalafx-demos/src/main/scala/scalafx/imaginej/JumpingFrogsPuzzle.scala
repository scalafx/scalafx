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

import Constants._
import scala._
import scalafx.Includes._
import scalafx.animation.Timeline
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}


/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 */

object Constants {
  //
  // absolute
  //
  // model
  //
  val NUMBER_OF_FROGS = 3
  //
  // view
  //
  val TITLE = "Jumping Frogs Puzzle"
  val SCALE = 2
  //
  // control
  //
  val TIME = 2.0
  //
  // absolute (up to SCALE)
  //
  //
  // view
  //
  // stones
  //
  val STONE_WIDTH = SCALE * 30
  val STONE_STROKE_WIDTH = SCALE * 1
  val STONE_GAP = SCALE * 6
  val STONE_HEIGHT = SCALE * 10
  val STONE_FILL = Color.WHITE
  val STONE_STROKE = Color.BLUE
  //
  // frogs
  //
  val FROG_RADIUS = SCALE * 6
  val GREEN_FROG_FILL = Color.DARKGREEN
  val RED_FROG_FILL = Color.DARKRED
  //
  // canvas
  //
  val CANVAS_HEIGHT = SCALE * 100
  val CANVAS_FILL = Color.LIGHTGRAY
  //
  // relative
  //
  // model
  //
  val NUMBER_OF_STONES = NUMBER_OF_FROGS * 2 + 1
  val STONE_NUMBER_LIST = (0 to NUMBER_OF_STONES - 1).toList
  //
  // view
  //
  // stones
  //
  val STONE_TOTAL_WIDTH = STONE_WIDTH + 2 * STONE_STROKE_WIDTH
  val STONE_TOTAL_HEIGHT = STONE_HEIGHT + 2 * STONE_STROKE_WIDTH
  val FIRST_STONE_X = STONE_TOTAL_WIDTH / 2
  val STONE_Y = CANVAS_HEIGHT - STONE_TOTAL_HEIGHT
  val STONE_STEP = STONE_TOTAL_WIDTH + STONE_GAP
  //
  // frogs
  //
  val FIRST_FROG_CENTER_X = STONE_TOTAL_WIDTH
  val FROG_CENTER_Y = STONE_Y - FROG_RADIUS
  //
  // canvas
  //
  val CANVAS_WIDTH = (NUMBER_OF_STONES + 1) * STONE_TOTAL_WIDTH + (NUMBER_OF_STONES - 1) * STONE_GAP
  //
}


///////////
// model //
///////////

//
// frog
//
trait Frog {
  def movesToRight: Boolean

  def movesToLeft: Boolean
}

class LeftFrog() extends Frog {
  def movesToRight = true

  def movesToLeft = false
}

class RightFrog() extends Frog {
  def movesToRight = false

  def movesToLeft = true
}

case object theDummyFrog extends Frog {
  def movesToRight = false

  def movesToLeft = false
}

//
// values
//
object theModelValues {
  private val optionalFrogs =
    for {
      i <- STONE_NUMBER_LIST
    } yield {
      if (i < NUMBER_OF_FROGS) {
        i -> Some(new LeftFrog())
      } else if (i == NUMBER_OF_FROGS) {
        i -> None
      } else {
        i -> Some(new RightFrog())
      }
    }

  val optionalFrogMap = optionalFrogs.toMap
}

//
// model
//
class Model(var optionalFrogMap: Map[Int, Option[Frog]]) {
  private def isAtRight(i: Int) =
    i == NUMBER_OF_STONES - 1

  private def isAtRightOrOneButRight(i: Int) =
    i == NUMBER_OF_STONES - 1 || i == NUMBER_OF_STONES - 2

  private def isAtLeft(i: Int) =
    i == 0

  private def isAtLeftOrOneButLeft(i: Int) =
    i == 0 || i == 1

  private val canMoveOneRightAt = (i: Int) =>
    !isAtRight(i) && optionalFrogMap(i + 1) == None

  private val canMoveTwoRightAt = (i: Int) =>
    !isAtRightOrOneButRight(i) &&
      optionalFrogMap(i + 1).get.movesToLeft &&
      optionalFrogMap(i + 2) == None

  private val canMoveOneLeftAt = (i: Int) =>
    !isAtLeft(i) && optionalFrogMap(i - 1) == None

  private val canMoveTwoLeftAt = (i: Int) =>
    !isAtLeftOrOneButLeft(i) &&
      optionalFrogMap(i - 1).get.movesToRight &&
      optionalFrogMap(i - 2) == None


  private def positionSingleton(frog: Frog) =
    for {
      (i, Some(`frog`)) <- optionalFrogMap
    } yield i

  private def update(next: Int => Int) = (frog: Frog) => {
    optionalFrogMap = for {
      entry@(i, _) <- optionalFrogMap
      j <- positionSingleton(frog)
    } yield {
      if (i == j) {
        i -> None
      } else if (i == next(j)) {
        i -> Some(frog)
      } else {
        entry
      }
    }
  }

  val position = (frog: Frog) => positionSingleton(frog).head

  val canJumpOneRight = canMoveOneRightAt compose position

  val canJumpTwoRight = canMoveTwoRightAt compose position

  val canJumpOneLeft = canMoveOneLeftAt compose position

  val canJumpTwoLeft = canMoveTwoLeftAt compose position

  val jumpOneRight = update(_ + 1)

  val jumpTwoRight = update(_ + 2)

  val jumpOneLeft = update(_ - 1)

  val jumpTwoLeft = update(_ - 2)

}

//////////
// view //
//////////

//
// canvas shape
//
case object theCanvasShape extends Rectangle {
  width = CANVAS_WIDTH
  height = CANVAS_HEIGHT
  fill = CANVAS_FILL
}

//
// stone shape
//
case class StoneShape(position: Int) extends Rectangle {
  x = FIRST_STONE_X + STONE_STEP * position
  y = STONE_Y
  width = STONE_WIDTH
  height = STONE_HEIGHT
  fill = STONE_FILL
  stroke = STONE_STROKE
  strokeWidth = STONE_STROKE_WIDTH
}

//
// frog shape
//
abstract class FrogShape(startPosition: Int, frog: Frog) extends Circle {
  val getFrog = frog
  centerX = FIRST_FROG_CENTER_X + STONE_STEP * startPosition
  centerY = FROG_CENTER_Y
  radius = FROG_RADIUS
}

case class GreenFrogShape(startPosition: Int, frog: Frog) extends FrogShape(startPosition, frog) {
  fill = GREEN_FROG_FILL
}

case class RedFrogShape(startPosition: Int, frog: Frog) extends FrogShape(startPosition, frog) {
  fill = RED_FROG_FILL
}

case object theDummyFrogShape extends FrogShape(-1, theDummyFrog)

//
// values
//
object theViewValues {
  val canvasShape =
    theCanvasShape

  val stoneShapes =
    for {
      i <- STONE_NUMBER_LIST
    } yield StoneShape(i)

  val frogShapes =
    for {
      i <- STONE_NUMBER_LIST
      frog <- theModelValues.optionalFrogMap(i)
    } yield {
      if (i < NUMBER_OF_FROGS) {
        GreenFrogShape(i, frog)
      } else if (i == NUMBER_OF_FROGS) {
        theDummyFrogShape
      } else {
        RedFrogShape(i, frog)
      }
    }
}

//
// view
//
class View(position: FrogShape => Int, val frogShapes: List[FrogShape]) {
  private def update(length: Int, next: (Double, Double) => Double) = (frogShape: FrogShape) => {
    val frogShapeCenterX = FIRST_FROG_CENTER_X + STONE_STEP * position(frogShape)
    val frogShapeCenterY = FROG_CENTER_Y

    Timeline(Seq(
      at(length * TIME s) {
        frogShape.centerY -> (frogShapeCenterY - length * STONE_STEP / 2)
      },
      at(length * TIME s) {
        frogShape.centerX -> next(frogShapeCenterX, length * STONE_STEP / 2)
      },
      at(2 * length * TIME s) {
        frogShape.centerY -> frogShapeCenterY
      },
      at(2 * length * TIME s) {
        frogShape.centerX -> next(frogShapeCenterX, length * STONE_STEP)
      }
    )).play()
  }

  val jumpOneRight = update(1, _ + _)

  val jumpTwoRight = update(2, _ + _)

  val jumpOneLeft = update(1, _ - _)

  val jumpTwoLeft = update(2, _ - _)
}

/////////////
// control //
/////////////

//
// control
//
class Control {
  def update(model: Model, view: View) {
    view.frogShapes.foreach {
      case `theDummyFrogShape` =>
      case frogShape => frogShape.onMouseClicked = {
        (_: MouseEvent) =>
          val frog = frogShape.getFrog
          if (model.canJumpOneRight(frog)) {
            view.jumpOneRight(frogShape)
            model.jumpOneRight(frog)
          } else if (model.canJumpTwoRight(frog)) {
            view.jumpTwoRight(frogShape)
            model.jumpTwoRight(frog)
          } else if (model.canJumpOneLeft(frog)) {
            view.jumpOneLeft(frogShape)
            model.jumpOneLeft(frog)
          } else if (model.canJumpTwoLeft(frog)) {
            view.jumpTwoLeft(frogShape)
            model.jumpTwoLeft(frog)
          }
          update(model, view)
      }
    }
  }
}

/////////
// mvc //
/////////

object theModel extends Model(
  theModelValues.optionalFrogMap)

object theView extends View(
  theModel.position compose (_.getFrog),
  theViewValues.frogShapes) {
  theControl.update(theModel, this)
}

object theControl extends Control

//////////////////////////
// jumping frogs puzzle //
//////////////////////////

object JumpingFrogsPuzzle extends JFXApp {

  stage = new PrimaryStage {
    title = TITLE
    scene = new Scene {
      content =
        theViewValues.canvasShape :: theViewValues.stoneShapes ::: theView.frogShapes
    }
  }
}

