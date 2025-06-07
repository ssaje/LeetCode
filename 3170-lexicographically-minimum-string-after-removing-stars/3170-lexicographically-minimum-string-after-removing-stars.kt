class Solution {
    fun clearStars(s: String): String {
        // (ch, index)
        val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
            if (a.first == b.first) b.second - a.second
            else a.first - b.first
        }

        for (i in s.indices) {
            val ch = s[i]
            if (ch == '*') {
                pq.poll()
            } else {
                pq.offer(ch - 'a' to i)
            }
        }

        val answer = mutableListOf<Pair<Int, Int>>()
        while (pq.isNotEmpty()) {
            answer += pq.poll()
        }

        return answer.sortedBy { it.second }.joinToString("") { ('a' + it.first).toString() }
    }
}