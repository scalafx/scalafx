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

import javafx.beans.{ property => jfxbp }
import scalafx.beans.property.ReadOnlyObjectProperty
import javafx.{ scene => jfxs }
import chart.ChartIncludes
import layout.LayoutIncludes
import image.ImageIncludes
import paint.PaintIncludes
import shape.ShapeIncludes
import control.ControlIncludes
import text.TextIncludes
import effect.EffectIncludes

object SceneIncludes extends SceneIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/package-summary.html `javafx.scene`]] and subpackages
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
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/package-summary.html `javafx.scene`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/
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
 * @define SCP SceneProperty
 * @define SNP SnapshotParameters
 */
trait LowerPriorityIncludes {

  /**
   * $START$CHI.html $CHI$END
   *
   * @param e $JFX $CHI
   * @return $SFX $CHI
   */
  implicit def jfxCacheHint2sfx(e: jfxs.CacheHint) = CacheHint.jfxEnum2sfx(e)

  /**
   * $START$CAM.html $CAM$END
   *
   * @param v $JFX $CAM
   * @return $SFX $CAM
   */
  implicit def jfxCamera2sfx(v: jfxs.Camera) = new Camera(v) {}

  /**
   * $START$CUR.html $CUR$END
   *
   * @param v $JFX $CUR
   * @return $SFX $CUR
   */
  implicit def jfxCursor2sfx(v: jfxs.Cursor) = new Cursor(v) {}

  /**
   * $START$DPT.html $DPT$END
   *
   * @param e $JFX $DPT
   * @return $SFX $DPT
   */
  implicit def jfxDepthTest2sfx(e: jfxs.DepthTest) = DepthTest.jfxEnum2sfx(e)

  /**
   * $START$GRP.html $GRP$END
   *
   * @param v $JFX $GRP
   * @return $SFX $GRP
   */
  implicit def jfxGroup2sfx(v: jfxs.Group) = new Group(v)

  /**
   * $START$IMC.html $IMC$END
   *
   * @param ic $JFX $IMC
   * @return $SFX $IMC
   */
  implicit def jfxImageCursor2sfx(ic: jfxs.ImageCursor) = new ImageCursor(ic)

  /**
   * $START$NOD.html $NOD$END
   *
   * @param v $JFX $NOD
   * @return $SFX $NOD
   */
  implicit def jfxNode2sfx(v: jfxs.Node) = new Node(v) {}

  /**
   * $START$PRC.html $PRC$END
   *
   * @param v $JFX $PRC
   * @return $SFX $PRC
   */
  implicit def jfxParallelCamera2sfx(v: jfxs.ParallelCamera) = new ParallelCamera(v)

  /**
   * $START$PAR.html $PAR$END
   *
   * @param v $JFX $PAR
   * @return $SFX $PAR
   */
  implicit def jfxParent2sfx(v: jfxs.Parent) = new Parent(v) {}

  /**
   * $START$PEC.html $PEC$END
   *
   * @param v $JFX $PEC
   * @return $SFX $PEC
   */
  implicit def jfxPerspectiveCamera2sfx(v: jfxs.PerspectiveCamera) = new PerspectiveCamera(v)

  /**
   * $START$SCE.html $SCE$END
   *
   * @param v $JFX $SCE
   * @return $SFX $SCE
   */
  implicit def jfxScene2sfx(v: jfxs.Scene) = new Scene(v)

  /**
   * Generates a $SCP from a $JFX $SCE.
   *
   * @param p A $SFX [[scalafx.beans.property.ReadOnlyObjectProperty]] containing a $JFX $SCE.
   * @return $SFX $SCP
   */
  implicit def jfxSceneProperty2sfx(p: ReadOnlyObjectProperty[jfxs.Scene]) = new SceneProperty(p)

  /**
   * $START$SNP.html $SNP$END
   *
   * @param sp $JFX $SNP
   * @return $SFX $SNP
   */
  implicit def jfxSnapshotParameters2sfx(sp: jfxs.SnapshotParameters) = new SnapshotParameters(sp)

}