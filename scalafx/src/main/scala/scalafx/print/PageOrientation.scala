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

import javafx.{print => jfxp}

import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/**
 * Companion Object for [[scalafx.print.PageOrientation]].
 */
object PageOrientation
  extends SFXEnumDelegateCompanion[jfxp.PageOrientation, PageOrientation] {

  /**
   * The printable area's origin is at the bottom left of the paper.
   */
  val Landscape = new PageOrientation(jfxp.PageOrientation.LANDSCAPE)

  /**
   * The printable area's origin is at the top left of the paper.
   */
  val Portrait = new PageOrientation(jfxp.PageOrientation.PORTRAIT)

  /**
   * The printable area's origin is at the top right of the paper.
   */
  val ReverseLandcsape = new PageOrientation(jfxp.PageOrientation.REVERSE_LANDSCAPE)

  /**
   * The printable area's origin is at the bottom right of the paper.
   */
  val ReversePortrait = new PageOrientation(jfxp.PageOrientation.REVERSE_PORTRAIT)

  protected override def unsortedValues: Array[PageOrientation] =
    Array(Landscape, Portrait, ReverseLandcsape, ReversePortrait)

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/print/PageOrientation.html JavaFX PageOrientation]].
 */
sealed case class PageOrientation(override val delegate: jfxp.PageOrientation)
  extends SFXEnumDelegate[jfxp.PageOrientation]