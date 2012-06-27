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
import scalafx.beans.property.ObjectProperty
import scalafx.util.Duration.DurationHelper

object UtilIncludes extends UtilIncludes

trait UtilIncludes {
  /**
   * Convert a Callback JavaFX to a Function1.
   */
  implicit def jfxCallbackToFunction1[P, R](c: jfxu.Callback[P, R]) = (param: P) => c.call(param)
  /**
   * Convert a Function1 to a Callback JavaFX.
   */
  implicit def function12jfxCallback[P, R](f: Function1[P, R]) = new jfxu.Callback[P, R] {
    def call(param: P) = f(param)
  }
  /**
   * Convert a Pair JavaFX to a Tuple2.
   */
  implicit def jfxPair2Tuple2[K, V](p: jfxu.Pair[K, V]) = (p.getKey(), p.getValue())
  /**
   * Convert a Tuple2 to a Pair JavaFX.
   */
  implicit def tuple22jfxPair[K, V](t: (K, V)) = new jfxu.Pair[K, V](t._1, t._2)
  implicit def double2DurationHelper(d: Double) = new DurationHelper(d)
  implicit def jfxDuration2sfx(d: jfxu.Duration) = new Duration(d)
  /**
   * Converts a [[javafx.util.StringConverter JavaFX StringConverter]] to its 
   * ScalaFX version. 
   */
  implicit def jfxStringConverter2sfx[T](c: jfxu.StringConverter[T]) = new StringConverter[T] {
    def fromString(string: String): T = c.fromString(string)
    def toString(t: T): String = c.toString(t)
  }
  /**
   * Converts a Scala's [[scalafx.beans.property.ObjectProperty]] that wraps a
   * [[SFXDelegate]] to a Java's [[javafx.beans.property.ObjectProperty]].
   *
   *  @tparam D Type wrapped by SFXDelegate
   *  @tparam S A SFXDelegate subtype that wraps D.
   *  @param obj ObjectProperty that a wraps Scala`s SFXDelegate
   *  @return A new Java's ObjectProperty
   */
  implicit def sfxObjectPropertyWithSFXDelegate2jfxObjectProperty[D <: Object, S <: SFXDelegate[D]](obj: ObjectProperty[S]): jfxbp.ObjectProperty[D] =
    new jfxbp.SimpleObjectProperty[D](obj.get.delegate)

}
