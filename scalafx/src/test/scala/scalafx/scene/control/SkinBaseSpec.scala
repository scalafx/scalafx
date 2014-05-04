package scalafx.scene.control

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import scalafx.testutil.{RunOnApplicationThread, SimpleSFXDelegateSpec}

/**
 * PseudoClass Spec tests.
 *
 */
@RunWith(classOf[JUnitRunner])
class SkinBaseSpec
  extends SimpleSFXDelegateSpec[jfxsc.SkinBase[jfxsc.Button], SkinBase[jfxsc.Button]](
      classOf[jfxsc.SkinBase[jfxsc.Button]], classOf[SkinBase[jfxsc.Button]])
  with RunOnApplicationThread {

  override protected def getScalaClassInstance = new SkinBase[jfxsc.Button](new jfxsc.SkinBase[jfxsc.Button](new jfxsc.Button) {}) {}

  override protected def getJavaClassInstance = new jfxsc.SkinBase[jfxsc.Button](new jfxsc.Button) {}
}