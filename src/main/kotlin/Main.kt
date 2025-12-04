package org.cesar

import java.io.File
import kotlin.math.absoluteValue

var password = 0
var currentDial = 50

fun main() {
    val inputURL = {}.javaClass.getResource("/input.txt")
    val inputFile = File(inputURL.toURI())

    inputFile.bufferedReader().use { reader ->
        reader.forEachLine { line ->
            println("===============")
            val (direction, amount) = parseLine(line)

            println("Initial turn amount: " + amount)

            val fullRotationsCount = amount/100
            password += fullRotationsCount

            val newAmount = amount%100
            currentDial %= 100

            currentDial = rotateDial(currentDial, direction, newAmount)
        }
    }

    println("===============")
    println("Final Password:" + password)
}

private fun parseLine(line: String): Pair<Char, Int> {
    val direction = line.first()
    val amount = line.drop(1).toInt()
    return direction to amount
}

private fun rotateDial(currentDial:Int, direction: Char, amount: Int): Int {
    val newDial: Int

    if (direction == 'L') {
        newDial = currentDial - amount
    } else {
        newDial = currentDial + amount
    }

    countRotations(newDial, currentDial)
    println(currentDial.toString() + " -> " + newDial.toString())
    println("Password: " + password)

    return newDial
}

private fun countRotations(newDial: Int, oldDial: Int) {
    password += (newDial/100).absoluteValue

    if (newDial == 0) {
        password++
    } else if (newDial > 0 && oldDial < 0) {
        password++
    } else if (newDial < 0 && oldDial > 0) {
        password++
    }
}