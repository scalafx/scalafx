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
package scalafx.print

import scalafx.delegate.SFXDelegate
import scala.language.implicitConversions
import javafx.{print => jfxp}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.IntegerProperty
import scalafx.beans.property.StringProperty

/**
 * Companion Object for [[scalafx.print.PaperSource]].
 */
object PaperSource {

  /**
   * Converts a ScalaFX PaperSource to its JavaFX counterpart.
   *
   * @param ps ScalaFX PaperSource
   * @return JavaFX PaperSource
   */
  implicit def sfxPaperSource2jfx(ps: PaperSource): jfxp.PaperSource = if (ps != null) ps.delegate else null

  /** Specify to automatically select the tray. */
  val Automatic: PaperSource = new PaperSource(jfxp.PaperSource.AUTOMATIC)

  /** Specify to select the BOTTOM tray. */
  val Bottom: PaperSource = new PaperSource(jfxp.PaperSource.BOTTOM)

  /** Specify to select the ENVELOPE tray. */
  val Envelope: PaperSource = new PaperSource(jfxp.PaperSource.ENVELOPE)

  /** Specify to select the LARGE_CAPACITY tray. */
  val LargeCapatity: PaperSource = new PaperSource(jfxp.PaperSource.LARGE_CAPACITY)

  /** Specify to select the MAIN tray. */
  val Main: PaperSource = new PaperSource(jfxp.PaperSource.MAIN)

  /** Specify to select the MANUAL tray. */
  val Manual: PaperSource = new PaperSource(jfxp.PaperSource.MANUAL)

  /** Specify to select the MIDDLE tray. */
  val Middle: PaperSource = new PaperSource(jfxp.PaperSource.MIDDLE)

  /** Specify to select the SIDE tray. */
  val Side: PaperSource = new PaperSource(jfxp.PaperSource.SIDE)

  /** Specify to select the TOP tray. */
  val Top: PaperSource = new PaperSource(jfxp.PaperSource.TOP)

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/PaperSource.html JavaFX PaperSource]].
 *
 * @constructor Creates a new ScalaFX PaperSource from its JavaFX counterpart.
 * @param delegate JavaFX PaperSource. Since there is no public constructor for it, there is not a default value.
 *
 * @since 8.0
 */
final class PaperSource(override val delegate: jfxp.PaperSource)
  extends SFXDelegate[jfxp.PaperSource] {

  /**
   * The name of this paper source.
   */
  def name: String = delegate.getName

}