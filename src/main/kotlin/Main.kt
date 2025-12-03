package org.cesar

import java.io.File

fun main() {
    var password = 0
    var currentDial = 50

    File("input.txt").bufferedReader().use { reader ->
        reader.forEachLine { line ->
            println(line)
            currentDial = rotateDial('l', 50, currentDial)

            if (currentDial % 100 == 0) {
                password++
            }
        }
    }

    println(password)
}

private fun rotateDial(direction: Char, amount: Int, current: Int): Int {
    var newCurrent: Int

    if (direction == 'l') {
        newCurrent = current - amount
    } else {
        newCurrent = current + amount
    }

    return newCurrent
}