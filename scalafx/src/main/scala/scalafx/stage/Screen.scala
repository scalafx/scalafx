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
package scalafx.stage

import javafx.{ stage => jfxs }
import scalafx.Includes._
import scalafx.geometry.Rectangle2D
import scalafx.scene.Node._
import scalafx.scene.Node
import scalafx.delegate.SFXDelegate

object Screen {
  implicit def sfxScreen2jfx(v: Screen) = v.delegate

  /**
   * The primary Screen.
   */
  def primary: Screen = jfxs.Screen.getPrimary

  /**
   * The observable list of currently available Screens
   */
  def screens = jfxs.Screen.getScreens

  /**
   * Returns a ObservableList of Screens that intersects the provided rectangle.
   */
  def screensForRectangle(x: Double, y: Double, width: Double, height: Double) = 
    jfxs.Screen.getScreensForRectangle(x, y, width, height)

  /**
   * Returns a ObservableList of Screens that intersects the provided rectangle.
   */
  def screensForRectangle(r: Rectangle2D) = jfxs.Screen.getScreensForRectangle(r)

}

class Screen(override val delegate: jfxs.Screen = new jfxs.Screen)
  extends SFXDelegate[jfxs.Screen] {

  /**
   * Gets the bounds of this Screen.
   */
  def bounds: Rectangle2D = delegate.getBounds

  /**
   * Gets the resolution (dots per inch) of this Screen.
   */
  def dpi = delegate.getDpi

  /**
   * Gets the visual bounds of this Screen.
   */
  def visualBounds: Rectangle2D = delegate.getVisualBounds

}