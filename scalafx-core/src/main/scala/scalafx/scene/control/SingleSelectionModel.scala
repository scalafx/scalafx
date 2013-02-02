/*
 * Copyright (c) 2012, ScalaFX Project
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

import scalafx.delegate.SFXDelegate
import javafx.scene.{ control => jfxsc }
import scalafx.Includes._

object SingleSelectionModel {
  implicit def sfxSingleSelectionModel2jfx[T](v: SingleSelectionModel[T]) = v.delegate

  /**
   * Creates a new [[scalafx.scene.control.SingleSelectionModel]] from functions that defines a data
   * model and quantity of items. This method was created to supply necessity
   * to override protected methods
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/SingleSelectionModel.html#getItemCount() getItemCount()]]
   * and
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/SingleSelectionModel.html#getModelItem(int) getModelItem(int)]]
   * from
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/SingleSelectionModel.html SingleSelectionModel]].
   *
   * @tparam T  The type of the item contained in the control that can be
   * selected.
   * @param modelItem Function that gets the data model item associated with a
   * specific index.
   * @param itemCount Function that gets the number of items available for the
   * selection model.
   */
  def apply[T](modelItem: Int => T, itemCount: => Int) = new SingleSelectionModel[T](
    new jfxsc.SingleSelectionModel[T] {
      protected def getModelItem(index: Int): T = modelItem(index)
      protected def getItemCount = itemCount
    }) {}

}

abstract class SingleSelectionModel[T](override val delegate: jfxsc.SingleSelectionModel[T])
  extends SelectionModel[T](delegate)
  with SFXDelegate[jfxsc.SingleSelectionModel[T]] 