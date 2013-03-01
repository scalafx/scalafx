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
package scalafx.scene.control

import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scalafx.testutil.AbstractSFXDelegateSpec
import scalafx.testutil.RunOnApplicationThread
import org.scalatest.matchers.ShouldMatchers._

/**
 * ContextMenu Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class ContextMenuSpec
  extends AbstractSFXDelegateSpec[jfxsc.ContextMenu, ContextMenu, jfxsc.ContextMenuBuilder[_]](
    classOf[jfxsc.ContextMenu], classOf[ContextMenu], classOf[jfxsc.ContextMenuBuilder[_]])
  with RunOnApplicationThread  {

  it should "not drop assigned items - Issue 42" in {
    val menuItemA = new MenuItem("MenuItemA")
    val menuItemB = new MenuItem("MenuItemB")

    val contexMenu = new ContextMenu()
    contexMenu.items.size should (equal(0))

    contexMenu.items +=(menuItemA, menuItemB)
    contexMenu.items.size should (equal(2))
  }
}