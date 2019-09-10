/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

package scalafx.scene.input

import java.{util => ju}

import scala.collection.{Iterator, mutable}

private[input] trait JMapWrapperLike[A, B]
  extends mutable.Map[A, B] {

  def underlying: ju.Map[A, B]

  override def size = underlying.size

  def get(k: A) = {
    val v = underlying get k
    if (v != null)
      Some(v)
    else if (underlying containsKey k)
      Some(null.asInstanceOf[B])
    else
      None
  }

  override def addOne(kv: (A, B)): this.type = {
    underlying.put(kv._1, kv._2);
    this
  }

  override def subtractOne(key: A): this.type = {
    underlying remove key;
    this
  }

  override def put(k: A, v: B): Option[B] = {
    val r = underlying.put(k, v)
    if (r != null) Some(r) else None
  }

  override def update(k: A, v: B): Unit = {
    underlying.put(k, v)
  }

  override def remove(k: A): Option[B] = {
    val r = underlying remove k
    if (r != null) Some(r) else None
  }

  //  def iterator: Iterator[(A, B)] = new AbstractIterator[(A, B)] {
  def iterator: Iterator[(A, B)] = new Iterator[(A, B)] {
    val ui = underlying.entrySet.iterator
    def hasNext = ui.hasNext
    def next() = { val e = ui.next(); (e.getKey, e.getValue) }
  }

  override def clear() = underlying.clear()
}
