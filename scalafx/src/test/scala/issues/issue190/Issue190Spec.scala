/*
 * Copyright (c) 2011-2020, ScalaFX Project
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

import java.io.File

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import scalafx.scene.input.{Clipboard, ClipboardContent, DataFormat}
import scalafx.testutil.RunOnApplicationThread

import scala.collection.JavaConverters._

/** Issue 190: Convenience methods not working for clipboard */
class Issue190Spec extends AnyFlatSpec with RunOnApplicationThread {

  "ClipboardContent" should "be assignable to the content of the clipboard" in {
    Clipboard.systemClipboard.content = new ClipboardContent()

    //    Clipboard.systemClipboard.content.size shouldBe 0
  }

  "ClipboardContent" should "be assignable from Map[DataFormat, T <: AnyRef]" in {

    val files = List(new File("Test"))
    //    Clipboard.systemClipboard.content = ClipboardContent(Map(DataFormat.Files -> files.asJava))
    //    val content = Clipboard.systemClipboard.content
    val content = ClipboardContent(Map(DataFormat.Files -> files.asJava))
    content.hasFiles shouldBe true

    val contentFiles = content.files
    contentFiles.length shouldBe 1
    contentFiles.head.getName shouldBe "Test"
  }

  "ClipboardContent" should "be assignable from `DataFormat -> value` pairs" in {

    //    Clipboard.systemClipboard.clear()

    //    Clipboard.systemClipboard.content = ClipboardContent(
    val content = ClipboardContent(
      DataFormat.Files     -> Seq(new File("Test"), new File("Test2")).asJava,
      DataFormat.PlainText -> "Test3"
    )

    //    val content = Clipboard.systemClipboard.content

    content.size shouldBe 2

    content.hasFiles shouldBe true
    val contentFiles = content.files
    contentFiles.length shouldBe 2
    contentFiles.head.getName shouldBe "Test"

    content.hasString shouldBe true
    content.string shouldBe "Test3"
  }

  "ClipboardContent" should "be assignable with `put` methods" in {

    //    Clipboard.systemClipboard.clear()

    val content = ClipboardContent()

    //    content +=  DataFormat.Files -> Seq(new File("Test"), new File("Test2")).asJava
    content.putFiles(Seq(new File("Test"), new File("Test2")))
    content.put(DataFormat.PlainText, "Test3")
    content.putHtml("<p/>")

    //    Clipboard.systemClipboard.content = cc

    //    val content = Clipboard.systemClipboard.content

    content.size shouldBe 3

    content.hasFiles shouldBe true
    val contentFiles = content.files
    contentFiles.length shouldBe 2
    contentFiles.head.getName shouldBe "Test"

    content.hasString shouldBe true
    content.string shouldBe "Test3"
  }
}
