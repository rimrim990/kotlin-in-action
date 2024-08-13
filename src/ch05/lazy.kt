package ch05

/**
 * 지연 계산 (lazy) 컬렉션 연산
 * - 시퀀스를 사용하면 중간 임시 컬렉션을 사용하지 않고 컬렉션 연산을 연쇄한다.
 * - 시퀀스 중간 연산은 항상 지연 계산된다.
 */
fun sequence(people: List<Person>) {
    // 원소가 필요할 때 계산
    people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()

    // 최종 연산 X, 아무런 내용도 출력되지 않는다.
    people.asSequence()
        .map { print("map ($it) "); it.age * it.age }
        .filter { print("filter ($it) "); it % 2 == 0 }
}

fun generateSeq() {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum()) // 5050
}