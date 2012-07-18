package scalafx.application

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.mapAsScalaMap

import javafx.{application => jfxa}

object ApplicationIncludes extends ApplicationIncludes

trait ApplicationIncludes {
  implicit def jfxParamaters2sfx(p: jfxa.Application.Parameters) = new JFXApp.Parameters {
    def raw = p.getRaw
    def named = p.getNamed
    def unnamed = p.getUnnamed
    def delegate = p
  }
}