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
package scalafx.scene.web

import javafx.scene.web as jfxsw
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Companion object for [[scalafx.scene.web.PopupFeatures]]
 */
object PopupFeatures {

  /**
   * Converts a ScalaFX PopupFeatures to its JavaFX counterpart.
   *
   * @param pe ScalaFX PopupFeatures
   * @return JavaFX PopupFeatures
   */
  implicit def sfxPopupFeatures2jfx(pe: PopupFeatures): jfxsw.PopupFeatures = if (pe != null) pe.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/PopupFeatures.html JavaFX PopupFeatures]]
 *
 * @constructor Creates a new PopupFeatures from its JavaFX counterpart.
 * @param delegate JavaFX PopupFeatures.
 */
class PopupFeatures(override val delegate: jfxsw.PopupFeatures)
    extends SFXDelegate[jfxsw.PopupFeatures] {

  /**
   * Creates a new instance.
   *
   * @param menu whether menu bar should be present
   * @param status whether status bar should be present
   * @param toolbar whether tool bar should be present
   * @param resizable whether popup window should be resizable
   */
  def this(menu: Boolean, status: Boolean, toolbar: Boolean, resizable: Boolean) =
    this(new jfxsw.PopupFeatures(menu, status, toolbar, resizable))

  /**
   * Returns whether menu bar should be present.
   */
  def hasMenu: Boolean = delegate.hasMenu

  /**
   * Returns whether status bar should be present.
   */
  def hasStatus: Boolean = delegate.hasStatus

  /**
   * Returns whether tool bar should be present.
   */
  def hasToolbar: Boolean = delegate.hasToolbar

  /**
   * Returns whether popup window should be resizable.
   */
  def resizable: Boolean = delegate.isResizable

}
