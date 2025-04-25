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
package scalafx

import javafx.collections as jfxc
import scalafx.delegate.SFXDelegate
import scalafx.util.JavaConverters.*

import scala.language.implicitConversions

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/package-summary.html `javafx.collections`]] package,
 * adding Scala's collections features to original JavaFX collections.
 */
package object collections {

  private def internalFiller[A, B](originalList: jfxc.ObservableList[A], filler: Iterable[B], f: B => A): Unit = {
    if (null == filler) {
      originalList.clear()
    } else {
      originalList.setAll(filler.map(f(_)).asJavaCollection)
    }
  }

  private def internalFillerWithOne[A, B](originalList: jfxc.ObservableList[A], element: B, f: B => A): Unit = {
    if (null == element) {
      originalList.clear()
    } else {
      originalList.setAll(List(f(element)).asJavaCollection)
    }
  }

  /**
   * Inserts all elements from a Iterable in a JavaFX ObservableList, replacing original content. If this iterable was
   * `null`, the list will be cleaned.
   *
   * @tparam T Iterable and ObservableList type
   * @param originalList List to be filled
   * @param filler Iterable which will fill originalList
   */
  def fillCollection[T](originalList: jfxc.ObservableList[T], filler: Iterable[T]): Unit = {
    this.internalFiller(originalList, filler, (t: T) => t)
  }

  /**
   * Replaces all content in an ObservableList of type T for a single element. If this element was `null`, the list
   * will be cleaned.
   *
   * @tparam T Element and ObservableList type
   * @param originalList List to be filled
   * @param element Element which will replace originalList content.
   */
  def fillCollectionWithOne[T](originalList: jfxc.ObservableList[T], element: T): Unit = {
    internalFillerWithOne(originalList, element, (t: T) => t)
  }

  /**
   * Inserts all elements from a Iterable of type SFXDelegate[J] in a JavaFX ObservableList of type J, replacing its
   * original content. If this iterable was `null`, the list will be cleaned.
   *
   * @tparam J Iterable and ObservableList type
   * @param originalList List to be filled
   * @param filler Iterable which will fill originalList
   */
  def fillSFXCollection[J <: Object](originalList: jfxc.ObservableList[J], filler: Iterable[SFXDelegate[J]]): Unit = {
    this.internalFiller(originalList, filler, (s: SFXDelegate[J]) => s.delegate)
  }

  /**
   * Replaces all content in an JavaFX ObservableList of type J for a single SFXDelegate[J] element.
   * If this element was `null`, the list will be cleaned.
   *
   * @tparam J Iterable and ObservableList type
   * @param originalList List to be filled
   * @param element Element which will replace originalList content. Actually, it will used its delegate.
   */
  def fillSFXCollectionWithOne[J <: Object](originalList: jfxc.ObservableList[J], element: SFXDelegate[J]): Unit = {
    this.internalFillerWithOne(originalList, element, (s: SFXDelegate[J]) => s.delegate)
  }

}
