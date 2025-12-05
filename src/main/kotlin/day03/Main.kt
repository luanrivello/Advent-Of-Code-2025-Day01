package org.cesar.day03

import java.io.File
import kotlin.system.measureNanoTime
import kotlin.text.toInt

var answer:Long = 0

fun main() {
    val time = measureNanoTime {
        val inputFile  = readFile("/day03/input.txt")

        inputFile.forEachLine { line ->
            findMaximumVoltage(line)
        }
    }

    println("Execution time: ${time / 1_000_000_000.0}s")
    println("Answer: $answer")
}

private fun readFile(path: String): File {
    val inputURL = {}.javaClass.getResource(path)
    return File(inputURL.toURI())
}

fun findMaximumVoltage(line: String) {
    val digits = line.map { it.digitToInt() }

    var biggestValue = 0
    var biggestIndice = 0
    for (i in 0..digits.size-2) {
        if (digits[i] > biggestValue) {
            biggestValue = digits[i]
            biggestIndice = i
        }
    }

    var complementValue = 0
    for (i in biggestIndice+1 until digits.size) {
        if (digits[i] > complementValue) {
            complementValue = digits[i]
        }
    }

    answer += biggestValue*10 + complementValue

    //println("Digits: $digits")
    println("Voltage: $biggestValue$complementValue")
    //println("Answer: $answer")
}
