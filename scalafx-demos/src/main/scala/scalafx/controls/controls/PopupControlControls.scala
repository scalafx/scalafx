/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

/**
 *
 */
package scalafx.controls.controls

import scalafx.Includes._
import scalafx.scene.control._

class PopupControlControls(target: PopupControl) extends PropertiesNodes[PopupControl](target, "Popup Control Properties") {

  val originalId: String = target.id.get()
  val txfID = new TextField {
    text <==> target.id
    prefWidth = 50.0
    minWidth = 50.0
//    maxWidth = 50.0
  }

  val originalMaxHeight: Double = target.maxHeight.get()
  val originalMinHeight: Double = target.minHeight.get()
  val originalPrefHeight = target.prefHeight
  val originalPrefWidth = target.prefWidth
  val originalMinWidth = target.minWidth
  val originalMaxWidth = target.maxWidth
  

  super.addNode("ID", txfID)
  super.addNode("Pref Width", new SliderLabelControl(target.prefWidth))
  super.addNode("Min Width", new SliderLabelControl(target.minWidth))
  super.addNode("Max Width", new SliderLabelControl(target.maxWidth) {
    max = 200d
  })
  super.addNode("Pref Height", new SliderLabelControl(target.prefHeight))
  super.addNode("Min Height", new SliderLabelControl(target.minHeight))
  super.addNode("Max Height", new SliderLabelControl(target.maxHeight)) 

}
/*
def id = delegate.idProperty
def skin = delegate.skinProperty
def style_=(v: String) {
*/