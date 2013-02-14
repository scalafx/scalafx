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

import javafx.beans.{ property => jfxbp }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import PositionDelegate._

object PositionDelegate  {
  
  type Positioned = {
    def xProperty(): jfxbp.DoubleProperty

    def yProperty(): jfxbp.DoubleProperty
  }

}

/**
 * Trait that unifies JavaFX classes that contains properties indicating localization in 2
 * dimensions, represented by xProperty and y yProperty and their respectives getter and setters.
 *
 */
trait PositionDelegate[J <: Object with Positioned]
  extends SFXDelegate[J] { 

  /**
   * X Position
   */
  def x: DoubleProperty = delegate.xProperty
  def x_=(v: Double) {
    x() = v
  }

  /**
   * Y Position
   */
  def y: DoubleProperty = delegate.yProperty
  def y_=(v: Double) {
    y() = v
  }

}