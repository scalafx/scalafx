/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.beans.property

import javafx.scene.paint.Color
import javafx.scene.paint.Paint

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers._
import scalafx.beans.binding.Bindings._

class ReadOnlyObjectPropertySpec extends FlatSpec {
  
  val bean = new Object()
  var readOnlyObjectProperty = new ReadOnlyObjectProperty[Paint](bean, "Test Read-only Object", Color.BLACK)
  var objectProperty1 = new ObjectProperty[Paint](bean, "Test Object 2")
  var objectProperty2 = new ObjectProperty[Paint](bean, "Test Object 3")
  var booleanProperty = new BooleanProperty(bean, "Test Boolean")
  
  
  "An Object Property" should "start with the value we gave it" in {
    readOnlyObjectProperty.value should equal (Color.BLACK)
  }

  it should "return its value using apply" in {
    readOnlyObjectProperty() should equal (Color.BLACK)
  }

  it should "know its name" in {
    readOnlyObjectProperty.name should equal ("Test Read-only Object")
  }

  it should "know its bean" in {
    readOnlyObjectProperty.bean should equal (bean)
  }

  it should "be bindable to another Object Property" in {
    objectProperty1 <== readOnlyObjectProperty
    objectProperty1() should equal (Color.BLACK)
    objectProperty1.unbind()
  }
  
  it should "support bindable infix equality with a property" in {
    booleanProperty <== readOnlyObjectProperty == objectProperty1
    objectProperty1() = Color.WHITE
    booleanProperty() should equal (false)
    objectProperty1() = Color.BLACK
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }
  
  it should "support bindable infix equality with a constant" in {
    booleanProperty <== readOnlyObjectProperty == Color.WHITE
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyObjectProperty == Color.BLACK
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== readOnlyObjectProperty != objectProperty1
    objectProperty1() = Color.WHITE
    booleanProperty() should equal (true)
    objectProperty1() = Color.BLACK
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== readOnlyObjectProperty != Color.WHITE
    booleanProperty() should equal (true)
    booleanProperty <== readOnlyObjectProperty != Color.BLACK
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }
  
}
