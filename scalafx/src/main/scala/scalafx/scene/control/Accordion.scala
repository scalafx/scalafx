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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.collections._
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Accordion {
  implicit def sfxAccordion2jfx(v: Accordion): jfxsc.Accordion = if (v != null) v.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Accordion.html]].
 */
class Accordion(override val delegate: jfxsc.Accordion = new jfxsc.Accordion)
    extends Control(delegate)
    with SFXDelegate[jfxsc.Accordion] {

  /**
   * The expanded TitledPane in the Accordion.
   */
  def expandedPane: ObjectProperty[jfxsc.TitledPane] = delegate.expandedPaneProperty

  def expandedPane_=(v: TitledPane): Unit = {
    expandedPane() = v
  }

  /**
   * The list of TitledPane in this Accordion.
   */
  def panes: ObservableBuffer[jfxsc.TitledPane] = delegate.getPanes

  /**
   * Sets the list of TitledPane in this Accordion, replacing the prior content. If you want append to current content,
   * use `add` or similar.
   *
   * @param c list of TitledPane in this Accordion to replace prior content.
   */
  def panes_=(c: Iterable[TitledPane]): Unit = {
    fillSFXCollection(this.panes, c)
  }

}
