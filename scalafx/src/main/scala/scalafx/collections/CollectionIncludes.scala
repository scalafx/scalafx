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
package scalafx.collections

import scala.collection.JavaConversions.mapAsScalaMap

import javafx.{ collections => jfxc }

object CollectionIncludes extends CollectionIncludes

/**
 * Contains implicit conversion functions from [[http://docs.oracle.com/javafx/2/api/javafx/collections/package-frame.html `javafx.collections`]]
 * traits to `scalafx.collections` traits.
 */
trait CollectionIncludes {
  /**
   * Converts a [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableList.html `ObservableList`]]
   * to a [[scalafx.collections.ObservableBuffer]].
   */
  implicit def observableList2ObservableBuffer[T](ol: jfxc.ObservableList[T]): ObservableBuffer[T] =
    new ObservableBuffer[T](ol)

  /**
   * Converts a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableMap.html `ObservableMap`]]
   * to a ScalaFX [[scalafx.collections.ObservableMap]].
   */
  implicit def jfxObservableMap2sfxObservableMap[K, V](om: jfxc.ObservableMap[K, V]): ObservableMap[K, V] =
    new ObservableMap[K, V] {
      override val delegate = om
    }

  /**
   * Converts a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableSet.html `ObservableSet`]]
   * to a ScalaFX [[scalafx.collections.ObservableSet]].
   */
  implicit def jfxObservableSet2sfxObservableSet[T](os: jfxc.ObservableSet[T]): ObservableHashSet[T] = new ObservableHashSet[T](os)
}
