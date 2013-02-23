package issues.issue09

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Ignore, FlatSpec}
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty

/** Verify that code causing Issue 9 behaves correctly after fix. */
@RunWith(classOf[JUnitRunner])
@Ignore
class Issue09Spec extends FlatSpec {

  "Issue 9 fix" should "run HeronsFormulaExample without exceptions" in {
    val a = DoubleProperty(0)
    val b = DoubleProperty(0)
    val c = DoubleProperty(0)

    val s = (a + b + c) / 2D

    // Exception was thrown here:
    //   java.lang.ClassCastException: javafx.beans.binding.Bindings$20
    //     cannot be cast to javafx.beans.value.ObservableObjectValue
    val areaSquared = when(((a + b) > c) && ((b + c) > a) && ((c + a) > b)) choose
      (s * (s - a) * (s - b) * (s - c)) otherwise 0.0

    a() = 3
    b() = 4
    c() = 5
    assert(6 * 6 === areaSquared())

    a() = 2
    b() = 2
    c() = 2
    assert(3 === areaSquared())
  }
}
