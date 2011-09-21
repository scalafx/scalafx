/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene

import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.testutil.PropertyComparator

class GroupSpec extends FlatSpec with PropertyComparator {
  "A Group" should "implement all the JavaFX properties" in {
    compareProperties(classOf[javafx.scene.Group], classOf[Group])
  }

  "A Group" should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[javafx.scene.GroupBuilder[_]], classOf[Group])
  }
}
