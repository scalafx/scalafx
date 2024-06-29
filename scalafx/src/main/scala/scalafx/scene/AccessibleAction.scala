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

package scalafx.scene

import javafx.{scene => jfxs}
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/**
 * This enum describes the actions that an assistive technology
 * such as a screen reader can request from the scene graph.
 *
 * The {@link AccessibleRole} dictates the set of actions that
 * the screen reader will request for a particular control. For
 * example, a push button normally fires an event to indicate
 * that it was pressed in response to the FIRE action.
 *
 * An action may have any number of parameters, depending on the particular action.
 *
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/AccessibleAction.html]]
 */
object AccessibleAction extends SFXEnumDelegateCompanion[jfxs.AccessibleAction, AccessibleAction] {

  /**
   * Request that the node be decremented by a large value.
   * A smaller decrement is requested using {@link #DECREMENT}.
   */
  case object BlockDecrement extends AccessibleAction(jfxs.AccessibleAction.BLOCK_DECREMENT)

  /**
   * Request that the node be incremented by a large value.
   * A smaller increment is requested using {@link #INCREMENT}.
   *
   * Used by Slider, ScrollBar, and others
   */
  case object BlockIncrement extends AccessibleAction(jfxs.AccessibleAction.BLOCK_INCREMENT)

  /**
   * Request that the node should become collapsed.
   *
   * Used by TreeItem, TitledPane, and others
   */
  case object Collapse extends AccessibleAction(jfxs.AccessibleAction.COLLAPSE)

  /**
   * Request that the node be decremented by a small value.
   * A larger decrement is requested using {@link #BLOCK_DECREMENT}.
   *
   * Used by Slider, ScrollBar, and others
   */
  case object Decrement extends AccessibleAction(jfxs.AccessibleAction.DECREMENT)

  /**
   * Request that the node should become expanded.
   *
   * Used by TreeItem, TitledPane, and others
   */
  case object Expand extends AccessibleAction(jfxs.AccessibleAction.EXPAND)

  /**
   * Fires the primary action for the node. For example, a push
   * button will normally send an action event to notify listeners
   * that is has been activated.
   *
   * Used by Button, Hyperlink, and others
   */
  case object Fire extends AccessibleAction(jfxs.AccessibleAction.FIRE)

  /**
   * Request that the node be incremented by a small value.
   * A larger increment is requested using {@link #BLOCK_INCREMENT}.
   *
   * Used by Slider, ScrollBar, and others
   */
  case object Increment extends AccessibleAction(jfxs.AccessibleAction.INCREMENT)

  /**
   * Request that the node take focus.  By default, a node will
   * request focus using  {@link javafx.scene.Node#requestFocus()}.
   * Both JavaFX and the assisteve technology have the concept of
   * a focus node and most of the time, they are the same.
   * In some cases, a control might want the JavaFX focus to remain
   * on the parent, while the assistive technology focus is on the child.
   * For example, a table may respond to this request by setting focus
   * to a cell inside the table before allowing the default to run.
   *
   * Used by Node, TabItem, TableCell and others
   */
  case object RequestFocus extends AccessibleAction(jfxs.AccessibleAction.REQUEST_FOCUS)

  /**
   * Request the node to show an item, scrolling if required.
   *
   * Used by ListView, TreeView, and others
   *
   * Parameters:
   * <ul>
   * <li> {@link Node} the item to show </li>
   * </ul>
   */
  case object ShowItem extends AccessibleAction(jfxs.AccessibleAction.SHOW_ITEM)

  /**
   * Request the node to show a text range, scrolling if required.
   *
   * Used by TextField and TextArea.
   *
   * Parameters:
   * <ul>
   * <li> {@link java.lang.Integer} the start offset </li>
   * <li> {@link java.lang.Integer} the end offset </li>
   * </ul>
   */
  case object ShowTextRange extends AccessibleAction(jfxs.AccessibleAction.SHOW_TEXT_RANGE)

  /**
   * Request the node to set the selection to a list of items.
   *
   * Used by ListView, TreeView, and others
   *
   * Parameters:
   * <ul>
   * <li> {@link javafx.collections.ObservableList}&lt;{@link Node}&gt; the items to select </li>
   * </ul>
   */
  case object SetSelectedItems extends AccessibleAction(jfxs.AccessibleAction.SET_SELECTED_ITEMS)

  /**
   * Request the node to set the selection to range of text.
   *
   * Used by TextField and TextArea.
   *
   * Parameters:
   * <ul>
   * <li> {@link java.lang.Integer} the start offset </li>
   * <li> {@link java.lang.Integer} the end offset </li>
   * </ul>
   */
  case object SetTextSelection extends AccessibleAction(jfxs.AccessibleAction.SET_TEXT_SELECTION)

  /**
   * Request the node to set the current text.
   *
   * Used by TextField and TextArea.
   *
   * Parameters:
   * <ul>
   * <li> {@link String} the new text</li>
   * </ul>
   */
  case object SetText extends AccessibleAction(jfxs.AccessibleAction.SET_TEXT)

  /**
   * Request the node to set the current value.
   *
   * Used by Slider, Scrollbars, and others
   *
   * Parameters:
   * <ul>
   * <li> {@link java.lang.Double} the new value </li>
   * </ul>
   */
  case object SetValue extends AccessibleAction(jfxs.AccessibleAction.SET_VALUE)

  /**
   * Request the node to show a menu.  If the node is a control,
   * then the context menu for the control is shown.  If the node
   * is a menu, then the submenu for the menu is shown.
   *
   * Used by Node, Menu
   *
   * Parameters:
   * <ul>
   * </ul>
   */
  case object ShowMenu extends AccessibleAction(jfxs.AccessibleAction.SHOW_MENU)

  protected override def unsortedValues: Array[AccessibleAction] = Array(
    BlockDecrement,
    BlockIncrement,
    Collapse,
    Decrement,
    Expand,
    Fire,
    Increment,
    RequestFocus,
    ShowItem,
    ShowTextRange,
    SetSelectedItems,
    SetTextSelection,
    SetText,
    SetValue,
    ShowMenu
  )
}

sealed abstract class AccessibleAction(override val delegate: jfxs.AccessibleAction)
    extends SFXEnumDelegate[jfxs.AccessibleAction]
