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
package scalafx.graphics3d

// JavaFX system properties: -Dprism.printStats=true -Dprism.verbose=true

import scalafx.Includes.*
import scalafx.animation.Timeline
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.*
import scalafx.scene.media.{Media, MediaPlayer, MediaView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.{Font, Text}
import scalafx.scene.transform.Rotate

import java.io.File
import scala.language.postfixOps

/**
 * The type VideoCubeDemo a demonstration of the JavaOne 2011 key note with {@link Media}, {@link MediaView}, and {@link
 * MediaPlayer} for six videos that are displayed as a 3D graphic cube.
 *
 * @author
 *   Peter Pilgrim (peter)
 */
object VideoCubeDemo extends JFXApp3 {
  override def start(): Unit = {
    var animation: Timeline = null
    var root                = new Group
    stage = new PrimaryStage {
      scene = new Scene(root, 800, 600, true, SceneAntialiasing.Balanced) { fill = Color.Black }
      resizable = false
      title = "Graphics 3D Video Cube Demo in ScalaFX"
    }
    val folderSysProperty = "scalafx.graphics3d.VideoCubeDemo.folder"
    val folderOption      = Option[String](System.getProperty(folderSysProperty))
    val folder = folderOption match {
      case Some(folderName) =>
        val file = new File(folderName)
        if (file.exists() && file.isDirectory) file
        else
          throw new IllegalArgumentException(
            "System property `" + folderSysProperty + " = " + folderName + "` " + "has to point to an existing directory."
          )
      case None =>
        throw new IllegalArgumentException("System property `" + folderSysProperty + "` is not defined.")
    }
    val vidFiles = List(
      "FLIGHT Trailer 2012 Denzel Washington Movie - Official [HD].mp4",
      "LOOPER Trailer 2012 Bruce Willis Movie - Official [HD].mp4",
      "PROMETHEUS Trailer 2 - 2012 Movie - Official [HD].mp4",
      "RESIDENT EVIL 5 Retribution Trailer 2 - 2012 Movie - Official.mp4",
      "TED Movie Trailer 2012 - Official [HD].mp4",
      "THE HOBBIT Trailer - 2012 Movie - Official [HD].mp4"
    )
    val mediaPlayers = vidFiles.map { filename =>
      val file  = new File(folder, filename)
      val media = new Media(file.toURI.toURL.toExternalForm)
      new MediaPlayer(media) {
        volume = 0.5d
        cycleCount = MediaPlayer.Indefinite
      }
    }
    def create3dContent(): Node = {
      val c1 = new VideoCube(mediaPlayers, 300)
      c1.rx.angle = 45
      c1.ry.angle = 45
      c1.translateX = 200
      c1.translateY = -200
      animation = new Timeline {
        cycleCount = Timeline.Indefinite
        keyFrames = Seq(
          at(0.s) {
            c1.ry.angle -> 0d
            c1.rx.angle -> 0d
            c1.rz.angle -> 0d
          },
          at(4.s) {
            c1.rx.angle -> 360d
            c1.ry.angle -> 520d
          },
          at(7.s) {
            c1.rx.angle -> 360d
            c1.ry.angle -> 520d
          },
          at(10.s) {
            c1.rz.angle -> 1080d
          }
        )
      }
      new Group(c1)
    }
    def play(): Unit = {
      animation.play()
      for (mp <- mediaPlayers) {
        mp.play()
      }
    }
    def stop(): Unit = {
      animation.pause()
      for (mp <- mediaPlayers) {
        mp.stop()
      }
    }
    val cubeSystem = create3dContent()
    cubeSystem.translateX = 800 / 2
    cubeSystem.translateY = 600 / 2
    stage.getScene.setCamera(new PerspectiveCamera())
    val lowX  = -75
    val lowY  = -75
    val highX = 900
    val highY = 700
    val starryBackground = new Group {
      val stars: Seq[Rectangle] = (1 to 500).map(_ =>
        new Rectangle {
          x = lowX + scala.math.random() * (highX - lowX)
          y = lowY + scala.math.random() * (highY - lowY)
          val s = 1 + scala.math.random() * 3
          width = s
          height = s
          fill = Color.White
        }
      )
      children = stars
      translateZ = 100.0d
    }
    root.children.addAll(starryBackground, cubeSystem)
    play()
  }
}

class VideoCube(val mediaPlayers: List[MediaPlayer], size: Double) extends Group {
  val rx = new Rotate(0, Rotate.XAxis)
  val ry = new Rotate(0, Rotate.YAxis)
  val rz = new Rotate(0, Rotate.ZAxis)

  transforms = Seq(rz, ry, rx)

  children = Seq(
    new MediaViewCubeFace(mediaPlayers(0)) {
      // back face
      fitWidth = size
      fitHeight = size
      translateX = -0.5 * size
      translateY = -0.5 * size
      translateZ = 0.5 * size
      //      preserveRatio = false
      text = "0"
    },
    new MediaViewCubeFace(mediaPlayers(1), 0.01) {
      // bottom face
      fitWidth = size
      fitHeight = size
      translateX = -0.5 * size
      translateY = 0
      rotationAxis = Rotate.XAxis
      rotate = 90
      //      preserveRatio = false
      text = "1"
    },
    new MediaViewCubeFace(mediaPlayers(2), 0.01) {
      // right face
      fitWidth = size
      fitHeight = size
      translateX = -1 * size
      translateY = -0.5 * size
      rotationAxis = Rotate.YAxis
      rotate = 90
      //      preserveRatio = false
      text = "2"
    },
    new MediaViewCubeFace(mediaPlayers(3)) {
      // left face
      fitWidth = size
      fitHeight = size
      translateX = 0
      translateY = -0.5 * size
      rotationAxis = Rotate.YAxis
      rotate = 90
      text = "3"
    },
    new MediaViewCubeFace(mediaPlayers(4)) {
      // top face
      fitWidth = size
      fitHeight = size
      translateX = -0.5 * size
      translateY = -1 * size
      rotationAxis = Rotate.XAxis
      rotate = 90
      text = "4"
    },
    new MediaViewCubeFace(mediaPlayers(5), 0.01) {
      // top face
      fitWidth = size
      fitHeight = size
      translateX = -0.5 * size
      translateY = -0.5 * size
      translateZ = -0.5 * size
      text = "5"
    }
  )

  /**
   * This is a custom node that associates a {@link MediaView} with a backing {@link Rectangle} that represents a cube
   * face
   * @param mediaPlayer
   *   the media player
   * @param size
   *   the square size of the cube face
   * @param color
   *   the colour of the cube face
   * @param shade
   *   the derived colour
   */
  class MediaViewCubeFace(
    val mediaPlayer: MediaPlayer,
    size: Double,
    offset: Double = -0.01,
    color: Color = Color.LightBlue,
    shade: Double = 1.0
  ) extends Group {

    def this(mediaPlayer: MediaPlayer, offset: Double) = this(mediaPlayer, 0.0, offset)

    def this(mediaPlayer: MediaPlayer) = this(mediaPlayer, 0.0)

    val debugText = new Text {
      font = new Font("Verdana", 36.0)
      fill = Color.Orange
      layoutX = size / 4
      layoutY = size / 4
    }

    val mediaView = new MediaView(mediaPlayer)

    val backRect = new Rectangle {
      x = 0
      y = 0
      translateZ = offset
      width = size
      height = size
      fill = color.deriveColor(0.0, 1.0, 1 - 0.5 * shade, 1.0)
      depthTest = DepthTest.Inherit
      // JavaFX Rendering on 3D with planar surfaces and MediaView will improve
      // opacity = 0.0
    }

    children = Seq(backRect, mediaView, debugText)

    def fitHeight = mediaView.fitHeightProperty

    def fitHeight_=(v: Double): Unit = {
      fitHeight() = v
      backRect.height = v
      mediaView.layoutY = v / 4
      debugText.layoutY = v / 4
    }

    /**
     * Determines the width of the bounding box within which the source media is resized as necessary to fit.
     */
    def fitWidth = mediaView.fitWidthProperty

    def fitWidth_=(v: Double): Unit = {
      fitWidth() = v
      backRect.width = v
      debugText.layoutX = v / 4
    }

    def preserveRatio = mediaView.preserveRatioProperty

    def preserveRatio_=(v: Boolean): Unit = {
      preserveRatio() = v
    }

    def smooth = mediaView.smoothProperty

    def smooth_=(v: Boolean): Unit = {
      smooth() = v
    }

    def text = debugText.text

    def text_=(v: String): Unit = {
      debugText.text = v
    }

  }

}
