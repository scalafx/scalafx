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

package scalafx.controls.controls

import scalafx.Includes._
import scalafx.scene.control.{Tooltip, Control, Label, TextField}

class ControlControls(target: Control) extends PropertiesNodes[Control](target, "Control Properties") {

  val lblHeight = new Label {
    text <== target.height.asString()
  }

  val lblWidth = new Label {
    text <== target.width.asString()
  }

  val originalMaxHeight = target.maxHeight
  val sldMaxHeight = new SliderLabelControl(target.maxHeight) {
    min = -10
  }

  val originalPrefHeight = target.prefHeight
  val sldPrefHeight = new SliderLabelControl(target.prefHeight) {
    min = -10
  }

  val originalMinHeight = target.minHeight
  val sldinHeight = new SliderLabelControl(target.minHeight) {
    min = -10
  }

  val originalMinWidth = target.minWidth
  val sldMinWidth = new SliderLabelControl(target.minWidth) {
    min = -10
  }

  val originalPrefWidth = target.prefWidth
  val sldPrefWidth = new SliderLabelControl(target.prefWidth) {
    min = -10
  }

  val originalMaxWidth = target.maxWidth
  val sldMaxWidth = new SliderLabelControl(target.maxWidth) {
    min = -10
  }

  val txfTootip = new TextField
  txfTootip.text.onChange {
    target.tooltip = if (txfTootip.text.get.isEmpty) null else Tooltip(txfTootip.text())
  }

  super.addNode("Max Height", sldMaxHeight)
  super.addNode("Pref Height", sldPrefHeight)
  super.addNode("Min Height", sldinHeight)
  super.addNode("Max Width", sldMaxWidth)
  super.addNode("Pref Width", sldPrefWidth)
  super.addNode("Min Width", sldMinWidth)
  super.addNode("Tooltip", txfTootip)
  super.addNode("Height", lblHeight)
  super.addNode("Width", lblWidth)
//  super.addNode(btnReset)

  override def resetProperties {
    target.maxHeight = originalMaxHeight.get
    target.prefHeight = originalPrefHeight.get
    target.minHeight = originalMinHeight.get
    target.minWidth = originalMinWidth.get
    target.prefWidth = originalPrefWidth.get
    target.maxWidth = originalMaxWidth.get
  }
}
/*
ObjectProperty<ContextMenu>	contextMenu
The ContextMenu to show for this control.

ObjectProperty<Skin<?>>	skin
Skin is responsible for rendering this Control.

*/