package scalafx.scene.control

import javafx.{util => jfxu}
import javafx.{scene => jfxs}
import javafx.scene.{control => jfxc}

object Pagination {
  val STYLE_CLASS_BULLET = jfxc.Pagination.STYLE_CLASS_BULLET
  val INDETERMINATE = jfxc.Pagination.INDETERMINATE
}

/**
 * Created with IntelliJ IDEA.
 * User: Daniel Alves
 * Date: 29/08/12
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
class Pagination(override val delegate: jfxc.Pagination = new jfxc.Pagination()) extends Control(delegate) {

  def this(pageCount: Int) = this(new jfxc.Pagination(pageCount))

  def this(pageCount: Int, pageIndex: Int) = this(new jfxc.Pagination(pageCount, pageIndex))


  /**
   * The current page index to display for this pagination control.
   * @return
   */
  def currentPageIndex = delegate.currentPageIndexProperty()

  /**
   * Sets the current page index
   * @param value
   */
  def currentPageIndex_=(value: Int) {
    currentPageIndex set value
  }


  /**
   * The maximum number of page indicators to use for this pagination control.
   * @return
   */
  def maxPageIndicatorCount = delegate.maxPageIndicatorCountProperty()

  /**
   * Sets the maximum number of page indicators
   * @param value
   */
  def maxPageIndicatorCount_=(value: Int) {
    maxPageIndicatorCount set value
  }


  /**
   * The number of pages for this pagination control.
   * @return
   */
  def pageCount = delegate.pageCountProperty()

  /**
   * Sets the number of pages
   * @param value
   */
  def pageCount_=(value: Int) {
    pageCount set value
  }


  /**
   * The pageFactory callback function that is called when a page has been selected by the application or the user.
   * @return
   */
  def pageFactory = delegate.pageFactoryProperty()

  /**
   * Sets the pageFactory callback function
   * @param value
   */
  def pageFactory_=(value: jfxu.Callback[Integer, jfxs.Node]) {
    pageFactory set value
  }

}
