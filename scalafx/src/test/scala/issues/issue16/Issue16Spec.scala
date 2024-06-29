/*
 * Copyright (c) 2011-2020, ScalaFX Project
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

package issues.issue16

import javafx.beans.{property => jfxbp}
import javafx.scene.{paint => jfxsp}
import org.scalatest.flatspec.AnyFlatSpec
import scalafx.Includes._
import scalafx.beans.property.{ObjectProperty, ReadOnlyBooleanProperty}
import scalafx.scene.paint.Color

/**
 * Verify that code causing Issue 16 behaves correctly after fix.
 */
class Issue16Spec extends AnyFlatSpec {

  "Issue 16 - binding" should "respond to changes in `when` condition" in {

    // Recreate situation in Issue 16 using properties of the same types.
    val hoverWrapper = new jfxbp.ReadOnlyBooleanWrapper(true)
    val hover: ReadOnlyBooleanProperty = hoverWrapper.getReadOnlyProperty
    val fill: ObjectProperty[jfxsp.Color] = ObjectProperty(jfxsp.Color.BLUE)

    // Before binding is created `fill` should have its original value
    assert(Color.Blue === fill())
    assert(true === hover())

    // The problem reported in Issue 16 was that `fill` did not respond to changes in `hover`.

    // TODO Scala 3: Original line of code does not compile with Scala 3.0.0-RC2
    // fill <== when (hover) choose Color.Green otherwise Color.Red
    // NOTE Scala 3: variable `helper` was added to force type (and implicit conversions) on right side of `<==`
    //               This is not needed in Scala 2
    import javafx.scene.{paint => jfxsp}
    import scalafx.beans.binding.ObjectBinding
    val helper: ObjectBinding[jfxsp.Color] = when(hover) choose Color.Green otherwise Color.Red
    fill <== helper

    assert(true === hover())
    assert(Color.Green === fill())

    hoverWrapper.set(false)
    assert(false === hover())
    assert(Color.Red === fill())

    hoverWrapper.set(true)
    assert(true === hover())
    assert(Color.Green === fill())
  }
}
