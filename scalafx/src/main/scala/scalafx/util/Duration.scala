/*
 * Copyright (c) 2011-2013, ScalaFX Project
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
package scalafx.util

import javafx.{util => jfxu}
import scalafx.delegate.SFXDelegate

object Duration {
  implicit def sfxDuration2jfx(d: Duration) = d.delegate

  def apply(millis: Double) = jfxu.Duration.millis(millis)

  private[util] class DurationHelper(d: Double) {
    def ms = apply(d)
    def s = jfxu.Duration.seconds(d)
    def m = jfxu.Duration.minutes(d)
    def h = jfxu.Duration.hours(d)
  }

  def INDEFINITE = jfxu.Duration.INDEFINITE
  def ONE = jfxu.Duration.ONE
  def UNKNOWN = jfxu.Duration.UNKNOWN
  def ZERO = jfxu.Duration.ZERO
}

class Duration(override val delegate: jfxu.Duration) extends SFXDelegate[jfxu.Duration] with Ordered[Duration] {
  def +(d: jfxu.Duration) = delegate.add(d)
  def -(d: jfxu.Duration) = delegate.subtract(d)

  def *(d: Double) = delegate.multiply(d)
  // Note: We are intentionally *not* supporting this...  there is no use case for multiplication with disregard to units
  // def *(d: jfxu.Duration) = delegate.multiply(d)

  def /(d: Double) = delegate.divide(d)
  // Note: This is a "fixed" function...  rather than returning a duration we properly cancel units and return a Double
  def /(d: jfxu.Duration) = delegate.toMillis / d.toMillis

  override def compare(that: Duration) = delegate.compareTo(that)
  def <(d: jfxu.Duration) = delegate.lessThan(d)
  def <=(d: jfxu.Duration) = delegate.lessThanOrEqualTo(d)
  def >(d: jfxu.Duration) = delegate.greaterThan(d)
  def >=(d: jfxu.Duration) = delegate.greaterThanOrEqualTo(d)

  def ==(d: jfxu.Duration) = delegate.equals(d)
  def !=(d: jfxu.Duration) = !delegate.equals(d)
  def ===(d: jfxu.Duration) = delegate.equals(d)
  def =!=(d: jfxu.Duration) = !delegate.equals(d)

  def unary_-() = delegate.negate()
}
