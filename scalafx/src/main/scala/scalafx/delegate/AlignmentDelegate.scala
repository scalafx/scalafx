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
package scalafx.delegate

import javafx.beans.{property => jfxbp}
import javafx.{geometry => jfxg}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.AlignmentDelegate._
import scalafx.geometry.Pos

import scala.language.{implicitConversions, reflectiveCalls}

object AlignmentDelegate {

  /**
   * Types that contains `alignment` property.
   */
  type Aligned = {

    /*
     * The overall alignment of children (or text) within the component's width and height
     */
    def alignmentProperty(): jfxbp.ObjectProperty[jfxg.Pos]

  }

}

/**
 * Trait that unifies JavaFX classes that contains properties indicating component's internal alignment,
 * represented by `alignmentProperty` and its respective getter and setters.
 */
trait AlignmentDelegate[J <: Object with Aligned]
    extends SFXDelegate[J] {

  /**
   * The overall alignment of children (or text) within the component's width and height.
   */
  def alignment: ObjectProperty[jfxg.Pos] = delegate.alignmentProperty()

  def alignment_=(v: Pos): Unit = {
    alignment() = v
  }

}
