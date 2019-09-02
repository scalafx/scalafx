/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

package scalafx.collections

import javafx.{collections => jfxc}

import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate

object ObservableBufferBase {

  /**
    * Converts a ScalaFX ObservableBufferBase to its JavaFX counterpart ObservableListBase.
    *
    * @param v ScalaFX ObservableBufferBase
    * @return JavaFX ObservableListBase
    */
  implicit def sfxObservableListBase2jfx[E](v: ObservableBufferBase[E]): jfxc.ObservableListBase[E] =
    if (v != null) v.delegate else null
}

/**
  * There is no need in ScalaFX to use this class. `ObservableListBase` is really an implementation detail of JavaFX,
  * that is added in ScalaFX as `ObservableBufferBase` to keep type hierarchies in `scalafx.collections.transformation` correct.
  * Note that `Buffer` is used instead of Java `List`, since it is a closer equivalent to java `List` than Scala `List`
  * (Java and Scala `List` are quite different).
  * There should be bo need to use this class from ScalaFX.
  * On JavaFX side this is an abstract class that serves as a base class for ObservableList implementations that wa added in JavFX 8.
  * In ScalaFX 8 the implementation is actually in ObservableBuffer.
  *
  *
  * Wraps a $JFX $URL0 $TC]].
  *
  * @tparam E - the type of the elements contained in the List
  *
  * @define TC ObservableListBase
  * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx.collections/ObservableListBase.html
  * @define JFX JavaFX
  * @define ORIGINALDOC Original Documentation]].
  */
abstract class ObservableBufferBase[E](override val delegate: jfxc.ObservableListBase[E])
    extends ObservableBuffer[E](delegate)
    with SFXDelegate[jfxc.ObservableListBase[E]]
