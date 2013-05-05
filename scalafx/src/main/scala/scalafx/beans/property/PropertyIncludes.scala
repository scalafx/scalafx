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
package scalafx.beans.property

import javafx.beans.{ property => jfxbp }

object PropertyIncludes extends PropertyIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/package-summary.html `javafx.beans.property`]]
 * Classes to their ScalaFX counterparts.
 */
trait PropertyIncludes extends LowerPriorityIncludes {

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/BooleanProperty `javafx.beans.property.BooleanProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX BooleanProperty
   * @return ScalaFX BooleanProperty
   */
  implicit def jfxBooleanProperty2sfx(p: jfxbp.BooleanProperty) = new BooleanProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/BooleanProperty `javafx.beans.property.BooleanProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX BooleanProperty
   * @return ScalaFX BooleanProperty
   */
  implicit def jfxDoubleProperty2sfx(p: jfxbp.DoubleProperty) = new DoubleProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/BooleanProperty `javafx.beans.property.BooleanProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX BooleanProperty
   * @return ScalaFX BooleanProperty
   */
  implicit def jfxFloatProperty2sfx(p: jfxbp.FloatProperty) = new FloatProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/BooleanProperty `javafx.beans.property.BooleanProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX BooleanProperty
   * @return ScalaFX BooleanProperty
   */
  implicit def jfxIntegerProperty2sfx(p: jfxbp.IntegerProperty) = new IntegerProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/LongProperty `javafx.beans.property.LongProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX LongProperty
   * @return ScalaFX LongProperty
   */
  implicit def jfxLongProperty2sfx(p: jfxbp.LongProperty) = new LongProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ObjectProperty `javafx.beans.property.ObjectProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @tparam T ObjectProperty Type
   * @param p JavaFX ObjectProperty
   * @return ScalaFX ObjectProperty
   */
  implicit def jfxObjectProperty2sfx[T <: Any](p: jfxbp.ObjectProperty[T]) = new ObjectProperty[T](p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/StringProperty `javafx.beans.property.StringProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX StringProperty
   * @return ScalaFX StringProperty
   */
  implicit def jfxStringProperty2sfx(p: jfxbp.StringProperty) = new StringProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyBooleanProperty `javafx.beans.property.ReadOnlyBooleanProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyBooleanProperty
   * @return ScalaFX ReadOnlyBooleanProperty
   */
  implicit def jfxReadOnlyBooleanProperty2sfx(p: jfxbp.ReadOnlyBooleanProperty) = new ReadOnlyBooleanProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyDoubleProperty `javafx.beans.property.ReadOnlyDoubleProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyDoubleProperty
   * @return ScalaFX ReadOnlyDoubleProperty
   */
  implicit def jfxReadOnlyDoubleProperty2sfx(p: jfxbp.ReadOnlyDoubleProperty) = new ReadOnlyDoubleProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyFloatProperty `javafx.beans.property.ReadOnlyFloatProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyFloatProperty
   * @return ScalaFX ReadOnlyFloatProperty
   */
  implicit def jfxReadOnlyFloatProperty2sfx(p: jfxbp.ReadOnlyFloatProperty) = new ReadOnlyFloatProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyIntegerProperty `javafx.beans.property.ReadOnlyIntegerProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyIntegerProperty
   * @return ScalaFX ReadOnlyIntegerProperty
   */
  implicit def jfxReadOnlyIntegerProperty2sfx(p: jfxbp.ReadOnlyIntegerProperty) = new ReadOnlyIntegerProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyLongProperty `javafx.beans.property.ReadOnlyLongProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyLongProperty
   * @return ScalaFX ReadOnlyLongProperty
   */
  implicit def jfxReadOnlyLongProperty2sfx(p: jfxbp.ReadOnlyLongProperty) = new ReadOnlyLongProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyObjectProperty `javafx.beans.property.ReadOnlyObjectProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyObjectProperty
   * @return ScalaFX ReadOnlyObjectProperty
   */
  implicit def jfxReadOnlyObjectProperty2sfx[T <: Any](p: jfxbp.ReadOnlyObjectProperty[T]) = new ReadOnlyObjectProperty[T](p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyStringProperty `javafx.beans.property.ReadOnlyStringProperty`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyStringProperty
   * @return ScalaFX ReadOnlyStringProperty
   */
  implicit def jfxReadOnlyStringProperty2sfx(p: jfxbp.ReadOnlyStringProperty) = new ReadOnlyStringProperty(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyStringWrapper
   * @return ScalaFX ReadOnlyStringWrapper
   */
  implicit def jfxReadOnlyBooleanWrapper2sfx(p: jfxbp.ReadOnlyBooleanWrapper) = new ReadOnlyBooleanWrapper(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyStringWrapper
   * @return ScalaFX ReadOnlyStringWrapper
   */
  implicit def jfxReadOnlyDoubleWrapper2sfx(p: jfxbp.ReadOnlyDoubleWrapper) = new ReadOnlyDoubleWrapper(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyStringWrapper
   * @return ScalaFX ReadOnlyStringWrapper
   */
  implicit def jfxReadOnlyFloatWrapper2sfx(p: jfxbp.ReadOnlyFloatWrapper) = new ReadOnlyFloatWrapper(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyStringWrapper
   * @return ScalaFX ReadOnlyStringWrapper
   */
  implicit def jfxReadOnlyIntegerWrapper2sfx(p: jfxbp.ReadOnlyIntegerWrapper) = new ReadOnlyIntegerWrapper(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyStringWrapper
   * @return ScalaFX ReadOnlyStringWrapper
   */
  implicit def jfxReadOnlyLongWrapper2sfx(p: jfxbp.ReadOnlyLongWrapper) = new ReadOnlyLongWrapper(p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyStringWrapper
   * @return ScalaFX ReadOnlyObjectWrapper
   */
  implicit def jfxReadOnlyObjectWrapper2sfx[T <: Any](p: jfxbp.ReadOnlyObjectWrapper[T]) = new ReadOnlyObjectWrapper[T](p)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/beans/property/ReadOnlyStringWrapper `javafx.beans.property.ReadOnlyStringWrapper`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX ReadOnlyStringWrappery
   * @return ScalaFX ReadOnlyStringWrapper
   */
  implicit def jfxReadOnlyStringWrapper2sfx(p: jfxbp.ReadOnlyStringWrapper) = new ReadOnlyStringWrapper(p)

}

trait LowerPriorityIncludes {
  implicit def jfxProperty2sfx[T <: AnyRef](p: jfxbp.Property[T]) = new Property[T, T] {
    override def delegate = p
    override def value = delegate.getValue
    override def value_=(v: T) {
      delegate.setValue(v)
    }
  }
}