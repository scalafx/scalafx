/*
 * Copyright (c) 2011-2017, ScalaFX Project
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

import javafx.{scene => jfxs}

import scalafx.Includes._
import scalafx.testutil.SimpleSFXDelegateSpec

/**
 * Scene Spec tests.
 */
class SceneAntialiasingSpec
    extends SimpleSFXDelegateSpec[jfxs.SceneAntialiasing, SceneAntialiasing](
      classOf[jfxs.SceneAntialiasing],
      classOf[SceneAntialiasing]
    ) {

  override protected def getScalaClassInstance     = SceneAntialiasing.Balanced
  override protected def getJavaClassInstance      = jfxs.SceneAntialiasing.DISABLED
  override protected def expectedNullJFXToSFXValue = SceneAntialiasing.Disabled

  /**
   * Class tests.
   */
  it should "treat a null JFX SceneAntialiasing reference as disabled" in {
    val jfxNull: jfxs.SceneAntialiasing = null
    val scalaEquiv: SceneAntialiasing   = jfxNull
    assert(scalaEquiv === expectedNullJFXToSFXValue)
  }

  it should "treat JFX SceneAntialiasing.DISABLED as disabled" in {
    val jfxDisabled                   = jfxs.SceneAntialiasing.DISABLED
    val scalaEquiv: SceneAntialiasing = jfxDisabled
    assert(scalaEquiv === SceneAntialiasing.Disabled)
  }

  it should "convert SFX SceneAntialiasing.Disabled to disabled" in {
    val sfxDisabled                       = SceneAntialiasing.Disabled
    val javaEquiv: jfxs.SceneAntialiasing = sfxDisabled
    assert(javaEquiv === jfxs.SceneAntialiasing.DISABLED)
  }

  it should "treat JFX SceneAntialiasing.BALANCED as balanced" in {
    val jfxBalanced                   = jfxs.SceneAntialiasing.BALANCED
    val scalaEquiv: SceneAntialiasing = jfxBalanced
    assert(scalaEquiv === SceneAntialiasing.Balanced)
  }

  it should "convert SFX SceneAntialiasing.Balanced to balanced" in {
    val sfxBalanced                       = SceneAntialiasing.Balanced
    val javaEquiv: jfxs.SceneAntialiasing = sfxBalanced
    assert(javaEquiv === jfxs.SceneAntialiasing.BALANCED)
  }
}
