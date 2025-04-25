/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

package scalafx.beans.binding

import javafx.beans.binding as jfxbb
import scalafx.beans.binding.BindingIncludes.jfxBooleanBinding2sfx
import scalafx.beans.property.PropertyIncludes.{jfxReadOnlyBooleanProperty2sfx, jfxReadOnlyIntegerProperty2sfx}
import scalafx.beans.property.{ReadOnlyBooleanProperty, ReadOnlyIntegerProperty}
import scalafx.collections.ObservableMap

import scala.language.implicitConversions

object MapExpression {

  /**
   * Converts a ScalaFX MapExpression to its JavaFX counterpart MapProperty.
   *
   * @param v ScalaFX MapExpression
   * @return JavaFX MapExpression
   */
  implicit def sfxMapExpression2jfx[K, V](v: MapExpression[K, V]): jfxbb.MapExpression[K, V] =
    if (v != null) v.delegate else null
}

/**
 * Wraps a $JFX $URL0 $TC]].
 *
 * @define TC          MapExpression
 * @define URL0        [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/MapExpression.html
 * @define JFX         JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class MapExpression[K, V](val delegate: jfxbb.MapExpression[K, V]) {

  /**
   * A boolean property that is `true`, if the the map is empty.
   */
  def empty: ReadOnlyBooleanProperty = delegate.emptyProperty()

  /**
   * An integer property that represents the size of the map.
   */
  def size: ReadOnlyIntegerProperty = delegate.sizeProperty()

  /**
   * Optionally returns the value associated with a key.
   *
   * @param key the key value
   * @return an option value containing the value associated with key in this $MAP, or None if
   *         none exists.
   */
  def get(key: K): Option[V] = if (delegate.containsKey(key)) Option(delegate.get(key)) else None

  def +=(kv: (K, V)): V = delegate.put(kv._1, kv._2)

  def ++=(m: Map[K, V]): Unit = {
    import scalafx.util.JavaConverters.*
    delegate.putAll(m.asJava)
  }

  /**
   * Creates a new BooleanBinding that holds true if this map is equal to another ObservableMap.
   *
   * @param other the other ObservableMap
   * @return the new BooleanBinding
   */
  def isEqualTo(other: ObservableMap[_, _]): BooleanBinding = delegate.isEqualTo(other.delegate)

  /**
   * Creates a new BooleanBinding that holds true if this map is not equal to another ObservableMap.
   *
   * @param other the other ObservableMap
   * @return the new BooleanBinding
   */
  def isNotEqualTo(other: ObservableMap[_, _]): BooleanBinding = delegate.isNotEqualTo(other.delegate)

  def -=(key: Any): V = this.delegate.remove(key)

  def values(): Iterable[V] = {
    import scalafx.util.JavaConverters.*
    delegate.values().asScala
  }
}
