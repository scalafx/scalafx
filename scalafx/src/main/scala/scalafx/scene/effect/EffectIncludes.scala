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

/*
 * Copyright (c) 2012, ScalaFX Project
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
import javafx.scene.{ effect => jfxse }

object EffectIncludes extends EffectIncludes

trait EffectIncludes {
  implicit def jfxBlend2sfx(b: jfxse.Blend) = new Blend(b)
  implicit def jfxBlendMode2sfx(e: jfxse.BlendMode) = BlendMode.jfxEnum2sfx(e)
  implicit def jfxBloom2sfx(b: jfxse.Bloom) = new Bloom(b)
  implicit def jfxBoxBlur2sfx(bb: jfxse.BoxBlur) = new BoxBlur(bb)
  implicit def jfxBlurType2sfx(e: jfxse.BlurType) = BlurType.jfxEnum2sfx(e)
  implicit def jfxColorAdjust2sfx(ca: jfxse.ColorAdjust) = new ColorAdjust(ca)
  implicit def jfxColorInput2sfx(ci: jfxse.ColorInput) = new ColorInput(ci)
  implicit def jfxDisplacementMap2sfx(dm: jfxse.DisplacementMap) = new DisplacementMap(dm)
  implicit def jfxEffect2sfx(e: jfxse.Effect) = new Effect(e) {}
  implicit def jfxDropShadow2sfx(ds: jfxse.DropShadow) = new DropShadow(ds)
  implicit def jfxFloatMap2sfx(fm: jfxse.FloatMap) = new FloatMap(fm)
  implicit def jfxGaussianBlur2sfx(gb: jfxse.GaussianBlur) = new GaussianBlur(gb)
  implicit def jfxGlow2sfx(g: jfxse.Glow) = new Glow(g)
  implicit def jfxImageInput2sfx(ii: jfxse.ImageInput) = new ImageInput(ii)
  implicit def jfxInnerShadow2sfx(ii: jfxse.InnerShadow) = new InnerShadow(ii)
  implicit def jfxLight2sfx(l: jfxse.Light) = new Light(l) {}
  implicit def jfxLightDistant2sfx(d: jfxse.Light.Distant) = new Light.Distant(d)
  implicit def jfxLightPoint2sfx(p: jfxse.Light.Point) = new Light.Point(p)
  implicit def jfxLightSpot2sfx(s: jfxse.Light.Spot) = new Light.Spot(s)
  implicit def jfxLighting2sfx(l: jfxse.Lighting) = new Lighting(l)
  implicit def jfxMotionBlur2sfx(mb: jfxse.MotionBlur) = new MotionBlur(mb)
  implicit def jfxPerspectiveTransform2sfx(pt: jfxse.PerspectiveTransform) = new PerspectiveTransform(pt)
  implicit def jfxReflection2sfx(r: jfxse.Reflection) = new Reflection(r)
  implicit def jfxSepiaTone2sfx(st: jfxse.SepiaTone) = new SepiaTone(st)
  implicit def jfxShadow2sfx(s: jfxse.Shadow) = new Shadow(s)
}