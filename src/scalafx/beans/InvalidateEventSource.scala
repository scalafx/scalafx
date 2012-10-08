package scalafx.beans

import javafx.beans.InvalidationListener
import javafx.beans
import scalafx.event.subscriptions.Subscription

/**
 * Created with IntelliJ IDEA.
 * User: Daniel Alves
 * Date: 08/10/12
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
case class InvalidateEventSource[+T <: Observable](source: T) {

  def subscribe(handler: (T) => Unit): Subscription = {
    val listener = new InvalidationListener {
      def invalidated(sender: beans.Observable) {
        handler(source)
      }
    }

    source.delegate.addListener(listener)

    new Subscription {
      def cancel() {
        source.delegate.removeListener(listener)
      }
    }
  }

}
