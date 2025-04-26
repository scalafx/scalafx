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
package scalafx.scene.control

import javafx.beans.property as jfxbp
import javafx.scene.control as jfxsc
import javafx.{scene as jfxs, util as jfxu}
import scalafx.Includes.*
import scalafx.beans.property.{IntegerProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node

import scala.language.implicitConversions

object Pagination {
  implicit def sfxPagination2jfx(p: Pagination): jfxsc.Pagination = if (p != null) p.delegate else null

  /**
   * The style class to change the numeric page indicators to bullet indicators.
   */
  val StyleClassBullet: String = jfxsc.Pagination.STYLE_CLASS_BULLET
  @deprecated("Use StyleClassBullet; STYLE_CLASS_BULLET will be removed in a future release", "8.0.60-R10")
  val STYLE_CLASS_BULLET: String = StyleClassBullet

  /**
   * Value for indicating that the page count is indeterminate.
   */
  val Indeterminate: Int = jfxsc.Pagination.INDETERMINATE
  @deprecated("Use Indeterminate; INDETERMINATE will be removed in a future release", "8.0.60-R10")
  val INDETERMINATE: Int = Indeterminate

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Pagination.html]]
 */
class Pagination(override val delegate: jfxsc.Pagination = new jfxsc.Pagination)
    extends Control(delegate)
    with SFXDelegate[jfxsc.Pagination] {

  /**
   * Constructs a new Pagination control with the specified page count.
   */
  def this(pageCount: Int) = this(new jfxsc.Pagination(pageCount))

  /**
   * Constructs a new Pagination control with the specified page count and page index.
   */
  def this(pageCount: Int, pageIndex: Int) = this(new jfxsc.Pagination(pageCount, pageIndex))

  /**
   * The current page index to display for this pagination control.
   */
  def currentPageIndex: IntegerProperty = delegate.currentPageIndexProperty

  def currentPageIndex_=(value: Int): Unit = {
    currentPageIndex() = value
  }

  /**
   * The maximum number of page indicators to use for this pagination control.
   */
  def maxPageIndicatorCount: IntegerProperty = delegate.maxPageIndicatorCountProperty

  def maxPageIndicatorCount_=(value: Int): Unit = {
    maxPageIndicatorCount() = value
  }

  /**
   * The number of pages for this pagination control.
   */
  def pageCount: IntegerProperty = delegate.pageCountProperty

  def pageCount_=(value: Int): Unit = {
    pageCount() = value
  }

  /**
   * The pageFactory callback function that is called when a page has been selected by the application or the user.
   */
  def pageFactory: ObjectProperty[Int => Node] =
    ObjectProperty((page: Int) => new Node(delegate.pageFactoryProperty.get.call(page)) {})

  def pageFactory_=(callback: Int => Node): Unit = {
    val jCallback = new jfxu.Callback[java.lang.Integer, jfxs.Node] {
      def call(pageIndex: java.lang.Integer): jfxs.Node = callback(pageIndex).delegate
    }

    delegate.setPageFactory(jCallback)
  }

}
