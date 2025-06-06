class Solution {
    fun robotWithString(s: String): String {
        val inCounts = IntArray(26)
        val outCounts = IntArray(26)
        for (ch in s) {
            outCounts[ch - 'a']++
        }

        val stack = Stack<Int>()
        var current = 0
        var i = 0
        var answer = StringBuilder()
        while (i < s.length) {
            while (inCounts[current] > 0 && stack.peek() == current) {
                inCounts[current]--
                stack.pop()
                answer.append('a' + current)
            }

            if (outCounts[current] > 0) {
                while (stack.isNotEmpty() && stack.peek() <= current) {
                    val top = stack.pop()
                    inCounts[top]--
                    answer.append('a' + top)
                }

                val ch = s[i] - 'a'
                inCounts[ch]++
                outCounts[ch]--
                stack.push(ch)
                i++
            } else {
                current++
            }
        }

        while(stack.isNotEmpty()) {
            answer.append('a' + stack.pop())
        }

        return answer.toString()
    }
}