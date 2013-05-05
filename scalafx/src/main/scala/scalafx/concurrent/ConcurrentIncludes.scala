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
package scalafx.concurrent

import javafx.{ concurrent => jfxc }

object ConcurrentIncludes extends ConcurrentIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/concurrent/package-summary.html `javafx.concurrent`]]
 * Classes to their ScalaFX counterparts.
 * 
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/concurrent/
 * @define END ]]` instance to its $SFX counterpart.
 * @define SER Service
 * @define TSK Task
 * @define WRK Worker
 * @define WRS Worker.State
 * @define WSE WorkerStateEvent
 */
trait ConcurrentIncludes {

  /**
   * $START$SER.html $SER$END
   *
   * @param s $JFX $SER
   * @return $SFX $SER
   */
  implicit def jfxService2sfxService[T](s: jfxc.Service[T]) = new Service[T](s) {}

  /**
   * $START$TSK.html $TSK$END
   *
   * @param t $JFX $TSK
   * @return $SFX $TSK
   */
  implicit def jfxTask2sfxTask[T](t: jfxc.Task[T]) = new Task[T](t) {}

  /**
   * $START$WRK.html $WRK$END
   *
   * @param w $JFX $WRK
   * @return $SFX $WRK
   */
  implicit def jfxWorker2sfxWorker[T](w: jfxc.Worker[T]) = new Worker[T] {
    override val delegate = w
  }

  /**
   * $START$WRS.html $WRS$END
   *
   * @param s $JFX $WRS
   * @return $SFX $WRS
   */
  implicit def jfxWorkerState2sfxWorkerState(s: jfxc.Worker.State) = Worker.State.jfxEnum2sfx(s)

  /**
   * $START$WSE.html $WSE$END
   *
   * @param w $JFX $WSE
   * @return $SFX $WSE
   */
  implicit def jfxWorkerStateEvent2sfxWorkerStateEvent(w: jfxc.WorkerStateEvent) = new WorkerStateEvent(w)

}