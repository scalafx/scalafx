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
package scalafx.event

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.{Pos, Point2D}
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.{Pane, BorderPane}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

/** Demo illustrating basic use of `handleEvent(..){...}` construct provided by `EventHandlerDelegate`.
  * Here we will handle mouse events. When user presses and drags the mouse over
  * the central pane a rectangle is drawn. Opposite corners of the rectangle are defined
  * by the points where user pressed the mouse and position of the mouse during dragging.
  *
  * Note that is important to use `import scalafx.Includes._`, without it you may get errors like:
  * {{{
  *   error No implicit view available from javafx.scene.input.MouseEvent => scalafx.scene.input.MouseEvent.
  *   me: MouseEvent => ...
  * }}}
  */
object RectangleDrawingDemo extends JFXApp {

  /** Encapsulate handle updates to the rectangle */
  object Updater {
    private var _start = new Point2D(0, 0)
    private var _end = new Point2D(0, 0)

    val rectangle = new Rectangle {
      fill = Color.BLUE
    }

    /** Update location of the rectangle proving two defining point (along the diameter) */
    def update(start: Point2D = _start, end: Point2D = _end) {
      _start = start
      _end = end
      rectangle.x = math.min(_start.x, _end.x)
      rectangle.y = math.min(_start.y, _end.y)
      rectangle.width = math.abs(_start.x - _end.x)
      rectangle.height = math.abs(_start.y - _end.y)
    }
  }

  val pane = new Pane {
    // Add rectangle that will be updated with user interactions
    content += Updater.rectangle
  }

  // Define handling of mouse events
  pane.handleEvent(MouseEvent.Any) {
    me: MouseEvent => {
      me.eventType match {
        case MouseEvent.MousePressed => {
          // Reset the shape
          val p = new Point2D(me.x, me.y)
          Updater.update(p, p)
        }
        case MouseEvent.MouseDragged => {
          // Adjust the shape
          Updater.update(end = new Point2D(me.x, me.y))
        }
        case _ => {}
      }
    }
  }

  stage = new PrimaryStage {
    title = "Draw Rectangle Demo"
    scene = new Scene(600, 400) {
      root = new BorderPane {
        top = new Label {
          text = "Drag the mouse below to draw a rectangle"
          alignmentInParent = Pos.CENTER
        }
        center = pane
      }
    }
  }
}
