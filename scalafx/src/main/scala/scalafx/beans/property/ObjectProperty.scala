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

import javafx.beans.{ property => jfxbp }
import scalafx.delegate.SFXDelegate

/**
 *  Factory for `[[scalafx.beans.property.ObjectProperty]]` instances.
 *
 *  @define OP `ObjectProperty`
 *  @define ISSUE14 Special case when value is an ScalaFX wrapper, to be used as a work around for 
 *  [[https://code.google.com/p/scalafx/issues/detail?id=14 Issue 14]]. Created object property will have value type 
 *  of the wrapped JavaFX type to simplify use with binding.
 */
object ObjectProperty {
  
  /**
   * Implicit conversion from a ScalaFX's $OP to a JavaFX's
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ObjectProperty.html $OP]], extracting its delegate.
   * 
   * @param op ScalaFX's $OP 
   * @return JavaFX's $OP, extracted from op's delegate.
   */
  implicit def sfxObjectProperty2jfx[T <: Any](op: ObjectProperty[T]) = op.delegate

  /**
   * Creates a new $OP.
   *
   * @param initialValue the initial value.
   */
  def apply[T <: Any](initialValue: T) = new ObjectProperty[T](new jfxbp.SimpleObjectProperty[T](initialValue))

  /**
   * Creates a new $OP with a [[scalafx.delegate.SFXDelegate]] as initial value.
   * 
   * $ISSUE14
   *
   * @param value the initial value.
   * @tparam J the JavaFX type of the value hold by this object property.
   */
  def apply[J <: Object](value: SFXDelegate[J]): ObjectProperty[J] =
    new ObjectProperty[J](new jfxbp.SimpleObjectProperty[J](value.delegate))

  /**
   * Creates a new $OP with its reference bean and name.
   *
   * @param bean The bean of this $OP
   * @param name The name of this $OP
   */
  def apply[T <: Any](bean: Object, name: String): ObjectProperty[T] =
    new ObjectProperty(new jfxbp.SimpleObjectProperty[T](bean, name))

  /**
   * Creates a new $OP with with its reference bean and name and initial value.
   *
   * @param bean The bean of this $OP
   * @param name The name of this $OP
   * @param initialValue The initial value of the wrapped value
   */
  def apply[T <: Any](bean: Object, name: String, initialValue: T): ObjectProperty[T] =
    new ObjectProperty(new jfxbp.SimpleObjectProperty[T](bean, name, initialValue))

  /**
   * Creates a new $OP with with its reference bean and name and a [[scalafx.delegate.SFXDelegate]] as initial value.
   *
   * $ISSUE14
   *
   * @tparam J the JavaFX type of the value hold by this object property.
   * @param bean The bean of this $OP
   * @param name The name of this $OP
   * @param initialValue The initial value of the wrapped value
   */
  def apply[J <: Object](bean: Object, name: String, initialValue: SFXDelegate[J]): ObjectProperty[J] =
    new ObjectProperty(new jfxbp.SimpleObjectProperty[J](bean, name, initialValue.delegate))

  /**
   * Fills a $OP with a value, setting `null` to its delegate if value is `null`.
   *
   * @tparam J $OP type
   * @param property $OP to be filled.
   * @param value Value to be injected in $OP.
   */
  def fillProperty[J <: AnyRef](property: ObjectProperty[J], value: J) {
    if (value == null) {
      property.delegate.setValue(null.asInstanceOf[J])
    } else {
      property() = value
    }
  }
}

/**
 * This class provides a full implementation of a Property wrapping an arbitrary Object.
 *
 * It is recommended, as a work around for Issue 14, to use companion object factory methods to construct new instances,
 * instead of using constructor directly, especially when an initial value is a ScalaFX wrapper, for instance:
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
