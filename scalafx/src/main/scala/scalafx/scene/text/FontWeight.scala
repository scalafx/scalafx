/*
 * Copyright (c) 2011-2018, ScalaFX Project
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
import scalafx.Includes._
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/FontWeight.html javafx.scene.text.FontWeight]] */
object FontWeight extends SFXEnumDelegateCompanion[jfxst.FontWeight, FontWeight] {

  case object Thin extends FontWeight(jfxst.FontWeight.THIN)
  @deprecated("Use Thin; THIN will be removed in a future release", "2.2.60")
  val THIN = Thin

  case object ExtraLight extends FontWeight(jfxst.FontWeight.EXTRA_LIGHT)
  @deprecated("Use ExtraLight; EXTRA_LIGHT will be removed in a future release", "2.2.60")
  val EXTRA_LIGHT = ExtraLight

  case object Light extends FontWeight(jfxst.FontWeight.LIGHT)
  @deprecated("Use Light; LIGHT will be removed in a future release", "2.2.60")
  val LIGHT = Light

  case object Normal extends FontWeight(jfxst.FontWeight.NORMAL)
  @deprecated("Use Normal; NORMAL will be removed in a future release", "2.2.60")
  val NORMAL = Normal

  case object Medium extends FontWeight(jfxst.FontWeight.MEDIUM)
  @deprecated("Use Medium; MEDIUM will be removed in a future release", "2.2.60")
  val MEDIUM = Medium

  case object SemiBold extends FontWeight(jfxst.FontWeight.SEMI_BOLD)
  @deprecated("Use SemiBold; SEMI_BOLD will be removed in a future release", "2.2.60")
  val SEMI_BOLD = SemiBold

  case object Bold extends FontWeight(jfxst.FontWeight.BOLD)
  @deprecated("Use Bold; BOLD will be removed in a future release", "2.2.60")
  val BOLD = Bold

  case object ExtraBold extends FontWeight(jfxst.FontWeight.EXTRA_BOLD)
  @deprecated("Use ExtraBold; EXTRA_BOLD will be removed in a future release", "2.2.60")
  val EXTRA_BOLD = ExtraBold

  case object Black extends FontWeight(jfxst.FontWeight.BLACK)
  @deprecated("Use Black; BLACK will be removed in a future release", "2.2.60")
  val BLACK = Black

  protected override def unsortedValues: Array[FontWeight] = Array(
    Thin,
    ExtraLight,
    Light,
    Normal,
    Medium,
    SemiBold,
    Bold,
    ExtraBold,
    Black
  )

  /** Returns FontWeight by its name. */
  def findByName(name: String): FontWeight = jfxst.FontWeight.findByName(name)

  /** Returns the closest [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/FontWeight.html javafx.scene.text.FontWeight]] for a weight value as defined by the CSS
    * and OpenType specifications.
    */
  def findByWeight(weight: Int): FontWeight = jfxst.FontWeight.findByWeight(weight)
}

sealed abstract class FontWeight(override val delegate: jfxst.FontWeight) extends SFXEnumDelegate[jfxst.FontWeight] {

  /** Return the visual weight (degree of blackness or thickness) specified by this FontWeight.  */
  def weight = delegate.getWeight
}
