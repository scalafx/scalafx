package scalafx.beans.value

import javafx.beans.value.ChangeListener
import javafx.beans.value
import scalafx.event.subscriptions.Subscription


/**
 * Created with IntelliJ IDEA.
 * User: Daniel Alves
 * Date: 05/10/12
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
case class ChangeEventSource[T, J, TObservable <: ObservableValue[T, J]](source: TObservable) {

  def subscribe(handler: (TObservable, J, J) => Unit): Subscription = {
    val listener = new ChangeListener[J] {
      def changed(sender: value.ObservableValue[_ <: J], oldValue: J, newValue: J) {
        handler(source, oldValue, newValue)
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
