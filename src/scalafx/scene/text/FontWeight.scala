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

package scalafx.scene.text

import javafx.scene.{text => jfxst}
import scalafx.util.{SFXEnumDelegateCompanion, SFXEnumDelegate}


/** Wrapper for [[javafx.scene.text.FontWeight]] */
object FontWeight extends SFXEnumDelegateCompanion[jfxst.FontWeight, FontWeight] {

  val THIN = new FontWeight(jfxst.FontWeight.THIN)
  val EXTRA_LIGHT = new FontWeight(jfxst.FontWeight.EXTRA_LIGHT)
  val LIGHT = new FontWeight(jfxst.FontWeight.LIGHT)
  val NORMAL = new FontWeight(jfxst.FontWeight.NORMAL)
  val MEDIUM = new FontWeight(jfxst.FontWeight.MEDIUM)
  val SEMI_BOLD = new FontWeight(jfxst.FontWeight.SEMI_BOLD)
  val BOLD = new FontWeight(jfxst.FontWeight.BOLD)
  val EXTRA_BOLD = new FontWeight(jfxst.FontWeight.EXTRA_BOLD)
  val BLACK = new FontWeight(jfxst.FontWeight.BLACK)

  lazy val values = List(THIN, EXTRA_LIGHT, LIGHT, NORMAL, MEDIUM, SEMI_BOLD, BOLD, EXTRA_BOLD, BLACK)

  /** Returns FontWeight by its name. */
  def findByName(name: String) = jfxst.FontWeight.findByName(name)

  /** Returns the closest [[javafx.scene.text.FontWeight]] for a weight value as defined by the CSS
    * and OpenType specifications.
    */
  def findByWeight(weight: Int): FontWeight = jfxst.FontWeight.findByWeight(weight)
}


sealed case class FontWeight(override val delegate: jfxst.FontWeight)
  extends SFXEnumDelegate[jfxst.FontWeight] {

  /** Return the visual weight (degree of blackness or thickness) specified by this FontWeight.  */
  def weight = delegate.getWeight
}
