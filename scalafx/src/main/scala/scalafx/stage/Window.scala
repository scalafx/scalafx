/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.event.EventDispatchChain
import javafx.{ event => jfxe }
import javafx.{ stage => jfxs }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyBooleanProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.beans.property.ReadOnlyProperty
import scalafx.event.Event
import scalafx.delegate.SFXDelegate

object Window {
  implicit def sfxWindow2jfx(v: Window) = v.delegate
}

class Window protected (override val delegate: jfxs.Window)
  extends SFXDelegate[jfxs.Window]
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

  /**
   * Called just after the Window has been hidden.
   */
  def onHidden = delegate.onHiddenProperty
  def onHidden_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onHidden() = v
  }

  /**
   * Called just prior to the Window being hidden.
   */
  def onHiding = delegate.onHidingProperty
  def onHiding_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onHiding() = v
  }

  /**
   * Called just prior to the Window being shown, even if the menu has no items to show.
   */
  def onShowing = delegate.onShowingProperty
  def onShowing_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onShowing() = v
  }

  /**
   * Called just after the Window is shown.
   */
  def onShown = delegate.onShownProperty
  def onShown_=(v: jfxe.EventHandler[jfxs.WindowEvent]) {
    onShown() = v
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

  /*
   * Registers an event filter to this node.
   */
  //  def addEventFilter[T <: Event](eventType: jfxe.EventType[T], eventFilter: jfxe.EventHandler[_]) = delegate.addEventFilter(eventType.asInstanceOf[jfxe.EventType[jfxe.Event]], eventFilter)

  /*
   * Registers an event handler to this node.
   */
  //  def addEventHandler[T <: Event](eventType: jfxe.EventType[T], eventFilter: jfxe.EventHandler[_])  = delegate.addEventHandler(eventType.asInstanceOf[jfxe.EventType[jfxe.Event]], eventFilter)

  /**
   * Construct an event dispatch chain for this stage.
   */
  def buildEventDispatchChain(tail: jfxe.EventDispatchChain) = delegate.buildEventDispatchChain(tail)

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

  /*
   * Unregisters a previously registered event filter from this node.
   */
  //  def removeEventFilter[T <: Event](eventType: jfxe.EventType[T], eventFilter: jfxe.EventHandler[_]) = delegate.removeEventFilter(eventType.asInstanceOf[jfxe.EventType[jfxe.Event]], eventFilter)

  /*
   * Unregisters a previously registered event handler from this node.
   */
  //  def removeEventHandler[T <: Event](eventType: jfxe.EventType[T], eventFilter: jfxe.EventHandler[_])  = delegate.removeEventHandler(eventType.asInstanceOf[jfxe.EventType[jfxe.Event]], eventFilter)

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

}
