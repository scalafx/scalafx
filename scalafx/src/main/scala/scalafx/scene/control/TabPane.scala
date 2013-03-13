/*
 * Copyright (c) 2012-2013, ScalaFX Project
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
import javafx.{ geometry => jfxg }
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate
import scalafx.delegate.{ SFXEnumDelegateCompanion, SFXEnumDelegate }
import scalafx.geometry.Side

object TabPane {

  implicit def sfxTabPane2jfx(v: TabPane) = v.delegate

  object TabClosingPolicy
    extends SFXEnumDelegateCompanion[jfxsc.TabPane.TabClosingPolicy, TabClosingPolicy] {

    /**
     * All tabs will have the option to be closed.
     */
    val ALL_TABS = new TabClosingPolicy(jfxsc.TabPane.TabClosingPolicy.ALL_TABS)

    /**
     * Only the currently selected tab will have the option to be closed, with a graphic next to the tab text being
     * shown.
     */
    val SELECTED_TAB = new TabClosingPolicy(jfxsc.TabPane.TabClosingPolicy.SELECTED_TAB)

    /**
     * Tabs can not be closed by the user.
     */
    val UNAVAILABLE = new TabClosingPolicy(jfxsc.TabPane.TabClosingPolicy.UNAVAILABLE)

    protected override def unsortedValues: Array[TabClosingPolicy] = Array(ALL_TABS, SELECTED_TAB, UNAVAILABLE)

  }

  /** Wrapper for [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TabPane.TabClosingPolicy.html]] */
  sealed case class TabClosingPolicy(override val delegate: jfxsc.TabPane.TabClosingPolicy)
    extends SFXEnumDelegate[jfxsc.TabPane.TabClosingPolicy]

  /**
   * TabPane mode will be changed to floating allowing the TabPane to be placed alongside other control.
   */
  val StyleClassFloating = jfxsc.TabPane.STYLE_CLASS_FLOATING

}

class TabPane(override val delegate: jfxsc.TabPane = new jfxsc.TabPane)
  extends Control(delegate)
  with SFXDelegate[jfxsc.TabPane] {

  /**
   * The rotatedGraphic state of the tabs in the TabPane.
   */
  def rotateGraphic: BooleanProperty = delegate.rotateGraphicProperty
  def rotateGraphic_=(v: Boolean) {
    rotateGraphic() = v
  }

  /**
   * The selection model used for selecting tabs.
   */
  def selectionModel: ObjectProperty[jfxsc.SingleSelectionModel[jfxsc.Tab]] = delegate.selectionModelProperty
  def selectionModel_=(v: SingleSelectionModel[Tab]) {
    selectionModel() = v.asInstanceOf[jfxsc.SingleSelectionModel[jfxsc.Tab]]
  }

  /**
   * The position of the tabs in the TabPane.
   */
  def side: ObjectProperty[jfxg.Side] = delegate.sideProperty
  def side_=(v: Side) {
    side() = v
  }

  /**
   * The closing policy for the tabs.
   */
  def tabClosingPolicy: ObjectProperty[jfxsc.TabPane.TabClosingPolicy] = delegate.tabClosingPolicyProperty
  def tabClosingPolicy_=(v: TabPane.TabClosingPolicy) {
    tabClosingPolicy() = v
  }

  /**
   * The maximum height of the tabs in the TabPane.
   */
  def tabMaxHeight: DoubleProperty = delegate.tabMaxHeightProperty
  def tabMaxHeight_=(v: Double) {
    tabMaxHeight() = v
  }

  /**
   * The maximum width of the tabs in the TabPane.
   */
  def tabMaxWidth: DoubleProperty = delegate.tabMaxWidthProperty
  def tabMaxWidth_=(v: Double) {
    tabMaxWidth() = v
  }

  /**
   * The minimum height of the tab.
   */
  def tabMinHeight: DoubleProperty = delegate.tabMinHeightProperty
  def tabMinHeight_=(v: Double) {
    tabMinHeight() = v
  }

  /**
   * The minimum width of the tabs in the TabPane.
   */
  def tabMinWidth: DoubleProperty = delegate.tabMinWidthProperty
  def tabMinWidth_=(v: Double) {
    tabMinWidth() = v
  }

  /**
   * The tabs to display in this TabPane.
   */
  def tabs = delegate.getTabs
  def tabs_=(tabSeq: Seq[Tab]) {
    delegate.getTabs.clear
    tabSeq.foreach(this += _)
  }

  /**
   * Append a new Tab to tabs
   */
  def +=(tab: Tab) = {
    tabs.add(tab)
    this
  }

}
