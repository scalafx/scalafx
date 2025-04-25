/*
 * Copyright (c) 2011-2025, ScalaFX Project
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
package scalafx.application

import javafx.application as jfxa
import scalafx.util.JavaConverters.*

import scala.collection.mutable
import scala.language.implicitConversions

object ApplicationIncludes extends ApplicationIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/application/package-summary.html `javafx.application`]] Classes to
 * their ScalaFX counterparts.
 */
trait ApplicationIncludes {

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.Parameters.html `javafx.application.Application.Parameters`]]
   * instance to its ScalaFX counterpart.
   *
   * @param p JavaFX Parameters
   * @return ScalaFX Parameters
   */
  implicit def jfxParameters2sfx(p: jfxa.Application.Parameters): JFXApp3.Parameters =
    if (p != null) new JFXApp3.Parameters {
      def raw: mutable.Buffer[String] = p.getRaw.asScala

      def named: mutable.Map[String, String] = p.getNamed.asScala

      def unnamed: mutable.Buffer[String] = p.getUnnamed.asScala

      def delegate: jfxa.Application.Parameters = p
    }
    else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/application/ConditionalFeature.html `javafx.application.ConditionalFeature`]]
   * instance to its ScalaFX counterpart.
   *
   * @param e JavaFX ConditionalFeature
   * @return ScalaFX ConditionalFeature
   */
  implicit def jfxConditionalFeature2sfx(e: jfxa.ConditionalFeature): ConditionalFeature =
    ConditionalFeature.jfxEnum2sfx(e)

  implicit def jfxHostServices2sfx(e: jfxa.HostServices): HostServices =
    Option(e).map(new HostServices(_)).orNull

  implicit def jfxPreferences2sfx(p: jfxa.Platform.Preferences): Platform.Preferences =
    Option(p).map(new Platform.Preferences(_) {}).orNull

  implicit def jfxColorScheme2sfx(o: jfxa.ColorScheme): ColorScheme = ColorScheme.jfxEnum2sfx(o)

}
