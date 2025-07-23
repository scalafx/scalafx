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

package scalafx.scene

import javafx.scene as jfxs
import scalafx.Includes.*
import scalafx.testutil.{RunOnApplicationThread, SimpleSFXDelegateSpec}

/**
 * Scene Spec tests.
 */
class SceneSpec
    extends SimpleSFXDelegateSpec[jfxs.Scene, Scene](classOf[jfxs.Scene], classOf[Scene])
    with RunOnApplicationThread {

  override protected def getScalaClassInstance = new Scene(getJavaClassInstance)

  override protected def getJavaClassInstance = new jfxs.Scene(new jfxs.Group)

  //  protected def getScalaPropertyClassInstance = new ScalaProperty(getJavaPropertyClassInstance)
  //  protected def getJavaPropetyClassInstance = new

  //  "A %s".format(classOf[jfxs.Scene].getSimpleName) should "have an implicit conversion from SFX Property to JFX Property" in {
  //    // Test if the implicit conversion exists
  //    //assert(sfxProp2jfxProp != null, "There is no implicit conversion from ScalaFX to JavaFX")
  //
  //    // Test if conversion behaves correctly
  //    val sfxObject = getScalaPropertyClassInstance
  //    val jfxObject: J = sfxObject
  //
  //    jfxObject should be(sfxObject.delegate)
  //  }
  //
  //  it should "have an implicit conversion from JFX to SFX" in {
  //    // Test if the implicit conversion exists
  //    assert(jfx2sfx != null, "There is no implicit conversion from JavaFX to ScalaFX")
  //
  //    // Test if conversion behaves correctly
  //    val jfxObject = getJavaClassInstance
  //    val sfxObject: S = jfxObject
  //
  //    sfxObject.delegate should be(jfxObject)
  //  }

  it should "have a Property class that exposes all the JavaFX properties" in {
    comparePropertiesInProxy(classOf[jfxs.Scene], classOf[SceneProperty])
  }

}
