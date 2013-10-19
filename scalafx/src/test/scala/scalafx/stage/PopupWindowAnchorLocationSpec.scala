package scalafx.stage

import javafx.{stage => jfxs}
import scalafx.Includes._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scalafx.testutil.SFXEnumDelegateSpec


/** Tests for [[javafx.stage.PopupWindow.AnchorLocation]]. */
@RunWith(classOf[JUnitRunner])
class PopupWindowAnchorLocationSpec
  extends SFXEnumDelegateSpec[jfxs.PopupWindow.AnchorLocation, PopupWindow.AnchorLocation](
  classOf[jfxs.PopupWindow.AnchorLocation],
  classOf[PopupWindow.AnchorLocation],
  PopupWindow.AnchorLocation)