package scalafx.event

import javafx.{event => jfx}

import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object EventDispatchChain {
  implicit def sfxEventDispatchChain2jfx(v: EventDispatchChain): jfx.EventDispatchChain = v.delegate
}

/**
 * Represents a chain of `EventDispatcher` objects, which can dispatch
 * an `Event`. The event is dispatched by passing it from one
 * `EventDispatcher` to the next in the chain until the end of chain is
 * reached. Each `EventDispatcher` in the chain can influence the event
 * path and the event itself. The chain is usually formed by following some
 * parent - child hierarchy from the root to the event target and appending
 * all `EventDispatcher` objects encountered to the chain.
 *
 *
 * Wraps a $JFX $URL0 $FC]].
 *
 * @define FC EventDispatchChain
 * @define URL0 [[https://docs.oracle.com/javafx/2/api/javafx/event/EventDispatchChain.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
trait EventDispatchChain extends SFXDelegate[jfx.EventDispatchChain] {

  /**
   * Appends the specified `EventDispatcher` to this chain. Returns a
   * reference to the chain with the appended element.
   * <p>
   * The caller shouldn't assume that this `EventDispatchChain` remains
   * unchanged nor that the returned value will reference a different chain
   * after the call. All this depends on the `EventDispatchChain`
   * implementation.
   * <p>
   * So the call should be always done in the following form:
   * `chain = chain.append(eventDispatcher);`
   *
   * @param eventDispatcher the `EventDispatcher` to append to the
   *                        chain
   * @return the chain with the appended event dispatcher
   * @see $URL0#append $ORIGINALDOC
   */
  def append(eventDispatcher: EventDispatcher): EventDispatchChain

  /**
   * Prepends the specified `EventDispatcher` to this chain. Returns a
   * reference to the chain with the prepended element.
   * <p>
   * The caller shouldn't assume that this `EventDispatchChain` remains
   * unchanged nor that the returned value will reference a different chain
   * after the call. All this depends on the `EventDispatchChain`
   * implementation.
   * <p>
   * So the call should be always done in the following form:
   * `chain = chain.prepend(eventDispatcher);`
   *
   * @param eventDispatcher the `EventDispatcher` to prepend to the
   *                        chain
   * @return the chain with the prepended event dispatcher
   * @see $URL0#prepend $ORIGINALDOC
   */
  def prepend(eventDispatcher: EventDispatcher): EventDispatchChain

  /**
   * Dispatches the specified event through this `EventDispatchChain`.
   * The return value represents the event after processing done by the chain.
   * If further processing is to be done after the call the event referenced
   * by the return value should be used instead of the original event. In the
   * case the event is fully handled / consumed in the chain the returned
   * value is `null` and no further processing should be done with that
   * event.
   *
   * @param event the event to dispatch
   * @return the processed event or `null` if the event had been fully
   *         handled / consumed
   * @see $URL0#dispatchEvent $ORIGINALDOC
   */
  def dispatchEvent(event: Event): Event = delegate.dispatchEvent(event.delegate)

}