/*
 * Copyright (c) 2011-2019, ScalaFX Project
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
package scalafx.concurrent

import javafx.{concurrent => jfxc, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object ScheduledService {
  implicit def sfxScheduledService2jfx[T](s: ScheduledService[T]): jfxc.ScheduledService[T] = if (s != null) s.delegate else null

  /**
   * A Callback implementation for the <code>backoffStrategy</code> property which
   * will exponentially backoff the period between re-executions in the case of
   * a failure. This computation takes the original period and the number of
   * consecutive failures and computes the backoff amount from that information.
   *
   * It delegates to JavaFX
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/ScheduledService.html#EXPONENTIAL_BACKOFF_STRATEGY EXPONENTIAL_BACKOFF_STRATEGY]]
   */
  val ExponentialBackoffStrategy = jfxc.ScheduledService.EXPONENTIAL_BACKOFF_STRATEGY

  /**
   * A Callback implementation for the <code>backoffStrategy</code> property which
   * will logarithmically backoff the period between re-executions in the case of
   * a failure. This computation takes the original period and the number of
   * consecutive failures and computes the backoff amount from that information.
   *
   * It delegates to JavaFX
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/ScheduledService.html#LOGARITHMIC_BACKOFF_STRATEGY LOGARITHMIC_BACKOFF_STRATEGY]]
   */
  val LogarithmicBackoffStrategy = jfxc.ScheduledService.LOGARITHMIC_BACKOFF_STRATEGY

  /**
   * A Callback implementation for the <code>backoffStrategy</code> property which
   * will linearly backoff the period between re-executions in the case of
   * a failure. This computation takes the original period and the number of
   * consecutive failures and computes the backoff amount from that information.
   *
   * It delegates to JavaFX
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/ScheduledService.html#LINEAR_BACKOFF_STRATEGY LINEAR_BACKOFF_STRATEGY]]
   */
  val LinearBackoffStrategy = jfxc.ScheduledService.LINEAR_BACKOFF_STRATEGY

  /**
   * Create a new [[scalafx.concurrent.ScheduledService]] with a operation to be invoked after this was started on the JavaFX
   * Application Thread.
   *
   * @param op [[scala.Function]] that returns a [[scalafx.concurrent.Task]] to be invoked after this was started on
   *           the JavaFX Application Thread.
   */
  def apply[T](op: => jfxc.Task[T]) = new ScheduledService[T](new jfxc.ScheduledService[T] {
    protected def createTask = op
  }) {}
}

/**
 * Wrapper class for [[http://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/ScheduledService.html ScheduledService]]
 * Class.
 */
abstract class ScheduledService[T](override val delegate: jfxc.ScheduledService[T])
  extends Service[T](delegate)
  with SFXDelegate[jfxc.ScheduledService[T]] {

  /**
   * The initial delay between when the ScheduledService is first started, and when it will begin
   * operation.
   */
  def delay: ObjectProperty[jfxu.Duration] = delegate.delayProperty

  def delay_=(v: jfxu.Duration): Unit = {
    delay() = v
  }

  /**
   * The maximum allowed value for the cumulativePeriod.
   */
  def maximumCumulativePeriod: ObjectProperty[jfxu.Duration] = delegate.maximumCumulativePeriodProperty

  def maximumCumulativePeriod_=(v: jfxu.Duration): Unit = {
    maximumCumulativePeriod() = v
  }

  /**
   * Indicates whether the ScheduledService should automatically restart in the case of a failure in the Task.
   */
  def restartOnFailure: BooleanProperty = delegate.restartOnFailureProperty

  def restartOnFailure_=(v: Boolean): Unit = {
    restartOnFailure() = v
  }

  /**
   * The last successfully computed value.
   */
  def lastValue: ReadOnlyObjectProperty[T] = delegate.lastValueProperty

  /**
   * The current cumulative period in use between iterations.
   */
  def cumulativePeriod: ReadOnlyObjectProperty[jfxu.Duration] = delegate.cumulativePeriodProperty

  /**
   * The current number of times the ScheduledService has failed.
   */
  def currentFailureCount: ReadOnlyIntegerProperty = delegate.currentFailureCountProperty

  /**
   * The maximum number of times the ScheduledService can fail before it simply ends in the FAILED
   * state.
   */
  def maximumFailureCount: IntegerProperty = delegate.maximumFailureCountProperty

  def maximumFailureCount_=(v: Int): Unit = {
    maximumFailureCount() = v
  }

  /**
   * The minimum amount of time to allow between the start of the last run and the start of the next run.
   */
  def period: ObjectProperty[jfxu.Duration] = delegate.periodProperty

  def period_=(v: jfxu.Duration): Unit = {
    period() = v
  }

  /**
   * Computes the amount of time to add to the period on each failure.
   */
  def backoffStrategy: ObjectProperty[jfxu.Callback[jfxc.ScheduledService[_], jfxu.Duration]] = delegate.backoffStrategyProperty

  def backoffStrategy_=(v: jfxu.Callback[jfxc.ScheduledService[_], jfxu.Duration]): Unit = {
    backoffStrategy() = v
  }
}
