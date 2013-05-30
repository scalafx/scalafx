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
package scalafx.scene.effect

import javafx.scene.{ effect => jfxse }

object EffectIncludes extends EffectIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/effect/package-summary.html `javafx.scene.effect`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/effect/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define BLE Blend
 * @define BLM BlendMode
 * @define BLO Bloom
 * @define BBL BoxBlur
 * @define BLT BlurType
 * @define CLA ColorAdjust
 * @define CLI ColorInput
 * @define DSM DisplacementMap
 * @define EFF Effect
 * @define DPS DropShadow
 * @define FLM FloatMap
 * @define GSB GaussianBlur
 * @define GLW Glow
 * @define IIN ImageInput
 * @define INS InnerShadow
 * @define LIG Light
 * @define LDS Light.Distant
 * @define LPT Light.Point
 * @define LSP Light.Spot
 * @define LIN Lighting
 * @define MBL MotionBlur
 * @define PTR PerspectiveTransform
 * @define RFL Reflection
 * @define SPT SepiaTone
 * @define SHW Shadow
 */
trait EffectIncludes {

  /**
   * $START$BLE.html $BLE$END
   *
   * @param b $JFX $BLE
   * @return $SFX $BLE
   */
  implicit def jfxBlend2sfx(b: jfxse.Blend) = new Blend(b)

  /**
   * $START$BLM.html $BLM$END
   *
   * @param e $JFX $BLM
   * @return $SFX $BLM
   */
  implicit def jfxBlendMode2sfx(e: jfxse.BlendMode) = BlendMode.jfxEnum2sfx(e)

  /**
   * $START$BLO.html $BLO$END
   *
   * @param b $JFX $BLO
   * @return $SFX $BLO
   */
  implicit def jfxBloom2sfx(b: jfxse.Bloom) = new Bloom(b)

  /**
   * $START$BBL.html $BBL$END
   *
   * @param bb $JFX $BBL
   * @return $SFX $BBL
   */
  implicit def jfxBoxBlur2sfx(bb: jfxse.BoxBlur) = new BoxBlur(bb)

  /**
   * $START$BLT.html $BLT$END
   *
   * @param e $JFX $BLT
   * @return $SFX $BLT
   */
  implicit def jfxBlurType2sfx(e: jfxse.BlurType) = BlurType.jfxEnum2sfx(e)

  /**
   * $START$CLA.html $CLA$END
   *
   * @param ca $JFX $CLA
   * @return $SFX $CLA
   */
  implicit def jfxColorAdjust2sfx(ca: jfxse.ColorAdjust) = new ColorAdjust(ca)

  /**
   * $START$CLI.html $CLI$END
   *
   * @param ci $JFX $CLI
   * @return $SFX $CLI
   */
  implicit def jfxColorInput2sfx(ci: jfxse.ColorInput) = new ColorInput(ci)

  /**
   * $START$DSM.html $DSM$END
   *
   * @param dm $JFX $DSM
   * @return $SFX $DSM
   */
  implicit def jfxDisplacementMap2sfx(dm: jfxse.DisplacementMap) = new DisplacementMap(dm)

  /**
   * $START$EFF.html $EFF$END
   *
   * @param e $JFX $EFF
   * @return $SFX $EFF
   */
  implicit def jfxEffect2sfx(e: jfxse.Effect) = new Effect(e) {}

  /**
   * $START$DPS.html $DPS$END
   *
   * @param ds $JFX $DPS
   * @return $SFX $DPS
   */
  implicit def jfxDropShadow2sfx(ds: jfxse.DropShadow) = new DropShadow(ds)

  /**
   * $START$FLM.html $FLM$END
   *
   * @param fm $JFX $FLM
   * @return $SFX $FLM
   */
  implicit def jfxFloatMap2sfx(fm: jfxse.FloatMap) = new FloatMap(fm)

  /**
   * $START$GSB.html $GSB$END
   *
   * @param gb $JFX $GSB
   * @return $SFX $GSB
   */
  implicit def jfxGaussianBlur2sfx(gb: jfxse.GaussianBlur) = new GaussianBlur(gb)

  /**
   * $START$GLW.html $GLW$END
   *
   * @param g $JFX $GLW
   * @return $SFX $GLW
   */
  implicit def jfxGlow2sfx(g: jfxse.Glow) = new Glow(g)

  /**
   * $START$IIN.html $IIN$END
   *
   * @param ii $JFX $IIN
   * @return $SFX $IIN
   */
  implicit def jfxImageInput2sfx(ii: jfxse.ImageInput) = new ImageInput(ii)

  /**
   * $START$INS.html $INS$END
   *
   * @param ii $JFX $INS
   * @return $SFX $INS
   */
  implicit def jfxInnerShadow2sfx(ii: jfxse.InnerShadow) = new InnerShadow(ii)

  /**
   * $START$LIG.html $LIG$END
   *
   * @param l $JFX $LIG
   * @return $SFX $LIG
   */
  implicit def jfxLight2sfx(l: jfxse.Light) = new Light(l) {}

  /**
   * $START$LDS.html $LDS$END
   *
   * @param d $JFX $LDS
   * @return $SFX $LDS
   */
  implicit def jfxLightDistant2sfx(d: jfxse.Light.Distant) = new Light.Distant(d)

  /**
   * $START$LPT.html $LPT$END
   *
   * @param p $JFX $LPT
   * @return $SFX $LPT
   */
  implicit def jfxLightPoint2sfx(p: jfxse.Light.Point) = new Light.Point(p)

  /**
   * $START$LSP.html $LSP$END
   *
   * @param s $JFX $LSP
   * @return $SFX $LSP
   */
  implicit def jfxLightSpot2sfx(s: jfxse.Light.Spot) = new Light.Spot(s)

  /**
   * $START$LIN.html $LIN$END
   *
   * @param l $JFX $LIN
   * @return $SFX $LIN
   */
  implicit def jfxLighting2sfx(l: jfxse.Lighting) = new Lighting(l)

  /**
   * $START$MBL.html $MBL$END
   *
   * @param mb $JFX $MBL
   * @return $SFX $MBL
   */
  implicit def jfxMotionBlur2sfx(mb: jfxse.MotionBlur) = new MotionBlur(mb)

  /**
   * $START$PTR.html $PTR$END
   *
   * @param pt $JFX $PTR
   * @return $SFX $PTR
   */
  implicit def jfxPerspectiveTransform2sfx(pt: jfxse.PerspectiveTransform) = new PerspectiveTransform(pt)

  /**
   * $START$RFL.html $RFL$END
   *
   * @param r $JFX $RFL
   * @return $SFX $RFL
   */
  implicit def jfxReflection2sfx(r: jfxse.Reflection) = new Reflection(r)

  /**
   * $START$SPT.html $SPT$END
   *
   * @param st $JFX $SPT
   * @return $SFX $SPT
   */
  implicit def jfxSepiaTone2sfx(st: jfxse.SepiaTone) = new SepiaTone(st)

  /**
   * $START$SHW.html $SHW$END
   *
   * @param s $JFX $SHW
   * @return $SFX $SHW
   */
  implicit def jfxShadow2sfx(s: jfxse.Shadow) = new Shadow(s)

}