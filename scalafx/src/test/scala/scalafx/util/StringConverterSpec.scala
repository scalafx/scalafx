/**
 *
 */
package scalafx.util

import javafx.{ util => jfxu }
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.matchers._
import scalafx.Includes._
import scalafx.util.StringConverter._
import java.{ text => jt }
import java.util._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.util.Calendar
import java.text.ParseException
import java.text.DecimalFormatSymbols

/**
 * StringConverter Spec tests.
 *
 */
@RunWith(classOf[JUnitRunner])
class StringConverterSpec extends FlatSpec {

  // Just For Fun
  object TFBooleanConverter extends StringConverter[Boolean] {
    def toString(b: Boolean) = if (b) "t" else "f"

    def fromString(s: String) = s match {
      case "t" => true
      case "f" => false
      case _   => throw new java.text.ParseException("'%s' can not be converted to a boolean".format(s), 0)
    }
  }

  // Getting decimal and group separator from current Locale 
  private val symbols = DecimalFormatSymbols.getInstance()
  val decimalSeparator = symbols.getDecimalSeparator
  val groupSeparator = symbols.getGroupingSeparator

  // HELPER METHODS - BEGIN

  private def testIrregularStringConvertion[T](converter: StringConverter[T], isNumberFormat: Boolean) {
    it should "not convert a Irregular String" in {
      if (isNumberFormat) {
        intercept[NumberFormatException] {
          converter.fromString("ABCSDE")
        }
      } else {
        intercept[ParseException] {
          converter.fromString("ABCSDE")
        }
      }
    }
  }

  private def testNullStringConvertion[T](converter: StringConverter[T], isNumberFormat: Boolean) {
    it should "not convert a Null String" in {
      if (isNumberFormat) {
        intercept[NumberFormatException] {
          converter.fromString(null)
        }
      } else {
        intercept[NullPointerException] {
          converter.fromString(null)
        }
      }
    }
  }

  private def testConversion[T](converter: StringConverter[T], string: String, value: T, converterName: String, typeName: String) {
    converterName should "convert '%s' in a %s and vice-versa".format(string, typeName) in {
      val numericValue = converter.fromString(string)
      numericValue should equal(value)
      converter.toString(numericValue) should equal(string)
    }
  }

  // HELPER METHODS - END

  // TESTING METHODS - BEGIN

  private def testImplicitConversion() {
    "A Scala StringConverter" should "be converteble to a JavaFX StringConverter" in {
      val sc = StringConverter[Char](s => s.charAt(0), ch => ch.toString)
      val jc: jfxu.StringConverter[Char] = sc

      jc.isInstanceOf[jfxu.StringConverter[_]] should be(true)
    }

    "A JavaFX StringConverter" should "be converteble to a Scala StringConverter" in {
      val jc = new jfxu.StringConverter[Char] {
        def toString(c: Char) = c.toString
        def fromString(s: String) = s.charAt(0)
      }
      val sc: StringConverter[Char] = jc

      sc.isInstanceOf[StringConverter[_]] should be(true)
    }
  }

  // TESTING METHODS - END

  // TESTS EXECUTION

  testImplicitConversion()

}