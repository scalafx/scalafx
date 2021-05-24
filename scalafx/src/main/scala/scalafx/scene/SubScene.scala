/*
 * Copyright (c) 2011-2020, ScalaFX Project
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

import javafx.scene.{layout => jfxsl, paint => jfxsp}
import javafx.{collections => jfxc, scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.collections._
import scalafx.delegate.SFXDelegate
import scalafx.scene.paint.Paint

import scala.language.implicitConversions

object SubScene {
  implicit def sfxSubScene2jfx(v: SubScene): jfxs.SubScene = if (v != null) v.delegate else null
}

/** Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/SubScene.html]]. */
class SubScene(override val delegate: jfxs.SubScene) extends Node(delegate) with SFXDelegate[jfxs.SubScene] {

  // TODO Combine common features with Scene in a trait used by both.

  /**
   * Creates a SubScene with a [[http://docs.oracle.com/javafx/8/api/javafx/scene/Group.htmlGroup]] as root Node with a
   * specified size.
   *
   * @param width
   *   The width of the scene
   * @param height
   *   The height of the scene
   */
  def this(width: Double, height: Double) = this(new jfxs.SubScene(new jfxs.Group(), width, height))

  /**
   * Constructs a SubScene with a [[http://docs.oracle.com/javafx/8/api/javafx/scene/Group.htmlGroup]] as root Node,
   * with a dimension of width and height, specifies whether a depth buffer is created for this scene and specifies the
   * level of antialiasing required.
   */
  def this(width: Double, height: Double, depthBuffer: Boolean, antiAliasing: SceneAntialiasing) =
    this(new jfxs.SubScene(new jfxs.Group(), width, height, depthBuffer, antiAliasing))

  /** Creates a SubScene for a specific root Node with a specific size. */
  def this(root: Parent, width: Double, height: Double) = this(new jfxs.SubScene(root, width, height))

  /**
   * Constructs a SubScene consisting of a root, with a dimension of width and height, specifies whether a depth buffer
   * is created for this scene and specifies the level of antialiasing required.
   */
  def this(root: Parent, width: Double, height: Double, depthBuffer: Boolean, antiAliasing: SceneAntialiasing) =
    this(new jfxs.SubScene(root, width, height, depthBuffer, antiAliasing))

  /** Defines the root Node of the SubScene scene graph. */
  def root: ObjectProperty[jfxs.Parent] = delegate.rootProperty

  def root_=(v: Parent): Unit = {
    ObjectProperty.fillProperty[jfxs.Parent](this.root, v)
  }

  /**
   * Returns Nodes children from this Scene's `root`.
   */
  def getChildren: ObservableBuffer[jfxs.Node] = root.value match {
    case group: jfxs.Group => group.getChildren
    case pane: jfxsl.Pane  => pane.getChildren
    case _ =>
      throw new IllegalStateException(
        "Cannot access children of root: " + root +
          "\nUse a class that extends Group or Pane, or override the getChildren method."
      )
  }

  /**
   * Returns Content's Node children from this Scene's `root`.
   */
  def content: jfxc.ObservableList[jfxs.Node] = getChildren

  /**
   * Sets the list of Nodes children from this Scene's `root`, replacing the prior content. If you want append to
   * current content, use `add` or similar.
   *
   * @param c
   *   list of Nodes children from this Scene's `root` to replace prior content.
   */
  def content_=(c: Iterable[Node]): Unit = {
    fillSFXCollection(this.content, c)
  }

  /**
   * Sets a Node child, replacing the prior content. If you want append to current content, use `add` or similar.
   *
   * @param n
   *   Node child to replace prior content.
   */
  def content_=(n: Node): Unit = {
    fillSFXCollectionWithOne(this.content, n)
  }

  /** Specifies the type of camera use for rendering this SubScene. */
  def camera: ObjectProperty[jfxs.Camera] = delegate.cameraProperty

  def camera_=(v: Camera): Unit = {
    ObjectProperty.fillProperty[jfxs.Camera](this.camera, v)
  }

  /** Defines the background fill of this SubScene. */
  def fill: ObjectProperty[jfxsp.Paint] = delegate.fillProperty

  def fill_=(v: Paint): Unit = {
    ObjectProperty.fillProperty[jfxsp.Paint](this.fill, v)
  }

  /** Defines the height of this SubScene. */
  def height: DoubleProperty = delegate.heightProperty

  def height_=(v: Double): Unit = {
    height() = v
  }

  /**
   * The URL of the user-agent stylesheet that will be used by this Scene in place of the the platform-default
   * user-agent stylesheet. If the URL does not resolve to a valid location, the platform-default user-agent stylesheet
   * will be used.
   *
   * For additional information about using CSS with the scene graph, see the
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.htmlCSS Reference Guide]].
   *
   * @return
   *   The URL of the user-agent stylesheet that will be used by this SubScene, or null if has not been set.
   */
  def userAgentStylesheet: ObjectProperty[String] = delegate.userAgentStylesheetProperty

  /**
   * Set the URL of the user-agent stylesheet that will be used by this Scene in place of the the platform-default
   * user-agent stylesheet. If the URL does not resolve to a valid location, the platform-default user-agent stylesheet
   * will be used.
   *
   * For additional information about using CSS with the scene graph, see the
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.htmlCSS Reference Guide]].
   *
   * @param url
   *   The URL is a hierarchical URI of the form `[scheme:][//authority][path]`. If the URL does not have a `[scheme:]`
   *   component, the URL is considered to be the `[path]` component only. Any leading '/' character of the `[path]` is
   *   ignored and the `[path]` is treated as a path relative to the root of the application's classpath.
   */
  def userAgentStylesheet_=(url: String): Unit = {
    ObjectProperty.fillProperty[String](userAgentStylesheet, url)
  }

  /** Defines the width of this SubScene. */
  def width: DoubleProperty = delegate.widthProperty

  def width_=(v: Double): Unit = {
    width() = v
  }

  /** Return true if this SubScene is anti-aliased otherwise false. */
  def isAntiAliasing: Boolean = delegate.isAntiAliasing
}
