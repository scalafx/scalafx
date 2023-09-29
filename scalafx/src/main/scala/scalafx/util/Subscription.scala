/*
 * Copyright (c) 2011-2023, ScalaFX Project
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

import javafx.util as jfxu
import scalafx.delegate.SFXDelegate
import scalafx.util.UtilIncludes.jfxSubscription2sfx

import scala.language.implicitConversions

//noinspection ScalaUnusedSymbol
object Subscription {
  implicit def sfxSubscription2jfx(s: Subscription): jfxu.Subscription = if (s != null) s.delegate else null

  /**
   * An empty subscription. Does nothing when cancelled.
   */
  val Empty: Subscription = jfxu.Subscription.EMPTY

  /**
   * Returns a `Subscription` which combines all of the given
   * subscriptions.
   *
   * @param subscriptions an array of subscriptions to combine, cannot be `null` or contain `null`
   * @return a `Subscription`, never `null`
   * @throws NullPointerException when `subscriptions` is `null` or contains `null`
   */
  def combine(subscriptions: Subscription*): Subscription =
    jfxu.Subscription.combine(subscriptions.map(_.delegate)*)
}

class Subscription(override val delegate: jfxu.Subscription) extends SFXDelegate[jfxu.Subscription] {

  /**
   * Combines this [[Subscription]] with the given `Subscription`
   * and returns a new `Subscription` which will cancel both when
   * cancelled.
   *
   * <p>This is equivalent to `Subscription.combine(this, other)`.
   *
   * @param other another `Subscription`, cannot be `null`
   * @return a combined `Subscription` which will cancel both when
   *         cancelled, never `null`
   * @throws NullPointerException when `other` is `null`
   */
  def and(other: Subscription): Subscription = delegate.and(other)
}
