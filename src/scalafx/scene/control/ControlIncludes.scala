/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene.control
import javafx.scene.{control => jfxsc}

object ControlIncludes extends ControlIncludes
trait ControlIncludes {
  
  implicit def jfxAccordion2sfx(r: jfxsc.Accordion) = new Accordion(r)
  implicit def jfxTitledPane2sfx(r: jfxsc.TitledPane) = new TitledPane(r)
  
  
  implicit def jfxControl2sfx(s: jfxsc.Control) = new Control(s) {}
}
