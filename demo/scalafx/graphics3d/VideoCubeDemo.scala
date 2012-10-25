package scalafx.graphics3d

import scalafx.application.JFXApp
import scalafx.scene.paint.Color
import scalafx.scene.{Node, PerspectiveCamera, Scene, Group}
import scalafx.scene.transform.{Translate, Rotate}
import scalafx.scene.shape.Rectangle
import scalafx.scene.media.{Media,MediaView,MediaPlayer}
import scalafx.animation.Timeline
import scalafx.stage.Stage
import scalafx.Includes._
import java.io.File

/**
 * The type VideoCubeDemo
 * 
 * @author Peter Pilgrim (peter)
 */
object VideoCubeDemo extends JFXApp {

  var animation: Timeline = _
  var root = new Group
  stage = new Stage {
    scene = new Scene( root, 800, 600, true )
    resizable = false
    title = "Graphics 3D Video Cube Demo in ScalaFX"
  }


  // Obviously, you need put videos files into an accessible on your local machine ;-)
  // Downloading from the net
  // COPYRIGHT: Please respect the copyright and DO NOT UPLOAD MOVIE CONTENT
  // to any server, PUBLIC, PROTECTED and PRIVATE without the studio consent ;-))
  // PLEASE DO NOT SHOW THIS PUBLIC LIKE IN A BIG CONFERENCE with consent either
  // This is just for learning and demonstration purposes.
  // Of course, it will only work my machine!!!!!!!!!!!!!!!!!!!!!! Until you edit the folder and files!
  val folder = new File( "C:\\Users\\peter\\Videos\\Movie-Trailers-2012" )

  // You need your video files ;-) Cannot redistribute MOVIE FILES!!!!!!!!!!!!
  // Substitute, for example, with your own family and vacation pictures
  val vidFiles = List(
    "FLIGHT Trailer 2012 Denzel Washington Movie - Official [HD].mp4",
    "LOOPER Trailer 2012 Bruce Willis Movie - Official [HD].mp4",
    "PROMETHEUS Trailer 2 - 2012 Movie - Official [HD].mp4",
    "RESIDENT EVIL 5 Retribution Trailer 2 - 2012 Movie - Official.mp4",
    "TED Movie Trailer 2012 - Official [HD].mp4",
    "THE HOBBIT Trailer - 2012 Movie - Official [HD].mp4" )

  val mediaPlayers = vidFiles.map {
    filename =>  {
        val file = new File( folder, filename)
        val media = new Media( file.toURI().toURL().toExternalForm )
        val mediaPlayer = new MediaPlayer( media )
        mediaPlayer.volume = 0.5
        mediaPlayer.cycleCount = MediaPlayer.Indefinite
        mediaPlayer
      }
  }

  root.getTransforms.addAll( new Translate(400 / 2, 150 / 2), new Rotate(180, Rotate.XAxis) )

  stage.getScene.setCamera( new PerspectiveCamera() )

  root.children.add(create3dContent())

  def create3dContent():Node = {
    val c1 = new VideoCube(mediaPlayers, 300);
    c1.rx.setAngle(45);
    c1.ry.setAngle(45);
    c1.translateX = 200
    c1.translateY = -200

    animation = new Timeline {
      cycleCount = Timeline.INDEFINITE
      keyFrames = Seq(
        at (0 s) { c1.ry.angle -> 0d },
        at (1 s) { c1.ry.angle -> 360d },
        at (0 s) { c1.rx.angle -> 0d },
        at (3 s) { c1.rx.angle -> 360d },
        at (0 s) { c1.rz.angle -> 0d },
        at (5 s) { c1.rz.angle -> 360d }
      )
    }

    return new Group(c1);
  }

  def play(): Unit = {
    animation.play()
    for ( mp <- mediaPlayers ) { mp.play() }
  }

  def stop(): Unit = {
    animation.pause()
    for ( mp <- mediaPlayers ) { mp.stop() }
  }

  play()
}


class VideoCube( val mediaPlayers: List[MediaPlayer], size: Double ) extends Group {
  val rx = new Rotate(0,Rotate.XAxis)
  val ry = new Rotate(0,Rotate.YAxis)
  val rz = new Rotate(0,Rotate.ZAxis)

  transforms = Seq(rz, ry, rx)

  children = Seq(
    new MediaView( mediaPlayers(0) ) { // back face
      fitWidth = size; fitHeight = size
      translateX = -0.5*size
      translateY = -0.5*size
      translateZ = 0.5*size
    },
    new MediaView( mediaPlayers(1) ) { // bottom face
      fitWidth = size ; fitHeight = size
      translateX = -0.5*size
      translateY = 0
      rotationAxis = Rotate.XAxis
      rotate = 90
    },
    new MediaView( mediaPlayers(2) ) { // right face
      fitWidth = size ; fitHeight = size
      translateX = -1*size
      translateY = -0.5*size
      rotationAxis = Rotate.YAxis
      rotate = 90
    },
    new MediaView( mediaPlayers(3) ) { // left face
      fitWidth = size; fitHeight = size
      translateX = 0
      translateY = -0.5*size
      rotationAxis = Rotate.YAxis
      rotate = 90
    },
    new MediaView( mediaPlayers(4) ) { // top face
      fitWidth = size; fitHeight = size
      translateX = -0.5*size
      translateY = -1*size
      rotationAxis = Rotate.XAxis
      rotate = 90
    },
    new MediaView( mediaPlayers(5) ) { // top face
      fitWidth = size; fitHeight = size
      translateX = -0.5*size
      translateY = -0.5*size
      translateZ = -0.5*size
    }
  )

}
