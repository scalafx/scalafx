/*
 * Copyright (c) 2011, ScalaFX Project
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
package scalafx.animation

import scala.collection.JavaConversions._

import javafx.{ event => jfxe }
import javafx.{ animation => jfxa }
import scalafx.util.Duration
import scalafx.delegate.SFXDelegate

object KeyFrame {
  implicit def sfxKeyFrame2jfx(v: KeyFrame) = v.delegate

  /**
   * Creates a new KeyFrame instance
   *
   * @param time  the time
   * @param name the Name
   * @param onFinished  the onFinished-handler
   * @param values a ObservableList of KeyValue instances
   */
  def apply(time: Duration,
    name: String = null,
    onFinished: jfxe.EventHandler[jfxe.ActionEvent] = null,
    values: Set[_ <: KeyValue[_, _]] = Set.empty) = {
    val mappedValues: Set[jfxa.KeyValue] = values.map((x: KeyValue[_, _]) => x.delegate)
    new KeyFrame(new jfxa.KeyFrame(time, name, onFinished, mappedValues))
  }

}

class KeyFrame(override val delegate: jfxa.KeyFrame)
  extends SFXDelegate[jfxa.KeyFrame] {

  /**
   * Returns the time offset of this KeyFrame.
   */
  def time = delegate.getTime

  /**
   * Returns the name of this KeyFrame.
   */
  def name = delegate.getName

  /**
   * Returns the onFinished event handler of this KeyFrame.
   */
  def onFinished = delegate.getOnFinished

  /**
   * Returns an immutable Set of KeyValue instances.
   */
  def values = delegate.getValues
}