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
import scalafx.event.subscriptions.Subscription
import scalafx.geometry.Point2D
import scalafx.scene.Scene
import scalafx.scene.control.{ToggleButton, ToolBar, ToggleGroup}
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.{Pane, BorderPane}
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Ellipse, Line, Circle, Rectangle}

/** Demo illustrating use of event handler subscription.
  *
  * User can draw rectangles, ellipses, or lines. Shape type is selected by pressing corresponding
  * toggle button. For the sake of simplicity of the demo code, only one instance of shape of each
  * type is used. User draws a shape by pressing and dragging a mouse.
  *
  * Each shape type has its own mouse event handler. Only one handler is used at a time.
  * Handlers are implemented using a simple method `MouseEvent => Unit`. When switching handlers,
  * previous handler, if any, is cancelled using a `Subscription` pattern.
  */
object MultipleShapeDrawingDemo extends JFXApp {

  /** Handles drawing of rectangles */
  object RectangleInteractor extends ShapeDrawInteractor {
    val rectangle = new Rectangle {
      fill = Color.web("RED", 0.5)
    }
    /** Update the shape using current `start` and `end` points. */
    override def update() {
      rectangle.x = math.min(start.x, end.x)
      rectangle.y = math.min(start.y, end.y)
      rectangle.width = math.abs(start.x - end.x)
      rectangle.height = math.abs(start.y - end.y)
    }
  }

  /** Handles drawing of ellipses */
  object EllipseInteractor extends ShapeDrawInteractor {
    val ellipse = new Ellipse {
      fill = Color.web("GREEN", 0.5)
    }
    /** Update the shape using current `start` and `end` points. */
    override def update() {
      ellipse.centerX = start.x
      ellipse.centerY = start.y
      ellipse.radiusX = math.abs(start.x - end.x)
      ellipse.radiusY = math.abs(start.y - end.y)
    }
  }

  /** Handles drawing of lines */
  object LineInteractor extends ShapeDrawInteractor {
    val line = new Line {
      stroke = Color.web("BLUE", 0.5)
      strokeWidth = 3
    }
    /** Update the shape using current `start` and `end` points. */
    override def update() {
      line.startX = start.x
      line.startY = start.y
      line.endX = end.x
      line.endY = end.y
    }
  }

  val drawingPane = new Pane {
    // For simplicity of the demo, just add all shapes to canvas, single instance of each type.
    // Initially, they have zero area so they will not be visible.
    content ++= Seq(RectangleInteractor.rectangle, EllipseInteractor.ellipse, LineInteractor.line)
  }

  stage = new PrimaryStage {
    title = "Multiple Shape Drawing Demo"
    scene = new Scene(600, 400) {
      root = new BorderPane {
        top = new ToolBar {
          val alignToggleGroup = new ToggleGroup()
          content = List(
            new ToggleButton {
              id = "rectangle"
              graphic = new Rectangle {
                fill = Color.web("RED", 0.5)
                width = 32
                height = 32
              }
              toggleGroup = alignToggleGroup
            },
            new ToggleButton {
              id = "ellipse"
              graphic = new Circle {
                fill = Color.web("GREEN", 0.5)
                radius = 16
              }
              toggleGroup = alignToggleGroup
            },
            new ToggleButton {
              id = "line"
              graphic = new Line {
                stroke = Color.web("BLUE", 0.5)
                startX = 0
                startY = 0
                endX = 28
                endY = 28
                strokeWidth = 3
              }
              toggleGroup = alignToggleGroup
            }
          )

          // Subscription to the current mouse event handler
          var mouseHandlerSubscription: Option[Subscription] = None

          // Handle pressing to toggle buttons.
          alignToggleGroup.selectedToggle.onChange {
            // Cancel current mouse event handler
            mouseHandlerSubscription.foreach(_.cancel())
            // Determine which shape is selected
            val handlerId = alignToggleGroup.selectedToggle().asInstanceOf[javafx.scene.control.ToggleButton].id()
            val selectedHandler = handlerId match {
              case "rectangle" => Some(RectangleInteractor.handler)
              case "ellipse" => Some(EllipseInteractor.handler)
              case "line" => Some(LineInteractor.handler)
              case _ => None
            }
            // Selected corresponding handler
            mouseHandlerSubscription = selectedHandler match {
              case Some(h) => Some(drawingPane.handleEvent(MouseEvent.Any)(h))
              case None => None
            }
          }

          // Select first button. We do selection here, after the handling of button selection was defined,
          // so this initial selection can be handled the same way as any other selection.
          alignToggleGroup.selectToggle(alignToggleGroup.toggles(0))
        }
        center = drawingPane
      }
    }
  }

  trait MouseHandler {
    /** Return event handling method */
    def handler: MouseEvent => Unit
  }

  /** Encapsulates common behaviour of interaction when drawing a shape based on two points. */
  trait ShapeDrawInteractor extends MouseHandler {
    private var _start = new Point2D(0, 0)
    private var _end = new Point2D(0, 0)

    def start: Point2D = _start
    def start_=(p: Point2D) {
      _start = p
      _end = p
      update()
    }

    def end: Point2D = _end
    def end_=(p: Point2D) {
      _end = p
      update()
    }

    /** Update the shape using current `start` and `end` points. */
    def update()

    override def handler: MouseEvent => Unit = {
      me: MouseEvent => {
        me.eventType match {
          case MouseEvent.MousePressed => start = new Point2D(me.x, me.y)
          case MouseEvent.MouseDragged => end = new Point2D(me.x, me.y)
          case _ => {}
        }
      }
    }
  }
}
