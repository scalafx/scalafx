/*
 * Copyright (c) 2012-2013, ScalaFX Project
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
package scalafx.beans.property

import javafx.beans.{property => jfxbp}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate


object ReadOnlyObjectWrapper {
  implicit def sfxReadOnlyObjectWrapper2jfx[T <: Any](roow: ReadOnlyObjectWrapper[T]) = roow.delegate

  /** Creates a new ReadOnlyObjectWrapper instance with a given initial wrapped value. */
  def apply[T <: Any](value: T): ReadOnlyObjectWrapper[T] =
    new ReadOnlyObjectWrapper[T](new jfxbp.ReadOnlyObjectWrapper[T](value))

  /** Creates a new ReadOnlyObjectWrapper instance with a given initial wrapped value.
    *
    * @param bean The bean of this ReadOnlyObjectWrapper
    * @param name The name of this ReadOnlyObjectWrapper
    * @param value the initial value.
    * @tparam T type of the value hold by this object property.
    */
  def apply[T <: Any](bean: Object, name: String, value: T): ReadOnlyObjectWrapper[T] =
    new ReadOnlyObjectWrapper[T](bean, name, value)

  /** Creates a new ReadOnlyObjectWrapper with a `delegate` as initial value.
    *
    * Special case when value is an ScalaFX wrapper, to be used as a work around for
    * [[https://code.google.com/p/scalafx/issues/detail?id=14 Issue 14]]. Created object property will have value type
    * of the wrapped JavaFX type to simplify use with binding.
    *
    * @param value the initial value, `value.delegate` is actually stored in this property.
    * @tparam J the JavaFX type of the value hold by this object property.
    */
  def apply[J <: Object](value: SFXDelegate[J]): ReadOnlyObjectWrapper[J] =
    new ReadOnlyObjectWrapper[J](new jfxbp.ReadOnlyObjectWrapper[J](value.delegate))

  /** Creates a new ReadOnlyObjectWrapper with a [[scalafx.delegate.SFXDelegate]] as initial value.
    *
    * Special case when value is an ScalaFX wrapper, to be used as a work around for
    * [[https://code.google.com/p/scalafx/issues/detail?id=14 Issue 14]]. Created object property will have value type
    * of the wrapped JavaFX type to simplify use with binding.
    *
    * @param bean The bean of this ReadOnlyObjectWrapper
    * @param name The name of this ReadOnlyObjectWrapper
    * @param value the initial value.
    * @tparam J the JavaFX type of the value hold by this object property.
    */
  def apply[J <: Object](bean: Object, name: String, value: SFXDelegate[J]): ReadOnlyObjectWrapper[J] =
    new ReadOnlyObjectWrapper[J](bean, name, value.delegate)
}


/** Wrapper for [[javafx.beans.property.ReadOnlyObjectWrapper]] */
class ReadOnlyObjectWrapper[T <: Any](override val delegate: jfxbp.ReadOnlyObjectWrapper[T])
  extends ObjectProperty[T](delegate)
  with SFXDelegate[jfxbp.ReadOnlyObjectWrapper[T]] {

  /** Creates a new ReadOnlyObjectWrapper instance.
    * @param bean the bean of this ReadOnlyObjectWrapper
    * @param name the name of this ReadOnlyObjectWrapper
    */
  def this(bean: Object, name: String) = this(new jfxbp.ReadOnlyObjectWrapper[T](bean, name))

  /** Creates a new ReadOnlyObjectWrapper instance.
    * @param bean the bean of this ReadOnlyObjectWrapper
    * @param name the name of this ReadOnlyObjectWrapper
    */
  def this(bean: Object, name: String, initialValue: T) =
    this(new jfxbp.ReadOnlyObjectWrapper[T](bean, name, initialValue))

  /** The read-only property, that is synchronized with this ReadOnlyObjectWrapper. */
  def readOnlyProperty: ReadOnlyObjectProperty[T] = delegate.getReadOnlyProperty
}
