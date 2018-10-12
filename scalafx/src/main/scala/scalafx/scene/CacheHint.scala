/*
 * Copyright (c) 2011-2018, ScalaFX Project
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
import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/CacheHint.html javafx.scene.CacheHint]] */
object CacheHint extends SFXEnumDelegateCompanion[jfxs.CacheHint, CacheHint] {

  case object Default extends CacheHint(jfxs.CacheHint.DEFAULT)
  @deprecated ("Use Default; DEFAULT will be removed in a future release", "8.0.60-R10")
  val DEFAULT = Default


  case object Quality extends CacheHint(jfxs.CacheHint.QUALITY)
  @deprecated ("Use Quality; QUALITY will be removed in a future release", "8.0.60-R10")
  val QUALITY = Quality

  case object Rotate extends CacheHint(jfxs.CacheHint.ROTATE)
  @deprecated ("Use Rotate; ROTATE will be removed in a future release", "8.0.60-R10")
  val ROTATE = Rotate

  case object Scale extends CacheHint(jfxs.CacheHint.SCALE)
  @deprecated ("Use Scale; SCALE will be removed in a future release", "8.0.60-R10")
  val SCALE = Scale

  case object ScaleAndRotate extends CacheHint(jfxs.CacheHint.SCALE_AND_ROTATE)
  @deprecated ("Use ScaleAndRotate; SCALE_AND_ROTATE will be removed in a future release", "8.0.60-R10")
  val SCALE_AND_ROTATE = ScaleAndRotate

  case object Speed extends CacheHint(jfxs.CacheHint.SPEED)
  @deprecated ("Use Speed; SPEED will be removed in a future release", "8.0.60-R10")
  val SPEED = Speed

  protected override def unsortedValues: Array[CacheHint] = Array(
    Default, Speed, Quality, Scale, Rotate, ScaleAndRotate
  )
}


sealed abstract class CacheHint(override val delegate: jfxs.CacheHint) extends SFXEnumDelegate[jfxs.CacheHint]
