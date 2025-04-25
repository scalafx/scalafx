/*
 * Copyright (c) 2011-2025, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.application

import javafx.application as jfxa
import javafx.scene.paint as jfxap
import scalafx.Includes.*
import scalafx.beans.property.{ReadOnlyBooleanProperty, ReadOnlyObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.input.KeyCode

import scala.language.implicitConversions

/** Application platform support, wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/application/Platform.html javafx.application.Platform]]. */
object Platform {

  object Preferences {
    implicit def sfxPreferences2jfx(p: Preferences): jfxa.Platform.Preferences = if (p != null) p.delegate else null

  }

  /**
   * Contains UI preferences of the current platform, wrapper for [[https://openjfx.io/javadoc/22/javafx.graphics/javafx/application/Platform.Preferences.html javafx.application.Platform.Preferences]]
   *
   * @since JavaFX 22
   */
  abstract class Preferences(override val delegate: jfxa.Platform.Preferences)
      extends SFXDelegate[jfxa.Platform.Preferences] {

    /**
     * The accent color, which can be used to highlight the active or
     * important part of a control and make it stand out from the rest of the user interface.
     */
    def accentColor: ReadOnlyObjectProperty[jfxap.Color] = delegate.accentColorProperty

    /**
     * The color used for background regions.
     */
    def backgroundColor: ReadOnlyObjectProperty[jfxap.Color] = delegate.backgroundColorProperty

    /**
     * The platform color scheme, which specifies whether applications should prefer light text on dark backgrounds,
     * or dark text on light backgrounds.
     */
    def colorScheme: ReadOnlyObjectProperty[jfxa.ColorScheme] = delegate.colorSchemeProperty

    /**
     * The color used for foreground elements like text.
     *
     * @return
     */
    def foregroundColor: ReadOnlyObjectProperty[jfxap.Color] = delegate.foregroundColorProperty

    /**
     * Specifies whether applications should always show scroll bars. If not set, an application may
     * choose to hide scroll bars that are not actively used, or make them smaller or less noticeable.
     *
     * If the platform does not report this preference, this property defaults to `false`.
     *
     * @since 24
     */
    def persistentScrollBars: ReadOnlyBooleanProperty = delegate.persistentScrollBarsProperty()

    /**
     * Specifies whether applications should minimize the amount of internet traffic, which users
     * might request because they are on a metered network or a limited data plan.
     *
     * If the platform does not report this preference, this property defaults to `false`.
     *
     * @since 24
     */
    def reducedData: ReadOnlyBooleanProperty = delegate.reducedDataProperty()

    /**
     * Specifies whether applications should minimize the amount of non-essential animations,
     * reducing discomfort for users who experience motion sickness or vertigo.
     *
     * If the platform does not report this preference, this property defaults to `false`.
     *
     * @since 24
     */
    def reducedMotion: ReadOnlyBooleanProperty = delegate.reducedMotionProperty()

    /**
     * Specifies whether applications should minimize the amount of transparent or translucent
     * layer effects, which can help to increase contrast and readability for some users.
     *
     * If the platform does not report this preference, this property defaults to `false`.
     *
     * @since 24
     */
    def reducedTransparency: ReadOnlyBooleanProperty = delegate.reducedTransparencyProperty()

  }

  /** Causes the JavaFX application to terminate. */
  def exit(): Unit = {
    jfxa.Platform.exit()
  }

  /**
   * Requests the Java Runtime to perform a pulse. This will run a pulse
   * even if there are no animation timers, scene graph modifications,
   * or window events that would otherwise cause the pulse to run.
   * If no pulse is in progress, then one will be scheduled to
   * run the next time the pulse timer fires.
   * If there is already a pulse running, then
   * at least one more pulse after the current pulse will be scheduled.
   * This method may be called on any thread.
   *
   * @since 9
   */
  def requestNextPulse(): Unit = jfxa.Platform.requestNextPulse()

  /** Returns true if the calling thread is the JavaFX Application Thread. */
  def isFxApplicationThread: Boolean = jfxa.Platform.isFxApplicationThread

  /** Gets the value of the implicitExit attribute. */
  def implicitExit: Boolean = jfxa.Platform.isImplicitExit

  /** Sets the implicitExit attribute to the specified value. */
  def implicitExit_=(implicitExit: Boolean): Unit = {
    jfxa.Platform.setImplicitExit(implicitExit)
  }

  /** Queries whether a specific conditional feature is supported by the platform. */
  def isSupported(feature: ConditionalFeature): Boolean = jfxa.Platform.isSupported(feature)

  /**
   * This method starts the JavaFX runtime. The specified Runnable will then be
   * called on the JavaFX Application Thread. In general it is not necessary to
   * explicitly call this method, since it is invoked as a consequence of
   * how most JavaFX applications are built. However there are valid use cases
   * for calling this method directly. Because this method starts the JavaFX
   * runtime, there is not yet any JavaFX Application Thread, so it is normal
   * that this method is called directly on the main thread of the application.
   *
   * <p>
   * This method may or may not return to the caller before the run method
   * of the specified Runnable has been called. In any case, once this method
   * returns, you may call [[runLater(Runnable)]] with additional Runnables.
   * Those Runnables will be called, also on the JavaFX Application Thread,
   * after the Runnable passed into this method has been called.
   * </p>
   *
   * <p>As noted, it is normally the case that the JavaFX Application Thread
   * is started automatically. It is important that this method only be called
   * when the JavaFX runtime has not yet been initialized. Situations where
   * the JavaFX runtime is started automatically include:
   * </p>
   *
   * <ul>
   * <li>For standard JavaFX applications that extend [[Application]], and
   * use either the Java launcher or one of the launch methods in the
   * Application class to launch the application, the FX runtime is
   * initialized automatically by the launcher before the `Application`
   * class is loaded.</li>
   * <li>For Swing applications that use [[javafx.embed.swing.JFXPanel]]
   * to display FX content, the
   * FX runtime is initialized when the first `JFXPanel` instance is
   *   constructed.</li>
   * <li>For SWT application that use `FXCanvas` to display FX content,
   * the FX runtime is initialized when the first `FXCanvas` instance is
   *   constructed.</li>
   * </ul>
   *
   * <p>When an application does not follow any of these common approaches,
   * then it becomes the responsibility of the developer to manually start the
   * JavaFX runtime by calling this startup method.
   * </p>
   *
   * <p>Calling this method when the JavaFX runtime is already running will result in an
   * [[IllegalStateException]] being thrown - it is only valid to request
   * that the JavaFX runtime be started once.
   * </p>
   *
   * @throws IllegalStateException if the JavaFX runtime is already running
   * @param runnable the Runnable whose run method will be executed on the
   *                 JavaFX Application Thread once it has been started
   * @see Application
   * @since 9
   */
  def startup(runnable: Runnable): Unit = jfxa.Platform.startup(runnable)

  /**
   * Run the specified Runnable on the JavaFX Application Thread at some unspecified time in the future.
   * Returns immediately.
   */
  def runLater(runnable: java.lang.Runnable): Unit = {
    jfxa.Platform.runLater(runnable)
  }

  /**
   * Run the specified code block on the JavaFX Application Thread at some unspecified time in the future.
   * Returns immediately.
   *
   * Example use:
   * {{{
   *   Platform.runLater {
   *     println("Running on application thread.")
   *   }
   * }}}
   */
  def runLater[R](op: => R): Unit = {
    runLater(new Runnable {
      def run(): Unit = {
        op
      }
    })
  }

  /**
   * Enter a nested event loop and block until the corresponding
   * exitNestedEventLoop call is made.
   * The key passed into this method is used to
   * uniquely identify the matched enter/exit pair. This method creates a
   * new nested event loop and blocks until the corresponding
   * exitNestedEventLoop method is called with the same key.
   * The return value of this method will be the `rval`
   * object supplied to the exitNestedEventLoop method call that unblocks it.
   *
   * <p>
   * This method must either be called from an input event handler or
   * from the run method of a Runnable passed to
   * [[javafx.application.Platform.runLater]].
   * It must not be called during animation or layout processing.
   * </p>
   *
   * @param key the Object that identifies the nested event loop, which
   *            must not be null
   * @throws IllegalArgumentException if the specified key is associated
   *                                  with a nested event loop that has not yet returned
   * @throws NullPointerException     if the key is null
   * @throws IllegalStateException    if this method is called during
   *                                  animation or layout processing.
   * @throws IllegalStateException    if this method is called on a thread
   *                                  other than the JavaFX Application Thread.
   * @return the value passed into the corresponding call to exitEventLoop
   * @since 9
   */
  def enterNestedEventLoop(key: Any): Any = jfxa.Platform.enterNestedEventLoop(key)

  /**
   * Exit a nested event loop and unblock the caller of the
   * corresponding enterNestedEventLoop.
   * The key passed into this method is used to
   * uniquely identify the matched enter/exit pair. This method causes the
   * nested event loop that was previously created with the key to exit and
   * return control to the caller. If the specified nested event loop is not
   * the inner-most loop then it will not return until all other inner loops
   * also exit.
   *
   * @param key  the Object that identifies the nested event loop, which
   *             must not be null
   * @param rval an Object that is returned to the caller of the
   *             corresponding enterNestedEventLoop. This may be null.
   * @throws IllegalArgumentException if the specified key is not associated
   *                                  with an active nested event loop
   * @throws NullPointerException     if the key is null
   * @throws IllegalStateException    if this method is called on a thread
   *                                  other than the FX Application thread
   * @since 9
   */
  def exitNestedEventLoop(key: Any, rval: Any): Unit = jfxa.Platform.exitNestedEventLoop(key, rval)

  /**
   * Returns a flag indicating whether the key corresponding to `keyCode`
   * is in the locked (or "on") state.
   * `keyCode` must be one of: [[KeyCode.Caps]] or [[KeyCode.NumLock]].
   * If the underlying system is not able to determine the state of the
   * specified `keyCode`, `None` is returned.
   * If the keyboard attached to the system doesn't have the specified key,
   * an `Some[False]` is returned.
   * This method must be called on the JavaFX Application thread.
   *
   * @param keyCode the `keyCode` of the lock state to query
   * @return the lock state of the key corresponding to `keyCode`,
   *         or None if the system cannot determine its state
   * @throws IllegalArgumentException if `keyCode` is not one of the
   *                                  valid`keyCode` values
   * @throws IllegalStateException    if this method is called on a thread
   *                                  other than the JavaFX Application Thread
   * @since 17
   */
  def isKeyLocked(keyCode: KeyCode): Option[Boolean] = if (jfxa.Platform.isKeyLocked(keyCode).isPresent) {
    Option(jfxa.Platform.isKeyLocked(keyCode).get)
  } else None

  /**
   * Checks whether a nested event loop is running, returning true to indicate
   * that one is, and false if there are no nested event loops currently
   * running.
   * This method must be called on the JavaFX Application thread.
   *
   * @return true if there is a nested event loop running, and false otherwise.
   * @throws IllegalStateException if this method is called on a thread
   *                               other than the JavaFX Application Thread.
   * @since 9
   */
  def isNestedLoopRunning: Boolean = jfxa.Platform.isNestedLoopRunning

  /**
   * Indicates whether a nested event loop can be started from the current thread in the current state.
   * A nested event loop can be started from an event handler or from a [[Runnable]] passed to
   * [[runLater]].
   * This method must be called on the JavaFX Application thread.
   *
   * @return `true` if a nested event loop can be started, and `false` otherwise.
   * @throws IllegalStateException if this method is called on a thread other than the JavaFX Application Thread.
   * @since 21
   */
  def canStartNestedEventLoop: Boolean = jfxa.Platform.canStartNestedEventLoop

  def isAccessibilityActive: Boolean = jfxa.Platform.isAccessibilityActive

  /**
   * Indicates whether or not accessibility is active.
   * This property is typically set to true the first time an
   * assistive technology, such as a screen reader, requests
   * information about any JavaFX window or its children.
   *
   * This method may be called from any thread.
   *
   * @return the read-only boolean property indicating if accessibility is active
   *
   * @since JavaFX 8u40
   */
  def accessibilityActive: ReadOnlyBooleanProperty = jfxa.Platform.accessibilityActiveProperty

  /**
   * Gets the preferences of the current platform, wraps [[https://openjfx.io/javadoc/22/javafx.graphics/javafx/application/Platform.html#getPreferences() Platform#getPreferences]]
   */
  def preferences: Preferences = jfxa.Platform.getPreferences
}
