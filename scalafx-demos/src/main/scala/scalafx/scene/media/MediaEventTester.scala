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

package scalafx.scene.media

import scala.language.postfixOps
import scalafx.Includes._
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.application.{JFXApp3, Platform}
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.layout.StackPane

/** Plays a video an displays text related at set video duration. */
object MediaEventTester extends JFXApp3 {
  override def start(): Unit = {
    val markerText = new Label {
      alignmentInParent = Pos.TopCenter
      style = "-fx-padding: 20; -fx-font-size: 24pt; -fx-text-fill: white;"
    }
    val url   = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv"
    val media = new Media(url)
    media.markers ++= Map(
      "Clouds"    -> 100.ms,
      "Planes"    -> 3000.ms,
      "Parachute" -> 8000.ms,
      "Car"       -> 13000.ms,
      "..."       -> 15000.ms
    )
    val mediaPlayer = new MediaPlayer(media)
    mediaPlayer.onMarker = (event: MediaMarkerEvent) =>
      Platform.runLater {
        markerText.text = event.marker.getKey
      }
    val mediaView = new MediaView(mediaPlayer) {
      onError = (event: MediaErrorEvent) => println(s"Media view error: $event")
    }
    val root = new StackPane {
      children ++= Seq(mediaView, markerText)
      style = "-fx-background-color: black;"
    }
    stage = new PrimaryStage {
      title = "MediaEventTester"
      scene = new Scene(root, 540, 320)
    }
    mediaPlayer.play()
  }
}
