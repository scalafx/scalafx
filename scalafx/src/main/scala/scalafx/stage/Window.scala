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

import javafx.{event => jfxe, stage => jfxs}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ObjectProperty, ReadOnlyBooleanProperty, ReadOnlyDoubleProperty, ReadOnlyObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventHandlerDelegate}

object Window {
  implicit def sfxWindow2jfx(v: Window): jfxs.Window = if (v != null) v.delegate else null
}

class Window protected(override val delegate: jfxs.Window)
  extends EventHandlerDelegate
  with SFXDelegate[jfxs.Window]
  with jfxe.EventTarget {

  /**
   * Specifies the event dispatcher for this node.
   */
  def eventDispatcher: ObjectProperty[jfxe.EventDispatcher] = delegate.eventDispatcherProperty
  def eventDispatcher_=(v: jfxe.EventDispatcher) {
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
  def height_=(h: Double) {
    delegate.setHeight(h)
  }

  /**
   * Called when there is an external request to close this Window.
   */
  def onCloseRequest = delegate.onCloseRequestProperty
  def onCloseRequest_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onCloseRequest() = v
  }
  def onCloseRequest_=(handler: WindowEvent => Unit) {
    onCloseRequest() = new jfxe.EventHandler[jfxs.WindowEvent] {
      override def handle(event: jfxs.WindowEvent): Unit = handler(event)
    }
  }

  /**
   * Called just after the Window has been hidden.
   */
  def onHidden = delegate.onHiddenProperty
  def onHidden_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onHidden() = v
  }
  def onHidden_=(handler: WindowEvent => Unit) {
    onHidden() = new jfxe.EventHandler[jfxs.WindowEvent] {
      override def handle(event: jfxs.WindowEvent): Unit = handler(event)
    }
  }

  /**
   * Called just prior to the Window being hidden.
   */
  def onHiding = delegate.onHidingProperty
  def onHiding_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onHiding() = v
  }
  def onHiding_=(handler: WindowEvent => Unit) {
    onHiding() = new jfxe.EventHandler[jfxs.WindowEvent] {
      override def handle(event: jfxs.WindowEvent): Unit = handler(event)
    }
  }

  /**
   * Called just prior to the Window being shown, even if the menu has no items to show.
   */
  def onShowing = delegate.onShowingProperty
  def onShowing_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onShowing() = v
  }
  def onShowing_=(handler: WindowEvent => Unit) {
    onShowing() = new jfxe.EventHandler[jfxs.WindowEvent] {
      override def handle(event: jfxs.WindowEvent): Unit = handler(event)
    }
  }

  /**
   * Called just after the Window is shown.
   */
  def onShown = delegate.onShownProperty
  def onShown_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onShown() = v
  }
  def onShown_=(handler: WindowEvent => Unit) {
    onShown() = new jfxe.EventHandler[jfxs.WindowEvent] {
      override def handle(event: jfxs.WindowEvent): Unit = handler(event)
    }
  }

  /**
   * Defines the opacity of the Stage as a value between 0.0 and 1.0.
   */
  def opacity: DoubleProperty = delegate.opacityProperty
  def opacity_=(v: Double) {
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
  def width_=(w: Double) {
    delegate.setWidth(w)
  }

  /**
   * The horizontal location of this Stage on the screen.
   */
  def x: ReadOnlyDoubleProperty = delegate.xProperty
  def x_=(value: Double) {
    delegate.setX(value)
  }

  /**
   * The vertical location of this Stage on the screen.
   */
  def y: ReadOnlyDoubleProperty = delegate.yProperty
  def y_=(value: Double) {
    delegate.setY(value)
  }

  /**
   * Sets x and y properties on this Window so that it is centered on the screen.
   */
  def centerOnScreen() {
    delegate.centerOnScreen()
  }

  /**
   * Whether or not this Window has the keyboard or input focus.
   */
  def fireEvent(event: Event) {
    delegate.fireEvent(event)
  }

  /**
   * Attempts to hide this Window by setting the visibility to false.
   */
  def hide() {
    delegate.hide()
  }

  /**
   * Requests that this Window get the input focus.
   */
  def requestFocus() {
    delegate.requestFocus()
  }

  /*
   * Attempts to show this Window by setting visibility to true
   */
  //  protected def show = delegate.show

  /**
   * Set the width and height of this Window to match the size of the content of this Window's Scene.
   */
  def sizeToScene() {
    delegate.sizeToScene()
  }

  override protected def eventHandlerDelegate = delegate.asInstanceOf[EventHandled]
}
