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

import org.scalatest.Assertions._

trait PropertyComparator {

  private def getScalaFXProperties(scalafxClass: Class[_]) = {
    scalafxClass.getMethods
      .map(m => m.getName)
      .toSet
  }

  private def scalaizePropertyNames(name: String) =
    if (name.length < 4) name
    else if (name.substring(0, 3) == "get") name(3).toLower + name.substring(4)
    else if (name.substring(0, 3) == "set") name(3).toLower + name.substring(4) + "_="
    else name

  /* TODO apply scalaizePropertyNames only to the javafx method names. */
  private def makeMethodSignature(m: java.lang.reflect.Method) = scalaizePropertyNames(m.getName) + m.getParameterTypes.map(_.getName).mkString("(", ",", ")")

  private def isSpecialMethodName(name: String) = (name == "applyTo") || (name == "create") || (name == "build") ||
    name.startsWith("impl_") || name.endsWith("Property") ||
    name.startsWith("get") || name.startsWith("set") || name.startsWith("is")

  /**
   * Takes a Method and generate a String showing the return type, name and parameters type of method.
   *
   * @param m Method
   */
  private def methodToString(m: Method) = {

      def classParameterToString(classParameter: Class[_], isVarargs: Boolean = false) = {
        (classParameter.isArray, classParameter.getName.matches("""^\[.$"""), isVarargs) match {
          case (true, true, true)   => classParameter.getName.last + "..."
          case (true, true, false)  => classParameter.getName.last + "[]"
          case (true, false, true)  => classParameter.getName.substring(2).init + "..."
          case (true, false, false) => classParameter.getName.substring(2).init + "[]"
          case (false, _, _)        => classParameter.getName
        }
      }

    val strParameters = (m.getParameterTypes.size, m.isVarArgs) match {
      case (0, _)    => ""
      case (1, true) => classParameterToString(m.getParameterTypes.last, true)
      case (_, true) => m.getParameterTypes.init.map(classParameterToString(_)).mkString("", ", ", ", ") +
        classParameterToString(m.getParameterTypes.last, true)
      case (_, false) => m.getParameterTypes.map(classParameterToString(_)).mkString(", ")
    }

    classParameterToString(m.getReturnType) + " " + m.getName + "(" + strParameters + ")"
  }

  /**
   * Returns a List with public methods (static or not) of a class.
   *
   * @param cls Class to be analyzed.
   * @param useStatic If we are looking for static methods or not
   * @return List with public methods (static or not) from cls.
   */
  private def groupMethods(cls: Class[_], useStatic: Boolean) = {
    val staticIndicator: Boolean => Boolean = if (useStatic) (b => b) else (b => !b)

    cls.getDeclaredMethods
      .filter(m => Modifier.isPublic(m.getModifiers) && staticIndicator(Modifier.isStatic(m.getModifiers)))
      .filterNot(m => isSpecialMethodName(m.getName))
      .sortWith(_.getName < _.getName)
      .toList
  }

  /**
   * Verifies if a method has a determined name.
   *
   *  @param methodName Name of method wanted
   *  @param method Method to be analyzed.
   *  @return `true` if scalaMethod has the requested name, `false` otherwise.
   */
  private def sameName(methodName: String, method: Method): Boolean = (method.getName == methodName)

  /**
   * Verifies if a method has no parameters
   *
   *  @param method Method to be analyzed.
   *  @return `true` if scalaMethod has no parameters, `false` otherwise.
   */
  private def methodHasNoArgs(method: Method): Boolean = (method.getParameterTypes.length == 0)

  /**
   * Verifies if a Scala method has as last argument a vararg. To be more precisely, this argument must be a
   * [[scala.Seq]], because this is the way how varargs are translated by Scala compiler. Notice that even a method
   * which really has a `Seq` as last argument (not a vararg) can return `true`. Moreover there is no information
   * about `Seq` type because of compiler erasing.
   *
   * @param method Method to be analyzed.
   * @return `true` if method's last argument is (potentially) vararg (ie, a `Seq`), `false` otherwise.
   */
  private def lastAgumentIsVararg(method: Method): Boolean = (method.getParameterTypes.last == classOf[Seq[_]])

  /**
   * Verifies if a method has only one argument ''and'' this argument is a varagrs.
   *
   * @param method Method to be analyzed.
   * @return `true` if method has only one argument ''and'' this argument is a varagrs, `false` otherwise.
   */
  private def methodHasOneArgVararg(method: Method): Boolean =
    (method.getParameterTypes.length == 1) && lastAgumentIsVararg(method)

  /**
   * Verifies if the a method arguments combine with
   */
  private def findMethodWithManyArgs(argTypes: List[Class[_]])(scalaMethod: Method): Boolean =
    (scalaMethod.getParameterTypes.length == argTypes.size) && (scalaMethod.getParameterTypes.toList == argTypes)

  /**
   *
   */
  private def findMethodWithManyArgsVarargs(argTypesExceptLast: List[Class[_]])(method: Method): Boolean =
    (method.getParameterTypes.length == argTypesExceptLast.size + 1) &&
      (method.getParameterTypes.init.toList == argTypesExceptLast) &&
      lastAgumentIsVararg(method)

  /**
   *
   *
   * @param javaMethods Relation of methods from a Java class
   * @param scalaMethods Relation of methods from a Scala class.
   * @param javaMethodsNotMirroed Relation of javaMethods that are not reflected in the scalaMethods.
   */
  private def compare(javaMethods: List[Method], scalaMethods: List[Method], javaMethodsNotMirroed: List[Method] = Nil): List[Method] = {
    javaMethods match {
      case Nil => javaMethodsNotMirroed
      case javaMethod :: otherMethods => {
        val finderMethod = (javaMethod.getParameterTypes.size, javaMethod.isVarArgs) match {
          case (0, _)     => methodHasNoArgs _
          case (1, true)  => methodHasOneArgVararg _
          case (_, true)  => findMethodWithManyArgsVarargs(javaMethod.getParameterTypes.toList.init) _
          case (_, false) => findMethodWithManyArgs(javaMethod.getParameterTypes.toList) _
        }

        if (scalaMethods.filter(sameName(javaMethod.getName, _)).exists(finderMethod)) compare(otherMethods, scalaMethods, javaMethodsNotMirroed)
        else compare(otherMethods, scalaMethods, javaMethod :: javaMethodsNotMirroed)
      }
    }
  }

  /**
   * Verify if all public methods from a Java class are mirroed in a Scala class. It means the same name,
   * return type, and parameters.
   *
   * @param javaClass Java Class
   * @param scalaClass Scala Class, that presumably must have the same public methods as javaClass
   * @param useStatic If it will be compared only static methods (`true`) or only declared methods (`false`).
   */
  private def compareMethods(javaClass: Class[_], scalaClass: Class[_], useStatic: Boolean) {
    val javaMethods = groupMethods(javaClass, useStatic)
    val scalaMethods = groupMethods(scalaClass, useStatic)

    val methodsNotFound = compare(javaMethods, scalaMethods)

    assert(methodsNotFound.isEmpty, "Missing %s Methods: ".format(if (useStatic) "Static" else "Declared") + methodsNotFound.map(methodToString).mkString(", "))
  }

  /**
   * This can be used to compare instance methods declared in a scalafx class with instance methods declared in
   * a javafx class. This should never actually be necessary, as "compareProperties" above will find all of the
   * property names that need to be implemented, and all other instance methods should be handled via implicit
   * conversions. However, having written the code, I'm leaving it in, in case it might prove useful as a way of
   * exploring the method signatures of a javafx class.
   *
   * @param javaClass JavaFx class
   * @param scalaClass ScalaFX class
   */
  def compareDeclaredMethods(javaClass: Class[_], scalaClass: Class[_]) = compareMethods(javaClass, scalaClass, false)

  /**
   * Similar to "compareProperties", the following compares the static methods in a javafx class
   * to the methods defined on a scalafx object.
   *
   * @param javaClass JavaFx class
   * @param scalaClass ScalaFX class
   */
  def compareStaticMethods(javaClass: Class[_], scalaClass: Class[_]) = compareMethods(javaClass, scalaClass, true)

  /**
   * 
   * @param javaFxProperties Properties names of JavaFX class. 
   * @param scalaFxClass ScalaFX class
   * @param complement 
   */
  private def assertProperties(javaFxProperties: Set[String], scalaFxClass: Class[_], complement: String) {
    val diff = javaFxProperties diff getScalaFXProperties(scalaFxClass)
    assert(diff.isEmpty, "Missing %s Properties: ".format(complement) + diff.toList.sorted.mkString(", "))
  }

  def compareProperties(javafxClass: Class[_], scalafxClass: Class[_]) {
    val javafxRegex = """(.*)Property""".r
    val javaFxProperties = javafxClass.getDeclaredMethods
      .filter(m => Modifier.isPublic(m.getModifiers))
      .filterNot(m => m.getName.startsWith("impl_"))
      .map(m => javafxRegex.findFirstMatchIn(m.getName))
      .flatMap(x => x)
      .map(_.group(1))
      .toSet

    assertProperties(javaFxProperties, scalafxClass, "")
  }

  def compareBuilderProperties(javafxClassBuilder: Class[_], scalafxClass: Class[_]) {
    val javaFxBuilderProperties = javafxClassBuilder.getDeclaredMethods // todo - this eventually needs to use: getMethods
      .filter(m => Modifier.isPublic(m.getModifiers))
      .map(_.getName)
      .filterNot(n => n == "applyTo" || n == "create" || n == "build" || n.startsWith("impl_"))
      .toSet

    assertProperties(javaFxBuilderProperties, scalafxClass, "Builder")
  }

}