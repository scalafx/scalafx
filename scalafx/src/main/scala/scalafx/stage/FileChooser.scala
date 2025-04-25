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

package scalafx.stage

import javafx.collections.ObservableList
import javafx.stage as jfxs
import scalafx.Includes.*
import scalafx.beans.property.{ObjectProperty, StringProperty}
import scalafx.delegate.SFXDelegate
import scalafx.stage.FileChooser.ExtensionFilter
import scalafx.util.JavaConverters.*

import java.io.File
import scala.language.implicitConversions

object FileChooser {
  implicit def sfxFileChooser2jfx(fc: FileChooser): jfxs.FileChooser = if (fc != null) fc.delegate else null

  object ExtensionFilter {
    implicit def sfxExtensionFilter2jfx(ef: ExtensionFilter): jfxs.FileChooser.ExtensionFilter =
      if (ef != null) ef.delegate else null
  }

  class ExtensionFilter(override val delegate: jfxs.FileChooser.ExtensionFilter)
      extends SFXDelegate[jfxs.FileChooser.ExtensionFilter] {

    /**
     * Creates an ExtensionFilter with the specified description and the file name extensions.
     * File name extension should be specified in the `*.<extension>` format.
     */
    def this(description: String, extensions: Seq[String]) =
      this(new jfxs.FileChooser.ExtensionFilter(description, extensions.asJava))

    /**
     * Creates an ExtensionFilter with the specified description and the file name extension.
     * This is a convenience constructor for a common situations when only one extension is used.
     * File name extension should be specified in the `*.<extension>` format.
     */
    def this(description: String, extension: String) =
      this(new jfxs.FileChooser.ExtensionFilter(description, extension))

    /*
     * Creates an ExtensionFilter with the specified description and the file name extensions.
     * NOTE IMPLEMENTATION: for constructor with extensions varargs compile complaints with message: "double definition: constructor
     * ExtensionFilter:(description: String, extensions: String*)scalafx.stage.FileChooser.ExtensionFilter and constructor
     * ExtensionFilter:(description: String, extensions: Seq[String])scalafx.stage.FileChooser.ExtensionFilter
     * at line XX have same type after erasure: (description: java.lang.String, extensions: Seq)scalafx.stage.FileChooser#ExtensionFilter".
     * So I decided maintain just Seq constructor.
     */
    //        def this(description: String, extensions: String*) = this(new jfxs.FileChooser.ExtensionFilter(description, extensions: _*))

    def description: String = delegate.getDescription

    def extensions: Seq[String] = delegate.getExtensions.asScala.toSeq

  }

}

/**
 * Provides support for standard platform file dialogs.
 * These dialogs have look and feel of the platform UI components which is independent of JavaFX.
 *
 * Example:
 * {{{
 * import scalafx.Includes._
 * import scalafx.stage.FileChooser
 * import scalafx.stage.FileChooser.ExtensionFilter
 *
 * ...
 *
 * val fileChooser = new FileChooser {
 *  title = "Open Resource File"
 *  extensionFilters ++= Seq(
 *    new ExtensionFilter("Text Files", "*.txt"),
 *    new ExtensionFilter("Image Files", Seq("*.png", "*.jpg", "*.gif")),
 *    new ExtensionFilter("Audio Files", Seq("*.wav", "*.mp3", "*.aac")),
 *    new ExtensionFilter("All Files", "*.*")
 *  )
 * }
 * val selectedFile = fileChooser.showOpenDialog(stage)
 * if (selectedFile != null) {
 *  stage.display(selectedFile);
 * }
 * }}}
 */
class FileChooser(override val delegate: jfxs.FileChooser = new jfxs.FileChooser)
    extends SFXDelegate[jfxs.FileChooser] {

  /**
   * The initial directory for the displayed dialog.
   */
  def initialDirectory: ObjectProperty[File] = delegate.initialDirectoryProperty

  def initialDirectory_=(v: File): Unit = {
    ObjectProperty.fillProperty[File](initialDirectory, v)
  }

  /** The initial file name for the displayed dialog. */
  def initialFileName: ObjectProperty[String] = delegate.initialFileNameProperty

  def initialFileName_=(v: String): Unit = {
    ObjectProperty.fillProperty[String](initialFileName, v)
  }

  /**
   * This property is used to pre-select the extension filter for the next displayed dialog
   * and to read the user-selected extension filter from the dismissed dialog.
   */
  def selectedExtensionFilter: ObjectProperty[jfxs.FileChooser.ExtensionFilter] =
    delegate.selectedExtensionFilterProperty

  def selectedExtensionFilter_=(v: ExtensionFilter): Unit = {
    ObjectProperty.fillProperty[jfxs.FileChooser.ExtensionFilter](selectedExtensionFilter, v)
  }

  /**
   * The title of the displayed dialog.
   */
  def title: StringProperty = delegate.titleProperty

  def title_=(v: String): Unit = {
    title() = v
  }

  /**
   * Gets the extension filters used in the displayed file dialog.
   */
  def extensionFilters: ObservableList[jfxs.FileChooser.ExtensionFilter] = delegate.getExtensionFilters

  /**
   * Shows a new file open dialog.
   *
   * @return the selected file or null if no file has been selected
   */
  def showOpenDialog(ownerWindow: Window): File = delegate.showOpenDialog(ownerWindow)

  /**
   * Shows a new file open dialog in which multiple files can be selected.
   *
   * @return the selected files or null if no file has been selected
   */
  def showOpenMultipleDialog(ownerWindow: Window): Seq[File] = {
    val selection = delegate.showOpenMultipleDialog(ownerWindow)
    if (selection != null) selection.asScala.toSeq else null.asInstanceOf[Seq[File]]
  }

  /**
   * Shows a new file save dialog.
   *
   * @return the selected file or null if no file has been selected
   */
  def showSaveDialog(ownerWindow: Window): File = delegate.showSaveDialog(ownerWindow)

}
