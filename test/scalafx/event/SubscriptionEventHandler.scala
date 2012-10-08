package scalafx.event

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import scalafx.beans.property.StringProperty
import scalafx.beans.Observable

/**
 * Created with IntelliJ IDEA.
 * User: Daniel Alves
 * Date: 08/10/12
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 */

@RunWith(classOf[JUnitRunner])
class SubscriptionEventHandler extends FlatSpec {

  "A subscription" should "be created from EventSources" in {
    val property: StringProperty = ""
    var called = false

    val subscription = property.invalidate.subscribe((observable: Observable) => {
      called = true
      assert(observable === property)
    })

    property set "one"
    assert(called === true)

    called = false
    subscription.cancel()
    property set "two"
    assert(called === false)
  }

}
