/*
 * Copyright (c) 2012-2013, ScalaFX Project
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

package issues.issue14

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.ObjectProperty
import scalafx.event.ActionEvent
import scalafx.geometry.{Pos, Insets}
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.layout.{BorderPane, HBox}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle


/** Example for ScalaFX Issue 14 [[http://code.google.com/p/scalafx/issues/detail?id=14]].
  *
  * The example illustrates problem with `ObjectProperty` holding a ScalaFX wrapper,
  * it cannot bind to component properties.
  * In example here we have to use JavaFX `Color` as value type for `ObjectProperty` to able to bind it
  * to `Rectangle#fill`.
  */
object ChangeFillExample extends JFXApp {

  // NOTE: We use here `ObjectProperty` factory method rather than constructor to indirectly create
  // an `ObjectProperty` that has JFX rather than SFX value type.
  // Without that we will have problems with binding `fillPaint` to `fill` in the `Rectangle`.
  // Compiler would throw:
  //   error: overloaded method value <== with alternatives:
  //   (v: scalafx.beans.value.ObservableValue[_ <: javafx.scene.paint.Paint, _ <: javafx.scene.paint.Paint])Unit <and>
  //   (v: javafx.beans.value.ObservableValue[_ <: javafx.scene.paint.Paint])Unit
  //   cannot be applied to (scalafx.beans.property.ObjectProperty[scalafx.scene.paint.Paint])
  //   fill <== fillPaint
  val fillPaint = ObjectProperty(this, "fillPaint", Color.LIGHTGRAY)
  val Light = Color.LIGHTGRAY
  val Dark = Color.GRAY

  stage = new PrimaryStage {
    title = "Change Fill Example"
    scene = new Scene {
      root = new BorderPane {
        padding = Insets(10)
        center = new Rectangle {
          width = 200
          height = 200
          // Binding here fails to compile if `ObjectProperty` value type is ScalaFX color.
          fill <== fillPaint
        }
        bottom = new HBox {
          padding = Insets(10)
          alignmentInParent = Pos.CENTER
          content = new Button {
            text = "Change Fill"
            onAction = (ae: ActionEvent) => fillPaint() = if (Light == fillPaint()) Dark else Light
          }
        }
      }
    }
  }
}
