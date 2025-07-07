class Solution {
    fun maxEvents(events: Array<IntArray>): Int {
        val sorted = events.sortedBy { it[0] }
        val max = events.maxOf { it[1] }
        val pq = PriorityQueue<Int>()
        var answer = 0
        var i = 0
        for (day in 1..max) {
            while (i < sorted.size && sorted[i][0] <= day) {
                pq.offer(sorted[i][1])
                i++
            }

            while (pq.isNotEmpty() && pq.peek() < day) {
                pq.poll()
            }

            if (pq.isNotEmpty()) {
                answer++
                pq.poll()
            }
        }

        return answer
    }
}