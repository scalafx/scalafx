/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.scene.paint

import javafx.scene.{paint => jfxsp}
import scalafx.util.SFXDelegate

object Color {
  implicit def sfxColor2jfx(c: Color) = c.delegate

  def web(color: String) = new Color(jfxsp.Color.web(color))
  def web(color: String, opacity: Double) = new Color(jfxsp.Color.web(color, opacity))
  def rgb(red: Int, green: Int, blue: Int) = new Color(jfxsp.Color.rgb(red, green, blue))
  def rgb(red: Int, green: Int, blue: Int, opacity: Double) = new Color(jfxsp.Color.rgb(red, green, blue, opacity))
  def hsb(hue: Double, saturation: Double, brightness: Double) = new Color(jfxsp.Color.hsb(hue, saturation, brightness))
  def hsb(hue: Double, saturation: Double, brightness: Double, opacity: Double) = new Color(jfxsp.Color.hsb(hue, saturation, brightness, opacity))
  def color(red: Double, green: Double, blue: Double) = new Color(jfxsp.Color.color(red, green, blue))
  def color(red: Double, green: Double, blue: Double, opacity: Double) = new Color(jfxsp.Color.color(red, green, blue, opacity))
  def gray(gray: Double) = new Color(jfxsp.Color.gray(gray))
  def gray(gray: Double, opacity: Double) = new Color(jfxsp.Color.gray(gray, opacity))
  def grayRgb(gray: Int) = new Color(jfxsp.Color.gray(gray))
  def grayRgb(gray: Int, opacity: Double) = new Color(jfxsp.Color.gray(gray, opacity))
}

class Color(override val delegate:jfxsp.Color) extends SFXDelegate[jfxsp.Color] {
  def red = delegate.getRed
  def green = delegate.getGreen
  def blue = delegate.getBlue
  def opacity = delegate.getOpacity
  
  def hue = delegate.getHue
  def saturation = delegate.getSaturation
  def brightness = delegate.getBrightness

  def opacity(o: Double) = jfxsp.Color.color(red, green, blue, o)
}