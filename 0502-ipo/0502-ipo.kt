class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val sorted = profits.zip(capital).sortedBy { it.second }
        val pq = PriorityQueue<Pair<Int, Int>> { a, b  -> b.first- a.first }
        var answer = w
        var i = 0
        repeat(k) {
            while (i < sorted.size && sorted[i].second <= answer) {
                if (sorted[i].first > sorted[i].second) {
                    pq.offer(sorted[i])
                }

                i++
            }

            if (pq.isEmpty()) {
                return answer
            }

            answer += pq.poll().first
        }

        return answer
    }
}