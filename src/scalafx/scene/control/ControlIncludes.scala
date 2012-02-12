/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene.control
import javafx.scene.{control => jfxsc}

object ControlIncludes extends ControlIncludes
trait ControlIncludes {
  implicit def jfxAccordion2sfx(a: jfxsc.Accordion) = new Accordion(a)
  implicit def jfxToggleGroup2sfx(tg: jfxsc.ToggleGroup) = new ToggleGroup(tg)
  implicit def jfxToggleButton2sfx(tb: jfxsc.ToggleButton) = new ToggleButton(tb)
  implicit def jfxRadioButton2sfx(rb: jfxsc.RadioButton) = new RadioButton(rb)
  implicit def jfxButtonBase2sfx(b: jfxsc.ButtonBase) = new ButtonBase(b)
  implicit def jfxButton2sfx(b: jfxsc.Button) = new Button(b)
  implicit def jfxChoiceBox2sfx[J <: AnyRef](cb: jfxsc.ChoiceBox[J]) = new ChoiceBox[J](cb)
  implicit def jfxCheckBox2sfx(c: jfxsc.CheckBox) = new CheckBox(c)
  implicit def jfxControl2sfx(c: jfxsc.Control) = new Control(c) {}
  implicit def jfxLabel2sfx(l: jfxsc.Label) = new Label(l)
  implicit def jfxLabeled2sfx(l: jfxsc.Labeled) = new Labeled(l) {}
  implicit def jfxScrollPane2sfx(s: jfxsc.ScrollPane) = new ScrollPane(s) {}
  implicit def jfxSlider2sfx(s: jfxsc.Slider) = new Slider(s)
  implicit def jfxTitledPane2sfx(t: jfxsc.TitledPane) = new TitledPane(t)
  implicit def jfxSeparator2sfx(s: jfxsc.Separator) = new Separator(s)
  implicit def jfxProgressIndicator2sfx(p: jfxsc.ProgressIndicator) = new ProgressIndicator(p)
  implicit def jfxProgressBar2sfx(p: jfxsc.ProgressBar) = new ProgressBar(p)
  implicit def jfxPasswordField2sfx(v: jfxsc.PasswordField) = new PasswordField(v)
  implicit def jfxTextField2sfx(v: jfxsc.TextField) = new TextField(v)
  implicit def jfxTextArea2sfx(t: jfxsc.TextArea) = new TextArea(t)
  implicit def jfxTextInputControl2sfx(t: jfxsc.TextInputControl) = new TextInputControl(t) {}
}
