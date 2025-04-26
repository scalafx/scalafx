/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

package scalafx.controls.treetableview

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.beans.property.{ObjectProperty, StringProperty}
import scalafx.scene.Scene
import scalafx.scene.control.{TreeItem, TreeTableCell, TreeTableColumn, TreeTableView}
import scalafx.scene.image.Image
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle

/**
 * ScalaFX version of the example from http://tutorials.jenkov.com/javafx/treetableview.html
 */
//noinspection TypeAnnotation
object TreeTableViewDemo extends JFXApp3:

  val translucentColor = Color(0, 0, 0, 0)

  class Car(brandName: String, modelName: String, sampleColor: Color):
    val brand = StringProperty(brandName)
    val model = StringProperty(modelName)
    val color = ObjectProperty[Color](sampleColor)

  val mercedes = new TreeItem(new Car("Mercedes", "", translucentColor)):
    children = Seq(
      new TreeItem(new Car("Mercedes", "SL500", Color.Aqua)),
      new TreeItem(new Car("Mercedes", "SL500 AMG", Color.Aquamarine)),
      new TreeItem(new Car("Mercedes", "CLA 200", Color.Silver))
    )

  val audi = new TreeItem(new Car("Audi", "", translucentColor)):
    children = Seq(
      new TreeItem(new Car("Audi", "A1", Color.Crimson)),
      new TreeItem(new Car("Audi", "A5", Color.Chocolate)),
      new TreeItem(new Car("Audi", "A7", Color.Coral))
    )

  override def start(): Unit =
    stage = new PrimaryStage:
      title = "TreeTableView CellFactory Demo"
      icons += new Image("/scalafx/sfx.png")
      scene = new Scene:
        root = new TreeTableView[Car]:
          columns ++= Seq(
            new TreeTableColumn[Car, String]("Brand"):
              cellValueFactory = _.value.value.value.brand
              prefWidth =
                150
            ,
            new TreeTableColumn[Car, String]("Model"):
              cellValueFactory = _.value.value.value.model
              prefWidth =
                120
            ,
            new TreeTableColumn[Car, Color]("Color"):
              cellValueFactory = _.value.value.value.color
              cellFactory = (cell: TreeTableCell[Car, Color], value: Color) =>
                cell.graphic = new Circle:
                  fill = value
                  radius = 8
              prefWidth = 120
          )
          root = new TreeItem(new Car("Cars", "", translucentColor)):
            children = Seq(
              audi,
              mercedes
            )
