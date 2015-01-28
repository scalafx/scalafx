package scalafx.stage

import javafx.{stage => jfxs}

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scalafx.Includes._
import scalafx.testutil.SFXEnumDelegateSpec


/** Tests for [[scalafx.stage.PopupWindow.AnchorLocation]]. */
@RunWith(classOf[JUnitRunner])
class PopupWindowAnchorLocationSpec
  extends SFXEnumDelegateSpec[jfxs.PopupWindow.AnchorLocation, PopupWindow.AnchorLocation](
  classOf[jfxs.PopupWindow.AnchorLocation],
  classOf[PopupWindow.AnchorLocation],
  PopupWindow.AnchorLocation)