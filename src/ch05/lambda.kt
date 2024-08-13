package ch05

/**
 * 함수형 프로그래밍. 함수를 다른 함수에 전달한다
 *
 */
val sum = { x: Int, y: Int -> x + y}

data class Person(val name: String, val age: Int)

fun main() {
    println(sum(1, 2))
    run { println(42)}

    val people = listOf(
        Person(name="Bob", age=31),
        Person(name="Alice", age=29),
    )

    /**
     * 람다 적용 과정
     */
    people.maxBy({ p: Person -> p.age })

    people.maxBy() { p: Person -> p.age } // 1. 맨 뒤 인자가 람다이면 괄호 밖으로 빼낼 수 있다.
    people.maxBy { p: Person -> p.age } // 2. 람다가 유일한 인자이면 괄호를 제거할 수 있다.

    people.maxBy { p -> p.age } // 3. 파라미터 타입을 생략할 수 있다. (컴파일러 추론)
    people.maxBy { it.age } // 4. 파라미터가 하나뿐이가 컴파일러 타입 추론이 가능하다면, 디폴트 이름인 it을 사용할 수 있다.
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    response.forEach {
        // 람다 안에서 파이널이 아닌 변수에 접근하고, 변경할 수 있다.
        if (it.startsWith("4")) {
            clientErrors ++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }

    println("$clientErrors client errors, $serverErrors server errors")

    /**
     * 멤버 참조
     */
    val getAge = { person: Person -> person.age }
    val getAgeRef = Person::age

    run(::sum) // 최상위 프로퍼티 참조
}