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

package scalafx.scene.layout

import javafx.{geometry => jfxg}
import javafx.scene.{layout => jfxsl}
import scalafx.Includes._
import scalafx.util.SFXDelegate

object ColumnConstraints {
  implicit def sfxColumnConstraints2jfx(v: ColumnConstraints) = v.delegate
}

class ColumnConstraints(override val delegate:jfxsl.ColumnConstraints = new jfxsl.ColumnConstraints()) extends ConstraintsBase(delegate) with SFXDelegate[jfxsl.ColumnConstraints] {
  def fillWidth = delegate.fillWidthProperty
  def fillWidth_=(v: Boolean) {
    fillWidth() = v
  }

  def halignment = delegate.halignmentProperty
  def halignment_=(v: jfxsl.Priority) {
    hgrow() = v
  }

  def hgrow = delegate.hgrowProperty
  def hgrow_=(v: jfxsl.Priority) {
    hgrow() = v
  }

  def maxWidth = delegate.maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth() = v
  }

  def minWidth = delegate.minWidthProperty
  def minWidth_=(v: Double) {
    minWidth() = v
  }

  def percentWidth = delegate.percentWidthProperty
  def percentWidth_=(v: Double) {
    percentWidth() = v
  }
  
  def prefWidth = delegate.prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth() = v
  }
}
