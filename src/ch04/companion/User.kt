package ch04.companion

// 비 공개 주 생성자 선언
open class User protected constructor(private val nickname: String) {

    // 동반 객체 선언
    companion object {
        // 팩터리 메서드
        fun newSubScribingUser(email: String) = SubscribingUser(email)
        fun newFacebookUser(accountId: Int) = FacebookUser(accountId)
    }
}

class SubscribingUser(private val email: String): User(email.substringBefore('@'))
class FacebookUser(private val accountId: Int): User("$accountId")

fun main() {
    val subscribingUser = User.newSubScribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser)
    println(facebookUser)
}