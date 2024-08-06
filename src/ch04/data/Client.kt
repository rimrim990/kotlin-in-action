package ch04.data

class Client(private val name: String, private val postalCode: Int) {
    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"

    // Any는 java.lang.Object에 대응, 모든 코틀린 클래스의 최상위 타입
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) // instanceof
            return false

        return name == other.name && postalCode == other.postalCode
    }

    // equals가 true이면, 반드시 hashCode 같아야 함
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

// 데이터 클래스 - equals, hashCode, toString
data class ClientInfo(val name: String, val postalCode: Int)

fun main() {
    val client1 = Client("rim", 1234)
    val client2 = Client("rim", 1234)

    println(client1)
    println(client1 == client2)

    val info = ClientInfo("immutable", 1234)
    val copy = info.copy(postalCode = 2345)

}