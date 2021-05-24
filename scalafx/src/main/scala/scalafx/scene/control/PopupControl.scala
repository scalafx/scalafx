/*
 * Copyright (c) 2011-2019, ScalaFX Project
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
import javafx.{css => jfxcss}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, StringProperty}
import scalafx.css.{PseudoClass, Styleable}
import scalafx.delegate.SFXDelegate
import scalafx.stage.PopupWindow

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.language.implicitConversions

/**
 * Object companion for [[scalafx.scene.control.PopupControl]].
 */
object PopupControl {

  /**
   * Converts a ScalaFX PopupControl to its JavaFX counterpart
   *
   * @param v
   *   ScalaFX PopupControl
   * @return
   *   JavaFX PopupControl
   */
  implicit def sfxPopupControl2jfx(v: PopupControl): jfxsc.PopupControl = if (v != null) v.delegate else null

  /**
   * Sentinel value which can be passed to a control's minWidth, minHeight, prefWidth, prefHeight, maxWidth, maxHeight
   * setters to reset the control's size constraint back to it's intrinsic size returned by computeMinWidth,
   * computeMinHeight, computePrefWidth, computePrefHeight, computeMaxWidth, or computeMaxHeight.
   */
  val UseComputedSize: Double = jfxsc.PopupControl.USE_COMPUTED_SIZE

  /**
   * Sentinel value which can be passed to a control's minWidth, minHeight, maxWidth or maxHeight setters to indicate
   * that the preferred dimension should be used for that max and/or min constraint.
   */
  val UsePrefSize: Double = jfxsc.PopupControl.USE_PREF_SIZE

  /**
   * The CssMetaData associated with this class, which may include the CssMetaData of its super classes.
   *
   * @since
   *   8.0
   */
  def classCssMetaData: mutable.Buffer[jfxcss.CssMetaData[_ <: jfxcss.Styleable, _]] =
    jfxsc.PopupControl.getClassCssMetaData.asScala

}

/**
 * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/PopupControl.htmlPopupControl]].
 *
 * @constructor
 *   Creates a new ScalaFX PopupControl from its JavaFX counterpart.
 * @param delegate
 *   JavaFX PopupControl to be wrapped. It defaul value is a new JavaFX PopupControl
 */
class PopupControl(override val delegate: jfxsc.PopupControl = new jfxsc.PopupControl)
    extends PopupWindow(delegate)
    with Styleable
    with Skinnable
    with SFXDelegate[jfxsc.PopupControl] {

  /**
   * The id of this Node.
   */
  def id: StringProperty = delegate.idProperty

  def id_=(v: String): Unit = {
    id() = v
  }

  /**
   * Property for overriding the control's computed maximum height.
   */
  def maxHeight: DoubleProperty = delegate.maxHeightProperty

  def maxHeight_=(v: Double): Unit = {
    maxHeight() = v
  }

  /**
   * Property for overriding the control's computed maximum width.
   */
  def maxWidth: DoubleProperty = delegate.maxWidthProperty

  def maxWidth_=(v: Double): Unit = {
    maxWidth() = v
  }

  /**
   * Property for overriding the control's computed minimum height.
   */
  def minHeight: DoubleProperty = delegate.minHeightProperty

  def minHeight_=(v: Double): Unit = {
    minHeight() = v
  }

  /**
   * Property for overriding the control's computed minimum width.
   */
  def minWidth: DoubleProperty = delegate.minWidthProperty

  def minWidth_=(v: Double): Unit = {
    minWidth() = v
  }

  /**
   * Property for overriding the control's computed preferred height.
   */
  def prefHeight: DoubleProperty = delegate.prefHeightProperty

  def prefHeight_=(v: Double): Unit = {
    prefHeight() = v
  }

  /**
   * Property for overriding the control's computed preferred width.
   */
  def prefWidth: DoubleProperty = delegate.prefWidthProperty

  def prefWidth_=(v: Double): Unit = {
    prefWidth() = v
  }

  /**
   * A string representation of the CSS style associated with this specific Node.
   */
  def style: StringProperty = delegate.styleProperty

  def style_=(v: String): Unit = {
    style() = v
  }

  /**
   * @since
   *   8.0
   */
  def pseudoClassStateChanged(pseudoClass: PseudoClass, active: Boolean): Unit = {
    delegate.pseudoClassStateChanged(pseudoClass, active)
  }

  // protected Skin<?> createDefaultSkin()

}
