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
 * DISCLAIMED. IN NO Task SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * TaskS; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.concurrent

import org.junit.runner.RunWith
import javafx.{ concurrent => jfxc }
import scalafx.Includes._
import scalafx.testutil.SimpleSFXDelegateSpec
import org.scalatest.junit.JUnitRunner

/**
 * Task Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class TaskSpec[T]
  extends SimpleSFXDelegateSpec[jfxc.Task[T], Task[T]](classOf[jfxc.Task[T]], classOf[Task[T]]) {

  override protected def getScalaClassInstance = Task[T](null.asInstanceOf[T])

  protected def convertScalaClassToJavaClass(sfxObject: Task[T]) = {
    val jfxcvent: jfxc.Task[T] = sfxObject
    jfxcvent
  }

  override protected def getJavaClassInstance = new jfxc.Task[T] {
    def call = null.asInstanceOf[T]
  }

  protected def convertJavaClassToScalaClass(jfxObject: jfxc.Task[T]) = {
    val sfxTask: Task[T] = jfxObject
    sfxTask
  }

}
