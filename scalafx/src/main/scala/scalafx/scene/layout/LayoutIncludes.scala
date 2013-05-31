/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.scene.{ layout => jfxsl }

object LayoutIncludes extends LayoutIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/package-summary.html `javafx.scene.layout`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/layout/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define ACPN AnchorPane
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
  implicit def jfxAnchorPane2sfx(a: jfxsl.AnchorPane) = new AnchorPane(a)

  /**
   * $START$BDPN.html $BDPN$END
   *
   * @param v $JFX $BDPN
   * @return $SFX $BDPN
   */
  implicit def jfxBorderPane2sfx(v: jfxsl.BorderPane) = new BorderPane(v)

  /**
   * $START$CLCT.html $CLCT$END
   *
   * @param v $JFX $CLCT
   * @return $SFX $CLCT
   */
  implicit def jfxColumnConstraints2sfx(v: jfxsl.ColumnConstraints) = new ColumnConstraints(v)

  /**
   * $START$CTBS.html $CTBS$END
   *
   * @param v $JFX $CTBS
   * @return $SFX $CTBS
   */
  implicit def jfxConstraintsBase2sfx(v: jfxsl.ConstraintsBase) = new ConstraintsBase(v) {}

  /**
   * $START$FLPN.html $FLPN$END
   *
   * @param v $JFX $FLPN
   * @return $SFX $FLPN
   */
  implicit def jfxFlowPane2sfx(v: jfxsl.FlowPane) = new FlowPane(v)

  /**
   * $START$GDPN.html $GDPN$END
   *
   * @param v $JFX $GDPN
   * @return $SFX $GDPN
   */
  implicit def jfxGridPane2sfx(v: jfxsl.GridPane) = new GridPane(v)

  /**
   * $START$HBOX.html $HBOX$END
   *
   * @param v $JFX $HBOX
   * @return $SFX $HBOX
   */
  implicit def jfxHBox2sfx(v: jfxsl.HBox) = new HBox(v)

  /**
   * $START$PANE.html $PANE$END
   *
   * @param v $JFX $PANE
   * @return $SFX $PANE
   */
  implicit def jfxPane2sfx(v: jfxsl.Pane) = new Pane(v)

  /**
   * $START$PRIO.html $PRIO$END
   *
   * @param e $JFX $PRIO
   * @return $SFX $PRIO
   */
  implicit def jfxPriority2sfx(e: jfxsl.Priority) = Priority.jfxEnum2sfx(e)

  /**
   * $START$REGI.html $REGI$END
   *
   * @param v $JFX $REGI
   * @return $SFX $REGI
   */
  implicit def jfxRegion2sfx(v: jfxsl.Region) = new Region(v)

  /**
   * $START$RWCT.html $RWCT$END
   *
   * @param v $JFX $RWCT
   * @return $SFX $RWCT
   */
  implicit def jfxRowConstraints2sfx(v: jfxsl.RowConstraints) = new RowConstraints(v)

  /**
   * $START$STPN.html $STPN$END
   *
   * @param v $JFX $STPN
   * @return $SFX $STPN
   */
  implicit def jfxStackPane2sfx(v: jfxsl.StackPane) = new StackPane(v)

  /**
   * $START$TLPN.html $TLPN$END
   *
   * @param v $JFX $TLPN
   * @return $SFX $TLPN
   */
  implicit def jfxTilePane2sfx(v: jfxsl.TilePane) = new TilePane(v)

  /**
   * $START$VBOX.html $VBOX$END
   *
   * @param v $JFX $VBOX
   * @return $SFX $VBOX
   */
  implicit def jfxVBox2sfx(v: jfxsl.VBox) = new VBox(v)

}
