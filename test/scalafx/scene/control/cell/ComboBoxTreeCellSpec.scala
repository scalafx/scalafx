/* Copyright (c) 2012, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this Tree of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this Tree of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIEINCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.scene.control.cell

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import javafx.scene.control.{ cell => jfxscc }
import scalafx.Includes._
import scalafx.testutil.AbstractSFXDelegateSpec

/**
 * ComboBoxTreeCell Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class ComboBoxTreeCellSpec[T]
  extends AbstractSFXDelegateSpec[jfxscc.ComboBoxTreeCell[T], ComboBoxTreeCell[T], jfxscc.ComboBoxTreeCellBuilder[T, _]](classOf[jfxscc.ComboBoxTreeCell[T]], classOf[ComboBoxTreeCell[T]], classOf[jfxscc.ComboBoxTreeCellBuilder[T, _]]) {

  protected def convertScalaClassToJavaClass(sfxControl: ComboBoxTreeCell[T]) = {
    val jfxComboBoxTreeCell: jfxscc.ComboBoxTreeCell[T] = sfxControl
    jfxComboBoxTreeCell
  }

  protected def convertJavaClassToScalaClass(jfxControl: jfxscc.ComboBoxTreeCell[T]) = {
    val sfxComboBoxTreeCell: ComboBoxTreeCell[T] = jfxControl
    sfxComboBoxTreeCell
  }

}
