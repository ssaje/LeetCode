class Solution {
    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        val n = s.length
        val visited = mutableSetOf<String>()
        val deque = ArrayDeque<String>()

        deque.addLast(s)

        var answer = s
        while (deque.isNotEmpty()) {
            val s = deque.removeFirst()
            answer = minOf(answer, s)

            val rotated = s.slice(n-b..<n) + s.slice(0..<n-b)
            if (rotated !in visited) {
                visited += rotated
                deque.addLast(rotated)
            }

            val sb = StringBuilder(s)
            for (i in 1..<n step 2) {
                val digit = (sb[i] - '0' + a) % 10
                sb[i] = '0' + digit
            }

            val added = sb.toString()
            if (added !in visited) {
                visited += added
                deque.addLast(added)
            }
        }

        return answer
    }
}