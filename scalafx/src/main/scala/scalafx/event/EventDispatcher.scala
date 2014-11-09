package scalafx.event

import javafx.{event => jfx}

import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object EventDispatcher {
  implicit def sfxEventDispatcher2jfx(v: EventDispatcher): jfx.EventDispatcher = v.delegate
}

/**
 * An  represents an event dispatching and processing
 * entity. It is used when an  needs to be dispatched to the
 * associated `EventTarget` through the `EventDispatchChain`
 * specified by the target. Each  in the chain can
 * influence the event path and the event itself. One
 * can appear in multiple chains.
 *
 * Wraps a $JFX $URL0 $FC]].
 *
 * @define FC EventDispatcher
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventDispatcher.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
trait EventDispatcher extends SFXDelegate[jfx.EventDispatcher] {

  /**
   * Dispatches the specified event by this . Does
   * any required event processing. Both the event and its further path can
   * be modified in this method. If the event is not handled / consumed during
   * the capturing phase, it should be dispatched to the rest of the chain
   * ().
   *
   * @param event the event do dispatch
   * @param tail the rest of the chain to dispatch event to
   * @return the return event or  if the event has been handled / consumed
   * @see $URL0#dispatchEvent $ORIGINALDOC
   */
  def dispatchEvent(event: Event, tail: EventDispatchChain): Event =
    delegate.dispatchEvent(event.delegate, tail.delegate)
}