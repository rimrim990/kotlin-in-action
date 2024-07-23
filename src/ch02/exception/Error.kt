package ch02.exception

import java.io.BufferedReader

fun check(number: Int) =
    if (number in 0..100) number
    else throw IllegalArgumentException("A percentage value must be betwen 0 and 100")

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}
