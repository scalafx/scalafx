/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import java.text.NumberFormat
import java.util.Locale
import javafx.util.{converter => jfxuc}

import scala.language.implicitConversions

object NumberStringConverter {
  implicit def sfxNumberStringConverter2jfx(c: NumberStringConverter): jfxuc.NumberStringConverter =
    if (c != null) c.delegate else null
}

class NumberStringConverter(delegate: jfxuc.NumberStringConverter = new jfxuc.NumberStringConverter)
    extends NumberStringConverterDelegate[jfxuc.NumberStringConverter](delegate) {

  def this(locale: Locale) = this(new jfxuc.NumberStringConverter(locale))

  def this(locale: Locale, pattern: String) = this(new jfxuc.NumberStringConverter(locale, pattern))

  def this(numberFormat: NumberFormat) = this(new jfxuc.NumberStringConverter(numberFormat))

  def this(pattern: String) = this(new jfxuc.NumberStringConverter(pattern))

}
