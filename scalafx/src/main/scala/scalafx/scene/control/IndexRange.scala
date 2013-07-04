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
package scalafx.scene.control

import javafx.scene.{ control => jfxsc }
import scalafx.delegate.SFXDelegate

object IndexRange {
  implicit def sfxIndexRange(r: IndexRange) = r.delegate

  /**
   * Index range value delimiter.
   */
  val VALUE_DELIMITER = jfxsc.IndexRange.VALUE_DELIMITER

  /**
   * Convenience method to create an IndexRange instance that has the smaller value as the start
   * index, and the larger value as the end index.
   */
  def normalize(v1: Int, v2: Int): IndexRange = new IndexRange(jfxsc.IndexRange.normalize(v1, v2))

  /**
   * Convenience method to parse in a String of the form '2,6', which will create an IndexRange
   * instance with a start value of 2, and an end value of 6.
   */
  def valueOf(value: String): IndexRange = new IndexRange(jfxsc.IndexRange.valueOf(value))

}

class IndexRange(override val delegate: jfxsc.IndexRange) extends SFXDelegate[jfxsc.IndexRange] {

  /**
   * Creates an instance of IndexRange by copying the values from the given IndexRange object.
   */
  def this(range: IndexRange) = this(new jfxsc.IndexRange(range))

  /**
   * Creates an instance of IndexRange representing the range between start and end.
   */
  def this(start: Int, end: Int) = this(new jfxsc.IndexRange(start, end))

  /**
   * Returns the start position of the range.
   */
  def start = delegate.getStart

  /**
   * Returns the end position of the range (exclusive).
   */
  def end = delegate.getEnd

  /**
   * Returns the length of the range.
   */
  def length = delegate.getLength

}