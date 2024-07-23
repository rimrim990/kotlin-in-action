package ch02.enum

enum class Color(
    r: Int,
    g: Int,
    b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0);

    var rgb = (r * 256 + g) * 256 + b
    fun printColor() = println("$this is $rgb")
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.ORANGE) -> Color.ORANGE
        else -> throw Exception("Dirty color")
    }

fun main() {
    println(Color.RED.rgb)
    Color.ORANGE.printColor()
}
