package scalafx.scene.chart

import scalafx.collections.ObservableBuffer

import scala.annotation.targetName

trait XYChartVersionSpecific[X, Y] { self: XYChart[X, Y] =>
  
  @targetName("data_=ObservableBufferScalafxXYChartSeries")
  def data_=(v: ObservableBuffer[XYChart.Series[X, Y]]): Unit = {
    data() = v.map(_.delegate)
  }

  @targetName("data_=SeqScalafxXYChartSeries")
  def data_=(v: Seq[XYChart.Series[X, Y]]): Unit = {
    data() = ObservableBuffer.from(v).map(_.delegate)
  }
}
