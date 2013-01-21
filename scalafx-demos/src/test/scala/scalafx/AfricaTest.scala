package scalafx

import org.junit.runner.RunWith
import org.junit.Assert._
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AfricaTest extends WordSpec {

	"the very first test" should {
		"produce simple output" in {
			val s = "Hello"
			val a = 1
			val b = 2
			assertEquals( 3, a + b )
			println(s+" World Test" )
		}
	}
}

