package scalafx.scene.effect

import javafx.scene.{effect => jfxse}
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.Includes._
import scalafx.testutil.PropertyComparator

class DropShadowSpec extends FlatSpec with PropertyComparator {
  "An DropShadow" should "implement all the JavaFX properties" in {
    compareProperties(classOf[jfxse.DropShadow], classOf[DropShadow])
  }

  it should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(classOf[jfxse.DropShadowBuilder[_]], classOf[DropShadow])
  }

  it should "have an implicit conversion from SFX to JFX" in {
    val sfxDropShadow = new DropShadow() {}
    val jfxDropShadow: jfxse.DropShadow = sfxDropShadow
    jfxDropShadow should be (sfxDropShadow.delegate)
  }

  it should "have an implicit conversion from JFX to SFX" in {
    val jfxDropShadow = new jfxse.DropShadow() {}
    val sfxDropShadow: DropShadow = jfxDropShadow
    sfxDropShadow.delegate should be (jfxDropShadow)
  }
}