/*
 * Copyright (c) 2011-2026, ScalaFX Project
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

package scalafx.scene.text

import javafx.scene.text as jfxst
import scalafx.Includes.*
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object TabStopPolicy {
  implicit def sfxTabStopPolicy2jfx(v: TabStopPolicy): jfxst.TabStopPolicy = if (v != null) v.delegate else null
}

/**
 * The TabStopPolicy determines the tab stop positions within the text layout.
 *
 * Wraps [[https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/text/TabStopPolicy.html]]
 *
 * @since 25
 */
class TabStopPolicy(override val delegate: jfxst.TabStopPolicy = new jfxst.TabStopPolicy)
    extends SFXDelegate[jfxst.TabStopPolicy] {

  /**
   * Specifies the default tab stop interval for tabs beyond the last stop provided by tabStops().
   * This is a fixed repeating distance (in pixels) to the next tab stop computed at regular intervals relative to
   * the leading edge of the TextFlow node.
   *
   * A value of less than or equal to 0 disables the default interval.
   */
  def defaultInterval: DoubleProperty = delegate.defaultIntervalProperty

  def defaultInterval_=(v: Double): Unit = {
    defaultInterval() = v
  }

}
