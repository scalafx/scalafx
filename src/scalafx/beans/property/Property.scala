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

package scalafx.beans.property

import javafx.beans.value.{ObservableValue => JFXObservableValue}
import javafx.beans.{property => jfxbp}
import scalafx.beans.value.ObservableValue
import scalafx.util.SFXDelegate

object Property {
  implicit def sfxProperty2jfx(p: Property[_, _]) = p.delegate
}

trait Property[@specialized(Int, Long, Float, Double, Boolean) T, J] extends ReadOnlyProperty[T, J] with SFXDelegate[jfxbp.Property[J]] {
  def value_=(v: T)

  def update(v: T) {
    value_=(v)
  }

  def <==(v: JFXObservableValue[_ <: J]) {
    delegate.bind(v)
  }

  def <==(v: ObservableValue[_ <: T, _ <: J]) {
    delegate.bind(v.delegate)
  }

  def <==>(v: Property[T, J]) {
    delegate.bindBidirectional(v.delegate)
  }

  def <==>(v: jfxbp.Property[J]) {
    delegate.bindBidirectional(v)
  }

  def unbind() {
    delegate.unbind()
  }

  def unbind(v: Property[T, J]) {
    delegate.unbindBidirectional(v.delegate)
  }

  def unbind(v: jfxbp.Property[J]) {
    delegate.unbindBidirectional(v)
  }
}
