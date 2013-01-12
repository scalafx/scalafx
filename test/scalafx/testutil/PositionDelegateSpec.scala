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
package scalafx.testutil

import org.scalatest.matchers.ShouldMatchers.be
import org.scalatest.matchers.ShouldMatchers.convertToAnyShouldWrapper
import org.scalatest.FlatSpec

import scalafx.Includes.jfxDoubleProperty2sfx
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.PositionDelegate

/**
 * Trait to test PositionDelegate subclasses
 */
trait PositionDelegateSpec[D <: PositionDelegate[_]] extends FlatSpec {

  /**
   * 
   */
  val positionDelegate: D

  private def testDeslocation(testedProperty: DoubleProperty, propertyName: String) {
    var moved = false
    val observerDouble = new DoubleProperty(positionDelegate, propertyName)

    testedProperty.value = -10.0

    testedProperty.onChange(moved = true)
    observerDouble <== testedProperty 

    testedProperty.value = +101.0

    moved should be(true)
    observerDouble.value should be(+101)
  }

  it should "have its X Coordinate observed when it is changed" in {
    testDeslocation(positionDelegate.x, "X Property")
  }

  it should "have its Y Coordinate observed when it is changed" in {
    testDeslocation(positionDelegate.y, "Y Property")
  }

}