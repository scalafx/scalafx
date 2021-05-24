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

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, StringProperty}
import scalafx.collections._
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.scene.Node

import scala.language.implicitConversions

/**
 * Object companion for [[scalafx.scene.control.ButtonBar]].
 */
object ButtonBar {

  /**
   * The default button ordering on Windows.
   */
  val ButtonOrderWindows: String = jfxsc.ButtonBar.BUTTON_ORDER_WINDOWS

  /**
   * The default button ordering on Mac OS.
   */
  val ButtonOrderMacOs: String = jfxsc.ButtonBar.BUTTON_ORDER_MAC_OS

  /**
   * The default button ordering on Linux (specifically, GNOME).
   */
  val ButtonOrderLinux: String = jfxsc.ButtonBar.BUTTON_ORDER_LINUX

  /**
   * A button ordering string that specifies there is no button ordering. In other words, buttons will be placed in the
   * order that exist in the [[scalafx.scene.control.ButtonBar.buttons]] list. The only aspect of layout that makes this
   * different than using an HBox is that the buttons are right-aligned.
   */
  val ButtonOrderNone: String = jfxsc.ButtonBar.BUTTON_ORDER_NONE

  /**
   * Converts a ScalaFX ButtonBar to its JavaFX counterpart.
   *
   * @param v
   *   ScalaFX ButtonBar
   * @return
   *   JavaFX ButtonBar
   */
  implicit def sfxButtonBar2jfx(v: ButtonBar): jfxsc.ButtonBar =
    if (v != null) v.delegate else null

  /**
   * Sets the given ButtonData on the given button. If this button is subsequently placed in a
   * [[scalafx.scene.control.ButtonBar]] it will be placed in the correct position relative to all other buttons in the
   * bar.
   *
   * @param button
   *   The button to annotate with the given { @link ButtonData} value.
   * @param buttonData
   *   The ButtonData to designate the button as.
   */
  def setButtonData(button: Node, buttonData: ButtonBar.ButtonData): Unit = {
    jfxsc.ButtonBar.setButtonData(button, buttonData)
  }

  /**
   * Returns the previously set ButtonData property on the given button. If this was never set, this method will return
   * null.
   *
   * @param button
   *   The button to return the previously set ButtonData for.
   */
  def getButtonData(button: Node): ButtonBar.ButtonData = jfxsc.ButtonBar.getButtonData(button)

  /**
   * By default all buttons are uniformly sized in a ButtonBar, meaning that all buttons take the width of the widest
   * button. It is possible to opt-out of this on a per-button basis, but calling the setButtonUniformSize method with a
   * boolean value of false.
   *
   * <p>If a button is excluded from uniform sizing, it is both excluded from being resized away from its preferred
   * size, and also excluded from the measuring process, so its size will not influence the maximum size calculated for
   * all buttons in the ButtonBar.
   *
   * @param button
   *   The button to include / exclude from uniform sizing.
   * @param uniformSize
   *   Boolean true to force uniform sizing on the button, false to exclude the button from uniform sizing.
   */
  def setButtonUniformSize(button: Node, uniformSize: Boolean): Unit = {
    jfxsc.ButtonBar.setButtonUniformSize(button, uniformSize)
  }

  /**
   * Returns whether the given node is part of the uniform sizing calculations or not. By default all nodes that have
   * not opted out (via [[scalafx.scene.control.ButtonBar.setButtonUniformSize(N o d e, b o o l e a n]] ) will return
   * true here.
   */
  def isButtonUniformSize(button: Node): Boolean = {
    jfxsc.ButtonBar.isButtonUniformSize(button)
  }

  /**
   * Wraps a $JFX $URL0 $FC]].
   *
   * @constructor
   *   Creates a new ButtonData from a JavaFX one.
   * @param delegate
   *   JavaFX ButtonData
   */
  sealed abstract class ButtonData(override val delegate: jfxsc.ButtonBar.ButtonData)
      extends SFXEnumDelegate[jfxsc.ButtonBar.ButtonData] {
    def typeCode: String = delegate.getTypeCode
  }

  /**
   * Wraps a $JFX $URL0 $FC]].
   *
   * @define
   *   EN ButtonData
   * @define
   *   URL0
   *   [[http://docs.oracle.com/javase/8/javafx/api/javafx/javafx/scene/control/ButtonBar.ButtonData.html@define JFX JavaFX @define ORIGINALDOC Original Documentation]].
   */
  object ButtonData extends SFXEnumDelegateCompanion[jfxsc.ButtonBar.ButtonData, ButtonData] {

    /**
     * Buttons with this style tag will statically end up on the left end of the bar.
     *
     * <p><strong>Button order code:</strong> L
     */
    case object Left extends ButtonData(jfxsc.ButtonBar.ButtonData.LEFT)

    /**
     * Buttons with this style tag will statically end up on the right end of the bar.
     *
     * <p><strong>Button order code:</strong> R
     */
    case object Right extends ButtonData(jfxsc.ButtonBar.ButtonData.RIGHT)

    /**
     * A tag for the "help" button that normally is supposed to be on the right.
     *
     * <p><strong>Button order code:</strong> H
     */
    case object Help extends ButtonData(jfxsc.ButtonBar.ButtonData.HELP)

    /**
     * A tag for the "help2" button that normally is supposed to be on the left.
     *
     * <p><strong>Button order code:</strong> E
     */
    case object Help2 extends ButtonData(jfxsc.ButtonBar.ButtonData.HELP_2)

    /**
     * A tag for the "yes" button.
     *
     * <p><strong>Is default button:</strong> True <p><strong>Button order code:</strong> Y
     */
    case object Yes extends ButtonData(jfxsc.ButtonBar.ButtonData.YES)

    /**
     * A tag for the "no" button.
     *
     * <p><strong>Is cancel button:</strong> True <p><strong>Button order code:</strong> N
     */
    case object No extends ButtonData(jfxsc.ButtonBar.ButtonData.NO)

    /**
     * A tag for the "next" or "forward" button.
     *
     * <p><strong>Is default button:</strong> True <p><strong>Button order code:</strong> X
     */
    case object NextForward extends ButtonData(jfxsc.ButtonBar.ButtonData.NEXT_FORWARD)

    /**
     * A tag for the "back" or "previous" button.
     *
     * <p><strong>Button order code:</strong> B
     */
    case object BackPrevious extends ButtonData(jfxsc.ButtonBar.ButtonData.BACK_PREVIOUS)

    /**
     * A tag for the "finish".
     *
     * <p><strong>Is default button:</strong> True <p><strong>Button order code:</strong> I
     */
    case object Finish extends ButtonData(jfxsc.ButtonBar.ButtonData.FINISH)

    /**
     * A tag for the "apply" button.
     *
     * <p><strong>Button order code:</strong> A
     */
    case object Apply extends ButtonData(jfxsc.ButtonBar.ButtonData.APPLY)

    /**
     * A tag for the "cancel" or "close" button.
     *
     * <p><strong>Is cancel button:</strong> True <p><strong>Button order code:</strong> C
     */
    case object CancelClose extends ButtonData(jfxsc.ButtonBar.ButtonData.CANCEL_CLOSE)

    /**
     * A tag for the "ok" or "done" button.
     *
     * <p><strong>Is default button:</strong> True <p><strong>Button order code:</strong> O
     */
    case object OKDone extends ButtonData(jfxsc.ButtonBar.ButtonData.OK_DONE)

    /**
     * All Uncategorized, Other, or "Unknown" buttons. Tag will be "other".
     *
     * <p><strong>Button order code:</strong> U
     */
    case object Other extends ButtonData(jfxsc.ButtonBar.ButtonData.OTHER)

    /**
     * A glue push gap that will take as much space as it can and at least an "unrelated" gap. (Platform dependent)
     *
     * <p><strong>Button order code:</strong> +
     */
    case object BigGap extends ButtonData(jfxsc.ButtonBar.ButtonData.BIG_GAP)

    /**
     * An "unrelated" gap. (Platform dependent)
     *
     * <p><strong>Button order code:</strong> _ (underscore)
     */
    case object SmallGap extends ButtonData(jfxsc.ButtonBar.ButtonData.SMALL_GAP)

    protected override def unsortedValues: Array[ButtonData] = Array(
      Left,
      Right,
      Help,
      Help2,
      Yes,
      No,
      NextForward,
      BackPrevious,
      Finish,
      Apply,
      CancelClose,
      OKDone,
      Other,
      BigGap,
      SmallGap
    )
  }

}

/**
 * A ButtonBar is essentially a HBox, with the additional functionality for operating system specific button placement.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * @define
 *   TC ButtonBar
 * @define
 *   URL0
 *   [[https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ButtonBar.html@define JFX JavaFX @define ORIGINALDOC Original Documentation]].
 * @constructor
 *   Creates a default ButtonBar instance using the default properties for the users operating system.
 */
class ButtonBar(override val delegate: jfxsc.ButtonBar = new jfxsc.ButtonBar())
    extends Control(delegate)
    with SFXDelegate[jfxsc.ButtonBar] {

  /**
   * Creates a ButtonBar with the given button order (refer to 'buttonOrder' property for more information).
   *
   * @param buttonOrder
   *   The button order to use in this button bar instance.
   */
  def this(buttonOrder: String) = this(new jfxsc.ButtonBar(buttonOrder))

  def buttons: ObservableBuffer[jfxs.Node] = delegate.getButtons

  def buttons_=(c: Node): Unit = {
    fillSFXCollectionWithOne(delegate.getButtons, c)
  }

  def buttons_=(c: Iterable[Node]): Unit = {
    fillSFXCollection(delegate.getButtons, c)
  }

  /**
   * The order for the typical buttons in a standard button bar. It is one letter per
   * [[scalafx.scene.control.ButtonBar.ButtonData]] enumeration value. Default button orders for operating systems are
   * also available: [[scalafx.scene.control.ButtonBar.ButtonOrderWindows]],
   * [[scalafx.scene.control.ButtonBar.ButtonOrderMacOs]], and [[scalafx.scene.control.ButtonBar.ButtonOrderLinux]].
   */
  def buttonOrder: StringProperty = delegate.buttonOrderProperty

  def buttonOrder_=(v: String): Unit = {
    buttonOrder() = v
  }

  /**
   * Specifies the minimum width of all buttons placed in this button bar.
   */
  def buttonMinWidth: DoubleProperty = delegate.buttonMinWidthProperty

  def buttonMinWidth_=(v: Double): Unit = {
    buttonMinWidth() = v
  }
}
