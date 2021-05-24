/*
 * Copyright (c) 2011-2020, ScalaFX Project
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
 * Wrapper for
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/application/ConditionalFeature.htmljavafx.application.ConditionalFeature]]
 */
object ConditionalFeature extends SFXEnumDelegateCompanion[jfxa.ConditionalFeature, ConditionalFeature] {

  case object Controls extends ConditionalFeature(jfxa.ConditionalFeature.CONTROLS)
  @deprecated("Use Controls; CONTROLS will be removed in a future release", "8.0.5")
  val CONTROLS: ConditionalFeature = Controls

  case object Graphics extends ConditionalFeature(jfxa.ConditionalFeature.GRAPHICS)

  @deprecated("Use Graphics; GRAPHICS will be removed in a future releas", "8.0.5")
  val GRAPHICS: ConditionalFeature = Graphics

  case object Effect extends ConditionalFeature(jfxa.ConditionalFeature.EFFECT)

  @deprecated("Use Effect; EFFECT will be removed in a future release", "2.2.60")
  val EFFECT: ConditionalFeature = Effect

  case object FXML extends ConditionalFeature(jfxa.ConditionalFeature.FXML)

  case object InputMethod extends ConditionalFeature(jfxa.ConditionalFeature.INPUT_METHOD)

  @deprecated("Use InputMethod; INPUT_METHOD will be removed in a future release", "2.2.60")
  val INPUT_METHOD: ConditionalFeature = InputMethod

  case object InputMultitouch extends ConditionalFeature(jfxa.ConditionalFeature.INPUT_MULTITOUCH)

  @deprecated("Use InputMultitouch; INPUT_MULTITOUCH will be removed in a future releas", "8.0.5")
  val INPUT_MULTITOUCH: ConditionalFeature = InputMultitouch

  case object InputPointer extends ConditionalFeature(jfxa.ConditionalFeature.INPUT_POINTER)

  @deprecated("Use InputPointer; INPUT_POINTER will be removed in a future releas", "8.0.5")
  val INPUT_POINTER: ConditionalFeature = InputPointer

  case object InputTouch extends ConditionalFeature(jfxa.ConditionalFeature.INPUT_TOUCH)

  @deprecated("Use InputTouch; INPUT_TOUCH will be removed in a future releas", "8.0.5")
  val INPUT_TOUCH: ConditionalFeature = InputTouch

  case object Media extends ConditionalFeature(jfxa.ConditionalFeature.MEDIA)

  @deprecated("Use Media; MEDIA will be removed in a future releas", "8.0.5")
  val MEDIA: ConditionalFeature = Media

  case object Scene3D extends ConditionalFeature(jfxa.ConditionalFeature.SCENE3D)

  @deprecated("Use Scene3D; SCENE3D will be removed in a future release", "2.2.60")
  val SCENE3D: ConditionalFeature = Scene3D

  case object ShapeClip extends ConditionalFeature(jfxa.ConditionalFeature.SHAPE_CLIP)

  @deprecated("Use ShapeClip; SHAPE_CLIP will be removed in a future release", "2.2.60")
  val SHAPE_CLIP: ConditionalFeature = ShapeClip

  case object Swing extends ConditionalFeature(jfxa.ConditionalFeature.SWING)

  @deprecated("Use Swing; SWING will be removed in a future releas", "8.0.5")
  val SWING: ConditionalFeature = Swing

  case object SWT extends ConditionalFeature(jfxa.ConditionalFeature.SWT)

  case object TransparentWindow extends ConditionalFeature(jfxa.ConditionalFeature.TRANSPARENT_WINDOW)

  @deprecated("Use TransparentWindow; TRANSPARENT_WINDOW will be removed in a future release", "2.2.60")
  val TRANSPARENT_WINDOW: ConditionalFeature = TransparentWindow

  case object TwoLevelFocus extends ConditionalFeature(jfxa.ConditionalFeature.TWO_LEVEL_FOCUS)

  @deprecated("Use TwoLevelFocus; TWO_LEVEL_FOCUS will be removed in a future releas", "8.0.5")
  val TWO_LEVEL_FOCUS: ConditionalFeature = TwoLevelFocus

  case object UnifiedWindow extends ConditionalFeature(jfxa.ConditionalFeature.UNIFIED_WINDOW)

  @deprecated("Use UnifiedWindow; UNIFIED_WINDOW will be removed in a future releas", "8.0.5")
  val UNIFIED_WINDOW: ConditionalFeature = UnifiedWindow

  case object VirtualKeyboard extends ConditionalFeature(jfxa.ConditionalFeature.VIRTUAL_KEYBOARD)

  @deprecated("Use VirtualKeyboard; VIRTUAL_KEYBOARD will be removed in a future releas", "8.0.5")
  val VIRTUAL_KEYBOARD: ConditionalFeature = VirtualKeyboard

  case object Web extends ConditionalFeature(jfxa.ConditionalFeature.WEB)

  @deprecated("Use Web; WEB will be removed in a future releas", "8.0.5")
  val WEB: ConditionalFeature = Web

  protected override def unsortedValues: Array[ConditionalFeature] = Array(
    Graphics,
    Controls,
    Media,
    Web,
    SWT,
    Swing,
    FXML,
    Scene3D,
    Effect,
    ShapeClip,
    InputMethod,
    TransparentWindow,
    UnifiedWindow,
    TwoLevelFocus,
    VirtualKeyboard,
    InputTouch,
    InputMultitouch,
    InputPointer
  )
}

sealed abstract class ConditionalFeature(override val delegate: jfxa.ConditionalFeature)
    extends SFXEnumDelegate[jfxa.ConditionalFeature]
