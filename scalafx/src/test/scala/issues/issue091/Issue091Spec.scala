package issues.issue091

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.Matchers._
import scalafx.scene.effect.Blend
import scalafx.scene.shape.Rectangle
import scalafx.testutil.RunOnApplicationThread

/** Issue 91: "Setting control effect as null causes NPE" */
@RunWith(classOf[JUnitRunner])
class Issue091Spec extends FlatSpec with RunOnApplicationThread {

  "Issue 91 - cont" should "compile" in {

    val drop = new Rectangle() {
      effect = new Blend()
    }
    drop.effect() should not be null

    // Issue 91 is causing NPE exception in the following line, due to an attempted implicit conversion of `null`.
    drop.effect = null

    drop.effect() should be(null)
  }

}
