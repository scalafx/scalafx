

/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.scene.paint

import javafx.scene.{paint => jfxsp}
import scalafx.util.SFXDelegate

//I think it might be better to implemented this way rather than extending Enumeration
object CycleMethod {
  implicit def sfxCycleMethod2jfx(c: CycleMethod) = c.delegate
  
  val NO_CYCLE = new CycleMethod(jfxsp.CycleMethod.NO_CYCLE)
  val REFLECT = new CycleMethod(jfxsp.CycleMethod.REFLECT)
  val REPEAT = new CycleMethod(jfxsp.CycleMethod.REPEAT)
  
  def valueOf(name: String) = name match {
    case "NO_CYCLE" => NO_CYCLE
    case "REFLECT" => REFLECT
    case "REPEAT" => REPEAT
  }
  def values = List(NO_CYCLE, REFLECT, REPEAT)
}

class CycleMethod(override val delegate:jfxsp.CycleMethod) extends SFXDelegate[jfxsp.CycleMethod]
