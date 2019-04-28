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

package scalafx.beans.property

import javafx.beans.{property => jfxbp}
import javafx.{collections => jfxc}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions


object BufferProperty {
  /**
    * Converts a ScalaFX BufferProperty to its JavaFX counterpart ListProperty.
    *
    * @param v ScalaFX BufferProperty
    * @return JavaFX ListProperty
    */
  implicit def sfxBufferProperty2jfx[E <: Any](v: BufferProperty[E]): jfxbp.ListProperty[E] =
    if (v != null) v.delegate else null

  /**
    * Creates a new BufferProperty instance using the ObservableBuffer as the value.
    *
    * @param value the initial value
    */
  def apply[E <: Any](value: ObservableBuffer[E]): BufferProperty[E] =
    new BufferProperty(new jfxbp.SimpleListProperty(value.delegate))

  /**
    * Creates a new BufferProperty instance.
    *
    * @param bean the bean of this BufferProperty
    * @param name the name of this BufferProperty
    */
  def apply[E <: Any](bean: Any, name: String): BufferProperty[E] =
    new BufferProperty(new jfxbp.SimpleListProperty[E](bean, name))

  /**
    * Creates a new BufferProperty instance.
    *
    * @param bean  the bean of this BufferProperty
    * @param name  the name of this BufferProperty
    * @param value the initial value
    */
  def apply[E <: Any](bean: Any, name: String, value: ObservableBuffer[E]): BufferProperty[E] =
    new BufferProperty(new jfxbp.SimpleListProperty(bean, name, value.delegate))

  /**
    * Creates a new BufferProperty and a its value from a sequence of elements.
    *
    * @param items Sequence of elements to assign to BufferProperty value
    * @return new BufferProperty from items
    */
  def apply[E <: Any](items: Seq[E]): BufferProperty[E] = {
    import scala.collection.JavaConverters._
    new BufferProperty[E](
      new jfxbp.SimpleListProperty(jfxc.FXCollections.observableArrayList[E](items.asJava)))
  }

  /**
    * Creates a new BufferProperty and a its value from a sequence of elements.
    *
    * @param bean  the bean of this BufferProperty
    * @param name  the name of this BufferProperty
    * @param items Sequence of elements to assign to BufferProperty value
    * @return new BufferProperty from items
    */
  def apply[E <: Any](bean: Any, name: String, items: Seq[E]): BufferProperty[E] = {
    import scala.collection.JavaConverters.seqAsJavaListConverter
    new BufferProperty[E](
      new jfxbp.SimpleListProperty(
        bean,
        name,
        jfxc.FXCollections.observableArrayList[E](seqAsJavaListConverter(items).asJava)))
  }
}


/**
  * Wraps a $JFX [[ $URL0 ListProperty]].
  *
  * @define TC   BufferProperty
  * @define URL0 https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ListProperty.html
  * @define JFX  JavaFX
  */
class BufferProperty[E <: Any](override val delegate: jfxbp.ListProperty[E] = new jfxbp.SimpleListProperty[E])
  extends ReadOnlyBufferProperty[E](delegate)
    with Property[ObservableBuffer[E], jfxc.ObservableList[E]]
    with SFXDelegate[jfxbp.ListProperty[E]] {

  /**
    * The constructor of BufferProperty
    *
    * @param value the initial value of the wrapped value
    */
  def this(value: ObservableBuffer[E]) =
    this(new jfxbp.SimpleListProperty(value.delegate))

  /**
    * The constructor of BufferProperty
    *
    * @param bean the bean of this BufferProperty
    * @param name the name of this BufferProperty
    */
  def this(bean: Any, name: String) =
    this(new jfxbp.SimpleListProperty[E](bean, name))

  /**
    * The constructor of BufferProperty
    *
    * @param bean  the bean of this BufferProperty
    * @param name  the name of this BufferProperty
    * @param value the initial value of the wrapped value
    */
  def this(bean: Any, name: String, value: ObservableBuffer[E]) =
    this(new jfxbp.SimpleListProperty(bean, name, value.delegate))

  /**
    * Creates a new BufferProperty and a its value from a sequence of elements.
    *
    * @param items Sequence of elements to assign to BufferProperty value
    * @return new BufferProperty from items
    */
  def this(items: Seq[E]) = {
    this(new jfxbp.SimpleListProperty(
      jfxc.FXCollections.observableArrayList[E](
        scala.collection.JavaConverters.seqAsJavaListConverter(items).asJava)))
  }

  /**
    * Creates a new BufferProperty and a its value from a sequence of elements.
    *
    * @param bean  the bean of this BufferProperty
    * @param name  the name of this BufferProperty
    * @param items Sequence of elements to assign to BufferProperty value
    * @return new BufferProperty from items
    */
  def this(bean: Any, name: String, items: Seq[E]) = {
    this(new jfxbp.SimpleListProperty(
      bean,
      name,
      jfxc.FXCollections.observableArrayList[E](
        scala.collection.JavaConverters.seqAsJavaListConverter(items).asJava)))
  }

  /**
    * Set the wrapped value.
    *
    * @param v The new value
    */
  override def value_=(v: ObservableBuffer[E]): Unit = delegate.setValue(v)
}
