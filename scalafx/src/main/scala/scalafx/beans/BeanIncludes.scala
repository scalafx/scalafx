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
package scalafx.beans

import javafx.beans.{value => jfxbv}
import javafx.{beans => jfxb}
import scalafx.beans.binding.BindingIncludes
import scalafx.beans.property.PropertyIncludes
import scalafx.beans.value.ObservableValue

import scala.language.implicitConversions

object BeanIncludes extends BeanIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/package-summary.html `javafx.beans`]] Classes to
 * their ScalaFX counterparts.
 */
trait BeanIncludes extends PropertyIncludes with BindingIncludes with LowerPriorityIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/package-summary.html `javafx.beans`]] Interfaces to
 * their ScalaFX counterparts.
 */
trait LowerPriorityIncludes {

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/Observable.html `javafx.beans.Observable`]]
   * instance to its ScalaFX counterpart.
   *
   * @param o JavaFX Observable
   * @return ScalaFX Observable
   */
  implicit def jfxObservable2sfx(o: jfxb.Observable): Observable = new Observable {
    override def delegate: jfxb.Observable = o
  }

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ObservableValue.html `javafx.beans.value.ObservableValue`]]
   * instance to its ScalaFX counterpart ''which Java Type and Scala Type are the same''.
   *
   * @param o JavaFX ObservableValue
   * @return ScalaFX ObservableValue ''which Java Type and Scala Type are the same''.
   */
  implicit def jfxObservableValue2sfx[T](o: jfxbv.ObservableValue[T]): ObservableValue[T, T] =
    new ObservableValue[T, T] {
      override def delegate: jfxbv.ObservableValue[T] = o
      override def value: T                           = delegate.getValue
    }
}
