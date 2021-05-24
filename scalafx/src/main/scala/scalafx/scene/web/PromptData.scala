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
package scalafx.scene.web

import javafx.scene.{web => jfxsw}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Companion object for [[scalafx.scene.web.PromptData]]
 */
object PromptData {

  /**
   * Converts a ScalaFX PromptData to its JavaFX counterpart.
   *
   * @param pd
   *   ScalaFX PromptData
   * @return
   *   JavaFX PromptData
   */
  implicit def sfxPromptData2jfx(pd: PromptData): jfxsw.PromptData = if (pd != null) pd.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/PromptData.htmlJavaFX PromptData]]
 *
 * @constructor
 *   Creates a new PromptData from its JavaFX counterpart.
 * @param delegate
 *   JavaFX PromptData.
 */
class PromptData(override val delegate: jfxsw.PromptData) extends SFXDelegate[jfxsw.PromptData] {

  /**
   * . Creates a new instance.
   */
  def this(message: String, defaultValue: String) = this(new jfxsw.PromptData(message, defaultValue))

  /**
   * Returns default value carried by this data object.
   */
  def defaultValue: String = delegate.getDefaultValue

  /**
   * Returns message carried by this data object.
   */
  def message: String = delegate.getMessage

}
