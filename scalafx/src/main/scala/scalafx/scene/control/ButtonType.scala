/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.ButtonBar.ButtonData

/**
 * Object companion for [[scalafx.scene.control.ButtonType]].
 */
object ButtonType {
  /**
   * Converts a ScalaFX ButtonType to its JavaFX counterpart.
   *
   * @param v ScalaFX ButtonType
   * @return JavaFX ButtonType
   */
  implicit def sfxButtonType2jfx(v: ButtonType): jfxsc.ButtonType =
    if (v != null) v.delegate else null

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "Apply" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of [[scalafx.scene.control.ButtonBar.ButtonData.Apply]].
   */
  val Apply: ButtonType = jfxsc.ButtonType.APPLY

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "OK" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of 
   * [[scalafx.scene.control.ButtonBar.ButtonData.OKDone]].
   */
  val OK: ButtonType = jfxsc.ButtonType.OK

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "Cancel" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of
   * [[scalafx.scene.control.ButtonBar.ButtonData.CancelClose]]\.
   */
  val Cancel: ButtonType = jfxsc.ButtonType.CANCEL

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "Close" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of
   * [[scalafx.scene.control.ButtonBar.ButtonData.CancelClose]]\.
   */
  val Close: ButtonType = jfxsc.ButtonType.CLOSE

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "Yes" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of
   * [[scalafx.scene.control.ButtonBar.ButtonData.Yes]].
   */
  val Yes: ButtonType = jfxsc.ButtonType.YES

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "No" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of
   * [[scalafx.scene.control.ButtonBar.ButtonData.No]].
   */
  val No: ButtonType = jfxsc.ButtonType.NO

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "Finish" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of
   * [[scalafx.scene.control.ButtonBar.ButtonData.Finish]].
   */
  val Finish: ButtonType = jfxsc.ButtonType.FINISH

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "Next" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of
   * [[scalafx.scene.control.ButtonBar.ButtonData.NextForward]].
   */
  val Next: ButtonType = jfxsc.ButtonType.NEXT

  /**
   * A pre-defined [[scalafx.scene.control.ButtonType]] that displays "Previous" and has a
   * [[scalafx.scene.control.ButtonBar.ButtonData]] of
   * [[scalafx.scene.control.ButtonBar.ButtonData.BackPrevious]].
   */
  val Previous: ButtonType = jfxsc.ButtonType.PREVIOUS
}

/**
 *
 * The ButtonType is used to specify which buttons should be shown to users in the dialogs.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * @define TC ButtonType
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ButtonType.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class ButtonType(override val delegate: jfxsc.ButtonType)
  extends SFXDelegate[jfxsc.ButtonType] {

  def this(text: String) = this(new jfxsc.ButtonType(text))

  def this(text: String, buttonData: ButtonData) = this(new jfxsc.ButtonType(text, buttonData))

  /**
   * Returns the ButtonData specified for this ButtonType in the constructor.
   */
  val buttonData: ButtonData = delegate.getButtonData

  /**
   * Returns the text specified for this ButtonType in the constructor;
   */
  val text: String = delegate.getText
}