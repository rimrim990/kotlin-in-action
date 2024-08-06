package ch04.delegation

// 컴파일러가 포워딩 메서드 자동 생성
class DelegatingCollection<T>(
    innerList: Collection<T> = ArrayList<T>()
): Collection<T> by innerList {}

class CountingSet<T>(
    private val innerSet: MutableCollection<T> = HashSet<T>()
): MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

fun main() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
}