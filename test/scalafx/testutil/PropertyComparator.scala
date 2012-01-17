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

import org.scalatest.Assertions._
import java.lang.reflect.Modifier

trait PropertyComparator {
  private def getScalaFXProperties(scalafxClass:Class[_]) = {
    scalafxClass.getMethods
      .map(m => m.getName)
      .toSet
  }

  def compareProperties(javafxClass:Class[_], scalafxClass:Class[_]) {
    val javafxRegex = """(.*)Property""".r
    val javafxProperties = javafxClass.getDeclaredMethods
      .filter(m => Modifier.isPublic(m.getModifiers) )
      .filterNot(m => m.getName.startsWith("impl_"))
      .map(m => javafxRegex.findFirstMatchIn(m.getName))
      .flatMap(x => x)
      .map(_.group(1))
      .toSet
    val diff = javafxProperties diff getScalaFXProperties(scalafxClass)
    assert(diff.isEmpty, "Missing Properties: " + diff.toList.sorted.mkString(", "))
  }

  private def scalaizePropertyNames(name: String) =
    if (name.length < 4) name
    else if (name.substring(0, 3) == "get") name(3).toLower + name.substring(4)
    else if (name.substring(0, 3) == "set") name(3).toLower + name.substring(4) + "_="
    else name

  /* TODO apply scalaizePropertyNames only to the javafx method names. */
  private def makeMethodSignature(m: java.lang.reflect.Method) = scalaizePropertyNames(m.getName) + m.getParameterTypes.map(_.getName).mkString("(", ",", ")")

  def compareBuilderProperties(javafxClassBuilder:Class[_], scalafxClass:Class[_]) {
    val javafxBuilderProperties = javafxClassBuilder.getDeclaredMethods // todo - this eventually needs to use: getMethods
      .filter(m => Modifier.isPublic(m.getModifiers))
      .map(_.getName)
      .filterNot(n => n == "applyTo" || n == "create" || n == "build" || n.startsWith("impl_"))
      .toSet
    val diff = javafxBuilderProperties diff getScalaFXProperties(scalafxClass)
    assert(diff.isEmpty, "Missing Properties: " + diff.toList.sorted.mkString(", "))
  }

  /**This can be used to compare instance methods declared in a scalafx class with instance methods declared in
   * a javafx class. This should never actually be necessary, as "compareProperties" above will find all of the
   * property names that need to be implemented, and all other instance methods should be handled via implicit
   * conversions. However, having written the code, I'm leaving it in, in case it might prove useful as a way of
   * exploring the method signatures of a javafx class.
   */
  def compareDeclaredMethods(jfxClass:Class[_], sfxClass:Class[_]) {
    val sfxMethods = sfxClass.getDeclaredMethods.filter(m => Modifier.isPublic(m.getModifiers))
    val sfxSignatures = sfxMethods.map(makeMethodSignature(_)).toSet

    val jfxMethods = jfxClass.getDeclaredMethods
      .filter(m => Modifier.isPublic(m.getModifiers))
      .filterNot(m => m.getName == "applyTo" || m.getName == "create" || m.getName == "build"
      || m.getName.startsWith("impl_") || m.getName.endsWith("Property")
      || m.getName.startsWith("get") || m.getName.startsWith("set") || m.getName.startsWith("is")
    )
    val jfxSignatures = jfxMethods.map(makeMethodSignature(_)).toSet

    val diff = jfxSignatures diff sfxSignatures
    assert(diff.isEmpty, "Missing Methods: " + diff.toList.sorted.mkString(", "))
  }

  /**Similar to "compareProperties", the following compares the static methods in a javafx class
   * to the methods defined on a scalafx object.
   */
  def compareStaticMethods(jfxClass:Class[_], sfxObject:Class[_]) {
    val jfxStaticMethods = jfxClass.getDeclaredMethods
      .filter(m => Modifier.isStatic(m.getModifiers) && Modifier.isPublic(m.getModifiers))
    val jfxStaticSigs = jfxStaticMethods
      .filterNot(m => m.getName == "applyTo" || m.getName == "create" || m.getName == "build"
      || m.getName.startsWith("impl_") || m.getName.endsWith("Property")
      || m.getName.startsWith("get") || m.getName.startsWith("set") || m.getName.startsWith("is")
      ).map(makeMethodSignature(_)).toSet

    val sfxMethods = sfxObject.getDeclaredMethods.filter(m => Modifier.isPublic(m.getModifiers))
    val sfxSignatures = sfxMethods.map(makeMethodSignature(_)).toSet

    val diff = jfxStaticSigs diff sfxSignatures
    assert(diff.isEmpty, "Missing Static Methods: " + diff.toList.sorted.mkString(", "))
  }
}