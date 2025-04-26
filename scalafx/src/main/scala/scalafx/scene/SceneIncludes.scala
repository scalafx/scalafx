/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.scene as jfxs
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.scene.chart.ChartIncludes
import scalafx.scene.control.ControlIncludes
import scalafx.scene.effect.EffectIncludes
import scalafx.scene.image.ImageIncludes
import scalafx.scene.layout.LayoutIncludes
import scalafx.scene.paint.PaintIncludes
import scalafx.scene.shape.ShapeIncludes
import scalafx.scene.text.TextIncludes

import scala.language.implicitConversions

object SceneIncludes extends SceneIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/package-summary.html `javafx.scene`]] and subpackages
 * Classes/Traits to their ScalaFX counterparts.
 */
trait SceneIncludes extends ChartIncludes
    with LayoutIncludes
    with PaintIncludes
    with ShapeIncludes
    with TextIncludes
    with ImageIncludes
    with EffectIncludes
    with LowerPriorityIncludes
    with ControlIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/package-summary.html `javafx.scene`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define CHI CacheHint
 * @define CAM Camera
 * @define CUR Cursor
 * @define DPT DepthTest
 * @define GRP Group
 * @define IMC ImageCursor
 * @define NOD Node
 * @define PRC ParallelCamera
 * @define PAR Parent
 * @define PEC PerspectiveCamera
 * @define SCE Scene
 * @define SCA SceneAntialiasing
 * @define SCP SceneProperty
 * @define SNP SnapshotParameters
 * @define SSCE SubScene
 */
trait LowerPriorityIncludes {

  implicit def jfxAccessibleAction2sfx(e: jfxs.AccessibleAction): AccessibleAction = AccessibleAction.jfxEnum2sfx(e)

  implicit def jfxAccessibleRole2sfx(e: jfxs.AccessibleRole): AccessibleRole = AccessibleRole.jfxEnum2sfx(e)

  implicit def jfxAmbientLight2sfx(v: jfxs.AmbientLight): AmbientLight = if (v != null) new AmbientLight(v) else null

  /**
   * $START$CHI.html $CHI$END
   *
   * @param e $JFX $CHI
   * @return $SFX $CHI
   */
  implicit def jfxCacheHint2sfx(e: jfxs.CacheHint): CacheHint = CacheHint.jfxEnum2sfx(e)

  /**
   * $START$CAM.html $CAM$END
   *
   * @param v $JFX $CAM
   * @return $SFX $CAM
   */
  implicit def jfxCamera2sfx(v: jfxs.Camera): Camera = if (v != null) new Camera(v) {} else null

  /**
   * $START$CUR.html $CUR$END
   *
   * @param v $JFX $CUR
   * @return $SFX $CUR
   */
  implicit def jfxCursor2sfx(v: jfxs.Cursor): Cursor = if (v != null) new Cursor(v) {} else null

  /**
   * $START$DPT.html $DPT$END
   *
   * @param e $JFX $DPT
   * @return $SFX $DPT
   */
  implicit def jfxDepthTest2sfx(e: jfxs.DepthTest): DepthTest = DepthTest.jfxEnum2sfx(e)

  /**
   * $START$GRP.html $GRP$END
   *
   * @param v $JFX $GRP
   * @return $SFX $GRP
   */
  implicit def jfxGroup2sfx(v: jfxs.Group): Group = if (v != null) new Group(v) else null

  /**
   * $START$IMC.html $IMC$END
   *
   * @param ic $JFX $IMC
   * @return $SFX $IMC
   */
  implicit def jfxImageCursor2sfx(ic: jfxs.ImageCursor): ImageCursor = if (ic != null) new ImageCursor(ic) else null

  implicit def jfxLightBase2sfx(v: jfxs.LightBase): LightBase = if (v != null) new LightBase(v) {} else null

  /**
   * $START$NOD.html $NOD$END
   *
   * @param v $JFX $NOD
   * @return $SFX $NOD
   */
  implicit def jfxNode2sfx(v: jfxs.Node): Node = if (v != null) new Node(v) {} else null

  /**
   * $START$PRC.html $PRC$END
   *
   * @param v $JFX $PRC
   * @return $SFX $PRC
   */
  implicit def jfxParallelCamera2sfx(v: jfxs.ParallelCamera): ParallelCamera =
    if (v != null) new ParallelCamera(v) else null

  /**
   * $START$PAR.html $PAR$END
   *
   * @param v $JFX $PAR
   * @return $SFX $PAR
   */
  implicit def jfxParent2sfx(v: jfxs.Parent): Parent = if (v != null) new Parent(v) {} else null

  /**
   * $START$PEC.html $PEC$END
   *
   * @param v $JFX $PEC
   * @return $SFX $PEC
   */
  implicit def jfxPerspectiveCamera2sfx(v: jfxs.PerspectiveCamera): PerspectiveCamera =
    if (v != null) new PerspectiveCamera(v) else null

  implicit def jfxPointLight2sfx(v: jfxs.PointLight): PointLight = if (v != null) new PointLight(v) else null

  /**
   * $START$SCE.html $SCE$END
   *
   * @param v $JFX $SCE
   * @return $SFX $SCE
   */
  implicit def jfxScene2sfx(v: jfxs.Scene): Scene = if (v != null) new Scene(v) else null

  /**
   * $START$SCA.html $SCA$END
   *
   * @param v $JFX $SCA
   * @return $SFX $SCA
   *
   * @throws java.lang.IllegalArgumentException if `v` has no known correspondence in ScalaFX.
   */
  implicit def jfxSceneAntialiasing2sfx(v: jfxs.SceneAntialiasing): SceneAntialiasing = {
    // A value of null is treated as though antialiasing is disabled.
    if (v eq null) SceneAntialiasing.Disabled
    else SceneAntialiasing(v)
  }

  /**
   * Generates a $SCP from a $JFX $SCE.
   *
   * @param p A $SFX [[scalafx.beans.property.ReadOnlyObjectProperty]] containing a $JFX $SCE.
   * @return $SFX $SCP
   */
  implicit def jfxSceneProperty2sfx(p: ReadOnlyObjectProperty[jfxs.Scene]): SceneProperty =
    if (p != null) new SceneProperty(p) else null

  /**
   * $START$SNP.html $SNP$END
   *
   * @param sp $JFX $SNP
   * @return $SFX $SNP
   */
  implicit def jfxSnapshotParameters2sfx(sp: jfxs.SnapshotParameters): SnapshotParameters =
    if (sp != null) new SnapshotParameters(sp) else null

  /**
   * $START$SSCE.html $SSCE$END
   *
   * @param v $JFX $SSCE
   * @return $SFX $SSCE
   */
  implicit def jfxSubScene2sfx(v: jfxs.SubScene): SubScene = if (v != null) new SubScene(v) else null
}
