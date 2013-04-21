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
package scalafx.controls

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.Hyperlink
import scalafx.scene.control.Label
import scalafx.scene.control.Pagination
import scalafx.scene.layout.AnchorPane
import scalafx.scene.layout.VBox

/**
 * Demo application based on Pagination example at [[http://docs.oracle.com/javafx/2/ui_controls/pagination.htm]].
 */
object PaginationSample extends JFXApp {

  private val itemsPerPage = 8

  private def createPage(pageIndex: Int): VBox = {

      def getPage(i: Int) = {
        val link = new Hyperlink {
          text = "Item " + (i + 1)
          visited = true
        }
        new VBox {
          content = List(link,
            new Label("""|Search results
                         |for %s""".stripMargin.format(link.text.value)))
        }
      }

    val page = pageIndex * itemsPerPage
    new VBox(5) {
      content = (page until (page + itemsPerPage)).map(getPage(_))
    }
  }

  private def getAnchorPage(pagination: Pagination): AnchorPane = {
    AnchorPane.setTopAnchor(pagination, 10.0)
    AnchorPane.setRightAnchor(pagination, 10.0)
    AnchorPane.setBottomAnchor(pagination, 10.0)
    AnchorPane.setLeftAnchor(pagination, 10.0)

    new AnchorPane {
      content = pagination
    }
  }

  val pagination = new Pagination(28, 0) {
    style = "-fx-border-color:red;"
    pageFactory = (pageIndex: Int) => createPage(pageIndex)
  }
  val anchor = this.getAnchorPage(pagination)

  stage = new PrimaryStage {
    title = "PaginationSample by ScalaFX"
    scene = new Scene {
      content = anchor
    }
  }

}