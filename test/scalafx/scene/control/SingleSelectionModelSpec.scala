package scalafx.scene.control

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

import javafx.scene.{ control => jfxsc }
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scalafx.Includes._
import scalafx.testutil.SimpleSFXDelegateSpec

@RunWith(classOf[JUnitRunner]) 
/**
 * SingleSelectionModel[T] Spec tests.
 * 
 */
class SingleSingleSelectionModelSpec[T] extends SimpleSFXDelegateSpec[jfxsc.SingleSelectionModel[T], SingleSelectionModel[T]](classOf[jfxsc.SingleSelectionModel[T]], classOf[SingleSelectionModel[T]]) {

  protected def getScalaClassInstance = new SingleSelectionModel[T](getJavaClassInstance) {}

  protected def convertScalaClassToJavaClass(sfxControl: SingleSelectionModel[T]) = {
    val jfxSingleSelectionModel: jfxsc.SingleSelectionModel[T] = sfxControl.delegate
    jfxSingleSelectionModel
  }

  // How SingleSelectionModel is a abstract class, it is done a basic implementation
  protected def getJavaClassInstance = new jfxsc.SingleSelectionModel[T] {
    def clearSingleSelection {}
    def clearSingleSelection(index: Int) {}
    def getItemCount = {0}
    def getModelItem(index: Int) = { null.asInstanceOf[T] }
    
  }

  protected def convertJavaClassToScalaClass(jfxControl: jfxsc.SingleSelectionModel[T]) = {
    val sfxSingleSelectionModel: SingleSelectionModel[T] = jfxControl
    sfxSingleSelectionModel
  }

}