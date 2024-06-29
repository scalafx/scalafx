/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import javafx.beans.{binding => jfxbb}
import javafx.{collections => jfxc}

import scala.language.implicitConversions
import scalafx.beans.value.ObservableValue
import scalafx.collections.CollectionIncludes.jfxObservableMap2sfxObservableMap
import scalafx.collections.ObservableMap

object MapBinding {

  /**
   * Converts a ScalaFX MapBinding to its JavaFX counterpart LisBinding.
   *
   * @param v ScalaFX MapBinding
   * @return JavaFX MapBinding
   */
  implicit def sfxMapBinding2jfx[K, V](v: MapBinding[K, V]): jfxbb.MapBinding[K, V] =
    if (v != null) v.delegate else null
}

/**
 * Wraps a $JFX $URL0 MapBinding]].
 *
 * @define TC          MapBinding
 * @define URL0        [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/MapBinding.html
 * @define JFX         JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class MapBinding[K, V](override val delegate: jfxbb.MapBinding[K, V])
    extends MapExpression(delegate)
    with ObservableValue[ObservableMap[K, V], jfxc.ObservableMap[K, V]] {

  override def value: ObservableMap[K, V] = delegate.get
}
