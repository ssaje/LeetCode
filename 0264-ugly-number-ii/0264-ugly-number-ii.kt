class Solution {
    fun nthUglyNumber(n: Int): Int {
        val pq = PriorityQueue<Long>()
        val visited = mutableSetOf<Long>()

        pq.offer(1)
        visited += 1

        var answer = 0L
        repeat(n) {
            answer = pq.poll()
            for (factor in listOf(2, 3, 5)) {
                val next = factor * answer
                if (next !in visited) {
                    pq.offer(next)
                    visited += next
                }
            }
        }

        return answer.toInt()
    }
}