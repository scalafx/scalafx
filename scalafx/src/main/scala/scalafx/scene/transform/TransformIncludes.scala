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
package scalafx.scene.transform

import javafx.scene.{ transform => jfxst }

object TransformIncludes extends TransformIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/transform/package-summary.html `javafx.scene.transform`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/transform/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define AF Affine
 * @define RT Rotate
 * @define SC Scale
 * @define SH Shear
 * @define TR Transform
 * @define TL Translate
 */
trait TransformIncludes {

  /**
   * $START$AF.html $AF$END
   *
   * @param v $JFX $AF
   * @return $SFX $AF
   */
  implicit def jfxAffine2sfx(v: jfxst.Affine) = new Affine(v)

  /**
   * $START$RT.html $RT$END
   *
   * @param v $JFX $RT
   * @return $SFX $RT
   */
  implicit def jfxRotate2sfx(v: jfxst.Rotate) = new Rotate(v)

  /**
   * $START$SC.html $SC$END
   *
   * @param v $JFX $SC
   * @return $SFX $SC
   */
  implicit def jfxScale2sfx(v: jfxst.Scale) = new Scale(v)

  /**
   * $START$SH.html $SH$END
   *
   * @param v $JFX $SH
   * @return $SFX $SH
   */
  implicit def jfxShear2sfx(v: jfxst.Shear) = new Shear(v)

  /**
   * $START$TR.html $TR$END
   *
   * @param v $JFX $TR
   * @return $SFX $TR
   */
  implicit def jfxTransform2sfx(v: jfxst.Transform) = new Transform(v) {}

  /**
   * $START$TL.html $TL$END
   *
   * @param v $JFX $TL
   * @return $SFX $TL
   */
  implicit def jfxTranslate2sfx(v: jfxst.Translate) = new Translate(v)

}