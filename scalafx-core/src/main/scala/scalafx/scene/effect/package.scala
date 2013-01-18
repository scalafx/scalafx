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
package scalafx.scene

import javafx.beans.{ property => jfxbp }
import javafx.scene.{ effect => jfxse }
import javafx.scene.{ paint => jfxsp }
import scalafx.Includes._
import scalafx.scene.paint.Color
import scalafx.delegate.SFXDelegate

/**
 *
 */
package object effect {

  /**
   * Type that indicates a JavaFX class that has the Property `inputProperty` of kind `ObjectProperty[Effect]`
   */
  type Inputed = {
    def inputProperty(): jfxbp.ObjectProperty[jfxse.Effect]
  }

  /**
   * Trait that unify all Effect subclasses whose Java counterpart have input Property. See type Inputed.
   */
  trait InputDelegate[J <: Object with Inputed]
    extends SFXDelegate[J] {

    /**
     * The input for this Effect.
     */
    def input = delegate.inputProperty
    def input_=(v: Effect) {
      input() = v
    }

  }

  /**
   * Type that indicates a JavaFX class that has the Property `colorProperty` of kind `ObjectProperty[Color]`
   */
  type Colored = {
    def colorProperty(): jfxbp.ObjectProperty[jfxsp.Color]
  }

  /**
   * Trait that unify all Effect subclasses whose Java counterpart have color Property. See type Colored.
   */
  trait ColorDelegate[J <: Object with Colored]
    extends SFXDelegate[J] {

    /**
     * The Effect's color.
     */
    def color = delegate.colorProperty
    def color_=(c: Color) {
      color() = c
    }

  }

}