/*
 * Copyright (c) 2011-2025, ScalaFX Project
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
import scalafx.beans.property.{BooleanProperty, ObjectProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}

import scala.language.implicitConversions

object LineChart {
  implicit def sfxLineChart2jfx[X, Y](v: LineChart[X, Y]): jfxsc.LineChart[X, Y] = if (v != null) v.delegate else null

  def apply[X, Y](xAxis: Axis[X], yAxis: Axis[Y]) =
    new LineChart[X, Y](new jfxsc.LineChart[X, Y](xAxis, yAxis))

  def apply[X, Y](xAxis: Axis[X], yAxis: Axis[Y], data: ObservableBuffer[jfxsc.XYChart.Series[X, Y]]) =
    new LineChart[X, Y](new jfxsc.LineChart[X, Y](xAxis, yAxis, data))

  object SortingPolicy extends SFXEnumDelegateCompanion[jfxsc.LineChart.SortingPolicy, SortingPolicy] {

    /**
     * The data should be left in the order defined by the list in [[scalafx.scene.chart.LineChart.data]] property.
     */
    case object None extends SortingPolicy(jfxsc.LineChart.SortingPolicy.NONE)

    /**
     * The data is ordered by x axis.
     */
    case object XAxis extends SortingPolicy(jfxsc.LineChart.SortingPolicy.X_AXIS)

    /**
     * The data is ordered by y axis.
     */
    case object YAxis extends SortingPolicy(jfxsc.LineChart.SortingPolicy.Y_AXIS)

    protected override def unsortedValues: Array[SortingPolicy] = Array(None, XAxis, YAxis)
  }

  sealed abstract class SortingPolicy(override val delegate: jfxsc.LineChart.SortingPolicy)
      extends SFXEnumDelegate[jfxsc.LineChart.SortingPolicy]

}

class LineChart[X, Y](override val delegate: jfxsc.LineChart[X, Y])
    extends XYChart[X, Y](delegate)
    with SFXDelegate[jfxsc.LineChart[X, Y]] {

  def this(xAxis: Axis[X], yAxis: Axis[Y]) = {
    this(new jfxsc.LineChart[X, Y](xAxis, yAxis))
  }

  def this(xAxis: Axis[X], yAxis: Axis[Y], data: ObservableBuffer[jfxsc.XYChart.Series[X, Y]]) = {
    this(new jfxsc.LineChart[X, Y](xAxis, yAxis, data))
  }

  /**
   * Indicates whether the data passed to LineChart should be sorted by natural order of one of the axes.
   */
  def axisSortingPolicy: ObjectProperty[jfxsc.LineChart.SortingPolicy] = delegate.axisSortingPolicyProperty

  def axisSortingPolicy_=(v: LineChart.SortingPolicy): Unit = {
    ObjectProperty.fillProperty(axisSortingPolicy, v)
  }

  def createSymbols: BooleanProperty = delegate.createSymbolsProperty

  def createSymbols_=(v: Boolean): Unit = {
    createSymbols() = v
  }
}
