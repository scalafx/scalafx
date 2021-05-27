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
import scalafx.beans.binding.MapExpression
import scalafx.collections.CollectionIncludes.jfxObservableMap2sfxObservableMap
import scalafx.collections.ObservableMap
import scalafx.delegate.SFXDelegate

object ReadOnlyMapProperty {
  /**
    * Converts a ScalaFX ReadOnlyMapProperty to its JavaFX counterpart ReadOnlyMapProperty.
    *
    * @param v ScalaFX ReadOnlyMapProperty
    * @return JavaFX ReadOnlyMapProperty
    */
  implicit def sfxReadOnlyMapProperty2jfx[K, V](v: ReadOnlyMapProperty[K, V]): jfxbp.ReadOnlyMapProperty[K, V] =
    if (v != null) v.delegate else null
}

/**
  * Wraps a $JFX $URL0 ReadOnlyMapProperty]].
  *
  * @define TC          ReadOnlyMapProperty
  * @define URL0        [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyMapProperty.html
  * @define JFX         JavaFX
  * @define ORIGINALDOC Original Documentation]].
  **/
class ReadOnlyMapProperty[K, V](override val delegate: jfxbp.ReadOnlyMapProperty[K, V])
  extends MapExpression[K, V](delegate)
    with ReadOnlyProperty[ObservableMap[K, V], jfxc.ObservableMap[K, V]]
    with SFXDelegate[jfxbp.ReadOnlyMapProperty[K, V]] {


  override def value: ObservableMap[K, V] = delegate.get()

  /**
    * Creates a content binding between the ObservableMap, that is wrapped in this ReadOnlyMapProperty,
    * and another ObservableMap.
    *
    * A content binding ensures that the content of the wrapped ObservableMaps is the same as that of the other map.
    * If the content of the other map changes, the wrapped map will be updated automatically.
    * Once the wrapped map is bound to another map, you must not change it directly.
    *
    * @param map the ObservableMap this property should be bound to
    */
  def bindContent(map: ObservableMap[K, V]): Unit = delegate.bindContent(map.delegate)

  /**
    * Creates a bidirectional content binding of the ObservableMap, that is wrapped in this ReadOnlyMapProperty,
    * and another ObservableMap.
    *
    * A bidirectional content binding ensures that the content of two ObservableMaps is the same.
    * If the content of one of the maps changes, the other one will be updated automatically.
    *
    * @param map the ObservableMap this property should be bound to
    */
  def bindContentBidirectional(map: ObservableMap[K, V]): Unit = delegate.bindContentBidirectional(map.delegate)

  /**
    * Deletes a content binding between the ObservableMap, that is wrapped in this ReadOnlyMapProperty, and another Object.
    *
    * This is a helper method that calls the JavaFX counterpart with a delegate rather than the original object.
    *
    * @param sfx the SFXDelegate object to which the binding should be removed
    */
  def unbindContent[T <: Object](sfx: SFXDelegate[T]): Unit = delegate.unbindContent(sfx.delegate)

  /**
    * Deletes a bidirectional content binding between the ObservableMap, that is wrapped in this ReadOnlyMapProperty, and another Object.
    *
    * This is a helper method that calls the JavaFX counterpart with a delegate rather than the original object.
    *
    * @param sfx the SFXDelegate object to which the binding should be removed
    */
  def unbindContentBidirectional[T <: Object](sfx: SFXDelegate[T]): Unit = delegate.unbindContentBidirectional(sfx.delegate)
}
