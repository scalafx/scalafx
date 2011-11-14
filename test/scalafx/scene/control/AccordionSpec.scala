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

class AccordionSpec extends FlatSpec with PropertyComparator {
  "A Accordion" should "implement all the JavaFX properties" in {
    compareProperties(classOf[jfxsc.Accordion], classOf[Accordion])
  }

  it should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[jfxsc.AccordionBuilder[_]], classOf[Accordion])
  }

  it should "have an implicit conversion from SFX to JFX" in {
    val sfxAccordion = new Accordion()
    val jfxAccordion: jfxsc.Accordion = sfxAccordion
    jfxAccordion should be (sfxAccordion.delegate)
  }

  it should "have an implicit conversion from JFX to SFX" in {
    val jfxAccordion = new jfxsc.Accordion()
    val sfxAccordion: Accordion = jfxAccordion
    sfxAccordion.delegate should be (jfxAccordion)
  }
}

