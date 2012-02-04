package scalafx.scene.effect

import javafx.scene.{effect => jfxse}
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.Includes._
import scalafx.testutil.AbstractSFXDelegateSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
/**
 * DropShadow Spec tests.
 * 
 *
 */
class DropShadowSpec extends AbstractSFXDelegateSpec[jfxse.DropShadow, DropShadow, jfxse.DropShadowBuilder[_]](classOf[jfxse.DropShadow], classOf[DropShadow], classOf[jfxse.DropShadowBuilder[_]]) {

  protected def getScalaClassInstance = new DropShadow(new jfxse.DropShadow)

  protected def convertScalaClassToJavaClass(sfxObject: DropShadow) = {
    val jfxDropShadow: jfxse.DropShadow = sfxObject
    jfxDropShadow
  }

  protected def getJavaClassInstance = new jfxse.DropShadow

  protected def convertJavaClassToScalaClass(jfxObject: jfxse.DropShadow) = {
    val sfxDropShadow: DropShadow = jfxObject
    sfxDropShadow
  }

}
