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

package scalafx.beans.binding


import javafx.beans.{binding => jfxbb, value => jfxbv}
import javafx.{beans => jfxb}
import scalafx.beans.Observable
import scalafx.beans.binding.NumberExpression.VariablePrecisionNumber

import scala.language.implicitConversions

object BindingIncludes extends BindingIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/package-summary.html `javafx.beans.binding`]]
 * Classes to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define BOB BooleanBinding
 * @define BOE BooleanExpression
 * @define NUB NumberBinding
 * @define NUE NumberExpression
 * @define OBB ObjectBinding
 * @define OBE ObjectExpression
 * @define STB StringBinding
 * @define STE StringExpression
 */
trait BindingIncludes extends Bindings {
  // Implicit upcasts from JavaFX to ScalaFX types for all bindings

  /**
   * $START$BOB.html $BOB$END
   *
   * @param bb $JFX $BOB
   * @return $SFX $BOB
   */
  implicit def jfxBooleanBinding2sfx(bb: jfxbb.BooleanBinding): BooleanBinding = if (bb != null) new BooleanBinding(bb) else null

  /**
   * $START$BOE.html $BOE$END
   *
   * @param be $JFX $BOE
   * @return $SFX $BOE
   */
  implicit def jfxBooleanExpression2sfx(be: jfxbb.BooleanExpression): BooleanExpression = if (be != null) new BooleanExpression(be) else null

  implicit def jfxListBinding2sfx[E <: Any](v: jfxbb.ListBinding[E]): BufferBinding[E] =
    if (v != null) new BufferBinding(v) else null

  implicit def jfxListExpression2sfx[E <: Any](v: jfxbb.ListExpression[E]): BufferExpression[E] =
    if (v != null) new BufferExpression(v) else null

  implicit def jfxMapBinding2sfx[K, V](v: jfxbb.MapBinding[K, V]): MapBinding[K, V] =
    if (v != null) new MapBinding(v) else null

  implicit def jfxMapExpression2sfx[K, V](v: jfxbb.MapExpression[K, V]): MapExpression[K, V] =
    if (v != null) new MapExpression(v) else null

  /**
   * $START$NUB.html $NUB$END
   *
   * @param nb $JFX $NUB
   * @return $SFX $NUB
   */
  implicit def jfxNumberBinding2sfx(nb: jfxbb.NumberBinding): NumberBinding = if (nb != null) new NumberBinding(nb) else null

  /**
   * $START$NUE.html $NUE$END
   *
   * @param ne $JFX $NUE
   * @return $SFX $NUE
   */
  implicit def jfxNumberExpression2sfx(ne: jfxbb.NumberExpression): NumberExpression = if (ne != null) new NumberExpression(ne) else null

  /**
   * $START$OBB.html $OBB$END
   *
   * @tparam T $OBB Type
   * @param ob $JFX $OBB
   * @return $SFX $OBB
   */
  implicit def jfxObjectBinding2sfx[T](ob: jfxbb.ObjectBinding[T]): ObjectBinding[T] = if (ob != null) new ObjectBinding[T](ob) else null

  /**
   * $START$OBE.html $OBE$END
   *
   * @tparam T $OBE Type
   * @param oe $JFX $OBE
   * @return $SFX $OBE
   */
  implicit def jfxObjectExpression2sfx[T](oe: jfxbb.ObjectExpression[T]): ObjectExpression[T] = if (oe != null) new ObjectExpression[T](oe) else null

  implicit def jfxSetBinding2sfx[E <: Any](v: jfxbb.SetBinding[E]): SetBinding[E] =
    if (v != null) new SetBinding(v) else null

  implicit def jfxSetExpression2sfx[E <: Any](v: jfxbb.SetExpression[E]): SetExpression[E] =
    if (v != null) new SetExpression(v) else null

  /**
   * $START$STB.html $STB$END
   *
   * @param sb $JFX $STB
   * @return $SFX $STB
   */
  implicit def jfxStringBinding2sfx(sb: jfxbb.StringBinding): StringBinding = if (sb != null) new StringBinding(sb) else null

  /**
   * $START$STE.html $STE$END
   *
   * @param se $JFX $STE
   * @return $SFX $STE
   */
  implicit def jfxStringExpression2sfx(se: jfxbb.StringExpression): StringExpression = if (se != null) new StringExpression(se) else null

  // Conversion helper for variable precision numbers (e.g. 100+-.01)

  /**
   * Converts a Double to a VariablePrecisionNumber.
   *
   * @param d A Double
   * @return a VariablePrecisionNumber
   */
  implicit def double2VariablePrecisionNumber(d: Double): VariablePrecisionNumber = VariablePrecisionNumber(d)

  // Simple closure syntax for observables to reduce boilerplate on the JavaFX addListener methods

  /**
   * Converts a closure to a $JFX InvalidationListener.
   *
    * @tparam R closure can have arbitrary return type to make usage easier (last statement in the closure does not
    *           have to return `Unit`). Return value is ignored in generated listener.
   * @param il Closure to be converted.
   * @return a new $JFX InvalidationListener.
   */
  implicit def closure2InvalidationListener[R](il: jfxb.Observable => R): jfxb.InvalidationListener = new jfxb.InvalidationListener {
    def invalidated(observable: jfxb.Observable): Unit = {
      il(observable)
    }
  }

  /**
    * Converts a closure to a $JFX InvalidationListener.
    *
    * @tparam R closure can have arbitrary return type to make usage easier (last statement in the closure does not
    *           have to return `Unit`). Return value is ignored in generated listener.
    * @param il Closure to be converted.
    * @return a new $JFX InvalidationListener.
    */
  implicit def closureSFX2InvalidationListener[R](il: Observable => R): jfxb.InvalidationListener = new jfxb.InvalidationListener {
    def invalidated(observable: jfxb.Observable): Unit = {
      il(scalafx.beans.BeanIncludes.jfxObservable2sfx(observable))
    }
  }

  /**
   * Converts a closure to a $JFX ChangeListener.
   *
   * @tparam P  Change listener type.
    * @tparam R closure can have arbitrary return type to make usage easier (last statement in the closure does not
    *           have to return `Unit`). Return value is ignored in generated listener.
   * @param cl Closure to be converted.
   * @return a new $JFX ChangeListener.
   */
  implicit def closure2ChangedListener[P, R](cl: (jfxbv.ObservableValue[_ <: P], P, P) => R): jfxbv.ChangeListener[P] = new jfxbv.ChangeListener[P]() {
    def changed(observable: jfxbv.ObservableValue[_ <: P], oldValue: P, newValue: P): Unit = {
      cl(observable, oldValue, newValue)
    }
  }

  // Upconversions from primitives to bindings
  // Needed for min and max, which take a list of bindings -- all other uses have the primitives declared directly for efficiency

  /**
   * Converts a Integer to a $JFX IntegerBinding
   *
   * @param i Integer to generate a new IntegerBinding
    * @return a new IntegerBinding generated from the Integer.
   */
  implicit def integer2IntegerBinding(i: Int): jfxbb.IntegerBinding = new jfxbb.IntegerBinding {
    def computeValue() = i
  }

  /**
   * Converts a Long to a $JFX LongBinding
   *
   * @param i Long to generate a new LongBinding
   * @return a new LongBinding generated from the Long.
   */
  implicit def long2LongBinding(i: Long): jfxbb.LongBinding = new jfxbb.LongBinding {
    def computeValue() = i
  }

  /**
   * Converts a Float to a $JFX FloatBinding
   *
   * @param i Float to generate a new FloatBinding
   * @return a new FloatBinding generated from the Float.
   */
  implicit def float2FloatBinding(i: Float): jfxbb.FloatBinding = new jfxbb.FloatBinding {
    def computeValue() = i
  }

  /**
   * Converts a Double to a $JFX DoubleBinding
   *
   * @param i Double to generate a new DoubleBinding
   * @return a new DoubleBinding generated from the Double.
   */
  implicit def double2DoubleBinding(i: Double): jfxbb.DoubleBinding = new jfxbb.DoubleBinding {
    def computeValue() = i
  }

}
