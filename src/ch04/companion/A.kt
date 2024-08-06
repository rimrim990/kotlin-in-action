package ch04.companion

class A {
    // 클래스 동반 객체 생성
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

fun main() {
    A.bar() // "Companion object called"
}