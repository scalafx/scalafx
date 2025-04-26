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
import scalafx.Includes.*
import scalafx.collections.{ObservableFloatArray, ObservableIntegerArray}
import scalafx.testutil.SimpleSFXDelegateSpec

/** TriangleMesh Spec tests. */
class TriangleMeshSpec
    extends SimpleSFXDelegateSpec[jfxss.TriangleMesh, TriangleMesh](
      classOf[jfxss.TriangleMesh],
      classOf[TriangleMesh]
    ) {

  trait TestData {
    val mesh            = new TriangleMesh()
    val emptyIntArray   = Array[Int]()
    val emptyFloatArray = Array[Float]()
    // Making arrays length 6 should satisfy all size constraints.
    // TODO: Add tests for invalid array lengths.
    val intArray   = Array(0, 1, 2, 3, 4, 5)
    val floatArray = Array(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 6.0f)
  }

  /**
   * Test integer array contents.
   *
   * @param ao Observable array
   * @param a  Basic array.
   */
  def testIntArray(oa: ObservableIntegerArray, a: Array[Int]): Unit = {
    assert(oa.isEmpty === a.isEmpty)
    assert(oa.length === a.length)
    for (i <- 0 until oa.length) {
      assert(oa(i) === a(i))
    }
    intercept[ArrayIndexOutOfBoundsException] {
      val invalid = oa(a.length)
    }
  }

  /**
   * Test integer array contents.
   *
   * @param ao Observable array
   * @param a  Basic array.
   */
  def testFloatArray(oa: ObservableFloatArray, a: Array[Float]): Unit = {
    assert(oa.isEmpty === a.isEmpty)
    assert(oa.length === a.length)
    for (i <- 0 until oa.length) {
      assert(oa(i) === a(i))
    }
    intercept[ArrayIndexOutOfBoundsException] {
      val invalid = oa(a.length)
    }
  }

  it should "report the correct array component sizes" in {
    new TestData {
      assert(mesh.faceElementSize === 6)
      assert(mesh.pointElementSize === 3)
      assert(mesh.texCoordElementSize === 2)
    }
  }

  it should "construct new mesh with empty arrays" in {
    new TestData {
      testFloatArray(mesh.points, emptyFloatArray)
      testFloatArray(mesh.texCoords, emptyFloatArray)
      testIntArray(mesh.faces, emptyIntArray)
      testIntArray(mesh.faceSmoothingGroups, emptyIntArray)
    }
  }

  it should "allow mesh arrays to be assigned to basic arrays" in {
    new TestData {
      mesh.points = floatArray
      testFloatArray(mesh.points, floatArray)
      mesh.texCoords = floatArray
      testFloatArray(mesh.texCoords, floatArray)
      mesh.faces = intArray
      testIntArray(mesh.faces, intArray)
      mesh.faceSmoothingGroups = intArray
      testIntArray(mesh.faceSmoothingGroups, intArray)
    }
  }
}
