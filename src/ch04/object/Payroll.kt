package ch04.`object`

class Person(val salary: Int)

// 언어 차원에서 싱글턴 생성 지원
object Payroll {
    private val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        allEmployees.sumOf { person -> person.salary }
    }
}

// 데이터 클래스
data class Employee(val name: String) {

    // 하나의 인스턴스를 갖는 내부 객체 선언
    object NameComparator: Comparator<Employee> {
        override fun compare(e1: Employee, e2: Employee): Int = e1.name.compareTo(e2.name)
    }
}

fun main() {
    val employees = listOf(Employee("Bob"), Employee("Alice"))
    println(employees.sortedWith(Employee.NameComparator)) // [Employee(name=Alice), Employee(name=Bob)]
}