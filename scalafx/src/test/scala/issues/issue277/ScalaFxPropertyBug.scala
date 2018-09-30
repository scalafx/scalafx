package issues.issue277

import scalafx.beans.property.IntegerProperty

object ScalaFxPropertyBug extends App {
  val property = IntegerProperty(1)

  // Compiles well
  property.value = property.value + 1
  println(".")
  println(property.value)
  println("..")
  println(property())
  println("...")

  // Error: Expression does not convert to assignment because receiver is not assignable.
  // Uncomment next line to get compilation error
  // property.value += 1
  println("....")

  property() += 1
  println(".....")

  // Work around
  println(property())
  println("......")
}
