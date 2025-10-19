class Solution {
    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        val n = s.length

        fun rotate(s: String): String {
            val chars = s.toCharArray()
            for (i in 0..<n) {
                chars[(i + b) % n] = s[i]
            }

            return String(chars)
        }

        fun add(s: String): String {
            val chars = s.toCharArray()
            for (i in 1..<n step 2) {
                chars[i] = '0' + (s[i].digitToInt() + a) % 10
            }

            return String(chars)
        }

        val visited = mutableSetOf<String>()
        val deque = ArrayDeque<String>()

        deque.addLast(s)

        var answer = s
        while (deque.isNotEmpty()) {
            val s = deque.removeFirst()
            answer = minOf(answer, s)

            val rotated = rotate(s)
            if (rotated !in visited) {
                visited += rotated
                deque.addLast(rotated)
            }

            val added = add(s)
            if (added !in visited) {
                visited += added
                deque.addLast(added)
            }
        }

        return answer
    }
}