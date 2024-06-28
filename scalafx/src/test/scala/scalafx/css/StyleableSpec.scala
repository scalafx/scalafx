/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
package scalafx.css

import javafx.collections.{ObservableList, ObservableSet}
import javafx.css as jfxcss
import scalafx.Includes.*
import scalafx.testutil.SimpleSFXDelegateSpec

import java.util

/**
 * Styleable Spec tests.
 */
class StyleableSpec
    extends SimpleSFXDelegateSpec[jfxcss.Styleable, Styleable](classOf[jfxcss.Styleable], classOf[Styleable]) {

  override protected def getScalaClassInstance: Styleable = new Styleable {
    override val delegate: jfxcss.Styleable = getJavaClassInstance
  }

  override protected def getJavaClassInstance: javafx.css.Styleable = new jfxcss.Styleable {
    override def getCssMetaData: util.List[jfxcss.CssMetaData[? <: jfxcss.Styleable, ?]] = null
    override def getId: String                                                           = ""
    override def getPseudoClassStates: ObservableSet[jfxcss.PseudoClass]                 = null
    override def getStyle: String                                                        = ""
    override def getStyleableParent: jfxcss.Styleable                                    = null
    override def getStyleClass: ObservableList[String]                                   = null
    override def getTypeSelector: String                                                 = ""
  }

}
