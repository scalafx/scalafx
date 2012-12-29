package scalafx.graphics3d

// JavaFX system properties: -Dprism.printStats=true -Dprism.verbose=true

import scalafx.application.JFXApp
import scalafx.scene.paint.Color
import scalafx.scene.{Node, PerspectiveCamera, Scene, Group}
import scalafx.scene.transform.{Translate, Rotate}
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.{Text,Font}
import scalafx.scene.media.{Media,MediaView,MediaPlayer}
import scalafx.animation.Timeline
import scalafx.stage.Stage
import scalafx.Includes._
import java.io.File
import javafx.scene.DepthTest

/**
 * The type VideoCubeDemo a demonstration of the JavaOne 2011 key note with
 * {@link Media}, {@link MediaView}, and {@link MediaPlayer} for
 * six videos that are displayed as a 3D graphic cube.
 *
 * @author Peter Pilgrim (peter)
 */
object VideoCubeDemo extends JFXApp {

  var animation: Timeline = _
  var root = new Group
  stage = new Stage {
    scene = new Scene( root, 800, 600, true )  {
      fill = Color.BLACK
    }
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
  val folder = if (System.getProperty("os.name").toLowerCase().contains("windows")) {
      new File( "C:\\Users\\peter\\Videos\\Movie-Trailers-2012" )
    }
    else {
      new File( "/Users/peterpilgrim/Movies/Movie-Trailers-2012" )
    }
  // TODO: +PP+ Dec 2012 - This all should be defined by a preferences (property file) in user home

  // You need your video files ;-) Cannot redistribute MOVIE FILES!!!
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

  val cubeSystem = create3dContent()
  cubeSystem.translateX = 800 / 2
  cubeSystem.translateY = 600 / 2

  //  cubeSystem.getTransforms.addAll( new Translate(800 / 2, 600 / 2), new Rotate(180, Rotate.XAxis) )

  stage.getScene.setCamera( new PerspectiveCamera() )

  val lowX = -75; val lowY = -75; val highX = 900; val highY = 700
  val starryBackground = new Group {
    val stars = (1 to 500).map( x => new Rectangle {
      x =  lowX + scala.math.random * (highX - lowX )
      y =  lowY + scala.math.random * (highY - lowY )
      //      printf("x=%5.1f, y=%5.1f\n", x.get(), y.get() )
      val s = 1 + scala.math.random * 3
      width = s
      height = s
      fill = Color.WHITE
    } )
    //    printf("stars=%s\n", stars)
    children = stars
    translateZ = 100.0;
  }

  root.children.addAll( starryBackground, cubeSystem )

  def create3dContent():Node = {
    val c1 = new VideoCube(mediaPlayers, 300);
    c1.rx.angle = 45;
    c1.ry.angle = 45;
    c1.translateX = 200
    c1.translateY = -200

    animation = new Timeline {
      cycleCount = Timeline.INDEFINITE
      keyFrames = Seq(
        at (0 s) { c1.ry.angle -> 0d ; c1.rx.angle -> 0d; c1.rz.angle -> 0d },
        at (4 s) { c1.rx.angle -> 360d ; c1.ry.angle -> 520d; },
//        at (4 s) { c1.rz.angle -> 0d ; c1.ry.angle -> 720d; }
        at (7 s) { c1.rx.angle -> 360d ; c1.ry.angle -> 520d },
        at (10 s) { c1.rz.angle -> 1080d }
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
    new MediaViewCubeFace( mediaPlayers(0) ) { // back face
      fitWidth = size; fitHeight = size
      translateX = -0.5*size
      translateY = -0.5*size
      translateZ = 0.5*size
//      preserveRatio = false
      text = "0"
    },
    new MediaViewCubeFace( mediaPlayers(1), 0.01  ) { // bottom face
      fitWidth = size ; fitHeight = size
      translateX = -0.5*size
      translateY = 0
      rotationAxis = Rotate.XAxis
      rotate = 90
//      preserveRatio = false
      text = "1"
    },
    new MediaViewCubeFace( mediaPlayers(2), 0.01 ) { // right face
      fitWidth = size ; fitHeight = size
      translateX = -1*size
      translateY = -0.5*size
      rotationAxis = Rotate.YAxis
      rotate = 90
//      preserveRatio = false
      text = "2"
    },
    new MediaViewCubeFace( mediaPlayers(3) ) { // left face
      fitWidth = size; fitHeight = size
      translateX = 0
      translateY = -0.5*size
      rotationAxis = Rotate.YAxis
      rotate = 90
      text = "3"
    },
    new MediaViewCubeFace( mediaPlayers(4) ) { // top face
      fitWidth = size; fitHeight = size
      translateX = -0.5*size
      translateY = -1*size
      rotationAxis = Rotate.XAxis
      rotate = 90
      text = "4"
    },
    new MediaViewCubeFace( mediaPlayers(5), 0.01 ) { // top face
      fitWidth = size; fitHeight = size
      translateX = -0.5*size
      translateY = -0.5*size
      translateZ = -0.5*size
      text = "5"
    }
  )

  /**
   * This is a custom node that associates a {@link MediaView} with a backing {@link Rectangle}
   * that represents a cube face
   * @param mediaPlayer the media player
   * @param size the square size of the cube face
   * @param color the colour of the cube face
   * @param shade the derived colour
   */
  class MediaViewCubeFace( val mediaPlayer: MediaPlayer, size: Double, offset: Double = -0.01,
                           color: Color = Color.LIGHTBLUE, shade: Double = 1.0 ) extends Group {

    def this( mediaPlayer: MediaPlayer, offset: Double ) = this( mediaPlayer, 0.0, offset )

    def this( mediaPlayer: MediaPlayer ) = this( mediaPlayer, 0.0 )

    val debugText = new Text {
      font = new Font("Verdana", 36.0 )
      fill = Color.ORANGE
      layoutX = size / 4
      layoutY = size / 4
    }

    val mediaView = new MediaView( mediaPlayer )

    val backRect = new Rectangle {
      x = 0
      y = 0
      translateZ = offset
      width = size
      height = size
      fill = color.deriveColor(0.0, 1.0, (1 - 0.5*shade), 1.0)
      depthTest = DepthTest.INHERIT
      // JavaFX Rendering on 3D with planar surfaces and mediaview will improve
      // opacity = 0.0
    }

    children = Seq( backRect, mediaView, debugText )

    def fitHeight = mediaView.fitHeightProperty
    def fitHeight_=(v: Double) {
      fitHeight() = v
      backRect.height = v
      mediaView.layoutY = v / 4
      debugText.layoutY = v / 4
    }

    /**
     * Determines the width of the bounding box within which the source media is resized as
     * necessary to fit.
     */
    def fitWidth = mediaView.fitWidthProperty
    def fitWidth_=(v: Double) {
      fitWidth() = v
      backRect.width = v
      debugText.layoutX = v / 4
    }

    def preserveRatio = mediaView.preserveRatioProperty
    def preserveRatio_=(v: Boolean) {
      preserveRatio() = v
    }

    def smooth = mediaView.smoothProperty
    def smooth_=(v: Boolean) {
      smooth() = v
    }

    def text = debugText.text
    def text_=(v: String) {
      debugText.text = v
    }

  }
}



// http://code.google.com/p/scalafx/source/browse/
