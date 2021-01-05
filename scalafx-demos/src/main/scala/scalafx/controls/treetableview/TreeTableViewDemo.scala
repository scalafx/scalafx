/*
 * Copyright (c) 2011-2021, ScalaFX Project
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

//noinspection TypeAnnotation

package scalafx.controls.treetableview

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.StringProperty
import scalafx.scene.Scene
import scalafx.scene.control.{TreeItem, TreeTableColumn, TreeTableView}
import scalafx.scene.image.Image

/**
 * ScalaFX version of the example from http://tutorials.jenkov.com/javafx/treetableview.html
 */
object TreeTableViewDemo extends JFXApp {

  class Car(brandName: String, modelName: String) {
    val brand = StringProperty(brandName)
    val model = StringProperty(modelName)
  }

  val brandColumn = new TreeTableColumn[Car, String]("Brand") {
    cellValueFactory = p => p.value.value.value.brand
    prefWidth = 150
  }

  val modelColumn = new TreeTableColumn[Car, String]("Model") {
    cellValueFactory = p => p.value.value.value.model
    prefWidth = 120
  }

  val mercedes = new TreeItem(new Car("Mercedes", "...")) {
    children = Seq(
      new TreeItem(new Car("Mercedes", "SL500")),
      new TreeItem(new Car("Mercedes", "SL500 AMG")),
      new TreeItem(new Car("Mercedes", "CLA 200"))
    )
  }

  val audi = new TreeItem(new Car("Audi", "...")) {
    children = Seq(
      new TreeItem(new Car("Audi", "A1")),
      new TreeItem(new Car("Audi", "A5")),
      new TreeItem(new Car("Audi", "A7"))
    )
  }

  stage = new PrimaryStage {
    title = "TreeTableView CellFactory Demo"
    icons += new Image("/scalafx/sfx.png")
    scene = new Scene {
      root = new TreeTableView[Car] {
        columns ++= Seq(brandColumn, modelColumn)
        root = new TreeItem(new Car("Cars", "...")) {
          children = Seq(audi, mercedes)
        }
      }
    }
  }
}
