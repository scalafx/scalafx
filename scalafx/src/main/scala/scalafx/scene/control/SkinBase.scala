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
import javafx.{css => jfxcss, scene => jfxs}
import scalafx.Includes._
import scalafx.collections.CollectionIncludes.observableList2ObservableBuffer
import scalafx.collections.ObservableBuffer
import scalafx.css.PseudoClass
import scalafx.css.PseudoClass.sfxPseudoClass2jfx
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.language.implicitConversions

object SkinBase {
  implicit def sfxSkinBase2jfx[C <: jfxsc.Control](v: SkinBase[C]): jfxsc.SkinBase[C] = if (v != null) v.delegate else null

  def classCssMetaData: mutable.Buffer[jfxcss.CssMetaData[_ <: jfxcss.Styleable, _]] = jfxsc.SkinBase.getClassCssMetaData.asScala
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SkinBase.html]].
 */
abstract class SkinBase[C <: jfxsc.Control] protected(override val delegate: jfxsc.SkinBase[C])
  extends SFXDelegate[jfxsc.SkinBase[C]] {

  /**
   * Called by a `Skinnable` when the `Skin` is replaced on the `Skinnable`.
   */
  def dispose(): Unit = {
    delegate.dispose()
  }

  /**
   * Returns the children of the skin.
   */
  def children: ObservableBuffer[jfxs.Node] = delegate.getChildren

  /**
   * This method should delegate to Node.getClassCssMetaData() so that a `Node`'s `CssMetaData` can be accessed without the need for reflection.
   */
  def cssMetaData: mutable.Buffer[jfxcss.CssMetaData[_ <: jfxcss.Styleable, _]] = delegate.getCssMetaData.asScala

  /**
   * Gets the `Node` which represents this `Skin`.
   */
  def node: Node = delegate.getNode

  /**
   * Gets the `Skinnable` to which this `Skin` is assigned.
   */
  def skinnable: C = delegate.getSkinnable

  def pseudoClassStateChanged(pseudoClass: PseudoClass, active: Boolean): Unit = {
    delegate.pseudoClassStateChanged(pseudoClass, active)
  }
}