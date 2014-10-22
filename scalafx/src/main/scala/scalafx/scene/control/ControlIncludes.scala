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
package scalafx.scene.control

import scala.language.implicitConversions
import javafx.scene.{control => jfxsc}
import scalafx.scene.control.cell.CellIncludes
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.collections.ObservableBuffer

object ControlIncludes extends ControlIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/package-summary.html `javafx.scene.control`]]
 * classes/traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/
 * @define END ]]` instance to its $SFX counterpart.
 *
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
 * @define CMNIT CheckMenuItem
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
 * @define SREV SortEvent
 * @define TTCL TreeTableCell
 * @define TRSM TreeSortMode
 * @define TRTP TreeTablePosition
 */
trait ControlIncludes
  extends CellIncludes {

  /**
   * $START$ACCD.html $ACCD$END
   *
   * @param a $JFX $ACCD
   * @return $SFX $ACCD
   */
  implicit def jfxAccordion2sfx(a: jfxsc.Accordion) = if (a != null) new Accordion(a) else null

  /**
   * $START$TGGR.html $TGGR$END
   *
   * @param tg $JFX $TGGR
   * @return $SFX $TGGR
   */
  implicit def jfxToggleGroup2sfx(tg: jfxsc.ToggleGroup) = if (tg != null) new ToggleGroup(tg) else null

  /**
   * $START$TGBT.html $TGBT$END
   *
   * @param tb $JFX $TGBT
   * @return $SFX $TGBT
   */
  implicit def jfxToggleButton2sfx(tb: jfxsc.ToggleButton) = if (tb != null) new ToggleButton(tb) else null

  /**
   * $START$RDBT.html $RDBT$END
   *
   * @param rb $JFX $RDBT
   * @return $SFX $RDBT
   */
  implicit def jfxRadioButton2sfx(rb: jfxsc.RadioButton) = if (rb != null) new RadioButton(rb) else null

  /**
   * $START$BTBS.html $BTBS$END
   *
   * @param b $JFX $BTBS
   * @return $SFX $BTBS
   */
  implicit def jfxButtonBase2sfx(b: jfxsc.ButtonBase) = if (b != null) new ButtonBase(b) {} else null

  /**
   * $START$BUTN.html $BUTN$END
   *
   * @param b $JFX $BUTN
   * @return $SFX $BUTN
   */
  implicit def jfxButton2sfx(b: jfxsc.Button) = if (b != null) new Button(b) else null

  /**
   * $START$CELL.html $CELL$END
   *
   * @tparam T $TTYPE $CELL
   * @param c $JFX $CELL
   * @return $SFX $CELL
   */
  implicit def jfxCell2sfx[T](c: jfxsc.Cell[T]) = if (c != null) new Cell[T](c) else null

  /**
   * $START$CHBX.html $CHBX$END
   *
   * @tparam J $TTYPE $CHBX
   * @param cb $JFX $CHBX
   * @return $SFX $CHBX
   */
  implicit def jfxChoiceBox2sfx[J <: AnyRef](cb: jfxsc.ChoiceBox[J]) = if (cb != null) new ChoiceBox[J](cb) else null

  /**
   * $START$CEBX.html $CEBX$END
   *
   * @param c $JFX $CEBX
   * @return $SFX $CEBX
   */
  implicit def jfxCheckBox2sfx(c: jfxsc.CheckBox) = if (c != null) new CheckBox(c) else null

  /**
   * $START$CMNIT.html $MNIT$END
   *
   * @param c $JFX $CMNIT
   * @return $SFX $CMNIT
   */
  implicit def jfxCheckMenuItem2sfx(c: jfxsc.CheckMenuItem) = if (c != null) new CheckMenuItem(c) else null

  /**
   * $START$CTDP.html $CTDP$END
   *
   * @param e $JFX $CTDP
   * @return $SFX $CTDP
   */
  implicit def jfxContentDisplay2sfx(e: jfxsc.ContentDisplay) = ContentDisplay.jfxEnum2sfx(e)

  /**
   * $START$CTMN.html $CTMN$END
   *
   * @param c $JFX $CTMN
   * @return $SFX $CTMN
   */
  implicit def jfxContextMenu2sfx(c: jfxsc.ContextMenu) = if (c != null) new ContextMenu(c) else null

  /**
   * $START$CTRL.html $CTRL$END
   *
   * @param c $JFX $CTRL
   * @return $SFX $CTRL
   */
  implicit def jfxControl2sfx(c: jfxsc.Control) = if (c != null) new Control(c) {} else null

  /**
   * $START$CLPK.html $CLPK$END
   *
   * @param cp $JFX $CLPK
   * @return $SFX $CLPK
   */
  implicit def jfxColorPicker2sfx(cp: jfxsc.ColorPicker) = if (cp != null) new ColorPicker(cp) else null

  /**
   * $START$CBBS.html $CBBS$END
   *
   * @tparam T $TTYPE $CBBS
   * @param v $JFX $CBBS
   * @return $SFX $CBBS
   */
  implicit def jfxComboBoxBase2sfx[T](v: jfxsc.ComboBoxBase[T]) = if (v != null) new ComboBoxBase[T](v) {} else null

  /**
   * $START$CBBX.html $CBBX$END
   *
   * @tparam T $TTYPE $CBBX
   * @param v $JFX $CBBX
   * @return $SFX $CBBX
   */
  implicit def jfxComboBox2sfx[T](v: jfxsc.ComboBox[T]) = if (v != null) new ComboBox[T](v) else null

  /**
   * $START$DTCL.html $DTCL$END
   *
   * @param v $JFX $DTCL
   * @return $SFX $DTCL
   */
  implicit def jfxDateCell2sfx(v: jfxsc.DateCell) = if (v != null) new DateCell(v) else null

  /**
   * $START$DTPR.html $DTPR$END
   *
   * @param v $JFX $DTPR
   * @return $SFX $DTPR
   */
  implicit def jfxDatePicker2sfx(v: jfxsc.DatePicker) = if (v != null) new DatePicker(v) else null

  /**
   * $START$FCMD.html $FCMD$END
   *
   * @tparam T $TTYPE $FCMD
   * @param v $JFX $FCMD
   * @return $SFX $FCMD
   */
  implicit def jfxFocusModel2sfx[T](v: jfxsc.FocusModel[T]) = if (v != null) new FocusModel[T](v) {} else null

  /**
   * $START$HYLK.html $HYLK$END
   *
   * @param h $JFX $HYLK
   * @return $SFX $HYLK
   */
  implicit def jfxHyperlink2sfx(h: jfxsc.Hyperlink) = if (h != null) new Hyperlink(h) else null

  /**
   * $START$IDCL.html $IDCL$END
   *
   * @tparam T $TTYPE $IDCL
   * @param c $JFX $IDCL
   * @return $SFX $IDCL
   */
  implicit def jfxIndexedCell2sfx[T](c: jfxsc.IndexedCell[T]) = if (c != null) new IndexedCell[T](c) else null

  /**
   * $START$IDRG.html $IDRG$END
   *
   * @param r $JFX $IDRG
   * @return $SFX $IDRG
   */
  implicit def jfxIndexRange2sfx(r: jfxsc.IndexRange) = if (r != null) new IndexRange(r) else null

  /**
   * $START$LBEL.html $LBEL$END
   *
   * @param l $JFX $LBEL
   * @return $SFX $LBEL
   */
  implicit def jfxLabel2sfx(l: jfxsc.Label) = if (l != null) new Label(l) else null

  /**
   * $START$LBLD.html $LBLD$END
   *
   * @param l $JFX $LBLD
   * @return $SFX $LBLD
   */
  implicit def jfxLabeled2sfx(l: jfxsc.Labeled) = if (l != null) new Labeled(l) {} else null

  /**
   * $START$LSCL.html $LSCL$END
   *
   * @tparam T $TTYPE $LSCL
   * @param l $JFX $LSCL
   * @return $SFX $LSCL
   */
  implicit def jfxListCell[T](l: jfxsc.ListCell[T]) = if (l != null) new ListCell(l) else null

  /**
   * $START$LSVW.html $LSVW$END
   *
   * @tparam T $TTYPE $LSVW
   * @param l $JFX $LSVW
   * @return $SFX $LSVW
   */
  implicit def jfxListView2sfx[T](l: jfxsc.ListView[T]) = if (l != null) new ListView(l) else null

  /**
   * $START$LVEE.html $LVEE$END
   *
   * @tparam T $TTYPE $LVEE
   * @param l $JFX $LVEE
   * @return $SFX $LVEE
   */
  implicit def jfxListViewEditEvent2sfx[T](l: jfxsc.ListView.EditEvent[T]) = if (l != null) new ListView.EditEvent(l) else null

  /**
   * $START$MENU.html $MENU$END
   *
   * @param h $JFX $MENU
   * @return $SFX $MENU
   */
  implicit def jfxMenu2sfx(h: jfxsc.Menu) = if (h != null) new Menu(h) else null

  /**
   * $START$MNBR.html $MNBR$END
   *
   * @param h $JFX $MNBR
   * @return $SFX $MNBR
   */
  implicit def jfxMenuBar2sfx(h: jfxsc.MenuBar) = if (h != null) new MenuBar(h) else null

  /**
   * $START$MNBT.html $MNBT$END
   *
   * @param h $JFX $MNBT
   * @return $SFX $MNBT
   */
  implicit def jfxMenuButton2sfx(h: jfxsc.MenuButton) = if (h != null) new MenuButton(h) else null

  /**
   * $START$MNIT.html $MNIT$END
   *
   * @param m $JFX $MNIT
   * @return $SFX $MNIT
   */
  implicit def jfxMenuItem2sfx(m: jfxsc.MenuItem) = if (m != null) new MenuItem(m) else null

  /**
   * $START$MSMD.html $MSMD$END
   *
   * @param v $JFX $MSMD
   * @return $SFX $MSMD
   */
  implicit def jfxMultipleSelectionModel2sfx[T](v: jfxsc.MultipleSelectionModel[T]) = if (v != null) new MultipleSelectionModel[T](v) {} else null

  /**
   * $START$ORST.html $ORST$END
   *
   * @param e $JFX $ORST
   * @return $SFX $ORST
   */
  implicit def jfxOverrunStyle2sfx(e: jfxsc.OverrunStyle) = OverrunStyle.jfxEnum2sfx(e)

  /**
   * $START$PGNT.html $PGNT$END
   *
   * @param p $JFX $PGNT
   * @return $SFX $PGNT
   */
  implicit def jfxPagination2sfx(p: jfxsc.Pagination) = if (p != null) new Pagination(p) else null

  /**
   * $START$SCPN.html $SCPN$END
   *
   * @param s $JFX $SCPN
   * @return $SFX $SCPN
   */
  implicit def jfxScrollPane2sfx(s: jfxsc.ScrollPane) = if (s != null) new ScrollPane(s) else null

  /**
   * $START$SCTE.html $SCTE$END
   *
   * @param ev $JFX $SCTE
   * @return $SFX $SCTE
   */
  implicit def jfxScrollToEvent2sfx[T](ev: jfxsc.ScrollToEvent[T]): ScrollToEvent[T] =
    if (ev != null) new ScrollToEvent[T](ev) else null

  /**
   * $START$SCSB.html $SCSB$END
   *
   * @param s $JFX $SCSB
   * @return $SFX $SCSB
   */
  implicit def jfxScrollPaneScrollBarPolicy2sfx(s: jfxsc.ScrollPane.ScrollBarPolicy) = ScrollPane.ScrollBarPolicy.jfxEnum2sfx(s)

  /**
   * $START$SCBR.html $SCBR$END
   *
   * @param s $JFX $SCBR
   * @return $SFX $SCBR
   */
  implicit def jfxScrollBar2sfx(s: jfxsc.ScrollBar) = if (s != null) new ScrollBar(s) else null

  /**
   * $START$SLMD.html $SLMD$END
   *
   * @param e $JFX $SLMD
   * @return $SFX $SLMD
   */
  implicit def jfxSelectionMode2sfx(e: jfxsc.SelectionMode) = SelectionMode.jfxEnum2sfx(e)

  /**
   * $START$SLDR.html $SLDR$END
   *
   * @param s $JFX $SLDR
   * @return $SFX $SLDR
   */
  implicit def jfxSlider2sfx(s: jfxsc.Slider) = if (s != null) new Slider(s) else null

  /**
   * $START$SPMB.html $SPMB$END
   *
   * @param h $JFX $SPMB
   * @return $SFX $SPMB
   */
  implicit def jfxSplitMenuButton2sfx(h: jfxsc.SplitMenuButton) = if (h != null) new SplitMenuButton(h) else null

  /**
   * $START$TBCL.html $TBCL$END
   *
   * @tparam T $TTYPE $TBCL
   * @param tc $JFX $TBCL
   * @return $SFX $TBCL
   */
  implicit def jfxTableCell2sfx[S, T](tc: jfxsc.TableCell[S, T]) = if (tc != null) new TableCell[S, T](tc) else null

  /**
   * $START$TBCM.html $TBCM$END
   *
   * @tparam T $TTYPE $TBCM
   * @param tc $JFX $TBCM
   * @return $SFX $TBCM
   */
  implicit def jfxTableColumn2sfx[S, T](tc: jfxsc.TableColumn[S, T]) = if (tc != null) new TableColumn[S, T](tc) else null

  /**
   * $START$TBST.html $TBST$END
   *
   * @param st $JFX $TBST
   * @return $SFX $TBST
   */
  implicit def jfxSortType2sfx(st: jfxsc.TableColumn.SortType) = TableColumn.SortType.jfxEnum2sfx(st)

  /**
   * $START$TCCD.html $TCCD$END
   *
   * @tparam T $TTYPE $TCCD
   * @param cdf $JFX $TCCD
   * @return $SFX $TCCD
   */
  implicit def jfxCellDataFeatures2sfx[S, T](cdf: jfxsc.TableColumn.CellDataFeatures[S, T]) = if (cdf != null) new TableColumn.CellDataFeatures[S, T](cdf) else null

  /**
   * $START$TCCE.html $TCCE$END
   *
   * @tparam T $TTYPE $TCCE
   * @param cee $JFX $TCCE
   * @return $SFX $TCCE
   */
  implicit def jfxCellEditEvent2sfx[S, T](cee: jfxsc.TableColumn.CellEditEvent[S, T]) = if (cee != null) new TableColumn.CellEditEvent[S, T](cee) else null

  /**
   * $START$TBPS.html $TBPS$END
   *
   * @tparam T $TTYPE  $TBPS
   * @param tp $JFX $TBPS
   * @return $SFX $TBPS
   */
  implicit def jfxTablePosition2sfx[S, T](tp: jfxsc.TablePosition[S, T]) = if (tp != null) new TablePosition[S, T](tp) else null

  /**
   * $START$TBPB.html $TBPB$END
   *
   * @tparam TC $TTYPE $TBPB
   * @param tpb $JFX $TBPB
   * @return $SFX $TBPB
   * @since 8.0
   */
  implicit def jfxTablePositionBase2sfx[TC <: jfxsc.TableColumnBase[_, _]](tpb: jfxsc.TablePositionBase[TC]) =
    if (tpb != null) new TablePositionBase[TC](tpb) {} else null

  /**
   * $START$TBRW.html $TBRW$END
   *
   * @tparam T $TTYPE $TBRW
   * @param tr $JFX $TBRW
   * @return $SFX $TBRW
   */
  implicit def jfxTableRow2sfx[T](tr: jfxsc.TableRow[T]) = if (tr != null) new TableRow[T](tr) else null

  /**
   * $START$TBVW.html $TBVW$END
   *
   * @tparam S $TTYPE $TBVW
   * @param tv $JFX $TBVW
   * @return $SFX $TBVW
   */
  implicit def jfxTableView2sfx[S](tv: jfxsc.TableView[S]) = if (tv != null) new TableView[S](tv) else null

  /**
   * $START$RFBS.html $RFBS$END
   *
   * @tparam S $TTYPE $RFBS
   * @param rf $JFX $RFBS
   * @return $SFX $RFBS
   */
  implicit def jfxResizeFeaturesBase2sfx[S](rf: jfxsc.ResizeFeaturesBase[S]): ResizeFeaturesBase[S] =
    if (rf != null) new ResizeFeaturesBase[S](rf) else null

  /**
   * $START$TVRF.html $TVRF$END
   *
   * @tparam S $TTYPE $TVRF
   * @param rf $JFX $TVRF
   * @return $SFX $TVRF
   */
  implicit def jfxResizeFeatures2sfx[S](rf: jfxsc.TableView.ResizeFeatures[S]) = if (rf != null) new TableView.ResizeFeatures[S](rf) else null

  /**
   * $START$TVSM.html $TVSM$END
   *
   * @tparam S $TTYPE $TVSM
   * @param tvsm $JFX $TVSM
   * @return $SFX $TVSM
   */
  implicit def jfxTableViewSelectionModel2sfx[S](tvsm: jfxsc.TableView.TableViewSelectionModel[S]) = if (tvsm != null) new TableView.TableViewSelectionModel[S](tvsm) {} else null

  /**
   * $START$TBSM.html $TBSM$END
   *
   * @tparam T $TTYPE $TBSM
   * @param tsm $JFX $TBSM
   * @return $SFX $TBSM
   */
  implicit def jfxTableSelectionModel2sfx[T](tsm: jfxsc.TableSelectionModel[T]) =
    if (tsm != null) new TableSelectionModel[T](tsm) {} else null
  /*
   * $START$TBCB.html $TBCB$END
   *
   * @tparam T The type of the UI control (e.g. the type of the 'row').
   * @tparam S The type of the content in all cells in this table column.
   * @param tbcb $JFX $TBCB
   * @return $SFX $TBCB
   *
  implicit def jfxTableColumnBase2sfx[S, T](tbcb: jfxsc.TableColumnBase[S, T]): TableColumnBase[S, T] =
    new TableColumnBase[S, T](tbcb) {
      def columns: ObservableBuffer[jfxsc.TableColumnBase[S, _]] = {
        ObservableBuffer(tbcb.getColumns)
      }
    }
*/
  /**
   * $START$TVFM.html $TVFM$END
   *
   * @tparam S $TTYPE $TVFM
   * @param tvfm $JFX $TVFM
   * @return $SFX $TVFM
   */
  implicit def jfxTableViewFocusModel2sfx[S](tvfm: jfxsc.TableView.TableViewFocusModel[S]) = if (tvfm != null) new TableView.TableViewFocusModel[S](tvfm) else null

  /**
   * $START$TBFM.html $TBFM$END
   *
   * @tparam T The type of the underlying data model for the UI control.
   * @tparam TC The concrete subclass of [[scalafx.scene.control.TableColumnBase]] that is used by
   *            the underlying UI control (e.g. [[scalafx.scene.control.TableColumn]] or `TreeTableColumn`).
   * @param tfm $JFX $TBFM
   * @return $SFX $TBFM
   * @since 8.0
   */
  implicit def jfxTableFocusModel2sfx[T, TC <: jfxsc.TableColumnBase[T, _]](tfm: jfxsc.TableFocusModel[T, TC]) =
    if (tfm != null) new TableFocusModel[T, TC](tfm) {} else null

  /**
   * $START$TTPN.html $TTPN$END
   *
   * @param t $JFX $TTPN
   * @return $SFX $TTPN
   */
  implicit def jfxTitledPane2sfx(t: jfxsc.TitledPane) = if (t != null) new TitledPane(t) else null

  /**
   * $START$TGGL.html $TGGL$END
   *
   * @param t $JFX $TGGL
   * @return $SFX $TGGL
   */
  implicit def jfxToggle2sfx(t: jfxsc.Toggle): Toggle = if (t != null) new Toggle {
    override val delegate = t
    def userData: AnyRef = delegate.getUserData
    def userData_=(v: AnyRef) {
      delegate.setUserData(v)
    }
  } else null

  /**
   * $START$SPRT.html $SPRT$END
   *
   * @param s $JFX $SPRT
   * @return $SFX $SPRT
   */
  implicit def jfxSeparator2sfx(s: jfxsc.Separator) = if (s != null) new Separator(s) else null

  /**
   * $START$SKIN.html $SKIN$END
   *
   * @tparam C $TTYPE $SKIN
   * @param s $JFX $SKIN
   * @return $SFX $SKIN
   */
  implicit def jfxSkin2sfxSkin[C <: jfxsc.Skinnable](s: jfxsc.Skin[C]): Skin[C] = if (s != null) new Skin[C] {
    override val delegate = s
  } else null

  /**
   * $START$SNBE.html $SNBE$END
   *
   * @param sb $JFX $SNBE
   * @return $SFX $SNBE
   */
  implicit def jfxSkinBase2sfx[C <: jfxsc.Control](sb: jfxsc.SkinBase[C]) =
    if (sb != null) new SkinBase[C](sb) {} else null

  /**
   * $START$SKNB.html $SKNB$END
   *
   * @param s $JFX $SKNB
   * @return $SFX $SKNB
   */
  implicit def jfxSkinnable2sfxSkinnable(s: jfxsc.Skinnable): Skinnable = if (s != null) new Skinnable {
    override val delegate = s
  } else null

  /**
   * $START$PRGI.html $PRGI$END
   *
   * @param p $JFX $PRGI
   * @return $SFX $PRGI
   */
  implicit def jfxProgressIndicator2sfx(p: jfxsc.ProgressIndicator) = if (p != null) new ProgressIndicator(p) else null

  /**
   * $START$PRGB.html $PRGB$END
   *
   * @param p $JFX $PRGB
   * @return $SFX $PRGB
   */
  implicit def jfxProgressBar2sfx(p: jfxsc.ProgressBar) = if (p != null) new ProgressBar(p) else null

  /**
   * $START$PSFD.html $PSFD$END
   *
   * @param v $JFX $PSFD
   * @return $SFX $PSFD
   */
  implicit def jfxPasswordField2sfx(v: jfxsc.PasswordField) = if (v != null) new PasswordField(v) else null

  /**
   * $START$PPCT.html $PPCT$END
   *
   * @param v $JFX $PPCT
   * @return $SFX $PPCT
   */
  implicit def jfxPopupControl2sfx(v: jfxsc.PopupControl) = if (v != null) new PopupControl(v) else null

  /**
   * $START$RDMI.html $RDMI$END
   *
   * @param m $JFX $RDMI
   * @return $SFX $RDMI
   */
  implicit def jfxRadioMenuItem2sfx(m: jfxsc.RadioMenuItem) = if (m != null) new RadioMenuItem(m) else null

  /**
   * $START$SCMD.html $SCMD$END
   *
   * @tparam T $TTYPE $SCMD
   * @param v $JFX $SCMD
   * @return $SFX $SCMD
   */
  implicit def jfxSelectionModel2sfx[T](v: jfxsc.SelectionModel[T]) = if (v != null) new SelectionModel[T](v) {} else null

  /**
   * $START$SSMD.html $SSMD$END
   *
   * @tparam T $TTYPE $SSMD
   * @param v $JFX $SSMD
   * @return $SFX $SSMD
   */
  implicit def jfxSingleSelectionModel2sfx[T](v: jfxsc.SingleSelectionModel[T]) = if (v != null) new SingleSelectionModel[T](v) {} else null

  /**
   * $START$SPPN.html $SPPN$END
   *
   * @param s $JFX $SPPN
   * @return $SFX $SPPN
   */
  implicit def jfxSplitPane2sfx(s: jfxsc.SplitPane) = if (s != null) new SplitPane(s) else null

  /**
   * $START$SPDV.html $SPDV$END
   *
   * @param d $JFX $SPDV
   * @return $SFX $SPDV
   */
  implicit def jfxSplitPaneDivider2sfx(d: jfxsc.SplitPane.Divider) = if (d != null) new SplitPane.Divider(d) else null

  /**
   * $START$TAB.html $TAB$END
   *
   * @param v $JFX $TAB
   * @return $SFX $TAB
   */
  implicit def jfxTab2sfx(v: jfxsc.Tab) = if (v != null) new Tab(v) else null

  /**
   * $START$TBPN.html $TBPN$END
   *
   * @param v $JFX $TBPN
   * @return $SFX $TBPN
   */
  implicit def jfxTabPane2sfx(v: jfxsc.TabPane) = if (v != null) new TabPane(v) else null

  /**
   * $START$TPCP.html $TPCP$END
   *
   * @param v $JFX $TPCP
   * @return $SFX $TPCP
   */
  implicit def jfxTabClosingPolicy2sfx(v: jfxsc.TabPane.TabClosingPolicy) = TabPane.TabClosingPolicy.jfxEnum2sfx(v)

  /**
   * $START$TXFD.html $TXFD$END
   *
   * @param v $JFX $TXFD
   * @return $SFX $TXFD
   */
  implicit def jfxTextField2sfx(v: jfxsc.TextField) = if (v != null) new TextField(v) else null

  /**
   * Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/$TXFD.html $TXFD]]` to a
   * TextFieldProperty.
   *
   * @param p A ReadOnlyObjectProperty containing a $TXFD
   * @return a new TextFieldProperty
   */
  implicit def jfxTextFieldProperty2sfx(p: ReadOnlyObjectProperty[jfxsc.TextField]) = if (p != null) new TextFieldProperty(p) else null

  /**
   * $START$TXAR.html $TXAR$END
   *
   * @param t $JFX $TXAR
   * @return $SFX $TXAR
   */
  implicit def jfxTextArea2sfx(t: jfxsc.TextArea) = if (t != null) new TextArea(t) else null

  /**
   * $START$TXIC.html $TXIC$END
   *
   * @param t $JFX $TXIC
   * @return $SFX $TXIC
   */
  implicit def jfxTextInputControl2sfx(t: jfxsc.TextInputControl) = if (t != null) new TextInputControl(t) {} else null

  /**
   * $START$TOTP.html $TOTP$END
   *
   * @param t $JFX $TOTP
   * @return $SFX $TOTP
   */
  implicit def jfxTooltip2sfx(t: jfxsc.Tooltip) = if (t != null) new Tooltip(t) {} else null

  /**
   * $START$TOBR.html $TOBR$END
   *
   * @param t $JFX $TOBR
   * @return $SFX $TOBR
   */
  implicit def jfxToolBar2sfx(t: jfxsc.ToolBar) = if (t != null) new ToolBar(t) {} else null

  /**
   * $START$TRCL.html $TRCL$END
   *
   * @tparam T $TTYPE $TRCL
   * @param t $JFX $TRCL
   * @return $SFX $TRCL
   */
  implicit def jfxTreeCell2sfx[T](t: jfxsc.TreeCell[T]) = if (t != null) new TreeCell[T](t) else null

  /**
   * $START$TRIT.html $TRIT$END
   *
   * @tparam T $TTYPE $TRIT
   * @param t $JFX $TRIT
   * @return $SFX $TRIT
   */
  implicit def jfxTreeItem2sfx[T](t: jfxsc.TreeItem[T]) = if (t != null) new TreeItem[T](t) else null

  /**
   * $START$TIME.html $TIME$END
   *
   * @tparam T $TTYPE $TIME
   * @param tmi $JFX $TIME
   * @return $SFX $TIME
   */
  implicit def jfxTreeModificationEvent2sfx[T](tmi: jfxsc.TreeItem.TreeModificationEvent[T]) = if (tmi != null) new TreeItem.TreeModificationEvent[T](tmi) else null

  /**
   * $START$TRVW.html $TRVW$END
   *
   * @tparam T $TTYPE $TRVW
   * @param t $JFX $TRVW
   * @return $SFX $TRVW
   */
  implicit def jfxTreeView2sfx[T](t: jfxsc.TreeView[T]) = if (t != null) new TreeView[T](t) else null

  /**
   * $START$TVEE.html $TVEE$END
   *
   * @tparam T $TTYPE $TVEE
   * @param t $JFX $TVEE
   * @return $SFX $TVEE
   */
  implicit def jfxTreeViewEditEvent2sfx[T](t: jfxsc.TreeView.EditEvent[T]) = if (t != null) new TreeView.EditEvent[T](t) else null


  /**
   * $START$TTRW.html $TTRW$END
   *
   * @tparam T $TTYPE $TTRW
   * @param ttr $JFX $TTRW
   * @return $SFX $TTRW
   * @since 8.0
   */
  implicit def jfxTreeTableRow2sfx[T](ttr: jfxsc.TreeTableRow[T]): TreeTableRow[T] =
    if (ttr != null) new TreeTableRow[T](ttr) else null

  /**
   * $START$TTCL.html $TTCL$END
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
   * $START$SREV.html $SREV$END
   *
   * @tparam C $TTYPE $SREV
   * @param se $JFX $SREV
   * @return $SFX $SREV
   */
  implicit def jfxSortEvent2sfx[C](se: jfxsc.SortEvent[C]): SortEvent[C] =
    if (se != null) new SortEvent[C](se) else null

  /**
   * $START$TRSM.html $TRSM$END
   *
   * @param tsm $JFX $TRSM
   * @return $SFX $TRSM
   * @since 8.0
   */
  implicit def jfxTreeSortMode2sfx(tsm: jfxsc.TreeSortMode) = TreeSortMode.jfxEnum2sfx(tsm)

  /**
   * $START$TRTP.html $TRTP$END
   *
   * @tparam S The type of the TreeItem instances contained within the TreeTableView.
   * @tparam T The type of the items contained within the TreeTableColumn.
   * @param ttp $JFX $TRTP
   * @return $SFX $TRTP
   */
  implicit def jfxTreeTablePosition2sfx[S, T](ttp: jfxsc.TreeTablePosition[S, T]): TreeTablePosition[S, T] =
    if (ttp != null) new TreeTablePosition[S, T](ttp) else null

  implicit def jfxTreeTableColumn2sfx[S,T](a: jfxsc.TreeTableColumn[S,T]) =
    if (a != null) new TreeTableColumn[S,T](a) else null

  implicit def jfxTreeCellDataFeatures2sfx[S,T](a: jfxsc.TreeTableColumn.CellDataFeatures[S,T]) =
    if (a != null) new TreeTableColumn.CellDataFeatures[S,T](a) else null

  implicit def jfxTreeTableView2sfx[S](a: jfxsc.TreeTableView[S]) =
    if (a != null) new TreeTableView[S](a) else null

  implicit def jfxTreeTableViewEditEvent2sfx[T](t: jfxsc.TreeTableView.EditEvent[T]) =
    if (t != null) new TreeTableView.EditEvent[T](t) else null
}
