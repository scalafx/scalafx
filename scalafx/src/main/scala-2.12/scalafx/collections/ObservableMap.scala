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
package scalafx.collections

import javafx.{collections => jfxc}
import scalafx.beans.Observable
import scalafx.delegate.SFXDelegate
import scalafx.event.subscriptions.Subscription

import java.{util => ju}
import scalafx.util.JavaConverters._
import scala.collection.generic.MutableMapFactory
import scala.collection.mutable
import scala.language.implicitConversions

/**
 * Companion Object for `[[scalafx.collections.ObservableMap]]`.
 *
 * @define OM `ObservableMap`
 */
object ObservableMap extends MutableMapFactory[ObservableMap] {

  /**
   * Extracts a JavaFX's [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableMap.html $OM]] from a
   * ScalaFX's $OM.
   *
   * @param om ScalaFX's $OM.
   * @return JavaFX's $OM inside parameter.
   */
  implicit def sfxObservableMap2sfxObservableMap[K, V](om: ObservableMap[K, V]): jfxc.ObservableMap[K, V] =
    if (om != null) om.delegate else null

  // CHANGING INDICATORS - BEGIN

  /**
   * Indicates a change in an $OM. It is a simpler version of JavaFX's
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/MapChangeListener.Change.html `MapChangeListener.Change`]],
   * where each subclass indicates a specific change operation.
   */
  trait Change[K, V]

  /**
   * Indicates an addition in an $OM.
   *
   * @param key Handled Key.
   * @param added Added element.
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/http://docs.oracle.com/javase/8/javafx/api/javafx/collections/MapChangeListener.Change.html#getKey() `MapChangeListener.Change.getKey()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/http://docs.oracle.com/javase/8/javafx/api/javafx/collections/MapChangeListener.Change.html#getValueAdded() `MapChangeListener.Change.getValueAdded()`]]
   */
  case class Add[K, V](key: K, added: V) extends Change[K, V]

  /**
   * Indicates a removal in an $OM.
   *
   * @param key Handled Key.
   * @param removed Removed element.
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/http://docs.oracle.com/javase/8/javafx/api/javafx/collections/MapChangeListener.Change.html#getKey() `MapChangeListener.Change.getKey()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/http://docs.oracle.com/javase/8/javafx/api/javafx/collections/MapChangeListener.Change.html#getValueRemoved() `MapChangeListener.Change.getValueRemoved()`]]
   */
  case class Remove[K, V](key: K, removed: V) extends Change[K, V]

  /**
   * Indicates a replacement in an $OM.
   *
   * @param key Handled Key.
   * @param added Added Value.
   * @param removed Removed Value.
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/http://docs.oracle.com/javase/8/javafx/api/javafx/collections/MapChangeListener.Change.html#getKey() `MapChangeListener.Change.getKey()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/http://docs.oracle.com/javase/8/javafx/api/javafx/collections/MapChangeListener.Change.html#getValueAdded() `MapChangeListener.Change.getValueAdded()`]]
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/http://docs.oracle.com/javase/8/javafx/api/javafx/collections/MapChangeListener.Change.html#getValueRemoved() `MapChangeListener.Change.getValueRemoved()`]]
   */
  case class Replace[K, V](key: K, added: V, removed: V) extends Change[K, V]

  // CHANGING INDICATORS - END

  // CREATION METHODS - BEGIN

  /**
   * Creates an empty $OM.
   *
   * @return a Empty [[scalafx.collections.ObservableHashMap]]
   */
  def empty[K, V]: ObservableMap[K, V] = new ObservableHashMap[K, V]

  /**
   * Creates a new $OM from a sequence of tuples
   *
   * @param keyValues Sequence of tuples
   * @return A newly created $OM.
   */
  def from[K, V](keyValues: Seq[(K, V)]): ObservableMap[K, V] = {
    val map = empty[K, V]
    keyValues.foreach(keyValue => map(keyValue._1) = keyValue._2)
    map
  }

  /**
   * Creates a new $OM that is backed by the specified map. Mutation operations on the $OM instance will be reported
   * to observers that have registered on that instance. Note that mutation operations made directly to the underlying
   * map are not reported to observers of any $OM that wraps it.
   *
   * @param originalMap A Map that backs this $OM.
   * @return A newly created $OM.
   */
  def from[K, V](originalMap: mutable.Map[K, V]): ObservableMap[K, V] =
    new ObservableMap[K, V] {
      override val delegate: jfxc.ObservableMap[K, V] = jfxc.FXCollections.observableMap(originalMap.asJava)
    }

  // CREATION METHODS - END

}

/**
 * Wrapper class to JavaFX's [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableMap.html $OM]].
 *
 * @tparam K Key type
 * @tparam V Value type.
 *           returned by
 *           [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/FXCollections.html#observableHashMap() observableHashMap]]
 *           method from
 *           [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/FXCollections.html FXCollections]].
 *
 * @define OM `ObservableMap`
 * @define MAP `Map`
 */
trait ObservableMap[K, V]
    extends mutable.Map[K, V]
    with mutable.MapLike[K, V, ObservableMap[K, V]]
    with mutable.Builder[(K, V), ObservableMap[K, V]]
    with Observable
    with SFXDelegate[jfxc.ObservableMap[K, V]] {

  /**
   * The result when this $MAP is used as a builder.
   */
  override def result(): ObservableMap[K, V] = this

  /**
   * The empty map of the same type as this $MAP.
   *
   * @return An empty $OM
   */
  override def empty = new ObservableHashMap[K, V]()

  /**
   * Adds a new key/value pair to this $MAP.
   *
   * @param kv the key/value pair.
   * @return The $OM itself
   */
  def +=(kv: (K, V)): ObservableMap.this.type = {
    delegate.put(kv._1, kv._2)
    this
  }

  /**
   * Removes a key from this $MAP.
   *
   * @param key the key to be removed
   * @return The $OM itself.
   */
  def -=(key: K): ObservableMap.this.type = {
    delegate.remove(key)
    this
  }

  /**
   * Removes all elements from the $MAP. After this operation has completed, the $MAP will be empty.
   */
  override def clear(): Unit = {
    delegate.clear()
  }

  /**
   * Creates a new [[http://www.scala-lang.org/api/current/scala/collection/Iterator.html `Iterator`]] over all
   * key/value pairs of this $OM.
   *
   * @return The new `iterator`.
   */
  def iterator: Iterator[(K, V)] = new Iterator[(K, V)] {
    // Definition copied from JavaConversions.JMapWrapperLike.iterator
    val it: ju.Iterator[ju.Map.Entry[K, V]] = delegate.entrySet.iterator

    def hasNext: Boolean = it.hasNext

    def next(): (K, V) = {
      val e = it.next()
      (e.getKey, e.getValue)
    }
  }

  /**
   * This $MAP's size.
   *
   * @return This $MAP's size.
   */
  override def size: Int = delegate.size

  /**
   * Optionally returns the value associated with a key.
   *
   * @param key the key value
   * @return an option value containing the value associated with key in this $MAP, or None if
   *         none exists.
   */
  def get(key: K): Option[V] = if (delegate.containsKey(key)) Option(delegate.get(key)) else None

  import scalafx.collections.ObservableMap._

  /**
   * Add a listener function to $MAP's changes. This function '''will handle''' this map's modifications data.
   *
   * @param op Function that will handle this $OM's modifications data to be activated when some change was made.
   */
  def onChange(op: (ObservableMap[K, V], Change[K, V]) => Unit): Subscription = {
    val listener = new jfxc.MapChangeListener[K, V] {
      def onChanged(change: jfxc.MapChangeListener.Change[_ <: K, _ <: V]): Unit = {
        val changeEvent: Change[K, V] = (change.wasAdded, change.wasRemoved) match {
          case (true, true)   => Replace(change.getKey, change.getValueAdded, change.getValueRemoved)
          case (true, false)  => Add(change.getKey, change.getValueAdded)
          case (false, true)  => Remove(change.getKey, change.getValueRemoved)
          case (false, false) => throw new IllegalStateException("Irregular Change: neither addition nor remotion")
        }

        op(ObservableMap.this, changeEvent)
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel(): Unit = {
        delegate.removeListener(listener)
      }
    }
  }

  /**
   * Add a listener function to $MAP's changes. This function '''will not handle''' this $MAP's modifications data.
   *
   * @param op No-argument function to be activated when some change in this $OM was made.
   */
  def onChange(op: => Unit): Subscription = {
    val listener = new jfxc.MapChangeListener[K, V] {
      def onChanged(change: jfxc.MapChangeListener.Change[_ <: K, _ <: V]): Unit = {
        op
      }
    }

    delegate.addListener(listener)

    new Subscription {
      def cancel(): Unit = {
        delegate.removeListener(listener)
      }
    }
  }

}

/**
 * [[scalafx.collections.ObservableMap]] implementation backed for a
 * [[http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html `HashMap`]] from Java Collection.
 *
 * @param delegate JavaFX
 *                 [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableMap.html `ObservableMap`]]
 *                 instance to be wrapped by this class. By default it is a
 *                 [[http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html `HashMap`]] wrapped by
 *                 [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/FXCollections.html#observableMap(java.util.Map) `observableMap`]]
 *                 method from
 *                 [[http://docs.oracle.com/javase/8/javafx/api/javafx/collections/FXCollections.html `FXCollections`]].
 */
class ObservableHashMap[K, V](override val delegate: jfxc.ObservableMap[K, V] =
  jfxc.FXCollections.observableMap(new ju.HashMap[K, V]))
    extends ObservableMap[K, V]
