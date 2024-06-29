/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
package scalafx.delegate

object SFXDelegate {

  /**
   * Return `delegate` contained in this wrapper or `null`.
   * This is useful in situations when passing calling directly JavaFX API that accepts `null` arguments.
   *
   * Call to
   * {{{
   *   delegateOrNull(wrapper)
   * }}}
   * is equivalent to
   * {{{
   *   if (wrapper != null) wrapper.delegate else null
   * }}}
   *
   * @param wrapper ScalaFX wrapper
   * @tparam J JavaFX type
   */
  def delegateOrNull[J <: Object](wrapper: SFXDelegate[J]): J = {
    if (wrapper != null) wrapper.delegate else null.asInstanceOf[J]
  }

}

/**
 * Basic trait for all JavaFX classes wrapping.
 *
 * @tparam D JavaFX class to be wrapped.
 */
trait SFXDelegate[+D <: Object] extends AnyRef {

  /**
   * JavaFX object to be wrapped.
   */
  def delegate: D

  /**
   * @return Returns the original delegate's `toString()` adding a `[SFX]` prefix.
   */
  override def toString: String = "[SFX]" + delegate.toString

  /**
   * Verifies if a object is equals to this delegate.
   *
   * @param ref Object to be compared.
   * @return if the other object is equals to this delegate or not.
   */
  override def equals(ref: Any): Boolean = {
    ref match {
      case sfxd: SFXDelegate[_] => delegate.equals(sfxd.delegate)
      case _                    => delegate.equals(ref)
    }
  }

  /**
   * @return The delegate hashcode
   */
  override def hashCode: Int = delegate.hashCode
}
