/*
 * Copyright (c) 2012, ScalaFX Project
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
package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import javafx.{ event => jfxe }
import scalafx.util.SFXDelegate

object TouchPoint {
  implicit def sfxTouchPoint2jfx(tp: TouchPoint) = tp.delegate
}

class TouchPoint(override val delegate: jfxsi.TouchPoint)
  extends SFXDelegate[jfxsi.TouchPoint] {

  /**
   * Distinguishes between touch points targeted to the given node or some of its children from touch points targeted
   * somewhere else.
   */
  def belongsTo(target: jfxe.EventTarget) = delegate.belongsTo(target)

  /**
   * Grabs this touch point by current event source.
   */
  def grab = delegate.grab

  /**
   * Grabs this touch point by the given target.
   */
  def grab(target: jfxe.EventTarget) = delegate.grab(target)

  /**
   * Gets event target which has grabbed this touch point.
   */
  def grabbed = delegate.getGrabbed

  /**
   * Gets identifier of this touch point.
   */
  def id = delegate.getId

  /**
   * Gets the horizontal position of the touch point relative to the origin of the Scene that contains the TouchEvent's
   * source.
   */
  def sceneX = delegate.getSceneX

  /**
   * Gets the vertical position of the touch point relative to the origin of the Scene that contains the TouchEvent's
   * source.
   */
  def sceneY = delegate.getSceneY

  /**
   * Gets the absolute horizontal position of the touch point.
   */
  def screenX = delegate.getScreenX

  /**
   * Gets the absolute vertical position of the touch point.
   */
  def screenY = delegate.getScreenY

  /**
   * Gets state of this touch point
   */
  def state = delegate.getState

  /**
   * Gets event target on which the touch event carrying this touch point is fired.
   */
  def target = delegate.getTarget

  /**
   * Gets the horizontal position of the touch point relative to the origin of the TouchEvent's source.
   */
  def x = delegate.getX

  /**
   * Gets the vertical position of the touch point relative to the origin of the TouchEvent's source.
   */
  def y = delegate.getY

  /**
   *
   */
  def ungrab = delegate.ungrab
}