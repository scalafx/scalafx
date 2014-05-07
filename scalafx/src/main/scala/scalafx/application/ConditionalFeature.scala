/*
* Copyright (c) 2011-2014, ScalaFX Project
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
package scalafx.application

import javafx.{application => jfxa}
import scalafx.delegate._


/**
 * ConditionalFeature
 */
/** Wrapper for [[javafx.application.ConditionalFeature]] */
object ConditionalFeature extends SFXEnumDelegateCompanion[jfxa.ConditionalFeature, ConditionalFeature] {

  val CONTROLS = new ConditionalFeature(jfxa.ConditionalFeature.CONTROLS)
  val GRAPHICS = new ConditionalFeature(jfxa.ConditionalFeature.GRAPHICS)
  val EFFECT = new ConditionalFeature(jfxa.ConditionalFeature.EFFECT)
  val FXML = new ConditionalFeature(jfxa.ConditionalFeature.FXML)
  val INPUT_METHOD = new ConditionalFeature(jfxa.ConditionalFeature.INPUT_METHOD)
  val INPUT_MULTITOUCH = new ConditionalFeature(jfxa.ConditionalFeature.INPUT_MULTITOUCH)
  val INPUT_POINTER = new ConditionalFeature(jfxa.ConditionalFeature.INPUT_POINTER)
  val INPUT_TOUCH = new ConditionalFeature(jfxa.ConditionalFeature.INPUT_TOUCH)
  val MEDIA = new ConditionalFeature(jfxa.ConditionalFeature.MEDIA)
  val SCENE3D = new ConditionalFeature(jfxa.ConditionalFeature.SCENE3D)
  val SHAPE_CLIP = new ConditionalFeature(jfxa.ConditionalFeature.SHAPE_CLIP)
  val SWING = new ConditionalFeature(jfxa.ConditionalFeature.SWING)
  val SWT = new ConditionalFeature(jfxa.ConditionalFeature.SWT)
  val TRANSPARENT_WINDOW = new ConditionalFeature(jfxa.ConditionalFeature.TRANSPARENT_WINDOW)
  val TWO_LEVEL_FOCUS = new ConditionalFeature(jfxa.ConditionalFeature.TWO_LEVEL_FOCUS)
  val UNIFIED_WINDOW = new ConditionalFeature(jfxa.ConditionalFeature.UNIFIED_WINDOW)
  val VIRTUAL_KEYBOARD = new ConditionalFeature(jfxa.ConditionalFeature.VIRTUAL_KEYBOARD)
  val WEB = new ConditionalFeature(jfxa.ConditionalFeature.WEB)

  protected override def unsortedValues: Array[ConditionalFeature] = Array(
    GRAPHICS, CONTROLS, MEDIA, WEB, SWT, SWING, FXML, SCENE3D, EFFECT, SHAPE_CLIP, INPUT_METHOD, TRANSPARENT_WINDOW,
    UNIFIED_WINDOW, TWO_LEVEL_FOCUS,  VIRTUAL_KEYBOARD, INPUT_TOUCH, INPUT_MULTITOUCH, INPUT_POINTER
  )
}


sealed case class ConditionalFeature(override val delegate: jfxa.ConditionalFeature) extends SFXEnumDelegate[jfxa.ConditionalFeature]
