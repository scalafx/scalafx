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

package scalafx.scene

import javafx.beans.{property => jfxbp}
import javafx.{scene => jfxs}
import layout.LayoutIncludes
import paint.PaintIncludes
import shape.ShapeIncludes
import control.ControlIncludes

object SceneIncludes extends SceneIncludes

trait SceneIncludes extends LayoutIncludes with PaintIncludes with ShapeIncludes with LowerPriorityIncludes with ControlIncludes

trait LowerPriorityIncludes {
  implicit def jfxGroup2sfx(v: jfxs.Group) = new Group(v)
  implicit def jfxParent2sfx(v: jfxs.Parent) = new Parent() {
    override val delegate = v
  }
  implicit def jfxNode2sfx(v: jfxs.Node) = new Node() {
    override val delegate = v
  }
  implicit def jfxScene2sfx(v: jfxs.Scene) = new Scene(v)
  implicit def jfxSceneProperty2sfx(p: jfxbp.ReadOnlyObjectProperty[jfxs.Scene]) = new SceneProperty(p)
}