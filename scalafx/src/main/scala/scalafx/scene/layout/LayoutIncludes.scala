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
package scalafx.scene.layout

import javafx.scene.layout as jfxsl

import scala.language.implicitConversions

object LayoutIncludes extends LayoutIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/package-summary.html `javafx.scene.layout`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define ACPN AnchorPane
 * @define BKGN Background
 * @define BRDR Border
 * @define BDPN BorderPane
 * @define CLCT ColumnConstraints
 * @define CTBS ConstraintsBase
 * @define FLPN FlowPane
 * @define GDPN GridPane
 * @define HBOX HBox
 * @define PANE Pane
 * @define PRIO Priority
 * @define REGI Region
 * @define RWCT RowConstraints
 * @define STPN StackPane
 * @define TLPN TilePane
 * @define VBOX  VBox
 */
trait LayoutIncludes {

  /**
   * $START$ACPN.html $ACPN$END
   *
   * @param a $JFX $ACPN
   * @return $SFX $ACPN
   */
  implicit def jfxAnchorPane2sfx(a: jfxsl.AnchorPane): AnchorPane = if (a != null) new AnchorPane(a) else null

  /**
   * $START$BKGN.html $BKGN$END
   *
   * @param v $JFX $BKGN
   * @return $SFX $BKGN
   */
  implicit def jfxBackground2sfx(v: jfxsl.Background): Background = if (v != null) new Background(v) else null

  implicit def jfxBackgroundFill2sfx(v: jfxsl.BackgroundFill): BackgroundFill =
    if (v != null) new BackgroundFill(v) else null

  implicit def jfxBackgroundImage2sfx(v: jfxsl.BackgroundImage): BackgroundImage =
    if (v != null) new BackgroundImage(v) else null

  implicit def jfxBackgroundPosition2sfx(v: jfxsl.BackgroundPosition): BackgroundPosition =
    if (v != null) new BackgroundPosition(v) else null

  implicit def jfxBackgroundRepeat2sfx(v: jfxsl.BackgroundRepeat): BackgroundRepeat =
    if (v != null) BackgroundRepeat(v) else null

  implicit def jfxBackgroundSize2sfx(v: jfxsl.BackgroundSize): BackgroundSize =
    if (v != null) new BackgroundSize(v) else null

  /**
   * $START$BRDR.html $BRDR$END
   *
   * @param v $JFX $BRDR
   * @return $SFX $BRDR
   */
  implicit def jfxBorder2sfx(v: jfxsl.Border): Border = if (v != null) new Border(v) else null

  implicit def jfxBorderImage2sfx(v: jfxsl.BorderImage): BorderImage = if (v != null) new BorderImage(v) else null

  /**
   * $START$BDPN.html $BDPN$END
   *
   * @param v $JFX $BDPN
   * @return $SFX $BDPN
   */
  implicit def jfxBorderPane2sfx(v: jfxsl.BorderPane): BorderPane = if (v != null) new BorderPane(v) else null

  implicit def jfxBorderRepeat2sfx(v: jfxsl.BorderRepeat): BorderRepeat = if (v != null) BorderRepeat(v) else null

  implicit def jfxBorderStroke2sfx(v: jfxsl.BorderStroke): BorderStroke = if (v != null) new BorderStroke(v) else null

  implicit def jfxBorderStrokeStyle2sfx(v: jfxsl.BorderStrokeStyle): BorderStrokeStyle =
    if (v != null) new BorderStrokeStyle(v) else null

  implicit def jfxBorderWidths2sfx(v: jfxsl.BorderWidths): BorderWidths = if (v != null) new BorderWidths(v) else null

  /**
   * $START$CLCT.html $CLCT$END
   *
   * @param v $JFX $CLCT
   * @return $SFX $CLCT
   */
  implicit def jfxColumnConstraints2sfx(v: jfxsl.ColumnConstraints): ColumnConstraints =
    if (v != null) new ColumnConstraints(v) else null

  /**
   * $START$CTBS.html $CTBS$END
   *
   * @param v $JFX $CTBS
   * @return $SFX $CTBS
   */
  implicit def jfxConstraintsBase2sfx(v: jfxsl.ConstraintsBase): ConstraintsBase = if (v != null)
    new ConstraintsBase(v) {}
  else null

  implicit def jfxCornerRadii2sfx(v: jfxsl.CornerRadii): CornerRadii = if (v != null) new CornerRadii(v) {} else null

  /**
   * $START$FLPN.html $FLPN$END
   *
   * @param v $JFX $FLPN
   * @return $SFX $FLPN
   */
  implicit def jfxFlowPane2sfx(v: jfxsl.FlowPane): FlowPane = if (v != null) new FlowPane(v) else null

  /**
   * $START$GDPN.html $GDPN$END
   *
   * @param v $JFX $GDPN
   * @return $SFX $GDPN
   */
  implicit def jfxGridPane2sfx(v: jfxsl.GridPane): GridPane = if (v != null) new GridPane(v) else null

  /**
   * $START$HBOX.html $HBOX$END
   *
   * @param v $JFX $HBOX
   * @return $SFX $HBOX
   */
  implicit def jfxHBox2sfx(v: jfxsl.HBox): HBox = if (v != null) new HBox(v) else null

  /**
   * $START$PANE.html $PANE$END
   *
   * @param v $JFX $PANE
   * @return $SFX $PANE
   */
  implicit def jfxPane2sfx(v: jfxsl.Pane): Pane = if (v != null) new Pane(v) else null

  /**
   * $START$PRIO.html $PRIO$END
   *
   * @param e $JFX $PRIO
   * @return $SFX $PRIO
   */
  implicit def jfxPriority2sfx(e: jfxsl.Priority): Priority = Priority.jfxEnum2sfx(e)

  /**
   * $START$REGI.html $REGI$END
   *
   * @param v $JFX $REGI
   * @return $SFX $REGI
   */
  implicit def jfxRegion2sfx(v: jfxsl.Region): Region = if (v != null) new Region(v) else null

  /**
   * $START$RWCT.html $RWCT$END
   *
   * @param v $JFX $RWCT
   * @return $SFX $RWCT
   */
  implicit def jfxRowConstraints2sfx(v: jfxsl.RowConstraints): RowConstraints =
    if (v != null) new RowConstraints(v) else null

  /**
   * $START$STPN.html $STPN$END
   *
   * @param v $JFX $STPN
   * @return $SFX $STPN
   */
  implicit def jfxStackPane2sfx(v: jfxsl.StackPane): StackPane = if (v != null) new StackPane(v) else null

  /**
   * $START$TLPN.html $TLPN$END
   *
   * @param v $JFX $TLPN
   * @return $SFX $TLPN
   */
  implicit def jfxTilePane2sfx(v: jfxsl.TilePane): TilePane = if (v != null) new TilePane(v) else null

  /**
   * $START$VBOX.html $VBOX$END
   *
   * @param v $JFX $VBOX
   * @return $SFX $VBOX
   */
  implicit def jfxVBox2sfx(v: jfxsl.VBox): VBox = if (v != null) new VBox(v) else null

}
