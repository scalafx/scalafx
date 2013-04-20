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
package scalafx.testutil

import java.lang.reflect.Method
import java.lang.reflect.Modifier

trait PropertyComparator 
  extends AbstractComparator {

  private def getScalaFXProperties(scalafxClass: Class[_]) = {
    scalafxClass.getMethods
      .map(m => m.getName)
      .toSet
  }

  protected def getDesirableMethodName(javaMethod: Method): String = javaMethod.getName

  protected def isSpecialMethodName(name: String) = super.isImplementation(name) ||
    (name == "applyTo") || (name == "create") || (name == "build") || 
    name.endsWith("Property") || name.startsWith("get") || name.startsWith("set") || name.startsWith("is")

  private def assertProperties(javaFxProperties: Set[String], scalaFxClass: Class[_], complement: String) {
    val diff = javaFxProperties diff getScalaFXProperties(scalaFxClass)
    assert(diff.isEmpty, "Missing %s: ".format(complement) + diff.toList.sorted.mkString(", "))
  }

  private def getProperties(javafxClass: Class[_]): Set[String] = {
    val javafxRegex = """(.*)Property""".r
    val javaFxProperties = javafxClass.getDeclaredMethods
      .filter(super.isPublicMethod)
      .filterNot(m => super.isImplementation(m.getName))
      .map(m => javafxRegex.findFirstMatchIn(m.getName))
      .flatMap(x => x)
      .map(_.group(1))
      .toSet
    javaFxProperties
  }

  private def getBuilderProperties(javafxClassBuilder: Class[_]): Set[String] = {
    val notAllowed = (n: String) => n == "applyTo" || n == "create" || n == "build" || super.isImplementation(n)

    val javaFxBuilderProperties = javafxClassBuilder.getDeclaredMethods // todo - this eventually needs to use: getMethods
      .filter(super.isPublicMethod)
      .map(_.getName)
      .filterNot(notAllowed)
      .toSet
    javaFxBuilderProperties
  }

  def compareProperties(javafxClass: Class[_], scalafxClass: Class[_]) {
    assertProperties(getProperties(javafxClass), scalafxClass, "Properties")
  }

  def comparePropertiesInProxy(javafxClass: Class[_], scalafxPropertyProxy: Class[_]) {
    assertProperties(getProperties(javafxClass), scalafxPropertyProxy, "Properties in Proxy")
  }

  def compareBuilderProperties(javafxClassBuilder: Class[_], scalafxClass: Class[_]) {
    assertProperties(getBuilderProperties(javafxClassBuilder), scalafxClass, "Builder Properties")
  }

  def compareBuilderPropertiesInProxy(javafxClassBuilder: Class[_], scalafxPropertyProxy: Class[_]) {
    assertProperties(getBuilderProperties(javafxClassBuilder), scalafxPropertyProxy, "Builder Properties in Proxy")
  }

}