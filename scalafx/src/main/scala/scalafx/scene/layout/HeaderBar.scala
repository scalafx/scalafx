/*
 * Copyright (c) 2011-2026, ScalaFX Project
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

package scalafx.scene.layout

import javafx.scene.layout as jfxsl
import javafx.{geometry as jfxg, scene as jfxs}
import scalafx.Includes.*
import scalafx.beans.property.{BooleanProperty, ObjectProperty, ReadOnlyDoubleProperty, ReadOnlyObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Node
import scalafx.stage.Stage

import scala.language.implicitConversions

object HeaderBar {
  implicit def sfxHeaderBar2jfx(v: HeaderBar): jfxsl.HeaderBar = if (v != null) v.delegate else null

  /**
   * Specifies the `HeaderDragType` of the child, indicating whether it is a draggable
   * part of the `HeaderBar`.
   *
   * Setting the value to `null` will remove the flag.
   *
   * @param child the child node
   * @param value the `HeaderDragType`, or `null` to remove the flag
   */
  def setDragType(child: Node, value: HeaderDragType): Unit =
    jfxsl.HeaderBar.setDragType(child, value)

  /**
   * Returns the `HeaderDragType` of the specified child.
   *
   * @param child the child node
   * @return the `HeaderDragType`, or `null` if not set
   */
  def getDragType(child: Node): HeaderDragType =
    jfxsl.HeaderBar.getDragType(child)

  /**
   * Specifies the `HeaderButtonType` of the child, indicating its semantic use in the header bar.
   *
   * This property can be set on any [[Node]]. Specifying a header button type also provides the behavior
   * associated with the button type. If the default behavior is not desired, applications can register an
   * event filter on the child node that consumes the [[scalafx.scene.input.MouseEvent#MouseReleased]] event.
   *
   * @param child the child node
   * @param value the `HeaderButtonType`, or `null`
   */
  def setButtonType(child: Node, value: HeaderButtonType): Unit =
    jfxsl.HeaderBar.setButtonType(child, value)

  /**
   * Returns the `HeaderButtonType` of the specified child.
   *
   * @param child the child node
   * @return the `HeaderButtonType`, or `null`
   */
  def getButtonType(child: Node): HeaderButtonType =
    jfxsl.HeaderBar.getButtonType(child)

  /**
   * Sentinel value that can be used for [[setPrefButtonHeight]] to indicate that
   * the platform should choose the platform-specific default button height.
   */
  val UseDefaultSize: Double = jfxsl.HeaderBar.USE_DEFAULT_SIZE

  /**
   * Specifies the preferred height of the system-provided header buttons of the specified stage.
   *
   * @param stage  the `Stage`
   * @param height the preferred height, or 0 to hide the system-provided header buttons
   */
  def setPrefButtonHeight(stage: Stage, height: Double): Unit =
    jfxsl.HeaderBar.setPrefButtonHeight(stage, height)

  /**
   * Returns the preferred height of the system-provided header buttons of the specified stage.
   *
   * @param stage the `Stage`
   * @return the preferred height of the system-provided header buttons
   */
  def getPrefButtonHeight(stage: Stage): Double =
    jfxsl.HeaderBar.getPrefButtonHeight(stage)

  /**
   * Sets the alignment for the child when contained in a `HeaderBar`.
   * If set, will override the header bar's default alignment for the child's position.
   * Setting the value to `null` will remove the constraint.
   *
   * @param child the child node
   * @param value the alignment position
   */
  def setAlignment(child: Node, value: Pos): Unit =
    jfxsl.HeaderBar.setAlignment(child, value)

  /**
   * Returns the child's alignment in the `HeaderBar`.
   *
   * @param child the child node
   * @return the alignment position for the child, or `null` if no alignment was set
   */
  def getAlignment(child: Node): Pos =
    jfxsl.HeaderBar.getAlignment(child)

  /**
   * Sets the margin for the child when contained in a `HeaderBar`.
   * If set, the header bar will lay it out with the margin space around it.
   * Setting the value to `null` will remove the constraint.
   *
   * @param child the child node
   * @param value the margin of space around the child
   */
  def setMargin(child: Node, value: Insets): Unit =
    jfxsl.HeaderBar.setMargin(child, value)

  /**
   * Returns the child's margin.
   *
   * @param child the child node
   * @return the margin for the child, or `null` if no margin was set
   */
  def getMargin(child: Node): Insets =
    jfxsl.HeaderBar.getMargin(child)
}

/**
 * A client-area header bar that is used as a replacement for the system-provided header bar in stages with
 * the StageStyle.Extended style.
 *
 * Wraps [[https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/HeaderBar.html]]
 */

class HeaderBar(override val delegate: jfxsl.HeaderBar = new jfxsl.HeaderBar)
    extends Region(delegate)
    with SFXDelegate[jfxsl.HeaderBar] {

  /**
   * The system-provided minimum recommended height for the `HeaderBar`, which usually corresponds
   * to the height of the default header buttons. Applications can use this value as a sensible lower limit
   * for the height of the `HeaderBar`.
   */
  def minSystemHeight: ReadOnlyDoubleProperty = delegate.minSystemHeightProperty

  /**
   * The center area of the `HeaderBar`.
   */
  def center: ObjectProperty[jfxs.Node] = delegate.centerProperty()
  def center_=(n: Node): Unit           = delegate.setCenter(n)

  /**
   * The leading area of the `HeaderBar`.
   */
  def leading: ObjectProperty[jfxs.Node] = delegate.leadingProperty()
  def leading_=(n: Node): Unit           = delegate.setLeading(n)

  /**
   * The trailing area of the `HeaderBar`.
   */
  def trailing: ObjectProperty[jfxs.Node] = delegate.trailingProperty()
  def trailing_=(n: Node): Unit           = delegate.setTrailing(n)

  /**
   * Specifies whether additional padding should be added to the leading side of the `HeaderBar`.
   * The size of the additional padding corresponds to the size of the system-reserved area that contains
   * the default header buttons (iconify, maximize, and close). If the system-reserved area contains no
   * header buttons, no additional padding is added to the leading side of the `HeaderBar`.
   */
  def leadingSystemPadding: BooleanProperty    = delegate.leadingSystemPaddingProperty
  def leadingSystemPadding_=(b: Boolean): Unit = delegate.setLeadingSystemPadding(b)

  /**
   * Specifies whether additional padding should be added to the trailing side of the `HeaderBar`.
   * The size of the additional padding corresponds to the size of the system-reserved area that contains
   * the default header buttons (iconify, maximize, and close). If the system-reserved area contains no
   * header buttons, no additional padding is added to the trailing side of the `HeaderBar`.
   */
  def trailingSystemPadding: BooleanProperty    = delegate.trailingSystemPaddingProperty
  def trailingSystemPadding_=(b: Boolean): Unit = delegate.setTrailingSystemPadding(b)

  def leftSystemInset: ReadOnlyObjectProperty[jfxg.Dimension2D] = delegate.leftSystemInsetProperty

  /**
   * Describes the size of the right system-reserved inset, which is an area reserved for the iconify, maximize,
   * and close window buttons. If there are no window buttons on the right side of the window, the returned area
   * is an empty `Dimension2D`.
   */
  def rightSystemInset: ReadOnlyObjectProperty[jfxg.Dimension2D] = delegate.rightSystemInsetProperty
}
