import java.util.Stack

class Solution {
    companion object {
        private val openBrackets = listOf('(', '{', '[')
        private val bracketPairs = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '[',
        )
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (bracket in s) {
            if (bracket in openBrackets) {
                stack.push(bracket)
            } else if (stack.isEmpty()) {
                return false
            } else if (stack.pop() != bracketPairs[bracket]) {
                return false
            }
        }

        return stack.isEmpty()
    }
}