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
package scalafx.application

import javafx.application as jfxa
import org.scalatest.matchers.should.Matchers.*
import scalafx.Includes.jfxParameters2sfx
import scalafx.application.JFXApp3.Parameters.sfxParameters2jfx
import scalafx.testutil.SimpleSFXDelegateSpec
import scalafx.util.JavaConverters.*

import java.util

/**
 * JFXApp3.Parameters Spec tests.
 */
class JFXApp3ParametersSpec
    extends SimpleSFXDelegateSpec[jfxa.Application.Parameters, JFXApp3.Parameters](
      classOf[jfxa.Application.Parameters],
      classOf[JFXApp3.Parameters]
    ) {

  override protected def getScalaClassInstance: scalafx.application.JFXApp3.ParametersImpl =
    new JFXApp3.ParametersImpl(Seq.empty[String])

  override protected def getJavaClassInstance: jfxa.Application.Parameters = new jfxa.Application.Parameters {
    def getRaw: util.List[String] = Seq.empty[String].asJava

    def getNamed: util.Map[String, String] = Map.empty[String, String].asJava

    def getUnnamed: util.List[String] = Seq.empty[String].asJava
  }

  private def getParameters(args: Seq[String]): JFXApp3.Parameters = JFXApp3.Parameters(args)

  it should "returns a empty list of parameters from empty arguments" in {
    getParameters(Seq.empty[String]).raw shouldBe empty
  }

  it should "allows raw arguments" in {
    val args       = Seq("arg1", "arg2")
    val parameters = getParameters(args)

    parameters.raw should contain theSameElementsInOrderAs args
    parameters.unnamed should contain theSameElementsInOrderAs args
    parameters.named shouldBe empty
  }

  it should "allows named arguments" in {
    val args       = Seq("--arg1=value1", "--arg2=value2")
    val parameters = getParameters(args)

    parameters.raw should contain theSameElementsInOrderAs args
    parameters.unnamed shouldBe empty
    parameters.named should contain theSameElementsAs Map("arg1" -> "value1", "arg2" -> "value2")
  }

  it should "allows mix raw and named arguments" in {
    val args       = Seq("arg1", "--arg2=value2", "-arg3=value3")
    val parameters = getParameters(args)

    parameters.raw should contain theSameElementsInOrderAs args
    parameters.unnamed should contain theSameElementsInOrderAs Seq("arg1", "-arg3=value3")
    parameters.named should contain theSameElementsAs Map("arg2" -> "value2")
  }

}
