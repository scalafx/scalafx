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

import scalafx.delegate.{SFXEnumDelegate, SFXEnumDelegateCompanion}

/**
 * Wrapper for [[scalafx.scene.control.$TSM]]
 *
 * @define TSM TreeSortMode
 * @define URL0 [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/$TSM.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
object TreeSortMode
  extends SFXEnumDelegateCompanion[jfxsc.TreeSortMode, TreeSortMode] {

  /**
   * Default; sort all nodes.
   *
   * @see $URL0#ALL_DESCENDANTS $ORIGINALDOC
   */
  val AllDescendants: TreeSortMode = new TreeSortMode(jfxsc.TreeSortMode.ALL_DESCENDANTS)

  /**
   * Sort first level nodes only regardless of whether the root is actually being shown or not
   *
   * @see $URL0#ONLY_FIRST_LEVEL $ORIGINALDOC
   */
  val OnlyFirstModel: TreeSortMode = new TreeSortMode(jfxsc.TreeSortMode.ONLY_FIRST_LEVEL)

  protected override def unsortedValues: Array[TreeSortMode] =
    Array(AllDescendants, OnlyFirstModel)

}

/**
 * Wraps JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeSortMode.html TreeSortMode]].
 *
 * @constructor Creates a new TreeSortMode from a JavaFX one.
 * @param delegate JavaFX TreeSortMode
 * @since 8.0
 */
sealed case class TreeSortMode(override val delegate: jfxsc.TreeSortMode)
  extends SFXEnumDelegate[jfxsc.TreeSortMode] 