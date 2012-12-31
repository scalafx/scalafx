/*
 * Copyright (c) 2011, ScalaFX Project
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
import scalafx.util.SFXDelegate

object ObjectProperty {
  implicit def sfxObjectProperty2jfx[J <: AnyRef](op: ObjectProperty[J]) = op.delegate

  /**
   * Creates a new ObjectProperty instance using the SimpleObjectProperty as the target.
   *
   * @param value the initial value
   * @return      the observable instance
   */
 def apply[J <: AnyRef](value: J) = new ObjectProperty[J](new jfxbp.SimpleObjectProperty[J](value))

  /** Prototype solution to Issue 14 [[http://code.google.com/p/scalafx/issues/detail?id=14]].
    *
    * There is a problem if an object property contains a ScalaFX wrapper and one attempts to bind it to a
    * JavaFX ObjectProperty containing a corresponding delegate.  See example of that that is provided with Issue 14.
    *
    * The approach here is to create jfxbp.ObjectProperty delegate that holds the delegate of the ScalaFX value
    * rather than value itself. This enables correct binging, and current implicit conversions should handle places
    * where the value is used as ScalaFX wrapper.
    */
  def create[J <: AnyRef](bean: Object, name: String, initialValue: SFXDelegate[J]) =
    new ObjectProperty[J](new jfxbp.SimpleObjectProperty[J](bean, name, initialValue.delegate))
}

class ObjectProperty[J <: AnyRef](override val delegate: jfxbp.ObjectProperty[J] = new jfxbp.SimpleObjectProperty[J])
  extends ReadOnlyObjectProperty[J](delegate)
  with Property[J, J]
  with SFXDelegate[jfxbp.ObjectProperty[J]] {

  def this(bean: Object, name: String) = this(new jfxbp.SimpleObjectProperty[J](bean, name))

  def this(bean: Object, name: String, initialValue: J) =
    this(new jfxbp.SimpleObjectProperty[J](bean, name, initialValue))

  def value_=(v: J) {
    delegate.set(v)
  }
}
