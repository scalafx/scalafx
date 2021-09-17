/*
 * Copyright (c) 2011-2021, ScalaFX Project
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
import javafx.{util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, ObjectProperty, ReadOnlyObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

import java.time.LocalDate
import java.time.chrono.Chronology
import scala.language.implicitConversions

object DatePicker {
  implicit def sfxDatePicker2jfx(v: DatePicker): jfxsc.DatePicker = if (v != null) v.delegate else null
}

/**
 * The DatePicker control allows the user to enter a date as text or to select a date from a calendar popup.
 * The calendar is based on either the standard ISO-8601 chronology or any of the other chronology classes defined in the
 * `java.time.chrono` package.
 *
 * Wraps [[https://openjfx.io/javadoc/16/javafx.controls/javafx/scene/control/DatePicker.html]].
 */
class DatePicker(override val delegate: jfxsc.DatePicker = new jfxsc.DatePicker())
  extends ComboBoxBase[LocalDate](delegate) with SFXDelegate[jfxsc.DatePicker] {


  /**
   * Creates a `DatePicker` instance and sets the value to the given date.
   */
  def this(localDate: LocalDate) = this(new jfxsc.DatePicker(localDate))

  /**
   * The calendar system used for parsing, displaying, and choosing dates in the DatePicker control.
   */
  def chronology: ObjectProperty[Chronology] = delegate.chronologyProperty

  def chronology_=(value: Chronology): Unit = {
    chronology() = value
  }

  /**
   * Converts the input text to an object of type `LocalDate` and vice versa.
   */
  def converter: ObjectProperty[jfxu.StringConverter[LocalDate]] = delegate.converterProperty

  def converter_=(value: StringConverter[LocalDate]): Unit = {
    converter() = value
  }

  /**
   * A custom cell factory can be provided to customize individual day cells in the `DatePicker` popup.
   */
  def dayCellFactory: ObjectProperty[jfxu.Callback[jfxsc.DatePicker, jfxsc.DateCell]] =
    delegate.dayCellFactoryProperty
  def dayCellFactory_=(callback: jfxu.Callback[jfxsc.DatePicker, jfxsc.DateCell]): Unit = {
    delegate.dayCellFactoryProperty().setValue(callback)
  }
  @deprecated(message = "" +
    "This method does not allow for correct handling of empty cells leading to possible rendering artifacts. " +
    "See explanation in [[https://github.com/scalafx/scalafx/issues/256 ScalaFX Issue #256]]. " +
    "Use the new `dayCellFactory` assignment method: `dayCellFactory = (cell, value) => {...}` that automatically " +
    "handles empty cells.",
    since = "16.0.0-R25")
  def dayCellFactory_=(value: DatePicker => DateCell): Unit = {
    dayCellFactory() = new jfxu.Callback[jfxsc.DatePicker, jfxsc.DateCell] {
      override def call(result: jfxsc.DatePicker): jfxsc.DateCell = {
        value(result)
      }
    }
  }

  /**
   * A custom cell factory can be provided to customize individual day cells in the `DatePicker` popup.
   * This is a helper method for easy creation of day cell factories.
   * A day cell is automatically created, and it handles rendering of default cells.
   * The user is only responsible for providing an operation `op` that customizes individual cells.
   *
   * The operation `op` provides as input the already created custom `cell` and `value` of that cell.
   * {{{
   *   val checkInDatePicker = new DatePicker() {
   *     value = LocalDate.now()
   *   }
   *   val checkOutDatePicker = new DatePicker() {
   *     value = checkInDatePicker.value().plusDays(1)
   *   }
   *
   *   // Custom rendering of day cells.
   *   // Days before check-in data will be disabled and marked in pink.
   *   checkOutDatePicker.dayCellFactory = (cell, date) => {
   *     if (date.isBefore(checkInDatePicker.value().plusDays(1))) {
   *       cell.disable = true
   *       cell.style = "-fx-background-color: #ffc0cb;"
   *     }
   *     val p = ChronoUnit.DAYS.between(checkInDatePicker.getValue, date)
   *     cell.tooltip = Tooltip("You're about to stay for " + p + " days")
   *   }
   * }}}
   *
   * @param op operation that modifies given cell for a given date.
   */
  def dayCellFactory_=(op: (DateCell, LocalDate) => Unit): Unit = {
    val callback =
      Option(op)
        .map { op =>
          new jfxu.Callback[jfxsc.DatePicker, jfxsc.DateCell] {
            override def call(v: jfxsc.DatePicker): jfxsc.DateCell = {
              new jfxsc.DateCell {
                val sfxThis = new DateCell(this)
                override def updateItem(item: LocalDate, empty: Boolean): Unit = {
                  super.updateItem(item, empty)
                  if (empty || item == null) {
                    setText(null)
                    setGraphic(null)
                  } else {
                    op(sfxThis, item)
                  }
                }
              }
            }
          }
        }
        .orNull

    delegate.dayCellFactoryProperty.setValue(callback)
  }


  /**
   * The editor for the `DatePicker`.
   */
  def editor: ReadOnlyObjectProperty[jfxsc.TextField] = delegate.editorProperty

  /**
   * Whether the `DatePicker` popup should display a column showing week numbers.
   */
  def showWeekNumbers: BooleanProperty = delegate.showWeekNumbersProperty

  def showWeekNumbers_=(value: Boolean): Unit = {
    showWeekNumbers() = value
  }
}