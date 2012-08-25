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

package scalafx

import animation.AnimationIncludes
import beans.BeanIncludes
import collections.CollectionIncludes
import concurrent.ConcurrentIncludes
import event.EventIncludes
import geometry.GeometryIncludes
import application.ApplicationIncludes
import scene.canvas.CanvasIncludes
import scene.input.InputIncludes
import scene.media.MediaIncludes
import scene.transform.TransformIncludes
import scene.web.WebIncludes
import scene.SceneIncludes
import stage.StageIncludes
import util.converter.ConverterIncludes
import util.UtilIncludes

/**
 * Include file that contains all the necessary declarations for jfx->sfx implicit conversions
 * and other syntactic sugar.
 *
 * This file is tiered both for modularity and to prioritize the implicits
 * (the order of the withs matter a lot!)
 */
object Includes extends Includes

trait Includes
  extends AnimationIncludes 
  with CollectionIncludes 
  with EventIncludes 
  with SceneIncludes 
  with BeanIncludes 
  with UtilIncludes 
  with GeometryIncludes 
  with TransformIncludes 
  with InputIncludes 
  with StageIncludes 
  with WebIncludes 
  with MediaIncludes
  with ConverterIncludes
  with ConcurrentIncludes
  with CanvasIncludes
  with ApplicationIncludes