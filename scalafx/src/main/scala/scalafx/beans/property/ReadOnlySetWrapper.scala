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

package scalafx.beans.property

import javafx.beans.{property => jfxbp}

import scala.language.implicitConversions
import scalafx.beans.property.PropertyIncludes.jfxReadOnlySetProperty2sfx
import scalafx.collections.ObservableSet
import scalafx.delegate.SFXDelegate

object ReadOnlySetWrapper {

  /**
   * Converts a ScalaFX ReadOnlySetWrapper to its JavaFX counterpart ReadOnlySetWrapper.
   *
   * @param v ScalaFX ReadOnlySetWrapper
   * @return JavaFX ReadOnlySetWrapper
   */
  implicit def sfxReadOnlySetWrapper2jfx[E <: Any](v: ReadOnlySetWrapper[E]): jfxbp.ReadOnlySetWrapper[E] =
    if (v != null) v.delegate else null

  /**
   * Creates a new ReadOnlySetWrapper instance.
   *
   * @param value the initial value of the wrapped value
   */
  def apply[E <: Any](value: ObservableSet[E]) = new ReadOnlySetWrapper(new jfxbp.ReadOnlySetWrapper(value))

  /**
   * Creates a new ReadOnlySetWrapper.
   *
   * @param bean the bean of this SetProperty
   * @param name the name of this SetProperty
   */
  def apply[E <: Any](bean: Any, name: String) =
    new ReadOnlySetWrapper(new jfxbp.ReadOnlySetWrapper[E](bean, name))

  /**
   * Creates a new ReadOnlySetWrapper.
   *
   * @param bean  the bean of this SetProperty
   * @param name  the name of this SetProperty
   * @param value the initial value
   */
  def apply[E <: Any](bean: Any, name: String, value: ObservableSet[E]) =
    new ReadOnlySetWrapper(new jfxbp.ReadOnlySetWrapper(bean, name, value.delegate))
}

/**
 * Wraps `javafx.beans.property.ReadOnlySetWrapper`.
 */
class ReadOnlySetWrapper[E <: Any](override val delegate: jfxbp.ReadOnlySetWrapper[E] = new jfxbp.ReadOnlySetWrapper[E])
    extends SetProperty[E](delegate)
    with SFXDelegate[jfxbp.ReadOnlySetWrapper[E]] {

  /**
   * Creates a new ReadOnlySetWrapper instance.
   *
   * @param value the initial value of the wrapped value
   */
  def this(value: ObservableSet[E]) =
    this(new jfxbp.ReadOnlySetWrapper[E](value))

  /**
   * Creates a new ReadOnlySetWrapper.
   *
   * @param bean the bean of this SetProperty
   * @param name the name of this SetProperty
   */
  def this(bean: Any, name: String) =
    this(new jfxbp.ReadOnlySetWrapper[E](bean, name))

  /**
   * Creates a new ReadOnlySetWrapper.
   *
   * @param bean  the bean of this SetProperty
   * @param name  the name of this SetProperty
   * @param value the initial value
   */
  def this(bean: Any, name: String, value: ObservableSet[E]) =
    this(new jfxbp.ReadOnlySetWrapper[E](bean, name, value))

  /**
   * Returns the readonly property, that is synchronized with this ReadOnlySetWrapper.
   *
   * @return the readonly property
   */
  def readOnlyProperty: ReadOnlySetProperty[E] = delegate.getReadOnlyProperty
}
