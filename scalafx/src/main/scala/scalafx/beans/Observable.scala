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
package scalafx.beans

import javafx.beans as jfxb
import scalafx.delegate.SFXDelegate
import scalafx.event.subscriptions.Subscription

import scala.language.implicitConversions

object Observable {
  implicit def sfxObservable2jfx(o: Observable): jfxb.Observable = if (o != null) o.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/Observable.html `Observable`]].
 *
 * @define JFX JavaFX
 * @define IV `InvalidationListener`
 * @define IVURL [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/InvalidationListener.html `InvalidationListener`]]
 * @define SUBRET A new [[scalafx.event.subscriptions.Subscription]] to remove $JFX $IV.
 */
trait Observable extends SFXDelegate[jfxb.Observable] {

  /**
   * Adds a function as a $JFX $IVURL. This function has all arguments from
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/InvalidationListener.html#invalidated(javafx.beans.Observable) `invalidated`]]
   * method from $IV.
   *
   * @param op Function that receives a ScalaFX `Observable`. It will be called when value was invalidated.
   * @return $SUBRET
   */
  def onInvalidate(op: Observable => Unit): Subscription = {
    val listener = new jfxb.InvalidationListener {
      def invalidated(observable: jfxb.Observable): Unit = {
        op(Observable.this)
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel(): Unit = {
        delegate.removeListener(listener)
      }
    }
  }

  /**
   * Adds a no argument function as a $JFX $IVURL. This function has no arguments because it will not handle
   * invalidated values.
   *
   * @param op A Function with no arguments. It will be called when value was invalidated.
   * @return $SUBRET
   */
  def onInvalidate(op: => Unit): Subscription = {
    val listener = new jfxb.InvalidationListener {
      def invalidated(observable: jfxb.Observable): Unit = {
        op
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel(): Unit = {
        delegate.removeListener(listener)
      }
    }
  }
}
