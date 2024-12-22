class Solution {
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size) { -1 }
        val queriesByIndex = Array(heights.size) { mutableListOf<IndexedValue<Int>>() }
        
        for (i in queries.indices) {
            val (a, b) = queries[i]

            val l = min(a, b)
            val r = max(a, b)
            if (l == r || heights[l] < heights[r]) {
                answer[i] = r
            } else {
                queriesByIndex[r].add(IndexedValue(i, heights[l]))
            }
        }

        val pq = PriorityQueue<IndexedValue<Int>> { a, b -> a.value.compareTo(b.value) }
        for (i in heights.indices) {
            val height = heights[i]
            while (pq.isNotEmpty() && pq.peek().value < height) {
                answer[pq.poll().index] = i
            }

            queriesByIndex[i].forEach { pq.offer(it) }
        }

        return answer
    }
}