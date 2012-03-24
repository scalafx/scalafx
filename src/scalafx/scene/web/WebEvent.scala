package scalafx.scene.web

import javafx.scene.{ web => jfxsw }
import javafx.{ event => jfxe }
import scalafx.event.Event
import scalafx.Includes._
import scalafx.util.SFXDelegate

object WebEvent {
  implicit def sfxWebEvent2jfx[T](we: WebEvent[T]) = we.delegate

  /**
   * This event occurs when a script calls the JavaScript alert function.
   */
  val ALERT = jfxsw.WebEvent.ALERT

  /**
   * Common supertype for all Web event types.
   */
  val ANY = jfxsw.WebEvent.ANY

  /**
   * This event occurs when a script changes location of the JavaScript window object.
   */
  val RESIZED = jfxsw.WebEvent.RESIZED

  /**
   * This event occurs when a script changes status line text.
   */
  val STATUS_CHANGED = jfxsw.WebEvent.STATUS_CHANGED

  /**
   * This event occurs when a script changes visibility of the JavaScript window object.
   */
  val VISIBILITY_CHANGED = jfxsw.WebEvent.VISIBILITY_CHANGED
}

class WebEvent[T](override val delegate: jfxsw.WebEvent[T]) extends Event(delegate) with SFXDelegate[jfxsw.WebEvent[T]] {

  /**
   * Creates a new event object.
   *
   */
  def this(source: Any, eventType: jfxe.EventType[jfxsw.WebEvent[_]], data: T) = this(new jfxsw.WebEvent(source, eventType, data))

  /**
   * Returns data item carried by this event.
   */
  def data = delegate.getData

}