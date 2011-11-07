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

import javafx.scene.paint.Color

import scalafx.Includes._

import scalafx.animation.Timeline
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.stage.Stage

/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 */
object Constants {

  /////////////
  // general //
  /////////////

  val TITLE = "Jumping Frogs Puzzle"

  val SCALE = 2

  val TIME = 2.0

  ///////////
  // model //
  ///////////

  //
  // absolute
  //

  val NUMBER_OF_FROGS = 3

  //
  // relative
  //

  val NUMBER_OF_STONES = NUMBER_OF_FROGS * 2 + 1

  val STONE_NUMBER_LIST = (0 to NUMBER_OF_STONES - 1).toList

  //////////
  // view //
  //////////

  //
  // absolute
  //

  // stones

  val STONE_WIDTH = SCALE * 30
  val STONE_STROKE_WIDTH = SCALE * 1
  val STONE_GAP = SCALE * 6
  val STONE_HEIGHT = SCALE * 10
  val STONE_FILL = Color.WHITE
  val STONE_STROKE = Color.BLUE

  // frogs

  val FROG_RADIUS = SCALE * 6
  val GREEN_FROG_FILL = Color.DARKGREEN
  val RED_FROG_FILL = Color.DARKRED

  // canvas

  val CANVAS_HEIGHT = SCALE * 100
  val CANVAS_FILL = Color.LIGHTGRAY;

  //
  // relative
  //

  // stones

  val STONE_TOTAL_WIDTH = STONE_WIDTH + 2 * STONE_STROKE_WIDTH
  val FIRST_STONE_TX = STONE_TOTAL_WIDTH / 2
  val STONE_STEP = STONE_TOTAL_WIDTH + STONE_GAP
  val STONE_TOTAL_HEIGHT = STONE_HEIGHT + 2 * STONE_STROKE_WIDTH
  val STONE_TY = CANVAS_HEIGHT - STONE_TOTAL_HEIGHT

  // frogs

  val FIRST_FROG_TX = STONE_TOTAL_WIDTH
  val FROG_TY = STONE_TY - FROG_RADIUS

  // canvas

  val CANVAS_WIDTH = (NUMBER_OF_STONES + 1) * STONE_TOTAL_WIDTH + (NUMBER_OF_STONES - 1) * STONE_GAP

}

import Constants._

///////////
// model //
///////////

trait Frog {
  def isGreen: Boolean

  def isRed: Boolean
}

case class GreenFrog() extends Frog {
  def isGreen = true

  def isRed = false
}

case class RedFrog() extends Frog {
  def isGreen = false

  def isRed = true
}

case object TheDummyFrog extends Frog {
  def isGreen = false

  def isRed = false
}

class Model(private[this] var frogMap: Map[Int, Frog], val view: View) {
  view.setOnMouseClicked(this)

  private def isAtRight(position: Int) =
    position == NUMBER_OF_STONES - 1

  private def isAtRightOrOneButRight(position: Int) =
    position == NUMBER_OF_STONES - 1 || position == NUMBER_OF_STONES - 2

  private def isAtLeft(position: Int) =
    position == 0

  private def isAtLeftOrOneButLeft(position: Int) =
    position == 0 || position == 1

  private def moveUsing(move: Int => Int)(position: Int) {
    frogMap = (for {
      i <- STONE_NUMBER_LIST
    } yield {
      if (i == position) {
        (i, TheDummyFrog)
      } else if (i == move(position)) {
        (i, frogMap(position))
      } else {
        (i, frogMap(i))
      }
    }).toMap
    view.setOnMouseClicked(this)
  }

  def canMoveOneRightAt(position: Int) =
    !isAtRight(position) &&
      frogMap(position + 1) == TheDummyFrog

  def canMoveTwoRightAt(position: Int) =
    !isAtRightOrOneButRight(position) &&
      frogMap(position + 1).isRed &&
      frogMap(position + 2) == TheDummyFrog

  def canMoveOneLeftAt(position: Int) =
    !isAtLeft(position) &&
      frogMap(position - 1) == TheDummyFrog

  def canMoveTwoLeftAt(position: Int) =
    !isAtLeftOrOneButLeft(position) &&
      frogMap(position - 1).isGreen &&
      frogMap(position - 2) == TheDummyFrog

  def moveOneRightAt: Int => Unit =
    moveUsing(_ + 1)

  def moveTwoRightAt: Int => Unit =
    moveUsing(_ + 2)

  def moveOneLeftAt: Int => Unit =
    moveUsing(_ - 1)

  def moveTwoLeftAt: Int => Unit =
    moveUsing(_ - 2)
}

object TheModelValues {
  val frogs = for {
    i <- STONE_NUMBER_LIST
  } yield {
    if (i < NUMBER_OF_FROGS) {
      i -> GreenFrog()
    } else if (i == NUMBER_OF_FROGS) {
      i -> TheDummyFrog
    } else {
      i -> RedFrog()
    }
  }
}

//////////
// view //
//////////

class CanvasShape extends Rectangle

case class StoneShape(position: Int) extends Rectangle {
  x = FIRST_STONE_TX + STONE_STEP * position
  y = STONE_TY
  width = STONE_WIDTH
  height = STONE_HEIGHT
  fill = STONE_FILL
  stroke = STONE_STROKE
  strokeWidth = STONE_STROKE_WIDTH
}

class FrogShape(private[this] var position: Int) extends Circle {

  private def moveOneRight() {
    position = position + 1
  }

  private def moveTwoRight() {
    position = position + 2
  }

  private def moveOneLeft() {
    position = position - 1
  }

  private def moveTwoLeft() {
    position = position - 2
  }

  private def playTimeLine(length: Int, to: (Double, Double) => Double) {
    val currentCenterX = FIRST_FROG_TX + STONE_STEP * position
    val currentCenterY = FROG_TY

    Timeline(Seq(
      at(length * TIME s) {
        centerY -> {
          currentCenterY - length * STONE_STEP / 2
        }
      },
      at(length * TIME s) {
        centerX -> {
          to(currentCenterX, length * STONE_STEP / 2)
        }
      },
      at(2 * length * TIME s) {
        centerY -> {
          currentCenterY
        }
      },
      at(2 * length * TIME s) {
        centerX -> {
          to(currentCenterX, length * STONE_STEP)
        }
      }
    )).play()
  }

  private def jump(length: Int, to: (Double, Double) => Double, moveAt: (Model, Int) => Unit, move: FrogShape => Unit)(model: Model) {
    moveAt(model, position)
    playTimeLine(length, to)
    move(this)
  }

  def canJumpOneRight(model: Model) =
    model.canMoveOneRightAt(position)

  def canJumpTwoRight(model: Model) =
    model.canMoveTwoRightAt(position)

  def canJumpOneLeft(model: Model) =
    model.canMoveOneLeftAt(position)

  def canJumpTwoLeft(model: Model) =
    model.canMoveTwoLeftAt(position)

  def jumpOneRight: Model => Unit =
    jump(1, _ + _, _.moveOneRightAt(_), _.moveOneRight())

  def jumpTwoRight: Model => Unit =
    jump(2, _ + _, _.moveTwoRightAt(_), _.moveTwoRight())

  def jumpOneLeft: Model => Unit =
    jump(1, _ - _, _.moveOneLeftAt(_), _.moveOneLeft())

  def jumpTwoLeft: Model => Unit =
    jump(2, _ - _, _.moveTwoLeftAt(_), _.moveTwoLeft())

}

class RealFrogShape(position: Int) extends FrogShape(position) {
  centerX = FIRST_FROG_TX + STONE_STEP * position
  centerY = FROG_TY
  radius = FROG_RADIUS
}

case class GreenFrogShape(position: Int) extends RealFrogShape(position) {
  fill = GREEN_FROG_FILL
}

case class RedFrogShape(position: Int) extends RealFrogShape(position) {
  fill = RED_FROG_FILL
}

case object TheDummyFrogShape extends FrogShape(0) {
  centerX = 0
  centerY = 0
  radius = 0
  fill = CANVAS_FILL
}

case class View(canvasShape: CanvasShape, stoneShapes: List[StoneShape], frogShapes: List[FrogShape]) {
  def setOnMouseClicked(model: Model) {
    frogShapes.foreach {
      case frogShape@GreenFrogShape(_) => frogShape.onMouseClicked =
        if (frogShape.canJumpOneRight(model)) {
          frogShape.jumpOneRight(model)
        } else if (frogShape.canJumpTwoRight(model)) {
          frogShape.jumpTwoRight(model)
        }
      case frogShape@RedFrogShape(_) => frogShape.onMouseClicked =
        if (frogShape.canJumpOneLeft(model)) {
          frogShape.jumpOneLeft(model)
        } else if (frogShape.canJumpTwoLeft(model)) {
          frogShape.jumpTwoLeft(model)
        }
      case frogShape@TheDummyFrogShape =>
    }
  }
}

object TheViewValues {
  val canvasShape = new CanvasShape {
    width = CANVAS_WIDTH
    height = CANVAS_HEIGHT
    fill = CANVAS_FILL
  }

  val stoneShapes = {
    for {
      i <- STONE_NUMBER_LIST
    } yield StoneShape(i)
  }

  val frogShapes = {
    for {
      i <- STONE_NUMBER_LIST
    } yield {
      if (i < NUMBER_OF_FROGS) {
        GreenFrogShape(i)
      } else if (i == NUMBER_OF_FROGS) {
        TheDummyFrogShape
      } else {
        RedFrogShape(i)
      }
    }
  }
}

///////////////
// the model //
///////////////

import TheModelValues.frogs

object TheModel extends Model(frogs.toMap, TheView)

//////////////
// the view //
//////////////

import TheViewValues.canvasShape
import TheViewValues.stoneShapes
import TheViewValues.frogShapes

object TheView extends View(canvasShape, stoneShapes, frogShapes)

//////////////////////////////////
// the jumping frogs puzzle app //
//////////////////////////////////

import TheModel.view

object JumpingFrogsPuzzle extends JFXApp {
  stage = new Stage {
    title = TITLE
    scene = new Scene {
      content =
        view.canvasShape ::
          view.stoneShapes :::
          view.frogShapes
    }
  }
}