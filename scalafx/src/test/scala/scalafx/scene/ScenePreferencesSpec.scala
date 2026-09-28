/*
 * Copyright (c) 2011-2026, ScalaFX Project
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

import javafx.{application as jfxa, scene as jfxs}
import org.scalatest.matchers.should.Matchers.*
import scalafx.CoreIncludes.*
import scalafx.application.{ColorScheme, Platform}
import scalafx.testutil.{RunOnApplicationThread, SimpleSFXDelegateSpec}

class ScenePreferencesSpec
    extends SimpleSFXDelegateSpec[jfxs.Scene.Preferences, Scene.Preferences](
      classOf[jfxs.Scene.Preferences],
      classOf[Scene.Preferences]
    )
    with RunOnApplicationThread {

  override protected def getScalaClassInstance: Scene.Preferences = new Scene.Preferences(getJavaClassInstance)

  override def getJavaClassInstance: jfxs.Scene.Preferences = new jfxs.Scene(new jfxs.Group).getPreferences

  it should "be accessible from Scene" in {
    val scene = new Scene()
    scene.preferences.delegate should be theSameInstanceAs scene.delegate.getPreferences
  }

  it should "override and restore platform color scheme" in {
    val preferences = new Scene().preferences

    preferences.colorScheme = ColorScheme.Dark
    preferences.colorScheme.value should be(jfxa.ColorScheme.DARK)
    preferences.colorScheme = ColorScheme.Light
    preferences.colorScheme.value should be(jfxa.ColorScheme.LIGHT)

    preferences.colorScheme = null
    preferences.colorScheme.value should be(Platform.preferences.colorScheme.value)
  }

  it should "override and restore platform boolean preferences" in {
    val preferences = new Scene().preferences
    val platform    = Platform.preferences

    val cases = Seq(
      (
        preferences.persistentScrollBars,
        platform.persistentScrollBars.value,
        (v: java.lang.Boolean) => preferences.persistentScrollBars = v
      ),
      (
        preferences.reducedMotion,
        platform.reducedMotion.value,
        (v: java.lang.Boolean) => preferences.reducedMotion = v
      ),
      (
        preferences.reducedTransparency,
        platform.reducedTransparency.value,
        (v: java.lang.Boolean) => preferences.reducedTransparency = v
      ),
      (
        preferences.reducedData,
        platform.reducedData.value,
        (v: java.lang.Boolean) => preferences.reducedData = v
      )
    )
    for ((property, platformValue, setter) <- cases) {
      setter(!platformValue)
      property.value.booleanValue should be(!platformValue)
      setter(null)
      property.value.booleanValue should be(platformValue)
    }
  }
}
