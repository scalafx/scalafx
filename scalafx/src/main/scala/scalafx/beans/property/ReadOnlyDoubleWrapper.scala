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

package scalafx.beans.property

import javafx.beans.property as jfxbp
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object ReadOnlyDoubleWrapper {
  implicit def sfxReadOnlyDoubleWrapper2jfx(w: ReadOnlyDoubleWrapper): jfxbp.ReadOnlyDoubleWrapper =
    if (w != null) w.delegate else null

  /**
   * Creates a new ReadOnlyDoubleWrapper instance.
   * @param value the initial value of the wrapped value
   */
  def apply(value: Double) = new ReadOnlyDoubleWrapper(new jfxbp.ReadOnlyDoubleWrapper(value))
}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyDoubleWrapper.html javafx.beans.property.ReadOnlyDoubleWrapper]] */
class ReadOnlyDoubleWrapper(override val delegate: jfxbp.ReadOnlyDoubleWrapper = new jfxbp.ReadOnlyDoubleWrapper())
    extends DoubleProperty(delegate)
    with SFXDelegate[jfxbp.ReadOnlyDoubleWrapper] {

  /**
   * Creates a new ReadOnlyDoubleWrapper instance.
   * @param bean the bean of this ReadOnlyDoubleWrapper
   * @param name the name of this ReadOnlyDoubleWrapper
   */
  def this(bean: Object, name: String) = this(new jfxbp.ReadOnlyDoubleWrapper(bean, name))

  /**
   * Creates a new ReadOnlyDoubleWrapper instance.
   * @param value the initial value of the wrapped value
   * @param bean the bean of this ReadOnlyDoubleWrapper
   * @param name the name of this ReadOnlyDoubleWrapper
   */
  def this(bean: Object, name: String, value: Double) = this(new jfxbp.ReadOnlyDoubleWrapper(bean, name, value))

  /** The read-only property, that is synchronized with this ReadOnlyDoubleWrapper. */
  def readOnlyProperty: ReadOnlyDoubleProperty = delegate.getReadOnlyProperty
}
