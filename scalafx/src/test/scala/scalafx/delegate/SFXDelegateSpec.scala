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
package scalafx.delegate

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*
import scalafx.beans.property.DoubleProperty

class SFXDelegateSpec extends AnyFlatSpec {
  val doubleProperty                  = new DoubleProperty(null, "double property")
  val doublePropertyWithSameName      = new DoubleProperty(null, "double property")
  val doublePropertyWithDifferentName = new DoubleProperty(null, "double property (with different name)")

  "SFXDelegate" should "delegate toString" in {
    doubleProperty.toString should be("[SFX]DoubleProperty [name: double property, value: 0.0]")
  }

  it should "delegate equals" in {
    // NOTE JFX8: JavaFX2 defined `equals` for SimpleDoubleProperty in ReadOnlyDoubleProperty
    //            JavaFX8 does not override `equals` that is defined in `Object` so comparing two different
    //            instances of SimpleDoubleProperty will be always return `false` and following test will fail
    // doubleProperty should equal(doublePropertyWithSameName)
    doubleProperty should not(equal(doublePropertyWithDifferentName))
  }

  it should "delegate hashCode" in {
    doubleProperty.hashCode should equal(doubleProperty.delegate.hashCode)
  }

  it should "have a public delegate property" in {
    doubleProperty.delegate should not(be(null))
  }
}
