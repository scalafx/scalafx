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

package scalafx.scene.shape

import javafx.scene.shape as jfxss
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object VertexFormat {

  /**
   * Converts a ScalaFX VertexFormat to its JavaFX counterpart.
   *
   * @param v ScalaFX VertexFormat
   * @return JavaFX VertexFormat
   */
  implicit def sfxVertexFormat2jfx(v: VertexFormat): jfxss.VertexFormat =
    if (v != null) v.delegate else null

  /**
   * Specifies the format of a vertex that consists of a point and texture coordinates.
   */
  val PointTexcoord: VertexFormat = new VertexFormat(jfxss.VertexFormat.POINT_TEXCOORD)

  /**
   * Specifies the format of a vertex that consists of a point, normal and texture coordinates.
   */
  val PointNormalTexcoord = new VertexFormat(jfxss.VertexFormat.POINT_NORMAL_TEXCOORD)
}

/**
 * Defines the format of the vertices in a mesh. A vertex consists of an array
 * of points, normals (optional), and texture coordinates.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * @define TC VertexFormat
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx/scene/shape/VertexFormat.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class VertexFormat(override val delegate: jfxss.VertexFormat)
    extends SFXDelegate[jfxss.VertexFormat] {

  /**
   * Returns the number of component indices that represents a vertex. For example,
   * a `PointTexcoord` vertex consists of 2 indices, one for point component and
   * the other for texture coordinates component. Hence its value will be 2.
   *
   * @return the number of component indices
   */
  def vertexIndexSize: Int = delegate.getVertexIndexSize

  /**
   * Returns the index offset in the face array of the point component within
   * a vertex.
   *
   * @return the offset to the point component.
   */
  def pointIndexOffset: Int = delegate.getPointIndexOffset

  /**
   * Returns the index offset in the face array of the normal component within
   * a vertex.
   *
   * @return the offset to the normal component.
   */
  def normalIndexOffset: Int = delegate.getNormalIndexOffset

  /**
   * Returns the index offset in the face array of the texture coordinates
   * component within a vertex.
   *
   * @return the offset to the texture coordinates component.
   */
  def texCoordIndexOffset: Int = delegate.getTexCoordIndexOffset

}
