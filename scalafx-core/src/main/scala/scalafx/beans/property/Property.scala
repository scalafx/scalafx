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

import javafx.beans.value.{ ObservableValue => JFXObservableValue }
import javafx.beans.{ property => jfxbp }
import scalafx.Includes._
import scalafx.beans.value.ObservableValue
import scalafx.delegate.SFXDelegate
import scalafx.animation.Tweenable

object Property {
  implicit def sfxProperty2jfx[T, J <: Any](p: Property[T, J]) = p.delegate
}

/**
 * Generic trait that defines the methods common to all (writable) properties independent of their
 * type.
 *
 * @tparam T Indicates Scala type that will be returned for this property.
 * @tparam J Indicates Java type to be wrapped by T. Eventually T and J could be the same.
 */
trait Property[@specialized(Int, Long, Float, Double, Boolean) T, J <: Any]
  extends ReadOnlyProperty[T, J]
  with SFXDelegate[jfxbp.Property[J]] {

  /**
   * Set the wrapped value.
   *
   * @param v The new value
   */
  def value_=(v: T)

  /**
   * Set the wrapped value.
   *
   * @param v The new value
   */
  def update(v: T) {
    value_=(v)
  }

  /**
   * Create a unidirection binding for this Property.
   *
   * @param v JavaFX ObservableValue this Property should be bound to.
   */
  def <==(v: JFXObservableValue[_ <: J]) {
    delegate.bind(v)
  }

  /**
   * Create a unidirection binding for this Property.
   *
   * @param v ScalaFX ObservableValue this Property should be bound to.
   */
  def <==(v: ObservableValue[_ <: T, _ <: J]) {
    delegate.bind(v.delegate)
  }

  /**
   * Create a bidirectional binding between this Property and another ScalaFX Property.
   *
   * @param  v the other ScalaFX Property
   */
  def <==>(v: Property[T, J]) {
    delegate.bindBidirectional(v.delegate)
  }

  /**
   * Create a bidirectional binding between this Property and another JavaFX Property.
   *
   * @param  v the other JavaFX Property
   */
  def <==>(v: jfxbp.Property[J]) {
    delegate.bindBidirectional(v)
  }

  /**
   * Remove the unidirectional binding for this Property. If the Property is not bound,
   * calling this method has no effect.
   */
  def unbind() {
    delegate.unbind()
  }

  /**
   * Remove a bidirectional binding between this Property and another ScalaFX one. If no
   * bidirectional binding between the properties exists, calling this method has no effect.
   *
   * @param v - the other Property
   */
  def unbind(v: Property[T, J]) {
    delegate.unbindBidirectional(v.delegate)
  }

  /**
   * Remove a bidirectional binding between this Property and another JavaFX one. If no
   * bidirectional binding between the properties exists, calling this method has no effect.
   *
   * @param v - the other Property
   */
  def unbind(v: jfxbp.Property[J]) {
    delegate.unbindBidirectional(v)
  }

  /**
   * Returns a new [[scalafx.animation.Tweenable Tweenable]] from a End Value.
   *
   *  @param endVal End Value
   *
   *  @return a new Tweenable with this Property and end value passed.
   */
  def ->(endVal: J) = new Tweenable[T, J](this, endVal)
}
