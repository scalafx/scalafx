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
package scalafx.collections

import javafx.{collections => jfxc}
import scalafx.collections.transformation.TransformationIncludes

import scala.language.implicitConversions

object CollectionIncludes extends CollectionIncludes

//trait CollectionIncludes extends TransformationIncludes with LowerPriorityIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/package-summary.html `javafx.collections`]]
 * Classes to their ScalaFX counterparts.
 */
trait CollectionIncludes extends TransformationIncludes {

  /**
   * Converts a [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableList.html `ObservableList`]]
   * to a [[scalafx.collections.ObservableBuffer]].
   *
   * @tparam T List Type
   * @param ol JavaFX ObservableList
   * @return ScalaFX ObservableBuffer
   */
  implicit def observableList2ObservableBuffer[T](ol: jfxc.ObservableList[T]): ObservableBuffer[T] =
    if (ol != null) new ObservableBuffer[T](ol)
    else null

  /**
   * Converts a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableMap.html `ObservableMap`]]
   * to a ScalaFX [[scalafx.collections.ObservableMap]].
   *
   * @tparam K Key Type
   * @tparam V Value Type
   * @param om JavaFX ObservableMap
   * @return ScalaFX ObservableMap
   */
  implicit def jfxObservableMap2sfxObservableMap[K, V](om: jfxc.ObservableMap[K, V]): ObservableMap[K, V] =
    if (om != null) new ObservableMap[K, V] {
      override val delegate: jfxc.ObservableMap[K, V] = om
    }
    else null

  /**
   * Converts a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableSet.html `ObservableSet`]]
   * to a ScalaFX [[scalafx.collections.ObservableSet]].
   *
   * @tparam T Set Type
   * @param os JavaFX ObservableSet
   * @return ScalaFX ObservableSet
   */
  implicit def jfxObservableSet2sfxObservableSet[T](os: jfxc.ObservableSet[T]): ObservableHashSet[T] =
    if (os != null) new ObservableHashSet[T] {
      override val delegate: jfxc.ObservableSet[T] = os
    }
    else null

  /**
   * Converts a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableFloatArray.html]] `ObservableFloatArray` to a ScalaFX [[scalafx.collections.ObservableFloatArray]].
   *
   * @param ofa JavaFX ObservableFloatArray
   * @return ScalaFX ObservableFloatArray
   */
  implicit def jfxObservableFloatArray2sfxObservableFloatArray(ofa: jfxc.ObservableFloatArray): ObservableFloatArray =
    if (ofa != null) new ObservableFloatArray(ofa) else null

  /**
   * Converts a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableIntegerArray.html]] `ObservableIntegerArray` to a ScalaFX [[scalafx.collections.ObservableIntegerArray]].
   *
   * @param oia JavaFX ObservableIntegerArray
   * @return ScalaFX ObservableIntegerArray
   */
  implicit def jfxObservableIntegerArray2sfxObservableIntegerArray(oia: jfxc.ObservableIntegerArray)
    : ObservableIntegerArray =
    if (oia != null) new ObservableIntegerArray(oia) else null
}
