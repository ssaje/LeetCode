class Solution {
    companion object {
        private val operations = listOf("+", "-", "*", "/")
    }

    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) {
            if (token !in operations) {
                stack.addLast(token.toInt())
                continue
            }

            val b = stack.removeLast()
            val a = stack.removeLast()
            val c = when (token) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                else -> a / b
            }

            stack.addLast(c)
        }

        return stack.last()
    }
}