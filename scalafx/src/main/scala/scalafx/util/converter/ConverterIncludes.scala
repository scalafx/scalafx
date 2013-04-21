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
package scalafx.util.converter

import javafx.util.{ converter => jfxuc }

object ConverterIncludes extends ConverterIncludes

trait ConverterIncludes {
  implicit def jfxBigDecimalStringConverter2sfx(c: jfxuc.BigDecimalStringConverter) = new BigDecimalStringConverter(c)
  implicit def jfxBigIntegerStringConverter2sfx(c: jfxuc.BigIntegerStringConverter) = new BigIntStringConverter(c)
  implicit def jfxBooleanStringConverter2sfx(c: jfxuc.BooleanStringConverter) = new BooleanStringConverter(c)
  implicit def jfxByteStringConverter2sfx(c: jfxuc.ByteStringConverter) = new ByteStringConverter(c)
  implicit def jfxCharacterStringConverter2sfx(c: jfxuc.CharacterStringConverter) = new CharStringConverter(c)
  implicit def jfxCurrencyStringConverter2sfx(c: jfxuc.CurrencyStringConverter) = new CurrencyStringConverter(c)
  implicit def jfxDateStringConverter2sfx(c: jfxuc.DateStringConverter) = new DateStringConverter(c)
  implicit def jfxDateTimeStringConverter2sfx(c: jfxuc.DateTimeStringConverter) = new DateTimeStringConverter(c)
  implicit def jfxDefaultStringConverter2sfx(c: jfxuc.DefaultStringConverter) = new DefaultStringConverter(c)
  implicit def jfxDoubleStringConverter2sfx(c: jfxuc.DoubleStringConverter) = new DoubleStringConverter(c)
  implicit def jfxFloatStringConverter2sfx(c: jfxuc.FloatStringConverter) = new FloatStringConverter(c)
  implicit def jfxIntegerStringConverter2sfx(c: jfxuc.IntegerStringConverter) = new IntStringConverter(c)
  implicit def jfxLongStringConverter2sfx(c: jfxuc.LongStringConverter) = new LongStringConverter(c)
  implicit def jfxNumberStringConverter2sfx(c: jfxuc.NumberStringConverter) = new NumberStringConverter(c)
  implicit def jfxPercentageStringConverter2sfx(c: jfxuc.PercentageStringConverter) = new PercentageStringConverter(c)
  implicit def jfxShortStringConverter2sfx(c: jfxuc.ShortStringConverter) = new ShortStringConverter(c)
  implicit def jfxTimeStringConverter2sfx(c: jfxuc.TimeStringConverter) = new TimeStringConverter(c)
}