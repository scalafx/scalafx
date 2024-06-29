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
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object IntegerProperty {
  implicit def sfxIntegerProperty2jfx(ip: IntegerProperty): jfxbp.IntegerProperty =
    if (ip != null) ip.delegate else null

  /**
   * Creates a new IntegerProperty instance using the SimpleIntegerProperty as the target.
   *
   * @param value the initial value
   * @return      the observable instance
   */
  def apply(value: Int) = new IntegerProperty(new jfxbp.SimpleIntegerProperty(value))
}

class IntegerProperty(override val delegate: jfxbp.IntegerProperty = new jfxbp.SimpleIntegerProperty)
    extends ReadOnlyIntegerProperty(delegate)
    with Property[Int, Number]
    with SFXDelegate[jfxbp.IntegerProperty] {

  def this(bean: Object, name: String) = this(new jfxbp.SimpleIntegerProperty(bean, name))

  def this(bean: Object, name: String, initialValue: Int) =
    this(new jfxbp.SimpleIntegerProperty(bean, name, initialValue))

  def value_=(v: Int): Unit = {
    delegate.set(v)
  }

  def value_=(v: Number): Unit = {
    delegate.set(v.intValue)
  }
}
