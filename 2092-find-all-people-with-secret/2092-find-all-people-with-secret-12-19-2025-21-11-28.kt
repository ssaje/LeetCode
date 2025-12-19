class Solution {
    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        val G = Array(n) { mutableListOf<Pair<Int, Int>>() }
        G[0].add(firstPerson to 0)

        for ((x, y, time) in meetings) {
            G[x].add(y to time)
            G[y].add(x to time)
        }

        val times = IntArray(n) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }

        pq.add(0 to 0)
        while (pq.isNotEmpty()) {
            val (u, minTime) = pq.remove()
            if (times[u] != Int.MAX_VALUE) {
                continue
            }

            times[u] = minTime
            for ((v, time) in G[u]) {
                if (minTime > time) {
                    continue
                }

                pq.add(v to time)
            }
        }

        return times
            .withIndex()
            .filter { it.value != Int.MAX_VALUE }
            .map { it.index }
    }
}