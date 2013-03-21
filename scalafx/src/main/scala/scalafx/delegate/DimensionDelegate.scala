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
package scalafx.delegate

import DimensionDelegate._
import javafx.beans.{ property => jfxbp }
import scalafx.beans.property.DoubleProperty
import scalafx.Includes._

object DimensionDelegate {

  /**
   * Types that contains `height` and `width` properties.
   */
  type Dimensioned = {
    
    def heightProperty(): jfxbp.DoubleProperty

    def widthProperty(): jfxbp.DoubleProperty
  }
}

/**
 * Trait that unifies JavaFX classes that contains properties indicating height and width,
 * represented by heightProperty and widthProperty and their respective getter and setters.
 *
 * @tparam J Original JavaFX type that contains `height` and `width` properties.
 */
trait DimensionDelegate[J <: Object with Dimensioned]
  extends SFXDelegate[J] {

  /**
   * Indicates the height of object.
   */
  def height: DoubleProperty = delegate.heightProperty()
  def height_=(h: Double) {
    height() = h
  }

  /**
   * Indicates the width of object.
   */
  def width: DoubleProperty = delegate.widthProperty()
  def width_=(w: Double) {
    width() = w
  }

}