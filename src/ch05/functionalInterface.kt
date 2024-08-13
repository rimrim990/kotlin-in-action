package ch05

import javax.swing.text.View

/**
 * 함수형 인터페이스
 * - 추상 메서드가 단 하나뿐인 인터페이스이다.
 * - 코틀린에서 함수형 인터페이스를 인자로 갖는 자바 메서드 호출시, 람다 전달 가능하다. (코틀린 컴파일러가 람다를 Runnable 로 변환)
 */

fun postponeComputation(number: Int, runnable: Runnable) {}

fun main() {
    // 메서드를 호출할 때마다 동일한 인스턴스 사용
    val runnable = Runnable { println(42) }
    fun handleComputation() {
        postponeComputation(1000, runnable)
    }

    // 람다가 주변 영역의 변수를 포획할 경우, 매 호출하마다 같은 인스턴스 사용 불가.
    fun handleComputation(id: String) {
        postponeComputation(1000) { println(id) }
    }
}

interface OnClickListener {
    fun onClick(view: View)
}