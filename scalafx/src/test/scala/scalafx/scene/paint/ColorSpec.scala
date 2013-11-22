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
package scalafx.scene.paint

import javafx.scene.{ paint => jfxsp }
import jfxsp.{ Color => JColor }
import scalafx.Includes._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scalafx.testutil.AbstractSFXDelegateSpec
import org.scalatest.Matchers._
import org.scalautils.Tolerance.convertNumericToPlusOrMinusWrapper

/**
 * Color Spec tests.
 */
@RunWith(classOf[JUnitRunner])
class ColorSpec
  extends AbstractSFXDelegateSpec[jfxsp.Color, Color, jfxsp.ColorBuilder[_]](classOf[jfxsp.Color], classOf[Color], classOf[jfxsp.ColorBuilder[_]]) {

  override protected def getJavaClassInstance = new jfxsp.Color(0, 0, 0, 0)

  private def assertComponent(realValue: Double, expectedValue: Double) {
    realValue should be(convertNumericToPlusOrMinusWrapper(expectedValue) +- 0.01)
  }

  private def intToDouble(i: Int): Double = i.toDouble / 255.0

  private def compareSfxColors(c: Color, r: Double, g: Double, b: Double, o: Double = 1.0) {
    assertComponent(c.red, r)
    assertComponent(c.green, g)
    assertComponent(c.blue, b)
    assertComponent(c.opacity, o)
  }

  private def testSfxColor(c: Color, r: Int, g: Int, b: Int, o: Int = 255) = compareSfxColors(c, intToDouble(r), intToDouble(g), intToDouble(b), intToDouble(o))

  private def compareJfxColors(c: JColor, r: Double, g: Double, b: Double, o: Double = 1.0) {
    assertComponent(c.getRed(), r)
    assertComponent(c.getGreen(), g)
    assertComponent(c.getBlue(), b)
    assertComponent(c.getOpacity(), o)
  }

  private def testJfxColor(c: JColor, r: Int, g: Int, b: Int, o: Int = 255) = compareJfxColors(c, intToDouble(r), intToDouble(g), intToDouble(b), intToDouble(o))

  it should "convert a webcolor to a ScalaFX Color" in {
    compareSfxColors("orange", Color.ORANGE.red, Color.ORANGE.green, Color.ORANGE.blue, Color.ORANGE.opacity)
    testSfxColor("transparent", 0, 0, 0, 0)
    testSfxColor("0xff668840", 0xff, 0x66, 0x88, 0x40)
    testSfxColor("0xff6688", 0xff, 0x66, 0x88)
    testSfxColor("#ff6688", 0xff, 0x66, 0x88)
    testSfxColor("#f68", 0xff, 0x66, 0x88)
    testSfxColor("rgb(255,102,136)", 255, 102, 136)
    compareSfxColors("rgb(100%,50%,50%)", 1, 0.5, 0.5)
    compareSfxColors("rgba(255,50%,50%,0.25)", 1, 0.5, 0.5, 0.25)
    val hsl = Color.hsb(240, 1, 1)
    compareSfxColors("hsl(240,100%,100%)", hsl.red, hsl.green, hsl.blue, hsl.opacity)
    val hsla = Color.hsb(120, 0, 0, 0.25)
    compareSfxColors("hsla(120,0%,0%,0.25)", hsla.red, hsla.green, hsla.blue, hsla.opacity)
  }

  it should "convert a webcolor to a JavaFX Color" in {
    compareJfxColors("orange", JColor.ORANGE.getRed(), JColor.ORANGE.getGreen(), JColor.ORANGE.getBlue(), JColor.ORANGE.getOpacity())
    testJfxColor("transparent", 0, 0, 0, 0)
    testJfxColor("0xff668840", 0xff, 0x66, 0x88, 0x40)
    testJfxColor("0xff6688", 0xff, 0x66, 0x88)
    testJfxColor("#ff6688", 0xff, 0x66, 0x88)
    testJfxColor("#f68", 0xff, 0x66, 0x88)
    testJfxColor("rgb(255,102,136)", 255, 102, 136)
    compareJfxColors("rgb(100%,50%,50%)", 1, 0.5, 0.5)
    compareJfxColors("rgba(255,50%,50%,0.25)", 1, 0.5, 0.5, 0.25)
    val hsl = JColor.hsb(240, 1, 1)
    compareJfxColors("hsl(240,100%,100%)", hsl.getRed(), hsl.getGreen(), hsl.getBlue(), hsl.getOpacity())
    val hsla = JColor.hsb(120, 0, 0, 0.25)
    compareJfxColors("hsla(120,0%,0%,0.25)", hsla.getRed(), hsla.getGreen(), hsla.getBlue(), hsla.getOpacity())
  }

  it should "convert a number to a ScalaFX Color" in {
    testSfxColor(0xff6688, 0xff, 0x66, 0x88)
    testSfxColor(0xeeff6688, 0xff, 0x66, 0x88)
    testSfxColor(0xabcdef, 0xab, 0xcd, 0xef)
    compareSfxColors(0, 0, 0, 0)
    compareSfxColors(255, 0, 0, 1)
    compareSfxColors(65280, 0, 1, 0)
    compareSfxColors(16777215, 1, 1, 1)
  }

  it should "convert a number to a JavaFX Color" in {
    testJfxColor(0xff6688, 0xff, 0x66, 0x88)
    testJfxColor(0xeeff6688, 0xff, 0x66, 0x88)
    testJfxColor(0xabcdef, 0xab, 0xcd, 0xef)
    compareJfxColors(0, 0, 0, 0)
    compareJfxColors(255, 0, 0, 1)
    compareJfxColors(65280, 0, 1, 0)
    compareJfxColors(16777215, 1, 1, 1)
  }
  
  it should "convert a tuple to a ScalaFX Color" in {
    testSfxColor((213, 23, 152), 213, 23, 152)
    testSfxColor((213, 23, 152, 0.25), 213, 23, 152, 255 / 4)
    testSfxColor((0, 0, 0), 0, 0, 0)
    testSfxColor((255, 255, 255, 1.0), 255, 255, 255, 255)
  }

  it should "convert a tuple to a JavaFX Color" in {
    testJfxColor((213, 23, 152), 213, 23, 152)
    testJfxColor((213, 23, 152, 0.25), 213, 23, 152, 255 / 4)
    testJfxColor((0, 0, 0), 0, 0, 0)
    testJfxColor((255, 255, 255, 1.0), 255, 255, 255, 255)
  }

}
