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
import javafx.{collections => jfxc}

import scala.language.implicitConversions
import scalafx.collections.ObservableSet
import scalafx.delegate.SFXDelegate

object SetProperty {

  /**
   * Converts a ScalaFX SetProperty to its JavaFX counterpart SetProperty.
   *
   * @param v ScalaFX SetProperty
   * @return JavaFX SetProperty
   */
  implicit def sfxSetProperty2jfx[E <: Any](v: SetProperty[E]): jfxbp.SetProperty[E] =
    if (v != null) v.delegate else null

  /**
   * Creates a new SetProperty instance using the ObservableSet as the value.
   *
   * @param value the initial value
   */
  def apply[E <: Any](value: ObservableSet[E]) =
    new SetProperty(new jfxbp.SimpleSetProperty(value.delegate))

  /**
   * Creates a new SetProperty instance.
   *
   * @param bean the bean of this SetProperty
   * @param name the name of this SetProperty
   */
  def apply[E <: Any](bean: Any, name: String) =
    new SetProperty(new jfxbp.SimpleSetProperty[E](bean, name))

  /**
   * Creates a new SetProperty instance.
   *
   * @param bean  the bean of this SetProperty
   * @param name  the name of this SetProperty
   * @param value the initial value
   */
  def apply[E <: Any](bean: Any, name: String, value: ObservableSet[E]) =
    new SetProperty(new jfxbp.SimpleSetProperty(bean, name, value.delegate))
}

/**
 * Wraps a $JFX $URL0 SetProperty]].
 *
 * @define TC          SetProperty
 * @define URL0        [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/SetProperty.html
 * @define JFX         JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class SetProperty[E <: Any](override val delegate: jfxbp.SetProperty[E] = new jfxbp.SimpleSetProperty[E])
    extends ReadOnlySetProperty[E](delegate)
    with Property[ObservableSet[E], jfxc.ObservableSet[E]]
    with SFXDelegate[jfxbp.SetProperty[E]] {

  /**
   * The constructor of SetProperty
   *
   * @param value the initial value of the wrapped value
   */
  def this(value: ObservableSet[E]) =
    this(new jfxbp.SimpleSetProperty(value.delegate))

  /**
   * The constructor of SetProperty
   *
   * @param bean the bean of this SetProperty
   * @param name the name of this SetProperty
   */
  def this(bean: Any, name: String) =
    this(new jfxbp.SimpleSetProperty[E](bean, name))

  /**
   * The constructor of SetProperty
   *
   * @param bean  the bean of this SetProperty
   * @param name  the name of this SetProperty
   * @param value the initial value of the wrapped value
   */
  def this(bean: Any, name: String, value: ObservableSet[E]) =
    this(new jfxbp.SimpleSetProperty(bean, name, value.delegate))

  /**
   * Set the wrapped value.
   *
   * @param v The new value
   */
  override def value_=(v: ObservableSet[E]): Unit = delegate.setValue(v)
}
