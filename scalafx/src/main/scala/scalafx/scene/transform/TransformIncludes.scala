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
package scalafx.scene.transform

import javafx.scene.{transform => jfxst}

import scala.language.implicitConversions

object TransformIncludes extends TransformIncludes

/**
  * Contains implcit methods to convert from
  * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/transform/package-summary.html `javafx.scene.transform`]]
  * Classes/Traits to their $SFX counterparts.
  *
  * @define JFX   JavaFX
  * @define SFX   ScalaFX
  * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/transform/
  *               @define END ]]` instance to its $SFX counterpart.
  * @define AF    Affine
  * @define RT    Rotate
  * @define SC    Scale
  * @define SH    Shear
  * @define TR    Transform
  * @define TL    Translate
  */
trait TransformIncludes {

  /**
    * $START$AF.html $AF$END
    *
    * @param v $JFX $AF
    * @return $SFX $AF
    */
  implicit def jfxAffine2sfx(v: jfxst.Affine): Affine = if (v != null) new Affine(v) else null

  implicit def jfxMatrixType2sfx(v: jfxst.MatrixType): MatrixType = if (v != null) MatrixType(v) else null

  implicit def jfxNonInvertibleTransformException2sfx(
      v: jfxst.NonInvertibleTransformException
  ): NonInvertibleTransformException =
    if (v != null) new NonInvertibleTransformException(v) else null

  /**
    * $START$RT.html $RT$END
    *
    * @param v $JFX $RT
    * @return $SFX $RT
    */
  implicit def jfxRotate2sfx(v: jfxst.Rotate): Rotate = if (v != null) new Rotate(v) else null

  /**
    * $START$SC.html $SC$END
    *
    * @param v $JFX $SC
    * @return $SFX $SC
    */
  implicit def jfxScale2sfx(v: jfxst.Scale): Scale = if (v != null) new Scale(v) else null

  /**
    * $START$SH.html $SH$END
    *
    * @param v $JFX $SH
    * @return $SFX $SH
    */
  implicit def jfxShear2sfx(v: jfxst.Shear): Shear = if (v != null) new Shear(v) else null

  /**
    * $START$TR.html $TR$END
    *
    * @param v $JFX $TR
    * @return $SFX $TR
    */
  implicit def jfxTransform2sfx(v: jfxst.Transform): Transform = if (v != null) new Transform(v) {} else null

  implicit def jfxTransformChangedEvent2sfx(v: jfxst.TransformChangedEvent): TransformChangedEvent =
    if (v != null) new TransformChangedEvent(v) else null

  /**
    * $START$TL.html $TL$END
    *
    * @param v $JFX $TL
    * @return $SFX $TL
    */
  implicit def jfxTranslate2sfx(v: jfxst.Translate): Translate = if (v != null) new Translate(v) else null

}
