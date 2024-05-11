class Solution {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val sorted = quality
            .mapIndexed { index, value ->
                wage[index].toDouble() / value to value
            }
            .sortedBy { it.first }

        val pq = PriorityQueue<Int>(Collections.reverseOrder())

        var sum = 0
        var answer = Double.MAX_VALUE
        for ((ratio, q) in sorted) {
            pq.offer(q)
            sum += q

            if (pq.size > k) {
                sum -= pq.poll()
            }

            if (pq.size == k) {
                answer = answer.coerceAtMost(ratio * sum)
            }
        }

        return answer
    }
}