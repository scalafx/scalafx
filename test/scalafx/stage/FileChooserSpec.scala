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

package scalafx.stage

import javafx.{ stage => jfxs }
import scalafx.Includes._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scalafx.testutil.AbstractSFXDelegateSpec
import scalafx.testutil.RunOnApplicationThread

@RunWith(classOf[JUnitRunner]) 
/**
 * FileChooser Spec tests.
 * 
 *
 */
class FileChooserSpec extends AbstractSFXDelegateSpec[jfxs.FileChooser, FileChooser, jfxs.FileChooserBuilder](classOf[jfxs.FileChooser], classOf[FileChooser], classOf[jfxs.FileChooserBuilder]) with RunOnApplicationThread {

  protected def getScalaClassInstance = new FileChooser(this.getJavaClassInstance)

  protected def convertScalaClassToJavaClass(sfxControl: FileChooser) = {
    val jfxFileChooser: jfxs.FileChooser = sfxControl
    jfxFileChooser
  }

  protected def getJavaClassInstance = new jfxs.FileChooser

  protected def convertJavaClassToScalaClass(jfxControl: jfxs.FileChooser) = {
    val sfxFileChooser: FileChooser = jfxControl
    sfxFileChooser
  }

}
