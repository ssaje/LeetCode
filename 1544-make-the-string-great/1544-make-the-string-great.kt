class Solution {
    fun makeGood(s: String): String {
        val stack = ArrayDeque<Char>()
        for (ch in s) {
            stack.addLast(ch)
            while (stack.size > 1 && (stack[stack.size - 2].code xor 32) == stack[stack.size - 1].code) {
                stack.removeLast()
                stack.removeLast()
            }
        }

        return stack.joinToString("")
    }
}