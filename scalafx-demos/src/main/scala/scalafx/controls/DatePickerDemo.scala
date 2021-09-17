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

package scalafx.controls

import scalafx.application.JFXApp3
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{DatePicker, Label, Tooltip}
import scalafx.scene.layout.{GridPane, VBox}
import scalafx.scene.paint.Color

import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.Locale
import scala.language.implicitConversions

/**
 * Based on DatePickerSample from [[https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/date-picker.htm]]
 *
 * Illustrates use of `dayCellFactory`
 */
object DatePickerDemo extends JFXApp3 {
  def start(): Unit = {

    Locale.setDefault(Locale.US)

    val checkInDatePicker = new DatePicker() {
      value = LocalDate.now()
    }
    val checkOutDatePicker = new DatePicker() {
      value = checkInDatePicker.value().plusDays(1)
    }

    // dayCellFactory
    checkOutDatePicker.dayCellFactory = (cell, date) => {
      if (date.isBefore(checkInDatePicker.value().plusDays(1))) {
        cell.disable = true
        cell.style = "-fx-background-color: #ffc0cb;"
      }
      val p = ChronoUnit.DAYS.between(checkInDatePicker.getValue, date)
      cell.tooltip = Tooltip("You're about to stay for " + p + " days")
    }

    val gridPane = new GridPane() {
      hgap = 10
      vgap = 10
    }
    gridPane.add(Label("Check-In Date:"), 0, 0)
    gridPane.add(checkInDatePicker, 0, 1)
    gridPane.add(Label("Check-Out Date:"), 0, 2)
    gridPane.add(checkOutDatePicker, 0, 3)

    stage = new JFXApp3.PrimaryStage {
      scene = new Scene(400, 400) {
        title = "Date Picker Demo"
        root = new VBox(20) {
          padding = Insets(10)
          children = Seq(
            gridPane,
            new Label {
              maxWidth = 380
              wrapText = true
              text = "Select calendar for 'Check-Out Date' to see custom rendering of day cells."
              textFill = Color.Gray
            }
          )
        }
      }
    }
  }
}
