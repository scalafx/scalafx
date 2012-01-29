package scalafx.scene.control

/*
 * Copyright (c) 2012, ScalaFX Project
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

import javafx.scene.{ control => jfxsc }
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.Includes._
import scalafx.testutil.PropertyComparator
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TextInputControlSpec extends FlatSpec with PropertyComparator {

  "A TextInputControl" should "implement all the JavaFX properties" in {
    compareProperties(classOf[jfxsc.TextInputControl], classOf[TextInputControl])
  }

  it should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[jfxsc.TextInputControlBuilder[_]], classOf[TextInputControl])
  }

  it should "have an implicit conversion from SFX to JFX" in {
    val sfxTextInputControl = new TextField
    val jfxTextInputControl: jfxsc.TextInputControl = sfxTextInputControl
    jfxTextInputControl should be(sfxTextInputControl.delegate)
  }

  /*
   * In sfxTextInputControl definition line we have compile error:
   * "type mismatch;  found   : javafx.scene.control.TextField  required: scalafx.scene.control.TextInputControl"
   * If I make a cast to TextInputControl like 
   * val sfxTextInputControl: TextInputControl = jfxTextInputControl.asInstanceOf[TextInputControl]
   * I have a ClassCastException "javafx.scene.control.TextField cannot be cast to scalafx.scene.control.TextInputControl"
   * 
   * TODO: How to correct this
   */
  /*
  it should "have an implicit conversion from JFX to SFX" in {
    val jfxTextInputControl = new jfxsc.TextField
    val sfxTextInputControl: TextInputControl = jfxTextInputControl.asInstanceOf[TextInputControl]
    sfxTextInputControl.delegate should be(jfxTextInputControl)
  }
*/
}