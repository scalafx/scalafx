/*
 * Copyright (c) 2012, ScalaFX Project
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

import javafx.scene.{ control => jfxsc }
import scalafx.scene.control.cell.CellIncludes

object ControlIncludes extends ControlIncludes

trait ControlIncludes
  extends CellIncludes {
  implicit def jfxAccordion2sfx(a: jfxsc.Accordion) = new Accordion(a)
  implicit def jfxToggleGroup2sfx(tg: jfxsc.ToggleGroup) = new ToggleGroup(tg)
  implicit def jfxToggleButton2sfx(tb: jfxsc.ToggleButton) = new ToggleButton(tb)
  implicit def jfxRadioButton2sfx(rb: jfxsc.RadioButton) = new RadioButton(rb)
  implicit def jfxButtonBase2sfx(b: jfxsc.ButtonBase) = new ButtonBase(b)
  implicit def jfxButton2sfx(b: jfxsc.Button) = new Button(b)
  implicit def jfxCell2sfx[T](c: jfxsc.Cell[T]) = new Cell[T](c)
  implicit def jfxChoiceBox2sfx[J <: AnyRef](cb: jfxsc.ChoiceBox[J]) = new ChoiceBox[J](cb)
  implicit def jfxCheckBox2sfx(c: jfxsc.CheckBox) = new CheckBox(c)
  implicit def jfxContextMenu2sfx(c: jfxsc.ContextMenu) = new ContextMenu(c)
  implicit def jfxControl2sfx(c: jfxsc.Control) = new Control(c) {}
  implicit def jfxColorPicker2sfx(cp: jfxsc.ColorPicker) = new ColorPicker(cp)
  implicit def jfxComboBoxBase2sfx[T](v: jfxsc.ComboBoxBase[T]) = new ComboBoxBase[T](v) {}
  implicit def jfxComboBox2sfx[T](v: jfxsc.ComboBox[T]) = new ComboBox[T](v)
  implicit def jfxFocusModel2sfx[T](v: jfxsc.FocusModel[T]) = new FocusModel[T](v) {}
  implicit def jfxHyperlink2sfx(h: jfxsc.Hyperlink) = new Hyperlink(h)
  implicit def jfxIndexedCell2sfx[T](c: jfxsc.IndexedCell[T]) = new IndexedCell[T](c)
  implicit def jfxIndexRange2sfx(r: jfxsc.IndexRange) = new IndexRange(r)
  implicit def jfxLabel2sfx(l: jfxsc.Label) = new Label(l)
  implicit def jfxLabeled2sfx(l: jfxsc.Labeled) = new Labeled(l) {}
  implicit def jfxListCell[T](l: jfxsc.ListCell[T]) = new ListCell(l)
  implicit def jfxListView2sfx[T](l: jfxsc.ListView[T]) = new ListView(l)
  implicit def jfxListViewEditEvent2sfx[T](l: jfxsc.ListView.EditEvent[T]) = new ListView.EditEvent(l)
  implicit def jfxMenu2sfx(h: jfxsc.Menu) = new Menu(h)
  implicit def jfxMenuBar2sfx(h: jfxsc.MenuBar) = new MenuBar(h)
  implicit def jfxMenuItem2sfx(m: jfxsc.MenuItem) = new MenuItem(m)
  implicit def jfxMultipleSelectionModel2sfx[T](v: jfxsc.MultipleSelectionModel[T]) = new MultipleSelectionModel[T](v) {}
  implicit def jfxPagination2sfx(p: jfxsc.Pagination) = new Pagination(p)
  implicit def jfxScrollPane2sfx(s: jfxsc.ScrollPane) = new ScrollPane(s)
  implicit def jfxScrollBar2sfx(s: jfxsc.ScrollBar) = new ScrollBar(s)
  implicit def jfxSlider2sfx(s: jfxsc.Slider) = new Slider(s)

  implicit def jfxTableCell2sfx[S, T](tc: jfxsc.TableCell[S, T]) = new TableCell[S, T](tc)
  implicit def jfxTableColumn2sfx[S, T](tc: jfxsc.TableColumn[S, T]) = new TableColumn[S, T](tc)
  implicit def jfxCellDataFeatures2sfx[S, T](cdf: jfxsc.TableColumn.CellDataFeatures[S, T]) = new TableColumn.CellDataFeatures[S, T](cdf)
  implicit def jfxCellEditEvent2sfx[S, T](cee: jfxsc.TableColumn.CellEditEvent[S, T]) = new TableColumn.CellEditEvent[S, T](cee)
  implicit def jfxTablePosition2sfx[S, T](tp: jfxsc.TablePosition[S, T]) = new TablePosition[S, T](tp)
  implicit def jfxTableRow2sfx[T](tr: jfxsc.TableRow[T]) = new TableRow[T](tr)
  implicit def jfxTableView2sfx[S](tv: jfxsc.TableView[S]) = new TableView[S](tv)
  implicit def jfxResizeFeatures2sfx[S](rf: jfxsc.TableView.ResizeFeatures[S]) = new TableView.ResizeFeatures[S](rf)
  implicit def jfxTableViewSelectionModel2sfx[S](tvsm: jfxsc.TableView.TableViewSelectionModel[S]) = new TableView.TableViewSelectionModel[S](tvsm) {}
  implicit def jfxTableViewFocusModel2sfx[S](tvfm: jfxsc.TableView.TableViewFocusModel[S]) = new TableView.TableViewFocusModel[S](tvfm)

  implicit def jfxTitledPane2sfx(t: jfxsc.TitledPane) = new TitledPane(t)
  implicit def jfxToggle2sfx(t: jfxsc.Toggle) = new Toggle {
    override val delegate = t
    def userData: AnyRef = delegate.getUserData()
    def userData_=(v: AnyRef) {
      delegate.setUserData(v)
    }
  }
  implicit def jfxSeparator2sfx(s: jfxsc.Separator) = new Separator(s)
  /**
   * Converts a JavaFX's Skin to a ScalaFX's [[Skinnable]]
   */
  implicit def jfxSkin2sfxSkin[C <: jfxsc.Skinnable](s: jfxsc.Skin[C]) = new Skin[C] {
    override val delegate = s
  }
  /**
   * Converts a JavaFX's Skinnable to a ScalaFX's [[Skinnable]]
   */
  implicit def jfxSkinnable2sfxSkinnable(s: jfxsc.Skinnable) = new Skinnable {
    override val delegate = s
  }
  implicit def jfxProgressIndicator2sfx(p: jfxsc.ProgressIndicator) = new ProgressIndicator(p)
  implicit def jfxProgressBar2sfx(p: jfxsc.ProgressBar) = new ProgressBar(p)
  implicit def jfxPasswordField2sfx(v: jfxsc.PasswordField) = new PasswordField(v)
  implicit def jfxPopupControl2sfx(v: jfxsc.PopupControl) = new PopupControl(v)
  implicit def jfxRadioMenuItem2sfx(m: jfxsc.RadioMenuItem) = new RadioMenuItem(m)
  implicit def jfxSelectionModel2sfx[T](v: jfxsc.SelectionModel[T]) = new SelectionModel[T](v) {}
  implicit def jfxSingleSelectionModel2sfx[T](v: jfxsc.SingleSelectionModel[T]) = new SingleSelectionModel[T](v) {}
  implicit def jfxSplitPane2sfx(s: jfxsc.SplitPane) = new SplitPane(s)
  implicit def jfxSplitPaneDivider2sfx(d: jfxsc.SplitPane.Divider) = new SplitPane.Divider(d)
  implicit def jfxTab2sfx(v: jfxsc.Tab) = new Tab(v)
  implicit def jfxTabPane2sfx(v: jfxsc.TabPane) = new TabPane(v)
  implicit def jfxTextField2sfx(v: jfxsc.TextField) = new TextField(v)
  implicit def jfxTextArea2sfx(t: jfxsc.TextArea) = new TextArea(t)
  implicit def jfxTextInputControl2sfx(t: jfxsc.TextInputControl) = new TextInputControl(t) {}
  implicit def jfxTooltip2sfx(t: jfxsc.Tooltip) = new Tooltip(t) {}
  implicit def jfxToolBar2sfx(t: jfxsc.ToolBar) = new ToolBar(t) {}
  implicit def jfxTreeCell2sfx[T](t: jfxsc.TreeCell[T]) = new TreeCell[T](t)
  implicit def jfxTreeItem2sfx[T](t: jfxsc.TreeItem[T]) = new TreeItem[T](t)
  implicit def jfxTreeModificationEvent2sfx[T](tmi: jfxsc.TreeItem.TreeModificationEvent[T]) = new TreeItem.TreeModificationEvent[T](tmi)
  implicit def jfxTreeView2sfx[T](t: jfxsc.TreeView[T]) = new TreeView[T](t)
  implicit def jfxTreeViewEditEvent2sfx[T](t: jfxsc.TreeView.EditEvent[T]) = new TreeView.EditEvent[T](t)
}
