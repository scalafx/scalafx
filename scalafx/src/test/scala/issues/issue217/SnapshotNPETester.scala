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

package issues.issue217

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Rectangle2D
import scalafx.scene._
import scalafx.scene.image.WritableImage
import scalafx.scene.layout.BorderPane
import scalafx.scene.media.{Media, MediaPlayer, MediaView}

/**
  * Illustration ofd Issue 217. Originallu reported on ScalaFX Users
  * [[https://groups.google.com/forum/#!topic/scalafx-users/-NWgd40U_W0 snapshot problem after upgrade to scalafx 8.0.60-R9]]
  */
object SnapshotNPETester extends JFXApp {
  val movie     = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv"
  val mediaView = new MediaView(new MediaPlayer(new Media(movie)) {autoPlay.value = true})

  test(mediaView)

  stage = new PrimaryStage {
    width = 500
    height = 300
    scene = new Scene(0, 0, true, SceneAntialiasing.Balanced) {
      camera = new PerspectiveCamera
      root = new BorderPane {center = mediaView}
    }
  }

  def test(mediaNode: Node) = {
    val param = new SnapshotParameters {viewport = new Rectangle2D(0, 0, 200, 200)}
    // This call was resulting in NPE - Issue #217.
    val textureImage: WritableImage = mediaNode.snapshot(param, null)
  }

}
