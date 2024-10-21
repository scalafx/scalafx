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

package scalafx.stage
import javafx.{stage => jfxs}
import org.scalatest.matchers.should.Matchers._
import scalafx.Includes._
import scalafx.stage.FileChooser.ExtensionFilter
import scalafx.testutil.{RunOnApplicationThread, SimpleSFXDelegateSpec}

/**
 * FileChooser Spec tests.
 */
class FileChooserSpec
    extends SimpleSFXDelegateSpec[jfxs.FileChooser, FileChooser](classOf[jfxs.FileChooser], classOf[FileChooser])
    with RunOnApplicationThread {

  it should "Allow `Seq` of ScalaFX `ExtensionFilter`s" in {
    val fileChooser = new FileChooser {
      title = "Open Resource File"
      extensionFilters ++= Seq(
        new ExtensionFilter("Text Files", "*.txt"),
        new ExtensionFilter("Image Files", Seq("*.png", "*.jpg", "*.gif")),
        new ExtensionFilter("Audio Files", Seq("*.wav", "*.mp3", "*.aac")),
        new ExtensionFilter("All Files", "*.*")
      )
    }

    fileChooser.extensionFilters.size() should be(4)
  }

  it should "Allow `Seq` of JavaFX `ExtensionFilter`s" in {
    val fileChooser = new FileChooser {
      title = "Open Resource File"
      extensionFilters ++= Seq(
        new jfxs.FileChooser.ExtensionFilter("Text Files", "*.txt"),
        new jfxs.FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
        new jfxs.FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
        new jfxs.FileChooser.ExtensionFilter("All Files", "*.*")
      )
    }

    fileChooser.extensionFilters.size() should be(4)
  }
}
