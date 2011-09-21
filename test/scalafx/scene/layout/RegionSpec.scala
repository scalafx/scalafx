/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene.layout

import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.testutil.PropertyComparator

class RegionSpec  extends FlatSpec with PropertyComparator {
  "A Region" should "implement all the JavaFX properties" in {
    compareProperties(classOf[javafx.scene.layout.Region], classOf[Region])
  }

  "A Region" should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[javafx.scene.layout.RegionBuilder[_]], classOf[Region])
  }
}
