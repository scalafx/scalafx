/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

package scalafx.scene.layout
import javafx.scene.layout as jfxsl
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/**
 * Companion Object for [[scalafx.scene.layout.HeaderButtonType]].
 */
object HeaderButtonType extends SFXEnumDelegateCompanion[jfxsl.HeaderButtonType, HeaderButtonType] {

  /**
   * Identifies the iconify button.
   *
   * @see [[scalafx.stage.Stage.iconified]]
   */
  case object Iconify extends HeaderButtonType(jfxsl.HeaderButtonType.ICONIFY)

  /**
   * Identifies the maximize button.
   *
   * This button toggles the [[scalafx.stage.Stage.maximized]] or [[scalafx.stage.Stage.fullScreen]] property,
   * depending on platform-specific invocation semantics. For example, on macOS the button will
   * put the window into full-screen mode by default, but maximize it to cover the desktop when
   * the option key is pressed.
   *
   * If the window is maximized, the button will have the `maximized` pseudo-class.
   *
   * @see [[scalafx.stage.Stage.maximized]]
   * @see [[scalafx.stage.Stage.fullScreen]]
   */
  case object Maximize extends HeaderButtonType(jfxsl.HeaderButtonType.MAXIMIZE)

  /**
   * Identifies the close button.
   *
   * @see [[scalafx.stage.Stage.close]]
   */
  case object Close extends HeaderButtonType(jfxsl.HeaderButtonType.CLOSE)

  protected override def unsortedValues: Array[HeaderButtonType] =
    Array(Iconify, Maximize, Close)
}

/**
 * Identifies the semantic type of a button in a custom [[HeaderBar]], which enables integrations
 * with the platform window manager. For example, hovering over a [[HeaderButtonType.Maximize]] button on Windows
 * will summon snap layouts.
 *
 * Wrapper for [[https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/HeaderButtonType.html]]
 */
sealed abstract class HeaderButtonType(override val delegate: jfxsl.HeaderButtonType)
    extends SFXEnumDelegate[jfxsl.HeaderButtonType]
