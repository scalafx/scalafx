/*
 * Copyright (c) 2011-2017, ScalaFX Project
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

import scala.language.implicitConversions
import scalafx.beans.property.PropertyIncludes.jfxReadOnlyMapProperty2sfx
import scalafx.collections.ObservableMap
import scalafx.delegate.SFXDelegate

object ReadOnlyMapWrapper {

  /**
    * Converts a ScalaFX ReadOnlyMapWrapper to its JavaFX counterpart ReadOnlyMapWrapper.
    *
    * @param v ScalaFX ReadOnlyMapWrapper
    * @return JavaFX ReadOnlyMapWrapper
    */
  implicit def sfxReadOnlyMapWrapper2jfx[K, V](v: ReadOnlyMapWrapper[K, V]): jfxbp.ReadOnlyMapWrapper[K, V] =
    if (v != null) v.delegate else null

  /** Creates a new ReadOnlyMapWrapper instance.
    *
    * @param value the initial value of the wrapped value
    */
  def apply[K, V](value: ObservableMap[K, V]) = new ReadOnlyMapWrapper(new jfxbp.ReadOnlyMapWrapper(value))

  /**
    * Creates a new ReadOnlyMapWrapper.
    *
    * @param bean the bean of this MapProperty
    * @param name the name of this MapProperty
    */
  def apply[K, V](bean: Any, name: String) =
    new ReadOnlyMapWrapper(new jfxbp.ReadOnlyMapWrapper[K, V](bean, name))

  /**
    * Creates a new ReadOnlyMapWrapper.
    *
    * @param bean  the bean of this MapProperty
    * @param name  the name of this MapProperty
    * @param value the initial value
    */
  def apply[K, V](bean: Any, name: String, value: ObservableMap[K, V]) =
    new ReadOnlyMapWrapper(new jfxbp.ReadOnlyMapWrapper(bean, name, value.delegate))
}

/**
  * Wraps `javafx.beans.property.ReadOnlyMapWrapper`.
  */
class ReadOnlyMapWrapper[K, V](
    override val delegate: jfxbp.ReadOnlyMapWrapper[K, V] = new jfxbp.ReadOnlyMapWrapper[K, V]
) extends MapProperty[K, V]
    with SFXDelegate[jfxbp.ReadOnlyMapWrapper[K, V]] {

  /** Creates a new ReadOnlyMapWrapper instance.
    *
    * @param value the initial value of the wrapped value
    */
  def this(value: ObservableMap[K, V]) =
    this(new jfxbp.ReadOnlyMapWrapper[K, V](value))

  /**
    * Creates a new ReadOnlyMapWrapper.
    *
    * @param bean the bean of this MapProperty
    * @param name the name of this MapProperty
    */
  def this(bean: Any, name: String) =
    this(new jfxbp.ReadOnlyMapWrapper[K, V](bean, name))

  /**
    * Creates a new ReadOnlyMapWrapper.
    *
    * @param bean  the bean of this MapProperty
    * @param name  the name of this MapProperty
    * @param value the initial value
    */
  def this(bean: Any, name: String, value: ObservableMap[K, V]) =
    this(new jfxbp.ReadOnlyMapWrapper[K, V](bean, name, value))

  /**
    * Returns the readonly property, that is synchronized with this ReadOnlyMapWrapper.
    *
    * @return the readonly property
    */
  def readOnlyProperty: ReadOnlyMapProperty[K, V] = delegate.getReadOnlyProperty
}
