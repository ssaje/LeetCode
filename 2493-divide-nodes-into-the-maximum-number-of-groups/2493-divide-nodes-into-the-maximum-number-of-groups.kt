class Solution {
    fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
        val degs = IntArray(n + 1)
        val graph = Array(n + 1) { mutableSetOf<Int>() }
        for ((a, b) in edges) {
            degs[a]++
            degs[b]++

            graph[a] += b
            graph[b] += a
        }

        val sorted = degs.withIndex().drop(1).sortedBy { it.value }
        var groupCount = 0
        val queue = ArrayDeque<Int>()
        val groups = IntArray(n + 1)
        for ((u, _) in sorted) {
            if (groups[u] != 0) {
                continue
            }

            queue.addLast(u)
            groups[u] = ++groupCount
            
            while (queue.isNotEmpty()) {
                var isIncremented = false
                repeat(queue.size) {
                    val v = queue.removeFirst()

                    for (w in graph[v]) {
                        if (groups[w] == 0) {
                            if (!isIncremented) {
                                isIncremented = true
                                groupCount++
                            }

                            groups[w] = groupCount
                            queue.addLast(w)
                        } else if ((groups[v] - groups[w]).absoluteValue != 1) {
                            return -1
                        }
                    }
                }
            }
        }

        return groupCount
    }
}