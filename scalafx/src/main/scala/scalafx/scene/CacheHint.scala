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
package scalafx.scene

import javafx.{scene => jfxs}
import scalafx.delegate.{ SFXEnumDelegateCompanion, SFXEnumDelegate }



/** Wrapper for [[javafx.scene.CacheHint]] */
object CacheHint extends SFXEnumDelegateCompanion[jfxs.CacheHint, CacheHint] {

  val DEFAULT = new CacheHint(jfxs.CacheHint.DEFAULT)
  val QUALITY = new CacheHint(jfxs.CacheHint.QUALITY)
  val ROTATE = new CacheHint(jfxs.CacheHint.ROTATE)
  val SCALE = new CacheHint(jfxs.CacheHint.SCALE)
  val SCALE_AND_ROTATE = new CacheHint(jfxs.CacheHint.SCALE_AND_ROTATE)
  val SPEED = new CacheHint(jfxs.CacheHint.SPEED)

  protected override def unsortedValues: Array[CacheHint] = Array(
    DEFAULT, SPEED, QUALITY, SCALE, ROTATE, SCALE_AND_ROTATE
  )
}


sealed case class CacheHint(override val delegate: jfxs.CacheHint) extends SFXEnumDelegate[jfxs.CacheHint]
