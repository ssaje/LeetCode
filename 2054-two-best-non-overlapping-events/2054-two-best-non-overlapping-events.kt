class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        // (endTime, value)
        val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }
        var maxValue = 0
        var answer = 0

        for ((startTime, endTime, value) in events.sortedBy { it[0] }) {
            while (pq.isNotEmpty() && pq.peek().first < startTime) {
                maxValue = maxValue.coerceAtLeast(pq.poll().second)
            }

            answer = answer.coerceAtLeast(value + maxValue)
            pq.offer(endTime to value)
        }

        return answer
    }
}