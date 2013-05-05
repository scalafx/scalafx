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
package scalafx.util

import javafx.beans.{ property => jfxbp }
import javafx.{ util => jfxu }
import scalafx.delegate.SFXDelegate
import scalafx.util.Duration.DurationHelper

object UtilIncludes extends UtilIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/util/package-summary.html `javafx.util`]]
 * Classes to their ScalaFX counterparts.
 */
trait UtilIncludes {

  /**
   * Converts a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/util/Callback.html `Callback`]] to a Function1.
   *
   * @tparam P Callback parameter type
   * @tparam R Callback  return type.
   * @param c JavaFX Callback
   * @return A function would call Callback.
   */
  implicit def jfxCallbackToFunction1[P, R](c: jfxu.Callback[P, R]) = (param: P) => c.call(param)

  /**
   * Converts a Function1 to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/util/Callback.html `Callback`]].
   *
   * @tparam P Callback parameter type
   * @tparam R Callback  return type.
   * @param f ScalaFX Function
   * @return a JavaFX Callback that will call ScalaFX function.
   */
  implicit def function12jfxCallback[P, R](f: Function1[P, R]) = new jfxu.Callback[P, R] {
    def call(param: P) = f(param)
  }

  /**
   * Convert a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/util/Pair.html Pair]] in a Scala Tuple2.
   *
   * @tparam K Key Type
   * @tparam V Value Type
   * @param p JavaFX Pair
   * @return A Scala Tuple2 generated from Pair.
   */
  implicit def jfxPair2Tuple2[K, V](p: jfxu.Pair[K, V]) = (p.getKey, p.getValue)

  /**
   * Convert a Scala Tuple2 to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/util/Pair.html Pair]].
   *
   * @tparam K Key Type
   * @tparam V Value Type
   * @param t A Scala Tuple2
   * @return A JavaFX Pair generated from Scala Tuple2.
   */
  implicit def tuple22jfxPair[K, V](t: (K, V)) = new jfxu.Pair[K, V](t._1, t._2)

  /**
   * Converts a Double to a Duration.
   *
   * @param d Double to convert
   * @return A [[scalafx.util.DurationHelper]] from where it is possible create a new [[scalafx.util.Duration]] instance.
   */
  implicit def double2DurationHelper(d: Double) = new DurationHelper(d)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/util/Duration.html `javafx.util.Duration`]]
   * instance to its ScalaFX counterpart.
   *
   * @param d JavaFX Duration
   * @return ScalaFX Duration
   */
  implicit def jfxDuration2sfx(d: jfxu.Duration) = new Duration(d)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/util/StringConverter.html `javafx.util.StringConverter`]]
   * instance to its ScalaFX counterpart.
   *
   * @tparam T StringConverter Type
   * @param c JavaFX StringConverter
   * @return ScalaFX StringConverter
   */
  implicit def jfxStringConverter2sfx[T](c: jfxu.StringConverter[T]) = new StringConverter[T] {
    def fromString(string: String): T = c.fromString(string)
    def toString(t: T): String = c.toString(t)
  }

}
