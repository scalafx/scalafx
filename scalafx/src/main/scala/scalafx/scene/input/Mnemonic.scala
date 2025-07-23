/*
 * Copyright (c) 2011-2025, ScalaFX Project
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
package scalafx.scene.input

import javafx.scene.input as jfxsi
import scalafx.Includes.*
import scalafx.delegate.{FireDelegate, SFXDelegate}
import scalafx.scene.Node

import scala.language.implicitConversions

object Mnemonic {
  implicit def sfxMnemonic2jfx(m: Mnemonic): jfxsi.Mnemonic = if (m != null) m.delegate else null
}

class Mnemonic(override val delegate: jfxsi.Mnemonic)
    extends FireDelegate[jfxsi.Mnemonic]
    with SFXDelegate[jfxsi.Mnemonic] {

  /**
   * Constructs a Mnemonic with the specified target Node and trigger KeyCombination.
   */
  def this(node: Node, keyCombination: KeyCombination) = this(new jfxsi.Mnemonic(node, keyCombination))

  /**
   * The KeyCombination
   */
  def keyCombination: KeyCombination = delegate.getKeyCombination

  def keyCombination_=(v: KeyCombination): Unit = {
    delegate.setKeyCombination(v)
  }

  /**
   * Returns the Node
   */
  def node: Node = delegate.getNode

  def node_=(n: Node): Unit = {
    delegate.setNode(n)
  }

}
