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
import javafx.{event => jfxe, scene => jfxs, util => jfxu}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.delegate.SFXDelegate
import scalafx.event.EventTarget
import scalafx.scene.Node
import scalafx.stage.{Modality, StageStyle, Window}

/** Helper trait for converting dialog return type. Not intended for separate use. */
trait DConvert[T, F] {
  type S
  def apply(t: T, f: F): S
}

object DConvert {
  def apply[T, F](implicit conv: DConvert[T, F]) = conv
  implicit def t2r[T, R]: DConvert[T, T => R] = new DConvert[T, T => R] {
    type S = R
    def apply(t: T, f: T => R) = f(t)
  }
}

/**
 * Object companion for [[scalafx.scene.control.Dialog]].
 */
object Dialog {
  /**
   * Converts a ScalaFX Dialog to its JavaFX counterpart.
   *
   * @param v ScalaFX Dialog
   * @return JavaFX Dialog
   */
  implicit def sfxDialog2jfx[R](v: Dialog[R]): jfxsc.Dialog[R] = if (v != null) v.delegate else null
}

/**
 * A Dialog wraps a DialogPane and provides the necessary API to present it to end users.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * @tparam R The default return type of the dialog, via the result property or `showAndWait` method.
 *
 * @define TC Dialog
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class Dialog[R](override val delegate: jfxsc.Dialog[R] = new jfxsc.Dialog[R]())
  extends EventTarget(delegate)
  with SFXDelegate[jfxsc.Dialog[R]] {

  /**
   * Shows the dialog and waits for the user response (in other words, brings
   * up a blocking dialog, with the returned value the users input).
   *
   * The intended use when return value is ignored:
   * {{{
   *   dialog.showAndWait()
   * }}}
   * Or when return value is required:
   * {{{
   *   val r = dialog.showAndWait()
   *   r match {
   *     case Some(v) => ...
   *     case None => ...
   *   }
   * }}}
   *
   * @return An `Option` that contains the `result`.
   * @see $URL0#showAndWait showAndWait $ORIGINALDOC
   */
  def showAndWait[F](j2s: F = { x: R => x})(implicit convert: DConvert[R, F]): Option[convert.S] = {
    val v = delegate.showAndWait()
    if (v.isPresent) Some(convert(v.get, j2s)) else None
  }

  /**
   * Specifies the style for this dialog. This must be done prior to making
   * the dialog visible. The style is one of: StageStyle.DECORATED,
   * StageStyle.UNDECORATED, StageStyle.TRANSPARENT, StageStyle.UTILITY,
   * or StageStyle.UNIFIED.
   *
   * @param style the style for this dialog.
   *
   * @throws IllegalStateException if this property is set after the dialog
   *                               has ever been made visible.
   *
   */
  def initStyle(style: StageStyle) {
    delegate.initStyle(style)
  }

  /**
   * Specifies the modality for this dialog. This must be done prior to making
   * the dialog visible. The modality is one of: Modality.NONE,
   * Modality.WINDOW_MODAL, or Modality.APPLICATION_MODAL.
   *
   * @param modality the modality for this dialog.
   *
   * @throws IllegalStateException if this property is set after the dialog
   *                               has ever been made visible.
   */
  def initModality(modality: Modality) {
    delegate.initModality(modality)
  }

  /**
   * Retrieves the modality attribute for this dialog.
   *
   * @return the modality.
   * @see $URL0#getModality getModality $ORIGINALDOC
   */
  def modality: Modality = delegate.getModality

  /**
   * Specifies the owner [[Window]] for this dialog, or null for a top-level,
   * unowned dialog. This must be done prior to making the dialog visible.
   *
   * @param window the owner [[Window]] for this dialog.
   *
   * @throws IllegalStateException if this property is set after the dialog
   *                               has ever been made visible.
   */
  def initOwner(window: Window) {
    delegate.initOwner(window)
  }

  /**
   * Retrieves the owner Window for this dialog, or null for an unowned dialog.
   *
   * @return the owner Window.
   * @see $URL0#getOwner  $ORIGINALDOC
   */
  def owner: Window = delegate.getOwner

  def dialogPane: ObjectProperty[jfxsc.DialogPane] = delegate.dialogPaneProperty
  def dialogPane_=(value: DialogPane): Unit = {
    ObjectProperty.fillProperty[jfxsc.DialogPane](this.dialogPane, value)
  }

  /**
   * A property representing the content text for the dialog pane. The content text
   * is lower precedence than the [[scalafx.scene.control.DialogPane.content]] node, meaning
   * that if both the content node and the contentText properties are set, the
   * content text will not be displayed in a default DialogPane instance.
   *
   * @see $URL0#contentTextProperty  $ORIGINALDOC
   */
  def contentText: StringProperty = delegate.contentTextProperty
  def contentText_=(value: String): Unit = {
    contentText() = value
  }

  /**
   * A property representing the header text for the dialog pane. The header text
   * is lower precedence than the [[scalafx.scene.control.DialogPane.header]] node, meaning
   * that if both the header node and the headerText properties are set, the
   * header text will not be displayed in a default DialogPane instance.
   *
   * @see $URL0#headerTextProperty  $ORIGINALDOC
   */
  def headerText: StringProperty = delegate.headerTextProperty
  def headerText_=(value: String): Unit = {
    headerText() = value
  }
  def headerText_=(value: Option[String]): Unit = {
    headerText() = value.orNull
  }

  /**
   * The dialog graphic, presented either in the header, if one is showing, or
   * to the left of the `content`.
   *
   * @see $URL0#headerTextProperty  $ORIGINALDOC
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty
  def graphic_=(value: Node): Unit = {
    ObjectProperty.fillProperty[jfxs.Node](this.graphic, value)
  }

  /**
   * A property representing what has been returned from the dialog. A result
   * is generated through the `resultConverter`,
   * which is intended to convert from the `ButtonType` that the user
   * clicked on into a value of type R.
   *
   * @see $URL0#resultProperty  $ORIGINALDOC
   */
  def result: ObjectProperty[R] = delegate.resultProperty
  def result_=(value: R): Unit = {
    if (value == null) {
      delegate.setResult(null.asInstanceOf[R])
    } else {
      result() = value
    }
  }

  /**
   * API to convert the [[scalafx.scene.control.ButtonType]] that the user clicked on into a
   * result that can be returned via the [[scalafx.scene.control.Dialog.result]]
   * property. This is necessary as [[scalafx.scene.control.ButtonType]] represents the visual
   * button within the dialog, and do not know how to map themselves to a valid
   * result - that is a requirement of the dialog implementation by making use
   * of the result converter. In some cases, the result type of a Dialog
   * subclass is ButtonType (which means that the result converter can be null),
   * but in some cases (where the result type, R, is not ButtonType or Void),
   * this callback must be specified.
   */
  def resultConverter: ObjectProperty[ButtonType => R] =
    ObjectProperty((bt: ButtonType) => delegate.resultConverterProperty.getValue.call(bt))
  def resultConverter_=(f: ButtonType => R): Unit = {
    delegate.setResultConverter(new jfxu.Callback[jfxsc.ButtonType, R] {
      override def call(param: jfxsc.ButtonType): R = f(param)
    })
  }

  /**
   * Represents whether the dialog is currently showing.
   */
  def showing: ReadOnlyBooleanProperty = delegate.showingProperty()

  /**
   * Represents whether the dialog is resizable.
   */
  def resizable: BooleanProperty = delegate.resizableProperty
  def resizable_=(v: Boolean) {
    resizable() = v
  }

  /**
   * Return the title of the dialog.
   */
  def title: StringProperty = delegate.titleProperty
  def title_=(v: String) {
    title() = v
  }

  /**
   * Property representing the height of the dialog.
   */
  def height: ReadOnlyDoubleProperty = delegate.heightProperty()
  def height_=(h: Double) {
    delegate.setHeight(h)
  }

  /**
   * Property representing the width of the dialog.
   */
  def width: ReadOnlyDoubleProperty = delegate.widthProperty()
  def width_=(w: Double) {
    delegate.setWidth(w)
  }

  /**
   * The horizontal location of this [[scalafx.scene.control.Dialog]]. Changing this attribute
   * will move the [[scalafx.scene.control.Dialog]] horizontally.
   */
  def x: ReadOnlyDoubleProperty = delegate.xProperty()
  def x_=(v: Double): Unit = {
    delegate.setX(v)
  }

  /**
   * The vertical location of this [[scalafx.scene.control.Dialog]]. Changing this attribute
   * will move the [[scalafx.scene.control.Dialog]] vertically.
   */
  def y: ReadOnlyDoubleProperty = delegate.yProperty()
  def y_=(v: Double) {
    delegate.setY(v)
  }


  /**
   * Called just prior to the Dialog being shown.
   */
  def onShowing = delegate.onShowingProperty
  def onShowing_=(v: jfxe.EventHandler[jfxsc.DialogEvent]) {
    onShowing() = v
  }

  /**
   * Called just after the Dialog is shown.
   */
  def onShown = delegate.onShownProperty
  def onShown_=(v: jfxe.EventHandler[jfxsc.DialogEvent]) {
    onShown() = v
  }

  /**
   * Called just prior to the Dialog being hidden.
   */
  def onHiding = delegate.onHidingProperty
  def onHiding_=(v: jfxe.EventHandler[jfxsc.DialogEvent]) {
    onHiding() = v
  }

  /**
   * Called just after the Dialog has been hidden.
   * When the [[scalafx.scene.control.Dialog]] is hidden, this event handler is invoked allowing
   * the developer to clean up resources or perform other tasks when the
   * [[scalafx.scene.control.Dialog]] is closed.
   */
  def onHidden = delegate.onHiddenProperty
  def onHidden_=(v: jfxe.EventHandler[jfxsc.DialogEvent]) {
    onHidden() = v
  }

  def onCloseRequest = delegate.onCloseRequestProperty
  def onCloseRequest_=(v: jfxe.EventHandler[jfxsc.DialogEvent]) {
    onCloseRequest() = v
  }

}