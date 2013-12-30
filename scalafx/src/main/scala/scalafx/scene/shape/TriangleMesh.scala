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
package scalafx.scene.shape

import javafx.scene.{shape => jfxss}
import scalafx.Includes._
import scalafx.collections.ObservableFloatArray
import scalafx.collections.ObservableIntegerArray
import scalafx.delegate.SFXDelegate


object TriangleMesh {
  implicit def sfxTriangleMesh2jfx(tm: TriangleMesh) = tm.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/shape/TriangleMesh.html]].
 */
class TriangleMesh(override val delegate: jfxss.TriangleMesh = new jfxss.TriangleMesh())
  extends Mesh(delegate)
  with SFXDelegate[jfxss.TriangleMesh] {

  /** Gets the number of array components representing a single face. */
  def faceElementSize = delegate.getFaceElementSize()

  /** Gets the ObservableIntegerArray of faces, indices into the points and texCoords arrays, of this TriangleMesh */
  def faces: ObservableIntegerArray = delegate.getFaces

  /**
   * Set faces to given array.
   * 
   * @param a Integer array to replace the contents of the faces array.
   */
  def faces_= (a: Array [Int]) {
    delegate.getFaces.setAll (a, 0, a.length)
  }

  /** Gets the ObservableIntegerArray of face smoothing groups of this TriangleMesh. */
  def faceSmoothingGroups: ObservableIntegerArray = delegate.getFaceSmoothingGroups

  /**
   * Set face smoothing groups to given array.
   * 
   * @param a Integer array to replace the contents of the face smoothing groups array.
   */
  def faceSmoothingGroups_= (a: Array [Int]) {
    delegate.getFaceSmoothingGroups.setAll (a, 0, a.length)
  }

  /** Gets the number of array components representing a single point. */
  def pointElementSize = delegate.getPointElementSize()

  /** Gets the ObservableFloatArray of points of this TriangleMesh. */
  def points: ObservableFloatArray = delegate.getPoints

  /**
   * Set points to given array.
   * 
   * @param a Float array to replace the contents of the points array.
   */
  def points_= (a: Array [Float]) {
    delegate.getPoints.setAll (a, 0, a.length)
  }

  /** Gets the number of array components representing a single text coordinate. */
  def texCoordElementSize = delegate.getTexCoordElementSize()

  /** Gets the ObservableFloatArray of texture coordinates of this TriangleMesh. */
  def texCoords: ObservableFloatArray = delegate.getTexCoords

  /**
   * Set texture coordinates to given array.
   * 
   * @param a Float array to replace the contents of the texture coordinates array.
   */
  def texCoords_= (a: Array [Float]) {
    delegate.getTexCoords.setAll (a, 0, a.length)
  }
}
