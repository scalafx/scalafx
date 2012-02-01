/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.event

import javafx.{event => jfxe}
import javafx.scene.{input => jfxsi}

import scalafx.scene.{input => sfxsi}

object EventIncludes extends EventIncludes {
  implicit def jfxMouseEvent2sfx(me: jfxsi.MouseEvent) = new sfxsi.MouseEvent(me)

  implicit def jfxActionEvent2sfx(ae: jfxe.ActionEvent) = new ActionEvent(ae)
}

trait EventIncludes {
  implicit def eventClosureWrapper[T <: jfxe.Event](handler: => Unit) = new jfxe.EventHandler[T] {
    def handle(event: T) {
      handler
    }
  }

  implicit def eventClosureWrapperWithUnitParam[T <: jfxe.Event](handler: Unit => Unit) = new jfxe.EventHandler[T] {
    def handle(event: T) {
      handler()
    }
  }

  implicit def eventClosureWrapperWithParam[T <: jfxe.Event](handler: (T) => Unit) = new jfxe.EventHandler[T] {
    def handle(event: T) {
      handler(event)
    }
  }

  implicit def mouseEventClosureWrapper(handler: (sfxsi.MouseEvent) => Unit) = new jfxe.EventHandler[jfxsi.MouseEvent] {

    import EventIncludes.jfxMouseEvent2sfx

    def handle(event: jfxsi.MouseEvent) {
      handler(event)
    }
  }

  implicit def actionEventClosureWrapper(handler: (ActionEvent) => Unit) = new jfxe.EventHandler[jfxe.ActionEvent] {

    import EventIncludes.jfxActionEvent2sfx

    def handle(event: jfxe.ActionEvent) {
      handler(event)
    }
  }
}
