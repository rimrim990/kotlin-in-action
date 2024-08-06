package ch04.companion

interface JsonFactory<T> {
    fun fromJson(jsonText: String): T
}

class Person(val name: String) {

    // 인터페이스를 구현하는 동반 객체.
    companion object: JsonFactory<Person> {
        override fun fromJson(jsonText: String): Person = Person("ts-master")
    }
}

