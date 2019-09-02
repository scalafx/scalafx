/*
 * Copyright (c) 2011-2019, ScalaFX Project
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
package scalafx.scene.paint

import javafx.scene.{paint => jfxsp}
import scalafx.Includes._
import scalafx.testutil.SimpleSFXDelegateSpec

/**
  * RadialGradient Spec tests.
  *
  *
  */
class RadialGradientSpec
    extends SimpleSFXDelegateSpec[jfxsp.RadialGradient, RadialGradient](
      classOf[jfxsp.RadialGradient],
      classOf[RadialGradient]
    ) {

  override protected def getJavaClassInstance =
    new jfxsp.RadialGradient(0, 0, 0, 0, 0, true, jfxsp.CycleMethod.NO_CYCLE, new java.util.LinkedList[jfxsp.Stop]())

  it should "return valid instance from companion's apply(List[Stop])" in {
    val expected: RadialGradient = new RadialGradient(0, 0, 0, 0, 0, true, jfxsp.CycleMethod.NO_CYCLE, Nil)
    val radialGradient = RadialGradient(
      focusAngle = 0,
      focusDistance = 0,
      centerX = 0,
      centerY = 0,
      radius = 0,
      proportional = true,
      cycleMethod = CycleMethod.NoCycle,
      stops = Nil
    )
    assert(radialGradient === expected)
  }

  it should "return valid instance from companion's apply(stops*)" in {
    val expected: RadialGradient = new RadialGradient(
      0,
      0,
      0,
      0,
      0,
      true,
      jfxsp.CycleMethod.NO_CYCLE,
      List(
        new jfxsp.Stop(0, Color.White),
        new jfxsp.Stop(0, Color.Black)
      )
    )
    val radialGradient = RadialGradient(
      focusAngle = 0,
      focusDistance = 0,
      centerX = 0,
      centerY = 0,
      radius = 0,
      proportional = true,
      cycleMethod = CycleMethod.NoCycle,
      Stop(0, Color.White),
      Stop(0, Color.Black)
    )
    assert(radialGradient === expected)
  }
}
