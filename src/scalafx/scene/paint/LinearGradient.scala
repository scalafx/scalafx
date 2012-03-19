/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.scene.paint

import javafx.scene.{paint => jfxsp}
import scalafx.util.SFXDelegate

object LinearGradient {
  implicit def sfxLinearGradient2jfx(c: LinearGradient) = c.delegate
  
  def apply(startX: Double, startY: Double, endX: Double, endY: Double, proportional: Boolean, cycleMethod: CycleMethod, stops: List[Stop]) { 
    val stopsList = new java.util.ArrayList[jfxsp.Stop](stops.length)
    for (stop <- stops) stopsList.add(stop)
    new LinearGradient(new jfxsp.LinearGradient(startX, startY, endX, endY, proportional, cycleMethod, stopsList))
  }

  def apply(startX: Double, startY: Double, endX: Double, endY: Double, proportional: Boolean, cycleMethod: CycleMethod, stops: Stop*) {
    val stopsList = new java.util.ArrayList[jfxsp.Stop](stops.length)
    for (stop <- stops) stopsList.add(stop)
    new LinearGradient(new jfxsp.LinearGradient(startX, startY, endX, endY, proportional, cycleMethod, stopsList))
  }
}

class LinearGradient(override val delegate:jfxsp.LinearGradient) extends Paint(delegate) with SFXDelegate[jfxsp.LinearGradient] {
  def cycleMethod = delegate.getCycleMethod
  def endX = delegate.getEndX
  def endY = delegate.getEndY
  def startX = delegate.getStartX
  def startY = delegate.getStartY
  def stops = delegate.getStops
  def proportional = delegate.isProportional
}