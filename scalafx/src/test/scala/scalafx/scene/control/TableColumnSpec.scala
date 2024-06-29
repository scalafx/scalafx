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
import org.scalatest.matchers.should.Matchers._
import scalafx.Includes._
import scalafx.testutil.SimpleSFXDelegateSpec

/**
 * TableColumnSpec tests.
 */
class TableColumnSpec[S, T]
    extends SimpleSFXDelegateSpec[jfxsc.TableColumn[S, T], TableColumn[S, T]](
      classOf[jfxsc.TableColumn[S, T]],
      classOf[TableColumn[S, T]]
    ) {

  it should " have parametrized default constructor - Issue 40" in {
    // Without correctly parametrized default constructor following line was throwing exception:
    //   error: polymorphic expression cannot be instantiated to expected type;
    //   found   : [S, T]javafx.scene.control.TableColumn[Nothing,Nothing]
    //   required: javafx.scene.control.TableColumn[String,String]
    new TableColumn[String, String]()
  }

  it should "not drop nested columns - Issue 44" in {
    val firstTC = new TableColumn[String, String]("First")
    val lastTC  = new TableColumn[String, String]("Last")

    val nameTC = new TableColumn[String, String]("Name")
    nameTC.columns.size should (equal(0))

    nameTC.columns.addAll(firstTC, lastTC)
    nameTC.columns.size should (equal(2))

    nameTC.columns.clear()
    nameTC.columns.size should (equal(0))
  }

  it should "allow a cellValueFactory to return null" in {
    val tc = new TableColumn[String, String]("col") {
      cellValueFactory = { _cdf => null }
    }
    tc.cellValueFactory()(null)
  }
}
