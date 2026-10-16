/*
 * Copyright (c) 2011-2026, ScalaFX Project
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

import com.jsuereth.sbtpgp.PgpKeys
import sbt.*
import sbt.Keys.*

/**
 * Checks that artifacts can be signed, before anything is published.
 *
 * Signs a temporary file with the same signer that `publishSigned` uses,
 * so it checks the actual setup: `gpg` command, signing key, and passphrase or gpg agent.
 * Run with `sbt checkSigning`, it is also executed at the start of `sbt release`.
 */
object SigningCheck {

  val checkSigning = TaskKey[Unit]("checkSigning", "Checks that artifacts can be signed by signing a temporary file")

  val settings: Seq[Setting[?]] = Seq(
    // Uncached, signing has to be performed on every run
    checkSigning := Def.uncached {
      val s      = streams.value
      val signer = PgpKeys.pgpSigner.value
      val key    = PgpKeys.pgpSigningKey.value.fold("default key")(k => s"key $k")
      IO.withTemporaryDirectory { dir =>
        val file = dir / "signing-check.txt"
        IO.write(file, "ScalaFX signing check\n")
        signer.sign(file, dir / "signing-check.txt.asc", s) // fails if gpg fails
      }
      s.log.info(s"Signing works, signed a test file with the $key")
    }
  )
}
