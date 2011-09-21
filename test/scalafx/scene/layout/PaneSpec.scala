/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene.layout

import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.testutil.PropertyComparator

class PaneSpec  extends FlatSpec with PropertyComparator {
  "A Pane" should "implement all the JavaFX properties" in {
    compareProperties(classOf[javafx.scene.layout.Pane], classOf[Pane])
  }

  "A Pane" should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[javafx.scene.layout.PaneBuilder[_]], classOf[Pane])
  }
}
