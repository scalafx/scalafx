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

import javafx.geometry.Bounds
import javafx.scene.CacheHint
import javafx.scene.Cursor
import javafx.scene.DepthTest
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Effect
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.beans.property.ReadOnlyBooleanProperty

abstract class Node {
  val node: javafx.scene.Node

  private[this] lazy val _blendModeProperty = new ObjectProperty[BlendMode](node.blendModeProperty())
  def blendMode = _blendModeProperty
  def blendMode_=(v: BlendMode) {
    blendMode() = v
  }    
  
  private[this] lazy val _boundsInLocalProperty = new ReadOnlyObjectProperty[Bounds](node.boundsInLocalProperty())
  def boundsInLocal = _boundsInLocalProperty

  private[this] lazy val _boundsInParentProperty = new ReadOnlyObjectProperty[Bounds](node.boundsInParentProperty())
  def boundsInParent = _boundsInParentProperty
   
  private[this] lazy val _cacheHintProperty = new ObjectProperty[CacheHint](node.cacheHintProperty())
  def cacheHint = _cacheHintProperty
  def cacheHint_=(v: CacheHint) {
    cacheHint() = v
  }

  private[this] lazy val _cacheProperty = new BooleanProperty(node.cacheProperty())
  def cache = _cacheProperty
  def cache_=(v: Boolean) {
    cache() = v
  }
 
  private[this] lazy val _clipProperty = new ObjectProperty[javafx.scene.Node](node.clipProperty())
  def clip = _clipProperty
  def clip_=(v: javafx.scene.Node) {
    clip() = v
  }
  
  private[this] lazy val _cursorProperty = new ObjectProperty[Cursor](node.cursorProperty())
  def cursor = _cursorProperty
  def cursor_=(v: Cursor) {
    cursor() = v
  }  
  
  private[this] lazy val _depthTestProperty = new ObjectProperty[DepthTest](node.depthTestProperty())
  def depthTest = _depthTestProperty
  def depthTest_=(v: DepthTest) {
    depthTest() = v
  }  
 
  private[this] lazy val _disabledProperty = new ReadOnlyBooleanProperty(node.disabledProperty())
  def disabled = _disabledProperty
 
  private[this] lazy val _disableProperty = new BooleanProperty(node.disableProperty())
  def disable = _disableProperty
  def disable_=(v: Boolean) {
    disable() = v
  }
  
  private[this] lazy val _effectProperty = new ObjectProperty[Effect](node.effectProperty())
  def effect = _effectProperty
  def effect_=(v: Effect) {
    effect() = v
  } 
  
  private[this] lazy val _hoverProperty = new ReadOnlyBooleanProperty(node.hoverProperty())
  def hover = _hoverProperty
}
