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
import scalafx.geometry.Bounds
import scalafx.delegate.SFXDelegate
import scalafx.beans.property._
import scalafx.delegate.{ SFXEnumDelegateCompanion, SFXEnumDelegate }
import javafx.{ scene => jfxs }
import scalafx.scene.Node

object ScrollPane {
  implicit def sfxScrollPane2jfx(v: ScrollPane) = v.delegate

  object ScrollBarPolicy
    extends SFXEnumDelegateCompanion[jfxsc.ScrollPane.ScrollBarPolicy, ScrollBarPolicy] {

    /** Indicates that a scroll bar should always be shown. */
    val ALWAYS = new ScrollBarPolicy(jfxsc.ScrollPane.ScrollBarPolicy.ALWAYS)

    /** Indicates that a scroll bar should be shown when required. */
    val AS_NEEDED = new ScrollBarPolicy(jfxsc.ScrollPane.ScrollBarPolicy.AS_NEEDED)

    /** Indicates that a scroll bar should never be shown */
    val NEVER = new ScrollBarPolicy(jfxsc.ScrollPane.ScrollBarPolicy.NEVER)

    protected override def unsortedValues: Array[ScrollBarPolicy] = Array(ALWAYS, AS_NEEDED, NEVER)

  }

  /** Wrapper for [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/ScrollPane.ScrollBarPolicy.html]] */
  sealed case class ScrollBarPolicy(override val delegate: jfxsc.ScrollPane.ScrollBarPolicy)
    extends SFXEnumDelegate[jfxsc.ScrollPane.ScrollBarPolicy]

}

class ScrollPane(override val delegate: jfxsc.ScrollPane = new jfxsc.ScrollPane)
  extends Control(delegate)
  with SFXDelegate[jfxsc.ScrollPane] {

  /**
   * The node used as the content of this ScrollPane.
   */
  def content: ObjectProperty[jfxs.Node] = delegate.contentProperty

  @deprecated("Use a ScalaFX Node instead a JavaFX Node", "1.0")
  def content_=(v: jfxs.Node) {
    content() = v
  }

  def content_=(v: Node) {
    content() = v
  }

  /**
   * If true and if the contained node is a Resizable, then the node will be kept resized to match the height of the 
   * ScrollPane's viewport.
   */
  def fitToHeight: BooleanProperty = delegate.fitToHeightProperty
  def fitToHeight_=(v: Boolean) {
    fitToHeight() = v
  }

  /**
   * If true and if the contained node is a Resizable, then the node will be kept resized to match the width of the 
   * ScrollPane's viewport.
   */
  def fitToWidth: BooleanProperty = delegate.fitToWidthProperty
  def fitToWidth_=(v: Boolean) {
    fitToWidth() = v
  }

  /**
   * Specifies the policy for showing the horizontal scroll bar.
   */
  def hbarPolicy: ObjectProperty[jfxsc.ScrollPane.ScrollBarPolicy] = delegate.hbarPolicyProperty
  def hbarPolicy_=(v: ScrollPane.ScrollBarPolicy) {
    hbarPolicy() = v
  }

  /**
   * The maximum allowable hvalue for this ScrollPane.
   */
  def hmax: DoubleProperty = delegate.hmaxProperty
  def hmax_=(v: Double) {
    hmax() = v
  }

  /**
   * The minimum allowable hvalue for this ScrollPane.
   */
  def hmin: DoubleProperty = delegate.hminProperty
  def hmin_=(v: Double) {
    hmin() = v
  }

  /**
   * The current horizontal scroll position of the ScrollPane.
   */
  def hvalue: DoubleProperty = delegate.hvalueProperty
  def hvalue_=(v: Double) {
    hvalue() = v
  }

  /**
   * Specifies whether the user should be able to pan the viewport by using the mouse.
   */
  def pannable: BooleanProperty = delegate.pannableProperty
  def pannable_=(v: Boolean) {
    pannable() = v
  }

  /**
   * Specify the preferred height of the ScrollPane Viewport.
   */
  def prefViewportHeight: DoubleProperty = delegate.prefViewportHeightProperty
  def prefViewportHeight_=(v: Double) {
    prefViewportHeight() = v
  }

  /**
   * Specify the preferred width of the ScrollPane Viewport.
   */
  def prefViewportWidth: DoubleProperty = delegate.prefViewportWidthProperty
  def prefViewportWidth_=(v: Double) {
    prefViewportWidth() = v
  }

  /**
   * Specifies the policy for showing the vertical scroll bar.
   */
  def vbarPolicy: ObjectProperty[jfxsc.ScrollPane.ScrollBarPolicy] = delegate.vbarPolicyProperty
  def vbarPolicy_=(v: ScrollPane.ScrollBarPolicy) {
    vbarPolicy() = v
  }

  /**
   * The actual Bounds of the ScrollPane Viewport.
   */
  def viewportBounds: ObjectProperty[jfxg.Bounds] = delegate.viewportBoundsProperty
  def viewportBounds_=(v: Bounds) {
    viewportBounds() = v
  }

  /**
   * The maximum allowable vvalue for this ScrollPane.
   */
  def vmax: DoubleProperty = delegate.vmaxProperty
  def vmax_=(v: Double) {
    vmax() = v
  }

  /**
   * The minimum allowable vvalue for this ScrollPane.
   */
  def vmin: DoubleProperty = delegate.vminProperty
  def vmin_=(v: Double) {
    vmin() = v
  }

  /**
   * The current vertical scroll position of the ScrollPane.
   */
  def vvalue: DoubleProperty = delegate.vvalueProperty
  def vvalue_=(v: Double) {
    vvalue() = v
  }

}