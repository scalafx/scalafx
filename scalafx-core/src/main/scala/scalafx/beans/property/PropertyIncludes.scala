/*
 * Copyright (c) 2011, ScalaFX Project
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

object PropertyIncludes extends PropertyIncludes

trait PropertyIncludes extends LowerPriorityIncludes {
  implicit def jfxBooleanProperty2sfx(p: jfxbp.BooleanProperty) = new BooleanProperty(p)
  implicit def jfxDoubleProperty2sfx(p: jfxbp.DoubleProperty) = new DoubleProperty(p)
  implicit def jfxFloatProperty2sfx(p: jfxbp.FloatProperty) = new FloatProperty(p)
  implicit def jfxIntegerProperty2sfx(p: jfxbp.IntegerProperty) = new IntegerProperty(p)
  implicit def jfxLongProperty2sfx(p: jfxbp.LongProperty) = new LongProperty(p)
  implicit def jfxObjectProperty2sfx[T <: AnyRef](p: jfxbp.ObjectProperty[T]) = new ObjectProperty[T](p)
  implicit def jfxStringProperty2sfx(p: jfxbp.StringProperty) = new StringProperty(p)

  implicit def jfxReadOnlyBooleanProperty2sfx(p: jfxbp.ReadOnlyBooleanProperty) = new ReadOnlyBooleanProperty(p)
  implicit def jfxReadOnlyDoubleProperty2sfx(p: jfxbp.ReadOnlyDoubleProperty) = new ReadOnlyDoubleProperty(p)
  implicit def jfxReadOnlyFloatProperty2sfx(p: jfxbp.ReadOnlyFloatProperty) = new ReadOnlyFloatProperty(p)
  implicit def jfxReadOnlyIntegerProperty2sfx(p: jfxbp.ReadOnlyIntegerProperty) = new ReadOnlyIntegerProperty(p)
  implicit def jfxReadOnlyLongProperty2sfx(p: jfxbp.ReadOnlyLongProperty) = new ReadOnlyLongProperty(p)
  implicit def jfxReadOnlyObjectProperty2sfx[T <: AnyRef](p: jfxbp.ReadOnlyObjectProperty[T]) = new ReadOnlyObjectProperty[T](p)
  implicit def jfxReadOnlyStringProperty2sfx(p: jfxbp.ReadOnlyStringProperty) = new ReadOnlyStringProperty(p)

  implicit def jfxReadOnlyObjectWrapper2sfx[T <: AnyRef](p: jfxbp.ReadOnlyObjectWrapper[T]) = new ReadOnlyObjectWrapper[T](p)
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