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

package scalafx.application

import javafx.application as jfxa
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

object ColorScheme extends SFXEnumDelegateCompanion[jfxa.ColorScheme, ColorScheme] {

  /** A dark color scheme uses dark backgrounds and bright text. */
  val Dark: ColorScheme = new ColorScheme(jfxa.ColorScheme.DARK)

  /** A light color scheme uses bright backgrounds and dark text. */
  val Light: ColorScheme = new ColorScheme(jfxa.ColorScheme.LIGHT)

  override val unsortedValues: Array[ColorScheme] = Array(Dark, Light)
}

/**
 * Defines the color scheme of the user interface,
 * which specifies whether applications should prefer light text on dark backgrounds,
 * or dark text on light backgrounds.
 *
 * Wraps [[https://openjfx.io/javadoc/22/javafx.graphics/javafx/application/ColorScheme.html javafx.application.ColorScheme]]
 *
 * @since JavaFX 22
 */
class ColorScheme(override val delegate: jfxa.ColorScheme)
    extends SFXEnumDelegate[jfxa.ColorScheme]
