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

package scalafx.collections

/**
 * An example of listening to changes in an ObservableArray.
 */
object ObservableArrayOnChangeExample {

  def main(args: Array[String]): Unit = {
    // Create an ObservableFloatArray
    val floatArray = new ObservableFloatArray()
    // Add some initial values
    floatArray.addAll(1.0f, 2.0f, 3.0f, 4.0f)

    floatArray.onChange { (a, change) =>
      println("Array changed!")
      println("Size changed: " + change.sizeChanged)
      println("Changed range: from " + change.start + " to " + change.end)
      if (change.sizeChanged) println("New size: " + a.size)
      // You can iterate through the changed portion if needed
      for (i <- change.start until change.end) {
        println("Value at index " + i + ": " + a.get(i))
      }
    }

    println("--- Initial array ---")
    printArray(floatArray)
    // Modify the array
    println("\n--- Modifying a value ---")
    floatArray.set(1, 2.5f) // This triggers a change event

    println("\n--- Adding elements ---")
    floatArray.addOne(5.0f) // This triggers a change event (sizeChanged will be true)

    println("\n--- Resizing ---")
    floatArray.resize(3) // This triggers a change event (sizeChanged will be true)

    println("\n--- Trim to size ---")
    floatArray.trimToSize()

    println("\n--- Final array ---")
    printArray(floatArray)
  }

  private def printArray(array: ObservableFloatArray): Unit =
    println("Current array: " + array.toArray.mkString("[", ", ", "]"))
}
