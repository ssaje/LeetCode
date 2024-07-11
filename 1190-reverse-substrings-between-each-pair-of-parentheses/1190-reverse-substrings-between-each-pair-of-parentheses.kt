class Solution {
    fun reverseParentheses(s: String): String {
        val stack = Stack<Int>()
        val pairs = IntArray(s.length)
        s.forEachIndexed { index, ch ->
            if (ch == '(') {
                stack.push(index)
            } else if (ch == ')') {
                val another = stack.pop()
                pairs[index] = another
                pairs[another] = index
            }
        }

        return buildString {
            var direction = 1
            var i = 0
            while (i < s.length) {
                val ch = s[i]
                if (ch == '(' || ch == ')') {
                    i = pairs[i]
                    direction = -direction
                } else {
                    append(ch)
                }

                i += direction
            }
        }
    }
}