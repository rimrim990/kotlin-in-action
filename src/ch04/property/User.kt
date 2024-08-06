package ch04.property

//  인터페이스에 추상 프로퍼티 선언.
interface User {
    val nickname: String
    val id: String
        get() = "user_$nickname"
}

// 1. 주 생성자 - 값을 저장
class PrivateUser(override val nickname: String): User

// 2. 커스텀 게터 - 접근자에서 매번 값을 계산
class SubscribingUser(private val email: String): User {
    override val nickname: String
        get() = email.substringBefore('@')
}

// 3. 프로퍼티 초기화 식 - 값을 저장
class FacebookUser(private val accountId: Int): User {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "user_$accountId"
    }
}

///

class Employee(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }

    var identity: Int = 12345
        private set
}

fun main() {
    println(PrivateUser("test@kotlinlang.org").nickname) // "test@kotlinlang.org"
    println(SubscribingUser("test@kotlinlang.org").nickname) // "test"
    println(FacebookUser(12).id) // "user_user_12"

    val employee = Employee("Alice")
    employee.address = "Elsenheimerstrasse 47, 80687 Muenchen" // 내부적으로 setter 호출
}
