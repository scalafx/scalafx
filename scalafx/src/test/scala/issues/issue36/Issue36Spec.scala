/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

package issues.issue36

import javafx.beans.{property => jfxbp}
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import scalafx.Includes._
import scalafx.beans.property.{ReadOnlyObjectWrapper, ObjectProperty}

/**
 * Verify that code causing Issue 36 behaves correctly after fix.
 */
@RunWith(classOf[JUnitRunner])
class Issue36Spec extends FlatSpec {

  "Issue 36 - ObjectProperty[Int]" should "be able to instantiate" in {

    val p = new ObjectProperty[Int]
    p.value = 42

    assert(42 === p.value)
  }

  it should "bind SFX <==> JFX" in {
    val sfxProperty = ObjectProperty[Int](null, "sfx", 13)
    val jfxProperty = new jfxbp.SimpleObjectProperty[Int](this, "jfx", 224)

    sfxProperty <==> jfxProperty
    sfxProperty() = 17
    assert(17 === sfxProperty())
    assert(17 === jfxProperty())

    jfxProperty() = 21
    assert(21 === sfxProperty())
    assert(21 === jfxProperty())
  }

  it should "bind JFX <==> SFX" in {
    val sfxProperty = ObjectProperty[Int](null, "sfx", 13)
    val jfxProperty = new jfxbp.SimpleObjectProperty[Int](this, "jfx", 224)

    jfxProperty <==> sfxProperty
    sfxProperty() = 17
    assert(17 === sfxProperty())
    assert(17 === jfxProperty())

    jfxProperty() = 21
    assert(21 === sfxProperty())
    assert(21 === jfxProperty())
  }

  "Issue 36 - ReadOnlyObjectWrapper[Int]" should "be able to instantiate" in {

    val p = ReadOnlyObjectWrapper[Int](42)
    assert(42 === p.value)
    val readOnlyProperty = p.readOnlyProperty
    assert(42 === readOnlyProperty())
  }

  it should "bind its readOnlyProperty" in {
    val p = ReadOnlyObjectWrapper[Int](42)
    assert(42 === p.value)
    val readOnlyProperty = p.readOnlyProperty
    assert(42 === readOnlyProperty())

    p.value = 13
    assert(13 === readOnlyProperty())
  }

  it should "readOnlyProperty should bind to JFX" in {
    val p = ReadOnlyObjectWrapper[Int](42)
    assert(42 === p.value)
    val readOnlyProperty = p.readOnlyProperty
    assert(42 === readOnlyProperty())

    val jfxProperty = new jfxbp.SimpleObjectProperty[Int](this, "jfx", 224)
    assert(224 === jfxProperty())

    jfxProperty <== readOnlyProperty
    p.value = 13
    assert(13 === jfxProperty())
    assert(13 === readOnlyProperty())
  }
}
