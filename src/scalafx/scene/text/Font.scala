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

package scalafx.scene.text

import scala.collection.JavaConversions._

import javafx.scene.{text => jfxst}
import javafx.scene.text.{FontWeight, FontPosture}
import scalafx.util.SFXDelegate

object Font {
  implicit def sfxFont2jfx(v: Font) = v.delegate

  def	default = jfxst.Font.getDefault

  def families = jfxst.Font.getFamilies.toSeq

  def	font(family: String, size: Double) = jfxst.Font.font(family, size)
  def	font(family: String, posture: FontPosture, size: Double) = jfxst.Font.font(family, posture, size)
  def	font(family: String, weight: FontWeight, size: Double) = jfxst.Font.font(family, weight, size)
  def	font(family: String, weight: FontWeight, posture: FontPosture, size: Double) = jfxst.Font.font(family, weight, posture, size)

  def fontNames = jfxst.Font.getFontNames.toSeq
  def fontNames(family: String) = jfxst.Font.getFontNames(family).toSeq

  def	loadFont(in: java.io.InputStream, size: Double) = jfxst.Font.loadFont(in, size)
  def	loadFont(urlStr: String, size: Double) = jfxst.Font.loadFont(urlStr, size)
}

class Font(val delegate: jfxst.Font) extends SFXDelegate[jfxst.Font]{

  def this(size: Double) = this(new jfxst.Font(size))

  def this(name: String, size: Double) = this(new jfxst.Font(name, size))

  def family = delegate.getFamily
  def name = delegate.getName
  def size = delegate.getSize
  def style = delegate.getStyle
}
