package scalafx.scene.transform

import scalafx.Includes._
import javafx.scene.{ transform => jfxst }

object TransformIncludes extends TransformIncludes

trait TransformIncludes {
  implicit def jfxAffine2sfx(v: jfxst.Affine) = new Affine(v)
  implicit def jfxRotate2sfx(v: jfxst.Rotate) = new Rotate(v)
  implicit def jfxScale2sfx(v: jfxst.Scale) = new Scale(v)
  implicit def jfxShear2sfx(v: jfxst.Shear) = new Shear(v)
  implicit def jfxTransform2sfx(v: jfxst.Transform) = new Transform(v) {}
  implicit def jfxTranslate2sfx(v: jfxst.Translate) = new Translate(v)
}