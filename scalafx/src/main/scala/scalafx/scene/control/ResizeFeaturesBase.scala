/*
 * Copyright (c) 2011-2023, ScalaFX Project
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

import javafx.scene.control as jfxsc
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.ControlIncludes.jfxTableColumnBase2sfx

import scala.language.implicitConversions

/**
 * Object companion for [[scalafx.scene.control.ResizeFeaturesBase]]
 *
 * @since 8.0
 */
object ResizeFeaturesBase {

  /**
   * Converts a ScalaFX ResizeFeaturesBase to its JavaFX counterpart.
   *
   * @param rfb A ScalaFX ResizeFeaturesBase
   * @return JavaFX ResizeFeaturesBase
   * @tparam S The type of the UI control (e.g. the type of the 'row').
   */
  implicit def sfxResizeFeaturesBase2jfx[S](rfb: ResizeFeaturesBase[S]): jfxsc.ResizeFeaturesBase[S] =
    if (rfb != null) rfb.delegate else null

}

/**
 * Wraps JavaFX [[http://docs.oracle.com/javafx/8/api/javafx/scene/control/ResizeFeaturesBase.html ResizeFeaturesBase]].
 *
 * @constructor Creates a new ScalaFX ResizeFeaturesBase from a JavaFX ResizeFeaturesBase.
 * @param delegate JavaFX ResizeFeaturesBase to be wrapped.
 * @tparam S The type of the UI control (e.g. the type of the 'row').
 * @since 8.0
 */
abstract class ResizeFeaturesBase[S](override val delegate: jfxsc.ResizeFeaturesBase[S])
    extends SFXDelegate[jfxsc.ResizeFeaturesBase[S]] {

  /**
   * The column upon which the resize is occurring, or null if this ResizeFeatures instance was
   * created as a result of a resize operation.
   */
  def column: TableColumnBase[S, _] = jfxTableColumnBase2sfx(delegate.getColumn)

  /**
   * The amount of horizontal space added or removed in the resize operation.
   */
  def delta: Double = delegate.getDelta

}
