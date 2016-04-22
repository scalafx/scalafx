/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

import javafx.{application => jfx}

import netscape.javascript.JSObject

import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate

object HostServices {
  /**
    * Converts a ScalaFX HostServices to its JavaFX counterpart.
    *
    * @param v ScalaFX HostServices
    * @return JavaFX HostServices
    */
  implicit def sfxHostServices2jfx(v: HostServices): jfx.HostServices =
    if (v != null) v.delegate else null
}

/**
  * This class provides HostServices for an Application.
  * This includes methods to get the code base and document base for an Application,
  * show a web page in a browser, and communicate with the enclosing web page using JavaScript
  * if the Application is running in a browser.
  *
  * Wraps a $JFX $URL0 $TC]].
  *
  * @define TC HostServices
  * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/application/HostServices.html
  * @define JFX JavaFX
  * @define ORIGINALDOC Original Documentation]].
  */
class HostServices(override val delegate: jfx.HostServices)
  extends SFXDelegate[jfx.HostServices] {

  /**
    * Gets the code base URI for this application.
    */
  def codeBase: String = delegate.getCodeBase

  /**
    * Gets the document base URI for this application.
    */
  def documentBase: String = delegate.getDocumentBase

  /**
    * Returns the JavaScript handle of the enclosing DOM window of the web page containing this application.
    */
  def webContext: JSObject = delegate.getWebContext

}