/*
 * Copyright (c) 2012, ScalaFX Project
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

import scala.collection.JavaConversions.mutableMapAsJavaMap
import scala.collection.generic.MutableMapFactory
import scala.collection.mutable.Builder
import scala.collection.mutable.Map
import scala.collection.mutable.MapLike

import javafx.collections.FXCollections
import javafx.{collections => jfxc}
import scalafx.beans.Observable
import scalafx.util.SFXDelegate

object ObservableMap extends MutableMapFactory[ObservableMap] {
  implicit def sfxObservableMap2sfxObservableMap[K, V](ob: ObservableMap[K, V]) = ob.delegate

  /**
   * Indicates a Change in a ObsevableMap
   *
   * @param key Key handled
   * @param added Value added. May be [[scala.None]] if there was just a remotion.
   * @param removed Value removed. May be [[scala.None]] if there was just a addition.
   */
  case class Change[K, V](key: K, added: Option[V], removed: Option[V])

  // CREATION METHODS - BEGIN

  /**
   * Creates a empty ObservableMap.
   */
  def empty[K, V]: ObservableMap[K, V] = new ObservableMap[K, V]

  /**
   * Creates a new ObservableMap from a sequence of tuples
   *
   * @param keyValues Sequence of tuples
   *
   * @returns A newly created ObservableMap
   */
  def observableMap[K, V](keyValues: Seq[(K, V)]): ObservableMap[K, V] = {
    val map = empty[K, V]
    keyValues.foreach(keyValue => map(keyValue._1) = keyValue._2)
    map
  }

  /**
   * Constructs an ObservableMap that is backed by the specified map. Mutation operations on the
   * ObservableMap instance will be reported to observers that have registered on that instance.
   * Note that mutation operations made directly to the underlying map are not reported to
   * observers of any ObservableMap that wraps it.
   *
   * @param A Map that backs this ObservableMap
   *
   * @returns A newly created ObservableMap
   */
  def observableMap[K, V](map: Map[K, V]): ObservableMap[K, V] =
    new ObservableMap(FXCollections.observableMap(map))

  // CREATION METHODS - END

}

/**
 * Wrapper class to [[http://docs.oracle.com/javafx/2/api/javafx/collections/ObservableMap.html ObservableMap]]'s
 * JavaFX.
 *
 * @tparam K Key type
 * @tparam V Value type.
 * @param delegate ObservableMap's JavaFX to be wrapped. Its default value is ObservableMap
 * returned by
 * [[http://docs.oracle.com/javafx/2/api/javafx/collections/FXCollections.html#observableHashMap() observableHashMap]]
 * method from
 * [[http://docs.oracle.com/javafx/2/api/javafx/collections/FXCollections.html FXCollections]].
 *
 */
class ObservableMap[K, V](override val delegate: jfxc.ObservableMap[K, V] = jfxc.FXCollections.observableHashMap[K, V])
  extends Map[K, V]
  with MapLike[K, V, ObservableMap[K, V]]
  with Builder[(K, V), ObservableMap[K, V]]
  with Observable
  with SFXDelegate[jfxc.ObservableMap[K, V]] {

  /**
   * The result when this map is used as a builder
   */
  override def result = this

  /**
   * The empty map of the same type as this map
   * 
   * @rturns an empty `ObservableMap`.
   */
  override def empty = new ObservableMap

  /**
   * Adds a new key/value pair to this map.
   * 
   * @param the key/value pair.
   * @returns the map itself 
   */
  override def +=(kv: (K, V)) = {
    delegate.put(kv._1, kv._2)
    this
  }

  /**
   * Removes a key from this map.
   * 
   * @param the key to be removed
   * @returns the map itself.
   */
  def -=(key: K) = {
    delegate.remove(key)
    this
  }

  /**
   * Optionally returns the value associated with a key.
   * 
   * @param key the key value
   * @returns an option value containing the value associated with key in this map, or None if 
   * none exists.
   */
  def get(key: K) = if (delegate.containsKey(key)) Option(delegate.get(key)) else None
  
  /**
   * Removes all elements from the map. After this operation has completed, the map will be empty.
   */
  override def clear = delegate.clear

  /**
   * Creates a new iterator over all key/value pairs of this map
   * 
   * @returns the new iterator
   */
  def iterator = new Iterator[(K, V)] {
    // Definition copied from JavaConversions.JMapWrapperLike.iterator
    val ui = delegate.entrySet.iterator
    def hasNext = ui.hasNext
    def next() = { val e = ui.next; (e.getKey, e.getValue) }
  }

  /**
   * Add a listener function to map's changes. This function will handle this
   * [[ObservableMap.Change map's modification data]].
   *
   * @param Function that will handle this map's modification data to be activated when
   * some change was made.
   */
  def onChange(op: (ObservableMap[K, V], ObservableMap.Change[K, V]) => Unit) {
    delegate.addListener(new jfxc.MapChangeListener[K, V] {
      def onChanged(change: jfxc.MapChangeListener.Change[_ <: K, _ <: V]) {
        val added = if (change.wasAdded) Some(change.getValueAdded) else None
        val removed = if (change.wasRemoved()) Some(change.getValueRemoved) else None
        op(ObservableMap.this, ObservableMap.Change(change.getKey, added, removed))
      }
    })
  }

  /**
   * Add a listener function to map's changes. This function will not handle this map's
   * modification data.
   *
   * @param op No-argument function to be activated when some change in this map was made.
   */
  def onChange(op: => Unit) {
    delegate.addListener(new jfxc.MapChangeListener[K, V] {
      def onChanged(change: jfxc.MapChangeListener.Change[_ <: K, _ <: V]) {
        op
      }
    })
  }

}