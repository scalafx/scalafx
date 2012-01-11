/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.Includes._
import scalafx.testutil.PropertyComparator

class ScrollPaneSpec extends FlatSpec with PropertyComparator {
  "A ScrollPane" should "implement all the JavaFX properties" in {
    compareProperties(classOf[jfxsc.ScrollPane], classOf[ScrollPane])
  }

  it should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[jfxsc.ScrollPaneBuilder[_]], classOf[ScrollPane])
  }

  it should "have an implicit conversion from SFX to JFX" in {
    val sfxScrollPane = new ScrollPane()
    val jfxScrollPane: jfxsc.ScrollPane = sfxScrollPane
    jfxScrollPane should be (sfxScrollPane.delegate)
  }

  it should "have an implicit conversion from JFX to SFX" in {
    val jfxScrollPane = new jfxsc.ScrollPane()
    val sfxScrollPane: ScrollPane = jfxScrollPane
    sfxScrollPane.delegate should be (jfxScrollPane)
  }
}
