package ch05

/**
 * 수신 객체 지정 람다
 * - with: 파라미터가 2개인 함수로, 첫 번째 인자로 받은 객체를 두 번째 인자로 받은 람다의 수신 객체로 만든다. (람다에서는 'this' 를 사용해 수신 객체 접근)
 * - apply: 수신 객체를 반환한다.
 */

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }

    result.append("\nNow I know the alphabet!")
    return result.toString()
}

// 메서드를 호출하려는 수신 객체 지정
fun alphabet_with() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        this.append(letter) // "this"를 명시해, 앞에서 지정한 수신 객체 메서드 호출
    }
    append("\nNow I know the alphabet!")
    this.toString() // 람다에서 값 반환
}

fun alphabet_apply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()
