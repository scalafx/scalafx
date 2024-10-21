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
package scalafx.scene.input

import javafx.scene.{input => jfxsi}
import javafx.{event => jfxe}
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.event.EventIncludes.jfxEventTarget2sfx
import scalafx.event.EventTarget

import scala.language.implicitConversions

object TouchPoint {
  implicit def sfxTouchPoint2jfx(tp: TouchPoint): jfxsi.TouchPoint = if (tp != null) tp.delegate else null

  object State
      extends SFXEnumDelegateCompanion[jfxsi.TouchPoint.State, State] {

    /**
     * The touch point has been moved
     */
    case object Moved extends State(jfxsi.TouchPoint.State.MOVED)

    @deprecated("Use Moved; MOVED will be removed in a future release", "8.0.60-R10")
    val MOVED: State = Moved

    /**
     * The touch point has been moved
     */
    case object Pressed extends State(jfxsi.TouchPoint.State.PRESSED)

    @deprecated("Use Pressed; PRESSED will be removed in a future release", "8.0.60-R10")
    val PRESSED: State = Pressed

    /**
     * The touch point remains pressed and still (without moving)
     */
    case object Stationary extends State(jfxsi.TouchPoint.State.STATIONARY)

    @deprecated("Use Stationary; STATIONARY will be removed in a future release", "8.0.60-R10")
    val STATIONARY: State = Stationary

    /**
     * The touch point has been released
     */
    case object Released extends State(jfxsi.TouchPoint.State.RELEASED)

    @deprecated("Use Released; RELEASED will be removed in a future release", "8.0.60-R10")
    val RELEASED: State = Released

    protected override def unsortedValues: Array[State] = Array(Moved, Pressed, Stationary, Released)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/TouchPoint.State.html]]
   */
  sealed abstract class State(override val delegate: jfxsi.TouchPoint.State)
      extends SFXEnumDelegate[jfxsi.TouchPoint.State]

}

class TouchPoint(override val delegate: jfxsi.TouchPoint)
    extends SFXDelegate[jfxsi.TouchPoint] {

  /**
   * Distinguishes between touch points targeted to the given node or some of its children from touch points targeted
   * somewhere else.
   */
  def belongsTo(target: jfxe.EventTarget): Boolean = delegate.belongsTo(target)

  /**
   * Grabs this touch point by current event source.
   */
  def grab(): Unit = {
    delegate.grab()
  }

  /**
   * Grabs this touch point by the given target.
   */
  def grab(target: EventTarget): Unit = {
    delegate.grab(target)
  }

  /**
   * Gets event target which has grabbed this touch point.
   */
  def grabbed: EventTarget = delegate.getGrabbed

  /**
   * Gets identifier of this touch point.
   */
  def id: Int = delegate.getId

  /**
   * Gets the horizontal position of the touch point relative to the origin of the Scene that contains the TouchEvent's
   * source.
   */
  def sceneX: Double = delegate.getSceneX

  /**
   * Gets the vertical position of the touch point relative to the origin of the Scene that contains the TouchEvent's
   * source.
   */
  def sceneY: Double = delegate.getSceneY

  /**
   * Gets the absolute horizontal position of the touch point.
   */
  def screenX: Double = delegate.getScreenX

  /**
   * Gets the absolute vertical position of the touch point.
   */
  def screenY: Double = delegate.getScreenY

  /**
   * Gets state of this touch point
   */
  def state: TouchPoint.State = TouchPoint.State.jfxEnum2sfx(delegate.getState)

  /**
   * Gets event target on which the touch event carrying this touch point is fired.
   */
  def target: EventTarget = delegate.getTarget

  /**
   * Gets the horizontal position of the touch point relative to the origin of the TouchEvent's source.
   */
  def x: Double = delegate.getX

  /**
   * Gets the vertical position of the touch point relative to the origin of the TouchEvent's source.
   */
  def y: Double = delegate.getY

  /**
   */
  def ungrab(): Unit = {
    delegate.ungrab()
  }
}
