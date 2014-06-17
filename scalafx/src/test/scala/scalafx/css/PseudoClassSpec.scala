package scalafx.css

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import javafx.{ css => jfxcss }
import scalafx.Includes._
import scalafx.testutil.{RunOnApplicationThread, SimpleSFXDelegateSpec}

/**
 * PseudoClass Spec tests.
 *
 */
@RunWith(classOf[JUnitRunner])
class PseudoClassSpec
  extends SimpleSFXDelegateSpec[jfxcss.PseudoClass, PseudoClass](
      classOf[jfxcss.PseudoClass], classOf[PseudoClass])
  with RunOnApplicationThread {

  override protected def getScalaClassInstance = new PseudoClass(new jfxcss.PseudoClass {def getPseudoClassName = ""}) {}

  override protected def getJavaClassInstance = new jfxcss.PseudoClass {def getPseudoClassName = ""}
}