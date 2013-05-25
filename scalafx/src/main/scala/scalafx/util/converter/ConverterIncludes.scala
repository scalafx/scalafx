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

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/util/converter/package-summary.html `javafx.util.converter`]]
 * Classes to their ScalaFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/util/converter/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define BDSC BigDecimalStringConverter
 * @define BISC BigIntegerStringConverter
 * @define BOSC BooleanStringConverter
 * @define BYSC ByteStringConverter
 * @define CHSC CharacterStringConverter
 * @define CUSC CurrencyStringConverter
 * @define DASC DateStringConverter
 * @define DTSC DateTimeStringConverter
 * @define DESC DefaultStringConverter
 * @define DOSC DoubleStringConverter
 * @define FLSC FloatStringConverter
 * @define INSC IntegerStringConverter
 * @define LOSC LongStringConverter
 * @define NUSC NumberStringConverter
 * @define PESC PercentageStringConverter
 * @define SHSC ShortStringConverter
 * @define TISC TimeStringConverter
 */
trait ConverterIncludes {

  /**
   * $START$BDSC.html $BDSC$END
   *
   * @param c $JFX $BDSC
   * @return $SFX $BDSC
   */
  implicit def jfxBigDecimalStringConverter2sfx(c: jfxuc.BigDecimalStringConverter) = new BigDecimalStringConverter(c)

  /**
   * $START$BISC.html $BISC$END
   *
   * @param c $JFX $BISC
   * @return $SFX $BISC
   */
  implicit def jfxBigIntegerStringConverter2sfx(c: jfxuc.BigIntegerStringConverter) = new BigIntStringConverter(c)

  /**
   * $START$BOSC.html $BOSC$END
   *
   * @param c $JFX $BOSC
   * @return $SFX $BOSC
   */
  implicit def jfxBooleanStringConverter2sfx(c: jfxuc.BooleanStringConverter) = new BooleanStringConverter(c)

  /**
   * $START$BYSC.html $BYSC$END
   *
   * @param c $JFX $BYSC
   * @return $SFX $BYSC
   */
  implicit def jfxByteStringConverter2sfx(c: jfxuc.ByteStringConverter) = new ByteStringConverter(c)

  /**
   * $START$CHSC.html $CHSC$END
   *
   * @param c $JFX $CHSC
   * @return $SFX $CHSC
   */
  implicit def jfxCharacterStringConverter2sfx(c: jfxuc.CharacterStringConverter) = new CharStringConverter(c)

  /**
   * $START$CUSC.html $CUSC$END
   *
   * @param c $JFX $CUSC
   * @return $SFX $CUSC
   */
  implicit def jfxCurrencyStringConverter2sfx(c: jfxuc.CurrencyStringConverter) = new CurrencyStringConverter(c)

  /**
   * $START$DASC.html $DASC$END
   *
   * @param c $JFX $DASC
   * @return $SFX $DASC
   */
  implicit def jfxDateStringConverter2sfx(c: jfxuc.DateStringConverter) = new DateStringConverter(c)

  /**
   * $START$DTSC.html $DTSC$END
   *
   * @param c $JFX $DTSC
   * @return $SFX $DTSC
   */
  implicit def jfxDateTimeStringConverter2sfx(c: jfxuc.DateTimeStringConverter) = new DateTimeStringConverter(c)

  /**
   * $START$DESC.html $DESC$END
   *
   * @param c $JFX $DESC
   * @return $SFX $DESC
   */
  implicit def jfxDefaultStringConverter2sfx(c: jfxuc.DefaultStringConverter) = new DefaultStringConverter(c)

  /**
   * $START$DOSC.html $DOSC$END
   *
   * @param c $JFX $DOSC
   * @return $SFX $DOSC
   */
  implicit def jfxDoubleStringConverter2sfx(c: jfxuc.DoubleStringConverter) = new DoubleStringConverter(c)

  /**
   * $START$FLSC.html $FLSC$END
   *
   * @param c $JFX $FLSC
   * @return $SFX $FLSC
   */
  implicit def jfxFloatStringConverter2sfx(c: jfxuc.FloatStringConverter) = new FloatStringConverter(c)

  /**
   * $START$INSC.html $INSC$END
   *
   * @param c $JFX $INSC
   * @return $SFX $INSC
   */
  implicit def jfxIntegerStringConverter2sfx(c: jfxuc.IntegerStringConverter) = new IntStringConverter(c)

  /**
   * $START$LOSC.html $LOSC$END
   *
   * @param c $JFX $LOSC
   * @return $SFX $LOSC
   */
  implicit def jfxLongStringConverter2sfx(c: jfxuc.LongStringConverter) = new LongStringConverter(c)

  /**
   * $START$NUSC.html $NUSC$END
   *
   * @param c $JFX $NUSC
   * @return $SFX $NUSC
   */
  implicit def jfxNumberStringConverter2sfx(c: jfxuc.NumberStringConverter) = new NumberStringConverter(c)

  /**
   * $START$PESC.html $PESC$END
   *
   * @param c $JFX $PESC
   * @return $SFX $PESC
   */
  implicit def jfxPercentageStringConverter2sfx(c: jfxuc.PercentageStringConverter) = new PercentageStringConverter(c)

  /**
   * $START$SHSC.html $SHSC$END
   *
   * @param c $JFX $SHSC
   * @return $SFX $SHSC
   */
  implicit def jfxShortStringConverter2sfx(c: jfxuc.ShortStringConverter) = new ShortStringConverter(c)

  /**
   * $START$TISC.html $TISC$END
   *
   * @param c $JFX $TISC
   * @return $SFX $TISC
   */
  implicit def jfxTimeStringConverter2sfx(c: jfxuc.TimeStringConverter) = new TimeStringConverter(c)

}