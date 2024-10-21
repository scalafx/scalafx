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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe, scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.css.Styleable
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.Node._

import scala.language.implicitConversions

object Tab {

  implicit def sfxTab2jfx(v: Tab): jfxsc.Tab = if (v != null) v.delegate else null

}

class Tab(override val delegate: jfxsc.Tab = new jfxsc.Tab)
    extends Styleable
    with SFXDelegate[jfxsc.Tab] {

  /**
   * The closable state for this tab.
   */
  def closable: BooleanProperty = delegate.closableProperty

  def closable_=(v: Boolean): Unit = {
    closable() = v
  }

  /**
   * The content associated with the tab.
   */
  def content: ObjectProperty[jfxs.Node] = delegate.contentProperty

  def content_=(v: Node): Unit = {
    content() = v
  }

  /**
   * The context menu associated with the tab.
   */
  def contextMenu: ObjectProperty[jfxsc.ContextMenu] = delegate.contextMenuProperty

  def contextMenu_=(v: ContextMenu): Unit = {
    contextMenu() = v
  }

  /**
   * The graphic in the tab.
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty

  def graphic_=(v: Node): Unit = {
    graphic() = v
  }

  /**
   * The id of this tab.
   */
  def id: StringProperty = delegate.idProperty

  def id_=(v: String): Unit = {
    id() = v
  }

  /**
   * The event handler that is associated with the tab when the tab is closed.
   */
  def onClosed: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onClosedProperty

  def onClosed_=(v: jfxe.EventHandler[jfxe.Event]): Unit = {
    onClosed() = v
  }

  /**
   * Called when there is an external request to close this Tab.
   */
  def onCloseRequest: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onCloseRequestProperty()

  def onCloseRequest_=(v: jfxe.EventHandler[jfxe.Event]): Unit = {
    ObjectProperty.fillProperty[jfxe.EventHandler[jfxe.Event]](onCloseRequest, v)
  }

  /**
   * The event handler that is associated with a selection on the tab.
   */
  def onSelectionChanged: ObjectProperty[jfxe.EventHandler[jfxe.Event]] = delegate.onSelectionChangedProperty

  def onSelectionChanged_=(v: jfxe.EventHandler[jfxe.Event]): Unit = {
    onSelectionChanged() = v
  }

  /**
   * The currently selected tab.
   */
  def selected: ReadOnlyBooleanProperty = delegate.selectedProperty

  /**
   * The CSS style string associated to this tab.
   */
  def style: StringProperty = delegate.styleProperty

  def style_=(v: String): Unit = {
    style() = v
  }

  /**
   * The TabPane that contains this tab.
   */
  def tabPane: ReadOnlyObjectProperty[jfxsc.TabPane] = delegate.tabPaneProperty

  /**
   * The text shown in the tab.
   */
  def text: StringProperty = delegate.textProperty

  def text_=(v: String): Unit = {
    text() = v
  }

  /**
   * The tooltip associated with this tab.
   */
  def tooltip: ObjectProperty[jfxsc.Tooltip] = delegate.tooltipProperty

  def tooltip_=(v: Tooltip): Unit = {
    tooltip() = v
  }

  /**
   * Sets the disabled state of this tab. A disable tab is no longer interactive or traversable,
   * but the contents remain interactive. A disable tab can be selected using TabPane.getSelectionModel().
   *
   * @since 2.2
   */
  def disable: BooleanProperty = delegate.disableProperty()

  def disable_=(v: Boolean): Unit = {
    disable() = v
  }

  /**
   * Indicates whether or not this Tab is disabled. A Tab will become disabled if disable is set to true
   * on either itself or if the TabPane is disabled.
   * @since 2.2
   */
  def disabled: ReadOnlyBooleanProperty = delegate.disabledProperty()

  /**
   * Set the value of the userData property for the instance constructed by this builder.
   * @since 2.2
   */
  def userData: AnyRef = delegate.getUserData

  def userData_=(v: AnyRef): Unit = {
    delegate.setUserData(v)
  }

}
