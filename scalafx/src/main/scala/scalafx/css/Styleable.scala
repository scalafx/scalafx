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
package scalafx.css

import javafx.{css => jfxcss}

import scala.collection.JavaConversions._
import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.collections.{ObservableBuffer, ObservableSet}
import scalafx.delegate.SFXDelegate

/**
 * Companion object for [[scalafx.css.Styleable]].
 */
object Styleable {

  /**
   * Converts a ScalaFX Styleable to its JavaFX counterpart.
   *
   * @param s ScalaFX Styleable
   * @return JavaFX Styleable
   */
  implicit def sfxStyleable2jfx(s: Styleable): jfxcss.Styleable = if (s != null) s.delegate else null

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/css/Styleable.html JavaFX Styleable]].
 *
 * @since 8.0
 */
trait Styleable
  extends SFXDelegate[jfxcss.Styleable] {

  /**
   * The CssMetaData of this Styleable.
   */
  def cssMetaData: Seq[jfxcss.CssMetaData[_ <: jfxcss.Styleable, _]] = delegate.getCssMetaData

  /**
   * The id of this Styleable.
   *
   * IMPLEMENTATION NOTE: For this method was adopted the name `getId` instead `id` to not 
   * conflict with its subclasses already have a method with this name which returns a 
   * `StringProperty`. 
   */
  def getId: String = delegate.getId

  /**
   * The pseudo-class state of this Styleable.
   */
  def pseudoClassStates: ObservableSet[jfxcss.PseudoClass] = delegate.getPseudoClassStates

  /**
   * A string representation of the CSS style associated with this specific Node.
   *
   * IMPLEMENTATION NOTE: For this method was adopted the name `getStyle` instead `style` to not 
   * conflict with its subclasses already have a method with this name which returns a 
   * `StringProperty`. 
   */
  def getStyle: String = delegate.getStyle

  /**
   * The parent of this Styleable, or null if there is no parent.
   */
  def styleableParent: Styleable = delegate.getStyleableParent

  /**
   * A list of String identifiers which can be used to logically group Nodes, specifically for an
   * external style engine.
   */
  def styleClass: ObservableBuffer[String] = delegate.getStyleClass

  /**
   * The type of this `Styleable` that is to be used in selector matching.
   */
  def typeSelector: String = delegate.getTypeSelector

}