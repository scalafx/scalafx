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

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.util.converter.FormatStringConverter
import scalafx.Includes._
import scalafx.testutil.{BootstrapApplication, RunOnApplicationThread, SimpleSFXDelegateSpec}

import java.text.NumberFormat
import scala.language.implicitConversions

/**
 * Test for [[scalafx.scene.control.TextFormatter.Change]].
 */
class TextFormatterChangeSpec
    extends SimpleSFXDelegateSpec[jfxsc.TextFormatter.Change, TextFormatter.Change](
      classOf[jfxsc.TextFormatter.Change],
      classOf[TextFormatter.Change]
    )
    with RunOnApplicationThread {

  // A bit elaborated way of creating an instance of TextFormatter.Change that cannot be created directly.
  val change = {
    // Initialize JavaFX, just in case it is not running yet
    BootstrapApplication.launch()

    // Create a TextField and generate change by changing its `text` value
    var changeOption: Option[jfxsc.TextFormatter.Change] = None
    val textField = {
      val converter = new FormatStringConverter[Number](NumberFormat.getCurrencyInstance)
      val filter: (TextFormatter.Change) => TextFormatter.Change = { (c: TextFormatter.Change) =>
        // Capture `change` object created by JavaFX
        changeOption = Option(c)
        c
      }

      new TextField { textFormatter = new TextFormatter[Number](converter, 1000, filter) }
    }

    textField.text = "250"
    changeOption.get
  }

  override protected def getScalaClassInstance: TextFormatter.Change      = new TextFormatter.Change(change)
  override protected def getJavaClassInstance: jfxsc.TextFormatter.Change = change
}
