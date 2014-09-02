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
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.geometry.Insets
import scalafx.scene.paint.Paint

object BackgroundFill {
  implicit def sfxBackgroundFill2jfx(v: BackgroundFill) = if (v != null) v.delegate else null
}

/**
 * The fill and associated properties that direct how to fill the background of a Region.
 */
class BackgroundFill(override val delegate: jfxsl.BackgroundFill)
  extends SFXDelegate[jfxsl.BackgroundFill] {

  /**
   * Creates a new BackgroundFill with the specified fill, radii, and insets.
   */
  def this(fill: Paint, radii: CornerRadii, insets: Insets) =
    this(new jfxsl.BackgroundFill(fill, radii, insets))

  /**
   * The Paint to use for filling the background of the Region.
   */
  def fill: Paint = delegate.getFill

  /**
   * The Insets to use for this fill.
   */
  def insets: Insets = delegate.getInsets

  /**
   * The Radii to use for representing the four radii of the BackgroundFill.
   */
  def radii: CornerRadii = delegate.getRadii
}
