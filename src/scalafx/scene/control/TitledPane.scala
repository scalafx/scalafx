/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene.control


import javafx.scene.{control => jfxsc}

import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.scene._

object TitledPane {
  implicit def sfxTitledPane2jfx(v: TitledPane) = v.delegate
}

/*

[info] - should implement all the JavaFX builder properties *** FAILED ***
[info]   Missing Properties: animatedProperty, collapsibleProperty, contentProperty, expandedProperty, getContent, isAnimated, isCollapsible, isExpanded, setAnimated, setCollapsible, setContent, setExpanded (PropertyComparator.scala:60)

 */

class TitledPane (override val delegate:jfxsc.TitledPane = new jfxsc.TitledPane) extends Control with SFXDelegate[jfxsc.TitledPane] {

  def animated = delegate.animatedProperty
  def animated_=(v:Boolean) {
    animated() = v
  }
  
  def collapsible = delegate.collapsibleProperty
  def collapsible_=(v:Boolean) {
    collapsible() = v
  }
  
  def content = delegate.contentProperty
  def content_=(v:Node) {
    content() = v
  }
  
  def expanded = delegate.expandedProperty
  def expanded_=(v:Boolean) {
    expanded() = v
  }
 }
