/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import javafx.scene.{control => jfxsc}
import javafx.{scene => jfxs}

import scala.language.implicitConversions

import scalafx.beans.property.{BooleanProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.Includes._
import scalafx.scene.Node

/** @author Roman Hargrave */
object CustomMenuItem {
    implicit def sfxCustomMenuItem2jfx(c: CustomMenuItem): jfxsc.CustomMenuItem = if(c != null) c.delegate else null
}
class CustomMenuItem(override val delegate: jfxsc.CustomMenuItem = new jfxsc.CustomMenuItem) extends MenuItem with SFXDelegate[jfxsc.CustomMenuItem] {

    /**
     * Bridge constructor for [[jfxsc.CustomMenuItem(Node)]]
     * @param content menu item content
     */
    def this(content: Node) = this(new jfxsc.CustomMenuItem(content))

    /**
     * Bridge constructor for [[jfxsc.CustomMenuItem(Node, boolean)]]
     * @param content menu item content
     * @param hidOnClick hide on click
     */
    def this(content: Node, hidOnClick: Boolean) = this(new jfxsc.CustomMenuItem)

    def content: ObjectProperty[jfxs.Node] = delegate.contentProperty()
    def content_=(n: Node): Unit = {
        content() = n
    }

    def hideOnClick: BooleanProperty = delegate.hideOnClickProperty()
    def hideOnClick_=(b: Boolean): Unit = {
        hideOnClick() = b
    }
}
