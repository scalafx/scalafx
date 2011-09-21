/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene

import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.testutil.PropertyComparator

class ParentSpec extends FlatSpec with PropertyComparator {
  "A Parent" should "implement all the JavaFX properties" in {
    compareProperties(classOf[javafx.scene.Parent], classOf[Parent])
  }

  "A Parent" should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[javafx.scene.ParentBuilder[_]], classOf[Parent])
  }
}
