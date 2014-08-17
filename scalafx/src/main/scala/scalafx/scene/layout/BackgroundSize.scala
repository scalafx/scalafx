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
package scalafx.scene.layout

import scala.language.implicitConversions
import javafx.scene.{layout => jfxsl}
import scalafx.delegate.SFXDelegate

object BackgroundSize {
  implicit def sfxBackgroundSize2jfx(v: BackgroundSize) = if (v != null) v.delegate else null

  /** From the CSS Specification:
    * An "auto" value for one dimension is resolved by using the image's intrinsic ratio and
    * the size of the other dimension, or failing that, using the image's intrinsic size,
    * or failing that, treating it as 100%.
    */
  val Auto: Double = jfxsl.BackgroundSize.AUTO

  /**
   * The default BackgroundSize used by BackgroundImages when an explicit size is not defined.
   */
  val Default = new BackgroundSize(jfxsl.BackgroundSize.DEFAULT)
}

/**
 * @author Jarek Sacha 
 */
class BackgroundSize(override val delegate: jfxsl.BackgroundSize)
  extends SFXDelegate[jfxsl.BackgroundSize] {

  /** Create a new BackgroundSize. */
  def this(width: Double, height: Double, widthAsPercentage: Boolean, heightAsPercentage: Boolean,
           contain: Boolean, cover: Boolean) =
    this(new jfxsl.BackgroundSize(width, height, widthAsPercentage, heightAsPercentage,
      contain, cover))

  /** The height of the area within the Region where the associated BackgroundImage should render. */
  def width: Double = delegate.getHeight

  /** The width of the area within the Region where the associated BackgroundImage should render. */
  def height: Double = delegate.getWidth
}
