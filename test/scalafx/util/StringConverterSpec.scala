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
 * @author rafael
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
  val decimalSeparator = symbols.getDecimalSeparator()
  val groupSeparator = symbols.getGroupingSeparator()

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

  private def testImplicitConversion {
    "A Scala StringConverter" should "be converteble to a JavaFX StringConverter" in {
      val sc = StringConverter[Char](s => s.charAt(0), ch => ch.toString)
      val jc: jfxu.StringConverter[Char] = sc

      jc.isInstanceOf[jfxu.StringConverter[Char]] should be(true)
    }

    "A JavaFX StringConverter" should "be converteble to a Scala StringConverter" in {
      val jc = new jfxu.StringConverter[Char] {
        def toString(c: Char) = c.toString
        def fromString(s: String) = s.charAt(0)
      }
      val sc: StringConverter[Char] = jc

      sc.isInstanceOf[StringConverter[Char]] should be(true)
    }
  }

  private def testDateFormatterConverter {
    var strDate = "10/01/2010"
    var pattern = "dd/MM/yyyy"
    val converter = dateFormatterConverter(pattern)

    "dateFormatterConverter" should "convert '%s' into a Date using format '%s' and vice-versa".format(strDate, pattern) in {
      val date = converter.fromString(strDate)
      val calendar = Calendar.getInstance()
      calendar.setTime(date)

      calendar.get(Calendar.YEAR) should equal(2010)
      calendar.get(Calendar.MONTH) should equal(Calendar.JANUARY)
      calendar.get(Calendar.DATE) should equal(10)
      calendar.get(Calendar.HOUR) should equal(0)
      calendar.get(Calendar.MINUTE) should equal(0)
      calendar.get(Calendar.SECOND) should equal(0)
      calendar.get(Calendar.MILLISECOND) should equal(0)

      converter.toString(date) should equal(strDate)
    }

    testIrregularStringConvertion(converter, false)
    testNullStringConvertion(converter, false)
  }

  private def testByteFormatConverter {
    testConversion(byteFormatterConverter("00"), "23", 23.asInstanceOf[Byte], "byteFormatConverter", "Byte")
    testIrregularStringConvertion(byteFormatterConverter("00"), false)
    testNullStringConvertion(byteFormatterConverter("00"), false)
  }

  private def testByteSimpleConverter {
    testConversion(byteSimpleConverter, "98", 98.asInstanceOf[Byte], "byteSimpleConverter", "Byte")
    testIrregularStringConvertion(intSimpleConverter, true)
    testNullStringConvertion(intSimpleConverter, true)
  }

  private def testIntFormatConverter {
    var strInt = "1" + groupSeparator + "234"

    testConversion(intFormatterConverter("0,000"), strInt, 1234, "intFormatterConverter", "Int")
    testIrregularStringConvertion(intFormatterConverter("0,000"), false)
    testNullStringConvertion(intFormatterConverter("0,000"), false)

    var intValue = 123456
    it should "convert %d in a Scientific notation and vice-versa".format(intValue) in {
      val intFormatConverter = intFormatterConverter("00.0E0")
      strInt = intFormatConverter.toString(intValue)
      strInt should equal("12" + decimalSeparator + "3E4")
      intFormatConverter.fromString(strInt) should equal(123000)
    }

  }

  private def testIntSimpleConverter {
    val str = "987654321"
    testConversion(intSimpleConverter, str, 987654321, "intSimpleConverter", "Int")
    testIrregularStringConvertion(intSimpleConverter, true)
    testNullStringConvertion(intSimpleConverter, true)
  }

  private def testLongFormatConverter {
    var str = "9" + groupSeparator + "876" + groupSeparator + "543" + groupSeparator + "210" + groupSeparator + "987"
    val value = 9876543210987L

    testConversion(longFormatterConverter("0,000"), str, value, "longFormatterConverter", "Long")
    testIrregularStringConvertion(longFormatterConverter("0,000"), false)
    testNullStringConvertion(longFormatterConverter("0,000"), false)

    it should "convert %d in a Scientific notation and vice-versa".format(value) in {
      val converter = longFormatterConverter("00.0E0")
      val string = converter.toString(value)
      string should equal("98" + decimalSeparator + "8E11")
      converter.fromString(string) should equal(9880000000000L)
    }
  }

  private def testLongSimpleConverter {
    val str = "9876543210987654"
    val value = 9876543210987654L

    testConversion(longSimpleConverter, str, value, "longSimpleConverter", "Int")
    testIrregularStringConvertion(longSimpleConverter, true)
    testNullStringConvertion(longSimpleConverter, true)
  }

  private def testFloatFormatConverter {
    var str = "5" + groupSeparator + "109" + decimalSeparator + "871"
    val value = 5109.871f

    testConversion(floatFormatterConverter("0,000.000"), str, value, "floatFormatterConverter", "Float")
    testIrregularStringConvertion(floatFormatterConverter("0.000"), false)
    testNullStringConvertion(floatFormatterConverter("0.000"), false)

    it should "convert %f in a Scientific notation and vice-versa".format(value) in {
      val converter = floatFormatterConverter("00.0E0")
      val string = converter.toString(value)
      string should equal("51" + decimalSeparator + "1E2")
      converter.fromString(string) should equal(5110f)
    }
  }

  private def testFLoatSimpleConverter {
    val str = "5109" + decimalSeparator + "871"
    val value = 5109.871f

    testConversion(floatSimpleConverter, str, value, "floatSimpleConverter", "Float")
    testIrregularStringConvertion(floatSimpleConverter, true)
    testNullStringConvertion(floatSimpleConverter, true)
  }

  private def testDoubleFormatConverter {
    var str = "763" + groupSeparator + "125" + groupSeparator + "109" + decimalSeparator + "871213"
    val value = 763125109.871213d

    testConversion(doubleFormatterConverter("0,000.000000"), str, value, "doubleFormatterConverter", "Double")
    testIrregularStringConvertion(doubleFormatterConverter("0.000"), false)
    testNullStringConvertion(doubleFormatterConverter("0.000"), false)

    it should "convert %f in a Scientific notation and vice-versa".format(value) in {
      val converter = doubleFormatterConverter("00.000E0")
      val string = converter.toString(value)
      string should equal("76" + decimalSeparator + "313E7")
      converter.fromString(string) should equal(763130000d)
    }
  }

  private def testDoubleSimpleConverter {
    val str = "7631251.789"
    val value = 7631251.789

    testConversion(doubleSimpleConverter, str, value, "doubleSimpleConverter", "Double")
    testIrregularStringConvertion(doubleSimpleConverter, true)
    testNullStringConvertion(doubleSimpleConverter, false)
  }

  private def testTFBooleanConverter {
    testConversion(TFBooleanConverter, "t", true, "TFBooleanConverter", "Boolean")
    testConversion(TFBooleanConverter, "f", false, "TFBooleanConverter", "Boolean")
    testIrregularStringConvertion(TFBooleanConverter, false)
    testNullStringConvertion(doubleSimpleConverter, false)
  }

  // TESTING METHODS - END

  // TESTS EXECUTION

  testImplicitConversion
  testDateFormatterConverter
  testByteFormatConverter
  testByteSimpleConverter
  testIntFormatConverter
  testIntSimpleConverter
  testLongFormatConverter
  testLongSimpleConverter
  testFloatFormatConverter
  testDoubleFormatConverter
  testDoubleSimpleConverter
  testTFBooleanConverter

}