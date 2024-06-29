/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

package issues.issue190

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.{Clipboard, ClipboardContent, DataFormat}
import scalafx.scene.layout.VBox

import java.io.File
import scala.collection.JavaConverters._
import scala.language.implicitConversions

/**
 * @author Jarek Sacha
 */
object ClipboardTester extends JFXApp3 {

  override def start(): Unit = {
    stage = new PrimaryStage {
      scene = new Scene {
        title = "Clipboard Tester"
        root = new VBox {
          children = Seq(
            new Button {
              text = "Print clipboard"
              onAction = _ => {
                val systemClipboard = Clipboard.systemClipboard
                val contentTypes    = systemClipboard.contentTypes
                println(s"\nClipboard contains " + contentTypes.size + " type(s).")
                contentTypes.foreach { ct =>
                  println("Checking content type: " + ct)
                  val ctContent = systemClipboard.getContent(ct)
                  println("  " + ctContent)
                }
              }
            },
            new Button {
              text = "Clear clipboard"
              onAction = _ => Clipboard.systemClipboard.clear()
            },
            new Button {
              text = "Add file content (1)"
              onAction = _ => {
                val cc = new ClipboardContent()
                cc.putFiles(Seq(new File("one"), new File("two")))
                Clipboard.systemClipboard.content = cc
              }
            },
            new Button {
              text = "Add file content (2)"
              onAction = _ => {
                val cc = new ClipboardContent()
                cc.put(DataFormat.Files, Seq(new File("c:/tmp")).asJava)
                Clipboard.systemClipboard.content = cc
              }
            },
            new Button {
              text = "Add file content (3)"
              onAction = _ => {
                Clipboard.systemClipboard.content = ClipboardContent(
                  DataFormat.Files     -> Seq(new File("c:/tmp")).asJava,
                  DataFormat.PlainText -> "Hello Clipboard!"
                )
              }
            },
            new Button {
              text = "Add text/HTML content (1)"
              onAction = _ => {
                val clipboard = Clipboard.systemClipboard
                val content   = new ClipboardContent()
                content.putString("Some text")
                content.putHtml("<b>Some</b> text")
                clipboard.content = content
              }
            },
            new Button {
              text = "Add text/HTML content (2)"
              onAction = _ => {
                Clipboard.systemClipboard.content = ClipboardContent(
                  DataFormat.PlainText -> "Some text",
                  DataFormat.Html      -> "<b>Some</b> text"
                )
              }
            }
          )
        }
      }
    }
  }
}
