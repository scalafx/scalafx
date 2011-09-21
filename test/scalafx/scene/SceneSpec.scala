/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene

import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.testutil.PropertyComparator

class SceneSpec extends FlatSpec with PropertyComparator {
  "A Scene" should "implement all the JavaFX properties" in {
    compareProperties(classOf[javafx.scene.Scene], classOf[Scene])
  }

  "A Scene" should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[javafx.scene.SceneBuilder[_]], classOf[Scene])
  }
}
