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

import scalafx.beans.property.Property.when
import javafx.beans.binding.When
import javafx.beans.value.{ObservableBooleanValue, ObservableValue}

object Property {
  case class when[T](ov:ObservableBooleanValue) {
    var _then:T = _
    def then(v:T) = {
      _then = v
      this
    }
    var _else:T = _
    def otherwise(v:T) = {
      _else = v
      this
    }
  }
}

abstract class Property[T](val wrappedProperty:javafx.beans.property.Property[T]) extends ReadOnlyProperty[T](wrappedProperty) {
  def value_=(v:T) {
    wrappedProperty.setValue(v)
  }

  def update(v:T) {
    value_=(v)
  }

  def bind(v:ObservableValue[_ <: T]) {
    wrappedProperty.bind(v)
  }

  def bind(t:when[_ <: T]) {
    wrappedProperty.bind(new When(t.ov).then(t._then).otherwise(t._else))
  }

  def unbind() {
    wrappedProperty.unbind()
  }

  def bibind(v:Property[T]) {
    wrappedProperty.bindBidirectional(v.wrappedProperty)
  }

  def biunbind(v:Property[T]) {
    wrappedProperty.unbindBidirectional(v.wrappedProperty)
  }
}
