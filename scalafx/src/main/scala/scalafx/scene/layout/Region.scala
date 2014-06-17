/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import scala.language.implicitConversions
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
import scalafx.scene.shape.Shape

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

  /** Utility method which lays out the child within an area of it's parent defined by areaX, areaY,
    * areaWidth x areaHeight, with a baseline offset relative to that area. */
  def layoutInArea(child: javafx.scene.Node,
                   areaX: Double, areaY: Double, areaWidth: Double, areaHeight: Double, areaBaselineOffset: Double,
                   margin: jfxg.Insets, fillWidth: Boolean, fillHeight: Boolean,
                   halignment: jfxg.HPos, valignment: jfxg.VPos, isSnapToPixel: Boolean) {
    jfxsl.Region.layoutInArea(
      child,
      areaX, areaY, areaWidth, areaHeight, areaBaselineOffset,
      margin, fillWidth, fillHeight,
      halignment, valignment, isSnapToPixel)
  }

  /** Utility method which positions the child within an area of this region defined by areaX, areaY,
    * areaWidth x areaHeight, with a baseline offset relative to that area. */
  def positionInArea(child: javafx.scene.Node,
                     areaX: Double, areaY: Double, areaWidth: Double, areaHeight: Double, areaBaselineOffset: Double,
                     margin: jfxg.Insets, halignment: jfxg.HPos, valignment: jfxg.VPos, isSnapToPixel: Boolean) {
    jfxsl.Region.positionInArea(child,
      areaX, areaY, areaWidth, areaHeight,
      areaBaselineOffset, margin, halignment, valignment, isSnapToPixel)
  }
}

class Region(override val delegate: jfxsl.Region = new jfxsl.Region())
  extends Parent(delegate)
  with SFXDelegate[jfxsl.Region] {

  /** The background of the Region, which is made up of zero or more BackgroundFills,
    * and zero or more BackgroundImages.
    */
  def background : ObjectProperty[jfxsl.Background] = delegate.backgroundProperty()
  def background_=(v:Background) {
    background() = v
  }

  /** The border of the Region, which is made up of zero or more BorderStrokes, and zero or more BorderImages. */
  def border : ObjectProperty[jfxsl.Border] = delegate.borderProperty()
  def border_=(v:Border) {
    border() = v
  }

  /** Defines a hint to the system indicating that the Shape used to define the region's
    * background is stable and would benefit from caching. */
  def cacheShape : BooleanProperty = delegate.cacheProperty()
  def cacheShape_=(v:Boolean) {
    cacheShape() = v
  }

  /** Defines whether the shape is centered within the Region's width or height. */
  def centerShape : BooleanProperty = delegate.centerShapeProperty()
  def centerShape_=(v:Boolean) {
    centerShape() = v
  }

  /**
   * The height of this resizable node.
   */
  def height: ReadOnlyDoubleProperty = delegate.heightProperty

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
  def opaqueInsets_=(v:Insets) {
    opaqueInsets() = v
  }

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

  /** When specified, the shape will cause the region to be rendered as the specified shape rather than as a rounded rectangle. */
  def shape : ObjectProperty[jfxss.Shape] = delegate.shapeProperty()
  def shape_=(v:Shape) {
    shape() = v
  }

  /**
   * Defines whether this region rounds position/spacing and cell size values to pixel boundaries
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
  override def resize(width: Double, height: Double) {
    delegate.resize(width, height)
  }

  /** Specifies whether the shape, if defined, is scaled to match the size of the Region. */
  def scaleShape : BooleanProperty = delegate.scaleShapeProperty()
  def scaleShape_=(v:Boolean) {
    scaleShape() = v
  }

  /**
   * Gets the space around content, which will include any borders plus padding if set.
   */
  def insets = delegate.getInsets
}
