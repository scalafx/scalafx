/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import scala.language.implicitConversions
import java.io.File
import javafx.{ stage => jfxs }
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.StringProperty
import scalafx.delegate.SFXDelegate

object DirectoryChooser {
  implicit def sfxDirectoryChooser2jfx(dc: DirectoryChooser) = dc.delegate
}

class DirectoryChooser(override val delegate: jfxs.DirectoryChooser = new jfxs.DirectoryChooser)
  extends SFXDelegate[jfxs.DirectoryChooser] {

  /**
   * The initial directory for the displayed dialog.
   */
  def initialDirectory: ObjectProperty[File] = delegate.initialDirectoryProperty
  def initialDirectory_=(v: File) {
    initialDirectory() = v
  }

  /**
   * The title of the displayed dialog.
   */
  def title: StringProperty = delegate.titleProperty
  def title_=(v: String) {
    title() = v
  }

  /**
   * Shows a new directory selection dialog.
   */
  def showDialog(ownerWindow: Window): File = delegate.showDialog(ownerWindow)

  /**
   * Shows a new directory selection dialog.
   */
  def showDialog(): File = delegate.showDialog(null)
}
