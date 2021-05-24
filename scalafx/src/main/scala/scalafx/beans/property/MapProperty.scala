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
import javafx.{collections => jfxc}

import scala.language.implicitConversions
import scalafx.collections.ObservableMap
import scalafx.delegate.SFXDelegate

object MapProperty {

  /**
   * Converts a ScalaFX MapProperty to its JavaFX counterpart MapProperty.
   *
   * @param v
   *   ScalaFX MapProperty
   * @return
   *   JavaFX MapProperty
   */
  implicit def sfxMapProperty2jfx[K, V](v: MapProperty[K, V]): jfxbp.MapProperty[K, V] =
    if (v != null) v.delegate else null

  /**
   * Creates a new MapProperty instance using the ObservableMap as the value.
   *
   * @param value
   *   the initial value
   */
  def apply[K, V](value: ObservableMap[K, V]) =
    new MapProperty(new jfxbp.SimpleMapProperty(value.delegate))

  /**
   * Creates a new MapProperty instance.
   *
   * @param bean
   *   the bean of this MapProperty
   * @param name
   *   the name of this MapProperty
   */
  def apply[K, V](bean: Any, name: String) =
    new MapProperty(new jfxbp.SimpleMapProperty[K, V](bean, name))

  /**
   * Creates a new MapProperty instance.
   *
   * @param bean
   *   the bean of this MapProperty
   * @param name
   *   the name of this MapProperty
   * @param value
   *   the initial value
   */
  def apply[K, V](bean: Any, name: String, value: ObservableMap[K, V]) =
    new MapProperty(new jfxbp.SimpleMapProperty(bean, name, value.delegate))
}

/**
 * Wraps a $JFX $URL0 MapProperty]].
 *
 * @define
 *   TC MapProperty
 * @define
 *   URL0
 *   [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/MapProperty.html@define JFX JavaFX @define ORIGINALDOC Original Documentation]].
 */
class MapProperty[K, V](override val delegate: jfxbp.MapProperty[K, V] = new jfxbp.SimpleMapProperty[K, V])
    extends ReadOnlyMapProperty[K, V](delegate)
    with Property[ObservableMap[K, V], jfxc.ObservableMap[K, V]]
    with SFXDelegate[jfxbp.MapProperty[K, V]] {

  /**
   * The constructor of MapProperty
   *
   * @param value
   *   the initial value of the wrapped value
   */
  def this(value: ObservableMap[K, V]) =
    this(new jfxbp.SimpleMapProperty(value.delegate))

  /**
   * The constructor of MapProperty
   *
   * @param bean
   *   the bean of this MapProperty
   * @param name
   *   the name of this MapProperty
   */
  def this(bean: Any, name: String) =
    this(new jfxbp.SimpleMapProperty[K, V](bean, name))

  /**
   * The constructor of MapProperty
   *
   * @param bean
   *   the bean of this MapProperty
   * @param name
   *   the name of this MapProperty
   * @param value
   *   the initial value of the wrapped value
   */
  def this(bean: Any, name: String, value: ObservableMap[K, V]) =
    this(new jfxbp.SimpleMapProperty(bean, name, value.delegate))

  /**
   * Set the wrapped value.
   *
   * @param v
   *   The new value
   */
  override def value_=(v: ObservableMap[K, V]): Unit = delegate.setValue(v)
}
