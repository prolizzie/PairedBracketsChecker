import java.util.*
import java.util.ArrayDeque

class BracketsChecker {

    companion object {
        fun checker(input: CharArray): String {
            val symbolStack = ArrayDeque<Char>()
            var counter = 0
            val openedBracketIndex: MutableList<Int> = LinkedList()
            val closedBracketIndex: MutableList<Int> = LinkedList()
            var result: String = ""

            for (c in input) {
                counter++
                if (c == '(' || c == '{' || c == '[' || c == '<') {
                    symbolStack.push(c)
                    openedBracketIndex.add(counter)
                }
                if (c == ')' || c == '}' || c == ']' || c == '>') {
                    if (symbolStack.isNotEmpty()) {
                        val topOfStack = symbolStack.peek()
                        if ((c == ')' && topOfStack == '(') ||
                            (c == '}' && topOfStack == '{') ||
                            (c == ']' && topOfStack == '[') ||
                            (c == '>' && topOfStack == '<')
                        ) {
                            symbolStack.pop()
                            (openedBracketIndex as LinkedList).removeLast()
                        } else {
                            closedBracketIndex.add(counter)
                            break
                        }
                    } else {
                        symbolStack.add(c)
                        closedBracketIndex.add(counter)
                        break
                    }
                }
            }

            if (symbolStack.isNotEmpty()) {
                if (closedBracketIndex.isNotEmpty()) {
                    result = (closedBracketIndex as LinkedList<Int>).first.toString()
                } else {
                    if (openedBracketIndex.isNotEmpty()) {
                        result = (openedBracketIndex as LinkedList<Int>).first.toString()
                    }
                }
            } else {
                result = "Success"
            }
            println(result)
            return result
        }
    }
}