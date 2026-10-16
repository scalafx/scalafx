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

package scalafx.scene.control

import javafx.scene.control as jfxsc
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.ScrollPane.ScrollBarPolicy
import scalafx.scene.control.SplitPane.Divider
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.control.TableColumn.{CellDataFeatures, CellEditEvent, SortType}
import scalafx.scene.control.TableView.{ResizeFeatures, TableViewFocusModel, TableViewSelectionModel}
import scalafx.scene.control.TreeItem.TreeModificationEvent
import scalafx.scene.control.TreeView.EditEvent
import scalafx.scene.control.cell.CellIncludes

import scala.language.implicitConversions

object ControlIncludes extends ControlIncludes

/**
 * Contains implicit methods to convert from
 * [[javafx.scene.control]]
 * classes/traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START  Converts a $JFX
 * @define END instance to its $SFX counterpart.
 * @define TTYPE The type of the
 * @define ACCD Accordion
 * @define TGGR ToggleGroup
 * @define TGBT ToggleButton
 * @define RDBT RadioButton
 * @define BTBS ButtonBase
 * @define BUTN Button
 * @define CELL Cell
 * @define CHBX ChoiceBox
 * @define CEBX CheckBox
 * @define CUMIT CustomMenuItem
 * @define CMNIT CheckMenuItem
 * @define SPMIT SeparatorMenuItem
 * @define CTDP ContentDisplay
 * @define CTMN ContextMenu
 * @define CTRL Control
 * @define CLPK ColorPicker
 * @define CBBS ComboBoxBase
 * @define CBBX ComboBox
 * @define DTCL DateCell
 * @define DTPR DatePicker
 * @define FCMD FocusModel
 * @define HYLK Hyperlink
 * @define IDCL IndexedCell
 * @define IDRG IndexRange
 * @define LBEL Label
 * @define LBLD Labeled
 * @define LSCL ListCell
 * @define LSVW ListView
 * @define LVEE ListView.EditEvent
 * @define MENU Menu
 * @define MNBR MenuBar
 * @define MNBT MenuButton
 * @define MNIT MenuItem
 * @define MSMD MultipleSelectionModel
 * @define ORST OverrunStyle
 * @define PGNT Pagination
 * @define RFBS ResizeFeaturesBase
 * @define SCPN ScrollPane
 * @define SCSB ScrollPane.ScrollBarPolicy
 * @define SCBR ScrollBar
 * @define SCTE ScrollToEvent
 * @define SLMD SelectionMode
 * @define SLDR Slider
 * @define SPMB SplitMenuButton
 * @define TBCL TableCell
 * @define TBCM TableColumn
 * @define TBST TableColumn.SortType
 * @define TCCD TableColumn.CellDataFeatures
 * @define TCCE TableColumn.CellEditEvent
 * @define TBCB TableColumnBase
 * @define TBPS TablePosition
 * @define TBPB TablePositionBase
 * @define TBSM TableSelectionModel
 * @define TBRW TableRow
 * @define TBVW TableView
 * @define TVRF TableView.ResizeFeatures
 * @define TVSM TableView.TableViewSelectionModel
 * @define TVFM TableView.TableViewFocusModel
 * @define TTPN TitledPane
 * @define TGGL Toggle
 * @define SPRT Separator
 * @define SKIN Skin
 * @define SNBE SkinBase
 * @define SKNB Skinnable
 * @define PRGI ProgressIndicator
 * @define PRGB ProgressBar
 * @define PSFD PasswordField
 * @define PPCT PopupControl
 * @define RDMI RadioMenuItem
 * @define SCMD SelectionModel
 * @define SSMD SingleSelectionModel
 * @define SPPN SplitPane
 * @define SPDV SplitPane.Divider
 * @define TAB  Tab
 * @define TBPN TabPane
 * @define TBFM TableFocusModel
 * @define TPCP TabPane.TabClosingPolicy
 * @define TXFD TextField
 * @define TXAR TextArea
 * @define TXIC TextInputControl
 * @define TOTP Tooltip
 * @define TOBR ToolBar
 * @define TRCL TreeCell
 * @define TRIT TreeItem
 * @define TIME TreeItem.TreeModificationEvent
 * @define TRVW TreeView
 * @define TVEE TreeView.EditEvent
 * @define TTRW TreeTableRow
 * @define TTVW TreeTableView
 * @define TTVR TreeTableView.ResizeFeatures
 * @define TTVE TreeTableView.EditEvent
 * @define TTVS TreeTableView.TreeTableViewSelectionModel
 * @define TTVF TreeTableView.TreeTableViewFocusModel
 * @define SREV SortEvent
 * @define TTCL TreeTableCell
 * @define TRSM TreeSortMode
 * @define TRTP TreeTablePosition
 */
trait ControlIncludes extends CellIncludes {

  /**
   * $START [[javafx.scene.control.Accordion Accordion]] $END
   *
   * @param a $JFX $ACCD
   * @return $SFX $ACCD
   */
  implicit def jfxAccordion2sfx(a: jfxsc.Accordion): Accordion = if (a != null) new Accordion(a) else null

  implicit def jfxAlert2sfx(a: jfxsc.Alert): Alert = if (a != null) new Alert(a) else null

  implicit def jfxAlertType2sfx(a: jfxsc.Alert.AlertType): Alert.AlertType = if (a != null) Alert.AlertType(a) else null

  implicit def jfxDialog2sfx[R](a: jfxsc.Dialog[R]): Dialog[R] = if (a != null) new Dialog[R](a) else null

  implicit def jfxDialogEvent2sfx(a: jfxsc.DialogEvent): DialogEvent = if (a != null) new DialogEvent(a) else null

  implicit def jfxDialogPane2sfx(a: jfxsc.DialogPane): DialogPane = if (a != null) new DialogPane(a) else null

  implicit def jfxDoubleSpinnerValueFactory2sfx(ev: jfxsc.SpinnerValueFactory.DoubleSpinnerValueFactory)
    : SpinnerValueFactory.DoubleSpinnerValueFactory =
    if (ev != null) new SpinnerValueFactory.DoubleSpinnerValueFactory(ev) else null

  /**
   * $START [[javafx.scene.control.ToggleGroup ToggleGroup]] $END
   *
   * @param tg $JFX $TGGR
   * @return $SFX $TGGR
   */
  implicit def jfxToggleGroup2sfx(tg: jfxsc.ToggleGroup): ToggleGroup = if (tg != null) new ToggleGroup(tg) else null

  /**
   * $START [[javafx.scene.control.ToggleButton ToggleButton]] $END
   *
   * @param tb $JFX $TGBT
   * @return $SFX $TGBT
   */
  implicit def jfxToggleButton2sfx(tb: jfxsc.ToggleButton): ToggleButton =
    if (tb != null) new ToggleButton(tb) else null

  /**
   * $START [[javafx.scene.control.RadioButton RadioButton]] $END
   *
   * @param rb $JFX $RDBT
   * @return $SFX $RDBT
   */
  implicit def jfxRadioButton2sfx(rb: jfxsc.RadioButton): RadioButton = if (rb != null) new RadioButton(rb) else null

  /**
   * $START [[javafx.scene.control.ButtonBase ButtonBase]] $END
   *
   * @param b $JFX $BTBS
   * @return $SFX $BTBS
   */
  implicit def jfxButtonBase2sfx(b: jfxsc.ButtonBase): ButtonBase =
    if (b != null) new ButtonBase(b) {} else null

  /**
   * $START [[javafx.scene.control.Button Button]] $END
   *
   * @param b $JFX $BUTN
   * @return $SFX $BUTN
   */
  implicit def jfxButton2sfx(b: jfxsc.Button): Button = if (b != null) new Button(b) else null

  implicit def jfxButtonBar2sfx(b: jfxsc.ButtonBar): ButtonBar = if (b != null) new ButtonBar(b) else null

  implicit def jfxButtonData2sfx(b: jfxsc.ButtonBar.ButtonData): ButtonBar.ButtonData =
    if (b != null) ButtonBar.ButtonData(b) else null

  implicit def jfxButtonType2sfx(b: jfxsc.ButtonType): ButtonType = if (b != null) new ButtonType(b) else null

  /**
   * $START [[javafx.scene.control.Cell Cell]] $END
   *
   * @tparam T $TTYPE $CELL
   * @param c $JFX $CELL
   * @return $SFX $CELL
   */
  implicit def jfxCell2sfx[T](c: jfxsc.Cell[T]): Cell[T] = if (c != null) new Cell[T](c) else null

  /**
   * $START [[javafx.scene.control.ChoiceBox ChoiceBox]] $END
   *
   * @tparam J $TTYPE $CHBX
   * @param cb $JFX $CHBX
   * @return $SFX $CHBX
   */
  implicit def jfxChoiceBox2sfx[J <: AnyRef](cb: jfxsc.ChoiceBox[J]): ChoiceBox[J] =
    if (cb != null) new ChoiceBox[J](cb) else null

  /**
   * $START [[javafx.scene.control.CheckBox CheckBox]] $END
   *
   * @param c $JFX $CEBX
   * @return $SFX $CEBX
   */
  implicit def jfxCheckBox2sfx(c: jfxsc.CheckBox): CheckBox = if (c != null) new CheckBox(c) else null

  implicit def jfxChoiceDialog2sfx[T](c: jfxsc.ChoiceDialog[T]): ChoiceDialog[T] =
    if (c != null) new ChoiceDialog[T](c) else null

  /**
   * $START [[javafx.scene.control.CheckMenuItem MenuItem]] $END
   *
   * @param c $JFX $CMNIT
   * @return $SFX $CMNIT
   */
  implicit def jfxCheckMenuItem2sfx(c: jfxsc.CheckMenuItem): CheckMenuItem =
    if (c != null) new CheckMenuItem(c) else null

  /**
   * $START [[javafx.scene.control.ContentDisplay ContentDisplay]] $END
   *
   * @param e $JFX $CTDP
   * @return $SFX $CTDP
   */
  implicit def jfxContentDisplay2sfx(e: jfxsc.ContentDisplay): ContentDisplay = ContentDisplay.jfxEnum2sfx(e)

  /**
   * $START [[javafx.scene.control.ContextMenu ContextMenu]] $END
   *
   * @param c $JFX $CTMN
   * @return $SFX $CTMN
   */
  implicit def jfxContextMenu2sfx(c: jfxsc.ContextMenu): ContextMenu = if (c != null) new ContextMenu(c) else null

  /**
   * $START [[javafx.scene.control.Control Control]] $END
   *
   * @param c $JFX $CTRL
   * @return $SFX $CTRL
   */
  implicit def jfxControl2sfx(c: jfxsc.Control): Control =
    if (c != null) new Control(c) {} else null

  /**
   * $START [[javafx.scene.control.ColorPicker ColorPicker]] $END
   *
   * @param cp $JFX $CLPK
   * @return $SFX $CLPK
   */
  implicit def jfxColorPicker2sfx(cp: jfxsc.ColorPicker): ColorPicker = if (cp != null) new ColorPicker(cp) else null

  /**
   * $START [[javafx.scene.control.ComboBoxBase ComboBoxBase]] $END
   *
   * @tparam T $TTYPE $CBBS
   * @param v $JFX $CBBS
   * @return $SFX $CBBS
   */
  implicit def jfxComboBoxBase2sfx[T](v: jfxsc.ComboBoxBase[T]): ComboBoxBase[T] =
    if (v != null) new ComboBoxBase[T](v) {} else null

  /**
   * $START [[javafx.scene.control.ComboBox ComboBox]] $END
   *
   * @tparam T $TTYPE $CBBX
   * @param v $JFX $CBBX
   * @return $SFX $CBBX
   */
  implicit def jfxComboBox2sfx[T](v: jfxsc.ComboBox[T]): ComboBox[T] = if (v != null) new ComboBox[T](v) else null

  /**
   * $START [[javafx.scene.control.DateCell DateCell]] $END
   *
   * @param v $JFX $DTCL
   * @return $SFX $DTCL
   */
  implicit def jfxDateCell2sfx(v: jfxsc.DateCell): DateCell = if (v != null) new DateCell(v) else null

  /**
   * $START [[javafx.scene.control.DatePicker DatePicker]] $END
   *
   * @param v $JFX $DTPR
   * @return $SFX $DTPR
   */
  implicit def jfxDatePicker2sfx(v: jfxsc.DatePicker): DatePicker = if (v != null) new DatePicker(v) else null

  /**
   * $START [[javafx.scene.control.FocusModel FocusModel]] $END
   *
   * @tparam T $TTYPE $FCMD
   * @param v $JFX $FCMD
   * @return $SFX $FCMD
   */
  implicit def jfxFocusModel2sfx[T](v: jfxsc.FocusModel[T]): FocusModel[T] =
    if (v != null) new FocusModel[T](v) {} else null

  /**
   * $START [[javafx.scene.control.Hyperlink Hyperlink]] $END
   *
   * @param h $JFX $HYLK
   * @return $SFX $HYLK
   */
  implicit def jfxHyperlink2sfx(h: jfxsc.Hyperlink): Hyperlink = if (h != null) new Hyperlink(h) else null

  /**
   * $START [[javafx.scene.control.IndexedCell IndexedCell]] $END
   *
   * @tparam T $TTYPE $IDCL
   * @param c $JFX $IDCL
   * @return $SFX $IDCL
   */
  implicit def jfxIndexedCell2sfx[T](c: jfxsc.IndexedCell[T]): IndexedCell[T] =
    if (c != null) new IndexedCell[T](c) else null

  /**
   * $START [[javafx.scene.control.IndexRange IndexRange]] $END
   *
   * @param r $JFX $IDRG
   * @return $SFX $IDRG
   */
  implicit def jfxIndexRange2sfx(r: jfxsc.IndexRange): IndexRange = if (r != null) new IndexRange(r) else null

  implicit def jfxIntegerSpinnerValueFactory2sfx(ev: jfxsc.SpinnerValueFactory.IntegerSpinnerValueFactory)
    : SpinnerValueFactory.IntegerSpinnerValueFactory =
    if (ev != null) new SpinnerValueFactory.IntegerSpinnerValueFactory(ev) else null

  /**
   * $START [[javafx.scene.control.Label Label]] $END
   *
   * @param l $JFX $LBEL
   * @return $SFX $LBEL
   */
  implicit def jfxLabel2sfx(l: jfxsc.Label): Label = if (l != null) new Label(l) else null

  /**
   * $START [[javafx.scene.control.Labeled Labeled]] $END
   *
   * @param l $JFX $LBLD
   * @return $SFX $LBLD
   */
  implicit def jfxLabeled2sfx(l: jfxsc.Labeled): Labeled =
    if (l != null) new Labeled(l) {} else null

  /**
   * $START [[javafx.scene.control.ListCell ListCell]] $END
   *
   * @tparam T $TTYPE $LSCL
   * @param l $JFX $LSCL
   * @return $SFX $LSCL
   */
  implicit def jfxListCell[T](l: jfxsc.ListCell[T]): ListCell[T] = if (l != null) new ListCell(l) else null

  implicit def jfxListSpinnerValueFactory2sfx[T](ev: jfxsc.SpinnerValueFactory.ListSpinnerValueFactory[T])
    : SpinnerValueFactory.ListSpinnerValueFactory[T] =
    if (ev != null) new SpinnerValueFactory.ListSpinnerValueFactory(ev) else null

  /**
   * $START [[javafx.scene.control.ListView ListView]] $END
   *
   * @tparam T $TTYPE $LSVW
   * @param l $JFX $LSVW
   * @return $SFX $LSVW
   */
  implicit def jfxListView2sfx[T](l: jfxsc.ListView[T]): ListView[T] = if (l != null) new ListView(l) else null

  /**
   * $START [[javafx.scene.control.ListView.EditEvent ListView.EditEvent]] $END
   *
   * @tparam T $TTYPE $LVEE
   * @param l $JFX $LVEE
   * @return $SFX $LVEE
   */
  implicit def jfxListViewEditEvent2sfx[T](l: jfxsc.ListView.EditEvent[T]): ListView.EditEvent[T] =
    if (l != null) new ListView.EditEvent(l) else null

  /**
   * $START [[javafx.scene.control.Menu Menu]] $END
   *
   * @param h $JFX $MENU
   * @return $SFX $MENU
   */
  implicit def jfxMenu2sfx(h: jfxsc.Menu): Menu = if (h != null) new Menu(h) else null

  /**
   * $START [[javafx.scene.control.MenuBar MenuBar]] $END
   *
   * @param h $JFX $MNBR
   * @return $SFX $MNBR
   */
  implicit def jfxMenuBar2sfx(h: jfxsc.MenuBar): MenuBar = if (h != null) new MenuBar(h) else null

  /**
   * $START [[javafx.scene.control.MenuButton MenuButton]] $END
   *
   * @param h $JFX $MNBT
   * @return $SFX $MNBT
   */
  implicit def jfxMenuButton2sfx(h: jfxsc.MenuButton): MenuButton = if (h != null) new MenuButton(h) else null

  /**
   * $START [[javafx.scene.control.MenuItem MenuItem]] $END
   *
   * @param m $JFX $MNIT
   * @return $SFX $MNIT
   */
  implicit def jfxMenuItem2sfx(m: jfxsc.MenuItem): MenuItem = if (m != null) new MenuItem(m) else null

  /**
   * $START [[javafx.scene.control.CustomMenuItem CustomMenuItem]] $END
   *
   * @param c $JFX $CUMIT
   * @return $SFX $CUMIT
   */
  implicit def jfxCustomMenuItem2sfx(c: jfxsc.CustomMenuItem): CustomMenuItem =
    if (c != null) new CustomMenuItem(c) else null

  /**
   * $START [[javafx.scene.control.SeparatorMenuItem SeparatorMenuItem]] $END
   *
   * @param s $JFX $SPMIT
   * @return $SFX $SPMIT
   */
  implicit def jfxSeparatorMenuItem2sfx(s: jfxsc.SeparatorMenuItem): SeparatorMenuItem =
    if (s != null) new SeparatorMenuItem(s) else null

  /**
   * $START [[javafx.scene.control.MultipleSelectionModel MultipleSelectionModel]] $END
   *
   * @param v $JFX $MSMD
   * @return $SFX $MSMD
   */
  implicit def jfxMultipleSelectionModel2sfx[T](v: jfxsc.MultipleSelectionModel[T]): MultipleSelectionModel[T] =
    if (v != null) new MultipleSelectionModel[T](v) {} else null

  /**
   * $START [[javafx.scene.control.OverrunStyle OverrunStyle]] $END
   *
   * @param e $JFX $ORST
   * @return $SFX $ORST
   */
  implicit def jfxOverrunStyle2sfx(e: jfxsc.OverrunStyle): OverrunStyle = OverrunStyle.jfxEnum2sfx(e)

  /**
   * $START [[javafx.scene.control.Pagination Pagination]] $END
   *
   * @param p $JFX $PGNT
   * @return $SFX $PGNT
   */
  implicit def jfxPagination2sfx(p: jfxsc.Pagination): Pagination = if (p != null) new Pagination(p) else null

  /**
   * $START [[javafx.scene.control.ScrollPane ScrollPane]] $END
   *
   * @param s $JFX $SCPN
   * @return $SFX $SCPN
   */
  implicit def jfxScrollPane2sfx(s: jfxsc.ScrollPane): ScrollPane = if (s != null) new ScrollPane(s) else null

  /**
   * $START [[javafx.scene.control.ScrollToEvent ScrollToEvent]] $END
   *
   * @param ev $JFX $SCTE
   * @return $SFX $SCTE
   */
  implicit def jfxScrollToEvent2sfx[T](ev: jfxsc.ScrollToEvent[T]): ScrollToEvent[T] =
    if (ev != null) new ScrollToEvent[T](ev) else null

  /**
   * $START [[javafx.scene.control.ScrollPane.ScrollBarPolicy ScrollPane.ScrollBarPolicy]] $END
   *
   * @param s $JFX $SCSB
   * @return $SFX $SCSB
   */
  implicit def jfxScrollPaneScrollBarPolicy2sfx(s: jfxsc.ScrollPane.ScrollBarPolicy): ScrollBarPolicy =
    ScrollPane.ScrollBarPolicy.jfxEnum2sfx(s)

  /**
   * $START [[javafx.scene.control.ScrollBar ScrollBar]] $END
   *
   * @param s $JFX $SCBR
   * @return $SFX $SCBR
   */
  implicit def jfxScrollBar2sfx(s: jfxsc.ScrollBar): ScrollBar = if (s != null) new ScrollBar(s) else null

  /**
   * $START [[javafx.scene.control.SelectionMode SelectionMode]] $END
   *
   * @param e $JFX $SLMD
   * @return $SFX $SLMD
   */
  implicit def jfxSelectionMode2sfx(e: jfxsc.SelectionMode): SelectionMode = SelectionMode.jfxEnum2sfx(e)

  /**
   * $START [[javafx.scene.control.Slider Slider]] $END
   *
   * @param s $JFX $SLDR
   * @return $SFX $SLDR
   */
  implicit def jfxSlider2sfx(s: jfxsc.Slider): Slider = if (s != null) new Slider(s) else null

  implicit def jfxSpinner2sfx[T](ev: jfxsc.Spinner[T]): Spinner[T] =
    if (ev != null) new Spinner[T](ev) else null

  implicit def jfxSpinnerValueFactory2sfx[T](ev: jfxsc.SpinnerValueFactory[T]): SpinnerValueFactory[T] =
    if (ev != null) new SpinnerValueFactory(ev) {} else null

  /**
   * $START [[javafx.scene.control.SplitMenuButton SplitMenuButton]] $END
   *
   * @param h $JFX $SPMB
   * @return $SFX $SPMB
   */
  implicit def jfxSplitMenuButton2sfx(h: jfxsc.SplitMenuButton): SplitMenuButton =
    if (h != null) new SplitMenuButton(h) else null

  /**
   * $START [[javafx.scene.control.TableCell TableCell]] $END
   *
   * @tparam T $TTYPE $TBCL
   * @param tc $JFX $TBCL
   * @return $SFX $TBCL
   */
  implicit def jfxTableCell2sfx[S, T](tc: jfxsc.TableCell[S, T]): TableCell[S, T] =
    if (tc != null) new TableCell[S, T](tc) else null

  /**
   * $START [[javafx.scene.control.TableColumn TableColumn]] $END
   *
   * @tparam T $TTYPE $TBCM
   * @param tc $JFX $TBCM
   * @return $SFX $TBCM
   */
  implicit def jfxTableColumn2sfx[S, T](tc: jfxsc.TableColumn[S, T]): TableColumn[S, T] =
    if (tc != null) new TableColumn[S, T](tc) else null

  implicit def jfxTextInputDialog2sfx(v: jfxsc.TextInputDialog): TextInputDialog =
    if (v != null) new TextInputDialog(v) else null

  /**
   * $START [[javafx.scene.control.TableColumn.SortType TableColumn.SortType]] $END
   *
   * @param st $JFX $TBST
   * @return $SFX $TBST
   */
  implicit def jfxSortType2sfx(st: jfxsc.TableColumn.SortType): SortType = TableColumn.SortType.jfxEnum2sfx(st)

  /**
   * $START [[javafx.scene.control.TableColumn.CellDataFeatures TableColumn.CellDataFeatures]] $END
   *
   * @tparam T $TTYPE $TCCD
   * @param cdf $JFX $TCCD
   * @return $SFX $TCCD
   */
  implicit def jfxCellDataFeatures2sfx[S, T](cdf: jfxsc.TableColumn.CellDataFeatures[S, T]): CellDataFeatures[S, T] =
    if (cdf != null) new TableColumn.CellDataFeatures[S, T](cdf) else null

  /**
   * $START [[javafx.scene.control.TableColumn.CellEditEvent TableColumn.CellEditEvent]] $END
   *
   * @tparam T $TTYPE $TCCE
   * @param cee $JFX $TCCE
   * @return $SFX $TCCE
   */
  implicit def jfxCellEditEvent2sfx[S, T](cee: jfxsc.TableColumn.CellEditEvent[S, T]): CellEditEvent[S, T] =
    if (cee != null) new TableColumn.CellEditEvent[S, T](cee) else null

  /**
   * $START [[javafx.scene.control.TablePosition TablePosition]] $END
   *
   * @tparam T $TTYPE  $TBPS
   * @param tp $JFX $TBPS
   * @return $SFX $TBPS
   */
  implicit def jfxTablePosition2sfx[S, T](tp: jfxsc.TablePosition[S, T]): TablePosition[S, T] =
    if (tp != null) new TablePosition[S, T](tp) else null

  /**
   * $START [[javafx.scene.control.TablePositionBase TablePositionBase]] $END
   *
   * @tparam TC $TTYPE $TBPB
   * @param tpb $JFX $TBPB
   * @return $SFX $TBPB
   * @since 8.0
   */
  implicit def jfxTablePositionBase2sfx[TC <: jfxsc.TableColumnBase[_, _]](tpb: jfxsc.TablePositionBase[TC])
    : TablePositionBase[TC] =
    if (tpb != null) new TablePositionBase[TC](tpb) {} else null

  /**
   * $START [[javafx.scene.control.TableRow TableRow]] $END
   *
   * @tparam T $TTYPE $TBRW
   * @param tr $JFX $TBRW
   * @return $SFX $TBRW
   */
  implicit def jfxTableRow2sfx[T](tr: jfxsc.TableRow[T]): TableRow[T] = if (tr != null) new TableRow[T](tr) else null

  /**
   * $START [[javafx.scene.control.TableView TableView]] $END
   *
   * @tparam S $TTYPE $TBVW
   * @param tv $JFX $TBVW
   * @return $SFX $TBVW
   */
  implicit def jfxTableView2sfx[S](tv: jfxsc.TableView[S]): TableView[S] =
    if (tv != null) new TableView[S](tv) else null

  /**
   * $START [[javafx.scene.control.TableView.ResizeFeatures TableView.ResizeFeatures]] $END
   *
   * @tparam S $TTYPE $TVRF
   * @param rf $JFX $TVRF
   * @return $SFX $TVRF
   */
  implicit def jfxResizeFeatures2sfx[S](rf: jfxsc.TableView.ResizeFeatures[S]): ResizeFeatures[S] =
    if (rf != null) new TableView.ResizeFeatures[S](rf) else null

  /**
   * $START [[javafx.scene.control.TableView.TableViewSelectionModel TableView.TableViewSelectionModel]] $END
   *
   * @tparam S $TTYPE $TVSM
   * @param tvsm $JFX $TVSM
   * @return $SFX $TVSM
   */
  implicit def jfxTableViewSelectionModel2sfx[S](tvsm: jfxsc.TableView.TableViewSelectionModel[S])
    : TableViewSelectionModel[S] =
    if (tvsm != null) new TableView.TableViewSelectionModel[S](tvsm) {} else null

  /**
   * $START [[javafx.scene.control.TableSelectionModel TableSelectionModel]] $END
   *
   * @tparam T $TTYPE $TBSM
   * @param tsm $JFX $TBSM
   * @return $SFX $TBSM
   */
  implicit def jfxTableSelectionModel2sfx[T](tsm: jfxsc.TableSelectionModel[T]): TableSelectionModel[T] =
    if (tsm != null) new TableSelectionModel[T](tsm) {} else null

  /**
   * $START [[javafx.scene.control.TableColumnBase TableColumnBase]] $END
   *
   * @tparam T The type of the UI control (e.g. the type of the 'row').
   * @tparam S The type of the content in all cells in this table column.
   * @param tbcb $JFX $TBCB
   * @return $SFX $TBCB
   */
  implicit def jfxTableColumnBase2sfx[S, T](tbcb: jfxsc.TableColumnBase[S, T]): TableColumnBase[S, T] =
    if (tbcb != null)
      new TableColumnBase[S, T](tbcb) {

        import scalafx.collections.CollectionIncludes.*

        def columns: ObservableBuffer[_ <: jfxsc.TableColumnBase[S, _]] = delegate.getColumns
      }
    else
      null

  /**
   * $START [[javafx.scene.control.TableView.TableViewFocusModel TableView.TableViewFocusModel]] $END
   *
   * @tparam S $TTYPE $TVFM
   * @param tvfm $JFX $TVFM
   * @return $SFX $TVFM
   */
  implicit def jfxTableViewFocusModel2sfx[S](tvfm: jfxsc.TableView.TableViewFocusModel[S]): TableViewFocusModel[S] =
    if (tvfm != null) new TableView.TableViewFocusModel[S](tvfm) else null

  /**
   * $START [[javafx.scene.control.TableFocusModel TableFocusModel]] $END
   *
   * @tparam T  The type of the underlying data model for the UI control.
   * @tparam TC The concrete subclass of [[scalafx.scene.control.TableColumnBase]] that is used by
   *            the underlying UI control (e.g. [[scalafx.scene.control.TableColumn]] or `TreeTableColumn`).
   * @param tfm $JFX $TBFM
   * @return $SFX $TBFM
   * @since 8.0
   */
  implicit def jfxTableFocusModel2sfx[T, TC <: jfxsc.TableColumnBase[T, _]](tfm: jfxsc.TableFocusModel[T, TC])
    : TableFocusModel[T, TC] =
    if (tfm != null) new TableFocusModel[T, TC](tfm) {} else null

  implicit def jfxTextFormatter2sfx[V](t: jfxsc.TextFormatter[V]): TextFormatter[V] =
    if (t != null) new TextFormatter(t) else null

  implicit def jfxTextFormatterChange2sfx(t: jfxsc.TextFormatter.Change): TextFormatter.Change =
    if (t != null) new TextFormatter.Change(t) else null

  /**
   * $START [[javafx.scene.control.TitledPane TitledPane]] $END
   *
   * @param t $JFX $TTPN
   * @return $SFX $TTPN
   */
  implicit def jfxTitledPane2sfx(t: jfxsc.TitledPane): TitledPane = if (t != null) new TitledPane(t) else null

  /**
   * $START [[javafx.scene.control.Toggle Toggle]] $END
   *
   * @param t $JFX $TGGL
   * @return $SFX $TGGL
   */
  implicit def jfxToggle2sfx(t: jfxsc.Toggle): Toggle =
    if (t != null) new Toggle {
      override val delegate: jfxsc.Toggle = t
      def userData: AnyRef                = delegate.getUserData

      def userData_=(v: AnyRef): Unit = {
        delegate.setUserData(v)
      }
    }
    else null

  /**
   * $START [[javafx.scene.control.Separator Separator]] $END
   *
   * @param s $JFX $SPRT
   * @return $SFX $SPRT
   */
  implicit def jfxSeparator2sfx(s: jfxsc.Separator): Separator = if (s != null) new Separator(s) else null

  /**
   * $START [[javafx.scene.control.Skin Skin]] $END
   *
   * @tparam C $TTYPE $SKIN
   * @param s $JFX $SKIN
   * @return $SFX $SKIN
   */
  implicit def jfxSkin2sfxSkin[C <: jfxsc.Skinnable](s: jfxsc.Skin[C]): Skin[C] =
    if (s != null) new Skin[C] {
      override val delegate: jfxsc.Skin[C] = s
    }
    else null

  /**
   * $START [[javafx.scene.control.SkinBase SkinBase]] $END
   *
   * @param sb $JFX $SNBE
   * @return $SFX $SNBE
   */
  implicit def jfxSkinBase2sfx[C <: jfxsc.Control](sb: jfxsc.SkinBase[C]): SkinBase[C] =
    if (sb != null) new SkinBase[C](sb) {} else null

  /**
   * $START [[javafx.scene.control.Skinnable Skinnable]] $END
   *
   * @param s $JFX $SKNB
   * @return $SFX $SKNB
   */
  implicit def jfxSkinnable2sfxSkinnable(s: jfxsc.Skinnable): Skinnable =
    if (s != null) new Skinnable {
      override val delegate: jfxsc.Skinnable = s
    }
    else null

  /**
   * $START [[javafx.scene.control.ProgressIndicator ProgressIndicator]] $END
   *
   * @param p $JFX $PRGI
   * @return $SFX $PRGI
   */
  implicit def jfxProgressIndicator2sfx(p: jfxsc.ProgressIndicator): ProgressIndicator =
    if (p != null) new ProgressIndicator(p) else null

  /**
   * $START [[javafx.scene.control.ProgressBar ProgressBar]] $END
   *
   * @param p $JFX $PRGB
   * @return $SFX $PRGB
   */
  implicit def jfxProgressBar2sfx(p: jfxsc.ProgressBar): ProgressBar = if (p != null) new ProgressBar(p) else null

  /**
   * $START [[javafx.scene.control.PasswordField PasswordField]] $END
   *
   * @param v $JFX $PSFD
   * @return $SFX $PSFD
   */
  implicit def jfxPasswordField2sfx(v: jfxsc.PasswordField): PasswordField =
    if (v != null) new PasswordField(v) else null

  /**
   * $START [[javafx.scene.control.PopupControl PopupControl]] $END
   *
   * @param v $JFX $PPCT
   * @return $SFX $PPCT
   */
  implicit def jfxPopupControl2sfx(v: jfxsc.PopupControl): PopupControl = if (v != null) new PopupControl(v) else null

  /**
   * $START [[javafx.scene.control.RadioMenuItem RadioMenuItem]] $END
   *
   * @param m $JFX $RDMI
   * @return $SFX $RDMI
   */
  implicit def jfxRadioMenuItem2sfx(m: jfxsc.RadioMenuItem): RadioMenuItem =
    if (m != null) new RadioMenuItem(m) else null

  /**
   * $START [[javafx.scene.control.SelectionModel SelectionModel]] $END
   *
   * @tparam T $TTYPE $SCMD
   * @param v $JFX $SCMD
   * @return $SFX $SCMD
   */
  implicit def jfxSelectionModel2sfx[T](v: jfxsc.SelectionModel[T]): SelectionModel[T] =
    if (v != null) new SelectionModel[T](v) {} else null

  /**
   * $START [[javafx.scene.control.SingleSelectionModel SingleSelectionModel]] $END
   *
   * @tparam T $TTYPE $SSMD
   * @param v $JFX $SSMD
   * @return $SFX $SSMD
   */
  implicit def jfxSingleSelectionModel2sfx[T](v: jfxsc.SingleSelectionModel[T]): SingleSelectionModel[T] =
    if (v != null) new SingleSelectionModel[T](v) {} else null

  /**
   * $START [[javafx.scene.control.SplitPane SplitPane]] $END
   *
   * @param s $JFX $SPPN
   * @return $SFX $SPPN
   */
  implicit def jfxSplitPane2sfx(s: jfxsc.SplitPane): SplitPane = if (s != null) new SplitPane(s) else null

  /**
   * $START [[javafx.scene.control.SplitPane.Divider SplitPane.Divider]] $END
   *
   * @param d $JFX $SPDV
   * @return $SFX $SPDV
   */
  implicit def jfxSplitPaneDivider2sfx(d: jfxsc.SplitPane.Divider): Divider =
    if (d != null) new SplitPane.Divider(d) else null

  /**
   * $START [[javafx.scene.control.Tab Tab]] $END
   *
   * @param v $JFX $TAB
   * @return $SFX $TAB
   */
  implicit def jfxTab2sfx(v: jfxsc.Tab): Tab = if (v != null) new Tab(v) else null

  /**
   * $START [[javafx.scene.control.TabPane TabPane]] $END
   *
   * @param v $JFX $TBPN
   * @return $SFX $TBPN
   */
  implicit def jfxTabPane2sfx(v: jfxsc.TabPane): TabPane = if (v != null) new TabPane(v) else null

  /**
   * $START [[javafx.scene.control.TabPane.TabClosingPolicy TabPane.TabClosingPolicy]] $END
   *
   * @param v $JFX $TPCP
   * @return $SFX $TPCP
   */
  implicit def jfxTabClosingPolicy2sfx(v: jfxsc.TabPane.TabClosingPolicy): TabClosingPolicy =
    TabPane.TabClosingPolicy.jfxEnum2sfx(v)

  /**
   * $START [[javafx.scene.control.TextField TextField]] $END
   *
   * @param v $JFX $TXFD
   * @return $SFX $TXFD
   */
  implicit def jfxTextField2sfx(v: jfxsc.TextField): TextField = if (v != null) new TextField(v) else null

  /**
   * Converts a $JFX [[javafx.scene.control.TextField $TXFD]] to a
   * TextFieldProperty.
   *
   * @param p A ReadOnlyObjectProperty containing a $TXFD
   * @return a new TextFieldProperty
   */
  implicit def jfxTextFieldProperty2sfx(p: ReadOnlyObjectProperty[jfxsc.TextField]): TextFieldProperty =
    if (p != null) new TextFieldProperty(p) else null

  /**
   * $START [[javafx.scene.control.TextArea TextArea]] $END
   *
   * @param t $JFX $TXAR
   * @return $SFX $TXAR
   */
  implicit def jfxTextArea2sfx(t: jfxsc.TextArea): TextArea = if (t != null) new TextArea(t) else null

  /**
   * $START [[javafx.scene.control.TextInputControl TextInputControl]] $END
   *
   * @param t $JFX $TXIC
   * @return $SFX $TXIC
   */
  implicit def jfxTextInputControl2sfx(t: jfxsc.TextInputControl): TextInputControl =
    if (t != null) new TextInputControl(t) {} else null

  /**
   * $START [[javafx.scene.control.Tooltip Tooltip]] $END
   *
   * @param t $JFX $TOTP
   * @return $SFX $TOTP
   */
  implicit def jfxTooltip2sfx(t: jfxsc.Tooltip): Tooltip =
    if (t != null) new Tooltip(t) {} else null

  /**
   * $START [[javafx.scene.control.ToolBar ToolBar]] $END
   *
   * @param t $JFX $TOBR
   * @return $SFX $TOBR
   */
  implicit def jfxToolBar2sfx(t: jfxsc.ToolBar): ToolBar =
    if (t != null) new ToolBar(t) {} else null

  /**
   * $START [[javafx.scene.control.TreeCell TreeCell]] $END
   *
   * @tparam T $TTYPE $TRCL
   * @param t $JFX $TRCL
   * @return $SFX $TRCL
   */
  implicit def jfxTreeCell2sfx[T](t: jfxsc.TreeCell[T]): TreeCell[T] = if (t != null) new TreeCell[T](t) else null

  /**
   * $START [[javafx.scene.control.TreeItem TreeItem]] $END
   *
   * @tparam T $TTYPE $TRIT
   * @param t $JFX $TRIT
   * @return $SFX $TRIT
   */
  implicit def jfxTreeItem2sfx[T](t: jfxsc.TreeItem[T]): TreeItem[T] = if (t != null) new TreeItem[T](t) else null

  /**
   * $START [[javafx.scene.control.TreeItem.TreeModificationEvent TreeItem.TreeModificationEvent]] $END
   *
   * @tparam T $TTYPE $TIME
   * @param tmi $JFX $TIME
   * @return $SFX $TIME
   */
  implicit def jfxTreeModificationEvent2sfx[T](tmi: jfxsc.TreeItem.TreeModificationEvent[T]): TreeModificationEvent[T] =
    if (tmi != null) new TreeItem.TreeModificationEvent[T](tmi) else null

  /**
   * $START [[javafx.scene.control.TreeView TreeView]] $END
   *
   * @tparam T $TTYPE $TRVW
   * @param t $JFX $TRVW
   * @return $SFX $TRVW
   */
  implicit def jfxTreeView2sfx[T](t: jfxsc.TreeView[T]): TreeView[T] = if (t != null) new TreeView[T](t) else null

  /**
   * $START [[javafx.scene.control.TreeView.EditEvent TreeView.EditEvent]] $END
   *
   * @tparam T $TTYPE $TVEE
   * @param t $JFX $TVEE
   * @return $SFX $TVEE
   */
  implicit def jfxTreeViewEditEvent2sfx[T](t: jfxsc.TreeView.EditEvent[T]): EditEvent[T] =
    if (t != null) new TreeView.EditEvent[T](t) else null

  /**
   * $START [[javafx.scene.control.TreeTableRow TreeTableRow]] $END
   *
   * @tparam T $TTYPE $TTRW
   * @param ttr $JFX $TTRW
   * @return $SFX $TTRW
   * @since 8.0
   */
  implicit def jfxTreeTableRow2sfx[T](ttr: jfxsc.TreeTableRow[T]): TreeTableRow[T] =
    if (ttr != null) new TreeTableRow[T](ttr) else null

  /**
   * $START [[javafx.scene.control.TreeTableCell TreeTableCell]] $END
   *
   * @tparam S 1st $TTYPE $TTCL
   * @tparam T 2st $TTYPE $TTCL
   * @param ttc $JFX $TTCL
   * @return $SFX $TTCL
   * @since 8.0
   */
  implicit def jfxTreeTableCell2sfx[S, T](ttc: jfxsc.TreeTableCell[S, T]): TreeTableCell[S, T] =
    if (ttc != null) new TreeTableCell[S, T](ttc) else null

  /**
   * $START [[javafx.scene.control.SortEvent SortEvent]] $END
   *
   * @tparam C $TTYPE $SREV
   * @param se $JFX $SREV
   * @return $SFX $SREV
   */
  implicit def jfxSortEvent2sfx[C](se: jfxsc.SortEvent[C]): SortEvent[C] =
    if (se != null) new SortEvent[C](se) else null

  /**
   * $START [[javafx.scene.control.TreeSortMode TreeSortMode]] $END
   *
   * @param tsm $JFX $TRSM
   * @return $SFX $TRSM
   * @since 8.0
   */
  implicit def jfxTreeSortMode2sfx(tsm: jfxsc.TreeSortMode): TreeSortMode = TreeSortMode.jfxEnum2sfx(tsm)

  /**
   * $START [[javafx.scene.control.TreeTablePosition TreeTablePosition]] $END
   *
   * @tparam S The type of the TreeItem instances contained within the TreeTableView.
   * @tparam T The type of the items contained within the TreeTableColumn.
   * @param ttp $JFX $TRTP
   * @return $SFX $TRTP
   */
  implicit def jfxTreeTablePosition2sfx[S, T](ttp: jfxsc.TreeTablePosition[S, T]): TreeTablePosition[S, T] =
    if (ttp != null) new TreeTablePosition[S, T](ttp) else null

  implicit def jfxTreeTableColumn2sfx[S, T](a: jfxsc.TreeTableColumn[S, T]): TreeTableColumn[S, T] =
    if (a != null) new TreeTableColumn[S, T](a) else null

  implicit def jfxTreeCellDataFeatures2sfx[S, T](a: jfxsc.TreeTableColumn.CellDataFeatures[S, T])
    : TreeTableColumn.CellDataFeatures[S, T] =
    if (a != null) new TreeTableColumn.CellDataFeatures[S, T](a) else null

  /**
   * $START [[javafx.scene.control.TreeTableView TreeTableView]] $END
   *
   * @tparam S The type of the TreeItem instances contained within the TreeTableView.
   * @param a $JFX $TTVW
   * @return $SFX $TTVW
   * @since 8.0
   */
  implicit def jfxTreeTableView2sfx[S](a: jfxsc.TreeTableView[S]): TreeTableView[S] =
    if (a != null) new TreeTableView[S](a) else null

  /**
   * $START [[javafx.scene.control.TreeTableView TreeTableView]] $END
   *
   * @tparam T The type of the TreeItem instances contained within the TreeTableView.
   * @param t $JFX $TTVW
   * @return $SFX $TTVW
   * @since 8.0
   */
  implicit def jfxTreeTableViewEditEvent2sfx[T](t: jfxsc.TreeTableView.EditEvent[T]): TreeTableView.EditEvent[T] =
    if (t != null) new TreeTableView.EditEvent[T](t) else null

  /**
   * $START [[javafx.scene.control.TreeTableView.EditEvent TreeTableView.EditEvent]] $END
   *
   * @tparam S The type of the TreeItem instances contained within the TreeTableView.
   * @param rf $JFX $TTVE
   * @return $SFX $TTVE
   */
  implicit def jfxTreeTableViewResizeFeatures2sfx[S](rf: jfxsc.TreeTableView.ResizeFeatures[S])
    : TreeTableView.ResizeFeatures[S] =
    if (rf != null) new TreeTableView.ResizeFeatures[S](rf) else null

  /**
   * $START [[javafx.scene.control.TreeTableView.TreeTableViewSelectionModel TreeTableView.TreeTableViewSelectionModel]] $END
   *
   * @tparam S The type of the TreeItem instances contained within the TreeTableView.
   * @param ttvsm $JFX $TTVS
   * @return $SFX $TTVS
   */
  implicit def jfxTreeTableViewSelectionModel2sfx[S](ttvsm: jfxsc.TreeTableView.TreeTableViewSelectionModel[S])
    : TreeTableView.TreeTableViewSelectionModel[S] =
    if (ttvsm != null) new TreeTableView.TreeTableViewSelectionModel[S](ttvsm) {} else null

  /**
   * $START [[javafx.scene.control.TreeTableView.TreeTableViewFocusModel TreeTableView.TreeTableViewFocusModel]] $END
   *
   * @tparam S The type of the TreeItem instances contained within the TreeTableView.
   * @param ttvfm $JFX $TTVF
   * @return $SFX $TTVF
   */
  implicit def jfxTreeTableViewFocusModel2sfx[S](ttvfm: jfxsc.TreeTableView.TreeTableViewFocusModel[S])
    : TreeTableView.TreeTableViewFocusModel[S] =
    if (ttvfm != null) new TreeTableView.TreeTableViewFocusModel[S](ttvfm) else null

}
