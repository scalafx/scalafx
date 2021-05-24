/*
 * Copyright (c) 2011-2021, ScalaFX Project
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

import javafx.scene.{effect => jfxse, input => jfxsi, layout => jfxsl, transform => jfxst}
import javafx.{event => jfxe, geometry => jfxg, scene => jfxs, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.collections._
import scalafx.css.Styleable
import scalafx.delegate.SFXDelegate
import scalafx.delegate.SFXDelegate.delegateOrNull
import scalafx.event.Event._
import scalafx.event.{Event, EventHandlerDelegate2}
import scalafx.geometry.Bounds._
import scalafx.geometry.Point2D._
import scalafx.geometry._
import scalafx.scene.effect.{BlendMode, Effect}
import scalafx.scene.image.WritableImage
import scalafx.scene.input.Dragboard
import scalafx.scene.layout.Priority
import scalafx.scene.transform.Transform

import scala.collection.JavaConverters._
import scala.language.implicitConversions

/**
 * Companion object for [[scalafx.scene.Node]].
 */
object Node {

  /**
   * Converts a ScalaFX Node to its JavaFX counterpart.
   *
   * @param v
   *   ScalaFX Node
   * @return
   *   JavaFX Node
   */
  implicit def sfxNode2jfx(v: Node): jfxs.Node = if (v != null) v.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html]].
 *
 * @constructor
 *   creates a new ScalaFX Node from a JavaFX Node.
 * @param delegate
 *   JavaFX Node
 */
abstract class Node protected (override val delegate: jfxs.Node)
    extends EventHandlerDelegate2
    with Styleable
    with SFXDelegate[jfxs.Node] {

  /**
   * The accessible text for this `Node`.
   *
   * This property is used to set the text that the screen reader will speak. If a node normally speaks text, that text
   * is overriden. For example, a button usually speaks using the text in the control but will no longer do this when
   * this value is set.
   *
   * Default value is `null`.
   *
   * @since
   *   JavaFX 8u40
   */
  def accessibleText: ObjectProperty[String] = delegate.accessibleTextProperty

  def accessibleText_=(v: String): Unit = {
    ObjectProperty.fillProperty(accessibleText, v)
  }

  /**
   * The accessible help text for this `Node`.
   *
   * The help text provides a more detailed description of the accessible text for a node. By default, if the node has a
   * tool tip, this text is used.
   *
   * Default value is `null`.
   *
   * @since
   *   JavaFX 8u40
   */
  def accessibleHelp: ObjectProperty[String] = delegate.accessibleHelpProperty

  def accessibleHelp_=(v: String): Unit = {
    ObjectProperty.fillProperty(accessibleHelp, v)
  }

  /**
   * The accessible role for this `Node`.
   *
   * The screen reader uses the role of a node to determine the attributes and actions that are supported.
   *
   * @since
   *   JavaFX 8u40
   */
  def accessibleRole: ObjectProperty[jfxs.AccessibleRole] = delegate.accessibleRoleProperty

  def accessibleRole_=(v: AccessibleRole): Unit = {
    ObjectProperty.fillProperty(accessibleRole, v)
  }

  /**
   * The role description of this `Node`.
   *
   * Noramlly, when a role is provided for a node, the screen reader speaks the role as well as the contents of the
   * node. When this value is set, it is possbile to override the default. This is useful because the set of roles is
   * predefined. For example, it is possible to set the role of a node to be a button, but have the role description be
   * arbitrary text.
   *
   * Default value is `null`.
   *
   * @since
   *   JavaFX 8u40
   */
  def accessibleRoleDescription: ObjectProperty[String] = delegate.accessibleRoleDescriptionProperty

  def accessibleRoleDescription_=(v: String): Unit = {
    ObjectProperty.fillProperty(accessibleRoleDescription, v)
  }

  /**
   * The BlendMode used to blend this individual node into the scene behind it.
   */
  def blendMode: ObjectProperty[jfxse.BlendMode] = delegate.blendModeProperty

  def blendMode_=(v: BlendMode): Unit = {
    blendMode() = v
  }

  /**
   * The rectangular bounds of this Node in the node's untransformed local coordinate space.
   */
  def boundsInLocal: ReadOnlyObjectProperty[jfxg.Bounds] = delegate.boundsInLocalProperty

  /**
   * The rectangular bounds of this Node which include its transforms.
   */
  def boundsInParent: ReadOnlyObjectProperty[jfxg.Bounds] = delegate.boundsInParentProperty

  /**
   * Additional hint for controlling bitmap caching.
   */
  def cacheHint: ObjectProperty[jfxs.CacheHint] = delegate.cacheHintProperty

  def cacheHint_=(v: CacheHint): Unit = {
    cacheHint() = v
  }

  /**
   * A performance hint to the system to indicate that this Node should be cached as a bitmap.
   */
  def cache: BooleanProperty = delegate.cacheProperty

  def cache_=(v: Boolean): Unit = {
    cache() = v
  }

  /**
   * Specifies a Node to use to define the the clipping shape for this Node.
   */
  def clip: ObjectProperty[jfxs.Node] = delegate.clipProperty

  def clip_=(v: Node): Unit = {
    clip() = v
  }

  /**
   * Returns the orientation of a node's resizing bias for layout purposes. If the node type has no bias, returns
   * `null`. If the node is resizable and it's height depends on its width, returns HORIZONTAL, else if its width
   * depends on its height, returns VERTICAL.
   *
   * Resizable subclasses should override this method to return an appropriate value.
   *
   * @return
   *   orientation of width/height dependency or `null` if there is none
   */
  def contentBias: Orientation = delegate.getContentBias

  /**
   * Defines the mouse cursor for this Node and subnodes.
   */
  def cursor: ObjectProperty[jfxs.Cursor] = delegate.cursorProperty

  def cursor_=(v: Cursor): Unit = {
    cursor() = v
  }

  /**
   * Indicates whether depth testing is used when rendering this node.
   */
  def depthTest: ObjectProperty[jfxs.DepthTest] = delegate.depthTestProperty

  def depthTest_=(v: DepthTest): Unit = {
    depthTest() = v
  }

  /**
   * Indicates whether or not this Node is disabled.
   */
  def disabled: ReadOnlyBooleanProperty = delegate.disabledProperty

  /**
   * Sets the individual disabled state of this Node.
   */
  def disable: BooleanProperty = delegate.disableProperty

  def disable_=(v: Boolean): Unit = {
    disable() = v
  }

  /**
   * Specifies an effect to apply to this Node.
   */
  def effect: ObjectProperty[jfxse.Effect] = delegate.effectProperty

  def effect_=(v: Effect): Unit = {
    ObjectProperty.fillProperty[jfxse.Effect](this.effect, v)
  }

  /**
   * Specifies the event dispatcher for this node.
   */
  def eventDispatcher: ObjectProperty[jfxe.EventDispatcher] = delegate.eventDispatcherProperty

  def eventDispatcher_=(v: jfxe.EventDispatcher): Unit = {
    eventDispatcher() = v
  }

  /**
   * Indicates whether this Node currently has the input focus.
   */
  def focused: ReadOnlyBooleanProperty = delegate.focusedProperty

  /**
   * Specifies whether this Node should be a part of focus traversal cycle.
   */
  def focusTraversable: BooleanProperty = delegate.focusTraversableProperty

  def focusTraversable_=(v: Boolean): Unit = {
    focusTraversable() = v
  }

  /**
   * Whether or not this Node is being hovered over.
   */
  def hover: ReadOnlyBooleanProperty = delegate.hoverProperty

  /**
   * The id of this Node.
   */
  def id: StringProperty = delegate.idProperty

  def id_=(v: String): Unit = {
    id() = v
  }

  /**
   * Property holding InputMethodRequests.
   */
  def inputMethodRequests: ObjectProperty[jfxsi.InputMethodRequests] = delegate.inputMethodRequestsProperty

  def inputMethodRequests_=(v: jfxsi.InputMethodRequests): Unit = {
    inputMethodRequests() = v
  }

  /**
   * The rectangular bounds that should be used for layout calculations for this node.
   */
  def layoutBounds: ReadOnlyObjectProperty[jfxg.Bounds] = delegate.layoutBoundsProperty

  /**
   * Defines the x coordinate of the translation that is added to this Node's transform for the purpose of layout.
   */
  def layoutX: DoubleProperty = delegate.layoutXProperty

  def layoutX_=(v: Double): Unit = {
    layoutX() = v
  }

  /**
   * Defines the y coordinate of the translation that is added to this Node's transform for the purpose of layout.
   */
  def layoutY: DoubleProperty = delegate.layoutYProperty

  def layoutY_=(v: Double): Unit = {
    layoutY() = v
  }

  /**
   * Defines whether or not this node's layout will be managed by it's parent.
   */
  def managed: BooleanProperty = delegate.managedProperty

  def managed_=(v: Boolean): Unit = {
    managed() = v
  }

  /**
   * If true, this node (together with all its children) is completely transparent to mouse events.
   */
  def mouseTransparent: BooleanProperty = delegate.mouseTransparentProperty

  def mouseTransparent_=(v: Boolean): Unit = {
    mouseTransparent() = v
  }

  /**
   * Node orientation describes the flow of visual data within a node.
   */
  def nodeOrientation: ObjectProperty[jfxg.NodeOrientation] = delegate.nodeOrientationProperty

  def nodeOrientation_=(v: NodeOrientation): Unit = {
    ObjectProperty.fillProperty[jfxg.NodeOrientation](this.nodeOrientation, v)
  }

  /**
   * The effective orientation of a node resolves the inheritance of node orientation, returning either left-to-right or
   * right-to-left.
   */
  def effectiveNodeOrientation: ReadOnlyObjectProperty[jfxg.NodeOrientation] = delegate.effectiveNodeOrientationProperty

  /**
   * Defines a function to be called when a context menu has been requested on this Node.
   */
  def onContextMenuRequested: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.ContextMenuEvent]] =
    delegate.onContextMenuRequestedProperty

  def onContextMenuRequested_=(v: jfxe.EventHandler[_ >: jfxsi.ContextMenuEvent]): Unit = {
    onContextMenuRequested() = v
  }

  /**
   * Defines a function to be called when drag gesture has been detected.
   */
  def onDragDetected: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseEvent]] = delegate.onDragDetectedProperty

  def onDragDetected_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]): Unit = {
    onDragDetected() = v
  }

  /**
   * Defines a function to be called when this Node is a drag and drop gesture source after its data has been dropped on
   * a drop target.
   */
  def onDragDone: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.DragEvent]] = delegate.onDragDoneProperty

  def onDragDone_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]): Unit = {
    onDragDone() = v
  }

  /**
   * Defines a function to be called when the mouse button is released on this Node during drag and drop gesture.
   */
  def onDragDropped: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.DragEvent]] = delegate.onDragDroppedProperty

  def onDragDropped_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]): Unit = {
    onDragDropped() = v
  }

  /**
   * Defines a function to be called when drag gesture enters this Node.
   */
  def onDragEntered: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.DragEvent]] = delegate.onDragEnteredProperty

  def onDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]): Unit = {
    onDragEntered() = v
  }

  /**
   * Defines a function to be called when drag gesture exits this Node.
   */
  def onDragExited: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.DragEvent]] = delegate.onDragExitedProperty

  def onDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]): Unit = {
    onDragExited() = v
  }

  /**
   * Defines a function to be called when drag gesture progresses within this Node.
   */
  def onDragOver: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.DragEvent]] = delegate.onDragOverProperty

  def onDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]): Unit = {
    onDragOver() = v
  }

  /**
   * Defines a function to be called when this Node has input focus and the input method text has changed.
   */
  def onInputMethodTextChanged: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.InputMethodEvent]] =
    delegate.onInputMethodTextChangedProperty

  def onInputMethodTextChanged_=(v: jfxe.EventHandler[_ >: jfxsi.InputMethodEvent]): Unit = {
    onInputMethodTextChanged() = v
  }

  /**
   * Defines a function to be called when this Node or its child Node has input focus and a key has been pressed.
   */
  def onKeyPressed: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.KeyEvent]] = delegate.onKeyPressedProperty

  def onKeyPressed_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]): Unit = {
    onKeyPressed() = v
  }

  /**
   * Defines a function to be called when this Node or its child Node has input focus and a key has been released.
   */
  def onKeyReleased: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.KeyEvent]] = delegate.onKeyReleasedProperty

  def onKeyReleased_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]): Unit = {
    onKeyReleased() = v
  }

  /**
   * Defines a function to be called when this Node or its child Node has input focus and a key has been typed.
   */
  def onKeyTyped: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.KeyEvent]] = delegate.onKeyTypedProperty

  def onKeyTyped_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]): Unit = {
    onKeyTyped() = v
  }

  /**
   * Defines a function to be called when a mouse button has been clicked (pressed and released) on this Node.
   */
  def onMouseClicked: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseEvent]] = delegate.onMouseClickedProperty

  def onMouseClicked_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]): Unit = {
    onMouseClicked() = v
  }

  /**
   * Defines a function to be called when a mouse button is pressed on this Node and then dragged.
   */
  def onMouseDragged: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseEvent]] = delegate.onMouseDraggedProperty

  def onMouseDragged_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]): Unit = {
    onMouseDragged() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture enters this Node.
   */
  def onMouseDragEntered: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]] =
    delegate.onMouseDragEnteredProperty

  def onMouseDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]): Unit = {
    onMouseDragEntered() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture leaves this Node.
   */
  def onMouseDragExited: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]] =
    delegate.onMouseDragExitedProperty

  def onMouseDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]): Unit = {
    onMouseDragExited() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture progresses within this Node.
   */
  def onMouseDragOver: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]] = delegate.onMouseDragOverProperty

  def onMouseDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]): Unit = {
    onMouseDragOver() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture ends (by releasing mouse button) within this
   * Node.
   */
  def onMouseDragReleased: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]] =
    delegate.onMouseDragReleasedProperty

  def onMouseDragReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseDragEvent]): Unit = {
    onMouseDragReleased() = v
  }

  /**
   * Defines a function to be called when the mouse enters this Node.
   */
  def onMouseEntered: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseEvent]] = delegate.onMouseEnteredProperty

  def onMouseEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]): Unit = {
    onMouseEntered() = v
  }

  /**
   * Defines a function to be called when the mouse exits this Node.
   */
  def onMouseExited: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseEvent]] = delegate.onMouseExitedProperty

  def onMouseExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]): Unit = {
    onMouseExited() = v
  }

  def onMouseMoved: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseEvent]] = delegate.onMouseMovedProperty

  def onMouseMoved_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]): Unit = {
    onMouseMoved() = v
  }

  /**
   * Defines a function to be called when a mouse button has been pressed on this Node.
   */
  def onMousePressed: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseEvent]] = delegate.onMousePressedProperty

  def onMousePressed_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]): Unit = {
    onMousePressed() = v
  }

  /**
   * Defines a function to be called when a mouse button has been released on this Node.
   */
  def onMouseReleased: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.MouseEvent]] = delegate.onMouseReleasedProperty

  def onMouseReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]): Unit = {
    onMouseReleased() = v
  }

  /**
   * Defines a function to be called when user performs a scrolling action.
   */
  def onScroll: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.ScrollEvent]] = delegate.onScrollProperty

  def onScroll_=(v: jfxe.EventHandler[_ >: jfxsi.ScrollEvent]): Unit = {
    onScroll() = v
  }

  /**
   * Specifies how opaque (that is, solid) the Node appears.
   */
  def opacity: DoubleProperty = delegate.opacityProperty

  def opacity_=(v: Double): Unit = {
    opacity() = v
  }

  /**
   * The parent of this Node.
   */
  def parent: ReadOnlyObjectProperty[jfxs.Parent] = delegate.parentProperty

  /**
   * Defines how the picking computation is done for this node when triggered by a MouseEvent or a contains function
   * call.
   */
  def pickOnBounds: BooleanProperty = delegate.pickOnBoundsProperty

  def pickOnBounds_=(v: Boolean): Unit = {
    pickOnBounds() = v
  }

  /**
   * Whether or not the Node is pressed.
   */
  def pressed: ReadOnlyBooleanProperty = delegate.pressedProperty

  /**
   * Defines the angle of rotation about the Node's center, measured in degrees.
   */
  def rotate: DoubleProperty = delegate.rotateProperty

  def rotate_=(v: Double): Unit = {
    rotate() = v
  }

  /**
   * Defines the axis of rotation of this Node.
   */
  def rotationAxis: ObjectProperty[jfxg.Point3D] = delegate.rotationAxisProperty

  def rotationAxis_=(v: Point3D): Unit = {
    rotationAxis() = v
  }

  /**
   * Defines the factor by which coordinates are scaled about the center of the object along the X axis of this Node.
   */
  def scaleX: DoubleProperty = delegate.scaleXProperty

  def scaleX_=(v: Double): Unit = {
    scaleX() = v
  }

  /**
   * Defines the factor by which coordinates are scaled about the center of the object along the Y axis of this Node.
   */
  def scaleY: DoubleProperty = delegate.scaleYProperty

  def scaleY_=(v: Double): Unit = {
    scaleY() = v
  }

  /**
   * Defines the factor by which coordinates are scaled about the center of the object along the Z axis of this Node.
   */
  def scaleZ: DoubleProperty = delegate.scaleZProperty

  def scaleZ_=(v: Double): Unit = {
    scaleZ() = v
  }

  /**
   * The Scene that this Node is part of.
   */
  def scene: ReadOnlyObjectProperty[jfxs.Scene] = delegate.sceneProperty

  /**
   * A string representation of the CSS style associated with this specific Node.
   */
  def style: StringProperty = delegate.styleProperty

  def style_=(v: String): Unit = {
    style() = v
  }

  /**
   * Sets the list of CSS styles classes, replacing the prior content. If you want append to current content, use `add`
   * or similar.
   *
   * @param c
   *   list of CSS styles classes to replace prior content.
   */
  def styleClass_=(c: Iterable[String]): Unit = {
    fillCollection(styleClass, c)
  }

  /**
   * Defines the ObservableList of Transform objects to be applied to this Node.
   */
  def transforms: ObservableBuffer[jfxst.Transform] = delegate.getTransforms

  /**
   * Sets the list of transforms, replacing the prior content. If you want append to current content, use `add` or
   * similar.
   *
   * @param c
   *   list of transforms to replace prior content.
   */
  def transforms_=(c: Iterable[Transform]): Unit = {
    fillSFXCollection(transforms, c)
  }

  /**
   * Defines the x coordinate of the translation that is added to this Node's transform.
   */
  def translateX: DoubleProperty = delegate.translateXProperty

  def translateX_=(v: Double): Unit = {
    translateX() = v
  }

  /**
   * Defines the y coordinate of the translation that is added to this Node's transform.
   */
  def translateY: DoubleProperty = delegate.translateYProperty

  def translateY_=(v: Double): Unit = {
    translateY() = v
  }

  /**
   * Defines the Z coordinate of the translation that is added to the transformed coordinates of this Node.
   */
  def translateZ: DoubleProperty = delegate.translateZProperty

  def translateZ_=(v: Double): Unit = {
    translateZ() = v
  }

  /**
   * Returns a previously set Object property, or null if no such property has been set using the setUserData(AnyRef)
   * method.
   */
  def userData: AnyRef = delegate.getUserData

  def userData_=(v: AnyRef): Unit = {
    delegate.setUserData(v)
  }

  /**
   * Specifies whether this Node and any subnodes should be rendered as part of the scene graph.
   */
  def visible: BooleanProperty = delegate.visibleProperty

  def visible_=(v: Boolean): Unit = {
    visible() = v
  }

  // layout pseudo-properties:

  /**
   * Pseudo-property that indicates this Node position inside its respective parent.
   */
  def alignmentInParent: Pos = delegate.getProperties.get("alignment").asInstanceOf[jfxg.Pos]

  /**
   * Sets this Node's alignment constraint inside its Parent. If set, will override the Parent's default alignment.
   * Setting the value to `null` will remove the constraint. Internally it calls `setAlignment(Node, Pos)` static method
   * JavaFX's [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.htmlBorderPane]],
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/StackPane.htmlStackPane]] and
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/TilePane.htmlTilePane]]. Furthermore, it is set
   * `halignment` and `valignment` property (using JavaFX Node's `getProperties()`) and called
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html#setHalignment(javafx.scene.Node,javafx.geometry.HPos)setHalignment]]
   * and
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html#setValignment(javafx.scene.Node,javafx.geometry.VPos)setValignment]]
   * static methods from [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.htmlGridPane]]; this
   * time using `hpos` and `vpos` from Pos argument. Besides, it sets this node `alignment` property towards
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#getProperties()JavaFXNode's getProperties()]]
   * and `setAlignment` static method from
   *
   * '''Do not confuse''' with `alignment` property from [[scalafx.delegate.AlignmentDelegate]]! It refers to alignment
   * ''inside'' element, while `alignmentInParent` refers to element's alignment inside its parent.
   *
   * @param p
   *   New node's Position
   */
  def alignmentInParent_=(p: Pos): Unit = {
    val delegateProperties = delegate.getProperties
    delegateProperties.put("alignment", delegateOrNull(p))
    delegateProperties("halignment") = if (p != null) p.hpos.delegate else null
    delegateProperties("valignment") = if (p != null) p.vpos.delegate else null
    // for compatibility with layouts, which all use different keys
    jfxsl.BorderPane.setAlignment(delegate, p)
    jfxsl.GridPane.setHalignment(delegate, p.hpos)
    jfxsl.GridPane.setValignment(delegate, p.vpos)
    jfxsl.StackPane.setAlignment(delegate, p)
    jfxsl.TilePane.setAlignment(delegate, p)
  }

  /**
   * Pseudo-property that returns this Node's margin constraint inside its Parent if set.
   *
   * @return
   *   this Node's margin constraint inside its Parent or `null` if no margin was set.
   */
  def margin: Insets = delegate.getProperties.get("margin").asInstanceOf[jfxg.Insets]

  /**
   * Sets this Node's margin constraint inside its Parent if set. If set, the parent will layout the child with the
   * margin space around it. Setting the value to `null` will remove the constraint. Internally it calls
   * `setMargin(Node, Insets)` static method from JavaFX's `BorderPane`, `FlowPane`, `GridPane`, `HBox`, `StackPane` and
   * `VBox` besides fill this Node's "margin" property.
   *
   * @param i
   *   The margin of space around this Node inside its parent.
   */
  def margin_=(i: Insets): Unit = {
    delegate.getProperties.put("margin", delegateOrNull(i))
    // for compatibility with layouts, which all use different keys
    jfxsl.BorderPane.setMargin(delegate, i)
    jfxsl.FlowPane.setMargin(delegate, i)
    jfxsl.GridPane.setMargin(delegate, i)
    jfxsl.HBox.setMargin(delegate, i)
    jfxsl.StackPane.setMargin(delegate, i)
    jfxsl.TilePane.setMargin(delegate, i)
    jfxsl.VBox.setMargin(delegate, i)
  }

  /**
   * Pseudo-property that returns this Node's hgrow constraint if set.
   *
   * @return
   *   the horizontal grow priority for the child or `null` if no priority was set
   */
  def hgrow: Priority = delegate.getProperties.get("hgrow").asInstanceOf[jfxsl.Priority]

  /**
   * Sets the horizontal grow priority for this Node inside its parent. Setting the value to `null` will remove the
   * constraint. Internally it calls `setHgrow(Node, Priority)` static method from JavaFX's `GridPane` and `HBox`
   * besides fill this Node's "hgrow" property.
   *
   * @param p
   *   the horizontal grow priority for this Node
   */
  def hgrow_=(p: Priority): Unit = {
    delegate.getProperties("hgrow") = delegateOrNull(p)
    // for compatibility with layouts, which all use different keys
    jfxsl.GridPane.setHgrow(delegate, p)
    jfxsl.HBox.setHgrow(delegate, p)
  }

  /**
   * Pseudo-property that returns this Node's vgrow constraint if set.
   *
   * @return
   *   the vertical grow priority for the child or `null` if no priority was set
   */
  def vgrow: Priority = delegate.getProperties.get("vgrow").asInstanceOf[jfxsl.Priority]

  /**
   * Sets the vertical grow priority for this Node inside its parent. Setting the value to `null` will remove the
   * constraint. Internally it calls `setVgrow(Node, Priority)` static method from JavaFX's `GridPane` and `VBox`
   * besides fill this Node's "vgrow" property.
   *
   * @param p
   *   the vertical grow priority for this Node
   */
  def vgrow_=(p: Priority): Unit = {
    delegate.getProperties("vgrow") = delegateOrNull(p)
    // for compatibility with layouts, which all use different keys
    jfxsl.GridPane.setVgrow(delegate, p)
    jfxsl.VBox.setVgrow(delegate, p)
  }

  /**
   * If the node is resizable, will set its layout bounds to its current preferred width and height.
   */
  def autosize(): Unit = {
    delegate.autosize()
  }

  /**
   * Returns true if the given point (specified in the local coordinate space of this Node) is contained within the
   * shape of this Node.
   */
  def contains(localX: Double, localY: Double): Boolean = delegate.contains(localX, localY)

  /**
   * Returns true if the given point (specified in the local coordinate space of this Node) is contained within the
   * shape of this Node.
   */
  def contains(localPoint: Point2D): Boolean = delegate.contains(localPoint)

  /**
   * Fires the specified event.
   */
  def fireEvent(event: Event): Unit = {
    delegate.fireEvent(event)
  }

  /**
   * The 'alphabetic' (or 'roman') baseline offset from the node's layoutBounds.minY location that should be used when
   * this node is being vertically aligned by baseline with other nodes.
   */
  def baselineOffset: Double = delegate.getBaselineOffset

  /**
   * Returns true if the given bounds (specified in the local coordinate space of this Node) intersects the shape of
   * this Node.
   */
  def intersects(localBounds: Bounds): Boolean = delegate.intersects(localBounds)

  /**
   * Returns true if the given rectangle (specified in the local coordinate space of this Node) intersects the shape of
   * this Node.
   */
  def intersects(localX: Double, localY: Double, localWidth: Double, localHeight: Double): Boolean =
    delegate.intersects(localX, localY, localWidth, localHeight)

  /**
   * Transforms a bounds from the local coordinate space of this Node into the coordinate space of its parent.
   */
  def localToParent(localBounds: Bounds): Bounds = delegate.localToParent(localBounds)

  /**
   * Transforms a point from the local coordinate space of this Node into the coordinate space of its parent.
   */
  def localToParent(localX: Double, localY: Double): Point2D = delegate.localToParent(localX, localY)

  /**
   * Transforms a point from the local coordinate space of this Node into the coordinate space of its parent.
   */
  def localToParent(localPoint: Point2D): Point2D = delegate.localToParent(localPoint)

  /**
   * Transforms a bounds from the local coordinate space of this Node into the coordinate space of its Scene.
   */
  def localToScene(localBounds: Bounds): Bounds = delegate.localToScene(localBounds)

  /**
   * Transforms a point from the local coordinate space of this Node into the coordinate space of its Scene.
   */
  def localToScene(localX: Double, localY: Double): Point2D = delegate.localToScene(localX, localY)

  /**
   * Transforms a point from the local coordinate space of this Node into the coordinate space of its Scene.
   */
  def localToScene(localPoint: Point2D): Point2D = delegate.localToScene(localPoint)

  /**
   * Finds this Node, or the first sub-node, based on the given CSS selector.
   */
  def lookup(selector: String): Node = delegate.lookup(selector)

  /**
   * Finds all Nodes, including this one and any children, which match the given CSS selector.
   */
  def lookupAll(selector: String): Set[jfxs.Node] = delegate.lookupAll(selector).asScala.toSet

  /**
   * Returns the node's maximum height for use in layout calculations.
   */
  def maxHeight(height: Double): Double = delegate.maxHeight(height)

  /**
   * Returns the node's maximum width for use in layout calculations.
   */
  def maxWidth(width: Double): Double = delegate.maxWidth(width)

  /**
   * Returns the node's minimum height for use in layout calculations.
   */
  def minHeight(height: Double): Double = delegate.minHeight(height)

  /**
   * Returns the node's minimum width for use in layout calculations.
   */
  def minWidth(width: Double): Double = delegate.minWidth(width)

  /**
   * Transforms a rectangle from the coordinate space of the parent into the local coordinate space of this Node.
   */
  def parentToLocal(parentBounds: Bounds): Bounds = delegate.parentToLocal(parentBounds)

  /**
   * Transforms a point from the coordinate space of the parent into the local coordinate space of this Node.
   */
  def parentToLocal(parentX: Double, parentY: Double): Point2D = delegate.parentToLocal(parentX, parentY)

  /**
   * Transforms a point from the coordinate space of the parent into the local coordinate space of this Node.
   */
  def parentToLocal(parentPoint: Point2D): Point2D = delegate.parentToLocal(parentPoint)

  /**
   * Sets the node's layoutX and layoutY translation properties in order to relocate this node to the x,y location in
   * the parent.
   */
  def relocate(x: Double, y: Double): Unit = {
    delegate.relocate(x, y)
  }

  /**
   * Requests that this Node get the input focus, and that this Node's top-level ancestor become the focused window.
   */
  def requestFocus(): Unit = {
    delegate.requestFocus()
  }

  /**
   * If the node is resizable, will set its layout bounds to the specified width and height.
   */
  def resize(width: Double, height: Double): Unit = {
    delegate.resize(width, height)
  }

  /**
   * If the node is resizable, will set its layout bounds to the specified width and height.
   */
  def resizeRelocate(x: Double, y: Double, width: Double, height: Double): Unit = {
    delegate.resizeRelocate(x, y, width, height)
  }

  /**
   * Transforms a rectangle from the coordinate space of the Scene into the local coordinate space of this Node.
   */
  def sceneToLocal(sceneBounds: Bounds): Bounds = delegate.sceneToLocal(sceneBounds)

  /**
   * Transforms a point from the coordinate space of the Scene into the local coordinate space of this Node.
   */
  def sceneToLocal(sceneX: Double, sceneY: Double): Point2D = delegate.sceneToLocal(sceneX, sceneY)

  /**
   * Transforms a point from the coordinate space of the Scene into the local coordinate space of this Node.
   */
  def sceneToLocal(scenePoint: Point2D): Point2D = delegate.sceneToLocal(scenePoint)

  /**
   * Takes a snapshot of this node and returns the rendered image when it is ready.
   */
  def snapshot(params: SnapshotParameters, image: WritableImage): WritableImage =
    delegate.snapshot(delegateOrNull(params), delegateOrNull(image))

  /**
   * Takes a snapshot of this node at the next frame and calls the specified callback method when the image is ready.
   * Arguments `params` and `image` can be null.
   */
  def snapshot(callback: SnapshotResult => Unit, params: SnapshotParameters, image: WritableImage): Unit = {
    val jfxCallback = new jfxu.Callback[jfxs.SnapshotResult, java.lang.Void] {
      override def call(result: jfxs.SnapshotResult): java.lang.Void = {
        callback(new SnapshotResult(result))
        null
      }
    }
    delegate.snapshot(jfxCallback, params, image)
  }

  /**
   * Confirms a potential drag and drop gesture that is recognized over this Node.
   */
  def startDragAndDrop(transferModes: jfxsi.TransferMode*): Dragboard =
    delegate.startDragAndDrop(transferModes: _*)

  /**
   * Starts a full press-drag-release gesture with this node as gesture source.
   */
  def startFullDrag(): Unit = {
    delegate.startFullDrag()
  }

  /**
   * Moves this Node to the back of its sibling nodes in terms of z-order.
   */
  def toBack(): Unit = {
    delegate.toBack()
  }

  /**
   * Moves this Node to the front of its sibling nodes in terms of z-order.
   */
  def toFront(): Unit = {
    delegate.toFront()
  }

  /**
   * An affine transform that holds the computed local-to-parent transform. This is the concatenation of all transforms
   * in this node, including all of the convenience transforms.
   *
   * @since
   *   2.2
   */
  def localToParentTransform: Transform = delegate.getLocalToParentTransform

  /**
   * An affine transform that holds the computed local-to-scene transform. This is the concatenation of all transforms
   * in this node's parents and in this node, including all of the convenience transforms.
   *
   * @since
   *   2.2
   */
  def localToSceneTransform: Transform = delegate.getLocalToSceneTransform

  /**
   * Defines a function to be called when user performs a rotation action.
   *
   * @since
   *   2.2
   */
  def onRotate: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.RotateEvent]] = delegate.onRotateProperty

  def onRotate_=(v: jfxe.EventHandler[_ >: jfxsi.RotateEvent]): Unit = {
    onRotate() = v
  }

  /**
   * Defines a function to be called when a rotation gesture ends.
   *
   * @since
   *   2.2
   */
  def onRotationFinished: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.RotateEvent]] =
    delegate.onRotationFinishedProperty()

  def onRotationFinished_=(v: jfxe.EventHandler[_ >: jfxsi.RotateEvent]): Unit = {
    onRotationFinished() = v
  }

  /**
   * Defines a function to be called when a rotation gesture starts.
   *
   * @since
   *   2.2
   */
  def onRotationStarted: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.RotateEvent]] =
    delegate.onRotationFinishedProperty()

  def onRotationStarted_=(v: jfxe.EventHandler[_ >: jfxsi.RotateEvent]): Unit = {
    onRotationStarted() = v
  }

  /**
   * Defines a function to be called when a Scroll gesture ends.
   *
   * @since
   *   2.2
   */
  def onScrollFinished: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.ScrollEvent]] = delegate.onScrollFinishedProperty()

  def onScrollFinished_=(v: jfxe.EventHandler[_ >: jfxsi.ScrollEvent]): Unit = {
    onScrollFinished() = v
  }

  /**
   * Defines a function to be called when a Scroll gesture starts.
   *
   * @since
   *   2.2
   */
  def onScrollStarted: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.ScrollEvent]] = delegate.onScrollStartedProperty()

  def onScrollStarted_=(v: jfxe.EventHandler[_ >: jfxsi.ScrollEvent]): Unit = {
    onScrollStarted() = v
  }

  /**
   * Defines a function to be called when a Swipe Down gesture starts.
   *
   * @since
   *   2.2
   */
  def onSwipeDown: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.SwipeEvent]] = delegate.onSwipeDownProperty()

  def onSwipeDown_=(v: jfxe.EventHandler[_ >: jfxsi.SwipeEvent]): Unit = {
    onSwipeDown() = v
  }

  /**
   * Defines a function to be called when a Swipe Down gesture starts.
   *
   * @since
   *   2.2
   */
  def onSwipeLeft: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.SwipeEvent]] = delegate.onSwipeLeftProperty()

  def onSwipeLeft_=(v: jfxe.EventHandler[_ >: jfxsi.SwipeEvent]): Unit = {
    onSwipeLeft() = v
  }

  /**
   * Defines a function to be called when a Swipe Up gesture starts.
   *
   * @since
   *   2.2
   */
  def onSwipeUp: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.SwipeEvent]] = delegate.onSwipeUpProperty()

  def onSwipeUp_=(v: jfxe.EventHandler[_ >: jfxsi.SwipeEvent]): Unit = {
    onSwipeUp() = v
  }

  /**
   * Defines a function to be called when a Swipe Right gesture starts.
   *
   * @since
   *   2.2
   */
  def onSwipeRight: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.SwipeEvent]] = delegate.onSwipeRightProperty()

  def onSwipeRight_=(v: jfxe.EventHandler[_ >: jfxsi.SwipeEvent]): Unit = {
    onSwipeRight() = v
  }

  /**
   * Defines a function to be called when user performs a Touch action.
   *
   * @since
   *   2.2
   */
  def onZoom: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.ZoomEvent]] = delegate.onZoomProperty()

  def onZoom_=(v: jfxe.EventHandler[_ >: jfxsi.ZoomEvent]): Unit = {
    onZoom() = v
  }

  /**
   * Defines a function to be called when a Zoom gesture ends.
   *
   * @since
   *   2.2
   */
  def onZoomFinished: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.ZoomEvent]] = delegate.onZoomFinishedProperty()

  def onZoomFinished_=(v: jfxe.EventHandler[_ >: jfxsi.ZoomEvent]): Unit = {
    onZoomFinished() = v
  }

  /**
   * Defines a function to be called when a Zoom gesture starts.
   *
   * @since
   *   2.2
   */
  def onZoomStarted: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.ZoomEvent]] = delegate.onZoomStartedProperty()

  def onZoomStarted_=(v: jfxe.EventHandler[_ >: jfxsi.ZoomEvent]): Unit = {
    onZoomStarted() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Moved action.
   *
   * @since
   *   2.2
   */
  def onTouchMoved: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.TouchEvent]] = delegate.onTouchMovedProperty()

  def onTouchMoved_=(v: jfxe.EventHandler[_ >: jfxsi.TouchEvent]): Unit = {
    onTouchMoved() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Pressed action.
   *
   * @since
   *   2.2
   */
  def onTouchPressed: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.TouchEvent]] = delegate.onTouchPressedProperty()

  def onTouchPressed_=(v: jfxe.EventHandler[_ >: jfxsi.TouchEvent]): Unit = {
    onTouchPressed() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Released action.
   *
   * @since
   *   2.2
   */
  def onTouchReleased: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.TouchEvent]] = delegate.onTouchReleasedProperty()

  def onTouchReleased_=(v: jfxe.EventHandler[_ >: jfxsi.TouchEvent]): Unit = {
    onTouchReleased() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Stationary action.
   *
   * @since
   *   2.2
   */
  def onTouchStationary: ObjectProperty[jfxe.EventHandler[_ >: jfxsi.TouchEvent]] = delegate.onTouchStationaryProperty()

  def onTouchStationary_=(v: jfxe.EventHandler[_ >: jfxsi.TouchEvent]): Unit = {
    onTouchStationary() = v
  }

  override def eventHandlerDelegate: EventHandled = new EventHandled {
    def addEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E]): Unit =
      delegate.addEventHandler(eventType, eventHandler)

    def removeEventHandler[E <: jfxe.Event](
        eventType: jfxe.EventType[E],
        eventHandler: jfxe.EventHandler[_ >: E]
    ): Unit =
      delegate.removeEventHandler(eventType, eventHandler)

    def addEventFilter[E <: jfxe.Event](eventType: jfxe.EventType[E], eventFilter: jfxe.EventHandler[_ >: E]): Unit =
      delegate.addEventFilter(eventType, eventFilter)

    def removeEventFilter[E <: jfxe.Event](eventType: jfxe.EventType[E], eventFilter: jfxe.EventHandler[_ >: E]): Unit =
      delegate.removeEventFilter(eventType, eventFilter)

    def buildEventDispatchChain(chain: jfxe.EventDispatchChain): jfxe.EventDispatchChain =
      delegate.buildEventDispatchChain(chain)
  }

  /**
   * Defines the rendering and picking order of this `Node` within its parent. <p> This property is used to alter the
   * rendering and picking order of a node within its parent without reordering the parent's `children` list. For
   * example, this can be used as a more efficient way to implement transparency sorting. To do this, an application can
   * assign the viewOrder value of each node to the computed distance between that node and the viewer. </p> <p> The
   * parent will traverse its `children` in decreasing `viewOrder` order. This means that a child with a lower
   * `viewOrder` will be in front of a child with a higher `viewOrder`. If two children have the same `viewOrder`, the
   * parent will traverse them in the order they appear in the parent's `children` list. </p> <p> However, `viewOrder`
   * does not alter the layout and focus traversal order of this Node within its parent. A parent always traverses its
   * `children` list in order when doing layout or focus traversal. </p>
   *
   * @return
   *   the view order for this `Node`
   * @since
   *   9 Default value is 0.0
   */
  def viewOrder: DoubleProperty = delegate.viewOrderProperty

  def viewOrder_(value: Double): Unit = {
    viewOrder() = value
  }

}
