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
package scalafx.scene.transform

import javafx.scene.{transform => jfxst}
import scalafx.delegate.{SFXEnumDelegateCompanion, SFXEnumDelegate}

/** Wrapper for [[javafx.scene.transform.MatrixType]] */
object MatrixType extends SFXEnumDelegateCompanion[jfxst.MatrixType, MatrixType] {

  /** A 2D affine transformation matrix of 2 rows and 3 columns. */
  val MT_2D_2x3 = new MatrixType(jfxst.MatrixType.MT_2D_2x3)
  /** A 2D transformation matrix of 3 rows and 3 columns. */
  val MT_2D_3x3 = new MatrixType(jfxst.MatrixType.MT_2D_3x3)
  /** A 3D affine transformation matrix of 3 rows and 4 columns */
  val MT_3D_3x4 = new MatrixType(jfxst.MatrixType.MT_3D_3x4)
  /** A 3D transformation matrix of 4 rows and 4 columns */
  val MT_3D_4x4 = new MatrixType(jfxst.MatrixType.MT_3D_4x4)

  protected override def unsortedValues: Array[MatrixType] = Array(MT_2D_2x3, MT_2D_3x3, MT_3D_3x4, MT_3D_4x4)
}


sealed case class MatrixType(override val delegate: jfxst.MatrixType)
  extends SFXEnumDelegate[jfxst.MatrixType] {
  /** Returns the number of columns in the matrix of this type. */
  def columns: Int = delegate.columns

  /** Returns the number of elements in the matrix of this type. */
  def elements: Int = delegate.elements

  /** Specifies if this is a 2D transformation matrix */
  def is2D: Boolean = delegate.is2D

  /** Returns the number of rows in the matrix of this type. */
  def rows: Int = delegate.rows
}
