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
package scalafx.stage

import javafx.{event => jfxe, stage => jfxs}
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventHandlerDelegate}

import scala.language.implicitConversions

object Window {
  implicit def sfxWindow2jfx(v: Window): jfxs.Window = if (v != null) v.delegate else null
}

class Window protected (override val delegate: jfxs.Window)
    extends EventHandlerDelegate
    with SFXDelegate[jfxs.Window]
    with jfxe.EventTarget {

  /**
   * Specifies the event dispatcher for this node.
   */
  def eventDispatcher: ObjectProperty[jfxe.EventDispatcher] = delegate.eventDispatcherProperty

  def eventDispatcher_=(v: jfxe.EventDispatcher): Unit = {
    eventDispatcher() = v
  }

  /**
   * Whether or not this Window has the keyboard or input focus.
   */
  def focused: ReadOnlyBooleanProperty = delegate.focusedProperty

  /**
   * The height of this Stage.
   */
  def height: ReadOnlyDoubleProperty = delegate.heightProperty

  def height_=(h: Double): Unit = {
    delegate.setHeight(h)
  }

  /**
   * Called when there is an external request to close this Window.
   */
  def onCloseRequest: ObjectProperty[jfxe.EventHandler[jfxs.WindowEvent]] = delegate.onCloseRequestProperty

  def onCloseRequest_=(v: jfxe.EventHandler[jfxs.WindowEvent]): Unit = {
    onCloseRequest() = v
  }

  /**
   * Called just after the Window has been hidden.
   */
  def onHidden: ObjectProperty[jfxe.EventHandler[jfxs.WindowEvent]] = delegate.onHiddenProperty

  def onHidden_=(v: jfxe.EventHandler[jfxs.WindowEvent]): Unit = {
    onHidden() = v
  }

  /**
   * Called just prior to the Window being hidden.
   */
  def onHiding: ObjectProperty[jfxe.EventHandler[jfxs.WindowEvent]] = delegate.onHidingProperty

  def onHiding_=(v: jfxe.EventHandler[jfxs.WindowEvent]): Unit = {
    onHiding() = v
  }

  /**
   * Called just prior to the Window being shown, even if the menu has no items to show.
   */
  def onShowing: ObjectProperty[jfxe.EventHandler[jfxs.WindowEvent]] = delegate.onShowingProperty

  def onShowing_=(v: jfxe.EventHandler[jfxs.WindowEvent]): Unit = {
    onShowing() = v
  }

  /**
   * Called just after the Window is shown.
   */
  def onShown: ObjectProperty[jfxe.EventHandler[jfxs.WindowEvent]] = delegate.onShownProperty

  def onShown_=(v: jfxe.EventHandler[jfxs.WindowEvent]): Unit = {
    onShown() = v
  }

  /**
   * Defines the opacity of the Stage as a value between 0.0 and 1.0.
   */
  def opacity: DoubleProperty = delegate.opacityProperty

  def opacity_=(v: Double): Unit = {
    opacity() = v
  }

  /**
   * The Scene to be rendered on this Stage.
   */
  def scene: ReadOnlyObjectProperty[javafx.scene.Scene] = delegate.sceneProperty

  /**
   * Whether or not this Stage is showing (that is, open on the user's system).
   */
  def showing: ReadOnlyBooleanProperty = delegate.showingProperty

  /**
   * The width of this Stage.
   */
  def width: ReadOnlyDoubleProperty = delegate.widthProperty

  def width_=(w: Double): Unit = {
    delegate.setWidth(w)
  }

  /**
   * The horizontal location of this Stage on the screen.
   */
  def x: ReadOnlyDoubleProperty = delegate.xProperty

  def x_=(value: Double): Unit = {
    delegate.setX(value)
  }

  /**
   * The vertical location of this Stage on the screen.
   */
  def y: ReadOnlyDoubleProperty = delegate.yProperty

  def y_=(value: Double): Unit = {
    delegate.setY(value)
  }

  /**
   * Sets x and y properties on this Window so that it is centered on the screen.
   */
  def centerOnScreen(): Unit = {
    delegate.centerOnScreen()
  }

  /**
   * Whether or not this Window has the keyboard or input focus.
   */
  def fireEvent(event: Event): Unit = {
    delegate.fireEvent(event)
  }

  /**
   * Attempts to hide this Window by setting the visibility to false.
   */
  def hide(): Unit = {
    delegate.hide()
  }

  /**
   * Requests that this Window get the input focus.
   */
  def requestFocus(): Unit = {
    delegate.requestFocus()
  }

  /*
   * Attempts to show this Window by setting visibility to true
   */
  //  protected def show = delegate.show

  /**
   * Set the width and height of this Window to match the size of the content of this Window's Scene.
   */
  def sizeToScene(): Unit = {
    delegate.sizeToScene()
  }

  override protected def eventHandlerDelegate: EventHandled = delegate.asInstanceOf[EventHandled]

  /**
   * The horizontal scale that the `Window` will use when rendering its `Scene` to the rendering buffer. This property
   * is automatically updated whenever there is a change in the [[outputScaleX]] property and can be overridden either
   * by calling `setRenderScaleX()` in response to a listener on the `outputScaleX` property or by binding it
   * appropriately.
   *
   * Default value is outputScaleX
   *
   * @see
   *   [[outputScaleX]]
   * @see
   *   [[forceIntegerRenderScale]]
   * @since
   *   9
   */
  def renderScaleX: DoubleProperty = delegate.renderScaleXProperty

  def renderScaleX_=(scale: Double): Unit = {
    renderScaleX = scale
  }

  /**
   * The vertical scale that the `Window` will use when rendering its `Scene` to the rendering buffer. This property is
   * automatically updated whenever there is a change in the [[outputScaleY]] property and can be overridden either by
   * calling `setRenderScaleY()` in response to a listener on the `outputScaleY` property or by binding it
   * appropriately.
   *
   * DefaultValue is outputScaleY
   *
   * @see
   *   [[outputScaleY]]
   * @see
   *   [[forceIntegerRenderScale]]
   * @since
   *   9
   */
  def renderScaleY: DoubleProperty = delegate.renderScaleYProperty

  def renderScaleY_=(scale: Double): Unit = {
    renderScaleY = scale
  }

  /**
   * The scale that the `Window` will apply to horizontal scene coordinates in all stages of rendering and compositing
   * the output to the screen or other destination device. This property is updated asynchronously by the system at
   * various times including: <ul> <li>Window creation <li>At some point during moving a window to a new `Screen` which
   * may be before or after the [[Screen]] property is updated. <li>In response to a change in user preferences for
   * output scaling. </ul>
   *
   * @see
   *   [[renderScaleX]]
   * @since
   *   9
   */
  def outputScaleX: ReadOnlyDoubleProperty = delegate.outputScaleXProperty

  def outputScaleX_=(value: Double): Unit = {
    outputScaleX = value
  }

  /**
   * The scale that the `Window` will apply to vertical scene coordinates in all stages of rendering and compositing the
   * output to the screen or other destination device. This property is updated asynchronously by the system at various
   * times including: <ul> <li>Window creation <li>At some point during moving a window to a new `Screen` which may be
   * before or after the [[Screen]] property is updated. <li>In response to a change in user preferences for output
   * scaling. </ul>
   *
   * @see
   *   [[renderScaleY]]
   * @since
   *   9
   */
  def outputScaleY: ReadOnlyDoubleProperty = delegate.outputScaleYProperty

  def outputScaleY_=(value: Double): Unit = {
    outputScaleY = value
  }

  /**
   * Boolean property that controls whether only integer render scales are set by default by the system when there is a
   * change in the associated output scale. The `renderScale` properties will be updated directly and simultaneously
   * with any changes in the associated `outputScale` properties, but the values can be overridden by subsequent calls
   * to the `setRenderScale` setters or through appropriate use of binding. This property will not prevent setting
   * non-integer scales directly using the `renderScale` property object or the convenience setter method.
   *
   * Default value is false
   *
   * @see
   *   [[renderScaleX]]
   * @see
   *   [[renderScaleY]]
   * @since
   *   9
   */
  def forceIntegerRenderScale: BooleanProperty = delegate.forceIntegerRenderScaleProperty

  def forceIntegerRenderScale_=(forced: Boolean): Unit = {
    forceIntegerRenderScale = forced
  }

}
