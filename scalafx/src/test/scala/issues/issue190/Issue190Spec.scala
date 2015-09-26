package issues.issue190

import java.io.File

import scalafx.scene.input.{DataFormat, ClipboardContent, Clipboard}

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

/** Issue 190: Convenience methods not working for clipboard */
@RunWith(classOf[JUnitRunner])
class Issue190Spec extends FlatSpec {
  "ClipboardContent" should "be assignable to the content of the clipboard" in {
    Clipboard.systemClipboard.content = new ClipboardContent()
  }

  "A Map" should "be assignable to the content of the clipboard" in {
    val files = List(new File("Test"))
    Clipboard.systemClipboard.content = Map(new DataFormat("Files") -> files)
  }
}
