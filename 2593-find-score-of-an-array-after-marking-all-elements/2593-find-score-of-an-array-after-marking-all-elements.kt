class Solution {
    fun findScore(nums: IntArray): Long {
        var score = 0L

        // (index, value)
        val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
            if (a.second != b.second) {
                a.second.compareTo(b.second)
            } else {
                a.first.compareTo(b.first)
            }
        }

        nums.forEachIndexed { index, value -> pq.offer(index to value) }

        val marked = BooleanArray(nums.size)
        while (pq.isNotEmpty()) {
            val (index, value) = pq.poll()
            if (marked[index]) {
                continue
            }

            score += value
            for (d in setOf(-1, 0, 1)) {
                val i = d + index
                if (i >= 0 && i < marked.size) {
                    marked[i] = true
                }
            }
        }

        return score
    }
}