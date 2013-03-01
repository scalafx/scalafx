package scalafx.controls.tableview

import scalafx.beans.property.StringProperty

class Person(firstName_ : String, lastName_ : String, phone_ : String) {

  val firstName = new StringProperty(this, "firstName", firstName_)
  val lastName = new StringProperty(this, "lastName", lastName_)
  val phone = new StringProperty(this, "phone", phone_)
}
