import java.util.*

class Main () {

}
fun main() {
    println("Введите строку для проверки расстановки скобок")
    val scanner = Scanner(System.`in`)
    val inputSymbols = scanner.nextLine().toCharArray()
    BracketsChecker.checker(inputSymbols)
}