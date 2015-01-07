/*
 * Copyright (c) 2011-2015, ScalaFX Project
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


/** Wrapper for [[http://docs.oracle.com/javafx/2/api/javafx/application/ConditionalFeature.html javafx.application.ConditionalFeature]] */
object ConditionalFeature extends SFXEnumDelegateCompanion[jfxa.ConditionalFeature, ConditionalFeature] {

  val Scene3D = new ConditionalFeature(jfxa.ConditionalFeature.SCENE3D)
  @deprecated ("Use Scene3D; SCENE3D will be removed in a future release", "2.2.60")
  val SCENE3D = Scene3D
  val Effect = new ConditionalFeature(jfxa.ConditionalFeature.EFFECT)
  @deprecated ("Use Effect; EFFECT will be removed in a future release", "2.2.60")
  val EFFECT = Effect
  val ShapeClip = new ConditionalFeature(jfxa.ConditionalFeature.SHAPE_CLIP)
  @deprecated ("Use ShapeClip; SHAPE_CLIP will be removed in a future release", "2.2.60")
  val SHAPE_CLIP = ShapeClip
  val InputMethod = new ConditionalFeature(jfxa.ConditionalFeature.INPUT_METHOD)
  @deprecated ("Use InputMethod; INPUT_METHOD will be removed in a future release", "2.2.60")
  val INPUT_METHOD = InputMethod
  val TransparentWindow = new ConditionalFeature(jfxa.ConditionalFeature.TRANSPARENT_WINDOW)
  @deprecated ("Use TransparentWindow; TRANSPARENT_WINDOW will be removed in a future release", "2.2.60")
  val TRANSPARENT_WINDOW = TransparentWindow

  protected override def unsortedValues: Array[ConditionalFeature] = Array(
    Scene3D, Effect, ShapeClip, InputMethod, TransparentWindow
  )
}


sealed case class ConditionalFeature(override val delegate: jfxa.ConditionalFeature) extends SFXEnumDelegate[jfxa.ConditionalFeature]
