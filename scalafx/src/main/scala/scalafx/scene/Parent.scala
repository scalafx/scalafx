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
import scalafx.Includes._
import scalafx.beans.property.ReadOnlyBooleanProperty
import scalafx.collections._
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Parent {
  implicit def sfxParent2jfx(v: Parent): jfxs.Parent = if (v != null) v.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/Parent.html]].
 */
abstract class Parent(override val delegate: jfxs.Parent)
    extends Node(delegate)
    with SFXDelegate[jfxs.Parent] {

  /**
   * Indicates that this Node and its subnodes requires a layout pass on the next pulse.
   */
  def needsLayout: ReadOnlyBooleanProperty = delegate.needsLayoutProperty

  /**
   * Gets an observable list of string URLs linking to the stylesheets to use with this Parent's contents.
   */
  def stylesheets: ObservableBuffer[String] = delegate.getStylesheets

  /**
   * Sets the list of stylesheets URLs, replacing the prior content. If you want append to current content, use `add` or
   * similar.
   *
   * @param c list of stylesheets URLs to replace prior content.
   */
  def stylesheets_=(c: Iterable[String]): Unit = {
    fillCollection(this.stylesheets, c)
  }
}
