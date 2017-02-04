package issues.issue262

import javafx.util.converter.IntegerStringConverter

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import org.scalatest.junit.JUnitRunner

import scalafx.Includes._
import scalafx.scene.control.cell.TextFieldListCell
import scalafx.testutil.RunOnApplicationThread

@RunWith(classOf[JUnitRunner])
class Issue262Spec extends FlatSpec with RunOnApplicationThread {
  "TextFieldListCell" should "support changing of StringConverter" in {
    val cell = new TextFieldListCell[Integer]
    cell.converter = new IntegerStringConverter
    cell.converter.value.fromString("123") should be(123)
  }
}
