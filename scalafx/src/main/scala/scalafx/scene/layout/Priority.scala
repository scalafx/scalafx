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
import scalafx.scene.layout.LayoutIncludes.jfxPriority2sfx

import scala.language.implicitConversions

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Priority.html javafx.scene.layout.Priority]] */
object Priority extends SFXEnumDelegateCompanion[jfxsl.Priority, Priority] {

  case object Always extends Priority(jfxsl.Priority.ALWAYS)

  @deprecated("Use Always; ALWAYS will be removed in a future release", "2.2.60")
  val ALWAYS: Priority = Always

  case object Sometimes extends Priority(jfxsl.Priority.SOMETIMES)

  @deprecated("Use Sometimes; SOMETIMES will be removed in a future release", "2.2.60")
  val SOMETIMES: Priority = Sometimes

  case object Never extends Priority(jfxsl.Priority.NEVER)

  @deprecated("Use Never; NEVER will be removed in a future release", "2.2.60")
  val NEVER: Priority = Never

  protected override def unsortedValues: Array[Priority] = Array(Always, Sometimes, Never)

  /** Convenience method for returning the higher of two priorities. */
  def max(a: jfxsl.Priority, b: jfxsl.Priority): Priority = jfxsl.Priority.max(a, b)

  /** Convenience method for returning the lower of two priorities. */
  def min(a: jfxsl.Priority, b: jfxsl.Priority): Priority = jfxsl.Priority.min(a, b)
}

sealed abstract class Priority(override val delegate: jfxsl.Priority)
    extends SFXEnumDelegate[jfxsl.Priority]
