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
package scalafx.scene.chart

import javafx.scene.chart as jfxsc
import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import scalafx.testutil.{RunOnApplicationThread, SimpleSFXDelegateSpec}

/**
 * Axis Spec tests.
 */
class AxisSpec[T]
    extends SimpleSFXDelegateSpec[jfxsc.Axis[T], Axis[T]](classOf[jfxsc.Axis[T]], classOf[Axis[T]])
    with RunOnApplicationThread {

  override def getScalaClassInstance: Axis[T] = new Axis[T](getJavaClassInstance) {}

  override def getJavaClassInstance: jfxsc.Axis[T] = new jfxsc.Axis[T] {
    protected def autoRange(length: Double): AnyRef                                  = null
    protected def calculateTickValues(length: Double, range: Any): java.util.List[T] = new java.util.ArrayList[T]
    def getDisplayPosition(value: T): Double                                         = 0.0
    protected def getRange: AnyRef                                                   = null
    protected def getTickMarkLabel(value: T): String                                 = ""
    def getValueForDisplay(displayPosition: Double): T                               = null.asInstanceOf[T]
    def getZeroPosition: Double                                                      = 0.0
    def isValueOnAxis(value: T): Boolean                                             = false

    protected def setRange(range: Any, animate: Boolean): Unit = {}

    def toNumericValue(value: T): Double = 0.0
    def toRealValue(value: Double): T    = null.asInstanceOf[T]
  }

  it should "correctly implement invalidateRange [Issue #310]" in {
    val a = new NumberAxis()
    a.invalidateRange(ObservableBuffer.empty[Number])
  }

}
