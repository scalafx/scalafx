/*
 * Copyright (c) 2011-2013, ScalaFX Project
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
package scalafx.scene.layout

import javafx.{ geometry => jfxg }
import javafx.scene.{ layout => jfxsl }
import javafx.scene.{ shape => jfxss }
import scalafx.Includes._
import scalafx.scene.Parent
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.geometry.Insets
import scalafx.delegate.SFXDelegate

object Region {
  implicit def sfxRegion2jfx(v: Region) = v.delegate

  /**
   * Sentinel value which can be passed to a region's minWidth, minHeight, prefWidth, prefHeight,
   * maxWidth, maxHeight properties to reset the region's size constraint back to it's intrinsic
   * size returned by computeMinWidth(), computeMinHeight(), computePrefWidth(),
   * computePrefHeight(), computeMaxWidth(), or computeMaxHeight().
   */
  val USE_COMPUTED_SIZE = jfxsl.Region.USE_COMPUTED_SIZE

  /**
   * Sentinel value which can be passed to a region's minWidth, minHeight, prefWidth, prefHeight,
   * maxWidth, maxHeight properties to indicate that the preferred dimension should be used for
   * that max and/or min constraint.
   */
  val USE_PREF_SIZE = jfxsl.Region.USE_PREF_SIZE

}

class Region(override val delegate: jfxsl.Region = new jfxsl.Region())
  extends Parent(delegate)
  with SFXDelegate[jfxsl.Region] {

  /** The background of the Region, which is made up of zero or more BackgroundFills,
    * and zero or more BackgroundImages.
    */
  def background : ObjectProperty[jfxsl.Background] = delegate.backgroundProperty()

  /** The border of the Region, which is made up of zero or more BorderStrokes, and zero or more BorderImages. */
  def border : ObjectProperty[jfxsl.Border] = delegate.borderProperty()

  /** Defines a hint to the system indicating that the Shape used to define the region's
    * background is stable and would benefit from caching. */
  def cacheShape : BooleanProperty = delegate.cacheProperty()

  /** Defines whether the shape is centered within the Region's width or height. */
  def centerShape : BooleanProperty = delegate.centerShapeProperty()

  /**
   * The height of this resizable node.
   */
  def height: ReadOnlyDoubleProperty = delegate.heightProperty

  /**
   * Gets the space around content, which will include any borders plus padding if set.
   */
  def insets = delegate.getInsets()

  /**
   * The width of this resizable node.
   */
  def width: ReadOnlyDoubleProperty = delegate.widthProperty

  /**
   * Property for overriding the region's computed maximum height.
   */
  def maxHeight: DoubleProperty = delegate.maxHeightProperty
  def maxHeight_=(v: Double) {
    maxHeight() = v
  }

  /**
   * Property for overriding the region's computed maximum width.
   */
  def maxWidth: DoubleProperty = delegate.maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth() = v
  }

  /**
   * Property for overriding the region's computed minimum height.
   */
  def minHeight: DoubleProperty = delegate.minHeightProperty
  def minHeight_=(v: Double) {
    minHeight() = v
  }

  /**
   * Property for overriding the region's computed minimum width.
   */
  def minWidth: DoubleProperty = delegate.minWidthProperty
  def minWidth_=(v: Double) {
    minWidth() = v
  }

  /** Defines the area of the region within which completely opaque pixels are drawn. */
  def opaqueInsets : ObjectProperty[jfxg.Insets] = delegate.opaqueInsetsProperty()

  /**
   * The top,right,bottom,left padding around the region's content.
   */
  def padding: ObjectProperty[jfxg.Insets] = delegate.paddingProperty
  def padding_=(v: Insets) {
    padding() = v
  }

  /**
   * Property for overriding the region's computed preferred height.
   */
  def prefHeight: DoubleProperty = delegate.prefHeightProperty
  def prefHeight_=(v: Double) {
    prefHeight() = v
  }

  /**
   * Property for overriding the region's computed preferred width.
   */
  def prefWidth: DoubleProperty = delegate.prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth() = v
  }

  def shape : ObjectProperty[jfxss.Shape] = delegate.shapeProperty()

  /**
   * Defines whether this region rounds position/spacing and ceils size values to pixel boundaries
   * when laying out its children.
   */
  def snapToPixel: BooleanProperty = delegate.snapToPixelProperty
  def snapToPixel_=(v: Boolean) {
    snapToPixel() = v
  }

  /**
   * Returns true since all Regions are resizable.
   */
  def resize = delegate.isResizable

  /**
   * Invoked by the region's parent during layout to set the region's width and height.
   */
  override def resize(width: Double, height: Double) = delegate.resize(width, height)

  /** Specifies whether the shape, if defined, is scaled to match the size of the Region. */
  def scaleShape : BooleanProperty = delegate.scaleShapeProperty()
}
