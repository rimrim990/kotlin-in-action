package ch02.loop

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun main() {
    val binaryReps = mutableMapOf<Char, String>()
    for (char in 'A' .. 'F') {
        val binary = char.code.toString(radix = 2)
        binaryReps[char] = binary
    }

    // destructing
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}
