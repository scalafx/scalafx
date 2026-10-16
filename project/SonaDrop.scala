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

import sbt.*
import sbt.internal.librarymanagement.ivy.IvyCredentials

import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.nio.charset.StandardCharsets.UTF_8
import java.util.Base64

/**
 * `sonaDrop <deploymentId>` command, drops a deployment on Sonatype Central Portal
 * that failed validation or was not published.
 *
 * Uses the same credentials as `sonaRelease`, for instance, `SONATYPE_USERNAME` and `SONATYPE_PASSWORD`.
 *
 * @see https://central.sonatype.org/publish/publish-portal-api/
 */
object SonaDrop {

  private val host = "central.sonatype.com"

  val command: Command = Command.single("sonaDrop") { (state, deploymentId) =>
    val (newState, creds) = Project.extract(state).runTask(Keys.credentials, state)
    IvyCredentials.forHost(creds, host) match {
      case Some(cred) => drop(deploymentId, cred.userName, cred.passwd, newState)
      case None       =>
        newState.log.error(s"No credentials are found for $host, set SONATYPE_USERNAME and SONATYPE_PASSWORD")
        newState.fail
    }
  }

  private def drop(deploymentId: String, userName: String, password: String, state: State): State = {
    val token   = Base64.getEncoder.encodeToString(s"$userName:$password".getBytes(UTF_8))
    val request = HttpRequest.newBuilder(URI.create(s"https://$host/api/v1/publisher/deployment/$deploymentId"))
      .header("Authorization", s"Bearer $token")
      .DELETE()
      .build()
    val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())
    if (response.statusCode / 100 == 2) {
      state.log.info(s"Dropped deployment $deploymentId")
      state
    } else {
      state.log.error(s"Failed to drop deployment $deploymentId: HTTP ${response.statusCode} ${response.body}")
      state.fail
    }
  }
}
