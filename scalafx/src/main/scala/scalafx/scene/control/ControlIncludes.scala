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
package scalafx.scene.control

import javafx.{event => jfxe, scene, application}
import javafx.scene.{ control => jfxsc }
import scalafx.scene.control.cell.CellIncludes
import scalafx.application.ConditionalFeature
import scalafx.beans.property.ReadOnlyObjectProperty

object ControlIncludes extends ControlIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/package-summary.html `javafx.scene.control`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/control/
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
 * @define SCPN ScrollPane
 * @define SCSB ScrollPane.ScrollBarPolicy
 * @define SCBR ScrollBar
 * @define SLMD SelectionMode
 * @define SLDR Slider
 * @define SPMB SplitMenuButton
 * @define TBCL TableCell
 * @define TBCM TableColumn
 * @define TBST TableColumn.SortType
 * @define TCCD TableColumn.CellDataFeatures
 * @define TCCE TableColumn.CellEditEvent
 * @define TBPS TablePosition
 * @define TBRW TableRow
 * @define TBVW TableView
 * @define TVRF TableView.ResizeFeatures
 * @define TVSM TableView.TableViewSelectionModel
 * @define TVFM TableView.TableViewFocusModel
 * @define TTPN TitledPane
 * @define TGGL Toggle
 * @define SPRT Separator
 * @define SKIN Skin
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
 */
trait ControlIncludes
  extends CellIncludes {

  /**
   * $START$ACCD.html $ACCD$END
   *
   * @param a $JFX $ACCD
   * @return $SFX $ACCD
   */
  implicit def jfxAccordion2sfx(a: jfxsc.Accordion) = new Accordion(a)

  /**
   * $START$TGGR.html $TGGR$END
   *
   * @param tg $JFX $TGGR
   * @return $SFX $TGGR
   */
  implicit def jfxToggleGroup2sfx(tg: jfxsc.ToggleGroup) = new ToggleGroup(tg)

  /**
   * $START$TGBT.html $TGBT$END
   *
   * @param tb $JFX $TGBT
   * @return $SFX $TGBT
   */
  implicit def jfxToggleButton2sfx(tb: jfxsc.ToggleButton) = new ToggleButton(tb)

  /**
   * $START$RDBT.html $RDBT$END
   *
   * @param rb $JFX $RDBT
   * @return $SFX $RDBT
   */
  implicit def jfxRadioButton2sfx(rb: jfxsc.RadioButton) = new RadioButton(rb)

  /**
   * $START$BTBS.html $BTBS$END
   *
   * @param b $JFX $BTBS
   * @return $SFX $BTBS
   */
  implicit def jfxButtonBase2sfx(b: jfxsc.ButtonBase) = new ButtonBase(b)

  /**
   * $START$BUTN.html $BUTN$END
   *
   * @param b $JFX $BUTN
   * @return $SFX $BUTN
   */
  implicit def jfxButton2sfx(b: jfxsc.Button) = new Button(b)

  /**
   * $START$CELL.html $CELL$END
   *
   * @tparam T $TTYPE $CELL
   * @param c $JFX $CELL
   * @return $SFX $CELL
   */
  implicit def jfxCell2sfx[T](c: jfxsc.Cell[T]) = new Cell[T](c)

  /**
   * $START$CHBX.html $CHBX$END
   *
   * @tparam J $TTYPE $CHBX
   * @param cb $JFX $CHBX
   * @return $SFX $CHBX
   */
  implicit def jfxChoiceBox2sfx[J <: AnyRef](cb: jfxsc.ChoiceBox[J]) = new ChoiceBox[J](cb)

  /**
   * $START$CEBX.html $CEBX$END
   *
   * @param c $JFX $CEBX
   * @return $SFX $CEBX
   */
  implicit def jfxCheckBox2sfx(c: jfxsc.CheckBox) = new CheckBox(c)

  /**
   * $START$CMNIT.html $MNIT$END
   *
   * @param c $JFX $CMNIT
   * @return $SFX $CMNIT
   */
  implicit def jfxCheckMenuItem2sfx(c: jfxsc.CheckMenuItem) = new CheckMenuItem(c)

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
  implicit def jfxContextMenu2sfx(c: jfxsc.ContextMenu) = new ContextMenu(c)

  /**
   * $START$CTRL.html $CTRL$END
   *
   * @param c $JFX $CTRL
   * @return $SFX $CTRL
   */
  implicit def jfxControl2sfx(c: jfxsc.Control) = new Control(c) {}

  /**
   * $START$CLPK.html $CLPK$END
   *
   * @param cp $JFX $CLPK
   * @return $SFX $CLPK
   */
  implicit def jfxColorPicker2sfx(cp: jfxsc.ColorPicker) = new ColorPicker(cp)

  /**
   * $START$CBBS.html $CBBS$END
   *
   * @tparam T $TTYPE $CBBS
   * @param v $JFX $CBBS
   * @return $SFX $CBBS
   */
  implicit def jfxComboBoxBase2sfx[T](v: jfxsc.ComboBoxBase[T]) = new ComboBoxBase[T](v) {}

  /**
   * $START$CBBX.html $CBBX$END
   *
   * @tparam T $TTYPE $CBBX
   * @param v $JFX $CBBX
   * @return $SFX $CBBX
   */
  implicit def jfxComboBox2sfx[T](v: jfxsc.ComboBox[T]) = new ComboBox[T](v)

  /**
   * $START$FCMD.html $FCMD$END
   *
   * @tparam T $TTYPE $FCMD
   * @param v $JFX $FCMD
   * @return $SFX $FCMD
   */
  implicit def jfxFocusModel2sfx[T](v: jfxsc.FocusModel[T]) = new FocusModel[T](v) {}

  /**
   * $START$HYLK.html $HYLK$END
   *
   * @param h $JFX $HYLK
   * @return $SFX $HYLK
   */
  implicit def jfxHyperlink2sfx(h: jfxsc.Hyperlink) = new Hyperlink(h)

  /**
   * $START$IDCL.html $IDCL$END
   *
   * @tparam T $TTYPE $IDCL
   * @param c $JFX $IDCL
   * @return $SFX $IDCL
   */
  implicit def jfxIndexedCell2sfx[T](c: jfxsc.IndexedCell[T]) = new IndexedCell[T](c)

  /**
   * $START$IDRG.html $IDRG$END
   *
   * @param r $JFX $IDRG
   * @return $SFX $IDRG
   */
  implicit def jfxIndexRange2sfx(r: jfxsc.IndexRange) = new IndexRange(r)

  /**
   * $START$LBEL.html $LBEL$END
   *
   * @param l $JFX $LBEL
   * @return $SFX $LBEL
   */
  implicit def jfxLabel2sfx(l: jfxsc.Label) = new Label(l)

  /**
   * $START$LBLD.html $LBLD$END
   *
   * @param l $JFX $LBLD
   * @return $SFX $LBLD
   */
  implicit def jfxLabeled2sfx(l: jfxsc.Labeled) = new Labeled(l) {}

  /**
   * $START$LSCL.html $LSCL$END
   *
   * @tparam T $TTYPE $LSCL
   * @param l $JFX $LSCL
   * @return $SFX $LSCL
   */
  implicit def jfxListCell[T](l: jfxsc.ListCell[T]) = new ListCell(l)

  /**
   * $START$LSVW.html $LSVW$END
   *
   * @tparam T $TTYPE $LSVW
   * @param l $JFX $LSVW
   * @return $SFX $LSVW
   */
  implicit def jfxListView2sfx[T](l: jfxsc.ListView[T]) = new ListView(l)

  /**
   * $START$LVEE.html $LVEE$END
   *
   * @tparam T $TTYPE $LVEE
   * @param l $JFX $LVEE
   * @return $SFX $LVEE
   */
  implicit def jfxListViewEditEvent2sfx[T](l: jfxsc.ListView.EditEvent[T]) = new ListView.EditEvent(l)

  /**
   * $START$MENU.html $MENU$END
   *
   * @param h $JFX $MENU
   * @return $SFX $MENU
   */
  implicit def jfxMenu2sfx(h: jfxsc.Menu) = new Menu(h)

  /**
   * $START$MNBR.html $MNBR$END
   *
   * @param h $JFX $MNBR
   * @return $SFX $MNBR
   */
  implicit def jfxMenuBar2sfx(h: jfxsc.MenuBar) = new MenuBar(h)

  /**
   * $START$MNBT.html $MNBT$END
   *
   * @param h $JFX $MNBT
   * @return $SFX $MNBT
   */
  implicit def jfxMenuButton2sfx(h: jfxsc.MenuButton) = new MenuButton(h)

  /**
   * $START$MNIT.html $MNIT$END
   *
   * @param m $JFX $MNIT
   * @return $SFX $MNIT
   */
  implicit def jfxMenuItem2sfx(m: jfxsc.MenuItem) = new MenuItem(m)

  /**
   * $START$MSMD.html $MSMD$END
   *
   * @param v $JFX $MSMD
   * @return $SFX $MSMD
   */
  implicit def jfxMultipleSelectionModel2sfx[T](v: jfxsc.MultipleSelectionModel[T]) = new MultipleSelectionModel[T](v) {}

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
  implicit def jfxPagination2sfx(p: jfxsc.Pagination) = new Pagination(p)

  /**
   * $START$SCPN.html $SCPN$END
   *
   * @param s $JFX $SCPN
   * @return $SFX $SCPN
   */
  implicit def jfxScrollPane2sfx(s: jfxsc.ScrollPane) = new ScrollPane(s)

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
  implicit def jfxScrollBar2sfx(s: jfxsc.ScrollBar) = new ScrollBar(s)

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
  implicit def jfxSlider2sfx(s: jfxsc.Slider) = new Slider(s)

  /**
   * $START$SPMB.html $SPMB$END
   *
   * @param h $JFX $SPMB
   * @return $SFX $SPMB
   */
  implicit def jfxSplitMenuButton2sfx(h: jfxsc.SplitMenuButton) = new SplitMenuButton(h)

  /**
   * $START$TBCL.html $TBCL$END
   *
   * @tparam T $TTYPE $TBCL
   * @param tc $JFX $TBCL
   * @return $SFX $TBCL
   */
  implicit def jfxTableCell2sfx[S, T](tc: jfxsc.TableCell[S, T]) = new TableCell[S, T](tc)

  /**
   * $START$TBCM.html $TBCM$END
   *
   * @tparam T $TTYPE $TBCM
   * @param tc $JFX $TBCM
   * @return $SFX $TBCM
   */
  implicit def jfxTableColumn2sfx[S, T](tc: jfxsc.TableColumn[S, T]) = new TableColumn[S, T](tc)

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
  implicit def jfxCellDataFeatures2sfx[S, T](cdf: jfxsc.TableColumn.CellDataFeatures[S, T]) = new TableColumn.CellDataFeatures[S, T](cdf)

  /**
   * $START$TCCE.html $TCCE$END
   *
   * @tparam T $TTYPE $TCCE
   * @param cee $JFX $TCCE
   * @return $SFX $TCCE
   */
  implicit def jfxCellEditEvent2sfx[S, T](cee: jfxsc.TableColumn.CellEditEvent[S, T]) = new TableColumn.CellEditEvent[S, T](cee)

  /**
   * $START$TBPS.html $TBPS$END
   *
   * @tparam T $TTYPE  $TBPS
   * @param tp $JFX $TBPS
   * @return $SFX $TBPS
   */
  implicit def jfxTablePosition2sfx[S, T](tp: jfxsc.TablePosition[S, T]) = new TablePosition[S, T](tp)

  /**
   * $START$TBRW.html $TBRW$END
   *
   * @tparam T $TTYPE $TBRW
   * @param tr $JFX $TBRW
   * @return $SFX $TBRW
   */
  implicit def jfxTableRow2sfx[T](tr: jfxsc.TableRow[T]) = new TableRow[T](tr)

  /**
   * $START$TBVW.html $TBVW$END
   *
   * @tparam S $TTYPE $TBVW
   * @param tv $JFX $TBVW
   * @return $SFX $TBVW
   */
  implicit def jfxTableView2sfx[S](tv: jfxsc.TableView[S]) = new TableView[S](tv)

  /**
   * $START$TVRF.html $TVRF$END
   *
   * @tparam S $TTYPE $TVRF
   * @param rf $JFX $TVRF
   * @return $SFX $TVRF
   */
  implicit def jfxResizeFeatures2sfx[S](rf: jfxsc.TableView.ResizeFeatures[S]) = new TableView.ResizeFeatures[S](rf)

  /**
   * $START$TVSM.html $TVSM$END
   *
   * @tparam S $TTYPE $TVSM
   * @param tvsm $JFX $TVSM
   * @return $SFX $TVSM
   */
  implicit def jfxTableViewSelectionModel2sfx[S](tvsm: jfxsc.TableView.TableViewSelectionModel[S]) = new TableView.TableViewSelectionModel[S](tvsm) {}

  /**
   * $START$TVFM.html $TVFM$END
   *
   * @tparam S $TTYPE $TVFM
   * @param tvfm $JFX $TVFM
   * @return $SFX $TVFM
   */
  implicit def jfxTableViewFocusModel2sfx[S](tvfm: jfxsc.TableView.TableViewFocusModel[S]) = new TableView.TableViewFocusModel[S](tvfm)

  /**
   * $START$TTPN.html $TTPN$END
   *
   * @param t $JFX $TTPN
   * @return $SFX $TTPN
   */
  implicit def jfxTitledPane2sfx(t: jfxsc.TitledPane) = new TitledPane(t)

  /**
   * $START$TGGL.html $TGGL$END
   *
   * @param t $JFX $TGGL
   * @return $SFX $TGGL
   */
  implicit def jfxToggle2sfx(t: jfxsc.Toggle) = new Toggle {
    override val delegate = t
    def userData: AnyRef = delegate.getUserData
    def userData_=(v: AnyRef) {
      delegate.setUserData(v)
    }
  }

  /**
   * $START$SPRT.html $SPRT$END
   *
   * @param s $JFX $SPRT
   * @return $SFX $SPRT
   */
  implicit def jfxSeparator2sfx(s: jfxsc.Separator) = new Separator(s)

  /**
   * $START$SKIN.html $SKIN$END
   *
   * @tparam C $TTYPE $SKIN
   * @param s $JFX $SKIN
   * @return $SFX $SKIN
   */
  implicit def jfxSkin2sfxSkin[C <: jfxsc.Skinnable](s: jfxsc.Skin[C]) = new Skin[C] {
    override val delegate = s
  }

  /**
   * $START$SKNB.html $SKNB$END
   *
   * @param s $JFX $SKNB
   * @return $SFX $SKNB
   */
  implicit def jfxSkinnable2sfxSkinnable(s: jfxsc.Skinnable) = new Skinnable {
    override val delegate = s
  }

  /**
   * $START$PRGI.html $PRGI$END
   *
   * @param p $JFX $PRGI
   * @return $SFX $PRGI
   */
  implicit def jfxProgressIndicator2sfx(p: jfxsc.ProgressIndicator) = new ProgressIndicator(p)

  /**
   * $START$PRGB.html $PRGB$END
   *
   * @param p $JFX $PRGB
   * @return $SFX $PRGB
   */
  implicit def jfxProgressBar2sfx(p: jfxsc.ProgressBar) = new ProgressBar(p)

  /**
   * $START$PSFD.html $PSFD$END
   *
   * @param v $JFX $PSFD
   * @return $SFX $PSFD
   */
  implicit def jfxPasswordField2sfx(v: jfxsc.PasswordField) = new PasswordField(v)

  /**
   * $START$PPCT.html $PPCT$END
   *
   * @param v $JFX $PPCT
   * @return $SFX $PPCT
   */
  implicit def jfxPopupControl2sfx(v: jfxsc.PopupControl) = new PopupControl(v)

  /**
   * $START$RDMI.html $RDMI$END
   *
   * @param m $JFX $RDMI
   * @return $SFX $RDMI
   */
  implicit def jfxRadioMenuItem2sfx(m: jfxsc.RadioMenuItem) = new RadioMenuItem(m)

  /**
   * $START$SCMD.html $SCMD$END
   *
   * @tparam T $TTYPE $SCMD
   * @param v $JFX $SCMD
   * @return $SFX $SCMD
   */
  implicit def jfxSelectionModel2sfx[T](v: jfxsc.SelectionModel[T]) = new SelectionModel[T](v) {}
  
  /**
   * $START$SSMD.html $SSMD$END
   *
   * @tparam T $TTYPE $SSMD
   * @param v $JFX $SSMD
   * @return $SFX $SSMD
   */
  implicit def jfxSingleSelectionModel2sfx[T](v: jfxsc.SingleSelectionModel[T]) = new SingleSelectionModel[T](v) {}

  /**
   * $START$SPPN.html $SPPN$END
   *
   * @param s $JFX $SPPN
   * @return $SFX $SPPN
   */
  implicit def jfxSplitPane2sfx(s: jfxsc.SplitPane) = new SplitPane(s)

  /**
   * $START$SPDV.html $SPDV$END
   *
   * @param d $JFX $SPDV
   * @return $SFX $SPDV
   */
  implicit def jfxSplitPaneDivider2sfx(d: jfxsc.SplitPane.Divider) = new SplitPane.Divider(d)

  /**
   * $START$TAB.html $TAB$END
   *
   * @param v $JFX $TAB
   * @return $SFX $TAB
   */
  implicit def jfxTab2sfx(v: jfxsc.Tab) = new Tab(v)

  /**
   * $START$TBPN.html $TBPN$END
   *
   * @param v $JFX $TBPN
   * @return $SFX $TBPN
   */
  implicit def jfxTabPane2sfx(v: jfxsc.TabPane) = new TabPane(v)

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
  implicit def jfxTextField2sfx(v: jfxsc.TextField) = new TextField(v)

  /**
   * Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/control/$TXFD.html $TXFD]]` to a 
   * TextFieldProperty.
   * 
   * @param p A ReadOnlyObjectProperty containing a $TXFD
   * @return a new TextFieldProperty
   */
  implicit def jfxTextFieldProperty2sfx(p: ReadOnlyObjectProperty[jfxsc.TextField]) = new TextFieldProperty(p)

  /**
   * $START$TXAR.html $TXAR$END
   *
   * @param t $JFX $TXAR
   * @return $SFX $TXAR
   */
  implicit def jfxTextArea2sfx(t: jfxsc.TextArea) = new TextArea(t)

  /**
   * $START$TXIC.html $TXIC$END
   *
   * @param t $JFX $TXIC
   * @return $SFX $TXIC
   */
  implicit def jfxTextInputControl2sfx(t: jfxsc.TextInputControl) = new TextInputControl(t) {}

  /**
   * $START$TOTP.html $TOTP$END
   *
   * @param t $JFX $TOTP
   * @return $SFX $TOTP
   */
  implicit def jfxTooltip2sfx(t: jfxsc.Tooltip) = new Tooltip(t) {}

  /**
   * $START$TOBR.html $TOBR$END
   *
   * @param t $JFX $TOBR
   * @return $SFX $TOBR
   */
  implicit def jfxToolBar2sfx(t: jfxsc.ToolBar) = new ToolBar(t) {}

  /**
   * $START$TRCL.html $TRCL$END
   *
   * @tparam T $TTYPE $TRCL
   * @param t $JFX $TRCL
   * @return $SFX $TRCL
   */
  implicit def jfxTreeCell2sfx[T](t: jfxsc.TreeCell[T]) = new TreeCell[T](t)

  /**
   * $START$TRIT.html $TRIT$END
   *
   * @tparam T $TTYPE $TRIT
   * @param t $JFX $TRIT
   * @return $SFX $TRIT
   */
  implicit def jfxTreeItem2sfx[T](t: jfxsc.TreeItem[T]) = new TreeItem[T](t)

  /**
   * $START$TIME.html $TIME$END
   *
   * @tparam T $TTYPE $TIME
   * @param tmi $JFX $TIME
   * @return $SFX $TIME
   */
  implicit def jfxTreeModificationEvent2sfx[T](tmi: jfxsc.TreeItem.TreeModificationEvent[T]) = new TreeItem.TreeModificationEvent[T](tmi)

  /**
   * $START$TRVW.html $TRVW$END
   *
   * @tparam T $TTYPE $TRVW
   * @param t $JFX $TRVW
   * @return $SFX $TRVW
   */
  implicit def jfxTreeView2sfx[T](t: jfxsc.TreeView[T]) = new TreeView[T](t)

  /**
   * $START$TVEE.html $TVEE$END
   *
   * @tparam T $TTYPE $TVEE
   * @param t $JFX $TVEE
   * @return $SFX $TVEE
   */
  implicit def jfxTreeViewEditEvent2sfx[T](t: jfxsc.TreeView.EditEvent[T]) = new TreeView.EditEvent[T](t)
}
