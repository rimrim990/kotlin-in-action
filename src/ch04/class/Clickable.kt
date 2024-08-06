package ch04.`class`

interface Clickable {
    // 추상 메서드
    fun click()

    // 디폴트 메서드
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

internal open class TalkativeButton: Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")

}

open class Button: Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    open val innerButton: Clickable = Button()
}

class ExtendedButton: Button() {
    override val innerButton: Clickable
        get() = RichButton()
}

// 상속을 허용
open class RichButton: Clickable {
    // final, 오버라이드 불가
    fun disable() {}

    // 오버라이드 가능
    open fun animate() {}

    override fun click() {}
}

fun main() {
    Button().click()

    val extBtn = ExtendedButton()
    if (extBtn.innerButton is RichButton) {
        // Smart cast to 'RichButton' is impossible, because 'extBtn.innerButton' is a property that has open or custom getter.
        // extBtn.innerButton.disable()
    }
}