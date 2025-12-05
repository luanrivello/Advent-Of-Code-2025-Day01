package org.cesar.day03

import java.io.File
import kotlin.system.measureNanoTime
import kotlin.text.toInt

var answer:Long = 0

fun main() {
    val time = measureNanoTime {
        val input  = readFile("/day03/example.txt")

    }

    println("Execution time: ${time / 1_000_000_000.0}s")
    println("Answer: $answer")
}

private fun readFile(path: String): String {
    val inputURL = {}.javaClass.getResource(path)
    val inputFile = File(inputURL.toURI())

    return inputFile.readText().trim()
}
