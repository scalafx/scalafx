package scalafx.testutil

import java.util.concurrent.CountDownLatch
import javafx.application.Platform
import org.scalatest.{AbstractSuite, Suite}

trait RunOnApplicationThread extends AbstractSuite { this: Suite =>
  abstract override def withFixture(test : NoArgTest) {
    BootstrapApplication.launch()
    val appThreadLatch = new CountDownLatch(1)
    val superWith = super.withFixture _ // required to access to super withFixture method from within runnable for a trait
    var testException:Exception = null
    Platform.runLater(new Runnable() {
      override def run() {
        try {
          superWith(test)
        } catch {
          case e:Exception => testException = e
        } finally {
          appThreadLatch.countDown()
        }
      }
    })
    appThreadLatch.await()
    if (testException != null) {
      throw testException
    }
  }
}
