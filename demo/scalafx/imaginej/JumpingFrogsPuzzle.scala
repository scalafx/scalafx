package scalafx.imaginej

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

import scalafx.Includes._

import scalafx.animation.Timeline
import scalafx.application.JFXApp
import scalafx.stage.Stage
import scalafx.scene.Scene
import javafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}
import scala._
import scalafx.imaginej._

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
  val CANVAS_FILL = Color.LIGHTGRAY;
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

import Constants._

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
  val optionalFrogMap =
    (for {
      i <- STONE_NUMBER_LIST
    } yield {
      if (i < NUMBER_OF_FROGS) {
        i -> Some(new LeftFrog())
      } else if (i == NUMBER_OF_FROGS) {
        i -> None
      } else {
        i -> Some(new RightFrog())
      }
    }).toMap
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

  private def canMoveOneRightAt(i: Int) =
    !isAtRight(i) &&
      optionalFrogMap(i + 1) == None

  private def canMoveTwoRightAt(i: Int) =
    !isAtRightOrOneButRight(i) &&
      optionalFrogMap(i + 1).get.movesToLeft &&
      optionalFrogMap(i + 2) == None

  private def canMoveOneLeftAt(i: Int) =
    !isAtLeft(i) &&
      optionalFrogMap(i - 1) == None

  private def canMoveTwoLeftAt(i: Int) =
    !isAtLeftOrOneButLeft(i) &&
      optionalFrogMap(i - 1).get.movesToRight &&
      optionalFrogMap(i - 2) == None

  def positionOf(frog: Frog) =
    (for {
      (i, optionalFrog) <- optionalFrogMap
      if (optionalFrog == Some(frog))
    } yield i).head

  def canJumpOneRight(frog: Frog) =
    canMoveOneRightAt(positionOf(frog))

  def canJumpTwoRight(frog: Frog) =
    canMoveTwoRightAt(positionOf(frog))

  def canJumpOneLeft(frog: Frog) =
    canMoveOneLeftAt(positionOf(frog))

  def canJumpTwoLeft(frog: Frog) =
    canMoveTwoLeftAt(positionOf(frog))

  def update(next: Int => Int)(frog: Frog) {
    val j = positionOf(frog)
    optionalFrogMap = for {
      entry@(i, _) <- optionalFrogMap
    } yield {
      if (i == j) {
        (i, None)
      } else if (i == next(j)) {
        (i, optionalFrogMap(j))
      } else {
        entry
      }
    }
  }
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

class GreenFrogShape(startPosition: Int, frog: Frog) extends FrogShape(startPosition, frog) {
  fill = GREEN_FROG_FILL
}

class RedFrogShape(startPosition: Int, frog: Frog) extends FrogShape(startPosition, frog) {
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

  val dummyFrogShape =
    theDummyFrogShape

  import theModelValues.optionalFrogMap

  val optionalFrogShapes =
    for {
      i <- STONE_NUMBER_LIST
    } yield {
      if (i < NUMBER_OF_FROGS) {
        Some(new GreenFrogShape(i, optionalFrogMap(i).get))
      } else if (i == NUMBER_OF_FROGS) {
        None
      } else {
        Some(new RedFrogShape(i, optionalFrogMap(i).get))
      }
    }
}

//
// view
//
class View(model: Model, control: Control, val optionalFrogShapes: List[Option[FrogShape]]) {
  control.update(model, this)

  private def update(length: Int, next: (Double, Double) => Double)(frogShape: FrogShape) {
    val frogShapeCenterX = FIRST_FROG_CENTER_X + STONE_STEP * model.positionOf(frogShape.getFrog)
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

  def jumpOneRight(frogShape: FrogShape) {
    update(1, _ + _)(frogShape)
    model.update(_ + 1)(frogShape.getFrog)
    control.update(model, this)
  }

  def jumpTwoRight(frogShape: FrogShape) {
    update(2, _ + _)(frogShape)
    model.update(_ + 2)(frogShape.getFrog)
    control.update(model, this)
  }

  def jumpOneLeft(frogShape: FrogShape) {
    update(1, _ - _)(frogShape)
    model.update(_ - 1)(frogShape.getFrog)
    control.update(model, this)
  }

  def jumpTwoLeft(frogShape: FrogShape) {
    update(2, _ - _)(frogShape)
    model.update(_ - 2)(frogShape.getFrog)
    control.update(model, this)
  }
}

/////////////
// control //
/////////////

//
// control
//

class Control {
  def update(model: Model, view: View) {
    view.optionalFrogShapes.foreach {
      case Some(frogShape) => frogShape.onMouseClicked =
        if (model.canJumpOneRight(frogShape.getFrog)) {
          view.jumpOneRight(frogShape)
        } else if (model.canJumpTwoRight(frogShape.getFrog)) {
          view.jumpTwoRight(frogShape)
        } else if (model.canJumpOneLeft(frogShape.getFrog)) {
          view.jumpOneLeft(frogShape)
        } else if (model.canJumpTwoLeft(frogShape.getFrog)) {
          view.jumpTwoLeft(frogShape)
        }
      case None =>
    }
  }
}

/////////
// mvc //
/////////

import theModelValues.optionalFrogMap

object theModel extends Model(optionalFrogMap)

object theControl extends Control

import theViewValues.optionalFrogShapes

object theView extends View(theModel, theControl, optionalFrogShapes)

//////////////////////////
// jumping frogs puzzle //
//////////////////////////

object JumpingFrogsPuzzle extends JFXApp {

  import theViewValues.canvasShape
  import theViewValues.stoneShapes
  import theViewValues.dummyFrogShape
  import theView.optionalFrogShapes

  val frogShapes =
    for {
      optionalFrogShape <- optionalFrogShapes
    } yield {
      optionalFrogShape match {
        case Some(frogShape) => frogShape
        case None => dummyFrogShape
      }
    }

  stage = new Stage {
    title = TITLE
    scene = new Scene {
      content =
        canvasShape :: stoneShapes ::: frogShapes
    }
  }
}
