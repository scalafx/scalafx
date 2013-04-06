/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

/**
 * Base trait for all Companion objects `SFXEnumDelegate` subclasses. It mirrors static methods for
 * [[http://docs.oracle.com/javase/7/docs/api/java/lang/Enum.html `Enum`]].
 *
 * @tparam E Original JavaFX `enum`
 * @tparam S `SFXEnumDelegate` that wrappers `E`
 */
trait SFXEnumDelegateCompanion[E <: java.lang.Enum[E], S <: SFXEnumDelegate[E]] {

  /**
   *  Converts a `SFXEnumDelegate` to its respective JavaFX `Enum`.
   *
   *  @param s `SFXEnumDelegate` instance
   *  @return Delegated `enum`
   */
  implicit def sfxEnum2jfx(s: S): E = s.delegate

  /**
   *  Converts a JavaFX `enum` to its respective `SFXEnumDelegate`. 
   *
   *  @param e JavaFX `enum`
   *  @return `[[scalafx.delegate.SFXEnumDelegate]]` equivalent to argument.
   */
  def jfxEnum2sfx(e: E): S = values.find(_.delegate == e).get

  /** Contain constants which will be source for `values` List  */
  protected def unsortedValues: Array[S]

  /** Returns a List containing the constants of this `enum` type, in the order they are declared. */
  lazy val values: List[S] = unsortedValues.sortWith(_.delegate.ordinal < _.delegate.ordinal).toList

  /**
   *  Returns the `enum` constant of this type with the specified name.
   *
   * @param name the name of the constant to return
   * @throws IllegalArgumentException If the specified `enum` type has no constant with the specified name, 
   * or the specified class object does not represent an `enum` type.
   */
  def apply(name: String) = values.find(_.name == name) match {
    case Some(e) => e
    case None    => throw new IllegalArgumentException("No enum constant %s.%s".format(values.head.getClass.getName, name))
  }

}
