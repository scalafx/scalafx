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
package scalafx.beans.property

import javafx.beans.{property => jfxbp}
import scalafx.delegate.SFXDelegate

/** Factory for [[scalafx.beans.property.ObjectProperty]] instances. */
object ObjectProperty {
  implicit def sfxObjectProperty2jfx[T <: Any](op: ObjectProperty[T]) = op.delegate

  /** Creates a new ObjectProperty.
    *
    * @param initialValue the initial value.
    */
  def apply[T <: Any](initialValue: T) = new ObjectProperty[T](new jfxbp.SimpleObjectProperty[T](initialValue))

  /** Creates a new ObjectProperty.
    *
    * Special case when value is an ScalaFX wrapper, to be used as a work around for Issue 14.
    * Created object property will have value type of the wrapped JavaFX type to simplify use with binding.
    *
    * @param value the initial value.
    * @tparam J the JavaFX type of the value hold by this object property.
    */
  def apply[J <: Object](value: SFXDelegate[J]): ObjectProperty[J] =
    new ObjectProperty[J](new jfxbp.SimpleObjectProperty[J](value.delegate))

  /** Creates a new ObjectProperty.
    *
    * @param bean - the bean of this ObjectProperty
    * @param name - the name of this ObjectProperty
    */
  def apply[T <: Any](bean: Object, name: String): ObjectProperty[T] =
    new ObjectProperty(new jfxbp.SimpleObjectProperty[T](bean, name))


  /** Creates a new ObjectProperty.
    *
    * @param bean - the bean of this ObjectProperty
    * @param name - the name of this ObjectProperty
    * @param initialValue - the initial value of the wrapped value
    */
  def apply[T <: Any](bean: Object, name: String, initialValue: T): ObjectProperty[T] =
    new ObjectProperty(new jfxbp.SimpleObjectProperty[T](bean, name, initialValue))

  /** Creates a new ObjectProperty.
    *
    * Special case when value is an ScalaFX wrapper, to be used as a work around for Issue 14.
    * Created object property will have value type of the wrapped JavaFX type to simplify use with binding.
    *
    * @param bean - the bean of this ObjectProperty
    * @param name - the name of this ObjectProperty
    * @param initialValue - the initial value of the wrapped value
    * @tparam J the JavaFX type of the value hold by this object property.
    */
  def apply[J <: Object](bean: Object, name: String, initialValue: SFXDelegate[J]): ObjectProperty[J] =
    new ObjectProperty(new jfxbp.SimpleObjectProperty[J](bean, name, initialValue.delegate))
}

/**
 * This class provides a full implementation of a Property wrapping an arbitrary Object.
 *
 * It is recommended, as a work around for Issue 14, to use companion object factory methods to construct new instances,
 * instead of using constructor directly, especially when an inatial value is a ScalaFX wrapper, for instance:
 *
 * {{{
 *   import scalafx.scene.Cursor
 *   ...
 *   val p = ObjectProperty(Cursor.WAIT)
 * }}}
 * This assumes that will not provide property type but let Scala compiler infer correct one.
 */
class ObjectProperty[T <: Any](override val delegate: jfxbp.ObjectProperty[T] = new jfxbp.SimpleObjectProperty[T])
  extends ReadOnlyObjectProperty[T](delegate)
  with Property[T, T]
  with SFXDelegate[jfxbp.ObjectProperty[T]] {

  def this(bean: Object, name: String) = this(new jfxbp.SimpleObjectProperty[T](bean, name))

  def this(bean: Object, name: String, initialValue: T) =
    this(new jfxbp.SimpleObjectProperty[T](bean, name, initialValue))

  def value_=(v: T) {
    delegate.set(v)
  }
}
