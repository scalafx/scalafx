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

class TitledPaneSpec extends FlatSpec with PropertyComparator {
  "A TitledPane" should "implement all the JavaFX properties" in {
    compareProperties(classOf[jfxsc.TitledPane], classOf[TitledPane])
  }

  it should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[jfxsc.TitledPaneBuilder[_]], classOf[TitledPane])
  }

  it should "have an implicit conversion from SFX to JFX" in {
    val sfxTitledPane = new TitledPane()
    val jfxTitledPane: jfxsc.TitledPane = sfxTitledPane
    jfxTitledPane should be (sfxTitledPane.delegate)
  }

  it should "have an implicit conversion from JFX to SFX" in {
    val jfxTitledPane = new jfxsc.TitledPane()
    val sfxTitledPane: TitledPane = jfxTitledPane
    sfxTitledPane.delegate should be (jfxTitledPane)
  }
}
