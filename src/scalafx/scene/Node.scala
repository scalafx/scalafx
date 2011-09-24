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

package scalafx.scene

import scalafx.Includes._
import javafx.scene.CacheHint
import javafx.scene.Cursor
import javafx.scene.DepthTest
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Effect
import scalafx.util.SFXDelegate

object Node {
  implicit def sfxNode2jfx(v: Node) = v.delegate
}

abstract class Node extends SFXDelegate[javafx.scene.Node] {
  def blendMode = delegate.blendModeProperty
  def blendMode_=(v: BlendMode) {
    blendMode() = v
  }

  def boundsInLocal = delegate.boundsInLocalProperty

  def boundsInParent = delegate.boundsInParentProperty

  def cacheHint = delegate.cacheHintProperty
  def cacheHint_=(v: CacheHint) {
    cacheHint() = v
  }

  def cache = delegate.cacheProperty
  def cache_=(v: Boolean) {
    cache() = v
  }

  def clip = delegate.clipProperty
  def clip_=(v: javafx.scene.Node) {
    clip() = v
  }

  def cursor = delegate.cursorProperty
  def cursor_=(v: Cursor) {
    cursor() = v
  }

  def depthTest = delegate.depthTestProperty
  def depthTest_=(v: DepthTest) {
    depthTest() = v
  }

  def disabled = delegate.disabledProperty

  def disable = delegate.disableProperty
  def disable_=(v: Boolean) {
    disable() = v
  }

  def effect = delegate.effectProperty
  def effect_=(v: Effect) {
    effect() = v
  }

  def hover = delegate.hoverProperty
}
