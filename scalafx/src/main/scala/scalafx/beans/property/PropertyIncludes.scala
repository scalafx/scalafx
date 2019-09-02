/*
 * Copyright (c) 2011-2017, ScalaFX Project
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

import scala.language.implicitConversions

object PropertyIncludes extends PropertyIncludes

/**
  * Contains implicit methods to convert from
  * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/package-summary.html `javafx.beans.property`]]
  * Classes to their ScalaFX counterparts.
  */
trait PropertyIncludes extends LowerPriorityIncludes {

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/BooleanProperty `javafx.beans.property.BooleanProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX BooleanProperty
    * @return ScalaFX BooleanProperty
    */
  implicit def jfxBooleanProperty2sfx(p: jfxbp.BooleanProperty): BooleanProperty =
    if (p != null) new BooleanProperty(p) else null

  implicit def jfxListProperty2sfx[E <: Any](p: jfxbp.ListProperty[E]): BufferProperty[E] =
    if (p != null) new BufferProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/BooleanProperty `javafx.beans.property.BooleanProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX BooleanProperty
    * @return ScalaFX BooleanProperty
    */
  implicit def jfxDoubleProperty2sfx(p: jfxbp.DoubleProperty): DoubleProperty =
    if (p != null) new DoubleProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/BooleanProperty `javafx.beans.property.BooleanProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX BooleanProperty
    * @return ScalaFX BooleanProperty
    */
  implicit def jfxFloatProperty2sfx(p: jfxbp.FloatProperty): FloatProperty =
    if (p != null) new FloatProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/BooleanProperty `javafx.beans.property.BooleanProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX BooleanProperty
    * @return ScalaFX BooleanProperty
    */
  implicit def jfxIntegerProperty2sfx(p: jfxbp.IntegerProperty): IntegerProperty =
    if (p != null) new IntegerProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/LongProperty `javafx.beans.property.LongProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX LongProperty
    * @return ScalaFX LongProperty
    */
  implicit def jfxLongProperty2sfx(p: jfxbp.LongProperty): LongProperty = if (p != null) new LongProperty(p) else null

  implicit def jfxMapProperty2sfx[K, V](p: jfxbp.MapProperty[K, V]): MapProperty[K, V] =
    if (p != null) new MapProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ObjectProperty `javafx.beans.property.ObjectProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @tparam T ObjectProperty Type
    * @param p JavaFX ObjectProperty
    * @return ScalaFX ObjectProperty
    */
  implicit def jfxObjectProperty2sfx[T <: Any](p: jfxbp.ObjectProperty[T]): ObjectProperty[T] = new ObjectProperty[T](p)

  implicit def jfxSetProperty2sfx[E <: Any](p: jfxbp.SetProperty[E]): SetProperty[E] =
    if (p != null) new SetProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/StringProperty `javafx.beans.property.StringProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX StringProperty
    * @return ScalaFX StringProperty
    */
  implicit def jfxStringProperty2sfx(p: jfxbp.StringProperty): StringProperty =
    if (p != null) new StringProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyBooleanProperty `javafx.beans.property.ReadOnlyBooleanProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyBooleanProperty
    * @return ScalaFX ReadOnlyBooleanProperty
    */
  implicit def jfxReadOnlyBooleanProperty2sfx(p: jfxbp.ReadOnlyBooleanProperty): ReadOnlyBooleanProperty =
    if (p != null) new ReadOnlyBooleanProperty(p) else null

  implicit def jfxReadOnlyListProperty2sfx[E](p: jfxbp.ReadOnlyListProperty[E]): ReadOnlyBufferProperty[E] =
    if (p != null) new ReadOnlyBufferProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyDoubleProperty `javafx.beans.property.ReadOnlyDoubleProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyDoubleProperty
    * @return ScalaFX ReadOnlyDoubleProperty
    */
  implicit def jfxReadOnlyDoubleProperty2sfx(p: jfxbp.ReadOnlyDoubleProperty): ReadOnlyDoubleProperty =
    if (p != null) new ReadOnlyDoubleProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyFloatProperty `javafx.beans.property.ReadOnlyFloatProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyFloatProperty
    * @return ScalaFX ReadOnlyFloatProperty
    */
  implicit def jfxReadOnlyFloatProperty2sfx(p: jfxbp.ReadOnlyFloatProperty): ReadOnlyFloatProperty =
    if (p != null) new ReadOnlyFloatProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyIntegerProperty `javafx.beans.property.ReadOnlyIntegerProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyIntegerProperty
    * @return ScalaFX ReadOnlyIntegerProperty
    */
  implicit def jfxReadOnlyIntegerProperty2sfx(p: jfxbp.ReadOnlyIntegerProperty): ReadOnlyIntegerProperty =
    if (p != null) new ReadOnlyIntegerProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyLongProperty `javafx.beans.property.ReadOnlyLongProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyLongProperty
    * @return ScalaFX ReadOnlyLongProperty
    */
  implicit def jfxReadOnlyLongProperty2sfx(p: jfxbp.ReadOnlyLongProperty): ReadOnlyLongProperty =
    if (p != null) new ReadOnlyLongProperty(p) else null

  implicit def jfxReadOnlyMapProperty2sfx[K, V](p: jfxbp.ReadOnlyMapProperty[K, V]): ReadOnlyMapProperty[K, V] =
    if (p != null) new ReadOnlyMapProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyObjectProperty `javafx.beans.property.ReadOnlyObjectProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyObjectProperty
    * @return ScalaFX ReadOnlyObjectProperty
    */
  implicit def jfxReadOnlyObjectProperty2sfx[T <: Any](p: jfxbp.ReadOnlyObjectProperty[T]): ReadOnlyObjectProperty[T] =
    new ReadOnlyObjectProperty[T](p)

  implicit def jfxReadOnlySetProperty2sfx[E](p: jfxbp.ReadOnlySetProperty[E]): ReadOnlySetProperty[E] =
    if (p != null) new ReadOnlySetProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyStringProperty `javafx.beans.property.ReadOnlyStringProperty`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyStringProperty
    * @return ScalaFX ReadOnlyStringProperty
    */
  implicit def jfxReadOnlyStringProperty2sfx(p: jfxbp.ReadOnlyStringProperty): ReadOnlyStringProperty =
    if (p != null) new ReadOnlyStringProperty(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyStringWrapper
    * @return ScalaFX ReadOnlyStringWrapper
    */
  implicit def jfxReadOnlyBooleanWrapper2sfx(p: jfxbp.ReadOnlyBooleanWrapper): ReadOnlyBooleanWrapper =
    if (p != null) new ReadOnlyBooleanWrapper(p) else null

  implicit def jfxReadOnlyListWrapper2sfx[E](p: jfxbp.ReadOnlyListWrapper[E]): ReadOnlyBufferWrapper[E] =
    if (p != null) new ReadOnlyBufferWrapper(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyStringWrapper
    * @return ScalaFX ReadOnlyStringWrapper
    */
  implicit def jfxReadOnlyDoubleWrapper2sfx(p: jfxbp.ReadOnlyDoubleWrapper): ReadOnlyDoubleWrapper =
    if (p != null) new ReadOnlyDoubleWrapper(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyStringWrapper
    * @return ScalaFX ReadOnlyStringWrapper
    */
  implicit def jfxReadOnlyFloatWrapper2sfx(p: jfxbp.ReadOnlyFloatWrapper): ReadOnlyFloatWrapper =
    if (p != null) new ReadOnlyFloatWrapper(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyStringWrapper
    * @return ScalaFX ReadOnlyStringWrapper
    */
  implicit def jfxReadOnlyIntegerWrapper2sfx(p: jfxbp.ReadOnlyIntegerWrapper): ReadOnlyIntegerWrapper =
    if (p != null) new ReadOnlyIntegerWrapper(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyStringWrapper
    * @return ScalaFX ReadOnlyStringWrapper
    */
  implicit def jfxReadOnlyLongWrapper2sfx(p: jfxbp.ReadOnlyLongWrapper): ReadOnlyLongWrapper =
    if (p != null) new ReadOnlyLongWrapper(p) else null

  implicit def jfxReadOnlyMapWrapper2sfx[K, V](p: jfxbp.ReadOnlyMapWrapper[K, V]): ReadOnlyMapWrapper[K, V] =
    if (p != null) new ReadOnlyMapWrapper(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyStringWrapper
    * @return ScalaFX ReadOnlyObjectWrapper
    */
  implicit def jfxReadOnlyObjectWrapper2sfx[T <: Any](p: jfxbp.ReadOnlyObjectWrapper[T]): ReadOnlyObjectWrapper[T] =
    new ReadOnlyObjectWrapper[T](p)

  implicit def jfxReadOnlySetWrapper2sfx[E](p: jfxbp.ReadOnlySetWrapper[E]): ReadOnlySetWrapper[E] =
    if (p != null) new ReadOnlySetWrapper(p) else null

  /**
    * Converts a
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
    * instance to its ScalaFX counterpart.
    *
    * @param p JavaFX ReadOnlyStringWrapper
    * @return ScalaFX ReadOnlyStringWrapper
    */
  implicit def jfxReadOnlyStringWrapper2sfx(p: jfxbp.ReadOnlyStringWrapper): ReadOnlyStringWrapper =
    if (p != null) new ReadOnlyStringWrapper(p) else null

}

trait LowerPriorityIncludes {
  implicit def jfxProperty2sfx[T <: AnyRef](p: jfxbp.Property[T]): Property[T, T] = new Property[T, T] {
    override def delegate = p
    override def value = delegate.getValue
    override def value_=(v: T) {
      delegate.setValue(v)
    }
  }
}
