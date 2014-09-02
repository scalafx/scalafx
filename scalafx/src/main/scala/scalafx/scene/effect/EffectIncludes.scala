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
package scalafx.scene.effect

import scala.language.implicitConversions
import javafx.scene.{effect => jfxse}

object EffectIncludes extends EffectIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/package-summary.html `javafx.scene.effect`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/
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
  implicit def jfxBlend2sfx(b: jfxse.Blend) = if (b != null) new Blend(b) else null

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
  implicit def jfxBloom2sfx(b: jfxse.Bloom) = if (b != null) new Bloom(b) else null

  /**
   * $START$BBL.html $BBL$END
   *
   * @param bb $JFX $BBL
   * @return $SFX $BBL
   */
  implicit def jfxBoxBlur2sfx(bb: jfxse.BoxBlur) = if (bb != null) new BoxBlur(bb) else null

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
  implicit def jfxColorAdjust2sfx(ca: jfxse.ColorAdjust) = if (ca != null) new ColorAdjust(ca) else null

  /**
   * $START$CLI.html $CLI$END
   *
   * @param ci $JFX $CLI
   * @return $SFX $CLI
   */
  implicit def jfxColorInput2sfx(ci: jfxse.ColorInput) = if (ci != null) new ColorInput(ci) else null

  /**
   * $START$DSM.html $DSM$END
   *
   * @param dm $JFX $DSM
   * @return $SFX $DSM
   */
  implicit def jfxDisplacementMap2sfx(dm: jfxse.DisplacementMap) = if (dm != null) new DisplacementMap(dm) else null

  /**
   * $START$EFF.html $EFF$END
   *
   * @param e $JFX $EFF
   * @return $SFX $EFF
   */
  implicit def jfxEffect2sfx(e: jfxse.Effect) = if (e != null) new Effect(e) {} else null

  /**
   * $START$DPS.html $DPS$END
   *
   * @param ds $JFX $DPS
   * @return $SFX $DPS
   */
  implicit def jfxDropShadow2sfx(ds: jfxse.DropShadow) = if (ds != null) new DropShadow(ds) else null

  /**
   * $START$FLM.html $FLM$END
   *
   * @param fm $JFX $FLM
   * @return $SFX $FLM
   */
  implicit def jfxFloatMap2sfx(fm: jfxse.FloatMap) = if (fm != null) new FloatMap(fm) else null

  /**
   * $START$GSB.html $GSB$END
   *
   * @param gb $JFX $GSB
   * @return $SFX $GSB
   */
  implicit def jfxGaussianBlur2sfx(gb: jfxse.GaussianBlur) = if (gb != null) new GaussianBlur(gb) else null

  /**
   * $START$GLW.html $GLW$END
   *
   * @param g $JFX $GLW
   * @return $SFX $GLW
   */
  implicit def jfxGlow2sfx(g: jfxse.Glow) = if (g != null) new Glow(g) else null

  /**
   * $START$IIN.html $IIN$END
   *
   * @param ii $JFX $IIN
   * @return $SFX $IIN
   */
  implicit def jfxImageInput2sfx(ii: jfxse.ImageInput) = if (ii != null) new ImageInput(ii) else null

  /**
   * $START$INS.html $INS$END
   *
   * @param ii $JFX $INS
   * @return $SFX $INS
   */
  implicit def jfxInnerShadow2sfx(ii: jfxse.InnerShadow) = if (ii != null) new InnerShadow(ii) else null

  /**
   * $START$LIG.html $LIG$END
   *
   * @param l $JFX $LIG
   * @return $SFX $LIG
   */
  implicit def jfxLight2sfx(l: jfxse.Light) = if (l != null) new Light(l) {} else null

  /**
   * $START$LDS.html $LDS$END
   *
   * @param d $JFX $LDS
   * @return $SFX $LDS
   */
  implicit def jfxLightDistant2sfx(d: jfxse.Light.Distant) = if (d != null) new Light.Distant(d) else null

  /**
   * $START$LPT.html $LPT$END
   *
   * @param p $JFX $LPT
   * @return $SFX $LPT
   */
  implicit def jfxLightPoint2sfx(p: jfxse.Light.Point) = if (p != null) new Light.Point(p) else null

  /**
   * $START$LSP.html $LSP$END
   *
   * @param s $JFX $LSP
   * @return $SFX $LSP
   */
  implicit def jfxLightSpot2sfx(s: jfxse.Light.Spot) = if (s != null) new Light.Spot(s) else null

  /**
   * $START$LIN.html $LIN$END
   *
   * @param l $JFX $LIN
   * @return $SFX $LIN
   */
  implicit def jfxLighting2sfx(l: jfxse.Lighting) = if (l != null) new Lighting(l) else null

  /**
   * $START$MBL.html $MBL$END
   *
   * @param mb $JFX $MBL
   * @return $SFX $MBL
   */
  implicit def jfxMotionBlur2sfx(mb: jfxse.MotionBlur) = if (mb != null) new MotionBlur(mb) else null

  /**
   * $START$PTR.html $PTR$END
   *
   * @param pt $JFX $PTR
   * @return $SFX $PTR
   */
  implicit def jfxPerspectiveTransform2sfx(pt: jfxse.PerspectiveTransform) = if (pt != null) new PerspectiveTransform(pt) else null

  /**
   * $START$RFL.html $RFL$END
   *
   * @param r $JFX $RFL
   * @return $SFX $RFL
   */
  implicit def jfxReflection2sfx(r: jfxse.Reflection) = if (r != null) new Reflection(r) else null

  /**
   * $START$SPT.html $SPT$END
   *
   * @param st $JFX $SPT
   * @return $SFX $SPT
   */
  implicit def jfxSepiaTone2sfx(st: jfxse.SepiaTone) = if (st != null) new SepiaTone(st) else null

  /**
   * $START$SHW.html $SHW$END
   *
   * @param s $JFX $SHW
   * @return $SFX $SHW
   */
  implicit def jfxShadow2sfx(s: jfxse.Shadow) = if (s != null) new Shadow(s) else null

}