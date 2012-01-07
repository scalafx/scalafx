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

package scalafx.scene

import collection.JavaConversions._
import javafx.{event => jfxe, geometry => jfxg, scene => jfxs}
import jfxs.{input => jfxsi, layout => jfxsl, effect => jfxse, transform => jfxst}
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.geometry.Insets

object Node {
  implicit def sfxNode2jfx(v: Node) = v.delegate
}

abstract class Node(override val delegate: jfxs.Node) extends SFXDelegate[jfxs.Node] {
  def blendMode = delegate.blendModeProperty
  def blendMode_=(v: jfxse.BlendMode) {
    blendMode() = v
  }

  def boundsInLocal = delegate.boundsInLocalProperty

  def boundsInParent = delegate.boundsInParentProperty

  def cacheHint = delegate.cacheHintProperty
  def cacheHint_=(v: jfxs.CacheHint) {
    cacheHint() = v
  }

  def cache = delegate.cacheProperty
  def cache_=(v: Boolean) {
    cache() = v
  }

  def clip = delegate.clipProperty
  def clip_=(v: jfxs.Node) {
    clip() = v
  }

  def cursor = delegate.cursorProperty
  def cursor_=(v: jfxs.Cursor) {
    cursor() = v
  }

  def depthTest = delegate.depthTestProperty
  def depthTest_=(v: jfxs.DepthTest) {
    depthTest() = v
  }

  def disabled = delegate.disabledProperty

  def disable = delegate.disableProperty
  def disable_=(v: Boolean) {
    disable() = v
  }

  def effect = delegate.effectProperty
  def effect_=(v: jfxse.Effect) {
    effect() = v
  }

  def eventDispatcher = delegate.eventDispatcherProperty
  def eventDispatcher_=(v: jfxe.EventDispatcher) {
    eventDispatcher() = v
  }

  def focused = delegate.focusedProperty

  def focusTraversable = delegate.focusTraversableProperty
  def focusTraversable_=(v: Boolean) {
    focusTraversable() = v
  }

  def hover = delegate.hoverProperty

  def id = delegate.idProperty
  def id_=(v: String) {
    id() = v
  }

  def inputMethodRequests = delegate.inputMethodRequestsProperty
  def inputMethodRequests_=(v: jfxsi.InputMethodRequests) {
    inputMethodRequests() = v
  }

  def layoutBounds = delegate.layoutBoundsProperty

  def layoutX = delegate.layoutXProperty
  def layoutX_=(v: Double) {
    layoutX() = v
  }

  def layoutY = delegate.layoutYProperty
  def layoutY_=(v: Double) {
    layoutY() = v
  }

  def managed = delegate.managedProperty
  def managed_=(v: Boolean) {
    managed() = v
  }

  def mouseTransparent = delegate.mouseTransparentProperty
  def mouseTransparent_=(v: Boolean) {
    mouseTransparent() = v
  }

  def onDragDetected = delegate.onDragDetectedProperty
  def onDragDetected_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onDragDetected() = v
  }

  def onDragDone = delegate.onDragDoneProperty
  def onDragDone_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragDone() = v
  }

  def onDragDropped = delegate.onDragDroppedProperty
  def onDragDropped_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragDropped() = v
  }

  def onDragEntered = delegate.onDragEnteredProperty
  def onDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragEntered() = v
  }

  def onDragExited = delegate.onDragExitedProperty
  def onDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragExited() = v
  }

  def onDragOver = delegate.onDragOverProperty
  def onDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragOver() = v
  }

  def onInputMethodTextChanged = delegate.onInputMethodTextChangedProperty
  def onInputMethodTextChanged_=(v: jfxe.EventHandler[_ >: jfxsi.InputMethodEvent]) {
    onInputMethodTextChanged() = v
  }

  def onKeyPressed = delegate.onKeyPressedProperty
  def onKeyPressed_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyPressed() = v
  }

  def onKeyReleased = delegate.onKeyReleasedProperty
  def onKeyReleased_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyReleased() = v
  }

  def onKeyTyped = delegate.onKeyTypedProperty
  def onKeyTyped_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyTyped() = v
  }

  def onMouseClicked = delegate.onMouseClickedProperty
  def onMouseClicked_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseClicked() = v
  }

  def onMouseDragged = delegate.onMouseDraggedProperty
  def onMouseDragged_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragged() = v
  }

  def onMouseEntered = delegate.onMouseEnteredProperty
  def onMouseEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseEntered() = v
  }

  def onMouseExited = delegate.onMouseExitedProperty
  def onMouseExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseExited() = v
  }

  def onMouseMoved = delegate.onMouseMovedProperty
  def onMouseMoved_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseMoved() = v
  }

  def onMousePressed = delegate.onMousePressedProperty
  def onMousePressed_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMousePressed() = v
  }

  def onMouseReleased = delegate.onMouseReleasedProperty
  def onMouseReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseReleased() = v
  }

  def opacity = delegate.opacityProperty

  def parent = delegate.parentProperty

  def pickOnBounds = delegate.pickOnBoundsProperty
  def pickOnBounds_=(v: Boolean) {
    pickOnBounds() = v
  }

  def pressed = delegate.pressedProperty

  def rotate = delegate.rotateProperty
  def rotate_=(v: Double) {
    rotate() = v
  }

  def rotationAxis = delegate.rotationAxisProperty
  def rotationAxis_=(v: jfxg.Point3D) {
    rotationAxis() = v
  }

  def scaleX = delegate.scaleXProperty
  def scaleX_=(v: Double) {
    scaleX() = v
  }

  def scaleY = delegate.scaleYProperty
  def scaleY_=(v: Double) {
    scaleY() = v
  }

  def scaleZ = delegate.scaleZProperty
  def scaleZ_=(v: Double) {
    scaleZ() = v
  }

  def scene = delegate.sceneProperty

  def style = delegate.styleProperty
  def style_=(v: String) {
    style() = v
  }

  def styleClass = delegate.getStyleClass
  def styleClass_=(c: Iterable[String]) {
    styleClass.setAll(c)
  }

  def transforms = delegate.getTransforms
  def transforms_=(c: Iterable[jfxst.Transform]) {
    transforms.setAll(c)
  }

  def translateX = delegate.translateXProperty
  def translateX_=(v: Double) {
    translateX() = v
  }

  def translateY = delegate.translateYProperty
  def translateY_=(v: Double) {
    translateY() = v
  }

  def translateZ = delegate.translateZProperty
  def translateZ_=(v: Double) {
    translateZ() = v
  }

  def userData = delegate.getUserData
  def userData_=(v: AnyRef) {
    delegate.setUserData(v)
  }

  def visible = delegate.visibleProperty
  def visible_=(v: Boolean) {
    visible() = v
  }

  // layout pseudo-properties:

  def alignment = delegate.getProperties().get("alignment").asInstanceOf[jfxg.Pos]
  def alignment_=(p: jfxg.Pos) {
    delegate.getProperties().put("alignment", p)
    delegate.getProperties().put("halignment", p.getHpos)
    delegate.getProperties().put("valignment", p.getVpos)
    // for compatibility with layouts, which all use different keys
    jfxsl.BorderPane.setAlignment(delegate, p)
    jfxsl.GridPane.setHalignment(delegate, p.getHpos)
    jfxsl.GridPane.setValignment(delegate, p.getVpos)
    jfxsl.StackPane.setAlignment(delegate, p)
    jfxsl.TilePane.setAlignment(delegate, p)
  }

  def margin = delegate.getProperties().get("margin").asInstanceOf[Insets]
  def margin_=(i: jfxg.Insets) {
    delegate.getProperties().put("margin", i)
    // for compatibility with layouts, which all use different keys
    jfxsl.BorderPane.setMargin(delegate, i)
    jfxsl.FlowPane.setMargin(delegate, i)
    jfxsl.GridPane.setMargin(delegate, i)
    jfxsl.HBox.setMargin(delegate, i)
    jfxsl.StackPane.setMargin(delegate, i)
    jfxsl.TilePane.setMargin(delegate, i)
    jfxsl.VBox.setMargin(delegate, i)
  }

  def hgrow = delegate.getProperties().get("hgrow").asInstanceOf[jfxsl.Priority]
  def hgrow_=(p: jfxsl.Priority) {
    delegate.getProperties().put("hgrow", p)
    // for compatibility with layouts, which all use different keys
    jfxsl.GridPane.setHgrow(delegate, p)
    jfxsl.HBox.setHgrow(delegate, p)
  }

  def vgrow = delegate.getProperties().get("vgrow").asInstanceOf[jfxsl.Priority]
  def vgrow_=(p: jfxsl.Priority) {
    delegate.getProperties().put("vgrow", p)
    // for compatibility with layouts, which all use different keys
    jfxsl.GridPane.setVgrow(delegate, p)
    jfxsl.VBox.setVgrow(delegate, p)
  }
}
