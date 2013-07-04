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
package scalafx.geometry

import javafx.{ geometry => jfxg }
import scalafx.delegate.SFXDelegate

object Insets {
  implicit def sfxInsets2jfx(i: Insets) = i.delegate

  /**
   * Empty insets. An Insets instance with all offsets equal to zero.
   */
  val Empty: Insets = new Insets(jfxg.Insets.EMPTY)

  /**
   * Constructs a new Insets instance with same value for all four offsets.
   */
  def apply(topRightBottomLeft: Double): Insets = new Insets(new jfxg.Insets(topRightBottomLeft))

  /**
   * Constructs a new Insets instance with four different offsets.
   */
  def apply(top: Double, right: Double, bottom: Double, left: Double): Insets =
    new Insets(new jfxg.Insets(top, right, bottom, left))

}

class Insets(override val delegate: jfxg.Insets) extends SFXDelegate[jfxg.Insets] {

  /**
   * The inset on the top side
   */
  def top = delegate.getTop

  /**
   * The inset on the right side
   */
  def right = delegate.getRight

  /**
   * The inset on the bottom side
   */
  def bottom = delegate.getBottom

  /**
   * The inset on the left side
   */
  def left = delegate.getLeft

}
