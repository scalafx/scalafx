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
import javafx.{collections => jfxc}

import scala.language.implicitConversions
import scalafx.beans.binding.SetExpression
import scalafx.collections.CollectionIncludes.jfxObservableSet2sfxObservableSet
import scalafx.collections.ObservableSet
import scalafx.delegate.SFXDelegate

object ReadOnlySetProperty {
  /**
    * Converts a ScalaFX ReadOnlySetProperty to its JavaFX counterpart ReadOnlySetProperty.
    *
    * @param v ScalaFX ReadOnlySetProperty
    * @return JavaFX ReadOnlySetProperty
    */
  implicit def sfxReadOnlySetProperty2jfx[E <: Any](v: ReadOnlySetProperty[E]): jfxbp.ReadOnlySetProperty[E] =
    if (v != null) v.delegate else null
}

/**
  * Wraps a $JFX $URL0 ReadOnlySetProperty]].
  *
  * @define TC          ReadOnlySetProperty
  * @define URL0        [[https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ReadOnlySetProperty.html
  * @define JFX         JavaFX
  * @define ORIGINALDOC Original Documentation]].
  **/
class ReadOnlySetProperty[E <: Any](override val delegate: jfxbp.ReadOnlySetProperty[E])
  extends SetExpression[E](delegate)
    with ReadOnlyProperty[ObservableSet[E], jfxc.ObservableSet[E]]
    with SFXDelegate[jfxbp.ReadOnlySetProperty[E]] {


  override def value: ObservableSet[E] = delegate.get()

  /**
    * Creates a content binding between the ObservableSet, that is wrapped in this ReadOnlySetProperty,
    * and another ObservableSet.
    *
    * A content binding ensures that the content of the wrapped ObservableSets is the same as that of the other set.
    * If the content of the other set changes, the wrapped set will be updated automatically.
    * Once the wrapped set is bound to another set, you must not change it directly.
    *
    * @param set the ObservableSet this property should be bound to
    */
  def bindContent(set: ObservableSet[E]): Unit = delegate.bindContent(set.delegate)

  /**
    * Creates a bidirectional content binding of the ObservableSet, that is wrapped in this ReadOnlySetProperty,
    * and another ObservableSet.
    *
    * A bidirectional content binding ensures that the content of two ObservableSets is the same.
    * If the content of one of the sets changes, the other one will be updated automatically.
    *
    * @param set the ObservableSet this property should be bound to
    */
  def bindContentBidirectional(set: ObservableSet[E]): Unit = delegate.bindContentBidirectional(set.delegate)

  /**
    * Deletes a content binding between the ObservableSet, that is wrapped in this ReadOnlySetProperty, and another Object.
    *
    * This is a helper method that calls the JavaFX counterpart with a delegate rather than the original object.
    *
    * @param sfx the SFXDelegate object to which the binding should be removed
    */
  def unbindContent[T <: Object](sfx: SFXDelegate[T]): Unit = delegate.unbindContent(sfx.delegate)

  /**
    * Deletes a bidirectional content binding between the ObservableSet, that is wrapped in this ReadOnlySetProperty, and another Object.
    *
    * This is a helper method that calls the JavaFX counterpart with a delegate rather than the original object.
    *
    * @param sfx the SFXDelegate object to which the binding should be removed
    */
  def unbindContentBidirectional[T <: Object](sfx: SFXDelegate[T]): Unit = delegate.unbindContentBidirectional(sfx.delegate)
}
