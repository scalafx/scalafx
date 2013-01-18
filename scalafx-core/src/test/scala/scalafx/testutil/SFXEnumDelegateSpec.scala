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

import java.lang.reflect.Method
import java.util.EnumSet
import scala.collection.JavaConversions._
import scalafx.delegate.SFXEnumDelegate
import scalafx.delegate.SFXEnumDelegateCompanion


/** Abstract class that facilitates testing of wrappers for Java enums.
  *
  * IMPORTANT: the second order parameters jfx2sfx and sfx2jfx have to be left unassigned in the derived class.
  * If compiler finds implicit conversion between JavaFX and ScalaFx (and back) it will assign the corresponding
  * implicit functions to those parameters. Make use that you provide implicit conversion include, for instance,
  * `import scalafx.Includes._`
  *
  * Here a complete test implemented using `SFXEnumDelegateSpec`,
  * {{{
  *  import javafx.{geometry => jfxg}
  *  import org.junit.runner.RunWith
  *  import org.scalatest.junit.JUnitRunner
  *  import scalafx.Includes._
  *  import scalafx.testutil.SFXEnumDelegateSpec
  *
  *  `@RunWith(classOf[JUnitRunner])`
  *  class HPosSpec extends SFXEnumDelegateSpec[jfxg.HPos, HPos](
  *    javaClass = classOf[jfxg.HPos],
  *    scalaClass = classOf[HPos],
  *    companion = HPos)
  * }}}
  *
  * @tparam E JavaFX enum class to be wrapped by SFXDelegate class
  * @tparam S SFXEnumDelegate subclass that will wrap JavaFX class
  *
  * @param javaClass JavaFX Enum class
  * @param scalaClass SFXEnumDelegate subclass related with JavaFX class
  * @param companion companion object of the ScalaFX enum wrapper class.
  * @param jfx2sfx Implicit conversion from JavaFX to ScalaFX, it should not be assigned,
  *                it has to be resolved automatically by the compiler.
  * @param sfx2jfx Implicit conversion from ScalaFX to JavaFX, it should not be assigned,
  *                it has to be resolved automatically by the compiler.
  */
abstract class SFXEnumDelegateSpec[E <: java.lang.Enum[E], S <: SFXEnumDelegate[E]] protected(javaClass: Class[E], scalaClass: Class[S], companion: SFXEnumDelegateCompanion[E, S])(implicit jfx2sfx: E => S = null, sfx2jfx: S => E = null)
  extends SFXDelegateSpec[E, S](javaClass, scalaClass) {

  private val javaEnumConstants = EnumSet.allOf(javaClass)

  private def nameIsPresent(name: String) = {
    try {
      val scalaEnum = companion(name)
      true
    } catch {
      case e: IllegalArgumentException => false
    }
  }

  private def assertScalaEnumWithOrdinal(s: S, index: Int): Unit =
    assert(s.delegate.ordinal() == index, "%s - Expected position: %d, actual: %d".format(s, s.delegate.ordinal(), index))

  protected override def getDesirableMethodName(javaMethod: Method): String = JavaBeanEvaluator.scalaizePropertyNames(javaMethod)

  /*
   * Functionalities from static method "valueOf" (present in all java enums) are being replaced by apply method in 
   * companions objects. Therefore, "valueOf" is being excluded from methods search.
   */
  protected override def isSpecialMethodName(name: String) = super.isImplementation(name) ||
    (name == "values") || (name == "valueOf") || name.startsWith("is") || name.startsWith("get")

  // Simply it gets the first constant available.
  override protected def getScalaClassInstance = companion.values.toList.head

  // Simply it gets the first constant available.
  override protected def getJavaClassInstance = javaEnumConstants.iterator.next

  /////////////////
  // TESTS - BEGIN 
  /////////////////

  it should "declare all public declared methods of " + javaClass.getName in {
    compareDeclaredMethods(javaClass, scalaClass)
  }

  it should "presents all constants from its original JavaFX class" in {
    val diff = javaEnumConstants -- companion.values.map(_.delegate)

    assert(diff.isEmpty, "Missing constants: " + diff.mkString(", "))
  }

  it should "generate all ScalaFX enums from JavaFX enums names" in {
    val missingJavaEnumNames = javaEnumConstants.map(_.name).filterNot(nameIsPresent(_))

    assert(missingJavaEnumNames.isEmpty, "Missing constants: " + missingJavaEnumNames.mkString(", "))
  }

  it should "not find a non registered name among enum constants" in {
    intercept[IllegalArgumentException] {
      companion("!@#$%")
    }
  }

  it should "throw `IllegalArgumentException` if the argument is `null`" in {
    intercept[IllegalArgumentException] {
      companion(null)
    }
  }

  it should "presents its values at same order as its JavaFX enum ordinal" in {
    companion.values.zipWithIndex.foreach({case (s, i) => assertScalaEnumWithOrdinal(s, i)})
  }

  ///////////////
  // TESTS - END 
  ///////////////

}