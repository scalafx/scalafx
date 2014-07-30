/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import scala.language.implicitConversions
import javafx.beans.{ property => jfxbp }
import scalafx.delegate.SFXDelegate

object LongProperty {
  implicit def sfxLongProperty2jfx(lp: LongProperty) = lp.delegate

  /**
   * Creates a new LongProperty instance using the SimpleLongProperty as the target.
   * 
   * @param value the initial value
   * @return      the observable instance
   */
  def apply(value: Long) = new LongProperty(new jfxbp.SimpleLongProperty(value))
}

class LongProperty(override val delegate: jfxbp.LongProperty = new jfxbp.SimpleLongProperty)
  extends ReadOnlyLongProperty(delegate)
  with Property[Long, Number]
  with SFXDelegate[jfxbp.LongProperty] {

  def this(bean: Object, name: String) = this(new jfxbp.SimpleLongProperty(bean, name))

  def this(bean: Object, name: String, initialValue: Long) =
    this(new jfxbp.SimpleLongProperty(bean, name, initialValue))

  def value_=(v: Long) {
    delegate.set(v)
  }
  def value_=(v: Number) {
    delegate.set(v.longValue)
  }
}
