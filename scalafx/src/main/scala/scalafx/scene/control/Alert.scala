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

package scalafx.scene.control

import javafx.scene.{control => jfxsc}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.scene.control.Alert.AlertType

object Alert {
  /**
   * Converts a ScalaFX Alert to its JavaFX counterpart.
   *
   * @param v ScalaFX Alert
   * @return JavaFX Alert
   */
  implicit def sfxAlert2jfx(v: Alert): jfxsc.Alert =
    if (v != null) v.delegate else null

  /**
   * An enumeration containing the available, pre-built alert types that
   * the `Alert` class can use to pre-populate various properties.
   */
  object AlertType extends SFXEnumDelegateCompanion[jfxsc.Alert.AlertType, AlertType] {
    /**
     * The `None` alert type has the effect of not setting any default properties
     * in the Alert.
     */
    val None = AlertType(jfxsc.Alert.AlertType.NONE)

    /**
     * The `INFORMATION` alert type configures the Alert dialog to appear in a
     * way that suggests the content of the dialog is informing the user of
     * a piece of information. This includes an 'information' image, an
     * appropriate title and header, and just an OK button for the user to
     * click on to dismiss the dialog.
     */
    val Information = AlertType(jfxsc.Alert.AlertType.INFORMATION)

    /**
     * The `Warning` alert type configures the Alert dialog to appear in a
     * way that suggests the content of the dialog is warning the user about
     * some fact or action. This includes a 'warning' image, an
     * appropriate title and header, and just an OK button for the user to
     * click on to dismiss the dialog.
     */
    val Warning = AlertType(jfxsc.Alert.AlertType.WARNING)

    /**
     * The `Confirmation` alert type configures the Alert dialog to appear in a
     * way that suggests the content of the dialog is seeking confirmation from
     * the user. This includes a 'confirmation' image, an
     * appropriate title and header, and both OK and Cancel buttons for the
     * user to click on to dismiss the dialog.
     */
    val Confirmation = AlertType(jfxsc.Alert.AlertType.CONFIRMATION)

    /**
     * The `Error` alert type configures the Alert dialog to appear in a
     * way that suggests that something has gone wrong. This includes an
     * 'error' image, an appropriate title and header, and just an OK button
     * for the user to click on to dismiss the dialog.
     */
    val Error = AlertType(jfxsc.Alert.AlertType.ERROR)

    /** Contain constants which will be source for `values` List  */
    override protected def unsortedValues = Array(None, Information, Warning, Confirmation, Error)
  }

  sealed case class AlertType(override val delegate: jfxsc.Alert.AlertType)
    extends SFXEnumDelegate[jfxsc.Alert.AlertType]

}

/**
 * The Alert class subclasses the `Dialog` class, and provides support for a number
 * of pre-built dialog types that can be easily shown to users to prompt for a
 * response.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * Example of displaying an information dialog:
 * {{{
 *   new Alert(AlertType.Information) {
       title = "Information Dialog"
       headerText = "Look, an Information Dialog"
       contentText = "I have a great message for you!"
     }.showAndWait()
 * }}}
 *
 * A bit more elaborated example that is using a custom buttons:
 *
 * {{{
 *  val One = new ButtonType("One")
 *  val Two = new ButtonType("Two")
 *  val Three = new ButtonType("Three")
 *
 *  val alert = new Alert(AlertType.Confirmation) {
 *    title = "Confirmation Dialog with Custom Actions"
 *    headerText = "Look, a Confirmation Dialog with Custom Actions"
 *    contentText = "Choose your option."
 *    buttonTypes = Seq(One, Two, Three, ButtonType.Cancel)
 *  }
 *
 *  val result = alert.showAndWait()
 *
 *  // Convert option to avoid matching on JavaFX types
 *  ButtonType(result) match {
 *    case Some(One)   => println("... user chose \"One\"")
 *    case Some(Two)   => println("... user chose \"Two\"")
 *    case Some(Three) => println("... user chose \"Three\"")
 *    case _           => println("... user chose CANCEL or closed the dialog")
 *  }
 * }}}
 *
 * @define TC Alert
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx.scene.control/Alert.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class Alert(override val delegate: jfxsc.Alert)
  extends Dialog[jfxsc.ButtonType](delegate)
  with SFXDelegate[jfxsc.Alert] {

  /**
   * Creates an alert with the given AlertType (refer to the `AlertType`
   * documentation for clarification over which one is most appropriate).
   *
   * By passing in an AlertType, default values for the
   * `title` property, `headerText` property, `graphic` property properties are set. Once the Alert
   * is instantiated, developers are able to modify the values of the alert as
   * desired.
   */
  def this(alertType: AlertType) = this(new jfxsc.Alert(alertType))

  /**
   * Creates an alert with the given contentText, ButtonTypes, and AlertType
   * (refer to the `AlertType` documentation for clarification over which
   * one is most appropriate).
   *
   * By passing in a variable number of ButtonType arguments, the developer
   * is directly overriding the default buttons that will be displayed in the
   * dialog, replacing the pre-defined buttons with whatever is specified in the
   * varargs array.
   *
   * By passing in an AlertType, default values for the
   * `title` property, `headerText` property, `graphic` property properties are set. Once the Alert
   * is instantiated, developers are able to modify the values of the alert as
   * desired.
   */
  def this(alertType: AlertType, contentText: String, buttons: ButtonType*) =
    this(new jfxsc.Alert(alertType, contentText, buttons.map(_.delegate): _*))

  def alertType: ObjectProperty[jfxsc.Alert.AlertType] = delegate.alertTypeProperty
  def alertType_(v: AlertType) {
    alertType() = v
  }


  /**
   * Returns an `ObservableBuffer` of all `ButtonType` instances that
   * are currently set inside this Alert instance.
   */
  def buttonTypes: ObservableBuffer[jfxsc.ButtonType] = delegate.getButtonTypes
  def buttonTypes_=(types: Iterable[ButtonType]): Unit = {
    buttonTypes.clear()
    buttonTypes ++= types.map(_.delegate)
  }
}