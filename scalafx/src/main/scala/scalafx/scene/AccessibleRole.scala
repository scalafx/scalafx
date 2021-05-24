/*
 * Copyright (c) 2011-2018, ScalaFX Project
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
 * This enum describes the accessible role for a `Node`.
 *
 * The role is used by assistive technologies such as screen readers to decide the set of actions and attributes for a
 * node. For example, when the screen reader needs the current value of a slider, it will request it using the value
 * attribute. When the screen reader changes the value of the slider, it will use an action to set the current value of
 * the slider. The slider must respond appropriately to both these requests.
 *
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/AccessibleRole.html]]
 */
object AccessibleRole extends SFXEnumDelegateCompanion[jfxs.AccessibleRole, AccessibleRole] {

  /**
   * Button role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#FIRE}
   * </li> </ul>
   */
  case object Button extends AccessibleRole(jfxs.AccessibleRole.BUTTON)

  /**
   * Check Box role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#SELECTED} </li> <li>
   * {@link AccessibleAttribute#INDETERMINATE} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#FIRE} </li> </ul>
   */
  case object CheckBox extends AccessibleRole(jfxs.AccessibleRole.CHECK_BOX)

  /**
   * Check Menu Item role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#ACCELERATOR} </li>
   * <li> {@link AccessibleAttribute#MNEMONIC} </li> <li> {@link AccessibleAttribute#DISABLED} </li> <li> {@link
   * AccessibleAttribute#SELECTED} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#FIRE} </li> </ul>
   */
  case object CheckMenuItem extends AccessibleRole(jfxs.AccessibleRole.CHECK_MENU_ITEM)

  /**
   * Combo Box role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#EXPANDED} </li> <li>
   * {@link AccessibleAttribute#EDITABLE} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#EXPAND} </li> <li>
   * {@link AccessibleAction#COLLAPSE} </li> </ul>
   */
  case object ComboBox extends AccessibleRole(jfxs.AccessibleRole.COMBO_BOX)

  /**
   * Context Menu role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#PARENT_MENU} </li> <li> {@link AccessibleAttribute#VISIBLE} </li>
   * </ul> Actions: <ul> </ul>
   */
  case object ContextMenu extends AccessibleRole(jfxs.AccessibleRole.CONTEXT_MENU)

  /**
   * Date Picker role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#DATE} </li> </ul>
   * Actions: <ul> </ul>
   */
  case object DatePicker extends AccessibleRole(jfxs.AccessibleRole.DATE_PICKER)

  /**
   * Decrement Button role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#FIRE}
   * </li> </ul>
   */
  case object DecrementButton extends AccessibleRole(jfxs.AccessibleRole.DECREMENT_BUTTON)

  /**
   * Hyperlink role.
   *
   * <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#VISITED} </li> </ul> Actions: <ul>
   * <li> {@link AccessibleAction#FIRE} </li> </ul>
   */
  case object Hyperlink extends AccessibleRole(jfxs.AccessibleRole.HYPERLINK)

  /**
   * Increment Button role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#FIRE}
   * </li> </ul>
   */
  case object IncrementButton extends AccessibleRole(jfxs.AccessibleRole.INCREMENT_BUTTON)

  /**
   * Image View role.
   *
   * Attributes: <ul> </ul> Actions: <ul> </ul> <p> It is strongly recommended that a text description of the image be
   * provided for each {@link ImageView}. This can be done by setting either {@link Node#accessibleTextProperty()} for
   * the {@link ImageView} or by using {@link AccessibleAttribute#LABELED_BY}. </p>
   */
  case object ImageView extends AccessibleRole(jfxs.AccessibleRole.IMAGE_VIEW)

  /**
   * List View role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#ITEM_AT_INDEX} </li> <li> {@link AccessibleAttribute#ITEM_COUNT}
   * </li> <li> {@link AccessibleAttribute#SELECTED_ITEMS} </li> <li> {@link AccessibleAttribute#MULTIPLE_SELECTION}
   * </li> <li> {@link AccessibleAttribute#VERTICAL_SCROLLBAR} </li> <li> {@link
   * AccessibleAttribute#HORIZONTAL_SCROLLBAR} </li> <li> {@link AccessibleAttribute#FOCUS_ITEM} </li> </ul> Actions:
   * <ul> <li> {@link AccessibleAction#SHOW_ITEM} </li> <li> {@link AccessibleAction#SET_SELECTED_ITEMS} </li> </ul>
   */
  case object ListView extends AccessibleRole(jfxs.AccessibleRole.LIST_VIEW)

  /**
   * List Item role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#INDEX} </li> <li>
   * {@link AccessibleAttribute#SELECTED} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#REQUEST_FOCUS} </li>
   * </ul>
   */
  case object ListItem extends AccessibleRole(jfxs.AccessibleRole.LIST_ITEM)

  /**
   * Menu role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#ACCELERATOR} </li>
   * <li> {@link AccessibleAttribute#MNEMONIC} </li> <li> {@link AccessibleAttribute#DISABLED} </li> <li> {@link
   * AccessibleAttribute#SUBMENU} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#FIRE} </li> </ul>
   */
  case object Menu extends AccessibleRole(jfxs.AccessibleRole.MENU)

  /**
   * Menu Bar role.
   *
   * Attributes: <ul> </ul> Actions: <ul> </ul>
   */
  case object MenuBar extends AccessibleRole(jfxs.AccessibleRole.MENU_BAR)

  /**
   * Menu Button role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#FIRE}
   * </li> </ul>
   */
  case object MenuButton extends AccessibleRole(jfxs.AccessibleRole.MENU_BUTTON)

  /**
   * Menu Item role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#ACCELERATOR} </li>
   * <li> {@link AccessibleAttribute#MNEMONIC} </li> <li> {@link AccessibleAttribute#DISABLED} </li> </ul> Actions: <ul>
   * <li> {@link AccessibleAction#FIRE} </li> </ul>
   */
  case object MenuItem extends AccessibleRole(jfxs.AccessibleRole.MENU_ITEM)

  /**
   * Node role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#ROLE} </li> <li> {@link AccessibleAttribute#PARENT} </li> <li>
   * {@link AccessibleAttribute#SCENE} </li> <li> {@link AccessibleAttribute#BOUNDS} </li> <li> {@link
   * AccessibleAttribute#DISABLED} </li> <li> {@link AccessibleAttribute#FOCUSED} </li> <li> {@link
   * AccessibleAttribute#VISIBLE} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#REQUEST_FOCUS} </li> </ul>
   * Optional Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#LABELED_BY}
   * </li> <li> {@link AccessibleAttribute#ROLE_DESCRIPTION} </li> <li> {@link AccessibleAttribute#HELP} </li> </ul>
   * Optional Actions: <ul> <li> {@link AccessibleAction#SHOW_MENU} </li> </ul>
   */
  case object Node extends AccessibleRole(jfxs.AccessibleRole.NODE)

  /**
   * Page role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#SELECTED} </li> </ul>
   * Actions: <ul> <li> {@link AccessibleAction#REQUEST_FOCUS} </li> </ul>
   */
  case object PageItem extends AccessibleRole(jfxs.AccessibleRole.PAGE_ITEM)

  /**
   * Pagination role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#ITEM_AT_INDEX} </li> <li> {@link AccessibleAttribute#ITEM_COUNT}
   * </li> <li> {@link AccessibleAttribute#FOCUS_ITEM} </li> </ul> Actions: <ul> </ul>
   */
  case object Pagination extends AccessibleRole(jfxs.AccessibleRole.PAGINATION)

  /**
   * Parent role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#CHILDREN} </li> </ul> Actions: <ul> </ul>
   */
  case object Parent extends AccessibleRole(jfxs.AccessibleRole.PARENT)

  /**
   * Password Field role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} - must return null or empty string </li> </ul> Actions: <ul>
   * </ul>
   */
  case object PasswordField extends AccessibleRole(jfxs.AccessibleRole.PASSWORD_FIELD)

  /**
   * Progress Indicator role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#VALUE} </li> <li> {@link AccessibleAttribute#MIN_VALUE} </li> <li>
   * {@link AccessibleAttribute#MAX_VALUE} </li> <li> {@link AccessibleAttribute#INDETERMINATE} </li> </ul> Actions:
   * <ul> </ul>
   */
  case object ProgressIndicator extends AccessibleRole(jfxs.AccessibleRole.PROGRESS_INDICATOR)

  /**
   * Radio Button role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#SELECTED} </li> </ul>
   * Actions: <ul> <li> {@link AccessibleAction#FIRE} </li> </ul>
   */
  case object RadioButton extends AccessibleRole(jfxs.AccessibleRole.RADIO_BUTTON)

  /**
   * Radio Menu Item role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#ACCELERATOR} </li>
   * <li> {@link AccessibleAttribute#MNEMONIC} </li> <li> {@link AccessibleAttribute#DISABLED} </li> <li> {@link
   * AccessibleAttribute#SELECTED} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#FIRE} </li> </ul>
   */
  case object RadioMenuItem extends AccessibleRole(jfxs.AccessibleRole.RADIO_MENU_ITEM)

  /**
   * Slider role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#VALUE} </li> <li> {@link AccessibleAttribute#MIN_VALUE} </li> <li>
   * {@link AccessibleAttribute#MAX_VALUE} </li> <li> {@link AccessibleAttribute#ORIENTATION} </li> </ul> Actions: <ul>
   * <li> {@link AccessibleAction#INCREMENT} </li> <li> {@link AccessibleAction#DECREMENT} </li> <li> {@link
   * AccessibleAction#SET_VALUE} </li> </ul>
   */
  case object Slider extends AccessibleRole(jfxs.AccessibleRole.SLIDER)

  /**
   * Spinner role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> </ul> Actions: <ul> <li> {@link
   * AccessibleAction#INCREMENT} </li> <li> {@link AccessibleAction#DECREMENT} </li> </ul>
   */
  case object Spinner extends AccessibleRole(jfxs.AccessibleRole.SPINNER)

  /**
   * Text role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#FONT} </li> </ul>
   * Actions: <ul> <li> {@link AccessibleAction#SET_TEXT} </li> </ul>
   */
  case object Text extends AccessibleRole(jfxs.AccessibleRole.TEXT)

  /**
   * Text Area role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#FONT} </li> <li>
   * {@link AccessibleAttribute#EDITABLE} </li> <li> {@link AccessibleAttribute#SELECTION_START} </li> <li> {@link
   * AccessibleAttribute#SELECTION_END} </li> <li> {@link AccessibleAttribute#CARET_OFFSET} </li> <li> {@link
   * AccessibleAttribute#OFFSET_AT_POINT} </li> <li> {@link AccessibleAttribute#LINE_START} </li> <li> {@link
   * AccessibleAttribute#LINE_END} </li> <li> {@link AccessibleAttribute#LINE_FOR_OFFSET} </li> <li> {@link
   * AccessibleAttribute#BOUNDS_FOR_RANGE} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#SET_TEXT} </li> <li>
   * {@link AccessibleAction#SET_TEXT_SELECTION} </li> </ul>
   */
  case object TextArea extends AccessibleRole(jfxs.AccessibleRole.TEXT_AREA)

  /**
   * Text Field role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#FONT} </li> <li>
   * {@link AccessibleAttribute#EDITABLE} </li> <li> {@link AccessibleAttribute#SELECTION_START} </li> <li> {@link
   * AccessibleAttribute#SELECTION_END} </li> <li> {@link AccessibleAttribute#CARET_OFFSET} </li> <li> {@link
   * AccessibleAttribute#OFFSET_AT_POINT} </li> <li> {@link AccessibleAttribute#BOUNDS_FOR_RANGE} </li> </ul> Actions:
   * <ul> <li> {@link AccessibleAction#SET_TEXT} </li> <li> {@link AccessibleAction#SET_TEXT_SELECTION} </li> </ul>
   */
  case object TextField extends AccessibleRole(jfxs.AccessibleRole.TEXT_FIELD)

  /**
   * Toggle Button role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#SELECTED} </li> </ul>
   * Actions: <ul> <li> {@link AccessibleAction#FIRE} </li> </ul>
   */
  case object ToggleButton extends AccessibleRole(jfxs.AccessibleRole.TOGGLE_BUTTON)

  /**
   * Tooltip role.
   *
   * Attributes: <ul> </ul> Actions: <ul> </ul>
   */
  case object Tooltip extends AccessibleRole(jfxs.AccessibleRole.TOOLTIP)

  /**
   * Scroll Bar role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#VALUE} </li> <li> {@link AccessibleAttribute#MAX_VALUE} </li> <li>
   * {@link AccessibleAttribute#MIN_VALUE} </li> <li> {@link AccessibleAttribute#ORIENTATION} </li> </ul> Actions: <ul>
   * <li> {@link AccessibleAction#INCREMENT} </li> <li> {@link AccessibleAction#DECREMENT} </li> <li> {@link
   * AccessibleAction#BLOCK_INCREMENT} </li> <li> {@link AccessibleAction#BLOCK_DECREMENT} </li> <li> {@link
   * AccessibleAction#SET_VALUE} </li> </ul>
   */
  case object ScrollBar extends AccessibleRole(jfxs.AccessibleRole.SCROLL_BAR)

  /**
   * Scroll Pane role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#CONTENTS} </li> <li> {@link
   * AccessibleAttribute#HORIZONTAL_SCROLLBAR} </li> <li> {@link AccessibleAttribute#VERTICAL_SCROLLBAR} </li> </ul>
   * Actions: <ul> </ul>
   */
  case object ScrollPane extends AccessibleRole(jfxs.AccessibleRole.SCROLL_PANE)

  /**
   * Split Menu Button role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#EXPANDED} </li> </ul>
   * Actions: <ul> <li> {@link AccessibleAction#FIRE} </li> <li> {@link AccessibleAction#EXPAND} </li> <li> {@link
   * AccessibleAction#COLLAPSE} </li> </ul>
   */
  case object SplitMenuButton extends AccessibleRole(jfxs.AccessibleRole.SPLIT_MENU_BUTTON)

  /**
   * Tab Item role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#SELECTED} </li> </ul>
   * Actions: <ul> <li> {@link AccessibleAction#REQUEST_FOCUS} </li> </ul>
   */
  case object TabItem extends AccessibleRole(jfxs.AccessibleRole.TAB_ITEM)

  /**
   * Tab Pane role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#ITEM_AT_INDEX} </li> <li> {@link AccessibleAttribute#ITEM_COUNT}
   * </li> <li> {@link AccessibleAttribute#FOCUS_ITEM} </li> </ul> Actions: <ul> </ul>
   */
  case object TabPane extends AccessibleRole(jfxs.AccessibleRole.TAB_PANE)

  /**
   * Table Cell role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#ROW_INDEX} </li> <li>
   * {@link AccessibleAttribute#COLUMN_INDEX} </li> <li> {@link AccessibleAttribute#SELECTED} </li> </ul> Actions: <ul>
   * <li> {@link AccessibleAction#REQUEST_FOCUS} </li> </ul>
   */
  case object TableCell extends AccessibleRole(jfxs.AccessibleRole.TABLE_CELL)

  /**
   * Table Column role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#INDEX} </li> </ul>
   * Actions: <ul> </ul>
   */
  case object TableColumn extends AccessibleRole(jfxs.AccessibleRole.TABLE_COLUMN)

  /**
   * Table Row role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#INDEX} </li> </ul>
   * Actions: <ul> </ul>
   */
  case object TableRow extends AccessibleRole(jfxs.AccessibleRole.TABLE_ROW)

  /**
   * Table View role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#ROW_COUNT} </li> <li> {@link AccessibleAttribute#ROW_AT_INDEX}
   * </li> <li> {@link AccessibleAttribute#COLUMN_COUNT} </li> <li> {@link AccessibleAttribute#COLUMN_AT_INDEX} </li>
   * <li> {@link AccessibleAttribute#SELECTED_ITEMS} </li> <li> {@link AccessibleAttribute#CELL_AT_ROW_COLUMN} </li>
   * <li> {@link AccessibleAttribute#HEADER} </li> <li> {@link AccessibleAttribute#MULTIPLE_SELECTION} </li> <li> {@link
   * AccessibleAttribute#VERTICAL_SCROLLBAR} </li> <li> {@link AccessibleAttribute#HORIZONTAL_SCROLLBAR} </li> <li>
   * {@link AccessibleAttribute#FOCUS_ITEM} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#SHOW_ITEM} </li> <li>
   * {@link AccessibleAction#SET_SELECTED_ITEMS} </li> </ul>
   */
  case object TableView extends AccessibleRole(jfxs.AccessibleRole.TABLE_VIEW)

  /**
   * Thumb role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#VALUE} </li> </ul> Actions: <ul> </ul>
   */
  case object Thumb extends AccessibleRole(jfxs.AccessibleRole.THUMB)

  /**
   * Titled Pane role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#EXPANDED} </li> </ul>
   * Actions: <ul> <li> {@link AccessibleAction#EXPAND} </li> <li> {@link AccessibleAction#COLLAPSE} </li> </ul>
   */
  case object TitledPane extends AccessibleRole(jfxs.AccessibleRole.TITLED_PANE)

  /**
   * Tool Bar role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#OVERFLOW_BUTTON} </li> </ul> Actions: <ul> </ul>
   */
  case object ToolBar extends AccessibleRole(jfxs.AccessibleRole.TOOL_BAR)

  /**
   * Tree Item role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#INDEX} </li> <li>
   * {@link AccessibleAttribute#SELECTED} </li> <li> {@link AccessibleAttribute#EXPANDED} </li> <li> {@link
   * AccessibleAttribute#LEAF} </li> <li> {@link AccessibleAttribute#DISCLOSURE_LEVEL} </li> <li> {@link
   * AccessibleAttribute#TREE_ITEM_COUNT} </li> <li> {@link AccessibleAttribute#TREE_ITEM_AT_INDEX} </li> <li> {@link
   * AccessibleAttribute#TREE_ITEM_PARENT} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#EXPAND} </li> <li>
   * {@link AccessibleAction#COLLAPSE} </li> <li> {@link AccessibleAction#REQUEST_FOCUS} </li> </ul>
   */
  case object TreeItem extends AccessibleRole(jfxs.AccessibleRole.TREE_ITEM)

  /**
   * Tree Table Cell role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#TEXT} </li> <li> {@link AccessibleAttribute#SELECTED} </li> <li>
   * {@link AccessibleAttribute#ROW_INDEX} </li> <li> {@link AccessibleAttribute#COLUMN_INDEX} </li> </ul> Actions: <ul>
   * <li> {@link AccessibleAction#REQUEST_FOCUS} </li> </ul>
   */
  case object TreeTableCell extends AccessibleRole(jfxs.AccessibleRole.TREE_TABLE_CELL)

  /**
   * Tree Table Row role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#INDEX} </li> <li> {@link AccessibleAttribute#EXPANDED} </li> <li>
   * {@link AccessibleAttribute#LEAF} </li> <li> {@link AccessibleAttribute#DISCLOSURE_LEVEL} </li> <li> {@link
   * AccessibleAttribute#TREE_ITEM_COUNT} </li> <li> {@link AccessibleAttribute#TREE_ITEM_AT_INDEX} </li> <li> {@link
   * AccessibleAttribute#TREE_ITEM_PARENT} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#EXPAND} </li> <li>
   * {@link AccessibleAction#COLLAPSE} </li> </ul>
   */
  case object TreeTableRow extends AccessibleRole(jfxs.AccessibleRole.TREE_TABLE_ROW)

  /**
   * Tree Table View role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#ROW_COUNT} </li> <li> {@link AccessibleAttribute#ROW_AT_INDEX}
   * </li> <li> {@link AccessibleAttribute#COLUMN_COUNT} </li> <li> {@link AccessibleAttribute#COLUMN_AT_INDEX} </li>
   * <li> {@link AccessibleAttribute#SELECTED_ITEMS} </li> <li> {@link AccessibleAttribute#CELL_AT_ROW_COLUMN} </li>
   * <li> {@link AccessibleAttribute#HEADER} </li> <li> {@link AccessibleAttribute#MULTIPLE_SELECTION} </li> <li> {@link
   * AccessibleAttribute#VERTICAL_SCROLLBAR} </li> <li> {@link AccessibleAttribute#HORIZONTAL_SCROLLBAR} </li> <li>
   * {@link AccessibleAttribute#FOCUS_ITEM} </li> </ul> Actions: <ul> <li> {@link AccessibleAction#SHOW_ITEM} </li> <li>
   * {@link AccessibleAction#SET_SELECTED_ITEMS} </li> </ul>
   */
  case object TreeTableView extends AccessibleRole(jfxs.AccessibleRole.TREE_TABLE_VIEW)

  /**
   * Tree View role.
   *
   * Attributes: <ul> <li> {@link AccessibleAttribute#ROW_COUNT} </li> <li> {@link AccessibleAttribute#ROW_AT_INDEX}
   * </li> <li> {@link AccessibleAttribute#SELECTED_ITEMS} </li> <li> {@link AccessibleAttribute#MULTIPLE_SELECTION}
   * </li> <li> {@link AccessibleAttribute#VERTICAL_SCROLLBAR} </li> <li> {@link
   * AccessibleAttribute#HORIZONTAL_SCROLLBAR} </li> <li> {@link AccessibleAttribute#FOCUS_ITEM} </li> </ul> Actions:
   * <ul> <li> {@link AccessibleAction#SHOW_ITEM} </li> <li> {@link AccessibleAction#SET_SELECTED_ITEMS} </li> </ul>
   */
  case object TreeView extends AccessibleRole(jfxs.AccessibleRole.TREE_VIEW)

  protected override def unsortedValues: Array[AccessibleRole] = Array(
    Button,
    CheckBox,
    CheckMenuItem,
    ComboBox,
    ContextMenu,
    DatePicker,
    DecrementButton,
    Hyperlink,
    IncrementButton,
    ImageView,
    ListView,
    ListItem,
    Menu,
    MenuBar,
    MenuButton,
    MenuItem,
    Node,
    PageItem,
    Pagination,
    Parent,
    PasswordField,
    ProgressIndicator,
    RadioButton,
    RadioMenuItem,
    Slider,
    Spinner,
    Text,
    TextArea,
    TextField,
    ToggleButton,
    Tooltip,
    ScrollBar,
    ScrollPane,
    SplitMenuButton,
    TabItem,
    TabPane,
    TableCell,
    TableColumn,
    TableRow,
    TableView,
    Thumb,
    TitledPane,
    ToolBar,
    TreeItem,
    TreeTableCell,
    TreeTableRow,
    TreeTableView,
    TreeView
  )
}

sealed abstract class AccessibleRole(override val delegate: jfxs.AccessibleRole)
    extends SFXEnumDelegate[jfxs.AccessibleRole]
