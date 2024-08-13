package ch05

import java.util.*

/**
 * 컬렉션 함수형 API
 */
fun filter() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it  % 2 == 0 })
}

fun map() {
    val list = listOf(1, 2, 3, 4)
    println(list.map{ it * it })

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.uppercase(Locale.getDefault()) })
}

val people = listOf(Person("Alice", 27), Person("Bob", 31))

fun all() {
    val canBeInClub27 = { p: Person -> p.age <= 27 }

    println(people.all(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))
}

fun groupBy() {
    // 키 값에 따라 값을 그룹핑한 맵
    val people = listOf(Person("Alice", 31), Person("Bob", 29), Person("Carol", 31))
    println(people.groupBy { it.age }) // 29=[Bob], 31=["Alice", "Carol"]

    val list = listOf("a", "ab", "b")
    list.groupBy(String::first) // a=["a", "ab"], b=["b"]
}

data class Book(val title: String, val authors: List<String>)
val books = listOf(
    Book("a", listOf("a", "b", "c")),
    Book("b", listOf("b","c"))
)

fun flatMap() {
    books.flatMap { it.authors }.toSet() // "a", "b", "c"
    println(listOf("abc", "def").flatMap { it -> it.toList() }) // "a", "b", "c", "d", "e", "f"
}