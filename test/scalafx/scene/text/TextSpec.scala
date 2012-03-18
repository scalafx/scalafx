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

import javafx.scene.{text => jfxs}
import org.scalatest.matchers.ShouldMatchers._
import scalafx.Includes._
import scalafx.testutil.PropertyComparator
import org.scalatest.{SeveredStackTraces, FlatSpec}

class TextSpec extends FlatSpec with PropertyComparator with SeveredStackTraces {

  val jfxClass = classOf[jfxs.Text]
  val sfxClass = classOf[Text]
  val sfxObject = Class.forName("scalafx.scene.text.Text$")

  "A " + sfxClass.getName should "implement all the JavaFX properties" in {
    compareProperties(jfxClass, sfxClass)
  }

  it should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[jfxs.TextBuilder[Any]], sfxClass)
  }

  it should "declare all public methods of " + jfxClass.getName in {
    compareDeclaredMethods(jfxClass, sfxClass)
  }

  it should "declare all public static methods of " + jfxClass.getName in {
    compareStaticMethods(jfxClass, sfxObject)
  }

  it should "have implicit conversions between SFX <-> JFX" in {
    val sfxOriginalInstance = new Text()
    val jfxInstance: jfxs.Text = sfxOriginalInstance
    val sfxInstance: Text = jfxInstance

    sfxOriginalInstance.delegate should be (jfxInstance)
    jfxInstance should be (sfxInstance.delegate)
  }
}
